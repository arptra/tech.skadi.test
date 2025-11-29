package androidx.webkit.internal;

import java.util.Objects;
import org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface;

public class WebMessagePayloadAdapter implements WebMessagePayloadBoundaryInterface {

    /* renamed from: a  reason: collision with root package name */
    public final int f1981a;
    public final String b;
    public final byte[] c;

    public WebMessagePayloadAdapter(String str) {
        this.f1981a = 0;
        this.b = str;
        this.c = null;
    }

    public final void a(int i) {
        if (this.f1981a != i) {
            throw new IllegalStateException("Expected " + i + ", but type is " + this.f1981a);
        }
    }

    public byte[] getAsArrayBuffer() {
        a(1);
        byte[] bArr = this.c;
        Objects.requireNonNull(bArr);
        return bArr;
    }

    public String getAsString() {
        a(0);
        return this.b;
    }

    public String[] getSupportedFeatures() {
        return new String[0];
    }

    public int getType() {
        return this.f1981a;
    }

    public WebMessagePayloadAdapter(byte[] bArr) {
        this.f1981a = 1;
        this.b = null;
        this.c = bArr;
    }
}
