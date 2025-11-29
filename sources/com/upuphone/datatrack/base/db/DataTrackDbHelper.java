package com.upuphone.datatrack.base.db;

import android.content.Context;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 12\u00020\u0001:\u00012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006H\u0007¢\u0006\u0004\b\u0017\u0010\u000bJ\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u0006\u0010\u0018\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\u0006\u0010\u0018\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\fH\u0007¢\u0006\u0004\b\u001d\u0010\u0010J\u001d\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u000e¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020%8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8BX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8BX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/upuphone/datatrack/base/db/DataTrackDbHelper;", "Lkotlinx/coroutines/CoroutineScope;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "Lcom/upuphone/datatrack/base/db/ReportType;", "reportTypes", "", "n", "(Ljava/util/List;)V", "", "eventName", "", "g", "(Ljava/lang/String;)I", "Lcom/upuphone/datatrack/base/db/AppTrack;", "appTrack", "m", "(Lcom/upuphone/datatrack/base/db/AppTrack;)V", "", "idList", "d", "count", "j", "(I)Ljava/util/List;", "l", "packageName", "k", "maxCount", "e", "(Ljava/lang/String;I)V", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lcom/upuphone/datatrack/base/db/ReportTypeDao;", "h", "()Lcom/upuphone/datatrack/base/db/ReportTypeDao;", "reportTypeDao", "Lcom/upuphone/datatrack/base/db/AppTrackDao;", "f", "()Lcom/upuphone/datatrack/base/db/AppTrackDao;", "appTrackDao", "c", "Companion", "datatrack-base_release"}, k = 1, mv = {1, 7, 1})
public final class DataTrackDbHelper implements CoroutineScope {
    public static final Companion c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Context f6389a;
    public final /* synthetic */ CoroutineScope b = CoroutineScopeKt.b();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/datatrack/base/db/DataTrackDbHelper$Companion;", "", "()V", "TAG", "", "datatrack-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public DataTrackDbHelper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f6389a = context;
    }

    public final void d(List list) {
        Intrinsics.checkNotNullParameter(list, "idList");
        Object unused = BuildersKt__BuildersKt.b((CoroutineContext) null, new DataTrackDbHelper$deleteAppTrackByIds$1(list, this, (Continuation<? super DataTrackDbHelper$deleteAppTrackByIds$1>) null), 1, (Object) null);
    }

    public final void e(String str, int i) {
        Intrinsics.checkNotNullParameter(str, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new DataTrackDbHelper$deleteOverLimitCount$1(this, str, i, (Continuation<? super DataTrackDbHelper$deleteOverLimitCount$1>) null), 3, (Object) null);
    }

    public final AppTrackDao f() {
        return DataTrackDB.f6387a.a(this.f6389a).f();
    }

    public final int g(String str) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        return ((Number) BuildersKt__BuildersKt.b((CoroutineContext) null, new DataTrackDbHelper$getEventType$1(this, str, (Continuation<? super DataTrackDbHelper$getEventType$1>) null), 1, (Object) null)).intValue();
    }

    public CoroutineContext getCoroutineContext() {
        return this.b.getCoroutineContext();
    }

    public final ReportTypeDao h() {
        return DataTrackDB.f6387a.a(this.f6389a).g();
    }

    public final List j(int i) {
        return (List) BuildersKt__BuildersKt.b((CoroutineContext) null, new DataTrackDbHelper$queryAppTrack$1(this, i, (Continuation<? super DataTrackDbHelper$queryAppTrack$1>) null), 1, (Object) null);
    }

    public final int k(String str) {
        Intrinsics.checkNotNullParameter(str, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        return ((Number) BuildersKt__BuildersKt.b((CoroutineContext) null, new DataTrackDbHelper$queryTrackCount$1(this, str, (Continuation<? super DataTrackDbHelper$queryTrackCount$1>) null), 1, (Object) null)).intValue();
    }

    public final List l(int i) {
        return (List) BuildersKt__BuildersKt.b((CoroutineContext) null, new DataTrackDbHelper$queryValidateAppTrack$1(this, i, (Continuation<? super DataTrackDbHelper$queryValidateAppTrack$1>) null), 1, (Object) null);
    }

    public final void m(AppTrack appTrack) {
        Intrinsics.checkNotNullParameter(appTrack, "appTrack");
        Object unused = BuildersKt__BuildersKt.b((CoroutineContext) null, new DataTrackDbHelper$saveAppTrackSync$1(appTrack, this, (Continuation<? super DataTrackDbHelper$saveAppTrackSync$1>) null), 1, (Object) null);
    }

    public final void n(List list) {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new DataTrackDbHelper$saveReportType$1(list, this, (Continuation<? super DataTrackDbHelper$saveReportType$1>) null), 3, (Object) null);
    }
}
