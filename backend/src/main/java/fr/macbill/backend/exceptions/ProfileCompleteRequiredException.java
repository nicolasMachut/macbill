package fr.macbill.backend.exceptions;

public class ProfileCompleteRequiredException extends MacBillException {
    public ProfileCompleteRequiredException() {
        super("Votre profil doit être complété avant d'effectuer cette action");
    }
}
