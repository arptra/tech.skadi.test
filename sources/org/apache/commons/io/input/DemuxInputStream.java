package org.apache.commons.io.input;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

public class DemuxInputStream extends InputStream {
    private final InheritableThreadLocal<InputStream> inputStreamLocal = new InheritableThreadLocal<>();

    public InputStream bindStream(InputStream inputStream) {
        InputStream inputStream2 = this.inputStreamLocal.get();
        this.inputStreamLocal.set(inputStream);
        return inputStream2;
    }

    public void close() throws IOException {
        IOUtils.close((Closeable) this.inputStreamLocal.get());
    }

    public int read() throws IOException {
        InputStream inputStream = this.inputStreamLocal.get();
        if (inputStream != null) {
            return inputStream.read();
        }
        return -1;
    }
}
