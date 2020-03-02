package exception.exception.define;

import com.alibaba.fastjson.JSON;
import exception.constant.ExceptionConstant;
import exception.exception.base.ConstantException;

import java.util.Map;


public class ArgsErrorException extends ConstantException {
    private static final String TEMPLATE = "参数值错误：%s";

    public static ArgsErrorException getInstance(String moduleCode,String appCode, Map<String, Object> args) {
        String message = String.format(TEMPLATE, JSON.toJSON(args));
        ArgsErrorException argsErrorException = new ArgsErrorException(moduleCode,appCode, ExceptionConstant.EXCEPTION_PARAMS, message,new Throwable(message));
        return argsErrorException;
    }

    public ArgsErrorException(String moduleCode,String appCode, String exceptionFLag, String message,Throwable throwable) {
        super(String.valueOf(Integer.valueOf(4 + appCode+ moduleCode + exceptionFLag)), message,throwable);
    }

}
