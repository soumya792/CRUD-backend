package com.soumya.crud.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequestDTO {

    @NotBlank(message = "Name required hai!")
    private String name;

    @NotNull(message = "Age required hai!")
    @Min(value = 1, message = "Age valid honi chahiye!")
    private Integer age;

    @NotBlank(message = "Course required hai!")
    private String course;

    @NotBlank(message = "Phone required hai!")
    private String phone;

    @NotBlank(message = "Email required hai!")
    @Email(message = "Valid email daalo!")
    private String email;
}