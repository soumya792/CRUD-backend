package com.soumya.crud.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequestDTO {

    @NotBlank(message = "Name is required!")
    private String name;

    @NotNull(message = "Age is required!")
    @Min(value = 1, message = "Age is not valid!")
    private Integer age;

    @NotBlank(message = "Course is required!")
    private String course;

    @NotBlank(message = "Phone is required!")
    private String phone;

    @NotBlank(message = "Email is required!")
    @Email(message = "Valid email is required!")
    private String email;
}