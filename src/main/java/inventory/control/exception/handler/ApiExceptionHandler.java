package inventory.control.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.List;

public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String MSG_ERRO_BEAN_VALIDATION = "Um ou mais campos informados são inválidos. " +
            "Corrija-os e tente novamente.";

    private static final String MSG_ERRO_GENERICO = "Ocorreu um erro inesperado no sistema. " +
            "Tente novamente e, se o problema persistir, entre em contato com o administrador.";

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleValidationException(ex, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleValidationException(ex, headers, status, request);
    }

    private ResponseEntity<Object> handleValidationException(Exception ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ApiError.Field> fields = getFieldsWithError(ex);

        ApiError apiError = ApiError
                .builder()
                .status(status.value())
                .title(MSG_ERRO_BEAN_VALIDATION)
                .type(getErrorDocumentationUrl(request))
                .detail("Preencha os dados que são obrigatórios, e respeite o limite/valor máximo dos caracteres.")
                .fields(fields)
                .build();

        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(ex, apiError, headers, status, request);
    }

    // parei aqui

}
