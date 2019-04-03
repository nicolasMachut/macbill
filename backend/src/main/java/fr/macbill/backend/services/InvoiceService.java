package fr.macbill.backend.services;

import fr.macbill.backend.models.Invoice;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.Locale;

public interface InvoiceService {
    public void generateInvoiceFor(Invoice invoice, Locale locale, ServletOutputStream outputStream) throws IOException;
}
