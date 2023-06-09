package jp.insaaf.fintech.data.repository;

import jp.insaaf.fintech.data.entity.Investment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentRepository extends MongoRepository<Investment, String> {
    // Custom queries can be added here if needed
}
