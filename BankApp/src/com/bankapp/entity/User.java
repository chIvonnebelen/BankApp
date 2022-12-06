package com.bankapp.entity;

public class User {
    private String name;
    private String lastName;
    private String email;
    private Integer dni;
    private Integer age;

    public User() {}

    public User(String name, String lastName, String email, Integer dni, Integer age) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.dni = dni;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dni=" + dni +
                ", age=" + age +
                '}';
    }


}
