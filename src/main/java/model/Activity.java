package model;

import enums.WeekDay;
import model.persons.Client;
import model.persons.Host;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Activity {
    private String name;
    private int ID;
    private final WeekDay weekDay;
    private Host host;
    private final List<Client> participants;
    private final Room room;
    private final Date startTime;
    private final Date endTime;

    public Activity(String name, Host host, Room room, Date startTime, Date endTime, WeekDay weekDay) {
        this.name = name;
        this.host = host;
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weekDay = weekDay;
        this.participants = new ArrayList<>();
    }

    public void addClient (Client client) {
        participants.add(client);
    }

    public void removeClient(Client client) {
        participants.remove(client);
    }

    public boolean isEnrolled (Client client) {
        return participants.contains(client);
    }

    public Date getEndTime() {
        return endTime;
    }
    public Date getStartTime() {
        return startTime;
    }
    public Host getHost() {
        return host;
    }
    public int getID() {
        return ID;
    }
    public List<Client> getParticipants() {
        return participants;
    }
    public Room getRoom() {
        return room;
    }
    public String getName() {
        return name;
    }
    public WeekDay getWeekDay() {
        return weekDay;
    }
}
