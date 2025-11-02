package com.project.back_end.models;

public class Doctor {
    private int doctorId;
    private String name;
    private String specialization;
    private String contactInfo;

    public Doctor() {}

    public Doctor(int doctorId, String name, String specialization, String contactInfo) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.contactInfo = contactInfo;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
