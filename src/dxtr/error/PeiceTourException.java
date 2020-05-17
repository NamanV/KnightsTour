package dxtr.error;

public class PeiceTourException extends Exception {
	private ErrorCode error;

	public PeiceTourException(ErrorCode error) {
		this.error = error;
	}
	
	@Override
	public String getMessage() {
		return error.getErrorMessage();
	}

}
