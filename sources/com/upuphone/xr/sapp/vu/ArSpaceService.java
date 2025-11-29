package com.upuphone.xr.sapp.vu;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.ServiceCompat;
import com.here.posclient.PositionEstimate;
import com.ucar.vehiclesdk.MDevice;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.utils.PhoneTypeUtils;
import com.upuphone.xr.sapp.vu.arspace.ArSpaceBridgerImpl;
import com.upuphone.xr.sapp.vu.arspace.ArSpaceMessageBroker;
import com.upuphone.xr.sapp.vu.arspace.ArSpaceMessageReceiver;
import com.upuphone.xr.sapp.vu.arspace.ArSpaceMessageSender;
import com.upuphone.xr.sapp.vu.arspace.IArSpaceMessageReceiver;
import com.upuphone.xr.sapp.vu.arspace.IOnDofModeChangeListener;
import com.upuphone.xr.sapp.vu.arspace.OnCaptureScreenListener;
import com.upuphone.xr.sapp.vu.arspace.OnRecordScreenListener;
import com.upuphone.xr.sapp.vu.input.RuntimeStatusOuterClass;
import com.upuphone.xr.sapp.vu.utils.GlassDataStoreHelper;
import com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil;
import com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper;
import com.xjmz.openxr.ctrl.dof.DOFCtrlBinder;
import com.xjmz.openxr.ctrl.runtime.RuntimeCtrl;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.apache.commons.lang3.BooleanUtils;
import org.zeromq.ZContext;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 c2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002deB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0005J\u0019\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ)\u0010\u001f\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\nH\u0016¢\u0006\u0004\b!\u0010\u0005J\u000f\u0010\"\u001a\u00020\nH\u0016¢\u0006\u0004\b\"\u0010\u0005J\u001d\u0010(\u001a\u00020'2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b(\u0010)J\u0015\u0010+\u001a\u00020\n2\u0006\u0010*\u001a\u00020'¢\u0006\u0004\b+\u0010,J\u0015\u0010.\u001a\u00020\n2\u0006\u0010-\u001a\u00020\b¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020\n¢\u0006\u0004\b0\u0010\u0005J\r\u00101\u001a\u00020\n¢\u0006\u0004\b1\u0010\u0005J\r\u00102\u001a\u00020\n¢\u0006\u0004\b2\u0010\u0005J\u0015\u00104\u001a\u00020\n2\u0006\u00103\u001a\u00020#¢\u0006\u0004\b4\u00105J\u001d\u00108\u001a\u00020\n2\u0006\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020'¢\u0006\u0004\b8\u00109J\u0015\u0010;\u001a\u00020\n2\u0006\u0010:\u001a\u00020'¢\u0006\u0004\b;\u0010,J\u0015\u0010=\u001a\u00020\n2\u0006\u0010<\u001a\u00020\b¢\u0006\u0004\b=\u0010/J\u0015\u0010?\u001a\u00020\n2\u0006\u0010>\u001a\u00020'¢\u0006\u0004\b?\u0010,J\u001f\u0010@\u001a\u00020\n2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b@\u0010AR\u0018\u0010D\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010CR\u0016\u0010G\u001a\u00020E8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\"\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010^\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010b\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b`\u0010a¨\u0006f"}, d2 = {"Lcom/upuphone/xr/sapp/vu/ArSpaceService;", "Landroid/app/Service;", "Lcom/upuphone/xr/sapp/vu/arspace/IArSpaceMessageReceiver;", "Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$OnArSpaceExitListener;", "<init>", "()V", "Landroid/content/Context;", "context", "", "displayId", "", "C", "(Landroid/content/Context;I)V", "E", "A", "q", "B", "Landroid/app/Notification;", "p", "()Landroid/app/Notification;", "Landroid/widget/RemoteViews;", "r", "()Landroid/widget/RemoteViews;", "onCreate", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "onDestroy", "b", "", "topic", "", "data", "", "w", "(Ljava/lang/String;[B)Z", "force", "u", "(Z)V", "dofMode", "z", "(I)V", "v", "D", "F", "language", "o", "(Ljava/lang/String;)V", "requestTag", "result", "t", "(Ljava/lang/String;Z)V", "enable", "s", "brightness", "y", "antiShake", "x", "a", "(Ljava/lang/String;[B)V", "Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl;", "Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl;", "arSpaceBridger", "Lorg/zeromq/ZContext;", "Lorg/zeromq/ZContext;", "zmqContext", "Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceMessageSender;", "c", "Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceMessageSender;", "touchpadMessengerSender", "Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceMessageReceiver;", "d", "Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceMessageReceiver;", "touchpadMessengerReceiver", "Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceMessageBroker;", "e", "Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceMessageBroker;", "messageBroker", "f", "Z", "isTouchpadExit", "Lcom/xjmz/openxr/ctrl/runtime/RuntimeCtrl;", "g", "Lcom/xjmz/openxr/ctrl/runtime/RuntimeCtrl;", "runtimeCtrl", "Lcom/xjmz/openxr/ctrl/dof/DOFCtrlBinder;", "h", "Lcom/xjmz/openxr/ctrl/dof/DOFCtrlBinder;", "dofCtrlBinder", "Lcom/upuphone/xr/sapp/vu/utils/VuScreenRecordHelper;", "i", "Lcom/upuphone/xr/sapp/vu/utils/VuScreenRecordHelper;", "vuScreenRecordHelper", "j", "ArSpaceServiceListener", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nArSpaceService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArSpaceService.kt\ncom/upuphone/xr/sapp/vu/ArSpaceService\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,434:1\n1#2:435\n*E\n"})
public final class ArSpaceService extends Service implements IArSpaceMessageReceiver, ArSpaceBridgerImpl.OnArSpaceExitListener {
    public static final Companion j = new Companion((DefaultConstructorMarker) null);
    public static ArSpaceService k;
    public static RuntimeStatusOuterClass.RuntimeStatus l;
    public static boolean m;
    public static OnRecordScreenListener n;
    public static OnCaptureScreenListener o;
    public static IOnDofModeChangeListener p;

    /* renamed from: a  reason: collision with root package name */
    public ArSpaceBridgerImpl f8018a;
    public ZContext b;
    public ArSpaceMessageSender c;
    public ArSpaceMessageReceiver d;
    public ArSpaceMessageBroker e;
    public boolean f;
    public RuntimeCtrl g;
    public DOFCtrlBinder h;
    public VuScreenRecordHelper i;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/upuphone/xr/sapp/vu/ArSpaceService$ArSpaceServiceListener;", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface ArSpaceServiceListener {
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\u0003R$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R.\u0010#\u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010!8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R.\u0010*\u001a\u0004\u0018\u00010)2\b\u0010\"\u001a\u0004\u0018\u00010)8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R.\u00101\u001a\u0004\u0018\u0001002\b\u0010\"\u001a\u0004\u0018\u0001008\u0006@FX\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002XT¢\u0006\u0006\n\u0004\b8\u00109¨\u0006:"}, d2 = {"Lcom/upuphone/xr/sapp/vu/ArSpaceService$Companion;", "", "<init>", "()V", "", "displayId", "Landroid/content/Context;", "context", "", "j", "(ILandroid/content/Context;)V", "d", "Lcom/upuphone/xr/sapp/vu/ArSpaceService;", "instance", "Lcom/upuphone/xr/sapp/vu/ArSpaceService;", "a", "()Lcom/upuphone/xr/sapp/vu/ArSpaceService;", "setInstance", "(Lcom/upuphone/xr/sapp/vu/ArSpaceService;)V", "Lcom/upuphone/xr/sapp/vu/input/RuntimeStatusOuterClass$RuntimeStatus;", "runtimeStatus", "Lcom/upuphone/xr/sapp/vu/input/RuntimeStatusOuterClass$RuntimeStatus;", "b", "()Lcom/upuphone/xr/sapp/vu/input/RuntimeStatusOuterClass$RuntimeStatus;", "g", "(Lcom/upuphone/xr/sapp/vu/input/RuntimeStatusOuterClass$RuntimeStatus;)V", "", "isArspaceStarted", "Z", "c", "()Z", "e", "(Z)V", "Lcom/upuphone/xr/sapp/vu/arspace/OnRecordScreenListener;", "value", "screenRecordScreenListener", "Lcom/upuphone/xr/sapp/vu/arspace/OnRecordScreenListener;", "getScreenRecordScreenListener", "()Lcom/upuphone/xr/sapp/vu/arspace/OnRecordScreenListener;", "i", "(Lcom/upuphone/xr/sapp/vu/arspace/OnRecordScreenListener;)V", "Lcom/upuphone/xr/sapp/vu/arspace/OnCaptureScreenListener;", "screenCaptureScreenListener", "Lcom/upuphone/xr/sapp/vu/arspace/OnCaptureScreenListener;", "getScreenCaptureScreenListener", "()Lcom/upuphone/xr/sapp/vu/arspace/OnCaptureScreenListener;", "h", "(Lcom/upuphone/xr/sapp/vu/arspace/OnCaptureScreenListener;)V", "Lcom/upuphone/xr/sapp/vu/arspace/IOnDofModeChangeListener;", "dofModeChangeListener", "Lcom/upuphone/xr/sapp/vu/arspace/IOnDofModeChangeListener;", "getDofModeChangeListener", "()Lcom/upuphone/xr/sapp/vu/arspace/IOnDofModeChangeListener;", "f", "(Lcom/upuphone/xr/sapp/vu/arspace/IOnDofModeChangeListener;)V", "", "TAG", "Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ArSpaceService a() {
            return ArSpaceService.k;
        }

        public final RuntimeStatusOuterClass.RuntimeStatus b() {
            return ArSpaceService.l;
        }

        public final boolean c() {
            return ArSpaceService.m;
        }

        public final void d() {
            e(false);
            RuntimeStatusOuterClass.RuntimeStatus defaultInstance = RuntimeStatusOuterClass.RuntimeStatus.getDefaultInstance();
            Intrinsics.checkNotNullExpressionValue(defaultInstance, "getDefaultInstance(...)");
            g(defaultInstance);
        }

        public final void e(boolean z) {
            ArSpaceService.m = z;
        }

        public final void f(IOnDofModeChangeListener iOnDofModeChangeListener) {
            ArSpaceService a2;
            ArSpaceBridgerImpl c;
            ArSpaceBridgerImpl c2;
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("ArSpaceService", "dofModeChangeListener change: " + iOnDofModeChangeListener);
            if (ArSpaceService.p != null) {
                IOnDofModeChangeListener d = ArSpaceService.p;
                delegate.a("ArSpaceService", "dofModeChangeListener remove old: " + d);
                ArSpaceService a3 = a();
                if (!(a3 == null || (c2 = a3.f8018a) == null)) {
                    IOnDofModeChangeListener d2 = ArSpaceService.p;
                    Intrinsics.checkNotNull(d2);
                    c2.removeOnDofModeChangeListener(d2);
                }
            }
            if (!(iOnDofModeChangeListener == null || (a2 = a()) == null || (c = a2.f8018a) == null)) {
                c.addOnDofModeChangeListener(iOnDofModeChangeListener);
            }
            ArSpaceService.p = iOnDofModeChangeListener;
        }

        public final void g(RuntimeStatusOuterClass.RuntimeStatus runtimeStatus) {
            Intrinsics.checkNotNullParameter(runtimeStatus, "<set-?>");
            ArSpaceService.l = runtimeStatus;
        }

        public final void h(OnCaptureScreenListener onCaptureScreenListener) {
            ArSpaceBridgerImpl c;
            ArSpaceBridgerImpl c2;
            ArSpaceService a2 = a();
            if (!(a2 == null || (c2 = a2.f8018a) == null)) {
                c2.removeOnCaptureScreenListener(ArSpaceService.o);
            }
            ArSpaceService a3 = a();
            if (!(a3 == null || (c = a3.f8018a) == null)) {
                c.addOnCaptureScreenListener(onCaptureScreenListener);
            }
            ArSpaceService.o = onCaptureScreenListener;
        }

        public final void i(OnRecordScreenListener onRecordScreenListener) {
            ArSpaceBridgerImpl c;
            ArSpaceBridgerImpl c2;
            ArSpaceService a2 = a();
            if (!(a2 == null || (c2 = a2.f8018a) == null)) {
                c2.removeOnRecordScreenListener(ArSpaceService.n);
            }
            ArSpaceService a3 = a();
            if (!(a3 == null || (c = a3.f8018a) == null)) {
                c.addOnRecordScreenListener(onRecordScreenListener);
            }
            ArSpaceService.n = onRecordScreenListener;
        }

        public final void j(int i, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, ArSpaceService.class);
            intent.putExtra("displayId", i);
            context.startService(intent);
        }

        public Companion() {
        }
    }

    static {
        RuntimeStatusOuterClass.RuntimeStatus defaultInstance = RuntimeStatusOuterClass.RuntimeStatus.getDefaultInstance();
        Intrinsics.checkNotNullExpressionValue(defaultInstance, "getDefaultInstance(...)");
        l = defaultInstance;
    }

    public final void A() {
        this.b = new ZContext(5);
        ZContext zContext = this.b;
        ZContext zContext2 = null;
        if (zContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("zmqContext");
            zContext = null;
        }
        ArSpaceMessageBroker arSpaceMessageBroker = new ArSpaceMessageBroker(zContext);
        if (!arSpaceMessageBroker.d()) {
            ULog.f6446a.c("ArSpaceService", "startArSpaceMessage: initBroker failed");
            return;
        }
        this.e = arSpaceMessageBroker;
        Intrinsics.checkNotNull(arSpaceMessageBroker);
        String b2 = arSpaceMessageBroker.b();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ArSpaceService", "ArSpaceMessageSender: pubEndpoint: " + b2);
        ZContext zContext3 = this.b;
        if (zContext3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("zmqContext");
            zContext3 = null;
        }
        ArSpaceMessageSender arSpaceMessageSender = new ArSpaceMessageSender(zContext3, b2);
        if (!arSpaceMessageSender.b()) {
            delegate.c("ArSpaceService", "startArSpaceMessage: initSender failed");
            return;
        }
        this.c = arSpaceMessageSender;
        ArSpaceMessageBroker arSpaceMessageBroker2 = this.e;
        Intrinsics.checkNotNull(arSpaceMessageBroker2);
        String c2 = arSpaceMessageBroker2.c();
        delegate.a("ArSpaceService", "ArSpaceMessageReceiver: subEndpoint: " + c2);
        ZContext zContext4 = this.b;
        if (zContext4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("zmqContext");
        } else {
            zContext2 = zContext4;
        }
        ArSpaceMessageReceiver arSpaceMessageReceiver = new ArSpaceMessageReceiver(zContext2, c2, "status", this);
        if (!arSpaceMessageReceiver.b()) {
            delegate.c("ArSpaceService", "startArSpaceMessage: initReceiver failed");
        } else {
            this.d = arSpaceMessageReceiver;
        }
    }

    public final void B() {
        try {
            ServiceCompat.a(this, 2000, p(), 2);
        } catch (Exception e2) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("ArSpaceService", "start foreground service error: " + e2);
        }
    }

    public final void C(Context context, int i2) {
        ArSpaceMessageBroker arSpaceMessageBroker = this.e;
        String str = null;
        String c2 = arSpaceMessageBroker != null ? arSpaceMessageBroker.c() : null;
        ArSpaceMessageBroker arSpaceMessageBroker2 = this.e;
        if (arSpaceMessageBroker2 != null) {
            str = arSpaceMessageBroker2.b();
        }
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("ArSpaceService", "startOpenXrRuntime: " + c2 + " " + str + "  DisplayId:" + i2);
        GlassDataStoreHelper glassDataStoreHelper = GlassDataStoreHelper.f8091a;
        boolean c3 = glassDataStoreHelper.c(false);
        glassDataStoreHelper.f(true);
        Map mapOf = MapsKt.mapOf(TuplesKt.to("XRT_MYVU_MSG_PUB_ENDPOINT", c2), TuplesKt.to("XRT_MYVU_MSG_SUB_ENDPOINT", str), TuplesKt.to("XRT_MYVU_HUB_SIMULATION", BooleanUtils.FALSE), TuplesKt.to("XRT_MYVU_VIEW_COUNT", "2"), TuplesKt.to("XRT_DISPLAY_PREMODE_ID", "0"), TuplesKt.to("XRT_DISPLAY_WIDTH", "3840"), TuplesKt.to("XRT_DISPLAY_HEIGHT", "1080"), TuplesKt.to("XRT_DISPLAY_REFRESH_RATE", "60"), TuplesKt.to("XRT_DISPLAY_ID", String.valueOf(i2)), TuplesKt.to("XRT_MYVU_HMD_ES", String.valueOf(c3)), TuplesKt.to("XRT_MYVU_HMD_HF", BooleanUtils.TRUE), TuplesKt.to("XRT_MYVU_HMD_DT", "follow_head"), TuplesKt.to("MMYVU_LOG", "debug"));
        try {
            RuntimeCtrl runtimeCtrl = this.g;
            if (runtimeCtrl != null) {
                runtimeCtrl.init(context, mapOf);
            }
            DOFCtrlBinder dOFCtrlBinder = this.h;
            if (dOFCtrlBinder != null) {
                dOFCtrlBinder.init(getApplicationContext());
            }
            VuScreenRecordHelper vuScreenRecordHelper = this.i;
            if (vuScreenRecordHelper != null) {
                vuScreenRecordHelper.E();
            }
        } catch (Exception e2) {
            ULog.Delegate delegate2 = ULog.f6446a;
            String message = e2.getMessage();
            delegate2.c("ArSpaceService", "startOpenXrRuntime error: " + message);
        }
    }

    public final void D() {
        ArSpaceBridgerImpl arSpaceBridgerImpl = this.f8018a;
        if (arSpaceBridgerImpl != null) {
            arSpaceBridgerImpl.startScreenRecord();
        }
    }

    public final void E() {
        ULog.f6446a.g("ArSpaceService", "stopOpenXrRuntime");
        try {
            VuScreenRecordHelper vuScreenRecordHelper = this.i;
            if (vuScreenRecordHelper != null) {
                vuScreenRecordHelper.z();
            }
            DOFCtrlBinder dOFCtrlBinder = this.h;
            if (dOFCtrlBinder != null) {
                dOFCtrlBinder.destroy();
            }
            RuntimeCtrl runtimeCtrl = this.g;
            if (runtimeCtrl != null) {
                runtimeCtrl.destroy();
            }
        } catch (Exception e2) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e2.getMessage();
            delegate.c("ArSpaceService", "stopOpenXrRuntime error: " + message);
        }
        this.g = null;
        this.i = null;
        this.h = null;
    }

    public final void F() {
        ArSpaceBridgerImpl arSpaceBridgerImpl = this.f8018a;
        if (arSpaceBridgerImpl != null) {
            arSpaceBridgerImpl.endScreenRecord();
        }
    }

    public void a(String str, byte[] bArr) {
        Intrinsics.checkNotNullParameter(str, "topic");
        Intrinsics.checkNotNullParameter(bArr, "data");
        RuntimeStatusOuterClass.RuntimeStatus parseFrom = RuntimeStatusOuterClass.RuntimeStatus.parseFrom(bArr);
        Intrinsics.checkNotNullExpressionValue(parseFrom, "parseFrom(...)");
        l = parseFrom;
        if (parseFrom.getFps() > 10.0f) {
            m = true;
        }
    }

    public void b() {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("ArSpaceService", "onArSpaceExit");
        stopSelf();
        VuTouchpadActivity b2 = VuTouchpadActivity.w.b();
        if (b2 != null) {
            b2.q1();
        }
        VuGlassesHidUtil.f8104a.w();
        this.f = true;
        delegate.g("ArSpaceService", "onArSpaceExit Over");
    }

    public final void o(String str) {
        Intrinsics.checkNotNullParameter(str, "language");
        ArSpaceBridgerImpl arSpaceBridgerImpl = this.f8018a;
        if (arSpaceBridgerImpl != null) {
            arSpaceBridgerImpl.changeLanguage(str);
        }
    }

    public IBinder onBind(Intent intent) {
        ULog.f6446a.g("ArSpaceService", "onBind");
        ArSpaceBridgerImpl arSpaceBridgerImpl = this.f8018a;
        Intrinsics.checkNotNull(arSpaceBridgerImpl);
        return arSpaceBridgerImpl;
    }

    public void onCreate() {
        super.onCreate();
        k = this;
        this.g = new RuntimeCtrl();
        this.h = new DOFCtrlBinder();
        this.i = new VuScreenRecordHelper(this);
        ULog.f6446a.g("ArSpaceService", "onCreate");
        RuntimeStatusOuterClass.RuntimeStatus defaultInstance = RuntimeStatusOuterClass.RuntimeStatus.getDefaultInstance();
        Intrinsics.checkNotNullExpressionValue(defaultInstance, "getDefaultInstance(...)");
        l = defaultInstance;
        m = false;
        A();
        DOFCtrlBinder dOFCtrlBinder = this.h;
        Intrinsics.checkNotNull(dOFCtrlBinder);
        VuScreenRecordHelper vuScreenRecordHelper = this.i;
        Intrinsics.checkNotNull(vuScreenRecordHelper);
        ArSpaceBridgerImpl arSpaceBridgerImpl = new ArSpaceBridgerImpl(this, dOFCtrlBinder, vuScreenRecordHelper);
        arSpaceBridgerImpl.setArSpaceExitListener(this);
        arSpaceBridgerImpl.addOnCaptureScreenListener(o);
        arSpaceBridgerImpl.addOnRecordScreenListener(n);
        IOnDofModeChangeListener iOnDofModeChangeListener = p;
        if (iOnDofModeChangeListener != null) {
            arSpaceBridgerImpl.addOnDofModeChangeListener(iOnDofModeChangeListener);
        }
        this.f8018a = arSpaceBridgerImpl;
    }

    public void onDestroy() {
        super.onDestroy();
        stopForeground(1);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("ArSpaceService", "onDestroy");
        if (!this.f) {
            VuTouchpadActivity b2 = VuTouchpadActivity.w.b();
            if (b2 != null) {
                b2.q1();
            }
            Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, Dispatchers.b(), (CoroutineStart) null, new ArSpaceService$onDestroy$1((Continuation<? super ArSpaceService$onDestroy$1>) null), 2, (Object) null);
        }
        ArSpaceBridgerImpl arSpaceBridgerImpl = this.f8018a;
        if (arSpaceBridgerImpl != null) {
            arSpaceBridgerImpl.destroy();
        }
        ArSpaceBridgerImpl arSpaceBridgerImpl2 = this.f8018a;
        if (arSpaceBridgerImpl2 != null) {
            arSpaceBridgerImpl2.setArSpaceExitListener((ArSpaceBridgerImpl.OnArSpaceExitListener) null);
        }
        E();
        q();
        Companion companion = j;
        companion.i((OnRecordScreenListener) null);
        companion.h((OnCaptureScreenListener) null);
        companion.f((IOnDofModeChangeListener) null);
        k = null;
        this.f8018a = null;
        delegate.g("ArSpaceService", "onDestroy Over");
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        Integer valueOf = intent != null ? Integer.valueOf(intent.getIntExtra("displayId", 0)) : null;
        if (valueOf != null) {
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            C(applicationContext, valueOf.intValue());
        } else {
            Context applicationContext2 = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
            C(applicationContext2, 0);
        }
        B();
        return 2;
    }

    public final Notification p() {
        NotificationCompat.Builder p2 = new NotificationCompat.Builder(this, "channel_screen_record").H(R.drawable.notification_logo).n(getString(R.string.view_glasses) + getString(R.string.air_glass_connect)).l(PendingIntent.getActivity(this, 0, new Intent(this, VuTouchpadActivity.class), PositionEstimate.Value.GNSS_TIME)).p(r());
        Intrinsics.checkNotNullExpressionValue(p2, "setCustomContentView(...)");
        PhoneTypeUtils phoneTypeUtils = PhoneTypeUtils.f7912a;
        if (Intrinsics.areEqual((Object) phoneTypeUtils.b(), (Object) MDevice.MANUFACTURERS_OPPO) || Intrinsics.areEqual((Object) phoneTypeUtils.b(), (Object) MDevice.MANUFACTURERS_VIVO) || phoneTypeUtils.f()) {
            p2.J(new NotificationCompat.DecoratedCustomViewStyle());
        } else if (Intrinsics.areEqual((Object) phoneTypeUtils.b(), (Object) "huawei") || Intrinsics.areEqual((Object) phoneTypeUtils.b(), (Object) "samsung")) {
            p2.H(R.drawable.notification_logo_mini);
        } else {
            p2.p(r());
        }
        Notification c2 = p2.c();
        Intrinsics.checkNotNullExpressionValue(c2, "build(...)");
        return c2;
    }

    public final void q() {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ArSpaceService", "destroyMessageSender start");
        ArSpaceMessageSender arSpaceMessageSender = this.c;
        if (arSpaceMessageSender != null) {
            arSpaceMessageSender.a();
        }
        delegate.a("ArSpaceService", "destroyMessageReceiver end");
        ArSpaceMessageReceiver arSpaceMessageReceiver = this.d;
        if (arSpaceMessageReceiver != null) {
            arSpaceMessageReceiver.a();
        }
        delegate.a("ArSpaceService", "destroyMessageBroker end");
        ArSpaceMessageBroker arSpaceMessageBroker = this.e;
        if (arSpaceMessageBroker != null) {
            arSpaceMessageBroker.a();
        }
        delegate.a("ArSpaceService", "zmqContext end");
        ZContext zContext = this.b;
        if (zContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("zmqContext");
            zContext = null;
        }
        zContext.close();
        delegate.a("ArSpaceService", "destroyMessageSender over");
    }

    public final RemoteViews r() {
        int i2;
        PhoneTypeUtils phoneTypeUtils = PhoneTypeUtils.f7912a;
        String b2 = phoneTypeUtils.b();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ArSpaceService", "getSmallRemoteViews::phone type is: " + b2);
        if (phoneTypeUtils.d()) {
            i2 = R.layout.notification_content_hw;
        } else if (phoneTypeUtils.e()) {
            Boolean bool = BuildConfig.f6575a;
            delegate.g("ArSpaceService", "getSmallRemoteViews  XIAOMI BuildConfig.COUNTRY_INTL = " + bool);
            i2 = !bool.booleanValue() ? R.layout.notification_content_xiaomi : R.layout.notification_content_xiaomi_for_intl;
        } else {
            i2 = phoneTypeUtils.h() ? R.layout.notification_content_mars : phoneTypeUtils.k() ? R.layout.notification_content_sanxing : R.layout.notification_content;
        }
        RemoteViews remoteViews = new RemoteViews(getPackageName(), i2);
        remoteViews.setViewVisibility(R.id.notification_touchpad, 0);
        remoteViews.setViewVisibility(R.id.notification_split, 0);
        remoteViews.setViewVisibility(R.id.delete, 8);
        int i3 = R.id.notification_content;
        String string = getString(R.string.view_glasses);
        String string2 = getString(R.string.air_glass_connect);
        remoteViews.setTextViewText(i3, string + string2);
        return remoteViews;
    }

    public final void s(boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ArSpaceService", "onLocationServiceResult: " + z);
        ArSpaceBridgerImpl arSpaceBridgerImpl = this.f8018a;
        if (arSpaceBridgerImpl != null) {
            arSpaceBridgerImpl.onLocationServiceResult(z);
        }
    }

    public final void t(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "requestTag");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("ArSpaceService", "onRequestPermissionResult: " + str + ", " + z);
        ArSpaceBridgerImpl arSpaceBridgerImpl = this.f8018a;
        if (arSpaceBridgerImpl != null) {
            arSpaceBridgerImpl.onRequestPermissionResult(str, z);
        }
    }

    public final void u(boolean z) {
        ArSpaceBridgerImpl arSpaceBridgerImpl = this.f8018a;
        if (arSpaceBridgerImpl != null) {
            arSpaceBridgerImpl.exitArSpace(z);
        }
    }

    public final void v() {
        ULog.f6446a.a("ArSpaceService", "screenshot");
        ArSpaceBridgerImpl arSpaceBridgerImpl = this.f8018a;
        if (arSpaceBridgerImpl != null) {
            arSpaceBridgerImpl.captureScreen();
        }
    }

    public final boolean w(String str, byte[] bArr) {
        Intrinsics.checkNotNullParameter(str, "topic");
        Intrinsics.checkNotNullParameter(bArr, "data");
        ArSpaceMessageSender arSpaceMessageSender = this.c;
        if (arSpaceMessageSender != null) {
            return arSpaceMessageSender.c(str, bArr);
        }
        return false;
    }

    public final void x(boolean z) {
        try {
            DOFCtrlBinder dOFCtrlBinder = this.h;
            if (dOFCtrlBinder != null) {
                dOFCtrlBinder.setStabilization(z);
            }
        } catch (Exception e2) {
            ULog.Delegate delegate = ULog.f6446a;
            String message = e2.getMessage();
            delegate.c("ArSpaceService", "setAntiShake error: " + message);
        }
    }

    public final void y(int i2) {
        ArSpaceBridgerImpl arSpaceBridgerImpl = this.f8018a;
        if (arSpaceBridgerImpl != null) {
            arSpaceBridgerImpl.setBrightness(i2);
        }
    }

    public final void z(int i2) {
        ArSpaceBridgerImpl arSpaceBridgerImpl = this.f8018a;
        if (arSpaceBridgerImpl != null) {
            arSpaceBridgerImpl.setDofMode(i2);
        }
    }
}
