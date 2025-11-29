package com.upuphone.star.httplib;

import com.upuphone.starrynet.payload.PayloadConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/upuphone/star/httplib/HttpResultException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "code", "", "msg", "", "rawContent", "(ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getRawContent", "super-http-lib_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HttpResultException extends Exception {
    private final int code;
    @NotNull
    private final String msg;
    @Nullable
    private final String rawContent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpResultException(int i, @NotNull String str, @Nullable String str2) {
        super("code=" + i + ", msg=" + str + ", rawContent='" + str2 + '\'');
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        this.code = i;
        this.msg = str;
        this.rawContent = str2;
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getMsg() {
        return this.msg;
    }

    @Nullable
    public final String getRawContent() {
        return this.rawContent;
    }
}
