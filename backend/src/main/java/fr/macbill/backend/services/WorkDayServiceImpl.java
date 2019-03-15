package fr.macbill.backend.services;

import fr.macbill.backend.models.WorkDay;
import fr.macbill.backend.repositories.WorkDayRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

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
    public List<WorkDay> findAll(String userId) {
        return this.workDayRepository.findAllByUserId(userId);
    }

    @Override
    public void delete(String id, String userId) {
        this.workDayRepository.deleteByIdAndUserId(id, userId);
    }

    @Override
    public List<WorkDay> findAllByCustomerId(String userId, String customerId, Date start, Date end) {
        return this.workDayRepository.findAllByUserIdAndCustomerIdAndStartAfterAndEndBefore(userId, customerId, start, end);
    }

    @Override
    public WorkDay findLastWorkDayForCustomer(String customerId, String userId) {
        return this.workDayRepository.findTopByUserIdAndCustomerIdOrderByStartDesc(userId, customerId);
    }
}
