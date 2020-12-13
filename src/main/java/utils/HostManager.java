package utils;

import com.google.inject.Inject;
import enums.WeekDay;
import model.Activity;
import model.persons.Host;
import persistence.IDataManager;
import utils.statics.StringsValidator;

import java.util.Date;
import java.util.List;

public class HostManager {
    private final IDataManager dataManager;
    private static HostManager instance;

    @Inject
    public HostManager (IDataManager dataManager) {
        this.dataManager = dataManager;
        instance = this;
    }

    public static HostManager getInstance() {
        return instance;
    }


    public boolean createHost (String name, String surname, String email) {
        if(!StringsValidator.validateInfo(name,surname,email))
            return false;
        if(!dataManager.isEmailFree(email)) {
            dataManager.saveHost(new Host(name,surname,email));
            return true;
        }
        return false;
    }

    public boolean removeHost (Host host) {
        if(!host.getActivities().isEmpty())
            return false;
        dataManager.removeHost(host);
        return true;
    }

    public List<Host> getHosts () {
        return dataManager.loadHosts();
    }

    public void addActivity (Host host, Activity activity) {
        if(!host.getActivities().contains(activity))
            host.getActivities().add(activity);
    }

    public void removeActivity (Host host, Activity activity) {
        host.getActivities().remove(activity);
    }

    public boolean isFree (Host host, WeekDay weekDay, Date startTime, Date endTime) {
        for(Activity activity : host.getActivities()) {
            if(activity.getWeekDay().equals(weekDay)) {
                if((activity.getStartTime().after(startTime) && activity.getStartTime().before(endTime)) ||
                        (activity.getEndTime().after(startTime) && activity.getEndTime().before(endTime)) ||
                        activity.getStartTime().equals(startTime) || activity.getEndTime().equals(endTime))
                    return false;
            }
        }
        return true;
    }

}
