package com.honey.account.l9;

import com.xjmz.ai.opus.OpusCodec;
import java.io.ByteArrayOutputStream;
import java.util.function.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ByteArrayOutputStream f7459a;

    public /* synthetic */ a(ByteArrayOutputStream byteArrayOutputStream) {
        this.f7459a = byteArrayOutputStream;
    }

    public final void accept(Object obj) {
        OpusCodec.lambda$byteList2ByteArr$0(this.f7459a, (byte[]) obj);
    }
}
