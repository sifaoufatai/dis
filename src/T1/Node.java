package T1;



import java.util.Map;
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;

public class Node {
    public long id;
    public double lat;
    public double lon;

    public Node(double v, String maLat, String maLon) {
        super();
    }
    public Node(long id, double lat, double lon) {
        super();
        this.id = id;
        this.lat = lat;
        this.lon = lon;
    }



    Map<Node, Double> Neighbor = new HashMap<>(); // Les noeuds voisins de ce noeud.avec la distance.

    public List<Node> shortestPath = new LinkedList<>(); // predecesseur depuis la source

    public List<Node> getShortestPath() {
        return shortestPath;
    }



    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }



    private double distance = Double.MAX_VALUE; // distances de nuds sont initialises avec Integer.MAX_VALUE pour simuler une distance infinie.
    // la distance depuis la source



    public void addDestination(Node destination, double distance) {

        Neighbor.put(destination,distance); // add un noeud voisin.


    }










    public void setNeighbor(Map<Node, Double> neighbor) {
        this.Neighbor = neighbor;
    }



    public double getDistance() {
        return distance;
    }



    public void setDistance(double distance) {
        this.distance = distance;
    }




}

