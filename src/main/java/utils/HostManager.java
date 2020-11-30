package utils;

import model.persons.Host;
import persistance.IDataManager;
import utils.StringsValidator;

import java.util.List;

public class HostManager {
    private final IDataManager dataManager;

    public HostManager (IDataManager dataManager) {
        this.dataManager = dataManager;
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
        if(host.getActivities().size() > 0)
            return false;
        dataManager.removeHost(host);
        return true;
    }

    public List<Host> getHosts () {
        return dataManager.loadHosts();
    }
}
