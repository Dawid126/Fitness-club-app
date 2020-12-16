package utils;

import com.google.inject.Inject;
import model.persons.Client;
import persistence.IDataManager;
import utils.statics.StringsValidator;

import java.util.List;

public class ClientManager {
    private final IDataManager dataManager;
    private static ClientManager instance;

    @Inject
    public ClientManager(IDataManager dataManager) {
        this.dataManager = dataManager;
        instance = this;
    }

    public static ClientManager getInstance() {
        return instance;
    }

    public boolean createClient(String name, String surname, String email) {
        if(StringsValidator.validateInfo(name, surname, email))
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

    public boolean updateClient (Client client, String name, String surname, String email) {
        if(StringsValidator.validateInfo(name, surname, email)) {
            return false;
        }

        if(client.getEmail().equals(email) || !dataManager.isEmailFree(email)) {
            client.update(name, surname, email);
            return true;
        }

        return false;
    }
}
