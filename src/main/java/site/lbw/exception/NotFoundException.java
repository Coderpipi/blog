package site.lbw.exception;

/**
 * @Description: 404异常
 * @Author: lbw
 * @Date: 2021-08-14
 */

public class NotFoundException extends RuntimeException {
	public NotFoundException() {
	}

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
