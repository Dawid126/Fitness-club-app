package model;

import enums.WeekDay;
import model.persons.Client;
import model.persons.Host;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "weekDay", nullable = false, length = 15)
    private WeekDay weekDay;

    @ManyToOne
    @JoinColumn(name = "host_id")
    private Host host;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "client_activity",
            joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "activity_id", referencedColumnName = "ID"))
    private List<Client> participants = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name = "startTime", nullable = false, length = 50)
    private Date startTime;

    @Column(name = "endTime", nullable = false, length = 50)
    private Date endTime;

    @Column(name = "maxGroupSize", nullable = false, length = 50)
    private int maxGroupSize;

    public Activity () {}
    public Activity(String name, Host host, Room room, Date startTime, Date endTime, WeekDay weekDay, int maxGroupSize) {
        this.name = name;
        this.host = host;
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weekDay = weekDay;
        this.maxGroupSize = Math.min(maxGroupSize,room.getCapacity());
    }

    public boolean isEnrolled (Client client) {
        return participants.contains(client);
    }
    public boolean canEnroll (Client client) {
        if(participants.contains(client))
            return false;
        return participants.size() < maxGroupSize;
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
    public int getId() {
        return id;
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
    public int getMaxGroupSize() {
        return maxGroupSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activity activity = (Activity) o;

        if (id != activity.id) return false;
        if (!room.equals(activity.room)) return false;
        if (!name.equals(activity.name)) return false;
        return weekDay.equals(activity.weekDay);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + weekDay.hashCode();
        result = 31 * result + room.hashCode();
        return result;
    }
}