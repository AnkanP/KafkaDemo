package com.example.kafkademo.models;

public class TopicCreation {
    private String topicName;
    private int partitions;
    private int replicas;

    public TopicCreation(String topicName, int partitions, int replicas) {
        this.topicName = topicName;
        this.partitions = partitions;
        this.replicas = replicas;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public int getPartitions() {
        return partitions;
    }

    public void setPartitions(int partitions) {
        this.partitions = partitions;
    }

    public int getReplicas() {
        return replicas;
    }

    public void setReplicas(int replicas) {
        this.replicas = replicas;
    }
}
