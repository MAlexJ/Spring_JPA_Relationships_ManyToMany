package com.malex.model;


import javax.persistence.*;

@Entity
@Table(name = "bank")
public class Bank extends BaseEntity {


    @Column(name = "name", nullable = false, unique = true)
    private String name;

   @OneToOne
    private Employee employee;

    public Bank() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    @Override
    public boolean equals(Object o) {


        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bank bank = (Bank) o;

        if (name != null ? !name.equals(bank.name) : bank.name != null) return false;
        return employee != null ? employee.equals(bank.employee) : bank.employee == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", employee=" + employee +
                '}';
    }
}
