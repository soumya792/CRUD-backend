package com.soumya.crud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name is required!")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Age is required!")
    @Min(value = 1, message = "Age is not valid!")
    private Integer age;

    @Column(nullable = false)
    @NotBlank(message = "Course is required!")
    private String course;

    @Column(nullable = false)
    @NotBlank(message = "Phone is required!")
    private String phone;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Email is required!")
    @Email(message = "Valid email is required!")
    private String email;
}