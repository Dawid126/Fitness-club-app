package model.persons;

import enums.Role;

public class User extends AbstractPerson{
    private String password;
    private Role role;

    public User (String name, String surname, String email, Role role, String password) {
        super(name, surname, email);
        this.role = role;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

}
