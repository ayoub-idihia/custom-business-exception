package io.idihia.customBusinessException.exceptions;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.idihia.customBusinessException.enums.ExceptionCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(value = BAD_REQUEST)
@JsonAutoDetect(fieldVisibility = NONE, getterVisibility = NONE)
public class BusinessException extends ServiceException {

    @JsonCreator
    public BusinessException(@JsonProperty("code") String code, @JsonProperty("message") String message, @JsonProperty("args") Object... args) {
        super(code, message, args);
    }

    public BusinessException(String code, String message, Throwable cause, Object... args) {
        super(code, message, cause, args);
    }

    public BusinessException(ExceptionCode exceptionCode, Object... args) {
        super(exceptionCode, args);
    }

    public BusinessException(ExceptionCode exceptionCode, Throwable cause, Object... args) {
        super(exceptionCode, cause, args);
    }

}
