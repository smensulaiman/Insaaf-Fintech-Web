package jp.insaaf.fintech.data.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String street;
    private String prefecture;
    private String city;
    private String district;
    private String policeStation;
    private String zip;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
