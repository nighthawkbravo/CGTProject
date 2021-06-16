package com.company;

import java.util.*;

public class Colorer {

    List<Integer> colorsUsed;
    private int color;
    private int k = 3;

    public Colorer()
    {
        colorsUsed  = new ArrayList<Integer>();
        colorsUsed.add(1);
    }

    // |c(v)−c(u)|≥k−dist(u, v)
    // TODO: Implement it
    private boolean condition(Node v, Node u)
    {
        return false;
    }

    private Queue<Queue<Node>> DeepQCopy(Queue<Queue<Node>> queue)
    {
        Queue<Queue<Node>> out = new ArrayDeque<>();

        for(var node:queue)
            out.add(node);
        return out;
    }

    // Using BSF to find distance
    public int distance(Node v, Node u, Graph g) {

        Queue<Queue<Node>> levelQueues = new ArrayDeque<>(); //Contains all search queues for the current level of the search tree
        Queue<Node> tmp = new ArrayDeque<>();
        tmp.add(v);
        levelQueues.add(tmp);

        //Create a visit map of all vertices
        Map<Integer,Boolean> visited = new HashMap<Integer,Boolean>();
        for (var node:g.nodes) {
            visited.put(node.myId,false);
        }

        int distance =0;

        // When level queues is going to be empty at the time of checking this statement
        // it'll mean we reached the end of the connected graph
        while(!levelQueues.isEmpty()) {
            Queue<Queue<Node>> nextLevelQueues = new ArrayDeque<>();
            for(var queue:levelQueues) {

                // Check whether any of the nodes are the target
                for (var node: queue) {
                    if (node.myId == u.myId)
                        return distance;
                    visited.put(node.myId,true);
                }

                for (var node:queue) {
                    Queue<Node> neighborsToVisit = new ArrayDeque<>();
                    for (var neighbor : node.neighbors) {
                        if(!visited.get(neighbor.myId))
                            neighborsToVisit.add(neighbor);
                    }
                    if (!neighborsToVisit.isEmpty())
                        nextLevelQueues.add(new LinkedList<>(neighborsToVisit));
                }
            }
            // Append distance
            distance++;
            // Prepare new line of queues
            levelQueues.clear();
            levelQueues = DeepQCopy(nextLevelQueues);
        }
        return -1;
    }

    private void assignColor(Node n)
    {
        if (n.color != 0) return;
        if (n.numOfNeighbors == 0) n.color = colorsUsed.get(0);
        else {
            color = 1;
            boolean contFlag = true;
            while(contFlag) {
                for (int i = 0; i < n.neighbors.size(); ++i) {
                    if (n.neighbors.get(i).color == n.color)
                    {
                        n.color = color++;
                        contFlag = false;
                        if(!colorsUsed.contains(n.color)) colorsUsed.add(n.color);
                    }
                }
                contFlag = false;
                for(int i=0;i<n.neighbors.size();++i)
                {
                    if (n.neighbors.get(i).color == n.color)
                    {
                        contFlag = true;
                        break;
                    }
                }
            }
        }

    }

    public void ColorDSatur(Node n)
    {
        if (n.color != 0) return;
        List<Integer> colorsUsed = new ArrayList<Integer>();

        for (var node: n.neighbors)
        {
            colorsUsed.add(node.color);
        }

        int newColor =1;
        while(true)
        {
            if(!colorsUsed.contains(newColor))
            {
                n.color = newColor;
                return;
            }
            newColor++;
        }
    }

    public void Greedy(Graph g, List<Integer> orderOfColoring)
    {
        for(int i=0;i<g.nodes.size(); ++i)
        {
            assignColor(g.FindById(orderOfColoring.get(i)));
        }
        g.Print();
    }

    // Finds a node with the largest degree in the graph
    //// I've cut it out of LargestFirst method to avoid repetition in DSatur method
    public int FindLargestDeg(Graph g)
    {
        int maxDeg = 0;
        for(int i=0; i<g.nodes.size();++i)
        {
            int n = g.nodes.get(i).neighbors.size();
            if (n>=maxDeg) maxDeg = n;
        }
        return maxDeg;
    }

    // Calculate Saturation of a node
    public int CalculateSaturation(Node n)
    {
        int saturation=0;
        for (int i = 0;i<n.numOfNeighbors;i++)
        {
            if(n.neighbors.get(i).color!=0)
                saturation++;
        }
        return saturation;
    }

    public void LargestFirst(Graph g)
    {
        List<Integer> orderOfColoring = new ArrayList<Integer>();

        int maxDeg = FindLargestDeg(g);

        for(int j=0; j<=maxDeg;++j)
        {
            for(int i=0; i<g.nodes.size();++i)
            {
                int n = g.nodes.get(i).neighbors.size();
                if (n == j) orderOfColoring.add(i);
            }
        }
        Collections.reverse(orderOfColoring);
        Greedy(g, orderOfColoring);
    }

    public void DSatur(Graph g)
    {

        // Step 1: Find a node with the largest degree
        int maxDeg = FindLargestDeg(g); // Finds the largest degree

        List<Node> verticesToColor = new ArrayList<>();
        verticesToColor.addAll(g.nodes);
        for(int i=0; i<g.nodes.size();++i) // Finds a Node with said degree
        {
            int n = g.nodes.get(i).neighbors.size();
            if (n == maxDeg) {
                //Step 2: Color the node
                ColorDSatur(g.nodes.get(i));
                verticesToColor.remove(i);
                break;
            }
        }

        int nextNodeToColorListId = -1;
        // Step 3: We find a vertex with the largest saturation among uncolored nodes
        while(verticesToColor.size()>0)
        {
            int maxSaturation = 0;
            for (int i = 0;i<verticesToColor.size();i++) {
                int saturation = 0;
                if ((saturation = CalculateSaturation(verticesToColor.get(i)))>=maxSaturation) {
                    maxSaturation = saturation;
                    nextNodeToColorListId = i;
                }
            }
            // Step 4: We color the node with the first suitable color
            ColorDSatur(g.FindById(verticesToColor.get(nextNodeToColorListId).myId));
            verticesToColor.remove(nextNodeToColorListId); // We remove the node from the list of uncolored nodes
        } //Step 5: Unless all the vertices are colored we go back to Step 3:

        g.Print();
    }

}
