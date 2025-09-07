// 1. CollegeRepository
package com.campusevent.repository;
import com.campusevent.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CollegeRepository extends JpaRepository<College, Long> {}
