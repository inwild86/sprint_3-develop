package ru.praktikum;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;

public class OrderGenerator {

    @Step("Generating random order")
    public static Order getRandomOrder() {
        String orderFirstname = RandomStringUtils.randomAlphabetic(9);
        String orderLstName = RandomStringUtils.randomAlphabetic(9);
        String orderAddress = RandomStringUtils.randomAlphabetic(9);
        String orderMetroStation = RandomStringUtils.randomAlphabetic(9);
        String orderPhone = RandomStringUtils.randomAlphabetic(9);
        int orderRentTime = 2;
        String orderDeliveryDate = "2022-06-06";
        String orderComment = RandomStringUtils.randomAlphabetic(9);
        ArrayList<String> color = new ArrayList<String>();
        color.add("BLACK");

        Allure.addAttachment("orderFirstname", orderFirstname);
        Allure.addAttachment("orderLstName", orderLstName);
        Allure.addAttachment("orderAddress", orderAddress);
        Allure.addAttachment("orderMetroStation", orderMetroStation);
        Allure.addAttachment("orderPhone", orderPhone);
        Allure.addAttachment("orderComment", orderComment);

        return new Order(orderFirstname, orderLstName, orderAddress, orderMetroStation, orderPhone, orderRentTime, orderDeliveryDate, orderComment, color);

    }

}
