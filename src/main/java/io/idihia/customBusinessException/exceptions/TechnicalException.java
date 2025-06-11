package io.idihia.customBusinessException.exceptions;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.idihia.customBusinessException.enums.ExceptionCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.management.ManagementFactory;
import java.security.SecureRandom;
import java.text.MessageFormat;
import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Getter
@ResponseStatus(value = INTERNAL_SERVER_ERROR)
@JsonAutoDetect(fieldVisibility = NONE, getterVisibility = NONE)
public class TechnicalException extends ServiceException {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    private static final String NODE_ID;

    static {
        String tempNodeId;
        try {
            tempNodeId = ManagementFactory.getRuntimeMXBean().getName();
        } catch (final Exception t) {
            tempNodeId = "?";
        }
        NODE_ID = tempNodeId;
    }

    @JsonProperty
    @Setter
    private String reportId;

    @JsonCreator
    public TechnicalException(@JsonProperty("code") String code, @JsonProperty("message") String message, @JsonProperty("args") Object... args) {
        super(code, message, args);
        this.reportId = genReportId();
    }

    public TechnicalException(String code, String message, Throwable cause, Object... args) {
        super(code, message, cause, args);
        this.reportId = genReportId();
    }

    public TechnicalException(ExceptionCode exceptionCode, Object... args) {
        super(exceptionCode, args);
        this.reportId = genReportId();
    }

    public TechnicalException(ExceptionCode exceptionCode, Throwable cause, Object... args) {
        super(exceptionCode, cause, args);
        this.reportId = genReportId();
    }

    private String genReportId() {
        return MessageFormat.format("B-{0}-{1,date,yyMMddHHmmssSSS}-{2,number,000}", NODE_ID, new Date(),
                SECURE_RANDOM.nextInt(1000));
    }

}