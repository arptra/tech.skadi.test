package io.netty.util;

import java.util.Arrays;

@Deprecated
public class ResourceLeakException extends RuntimeException {
    private static final long serialVersionUID = 7186453858343358280L;
    private final StackTraceElement[] cachedStackTrace = getStackTrace();

    public ResourceLeakException() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ResourceLeakException)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return Arrays.equals(this.cachedStackTrace, ((ResourceLeakException) obj).cachedStackTrace);
    }

    public int hashCode() {
        int i = 0;
        for (StackTraceElement hashCode : this.cachedStackTrace) {
            i = (i * 31) + hashCode.hashCode();
        }
        return i;
    }

    public ResourceLeakException(String str) {
        super(str);
    }

    public ResourceLeakException(String str, Throwable th) {
        super(str, th);
    }

    public ResourceLeakException(Throwable th) {
        super(th);
    }
}
