package model;

public class Room {
    private int capacity;
    private int id = 0;

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Room(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getId() {
        return id;
    }
}
