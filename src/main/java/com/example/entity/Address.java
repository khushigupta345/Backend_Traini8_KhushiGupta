package com.example.entity;




import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import lombok.*;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @NotBlank(message = "detailed address is required")
    private String detailedAddress;

    @NotBlank(message = "city is required")
    private String city;

    @NotBlank(message = "state is required")
    private String state;

    @NotBlank(message = "pincode is required")
    @Pattern(regexp = "^[0-9]{6}$", message = "Pincode should be exactly 6 digits")
    private String pincode;
}