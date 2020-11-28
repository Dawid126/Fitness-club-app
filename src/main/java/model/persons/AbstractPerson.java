package model.persons;

public abstract class AbstractPerson {
    private final String name;
    private final String surname;
    private int id;
    private String email;

    public AbstractPerson (String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }
}
