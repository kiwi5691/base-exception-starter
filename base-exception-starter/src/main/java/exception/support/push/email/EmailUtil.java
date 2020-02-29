package exception.support.push.email;

import exception.entity.Log;
import exception.support.push.email.template.EmailTemplate;
import exception.support.utils.DateTimeUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.*;

/**
 * @auther kiwi
 * @Date 2019/9/8 19:26
 */
@Slf4j
@Component
public class EmailUtil {

    //无界任务队列 LinkedBlockingQueue
    public static ExecutorService emailExePool =new
            ThreadPoolExecutor(1, 10, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());


    private String sender;

    private String host;

    private String pwd;

    public EmailUtil(String sender, String host, String pwd) {
        this.sender = sender;
        this.host = host;
        this.pwd = pwd;
    }

    //todo 这里需要对线程池重新校验
    public void sendEmailExecute(String to, String subject, Log log){
        emailExePool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    sendEmail(to,subject,
                                EmailTemplate.issueTemplate(DateTimeUtil.getDateTimeDisplayStringByDateType(log.getCreateTime()), String.valueOf(log.getCreator())));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    //todo demo
    public void sendEmailExecute(String to, String subject){
        emailExePool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    sendEmail(to,subject,
                            EmailTemplate.issueTemplate("demo","BodyDemo"));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public void sendEmail(String to, String subject, String content) throws Exception {

        Properties props = new Properties();

        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", host);
        props.setProperty("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props);
        // 开启debug模式，可以看到更多详细的输入日志
        MimeMessage message = this.addEmail(session,to,subject, content);

        //获取传输通道
        Transport transport = session.getTransport();
        transport.connect(host, sender, pwd);
        //连接，并发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();


    }
        /**
         * 创建邮件
         */
        public MimeMessage addEmail(Session session,String to, String subject, String content) throws Exception {
            // 根据会话创建邮件
            MimeMessage msg = new MimeMessage(session);

            // 设置发送邮件方
            msg.setFrom(new InternetAddress(sender));
            // 设置邮件接收方
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // 设置邮件标题

            msg.setSubject(subject, "utf-8");
            msg.setContent(content,"text/html;charset=utf-8");
            // 设置显示的发件时间
            msg.setSentDate(new Date());
            // 保存设置
            msg.saveChanges();
            return msg;
        }

}

