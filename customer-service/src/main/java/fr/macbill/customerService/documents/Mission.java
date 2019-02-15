package fr.macbill.customerService.documents;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "missions")
@Data
public class Mission {

    @Id
    private String id;

    private Customer customer;
}
