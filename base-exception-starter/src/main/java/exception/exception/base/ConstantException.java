package exception.exception.base;

public class ConstantException extends AbstractBaseExeption {
    private static final long serialVersionUID = -5789311455376383881L;

    public ConstantException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConstantException(String message) {
        super(message);
    }

    public ConstantException(String message, Object... params) {
        super(String.format(message, params));
    }

    public ConstantException(Throwable cause) {
        super(cause);
    }
}