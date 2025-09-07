package com.campusevent.repository;
import com.campusevent.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EventRepository extends JpaRepository<Event, Long> {}