package com.upuphone.ar.fastrecord.phone.listener;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/listener/RecordOnInterConnectMsgListener;", "", "onInterConnectMessage", "", "msgCmd", "", "data", "", "bytes", "", "onRemoteDie", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface RecordOnInterConnectMsgListener {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void onInterConnectMessage$default(RecordOnInterConnectMsgListener recordOnInterConnectMsgListener, int i, String str, byte[] bArr, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    str = null;
                }
                if ((i2 & 4) != 0) {
                    bArr = null;
                }
                recordOnInterConnectMsgListener.onInterConnectMessage(i, str, bArr);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onInterConnectMessage");
        }
    }

    void onInterConnectMessage(int i, @Nullable String str, @Nullable byte[] bArr);

    void onRemoteDie();
}
