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
    @NotBlank(message = "Name required hai!")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Age required hai!")
    @Min(value = 1, message = "Age valid honi chahiye!")
    private Integer age;

    @Column(nullable = false)
    @NotBlank(message = "Course required hai!")
    private String course;

    @Column(nullable = false)
    @NotBlank(message = "Phone required hai!")
    private String phone;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Email required hai!")
    @Email(message = "Valid email daalo!")
    private String email;
}