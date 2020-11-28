package model;

public class Room {
    private final int capacity;
    private int id;

    public Room(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
