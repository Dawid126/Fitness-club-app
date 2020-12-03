package ui.Clients;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.persons.Client;

public class ClientView {
    private StringProperty name;
    private StringProperty surname;
    private StringProperty email;

    public ClientView(Client client) {
        this.name = new SimpleStringProperty(client.getName());
        this.surname = new SimpleStringProperty(client.getSurname());
        this.email = new SimpleStringProperty(client.getEmail());
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
}
