package com.upuphone.datatrack.sdk.reporter;

import com.upuphone.datatrack.base.utils.DataTrackHelper;
import com.upuphone.datatrack.base.utils.LogUtil;
import com.upuphone.datatrack.base.utils.XJDeviceUtil;
import com.upuphone.datatrack.sdk.XJDataTrack;
import com.upuphone.datatrack.sdk.XJHttpManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00048\u0002XD¢\u0006\u0006\n\u0004\b\u000b\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/upuphone/datatrack/sdk/reporter/InstantReporter;", "Lcom/upuphone/datatrack/sdk/reporter/DataTrackReporter;", "<init>", "()V", "", "packageName", "trackMsg", "eventName", "", "isSync", "", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Ljava/lang/String;", "TAG", "datatrack-sdk_release"}, k = 1, mv = {1, 7, 1})
public final class InstantReporter implements DataTrackReporter {

    /* renamed from: a  reason: collision with root package name */
    public final String f6420a = "InstantReporter";

    public void a(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(str2, "trackMsg");
        Intrinsics.checkNotNullParameter(str3, "eventName");
        String str4 = this.f6420a;
        LogUtil.b(str4, "reportEvent, packageName: " + str + ", eventName: " + str3 + ", trackMsg: " + str2);
        XJHttpManager.g(XJDataTrack.h().g()).m(DataTrackHelper.b(CollectionsKt.listOf(DataTrackHelper.d(str, str3, str2)), XJDeviceUtil.f(), XJDeviceUtil.h()), new InstantReporter$reportEvent$1(this, str3, str, str2, z));
    }
}
