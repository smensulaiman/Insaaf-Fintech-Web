package jp.insaaf.fintech.data.repository;

import jp.insaaf.fintech.data.entity.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, String> {
    // Custom queries can be added here if needed
}
