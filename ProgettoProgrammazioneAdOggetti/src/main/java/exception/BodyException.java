package exception;

public class BodyException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	// Viene lanciata quando viene inserito una chiave json body che non esiste.
	public BodyException(String message) {
		
		super(message);
		}
	

}
