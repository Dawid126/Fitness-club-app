package utils;

import model.persons.Client;
import persistance.IDataManager;

import java.util.List;

public class ClientManager {
    private final IDataManager dataManager;

    public ClientManager(IDataManager dataManager) {
        this.dataManager = dataManager;
    }

    public boolean createClient(String name, String surname, String email) {
        if(!StringsValidator.validateInfo(name, surname, email))
            return false;
        if(dataManager.isEmailFree(email)) {
            dataManager.saveClient(new Client(name, surname, email));
            return true;
        }
        return false;
    }

    public boolean removeClient(Client clientToRemove) {
        if(!clientToRemove.getActivities().isEmpty()) //TODO zwracanie listy activities na ktore chodzi dany klient
            return false;
        dataManager.removeClient(clientToRemove);
        return true;
    }

    public List<Client> getClients() {
        return dataManager.loadClients();
    }
}
