package com.soumya.crud.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponseDTO {

    private Long id;
    private String name;
    private Integer age;
    private String course;
    private String phone;
    private String email;
    private String message;
}