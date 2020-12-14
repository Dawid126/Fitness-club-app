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
    private List<Activity> activities = new ArrayList<>();

    public Host() {}

    public Host (String name, String surname, String email) {
        super(name, surname, email);
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public boolean isFree (WeekDay weekDay, Date startTime, Date endTime) {
        for(Activity activity : activities) {
            if(activity.getWeekDay().equals(weekDay)) {
                if((activity.getStartTime().after(startTime) && activity.getStartTime().before(endTime)) ||
                        (activity.getEndTime().after(startTime) && activity.getEndTime().before(endTime)) ||
                        activity.getStartTime().equals(startTime) || activity.getEndTime().equals(endTime))
                    return false;
            }
        }
        return true;
    }
}
