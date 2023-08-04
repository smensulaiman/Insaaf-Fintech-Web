package jp.insaaf.fintech.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tbl_project")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String projectName;
    private String description;
    private String image;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    @OneToMany
    @JoinColumn(name = "id")
    private List<User> members;
    private double profit;
    private double profitPercentage;
}
