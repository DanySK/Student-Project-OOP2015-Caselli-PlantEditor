package exception;

public class NotPermittedCommandException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public NotPermittedCommandException() {
	super();
    }

    @Override
    public String getMessage() {
	return "Not Permitted Command: Invalid Parameters";
    }

}
