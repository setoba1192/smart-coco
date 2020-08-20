package co.com.coco.exception;

public class DaoException extends RuntimeException {

	private static final long serialVersionUID = -4325423036600329705L;

	public DaoException() {

	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoException(String message, Throwable cause, boolean enableSuppression,
                        boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}