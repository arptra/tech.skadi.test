package com.upuphone.ar.translation.iflytek.listener;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000f"}, d2 = {"Lcom/upuphone/ar/translation/iflytek/listener/WebSocketMsgListener;", "", "onClosed", "", "code", "", "reason", "", "onClosing", "onFailure", "throwable", "", "Lokhttp3/Response;", "onOpen", "response", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface WebSocketMsgListener {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void a(WebSocketMsgListener webSocketMsgListener, int i, String str) {
            Intrinsics.checkNotNullParameter(str, "reason");
        }

        public static void b(WebSocketMsgListener webSocketMsgListener, int i, String str) {
            Intrinsics.checkNotNullParameter(str, "reason");
        }

        public static void c(WebSocketMsgListener webSocketMsgListener, Throwable th, Response response) {
        }

        public static void d(WebSocketMsgListener webSocketMsgListener, Response response) {
        }
    }

    void onClosed(int i, String str);

    void onClosing(int i, String str);

    void onFailure(Throwable th, Response response);

    void onOpen(Response response);
}
