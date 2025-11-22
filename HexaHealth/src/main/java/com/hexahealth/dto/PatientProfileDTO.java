package com.hexahealth.dto;

import com.hexahealth.model.Appointment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientProfileDTO {
    private int pid;
    private String Name;
    private String City;

    private List<Appointment> appointments;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
