package io.github.mfaisalkhatri.testdata;

import lombok.Builder;
import lombok.Getter;

/**
 * Created By Faisal Khatri on 25-07-2022
 */
@Builder
@Getter
public class RegisterUserData {

    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
    private String password;
}