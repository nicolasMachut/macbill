package fr.macbill.backend.resources;

import fr.macbill.backend.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api")
public class InvoiceResource {

    private final CustomerService customerService;

    public InvoiceResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/invoice")
    public String main(Model model, @RequestParam("customerId") String customerId) {
        model.addAttribute("customer", this.customerService.findById(customerId, ""));
        return "invoice";
    }
}
