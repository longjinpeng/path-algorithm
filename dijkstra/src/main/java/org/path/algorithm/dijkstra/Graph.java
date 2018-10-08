package org.path.algorithm.dijkstra;

import java.util.*;

public class Graph {

    private final Map <String, List <Vertex>> vertices;

    public Graph() {
        this.vertices = new HashMap <String, List <Vertex>>();
    }

    public void addVertex(String item, List <Vertex> vertex) {
        this.vertices.put(item, vertex);
    }

    //Dijkstra核心算法逻辑
    public List <String> getShortestPath(String start, String finish) {
        final Map <String, Long> distances = new HashMap <String, Long>();
        final Map <String, Vertex> previous = new HashMap <String, Vertex>();
        PriorityQueue <Vertex> nodes = new PriorityQueue <Vertex>();

        for (String vertex : vertices.keySet()) {
            if (vertex.equals(start)) {
                distances.put(vertex, 0L);
                nodes.add(new Vertex(vertex, 0L));
            } else {
                distances.put(vertex, Long.MAX_VALUE);
                nodes.add(new Vertex(vertex, Long.MAX_VALUE));
            }
            previous.put(vertex, null);
        }

        while (!nodes.isEmpty()) {
            Vertex smallest = nodes.poll();
            if (smallest.getId().equals(finish)) {
                final List <String> path = new ArrayList <String>();
                while (previous.get(smallest.getId()) != null) {
                    path.add(smallest.getId());
                    smallest = previous.get(smallest.getId());
                }
                return path;
            }

            if (distances.get(smallest.getId()) == Integer.MAX_VALUE) {
                break;
            }

            for (Vertex neighbor : vertices.get(smallest.getId())) {
                Long alt = distances.get(smallest.getId()) + neighbor.getDistance();
                if (alt < distances.get(neighbor.getId())) {
                    distances.put(neighbor.getId(), alt);
                    previous.put(neighbor.getId(), smallest);

                    forloop:
                    for (Vertex n : nodes) {
                        if (n.getId().equals(neighbor.getId())) {
                            nodes.remove(n);
                            n.setDistance(alt);
                            nodes.add(n);
                            break forloop;
                        }
                    }
                }
            }
        }

        return new ArrayList <String>(distances.keySet());
    }

}
