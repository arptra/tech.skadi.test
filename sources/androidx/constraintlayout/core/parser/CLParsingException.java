package androidx.constraintlayout.core.parser;

import com.upuphone.starrynet.common.StarryNetConstant;

public class CLParsingException extends Exception {
    private final String mElementClass;
    private final int mLineNumber;
    private final String mReason;

    public CLParsingException(String str, CLElement cLElement) {
        this.mReason = str;
        if (cLElement != null) {
            this.mElementClass = cLElement.b();
            this.mLineNumber = cLElement.a();
            return;
        }
        this.mElementClass = StarryNetConstant.DEVICE_NAME_UNKNOWN;
        this.mLineNumber = 0;
    }

    public String reason() {
        return this.mReason + " (" + this.mElementClass + " at line " + this.mLineNumber + ")";
    }

    public String toString() {
        return "CLParsingException (" + hashCode() + ") : " + reason();
    }
}
