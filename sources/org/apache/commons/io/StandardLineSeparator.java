package org.apache.commons.io;

import java.nio.charset.Charset;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

public enum StandardLineSeparator {
    CR(StringUtils.CR),
    CRLF("\r\n"),
    LF(StringUtils.LF);
    
    private final String lineSeparator;

    private StandardLineSeparator(String str) {
        Objects.requireNonNull(str, "lineSeparator");
        this.lineSeparator = str;
    }

    public byte[] getBytes(Charset charset) {
        return this.lineSeparator.getBytes(charset);
    }

    public String getString() {
        return this.lineSeparator;
    }
}
