package fr.macbill.backend.repositories;

import fr.macbill.backend.models.WorkDay;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Repository
public interface WorkDayRepository extends CrudRepository<WorkDay, String> {
    List<WorkDay> findAllByUserId(String userId);
    void deleteByIdAndUserId(String id, String userId);
    List<WorkDay> findAllByUserIdAndCustomerIdAndStartAfterAndEndBefore(String userId, String customerId, Date start, Date end);
    WorkDay findTopByUserIdAndCustomerIdOrderByStartDesc (String userId, String customerId);
}
