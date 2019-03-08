package fr.macbill.backend.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Document(collection = "customers")
@Data
public class Customer {

    @Id
    private String id;

    @NotEmpty
    private String name;

    @NotNull
    @Valid
    private Address address;

    @NotEmpty
    private String companyType;

    private String userId;
}
