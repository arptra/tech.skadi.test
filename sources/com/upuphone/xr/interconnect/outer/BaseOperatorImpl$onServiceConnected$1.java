package com.upuphone.xr.interconnect.outer;

import android.util.Log;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "R", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class BaseOperatorImpl$onServiceConnected$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BaseOperatorImpl<R> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseOperatorImpl$onServiceConnected$1(BaseOperatorImpl<R> baseOperatorImpl) {
        super(0);
        this.this$0 = baseOperatorImpl;
    }

    public final void invoke() {
        Object invoke = this.this$0.remoteProxyGetter.invoke();
        if (invoke == null) {
            Log.e(this.this$0.getTag(), "Got null proxy when service is already connected!");
            return;
        }
        String access$getTag = this.this$0.getTag();
        Log.i(access$getTag, "Got proxy " + invoke + '.');
        this.this$0.remoteProxy = invoke;
    }
}
