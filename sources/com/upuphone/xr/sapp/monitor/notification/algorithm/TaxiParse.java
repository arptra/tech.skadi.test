package com.upuphone.xr.sapp.monitor.notification.algorithm;

import com.meizu.common.util.LunarCalendar;
import com.upuphone.sdk.ArSmartReminderModel;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.monitor.notification.constants.ReminderType;
import com.upuphone.xr.sapp.monitor.notification.model.ArTaxiModel;
import com.upuphone.xr.sapp.utils.AppInfoHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nTaxiParse.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaxiParse.kt\ncom/upuphone/xr/sapp/monitor/notification/algorithm/TaxiParse\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,270:1\n1#2:271\n766#3:272\n857#3,2:273\n766#3:275\n857#3,2:276\n766#3:278\n857#3,2:279\n*S KotlinDebug\n*F\n+ 1 TaxiParse.kt\ncom/upuphone/xr/sapp/monitor/notification/algorithm/TaxiParse\n*L\n162#1:272\n162#1:273,2\n193#1:275\n193#1:276,2\n210#1:278\n210#1:279,2\n*E\n"})
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/algorithm/TaxiParse;", "Lcom/upuphone/xr/sapp/monitor/notification/algorithm/BaseParse;", "Lcom/upuphone/xr/sapp/monitor/notification/model/ArTaxiModel;", "<init>", "()V", "Lcom/upuphone/sdk/ArSmartReminderModel;", "model", "", "j", "(Lcom/upuphone/sdk/ArSmartReminderModel;)V", "", "a", "()Ljava/lang/String;", "i", "(Lcom/upuphone/sdk/ArSmartReminderModel;)Lcom/upuphone/xr/sapp/monitor/notification/model/ArTaxiModel;", "h", "takeoutModel", "n", "(Lcom/upuphone/sdk/ArSmartReminderModel;Lcom/upuphone/xr/sapp/monitor/notification/model/ArTaxiModel;)Lcom/upuphone/xr/sapp/monitor/notification/model/ArTaxiModel;", "carNumber", "k", "(Lcom/upuphone/sdk/ArSmartReminderModel;Ljava/lang/String;)Lcom/upuphone/xr/sapp/monitor/notification/model/ArTaxiModel;", "", "m", "()Z", "msgType", "f", "(Ljava/lang/String;)Ljava/lang/String;", "", "g", "(Ljava/lang/String;)I", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TaxiParse extends BaseParse<ArTaxiModel> {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f7753a = new Companion((DefaultConstructorMarker) null);
    public static final String[] b = {"com.autonavi.minimap", "com.sdu.didi.psnger", "com.baidu.BaiduMap", "com.sankuai.meituan"};
    public static final List c = new ArrayList();

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u000bR\u0014\u0010\u0018\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u000bR\u0014\u0010\u0019\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u000bR\u0014\u0010\u001a\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u000bR\u0014\u0010\u001b\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u000bR\u0014\u0010\u001c\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\u001c\u0010\u000bR\u0014\u0010\u001d\u001a\u00020\u00058\u0006XT¢\u0006\u0006\n\u0004\b\u001d\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/algorithm/TaxiParse$Companion;", "", "<init>", "()V", "", "", "TAXI_SCENES_PACKAGE", "[Ljava/lang/String;", "a", "()[Ljava/lang/String;", "BAI_DU", "Ljava/lang/String;", "DI_DI", "GAO_DE", "MEI_TUAN", "TAG", "", "TIME_OUT", "I", "", "Lcom/upuphone/xr/sapp/monitor/notification/model/ArTaxiModel;", "cacheArray", "Ljava/util/List;", "cancelOrder", "driverArrive", "driverComingSoon", "driverReceivesOrder", "orderFinish", "orderStart", "userLate", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String[] a() {
            return TaxiParse.b;
        }

        public Companion() {
        }
    }

    public static /* synthetic */ ArTaxiModel l(TaxiParse taxiParse, ArSmartReminderModel arSmartReminderModel, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return taxiParse.k(arSmartReminderModel, str);
    }

    public String a() {
        return "SYNC_SMART_REMINDER_TAXI";
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0065 A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String f(java.lang.String r1) {
        /*
            r0 = this;
            int r0 = r1.hashCode()
            switch(r0) {
                case -2103638291: goto L_0x005c;
                case -1435934469: goto L_0x004e;
                case -1236334438: goto L_0x0040;
                case -1148783680: goto L_0x0032;
                case -23839195: goto L_0x0024;
                case 704288912: goto L_0x0016;
                case 1436538264: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0065
        L_0x0008:
            java.lang.String r0 = "taxi:cancelOrder"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0012
            goto L_0x0065
        L_0x0012:
            java.lang.String r0 = "订单取消"
            goto L_0x006c
        L_0x0016:
            java.lang.String r0 = "taxi:orderStart"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0020
            goto L_0x0065
        L_0x0020:
            java.lang.String r0 = "行程开始"
            goto L_0x006c
        L_0x0024:
            java.lang.String r0 = "taxi:orderFinish"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x002e
            goto L_0x0065
        L_0x002e:
            java.lang.String r0 = "行程已结束"
            goto L_0x006c
        L_0x0032:
            java.lang.String r0 = "taxi:driverComingSoon"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x003c
            goto L_0x0065
        L_0x003c:
            java.lang.String r0 = "司机即将到达"
            goto L_0x006c
        L_0x0040:
            java.lang.String r0 = "taxi:driverReceivesOrder"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x004a
            goto L_0x0065
        L_0x004a:
            java.lang.String r0 = "司机已接单"
            goto L_0x006c
        L_0x004e:
            java.lang.String r0 = "taxi:driverArrive"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0058
            goto L_0x0065
        L_0x0058:
            java.lang.String r0 = "司机到达"
            goto L_0x006c
        L_0x005c:
            java.lang.String r0 = "taxi:userLate"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0069
        L_0x0065:
            java.lang.String r0 = "未知"
            goto L_0x006c
        L_0x0069:
            java.lang.String r0 = "您已迟到"
        L_0x006c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.notification.algorithm.TaxiParse.f(java.lang.String):java.lang.String");
    }

    public final int g(String str) {
        switch (str.hashCode()) {
            case -2103638291:
                return !str.equals("taxi:userLate") ? 100 : 3;
            case -1435934469:
                return !str.equals("taxi:driverArrive") ? 100 : 2;
            case -1236334438:
                return !str.equals("taxi:driverReceivesOrder") ? 100 : 0;
            case -1148783680:
                return !str.equals("taxi:driverComingSoon") ? 100 : 1;
            case 704288912:
                return !str.equals("taxi:orderStart") ? 100 : 4;
            case 1436538264:
                boolean equals = str.equals("taxi:cancelOrder");
                return 100;
            default:
                return 100;
        }
    }

    public String h() {
        return ReminderType.MSG_TYPE_TAXI;
    }

    public ArTaxiModel i(ArSmartReminderModel arSmartReminderModel) {
        Intrinsics.checkNotNullParameter(arSmartReminderModel, "model");
        String str = "taxi-" + arSmartReminderModel.f() + LunarCalendar.DATE_SEPARATOR + System.currentTimeMillis();
        Long b2 = arSmartReminderModel.b();
        String f = arSmartReminderModel.f();
        String d = arSmartReminderModel.d();
        String d2 = arSmartReminderModel.d();
        Intrinsics.checkNotNullExpressionValue(d2, "getMsgType(...)");
        String f2 = f(d2);
        AppInfoHelper appInfoHelper = AppInfoHelper.f7840a;
        String f3 = arSmartReminderModel.f();
        Intrinsics.checkNotNullExpressionValue(f3, "getPackageName(...)");
        String b3 = appInfoHelper.b(f3);
        long currentTimeMillis = System.currentTimeMillis();
        String a2 = arSmartReminderModel.a();
        Intrinsics.checkNotNull(b2);
        long longValue = b2.longValue();
        Intrinsics.checkNotNull(f);
        Intrinsics.checkNotNull(d);
        Intrinsics.checkNotNull(a2);
        return new ArTaxiModel(str, longValue, (String) null, f, b3, d, f2, "", "", 0, currentTimeMillis, a2, 4, (DefaultConstructorMarker) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.upuphone.xr.sapp.monitor.notification.model.ArTaxiModel} */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v10, types: [java.util.HashMap] */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: type inference failed for: r1v17 */
    /* JADX WARNING: type inference failed for: r1v18 */
    /* JADX WARNING: type inference failed for: r1v19 */
    /* JADX WARNING: type inference failed for: r1v20 */
    /* JADX WARNING: type inference failed for: r1v21 */
    /* JADX WARNING: type inference failed for: r1v22 */
    /* JADX WARNING: type inference failed for: r1v23 */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x008b, code lost:
        if (r0.equals("taxi:orderStart") == false) goto L_0x01e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0096, code lost:
        if (r0.equals("taxi:orderFinish") == false) goto L_0x01e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x012d, code lost:
        if (r0 != null) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0146, code lost:
        if (r0 != null) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01de, code lost:
        if (r0.equals("taxi:userLate") == false) goto L_0x01e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01e1, code lost:
        r1 = n(r12, l(r11, r12, (java.lang.String) null, 2, (java.lang.Object) null));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0080, code lost:
        if (r0.equals("taxi:cancelOrder") == false) goto L_0x01e9;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j(com.upuphone.sdk.ArSmartReminderModel r12) {
        /*
            r11 = this;
            java.lang.String r0 = "model"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            boolean r0 = r11.m()
            if (r0 != 0) goto L_0x0045
            java.lang.String r2 = r12.c()
            java.lang.String r0 = "getId(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            java.lang.String r3 = r12.g()
            java.lang.String r0 = "getTitle(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            java.lang.String r4 = r12.a()
            java.lang.String r0 = "getContent(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            java.lang.Long r0 = r12.b()
            java.lang.String r1 = "getCrateTime(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            long r5 = r0.longValue()
            java.lang.String r7 = r12.f()
            java.lang.String r12 = "getPackageName(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r12)
            r9 = 32
            r10 = 0
            r8 = 0
            r1 = r11
            com.upuphone.xr.sapp.monitor.notification.algorithm.BaseParse.c(r1, r2, r3, r4, r5, r7, r8, r9, r10)
            return
        L_0x0045:
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r1 = r12.d()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "taxi parseMessage msgType:"
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "TaxiParse"
            r0.g(r2, r1)
            java.lang.String r0 = r12.d()
            r1 = 0
            if (r0 == 0) goto L_0x01e9
            int r2 = r0.hashCode()
            r3 = 2
            java.lang.String r4 = "carBrand"
            java.lang.String r5 = "carNumber"
            java.lang.String r6 = ""
            switch(r2) {
                case -2103638291: goto L_0x01d7;
                case -1435934469: goto L_0x018f;
                case -1236334438: goto L_0x00ff;
                case -1148783680: goto L_0x009a;
                case -23839195: goto L_0x008f;
                case 704288912: goto L_0x0084;
                case 1436538264: goto L_0x0079;
                default: goto L_0x0077;
            }
        L_0x0077:
            goto L_0x01e9
        L_0x0079:
            java.lang.String r2 = "taxi:cancelOrder"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01e1
            goto L_0x01e9
        L_0x0084:
            java.lang.String r2 = "taxi:orderStart"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01e1
            goto L_0x01e9
        L_0x008f:
            java.lang.String r2 = "taxi:orderFinish"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01e1
            goto L_0x01e9
        L_0x009a:
            java.lang.String r2 = "taxi:driverComingSoon"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x00a5
            goto L_0x01e9
        L_0x00a5:
            com.upuphone.xr.sapp.monitor.notification.model.ArTaxiModel r0 = l(r11, r12, r1, r3, r1)
            java.util.HashMap r2 = r12.e()
            boolean r3 = r2.containsKey(r5)
            if (r3 == 0) goto L_0x00b4
            goto L_0x00b5
        L_0x00b4:
            r2 = r1
        L_0x00b5:
            if (r2 == 0) goto L_0x00c0
            java.lang.Object r2 = r2.get(r5)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x00c0
            goto L_0x00c1
        L_0x00c0:
            r2 = r6
        L_0x00c1:
            java.util.HashMap r3 = r12.e()
            java.lang.String r4 = "ArriveTime"
            boolean r5 = r3.containsKey(r4)
            if (r5 == 0) goto L_0x00ce
            r1 = r3
        L_0x00ce:
            if (r1 == 0) goto L_0x00d9
            java.lang.Object r1 = r1.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x00d9
            r6 = r1
        L_0x00d9:
            com.upuphone.xr.sapp.monitor.notification.model.ArTaxiModel r1 = r11.n(r12, r0)
            int r12 = r6.length()
            if (r12 <= 0) goto L_0x00ea
            long r3 = java.lang.Long.parseLong(r6)
            r1.setDriverArriveTime(r3)
        L_0x00ea:
            int r12 = r2.length()
            if (r12 <= 0) goto L_0x01e9
            java.lang.String r12 = r1.getCarNumber()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r2)
            if (r12 != 0) goto L_0x01e9
            r1.setCarNumber(r2)
            goto L_0x01e9
        L_0x00ff:
            java.lang.String r2 = "taxi:driverReceivesOrder"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x010a
            goto L_0x01e9
        L_0x010a:
            java.lang.String r0 = r12.f()
            java.lang.String r2 = "com.baidu.BaiduMap"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x0132
            java.util.HashMap r0 = r12.e()
            java.lang.String r2 = "tailNumber"
            boolean r5 = r0.containsKey(r2)
            if (r5 == 0) goto L_0x0124
            goto L_0x0125
        L_0x0124:
            r0 = r1
        L_0x0125:
            if (r0 == 0) goto L_0x0130
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x0130
            goto L_0x0149
        L_0x0130:
            r0 = r6
            goto L_0x0149
        L_0x0132:
            java.util.HashMap r0 = r12.e()
            boolean r2 = r0.containsKey(r5)
            if (r2 == 0) goto L_0x013d
            goto L_0x013e
        L_0x013d:
            r0 = r1
        L_0x013e:
            if (r0 == 0) goto L_0x0130
            java.lang.Object r0 = r0.get(r5)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0149
            goto L_0x0130
        L_0x0149:
            java.util.HashMap r2 = r12.e()
            java.lang.String r5 = "defalutArriveTime"
            boolean r7 = r2.containsKey(r5)
            if (r7 == 0) goto L_0x0156
            goto L_0x0157
        L_0x0156:
            r2 = r1
        L_0x0157:
            if (r2 == 0) goto L_0x0160
            java.lang.Object r2 = r2.get(r5)
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x0161
        L_0x0160:
            r2 = r1
        L_0x0161:
            java.util.HashMap r5 = r12.e()
            boolean r7 = r5.containsKey(r4)
            if (r7 == 0) goto L_0x016c
            goto L_0x016d
        L_0x016c:
            r5 = r1
        L_0x016d:
            if (r5 == 0) goto L_0x0176
            java.lang.Object r4 = r5.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0177
        L_0x0176:
            r4 = r1
        L_0x0177:
            com.upuphone.xr.sapp.monitor.notification.model.ArTaxiModel r1 = l(r11, r12, r1, r3, r1)
            if (r2 == 0) goto L_0x0184
            long r2 = java.lang.Long.parseLong(r2)
            r1.setDriverArriveTime(r2)
        L_0x0184:
            r1.setCarNumber(r0)
            if (r4 != 0) goto L_0x018a
            goto L_0x018b
        L_0x018a:
            r6 = r4
        L_0x018b:
            r1.setCarBrand(r6)
            goto L_0x01e9
        L_0x018f:
            java.lang.String r2 = "taxi:driverArrive"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0199
            goto L_0x01e9
        L_0x0199:
            java.util.HashMap r0 = r12.e()
            boolean r2 = r0.containsKey(r5)
            if (r2 == 0) goto L_0x01a4
            goto L_0x01a5
        L_0x01a4:
            r0 = r1
        L_0x01a5:
            if (r0 == 0) goto L_0x01af
            java.lang.Object r0 = r0.get(r5)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x01b0
        L_0x01af:
            r0 = r6
        L_0x01b0:
            java.util.HashMap r2 = r12.e()
            boolean r3 = r2.containsKey(r4)
            if (r3 == 0) goto L_0x01bb
            goto L_0x01bc
        L_0x01bb:
            r2 = r1
        L_0x01bc:
            if (r2 == 0) goto L_0x01c4
            java.lang.Object r1 = r2.get(r4)
            java.lang.String r1 = (java.lang.String) r1
        L_0x01c4:
            com.upuphone.xr.sapp.monitor.notification.model.ArTaxiModel r2 = r11.k(r12, r0)
            if (r1 != 0) goto L_0x01cb
            goto L_0x01cc
        L_0x01cb:
            r6 = r1
        L_0x01cc:
            r2.setCarBrand(r6)
            r2.setCarNumber(r0)
            com.upuphone.xr.sapp.monitor.notification.model.ArTaxiModel r1 = r11.n(r12, r2)
            goto L_0x01e9
        L_0x01d7:
            java.lang.String r2 = "taxi:userLate"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01e1
            goto L_0x01e9
        L_0x01e1:
            com.upuphone.xr.sapp.monitor.notification.model.ArTaxiModel r0 = l(r11, r12, r1, r3, r1)
            com.upuphone.xr.sapp.monitor.notification.model.ArTaxiModel r1 = r11.n(r12, r0)
        L_0x01e9:
            if (r1 == 0) goto L_0x01f6
            com.upuphone.xr.sapp.monitor.notification.model.ArTaxiModel[] r12 = new com.upuphone.xr.sapp.monitor.notification.model.ArTaxiModel[]{r1}
            java.util.ArrayList r12 = kotlin.collections.CollectionsKt.arrayListOf(r12)
            r11.d(r12)
        L_0x01f6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.notification.algorithm.TaxiParse.j(com.upuphone.sdk.ArSmartReminderModel):void");
    }

    public final ArTaxiModel k(ArSmartReminderModel arSmartReminderModel, String str) {
        ArrayList arrayList;
        String d = arSmartReminderModel.d();
        Intrinsics.checkNotNullExpressionValue(d, "getMsgType(...)");
        int g = g(d);
        List list = c;
        ArrayList arrayList2 = new ArrayList();
        for (Object next : list) {
            ArTaxiModel arTaxiModel = (ArTaxiModel) next;
            if (g(arTaxiModel.getTaxiState()) < g && Intrinsics.areEqual((Object) arSmartReminderModel.f(), (Object) arTaxiModel.getPackageName())) {
                arrayList2.add(next);
            }
        }
        if (arrayList2.isEmpty()) {
            ArTaxiModel i = i(arSmartReminderModel);
            c.add(i);
            return i;
        } else if (arrayList2.size() == 1) {
            return (ArTaxiModel) CollectionsKt.first(arrayList2);
        } else {
            if (str == null || str.length() == 0) {
                arrayList = arrayList2;
            } else {
                arrayList = new ArrayList();
                for (Object next2 : arrayList2) {
                    if (Intrinsics.areEqual((Object) str, (Object) ((ArTaxiModel) next2).getCarNumber())) {
                        arrayList.add(next2);
                    }
                }
            }
            return (ArTaxiModel) (arrayList.isEmpty() ? CollectionsKt.first(arrayList2) : CollectionsKt.first(arrayList));
        }
    }

    public final boolean m() {
        SuperNotificationManager superNotificationManager = SuperNotificationManager.f7749a;
        if (!superNotificationManager.q()) {
            ULog.f6446a.c("TaxiParse", "---parse message reminder switch close----");
            c.clear();
            return false;
        } else if (superNotificationManager.s(h())) {
            return true;
        } else {
            ULog.f6446a.c("TaxiParse", "---parse message reminder type switch close----");
            c.clear();
            return false;
        }
    }

    public final ArTaxiModel n(ArSmartReminderModel arSmartReminderModel, ArTaxiModel arTaxiModel) {
        String d = arSmartReminderModel.d();
        Intrinsics.checkNotNullExpressionValue(d, "getMsgType(...)");
        arTaxiModel.setTaxiState(d);
        String d2 = arSmartReminderModel.d();
        Intrinsics.checkNotNullExpressionValue(d2, "getMsgType(...)");
        arTaxiModel.setTaxiStateDesc(f(d2));
        arTaxiModel.setLastUpdateTime(System.currentTimeMillis());
        String a2 = arSmartReminderModel.a();
        Intrinsics.checkNotNullExpressionValue(a2, "getContent(...)");
        arTaxiModel.setNotificationContent(a2);
        return arTaxiModel;
    }
}
