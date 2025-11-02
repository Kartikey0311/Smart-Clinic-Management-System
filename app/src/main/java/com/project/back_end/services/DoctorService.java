package com.project.back_end.services;

import com.project.back_end.models.Doctor;
import com.project.back_end.repo.DoctorRepository;
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
        Optional<Doctor> doctor = doctorRepository.findById(id);
        return doctor.orElse(null);
    }

    /**
     * Get doctors by specialization
     */
    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization);
    }

    /**
     * Get doctor by name
     */
    public Doctor getDoctorByName(String name) {
        Optional<Doctor> doctor = doctorRepository.findByName(name);
        return doctor.orElse(null);
    }

    /**
     * Search doctors by name containing keyword
     */
    public List<Doctor> searchDoctorsByName(String keyword) {
        return doctorRepository.findByNameContainingIgnoreCase(keyword);
    }

    /**
     * Get doctor by contact info
     */
    public Doctor getDoctorByContactInfo(String contactInfo) {
        Optional<Doctor> doctor = doctorRepository.findByContactInfo(contactInfo);
        return doctor.orElse(null);
    }

    /**
     * Save or create a new doctor
     */
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    /**
     * Update existing doctor
     */
    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        Optional<Doctor> existingDoctor = doctorRepository.findById(id);
        if (existingDoctor.isPresent()) {
            Doctor doctor = existingDoctor.get();
            doctor.setName(updatedDoctor.getName());
            doctor.setSpecialization(updatedDoctor.getSpecialization());
            doctor.setContactInfo(updatedDoctor.getContactInfo());
            return doctorRepository.save(doctor);
        }
        return null;
    }

    /**
     * Delete doctor by ID
     */
    public boolean deleteDoctor(Long id) {
        if (doctorRepository.existsById(id)) {
            doctorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Check if doctor exists by ID
     */
    public boolean doctorExists(Long id) {
        return doctorRepository.existsById(id);
    }

    /**
     * Check if doctor exists by contact info
     */
    public boolean doctorExistsByContactInfo(String contactInfo) {
        return doctorRepository.existsByContactInfo(contactInfo);
    }

    /**
     * Count total doctors
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
