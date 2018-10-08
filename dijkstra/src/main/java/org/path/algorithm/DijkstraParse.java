package org.path.algorithm;


import org.path.algorithm.dijkstra.Graph;
import org.path.algorithm.dijkstra.Vertex;
import org.path.algorithm.model.PceLink;
import org.path.algorithm.model.PceNode;
import org.path.algorithm.model.PceTopology;

import java.util.LinkedList;
import java.util.List;

public class DijkstraParse {

    public static Graph modelParse(PceTopology topology) {
        Graph g = new Graph();
        for (PceNode node : topology.getNodes()) {
            String nodeId = node.getNodeId();
            List <Vertex> vertex = new LinkedList <>();
            for (PceLink link : topology.getLinks()) {
                if (link.getDestNodeId().equals(nodeId)) {
                    vertex.add(new Vertex(link.getSourceNodeId(), link.getDistance()));
                }
                if (link.getSourceNodeId().equals(nodeId)) {
                    vertex.add(new Vertex(link.getDestNodeId(), link.getDistance()));
                }
            }
            g.addVertex(nodeId, vertex);
        }
        return g;
    }
}
