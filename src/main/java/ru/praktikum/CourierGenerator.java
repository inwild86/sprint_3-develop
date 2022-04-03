package ru.praktikum;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;



public class CourierGenerator {
    static String courierLogin;
    static String courierPassword;
    static String courierFirstName;

    @Step("Generating random courier with Login, Password and FirstName")
    public static Courier getRandomLoginPasswordFirstName() {
        courierLogin = RandomStringUtils.randomAlphabetic(9);
        courierPassword = RandomStringUtils.randomAlphabetic(9);
        courierFirstName = RandomStringUtils.randomAlphabetic(9);

        Allure.addAttachment("login", courierLogin);
        Allure.addAttachment("password", courierPassword);
        Allure.addAttachment("firstName", courierFirstName);

        return new Courier(courierLogin, courierPassword, courierFirstName);
    }

    @Step("Generating random courier with Login and Password without FirstName")
    public static Courier getRandomLoginPasswordWithoutFirstName() {
        courierLogin = RandomStringUtils.randomAlphabetic(9);
        courierPassword = RandomStringUtils.randomAlphabetic(9);

        Allure.addAttachment("login", courierLogin);
        Allure.addAttachment("password", courierPassword);

        return new Courier(courierLogin, courierPassword);
    }

    @Step("Generating random courier with Login without FirstName and Password")
    public static Courier getRandomLoginPasswordWithoutFirstNameAndPassword() {
        courierLogin = RandomStringUtils.randomAlphabetic(9);

        Allure.addAttachment("login", courierLogin);

        return new Courier(courierLogin);
    }


}