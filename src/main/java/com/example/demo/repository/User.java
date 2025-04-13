package com.example.demo.repository;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "userdemo")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "name") //если поле различается с полем в БД
    public  String name;
    public String email;
    public LocalDate birth;
    public Integer age;


    public User(Integer age, LocalDate birth, String email, String name, Long id) {
        this.age = age;
        this.birth = birth;
        this.email = email;
        this.name = name;
        this.id = id;
    }

    public User() { }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                ", age=" + age +
                '}';
    }
}

