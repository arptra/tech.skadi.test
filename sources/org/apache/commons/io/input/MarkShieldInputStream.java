package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

public class MarkShieldInputStream extends ProxyInputStream {
    public MarkShieldInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public void mark(int i) {
    }

    public boolean markSupported() {
        return false;
    }

    public void reset() throws IOException {
        throw UnsupportedOperationExceptions.reset();
    }
}
