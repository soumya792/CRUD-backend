package com.soumya.crud.repository;

import com.soumya.crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface Studentrepository 
        extends JpaRepository<Student, Long> {

    // Email se student dhundo
    Optional<Student> findByEmail(String email);

    // Name se student dhundo
    boolean existsByEmail(String email);
}