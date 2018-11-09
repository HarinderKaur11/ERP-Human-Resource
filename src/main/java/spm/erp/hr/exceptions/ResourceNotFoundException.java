package spm.erp.hr.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(Exception ex) {
		super(ex);
	}

}
