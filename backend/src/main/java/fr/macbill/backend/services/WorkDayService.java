package fr.macbill.backend.services;

import fr.macbill.backend.models.WorkDay;

import java.util.Date;
import java.util.List;

public interface WorkDayService {

    WorkDay save(WorkDay workDay);

    List<WorkDay> findAll(String userId);

    void delete(String id, String userId);

    List<WorkDay> findAllByCustomerId(String userId, String customerId, Date start, Date end);

    WorkDay findLastWorkDayForCustomer(String customerId, String userId);
}
