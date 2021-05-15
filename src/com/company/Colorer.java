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

    public void LargestFirst(Graph g)
    {
        List<Integer> orderOfColoring = new ArrayList<Integer>();
        int maxDeg = 0;
        for(int i=0; i<g.nodes.size();++i)
        {
            int n = g.nodes.get(i).neighbors.size();
            if (n>=maxDeg) maxDeg = n;
        }

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
}
