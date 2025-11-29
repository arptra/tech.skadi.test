package com.honey.account.wb;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.apache.commons.io.output.AbstractByteArrayOutputStream;

public final /* synthetic */ class a implements AbstractByteArrayOutputStream.InputStreamConstructor {
    public final InputStream construct(byte[] bArr, int i, int i2) {
        return new ByteArrayInputStream(bArr, i, i2);
    }
}
