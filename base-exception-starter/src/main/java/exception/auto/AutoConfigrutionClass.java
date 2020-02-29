package exception.auto;

import exception.config.EmailConfigruation;
import exception.support.web.UIController;
import exception.support.push.email.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {EmailConfigruation.class})
@ConditionalOnClass(value = {EmailUtil.class})
public class AutoConfigrutionClass {
    @Autowired
    private EmailConfigruation emailConfigruation;

    @Bean
    @ConditionalOnProperty(prefix = "exception.ui",value = "enabled",havingValue = "true")
//    @ConditionalOnMissingBean
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
        return new EmailUtil(emailConfigruation.getSender(),emailConfigruation.getHost(),emailConfigruation.getPwd());
    }


}
