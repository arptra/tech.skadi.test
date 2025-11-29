package com.upuphone.datatrack.sdk.reporter;

import com.upuphone.datatrack.base.db.XJDataBaseManager;
import com.upuphone.datatrack.base.utils.LogUtil;
import com.upuphone.datatrack.sdk.XJDataTrack;
import com.upuphone.datatrack.sdk.XJHttpManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/upuphone/datatrack/sdk/reporter/InstantReporter$reportEvent$1", "Lcom/upuphone/datatrack/sdk/XJHttpManager$UploadCallback;", "", "onSuccess", "()V", "", "errCode", "", "errMsg", "a", "(ILjava/lang/String;)V", "datatrack-sdk_release"}, k = 1, mv = {1, 7, 1})
public final class InstantReporter$reportEvent$1 implements XJHttpManager.UploadCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InstantReporter f6421a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ boolean e;

    public InstantReporter$reportEvent$1(InstantReporter instantReporter, String str, String str2, String str3, boolean z) {
        this.f6421a = instantReporter;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = z;
    }

    public void a(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "errMsg");
        String b2 = this.f6421a.f6420a;
        LogUtil.c(b2, "reportEvent, eventName: " + this.b + ", upload fail: " + i + ", " + str);
        XJDataBaseManager.d(XJDataTrack.h().g()).e(this.c, this.d, this.b, this.e);
    }

    public void onSuccess() {
        String b2 = this.f6421a.f6420a;
        LogUtil.e(b2, "reportEvent, eventName: " + this.b + ", upload success");
    }
}
