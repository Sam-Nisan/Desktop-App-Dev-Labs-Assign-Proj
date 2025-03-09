package qa.udst.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import qa.udst.backend.models.Program;
import qa.udst.backend.repositories.ProgramRepository;

@RestController
@RequestMapping("/api/programs")
@CrossOrigin(origins = "*") // For development purposes
public class ProgramController {
    
    @Autowired 
    private ProgramRepository programRepository;
    
    @GetMapping
    public List<Program> getAllPrograms() {
        return programRepository.findAll();
    }
}
