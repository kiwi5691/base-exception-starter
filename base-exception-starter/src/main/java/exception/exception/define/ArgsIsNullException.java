package exception.exception.define;

import exception.constant.ExceptionConstant;
import exception.exception.base.ConstantException;

public class ArgsIsNullException extends ConstantException {

	private static final long serialVersionUID = 1L;

	private static final String PARAM_STR = "参数";

	private static final String IS_NULL_STR = "为Null";

	public ArgsIsNullException(String moduleCode,String appCode, String argName) {
		this(moduleCode,appCode, ExceptionConstant.EXCEPTION_PARAMS, PARAM_STR + argName + IS_NULL_STR,
				new Throwable(PARAM_STR + argName + IS_NULL_STR));
	}

	public ArgsIsNullException(String moduleCode,String appCode, String exceptionFLag, String message, Throwable throwable) {
		super(String.valueOf(Integer.valueOf(4 + appCode + moduleCode + exceptionFLag)), message, throwable);
	}

	public static ArgsIsNullException getArgsIsNullException(String moduleCode,String appCode, String... str) {
		String message = PARAM_STR + String.join(",", str) + IS_NULL_STR;
		ArgsIsNullException argsIsNullException = new ArgsIsNullException(moduleCode,appCode,
				ExceptionConstant.EXCEPTION_PARAMS, message, new Throwable(message));
		return argsIsNullException;
	}

}
