package com.elite.elitefurniturestore.service;

import com.elite.elitefurniturestore.entity.AppointmentRequest;
import com.elite.elitefurniturestore.repository.AppointmentRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentRequestService {

    private final AppointmentRequestRepository appointmentRequestRepository;

    public AppointmentRequestService(AppointmentRequestRepository appointmentRequestRepository) {
        this.appointmentRequestRepository = appointmentRequestRepository;
    }

    public List<AppointmentRequest> getAllAppointments() {
        return appointmentRequestRepository.findAll();
    }

    public Optional<AppointmentRequest> getAppointmentById(Long id) {
        return appointmentRequestRepository.findById(id);
    }

    public AppointmentRequest saveAppointment(AppointmentRequest appointmentRequest) {
        return appointmentRequestRepository.save(appointmentRequest);
    }

    public AppointmentRequest updateAppointment(Long id, AppointmentRequest updatedAppointment) {
        return appointmentRequestRepository.findById(id).map(appointment -> {
            appointment.setCustomerName(updatedAppointment.getCustomerName());
            appointment.setEmail(updatedAppointment.getEmail());
            appointment.setPhone(updatedAppointment.getPhone());
            appointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
            appointment.setAppointmentTime(updatedAppointment.getAppointmentTime());
            appointment.setPurpose(updatedAppointment.getPurpose());
            appointment.setNote(updatedAppointment.getNote());
            return appointmentRequestRepository.save(appointment);
        }).orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    public void deleteAppointment(Long id) {
        appointmentRequestRepository.deleteById(id);
    }
}