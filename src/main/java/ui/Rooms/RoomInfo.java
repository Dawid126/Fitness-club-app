package ui.Rooms;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Room;

public class RoomInfo {
    private Room room;
    private StringProperty id;
    private StringProperty capacity;

    public RoomInfo(Room room){
        this.room = room;
        this.id = new SimpleStringProperty(Integer.toString(room.getId()));
        this.capacity = new SimpleStringProperty(Integer.toString(room.getCapacity()));
    }

    public String getId() {
        return id.get();
    }

    public StringProperty getIdProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getCapacity() {
        return capacity.get();
    }

    public StringProperty getCapacityProperty() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity.set(capacity);
    }

    public Room getRoom(){
        return this.room;
    }
}
