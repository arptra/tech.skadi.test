package com.upuphone.xr.sapp.monitor.notification.missedcall;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.CallLog;
import android.telephony.SubscriptionManager;
import com.meizu.common.util.LunarCalendar;
import com.upuphone.star.core.log.Printer;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.monitor.notification.model.ArNotificationModel;
import com.upuphone.xr.sapp.monitor.notification.model.DiscernResultModel;
import com.upuphone.xr.sapp.monitor.notification.utils.NotificationHelper;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.monitor.starry.StarryNotificationBase;
import com.upuphone.xr.sapp.utils.AppInfoHelper;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.utils.PhoneTypeUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bH@¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/notification/missedcall/MissedCallMonitor;", "", "<init>", "()V", "", "h", "e", "d", "", "Lcom/upuphone/xr/sapp/monitor/notification/missedcall/MissedCallInfo;", "f", "()Ljava/util/List;", "g", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "b", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "", "c", "Z", "isInit", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nMissedCallMonitor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MissedCallMonitor.kt\ncom/upuphone/xr/sapp/monitor/notification/missedcall/MissedCallMonitor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,265:1\n1#2:266\n*E\n"})
public final class MissedCallMonitor {

    /* renamed from: a  reason: collision with root package name */
    public static final MissedCallMonitor f7773a = new MissedCallMonitor();
    public static final CoroutineScope b = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b((Job) null, 1, (Object) null)));
    public static boolean c;

    public final void d() {
        boolean z = MainApplication.k.f().checkSelfPermission("android.permission.READ_CALL_LOG") == 0;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("MissedCallMonitor", "checkMissedCall: hasPermission: " + z);
        if (z) {
            List<MissedCallInfo> f = f();
            delegate.a("MissedCallMonitor", "checkMissedCall: missedCall: " + f.size());
            if (!f.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (MissedCallInfo missedCallInfo : f) {
                    long currentTimeMillis = (System.currentTimeMillis() - missedCallInfo.b()) / ((long) 1000);
                    String g = currentTimeMillis > 3600 ? GlobalExtKt.g(R.string.missed_call_before_hours, Long.valueOf(currentTimeMillis / ((long) 3600))) : GlobalExtKt.g(R.string.missed_call_before_minutes, Long.valueOf(Long.max(currentTimeMillis / ((long) 60), 1)));
                    if (missedCallInfo.a() > 1) {
                        g = g + GlobalExtKt.g(R.string.missed_call_num, Integer.valueOf(missedCallInfo.a()));
                    }
                    String str = g;
                    ULog.f6446a.a("MissedCallMonitor", "checkMissedCall: content： " + NotificationHelper.f7775a.h(str));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("phone", missedCallInfo.d());
                    jSONObject.put("slotIndex", missedCallInfo.e());
                    String str2 = "phone-com.android.dialer-" + missedCallInfo.d() + LunarCalendar.DATE_SEPARATOR + missedCallInfo.b();
                    String c2 = missedCallInfo.c();
                    long currentTimeMillis2 = System.currentTimeMillis();
                    String b2 = AppInfoHelper.f7840a.b("com.android.dialer");
                    if (b2.length() == 0) {
                        b2 = GlobalExtKt.g(R.string.dial, new Object[0]);
                    }
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNull(jSONObject2);
                    arrayList.add(new ArNotificationModel(str2, c2, str, currentTimeMillis2, "MSG_TYPE_MISSEDCALL", "com.android.dialer", b2, false, jSONObject2, (DiscernResultModel) null, 640, (DefaultConstructorMarker) null));
                }
                StarryMessageHelper.t(StarryMessageHelper.f7799a, (byte[]) null, new StarryNotificationBase("SHOW_NOTIFICATION", arrayList), (SendMessageListener) null, 5, (Object) null);
            }
        }
    }

    public final void e() {
        if (!PhoneTypeUtils.f7912a.i()) {
            ULog.f6446a.a("MissedCallMonitor", " wechat call not meizu phone, return");
        } else {
            Job unused = BuildersKt__Builders_commonKt.d(b, (CoroutineContext) null, (CoroutineStart) null, new MissedCallMonitor$checkMissedWechatCall$1((Continuation<? super MissedCallMonitor$checkMissedWechatCall$1>) null), 3, (Object) null);
        }
    }

    public final List f() {
        Object obj;
        Throwable th;
        int i;
        long max = Long.max(System.currentTimeMillis() - ((long) 86400000), ((Number) DataStoreUtils.i(DataStoreUtils.e.a(), "missed_call_last_check_time", 0L, (Context) null, 4, (Object) null)).longValue());
        ContentResolver contentResolver = MainApplication.k.f().getContentResolver();
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m20constructorimpl(contentResolver.query(CallLog.Calls.CONTENT_URI, new String[]{"name", "number", "date", "type", "subscription_id"}, "date > " + max, (String[]) null, "date DESC"));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m20constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m26isFailureimpl(obj)) {
            obj = null;
        }
        Cursor cursor = (Cursor) obj;
        ULog.Delegate delegate = ULog.f6446a;
        int i2 = 0;
        int i3 = 1;
        boolean z = (cursor != null ? Integer.valueOf(cursor.getCount()) : null) == null;
        delegate.a("MissedCallMonitor", "getCallLogs: selection[date > " + max + "] cursor:" + z);
        ArrayList arrayList = new ArrayList();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList2 = new ArrayList();
        if (cursor != null) {
            Closeable closeable = cursor;
            try {
                Cursor cursor2 = (Cursor) closeable;
                while (cursor2.moveToNext()) {
                    String string = cursor2.getString(i2);
                    String string2 = cursor2.getString(i3);
                    long j = cursor2.getLong(2);
                    int i4 = cursor2.getInt(3);
                    int slotIndex = SubscriptionManager.getSlotIndex(cursor2.getInt(4));
                    Printer s = ULog.f6446a.s();
                    StringBuilder sb = new StringBuilder();
                    Cursor cursor3 = cursor2;
                    sb.append("getCallLogs: ");
                    sb.append(string);
                    sb.append(", ");
                    sb.append(string2);
                    sb.append(", ");
                    sb.append(j);
                    sb.append(", ");
                    sb.append(i4);
                    sb.append(", ");
                    sb.append(slotIndex);
                    s.a("MissedCallMonitor", sb.toString());
                    if (linkedHashSet.contains(string2)) {
                        cursor2 = cursor3;
                        i2 = 0;
                        i3 = 1;
                    } else {
                        if (string != null) {
                            if (!StringsKt.isBlank(string)) {
                                if (i4 == 3) {
                                    MissedCallInfo missedCallInfo = (MissedCallInfo) linkedHashMap.get(string2);
                                    if (missedCallInfo == null) {
                                        Intrinsics.checkNotNull(string);
                                        Intrinsics.checkNotNull(string2);
                                        missedCallInfo = new MissedCallInfo(string, string2, slotIndex, j, 0);
                                        linkedHashMap.put(string2, missedCallInfo);
                                        arrayList2.add(missedCallInfo);
                                    }
                                    i = 1;
                                    missedCallInfo.f(missedCallInfo.a() + 1);
                                    Intrinsics.checkNotNull(string2);
                                    linkedHashMap.put(string2, missedCallInfo);
                                    arrayList.add(missedCallInfo);
                                    i3 = i;
                                    cursor2 = cursor3;
                                    i2 = 0;
                                }
                            }
                        }
                        i = 1;
                        Intrinsics.checkNotNull(string2);
                        linkedHashSet.add(string2);
                        i3 = i;
                        cursor2 = cursor3;
                        i2 = 0;
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(closeable, (Throwable) null);
            } catch (Throwable th3) {
                Throwable th4 = th3;
                CloseableKt.closeFinally(closeable, th);
                throw th4;
            }
        }
        DataStoreUtils.e.a().o("missed_call_last_check_time", Long.valueOf(System.currentTimeMillis()));
        return arrayList2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ae A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object g(kotlin.coroutines.Continuation r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.upuphone.xr.sapp.monitor.notification.missedcall.MissedCallMonitor$getWechatCallLogs$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.upuphone.xr.sapp.monitor.notification.missedcall.MissedCallMonitor$getWechatCallLogs$1 r0 = (com.upuphone.xr.sapp.monitor.notification.missedcall.MissedCallMonitor$getWechatCallLogs$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.monitor.notification.missedcall.MissedCallMonitor$getWechatCallLogs$1 r0 = new com.upuphone.xr.sapp.monitor.notification.missedcall.MissedCallMonitor$getWechatCallLogs$1
            r0.<init>(r14, r15)
        L_0x0018:
            java.lang.Object r14 = r0.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x003d
            if (r1 == r3) goto L_0x0039
            if (r1 != r2) goto L_0x0031
            java.lang.Object r15 = r0.L$0
            java.util.Map r15 = (java.util.Map) r15
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00b0
        L_0x0031:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0053
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r14)
            com.upuphone.xr.sapp.monitor.notification.cache.NotificationDataBase$Companion r14 = com.upuphone.xr.sapp.monitor.notification.cache.NotificationDataBase.f7758a
            com.upuphone.xr.sapp.monitor.notification.cache.NotificationDataBase r14 = r14.a()
            com.upuphone.xr.sapp.monitor.notification.cache.WechatMissedCallDao r14 = r14.f()
            r0.label = r3
            java.lang.Object r14 = r14.c(r0)
            if (r14 != r15) goto L_0x0053
            return r15
        L_0x0053:
            java.util.List r14 = (java.util.List) r14
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            java.util.Iterator r14 = r14.iterator()
        L_0x005e:
            boolean r4 = r14.hasNext()
            if (r4 == 0) goto L_0x009a
            java.lang.Object r4 = r14.next()
            com.upuphone.xr.sapp.monitor.notification.model.WechatMissedCallModel r4 = (com.upuphone.xr.sapp.monitor.notification.model.WechatMissedCallModel) r4
            java.lang.String r5 = r4.getName()
            r6 = 0
            java.lang.Object r5 = r1.getOrDefault(r5, r6)
            com.upuphone.xr.sapp.monitor.notification.missedcall.MissedCallInfo r5 = (com.upuphone.xr.sapp.monitor.notification.missedcall.MissedCallInfo) r5
            if (r5 != 0) goto L_0x0091
            java.lang.String r5 = r4.getName()
            com.upuphone.xr.sapp.monitor.notification.missedcall.MissedCallInfo r13 = new com.upuphone.xr.sapp.monitor.notification.missedcall.MissedCallInfo
            java.lang.String r7 = r4.getName()
            long r10 = r4.getDate()
            r12 = 1
            java.lang.String r8 = ""
            r9 = 0
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r12)
            r1.put(r5, r13)
            goto L_0x005e
        L_0x0091:
            int r4 = r5.a()
            int r4 = r4 + r3
            r5.f(r4)
            goto L_0x005e
        L_0x009a:
            com.upuphone.xr.sapp.monitor.notification.cache.NotificationDataBase$Companion r14 = com.upuphone.xr.sapp.monitor.notification.cache.NotificationDataBase.f7758a
            com.upuphone.xr.sapp.monitor.notification.cache.NotificationDataBase r14 = r14.a()
            com.upuphone.xr.sapp.monitor.notification.cache.WechatMissedCallDao r14 = r14.f()
            r0.L$0 = r1
            r0.label = r2
            java.lang.Object r14 = r14.d(r0)
            if (r14 != r15) goto L_0x00af
            return r15
        L_0x00af:
            r15 = r1
        L_0x00b0:
            java.util.Collection r14 = r15.values()
            java.util.List r14 = kotlin.collections.CollectionsKt.toList(r14)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.notification.missedcall.MissedCallMonitor.g(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void h() {
        ULog.f6446a.a("MissedCallMonitor", "init: ");
        if (!c) {
            c = true;
            Job unused = BuildersKt__Builders_commonKt.d(b, (CoroutineContext) null, (CoroutineStart) null, new MissedCallMonitor$init$1((Continuation<? super MissedCallMonitor$init$1>) null), 3, (Object) null);
        }
    }
}
