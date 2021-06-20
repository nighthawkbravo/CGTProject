package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Colorer c = new Colorer(5);
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

        c.LargestFirst(g);

        Graph g2 = new Graph(8);

        g2.AddNode(new Node(4));
        l1.clear();
        l1.add(9); l1.add(10); l1.add(14); l1.add(15);

        g2.AddNode(new Node(4));
        l2.clear();
        l2.add(8); l2.add(10); l2.add(11); l2.add(15);

        g2.AddNode(new Node(4));
        l3.clear();
        l3.add(8); l3.add(9); l3.add(11); l3.add(12);

        g2.AddNode(new Node(4));
        l4.clear();
        l4.add(9); l4.add(10); l4.add(12); l4.add(13);

        g2.AddNode(new Node(4));
        l5.clear();
        l5.add(10); l5.add(11); l5.add(13); l5.add(14);

        g2.AddNode(new Node(4));
        l6.clear();
        l6.add(11); l6.add(12); l6.add(14); l6.add(15);

        g2.AddNode(new Node(4));
        l7.clear();
        l7.add(12); l7.add(13); l7.add(15); l7.add(8);

        g2.AddNode(new Node(4));
        l8.clear();
        l8.add(9); l8.add(8); l8.add(14); l8.add(13);

        g2.AddManyEdges(8,l1);
        g2.AddManyEdges(9,l2);
        g2.AddManyEdges(10,l3);
        g2.AddManyEdges(11,l4);
        g2.AddManyEdges(12,l5);
        g2.AddManyEdges(13,l6);
        g2.AddManyEdges(14,l7);
        g2.AddManyEdges(15,l8);

        c.LargestFirst(g2);

        Graph g3 = new Graph(5);

        g3.AddNode(new Node(4));
        l1.clear();
        l1.add(17); l1.add(18); l1.add(19); l1.add(20);


        g3.AddNode(new Node(1));
        g3.AddNode(new Node(1));
        g3.AddNode(new Node(1));
        g3.AddNode(new Node(1));

        g3.AddManyEdges(16, l1);
        g3.AddEdge(17,16);
        g3.AddEdge(18,16);
        g3.AddEdge(19,16);
        g3.AddEdge(20,16);

        c.LargestFirst(g3);



        Graph g4 = new Graph(5);

        g4.AddNode(new Node(3));
        l1.clear();
        l1.add(23); l1.add(24); l1.add(25);

        g4.AddNode(new Node(3));
        l2.clear();
        l2.add(23); l2.add(24); l2.add(25);

        g4.AddNode(new Node(2));
        l3.clear();
        l3.add(21); l3.add(22);

        g4.AddNode(new Node(2));
        l4.clear();
        l4.add(21); l4.add(22);

        g4.AddNode(new Node(2));
        l5.clear();
        l5.add(21); l5.add(22);

        g4.AddManyEdges(21, l1);
        g4.AddManyEdges(22, l2);
        g4.AddManyEdges(23, l3);
        g4.AddManyEdges(24, l4);
        g4.AddManyEdges(25, l5);

        c.LargestFirst(g4);




        Graph g5 = new Graph(5);

        g5.AddNode(new Node(2));
        l1.clear();
        l1.add(27); l1.add(28);

        g5.AddNode(new Node(2));
        l2.clear();
        l2.add(26); l2.add(28);

        g5.AddNode(new Node(2));
        l3.clear();
        l3.add(26); l3.add(27);

        g5.AddNode(new Node(1));
        g5.AddNode(new Node(1));


        g5.AddManyEdges(26, l1);
        g5.AddManyEdges(27, l2);
        g5.AddManyEdges(28, l3);

        g5.AddEdge(29,30);

        c.LargestFirst(g5);


        Graph g6 = new Graph(6);

        g6.AddNode(new Node(2));
        g6.AddNode(new Node(3));
        g6.AddNode(new Node(1));
        g6.AddNode(new Node(1));
        g6.AddNode(new Node(2));
        g6.AddNode(new Node(1));


        g6.AddEdge(31,35);
        g6.AddEdge(31,32);
        g6.AddEdge(32,33);
        g6.AddEdge(32,34);
        g6.AddEdge(35,36);

        //g3.Print();
        c.LargestFirst(g6);



        Graph g7 = new Graph(8);

        g7.AddNode(new Node(1));
        g7.AddNode(new Node(1));
        g7.AddNode(new Node(1));
        g7.AddNode(new Node(4));
        g7.AddNode(new Node(4));
        g7.AddNode(new Node(1));
        g7.AddNode(new Node(1));
        g7.AddNode(new Node(1));


        g7.AddEdge(37,40);
        g7.AddEdge(38,40);
        g7.AddEdge(39,40);
        g7.AddEdge(40,41);
        g7.AddEdge(41,42);
        g7.AddEdge(41,43);
        g7.AddEdge(41,44);

        //g3.Print();
        c.LargestFirst(g7);


        Graph g8 = new Graph(5);

        g8.AddNode(new Node(4));
        l1.clear();
        l1.add(46); l1.add(47); l1.add(48); l1.add(49);

        g8.AddNode(new Node(4));
        l2.clear();
        l2.add(45); l2.add(47); l2.add(48); l2.add(49);

        g8.AddNode(new Node(4));
        l3.clear();
        l3.add(45); l3.add(46); l3.add(48); l3.add(49);

        g8.AddNode(new Node(4));
        l4.clear();
        l4.add(45); l4.add(46); l4.add(47); l4.add(49);

        g8.AddNode(new Node(4));
        l5.clear();
        l5.add(45); l5.add(46); l5.add(47); l5.add(48);

        g8.AddManyEdges(45, l1);
        g8.AddManyEdges(46, l2);
        g8.AddManyEdges(47, l3);
        g8.AddManyEdges(48, l4);
        g8.AddManyEdges(49, l5);

        c.LargestFirst(g8);


        Graph g9 = new Graph(5);

        g9.AddNode(new Node(1));
        g9.AddNode(new Node(3));
        g9.AddNode(new Node(2));
        g9.AddNode(new Node(3));
        g9.AddNode(new Node(1));


        g9.AddEdge(50,51);
        g9.AddEdge(51,52);
        g9.AddEdge(51,53);
        g9.AddEdge(52,53);
        g9.AddEdge(53,54);

        c.LargestFirst(g9);

        // Large Graphs

        Graph g10 = new Graph(12);

        g10.AddNode(new Node(2)); // 55
        g10.AddNode(new Node(4));
        g10.AddNode(new Node(5));
        g10.AddNode(new Node(4));
        g10.AddNode(new Node(3));
        g10.AddNode(new Node(2));
        g10.AddNode(new Node(4));
        g10.AddNode(new Node(4));
        g10.AddNode(new Node(4));
        g10.AddNode(new Node(4));
        g10.AddNode(new Node(3));
        g10.AddNode(new Node(3)); // 66

        g10.AddEdge(55,57);        g10.AddEdge(55,56);
        g10.AddEdge(56,57);        g10.AddEdge(56,59);        g10.AddEdge(56,61);
        g10.AddEdge(57,59);        g10.AddEdge(57,60);        g10.AddEdge(57,58);
        g10.AddEdge(58,61);        g10.AddEdge(58,62);        g10.AddEdge(58,64);
        g10.AddEdge(59,61);        g10.AddEdge(60,62);
        g10.AddEdge(61,62);
        g10.AddEdge(62,63);
        g10.AddEdge(63,64);        g10.AddEdge(63,65);        g10.AddEdge(63,66);
        g10.AddEdge(64,65);        g10.AddEdge(64,66);
        g10.AddEdge(65,66);

        c.LargestFirst(g10);

    }
}
