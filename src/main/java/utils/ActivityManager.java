package utils;

import enums.WeekDay;
import model.Activity;
import model.Room;
import model.Scheduler;
import model.persons.Client;
import model.persons.Host;
import persistance.IDataManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityManager {
    private final Scheduler scheduler;
    private final IDataManager dataManager;

    public ActivityManager (IDataManager dataManager) {
        this.dataManager = dataManager;
        this.scheduler = new Scheduler();
        for(Activity a : dataManager.loadActivities()) {
            this.scheduler.addActivity(a);
        }
    }

    public boolean createActivity (String name, Host host, Room room, Date startTime, Date endTime, WeekDay weekDay) {
        if(!host.isFree(weekDay,startTime,endTime))
            return false;
        List<Activity> activities = scheduler.getActivities(weekDay,room);
        for(Activity activity : activities) {
            if(activity.getStartTime().after(startTime) && activity.getStartTime().before(endTime) ||
                    activity.getEndTime().after(startTime) && activity.getEndTime().before(endTime))
                return false;
        }
        Activity newActivity = new Activity(name, host, room, startTime, endTime, weekDay);
        dataManager.saveActivity(newActivity);
        scheduler.addActivity(newActivity);
        return true;
    }

    public void removeActivity (Activity activity) {
        scheduler.removeActivity(activity);
        dataManager.removeActivity(activity);
    }

    public boolean addClientToActivity (Client clientToAdd, Activity activity) {
        if(activity.isEnrolled(clientToAdd))
            return false;
        if(activity.getParticipants().size() == activity.getRoom().getCapacity())
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

    public void removeClientFromActivity(Client clientToRemove, Activity activity) {
        clientToRemove.removeActivity(activity);
        activity.removeClient(clientToRemove);
    }

    public List<Activity> getAllActivities (WeekDay weekDay) {
        return scheduler.getActivities(weekDay);
    }

    public List<Room> getPossibleRooms (WeekDay weekDay, Date startTime, Date endTime) {
        List<Room> availableRooms = dataManager.loadRooms();

        for(Activity activity: this.getAllActivities(weekDay)) {
            if((activity.getStartTime().after(startTime) && activity.getStartTime().before(endTime)) ||
                    (activity.getEndTime().after(startTime) && activity.getEndTime().before(endTime))) {
                availableRooms.remove(activity.getRoom());
            }
        }
        return availableRooms;
    }

    public List<Host> getPossibleHosts () {
        List<Host> result = new ArrayList<>();
        //TODO:
        return result;
    }
}
