package jp.insaaf.fintech.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_remittance")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Remittance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @OneToOne
    private User user;
    private Double amount;
    private String fromCountry;
    private String toCountry;
    private LocalDateTime remitDate;
}
