package punto_de_venta.exceptions.domain;

public class MethodArgumentTypeMismatchException extends RuntimeException {
    public MethodArgumentTypeMismatchException(String message) {
        super(message);
    }
}
