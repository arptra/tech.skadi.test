package com.xjmz.myvu.account;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001f B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u000fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u001a\u001a\u0004\b\u0014\u0010\u001bR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001c\u001a\u0004\b\u0017\u0010\u001d¨\u0006!"}, d2 = {"Lcom/xjmz/myvu/account/MzTokenResult;", "", "", "state", "", "token", "Landroid/content/Intent;", "intent", "Lcom/xjmz/myvu/account/MzTokenResult$OriginError;", "originError", "<init>", "(ILjava/lang/String;Landroid/content/Intent;Lcom/xjmz/myvu/account/MzTokenResult$OriginError;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "c", "b", "Ljava/lang/String;", "d", "Landroid/content/Intent;", "()Landroid/content/Intent;", "Lcom/xjmz/myvu/account/MzTokenResult$OriginError;", "()Lcom/xjmz/myvu/account/MzTokenResult$OriginError;", "e", "Companion", "OriginError", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class MzTokenResult {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final int f8223a;
    public final String b;
    public final Intent c;
    public final OriginError d;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/xjmz/myvu/account/MzTokenResult$Companion;", "", "()V", "STATE_ERROR", "", "STATE_HANDLE_INTENT", "STATE_SUCCESS", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0012\u001a\u0004\b\u0011\u0010\fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/xjmz/myvu/account/MzTokenResult$OriginError;", "", "", "p0", "p1", "", "msg", "<init>", "(IILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getP0", "b", "c", "Ljava/lang/String;", "getMsg", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class OriginError {

        /* renamed from: a  reason: collision with root package name */
        public final int f8224a;
        public final int b;
        public final String c;

        public OriginError(int i, int i2, String str) {
            this.f8224a = i;
            this.b = i2;
            this.c = str;
        }

        public final int a() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OriginError)) {
                return false;
            }
            OriginError originError = (OriginError) obj;
            return this.f8224a == originError.f8224a && this.b == originError.b && Intrinsics.areEqual((Object) this.c, (Object) originError.c);
        }

        public int hashCode() {
            int hashCode = ((Integer.hashCode(this.f8224a) * 31) + Integer.hashCode(this.b)) * 31;
            String str = this.c;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            int i = this.f8224a;
            int i2 = this.b;
            String str = this.c;
            return "OriginError(p0=" + i + ", p1=" + i2 + ", msg=" + str + ")";
        }
    }

    public MzTokenResult(int i, String str, Intent intent, OriginError originError) {
        this.f8223a = i;
        this.b = str;
        this.c = intent;
        this.d = originError;
    }

    public final Intent a() {
        return this.c;
    }

    public final OriginError b() {
        return this.d;
    }

    public final int c() {
        return this.f8223a;
    }

    public final String d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MzTokenResult)) {
            return false;
        }
        MzTokenResult mzTokenResult = (MzTokenResult) obj;
        return this.f8223a == mzTokenResult.f8223a && Intrinsics.areEqual((Object) this.b, (Object) mzTokenResult.b) && Intrinsics.areEqual((Object) this.c, (Object) mzTokenResult.c) && Intrinsics.areEqual((Object) this.d, (Object) mzTokenResult.d);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.f8223a) * 31;
        String str = this.b;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Intent intent = this.c;
        int hashCode3 = (hashCode2 + (intent == null ? 0 : intent.hashCode())) * 31;
        OriginError originError = this.d;
        if (originError != null) {
            i = originError.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        int i = this.f8223a;
        String str = this.b;
        Intent intent = this.c;
        OriginError originError = this.d;
        return "MzTokenResult(state=" + i + ", token=" + str + ", intent=" + intent + ", originError=" + originError + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MzTokenResult(int i, String str, Intent intent, OriginError originError, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : intent, (i2 & 8) != 0 ? null : originError);
    }
}
