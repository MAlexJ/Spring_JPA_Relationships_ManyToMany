package com.malex.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "user_name")
    private String userName;

    @OneToOne(cascade = CascadeType.ALL)
    private Bank bank;

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (userName != null ? !userName.equals(employee.userName) : employee.userName != null) return false;
        return bank != null ? bank.equals(employee.bank) : employee.bank == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (bank != null ? bank.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {

        return "Employee{" +
                "name='" + name +
                ", userName='" + userName +
                (bank != null ? ", bank=" + bank.getName() : " ")
                + '}';
    }
}
