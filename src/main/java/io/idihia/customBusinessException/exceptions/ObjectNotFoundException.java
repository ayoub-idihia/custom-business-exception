package io.idihia.customBusinessException.exceptions;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.idihia.customBusinessException.enums.ExceptionCode;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static org.springframework.http.HttpStatus.NOT_FOUND;


@ResponseStatus(value = NOT_FOUND)
@JsonAutoDetect(fieldVisibility = NONE, getterVisibility = NONE)
public class ObjectNotFoundException extends BusinessException {

    @JsonCreator
    public ObjectNotFoundException(@JsonProperty("code") String code, @JsonProperty("message") String message, @JsonProperty("args") Object... args) {
        super(code, message, args);
    }

    public ObjectNotFoundException(String code, String message, Throwable cause, Object... args) {
        super(code, message, cause, args);
    }

    public ObjectNotFoundException(ExceptionCode exceptionCode, Object... args) {
        super(exceptionCode, args);
    }

    public ObjectNotFoundException(ExceptionCode exceptionCode, Throwable cause, Object... args) {
        super(exceptionCode, cause, args);
    }
}