package jp.insaaf.fintech.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_permission_to_service")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionToService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    private boolean isActivated;
    private boolean isDepositEnabled;
    private boolean isInvestmentEnabled;
    private boolean isRemitEnabled;
    private boolean isEcomEnabled;
    private LocalDateTime activateDate;
    private LocalDateTime depositeDate;
    private LocalDateTime investmentDate;
    private LocalDateTime remitDate;
    private LocalDateTime ecomDate;
}
