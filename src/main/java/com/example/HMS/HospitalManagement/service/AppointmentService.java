package com.example.HMS.HospitalManagement.service;

import com.example.HMS.HospitalManagement.entity.Appointment;
import com.example.HMS.HospitalManagement.entity.Doctor;
import com.example.HMS.HospitalManagement.entity.Patient;
import com.example.HMS.HospitalManagement.repository.AppointmentRepository;
import com.example.HMS.HospitalManagement.repository.DoctorRepository;
import com.example.HMS.HospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public Appointment createAppointment(Appointment appointment, Long patientId, Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId() != null) throw new IllegalArgumentException("Appointment already exists");

        appointment.setPatient(patient);    //owning side
        appointment.setDoctor(doctor);      // owning side

        patient.getAppointments().add(appointment);     // just to maintain bidirectional consistency

        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reassignAppointmentToDoctor(Long appointmentId, Long doctorId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);      // appointment is updated, so by dirty checking it's updated in DB as appointment is in persistent state
        doctor.getAppointments().add(appointment);      // just for bidirectional consistency
        return appointment;
    }
}
