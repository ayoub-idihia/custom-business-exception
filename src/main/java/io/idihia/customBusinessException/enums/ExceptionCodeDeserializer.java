package io.idihia.customBusinessException.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ExceptionCodeDeserializer implements ExceptionCode {

	private final String code;

	private final String message;

	public ExceptionCodeDeserializer(String code) {
		this.code = code;
		this.message = null;
	}

}
