package exception.exception.cache;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
@Slf4j
public abstract class AbstractCache <TKey, T>  {



    public AbstractCache(int maxSize, int hours) {
//        cache = CacheBuilder.newBuilder().maximumSize(maxSize).expireAfterWrite(hours, TimeUnit.HOURS).build(this);
//
//        preLoad(cache);

    }

    protected void preLoad() {
    }

    public T get(TKey key) {
//        try {
//            return cache.get(key);
//        } catch (ExecutionException e) {
//            String msg = this.getClass().getSimpleName() + " cache get fail ,key =  " + key;
//            log.error(msg, e);
//            return null;
//        } finally {
//        }
        return null;
    }
}
