package fr.macbill.backend.models;

import lombok.Data;

import java.security.Principal;

@Data
public class Invoice {
    private  String invoiceNumber;
    private Customer customer;
    private Profile profile;
    private Principal principal;
    private String date;
}
