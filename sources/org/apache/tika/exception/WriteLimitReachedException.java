package org.apache.tika.exception;

import org.xml.sax.SAXException;

public class WriteLimitReachedException extends SAXException {
    private static final int MAX_DEPTH = 100;
    private final int writeLimit;

    public WriteLimitReachedException(int i) {
        this.writeLimit = i;
    }

    public static boolean isWriteLimitReached(Throwable th) {
        return isWriteLimitReached(th, 0);
    }

    public static void throwIfWriteLimitReached(Exception exc) throws SAXException {
        throwIfWriteLimitReached(exc, 0);
    }

    public String getMessage() {
        return "Your document contained more than " + this.writeLimit + " characters, and so your requested limit has been reached. To receive the full text of the document, increase your limit. (Text up to the limit is however available).";
    }

    private static boolean isWriteLimitReached(Throwable th, int i) {
        if (th == null || i > 100) {
            return false;
        }
        if (th instanceof WriteLimitReachedException) {
            return true;
        }
        if (th.getCause() == null || !isWriteLimitReached(th.getCause(), i + 1)) {
            return false;
        }
        return true;
    }

    private static void throwIfWriteLimitReached(Exception exc, int i) throws SAXException {
        if (exc == null || i > 100) {
            return;
        }
        if (!(exc instanceof WriteLimitReachedException)) {
            isWriteLimitReached(exc.getCause(), i + 1);
            return;
        }
        throw ((SAXException) exc);
    }
}
