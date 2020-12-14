package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private int id;

    @Column(name = "capacity", nullable = false, length = 50)
    private int capacity;

    @Column(name = "number", nullable = false, length = 50)
    private int number;

    @OneToMany(mappedBy = "room", fetch = FetchType.EAGER)
    private List<Activity> activities = new ArrayList<>();

    public Room() {}
    public Room(int capacity, int number) {
        this.capacity = capacity;
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getId() {
        return id;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (id != room.id) return false;
        return number == room.number;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + number;
        return result;
    }
}
