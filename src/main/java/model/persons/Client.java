package model.persons;

import model.Activity;

import java.util.ArrayList;
import java.util.List;

public class Client extends AbstractPerson{

    private final List<Activity> activities;

    public Client (String name, String surname, String email) {
        super(name, surname, email);
        activities = new ArrayList<>();
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void addActivity (Activity activity) {
        if(!activities.contains(activity))
            activities.add(activity);
    }
    public void removeActivity (Activity activity) {
        activities.remove(activity);
    }
}
