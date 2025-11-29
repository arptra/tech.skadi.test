package com.upuphone.star.fota.phone;

import com.upuphone.starrynet.payload.PayloadConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/star/fota/phone/GlassUpdateException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "code", "", "msg", "", "(ILjava/lang/String;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "ar-fota-lib_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GlassUpdateException extends Exception {
    private final int code;
    @NotNull
    private final String msg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassUpdateException(int i, @NotNull String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        this.code = i;
        this.msg = str;
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getMsg() {
        return this.msg;
    }
}
