package com.upuphone.xr.sapp.vu.arspace;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.entity.DeviceInfo;
import com.upuphone.xr.sapp.utils.DataTrackUtil;
import com.upuphone.xr.sapp.vu.VuInputDialog;
import com.upuphone.xr.sapp.vu.VuTouchpadActivity;
import com.upuphone.xr.sapp.vu.arspace.IArSpaceBridger;
import com.upuphone.xr.sapp.vu.monitor.VuSportInfo;
import com.upuphone.xr.sapp.vu.monitor.VuWeatherMonitor;
import com.upuphone.xr.sapp.vu.utils.VuGlassesEventDispatcher;
import com.upuphone.xr.sapp.vu.utils.VuGlassesHidUtil;
import com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper;
import com.upuphone.xr.sapp.vu.vm.VuGlassesDeviceInfoModel;
import com.xjmz.openxr.ctrl.dof.DOFCtrlBinder;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\f*\u0006\u001a$-8=@\u0018\u0000 \u00012\u00020\u0001:\u0004\u0001\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u001eH\u0016J\u0010\u0010G\u001a\u00020E2\u0006\u0010F\u001a\u00020 H\u0016J\u0010\u0010G\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010HJ\u0010\u0010I\u001a\u00020E2\u0006\u0010F\u001a\u00020\"H\u0016J\u0010\u0010J\u001a\u00020E2\u0006\u0010F\u001a\u00020'H\u0016J\u0010\u0010K\u001a\u00020E2\u0006\u0010F\u001a\u00020)H\u0016J\u0010\u0010L\u001a\u00020E2\u0006\u0010F\u001a\u00020+H\u0016J\u0010\u0010M\u001a\u00020E2\u0006\u0010F\u001a\u000200H\u0016J\u0010\u0010M\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010NJ\u0010\u0010O\u001a\u00020E2\u0006\u0010F\u001a\u000202H\u0016J\u0010\u0010P\u001a\u00020E2\u0006\u0010F\u001a\u000204H\u0016J\u0010\u0010Q\u001a\u00020E2\u0006\u0010F\u001a\u000206H\u0016J\b\u0010R\u001a\u00020EH\u0016J\u000e\u0010S\u001a\u00020E2\u0006\u0010T\u001a\u00020UJ\u001c\u0010V\u001a\u00020E2\b\u0010W\u001a\u0004\u0018\u00010U2\b\u0010F\u001a\u0004\u0018\u00010XH\u0016J\b\u0010Y\u001a\u00020EH\u0002J\u0006\u0010Z\u001a\u00020EJ\b\u0010[\u001a\u00020EH\u0016J\b\u0010\\\u001a\u00020EH\u0016J\u000e\u0010]\u001a\u00020E2\u0006\u0010^\u001a\u00020\u0018J\b\u0010_\u001a\u00020\u0014H\u0016J\b\u0010`\u001a\u00020\u0014H\u0016J\b\u0010a\u001a\u00020UH\u0016J\b\u0010b\u001a\u00020\u0014H\u0016J\b\u0010c\u001a\u00020\u0014H\u0016J\b\u0010d\u001a\u00020EH\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010e\u001a\u00020\u0018H\u0016J\b\u0010f\u001a\u00020EH\u0016J\u000e\u0010g\u001a\u00020E2\u0006\u0010h\u001a\u00020\u0018J\u0016\u0010i\u001a\u00020E2\u0006\u0010j\u001a\u00020U2\u0006\u0010k\u001a\u00020\u0018J\u0010\u0010l\u001a\u00020E2\u0006\u0010F\u001a\u00020\u001eH\u0016J\u0010\u0010m\u001a\u00020E2\u0006\u0010F\u001a\u00020 H\u0016J\u0010\u0010m\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010HJ\u0010\u0010n\u001a\u00020E2\u0006\u0010F\u001a\u00020\"H\u0016J\u0010\u0010o\u001a\u00020E2\u0006\u0010F\u001a\u00020'H\u0016J\u0010\u0010p\u001a\u00020E2\u0006\u0010F\u001a\u00020)H\u0016J\u0010\u0010q\u001a\u00020E2\u0006\u0010F\u001a\u00020+H\u0016J\u0010\u0010r\u001a\u00020E2\u0006\u0010F\u001a\u000200H\u0016J\u0010\u0010r\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010NJ\u0010\u0010s\u001a\u00020E2\u0006\u0010F\u001a\u000202H\u0016J\u0010\u0010t\u001a\u00020E2\u0006\u0010F\u001a\u000204H\u0016J\u0010\u0010u\u001a\u00020E2\u0006\u0010F\u001a\u000206H\u0016J(\u0010v\u001a\u00020E2\u0006\u0010w\u001a\u00020U2\u0016\u0010x\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010z\u0012\u0006\u0012\u0004\u0018\u00010z0yH\u0016J\u0018\u0010{\u001a\u00020E2\u0006\u0010|\u001a\u00020U2\u0006\u0010F\u001a\u00020;H\u0016J:\u0010}\u001a\u00020E2\u0006\u0010j\u001a\u00020U2\b\u0010~\u001a\u0004\u0018\u00010U2\b\u0010\u001a\u0004\u0018\u00010U2\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020U0\u0001H\u0016¢\u0006\u0003\u0010\u0001J\u0012\u0010\u0001\u001a\u00020E2\u0007\u0010\u0001\u001a\u00020\u0014H\u0016J\u0011\u0010\u0001\u001a\u00020E2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0001\u001a\u00020E2\u0007\u0010\u0001\u001a\u00020\u0012H\u0002J\u0012\u0010\u0001\u001a\u00020E2\u0007\u0010\u0001\u001a\u00020\u0012H\u0016J\t\u0010\u0001\u001a\u00020EH\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001dX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001dX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00020$X\u0004¢\u0006\u0004\n\u0002\u0010%R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u001dX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u001dX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u001dX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u00020-X\u0004¢\u0006\u0004\n\u0002\u0010.R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u001dX\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u0002020\u001dX\u0004¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\b\u0012\u0004\u0012\u0002040\u001dX\u0004¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u0002060\u001dX\u0004¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u000208X\u0004¢\u0006\u0004\n\u0002\u00109R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u00020=X\u0004¢\u0006\u0004\n\u0002\u0010>R\u0010\u0010?\u001a\u00020@X\u0004¢\u0006\u0004\n\u0002\u0010AR\u000e\u0010B\u001a\u00020CX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl;", "Lcom/upuphone/xr/sapp/vu/arspace/IArSpaceBridger$Stub;", "context", "Landroid/content/Context;", "dofCtrlBinder", "Lcom/xjmz/openxr/ctrl/dof/DOFCtrlBinder;", "recordHelper", "Lcom/upuphone/xr/sapp/vu/utils/VuScreenRecordHelper;", "(Landroid/content/Context;Lcom/xjmz/openxr/ctrl/dof/DOFCtrlBinder;Lcom/upuphone/xr/sapp/vu/utils/VuScreenRecordHelper;)V", "arSpaceExitListener", "Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$OnArSpaceExitListener;", "getArSpaceExitListener", "()Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$OnArSpaceExitListener;", "setArSpaceExitListener", "(Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$OnArSpaceExitListener;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "currentEditTextInfo", "Lcom/upuphone/xr/sapp/vu/arspace/EditTextInfo;", "dofMode", "", "inputDialog", "Lcom/upuphone/xr/sapp/vu/VuInputDialog;", "isExiting", "", "onBrightnessChangeListener", "com/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$onBrightnessChangeListener$1", "Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$onBrightnessChangeListener$1;", "onBrightnessChangeListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/upuphone/xr/sapp/vu/arspace/IOnBrightnessChangeListener;", "onCaptureScreenListeners", "Lcom/upuphone/xr/sapp/vu/arspace/IOnCaptureScreenListener;", "onDofModeChangeListeners", "Lcom/upuphone/xr/sapp/vu/arspace/IOnDofModeChangeListener;", "onGlassesKeyListener", "com/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$onGlassesKeyListener$1", "Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$onGlassesKeyListener$1;", "onGlassesWearStateChangeListeners", "Lcom/upuphone/xr/sapp/vu/arspace/IOnGlassesWearStateChangeListener;", "onInputTextListeners", "Lcom/upuphone/xr/sapp/vu/arspace/IOnInputTextListener;", "onKeyListeners", "Lcom/upuphone/xr/sapp/vu/arspace/IOnKeyListener;", "onPhoneKeyListener", "com/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$onPhoneKeyListener$1", "Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$onPhoneKeyListener$1;", "onRecordScreenListeners", "Lcom/upuphone/xr/sapp/vu/arspace/IOnRecordScreenListener;", "onRequestChangeLanguageListeners", "Lcom/upuphone/xr/sapp/vu/arspace/IOnRequestChangeLanguageListener;", "onRequestExitArSpaceListeners", "Lcom/upuphone/xr/sapp/vu/arspace/IOnRequestExitArSpaceListener;", "onRequestPermissionResultListeners", "Lcom/upuphone/xr/sapp/vu/arspace/IOnRequestPermissionResultListener;", "onWearStatusChangeListener", "com/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$onWearStatusChangeListener$1", "Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$onWearStatusChangeListener$1;", "pendingWeatherListener", "Lcom/upuphone/xr/sapp/vu/arspace/IOnDataResultListener;", "screenCaptureListener", "com/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$screenCaptureListener$1", "Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$screenCaptureListener$1;", "screenRecorderListener", "com/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$screenRecorderListener$1", "Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$screenRecorderListener$1;", "weatherMonitor", "Lcom/upuphone/xr/sapp/vu/monitor/VuWeatherMonitor;", "addOnBrightnessChangeListener", "", "listener", "addOnCaptureScreenListener", "Lcom/upuphone/xr/sapp/vu/arspace/OnCaptureScreenListener;", "addOnDofModeChangeListener", "addOnGlassesWearStateChangeListener", "addOnInputTextListener", "addOnKeyListener", "addOnRecordScreenListener", "Lcom/upuphone/xr/sapp/vu/arspace/OnRecordScreenListener;", "addOnRequestChangeLanguageListener", "addOnRequestExitArSpaceListener", "addOnRequestPermissionResultListener", "captureScreen", "changeLanguage", "language", "", "checkUrl", "url", "Lcom/upuphone/xr/sapp/vu/arspace/IOnCheckUrlResultListener;", "cleanListeners", "destroy", "endInputText", "endScreenRecord", "exitArSpace", "force", "getBrightness", "getDofMode", "getLanguage", "getMaxBrightness", "getMinBrightness", "hideInputDialog", "isGlassesWorn", "onExitArSpace", "onLocationServiceResult", "enable", "onRequestPermissionResult", "requestTag", "result", "removeOnBrightnessChangeListener", "removeOnCaptureScreenListener", "removeOnDofModeChangeListener", "removeOnGlassesWearStateChangeListener", "removeOnInputTextListener", "removeOnKeyListener", "removeOnRecordScreenListener", "removeOnRequestChangeLanguageListener", "removeOnRequestExitArSpaceListener", "removeOnRequestPermissionResultListener", "reportEvent", "eventName", "attributes", "", "", "requestData", "type", "requestPermission", "desc", "detail", "permissions", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "setBrightness", "brightness", "setDofMode", "showInputDialog", "textInfo", "startInputText", "info", "startScreenRecord", "Companion", "OnArSpaceExitListener", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nArSpaceBridgerImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArSpaceBridgerImpl.kt\ncom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,665:1\n1855#2,2:666\n*S KotlinDebug\n*F\n+ 1 ArSpaceBridgerImpl.kt\ncom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl\n*L\n262#1:666,2\n*E\n"})
public final class ArSpaceBridgerImpl extends IArSpaceBridger.Stub {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String DATA_TYPE_SPORT = "sport";
    @NotNull
    private static final String DATA_TYPE_WEATHER = "weather";
    @NotNull
    private static final String TAG = "ArSpaceBridgerImpl";
    @Nullable
    private OnArSpaceExitListener arSpaceExitListener;
    @NotNull
    private final CoroutineScope coroutineScope = CoroutineScopeKt.a(Dispatchers.c().plus(SupervisorKt.b((Job) null, 1, (Object) null)));
    /* access modifiers changed from: private */
    @Nullable
    public EditTextInfo currentEditTextInfo;
    @NotNull
    private DOFCtrlBinder dofCtrlBinder;
    private int dofMode;
    @Nullable
    private VuInputDialog inputDialog;
    private boolean isExiting;
    @NotNull
    private final ArSpaceBridgerImpl$onBrightnessChangeListener$1 onBrightnessChangeListener;
    /* access modifiers changed from: private */
    @NotNull
    public final CopyOnWriteArraySet<IOnBrightnessChangeListener> onBrightnessChangeListeners = new CopyOnWriteArraySet<>();
    /* access modifiers changed from: private */
    @NotNull
    public final CopyOnWriteArraySet<IOnCaptureScreenListener> onCaptureScreenListeners = new CopyOnWriteArraySet<>();
    @NotNull
    private final CopyOnWriteArraySet<IOnDofModeChangeListener> onDofModeChangeListeners = new CopyOnWriteArraySet<>();
    @NotNull
    private final ArSpaceBridgerImpl$onGlassesKeyListener$1 onGlassesKeyListener;
    /* access modifiers changed from: private */
    @NotNull
    public final CopyOnWriteArraySet<IOnGlassesWearStateChangeListener> onGlassesWearStateChangeListeners = new CopyOnWriteArraySet<>();
    /* access modifiers changed from: private */
    @NotNull
    public final CopyOnWriteArraySet<IOnInputTextListener> onInputTextListeners = new CopyOnWriteArraySet<>();
    /* access modifiers changed from: private */
    @NotNull
    public final CopyOnWriteArraySet<IOnKeyListener> onKeyListeners = new CopyOnWriteArraySet<>();
    @NotNull
    private final ArSpaceBridgerImpl$onPhoneKeyListener$1 onPhoneKeyListener;
    /* access modifiers changed from: private */
    @NotNull
    public final CopyOnWriteArraySet<IOnRecordScreenListener> onRecordScreenListeners = new CopyOnWriteArraySet<>();
    /* access modifiers changed from: private */
    @NotNull
    public final CopyOnWriteArraySet<IOnRequestChangeLanguageListener> onRequestChangeLanguageListeners = new CopyOnWriteArraySet<>();
    /* access modifiers changed from: private */
    @NotNull
    public final CopyOnWriteArraySet<IOnRequestExitArSpaceListener> onRequestExitArSpaceListeners = new CopyOnWriteArraySet<>();
    /* access modifiers changed from: private */
    @NotNull
    public final CopyOnWriteArraySet<IOnRequestPermissionResultListener> onRequestPermissionResultListeners = new CopyOnWriteArraySet<>();
    @NotNull
    private final ArSpaceBridgerImpl$onWearStatusChangeListener$1 onWearStatusChangeListener;
    /* access modifiers changed from: private */
    @Nullable
    public IOnDataResultListener pendingWeatherListener;
    /* access modifiers changed from: private */
    @NotNull
    public VuScreenRecordHelper recordHelper;
    @NotNull
    private final ArSpaceBridgerImpl$screenCaptureListener$1 screenCaptureListener;
    @NotNull
    private final ArSpaceBridgerImpl$screenRecorderListener$1 screenRecorderListener;
    /* access modifiers changed from: private */
    @NotNull
    public final VuWeatherMonitor weatherMonitor = new VuWeatherMonitor();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$Companion;", "", "()V", "DATA_TYPE_SPORT", "", "DATA_TYPE_WEATHER", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/vu/arspace/ArSpaceBridgerImpl$OnArSpaceExitListener;", "", "", "b", "()V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface OnArSpaceExitListener {
        void b();
    }

    public ArSpaceBridgerImpl(@NotNull Context context, @NotNull DOFCtrlBinder dOFCtrlBinder, @NotNull VuScreenRecordHelper vuScreenRecordHelper) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dOFCtrlBinder, "dofCtrlBinder");
        Intrinsics.checkNotNullParameter(vuScreenRecordHelper, "recordHelper");
        this.dofCtrlBinder = dOFCtrlBinder;
        this.recordHelper = vuScreenRecordHelper;
        ArSpaceBridgerImpl$onBrightnessChangeListener$1 arSpaceBridgerImpl$onBrightnessChangeListener$1 = new ArSpaceBridgerImpl$onBrightnessChangeListener$1(this);
        this.onBrightnessChangeListener = arSpaceBridgerImpl$onBrightnessChangeListener$1;
        ArSpaceBridgerImpl$screenCaptureListener$1 arSpaceBridgerImpl$screenCaptureListener$1 = new ArSpaceBridgerImpl$screenCaptureListener$1(this);
        this.screenCaptureListener = arSpaceBridgerImpl$screenCaptureListener$1;
        ArSpaceBridgerImpl$screenRecorderListener$1 arSpaceBridgerImpl$screenRecorderListener$1 = new ArSpaceBridgerImpl$screenRecorderListener$1(this);
        this.screenRecorderListener = arSpaceBridgerImpl$screenRecorderListener$1;
        ArSpaceBridgerImpl$onGlassesKeyListener$1 arSpaceBridgerImpl$onGlassesKeyListener$1 = new ArSpaceBridgerImpl$onGlassesKeyListener$1(this);
        this.onGlassesKeyListener = arSpaceBridgerImpl$onGlassesKeyListener$1;
        ArSpaceBridgerImpl$onPhoneKeyListener$1 arSpaceBridgerImpl$onPhoneKeyListener$1 = new ArSpaceBridgerImpl$onPhoneKeyListener$1(this);
        this.onPhoneKeyListener = arSpaceBridgerImpl$onPhoneKeyListener$1;
        ArSpaceBridgerImpl$onWearStatusChangeListener$1 arSpaceBridgerImpl$onWearStatusChangeListener$1 = new ArSpaceBridgerImpl$onWearStatusChangeListener$1(this);
        this.onWearStatusChangeListener = arSpaceBridgerImpl$onWearStatusChangeListener$1;
        VuGlassesEventDispatcher vuGlassesEventDispatcher = VuGlassesEventDispatcher.f8098a;
        vuGlassesEventDispatcher.d(arSpaceBridgerImpl$onBrightnessChangeListener$1);
        vuGlassesEventDispatcher.e(arSpaceBridgerImpl$onGlassesKeyListener$1);
        vuGlassesEventDispatcher.f(arSpaceBridgerImpl$onPhoneKeyListener$1);
        vuGlassesEventDispatcher.h(arSpaceBridgerImpl$onWearStatusChangeListener$1);
        this.recordHelper.s(arSpaceBridgerImpl$screenCaptureListener$1);
        this.recordHelper.t(arSpaceBridgerImpl$screenRecorderListener$1);
    }

    private final void cleanListeners() {
        this.onBrightnessChangeListeners.clear();
        this.onDofModeChangeListeners.clear();
        this.onRecordScreenListeners.clear();
        this.onCaptureScreenListeners.clear();
        this.onInputTextListeners.clear();
        this.onKeyListeners.clear();
        this.onRequestChangeLanguageListeners.clear();
        this.onGlassesWearStateChangeListeners.clear();
        this.onRequestPermissionResultListeners.clear();
        this.onRequestExitArSpaceListeners.clear();
    }

    /* access modifiers changed from: private */
    public final void hideInputDialog() {
        Unit unit;
        try {
            Result.Companion companion = Result.Companion;
            VuInputDialog vuInputDialog = this.inputDialog;
            if (vuInputDialog != null) {
                vuInputDialog.dismiss();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Result.m20constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* access modifiers changed from: private */
    public final void showInputDialog(EditTextInfo editTextInfo) {
        Unit unit;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TAG, "showInputDialog: " + editTextInfo);
        VuTouchpadActivity.Companion companion = VuTouchpadActivity.w;
        if (companion.b() == null) {
            delegate.a(TAG, "VuMainActivity.instance is null");
            return;
        }
        if (this.inputDialog == null) {
            VuTouchpadActivity b = companion.b();
            Intrinsics.checkNotNull(b);
            VuInputDialog vuInputDialog = new VuInputDialog(b);
            vuInputDialog.i(new ArSpaceBridgerImpl$showInputDialog$1(this));
            vuInputDialog.h(new ArSpaceBridgerImpl$showInputDialog$2(this));
            this.inputDialog = vuInputDialog;
        }
        try {
            Result.Companion companion2 = Result.Companion;
            VuInputDialog vuInputDialog2 = this.inputDialog;
            if (vuInputDialog2 != null) {
                vuInputDialog2.j(editTextInfo);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Result.m20constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion3 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th));
        }
    }

    public void addOnBrightnessChangeListener(@NotNull IOnBrightnessChangeListener iOnBrightnessChangeListener) {
        Intrinsics.checkNotNullParameter(iOnBrightnessChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onBrightnessChangeListeners.add(iOnBrightnessChangeListener);
    }

    public void addOnCaptureScreenListener(@NotNull IOnCaptureScreenListener iOnCaptureScreenListener) {
        Intrinsics.checkNotNullParameter(iOnCaptureScreenListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TAG, "addOnCaptureScreenListener: " + iOnCaptureScreenListener);
        this.onCaptureScreenListeners.add(iOnCaptureScreenListener);
    }

    public void addOnDofModeChangeListener(@NotNull IOnDofModeChangeListener iOnDofModeChangeListener) {
        Intrinsics.checkNotNullParameter(iOnDofModeChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TAG, "addOnDofModeChangeListener: " + iOnDofModeChangeListener);
        this.onDofModeChangeListeners.add(iOnDofModeChangeListener);
    }

    public void addOnGlassesWearStateChangeListener(@NotNull IOnGlassesWearStateChangeListener iOnGlassesWearStateChangeListener) {
        Intrinsics.checkNotNullParameter(iOnGlassesWearStateChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onGlassesWearStateChangeListeners.add(iOnGlassesWearStateChangeListener);
    }

    public void addOnInputTextListener(@NotNull IOnInputTextListener iOnInputTextListener) {
        Intrinsics.checkNotNullParameter(iOnInputTextListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TAG, "addOnInputTextChangeListener: " + iOnInputTextListener);
        this.onInputTextListeners.add(iOnInputTextListener);
    }

    public void addOnKeyListener(@NotNull IOnKeyListener iOnKeyListener) {
        Intrinsics.checkNotNullParameter(iOnKeyListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TAG, "addOnRequestExitArSpaceListener: " + iOnKeyListener);
        this.onKeyListeners.add(iOnKeyListener);
    }

    public void addOnRecordScreenListener(@NotNull IOnRecordScreenListener iOnRecordScreenListener) {
        Intrinsics.checkNotNullParameter(iOnRecordScreenListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TAG, "addOnRecordScreenListener: " + iOnRecordScreenListener);
        this.onRecordScreenListeners.add(iOnRecordScreenListener);
    }

    public void addOnRequestChangeLanguageListener(@NotNull IOnRequestChangeLanguageListener iOnRequestChangeLanguageListener) {
        Intrinsics.checkNotNullParameter(iOnRequestChangeLanguageListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onRequestChangeLanguageListeners.add(iOnRequestChangeLanguageListener);
    }

    public void addOnRequestExitArSpaceListener(@NotNull IOnRequestExitArSpaceListener iOnRequestExitArSpaceListener) {
        Intrinsics.checkNotNullParameter(iOnRequestExitArSpaceListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TAG, "addOnRequestExitArSpaceListener: " + iOnRequestExitArSpaceListener);
        this.onRequestExitArSpaceListeners.add(iOnRequestExitArSpaceListener);
    }

    public void addOnRequestPermissionResultListener(@NotNull IOnRequestPermissionResultListener iOnRequestPermissionResultListener) {
        Intrinsics.checkNotNullParameter(iOnRequestPermissionResultListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onRequestPermissionResultListeners.add(iOnRequestPermissionResultListener);
    }

    public void captureScreen() {
        ULog.f6446a.a(TAG, "takeScreenshot");
        VuScreenRecordHelper vuScreenRecordHelper = this.recordHelper;
        if (vuScreenRecordHelper != null) {
            vuScreenRecordHelper.R();
        }
    }

    public final void changeLanguage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "language");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TAG, "changeLanguage: " + str);
        Job unused = BuildersKt__Builders_commonKt.d(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ArSpaceBridgerImpl$changeLanguage$1(this, str, (Continuation<? super ArSpaceBridgerImpl$changeLanguage$1>) null), 3, (Object) null);
    }

    public void checkUrl(@Nullable String str, @Nullable IOnCheckUrlResultListener iOnCheckUrlResultListener) {
        if (iOnCheckUrlResultListener != null) {
            if (str != null) {
                try {
                    if (!StringsKt.isBlank(str)) {
                        Job unused = BuildersKt__Builders_commonKt.d(this.coroutineScope, Dispatchers.b(), (CoroutineStart) null, new ArSpaceBridgerImpl$checkUrl$1(str, iOnCheckUrlResultListener, (Continuation<? super ArSpaceBridgerImpl$checkUrl$1>) null), 2, (Object) null);
                        return;
                    }
                } catch (Exception e) {
                    ULog.Delegate delegate = ULog.f6446a;
                    delegate.c(TAG, "checkUrl: " + e);
                    return;
                }
            }
            iOnCheckUrlResultListener.onResult(-1);
        }
    }

    public final void destroy() {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TAG, "destroy");
        this.weatherMonitor.c();
        VuGlassesEventDispatcher vuGlassesEventDispatcher = VuGlassesEventDispatcher.f8098a;
        vuGlassesEventDispatcher.n(this.onBrightnessChangeListener);
        vuGlassesEventDispatcher.o(this.onGlassesKeyListener);
        vuGlassesEventDispatcher.p(this.onPhoneKeyListener);
        vuGlassesEventDispatcher.r(this.onWearStatusChangeListener);
        this.recordHelper.M(this.screenCaptureListener);
        this.recordHelper.N(this.screenRecorderListener);
        cleanListeners();
        delegate.a(TAG, "destroy end");
    }

    public void endInputText() {
        ULog.f6446a.a(TAG, "endInputText");
        this.currentEditTextInfo = null;
        Job unused = BuildersKt__Builders_commonKt.d(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ArSpaceBridgerImpl$endInputText$1(this, (Continuation<? super ArSpaceBridgerImpl$endInputText$1>) null), 3, (Object) null);
    }

    public void endScreenRecord() {
        ULog.f6446a.a(TAG, "endScreenRecord");
        Job unused = BuildersKt__Builders_commonKt.d(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ArSpaceBridgerImpl$endScreenRecord$1(this, (Continuation<? super ArSpaceBridgerImpl$endScreenRecord$1>) null), 3, (Object) null);
    }

    public final void exitArSpace(boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TAG, "exitArSpace: " + z);
        if (z || this.onRequestExitArSpaceListeners.isEmpty()) {
            onExitArSpace();
        }
        Job unused = BuildersKt__Builders_commonKt.d(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ArSpaceBridgerImpl$exitArSpace$1(this, z, (Continuation<? super ArSpaceBridgerImpl$exitArSpace$1>) null), 3, (Object) null);
    }

    @Nullable
    public final OnArSpaceExitListener getArSpaceExitListener() {
        return this.arSpaceExitListener;
    }

    public int getBrightness() {
        return RangesKt.coerceIn(VuGlassesHidUtil.f8104a.a(), getMinBrightness(), getMaxBrightness());
    }

    public int getDofMode() {
        ULog.f6446a.a(TAG, "getDofMode");
        return this.dofMode;
    }

    @NotNull
    public String getLanguage() {
        return Intrinsics.areEqual((Object) Locale.getDefault().getLanguage(), (Object) "zh") ? "zh-CN" : "en-US";
    }

    public int getMaxBrightness() {
        return 10;
    }

    public int getMinBrightness() {
        return 1;
    }

    public final boolean isExiting() {
        return this.isExiting;
    }

    public boolean isGlassesWorn() {
        return VuGlassesHidUtil.f8104a.p();
    }

    public void onExitArSpace() {
        ULog.f6446a.a(TAG, "onExitArSpace");
        if (!this.isExiting) {
            this.isExiting = true;
            OnArSpaceExitListener onArSpaceExitListener = this.arSpaceExitListener;
            if (onArSpaceExitListener != null) {
                onArSpaceExitListener.b();
            }
        }
    }

    public final void onLocationServiceResult(boolean z) {
        if (this.pendingWeatherListener != null) {
            Job unused = BuildersKt__Builders_commonKt.d(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ArSpaceBridgerImpl$onLocationServiceResult$1(this, (Continuation<? super ArSpaceBridgerImpl$onLocationServiceResult$1>) null), 3, (Object) null);
        }
    }

    public final void onRequestPermissionResult(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "requestTag");
        Job unused = BuildersKt__Builders_commonKt.d(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ArSpaceBridgerImpl$onRequestPermissionResult$1(this, str, z, (Continuation<? super ArSpaceBridgerImpl$onRequestPermissionResult$1>) null), 3, (Object) null);
    }

    public void removeOnBrightnessChangeListener(@NotNull IOnBrightnessChangeListener iOnBrightnessChangeListener) {
        Intrinsics.checkNotNullParameter(iOnBrightnessChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onBrightnessChangeListeners.remove(iOnBrightnessChangeListener);
    }

    public void removeOnCaptureScreenListener(@NotNull IOnCaptureScreenListener iOnCaptureScreenListener) {
        Intrinsics.checkNotNullParameter(iOnCaptureScreenListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TAG, "removeOnCaptureScreenListener: " + iOnCaptureScreenListener);
        this.onCaptureScreenListeners.remove(iOnCaptureScreenListener);
    }

    public void removeOnDofModeChangeListener(@NotNull IOnDofModeChangeListener iOnDofModeChangeListener) {
        Intrinsics.checkNotNullParameter(iOnDofModeChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TAG, "removeOnDofModeChangeListener: " + iOnDofModeChangeListener);
        this.onDofModeChangeListeners.remove(iOnDofModeChangeListener);
    }

    public void removeOnGlassesWearStateChangeListener(@NotNull IOnGlassesWearStateChangeListener iOnGlassesWearStateChangeListener) {
        Intrinsics.checkNotNullParameter(iOnGlassesWearStateChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onGlassesWearStateChangeListeners.remove(iOnGlassesWearStateChangeListener);
    }

    public void removeOnInputTextListener(@NotNull IOnInputTextListener iOnInputTextListener) {
        Intrinsics.checkNotNullParameter(iOnInputTextListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TAG, "removeOnInputTextChangeListener: " + iOnInputTextListener);
        this.onInputTextListeners.remove(iOnInputTextListener);
    }

    public void removeOnKeyListener(@NotNull IOnKeyListener iOnKeyListener) {
        Intrinsics.checkNotNullParameter(iOnKeyListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TAG, "removeOnRequestExitArSpaceListener: " + iOnKeyListener);
        this.onKeyListeners.remove(iOnKeyListener);
    }

    public void removeOnRecordScreenListener(@NotNull IOnRecordScreenListener iOnRecordScreenListener) {
        Intrinsics.checkNotNullParameter(iOnRecordScreenListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TAG, "removeOnRecordScreenListener: " + iOnRecordScreenListener);
        this.onRecordScreenListeners.remove(iOnRecordScreenListener);
    }

    public void removeOnRequestChangeLanguageListener(@NotNull IOnRequestChangeLanguageListener iOnRequestChangeLanguageListener) {
        Intrinsics.checkNotNullParameter(iOnRequestChangeLanguageListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TAG, "removeOnRequestExitArSpaceListener: " + iOnRequestChangeLanguageListener);
        this.onRequestChangeLanguageListeners.remove(iOnRequestChangeLanguageListener);
    }

    public void removeOnRequestExitArSpaceListener(@NotNull IOnRequestExitArSpaceListener iOnRequestExitArSpaceListener) {
        Intrinsics.checkNotNullParameter(iOnRequestExitArSpaceListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TAG, "removeOnRequestExitArSpaceListener: " + iOnRequestExitArSpaceListener);
        this.onRequestExitArSpaceListeners.remove(iOnRequestExitArSpaceListener);
    }

    public void removeOnRequestPermissionResultListener(@NotNull IOnRequestPermissionResultListener iOnRequestPermissionResultListener) {
        Intrinsics.checkNotNullParameter(iOnRequestPermissionResultListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onRequestPermissionResultListeners.remove(iOnRequestPermissionResultListener);
    }

    public void reportEvent(@NotNull String str, @NotNull Map<Object, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, "attributes");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TAG, "report event: " + str);
        DeviceInfo d = VuGlassesDeviceInfoModel.f8112a.d();
        DataTrackUtil dataTrackUtil = DataTrackUtil.f7875a;
        String serialNo = d.getSerialNo();
        if (serialNo == null) {
            serialNo = "";
        }
        DataTrackUtil.m(dataTrackUtil, str, map, dataTrackUtil.f(serialNo), d.getModel(), d.getRomVersion(), false, 32, (Object) null);
    }

    public void requestData(@NotNull String str, @NotNull IOnDataResultListener iOnDataResultListener) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(iOnDataResultListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TAG, "requestData: " + str + ", " + iOnDataResultListener);
        if (Intrinsics.areEqual((Object) str, (Object) "weather")) {
            this.pendingWeatherListener = iOnDataResultListener;
            if (!this.weatherMonitor.g()) {
                Job unused = BuildersKt__Builders_commonKt.d(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ArSpaceBridgerImpl$requestData$1(this, (Continuation<? super ArSpaceBridgerImpl$requestData$1>) null), 3, (Object) null);
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) DATA_TYPE_SPORT)) {
            try {
                iOnDataResultListener.onResult(DATA_TYPE_SPORT, 0, new VuSportInfo(1000, 100.0d, 1.0d).toJson());
            } catch (Exception e) {
                ULog.Delegate delegate2 = ULog.f6446a;
                delegate2.c(TAG, "requestData: " + e);
            }
        } else {
            try {
                iOnDataResultListener.onResult(str, -1, "");
            } catch (Exception e2) {
                ULog.Delegate delegate3 = ULog.f6446a;
                delegate3.c(TAG, "requestData: " + e2);
            }
        }
    }

    public void requestPermission(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(str, "requestTag");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Job unused = BuildersKt__Builders_commonKt.d(this.coroutineScope, Dispatchers.c(), (CoroutineStart) null, new ArSpaceBridgerImpl$requestPermission$1(str, str2, str3, strArr, (Continuation<? super ArSpaceBridgerImpl$requestPermission$1>) null), 2, (Object) null);
    }

    public final void setArSpaceExitListener(@Nullable OnArSpaceExitListener onArSpaceExitListener) {
        this.arSpaceExitListener = onArSpaceExitListener;
    }

    public void setBrightness(int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TAG, "setBrightness: " + i);
        VuGlassesHidUtil.f8104a.y(i);
        VuGlassesEventDispatcher.f8098a.i(i);
    }

    public void setDofMode(int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TAG, "setDofMode: " + i);
        this.dofMode = i;
        try {
            Result.Companion companion = Result.Companion;
            DOFCtrlBinder dOFCtrlBinder = this.dofCtrlBinder;
            if (dOFCtrlBinder != null) {
                dOFCtrlBinder.setDofType(i == 1 ? "hover" : "follow_head");
            }
            for (IOnDofModeChangeListener onDofModeChanged : this.onDofModeChangeListeners) {
                onDofModeChanged.onDofModeChanged(i);
            }
            Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th));
        }
    }

    public void startInputText(@NotNull EditTextInfo editTextInfo) {
        Intrinsics.checkNotNullParameter(editTextInfo, "info");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(TAG, "startInputText: " + editTextInfo);
        this.currentEditTextInfo = editTextInfo;
        Job unused = BuildersKt__Builders_commonKt.d(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ArSpaceBridgerImpl$startInputText$1(this, editTextInfo, (Continuation<? super ArSpaceBridgerImpl$startInputText$1>) null), 3, (Object) null);
    }

    public void startScreenRecord() {
        ULog.f6446a.a(TAG, "startScreenRecord");
        Job unused = BuildersKt__Builders_commonKt.d(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ArSpaceBridgerImpl$startScreenRecord$1(this, (Continuation<? super ArSpaceBridgerImpl$startScreenRecord$1>) null), 3, (Object) null);
    }

    public final void addOnCaptureScreenListener(@Nullable OnCaptureScreenListener onCaptureScreenListener) {
        VuScreenRecordHelper vuScreenRecordHelper;
        if (onCaptureScreenListener != null && (vuScreenRecordHelper = this.recordHelper) != null) {
            vuScreenRecordHelper.s(onCaptureScreenListener);
        }
    }

    public final void addOnRecordScreenListener(@Nullable OnRecordScreenListener onRecordScreenListener) {
        VuScreenRecordHelper vuScreenRecordHelper;
        if (onRecordScreenListener != null && (vuScreenRecordHelper = this.recordHelper) != null) {
            vuScreenRecordHelper.t(onRecordScreenListener);
        }
    }

    public final void removeOnCaptureScreenListener(@Nullable OnCaptureScreenListener onCaptureScreenListener) {
        VuScreenRecordHelper vuScreenRecordHelper;
        if (onCaptureScreenListener != null && (vuScreenRecordHelper = this.recordHelper) != null) {
            vuScreenRecordHelper.M(onCaptureScreenListener);
        }
    }

    public final void removeOnRecordScreenListener(@Nullable OnRecordScreenListener onRecordScreenListener) {
        VuScreenRecordHelper vuScreenRecordHelper;
        if (onRecordScreenListener != null && (vuScreenRecordHelper = this.recordHelper) != null) {
            vuScreenRecordHelper.N(onRecordScreenListener);
        }
    }
}
