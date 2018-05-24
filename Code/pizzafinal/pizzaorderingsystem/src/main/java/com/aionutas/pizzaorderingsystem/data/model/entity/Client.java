package com.aionutas.pizzaorderingsystem.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document
public class Client {
    private Long id;
    private String name;
    private String email;
    private Long phoneNb;
    private String username;
    private String password;



    public Client(Long id, String name, String email, Long phoneNb, String username, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNb = phoneNb;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNb() {
        return phoneNb;
    }

    public void setPhoneNb(Long phoneNb) {
        this.phoneNb = phoneNb;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNb=" + phoneNb +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != null ? !id.equals(client.id) : client.id != null) return false;
        if (name != null ? !name.equals(client.name) : client.name != null) return false;
        if (email != null ? !email.equals(client.email) : client.email != null) return false;
        if (phoneNb != null ? !phoneNb.equals(client.phoneNb) : client.phoneNb != null) return false;
        if (username != null ? !username.equals(client.username) : client.username != null) return false;
        return password != null ? password.equals(client.password) : client.password == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNb != null ? phoneNb.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public Client(String name, String email, Long phoneNb, String username, String password) {
        this.name = name;
        this.email = email;
        this.phoneNb = phoneNb;
        this.username = username;
        this.password = password;
    }

    public Client(String name, String email, Long phoneNb, String username) {
        this.name = name;
        this.email = email;
        this.phoneNb = phoneNb;
        this.username = username;
    }

    public Client() {
    }

}


