package spm.erp.hr.exceptions;

/**
 * The Class ResourceNotFoundException.
 */
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * Instantiates a new resource not found exception.
	 *
	 * @param message the message
	 */
	public ResourceNotFoundException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new resource not found exception.
	 *
	 * @param ex the ex
	 */
	public ResourceNotFoundException(Exception ex) {
		super(ex);
	}

}
