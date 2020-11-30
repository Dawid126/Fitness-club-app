package utils;

import enums.Role;
import model.Activity;
import model.persons.Client;
import model.persons.User;
import persistance.IDataManager;

import java.util.List;

public class UserManager {
    private final IDataManager dataManager;

    public UserManager(IDataManager dataManager) {
        this.dataManager = dataManager;
    }

    public List<User> getUsers() {
        return dataManager.loadUsers();
    }

    public boolean createUser(String name, String surname, String email, Role role, String password) {
        if(!StringsValidator.validateInfo(name, surname, email))
            return false;
        if(dataManager.isEmailFree(email))
            dataManager.saveUser(new User(name, surname, email, role, password));
        return true;
    }

    public boolean removeUser(User userToRemove) {
        if(!userToRemove.getRole().equals(Role.ADMIN)) //TODO zwracanie listy activities ktore uzywaja dany room
            return false;
        dataManager.removeUser(userToRemove);
        return true;
    }
}
