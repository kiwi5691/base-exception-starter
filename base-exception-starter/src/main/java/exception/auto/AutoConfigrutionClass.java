package exception.auto;

import exception.config.AspectConfiguration;
import exception.config.EmailConfiguration;
import exception.handler.ExceptionHandler;
import exception.support.web.UIController;
import exception.support.push.email.EmailUtil;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureOrder
@EnableConfigurationProperties(value = {EmailConfiguration.class,AspectConfiguration.class})
@ConditionalOnClass(value = {EmailUtil.class})
public class AutoConfigrutionClass {
    @Autowired
    private EmailConfiguration emailConfiguration;
    @Autowired
    private AspectConfiguration aspectConfiguration;
    @Bean
    @ConditionalOnProperty(name = "exception.scan.packages")
    public DefaultPointcutAdvisor defaultPointcutAdvisor() {
        StringBuilder baseRoot = new StringBuilder();
        baseRoot.append("execution(*");
        baseRoot.append(aspectConfiguration.getPackages());
        baseRoot.append(".*(..))");

        ExceptionHandler handler = new ExceptionHandler();
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(baseRoot.toString());
        // 配置增强类advisor
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(handler);
        return advisor;
    }
    @Bean
    @ConditionalOnProperty(prefix = "exception.ui",value = "enabled",havingValue = "true")
    public UIController getUIController() {
        return new UIController();
    }

//    @ConditionalOnMissingBean
//    @Bean
//    public EmailUtil getEmailService(){
//        return new EmailUtil(emailConfigruation.getSender(),emailConfigruation.getHost(),emailConfigruation.getPwd());
//    }

    @Bean
    @ConditionalOnProperty(prefix = "exception.email",name = {"sender","host","pwd"})
//    @ConditionalOnMissingBean
    public EmailUtil getEmailService(){
        return new EmailUtil(emailConfiguration.getSender(),emailConfiguration.getHost(),emailConfiguration.getPwd());
    }


}
