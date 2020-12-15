package model.persons;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false, length = 50)
    protected String name;

    @Column(name = "surname", nullable = false, length = 50)
    protected String surname;

    @Column(name = "email", nullable = false, length = 50)
    protected String email;

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

    public void update(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
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
