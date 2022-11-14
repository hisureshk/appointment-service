package com.bits.scalableservices.group23.service;

import com.bits.scalableservices.group23.model.Appointment;
import com.bits.scalableservices.group23.repo.AppointmentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepo appointmentRepo;

    public AppointmentServiceImpl() {
    }

    public AppointmentServiceImpl(AppointmentRepo appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

    @Override
    public Optional<Appointment> findById(Long appointmentId) {
        return appointmentRepo.findById(appointmentId);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepo.findAll();
    }

    @Override
    public List<Appointment> findByDateRangeSortedByPrice(LocalDate startDate, LocalDate endDate) {
        return appointmentRepo.findAllByAppointmentDateBetweenOrderByPriceAsc(startDate, endDate);
    }

    @Override
    public Appointment create(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    @Override
    public Appointment update(Long appointmentId, Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    @Override
    public Appointment updateStatus(Long appointmentId, Appointment appointment) {

        Optional<Appointment> appointmentList = appointmentRepo.findById(appointmentId);

        if(appointmentList.isPresent()){
            if(appointment.getStatus() != null){
                appointmentList.get().setStatus(appointment.getStatus());
            }
            return appointmentRepo.save(appointmentList.get());
        }
        return null;
    }

    @Override
    public void deleteById(Long appointmentId) {
        appointmentRepo.deleteById(appointmentId);
    }
    
}
