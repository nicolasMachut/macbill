package fr.macbill.backend.services;

import fr.macbill.backend.models.WorkDay;
import fr.macbill.backend.repositories.WorkDayRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkDayServiceImpl implements WorkDayService {

    private final WorkDayRepository workDayRepository;

    public WorkDayServiceImpl(WorkDayRepository workDayRepository) {
        this.workDayRepository = workDayRepository;
    }

    @Override
    public WorkDay save(WorkDay workDay) {
        return this.workDayRepository.save(workDay);
    }

    @Override
    public Iterable<WorkDay> findAll(String userId) {
        return this.workDayRepository.findAllByUserId(userId);
    }

    @Override
    public void delete(String id, String userId) {
        this.workDayRepository.deleteByIdAndUserId(id, userId);
    }
}
