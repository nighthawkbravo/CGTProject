package com.company;
import java.util.*;

public class Graph {
    public static int graphIds = 0;
    public final int myId;
    public int numOfVertices;
    public List<Node> nodes;
    public List<Node> coloredNodes;

    public Graph(int n)
    {
        numOfVertices = 0;
        myId = graphIds++;
        nodes = new ArrayList<Node>();
        coloredNodes = new ArrayList<Node>();
    }

    public Node FindById(int id)
    {
        for(int i=0; i<nodes.size(); ++i)
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
        if(FindById(n.myId) != null)
        {
            System.out.println("ERROR -- Adding Node -- Node Id: "+n.myId+" already exists");
            return;
        }
        numOfVertices++;
        nodes.add(n);
    }

    public void DelNode(int id)
    {
        Node tmp = FindById(id);
        if(tmp == null)
        {
            System.out.println("ERROR -- Deletion -- Node Id: "+id+" does not exist");
            return;
        }
        tmp.RmFromAllNeighbors();
        nodes.remove(tmp);
        numOfVertices--;
    }

    public void AddEdge(int id1, int id2)
    {
        Node n1 = FindById(id1);
        if(n1 == null)
        {
            System.out.println("ERROR -- Adding Edge -- Node Id: "+id1+" does not exist");
            return;
        }
        Node n2 = FindById(id2);
        if(n2 == null)
        {
            System.out.println("ERROR -- Adding Edge -- Node Id: "+id2+" does not exist");
            return;
        }
        if(n1.neighbors.contains(n2))
        {
            //System.out.println("ERROR -- Adding Edge -- Nodes: " +id1+" and "+id2+" already have an edge");
            return;
        }

        n1.AddNeighbor(n2);
        n2.AddNeighbor(n1);
    }

    public void DelEdge(int id1, int id2)
    {
        Node n1 = FindById(id1);
        if(n1 == null)
        {
            System.out.println("ERROR -- Deleting Edge -- Node Id: "+id1+" does not exist");
            return;
        }
        Node n2 = FindById(id2);
        if(n2 == null)
        {
            System.out.println("ERROR -- Deleting Edge -- Node Id: "+id2+" does not exist");
            return;
        }
        if(!n1.neighbors.contains(n2))
        {
            System.out.println("ERROR -- Deleting Edge -- Nodes: " +id1+" and "+id2+" don't have an edge");
            return;
        }

        n1.RmNeighbor(n2);
        n2.RmNeighbor(n1);
    }

    public void AddManyEdges(int id, List<Integer> ids)
    {
        if(FindById(id) == null)
        {
            System.out.println("ERROR -- Adding many edges -- Node Id: "+id+" does not exist");
            return;
        }

        for(int i=0;i<ids.size();++i)
        {
            AddEdge(id,ids.get(i));
        }
    }

    public void DelManyEdges(int id, List<Integer> ids)
    {
        if(FindById(id) == null)
        {
            System.out.println("ERROR -- Deleting many edges -- Node Id: "+id+" does not exist");
            return;
        }

        for(int i=0;i<ids.size();++i)
        {
            DelEdge(id,ids.get(i));
        }
    }

    public void Print()
    {
        //System.out.println("+----------------------+");
        System.out.println();
        System.out.println("Graph Id: "+myId + " - Chromatic Number: "+ (ChromaticNum()+1));
        System.out.println();
        System.out.println("-- Nodes -- ");
        for(int i=0;i<nodes.size();++i)
        {
            nodes.get(i).Print();
        }
        System.out.println("+----------------------+");
    }

    private int ChromaticNum()
    {
        int max = 0;
        for(int i=0;i<nodes.size();++i)
        {
            if(nodes.get(i).color >= max) max = nodes.get(i).color;
        }
        return max;
    }

}
