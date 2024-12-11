package mk.ukim.finki.lab.repository;

import jakarta.persistence.Entity;
import mk.ukim.finki.lab.model.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevivewsRepository extends JpaRepository<Reviews,Long> {
}
