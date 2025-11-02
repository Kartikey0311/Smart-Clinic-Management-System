package com.project.back_end.repo;

import com.project.back_end.models.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    /**
     * Find prescriptions by patient ID
     */
    List<Prescription> findByPatientId(Long patientId);

    /**
     * Find prescriptions by doctor ID
     */
    List<Prescription> findByDoctorId(Long doctorId);

    /**
     * Find prescriptions by medication name
     */
    List<Prescription> findByMedicationContainingIgnoreCase(String medication);

    /**
     * Find prescriptions by prescription date
     */
    List<Prescription> findByPrescriptionDate(LocalDate prescriptionDate);

    /**
     * Find prescriptions after a specific date
     */
    List<Prescription> findByPrescriptionDateAfter(LocalDate date);

    /**
     * Find prescriptions before a specific date
     */
    List<Prescription> findByPrescriptionDateBefore(LocalDate date);

    /**
     * Find prescriptions between two dates
     */
    List<Prescription> findByPrescriptionDateBetween(LocalDate startDate, LocalDate endDate);

    /**
     * Custom query to find prescriptions by patient ID and doctor ID
     */
    @Query("SELECT p FROM Prescription p WHERE p.patientId = :patientId AND p.doctorId = :doctorId")
    List<Prescription> findByPatientIdAndDoctorId(@Param("patientId") Long patientId, @Param("doctorId") Long doctorId);

    /**
     * Count prescriptions by patient ID
     */
    long countByPatientId(Long patientId);

    /**
     * Count prescriptions by doctor ID
     */
    long countByDoctorId(Long doctorId);
}
