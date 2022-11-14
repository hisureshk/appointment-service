package com.bits.scalableservices.group23.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Entity
public class Appointment {

    private @Id @GeneratedValue Long id;
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    private LocalDate appointmentDate;
    private Time appointmentStartTime;
    private Time appointmentEndTime;
    private String doctorName;
    private String status = "Booked";
    private String appointmentType;
    private BigDecimal price;

    public Appointment() {

    }

    public Appointment(Timestamp createdAt, LocalDate appointmentDate, Time appointmentStartTime, Time appointmentEndTime, String doctorName, String status, BigDecimal price, String appointmentType) {
        this.createdAt = createdAt;
        this.appointmentDate = appointmentDate;
        this.appointmentStartTime = appointmentStartTime;
        this.appointmentEndTime = appointmentEndTime;
        this.doctorName = doctorName;
        this.status = status;
        this.price = price;
        this.appointmentType = appointmentType;
    }

    public Appointment(LocalDate appointmentDate, Time appointmentStartTime, Time appointmentEndTime, String doctorName, BigDecimal price, String appointmentType) {
        this.appointmentDate = appointmentDate;
        this.appointmentStartTime = appointmentStartTime;
        this.appointmentEndTime = appointmentEndTime;
        this.doctorName = doctorName;
        this.price = price;
        this.appointmentType = appointmentType;
    }

    public Appointment(LocalDate appointmentDate, String doctorName, BigDecimal price) {
        this.appointmentDate = appointmentDate;
        this.doctorName = doctorName;
        this.price = price;
    }

}