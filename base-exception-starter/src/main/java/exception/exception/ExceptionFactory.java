package exception.exception;

import exception.constant.ExceptionConstant;
import exception.exception.base.BusinessException;
import exception.exception.define.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ExceptionFactory {

//    @Autowired
//    private PropertiesUtils propertiesUtilsAUtowired;
//
//    private static PropertiesUtils propertiesUtils;

//    @PostConstruct
//    public void init(){
//        this.propertiesUtils = propertiesUtilsAUtowired;
//    }

    public static DaoException getDaoException(String moduleCode, String exceptionFLag, String message, Map<String, Object> properties, Throwable throwable) {
        return new DaoException(moduleCode, exceptionFLag, message, throwable);
    }

    public static DaoException getDaoException(String systemCode, String moduleCode, String exceptionFLag, String message, Map<String, Object> properties, Throwable throwable) {
        return new DaoException(moduleCode, exceptionFLag, message, throwable);
    }

    public static BusinessException getBusinessException(String moduleCode, String message) {
        return new ValidateException(moduleCode,"ss", message);
    }



    public static ArgsIsNullException getArgsIsNullException(String moduleCode, String argName) {
        return new ArgsIsNullException(moduleCode,"ff", argName);
    }
    public static ArgsIsNullException getArgsIsNullException(String moduleCode, String ... argName) {
        return ArgsIsNullException.getArgsIsNullException(moduleCode,"ss" ,argName);
    }

    public static ArgsErrorException getArgsErrorException(String moduleCode, Map<String, Object> args) {
        return  ArgsErrorException.getInstance(moduleCode,"sss", args);
    }

    public static ObjectNotFundException getObjectNotFundException(String moduleCode, String mapperId, Map<String, Object> args) {
        return  ObjectNotFundException.getInstance(moduleCode,"ss", mapperId, args);
    }

    public static ObjectNotFundException getObjectNotFundException(String moduleCode, String objectName, String ids) {
        return  ObjectNotFundException.getInstance(moduleCode, "ss",objectName, ids);
    }



    /**
     *  
     * @Description 数据操作影响行数校验异常
     * @Date 11:05 2018/12/8
     * @Param [moduleCode, tableName, exceptRows, actRows]
     **/
    public static EffectRowsException getEffectRowsException(String moduleCode,String tableName,Integer exceptRows,Integer actRows){
        return EffectRowsException.getEffectRowsException(moduleCode,"ss",tableName,exceptRows,actRows);
    }
    public static EffectRowsException getEffectRowsException(String moduleCode,String tableName,long exceptRows,long actRows){
        return EffectRowsException.getEffectRowsException(moduleCode,"ss",tableName,exceptRows,actRows);
    }


    public static ValidateException getValidateException(String moduleCode, String name, Object value) {
        return ValidateException.getInstance(moduleCode, "ss",name, value);
    }



    public static String getExceptionMessage(Exception e){
        if(e == null){
            return null;
        }
        if(e.getCause() == null){
            return e.getMessage();
        }
        return e.getCause().getMessage();
    }

}
