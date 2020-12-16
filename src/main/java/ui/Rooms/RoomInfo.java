package ui.Rooms;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Room;

public class RoomInfo {
    private Room room;
    private StringProperty number;
    private StringProperty capacity;

    public RoomInfo(Room room){
        this.room = room;
        this.number = new SimpleStringProperty(Integer.toString(room.getNumber()));
        this.capacity = new SimpleStringProperty(Integer.toString(room.getCapacity()));
    }

    public String getNumber() {
        return number.get();
    }

    public StringProperty getNumberProperty() {
        return number;
    }

    public void setId(String id) {
        this.number.set(id);
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
