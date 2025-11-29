package org.apache.commons.io.input;

import com.honey.account.vb.a;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.util.function.IntPredicate;

public abstract class AbstractCharacterFilterReader extends FilterReader {
    protected static final IntPredicate SKIP_NONE = new a();
    private final IntPredicate skip;

    public AbstractCharacterFilterReader(Reader reader) {
        this(reader, SKIP_NONE);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$0(int i) {
        return false;
    }

    public boolean filter(int i) {
        return this.skip.test(i);
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public int read() throws java.io.IOException {
        /*
            r2 = this;
        L_0x0000:
            java.io.Reader r0 = r2.in
            int r0 = r0.read()
            r1 = -1
            if (r0 == r1) goto L_0x000f
            boolean r1 = r2.filter(r0)
            if (r1 != 0) goto L_0x0000
        L_0x000f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.input.AbstractCharacterFilterReader.read():int");
    }

    public AbstractCharacterFilterReader(Reader reader, IntPredicate intPredicate) {
        super(reader);
        this.skip = intPredicate == null ? SKIP_NONE : intPredicate;
    }

    public int read(char[] cArr, int i, int i2) throws IOException {
        int read = super.read(cArr, i, i2);
        if (read == -1) {
            return -1;
        }
        int i3 = i - 1;
        for (int i4 = i; i4 < i + read; i4++) {
            if (!filter(cArr[i4]) && (i3 = i3 + 1) < i4) {
                cArr[i3] = cArr[i4];
            }
        }
        return (i3 - i) + 1;
    }
}
