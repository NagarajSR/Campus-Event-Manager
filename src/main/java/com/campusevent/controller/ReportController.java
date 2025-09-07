package com.campusevent.controller;

import com.campusevent.entity.Event;
import com.campusevent.entity.Registration;
import com.campusevent.repository.EventRepository;
import com.campusevent.repository.RegistrationRepository;
import com.campusevent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private StudentRepository studentRepository;

    /**
     * Event Popularity Report → Sorted by number of registrations
     */
    @GetMapping("/event-popularity")
    public List<Map<String, Object>> getEventPopularityReport() {
        List<Event> events = eventRepository.findAll();
        List<Map<String, Object>> report = new ArrayList<>();

        for (Event event : events) {
            long count = registrationRepository.countByEvent(event);
            Map<String, Object> row = new HashMap<>();
            row.put("event", event.getName());
            row.put("registrations", count);
            report.add(row);
        }

        // Sort by number of registrations (descending)
        report.sort((a, b) -> ((Long) b.get("registrations")).compareTo((Long) a.get("registrations")));
        return report;
    }

    /**
     * Student Participation Report → How many events a student attended
     */
    @GetMapping("/student-participation")
    public List<Map<String, Object>> getStudentParticipationReport() {
        List<Registration> registrations = registrationRepository.findAll();
        Map<String, Long> participation = new HashMap<>();

        for (Registration reg : registrations) {
            if (reg.isAttended()) {
                String studentName = reg.getStudent().getName();
                participation.put(studentName, participation.getOrDefault(studentName, 0L) + 1);
            }
        }

        List<Map<String, Object>> report = new ArrayList<>();
        participation.forEach((student, count) -> {
            Map<String, Object> row = new HashMap<>();
            row.put("student", student);
            row.put("attendedEvents", count);
            report.add(row);
        });

        return report;
    }

    /**
     * Top 3 Most Active Students
     */
    @GetMapping("/top-active-students")
    public List<Map<String, Object>> getTopActiveStudents() {
        List<Map<String, Object>> participation = getStudentParticipationReport();
        participation.sort((a, b) -> ((Long) b.get("attendedEvents")).compareTo((Long) a.get("attendedEvents")));
        return participation.subList(0, Math.min(3, participation.size()));
    }
}
