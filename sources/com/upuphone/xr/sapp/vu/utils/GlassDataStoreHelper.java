package com.upuphone.xr.sapp.vu.utils;

import android.content.Context;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynet.payload.PayloadConstant;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.PhoneTypeUtils;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0010J\u0015\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0016J\r\u0010\u0018\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0012J\u0015\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\r¢\u0006\u0004\b\u001a\u0010\u0010J\r\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\bJ\u0015\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0004¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010\b¨\u0006#"}, d2 = {"Lcom/upuphone/xr/sapp/vu/utils/GlassDataStoreHelper;", "", "<init>", "()V", "", "modelId", "", "k", "(Ljava/lang/String;)V", "h", "", "a", "()Ljava/util/List;", "", "autoOpen", "j", "(Z)V", "d", "()Z", "i", "defaultValue", "c", "(Z)Z", "f", "e", "isFirst", "n", "b", "()Ljava/lang/String;", "language", "m", "sn", "g", "(Ljava/lang/String;)Z", "l", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nGlassDataStoreHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassDataStoreHelper.kt\ncom/upuphone/xr/sapp/vu/utils/GlassDataStoreHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,135:1\n766#2:136\n857#2,2:137\n*S KotlinDebug\n*F\n+ 1 GlassDataStoreHelper.kt\ncom/upuphone/xr/sapp/vu/utils/GlassDataStoreHelper\n*L\n41#1:136\n41#1:137,2\n*E\n"})
public final class GlassDataStoreHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final GlassDataStoreHelper f8091a = new GlassDataStoreHelper();

    public final List a() {
        List split$default = StringsKt.split$default((CharSequence) StringsKt.trim((String) DataStoreUtils.i(DataStoreUtils.e.a(), "device_connect_history_list", "", (Context) null, 4, (Object) null), StringUtil.COMMA), new String[]{MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object next : split$default) {
            if (!StringsKt.isBlank((String) next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public final String b() {
        return (String) DataStoreUtils.i(DataStoreUtils.e.a(), "sp_vu_glass_language", "zh-CN", (Context) null, 4, (Object) null);
    }

    public final boolean c(boolean z) {
        return ((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "vu_anti_shake", Boolean.valueOf(z), (Context) null, 4, (Object) null)).booleanValue();
    }

    public final boolean d() {
        if (PhoneTypeUtils.f7912a.h()) {
            return ((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "vu_auto_open_ar_space", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue();
        }
        return false;
    }

    public final boolean e() {
        return ((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "vu_is_first_show_touchpad", Boolean.TRUE, (Context) null, 4, (Object) null)).booleanValue();
    }

    public final boolean f(boolean z) {
        return ((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "vu_keep_view_horizontal", Boolean.valueOf(z), (Context) null, 4, (Object) null)).booleanValue();
    }

    public final boolean g(String str) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_STR_SN);
        return ((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "sp_view_glass_active_" + str, Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue();
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "modelId");
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        companion.a().o("device_connect_history_list", StringsKt.replace$default((String) DataStoreUtils.i(companion.a(), "device_connect_history_list", "", (Context) null, 4, (Object) null), str + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA, "", false, 4, (Object) null));
    }

    public final void i(boolean z) {
        DataStoreUtils.e.a().o("vu_anti_shake", Boolean.valueOf(z));
    }

    public final void j(boolean z) {
        DataStoreUtils.e.a().o("vu_auto_open_ar_space", Boolean.valueOf(z));
    }

    public final void k(String str) {
        Intrinsics.checkNotNullParameter(str, "modelId");
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        String str2 = (String) DataStoreUtils.i(companion.a(), "device_connect_history_list", "", (Context) null, 4, (Object) null);
        if (StringsKt.indexOf$default((CharSequence) str2, str, 0, false, 6, (Object) null) >= 0) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("GlassDataStoreHelper", "saveDeviceTypeHistory " + str + " has been saved");
            return;
        }
        companion.a().o("device_connect_history_list", str2 + str + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
    }

    public final void l(String str) {
        Intrinsics.checkNotNullParameter(str, PayloadConstant.PARAMS_KEY_STR_SN);
        DataStoreUtils.e.a().o("sp_view_glass_active_" + str, Boolean.TRUE);
    }

    public final void m(String str) {
        Intrinsics.checkNotNullParameter(str, "language");
        DataStoreUtils.e.a().o("sp_vu_glass_language", str);
    }

    public final void n(boolean z) {
        DataStoreUtils.e.a().o("vu_is_first_show_touchpad", Boolean.valueOf(z));
    }
}
