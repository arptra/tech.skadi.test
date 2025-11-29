package com.honey.account.wb;

import java.io.InputStream;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.commons.io.output.AbstractByteArrayOutputStream;

public final /* synthetic */ class e implements AbstractByteArrayOutputStream.InputStreamConstructor {
    public final InputStream construct(byte[] bArr, int i, int i2) {
        return new UnsynchronizedByteArrayInputStream(bArr, i, i2);
    }
}
