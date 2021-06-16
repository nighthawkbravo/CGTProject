package com.company;

import java.util.*;

public class Colorer {

    List<Integer> colorsUsed;
    private int color;
    int k;

    public Colorer(int K)
    {
        k = K;
        colorsUsed  = new ArrayList<Integer>();
        colorsUsed.add(1);
    }

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

    private void assignColor(Node n, Graph g)
    {
        if (n.color != 0) return;
        if (n.numOfNeighbors == 0) n.color = colorsUsed.get(0);
        else {
            color = 1;
            boolean contFlag = true;
            // Greedy part
            while(contFlag) {
                for (int i = 0; i < n.neighbors.size(); ++i) {
                    if (n.neighbors.get(i).color == n.color)
                    {
                        n.color = color++;
                        contFlag = false;
                        if(!colorsUsed.contains(n.color)) colorsUsed.add(n.color);
                    }
                }
                for(int i=0; i<g.coloredNodes.size(); ++i)
                {
                    if(Math.abs(n.color - g.coloredNodes.get(i).color) < k-distance(n, g.coloredNodes.get(i), g))
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
                for(int i=0; i<g.coloredNodes.size(); ++i)
                {
                    if(Math.abs(n.color - g.coloredNodes.get(i).color) < k-distance(n, g.coloredNodes.get(i), g))
                    {
                        contFlag = true;
                        break;
                    }
                }
            }
            g.coloredNodes.add(n);
        }

    }

    public void Greedy(Graph g, List<Integer> orderOfColoring)
    {
        for(int i=0;i<g.nodes.size(); ++i)
        {
            assignColor(g.FindById(orderOfColoring.get(i)), g);
        }
        g.Print();
    }

    public void LargestFirst(Graph g)
    {
        List<Integer> orderOfColoring = new ArrayList<Integer>();
        int maxDeg = 0;
        int minDeg = 0;
        for(int i=0; i<g.nodes.size();++i)
        {
            int n = g.nodes.get(i).neighbors.size();
            if (n>=maxDeg) maxDeg = n;
        }
        for(int i=0; i<g.nodes.size();++i)
        {
            int n = g.nodes.get(i).neighbors.size();
            if (n<=minDeg) minDeg = n;
        }

        for(int j=minDeg; j<=maxDeg;++j)
        {
            for(int i=0; i<g.nodes.size();++i)
            {
                int n = g.nodes.get(i).neighbors.size();
                if (n == j) orderOfColoring.add(g.nodes.get(i).myId);
            }
        }
        Collections.reverse(orderOfColoring);
        Greedy(g, orderOfColoring);
    }
}
