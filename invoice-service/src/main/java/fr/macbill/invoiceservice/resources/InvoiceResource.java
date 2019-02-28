package fr.macbill.invoiceservice.resources;

import fr.macbill.invoiceservice.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InvoiceResource {

    private final CustomerService customerService;

    public InvoiceResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/invoice")
    public String main(Model model, @RequestParam("customerId") String customerId) {
        model.addAttribute("customer", this.customerService.getCustomerById(customerId));
        return "invoice";
    }
}
