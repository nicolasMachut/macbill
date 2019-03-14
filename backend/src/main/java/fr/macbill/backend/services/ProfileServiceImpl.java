package fr.macbill.backend.services;

import fr.macbill.backend.models.Profile;
import fr.macbill.backend.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile findByUserId(String user) {
        return this.profileRepository.findFirstByUser(user);
    }

    @Override
    public Profile updateProfile(Profile profile, String user) {
        profile.setUser(user);
        return this.profileRepository.save(profile);
    }
}
