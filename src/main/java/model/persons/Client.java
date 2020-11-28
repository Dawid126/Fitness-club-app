package model.persons;

import model.Activity;

import java.util.ArrayList;
import java.util.List;

public class Client extends AbstractPerson{

    private final List<Activity> activities;

    public Client (String name, String surname, String email, int ID) {
        super(name, surname, email, ID);
        activities = new ArrayList<>();
    }

    public List<Activity> getActivities() {
        return activities;
    }
}
