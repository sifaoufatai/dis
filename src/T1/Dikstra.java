package T1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;;
import  java.util.*;

import static java.lang.Double.parseDouble;

public class Dikstra {
    private double INFINIADouble = Double.MAX_VALUE;

    public ArrayList<Node> getNeighbor(Node current) {
        // ici j'aurais ma matrice d'adjacence
        ArrayList<Node> nodes = new ArrayList<>();
        return nodes;
    }

    public Node getClosestNode(Map<Node, Double> distances, Set<Node> invisited) {
        Node closest = null;
        Double min = INFINIADouble;
        for (Node node : invisited) {
            if (distances.get(node) < min) {
                min = distances.get(node);
                closest = node;
            }

        }
        return closest;
    }

    public double distance(Node start, Node end) {
        double xDistance = Math.abs(start.lon - end.lon);
        double yDistance = Math.abs(start.lat - end.lat);
        double euclideanDistance = Math.sqrt(xDistance * xDistance + yDistance * yDistance);
        return (int) euclideanDistance;
    }

    public Map<Node, Node> shortestpath(ArrayList<Node> nodes, Node start, Node end) {


        Map<Node, Double> distances = new HashMap<>();
        ;
        Map<Node, Node> predecessor = new HashMap<>();
        Set<Node> invisited = new HashSet<>();


        for (Node node : nodes) {
            if (node != start) {
                invisited.add(node);
                distances.put(node, INFINIADouble);
            }

        }


        distances.put(start, parseDouble(String.valueOf(00)));
        Node current;
        invisited.remove(start);
        while (!invisited.isEmpty()) {
            current = getClosestNode(distances, invisited);
            invisited.remove(current);

            for (Node neighbor : getNeighbor(current)) {

                double alt = distances.get(current) + distance(neighbor, current);
                if (alt < distances.get(neighbor)) {

                    distances.put(neighbor, alt);
                    predecessor.put(neighbor, current);
                }
            }

        }
        return predecessor;
    }


    public  ArrayList<Node> reconstructPath(Map<Node, Node> predecessor, Node start) {

        ArrayList<Node> path = new ArrayList<>();
        while (predecessor.containsKey(start)) {
            path.add(start);

            start = predecessor.get(start);
        }

        return path;
    }









}