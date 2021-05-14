package com.company;
import java.util.*;

public class Graph {
    public int numOfVertices;
    public List<Node> nodes;

    public Graph(int n)
    {
        numOfVertices = n;
        nodes = new ArrayList<Node>();
    }

    private Node FindById(int id)
    {
        for(int i=0; i<numOfVertices; ++i)
        {
            if (nodes.get(i).myId == id)
            {
                return nodes.get(i);
            }
        }

        return null;
    }

    public void AddNode(Node n)
    {
        numOfVertices++;
        nodes.add(n);
    }

    public void DelNode(int id)
    {
        Node tmp = FindById(id);
        tmp.RmFromAllNeighbors();
        nodes.remove(tmp);
        numOfVertices--;
    }

    public void AddEdge(int id1, int id2)
    {
        FindById(id1).AddNeighbor(FindById(id2));
        FindById(id2).AddNeighbor(FindById(id1));
    }

    public void DelEdge(int id1, int id2)
    {
        FindById(id1).RmNeighbor(FindById(id2));
        FindById(id2).RmNeighbor(FindById(id1));
    }

    public void AddManyEdges(int id, List<Integer> ids)
    {
        for(int i=0;i<ids.size();++i)
        {
            AddEdge(id,ids.get(i));
        }
    }

    public void DelManyEdges(int id, List<Integer> ids)
    {
        for(int i=0;i<ids.size();++i)
        {
            DelEdge(id,ids.get(i));
        }
    }



}
