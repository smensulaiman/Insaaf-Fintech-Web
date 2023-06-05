package jp.insaaf.fintech.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("collection_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private ObjectId id;
    private String userName;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String jpAddress;
    private String bdAddress;
    private String occupation;
}
