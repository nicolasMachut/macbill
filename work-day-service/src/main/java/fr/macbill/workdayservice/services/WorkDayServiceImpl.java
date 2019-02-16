package fr.macbill.workdayservice.services;

import fr.macbill.workdayservice.models.WorkDay;
import fr.macbill.workdayservice.repositories.WorkDayRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WorkDayServiceImpl implements WorkDayService {

    private final WorkDayRepository workDayRepository;

    public WorkDayServiceImpl(WorkDayRepository workDayRepository) {
        this.workDayRepository = workDayRepository;
    }

    @Override
    public Mono<WorkDay> save(WorkDay workDay) {
        return this.workDayRepository.save(workDay);
    }

    @Override
    public Flux<WorkDay> findAll() {
        return this.workDayRepository.findAll();
    }

    @Override
    public Mono<WorkDay> findById(String workDayId) {
        return this.workDayRepository.findById(workDayId);
    }

    @Override
    public Mono<Void> delete(WorkDay workDay) {
        return this.workDayRepository.delete(workDay);
    }
}
