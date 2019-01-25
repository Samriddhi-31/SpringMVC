package com.entities;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "userdetails")
public class UserDetails {
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Address getUser_addr() {
        return user_addr;
    }

    public void setUser_addr(Address user_addr) {
        this.user_addr = user_addr;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer user_id;
    @Embedded
    @Column(name = "user_addr")
    private Address user_addr;
}
