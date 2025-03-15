package qa.udst.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qa.udst.backend.models.Program;
import qa.udst.backend.repositories.ProgramRepository;

import java.util.List;

@RestController
@RequestMapping("/api/programs")
@RequiredArgsConstructor
public class ProgramController {
    
    private final ProgramRepository programRepository;
    
    @GetMapping
    public List<Program> getAllPrograms() {
        return programRepository.findAll();
    }
}
