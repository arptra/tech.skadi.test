package com.upuphone.star.fota.phone;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\fJ6\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/upuphone/star/fota/phone/BasicResult;", "T", "", "code", "", "msg", "", "data", "(ILjava/lang/String;Ljava/lang/Object;)V", "getCode", "()I", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "isSuccess", "", "()Z", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(ILjava/lang/String;Ljava/lang/Object;)Lcom/upuphone/star/fota/phone/BasicResult;", "equals", "other", "hashCode", "toString", "ar-fota-lib_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class BasicResult<T> {
    private final int code;
    @Nullable
    private final T data;
    @Nullable
    private final String msg;

    public BasicResult(int i, @Nullable String str, @Nullable T t) {
        this.code = i;
        this.msg = str;
        this.data = t;
    }

    public static /* synthetic */ BasicResult copy$default(BasicResult basicResult, int i, String str, T t, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = basicResult.code;
        }
        if ((i2 & 2) != 0) {
            str = basicResult.msg;
        }
        if ((i2 & 4) != 0) {
            t = basicResult.data;
        }
        return basicResult.copy(i, str, t);
    }

    public final int component1() {
        return this.code;
    }

    @Nullable
    public final String component2() {
        return this.msg;
    }

    @Nullable
    public final T component3() {
        return this.data;
    }

    @NotNull
    public final BasicResult<T> copy(int i, @Nullable String str, @Nullable T t) {
        return new BasicResult<>(i, str, t);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BasicResult)) {
            return false;
        }
        BasicResult basicResult = (BasicResult) obj;
        return this.code == basicResult.code && Intrinsics.areEqual((Object) this.msg, (Object) basicResult.msg) && Intrinsics.areEqual((Object) this.data, (Object) basicResult.data);
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final T getData() {
        return this.data;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.code) * 31;
        String str = this.msg;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        T t = this.data;
        if (t != null) {
            i = t.hashCode();
        }
        return hashCode2 + i;
    }

    public final boolean isSuccess() {
        return this.code == 0;
    }

    @NotNull
    public String toString() {
        int i = this.code;
        String str = this.msg;
        T t = this.data;
        return "BasicResult(code=" + i + ", msg=" + str + ", data=" + t + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BasicResult(int i, String str, Object obj, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? null : obj);
    }
}
