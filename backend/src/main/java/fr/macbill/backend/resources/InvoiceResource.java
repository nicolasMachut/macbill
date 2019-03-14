package fr.macbill.backend.resources;

import fr.macbill.backend.services.CustomerService;
import fr.macbill.backend.services.ProfileService;
import fr.macbill.backend.services.WorkDayService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/api")
public class InvoiceResource {

    private final CustomerService customerService;
    private final WorkDayService  workDayService;
    private final ProfileService profileService;

    public InvoiceResource(CustomerService customerService, WorkDayService workDayService, ProfileService profileService) {
        this.customerService = customerService;
        this.workDayService = workDayService;
        this.profileService = profileService;
    }

    @GetMapping("/invoice")
    public String main(Model model,
                       @RequestParam("customerId") String customerId,
                       Principal principal,
                       @RequestParam("end") Date end,
                       @RequestParam("start") Date start) {

        model.addAttribute("customer", this.customerService.findById(customerId, principal.getName()));
        model.addAttribute("workDays", this.workDayService.findAllByCustomerId(principal.getName(), customerId, start, end));
        model.addAttribute("profile", this.profileService.findByUserId(principal.getName()));
        model.addAttribute("principal", principal);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();

        model.addAttribute("billingDate", dateFormat.format(calendar.getTime()));
        String billingNumber = "";

        billingNumber += calendar.get(Calendar.YEAR);
        billingNumber += "-";
        billingNumber += calendar.get(Calendar.MONTH) + 1;
        billingNumber += "-";
        billingNumber += "001";
        model.addAttribute("billingNumber", billingNumber);


        return "invoiceTemplate";
    }
}
