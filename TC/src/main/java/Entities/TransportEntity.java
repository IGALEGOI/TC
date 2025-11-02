package Entities;

public class TransportEntity {
    private int id;
    private String model;
    private int maxSpeed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String _modelo) {
        this.model = _modelo;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int _maxSpeed) {
        this.maxSpeed = _maxSpeed;
    }

    public TransportEntity() {
    }

    public TransportEntity(int _id, String _model, int _maxSpeed) {
        this.id = _id;
        this.model = _model;
        this.maxSpeed = _maxSpeed;
    }
}
