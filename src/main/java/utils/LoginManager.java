package utils;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import enums.Role;
import model.persons.User;
import persistance.IDataManager;

public class LoginManager {
    private User loggedUser;
    private final IDataManager dataManager;
    private static LoginManager instance;

    @Inject
    public LoginManager(IDataManager dataManager) {
        this.dataManager = dataManager;
        instance = this;
        loggedUser = null;
    }

    public static LoginManager getInstance() {
        return instance;
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
