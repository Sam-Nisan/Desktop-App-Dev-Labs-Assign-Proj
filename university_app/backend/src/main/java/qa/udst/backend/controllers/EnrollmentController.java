package qa.udst.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qa.udst.backend.models.Enrollment;
import qa.udst.backend.repositories.EnrollmentRepository;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
    
    @Autowired 
    private EnrollmentRepository repository;
    
    @PostMapping
    public Enrollment enroll(@RequestBody Enrollment enrollment) {
        return repository.save(enrollment);
    }
    
    @GetMapping
    public Iterable<Enrollment> getAllEnrollments() {
        return repository.findAll();
    }
    
    @GetMapping("/{id}")
    public Enrollment getEnrollment(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found with id: " + id));
    }
}
