package com.ceub.pi.effycityservice.config.handler;

import com.ceub.pi.effycityservice.exception.AreaTematicaNotFoundException;
import com.ceub.pi.effycityservice.exception.EstadoNotFoundException;
import com.ceub.pi.effycityservice.exception.MunicipioNotFoundException;
import com.ceub.pi.effycityservice.exception.NecessidadeGestorNotFoundException;
import com.ceub.pi.effycityservice.exception.ProjectNotFoundException;
import com.ceub.pi.effycityservice.exception.UsuarioEmpresaNotFoundException;
import com.ceub.pi.effycityservice.exception.UsuarioGestorNotFoundException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.PropertyBindingException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

/**
 * General exception call
 * @param ex Exception
 * @param body Body return
 * @param headers Header return
 * @param status Status return
 * @param request Request
 * @return ResponseEntity<ApiError>
 */

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UsuarioGestorNotFoundException.class)
    public ResponseEntity<?> handleUsuarioGestorNotFoundException(UsuarioGestorNotFoundException ex, WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ProblemType problemType = ProblemType.ENTITY_NOT_FOUND;
        String message = ex.getMessage();
        ApiError apiError = createProblemBuilder(status, problemType, message).build();
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), status, request);
    }
    @ExceptionHandler(ProjectNotFoundException.class)
    public ResponseEntity<?> handleProjectNotFoundException(ProjectNotFoundException ex, WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ProblemType problemType = ProblemType.ENTITY_NOT_FOUND;
        String message = ex.getMessage();
        ApiError apiError = createProblemBuilder(status, problemType, message).build();
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), status, request);
    }
    @ExceptionHandler(MunicipioNotFoundException.class)
    public ResponseEntity<?> handleMunicipioNotFoundException(MunicipioNotFoundException ex, WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ProblemType problemType = ProblemType.ENTITY_NOT_FOUND;
        String message = ex.getMessage();
        ApiError apiError = createProblemBuilder(status, problemType, message).build();
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), status, request);
    }
    @ExceptionHandler(EstadoNotFoundException.class)
    public ResponseEntity<?> handleEstadoNotFoundException(EstadoNotFoundException ex, WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ProblemType problemType = ProblemType.ENTITY_NOT_FOUND;
        String message = ex.getMessage();
        ApiError apiError = createProblemBuilder(status, problemType, message).build();
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), status, request);
    }
    @ExceptionHandler(UsuarioEmpresaNotFoundException.class)
    public ResponseEntity<?> handleUsuarioEmpresaNotFoundException(UsuarioEmpresaNotFoundException ex, WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ProblemType problemType = ProblemType.ENTITY_NOT_FOUND;
        String message = ex.getMessage();
        ApiError apiError = createProblemBuilder(status, problemType, message).build();
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), status, request);
    }
    @ExceptionHandler(NecessidadeGestorNotFoundException.class)
    public ResponseEntity<?> handleNecessidadeGestorNotFoundException(NecessidadeGestorNotFoundException ex, WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ProblemType problemType = ProblemType.ENTITY_NOT_FOUND;
        String message = ex.getMessage();
        ApiError apiError = createProblemBuilder(status, problemType, message).build();
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), status, request);
    }
    @ExceptionHandler(AreaTematicaNotFoundException.class)
    public ResponseEntity<?> handleAreaTematicaNotFoundException(AreaTematicaNotFoundException ex, WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ProblemType problemType = ProblemType.ENTITY_NOT_FOUND;
        String message = ex.getMessage();
        ApiError apiError = createProblemBuilder(status, problemType, message).build();
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), status, request);
    }

    /**
     * ApiError default constructor
     * @param status Status
     * @param problemType Problem Type
     * @param detail Detail of Problem
     * @return ApiError
     */
    private ApiError.ApiErrorBuilder createProblemBuilder (HttpStatus status, ProblemType problemType, String detail) {
        return ApiError.builder()
                .status(status.value())
                .type(problemType.getUri())
                .title(problemType.getTitle())
                .detail(detail);
    }

    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (body == null){
            body = ApiError.builder()
                    .title(status.getReasonPhrase())
                    .status(status.value())
                    .build();
        }
        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    private ResponseEntity<Object> handlePropertyBidingException(PropertyBindingException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String path = ex.getPath().stream()
                .map(ref -> ref.getFieldName())
                .collect(Collectors.joining("."));

        ProblemType problemType = ProblemType.NOT_READABLE;
        String detail = String.format("A propriedade '%s' informada, não existe. ", path);
        ApiError apiError = createProblemBuilder(status, problemType, detail).build();
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), status, request);
    }

    private ResponseEntity<Object> handleInvalidFormatException(InvalidFormatException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String path = ex.getPath().stream()
                .map(ref -> ref.getFieldName())
                .collect(Collectors.joining("."));

        ProblemType problemType = ProblemType.NOT_READABLE;
        String detail = String.format("A propriedade '%s' recebeu o valor '%s' " +
                        "que é de um tipo inválido. Corrija e informe um valor compatível com o tipo '%s'.",
                path, ex.getValue(), ex.getTargetType().getSimpleName());
        ApiError apiError = createProblemBuilder(status, problemType, detail).build();
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), status, request);
    }

    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Throwable rootCause = ExceptionUtils.getRootCause(ex);
        if (rootCause instanceof InvalidFormatException) {
            return handleInvalidFormatException((InvalidFormatException) rootCause, headers, status, request);
        } else if ( rootCause instanceof PropertyBindingException) {
            return handlePropertyBidingException((PropertyBindingException) rootCause, headers, status, request);
        }

        ProblemType problemType = ProblemType.NOT_READABLE;
        String detail = "O corpo da requisição está inválido. Verifique erro de sintaxe.";
        ApiError apiError = createProblemBuilder(status, problemType, detail).build();
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), status, request);
    }
}
