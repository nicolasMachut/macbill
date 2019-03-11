package fr.macbill.backend.resources;

import fr.macbill.backend.services.CustomerService;
import fr.macbill.backend.services.WorkDayService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class InvoiceResource {

    private final CustomerService customerService;
    private final WorkDayService  workDayService;

    public InvoiceResource(CustomerService customerService, WorkDayService workDayService) {
        this.customerService = customerService;
        this.workDayService = workDayService;
    }

    @GetMapping("/invoice")
    public String main(Model model, @RequestParam("customerId") String customerId, Principal principal) {
        String userId = getUserId((OAuth2Authentication) principal);
        model.addAttribute("customer", this.customerService.findById(customerId, userId).get());
        model.addAttribute("workDays", this.workDayService.findAll(userId));
        return "invoiceTemplate";
    }

    private String getUserId(OAuth2Authentication principal) {
        OAuth2Authentication authentication = principal;
        Map<String, String> user = (Map<String, String>) authentication.getUserAuthentication().getDetails();
        return user.get("sub");
    }
}
