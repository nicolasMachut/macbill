package fr.macbill.workdayservice.services;

import fr.macbill.workdayservice.models.WorkDay;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WorkDayService {

    Mono<WorkDay> save(WorkDay workDay);

    Flux<WorkDay> findAll();

    Mono<WorkDay> findById(String workDayId);

    Mono<Void> delete(WorkDay workDay);
}
