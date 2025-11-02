package Entities;

public class NeighborhoodPathEntity {
    private int id;        
    private String fromId;  
    private String toId;
    private int distance;
    private int traffic;
    private int maxSpeed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getTraffic() {
        return traffic;
    }

    public void setTraffic(int traffic) {
        this.traffic = traffic;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public NeighborhoodPathEntity() {
    }

    public NeighborhoodPathEntity(int _id, String _fromId, String _toId, int _distance, int _traffic, int _maxSpeed) {
        this.id = id;
        this.fromId = fromId;
        this.toId = toId;
        this.distance = distance;
        this.traffic = traffic;
        this.maxSpeed = maxSpeed;
    }
}