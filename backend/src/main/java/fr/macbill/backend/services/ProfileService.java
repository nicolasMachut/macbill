package fr.macbill.backend.services;

import fr.macbill.backend.models.Profile;

public interface ProfileService {
    Profile findByUserId(String user);
    Profile updateProfile(Profile profile, String user);
}
