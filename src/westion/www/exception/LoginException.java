package westion.www.exception;


/**
 * 
 * ��¼���󣬵�¼ʧ��
 * @version 1.0, 2014-3-20
 * @author westion
 * @since JDK1.7
 */
public class LoginException extends RuntimeException {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public LoginException() {
		super("can not login");
	}

	
}
