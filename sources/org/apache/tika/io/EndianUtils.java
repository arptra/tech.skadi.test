package org.apache.tika.io;

import org.apache.tika.exception.TikaException;

public class EndianUtils {

    public static class BufferUnderrunException extends TikaException {
        private static final long serialVersionUID = 8358288231138076276L;

        public BufferUnderrunException() {
            super("Insufficient data left in stream for required read");
        }
    }
}
