package io.github.mfaisalkhatri.data.juiceshop;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public final class UserData {

    private String name;
    private String email;
    private String pass;
    private int mobileNumber;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String country;
}
