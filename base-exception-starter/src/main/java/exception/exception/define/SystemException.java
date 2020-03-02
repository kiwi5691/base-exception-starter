package exception.exception.define;

import exception.constant.ExceptionConstant;


public class SystemException extends BaseException {

    public SystemException(int exceptionCode, String message){
        super(exceptionCode, message, null);
    }

    public SystemException(int exceptionCode, String message, Throwable throwable){
        super(exceptionCode, message, throwable);
        this.setExceptionType(ExceptionConstant.EXCEPTION_TYPE_SYSTEM);
    }


}
