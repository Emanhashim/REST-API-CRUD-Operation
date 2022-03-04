package com.example.restapi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="employee")
public class register {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @Column(name = "birth", nullable = false)
    private String birth;

    @Column(name = "country")
    private String country;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

    @Column(name = "re_password")
    private String re_password;

    @Column(name = "role")
    private String role = "user";


}
