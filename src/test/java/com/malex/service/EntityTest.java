package com.malex.service;

import com.malex.configuration.AppConfigTest;
import com.malex.model.Appointment;
import com.malex.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;


@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigTest.class})
@WebAppConfiguration
public class EntityTest extends AbstractTransactionalJUnit4SpringContextTests {

   @Autowired
   private AppointmentService appointmentService;

   @Autowired
   private UserService userService;

   @Test
   @Rollback(value = false)
   public void testCreate_1_0() {

      // >>> Patients
      User patient_01 = createUser("Alex", "M", "alex@com.com", "PATIENT");
      User patient_02 = createUser("Max", "S", "max@ss.sss", "PATIENT");
      User patient_03 = createUser("Anna", "Kov", "kov@kk.kkk", "PATIENT");

      // >>> Doctors
      User doctor_01 = createUser("ADoc", "AI", "doc@email.com", "DOCTOR");
      User doctor_02 = createUser("BB_DOC", "DD", "dddddd@ddddd.com", "DOCTOR");

      // create users
      userService.save(patient_01);
      userService.save(patient_02);
      userService.save(patient_03);
      userService.save(doctor_01);
      userService.save(doctor_02);

      // #2
      Appointment appointment = createAppointment("Headache","In progress");
      appointmentService.save(appointment);

      List<Appointment> appointmentList = new ArrayList<>();
      appointmentList.add(appointment);

      // #3
      patient_01.setAppointments(appointmentList);
      doctor_01.setAppointments(appointmentList);

   }


   @Test
   public void testGetUserIgnoreAppointment(){
      User user = userService.getUserIgnoreAppointment("alex@com.com");

      System.err.println(user.getEmail());

      for(Appointment appointment: user.getAppointments()){
         System.err.println(appointment.getDescription());
         System.err.println(appointment.getUsers());
      }

   }

   @Test
   public void test(){
      User user = userService.getUserWithAppointment("alex@com.com");

      System.err.println(user.getEmail());

      for(Appointment appointment: user.getAppointments()){
         System.err.println(appointment.getDescription());
         System.err.println(appointment.getUsers());
      }
   }



   /**
    * Create a new User
    */
   private User createUser(String firstName, String lastName, String email, String type) {
      User user = new User();
      user.setFirstName(firstName);
      user.setLastName(lastName);
      user.setEmail(email);
      user.setType(type);
      return user;
   }

   /**
    * Create a new Appointment
    */
   private Appointment createAppointment(String description, String status) {
      Appointment appointment = new Appointment();
      appointment.setDescription(description);
      appointment.setStatus(status);
      return appointment;
   }

}
