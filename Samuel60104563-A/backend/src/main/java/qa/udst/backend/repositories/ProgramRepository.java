package qa.udst.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qa.udst.backend.models.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {
    
}
