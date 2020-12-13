package model.persons;

import model.Room;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = Columns.ID)
    private int id;

    @Column(name = Columns.NAME, nullable = false, length = 50, unique = true)
    private String name;

    @Column(name = Columns.SURNAME, nullable = false, length = 50, unique = true)
    private String surname;

    @Column(name = Columns.EMAIL, nullable = false, length = 50, unique = true)
    private String email;

    public AbstractPerson () {}
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

    public static class Columns {

        public static final String ID = "id";

        public static final String NAME = "name";

        public static final String SURNAME = "surname";

        public static final String EMAIL = "email";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractPerson person = (AbstractPerson) o;

        if (id != person.id) return false;
        if (!email.equals(person.email)) return false;
        if (!name.equals(person.name)) return false;
        return surname.equals(person.surname);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }
}
