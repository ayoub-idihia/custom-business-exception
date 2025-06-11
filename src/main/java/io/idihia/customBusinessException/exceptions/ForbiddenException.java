package io.idihia.customBusinessException.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.idihia.customBusinessException.enums.ExceptionCode;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static org.springframework.http.HttpStatus.FORBIDDEN;


@SuppressWarnings("java:S110")
@ResponseStatus(value = FORBIDDEN)
@JsonAutoDetect(fieldVisibility = NONE, getterVisibility = NONE)
public class ForbiddenException extends BusinessException {

    @JsonCreator
    public ForbiddenException(@JsonProperty("code") String code, @JsonProperty("message") String message, @JsonProperty("args") Object... args) {
        super(code, message, args);
    }

    public ForbiddenException(String code, String message, Throwable cause, Object... args) {
        super(code, message, cause, args);
    }

    public ForbiddenException(ExceptionCode exceptionCode, Object... args) {
        super(exceptionCode, args);
    }

    public ForbiddenException(ExceptionCode exceptionCode, Throwable cause, Object... args) {
        super(exceptionCode, cause, args);
    }
}