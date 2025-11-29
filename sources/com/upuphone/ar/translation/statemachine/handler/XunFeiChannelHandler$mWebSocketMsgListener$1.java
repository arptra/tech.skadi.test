package com.upuphone.ar.translation.statemachine.handler;

import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.iflytek.entity.TranslationError;
import com.upuphone.ar.translation.iflytek.listener.TranslateMsgListener;
import com.upuphone.ar.translation.statemachine.bean.AsrTtsResult;
import com.upuphone.ar.translation.utils.GsonUtils;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0014\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"com/upuphone/ar/translation/statemachine/handler/XunFeiChannelHandler$mWebSocketMsgListener$1", "Lcom/upuphone/ar/translation/iflytek/listener/TranslateMsgListener;", "", "result", "", "a", "(Ljava/lang/String;)V", "c", "state", "b", "onAsrReconnectStart", "()V", "onAsrReconnectSuccess", "Lokhttp3/Response;", "response", "onOpen", "(Lokhttp3/Response;)V", "", "throwable", "reason", "onFailure", "(Ljava/lang/Throwable;Lokhttp3/Response;)V", "", "code", "onClosing", "(ILjava/lang/String;)V", "onClosed", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class XunFeiChannelHandler$mWebSocketMsgListener$1 implements TranslateMsgListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XunFeiChannelHandler f6356a;

    public XunFeiChannelHandler$mWebSocketMsgListener$1(XunFeiChannelHandler xunFeiChannelHandler) {
        this.f6356a = xunFeiChannelHandler;
    }

    public void a(String str) {
        Intrinsics.checkNotNullParameter(str, "result");
        TranslateMsgListener.DefaultImpls.h(this, str);
        this.f6356a.f6354a.x(new AsrTtsResult(str, (byte[]) null));
    }

    public void b(String str) {
        Intrinsics.checkNotNullParameter(str, "state");
        TranslateMsgListener.DefaultImpls.i(this, str);
        LogExt.j("TranslateMsgListener onTranslateRunningState=" + str, "XunFeiChannelHandler");
        try {
            Object a2 = GsonUtils.a(str, TranslationError.class);
            XunFeiChannelHandler xunFeiChannelHandler = this.f6356a;
            if (Intrinsics.areEqual((Object) ((TranslationError) a2).getAction(), (Object) "error")) {
                xunFeiChannelHandler.f6354a.s(0);
            } else {
                xunFeiChannelHandler.f6354a.A(str);
            }
        } catch (Exception e) {
            String stackTraceToString = ExceptionsKt.stackTraceToString(e);
            LogExt.j("TranslateMsgListener 解析RunningState失败, error=" + stackTraceToString, "XunFeiChannelHandler");
        }
    }

    public void c(String str) {
        Intrinsics.checkNotNullParameter(str, "result");
        TranslateMsgListener.DefaultImpls.g(this, str);
        this.f6356a.f6354a.w(new AsrTtsResult(str, (byte[]) null));
    }

    public void onAsrReconnectStart() {
        TranslateMsgListener.DefaultImpls.a(this);
        this.f6356a.p();
    }

    public void onAsrReconnectSuccess() {
        TranslateMsgListener.DefaultImpls.b(this);
        this.f6356a.q();
    }

    public void onClosed(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "reason");
        TranslateMsgListener.DefaultImpls.c(this, i, str);
        LogExt.j("TranslateMsgListener onClosed=" + i + ", reason=" + str, "XunFeiChannelHandler");
        this.f6356a.w();
    }

    public void onClosing(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "reason");
        TranslateMsgListener.DefaultImpls.d(this, i, str);
        LogExt.j("TranslateMsgListener onClosing", "XunFeiChannelHandler");
    }

    public void onFailure(Throwable th, Response response) {
        TranslateMsgListener.DefaultImpls.e(this, th, response);
        LogExt.j("TranslateMsgListener onFailure", "XunFeiChannelHandler");
        this.f6356a.x(response);
    }

    public void onOpen(Response response) {
        TranslateMsgListener.DefaultImpls.f(this, response);
        this.f6356a.y();
    }
}
