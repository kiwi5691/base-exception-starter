package exception.exception.define;

import exception.constant.ExceptionConstant;
import exception.exception.base.ConstantException;


public class ValidateException extends ConstantException {

    private String rule;
    private String objectName;
    private String filedName;


    public ValidateException(String moduleCode,String appCode, String message) {
        super(String.valueOf(Integer.valueOf(4 + appCode + moduleCode + ExceptionConstant.EXCEPTION_PARAMS)), message,new Throwable(message));
    }



    public static ValidateException getInstance(String moduleCode,String appCode, String name, Object value) {
        String message = String.format("属性%s值为%s校验不通过",name,value);
        ValidateException validateException = new ValidateException(Integer.valueOf(4 + appCode + moduleCode + ExceptionConstant.EXCEPTION_PARAMS), message, new Throwable(message));
        return validateException;
    }

    public ValidateException(Integer exceptionCode, String message, Throwable throwable) {
        super(String.valueOf(exceptionCode), message,throwable);
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getFiledName() {
        return filedName;
    }

    public void setFiledName(String filedName) {
        this.filedName = filedName;
    }
}