package com.campusevent.controller;

import com.campusevent.entity.College;
import com.campusevent.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/colleges")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @PostMapping
    public College createCollege(@RequestBody College college) {
        return collegeService.createCollege(college);
    }

    @GetMapping
    public List<College> getAllColleges() {
        return collegeService.getAllColleges();
    }
}
