package fr.macbill.backend.repositories;

import fr.macbill.backend.models.WorkDay;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkDayRepository extends CrudRepository<WorkDay, String> {
    Iterable<WorkDay> findAllByUserId(String userId);
    void deleteByIdAndUserId(String id, String userId);
}
