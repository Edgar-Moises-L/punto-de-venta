package punto_de_venta.exceptions.domain;

public class MissingServletRequestParameterException extends RuntimeException {
    public MissingServletRequestParameterException(String message) {
        super(message);
    }
}
