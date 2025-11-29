package com.upuphone.xr.sapp.vu;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.PathInterpolator;
import androidx.activity.result.ActivityResultLauncher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.honey.account.b9.a0;
import com.honey.account.b9.b0;
import com.honey.account.b9.c0;
import com.honey.account.b9.d0;
import com.honey.account.b9.e0;
import com.honey.account.b9.f0;
import com.honey.account.b9.g0;
import com.honey.account.b9.h0;
import com.honey.account.b9.v;
import com.honey.account.b9.w;
import com.honey.account.b9.x;
import com.honey.account.b9.y;
import com.honey.account.b9.z;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.BaseActivity;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentVuTouchpadBinding;
import com.upuphone.xr.sapp.entity.DeviceInfo;
import com.upuphone.xr.sapp.entity.PermissionNote;
import com.upuphone.xr.sapp.permission.PermissionHelper;
import com.upuphone.xr.sapp.utils.ContextExtKt;
import com.upuphone.xr.sapp.utils.DataTrackUtil;
import com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils;
import com.upuphone.xr.sapp.utils.PhoneTypeUtils;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.view.SuperGenericWindowView;
import com.upuphone.xr.sapp.vu.ArSpaceService;
import com.upuphone.xr.sapp.vu.arspace.IOnDofModeChangeListener;
import com.upuphone.xr.sapp.vu.arspace.OnCaptureScreenListener;
import com.upuphone.xr.sapp.vu.arspace.OnRecordScreenListener;
import com.upuphone.xr.sapp.vu.input.RuntimeStatusOuterClass;
import com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper;
import com.upuphone.xr.sapp.vu.utils.GlassDataStoreHelper;
import com.upuphone.xr.sapp.vu.utils.VuGlassesEventDispatcher;
import com.upuphone.xr.sapp.vu.vm.VuGlassControlModel;
import com.upuphone.xr.sapp.vu.vm.VuGlassesDeviceInfoModel;
import java.util.HashMap;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0006\u0001\u0001¡\u0001\u0018\u0000 ±\u00012\u00020\u00012\u00020\u0002:\u0002²\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0010\u0010\tJ\u000f\u0010\u0011\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0014\u0010\u0004J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u0004J\r\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u0004J\u001f\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J!\u0010#\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J!\u0010(\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b(\u0010)J!\u0010*\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b*\u0010)J\u0019\u0010-\u001a\u00020\u00152\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b-\u0010.J%\u00101\u001a\u00020\u00072\u0016\u00100\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010/¢\u0006\u0004\b1\u00102J7\u00109\u001a\u00020\u00072\u0006\u00104\u001a\u0002032\b\u00105\u001a\u0004\u0018\u0001032\b\u00106\u001a\u0004\u0018\u0001032\f\u00108\u001a\b\u0012\u0004\u0012\u00020307¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u00020\u0007¢\u0006\u0004\b;\u0010\u0004J\u000f\u0010<\u001a\u00020\u0007H\u0002¢\u0006\u0004\b<\u0010\u0004J\u001f\u0010?\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020\u0015H\u0002¢\u0006\u0004\b?\u0010@J \u0010A\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020\u0015H@¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0007H\u0002¢\u0006\u0004\bC\u0010\u0004J\u000f\u0010D\u001a\u00020\u0007H\u0002¢\u0006\u0004\bD\u0010\u0004J\u001f\u0010E\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\u0007H\u0003¢\u0006\u0004\bG\u0010\u0004J\u0019\u0010I\u001a\u00020\u00072\b\u0010H\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\bI\u0010JJ\u0019\u0010L\u001a\u00020\u00072\b\b\u0002\u0010K\u001a\u00020\u0015H\u0002¢\u0006\u0004\bL\u0010\u0018J\u000f\u0010M\u001a\u00020\u0007H\u0002¢\u0006\u0004\bM\u0010\u0004J\u000f\u0010N\u001a\u00020\u0007H\u0002¢\u0006\u0004\bN\u0010\u0004J\u000f\u0010O\u001a\u00020\u0007H\u0002¢\u0006\u0004\bO\u0010\u0004J\u0017\u0010Q\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u0015H\u0002¢\u0006\u0004\bQ\u0010\u0018J\u000f\u0010R\u001a\u00020\u0007H\u0002¢\u0006\u0004\bR\u0010\u0004J\u000f\u0010S\u001a\u00020\u0007H\u0002¢\u0006\u0004\bS\u0010\u0004J\u000f\u0010T\u001a\u00020\u0007H\u0002¢\u0006\u0004\bT\u0010\u0004J\u000f\u0010U\u001a\u00020\u0007H\u0002¢\u0006\u0004\bU\u0010\u0004J\u000f\u0010V\u001a\u00020\u0007H\u0002¢\u0006\u0004\bV\u0010\u0004J\u000f\u0010W\u001a\u00020\u0015H\u0002¢\u0006\u0004\bW\u0010XJ\u000f\u0010Y\u001a\u00020\u0007H\u0002¢\u0006\u0004\bY\u0010\u0004J\u000f\u0010Z\u001a\u00020\u0007H\u0002¢\u0006\u0004\bZ\u0010\u0004J\u000f\u0010[\u001a\u00020\u0007H\u0002¢\u0006\u0004\b[\u0010\u0004J\u000f\u0010\\\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\\\u0010\u0004J\u000f\u0010]\u001a\u00020\u0007H\u0002¢\u0006\u0004\b]\u0010\u0004J\u000f\u0010^\u001a\u00020\u0015H\u0002¢\u0006\u0004\b^\u0010XJ\u000f\u0010_\u001a\u00020\u0015H\u0002¢\u0006\u0004\b_\u0010XJ\u000f\u0010`\u001a\u00020\u0007H\u0002¢\u0006\u0004\b`\u0010\u0004J\u0017\u0010a\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\ba\u0010\u0018J\u0017\u0010b\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u001cH\u0002¢\u0006\u0004\bb\u0010cJ\u000f\u0010d\u001a\u00020\u0007H\u0002¢\u0006\u0004\bd\u0010\u0004J\u000f\u0010e\u001a\u00020\u0007H\u0002¢\u0006\u0004\be\u0010\u0004J\u000f\u0010f\u001a\u00020\u0007H\u0002¢\u0006\u0004\bf\u0010\u0004R\u0018\u0010j\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010m\u001a\u00020k8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b#\u0010lR\u0016\u0010p\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u001c\u0010u\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010r0q8\u0002X\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010y\u001a\u00020v8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010}\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0016\u0010\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b~\u0010oR\u0018\u0010\u0001\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010oR\u0018\u0010\u0001\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010oRJ\u0010\u0001\u001a,\u0012\u0004\u0012\u000203\u0012\n\u0012\b\u0012\u0004\u0012\u000203070\u0001j\u0015\u0012\u0004\u0012\u000203\u0012\n\u0012\b\u0012\u0004\u0012\u00020307`\u00018BX\u0002¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010oR\u0018\u0010\u0001\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010oR\u0018\u0010\u0001\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010oR\u0018\u0010\u0001\u001a\u00030\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00030\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010 \u0001\u001a\u00030\u00018\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010¤\u0001\u001a\u00030¡\u00018\u0002X\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R$\u0010¨\u0001\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010¥\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R)\u0010«\u0001\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R\u001d\u0010°\u0001\u001a\b0¬\u0001j\u0003`­\u00018\u0002X\u0004¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001¨\u0006³\u0001"}, d2 = {"Lcom/upuphone/xr/sapp/vu/VuTouchpadActivity;", "Lcom/upuphone/xr/sapp/BaseActivity;", "Lcom/upuphone/xr/sapp/view/SuperGenericWindowView$IActionCallback;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "recreate", "outState", "onSaveInstanceState", "onStart", "onResume", "onPause", "onStop", "", "hasFocus", "onWindowFocusChanged", "(Z)V", "onDestroy", "onBackPressed", "q1", "", "windowType", "actionType", "a", "(II)V", "", "data", "c", "(ILjava/lang/Object;)V", "keyCode", "Landroid/view/KeyEvent;", "event", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "onKeyUp", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "Lkotlin/Function1;", "resultCallback", "A1", "(Lkotlin/jvm/functions/Function1;)V", "", "requestTag", "desc", "detail", "", "permissions", "y1", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "D1", "a1", "displayId", "showTip", "t1", "(IZ)V", "u1", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "r1", "b1", "K1", "(ILandroid/content/Intent;)V", "initView", "dofMode", "R1", "(Ljava/lang/Integer;)V", "animated", "G1", "g1", "p1", "Q1", "force", "z1", "C1", "M1", "N1", "O1", "P1", "Y0", "()Z", "B1", "v1", "L1", "U0", "d1", "W0", "Z0", "E1", "X0", "x1", "(I)V", "c1", "s1", "V0", "Landroid/animation/Animator;", "b", "Landroid/animation/Animator;", "moreAnimation", "Lcom/upuphone/xr/sapp/databinding/FragmentVuTouchpadBinding;", "Lcom/upuphone/xr/sapp/databinding/FragmentVuTouchpadBinding;", "binding", "d", "Z", "isRecording", "Landroidx/lifecycle/Observer;", "Lcom/upuphone/xr/sapp/vu/vm/VuGlassControlModel$ViewGlassesInfo;", "e", "Landroidx/lifecycle/Observer;", "glassesConnectObserver", "", "f", "J", "lastSwitchFloatModeTime", "Lcom/upuphone/xr/sapp/vu/VuExitArSpaceDialog;", "g", "Lcom/upuphone/xr/sapp/vu/VuExitArSpaceDialog;", "exitDialog", "h", "hasFocused", "i", "isConnectScreenShowed", "j", "requestingConnectScreen", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "k", "Lkotlin/Lazy;", "e1", "()Ljava/util/HashMap;", "arSpacePermission", "Lkotlinx/coroutines/Job;", "l", "Lkotlinx/coroutines/Job;", "homeLongClickCheckTask", "m", "finishByExit", "n", "manualExit", "o", "isEnablingLocalService", "Landroid/os/Handler;", "p", "Landroid/os/Handler;", "brightnessHandler", "com/upuphone/xr/sapp/vu/VuTouchpadActivity$dofModeChangeListener$1", "q", "Lcom/upuphone/xr/sapp/vu/VuTouchpadActivity$dofModeChangeListener$1;", "dofModeChangeListener", "com/upuphone/xr/sapp/vu/VuTouchpadActivity$screenCaptureListener$1", "r", "Lcom/upuphone/xr/sapp/vu/VuTouchpadActivity$screenCaptureListener$1;", "screenCaptureListener", "com/upuphone/xr/sapp/vu/VuTouchpadActivity$screenRecordListener$1", "s", "Lcom/upuphone/xr/sapp/vu/VuTouchpadActivity$screenRecordListener$1;", "screenRecordListener", "Landroidx/activity/result/ActivityResultLauncher;", "t", "Landroidx/activity/result/ActivityResultLauncher;", "requestRecordLauncher", "u", "Lkotlin/jvm/functions/Function1;", "requestRecordResultListener", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "v", "Ljava/lang/Runnable;", "dimScreenRunnable", "w", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nVuTouchpadActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VuTouchpadActivity.kt\ncom/upuphone/xr/sapp/vu/VuTouchpadActivity\n+ 2 Runnable.kt\nkotlinx/coroutines/RunnableKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,838:1\n17#2:839\n256#3,2:840\n81#3:842\n254#3:843\n254#3:844\n254#3:845\n*S KotlinDebug\n*F\n+ 1 VuTouchpadActivity.kt\ncom/upuphone/xr/sapp/vu/VuTouchpadActivity\n*L\n816#1:839\n301#1:840,2\n305#1:842\n785#1:843\n787#1:844\n362#1:845\n*E\n"})
public final class VuTouchpadActivity extends BaseActivity implements SuperGenericWindowView.IActionCallback {
    public static final Companion w = new Companion((DefaultConstructorMarker) null);
    public static VuTouchpadActivity x;
    public static long y;
    public Animator b;
    public FragmentVuTouchpadBinding c;
    public boolean d;
    public final Observer e = new x(this);
    public long f;
    public VuExitArSpaceDialog g;
    public boolean h;
    public boolean i;
    public boolean j;
    public final Lazy k = LazyKt.lazy(VuTouchpadActivity$arSpacePermission$2.INSTANCE);
    public Job l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final Handler p = new Handler(Looper.getMainLooper());
    public final VuTouchpadActivity$dofModeChangeListener$1 q = new VuTouchpadActivity$dofModeChangeListener$1(this);
    public final VuTouchpadActivity$screenCaptureListener$1 r = new VuTouchpadActivity$screenCaptureListener$1();
    public final VuTouchpadActivity$screenRecordListener$1 s = new VuTouchpadActivity$screenRecordListener$1(this);
    public ActivityResultLauncher t;
    public Function1 u;
    public final Runnable v = new VuTouchpadActivity$special$$inlined$Runnable$1(this);

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002XT¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u001e8\u0002XT¢\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010\"\u001a\u00020\u001e8\u0002XT¢\u0006\u0006\n\u0004\b\"\u0010 R\u0014\u0010#\u001a\u00020\u001e8\u0002XT¢\u0006\u0006\n\u0004\b#\u0010 R\u0014\u0010$\u001a\u00020\u001e8\u0002XT¢\u0006\u0006\n\u0004\b$\u0010 R\u0014\u0010%\u001a\u00020\u001e8\u0002XT¢\u0006\u0006\n\u0004\b%\u0010 R\u0014\u0010&\u001a\u00020\u001e8\u0002XT¢\u0006\u0006\n\u0004\b&\u0010 R\u0014\u0010'\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010*\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010+\u001a\u00020\u001e8\u0002XT¢\u0006\u0006\n\u0004\b+\u0010 ¨\u0006,"}, d2 = {"Lcom/upuphone/xr/sapp/vu/VuTouchpadActivity$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "e", "(Landroid/content/Context;)V", "", "displayId", "", "autoOpen", "d", "(Landroid/content/Context;IZ)V", "a", "Lcom/upuphone/xr/sapp/vu/VuTouchpadActivity;", "instance", "Lcom/upuphone/xr/sapp/vu/VuTouchpadActivity;", "b", "()Lcom/upuphone/xr/sapp/vu/VuTouchpadActivity;", "setInstance", "(Lcom/upuphone/xr/sapp/vu/VuTouchpadActivity;)V", "", "manualExitArSpaceTime", "J", "c", "()J", "setManualExitArSpaceTime", "(J)V", "", "AR_SPACE_PERMISSION_TAG_GALLERY", "Ljava/lang/String;", "AR_SPACE_PERMISSION_TAG_LOCATION", "KEY_AUTO_OPEN", "KEY_DISPLAY_ID", "KEY_STATE", "SCREEN_RECORD_PERMISSION_TAG", "SCREEN_SHOT_PERMISSION_TAG", "STATE_FINISH", "I", "STATE_READY", "STATE_WAIT", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, VuTouchpadActivity.class);
            intent.putExtra("key_state", 2);
            context.startActivity(intent);
        }

        public final VuTouchpadActivity b() {
            return VuTouchpadActivity.x;
        }

        public final long c() {
            return VuTouchpadActivity.y;
        }

        public final void d(Context context, int i, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, VuTouchpadActivity.class);
            intent.putExtra("key_state", 1);
            intent.putExtra("key_display_id", i);
            intent.putExtra("key_auto_open", z);
            context.startActivity(intent);
        }

        public final void e(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, VuTouchpadActivity.class);
            intent.putExtra("key_state", 0);
            context.startActivity(intent);
        }

        public Companion() {
        }
    }

    public static final void F1(VuTouchpadActivity vuTouchpadActivity, View view) {
        Intrinsics.checkNotNullParameter(vuTouchpadActivity, "this$0");
        vuTouchpadActivity.n = true;
        vuTouchpadActivity.z1(false);
    }

    public static /* synthetic */ void H1(VuTouchpadActivity vuTouchpadActivity, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        vuTouchpadActivity.G1(z);
    }

    public static final void I1(VuTouchpadActivity vuTouchpadActivity, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(vuTouchpadActivity, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding = vuTouchpadActivity.c;
        if (fragmentVuTouchpadBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuTouchpadBinding = null;
        }
        fragmentVuTouchpadBinding.h.setAlpha(floatValue);
    }

    public static final void J1(VuTouchpadActivity vuTouchpadActivity, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(vuTouchpadActivity, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding = vuTouchpadActivity.c;
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding2 = null;
        if (fragmentVuTouchpadBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuTouchpadBinding = null;
        }
        int height = fragmentVuTouchpadBinding.h.getHeight();
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding3 = vuTouchpadActivity.c;
        if (fragmentVuTouchpadBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuTouchpadBinding3 = null;
        }
        float f2 = ((float) height) * floatValue;
        fragmentVuTouchpadBinding3.h.setTranslationY(f2);
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding4 = vuTouchpadActivity.c;
        if (fragmentVuTouchpadBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuTouchpadBinding4 = null;
        }
        ViewGroup.LayoutParams layoutParams = fragmentVuTouchpadBinding4.p.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = (int) f2;
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding5 = vuTouchpadActivity.c;
        if (fragmentVuTouchpadBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentVuTouchpadBinding2 = fragmentVuTouchpadBinding5;
        }
        fragmentVuTouchpadBinding2.p.setLayoutParams(marginLayoutParams);
    }

    public static final void f1(VuTouchpadActivity vuTouchpadActivity, VuGlassControlModel.ViewGlassesInfo viewGlassesInfo) {
        Intrinsics.checkNotNullParameter(vuTouchpadActivity, "this$0");
        if (viewGlassesInfo == null || !viewGlassesInfo.e() || !viewGlassesInfo.d()) {
            vuTouchpadActivity.z1(true);
        }
    }

    public static final void h1(VuTouchpadActivity vuTouchpadActivity, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(vuTouchpadActivity, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding = vuTouchpadActivity.c;
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding2 = null;
        if (fragmentVuTouchpadBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuTouchpadBinding = null;
        }
        int height = fragmentVuTouchpadBinding.h.getHeight();
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding3 = vuTouchpadActivity.c;
        if (fragmentVuTouchpadBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuTouchpadBinding3 = null;
        }
        float f2 = ((float) height) * (1.0f - floatValue);
        fragmentVuTouchpadBinding3.h.setTranslationY(f2);
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding4 = vuTouchpadActivity.c;
        if (fragmentVuTouchpadBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuTouchpadBinding4 = null;
        }
        ViewGroup.LayoutParams layoutParams = fragmentVuTouchpadBinding4.p.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = (int) f2;
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding5 = vuTouchpadActivity.c;
        if (fragmentVuTouchpadBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentVuTouchpadBinding2 = fragmentVuTouchpadBinding5;
        }
        fragmentVuTouchpadBinding2.p.setLayoutParams(marginLayoutParams);
    }

    public static final void i1(VuTouchpadActivity vuTouchpadActivity, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(vuTouchpadActivity, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding = vuTouchpadActivity.c;
        if (fragmentVuTouchpadBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuTouchpadBinding = null;
        }
        fragmentVuTouchpadBinding.h.setAlpha(floatValue);
    }

    private final void initView() {
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding = this.c;
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding2 = null;
        if (fragmentVuTouchpadBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuTouchpadBinding = null;
        }
        fragmentVuTouchpadBinding.e.setOnTouchListener(new VuTouchpadActivity$initView$1(this));
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding3 = this.c;
        if (fragmentVuTouchpadBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuTouchpadBinding3 = null;
        }
        fragmentVuTouchpadBinding3.e.setHapticFeedbackEnabled(false);
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding4 = this.c;
        if (fragmentVuTouchpadBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuTouchpadBinding4 = null;
        }
        fragmentVuTouchpadBinding4.b.setOnClickListener(new v(this));
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding5 = this.c;
        if (fragmentVuTouchpadBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuTouchpadBinding5 = null;
        }
        fragmentVuTouchpadBinding5.g.setOnClickListener(new z(this));
        try {
            R1(0);
        } catch (Exception e2) {
            ULog.f6446a.c("VuTouchpadActivity", "initView getDofType error: " + e2.getMessage());
        }
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding6 = this.c;
        if (fragmentVuTouchpadBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuTouchpadBinding6 = null;
        }
        fragmentVuTouchpadBinding6.d.setOnClickListener(new a0(this));
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding7 = this.c;
        if (fragmentVuTouchpadBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuTouchpadBinding7 = null;
        }
        fragmentVuTouchpadBinding7.c.setOnClickListener(new b0(this));
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding8 = this.c;
        if (fragmentVuTouchpadBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuTouchpadBinding8 = null;
        }
        fragmentVuTouchpadBinding8.m.setOnClickListener(new c0(this));
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding9 = this.c;
        if (fragmentVuTouchpadBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentVuTouchpadBinding2 = fragmentVuTouchpadBinding9;
        }
        fragmentVuTouchpadBinding2.k.setOnClickListener(new d0(this));
    }

    public static final void j1(VuTouchpadActivity vuTouchpadActivity, View view) {
        Intrinsics.checkNotNullParameter(vuTouchpadActivity, "this$0");
        ULog.f6446a.a("VuTouchpadActivity", "click exit ar space");
        if (!ArSpaceService.j.c()) {
            ContextExtKt.e(R.string.opening_arspace, 0, 2, (Object) null);
        } else {
            vuTouchpadActivity.E1();
        }
    }

    public static final void k1(VuTouchpadActivity vuTouchpadActivity, View view) {
        Intrinsics.checkNotNullParameter(vuTouchpadActivity, "this$0");
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding = vuTouchpadActivity.c;
        if (fragmentVuTouchpadBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuTouchpadBinding = null;
        }
        ConstraintLayout constraintLayout = fragmentVuTouchpadBinding.h;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "moreFunctionLayout");
        if (constraintLayout.getVisibility() == 0) {
            vuTouchpadActivity.g1();
        } else {
            H1(vuTouchpadActivity, false, 1, (Object) null);
        }
    }

    public static final void l1(VuTouchpadActivity vuTouchpadActivity, View view) {
        Intrinsics.checkNotNullParameter(vuTouchpadActivity, "this$0");
        if (vuTouchpadActivity.W0() && vuTouchpadActivity.Z0()) {
            try {
                ArSpaceService a2 = ArSpaceService.j.a();
                if (a2 != null) {
                    a2.z(0);
                }
                vuTouchpadActivity.R1(0);
                vuTouchpadActivity.x1(0);
            } catch (Exception e2) {
                ULog.Delegate delegate = ULog.f6446a;
                String message = e2.getMessage();
                delegate.c("VuTouchpadActivity", "followHeadMode error: " + message);
            }
        }
    }

    public static final void m1(VuTouchpadActivity vuTouchpadActivity, View view) {
        Intrinsics.checkNotNullParameter(vuTouchpadActivity, "this$0");
        if (vuTouchpadActivity.W0() && vuTouchpadActivity.Z0()) {
            try {
                ArSpaceService a2 = ArSpaceService.j.a();
                if (a2 != null) {
                    a2.z(1);
                }
                vuTouchpadActivity.R1(1);
                vuTouchpadActivity.x1(1);
            } catch (Exception e2) {
                ULog.Delegate delegate = ULog.f6446a;
                String message = e2.getMessage();
                delegate.c("VuTouchpadActivity", "floatMode error: " + message);
            }
        }
    }

    public static final void n1(VuTouchpadActivity vuTouchpadActivity, View view) {
        Intrinsics.checkNotNullParameter(vuTouchpadActivity, "this$0");
        if (!vuTouchpadActivity.W0()) {
            ArSpaceReportHelper.g(ArSpaceReportHelper.f8088a, ArSpaceReportHelper.ScreenshotResult.AR_SPACE_NOT_READY, (String) null, 2, (Object) null);
        } else {
            vuTouchpadActivity.C1();
        }
    }

    public static final void o1(VuTouchpadActivity vuTouchpadActivity, View view) {
        Intrinsics.checkNotNullParameter(vuTouchpadActivity, "this$0");
        if (!vuTouchpadActivity.W0()) {
            ArSpaceReportHelper.e(ArSpaceReportHelper.f8088a, ArSpaceReportHelper.ScreenRecordResult.AR_SPACE_NOT_READY, 0, (String) null, 6, (Object) null);
        } else if (!vuTouchpadActivity.d) {
            vuTouchpadActivity.M1();
        } else {
            vuTouchpadActivity.N1();
        }
    }

    public static final void w1(VuTouchpadActivity vuTouchpadActivity, Intent intent) {
        Intrinsics.checkNotNullParameter(vuTouchpadActivity, "this$0");
        Function1 function1 = vuTouchpadActivity.u;
        if (function1 != null) {
            function1.invoke(intent);
        }
        vuTouchpadActivity.u = null;
    }

    public final void A1(Function1 function1) {
        ULog.f6446a.a("VuTouchpadActivity", "requestRecordPermission");
        this.u = function1;
        ActivityResultLauncher activityResultLauncher = this.t;
        if (activityResultLauncher != null) {
            activityResultLauncher.a((Object) null);
        }
    }

    public final void B1() {
        String[] y2 = PermissionAndStateCheckUtils.f7907a.y();
        PermissionHelper permissionHelper = PermissionHelper.f7819a;
        PermissionNote e2 = permissionHelper.e(this, y2);
        permissionHelper.q(this, y2, e2, 2008, e2, new VuTouchpadActivity$requestScreenRecordPermission$1(this));
    }

    public final void C1() {
        if (this.d) {
            if (!PhoneTypeUtils.f7912a.e()) {
                ContextExtKt.e(R.string.screenshot_error_recording, 0, 2, (Object) null);
            }
            ArSpaceReportHelper.g(ArSpaceReportHelper.f8088a, ArSpaceReportHelper.ScreenshotResult.SCREEN_RECORDING, (String) null, 2, (Object) null);
            return;
        }
        ArSpaceService a2 = ArSpaceService.j.a();
        if (a2 != null) {
            a2.v();
        }
    }

    public final void D1() {
        StaticMethodUtilsKt.G(this, CollectionsKt.arrayListOf(102), false, false, 6, (Object) null);
    }

    public final void E1() {
        if (this.g == null) {
            VuExitArSpaceDialog vuExitArSpaceDialog = new VuExitArSpaceDialog(this);
            this.g = vuExitArSpaceDialog;
            vuExitArSpaceDialog.e(new y(this));
        }
        VuExitArSpaceDialog vuExitArSpaceDialog2 = this.g;
        if (vuExitArSpaceDialog2 != null) {
            vuExitArSpaceDialog2.show();
        }
    }

    public final void G1(boolean z) {
        Animator animator = this.b;
        if (animator != null) {
            animator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration(z ? 300 : 10);
        ofFloat.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.2f, 1.0f));
        ofFloat.addUpdateListener(new f0(this));
        ofFloat.addListener(new VuTouchpadActivity$showMoreFunction$translate$1$2(this));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat2.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
        ofFloat2.setDuration(z ? 150 : 10);
        ofFloat2.addUpdateListener(new g0(this));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        if (!z) {
            animatorSet.setDuration(10);
        }
        animatorSet.start();
        this.b = animatorSet;
    }

    public final void K1(int i2, Intent intent) {
        ActivityOptions makeBasic = ActivityOptions.makeBasic();
        makeBasic.setLaunchDisplayId(i2);
        startActivity(intent, makeBasic.toBundle());
    }

    public final void L1() {
        Job job = this.l;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        this.l = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new VuTouchpadActivity$startCheckHomeLongClick$1(this, (Continuation<? super VuTouchpadActivity$startCheckHomeLongClick$1>) null), 3, (Object) null);
    }

    public final void M1() {
        if (!Y0()) {
            B1();
            return;
        }
        ArSpaceService a2 = ArSpaceService.j.a();
        if (a2 != null) {
            a2.D();
        }
    }

    public final void N1() {
        ArSpaceService a2;
        if (this.d && (a2 = ArSpaceService.j.a()) != null) {
            a2.F();
        }
    }

    public final void O1() {
        this.d = true;
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new VuTouchpadActivity$toRecordStatus$1(this, (Continuation<? super VuTouchpadActivity$toRecordStatus$1>) null), 3, (Object) null);
    }

    public final void P1() {
        this.d = false;
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new VuTouchpadActivity$toUnRecordStatus$1(this, (Continuation<? super VuTouchpadActivity$toUnRecordStatus$1>) null), 3, (Object) null);
    }

    public final void Q1() {
        VuGlassControlModel.f8109a.v().removeObserver(this.e);
    }

    public final void R1(Integer num) {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new VuTouchpadActivity$updateDofMode$1(num, this, (Continuation<? super VuTouchpadActivity$updateDofMode$1>) null), 3, (Object) null);
    }

    public final void U0() {
        Job job = this.l;
        if (job != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
    }

    public final void V0() {
        this.p.removeCallbacks(this.v);
    }

    public final boolean W0() {
        if (ArSpaceService.j.b().getFps() >= 10.0f) {
            return true;
        }
        ContextExtKt.e(R.string.opening_arspace, 0, 2, (Object) null);
        return false;
    }

    public final void X0(boolean z) {
        if (PhoneTypeUtils.f7912a.d()) {
            ULog.Delegate delegate = ULog.f6446a;
            FragmentVuTouchpadBinding fragmentVuTouchpadBinding = this.c;
            FragmentVuTouchpadBinding fragmentVuTouchpadBinding2 = null;
            if (fragmentVuTouchpadBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentVuTouchpadBinding = null;
            }
            View view = fragmentVuTouchpadBinding.f;
            Intrinsics.checkNotNullExpressionValue(view, "maskView");
            boolean z2 = view.getVisibility() == 0;
            delegate.a("VuTouchpadActivity", "checkConfirmConnectScreen: " + z + ", masView visible: " + z2 + ", hasFocused: " + this.h + "isConnectScreenShowed: " + this.i + ", requestingConnectScreen: " + this.j);
            FragmentVuTouchpadBinding fragmentVuTouchpadBinding3 = this.c;
            if (fragmentVuTouchpadBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentVuTouchpadBinding2 = fragmentVuTouchpadBinding3;
            }
            View view2 = fragmentVuTouchpadBinding2.f;
            Intrinsics.checkNotNullExpressionValue(view2, "maskView");
            if (view2.getVisibility() == 0 && !this.i) {
                if (z) {
                    if (!this.h) {
                        this.h = true;
                    } else if (this.j) {
                        this.i = true;
                        b1();
                    }
                } else if (this.h) {
                    this.j = true;
                }
            }
        }
    }

    public final boolean Y0() {
        return PermissionHelper.f7819a.n(this, PermissionAndStateCheckUtils.f7907a.y());
    }

    public final boolean Z0() {
        if (SystemClock.elapsedRealtime() - this.f < 800) {
            ContextExtKt.e(R.string.opening_arspace, 0, 2, (Object) null);
            return false;
        }
        this.f = SystemClock.elapsedRealtime();
        return true;
    }

    public void a(int i2, int i3) {
        if (i2 != 102) {
            if (i2 == 2008 && i3 == 1101) {
                StaticMethodUtilsKt.o(this);
            }
        } else if (i3 == 1101) {
            this.o = true;
            startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        }
    }

    public final void a1() {
        ULog.f6446a.a("VuTouchpadActivity", "closeTouchpad");
        finishAndRemoveTask();
    }

    public final void b1() {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new VuTouchpadActivity$delayCheckOpened$1(this, (Continuation<? super VuTouchpadActivity$delayCheckOpened$1>) null), 3, (Object) null);
    }

    public void c(int i2, Object obj) {
    }

    public final void c1() {
        this.p.postDelayed(this.v, 15000);
    }

    public final void d1() {
        WindowInsetsControllerCompat a2 = WindowCompat.a(getWindow(), getWindow().getDecorView());
        Intrinsics.checkNotNullExpressionValue(a2, "getInsetsController(...)");
        a2.e(2);
        a2.a(WindowInsetsCompat.Type.f());
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 0) {
            s1();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final HashMap e1() {
        return (HashMap) this.k.getValue();
    }

    public final void g1() {
        Animator animator = this.b;
        if (animator != null) {
            animator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(new PathInterpolator(0.4f, 0.0f, 0.4f, 1.0f));
        ofFloat.addUpdateListener(new h0(this));
        ofFloat.addListener(new VuTouchpadActivity$hideMoreFunction$translate$1$2(this));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat2.setStartDelay(150);
        ofFloat2.setDuration(150);
        ofFloat2.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
        ofFloat2.addUpdateListener(new w(this));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.start();
        this.b = animatorSet;
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding = this.c;
        if (fragmentVuTouchpadBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuTouchpadBinding = null;
        }
        fragmentVuTouchpadBinding.g.setImageResource(R.drawable.icon_vu_touchpad_more);
    }

    public void onBackPressed() {
    }

    public void onCreate(Bundle bundle) {
        fitSystemWindow(true);
        d1();
        super.onCreate(bundle);
        ULog.f6446a.a("VuTouchpadActivity", "onCreate");
        this.m = false;
        x = this;
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding = null;
        FragmentVuTouchpadBinding c2 = FragmentVuTouchpadBinding.c(getLayoutInflater(), (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.c = c2;
        if (c2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentVuTouchpadBinding = c2;
        }
        setContentView((View) fragmentVuTouchpadBinding.j);
        ArSpaceService.Companion companion = ArSpaceService.j;
        companion.f(this.q);
        companion.h(this.r);
        companion.i(this.s);
        initView();
        v1();
        if (bundle != null) {
            r1();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        ULog.Delegate delegate = ULog.f6446a;
        boolean z = this.n;
        boolean isChangingConfigurations = isChangingConfigurations();
        delegate.a("VuTouchpadActivity", "onDestroy: manualExit " + z + ", isConfigurationChange: " + isChangingConfigurations);
        x = null;
        Q1();
        ArSpaceService.Companion companion = ArSpaceService.j;
        companion.f((IOnDofModeChangeListener) null);
        companion.h((OnCaptureScreenListener) null);
        companion.i((OnRecordScreenListener) null);
        if (!isChangingConfigurations() && !this.m) {
            this.n = true;
            ArSpaceService a2 = companion.a();
            if (a2 != null) {
                a2.u(true);
            }
        }
        if (this.n) {
            y = SystemClock.elapsedRealtime();
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuTouchpadActivity", "onKeyDown: " + i2);
        VuGlassesEventDispatcher.f8098a.l(i2, 0);
        return super.onKeyDown(i2, keyEvent);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuTouchpadActivity", "onKeyUp: " + i2);
        VuGlassesEventDispatcher.f8098a.l(i2, 1);
        return super.onKeyUp(i2, keyEvent);
    }

    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        int intExtra = intent.getIntExtra("key_state", 0);
        if (intExtra == 1) {
            t1(intent.getIntExtra("key_display_id", 0), !intent.getBooleanExtra("key_auto_open", false));
        } else if (intExtra == 2) {
            a1();
        }
    }

    public void onPause() {
        super.onPause();
        ULog.f6446a.a("VuTouchpadActivity", "onPause");
    }

    public void onResume() {
        super.onResume();
        ULog.f6446a.a("VuTouchpadActivity", "onResume");
        if (this.o) {
            this.o = false;
            boolean f2 = PermissionAndStateCheckUtils.f7907a.f(MainApplication.k.f());
            ArSpaceService a2 = ArSpaceService.j.a();
            if (a2 != null) {
                a2.s(f2);
            }
        }
        s1();
    }

    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuTouchpadActivity", "onSaveInstanceState: " + bundle);
    }

    public void onStart() {
        super.onStart();
        ULog.f6446a.a("VuTouchpadActivity", "onStart");
    }

    public void onStop() {
        super.onStop();
        ULog.f6446a.a("VuTouchpadActivity", "onStop");
        V0();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        X0(z);
    }

    public final void p1() {
        VuGlassControlModel.f8109a.v().observeForever(this.e);
    }

    public final void q1() {
        ULog.f6446a.a("VuTouchpadActivity", "onArSpaceExit");
        this.m = true;
        finishAndRemoveTask();
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (launchIntentForPackage != null) {
            startActivity(launchIntentForPackage);
        }
    }

    public final void r1() {
        p1();
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding = this.c;
        FragmentVuTouchpadBinding fragmentVuTouchpadBinding2 = null;
        if (fragmentVuTouchpadBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentVuTouchpadBinding = null;
        }
        View view = fragmentVuTouchpadBinding.f;
        Intrinsics.checkNotNullExpressionValue(view, "maskView");
        view.setVisibility(8);
        GlassDataStoreHelper glassDataStoreHelper = GlassDataStoreHelper.f8091a;
        boolean e2 = glassDataStoreHelper.e();
        ULog.f6446a.a("VuTouchpadActivity", "isFirstShow: " + e2);
        if (e2) {
            FragmentVuTouchpadBinding fragmentVuTouchpadBinding3 = this.c;
            if (fragmentVuTouchpadBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentVuTouchpadBinding2 = fragmentVuTouchpadBinding3;
            }
            ConstraintLayout constraintLayout = fragmentVuTouchpadBinding2.h;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "moreFunctionLayout");
            OneShotPreDrawListener.a(constraintLayout, new VuTouchpadActivity$onArSpaceOpened$$inlined$doOnPreDraw$1(constraintLayout, this));
            glassDataStoreHelper.n(false);
        }
    }

    public void recreate() {
        super.recreate();
        ULog.f6446a.a("VuTouchpadActivity", "recreate");
    }

    public final void s1() {
        V0();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.screenBrightness = -1.0f;
        getWindow().setAttributes(attributes);
        c1();
    }

    public final void t1(int i2, boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuTouchpadActivity", "openArSpace displayId: " + i2 + ", showTip: " + z);
        ArSpaceService.Companion companion = ArSpaceService.j;
        RuntimeStatusOuterClass.RuntimeStatus defaultInstance = RuntimeStatusOuterClass.RuntimeStatus.getDefaultInstance();
        Intrinsics.checkNotNullExpressionValue(defaultInstance, "getDefaultInstance(...)");
        companion.g(defaultInstance);
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new VuTouchpadActivity$openArSpace$1(this, i2, z, (Continuation<? super VuTouchpadActivity$openArSpace$1>) null), 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object u1(int r12, boolean r13, kotlin.coroutines.Continuation r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.upuphone.xr.sapp.vu.VuTouchpadActivity$realOpenArSpace$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.upuphone.xr.sapp.vu.VuTouchpadActivity$realOpenArSpace$1 r0 = (com.upuphone.xr.sapp.vu.VuTouchpadActivity$realOpenArSpace$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.vu.VuTouchpadActivity$realOpenArSpace$1 r0 = new com.upuphone.xr.sapp.vu.VuTouchpadActivity$realOpenArSpace$1
            r0.<init>(r11, r14)
        L_0x0018:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 2
            r5 = 0
            if (r2 == 0) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r11 = r0.L$0
            com.upuphone.xr.sapp.vu.VuTouchpadActivity r11 = (com.upuphone.xr.sapp.vu.VuTouchpadActivity) r11
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00d0
        L_0x0030:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r14)
            com.upuphone.star.core.log.ULog$Delegate r14 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "realOpenArSpace: "
            r2.append(r6)
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            java.lang.String r6 = "VuTouchpadActivity"
            r14.a(r6, r2)
            java.lang.String r2 = "com.irisview.irisxr.MainActivity"
            java.lang.Class r2 = java.lang.Class.forName(r2)
            android.content.Intent r7 = new android.content.Intent
            r7.<init>(r11, r2)
            java.lang.Class<android.app.ActivityManager> r2 = android.app.ActivityManager.class
            java.lang.Object r2 = r11.getSystemService(r2)
            android.app.ActivityManager r2 = (android.app.ActivityManager) r2
            boolean r2 = r2.isActivityStartAllowedOnDisplay(r11, r12, r7)
            com.upuphone.xr.sapp.MainApplication$Companion r8 = com.upuphone.xr.sapp.MainApplication.k
            com.upuphone.xr.sapp.MainApplication r8 = r8.f()
            boolean r8 = r8.v()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "startActivityOnDisplay: allowOpen "
            r9.append(r10)
            r9.append(r2)
            java.lang.String r10 = ", isAppForeground: "
            r9.append(r10)
            r9.append(r8)
            java.lang.String r9 = r9.toString()
            r14.a(r6, r9)
            if (r8 == 0) goto L_0x00dd
            if (r2 != 0) goto L_0x0095
            goto L_0x00dd
        L_0x0095:
            com.upuphone.xr.sapp.vu.utils.ArSpaceUtil r13 = com.upuphone.xr.sapp.vu.utils.ArSpaceUtil.f8089a
            boolean r13 = r13.h(r11)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r8 = "isArSpaceRunning: "
            r2.append(r8)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r14.a(r6, r2)
            com.upuphone.xr.sapp.vu.ArSpaceService$Companion r2 = com.upuphone.xr.sapp.vu.ArSpaceService.j
            r2.j(r12, r11)
            if (r13 == 0) goto L_0x00bc
            java.lang.String r12 = "realOpenArSpace: isArSpaceRunning"
            r14.a(r6, r12)
            goto L_0x00bf
        L_0x00bc:
            r11.K1(r12, r7)
        L_0x00bf:
            r12 = 0
            r11.overridePendingTransition(r12, r12)
            r0.L$0 = r11
            r0.label = r3
            r12 = 100
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.b(r12, r0)
            if (r12 != r1) goto L_0x00d0
            return r1
        L_0x00d0:
            r11.r1()
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper r11 = com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.f8088a
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper$OpenArSpaceResult r12 = com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.OpenArSpaceResult.SUCCESS
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.c(r11, r12, r5, r4, r5)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00dd:
            if (r13 == 0) goto L_0x00e6
            com.upuphone.star.common.phone.UToast$Companion r12 = com.upuphone.star.common.phone.UToast.f6444a
            int r13 = com.upuphone.xr.sapp.R.string.open_ar_space_error
            r12.b(r11, r13)
        L_0x00e6:
            r11.finishAndRemoveTask()
            if (r8 != 0) goto L_0x00f3
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper r11 = com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.f8088a
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper$OpenArSpaceResult r12 = com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.OpenArSpaceResult.APP_BACKGROUND
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.c(r11, r12, r5, r4, r5)
            goto L_0x00fc
        L_0x00f3:
            if (r2 != 0) goto L_0x00fc
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper r11 = com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.f8088a
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper$OpenArSpaceResult r12 = com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.OpenArSpaceResult.CANNOT_START_ACTIVITY
            com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper.c(r11, r12, r5, r4, r5)
        L_0x00fc:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vu.VuTouchpadActivity.u1(int, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void v1() {
        this.t = registerForActivityResult(new VuTouchpadActivity$registerRecordContract$requestRecordContract$1(this), new e0(this));
    }

    public final void x1(int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("ar_render_mode", Integer.valueOf(i2 == 0 ? 0 : 1));
        DeviceInfo d2 = VuGlassesDeviceInfoModel.f8112a.d();
        DataTrackUtil.m(DataTrackUtil.f7875a, "ar_render_mode", hashMap, d2.getSerialNo(), d2.getModel(), d2.getRomVersion(), false, 32, (Object) null);
    }

    public final void y1(String str, String str2, String str3, String[] strArr) {
        Intrinsics.checkNotNullParameter(str, "requestTag");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VuTouchpadActivity", "requestArSpacePermission: " + str);
        String[] strArr2 = (String[]) e1().get(str);
        if (strArr2 == null) {
            ArSpaceService a2 = ArSpaceService.j.a();
            if (a2 != null) {
                a2.t(str, false);
                return;
            }
            return;
        }
        PermissionHelper permissionHelper = PermissionHelper.f7819a;
        PermissionNote e2 = permissionHelper.e(this, strArr2);
        permissionHelper.q(this, strArr2, e2, 2008, e2, new VuTouchpadActivity$requestArSpacePermission$1(str));
    }

    public final void z1(boolean z) {
        N1();
        ArSpaceService a2 = ArSpaceService.j.a();
        if (a2 != null) {
            a2.u(z);
        }
    }
}
