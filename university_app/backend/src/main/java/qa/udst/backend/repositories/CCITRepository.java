package qa.udst.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qa.udst.backend.models.CCIT;

@Repository
public interface CCITRepository extends JpaRepository<CCIT, Long> {
    
}
