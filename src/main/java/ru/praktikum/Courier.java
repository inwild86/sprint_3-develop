package ru.praktikum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "login", "password", "firstname"})
public class Courier {

    public static String login;
    public static String password;
    public static String firstname;

@JsonCreator
    public Courier
        (@JsonProperty("login") String login) {
        this.login = login;

    }

@JsonCreator
    public Courier(
        @JsonProperty("login") String login,
        @JsonProperty("password") String password) {
            this.login = login;
            this.password = password;

    }

@JsonCreator
    public Courier(
        @JsonProperty("login") String login,
        @JsonProperty("password") String password,
        @JsonProperty("firstname") String firstname) {
        this.login = login;
        this.password = password;
        this.firstname = firstname;
    }

@JsonGetter("login")
    public String getLogin() {
        return login;
    }

@JsonGetter("password")
    public String getPassword() {
        return password;
    }

@JsonGetter("firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

}

