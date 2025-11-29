package org.apache.tika.parser.strings;

import java.io.Serializable;

public class StringsConfig implements Serializable {
    private static final long serialVersionUID = -1465227101645003594L;
    private StringsEncoding encoding = StringsEncoding.SINGLE_7_BIT;
    private int minLength = 4;
    private String stringsPath = "";
    private int timeoutSeconds = 120;

    public StringsEncoding getEncoding() {
        return this.encoding;
    }

    public int getMinLength() {
        return this.minLength;
    }

    public int getTimeoutSeconds() {
        return this.timeoutSeconds;
    }

    public void setEncoding(StringsEncoding stringsEncoding) {
        this.encoding = stringsEncoding;
    }

    public void setMinLength(int i) {
        if (i >= 1) {
            this.minLength = i;
            return;
        }
        throw new IllegalArgumentException("Invalid minimum length");
    }

    public void setTimeoutSeconds(int i) {
        if (i >= 1) {
            this.timeoutSeconds = i;
            return;
        }
        throw new IllegalArgumentException("Invalid timeout");
    }
}
