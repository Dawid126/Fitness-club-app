package utils;

import enums.Role;
import model.persons.User;
import persistance.IDataManager;

public class LoginManager {
    private User loggedUser;
    private final IDataManager dataManager;

    public LoginManager(IDataManager dataManager) {
        this.dataManager = dataManager;
        loggedUser = null;
    }

    public boolean login(String email, String password) {
        User user = dataManager.getUserByEmail(email);
        if(user != null) {
            if(user.getPassword().equals(password)) {
                loggedUser = user;
                return true;
            }
        }
        return false;
    }

    public void logout() {
        loggedUser = null;
    }

    public User getLoggedUser () {
        return loggedUser;
    }
}
