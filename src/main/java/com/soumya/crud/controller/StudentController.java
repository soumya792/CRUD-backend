package com.soumya.crud.controller;

import com.soumya.crud.dto.*;
import com.soumya.crud.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
@Tag(name = "Student API", 
     description = "Student Management CRUD")
public class StudentController {

    private final StudentService studentService;

    // ===== POST - CREATE =====
    @PostMapping
    @Operation(summary = "Naya student add karo")
    public ResponseEntity<StudentResponseDTO> createStudent(
            @Valid @RequestBody StudentRequestDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentService.createStudent(dto));
    }

    // ===== GET ALL =====
    @GetMapping
    @Operation(summary = "Saare students dekho")
    public ResponseEntity<List<StudentResponseDTO>> 
                                        getAllStudents() {
        return ResponseEntity
                .ok(studentService.getAllStudents());
    }

    // ===== GET BY ID =====
    @GetMapping("/{id}")
    @Operation(summary = "ID se student dekho")
    public ResponseEntity<StudentResponseDTO> 
                                getStudentById(
            @PathVariable Long id) {
        return ResponseEntity
                .ok(studentService.getStudentById(id));
    }

    // ===== PUT - UPDATE =====
    @PutMapping("/{id}")
    @Operation(summary = "Student update karo")
    public ResponseEntity<StudentResponseDTO> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentRequestDTO dto) {
        return ResponseEntity
                .ok(studentService.updateStudent(id, dto));
    }

    // ===== DELETE =====
    @DeleteMapping("/{id}")
    @Operation(summary = "Student delete karo")
    public ResponseEntity<String> deleteStudent(
            @PathVariable Long id) {
        return ResponseEntity
                .ok(studentService.deleteStudent(id));
    }
}