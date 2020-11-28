package model.persons;

public class User extends AbstractPerson{
    private String password;

    public User (String name, String surname, String email, int ID) {
        super(name, surname, email, ID);
    }
}
