package jp.insaaf.fintech.data.repository;

import jp.insaaf.fintech.data.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
    // Custom queries can be added here if needed
}