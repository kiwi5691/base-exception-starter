package exception.exception.define;

import exception.constant.ExceptionConstant;

/**
 * <pre>
 * 描述：TODO
 * </pre>
 *
 */
public class EffectRowsException extends SystemException {

    private static String template = "操作表%s影响行数预期为%s,实际为%s";

    public static EffectRowsException getEffectRowsException(String moduleCode,String appCode, String tableName, Integer expectRows, Integer actRows) {
        String message = String.format(template, tableName, expectRows, actRows);
        EffectRowsException exception = new EffectRowsException(Integer.valueOf(5 + appCode + moduleCode + ExceptionConstant.EXCEPTION_EFFECTROWS), message);
        return exception;
    }
    public static EffectRowsException getEffectRowsException(String moduleCode,String appCode, String tableName, Long expectRows, Long actRows) {
        String message = String.format(template, tableName, expectRows, actRows);
        EffectRowsException exception = new EffectRowsException(Integer.valueOf(5 + appCode + moduleCode + ExceptionConstant.EXCEPTION_EFFECTROWS), message);
        return exception;
    }

    public EffectRowsException(int exceptionCode, String message) {
        super(exceptionCode, message);
    }
}
