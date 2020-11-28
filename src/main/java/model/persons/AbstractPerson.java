package model.persons;

public abstract class AbstractPerson {
    private final String name;
    private final String surname;
    private int ID;
    private String email;

    public AbstractPerson (String name, String surname, String email, int ID) {
        this.name = name;
        this.surname = surname;
        this.ID = ID;
        this.email = email;
    }
}
