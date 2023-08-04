package jp.insaaf.fintech.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String password;
    private String phone;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String occupation;

    private LocalDate dateOfBirth;

    @OneToOne
    private Address jpAddress;

    @OneToOne
    private Address bdAddress;

    private boolean isActivated;
    private boolean isInvestmentEnabled;
    private boolean isDepositEnabled;
    private String comment;
    private String imageUrl;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

