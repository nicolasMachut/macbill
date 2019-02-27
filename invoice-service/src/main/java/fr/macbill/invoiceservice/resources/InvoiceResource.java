package fr.macbill.invoiceservice.resources;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InvoiceResource {

    @GetMapping("/invoice")
    public String main(Model model) {
        return "invoice";
    }
}
