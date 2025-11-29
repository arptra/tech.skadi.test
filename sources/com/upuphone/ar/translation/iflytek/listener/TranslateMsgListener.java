package com.upuphone.ar.translation.iflytek.listener;

import com.upuphone.ar.translation.iflytek.listener.WebSocketMsgListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/upuphone/ar/translation/iflytek/listener/TranslateMsgListener;", "Lcom/upuphone/ar/translation/iflytek/listener/WebSocketMsgListener;", "", "result", "", "a", "(Ljava/lang/String;)V", "c", "state", "b", "onAsrReconnectStart", "()V", "onAsrReconnectSuccess", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public interface TranslateMsgListener extends WebSocketMsgListener {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void a(TranslateMsgListener translateMsgListener) {
        }

        public static void b(TranslateMsgListener translateMsgListener) {
        }

        public static void c(TranslateMsgListener translateMsgListener, int i, String str) {
            Intrinsics.checkNotNullParameter(str, "reason");
            WebSocketMsgListener.DefaultImpls.a(translateMsgListener, i, str);
        }

        public static void d(TranslateMsgListener translateMsgListener, int i, String str) {
            Intrinsics.checkNotNullParameter(str, "reason");
            WebSocketMsgListener.DefaultImpls.b(translateMsgListener, i, str);
        }

        public static void e(TranslateMsgListener translateMsgListener, Throwable th, Response response) {
            WebSocketMsgListener.DefaultImpls.c(translateMsgListener, th, response);
        }

        public static void f(TranslateMsgListener translateMsgListener, Response response) {
            WebSocketMsgListener.DefaultImpls.d(translateMsgListener, response);
        }

        public static void g(TranslateMsgListener translateMsgListener, String str) {
            Intrinsics.checkNotNullParameter(str, "result");
        }

        public static void h(TranslateMsgListener translateMsgListener, String str) {
            Intrinsics.checkNotNullParameter(str, "result");
        }

        public static void i(TranslateMsgListener translateMsgListener, String str) {
            Intrinsics.checkNotNullParameter(str, "state");
        }
    }

    void a(String str);

    void b(String str);

    void c(String str);

    void onAsrReconnectStart();

    void onAsrReconnectSuccess();
}
