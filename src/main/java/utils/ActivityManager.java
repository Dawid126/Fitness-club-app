package utils;

import enums.WeekDay;
import model.Activity;
import model.Room;
import model.Scheduler;
import model.persons.Client;
import model.persons.Host;

import java.util.Date;
import java.util.List;

public class ActivityManager {
    private Scheduler scheduler;

    public boolean createActivity (String name, int id, Host host, Room room, Date startTime, Date endTime, WeekDay weekDay) {
        if(!host.isFree(weekDay,startTime,endTime))
            return false;
        List<Activity> activities = scheduler.getActivities(weekDay,room);
        for(Activity activity : activities) {
            if(activity.getStartTime().after(startTime) && activity.getStartTime().before(endTime) ||
                    activity.getEndTime().after(startTime) && activity.getEndTime().before(endTime))
                return false;
        }
        scheduler.addActivity(new Activity(name, id, host, room, startTime, endTime, weekDay));
        return true;
    }
    public void removeActivity (Activity activity) {
        scheduler.removeActivity(activity);
    }

    public boolean addClientToActivity (Client clientToAdd, Activity activity) {
        if(activity.isEnrolled(clientToAdd))
            return false;
        for(Activity clientActivity : clientToAdd.getActivities()) {
            if(clientActivity.getWeekDay().equals(activity.getWeekDay())) {
                if(activity.getStartTime().after(clientActivity.getStartTime()) && activity.getStartTime().before(clientActivity.getEndTime()) ||
                        activity.getEndTime().after(clientActivity.getStartTime()) && activity.getEndTime().before(clientActivity.getEndTime()))
                    return false;
            }
        }
        activity.addClient(clientToAdd);
        return true;
    }

    public void getAllActivities (WeekDay weekDay) {
        scheduler.getActivities(weekDay);
    }

    public List<Room> getPossibleRooms (WeekDay weekDay, Date startTime, Date endTime, int groupSize) {

        return null;
    }
}
