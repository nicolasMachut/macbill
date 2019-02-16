package fr.macbill.workdayservice.repositories;

import fr.macbill.workdayservice.models.WorkDay;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkDayRepository extends ReactiveMongoRepository<WorkDay, String> {
}
