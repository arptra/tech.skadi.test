package com.upuphone.xr.sapp.vu.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.here.posclient.PositionEstimate;
import com.meizu.common.datetimepicker.date.MonthView;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.permission.PermissionHelper;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.vu.VuTouchpadActivity;
import com.upuphone.xr.sapp.vu.arspace.OnCaptureScreenListener;
import com.upuphone.xr.sapp.vu.arspace.OnRecordScreenListener;
import com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper;
import com.xjmz.myvu.MYVUActivity;
import com.xjmz.openxr.ctrl.record.RecordCtrl;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 [2\u00020\u0001:\u0002\\]B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tH@¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\bJ\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\bJ\u0019\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0012J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u000fH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0006H\u0002¢\u0006\u0004\b.\u0010\bJ\r\u0010/\u001a\u00020\u0006¢\u0006\u0004\b/\u0010\bJ\r\u00100\u001a\u00020\u0006¢\u0006\u0004\b0\u0010\bJ\u0015\u00103\u001a\u00020\u00062\u0006\u00102\u001a\u000201¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020\u00062\u0006\u00102\u001a\u000201¢\u0006\u0004\b5\u00104J\u0015\u00107\u001a\u00020\u00062\u0006\u00102\u001a\u000206¢\u0006\u0004\b7\u00108J\u0015\u00109\u001a\u00020\u00062\u0006\u00102\u001a\u000206¢\u0006\u0004\b9\u00108J\r\u0010:\u001a\u00020\u0006¢\u0006\u0004\b:\u0010\bJ\u0010\u0010;\u001a\u00020\u0006H@¢\u0006\u0004\b;\u0010\u000bJ\r\u0010<\u001a\u00020\u0006¢\u0006\u0004\b<\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001b\u0010F\u001a\u00020A8BX\u0002¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u001b\u0010K\u001a\u00020G8BX\u0002¢\u0006\f\n\u0004\bH\u0010C\u001a\u0004\bI\u0010JR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u0002010L8\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u0002060L8\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010NR\u0016\u0010T\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u001e\u0010X\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010U8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Z\u001a\u00020'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bY\u0010\u0016¨\u0006^"}, d2 = {"Lcom/upuphone/xr/sapp/vu/utils/VuScreenRecordHelper;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "u", "()V", "Landroid/content/Intent;", "O", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "F", "H", "", "uri", "G", "(Ljava/lang/String;)V", "J", "K", "path", "I", "Ljava/io/File;", "file", "Landroid/net/Uri;", "Q", "(Ljava/io/File;)Landroid/net/Uri;", "P", "target", "", "w", "(Ljava/io/File;Landroid/net/Uri;)Z", "C", "()Ljava/lang/String;", "y", "(Ljava/io/File;)V", "v", "(Landroid/content/Context;)Z", "", "time", "Landroid/app/Notification;", "x", "(I)Landroid/app/Notification;", "U", "(I)V", "L", "E", "z", "Lcom/upuphone/xr/sapp/vu/arspace/OnCaptureScreenListener;", "listener", "s", "(Lcom/upuphone/xr/sapp/vu/arspace/OnCaptureScreenListener;)V", "M", "Lcom/upuphone/xr/sapp/vu/arspace/OnRecordScreenListener;", "t", "(Lcom/upuphone/xr/sapp/vu/arspace/OnRecordScreenListener;)V", "N", "R", "A", "S", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/xjmz/openxr/ctrl/record/RecordCtrl;", "b", "Lkotlin/Lazy;", "D", "()Lcom/xjmz/openxr/ctrl/record/RecordCtrl;", "recordCtrl", "Lkotlinx/coroutines/CoroutineScope;", "c", "B", "()Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Ljava/util/concurrent/CopyOnWriteArraySet;", "d", "Ljava/util/concurrent/CopyOnWriteArraySet;", "screenCaptureListeners", "e", "screenRecordListeners", "f", "Z", "isRecording", "Lkotlinx/coroutines/Deferred;", "g", "Lkotlinx/coroutines/Deferred;", "timerJob", "h", "duration", "i", "Companion", "MsgReceiver", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nVuScreenRecordHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VuScreenRecordHelper.kt\ncom/upuphone/xr/sapp/vu/utils/VuScreenRecordHelper\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,454:1\n314#2,11:455\n1855#3,2:466\n1855#3,2:468\n1855#3,2:470\n1855#3,2:472\n1855#3,2:474\n1855#3,2:476\n1#4:478\n*S KotlinDebug\n*F\n+ 1 VuScreenRecordHelper.kt\ncom/upuphone/xr/sapp/vu/utils/VuScreenRecordHelper\n*L\n234#1:455,11\n258#1:466,2\n264#1:468,2\n270#1:470,2\n277#1:472,2\n283#1:474,2\n293#1:476,2\n*E\n"})
public final class VuScreenRecordHelper {
    public static final Companion i = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Context f8105a;
    public final Lazy b = LazyKt.lazy(VuScreenRecordHelper$recordCtrl$2.INSTANCE);
    public final Lazy c = LazyKt.lazy(VuScreenRecordHelper$coroutineScope$2.INSTANCE);
    public final CopyOnWriteArraySet d = new CopyOnWriteArraySet();
    public final CopyOnWriteArraySet e = new CopyOnWriteArraySet();
    public boolean f;
    public Deferred g;
    public int h;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/upuphone/xr/sapp/vu/utils/VuScreenRecordHelper$Companion;", "", "()V", "CAPTURE_HEIGHT", "", "CAPTURE_PATH", "", "CAPTURE_WIDTH", "FILE_PREFIX", "MAX_RECORD_SCECONDS", "", "MIME_TYPE_IMAGE", "MIME_TYPE_VIDEO", "NOTIFICATION_ID", "RECORD_PATH", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/vu/utils/VuScreenRecordHelper$MsgReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/upuphone/xr/sapp/vu/utils/VuScreenRecordHelper;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class MsgReceiver extends BroadcastReceiver {
        public MsgReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("ScreenRecordHelper", "receive msg");
            String stringExtra = intent.getStringExtra("error");
            if (stringExtra != null) {
                delegate.a("ScreenRecordHelper", "receive msg:" + stringExtra);
                VuScreenRecordHelper.this.u();
                ArSpaceReportHelper.f8088a.d(ArSpaceReportHelper.ScreenRecordResult.ERROR, 0, stringExtra);
            }
        }
    }

    public VuScreenRecordHelper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f8105a = context;
        ArSpaceNotificationUtil arSpaceNotificationUtil = ArSpaceNotificationUtil.f8087a;
        x(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00af A[Catch:{ all -> 0x0040 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bd A[Catch:{ all -> 0x0040 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object A(kotlin.coroutines.Continuation r25) {
        /*
            r24 = this;
            r1 = r24
            r0 = r25
            boolean r2 = r0 instanceof com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper$endScreenRecord$1
            if (r2 == 0) goto L_0x0017
            r2 = r0
            com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper$endScreenRecord$1 r2 = (com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper$endScreenRecord$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.label = r3
            goto L_0x001c
        L_0x0017:
            com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper$endScreenRecord$1 r2 = new com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper$endScreenRecord$1
            r2.<init>(r1, r0)
        L_0x001c:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 0
            java.lang.String r6 = "endScreenRecord path:"
            r7 = 1
            java.lang.String r8 = "ScreenRecordHelper"
            if (r4 == 0) goto L_0x004c
            if (r4 != r7) goto L_0x0044
            java.lang.Object r1 = r2.L$2
            java.io.File r1 = (java.io.File) r1
            java.lang.Object r3 = r2.L$1
            com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper r3 = (com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper) r3
            java.lang.Object r2 = r2.L$0
            com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper r2 = (com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper) r2
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0040 }
            r9 = r1
            r1 = r3
            goto L_0x0097
        L_0x0040:
            r0 = move-exception
            r1 = r2
            goto L_0x00de
        L_0x0044:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004c:
            kotlin.ResultKt.throwOnFailure(r0)
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r4 = "endScreenRecord"
            r0.a(r8, r4)
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ all -> 0x00dd }
            com.xjmz.openxr.ctrl.record.RecordCtrl r4 = r24.D()     // Catch:{ all -> 0x00dd }
            r4.stopRecord()     // Catch:{ all -> 0x00dd }
            com.xjmz.openxr.ctrl.record.RecordCtrl r4 = r24.D()     // Catch:{ all -> 0x00dd }
            java.lang.String r4 = r4.getRecordPath()     // Catch:{ all -> 0x00dd }
            java.io.File r9 = new java.io.File     // Catch:{ all -> 0x00dd }
            r9.<init>(r4)     // Catch:{ all -> 0x00dd }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dd }
            r10.<init>()     // Catch:{ all -> 0x00dd }
            r10.append(r6)     // Catch:{ all -> 0x00dd }
            r10.append(r4)     // Catch:{ all -> 0x00dd }
            java.lang.String r4 = r10.toString()     // Catch:{ all -> 0x00dd }
            r0.a(r8, r4)     // Catch:{ all -> 0x00dd }
            kotlinx.coroutines.CoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.b()     // Catch:{ all -> 0x00dd }
            com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper$endScreenRecord$2$uri$1 r4 = new com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper$endScreenRecord$2$uri$1     // Catch:{ all -> 0x00dd }
            r4.<init>(r9, r1, r5)     // Catch:{ all -> 0x00dd }
            r2.L$0 = r1     // Catch:{ all -> 0x00dd }
            r2.L$1 = r1     // Catch:{ all -> 0x00dd }
            r2.L$2 = r9     // Catch:{ all -> 0x00dd }
            r2.label = r7     // Catch:{ all -> 0x00dd }
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.g(r0, r4, r2)     // Catch:{ all -> 0x00dd }
            if (r0 != r3) goto L_0x0096
            return r3
        L_0x0096:
            r2 = r1
        L_0x0097:
            android.net.Uri r0 = (android.net.Uri) r0     // Catch:{ all -> 0x0040 }
            com.upuphone.star.core.log.ULog$Delegate r3 = com.upuphone.star.core.log.ULog.f6446a     // Catch:{ all -> 0x0040 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0040 }
            r4.<init>()     // Catch:{ all -> 0x0040 }
            r4.append(r6)     // Catch:{ all -> 0x0040 }
            r4.append(r0)     // Catch:{ all -> 0x0040 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0040 }
            r3.a(r8, r4)     // Catch:{ all -> 0x0040 }
            if (r0 != 0) goto L_0x00bd
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper r10 = com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.f8088a     // Catch:{ all -> 0x0040 }
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper$ScreenRecordResult r11 = com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.ScreenRecordResult.FILE_SAVE_ERROR     // Catch:{ all -> 0x0040 }
            r15 = 6
            r16 = 0
            r12 = 0
            r14 = 0
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.e(r10, r11, r12, r14, r15, r16)     // Catch:{ all -> 0x0040 }
            goto L_0x00cc
        L_0x00bd:
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper r17 = com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.f8088a     // Catch:{ all -> 0x0040 }
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper$ScreenRecordResult r18 = com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.ScreenRecordResult.SUCCESS     // Catch:{ all -> 0x0040 }
            r22 = 6
            r23 = 0
            r19 = 0
            r21 = 0
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.e(r17, r18, r19, r21, r22, r23)     // Catch:{ all -> 0x0040 }
        L_0x00cc:
            r1.y(r9)     // Catch:{ all -> 0x0040 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0040 }
            r1.I(r0)     // Catch:{ all -> 0x0040 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0040 }
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r0)     // Catch:{ all -> 0x0040 }
            goto L_0x00e9
        L_0x00dd:
            r0 = move-exception
        L_0x00de:
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r0)
            r2 = r1
        L_0x00e9:
            java.lang.Throwable r0 = kotlin.Result.m23exceptionOrNullimpl(r0)
            if (r0 == 0) goto L_0x010a
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r3 = "endScreenRecord error"
            r1.d(r8, r3, r0)
            r2.I(r5)
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper r1 = com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.f8088a
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper$ScreenRecordResult r2 = com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.ScreenRecordResult.ERROR
            java.lang.String r0 = r0.getMessage()
            if (r0 != 0) goto L_0x0105
            java.lang.String r0 = ""
        L_0x0105:
            r3 = 0
            r1.d(r2, r3, r0)
        L_0x010a:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper.A(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final CoroutineScope B() {
        return (CoroutineScope) this.c.getValue();
    }

    public final String C() {
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
        return "MYVU_Capture_" + format;
    }

    public final RecordCtrl D() {
        return (RecordCtrl) this.b.getValue();
    }

    public final void E() {
        D().init(this.f8105a.getApplicationContext(), new MsgReceiver(), 1000, x(0));
    }

    public final void F() {
        for (OnCaptureScreenListener onPrepare : this.d) {
            onPrepare.onPrepare(0);
        }
    }

    public final void G(String str) {
        for (OnCaptureScreenListener onCaptureScreenEnd : this.d) {
            onCaptureScreenEnd.onCaptureScreenEnd(str);
        }
    }

    public final void H() {
        for (OnCaptureScreenListener onCaptureScreenStart : this.d) {
            onCaptureScreenStart.onCaptureScreenStart();
        }
    }

    public final void I(String str) {
        Deferred deferred;
        this.f = false;
        Deferred deferred2 = this.g;
        if (!(deferred2 == null || !deferred2.isActive() || (deferred = this.g) == null)) {
            Job.DefaultImpls.a(deferred, (CancellationException) null, 1, (Object) null);
        }
        for (OnRecordScreenListener onRecordScreenEnd : this.e) {
            onRecordScreenEnd.onRecordScreenEnd(str);
        }
    }

    public final void J() {
        this.f = true;
        for (OnRecordScreenListener onPrepare : this.e) {
            onPrepare.onPrepare(0);
        }
    }

    public final void K() {
        for (OnRecordScreenListener onRecordScreenStart : this.e) {
            onRecordScreenStart.onRecordScreenStart();
        }
    }

    public final void L() {
        Object systemService = this.f8105a.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancel(1000);
    }

    public final void M(OnCaptureScreenListener onCaptureScreenListener) {
        Intrinsics.checkNotNullParameter(onCaptureScreenListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.d.remove(onCaptureScreenListener);
    }

    public final void N(OnRecordScreenListener onRecordScreenListener) {
        Intrinsics.checkNotNullParameter(onRecordScreenListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.e.remove(onRecordScreenListener);
    }

    public final Object O(Continuation continuation) {
        ULog.f6446a.a("ScreenRecordHelper", "requestAuthorize");
        VuTouchpadActivity b2 = VuTouchpadActivity.w.b();
        if (b2 == null) {
            return null;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.x();
        b2.A1(new VuScreenRecordHelper$requestAuthorize$2$1(cancellableContinuationImpl));
        Object u = cancellableContinuationImpl.u();
        if (u == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return u;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00d4, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00d5, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00d8, code lost:
        throw r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.net.Uri P(java.io.File r10) {
        /*
            r9 = this;
            java.lang.String r9 = r9.C()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r9)
            java.lang.String r9 = ".jpg"
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            com.upuphone.xr.sapp.MainApplication$Companion r0 = com.upuphone.xr.sapp.MainApplication.k
            com.upuphone.xr.sapp.MainApplication r0 = r0.f()
            android.content.ContentResolver r0 = r0.getContentResolver()
            android.content.ContentValues r1 = new android.content.ContentValues
            r1.<init>()
            java.lang.String r2 = "_display_name"
            r1.put(r2, r9)
            java.lang.String r9 = "relative_path"
            java.lang.String r2 = "Pictures/Screenshots"
            r1.put(r9, r2)
            java.lang.String r9 = "mime_type"
            java.lang.String r2 = "image/jpeg"
            r1.put(r9, r2)
            long r2 = java.lang.System.currentTimeMillis()
            r9 = 1000(0x3e8, float:1.401E-42)
            long r4 = (long) r9
            long r2 = r2 / r4
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r4 = "date_added"
            r1.put(r4, r9)
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "date_modified"
            r1.put(r2, r9)
            r9 = 1920(0x780, float:2.69E-42)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r2 = "width"
            r1.put(r2, r9)
            r9 = 1080(0x438, float:1.513E-42)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r2 = "height"
            r1.put(r2, r9)
            r9 = 1
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r2 = "is_pending"
            r1.put(r2, r9)
            android.net.Uri r9 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            android.net.Uri r9 = r0.insert(r9, r1)
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "saveToGallery uri:"
            r3.append(r4)
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "ScreenRecordHelper"
            r1.a(r4, r3)
            r1 = 0
            if (r9 != 0) goto L_0x0094
            return r1
        L_0x0094:
            java.io.FileInputStream r3 = new java.io.FileInputStream
            r3.<init>(r10)
            android.graphics.Bitmap r10 = android.graphics.BitmapFactory.decodeStream(r3)     // Catch:{ all -> 0x00d2 }
            kotlin.io.CloseableKt.closeFinally(r3, r1)
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888
            r5 = 0
            android.graphics.Bitmap r4 = r10.copy(r4, r5)
            java.io.OutputStream r6 = r0.openOutputStream(r9)
            if (r6 == 0) goto L_0x00b4
            android.graphics.Bitmap$CompressFormat r7 = android.graphics.Bitmap.CompressFormat.JPEG
            r8 = 100
            r4.compress(r7, r8, r6)
        L_0x00b4:
            r3.close()
            if (r6 == 0) goto L_0x00bc
            r6.close()
        L_0x00bc:
            r10.recycle()
            r4.recycle()
            android.content.ContentValues r10 = new android.content.ContentValues
            r10.<init>()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r10.put(r2, r3)
            r0.update(r9, r10, r1, r1)
            return r9
        L_0x00d2:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x00d4 }
        L_0x00d4:
            r10 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper.P(java.io.File):android.net.Uri");
    }

    public final Uri Q(File file) {
        ContentResolver contentResolver = MainApplication.k.f().getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", C() + ".mp4");
        contentValues.put("mime_type", "video/mp4");
        contentValues.put("relative_path", "Movies/Videoshots");
        long currentTimeMillis = System.currentTimeMillis() / ((long) 1000);
        contentValues.put("date_added", Long.valueOf(currentTimeMillis));
        contentValues.put("date_modified", Long.valueOf(currentTimeMillis));
        contentValues.put(MonthView.VIEW_PARAMS_WIDTH, 1920);
        contentValues.put(MonthView.VIEW_PARAMS_HEIGHT, 1080);
        contentValues.put("is_pending", 1);
        Uri insert = contentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
        ULog.f6446a.a("ScreenRecordHelper", "saveToGallery uri:" + insert);
        if (insert == null) {
            return null;
        }
        if (w(file, insert)) {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("is_pending", 0);
            contentResolver.update(insert, contentValues2, (String) null, (String[]) null);
        }
        return insert;
    }

    public final void R() {
        if (this.f) {
            ULog.f6446a.a("ScreenRecordHelper", "screenShot isRecording");
        } else {
            Job unused = BuildersKt__Builders_commonKt.d(B(), (CoroutineContext) null, (CoroutineStart) null, new VuScreenRecordHelper$screenShot$1(this, (Continuation<? super VuScreenRecordHelper$screenShot$1>) null), 3, (Object) null);
        }
    }

    public final void S() {
        if (!v(this.f8105a)) {
            ULog.f6446a.a("ScreenRecordHelper", "startScreenRecord no permission");
            ArSpaceReportHelper.e(ArSpaceReportHelper.f8088a, ArSpaceReportHelper.ScreenRecordResult.NO_PERMISSION, 0, (String) null, 6, (Object) null);
        } else if (this.f) {
            ULog.f6446a.a("ScreenRecordHelper", "startScreenRecord isRecording");
            ArSpaceReportHelper.e(ArSpaceReportHelper.f8088a, ArSpaceReportHelper.ScreenRecordResult.SCREEN_RECORDING, 0, (String) null, 6, (Object) null);
        } else {
            Job unused = BuildersKt__Builders_commonKt.d(B(), (CoroutineContext) null, (CoroutineStart) null, new VuScreenRecordHelper$startScreenRecord$1(this, (Continuation<? super VuScreenRecordHelper$startScreenRecord$1>) null), 3, (Object) null);
        }
    }

    public final void T() {
        this.g = BuildersKt__Builders_commonKt.b(B(), (CoroutineContext) null, (CoroutineStart) null, new VuScreenRecordHelper$startTimer$1(this, (Continuation<? super VuScreenRecordHelper$startTimer$1>) null), 3, (Object) null);
    }

    public final void U(int i2) {
        Object systemService = this.f8105a.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).notify(1000, x(i2));
    }

    public final void s(OnCaptureScreenListener onCaptureScreenListener) {
        Intrinsics.checkNotNullParameter(onCaptureScreenListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.d.add(onCaptureScreenListener);
    }

    public final void t(OnRecordScreenListener onRecordScreenListener) {
        Intrinsics.checkNotNullParameter(onRecordScreenListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.e.add(onRecordScreenListener);
    }

    public final void u() {
        Object obj;
        ULog.f6446a.a("ScreenRecordHelper", "cancelScreenRecord");
        try {
            Result.Companion companion = Result.Companion;
            D().stopRecord();
            y(new File(D().getRecordPath()));
            obj = Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        Throwable r0 = Result.m23exceptionOrNullimpl(obj);
        if (r0 != null) {
            ULog.f6446a.d("ScreenRecordHelper", "cancelScreenRecord error", r0);
        }
        I((String) null);
    }

    public final boolean v(Context context) {
        return PermissionHelper.f7819a.n(context, new String[]{"android.permission.RECORD_AUDIO"});
    }

    public final boolean w(File file, Uri uri) {
        OutputStream openOutputStream = MainApplication.k.f().getContentResolver().openOutputStream(uri);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    try {
                        break;
                    } catch (Exception e2) {
                        ULog.f6446a.d("ScreenRecordHelper", "saveToGallery error", e2);
                    }
                } else if (openOutputStream != null) {
                    openOutputStream.write(bArr, 0, read);
                }
            } catch (Exception e3) {
                ULog.f6446a.d("ScreenRecordHelper", "saveToGallery error", e3);
                try {
                    fileInputStream.close();
                } catch (Exception e4) {
                    ULog.f6446a.d("ScreenRecordHelper", "saveToGallery error", e4);
                }
                if (openOutputStream == null) {
                    return false;
                }
                try {
                    openOutputStream.close();
                    return false;
                } catch (Exception e5) {
                    ULog.f6446a.d("ScreenRecordHelper", "saveToGallery error", e5);
                    return false;
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Exception e6) {
                    ULog.f6446a.d("ScreenRecordHelper", "saveToGallery error", e6);
                }
                if (openOutputStream != null) {
                    try {
                        openOutputStream.close();
                    } catch (Exception e7) {
                        ULog.f6446a.d("ScreenRecordHelper", "saveToGallery error", e7);
                    }
                }
                throw th;
            }
        }
        fileInputStream.close();
        if (openOutputStream != null) {
            try {
                openOutputStream.close();
            } catch (Exception e8) {
                ULog.f6446a.d("ScreenRecordHelper", "saveToGallery error", e8);
            }
        }
        return true;
    }

    public final Notification x(int i2) {
        String h2 = GlobalExtKt.h(R.string.screen_recording);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i2 / 60), Integer.valueOf(i2 % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        NotificationCompat.Builder B = new NotificationCompat.Builder(this.f8105a, "channel_screen_record").H(R.drawable.notification_logo).n(h2).m(format).l(PendingIntent.getActivity(this.f8105a, 0, new Intent(this.f8105a, MYVUActivity.class), PositionEstimate.Value.GNSS_TIME)).B(true);
        Intrinsics.checkNotNullExpressionValue(B, "setOnlyAlertOnce(...)");
        Notification c2 = B.c();
        Intrinsics.checkNotNullExpressionValue(c2, "build(...)");
        return c2;
    }

    public final void y(File file) {
        if (file.exists()) {
            file.delete();
        }
    }

    public final void z() {
        Job unused = BuildersKt__Builders_commonKt.d(B(), (CoroutineContext) null, (CoroutineStart) null, new VuScreenRecordHelper$destroy$1(this, (Continuation<? super VuScreenRecordHelper$destroy$1>) null), 3, (Object) null);
    }
}
