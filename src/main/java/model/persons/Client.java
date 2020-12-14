package model.persons;

import model.Activity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
public class Client extends AbstractPerson{

    @ManyToMany(mappedBy = "participants")
    private List<Activity> activities  = new ArrayList<>();

    public Client () {}
    public Client (String name, String surname, String email) {
        super(name, surname, email);
    }

    public List<Activity> getActivities() {
        return activities;
    }
}
