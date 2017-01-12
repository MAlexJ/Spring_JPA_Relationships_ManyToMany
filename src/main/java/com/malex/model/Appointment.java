package com.malex.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Entity class
 *
 * @author malex
 */
@Entity
@Table(name = "appointment")
public class Appointment extends BaseEntity {

    private String description;
    private String status;

    //bi-directional many-to-many association to User
    @ManyToMany(mappedBy = "appointments")
    private List<User> users;


    public Appointment() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
