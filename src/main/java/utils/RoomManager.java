package utils;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import model.Activity;
import model.Room;
import org.checkerframework.checker.units.qual.A;
import persistance.IDataManager;

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

    public void createRoom(int capacity) {
        dataManager.saveRoom(new Room(capacity));
    }

}
