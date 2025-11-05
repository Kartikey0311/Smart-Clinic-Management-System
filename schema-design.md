## Database Schema Design

### Tables

**Doctor**
- doctor_id (PK)
- name
- specialization
- contact_info

**Patient**
- patient_id (PK)
- name
- age
- contact_info

**Appointment**
- appointment_id (PK)
- doctor_id (FK)
- patient_id (FK)
- appointment_date
- status
**Presciption**
 - prescription_id (PK)
 - appointment_id (FK → Appointment.appointment_id)
 - doctor_id (FK → Doctor.doctor_id)
 - patient_id (FK → Patient.patient_id)
 - medication_details
 - created_at
