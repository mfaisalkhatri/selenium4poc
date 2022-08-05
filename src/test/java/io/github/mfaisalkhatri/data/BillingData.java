package io.github.mfaisalkhatri.data;

import lombok.Builder;
import lombok.Getter;

/**
 * Created By Faisal Khatri on 28-07-2022
 */

@Builder
@Getter
public class BillingData {
    private String firstName;
    private String lastName;
    private String addressLineOne;
    private String city;
    private String postCode;
    private String country;
    private String state;
}