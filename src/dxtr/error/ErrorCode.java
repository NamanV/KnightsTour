package dxtr.error;

public enum ErrorCode {
	INVALID_BOARD(10, "Invalid board dimensions!"), //
	INVALID_STARTING_POSITION(12, "Please use a valid starting position with in the limit of the board size!"),
	INVALID_BOARD_SIZE(11,"Both the dimensions have to be equal!");

	private ErrorCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	private int code;
	private String message;

	public String getErrorMessage() {
		return "Error code: " + code + "; Message : " + message;
	}
}
