package io.idihia.customBusinessException.exceptions;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.idihia.customBusinessException.enums.ExceptionCode;
import lombok.Getter;
import org.slf4j.helpers.MessageFormatter;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@Getter
@JsonTypeInfo(use = NAME, visible = true, defaultImpl = TechnicalException.class, property = "type")
@JsonSubTypes(value = {@JsonSubTypes.Type(name = "BusinessException", value = BusinessException.class),
        @JsonSubTypes.Type(name = "ForbiddenException", value = ForbiddenException.class),
        @JsonSubTypes.Type(name = "ObjectNotFoundException", value = ObjectNotFoundException.class),
        @JsonSubTypes.Type(name = "TechnicalException", value = TechnicalException.class)})
@JsonAutoDetect(fieldVisibility = NONE, getterVisibility = NONE)
public abstract class ServiceException extends RuntimeException {

    @JsonProperty
    protected final String code;

    @Override
    @JsonProperty
    public String getMessage() {
        return super.getMessage();
    }

    protected ServiceException(String code, String message, Object... args) {
        super(MessageFormatter.arrayFormat(message, args).getMessage());
        this.code = code;
    }

    protected ServiceException(String code, String message, Throwable cause, Object... args) {
        super(MessageFormatter.arrayFormat(message, args).getMessage(), cause);
        this.code = code;
    }

    protected ServiceException(ExceptionCode exceptionCode, Object... args) {
        super(MessageFormatter.arrayFormat(exceptionCode.getMessage(), args).getMessage());
        this.code = exceptionCode.getCode();
    }

    protected ServiceException(ExceptionCode exceptionCode, Throwable cause, Object... args) {
        super(MessageFormatter.arrayFormat(exceptionCode.getMessage(), args).getMessage(), cause);
        this.code = exceptionCode.getCode();
    }

    /**
     * Returns a string representation of the exception. Retourne une représentation sous
     * forme de chaîne de caractères de l'exception.
     */
    @Override
    public String toString() {
        return MessageFormatter.format("[{}]: {}", this.getCode(), this.getMessage()).getMessage();
    }

}
