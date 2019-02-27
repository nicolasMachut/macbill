package fr.macbill.gateway.documents;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class ApplicationUser {
    @Id
    private String id;
    private String username;
    private String password;
}
