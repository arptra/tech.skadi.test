package org.apache.tika.exception;

import java.io.IOException;

public class FileTooLongException extends IOException {
    public FileTooLongException(String str) {
        super(str);
    }

    private static String msg(long j, long j2) {
        return "File is " + j + " bytes, but " + j2 + " is the maximum length allowed.  You can modify maxLength via the setter on the fetcher.";
    }

    public FileTooLongException(long j, long j2) {
        super(msg(j, j2));
    }
}
