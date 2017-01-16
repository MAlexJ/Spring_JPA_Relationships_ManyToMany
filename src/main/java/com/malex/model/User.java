package com.malex.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * Entity class
 *
 * @author malex
 */
@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "User.getByEmail", query = "SELECT u FROM User u where u.email = :email")
})
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int userId;

   private String firstName;
   private String lastName;
   private String email;
   private String type;

   // bi-directional many-to-many association to Appointment
   @ManyToMany
   @Fetch(FetchMode.SUBSELECT)
   @JoinTable(name = "users_appointments",
           joinColumns = {@JoinColumn(name = "userId")},
           inverseJoinColumns = {@JoinColumn(name = "appointmentId")})
   private List<Appointment> appointments;

   public User() {
   }

   public int getUserId() {
      return userId;
   }

   public void setUserId(int userId) {
      this.userId = userId;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public List<Appointment> getAppointments() {
      return appointments;
   }

   public void setAppointments(List<Appointment> appointments) {
      this.appointments = appointments;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
}
