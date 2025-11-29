package org.apache.tika.pipes.emitter;

import org.apache.tika.exception.TikaException;

public class TikaEmitterException extends TikaException {
    public TikaEmitterException(String str) {
        super(str);
    }

    public TikaEmitterException(String str, Throwable th) {
        super(str, th);
    }
}
