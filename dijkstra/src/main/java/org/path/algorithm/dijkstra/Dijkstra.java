package org.path.algorithm.dijkstra;

import org.path.algorithm.DijkstraParse;
import org.path.algorithm.model.PceLink;
import org.path.algorithm.model.PceNode;
import org.path.algorithm.model.PceTopology;

import java.util.*;

public class Dijkstra {

    public static List <PceNode> calculatePath(PceTopology topology, PceNode source, PceNode dest) {
        Graph g = DijkstraParse.modelParse(topology);
        List <String> nodeOut = g.getShortestPath(source.getNodeId(), dest.getNodeId());
        List <PceNode> nodes = new LinkedList <>();
        for (String nodeId : nodeOut) {
            nodes.add(new PceNode(nodeId));
        }
        nodes.add(source);
        Collections.reverse(nodes);
        return nodes;
    }

    public static void main(String[] args) {
//        Graph g = new Graph();
//        g.addVertex("A", Arrays.asList(new Vertex("B", 7L), new Vertex("C", 8L)));
//        g.addVertex("B", Arrays.asList(new Vertex("A", 7L), new Vertex("F", 2L)));
//        g.addVertex("C", Arrays.asList(new Vertex("A", 8L), new Vertex("F", 6L), new Vertex("G", 4L)));
//        g.addVertex("D", Arrays.asList(new Vertex("F", 8L)));
//        g.addVertex("E", Arrays.asList(new Vertex("H", 1L)));
//        g.addVertex("F", Arrays.asList(new Vertex("B", 2L), new Vertex("C", 6L),
//                new Vertex("D", 8L), new Vertex("G", 9L), new Vertex("H", 3L)));
//        g.addVertex("G", Arrays.asList(new Vertex("C", 4L), new Vertex("F", 9L)));
//        g.addVertex("H", Arrays.asList(new Vertex("E", 1L), new Vertex("F", 3L)));
//        System.out.println(g.getShortestPath("A", "E"));
        List nodes = Arrays.asList(new PceNode("AA"), new PceNode("BB"), new PceNode("CC"),
                new PceNode("DD"), new PceNode("EE"));
        PceLink link1 = new PceLink("11", "AA", "", "BB", "", 0,10L,1L);
        PceLink link2 = new PceLink("22", "AA", "", "CC", "", 0,10L,1L);
        PceLink link3 = new PceLink("33", "BB", "", "EE", "", 0,15L,1L);
        PceLink link4 = new PceLink("44", "CC", "", "DD", "", 0,10L,1L);
        PceLink link5 = new PceLink("55", "DD", "", "EE", "", 0,10L,1L);
        PceLink link6 = new PceLink("66", "AA", "", "EE", "", 0,10L,1L);

        List <PceLink> links = new ArrayList <>(5);
        links.add(link1);
        links.add(link2);
        links.add(link3);
        links.add(link4);
        links.add(link5);
        links.add(link6);

        PceTopology topology = new PceTopology(nodes,links);
        List <PceNode> nodePath = calculatePath(topology, new PceNode("AA"), new PceNode("EE"));
        List <String> list = new ArrayList <>(5);
        for (PceNode node : nodePath) {
            list.add(node.getNodeId());
        }
        System.out.println(list);
    }
}

