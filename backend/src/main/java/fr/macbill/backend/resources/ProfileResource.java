package fr.macbill.backend.resources;

import fr.macbill.backend.models.Profile;
import fr.macbill.backend.services.ProfileService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/profile")
public class ProfileResource {

    private final ProfileService profileService;

    public ProfileResource(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public Profile getProfile (Principal principal) {
        return this.profileService.findByUserId(principal.getName());
    }

    @PutMapping
    public Profile updateProfile (@RequestBody Profile profile, Principal principal) {
        return this.profileService.updateProfile(profile, principal.getName());
    }
}
