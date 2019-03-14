package fr.macbill.backend.resources;

import fr.macbill.backend.models.WorkDay;
import fr.macbill.backend.services.WorkDayService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class WorkDayResource {

    private final WorkDayService workDayService;

    public WorkDayResource(WorkDayService workDayService) {
        this.workDayService = workDayService;
    }

    @PostMapping("/workDay")
    public WorkDay createNewWorkDay (@RequestBody WorkDay workDay, Principal principal) {
        workDay.setUserId(principal.getName());
        return this.workDayService.save(workDay);
    }

    @GetMapping(path = "/workDays")
    public Iterable<WorkDay> findAll (Principal principal) {
        return this.workDayService.findAll(principal.getName());
    }

    @DeleteMapping("/workDay/{id}")
    public void delete (@PathVariable(value = "id") String workDayId, Principal principal) {
        this.workDayService.delete(workDayId, principal.getName());
    }
}
