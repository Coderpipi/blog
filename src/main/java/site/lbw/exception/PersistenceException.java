package site.lbw.exception;

/**
 * @Description: 持久化异常
 * @Author: lbw
 * @Date: 2021-08-14
 */

public class PersistenceException extends RuntimeException {
	public PersistenceException() {
	}

	public PersistenceException(String message) {
		super(message);
	}

	public PersistenceException(String message, Throwable cause) {
		super(message, cause);
	}
}
