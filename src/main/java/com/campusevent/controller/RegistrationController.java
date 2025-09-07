package com.campusevent.controller;

import com.campusevent.entity.Registration;
import com.campusevent.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    // Register a student to an event
    @PostMapping("/register")
    public Registration registerStudent(
            @RequestParam Long studentId,
            @RequestParam Long eventId) {
        return registrationService.registerStudent(studentId, eventId);
    }

    // Mark attendance
    @PutMapping("/{id}/attendance")
    public Registration markAttendance(
            @PathVariable Long id,
            @RequestParam boolean attended) {
        return registrationService.markAttendance(id, attended);
    }

    // Collect feedback (rating 1–5)
    @PutMapping("/{id}/feedback")
    public Registration collectFeedback(
            @PathVariable Long id,
            @RequestParam int rating) {
        return registrationService.collectFeedback(id, rating);
    }

    // List all registrations
    @GetMapping
    public List<Registration> getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }
}
