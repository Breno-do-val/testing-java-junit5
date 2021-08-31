package guru.springframework.sfgpetclinic.controllers.exceptions;

public class OupsHandlerWithNoArgumentException extends RuntimeException {

    public OupsHandlerWithNoArgumentException(String msg) {
        super(msg);
    }
}
