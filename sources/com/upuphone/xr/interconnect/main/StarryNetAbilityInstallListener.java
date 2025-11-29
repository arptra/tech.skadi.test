package com.upuphone.xr.interconnect.main;

import android.content.Context;
import com.honey.account.view.web.WebJs;
import com.upuphone.starrynetsdk.InstallListener;
import com.upuphone.starrynetsdk.StarryNet;
import com.upuphone.starrynetsdk.device.connection.DevicesConnector;
import com.upuphone.starrynetsdk.device.discovery.DevicesDiscoverer;
import com.upuphone.xr.interconnect.adapter.StarryNetSdkAdapterImpl;
import com.upuphone.xr.interconnect.petastep.PetaStepSerializer;
import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\fJ\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J&\u0010\u0018\u001a\u00020\u00112\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J'\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00110\u001e¢\u0006\u0002\b\u001fJ'\u0010 \u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00110\u001e¢\u0006\u0002\b\u001fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010`\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/upuphone/xr/interconnect/main/StarryNetAbilityInstallListener;", "Lcom/upuphone/xr/interconnect/petastep/PetaStepSerializer;", "Lcom/upuphone/starrynetsdk/InstallListener;", "()V", "applicationContext", "Landroid/content/Context;", "devicesConnector", "Lcom/upuphone/starrynetsdk/device/connection/DevicesConnector;", "kotlin.jvm.PlatformType", "devicesDiscoverer", "Lcom/upuphone/starrynetsdk/device/discovery/DevicesDiscoverer;", "isInitialized", "", "isInstalled", "operationQueue", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "", "Lkotlin/collections/ArrayList;", "install", "isFinishInit", "onInstalled", "onUninstalled", "tryInstallInMainThread", "useAfterInitialize", "onFail", "action", "useDevicesConnector", "description", "", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "useDevicesDiscoverer", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StarryNetAbilityInstallListener extends PetaStepSerializer implements InstallListener {
    @NotNull
    public static final StarryNetAbilityInstallListener INSTANCE = new StarryNetAbilityInstallListener();
    /* access modifiers changed from: private */
    @Nullable
    public static volatile Context applicationContext;
    /* access modifiers changed from: private */
    public static final DevicesConnector devicesConnector = DevicesConnector.getInstance();
    /* access modifiers changed from: private */
    @NotNull
    public static final DevicesDiscoverer devicesDiscoverer = new DevicesDiscoverer();
    private static volatile boolean isInitialized;
    /* access modifiers changed from: private */
    public static boolean isInstalled;
    /* access modifiers changed from: private */
    @NotNull
    public static final ArrayList<Function0<Unit>> operationQueue = new ArrayList<>();

    private StarryNetAbilityInstallListener() {
        super(AnonymousClass1.INSTANCE, "sTEiLR");
    }

    /* access modifiers changed from: private */
    public final boolean tryInstallInMainThread(Context context) {
        if (isInitialized) {
            return true;
        }
        int installStarryNet = StarryNetSdkAdapterImpl.INSTANCE.installStarryNet(context);
        if (installStarryNet == 0) {
            isInitialized = true;
            StarryNet.getInstance().registerInstallListener(this);
            return true;
        }
        String tag = getTag();
        ILog.w(tag, "Install failed with error " + installStarryNet);
        return false;
    }

    /* access modifiers changed from: private */
    public final void useAfterInitialize(Function0<Unit> function0, Function0<Unit> function02) {
        if (!isInitialized) {
            if (((Boolean) BuildersKt__BuildersKt.b((CoroutineContext) null, new StarryNetAbilityInstallListener$useAfterInitialize$2((Continuation<? super StarryNetAbilityInstallListener$useAfterInitialize$2>) null), 1, (Object) null)).booleanValue()) {
                operationQueue.add(function02);
            } else {
                function0.invoke();
            }
        } else if (!isInstalled) {
            operationQueue.add(function02);
        } else {
            function02.invoke();
        }
    }

    public static /* synthetic */ void useAfterInitialize$default(StarryNetAbilityInstallListener starryNetAbilityInstallListener, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = StarryNetAbilityInstallListener$useAfterInitialize$1.INSTANCE;
        }
        starryNetAbilityInstallListener.useAfterInitialize(function0, function02);
    }

    public final void install(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        ILog.d(getTag(), "Attempting to initialize.");
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c().getImmediate()), (CoroutineContext) null, (CoroutineStart) null, new StarryNetAbilityInstallListener$install$1(context, (Continuation<? super StarryNetAbilityInstallListener$install$1>) null), 3, (Object) null);
        applicationContext = context;
    }

    public final boolean isFinishInit() {
        return isInitialized;
    }

    public void onInstalled() {
        serialize("installation", StarryNetAbilityInstallListener$onInstalled$1.INSTANCE);
    }

    public void onUninstalled() {
        serialize("uninstallation", StarryNetAbilityInstallListener$onUninstalled$1.INSTANCE);
    }

    public final void useDevicesConnector(@NotNull String str, @NotNull Function1<? super DevicesConnector, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "description");
        Intrinsics.checkNotNullParameter(function1, WebJs.ACTION);
        serialize("connection action", new StarryNetAbilityInstallListener$useDevicesConnector$1(str, function1));
    }

    public final void useDevicesDiscoverer(@NotNull String str, @NotNull Function1<? super DevicesDiscoverer, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "description");
        Intrinsics.checkNotNullParameter(function1, WebJs.ACTION);
        serialize("discoverer action", new StarryNetAbilityInstallListener$useDevicesDiscoverer$1(str, function1));
    }
}
