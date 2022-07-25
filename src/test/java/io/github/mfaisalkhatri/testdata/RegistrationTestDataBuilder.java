package io.github.mfaisalkhatri.testdata;

import com.github.javafaker.Faker;

/**
 * Created By Faisal Khatri on 25-07-2022
 */
public class RegistrationTestDataBuilder {

    public RegisterUserData registerUserDataBuilder () {
        Faker faker = Faker.instance();
        return RegisterUserData.builder().firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet()
                        .emailAddress())
                .telephone(String.valueOf(faker.number().numberBetween(9000000000L, 9999999999L)))
                .build();
    }
}