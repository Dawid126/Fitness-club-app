package model;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = Columns.ID)
    private int id;

    @Column(name = Columns.CAPACITY, nullable = false, length = 50, unique = true)
    private final int capacity;

    @Column(name = Columns.NUMBER, nullable = false, length = 50, unique = true)
    private int number;

    public Room(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getId() {
        return id;
    }

    public static class Columns {

        public static final String ID = "id";

        public static final String CAPACITY = "capacity";

        public static final String NUMBER = "number";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room course = (Room) o;

        if (id != course.id) return false;
        return number == course.number;
    }

//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + name.hashCode();
//        return result;
//    }
}
