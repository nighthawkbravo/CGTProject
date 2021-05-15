package com.company;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public static int id = 0;
    public final int myId;
    public int numOfNeighbors;
    public int color;

    public List<Node> neighbors;

    public Node(int n)
    {
        myId = id++;
        color = 0;
        numOfNeighbors = n;
        neighbors = new ArrayList<Node>();
    }

    public void AddNeighbor(Node n)
    {
        this.neighbors.add(n);
        numOfNeighbors++;
    }

    public void RmNeighbor(Node n)
    {
        this.neighbors.remove(n);
        numOfNeighbors--;
    }

    public void RmFromAllNeighbors()
    {
        for(int i=0; i<neighbors.size(); ++i)
        {
            neighbors.get(i).RmNeighbor(this);
        }
        this.neighbors.clear();
        numOfNeighbors = 0;
    }

    public void Print()
    {
        System.out.print("Node Id: " + myId + " - Color Id: " + color + " - Neighbor Ids: ");
        int i;
        for(i=0;i<neighbors.size()-1;++i) {
            System.out.print(neighbors.get(i).myId+", ");
        }
        if(i != 0) System.out.print(neighbors.get(i).myId);
        System.out.println();
    }



}
