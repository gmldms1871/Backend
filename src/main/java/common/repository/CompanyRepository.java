package common.repository;

import common.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, String> {
    Optional<Company> findByEmail(String email);
    Optional<Company> findByEmailAndPassword(String email, String password);
    List<Company> findAllByOrderByLikesDesc();
}

