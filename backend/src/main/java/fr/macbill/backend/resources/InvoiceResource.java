package fr.macbill.backend.resources;

import fr.macbill.backend.models.Invoice;
import fr.macbill.backend.models.Profile;
import fr.macbill.backend.services.CustomerService;
import fr.macbill.backend.services.InvoiceService;
import fr.macbill.backend.services.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@RestController
@RequestMapping("/api")
public class InvoiceResource {

    private final CustomerService customerService;
    private final ProfileService profileService;
    private final InvoiceService invoiceService;

    public InvoiceResource(CustomerService customerService, ProfileService profileService, InvoiceService invoiceService) {
        this.customerService = customerService;
        this.profileService = profileService;
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoice/pdf")
    public void getInvoicePdf(@RequestParam("customerId") String customerId,
                              Principal principal,
                              HttpServletResponse response,
                              @RequestParam("end") Date end,
                              @RequestParam("start") Date start) throws IOException {

        Invoice invoice = new Invoice();
        Profile profile = this.profileService.findByUserId(principal.getName());
        if (profile == null) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Votre profil doit être complété");
        }
        invoice.setCustomer(this.customerService.findById(customerId, principal.getName()));
        invoice.setInvoiceNumber("1234567890");
        invoice.setProfile(profile);
        invoice.setPrincipal(principal);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        invoice.setDate(dateFormat.format(calendar.getTime()));

        String billingNumber = "";

        billingNumber += calendar.get(Calendar.YEAR);
        billingNumber += "-";
        billingNumber += String.format("%02d", calendar.get(Calendar.MONTH) + 1);
        billingNumber += "-";
        billingNumber += "001";
        invoice.setInvoiceNumber(billingNumber);

        this.invoiceService.generateInvoiceFor(invoice, Locale.FRANCE, response.getOutputStream());
        response.getOutputStream().flush();
        response.flushBuffer();
    }
}
