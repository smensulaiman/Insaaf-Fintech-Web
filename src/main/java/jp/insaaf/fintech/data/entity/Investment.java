package jp.insaaf.fintech.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_investment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String id;
    @OneToOne
    public User user;
    @OneToOne
    public Project project;
    public double investmentAmount;
    public LocalDate investmentDate;
}
