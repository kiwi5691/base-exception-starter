package exception.exception.define;



public class DataBaseException extends SystemException {

    public DataBaseException(String moduleCode, String exceptionFLag, String message) {
        this( moduleCode, exceptionFLag, message,null);
    }

    public DataBaseException(String moduleCode, String exceptionFLag, String message, Throwable throwable) {
        super(Integer.valueOf(5 + "0000" + moduleCode + exceptionFLag), message,throwable);
    }

}
