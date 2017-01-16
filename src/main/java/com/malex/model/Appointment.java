package com.malex.model;

import javax.persistence.*;
import java.util.List;

/**
 * Entity class
 *
 * @author malex
 */
@Entity
@Table(name = "appointments")
public class Appointment {

   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private int appointmentId;

    private String description;
    private String status;

    //bi-directional many-to-many association to User
    @ManyToMany(mappedBy = "appointments")
    private List<User> users;


    public Appointment() {
    }

   public int getAppointmentId() {
      return appointmentId;
   }

   public void setAppointmentId(int appointmentId) {
      this.appointmentId = appointmentId;
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
