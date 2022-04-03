package ru.praktikum;

public class CourierCredentials {


    private String login;
    private String password;
    //private String firstName;

    public CourierCredentials(String login, String password) {
        this.login = login;
        this.password = password;
        //this.firstName = firstName;
    }



    public CourierCredentials(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}