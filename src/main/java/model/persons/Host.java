package model.persons;

import enums.WeekDay;
import model.Activity;
import model.Room;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "host")
public class Host extends AbstractPerson{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "host")
    private List<Activity> activities;

    public Host() {}

    public Host (String name, String surname, String email) {
        super(name, surname, email);
        activities = new ArrayList<>();
    }

    public List<Activity> getActivities() {
        return activities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Host host = (Host) o;

        if (id != host.id) return false;
        if(this.getName() != host.getName()) return false;
        if(this.getSurname() != host.getSurname()) return false;
        return this.getEmail() == host.getEmail();
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result;
        return result;
    }
}
