package utils;

import com.google.inject.Inject;
import enums.WeekDay;
import model.Activity;
import model.Room;
import model.persons.Client;
import model.persons.Host;
import persistence.IDataManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityManager {
    private final IDataManager dataManager;
    private static ActivityManager instance;

    @Inject
    public ActivityManager (IDataManager dataManager) {
        this.dataManager = dataManager;
        instance = this;
    }

    public static ActivityManager getInstance() {
        return instance;
    }

    public boolean createActivity (String name, Host host, Room room, Date startTime, Date endTime, WeekDay weekDay, int maxGroupSize) {
        if(!host.isFree(weekDay,startTime,endTime))
            return false;
        List<Activity> activities = getActivities(weekDay,room);
        for(Activity activity : activities) {
            if(activity.getStartTime().after(startTime) && activity.getStartTime().before(endTime) ||
                    activity.getEndTime().after(startTime) && activity.getEndTime().before(endTime))
                return false;
        }
        Activity newActivity = new Activity(name, host, room, startTime, endTime, weekDay, maxGroupSize);
        dataManager.saveActivity(newActivity);
        host.getActivities().add(newActivity);
        room.getActivities().add(newActivity);
        dataManager.updateHost(host);
        dataManager.updateRoom(room);
        return true;
    }

    public boolean removeActivity (Activity activity) {
        dataManager.removeActivity(activity);
        for(Client client : activity.getParticipants()) {
            client.getActivities().remove(activity);
            dataManager.updateClient(client);
        }
        activity.getHost().getActivities().remove(activity);
        activity.getRoom().getActivities().remove(activity);
        dataManager.updateHost(activity.getHost());
        dataManager.updateRoom(activity.getRoom());
        return true;
    }

    public boolean addClientToActivity (Client clientToAdd, Activity activity) {
        if(!activity.canEnroll(clientToAdd))
            return false;

        for(Activity clientActivity : clientToAdd.getActivities()) {
            if(clientActivity.getWeekDay().equals(activity.getWeekDay())) {
                if(activity.getStartTime().after(clientActivity.getStartTime()) && activity.getStartTime().before(clientActivity.getEndTime()) ||
                        activity.getEndTime().after(clientActivity.getStartTime()) && activity.getEndTime().before(clientActivity.getEndTime()))
                    return false;
            }
        }
        activity.getParticipants().add(clientToAdd);
        clientToAdd.getActivities().add(activity);
        dataManager.updateActivity(activity);
        dataManager.updateClient(clientToAdd);
        return true;
    }

    public void removeClientFromActivity(Client clientToRemove, Activity activity) {
        clientToRemove.getActivities().remove(activity);
        activity.getParticipants().remove(clientToRemove);
        dataManager.updateActivity(activity);
        dataManager.updateClient(clientToRemove);
    }

    public List<Room> getPossibleRooms (WeekDay weekDay, Date startTime, Date endTime) {
        List<Room> availableRooms = dataManager.loadRooms();

        for(Activity activity: this.getActivities(weekDay)) {
            if((activity.getStartTime().after(startTime) && activity.getStartTime().before(endTime)) ||
                    (activity.getEndTime().after(startTime) && activity.getEndTime().before(endTime))) {
                availableRooms.remove(activity.getRoom());
            }
        }
        return availableRooms;
    }

    public List<Host> getPossibleHosts (WeekDay weekDay, Date startTime, Date endTime) {
        List<Host> availableHosts = dataManager.loadHosts();

        for(Activity activity: this.getActivities(weekDay)) {
            if((activity.getStartTime().after(startTime) && activity.getStartTime().before(endTime)) ||
                    (activity.getEndTime().after(startTime) && activity.getEndTime().before(endTime))) {
                availableHosts.remove(activity.getHost());
            }
        }
        return availableHosts;
    }

    public List<Activity> getActivities () {
        return dataManager.loadActivities();
    }
    public List<Activity> getActivities(WeekDay weekDay) {
        List<Activity> result = new ArrayList<>();
        for(Activity activity : dataManager.loadActivities()) {
            if(activity.getWeekDay().equals(weekDay))
                result.add(activity);
        }
        return result;
    }
    public List<Activity> getActivities(Room room) {
        List<Activity> result = new ArrayList<>();
        for(Activity activity : dataManager.loadActivities()) {
            if(activity.getRoom().equals(room))
                result.add(activity);
        }
        return result;
    }
    public List<Activity> getActivities(WeekDay weekDay, Room room) {
        List<Activity> result = new ArrayList<>();
        for(Activity activity : dataManager.loadActivities()) {
            if(activity.getWeekDay().equals(weekDay) && activity.getRoom().equals(room))
                result.add(activity);
        }
        return result;
    }
}
