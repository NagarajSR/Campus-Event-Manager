package com.campusevent.service;

import com.campusevent.entity.Event;
import com.campusevent.entity.Registration;
import com.campusevent.entity.Student;
import com.campusevent.repository.RegistrationRepository;
import com.campusevent.repository.StudentRepository;
import com.campusevent.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EventRepository eventRepository;

    @Transactional
    public Registration registerStudent(Long studentId, Long eventId) {
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        Optional<Event> eventOpt = eventRepository.findById(eventId);

        if (studentOpt.isPresent() && eventOpt.isPresent()) {
            Student student = studentOpt.get();
            Event event = eventOpt.get();

            // Business logic: check if student is already registered for this event
            Registration existingRegistration = registrationRepository.findByStudentAndEvent(student, event);
            if (existingRegistration != null) {
                throw new IllegalStateException("Student is already registered for this event.");
            }

            Registration registration = new Registration();
            registration.setStudent(student);
            registration.setEvent(event);
            return registrationRepository.save(registration);
        }
        throw new IllegalArgumentException("Student or Event not found.");
    }

    @Transactional
    public Registration markAttendance(Long registrationId, boolean attended) {
        Optional<Registration> registrationOpt = registrationRepository.findById(registrationId);
        if (registrationOpt.isPresent()) {
            Registration registration = registrationOpt.get();
            registration.setAttended(attended);
            return registrationRepository.save(registration);
        }
        throw new IllegalArgumentException("Registration not found.");
    }

    @Transactional
    public Registration collectFeedback(Long registrationId, int rating) {
        Optional<Registration> registrationOpt = registrationRepository.findById(registrationId);
        if (registrationOpt.isPresent()) {
            Registration registration = registrationOpt.get();
            if (rating < 1 || rating > 5) {
                throw new IllegalArgumentException("Feedback rating must be between 1 and 5.");
            }
            registration.setFeedback(rating);
            return registrationRepository.save(registration);
        }
        throw new IllegalArgumentException("Registration not found.");
    }

    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }
}