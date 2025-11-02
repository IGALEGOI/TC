package Entities;

public class NeighborhoodEntity {
    private String name;
    private int axisX;  
    private int axisY; 

    public String getName() {
        return name;
    }

    public void setName(String bairro) {
        this.name = bairro;
    }

    public int getAxisX() {
        return axisX;
    }

    public void setAxisX(int _axisX) {
        this.axisX = _axisX;
    }

    public int getAxisY() {
        return axisY;
    }

    public void setAxisY(int _axisY) {
        this.axisY = _axisY;
    }

    public NeighborhoodEntity() {
    }

    public NeighborhoodEntity(String bairro, int _axisX, int _axisY) {
        this.name = bairro;
        this.axisX = _axisX;
        this.axisY = _axisY;
    }
}
