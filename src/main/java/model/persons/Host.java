package model.persons;

import enums.WeekDay;
import model.Activity;
import model.Room;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "host")
public class Host extends AbstractPerson{

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
}
