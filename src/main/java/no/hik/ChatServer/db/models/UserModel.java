package no.hik.ChatServer.db.models;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.*;

@Entity(name = "users")
@Table(name = "users")
@DynamicUpdate
public class UserModel {
    public UserModel () {}

    public UserModel(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String firstName;
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String lastName;
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
