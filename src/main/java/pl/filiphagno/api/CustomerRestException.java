package pl.filiphagno.api;

public class CustomerRestException extends RuntimeException {
    public CustomerRestException(String message) {
        super(message);
    }
}
