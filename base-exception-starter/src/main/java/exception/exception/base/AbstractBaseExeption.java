package exception.exception.base;


public abstract class AbstractBaseExeption extends RuntimeException  {
    public AbstractBaseExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractBaseExeption(String message) {
        super(message);
    }

    public AbstractBaseExeption(String message, Object... params) {
        super(String.format(message, params));
    }

    public AbstractBaseExeption(Throwable cause) {
        super(cause);
    }
}
