package exception;

public class IdNotFound extends RuntimeException{
	
	

	private static final long serialVersionUID = 1L;

	public IdNotFound(String massege) {
		super(massege);
	}
		public IdNotFound(String massege,Throwable cause) {	
		super(massege,cause);

	} 

}
