package punto_de_venta.exceptions.infrastructure;

import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import punto_de_venta.exceptions.domain.DuplicateResourceException;
import punto_de_venta.exceptions.domain.MethodArgumentTypeMismatchException;
import punto_de_venta.exceptions.domain.MissingServletRequestParameterException;
import punto_de_venta.exceptions.domain.ResoursceNotFoundException;

import java.time.Instant;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    //400
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException e, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
                "El cuerpo de la petición (JSON) tiene un formato incorrecto o faltan valores requeridos.");
        problemDetail.setTitle("Error de lectura de JSON");
        addCommonProperties(problemDetail);

        return ResponseEntity.status(status).body(problemDetail);
    }

    //400
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> fieldErrors = e.getBindingResult().getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        error -> error.getField(),
                        error -> error.getDefaultMessage(),
                        (existingValue, newValue) -> existingValue
                ));


        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST, "Se encontraron errores de validación en la solicitud."
        );
        problemDetail.setTitle("Error de validación de datos");
        problemDetail.setProperty("invalid_params", fieldErrors);
        addCommonProperties(problemDetail);

        return ResponseEntity.status(status).body(problemDetail);
    }

    //400
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ProblemDetail handleTypeMismatch(MethodArgumentTypeMismatchException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
        problemDetail.setTitle("El parametro introducido en la URL es invalido");
        addCommonProperties(problemDetail);
        return problemDetail;
    }

    //400
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ProblemDetail handleMissingParameter(MissingServletRequestParameterException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
        problemDetail.setTitle("El parametro requerido no esta presente");
        addCommonProperties(problemDetail);
        return problemDetail;
    }

    //404
    @ExceptionHandler(ResoursceNotFoundException.class)
    public ProblemDetail handleResoursceNotFoundException(ResoursceNotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Recurso no encontrado");
        addCommonProperties(problemDetail);
        return problemDetail;
    }

    //409
    @ExceptionHandler(DuplicateResourceException.class)
    public ProblemDetail handleDuplicateResourceException(DuplicateResourceException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, e.getMessage());
        problemDetail.setTitle("Conflicto de duplicidad");
        addCommonProperties(problemDetail);

        return problemDetail;
    }

    //500
    @ExceptionHandler(Exception.class)
    public ProblemDetail handleGlobalException(Exception e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrió un error interno inesperado");
        problemDetail.setTitle("Error interno del servidor");
        addCommonProperties(problemDetail);

        return problemDetail;
    }

    private void addCommonProperties(ProblemDetail problemDetail) {
        problemDetail.setProperty("timestamp", Instant.now());
    }
}
