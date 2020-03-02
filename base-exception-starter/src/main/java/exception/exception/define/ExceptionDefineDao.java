package exception.exception.define;


import exception.config.ExceptionConfig;
import exception.exception.cache.AbstractCache;
import org.springframework.beans.factory.annotation.Autowired;


public class ExceptionDefineDao extends AbstractCache<Integer, ExceptionDefine> {

     @Autowired
    private ExceptionConfig exceptionConfig;

    public ExceptionDefineDao(){
        super(100000, 30);
    }

    public ExceptionDefine load(Integer exceptionCode) throws Exception {
        ExceptionDefine define = new ExceptionDefine();
        return define;
    }


    public static ExceptionDefineDao getInstance() {
        return Loader.X;
    }

    private static class Loader {
        private static final ExceptionDefineDao X = new ExceptionDefineDao();
    }
}
