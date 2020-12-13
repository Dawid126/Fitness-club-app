package utils;

import com.google.inject.Inject;
import model.Activity;
import model.Room;
import persistence.IDataManager;

import java.util.List;

public class RoomManager {
    private final IDataManager dataManager;
    private static RoomManager instance;

    @Inject
    public RoomManager(IDataManager dataManager) {
        this.dataManager = dataManager;
        instance = this;
    }

    public static RoomManager getInstance() {
        return instance;
    }

    public List<Room> getRooms() {
        return dataManager.loadRooms();
    }

    public boolean removeRoom(Room roomToRemove) {
        List<Activity> activities = dataManager.loadActivities();
        for(Activity activity: activities) {
            if(activity.getRoom().equals(roomToRemove)) //TODO zwracanie listy activities ktore uzywaja dany room
                return false;
        }
        dataManager.removeRoom(roomToRemove);
        return true;
    }

    public boolean createRoom(int capacity) {
        if(capacity>0) {
            //TODO to jest zle:
            dataManager.saveRoom(new Room(capacity,capacity+20));
            return true;
        }
        return false;
    }

}
