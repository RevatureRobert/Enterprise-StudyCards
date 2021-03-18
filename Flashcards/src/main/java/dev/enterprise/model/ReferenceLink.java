package dev.enterprise.model;

public class ReferenceLink {
    private int id;
    private String address;
    private Topic topic;
    private String subtopic;

    public ReferenceLink(int id, String address, Topic topic, String subtopic) {
        this.id = id;
        this.address = address;
        this.topic = topic;
        this.subtopic = subtopic;
    }

    public ReferenceLink() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getSubtopic() {
        return subtopic;
    }

    public void setSubtopic(String subtopic) {
        this.subtopic = subtopic;
    }

    @Override
    public String toString() {
        return "ReferenceLink{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", topic=" + topic +
                ", subtopic='" + subtopic + '\'' +
                '}';
    }
}
