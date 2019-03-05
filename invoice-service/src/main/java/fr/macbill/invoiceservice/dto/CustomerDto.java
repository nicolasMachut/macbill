package fr.macbill.invoiceservice.dto;

import lombok.Data;

@Data
public class CustomerDto {

    private String id;
    private String name;
    private AddressDto address;
    private String companyType;
}
