package jp.insaaf.fintech.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("collection_address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    private String id;
    private String street;
    private String prefecture;
    private String city;
    private String district;
    private String policeStation;
    private String zip;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
