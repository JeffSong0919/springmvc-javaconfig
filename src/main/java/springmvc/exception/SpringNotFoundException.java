package springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="spring not found")
public class SpringNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6353449734158105483L;

}
