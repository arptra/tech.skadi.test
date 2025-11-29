package com.google.android.gms.internal.mlkit_language_id_common;

import androidx.annotation.NonNull;
import java.io.OutputStream;

final class zzaj extends OutputStream {
    private long zza = 0;

    public final void write(int i) {
        this.zza++;
    }

    public final long zza() {
        return this.zza;
    }

    public final void write(byte[] bArr) {
        this.zza += (long) bArr.length;
    }

    public final void write(@NonNull byte[] bArr, int i, int i2) {
        int length;
        int i3;
        if (i < 0 || i > (length = bArr.length) || i2 < 0 || (i3 = i + i2) > length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.zza += (long) i2;
    }
}
