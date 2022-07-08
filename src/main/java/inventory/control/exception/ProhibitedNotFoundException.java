package inventory.control.exception;

public class ProhibitedNotFoundException extends RuntimeException {

    public ProhibitedNotFoundException(String message) {
        super(message);
    }

}
