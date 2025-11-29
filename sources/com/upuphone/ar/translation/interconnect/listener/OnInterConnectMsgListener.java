package com.upuphone.ar.translation.interconnect.listener;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/upuphone/ar/translation/interconnect/listener/OnInterConnectMsgListener;", "", "onInterConnectMessage", "", "msgCmd", "", "data", "", "bytes", "", "onRemoteDie", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface OnInterConnectMsgListener {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    void onInterConnectMessage(int i, String str, byte[] bArr);

    void onRemoteDie();
}
