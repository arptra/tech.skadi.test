package com.upuphone.datatrack.base.utils;

import com.upuphone.datatrack.base.db.AppTrack;
import com.upuphone.datatrack.base.model.XJTrackData;
import com.upuphone.starrynet.payload.PayloadConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\fJ7\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\r\u0010\fJ#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/upuphone/datatrack/base/utils/DataTrackHelper;", "", "<init>", "()V", "", "Lcom/upuphone/datatrack/base/db/AppTrack;", "appTrackList", "", "iotDeviceId", "iotDeviceRom", "Lcom/upuphone/datatrack/base/model/XJTrackData;", "a", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "b", "trackList", "", "c", "(Ljava/util/List;)Ljava/util/List;", "packageName", "eventName", "msg", "d", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/upuphone/datatrack/base/db/AppTrack;", "datatrack-base_release"}, k = 1, mv = {1, 7, 1})
public final class DataTrackHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final DataTrackHelper f6398a = new DataTrackHelper();

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x000e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List a(java.util.List r12, java.lang.String r13, java.lang.String r14) {
        /*
            java.lang.String r0 = "appTrackList"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r12 = r12.iterator()
        L_0x000e:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L_0x0071
            java.lang.Object r1 = r12.next()
            com.upuphone.datatrack.base.db.AppTrack r1 = (com.upuphone.datatrack.base.db.AppTrack) r1
            java.lang.String r2 = r1.getIotDeviceId()
            r3 = 0
            if (r2 == 0) goto L_0x002e
            int r4 = r2.length()
            if (r4 <= 0) goto L_0x0028
            goto L_0x0029
        L_0x0028:
            r2 = r3
        L_0x0029:
            if (r2 != 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r10 = r2
            goto L_0x002f
        L_0x002e:
            r10 = r13
        L_0x002f:
            java.lang.String r2 = r1.getIotDeviceRom()
            if (r2 == 0) goto L_0x0042
            int r4 = r2.length()
            if (r4 <= 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r2 = r3
        L_0x003d:
            if (r2 != 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r11 = r2
            goto L_0x0043
        L_0x0042:
            r11 = r14
        L_0x0043:
            if (r10 == 0) goto L_0x006b
            int r2 = r10.length()
            if (r2 != 0) goto L_0x004c
            goto L_0x006b
        L_0x004c:
            if (r11 == 0) goto L_0x006b
            int r2 = r11.length()
            if (r2 != 0) goto L_0x0055
            goto L_0x006b
        L_0x0055:
            com.upuphone.datatrack.base.model.XJTrackData r3 = new com.upuphone.datatrack.base.model.XJTrackData
            long r5 = r1.getId()
            java.lang.String r7 = r1.getPackageName()
            java.lang.String r8 = r1.getName()
            java.lang.String r9 = r1.getMsg()
            r4 = r3
            r4.<init>(r5, r7, r8, r9, r10, r11)
        L_0x006b:
            if (r3 == 0) goto L_0x000e
            r0.add(r3)
            goto L_0x000e
        L_0x0071:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.datatrack.base.utils.DataTrackHelper.a(java.util.List, java.lang.String, java.lang.String):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (r3 == null) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002f, code lost:
        if (r2 == null) goto L_0x0031;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List b(java.util.List r13, java.lang.String r14, java.lang.String r15) {
        /*
            java.lang.String r0 = "appTrackList"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r13, r1)
            r0.<init>(r1)
            java.util.Iterator r13 = r13.iterator()
        L_0x0014:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L_0x0068
            java.lang.Object r1 = r13.next()
            com.upuphone.datatrack.base.db.AppTrack r1 = (com.upuphone.datatrack.base.db.AppTrack) r1
            java.lang.String r2 = r1.getIotDeviceId()
            r3 = 0
            if (r2 == 0) goto L_0x0031
            int r4 = r2.length()
            if (r4 <= 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r2 = r3
        L_0x002f:
            if (r2 != 0) goto L_0x0032
        L_0x0031:
            r2 = r14
        L_0x0032:
            java.lang.String r4 = r1.getIotDeviceRom()
            if (r4 == 0) goto L_0x0041
            int r5 = r4.length()
            if (r5 <= 0) goto L_0x003f
            r3 = r4
        L_0x003f:
            if (r3 != 0) goto L_0x0042
        L_0x0041:
            r3 = r15
        L_0x0042:
            com.upuphone.datatrack.base.model.XJTrackData r12 = new com.upuphone.datatrack.base.model.XJTrackData
            long r5 = r1.getId()
            java.lang.String r7 = r1.getPackageName()
            java.lang.String r8 = r1.getName()
            java.lang.String r9 = r1.getMsg()
            java.lang.String r1 = ""
            if (r2 != 0) goto L_0x005a
            r10 = r1
            goto L_0x005b
        L_0x005a:
            r10 = r2
        L_0x005b:
            if (r3 != 0) goto L_0x005f
            r11 = r1
            goto L_0x0060
        L_0x005f:
            r11 = r3
        L_0x0060:
            r4 = r12
            r4.<init>(r5, r7, r8, r9, r10, r11)
            r0.add(r12)
            goto L_0x0014
        L_0x0068:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.datatrack.base.utils.DataTrackHelper.b(java.util.List, java.lang.String, java.lang.String):java.util.List");
    }

    public static final List c(List list) {
        Intrinsics.checkNotNullParameter(list, "trackList");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((XJTrackData) it.next()).getId()));
        }
        return arrayList;
    }

    public static final AppTrack d(String str, String str2, String str3) {
        String str4;
        Intrinsics.checkNotNullParameter(str, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(str2, "eventName");
        Intrinsics.checkNotNullParameter(str3, PayloadConstant.PARAMS_KEY_CALLBACK_MSG);
        String str5 = null;
        try {
            JSONObject jSONObject = new JSONObject(str3);
            str4 = jSONObject.has("_iot_device_id_") ? jSONObject.getString("_iot_device_id_") : XJDeviceUtil.f();
            try {
                str5 = jSONObject.has("iot_device_rom") ? jSONObject.getString("iot_device_rom") : XJDeviceUtil.h();
            } catch (Exception e) {
                e = e;
                LogUtil.c("DataTrackHelper", "newAppTrack, JSONObject-error: " + e);
                return AppTrack.Companion.a(str, str2, str3, str4, str5);
            }
        } catch (Exception e2) {
            e = e2;
            str4 = null;
            LogUtil.c("DataTrackHelper", "newAppTrack, JSONObject-error: " + e);
            return AppTrack.Companion.a(str, str2, str3, str4, str5);
        }
        return AppTrack.Companion.a(str, str2, str3, str4, str5);
    }
}
