package com.project.back_end.repo;

import com.project.back_end.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    /**
     * Find doctor by name
     */
    Optional<Doctor> findByName(String name);

    /**
     * Find doctors by specialization
     */
    List<Doctor> findBySpecialization(String specialization);

    /**
     * Find doctor by contact info
     */
    Optional<Doctor> findByContactInfo(String contactInfo);

    /**
     * Find doctors by name containing a keyword (case-insensitive)
     */
    List<Doctor> findByNameContainingIgnoreCase(String keyword);

    /**
     * Find doctors by specialization containing a keyword (case-insensitive)
     */
    List<Doctor> findBySpecializationContainingIgnoreCase(String keyword);

    /**
     * Count doctors by specialization
     */
    long countBySpecialization(String specialization);

    /**
     * Check if a doctor exists by contact info
     */
    boolean existsByContactInfo(String contactInfo);

    /**
     * Get all distinct specializations
     */
    @Query("SELECT DISTINCT d.specialization FROM Doctor d ORDER BY d.specialization")
    List<String> findDistinctSpecializations();

    /**
     * Custom query to find doctors with specific specializations
     */
    @Query("SELECT d FROM Doctor d WHERE d.specialization IN :specializations")
    List<Doctor> findBySpecializationIn(List<String> specializations);
}
