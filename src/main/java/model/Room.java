package model;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private int id;

    @Column(name = "capacity", nullable = false, length = 50, unique = true)
    private int capacity;

    @Column(name = "number", nullable = false, length = 50, unique = true)
    private int number;

    public Room() {}
    public Room(int capacity) {
        this.capacity = capacity;
        this.number = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room course = (Room) o;

        if (id != course.id) return false;
        return number == course.number;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + number;
        return result;
    }
}
