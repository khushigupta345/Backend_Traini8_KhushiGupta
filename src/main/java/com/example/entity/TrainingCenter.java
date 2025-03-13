package com.example.entity;



import jakarta.persistence.*;
import jakarta.validation.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TrainingCenter {
//primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "center name is required")
    @Size(max = 40, message = "center name should be less than 40 character")
    private String centerName;

    @NotBlank(message = "center code is required")
    @Pattern(regexp = "^[A-Za-z0-9]{12}$", message = "Center code must be exactly 12 alphanumeric characters")
    private String centerCode;
//embedded address for storing center address
    @Embedded
    @Valid
    private Address address;

    private Integer studentCapacity;

    @ElementCollection
    private List<String> coursesOffered;


    @JsonIgnore
   private Long createdOn;

    @Email(message = "Invalid email format")
    private String contactEmail;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number should be exactly 10 digits")
    private String contactPhone;
//for storing in epoch time
    @PrePersist
    public void prePersist() {
    
        this.createdOn = System.currentTimeMillis();
        
    }
}
  