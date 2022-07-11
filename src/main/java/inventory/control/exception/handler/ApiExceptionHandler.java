package inventory.control.exception.handler;

import inventory.control.config.ApiError;
import inventory.control.exception.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.persistence.NoResultException;
import java.util.List;

public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String MSG_ERRO_BEAN_VALIDATION = "Um ou mais campos informados são inválidos. " +
            "Corrija-os e tente novamente.";

    private static final String MSG_ERRO_GENERICO = "Ocorreu um erro inesperado no sistema. " +
            "Tente novamente e, se o problema persistir, entre em contato com o administrador.";

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleValidationException(exception, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleValidationException(exception, headers, status, request);
    }

    private ResponseEntity<Object> handleValidationException(Exception exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ApiError.Field> fields = getFieldsWithError(exception);

        ApiError apiError = ApiError
                .builder()
                .status(status.value())
                .title(MSG_ERRO_BEAN_VALIDATION)
                .type(getErrorDocumentationUrl(request))
                .detail("Preencha os dados que são obrigatórios, e respeite o limite/valor máximo dos caracteres.")
                .fields(fields)
                .build();

        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(exception, apiError, headers, status, request);
    }

    @ExceptionHandler(NoResultException.class)
    protected ResponseEntity<Object> handleNoResult(NoResultException exception, WebRequest request) {
        var status = HttpStatus.NOT_FOUND;

        ApiError apiError = ApiError
                .builder()
                .status(status.value())
                .title("Recurso não encontrado.")
                .type(getErrorDocumentationUrl(request))
                .detail(exception.getMessage())
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(exception, apiError, headers, status, request);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    protected ResponseEntity<Object> handleCategory(CategoryNotFoundException exception, WebRequest request) {
        var status = HttpStatus.BAD_REQUEST;

        ApiError apiError = ApiError
                .builder()
                .status(status.value())
                .title("Dados inválidos.")
                .type(getErrorDocumentationUrl(request))
                .detail(exception.getMessage())
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(exception, apiError, headers, status, request);
    }

    @ExceptionHandler(CityNotFoundException.class)
    protected ResponseEntity<Object> handleCity(CityNotFoundException exception, WebRequest request) {
        var status = HttpStatus.BAD_REQUEST;

        ApiError apiError = ApiError
                .builder()
                .status(status.value())
                .title("Dados inválidos.")
                .type(getErrorDocumentationUrl(request))
                .detail(exception.getMessage())
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(exception, apiError, headers, status, request);
    }

    @ExceptionHandler(ConveyorNotFoundException.class)
    protected ResponseEntity<Object> handleConveyor(ConveyorNotFoundException exception, WebRequest request) {
        var status = HttpStatus.BAD_REQUEST;

        ApiError apiError = ApiError
                .builder()
                .status(status.value())
                .title("Dados inválidos.")
                .type(getErrorDocumentationUrl(request))
                .detail(exception.getMessage())
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(exception, apiError, headers, status, request);
    }

    @ExceptionHandler(EntryItemNotFoundException.class)
    protected ResponseEntity<Object> handleEntryItem(EntryItemNotFoundException exception, WebRequest request) {
        var status = HttpStatus.BAD_REQUEST;

        ApiError apiError = ApiError
                .builder()
                .status(status.value())
                .title("Dados inválidos.")
                .type(getErrorDocumentationUrl(request))
                .detail(exception.getMessage())
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(exception, apiError, headers, status, request);
    }

    @ExceptionHandler(ExitNotFoundException.class)
    protected ResponseEntity<Object> handleExit(ExitNotFoundException exception, WebRequest request) {
        var status = HttpStatus.BAD_REQUEST;

        ApiError apiError = ApiError
                .builder()
                .status(status.value())
                .title("Dados inválidos.")
                .type(getErrorDocumentationUrl(request))
                .detail(exception.getMessage())
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(exception, apiError, headers, status, request);
    }

    @ExceptionHandler(OutputItemNotFoundException.class)
    protected ResponseEntity<Object> handleOutputItem(OutputItemNotFoundException exception, WebRequest request) {
        var status = HttpStatus.BAD_REQUEST;

        ApiError apiError = ApiError
                .builder()
                .status(status.value())
                .title("Dados inválidos.")
                .type(getErrorDocumentationUrl(request))
                .detail(exception.getMessage())
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(exception, apiError, headers, status, request);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    protected ResponseEntity<Object> handleProduct(ProductNotFoundException exception, WebRequest request) {
        var status = HttpStatus.BAD_REQUEST;

        ApiError apiError = ApiError
                .builder()
                .status(status.value())
                .title("Dados inválidos.")
                .type(getErrorDocumentationUrl(request))
                .detail(exception.getMessage())
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(exception, apiError, headers, status, request);
    }

    @ExceptionHandler(ProhibitedNotFoundException.class)
    protected ResponseEntity<Object> handleProhibited(ProhibitedNotFoundException exception, WebRequest request) {
        var status = HttpStatus.BAD_REQUEST;

        ApiError apiError = ApiError
                .builder()
                .status(status.value())
                .title("Dados inválidos.")
                .type(getErrorDocumentationUrl(request))
                .detail(exception.getMessage())
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(exception, apiError, headers, status, request);
    }

    @ExceptionHandler(ProviderNotFoundException.class)
    protected ResponseEntity<Object> handleProvider(ProviderNotFoundException exception, WebRequest request) {
        var status = HttpStatus.BAD_REQUEST;

        ApiError apiError = ApiError
                .builder()
                .status(status.value())
                .title("Dados inválidos.")
                .type(getErrorDocumentationUrl(request))
                .detail(exception.getMessage())
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(exception, apiError, headers, status, request);
    }

    @ExceptionHandler(StoreNotFoundException.class)
    protected ResponseEntity<Object> handleStore(StoreNotFoundException exception, WebRequest request) {
        var status = HttpStatus.BAD_REQUEST;

        ApiError apiError = ApiError
                .builder()
                .status(status.value())
                .title("Dados inválidos.")
                .type(getErrorDocumentationUrl(request))
                .detail(exception.getMessage())
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(exception, apiError, headers, status, request);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException exception, WebRequest request) {
        var status = HttpStatus.INTERNAL_SERVER_ERROR;

        ApiError apiError = ApiError
                .builder()
                .status(status.value())
                .title("Erro de integridade de dados")
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(exception, apiError, headers, status, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUncaughtException(Exception exception, WebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        ApiError apiError = ApiError
                .builder()
                .status(status.value())
                .title(MSG_ERRO_GENERICO)
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(exception, apiError, headers, status, request);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRunTimeException(RuntimeException exception, WebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        ApiError apiError = ApiError
                .builder()
                .status(status.value())
                .title(MSG_ERRO_GENERICO)
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(exception, apiError, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception exception, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError apiError = ApiError
                .builder()
                .status(status.value())
                .title(status.getReasonPhrase())
                .build();

        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON);

        return super.handleExceptionInternal(exception, apiError, headers, status, request);
    }

    private List<ApiError.Field> getFieldsWithError(Exception exception) {
        return ((MethodArgumentNotValidException) exception)
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> ApiError
                        .Field
                        .builder()
                        .name(fieldError.getField())
                        .message(fieldError.getDefaultMessage())
                        .build())
                .toList();
    }

    private String getErrorDocumentationUrl(WebRequest request) {
        var servletRequest = ((ServletWebRequest) request).getRequest();
        var requestUrl = servletRequest.getRequestURL().toString();
        var requestUri = servletRequest.getRequestURI();
        var contextPath = servletRequest.getContextPath();
        var documentationUri = contextPath + "/documentation";

        return requestUrl.replace(requestUri, documentationUri);
    }

}
