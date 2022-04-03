package ru.praktikum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;

@JsonPropertyOrder({ "firstname", "lastName", "address", "metroStation", "phone", "phone", "rentTime", "deliveryDate", "comment", "color"})
public class Order {

    public static String firstname;
    public static String lastName;
    public static String address;
    public static String metroStation;
    public static String phone;
    public static int rentTime;
    public static String deliveryDate;
    public static String comment;
    public static ArrayList<String> color;


    @JsonCreator
    public Order(
            @JsonProperty("firstname") String firstname,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("address") String address,
            @JsonProperty("metroStation") String metroStation,
            @JsonProperty("phone") String phone,
            @JsonProperty("rentTime") int rentTime,
            @JsonProperty("deliveryDate") String deliveryDate,
            @JsonProperty("comment") String comment,
            @JsonProperty("color") ArrayList<String> color) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;

    }

//    public Order(String firstname, String lastName, String address, String metroStation, String phone, int rentTime, String deliveryDate, String comment, ArrayList<String> color) {
//
//    }

    @JsonGetter("firstname")
    public static String getFirstname() {
        return firstname;
    }

    @JsonGetter("lastName")
    public static String getLastName() {
        return lastName;
    }

    @JsonGetter("address")
    public static String getAddress() {
        return address;
    }

    @JsonGetter("metroStation")
    public static String getMetroStation() {
        return metroStation;
    }

    @JsonGetter("phone")
    public static String getPhone() {
        return phone;
    }

    @JsonGetter("rentTime")
    public static int getRentTime() {
        return rentTime;
    }

    @JsonGetter("deliveryDate")
    public static String getDeliveryDate() {
        return deliveryDate;
    }

    @JsonGetter("comment")
    public static String getComment() {
        return comment;
    }

    @JsonGetter("color")
    public static ArrayList<String> getColor() {
        return color;
    }

}


