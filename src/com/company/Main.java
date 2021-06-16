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


        g.Print();
        System.out.println("Distance: " + c.distance(g.nodes.get(0),g.nodes.get(2),g));
//        c.LargestFirst(g);
        c.DSatur(g);


//        Graph g2 = new Graph(8);
//
//        g2.AddNode(new Node(4));
//        l1.clear();
//        l1.add(9); l1.add(10); l1.add(14); l1.add(15);
//
//        g2.AddNode(new Node(4));
//        l2.clear();
//        l2.add(8); l2.add(10); l2.add(11); l2.add(15);
//
//        g2.AddNode(new Node(4));
//        l3.clear();
//        l3.add(8); l3.add(9); l3.add(11); l3.add(12);
//
//        g2.AddNode(new Node(4));
//        l4.clear();
//        l4.add(9); l4.add(10); l4.add(12); l4.add(13);
//
//        g2.AddNode(new Node(4));
//        l5.clear();
//        l5.add(10); l5.add(11); l5.add(13); l5.add(14);
//
//        g2.AddNode(new Node(4));
//        l6.clear();
//        l6.add(11); l6.add(12); l6.add(14); l6.add(15);
//
//        g2.AddNode(new Node(4));
//        l7.clear();
//        l7.add(12); l7.add(13); l7.add(15); l7.add(8);
//
//        g2.AddNode(new Node(4));
//        l8.clear();
//        l8.add(9); l8.add(8); l8.add(14); l8.add(13);
//
//        g2.AddManyEdges(8,l1);
//        g2.AddManyEdges(9,l2);
//        g2.AddManyEdges(10,l3);
//        g2.AddManyEdges(11,l4);
//        g2.AddManyEdges(12,l5);
//        g2.AddManyEdges(13,l6);
//        g2.AddManyEdges(14,l7);
//        g2.AddManyEdges(15,l8);
//
//        g2.Print();
//        //c.LargestFirst(g2);
//        c.DSatur(g2);
//
//        Graph g3 = new Graph(5);
//
//        g3.AddNode(new Node(4));
//        l1.clear();
//        l1.add(17); l1.add(18); l1.add(19); l1.add(20);
//
//
//        g3.AddNode(new Node(1));
//        g3.AddNode(new Node(1));
//        g3.AddNode(new Node(1));
//        g3.AddNode(new Node(1));
//
//        g3.AddManyEdges(16, l1);
//        g3.AddEdge(17,16);
//        g3.AddEdge(18,16);
//        g3.AddEdge(19,16);
//        g3.AddEdge(20,16);
//
//        g3.Print();
////        c.LargestFirst(g3);
//        c.DSatur(g3);
    }
}
