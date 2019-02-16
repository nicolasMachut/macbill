package fr.macbill.workdayservice.resources;

import fr.macbill.workdayservice.models.WorkDay;
import fr.macbill.workdayservice.services.WorkDayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
public class WorkDayResource {

    private final WorkDayService workDayService;

    public WorkDayResource(WorkDayService workDayService) {
        this.workDayService = workDayService;
    }

    @PostMapping("/workDay")
    public Mono<WorkDay> createNewWorkDay (@RequestBody WorkDay workDay) {
        return this.workDayService.save(workDay);
    }

    @GetMapping(path = "/workDays")
    public Flux<WorkDay> findAll () {
        return this.workDayService.findAll();
    }

    @DeleteMapping("/workDay/{id}")
    public Mono<ResponseEntity<Void>> delete (@PathVariable(value = "id") String workDayId) {
        return this.workDayService.findById(workDayId)
                .flatMap(existingWorkDay ->
                        workDayService.delete(existingWorkDay)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
