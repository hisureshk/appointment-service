package com.bits.scalableservices.group23.repo;

import com.bits.scalableservices.group23.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByAppointmentDateBetweenOrderByPriceAsc(LocalDate startDate, LocalDate endDate);

}