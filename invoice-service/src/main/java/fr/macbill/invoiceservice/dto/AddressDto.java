package fr.macbill.invoiceservice.dto;

import lombok.Data;

@Data
public class AddressDto {

    private String id;
    private String streetNumber;
    private String route;
    private String route2;
    private String postalCode;
    private String city;
}
