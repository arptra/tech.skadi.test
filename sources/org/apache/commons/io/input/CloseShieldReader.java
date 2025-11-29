package org.apache.commons.io.input;

import java.io.Reader;

public class CloseShieldReader extends ProxyReader {
    @Deprecated
    public CloseShieldReader(Reader reader) {
        super(reader);
    }

    public static CloseShieldReader wrap(Reader reader) {
        return new CloseShieldReader(reader);
    }

    public void close() {
        this.in = ClosedReader.CLOSED_READER;
    }
}
