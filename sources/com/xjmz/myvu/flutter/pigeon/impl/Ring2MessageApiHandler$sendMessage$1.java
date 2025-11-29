package com.xjmz.myvu.flutter.pigeon.impl;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.api.StarryNetMessageOperator;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.xjmz.myvu.flutter.pigeon.AndroidRing2MessageApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/xr/interconnect/api/StarryNetMessageOperator;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class Ring2MessageApiHandler$sendMessage$1 extends Lambda implements Function1<StarryNetMessageOperator, Unit> {
    final /* synthetic */ AndroidRing2MessageApi.Ring2Message $message;
    final /* synthetic */ AndroidRing2MessageApi.Result<Boolean> $result;
    final /* synthetic */ StarryNetMessage $starryMessage;
    final /* synthetic */ Ring2MessageApiHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Ring2MessageApiHandler$sendMessage$1(Ring2MessageApiHandler ring2MessageApiHandler, StarryNetMessage starryNetMessage, AndroidRing2MessageApi.Ring2Message ring2Message, AndroidRing2MessageApi.Result<Boolean> result) {
        super(1);
        this.this$0 = ring2MessageApiHandler;
        this.$starryMessage = starryNetMessage;
        this.$message = ring2Message;
        this.$result = result;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((StarryNetMessageOperator) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull StarryNetMessageOperator starryNetMessageOperator) {
        Intrinsics.checkNotNullParameter(starryNetMessageOperator, "it");
        ULog.Delegate delegate = ULog.f6446a;
        String h = this.this$0.p(this.$starryMessage);
        delegate.g("Ring2MessageApiHandler", "发送消息: " + h);
        StarryNetMessage starryNetMessage = this.$starryMessage;
        final AndroidRing2MessageApi.Ring2Message ring2Message = this.$message;
        final AndroidRing2MessageApi.Result<Boolean> result = this.$result;
        starryNetMessageOperator.sendMessage2(starryNetMessage, new SendMessageListener() {
            public void onFail(@NotNull String str, int i) {
                Intrinsics.checkNotNullParameter(str, "p0");
                ULog.Delegate delegate = ULog.f6446a;
                String g = ring2Message.g();
                delegate.g("Ring2MessageApiHandler", "appId: " + g + " sendMessage onFail message: " + str + " code: " + i);
                result.success(Boolean.FALSE);
            }

            public void onSuccess(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "p0");
                ULog.Delegate delegate = ULog.f6446a;
                String g = ring2Message.g();
                delegate.g("Ring2MessageApiHandler", "appId: " + g + " sendMessage onSuccess: " + str);
                result.success(Boolean.TRUE);
            }
        });
    }
}
