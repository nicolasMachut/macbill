package fr.macbill.backend.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Document(collection = "profiles")
@Data
public class Profile {

    @Id
    private String id;

    @NotNull
    private String user;

    @Valid
    private Address address;

    @NotEmpty
    private String siret;

    @NotEmpty
    private String tvaIntracom;

    @NotEmpty
    private String owner;

    @NotEmpty
    private String iban;

    @NotEmpty
    private String bic;
}
