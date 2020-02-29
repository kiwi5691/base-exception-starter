package exception.handler;


import exception.config.ExceptionConfig;
import exception.exception.base.ExceptionHandlerTags;
import exception.exception.define.*;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Aspect
@Configuration
public class ExceptionHandler {

//    @Bean(name = "exceptionConfig")
    public ExceptionConfig exceptionConfig() {
        ExceptionConfig exceptionConfig = new ExceptionConfig();
//        exceptionConfig.setQueryDefineSql("SELECT * FROM EXCEPTION_DEFINE WHERE EXCEPTION_CODE=?");
//        exceptionConfig.setUnknownStatus(5999999);
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setPassword(exceptionDataSourcePassword);
//        dataSource.setUsername(exceptionDataSourceUserName);
//        dataSource.setUrl(exceptionDataSourceUrl);
//        exceptionConfig.setDataSource(dataSource);
        return exceptionConfig;
    }

    @Bean(name = "exceptionDefineDao")
    public ExceptionDefineDao exceptionDefineDao(){
        return new ExceptionDefineDao();
    }

    private static Logger log = LoggerFactory.getLogger(ExceptionHandler.class);

//    @Around("execution(* com.gillion..*Controller.*(..))")
//    public Object serviceAround(ProceedingJoinPoint pjp) throws Throwable {
//
//        Object retVal = null;
//        try {
//            retVal = pjp.proceed();
//            return retVal;
//        }
//        catch (Throwable err) {
//           throw (handler(err, pjp.getSignature().toString()));
//        }
//    }

    public Throwable handler(Throwable throwable, String methodName){

        BaseException err;
        if(throwable instanceof BaseException){
            err = (BaseException)throwable;
            if(err.getInvokeMethod() == null){
                err.setInvokeMethod(methodName);
            }
            if(err.getHostName() == null){
                String host;
                try {
                    host = InetAddress.getLocalHost().getHostName();
                } catch (UnknownHostException e) {
                    host = "Unknown Host";
                    log.error("获取hostname失败",e);
                }
                err.setHostName(host);
            }
//            BusinessParam businessParam = BusinessParamsHolder.getInstance().getBusinessParam();
//
//            if(null!=businessParam){
//                String tempId = businessParam.getBusinessId();
//                if(StringUtils.isNotBlank(tempId)) {
//                    err.setBusinessId(Long.valueOf(businessParam.getBusinessId()));
//                }
//                String boName = businessParam.getBoName();
//                if(StringUtils.isNotBlank(boName)){
//                    err.setBusinessType(boName);
//                }
//                BusinessParamsHolder.getInstance().clear();
            }
//            ExceptionDefine define = this.getExceptionDefine(err.getExceptionCode());
//            if(define==null){
//                log.info(err.getMessage(), throwable);
//                return err;
//            }
//            int handlerTags = define.getHandlerTags();
        //todo
            if (ExceptionHandlerTags.HANDLER_DB.containTo(1)) {

                ExceptionMessage exceptionMessage = new ExceptionMessage();
//                exceptionMessage.setOperater(err.getOperater());
//                exceptionMessage.setExceptionCode(err.getExceptionCode());
//                exceptionMessage.setInvokeMethod(err.getInvokeMethod());
//                exceptionMessage.setHostName(err.getHostName());
//                exceptionMessage.setMessage(err.getMessage());
//                exceptionMessage.setBusinessType(err.getBusinessType());
//                exceptionMessage.setExceptionCode(err.getExceptionCode());
//                exceptionMessage.setBusinessNo(err.getBusinessNo());
//                exceptionMessage.setBusinessId(err.getBusinessId());
//                exceptionMessage.setExceptionType(err.getExceptionType());
                //EdsClient.request("eds://exceptionHandler", exceptionMessage);
//                SdkRegistry.getInstance().getEdsClient().request("eds://exceptionHandler", exceptionMessage);
            }
//            if (ExceptionHandlerTags.SAVE_TO_LOG.containTo(handlerTags)) {
//                log.error(err.getMessage(), throwable);
//            }
//            if (ExceptionHandlerTags.SAVE_TO_SMS.containTo(handlerTags)) {
//                this.sendExceptionSMS(err);
//            }
//
//            if (ExceptionHandlerTags.SAVE_TO_EMAIL.containTo(handlerTags)) {
                // this.sendExceptionEmail(err);
//            }
//            return err;
//        }
        return throwable;
    }

    private ExceptionDefine getExceptionDefine(int exceptionCode){
        try {
            ExceptionDefine define = exceptionDefineDao().get(exceptionCode);
            return  define;
        }catch (Exception e){
            log.error("获取异常处理失败",e);
            return null;
        }


    }

}
