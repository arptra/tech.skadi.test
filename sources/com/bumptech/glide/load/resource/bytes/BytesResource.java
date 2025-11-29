package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

public class BytesResource implements Resource<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f2648a;

    public BytesResource(byte[] bArr) {
        this.f2648a = (byte[]) Preconditions.d(bArr);
    }

    public void a() {
    }

    public int b() {
        return this.f2648a.length;
    }

    public Class c() {
        return byte[].class;
    }

    /* renamed from: d */
    public byte[] get() {
        return this.f2648a;
    }
}
