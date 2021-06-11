package exception;

public class NotFound extends RuntimeException{
	
	

	private static final long serialVersionUID = 1L;

	public NotFound(String massege) {
		super(massege);
	}
		public NotFound(String massege,Throwable cause) {	
		super(massege,cause);

	} 

}
