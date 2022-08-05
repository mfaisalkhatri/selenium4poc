package io.github.mfaisalkhatri.data;

import com.github.javafaker.Faker;

/**
 * Created By Faisal Khatri on 25-07-2022
 */
public class TestDataBuilder {

    private static final Faker FAKER = Faker.instance ();

    public static BillingData getBillingData () {
        return BillingData.builder ()
            .firstName (FAKER.name ()
                .firstName ())
            .lastName (FAKER.name ()
                .lastName ())
            .addressLineOne (FAKER.address ()
                .streetAddress ())
            .city (FAKER.address ()
                .cityName ())
            .postCode (FAKER.address ()
                .zipCode ())
            .country ("India")
            .state ("Maharashtra")
            .build ();
    }

    public static RegisterUserData getRegisterUserData () {
        return RegisterUserData.builder ()
            .firstName (FAKER.name ()
                .firstName ())
            .lastName (FAKER.name ()
                .lastName ())
            .email (FAKER.internet ()
                .emailAddress ())
            .telephone (String.valueOf (FAKER.number ()
                .numberBetween (9000000000L, 9999999999L)))
            .build ();
    }
}