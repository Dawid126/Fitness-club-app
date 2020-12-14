package model.persons;

import enums.Role;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User extends AbstractPerson{

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, length = 10)
    private Role role;

    public User () {}
    public User (String name, String surname, String email, Role role, String password) {
        super(name, surname, email);
        this.role = role;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() { return role; }

}
