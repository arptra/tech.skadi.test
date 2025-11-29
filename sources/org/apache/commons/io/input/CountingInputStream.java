package org.apache.commons.io.input;

import com.here.posclient.UpdateOptions;
import java.io.IOException;
import java.io.InputStream;

public class CountingInputStream extends ProxyInputStream {
    private long count;

    public CountingInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public synchronized void afterRead(int i) {
        if (i != -1) {
            this.count += (long) i;
        }
    }

    public synchronized long getByteCount() {
        return this.count;
    }

    public int getCount() {
        long byteCount = getByteCount();
        if (byteCount <= UpdateOptions.SOURCE_ANY) {
            return (int) byteCount;
        }
        throw new ArithmeticException("The byte count " + byteCount + " is too large to be converted to an int");
    }

    public synchronized long resetByteCount() {
        long j;
        j = this.count;
        this.count = 0;
        return j;
    }

    public int resetCount() {
        long resetByteCount = resetByteCount();
        if (resetByteCount <= UpdateOptions.SOURCE_ANY) {
            return (int) resetByteCount;
        }
        throw new ArithmeticException("The byte count " + resetByteCount + " is too large to be converted to an int");
    }

    public synchronized long skip(long j) throws IOException {
        long skip;
        skip = super.skip(j);
        this.count += skip;
        return skip;
    }
}
