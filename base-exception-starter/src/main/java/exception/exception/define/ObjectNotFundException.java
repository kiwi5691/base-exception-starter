package exception.exception.define;

import com.alibaba.fastjson.JSON;
import exception.constant.ExceptionConstant;
import exception.exception.base.ConstantException;

import java.util.Map;

public class ObjectNotFundException extends ConstantException {

	private static final String TEMPLATE = "根据条件%s查询%s，查询结果为空";

	public static ObjectNotFundException getInstance(String moduleCode,String appCode, String mapperId, Map<String, Object> args) {
		String message = String.format(TEMPLATE, JSON.toJSON(args), mapperId);
		ObjectNotFundException exception = new ObjectNotFundException(moduleCode,appCode, ExceptionConstant.EXCEPTION_PARAMS,
				message, new Throwable(message));
		return exception;
	}

	public static ObjectNotFundException getInstance(String moduleCode, String appCode,String objectName, String ids) {
		String message = String.format(TEMPLATE, "{ids:" + ids + "}", objectName);
		ObjectNotFundException exception = new ObjectNotFundException(moduleCode,appCode, ExceptionConstant.EXCEPTION_PARAMS,
				message, new Throwable(message));
		return exception;
	}



	private ObjectNotFundException(String moduleCode,String appCode, String exceptionFLag, String message, Throwable throwable) {
		super(String.valueOf(Integer.valueOf(4 + appCode + moduleCode + exceptionFLag)), message, throwable);
	}
}
