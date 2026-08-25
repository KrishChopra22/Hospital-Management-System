package com.example.HMS.HospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String reason;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne  // Owning Side
    @JoinColumn(nullable = false)  // without patient, appointment is of no use
    @ToString.Exclude
    private Patient patient;

    @ManyToOne  // Owning Side
    @JoinColumn(nullable = false)
    @ToString.Exclude
    private Doctor doctor;
}
