package fr.macbill.backend.services;

import fr.macbill.backend.models.WorkDay;

import java.util.Date;

public interface WorkDayService {

    WorkDay save(WorkDay workDay);

    Iterable<WorkDay> findAll(String userId);

    void delete(String id, String userId);

    Iterable<WorkDay> findAllByCustomerId(String userId, String customerId, Date start, Date end);
}
