package com.upuphone.star.httplib;

import com.upuphone.starrynet.payload.PayloadConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B/\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u0004\u0018\u00018\u00008\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u000e\u0010\u0013R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0018\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/upuphone/star/httplib/HttpResult;", "T", "", "", "code", "", "msg", "data", "rawContent", "<init>", "(ILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "a", "I", "()I", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "Ljava/lang/Object;", "()Ljava/lang/Object;", "d", "", "e", "()Z", "isSuccess", "super-http-lib_release"}, k = 1, mv = {1, 8, 0})
public final class HttpResult<T> {

    /* renamed from: a  reason: collision with root package name */
    public final int f6478a;
    public final String b;
    public final Object c;
    public final String d;

    public HttpResult(int i, String str, Object obj, String str2) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        this.f6478a = i;
        this.b = str;
        this.c = obj;
        this.d = str2;
    }

    public final int a() {
        return this.f6478a;
    }

    public final Object b() {
        return this.c;
    }

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.d;
    }

    public final boolean e() {
        return this.f6478a == 200;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HttpResult(int i, String str, Object obj, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? null : obj, (i2 & 8) != 0 ? null : str2);
    }
}
