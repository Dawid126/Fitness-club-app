package model;

import enums.WeekDay;
import model.persons.Client;
import model.persons.Host;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private final List<Activity> activities;

    public Scheduler() {
        this.activities = new ArrayList<>();
    }

    public void addActivity (Activity activity) {
        if(!activities.contains(activity))
            activities.add(activity);
    }
    public void removeActivity (Activity activity) {
        for(Client client : activity.getParticipants()) {
            client.removeActivity(activity);
        }
        activities.remove(activity);
    }

    public List<Activity> getActivities(WeekDay weekDay) {
        List<Activity> result = new ArrayList<>();
        for(Activity activity : activities) {
            if(activity.getWeekDay().equals(weekDay))
                result.add(activity);
        }
        return result;
    }
    public List<Activity> getActivities(WeekDay weekDay, Room room) {
        List<Activity> result = new ArrayList<>();
        for(Activity activity : activities) {
            if(activity.getWeekDay().equals(weekDay) && activity.getRoom().equals(room))
                result.add(activity);
        }
        return result;
    }
}
