package utils;

import model.Activity;
import model.Room;
import org.checkerframework.checker.units.qual.A;
import persistance.IDataManager;

import java.util.List;

public class RoomManager {
    private final IDataManager dataManager;

    public RoomManager(IDataManager dataManager) {
        this.dataManager = dataManager;
    }

    public List<Room> getRooms() {
        return dataManager.loadRooms();
    }

    public boolean removeRoom(Room roomToRemove) {
        List<Activity> activies = dataManager.loadActivities();
        for(Activity activity: activies) {
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
