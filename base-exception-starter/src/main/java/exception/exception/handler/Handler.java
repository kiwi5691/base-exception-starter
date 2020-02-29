package exception.exception.handler;

import exception.exception.base.ExceptionHandlerTags;
import exception.exception.base.LevelTags;

//责任链基类
public abstract class Handler {

    protected Handler sender = null;

    public Handler getSender() {
        return sender;
    }
    public void setSender(Handler sender) {
        this.sender = sender;
    }
    public abstract String handleSendRequest(LevelTags levelTags , ExceptionHandlerTags exceptionHandlerTags);
}
