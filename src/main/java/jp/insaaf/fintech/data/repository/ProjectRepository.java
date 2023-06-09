package jp.insaaf.fintech.data.repository;

import jp.insaaf.fintech.data.entity.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {
    // Custom queries can be added here if needed
}