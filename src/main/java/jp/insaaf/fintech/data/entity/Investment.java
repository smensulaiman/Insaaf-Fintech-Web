package jp.insaaf.fintech.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("collection_investment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Investment {
    @Id
    public String id;
    @DBRef
    public User user;
    @DBRef
    public Project project;
    public double investmentAmount;
    public LocalDate investmentDate;
}
