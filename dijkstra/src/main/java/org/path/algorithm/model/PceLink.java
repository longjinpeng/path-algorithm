package org.path.algorithm.model;

public class PceLink {
    private String linkId;
    private String sourceNodeId;
    private String sourcePortId;
    private String destNodeId;
    private String destPortId;
    private Integer direction = 1;//0代表单向，1代表双向。且默认为双向
    private Long distance = 10L;//距离默认为10
    private Long bandwidth;//带宽

    public PceLink(String linkId, String sourceNodeId, String sourcePortId, String destNodeId,
                   String destPortId, Integer direction, Long distance, Long bandwidth) {
        this.linkId = linkId;
        this.sourceNodeId = sourceNodeId;
        this.sourcePortId = sourcePortId;
        this.destNodeId = destNodeId;
        this.destPortId = destPortId;
        this.direction = direction;
        this.distance = distance;
        this.bandwidth = bandwidth;
    }

    public String getSourceNodeId() {
        return sourceNodeId;
    }

    public PceLink setSourceNodeId(String sourceNodeId) {
        this.sourceNodeId = sourceNodeId;
        return this;
    }

    public String getSourcePortId() {
        return sourcePortId;
    }

    public PceLink setSourcePortId(String sourcePortId) {
        this.sourcePortId = sourcePortId;
        return this;
    }

    public String getDestNodeId() {
        return destNodeId;
    }

    public PceLink setDestNodeId(String destNodeId) {
        this.destNodeId = destNodeId;
        return this;
    }

    public String getDestPortId() {
        return destPortId;
    }

    public PceLink setDestPortId(String destPortId) {
        this.destPortId = destPortId;
        return this;
    }

    public String getLinkId() {
        return linkId;
    }

    public PceLink setLinkId(String linkId) {
        this.linkId = linkId;
        return this;
    }

    public Integer getDirection() {
        return direction;
    }

    public PceLink setDirection(Integer direction) {
        this.direction = direction;
        return this;
    }

    public Long getDistance() {
        return distance;
    }

    public PceLink setDistance(Long distance) {
        this.distance = distance;
        return this;
    }

    public PceLink setBandwidth(Long bandwidth) {
        this.bandwidth = bandwidth;
        return this;
    }

    public Long getBandwidth() {
        return bandwidth;
    }
}
