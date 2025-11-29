package io.netty.handler.ssl;

import io.netty.util.internal.EmptyArrays;
import java.util.Arrays;

final class OpenSslSessionId {
    static final OpenSslSessionId NULL_ID = new OpenSslSessionId(EmptyArrays.EMPTY_BYTES);
    private final int hashCode;
    private final byte[] id;

    public OpenSslSessionId(byte[] bArr) {
        this.id = bArr;
        this.hashCode = Arrays.hashCode(bArr);
    }

    public byte[] cloneBytes() {
        return (byte[]) this.id.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenSslSessionId)) {
            return false;
        }
        return Arrays.equals(this.id, ((OpenSslSessionId) obj).id);
    }

    public int hashCode() {
        return this.hashCode;
    }

    public String toString() {
        return "OpenSslSessionId{id=" + Arrays.toString(this.id) + '}';
    }
}
