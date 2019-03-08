package fr.macbill.backend.services;

import fr.macbill.backend.models.WorkDay;

public interface WorkDayService {

    WorkDay save(WorkDay workDay);

    Iterable<WorkDay> findAll(String userId);

    void delete(String id, String userId);
}
