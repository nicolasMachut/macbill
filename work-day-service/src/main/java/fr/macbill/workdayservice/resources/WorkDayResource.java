package fr.macbill.workdayservice.resources;

import fr.macbill.workdayservice.models.WorkDay;
import fr.macbill.workdayservice.services.WorkDayService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@RestController
public class WorkDayResource {

    private final WorkDayService workDayService;

    public WorkDayResource(WorkDayService workDayService) {
        this.workDayService = workDayService;
    }

    @PostMapping("/workDay")
    public WorkDay createNewWorkDay (@RequestBody WorkDay workDay, Principal principal) {
        String userId = getUserId((OAuth2Authentication) principal);
        workDay.setUserId(userId);
        return this.workDayService.save(workDay);
    }

    @GetMapping(path = "/workDays")
    public Iterable<WorkDay> findAll (Principal principal) {
        String userId = getUserId((OAuth2Authentication) principal);
        return this.workDayService.findAll(userId);
    }

    @DeleteMapping("/workDay/{id}")
    public void delete (@PathVariable(value = "id") String workDayId, Principal principal) {
        String userId = getUserId((OAuth2Authentication) principal);
        this.workDayService.delete(workDayId, userId);
    }

    private String getUserId(OAuth2Authentication principal) {
        OAuth2Authentication authentication = principal;
        Map<String, String> user = (Map<String, String>) authentication.getUserAuthentication().getDetails();
        return user.get("sub");
    }
}
