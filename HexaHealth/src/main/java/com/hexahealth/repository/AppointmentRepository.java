package com.hexahealth.repository;

import com.hexahealth.model.Appointment;
import com.hexahealth.model.AppointmentType;
import com.hexahealth.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    @Query("select distinct a.patient from Appointment a where a.type = :type")
    List<Patient> patientsForSurgery(@Param("type") AppointmentType type);

    @Query("select a from Appointment a where a.patient.pid = :pid")
    List<Appointment> findAppointmentsByPatient(@Param("pid") int pid);

    @Query("select a from Appointment a where a.type = :type")
    List<Appointment> findAppointmentsByAppointmentsType(AppointmentType type);
}
