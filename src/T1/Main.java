package T1;

import java.util.ArrayList;

public class Main {

        public static void main(String[] args) {

                // création des noeuds
                Node n0 = new Node(0, 0.0, 0.0);
                Node n1 = new Node(1, 1.0, 1.0);
                Node n2 = new Node(2, 2.0, 2.0);
                Node n3 = new Node(3, 3.0, 3.0);
                Node n4 = new Node(4, 4.0, 4.0);
                Node n5 = new Node(5, 5.0, 5.0);
                Node n6 = new Node(6, 6.0, 6.0);
                Node n7 = new Node(7, 7.0, 7.0);
                Node n8 = new Node(8, 8.0, 8.0);
                Node n9 = new Node(9, 9.0, 9.0);

                // création des voisins pour chaque noeud
                n(n0, n1, n2, n3, n4, n5);
                n(n4, n5, n6, n7, n8, n9);
                n8.addDestination(n9, 1);

                ArrayList<Node> nodes = new ArrayList<>();
                nodes.add(n0);
                nodes.add(n1);
                nodes.add(n2);
                nodes.add(n3);
                nodes.add(n4);
                nodes.add(n5);
                nodes.add(n6);
                nodes.add(n7);
                nodes.add(n8);
                nodes.add(n9);

                Dikstra dikstra = new Dikstra();
                ArrayList<Node> path = dikstra.reconstructPath(dikstra.shortestpath(nodes, n0, n9), n9);

                System.out.println("Chemin le plus court de n0 à n9 : " + path);
        }

        private static void n(Node n4, Node n5, Node n6, Node n7, Node n8, Node n9) {
                n4.addDestination(n5, 1);
                n4.addDestination(n6, 2);
                n5.addDestination(n6, 1);
                n5.addDestination(n7, 2);
                n6.addDestination(n7, 1);
                n6.addDestination(n8, 2);
                n7.addDestination(n8, 1);
                n7.addDestination(n9, 2);
        }

}
