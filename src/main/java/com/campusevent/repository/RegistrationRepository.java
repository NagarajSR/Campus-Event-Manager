package com.campusevent.repository;

import com.campusevent.entity.Registration;
import com.campusevent.entity.Student;
import com.campusevent.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    long countByEvent(Event event);
    /**
     * Finds a registration by a specific student and event.
     * Spring Data JPA will automatically generate the query based on the method name.
     * @param student The student entity.
     * @param event The event entity.
     * @return The registration for the given student and event, or null if not found.
     */
    Registration findByStudentAndEvent(Student student, Event event);
}