package persistance;

import model.Activity;
import model.persons.Client;

import java.util.List;

public interface IDataManager {
    void saveActivities(List<Activity> teachers);
    List<Activity> loadActivities();
    void saveClients(List<Client> classes);
    List<Client> loadClients();
}
