package exception.exception.define;


public class NetworkException extends  SystemException {
    public NetworkException(String moduleCode,String exceptionFLag, String message){
        this(moduleCode,exceptionFLag, message, null);
    }

    public NetworkException( String moduleCode, String exceptionFLag, String message,  Throwable throwable){
        super(Integer.valueOf(7+"0000"+moduleCode+exceptionFLag), message, throwable);
    }
}
