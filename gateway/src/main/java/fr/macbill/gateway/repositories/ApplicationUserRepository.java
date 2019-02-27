package fr.macbill.gateway.repositories;

import fr.macbill.gateway.documents.ApplicationUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends MongoRepository<ApplicationUser, String> {

    ApplicationUser findByUsername(String username);
}
