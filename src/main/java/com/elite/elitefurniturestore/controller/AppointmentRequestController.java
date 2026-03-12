package com.elite.elitefurniturestore.controller;

import com.elite.elitefurniturestore.entity.AppointmentRequest;
import com.elite.elitefurniturestore.service.AppointmentRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*")
public class AppointmentRequestController {

    private final AppointmentRequestService appointmentRequestService;

    public AppointmentRequestController(AppointmentRequestService appointmentRequestService) {
        this.appointmentRequestService = appointmentRequestService;
    }

    @GetMapping
    public List<AppointmentRequest> getAllAppointments() {
        return appointmentRequestService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public AppointmentRequest getAppointmentById(@PathVariable Long id) {
        return appointmentRequestService.getAppointmentById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    @PostMapping
    public AppointmentRequest createAppointment(@RequestBody AppointmentRequest appointmentRequest) {
        return appointmentRequestService.saveAppointment(appointmentRequest);
    }

    @PutMapping("/{id}")
    public AppointmentRequest updateAppointment(@PathVariable Long id, @RequestBody AppointmentRequest appointmentRequest) {
        return appointmentRequestService.updateAppointment(id, appointmentRequest);
    }

    @DeleteMapping("/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        appointmentRequestService.deleteAppointment(id);
        return "Appointment deleted successfully";
    }
}