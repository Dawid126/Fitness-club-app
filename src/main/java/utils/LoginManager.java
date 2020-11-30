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

    public boolean registerNewUser (String name, String surname, String email, Role role, String password) {
        if(StringsValidator.validateInfo(name,surname,email))
            return false;
        if(dataManager.getUserByEmail(email) == null) {
            dataManager.saveUser(new User(name, surname, email, role, password));
            return true;
        }
        return false;
    }

    public User getLoggedUser () {
        return loggedUser;
    }
}
