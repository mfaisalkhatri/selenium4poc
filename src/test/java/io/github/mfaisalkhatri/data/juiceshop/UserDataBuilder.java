package io.github.mfaisalkhatri.data.juiceshop;

import net.datafaker.Faker;

public final class UserDataBuilder {

    public static UserData getUserData() {

        final Faker faker = new Faker();
        return UserData.builder().name(faker.name()
                .fullName()).email(faker.internet()
                .emailAddress()).pass(faker.internet()
                .password(6, 12)).mobileNumber(faker.number()
                .numberBetween(99900000, 99988888)).address(faker.address()
                .streetAddress()).city(faker.address()
                .city()).state(faker.address()
                .state()).zipcode(faker.number()
                .digits(6)).country(faker.address()
                .country()).build();
    }
}
