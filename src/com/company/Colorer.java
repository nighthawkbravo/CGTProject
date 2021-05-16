package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Colorer {

    List<Integer> colorsUsed;
    private int color;

    public Colorer()
    {
        colorsUsed  = new ArrayList<Integer>();
        colorsUsed.add(1);
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

        List<Node> verticesToColor = g.nodes;

        for(int i=0; i<g.nodes.size();++i) // Finds a Node with said degree
        {
            int n = g.nodes.get(i).neighbors.size();
            if (n == maxDeg) {
                //Step 2: Color the node
                assignColor(g.FindById(i));
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
                if (CalculateSaturation(g.nodes.get(i))>=maxSaturation)
                    nextNodeToColorListId = i;
            }
            // Step 4: We color the node with the first suitable color
            assignColor(g.FindById(nextNodeToColorListId));
            verticesToColor.remove(nextNodeToColorListId); // We remove the node from the list of uncolored nodes
        } //Step 5: Unless all the vertices are colored we go back to Step 3:
    }

}
