package io.github.mfaisalkhatri.data;

import lombok.Builder;
import lombok.Getter;

/**
 * Created By Faisal Khatri on 25-07-2022
 */
@Builder
@Getter
public class RegisterUserData {
    
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String telephone;
}