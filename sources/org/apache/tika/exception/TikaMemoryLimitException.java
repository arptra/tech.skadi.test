package org.apache.tika.exception;

public class TikaMemoryLimitException extends TikaException {
    public TikaMemoryLimitException(String str) {
        super(str);
    }

    private static String msg(long j, long j2) {
        return "Tried to allocate " + j + " bytes, but " + j2 + " is the maximum allowed. Please open an issue https://issues.apache.org/jira/projects/TIKA if you believe this file is not corrupt.";
    }

    public TikaMemoryLimitException(long j, long j2) {
        super(msg(j, j2));
    }
}
