package org.apache.commons.io.output;

import java.io.Writer;

public class CloseShieldWriter extends ProxyWriter {
    @Deprecated
    public CloseShieldWriter(Writer writer) {
        super(writer);
    }

    public static CloseShieldWriter wrap(Writer writer) {
        return new CloseShieldWriter(writer);
    }

    public void close() {
        this.out = ClosedWriter.CLOSED_WRITER;
    }
}
