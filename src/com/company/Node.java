package com.company;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public static int id = 0;
    public final int myId;
    public int color;

    public List<Node> neighbors;

    public Node()
    {
        myId = ++id;
        color = 0;
        neighbors = new ArrayList<Node>();
    }

    public void AddNeighbor(Node n)
    {
        this.neighbors.add(n);
    }

    public void RmNeighbor(Node n)
    {
        this.neighbors.remove(n);
    }

    public void RmFromAllNeighbors()
    {
        for(int i=0; i<neighbors.size(); ++i)
        {
            neighbors.get(i).RmNeighbor(this);
        }
        this.neighbors.clear();
    }

    public void print()
    {
        
    }



}
