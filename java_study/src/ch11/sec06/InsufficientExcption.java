package ch11.sec06;

public class InsufficientExcption extends Exception {
	public InsufficientExcption () {
		
	}
	public InsufficientExcption(String message) {
		super(message);
	}
}
