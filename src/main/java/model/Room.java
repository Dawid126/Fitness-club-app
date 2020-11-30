package model;

public class Room {
    private final int capacity;
    private int id = 0;

    public Room(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
