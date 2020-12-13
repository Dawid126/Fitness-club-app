package model.persons;

public abstract class AbstractPerson {
    protected String name;
    protected String surname;
    private int id = 0;
    protected String email;

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

    public void update(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
}
