package io.idihia.customBusinessException.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
public enum TechnicalExceptionCode implements ExceptionCode {

    TECH_UNKNOWN("TECH_00001", "An unknown error occurred while calling the API {} {}"),

    HTTP_EMPTY_RESPONSE("TECH_00002", "Empty or null response from the API call to {} {}"),

    HTTP_MISSING_HEADER("TECH_00003", "Missing 'rece-entete' header in the API response"),

    HTTP_ERROR("TECH_00004", "An HTTP error occurred"),

    HTTP_TECHNICAL_ERROR("TECH_00005", "Technical error while calling the API at {} {}"),

    HTTP_UNAUTHORIZED("TECH_00006", "Insufficient permissions to call {} {}");

    private final String code;

    private final String message;

}
