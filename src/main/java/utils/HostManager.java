package utils;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import model.persons.Host;
import persistance.IDataManager;
import utils.statics.StringsValidator;

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
}
