package fr.macbill.backend.repositories;

import fr.macbill.backend.models.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, String> {
    Profile findFirstByUser (String user);
}
