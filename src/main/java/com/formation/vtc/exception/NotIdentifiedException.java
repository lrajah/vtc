package com.formation.vtc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Dell
 *
 */
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class NotIdentifiedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

}