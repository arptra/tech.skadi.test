package rxhttp.wrapper.exception;

import java.io.IOException;

public class CacheReadFailedException extends IOException {
    public CacheReadFailedException(String str) {
        super(str);
    }
}
