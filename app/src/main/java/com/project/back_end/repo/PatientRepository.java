package com.project.back_end.repo;

import com.project.back_end.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    /**
     * Find patient by name
     */
    Optional<Patient> findByName(String name);

    /**
     * Find patients by gender
     */
    List<Patient> findByGender(String gender);

    /**
     * Find patients by contact info
     */
    Optional<Patient> findByContactInfo(String contactInfo);

    /**
     * Find patients born after a specific date
     */
    List<Patient> findByDateOfBirthAfter(LocalDate date);

    /**
     * Find patients born before a specific date
     */
    List<Patient> findByDateOfBirthBefore(LocalDate date);

    /**
     * Find patients by name containing a keyword (case-insensitive)
     */
    List<Patient> findByNameContainingIgnoreCase(String keyword);

    /**
     * Custom query to find patients by address containing a keyword
     */
    @Query("SELECT p FROM Patient p WHERE p.address LIKE %:keyword%")
    List<Patient> findByAddressContaining(@Param("keyword") String keyword);

    /**
     * Custom query to find patients with specific medical conditions
     */
    @Query("SELECT p FROM Patient p WHERE p.medicalHistory LIKE %:condition%")
    List<Patient> findByMedicalCondition(@Param("condition") String condition);

    /**
     * Count patients by gender
     */
    long countByGender(String gender);

    /**
     * Check if a patient exists by contact info
     */
    boolean existsByContactInfo(String contactInfo);
}
