package fr.macbill.CustomerService.documents;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Document(collection = "addresses")
@Data
public class Address {

    @Id
    private ObjectId _id;

    @NotEmpty
    private String streetNumber;

    @NotEmpty
    private String route;

    private String route2;

    @NotEmpty
    private String postalCode;

    @NotEmpty
    private String city;

    @NotEmpty
    private String companyType;
}
