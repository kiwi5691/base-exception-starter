package exception.exception.define;

/**
 * <pre>
 * 描述：TODO
 * </pre>
 *
 */
public class ExceptionDefine {
    private int exceptionCode;
    private String desc;
    private int handlerTags;
    private String template;

    public int getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(int exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getHandlerTags() {
        return handlerTags;
    }

    public void setHandlerTags(int handlerTags) {
        this.handlerTags = handlerTags;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
