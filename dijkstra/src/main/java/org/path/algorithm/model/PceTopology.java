package org.path.algorithm.model;

import java.util.Collections;
import java.util.List;

public class PceTopology {

    private List <PceNode> nodes = Collections.emptyList();
    private List <PceLink> links = Collections.emptyList();

    public PceTopology(List <PceNode> nodes, List <PceLink> links) {
        this.nodes = nodes;
        this.links = links;
    }

    public List <PceNode> getNodes() {
        return nodes;
    }

    public void setNodes(List <PceNode> nodes) {
        this.nodes = nodes;
    }

    public List <PceLink> getLinks() {
        return links;
    }

    public void setLinks(List <PceLink> links) {
        this.links = links;
    }
}
