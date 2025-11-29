package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.data.DataRewinder;
import java.nio.ByteBuffer;

public class ByteBufferRewinder implements DataRewinder<ByteBuffer> {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f2647a;

    public static class Factory implements DataRewinder.Factory<ByteBuffer> {
        public Class a() {
            return ByteBuffer.class;
        }

        /* renamed from: c */
        public DataRewinder b(ByteBuffer byteBuffer) {
            return new ByteBufferRewinder(byteBuffer);
        }
    }

    public ByteBufferRewinder(ByteBuffer byteBuffer) {
        this.f2647a = byteBuffer;
    }

    public void b() {
    }

    /* renamed from: c */
    public ByteBuffer a() {
        this.f2647a.position(0);
        return this.f2647a;
    }
}
