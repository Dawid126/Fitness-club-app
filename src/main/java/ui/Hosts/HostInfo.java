package ui.Hosts;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.persons.Client;
import model.persons.Host;

public class HostInfo {
    private Host host;
    private StringProperty name;
    private StringProperty surname;
    private StringProperty email;

    public HostInfo(Host host){
        this.host = host;
        this.name = new SimpleStringProperty(host.getName());
        this.surname = new SimpleStringProperty(host.getSurname());
        this.email = new SimpleStringProperty(host.getEmail());
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

    public Host getHost(){
        return this.host;
    }
}
