package com.xjmz.myvu.account;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001b\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0007R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/xjmz/myvu/account/XjTokenResult;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getState", "state", "b", "Ljava/lang/String;", "getToken", "token", "Lcom/xjmz/myvu/account/XjTokenResult$OriginError;", "c", "Lcom/xjmz/myvu/account/XjTokenResult$OriginError;", "getOriginError", "()Lcom/xjmz/myvu/account/XjTokenResult$OriginError;", "originError", "d", "Companion", "OriginError", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class XjTokenResult {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final int f8226a;
    public final String b;
    public final OriginError c;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/xjmz/myvu/account/XjTokenResult$Companion;", "", "()V", "STATE_ERROR", "", "STATE_SUCC", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0007R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/xjmz/myvu/account/XjTokenResult$OriginError;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getP0", "p0", "b", "Ljava/lang/String;", "getMsg", "msg", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class OriginError {

        /* renamed from: a  reason: collision with root package name */
        public final int f8227a;
        public final String b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OriginError)) {
                return false;
            }
            OriginError originError = (OriginError) obj;
            return this.f8227a == originError.f8227a && Intrinsics.areEqual((Object) this.b, (Object) originError.b);
        }

        public int hashCode() {
            int hashCode = Integer.hashCode(this.f8227a) * 31;
            String str = this.b;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            int i = this.f8227a;
            String str = this.b;
            return "OriginError(p0=" + i + ", msg=" + str + ")";
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof XjTokenResult)) {
            return false;
        }
        XjTokenResult xjTokenResult = (XjTokenResult) obj;
        return this.f8226a == xjTokenResult.f8226a && Intrinsics.areEqual((Object) this.b, (Object) xjTokenResult.b) && Intrinsics.areEqual((Object) this.c, (Object) xjTokenResult.c);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.f8226a) * 31;
        String str = this.b;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        OriginError originError = this.c;
        if (originError != null) {
            i = originError.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        int i = this.f8226a;
        String str = this.b;
        OriginError originError = this.c;
        return "XjTokenResult(state=" + i + ", token=" + str + ", originError=" + originError + ")";
    }
}
