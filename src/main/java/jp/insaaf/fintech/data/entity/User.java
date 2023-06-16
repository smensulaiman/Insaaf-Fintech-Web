package jp.insaaf.fintech.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("collection_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String email;
    private String password;
    private String phone;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String occupation;
    private String dateOfBirth;
    private Long dateOfBirthInMillis;
    @Transient
    private Address jpAddress;
    @Transient
    private Address bdAddress;
    private boolean isActivated;
    private boolean isInvestmentEnabled;
    private boolean isDepositEnabled;
    @Transient
    private String comment;
    private String imageUrl;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

}
