package com.upuphone.xr.sapp.monitor.notification;

import android.content.Context;
import com.android.dingtalk.openauth.utils.DDAuthConstant;
import com.google.gson.Gson;
import com.upuphone.sdk.Regular;
import com.upuphone.xr.sapp.monitor.notification.model.AppNotifyConfigModel;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/AppConfigHelper;", "", "<init>", "()V", "", "f", "", "packageName", "Lcom/upuphone/xr/sapp/monitor/notification/model/AppNotifyConfigModel;", "c", "(Ljava/lang/String;)Lcom/upuphone/xr/sapp/monitor/notification/model/AppNotifyConfigModel;", "config", "g", "(Lcom/upuphone/xr/sapp/monitor/notification/model/AppNotifyConfigModel;)V", "", "e", "(Ljava/lang/String;)Z", "", "a", "[Ljava/lang/String;", "getImPackageArray", "()[Ljava/lang/String;", "imPackageArray", "b", "d", "imPackageDialogArray", "", "Ljava/util/List;", "enableAppArray", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nAppConfigHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppConfigHelper.kt\ncom/upuphone/xr/sapp/monitor/notification/AppConfigHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,138:1\n766#2:139\n857#2,2:140\n766#2:142\n857#2,2:143\n766#2:145\n857#2,2:146\n*S KotlinDebug\n*F\n+ 1 AppConfigHelper.kt\ncom/upuphone/xr/sapp/monitor/notification/AppConfigHelper\n*L\n88#1:139\n88#1:140,2\n110#1:142\n110#1:143,2\n127#1:145\n127#1:146,2\n*E\n"})
public final class AppConfigHelper {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);
    public static AppConfigHelper e;

    /* renamed from: a  reason: collision with root package name */
    public final String[] f7745a = {"com.tencent.mm", "com.tencent.mobileqq", DDAuthConstant.DD_APP_PACKAGE, "com.ss.android.lark", "com.tencent.wework"};
    public final String[] b = {"com.tencent.mm", DDAuthConstant.DD_APP_PACKAGE};
    public final List c = new ArrayList();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/AppConfigHelper$Companion;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/monitor/notification/AppConfigHelper;", "a", "()Lcom/upuphone/xr/sapp/monitor/notification/AppConfigHelper;", "", "NOTIFICATION_ENABLE_PACKAGE_KEY", "Ljava/lang/String;", "helper", "Lcom/upuphone/xr/sapp/monitor/notification/AppConfigHelper;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppConfigHelper a() {
            if (AppConfigHelper.e == null) {
                AppConfigHelper.e = new AppConfigHelper();
            }
            AppConfigHelper a2 = AppConfigHelper.e;
            Intrinsics.checkNotNull(a2);
            return a2;
        }

        public Companion() {
        }
    }

    public AppConfigHelper() {
        f();
    }

    public final AppNotifyConfigModel c(String str) {
        Intrinsics.checkNotNullParameter(str, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        List list = this.c;
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (Intrinsics.areEqual((Object) ((AppNotifyConfigModel) next).getPackageName(), (Object) str)) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            return (AppNotifyConfigModel) CollectionsKt.first(arrayList);
        }
        AppNotifyConfigModel appNotifyConfigModel = new AppNotifyConfigModel(str, false, false, false, 14, (DefaultConstructorMarker) null);
        if (Regular.a(str) || Regular.b(str)) {
            appNotifyConfigModel.setDisableState(false);
        }
        if (ArraysKt.contains((T[]) this.f7745a, str)) {
            appNotifyConfigModel.setShowAllNotify(true);
        }
        return appNotifyConfigModel;
    }

    public final String[] d() {
        return this.b;
    }

    public final boolean e(String str) {
        Intrinsics.checkNotNullParameter(str, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        List list = this.c;
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (Intrinsics.areEqual((Object) ((AppNotifyConfigModel) next).getPackageName(), (Object) str)) {
                arrayList.add(next);
            }
        }
        return arrayList.isEmpty() ^ true ? ((AppNotifyConfigModel) CollectionsKt.first(arrayList)).getDisableState() : !Regular.a(str) && !Regular.b(str);
    }

    public final void f() {
        String str = (String) DataStoreUtils.j(DataStoreUtils.e.a(), "notification_enable_package_key", "", true, (Context) null, 8, (Object) null);
        if (str.length() > 0) {
            List list = (List) new Gson().fromJson(str, new AppConfigHelper$restCache$packages$1().getType());
            this.c.clear();
            List list2 = this.c;
            Intrinsics.checkNotNull(list);
            list2.addAll(list);
        }
    }

    public final void g(AppNotifyConfigModel appNotifyConfigModel) {
        Intrinsics.checkNotNullParameter(appNotifyConfigModel, "config");
        List list = this.c;
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (Intrinsics.areEqual((Object) ((AppNotifyConfigModel) next).getPackageName(), (Object) appNotifyConfigModel.getPackageName())) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            this.c.removeAll(arrayList);
        }
        this.c.add(appNotifyConfigModel);
        DataStoreUtils.e.a().p("notification_enable_package_key", new Gson().toJson((Object) this.c), true);
    }
}
