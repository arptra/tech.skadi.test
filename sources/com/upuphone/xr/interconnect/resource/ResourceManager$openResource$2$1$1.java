package com.upuphone.xr.interconnect.resource;

import com.upuphone.xr.interconnect.common.IResourceManager;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.interconnect.util.log.ILog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/upuphone/xr/interconnect/resource/ResourceManager$openResource$2$1$1", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "onFail", "", "msgId", "", "errorCode", "", "onSuccess", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ResourceManager$openResource$2$1$1 extends SendMessageListener {
    final /* synthetic */ CancellableContinuation<Unit> $continuation;
    final /* synthetic */ String $identifier;
    final /* synthetic */ byte $type;

    public ResourceManager$openResource$2$1$1(String str, byte b, CancellableContinuation<? super Unit> cancellableContinuation) {
        this.$identifier = str;
        this.$type = b;
        this.$continuation = cancellableContinuation;
    }

    public void onFail(@Nullable String str, int i) {
        String str2 = this.$identifier;
        byte b = this.$type;
        ILog.d(IResourceManager.TAG, "Message to open " + str2 + "(" + b + ") not sent due to error " + i + ": " + str + ".");
        CancellableContinuation<Unit> cancellableContinuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m20constructorimpl(Unit.INSTANCE));
    }

    public void onSuccess(@Nullable String str) {
        String str2 = this.$identifier;
        byte b = this.$type;
        ILog.d(IResourceManager.TAG, "Message to open " + str2 + "(" + b + ") successfully sent.");
        CancellableContinuation<Unit> cancellableContinuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m20constructorimpl(Unit.INSTANCE));
    }
}
