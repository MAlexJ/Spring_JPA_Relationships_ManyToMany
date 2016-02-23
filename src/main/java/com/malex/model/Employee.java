package com.malex.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {

    @Column(name = "user_name")
    private String userName;

    @OneToOne(mappedBy = "employee")
    private Bank bank;

    public Employee() {
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
}
