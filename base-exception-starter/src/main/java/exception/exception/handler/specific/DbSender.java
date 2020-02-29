package exception.exception.handler.specific;

import exception.exception.base.ExceptionHandlerTags;
import exception.exception.base.LevelTags;
import exception.exception.handler.Handler;

public class DbSender extends Handler {
    @Override
    public String handleSendRequest(LevelTags levelTags, ExceptionHandlerTags exceptionHandlerTags) {
        String str = "";
        //最大权限开始
        if(levelTags.getLevelCode().equals(1))
        {
//            直接通过

        }else
        {
            //如果还有后继的处理对象，继续传递
            if(getSender() != null)
            {
                return getSender().handleSendRequest(levelTags, exceptionHandlerTags);
            }
        }
        return str;
    }

}
