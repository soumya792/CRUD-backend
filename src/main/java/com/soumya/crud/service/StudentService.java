package com.soumya.crud.service;

import com.soumya.crud.dto.*;
import com.soumya.crud.entity.Student;
import com.soumya.crud.repository.Studentrepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final Studentrepository studentRepository;

    // ===== CREATE =====
    public StudentResponseDTO createStudent(
                              StudentRequestDTO dto) {
        
        // Email already exist karta hai?
        if (studentRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException(
                "Email is already in use!");
        }

        Student student = Student.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .course(dto.getCourse())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .build();

        Student saved = studentRepository.save(student);
        return mapToResponse(saved, 
                "Student successfully added! ✅");
    }

    // ===== READ ALL =====
    public List<StudentResponseDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(s -> mapToResponse(s, ""))
                .collect(Collectors.toList());
    }

    // ===== READ BY ID =====
    public StudentResponseDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                    "Student ID not found: " + id));
        return mapToResponse(student, "Student found! ✅");
    }

    // ===== UPDATE =====
    public StudentResponseDTO updateStudent(
                              Long id, 
                              StudentRequestDTO dto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                    "Student ID not found: " + id));

        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setCourse(dto.getCourse());
        student.setPhone(dto.getPhone());
        student.setEmail(dto.getEmail());

        Student updated = studentRepository.save(student);
        return mapToResponse(updated, 
                "Student updated! ✅");
    }

    // ===== DELETE =====
    public String deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                    "Student ID not found: " + id));
        studentRepository.delete(student);
        return "Student ID " + id + " deleted! 🗑️";
    }

    // ===== MAPPER =====
    private StudentResponseDTO mapToResponse(
                               Student s, String message) {
        return StudentResponseDTO.builder()
                .id(s.getId())
                .name(s.getName())
                .age(s.getAge())
                .course(s.getCourse())
                .phone(s.getPhone())
                .email(s.getEmail())
                .message(message)
                .build();
    }
}