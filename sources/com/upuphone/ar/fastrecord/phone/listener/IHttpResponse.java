package com.upuphone.ar.fastrecord.phone.listener;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/listener/IHttpResponse;", "", "onResponseFailure", "", "message", "", "code", "", "onResponseSuccess", "body", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface IHttpResponse {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void onResponseFailure$default(IHttpResponse iHttpResponse, String str, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    str = "";
                }
                iHttpResponse.onResponseFailure(str, i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onResponseFailure");
        }

        public static /* synthetic */ void onResponseSuccess$default(IHttpResponse iHttpResponse, String str, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    str = "";
                }
                iHttpResponse.onResponseSuccess(str, i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onResponseSuccess");
        }
    }

    void onResponseFailure(@Nullable String str, int i);

    void onResponseSuccess(@Nullable String str, int i);
}
