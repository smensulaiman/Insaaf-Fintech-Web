package jp.insaaf.fintech.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_expense")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @OneToOne
    public Project project;
    public double expenseAmount;
    public LocalDate expenseDate;
    @Column(name = "expense_type")
    private String expenseType;
}
