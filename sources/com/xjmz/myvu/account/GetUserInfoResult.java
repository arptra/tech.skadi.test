package com.xjmz.myvu.account;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001b\u001cB'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\rR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u000bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/xjmz/myvu/account/GetUserInfoResult;", "", "", "state", "", "userInfoJson", "Lcom/xjmz/myvu/account/GetUserInfoResult$ResultError;", "error", "<init>", "(ILjava/lang/String;Lcom/xjmz/myvu/account/GetUserInfoResult$ResultError;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "b", "Ljava/lang/String;", "c", "Lcom/xjmz/myvu/account/GetUserInfoResult$ResultError;", "getError", "()Lcom/xjmz/myvu/account/GetUserInfoResult$ResultError;", "d", "Companion", "ResultError", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class GetUserInfoResult {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final int f8221a;
    public final String b;
    public final ResultError c;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/xjmz/myvu/account/GetUserInfoResult$Companion;", "", "()V", "STATE_ERROR", "", "STATE_SUCC", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u000bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/xjmz/myvu/account/GetUserInfoResult$ResultError;", "", "", "code", "", "msg", "<init>", "(ILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getCode", "b", "Ljava/lang/String;", "getMsg", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class ResultError {

        /* renamed from: a  reason: collision with root package name */
        public final int f8222a;
        public final String b;

        public ResultError(int i, String str) {
            this.f8222a = i;
            this.b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResultError)) {
                return false;
            }
            ResultError resultError = (ResultError) obj;
            return this.f8222a == resultError.f8222a && Intrinsics.areEqual((Object) this.b, (Object) resultError.b);
        }

        public int hashCode() {
            int hashCode = Integer.hashCode(this.f8222a) * 31;
            String str = this.b;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            int i = this.f8222a;
            String str = this.b;
            return "ResultError(code=" + i + ", msg=" + str + ")";
        }
    }

    public GetUserInfoResult(int i, String str, ResultError resultError) {
        this.f8221a = i;
        this.b = str;
        this.c = resultError;
    }

    public final int a() {
        return this.f8221a;
    }

    public final String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetUserInfoResult)) {
            return false;
        }
        GetUserInfoResult getUserInfoResult = (GetUserInfoResult) obj;
        return this.f8221a == getUserInfoResult.f8221a && Intrinsics.areEqual((Object) this.b, (Object) getUserInfoResult.b) && Intrinsics.areEqual((Object) this.c, (Object) getUserInfoResult.c);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.f8221a) * 31;
        String str = this.b;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        ResultError resultError = this.c;
        if (resultError != null) {
            i = resultError.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        int i = this.f8221a;
        String str = this.b;
        ResultError resultError = this.c;
        return "GetUserInfoResult(state=" + i + ", userInfoJson=" + str + ", error=" + resultError + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetUserInfoResult(int i, String str, ResultError resultError, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : resultError);
    }
}
