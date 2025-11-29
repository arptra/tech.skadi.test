package org.apache.tika.pipes.fetcher;

import org.apache.tika.exception.TikaException;

public class FetcherStringException extends TikaException {
    public FetcherStringException(String str) {
        super(str);
    }
}
