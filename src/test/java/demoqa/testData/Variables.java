package demoqa.testData;

import demoqa.utils.RandomUtil;
import com.github.javafaker.Faker;

public class Variables {
    private static final Faker faker = new Faker();

    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            number = faker.phoneNumber().subscriberNumber(10),
            day = String.valueOf(faker.number().numberBetween(1, 15)),
            month = RandomUtil.getRandomMonth(),
            year = String.valueOf(faker.number().numberBetween(1960, 2013)),
            subjects = "Chemistry",
            hobbies = "Sports",
            picturePath = "src/test/resources/K5XLWdiTxVs.jpg",
            picture = "K5XLWdiTxVs.jpg",
            address = faker.address().fullAddress(),
            state = "Haryana",
            city = "Karnal",
            birthDay = day + " " + month + "," + year;
}
