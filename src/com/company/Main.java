package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Colorer c = new Colorer();
        Graph g = new Graph(8);

        g.AddNode(new Node(4));
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(1); l1.add(2); l1.add(7); l1.add(6);

        g.AddNode(new Node(3));
        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(0); l2.add(2); l2.add(7);

        g.AddNode(new Node(3));
        List<Integer> l3 = new ArrayList<Integer>();
        l3.add(0); l3.add(1); l3.add(3);

        g.AddNode(new Node(4));
        List<Integer> l4 = new ArrayList<Integer>();
        l4.add(2); l4.add(6); l4.add(4); l4.add(5);

        g.AddNode(new Node(2));
        List<Integer> l5 = new ArrayList<Integer>();
        l5.add(3); l5.add(5);

        g.AddNode(new Node(2));
        List<Integer> l6 = new ArrayList<Integer>();
        l6.add(4); l6.add(3);

        g.AddNode(new Node(3));
        List<Integer> l7 = new ArrayList<Integer>();
        l7.add(7); l7.add(0); l7.add(3);

        g.AddNode(new Node(3));
        List<Integer> l8 = new ArrayList<Integer>();
        l8.add(6); l8.add(0); l8.add(1);

        g.AddManyEdges(0,l1);
        g.AddManyEdges(1,l2);
        g.AddManyEdges(2,l3);
        g.AddManyEdges(3,l4);
        g.AddManyEdges(4,l5);
        g.AddManyEdges(5,l6);
        g.AddManyEdges(6,l7);
        g.AddManyEdges(7,l8);


        Graph g1 = g;

        g.Print();
        c.LargestFirst(g);

        g1.Print();
        c.DSatur(g1);

    }
}
