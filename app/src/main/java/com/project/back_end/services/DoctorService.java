package com.project.back_end.services;

import com.project.back_end.models.Doctor;
import com.project_back_end.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    /**
     * Get all doctors
     */
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    /**
     * Get doctor by ID
     */
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Doctor not found with ID: " + id)
        );
    }

    /**
     * Get doctors by specialization
     */
    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization);
    }

    /**
     * Get doctor by exact name
     */
    public Doctor getDoctorByName(String name) {
        return doctorRepository.findByName(name).orElse(null);
    }

    /**
     * Search doctors by name keyword
     */
    public List<Doctor> searchDoctorsByName(String keyword) {
        return doctorRepository.findByNameContainingIgnoreCase(keyword);
    }

    /**
     * Get doctor by contact info
     */
    public Doctor getDoctorByContactInfo(String contactInfo) {
        return doctorRepository.findByContactInfo(contactInfo).orElse(null);
    }

    /**
     * Save or create a doctor
     */
    public Doctor saveDoctor(Doctor doctor) {
        if (doctor.getName() == null || doctor.getName().isBlank()) {
            throw new IllegalArgumentException("Doctor name cannot be empty");
        }
        return doctorRepository.save(doctor);
    }

    /**
     * Update existing doctor
     */
    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        return doctorRepository.findById(id).map(existingDoctor -> {
            existingDoctor.setName(updatedDoctor.getName());
            existingDoctor.setSpecialization(updatedDoctor.getSpecialization());
            existingDoctor.setContactInfo(updatedDoctor.getContactInfo());
            return doctorRepository.save(existingDoctor);
        }).orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + id));
    }

    /**
     * Delete doctor by ID
     */
    public boolean deleteDoctor(Long id) {
        if (!doctorRepository.existsById(id)) {
            return false;
        }
        doctorRepository.deleteById(id);
        return true;
    }

    /**
     * Check doctor exists by ID
     */
    public boolean doctorExists(Long id) {
        return doctorRepository.existsById(id);
    }

    /**
     * Check doctor exists by contact info
     */
    public boolean doctorExistsByContactInfo(String contactInfo) {
        return doctorRepository.existsByContactInfo(contactInfo);
    }

    /**
     * Count all doctors
     */
    public long countAllDoctors() {
        return doctorRepository.count();
    }

    /**
     * Count doctors by specialization
     */
    public long countDoctorsBySpecialization(String specialization) {
        return doctorRepository.countBySpecialization(specialization);
    }

    /**
     * Get all unique specializations
     */
    public List<String> getAllSpecializations() {
        return doctorRepository.findDistinctSpecializations();
    }
}
