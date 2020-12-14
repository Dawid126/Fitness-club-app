package utils;

import com.google.inject.Inject;
import model.Activity;
import model.Room;
import model.persons.Client;
import persistence.IDataManager;
import utils.statics.StringsValidator;

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
            dataManager.saveRoom(new Room(capacity));
            return true;
        }
        return false;
    }

    public boolean updateRoom(Room room, int capacity) {
        if(capacity > 0) {
            room.setCapacity(capacity);
            return true;
        }
        return false;
    }

}
