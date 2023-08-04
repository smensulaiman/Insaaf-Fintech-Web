package jp.insaaf.fintech.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    private String comment;
    private String imageUrl;
    private String residentCardImage;
    private String passportImage;
    @OneToMany
    private List<Deposit> deposits;
    private double balance;
    @OneToOne
    private User ref;
    @OneToMany
    @JoinColumn(name = "id")
    private List<Project> projects;
    @OneToOne
    private Nominee nominee;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

