package com.xjmz.myvu.flutter.pigeon.impl;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.xjmz.myvu.flutter.pigeon.AndroidRingStarryNetApi;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/xjmz/myvu/flutter/pigeon/impl/StarryNetApiHandler$sendMessage$1", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "onFail", "", "p0", "", "p1", "", "onSuccess", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StarryNetApiHandler$sendMessage$1 extends SendMessageListener {
    final /* synthetic */ byte[] $data;
    final /* synthetic */ StarryNetApiHandler this$0;

    public StarryNetApiHandler$sendMessage$1(StarryNetApiHandler starryNetApiHandler, byte[] bArr) {
        this.this$0 = starryNetApiHandler;
        this.$data = bArr;
    }

    public void onFail(@Nullable String str, int i) {
        AndroidRingStarryNetApi.SendMessageCallback O = this.this$0.l0();
        if (O != null) {
            O.d(Boolean.FALSE, Long.valueOf((long) i), new StarryVoidResult());
        }
        ULog.Delegate delegate = ULog.f6446a;
        String joinToString$default = ArraysKt.joinToString$default(this.$data, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
        delegate.g("StarryNetApiHandler", "sendMessage fail message: " + str + " code: " + i + " data: " + joinToString$default);
    }

    public void onSuccess(@Nullable String str) {
        AndroidRingStarryNetApi.SendMessageCallback O = this.this$0.l0();
        if (O != null) {
            O.d(Boolean.TRUE, 0L, new StarryVoidResult());
        }
    }
}
