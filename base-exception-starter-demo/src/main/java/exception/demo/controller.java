package exception.demo;

import exception.GetHashCodeClass;
import exception.support.push.email.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    private final String testSender = "805344479@qq.com";
    @Autowired
    EmailUtil emailUtil;
    @GetMapping("/test")
    public String test(){

        emailUtil.sendEmailExecute(testSender,"test");
        return "getHashCodeClass.getHashCode()";
    }
    @GetMapping("/testa")
    public String getNme(){
        return "getHashCodeClass.getName()";
    }
}
