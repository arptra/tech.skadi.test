package com.upuphone.xr.sapp.monitor.schedule;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.context.GlassInfoExtKt;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.monitor.notification.constants.ReminderType;
import com.upuphone.xr.sapp.monitor.notification.model.ArReminderModel;
import com.upuphone.xr.sapp.monitor.schedule.calendar.CalendarObserver;
import com.upuphone.xr.sapp.monitor.schedule.calendar.CalendarScheduleProvider;
import com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.monitor.starry.StarryNotificationBase;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.utils.VersionMatchHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.constant.ConstantKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0003J\u001d\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0012\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0003RJ\u0010\"\u001a*\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u001aj\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f`\u001b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010+¨\u0006-"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/ScheduleDataSyncManager;", "", "<init>", "()V", "", "h", "", "i", "()Z", "e", "", "title", "packageName", "j", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "Lcom/upuphone/xr/sapp/monitor/notification/model/ArReminderModel;", "data", "k", "(Ljava/util/List;)V", "", "cycleTime", "l", "(Ljava/lang/Long;)V", "d", "f", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "g", "()Ljava/util/HashMap;", "setScheduleData", "(Ljava/util/HashMap;)V", "scheduleData", "", "c", "[Ljava/lang/String;", "schedulePackage", "", "Ljava/util/List;", "lastSyncData", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nScheduleDataSyncManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScheduleDataSyncManager.kt\ncom/upuphone/xr/sapp/monitor/schedule/ScheduleDataSyncManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,243:1\n288#2,2:244\n766#2:246\n857#2,2:247\n1855#2,2:249\n1855#2:251\n766#2:252\n857#2,2:253\n288#2,2:255\n1856#2:257\n1002#2,2:258\n1855#2:260\n288#2,2:261\n1856#2:263\n*S KotlinDebug\n*F\n+ 1 ScheduleDataSyncManager.kt\ncom/upuphone/xr/sapp/monitor/schedule/ScheduleDataSyncManager\n*L\n115#1:244,2\n167#1:246\n167#1:247,2\n169#1:249,2\n190#1:251\n193#1:252\n193#1:253,2\n200#1:255,2\n190#1:257\n216#1:258,2\n221#1:260\n222#1:261,2\n221#1:263\n*E\n"})
public final class ScheduleDataSyncManager {

    /* renamed from: a  reason: collision with root package name */
    public static final ScheduleDataSyncManager f7777a = new ScheduleDataSyncManager();
    public static HashMap b = new HashMap();
    public static String[] c = {"com.huawei.calendar", "com.android.calendar", "com.coloros.calendar"};
    public static List d = new ArrayList();
    public static final CoroutineScope e;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.sapp.monitor.schedule.ScheduleDataSyncManager$1", f = "ScheduleDataSyncManager.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.sapp.monitor.schedule.ScheduleDataSyncManager$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow d = ScheduleAccountManager.f7776a.d();
                AnonymousClass1 r1 = AnonymousClass1.f7778a;
                this.label = 1;
                if (d.collect(r1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        CoroutineScope a2 = CoroutineScopeKt.a(Dispatchers.b());
        e = a2;
        Job unused = BuildersKt__Builders_commonKt.d(a2, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    public final void d() {
        List e2 = ScheduleAccountManager.f7776a.e();
        ArrayList<LocalScheduleModel> arrayList = new ArrayList<>();
        for (Object next : e2) {
            if (!((LocalScheduleModel) next).f()) {
                arrayList.add(next);
            }
        }
        for (LocalScheduleModel localScheduleModel : arrayList) {
            if (b.containsKey(localScheduleModel.c())) {
                ULog.Delegate delegate = ULog.f6446a;
                String c2 = localScheduleModel.c();
                String name = localScheduleModel.e().name();
                delegate.a("Schedule-DataSyncManager", " checkScheduleData remove" + c2 + " type:" + name + " ");
                b.remove(localScheduleModel.c());
            }
        }
    }

    public final void e() {
        ULog.f6446a.a("Schedule-DataSyncManager", "cleanScheduleSync");
        b.clear();
        d.clear();
        WorkManager.d(GlobalExtKt.f()).a("schedule_worker_tag");
        f();
        CalendarObserver.f7783a.b(GlobalExtKt.f());
    }

    public final void f() {
        boolean z;
        Object obj;
        Object obj2;
        boolean s = SuperNotificationManager.f7749a.s(ReminderType.MSG_TYPE_REMINDER);
        ULog.f6446a.a("Schedule-DataSyncManager", "dealSendScheduleData isOpen:" + s);
        if (s) {
            ArrayList<ArReminderModel> arrayList = new ArrayList<>();
            Object orDefault = b.getOrDefault("system_calendar", new ArrayList());
            Intrinsics.checkNotNullExpressionValue(orDefault, "getOrDefault(...)");
            List list = (List) orDefault;
            Set keySet = b.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
            Iterator it = keySet.iterator();
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                List list2 = (List) b.get(str);
                if (list2 != null) {
                    Intrinsics.checkNotNull(list2);
                    ArrayList<ArReminderModel> arrayList2 = new ArrayList<>();
                    for (Object next : list2) {
                        Long endTime = ((ArReminderModel) next).getEndTime();
                        if ((endTime != null ? endTime.longValue() : 0) > System.currentTimeMillis()) {
                            arrayList2.add(next);
                        }
                    }
                    ULog.Delegate delegate = ULog.f6446a;
                    delegate.a("Schedule-DataSyncManager", "deal valid:" + arrayList2.size());
                    if (!Intrinsics.areEqual((Object) str, (Object) "system_calendar")) {
                        for (ArReminderModel arReminderModel : arrayList2) {
                            if (!list.isEmpty()) {
                                Iterator it2 = list.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        obj2 = null;
                                        break;
                                    }
                                    obj2 = it2.next();
                                    ArReminderModel arReminderModel2 = (ArReminderModel) obj2;
                                    if (Intrinsics.areEqual((Object) arReminderModel2.getTitle(), (Object) arReminderModel.getTitle()) && arReminderModel2.getCrateTime() == arReminderModel.getCrateTime()) {
                                        break;
                                    }
                                }
                                ArReminderModel arReminderModel3 = (ArReminderModel) obj2;
                                if (arReminderModel3 != null) {
                                    ULog.f6446a.a("Schedule-DataSyncManager", "deal system_calendar repeat:" + arReminderModel3.getTitle());
                                }
                            }
                            ULog.f6446a.a("Schedule-DataSyncManager", "validData.add " + arReminderModel.getTitle());
                            arrayList.add(arReminderModel);
                        }
                    } else {
                        delegate.a("Schedule-DataSyncManager", "validData.addAll key:" + str + " size:" + arrayList2.size());
                        arrayList.addAll(arrayList2);
                    }
                }
            }
            if (arrayList.size() > 1) {
                CollectionsKt.sortWith(arrayList, new ScheduleDataSyncManager$dealSendScheduleData$$inlined$sortBy$1());
            }
            if (arrayList.size() == d.size()) {
                boolean z2 = false;
                for (ArReminderModel arReminderModel4 : arrayList) {
                    Iterator it3 = d.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it3.next();
                        if (Intrinsics.areEqual((Object) arReminderModel4.getId(), (Object) ((ArReminderModel) obj).getId())) {
                            break;
                        }
                    }
                    ArReminderModel arReminderModel5 = (ArReminderModel) obj;
                    if (arReminderModel5 != null && !arReminderModel5.equals(arReminderModel4)) {
                        ULog.f6446a.a("Schedule-DataSyncManager", "findReminder equals false");
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (!z) {
                ULog.f6446a.a("Schedule-DataSyncManager", "The data is not updated");
                return;
            }
            d = arrayList;
            ULog.f6446a.a("Schedule-DataSyncManager", "dealSendScheduleData validData:" + arrayList);
            StarryMessageHelper.t(StarryMessageHelper.f7799a, (byte[]) null, new StarryNotificationBase("SYNC_SMART_REMINDER", arrayList), (SendMessageListener) null, 5, (Object) null);
        }
    }

    public final HashMap g() {
        return b;
    }

    public final void h() {
        boolean s = SuperNotificationManager.f7749a.s(ReminderType.MSG_TYPE_REMINDER);
        boolean i = i();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("Schedule-DataSyncManager", "initSchedule isOpen:" + s + " isSupportSchedule:" + i);
        if (s && i) {
            CalendarScheduleProvider.f7784a.c();
            CalendarObserver.f7783a.a(GlobalExtKt.f());
        }
    }

    public final boolean i() {
        return VersionMatchHelper.e(VersionMatchHelper.f7930a, false, false, false, (String) null, (String) null, GlassInfoExtKt.c(GlassInfoExtKt.d("1.1.3")), (String) null, 92, (Object) null);
    }

    public final boolean j(String str, String str2) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, ConstantKt.FACTOR_PARAMS_PACKAGE_NAME);
        boolean z = false;
        if (!ArraysKt.contains((T[]) c, str2)) {
            return false;
        }
        Iterator it = d.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((ArReminderModel) obj).getTitle(), (Object) str)) {
                break;
            }
        }
        if (obj != null) {
            z = true;
        }
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("Schedule-DataSyncManager", "Deduplication result:" + z + " packageName:" + str2 + " title:" + str + " ");
        return z;
    }

    public final void k(List list) {
        Intrinsics.checkNotNullParameter(list, "data");
        ULog.Delegate delegate = ULog.f6446a;
        int size = list.size();
        String joinToString$default = CollectionsKt.joinToString$default(list, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, ScheduleDataSyncManager$onCalendarScheduleChange$1.INSTANCE, 31, (Object) null);
        delegate.a("Schedule-DataSyncManager", "onCalendarScheduleChange " + size + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + joinToString$default);
        b.put("system_calendar", list);
        f();
    }

    public final void l(Long l) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("Schedule-DataSyncManager", "syncSchedule cycleTime:" + l);
        WorkManager.d(GlobalExtKt.f()).a("schedule_worker_tag");
        OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder(ScheduleWorker.class);
        builder.a("schedule_worker_tag");
        if (l != null) {
            builder.j(l.longValue(), TimeUnit.SECONDS);
        }
        OneTimeWorkRequest oneTimeWorkRequest = (OneTimeWorkRequest) builder.b();
        WorkManager.d(GlobalExtKt.f()).b(oneTimeWorkRequest);
        WorkManager.d(GlobalExtKt.f()).e(oneTimeWorkRequest.a()).observeForever(new ScheduleDataSyncManager$sam$androidx_lifecycle_Observer$0(ScheduleDataSyncManager$syncSchedule$1.INSTANCE));
    }
}
