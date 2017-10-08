package com.example.shan.wallet.Models;

import java.util.List;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Username")
    @Expose
    private String username;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Surname")
    @Expose
    private String surname;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("Gender")
    @Expose
    private Boolean gender;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("Roles")
    @Expose
    private Object roles;

    public User(String username, String name, String surname, String password, Boolean gender, String email) {
        this.id = 3;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.roles = null;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getSurname() {

        return surname;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public Boolean getGender() {

        return gender;
    }

    public void setGender(Boolean gender) {

        this.gender = gender;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public Object getRoles() {

        return roles;
    }

    public void setRoles(Object roles) {

        this.roles = roles;
    }

}