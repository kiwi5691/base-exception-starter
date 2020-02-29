package exception.support.push.email.template;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @auther kiwi
 * @Date 2019/9/7 23:55
 */
@Slf4j
public class EmailTemplate {

    /**
     *@Auther kiwi
     *@Data 2019/9/8
     @param  * @param
     *@reutn java.lang.String
    */
    public static String issueTemplate(String titleName,String context) throws IOException {
        String fileName = "support/pod-scale-alarm.html";
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(fileName);
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        try {
            while ((line = fileReader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (IOException e) {
            log.error("读取文件失败，fileName:{}", fileName, e);
        } finally {
            inputStream.close();
            fileReader.close();
        }

        String contentText = context;


        String emailHeadColor = "#8A2BE2";
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = dtf2.format(LocalDateTime.now(Clock.system(ZoneId.of("Asia/Shanghai"))));
        String htmlText = MessageFormat.format(buffer.toString(), emailHeadColor,titleName ,contentText, date);

        return htmlText;
    }
}
