package fr.macbill.workdayservice.services;

import fr.macbill.workdayservice.models.WorkDay;

import java.util.Optional;

public interface WorkDayService {

    WorkDay save(WorkDay workDay);

    Iterable<WorkDay> findAll(String userId);

    void delete(String id, String userId);
}
