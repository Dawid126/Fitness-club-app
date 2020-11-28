package model.persons;

import enums.WeekDay;
import model.Activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Host extends AbstractPerson{

    private final List<Activity> activities;

    public Host (String name, String surname, String email) {
        super(name, surname, email
        );
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

    public boolean isFree (WeekDay weekDay, Date startTime, Date endTime) {
        for(Activity activity : activities) {
            if(activity.getWeekDay().equals(weekDay)) {
                if(activity.getStartTime().after(startTime) && activity.getStartTime().before(endTime) ||
                        activity.getEndTime().after(startTime) && activity.getEndTime().before(endTime))
                    return false;
            }
        }
        return true;
    }
}
