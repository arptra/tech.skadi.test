package com.upuphone.xr.sapp.monitor.schedule;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel;
import com.upuphone.xr.sapp.monitor.schedule.model.SubscribeType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH@¢\u0006\u0004\b\t\u0010\nJ \u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH@¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/ScheduleWorker;", "Landroidx/work/CoroutineWorker;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "workerParams", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Landroidx/work/ListenableWorker$Result;", "r", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/xr/sapp/monitor/schedule/model/LocalScheduleModel;", "config", "", "Lcom/upuphone/xr/sapp/monitor/notification/model/ArReminderModel;", "w", "(Lcom/upuphone/xr/sapp/monitor/schedule/model/LocalScheduleModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "h", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nScheduleWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScheduleWorker.kt\ncom/upuphone/xr/sapp/monitor/schedule/ScheduleWorker\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,72:1\n1855#2,2:73\n*S KotlinDebug\n*F\n+ 1 ScheduleWorker.kt\ncom/upuphone/xr/sapp/monitor/schedule/ScheduleWorker\n*L\n29#1:73,2\n*E\n"})
public final class ScheduleWorker extends CoroutineWorker {
    public static final Companion h = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/schedule/ScheduleWorker$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScheduleWorker(@NotNull Context context, @NotNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00be A[SYNTHETIC] */
    public java.lang.Object r(kotlin.coroutines.Continuation r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.upuphone.xr.sapp.monitor.schedule.ScheduleWorker$doWork$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.upuphone.xr.sapp.monitor.schedule.ScheduleWorker$doWork$1 r0 = (com.upuphone.xr.sapp.monitor.schedule.ScheduleWorker$doWork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.monitor.schedule.ScheduleWorker$doWork$1 r0 = new com.upuphone.xr.sapp.monitor.schedule.ScheduleWorker$doWork$1
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 != r3) goto L_0x003d
            java.lang.Object r8 = r0.L$4
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r2 = r0.L$3
            com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel r2 = (com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel) r2
            java.lang.Object r4 = r0.L$2
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            java.lang.Object r6 = r0.L$0
            com.upuphone.xr.sapp.monitor.schedule.ScheduleWorker r6 = (com.upuphone.xr.sapp.monitor.schedule.ScheduleWorker) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x009c
        L_0x003d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.jvm.internal.Ref$ObjectRef r9 = new kotlin.jvm.internal.Ref$ObjectRef
            r9.<init>()
            androidx.work.ListenableWorker$Result r2 = androidx.work.ListenableWorker.Result.c()
            java.lang.String r4 = "success(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            r9.element = r2
            com.upuphone.xr.sapp.monitor.schedule.ScheduleAccountManager r2 = com.upuphone.xr.sapp.monitor.schedule.ScheduleAccountManager.f7776a
            java.util.List r2 = r2.e()
            java.util.Iterator r2 = r2.iterator()
            r5 = r9
            r4 = r2
        L_0x0065:
            boolean r9 = r4.hasNext()
            if (r9 == 0) goto L_0x00be
            java.lang.Object r9 = r4.next()
            r2 = r9
            com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel r2 = (com.upuphone.xr.sapp.monitor.schedule.model.LocalScheduleModel) r2
            boolean r9 = r2.f()
            if (r9 == 0) goto L_0x0065
            com.upuphone.xr.sapp.monitor.schedule.model.SubscribeType r9 = r2.e()
            com.upuphone.xr.sapp.monitor.schedule.model.SubscribeType r6 = com.upuphone.xr.sapp.monitor.schedule.model.SubscribeType.calendar
            if (r9 == r6) goto L_0x0065
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r0.L$0 = r8
            r0.L$1 = r5
            r0.L$2 = r4
            r0.L$3 = r2
            r0.L$4 = r9
            r0.label = r3
            java.lang.Object r6 = r8.w(r2, r0)
            if (r6 != r1) goto L_0x0098
            return r1
        L_0x0098:
            r7 = r6
            r6 = r8
            r8 = r9
            r9 = r7
        L_0x009c:
            java.util.List r9 = (java.util.List) r9
            if (r9 == 0) goto L_0x00b1
            r8.addAll(r9)
            com.upuphone.xr.sapp.monitor.schedule.ScheduleDataSyncManager r9 = com.upuphone.xr.sapp.monitor.schedule.ScheduleDataSyncManager.f7777a
            java.util.HashMap r9 = r9.g()
            java.lang.String r2 = r2.c()
            r9.put(r2, r8)
            goto L_0x00bc
        L_0x00b1:
            androidx.work.ListenableWorker$Result r8 = androidx.work.ListenableWorker.Result.a()
            java.lang.String r9 = "failure(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            r5.element = r8
        L_0x00bc:
            r8 = r6
            goto L_0x0065
        L_0x00be:
            T r8 = r5.element
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.monitor.schedule.ScheduleWorker.r(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object w(LocalScheduleModel localScheduleModel, Continuation continuation) {
        ULog.Delegate delegate = ULog.f6446a;
        SubscribeType e = localScheduleModel.e();
        String b = localScheduleModel.b();
        String c = localScheduleModel.c();
        delegate.a("Schedule-ScheduleWorker", "worker querySchedule:" + e + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + b + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_XML + c);
        return TimeoutKt.d(5000, new ScheduleWorker$querySchedule$2(localScheduleModel, (Continuation<? super ScheduleWorker$querySchedule$2>) null), continuation);
    }
}
