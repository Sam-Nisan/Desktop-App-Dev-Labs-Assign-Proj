package qa.udst.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import qa.udst.backend.models.CCIT;
import qa.udst.backend.repositories.CCITRepository;

@RestController
@RequestMapping("/api/ccit")
@RequiredArgsConstructor
public class CCITController {
    
    private final CCITRepository ccitRepository;
    
    @GetMapping
    public ResponseEntity<List<CCIT>> getAllCCIT() {
        List<CCIT> ccits = ccitRepository.findAll();
        return new ResponseEntity<>(ccits, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CCIT> getCCITById(@PathVariable Long id) {
        Optional<CCIT> ccit = ccitRepository.findById(id);
        
        return ccit.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
