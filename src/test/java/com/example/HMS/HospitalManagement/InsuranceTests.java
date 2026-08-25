package com.example.HMS.HospitalManagement;

import com.example.HMS.HospitalManagement.entity.Appointment;
import com.example.HMS.HospitalManagement.entity.Insurance;
import com.example.HMS.HospitalManagement.entity.Patient;
import com.example.HMS.HospitalManagement.service.AppointmentService;
import com.example.HMS.HospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTests {
    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testInsurance(){
//        Insurance insurance = new Insurance();    // not required now, we'll use builder
        Insurance insurance = Insurance.builder().
                policyNumber("HDFC-00324").provider("HDFC").validUntil(LocalDate.of(2030,12, 12)).build();
        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println(patient);

        var newPatient = insuranceService.disassociateInsuranceFromPatient(2L);
        System.out.println(newPatient);
    }

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testAppointment(){
        Appointment appointment = Appointment.builder().appointmentTime(LocalDateTime.of(2025,11,1,14,15,0)).reason("Stomach Pain").build();
        var newAppt = appointmentService.createAppointment(appointment, 2L, 1L);
        System.out.println(newAppt);

        var updatedAppointment = appointmentService.reassignAppointmentToDoctor(newAppt.getId(), 3L);
        System.out.println(updatedAppointment);
    }
}
