package exception.exception.define;

public class BaseException extends RuntimeException implements CustomException {
    private int exceptionCode;
    private String hostName;
    private String operater;
    private String invokeMethod;
    private Byte ExceptionType;
    private String message;

    //args
    public BaseException(){}


    public BaseException(int exceptionCode, String message){
        this(exceptionCode, message,new Throwable(message));
    }

    public BaseException(int exceptionCode, String message, Throwable throwable){
        super(message, throwable);
        this.exceptionCode = exceptionCode;
        if(!message.contains(String.valueOf(exceptionCode))){
            this.message = message+"("+exceptionCode+")";
        }else{
            this.message = message;
        }

    }

    @Override
    public int getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(int exceptionCode){
        this.exceptionCode = exceptionCode;
    }

    @Override
    public String getHostName() {

        return this.hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getOperater() {
        return operater;
    }

    public void setOperater(String operater) {
        this.operater = operater;
    }

    public String getInvokeMethod() {
        return invokeMethod;
    }


    public void setInvokeMethod(String invokeMethod) {
        this.invokeMethod = invokeMethod;
    }


    public Byte getExceptionType() {
        return ExceptionType;
    }

    public void setExceptionType(Byte exceptionType) {
        ExceptionType = exceptionType;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
