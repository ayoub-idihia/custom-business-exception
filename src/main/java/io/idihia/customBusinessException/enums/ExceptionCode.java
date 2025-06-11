package io.idihia.customBusinessException.enums;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = ExceptionCodeDeserializer.class)
public interface ExceptionCode {

	String getCode();

	String getMessage();

}
