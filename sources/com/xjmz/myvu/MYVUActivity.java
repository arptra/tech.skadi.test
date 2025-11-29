package com.xjmz.myvu;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import com.honey.account.n9.a;
import com.honey.account.n9.b;
import com.honey.account.n9.c;
import com.honey.account.n9.d;
import com.honey.account.n9.e;
import com.honey.account.n9.f;
import com.honey.account.n9.g;
import com.honey.account.n9.h;
import com.honey.account.n9.i;
import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.navi.lite.manger.NaviManager;
import com.upuphone.ar.navi.lite.model.INaviVoiceStateChanged;
import com.upuphone.star.core.log.ULog;
import com.upuphone.star.fota.phone.GlassCheckUpdateResult;
import com.upuphone.star.fota.phone.GlassCheckUpdateResultKt;
import com.upuphone.star.fota.phone.GlassUpdateInfo;
import com.upuphone.xr.sapp.BaseActivity;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.ability.PhoneSappAbility;
import com.upuphone.xr.sapp.aspect.AspectHelper;
import com.upuphone.xr.sapp.common.CachedViewModelLazy;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$1;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$2;
import com.upuphone.xr.sapp.common.GlobalViewStoreExtKt$cachedViewModels$factoryPromise$1;
import com.upuphone.xr.sapp.common.GlobalViewStoreOwner;
import com.upuphone.xr.sapp.common.MzAccountManager;
import com.upuphone.xr.sapp.contract.ContractEntry;
import com.upuphone.xr.sapp.contract.ProtocolType;
import com.upuphone.xr.sapp.contract.ReceiveLocationEventManager;
import com.upuphone.xr.sapp.databinding.ActivityMyvuBinding;
import com.upuphone.xr.sapp.entity.BasicGlassInfo;
import com.upuphone.xr.sapp.entity.ConnectState;
import com.upuphone.xr.sapp.entity.GlassCheckUpdateState;
import com.upuphone.xr.sapp.entity.GlassCheckUpdateStateKt;
import com.upuphone.xr.sapp.entity.NetDevice;
import com.upuphone.xr.sapp.entity.WindowFocusChangeListener;
import com.upuphone.xr.sapp.glass.CompatibilityManager;
import com.upuphone.xr.sapp.glass.GlassCompatHelper;
import com.upuphone.xr.sapp.glass.GlassFileTransferHelper;
import com.upuphone.xr.sapp.glass.GlassScreenShotHelper;
import com.upuphone.xr.sapp.glass.GlassUpdateHelper;
import com.upuphone.xr.sapp.glass.GlassUpdateInfoActivity;
import com.upuphone.xr.sapp.receiver.StarryDeviceNameChangeReceiver;
import com.upuphone.xr.sapp.unicron.UnicronUpdateHelper;
import com.upuphone.xr.sapp.utils.AppUpdateHelper;
import com.upuphone.xr.sapp.utils.AppUtils;
import com.upuphone.xr.sapp.utils.AssociateUserManager;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.DynamicAdapterUtils;
import com.upuphone.xr.sapp.utils.FlymeUtils;
import com.upuphone.xr.sapp.utils.GenericWindowManger;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.utils.HttpRequestUtil;
import com.upuphone.xr.sapp.utils.HuaWeiFeatureParser;
import com.upuphone.xr.sapp.utils.LocalSharePreference;
import com.upuphone.xr.sapp.utils.ModelIdExtKt;
import com.upuphone.xr.sapp.utils.NetworkUtils;
import com.upuphone.xr.sapp.utils.PhoneTypeUtils;
import com.upuphone.xr.sapp.utils.StarryNetHelper;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import com.upuphone.xr.sapp.utils.VersionCheckUtil;
import com.upuphone.xr.sapp.view.BlockEventFrameLayout;
import com.upuphone.xr.sapp.view.SuperGenericWindowView;
import com.upuphone.xr.sapp.vm.DeviceControlModel;
import com.upuphone.xr.sapp.vm.GlassUpdateViewModel;
import com.upuphone.xr.sapp.vm.Ring2ControlViewModel;
import com.upuphone.xr.sapp.vm.SuperViewModel;
import com.upuphone.xr.sapp.vm.internal.SuperMessageManger;
import com.upuphone.xr.sapp.vu.VuBaseGlassesActivity;
import com.xjmz.myvu.bridge.MainActivityInterface;
import com.xjmz.myvu.dialog.GlobalWindowDialog;
import com.xjmz.myvu.ext.ContextExtKt;
import com.xjmz.myvu.flutter.FlutterEngineManager;
import com.xjmz.myvu.modules.home.HomeFragment;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 Ð\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002Ñ\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\u0007J\u000f\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0007J\u000f\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u0007J\u000f\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0007J\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\u0007J\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0007J\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0007J\u000f\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\u0007J)\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010 \u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\nH\u0002¢\u0006\u0004\b\"\u0010\u0007J\u000f\u0010#\u001a\u00020\nH\u0002¢\u0006\u0004\b#\u0010\u0007J\u000f\u0010$\u001a\u00020\nH\u0002¢\u0006\u0004\b$\u0010\u0007J\u000f\u0010%\u001a\u00020\nH\u0002¢\u0006\u0004\b%\u0010\u0007J\u000f\u0010&\u001a\u00020\nH\u0002¢\u0006\u0004\b&\u0010\u0007J\u0017\u0010)\u001a\u00020\n2\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00162\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\nH\u0002¢\u0006\u0004\b-\u0010\u0007J\u000f\u0010.\u001a\u00020\nH\u0002¢\u0006\u0004\b.\u0010\u0007J\u0017\u00100\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u001eH\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\nH\u0002¢\u0006\u0004\b2\u0010\u0007J\u000f\u00103\u001a\u00020\nH\u0002¢\u0006\u0004\b3\u0010\u0007J\u000f\u00104\u001a\u00020\nH\u0002¢\u0006\u0004\b4\u0010\u0007J!\u00108\u001a\u00020\n2\u0006\u00106\u001a\u0002052\b\b\u0002\u00107\u001a\u00020\u001eH\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\nH\u0002¢\u0006\u0004\b:\u0010\u0007J\u000f\u0010;\u001a\u00020\nH\u0002¢\u0006\u0004\b;\u0010\u0007J\u0019\u0010>\u001a\u00020\n2\b\u0010=\u001a\u0004\u0018\u00010<H\u0014¢\u0006\u0004\b>\u0010?J\u0019\u0010B\u001a\u00020\n2\b\u0010A\u001a\u0004\u0018\u00010@H\u0014¢\u0006\u0004\bB\u0010CJ\u0017\u0010D\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\bD\u0010\fJ\u000f\u0010E\u001a\u00020\nH\u0014¢\u0006\u0004\bE\u0010\u0007J\u000f\u0010F\u001a\u00020\nH\u0014¢\u0006\u0004\bF\u0010\u0007J!\u0010I\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u00162\n\b\u0002\u0010H\u001a\u0004\u0018\u00010<¢\u0006\u0004\bI\u0010JJ\u001f\u0010M\u001a\u00020\n2\u0006\u0010K\u001a\u00020\u00162\u0006\u0010L\u001a\u00020\u0016H\u0016¢\u0006\u0004\bM\u0010NJ!\u0010P\u001a\u00020\n2\u0006\u0010K\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010OH\u0016¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020\nH\u0016¢\u0006\u0004\bR\u0010\u0007J)\u0010S\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\bS\u0010\u001bJ\u001d\u0010V\u001a\u00020\n2\f\u0010U\u001a\b\u0012\u0004\u0012\u0002050TH\u0016¢\u0006\u0004\bV\u0010WJ\u000f\u0010X\u001a\u00020\nH\u0016¢\u0006\u0004\bX\u0010\u0007J\u0019\u0010[\u001a\u00020\u001e2\b\u0010Z\u001a\u0004\u0018\u00010YH\u0016¢\u0006\u0004\b[\u0010\\J\u0017\u0010^\u001a\u00020\n2\b\u0010]\u001a\u0004\u0018\u000105¢\u0006\u0004\b^\u0010_J)\u0010e\u001a\u00020\n2\u0006\u0010a\u001a\u00020`2\u0006\u0010c\u001a\u00020b2\b\u0010d\u001a\u0004\u0018\u00010<H\u0016¢\u0006\u0004\be\u0010fJ\u0017\u0010h\u001a\u00020\n2\u0006\u0010g\u001a\u00020\u001eH\u0016¢\u0006\u0004\bh\u00101J\u0017\u0010j\u001a\u00020\n2\u0006\u0010i\u001a\u00020<H\u0015¢\u0006\u0004\bj\u0010?J\u0017\u0010l\u001a\u00020\n2\u0006\u0010k\u001a\u00020\u001eH\u0016¢\u0006\u0004\bl\u00101J\r\u0010m\u001a\u00020\n¢\u0006\u0004\bm\u0010\u0007J\r\u0010n\u001a\u00020\n¢\u0006\u0004\bn\u0010\u0007J\r\u0010o\u001a\u00020\n¢\u0006\u0004\bo\u0010\u0007R\u001c\u0010t\u001a\b\u0012\u0004\u0012\u00020q0p8\u0002@\u0002X.¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010v\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010uR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bx\u0010yR\u001c\u0010\u0001\u001a\u00020{8BX\u0002¢\u0006\f\n\u0004\b|\u0010}\u001a\u0004\b~\u0010R \u0010\u0001\u001a\u00030\u00018BX\u0002¢\u0006\u000f\n\u0005\b\u0001\u0010}\u001a\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\u00030\u00018BX\u0002¢\u0006\u000f\n\u0005\b\u0001\u0010}\u001a\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\u00030\u00018BX\u0002¢\u0006\u000f\n\u0005\b\u0001\u0010}\u001a\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\u00030\u00018BX\u0002¢\u0006\u000f\n\u0005\b\u0001\u0010}\u001a\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0001\u001a\u0004\u0018\u0001058\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R'\u0010\u0001\u001a\u00020\u001e8\u0006@\u0006X\u000e¢\u0006\u0016\n\u0005\b\u0001\u0010u\u001a\u0006\b\u0001\u0010\u0001\"\u0005\b\u0001\u00101R\u0017\u0010\u0001\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u0010uR+\u0010¤\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0017\n\u0005\bV\u0010\u0001\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R\u001b\u0010¦\u0001\u001a\u0004\u0018\u0001058\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010\u0001R\u001c\u0010ª\u0001\u001a\u0005\u0018\u00010§\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u0018\u0010¬\u0001\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b«\u0001\u0010uR\u001b\u0010¯\u0001\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b­\u0001\u0010®\u0001R\u0018\u0010±\u0001\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b°\u0001\u0010uR\u0019\u0010´\u0001\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b²\u0001\u0010³\u0001R\u001c\u0010¸\u0001\u001a\u0005\u0018\u00010µ\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R(\u0010¼\u0001\u001a\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002050T\u0018\u00010¹\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R\u0018\u0010¾\u0001\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b½\u0001\u0010uR\"\u0010À\u0001\u001a\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010¹\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010»\u0001R\u001b\u0010Ã\u0001\u001a\u0005\u0018\u00010Á\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\be\u0010Â\u0001R \u0010È\u0001\u001a\u00030Ä\u00018BX\u0002¢\u0006\u000f\n\u0005\bÅ\u0001\u0010}\u001a\u0006\bÆ\u0001\u0010Ç\u0001R\u001b\u0010Ë\u0001\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010Ê\u0001R\u001c\u0010Í\u0001\u001a\u0005\u0018\u00010Á\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010Â\u0001R\u001c\u0010Ï\u0001\u001a\u0005\u0018\u00010Á\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010Â\u0001¨\u0006Ò\u0001"}, d2 = {"Lcom/xjmz/myvu/MYVUActivity;", "Lcom/upuphone/xr/sapp/BaseActivity;", "Lcom/upuphone/xr/sapp/view/SuperGenericWindowView$IActionCallback;", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "Lcom/xjmz/myvu/bridge/MainActivityInterface;", "Lcom/upuphone/ar/navi/lite/model/INaviVoiceStateChanged;", "<init>", "()V", "Landroid/content/Intent;", "intent", "", "V0", "(Landroid/content/Intent;)V", "j1", "X0", "d1", "x1", "k1", "p1", "S0", "m1", "l1", "", "requestCode", "resultCode", "data", "W0", "(IILandroid/content/Intent;)V", "Lcom/upuphone/xr/sapp/entity/GlassCheckUpdateState;", "glassCheckUpdateState", "", "glassUpdateBadge", "E1", "(Lcom/upuphone/xr/sapp/entity/GlassCheckUpdateState;Ljava/lang/Boolean;)V", "h1", "P0", "R0", "O0", "z1", "Landroid/view/View;", "view", "b1", "(Landroid/view/View;)V", "N0", "(Landroid/view/View;)I", "y1", "I1", "isVisible", "A1", "(Z)V", "B1", "u1", "i1", "", "uid", "forceToShow", "K1", "(Ljava/lang/String;Z)V", "T0", "J1", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Context;", "newBase", "attachBaseContext", "(Landroid/content/Context;)V", "onNewIntent", "onPause", "onResume", "resId", "arg", "q1", "(ILandroid/os/Bundle;)V", "windowType", "actionType", "a", "(II)V", "", "c", "(ILjava/lang/Object;)V", "onDestroy", "onActivityResult", "", "permissions", "m", "([Ljava/lang/String;)V", "l", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "deviceId", "C1", "(Ljava/lang/String;)V", "Landroidx/navigation/NavController;", "controller", "Landroidx/navigation/NavDestination;", "destination", "arguments", "x", "(Landroidx/navigation/NavController;Landroidx/navigation/NavDestination;Landroid/os/Bundle;)V", "hasFocus", "onWindowFocusChanged", "outState", "onSaveInstanceState", "state", "NaviVoiceStateChanged", "G1", "H1", "c1", "Landroidx/lifecycle/Observer;", "Lcom/upuphone/xr/sapp/entity/NetDevice;", "b", "Landroidx/lifecycle/Observer;", "deviceConnectObserver", "Z", "isChangingUiMode", "Lcom/upuphone/xr/sapp/databinding/ActivityMyvuBinding;", "d", "Lcom/upuphone/xr/sapp/databinding/ActivityMyvuBinding;", "binding", "Lcom/upuphone/xr/sapp/vm/GlassUpdateViewModel;", "e", "Lkotlin/Lazy;", "Y0", "()Lcom/upuphone/xr/sapp/vm/GlassUpdateViewModel;", "glassUpdateVM", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "f", "f1", "()Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "superViewModel", "Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "g", "Z0", "()Lcom/upuphone/xr/sapp/vm/DeviceControlModel;", "mDeviceModel", "Lcom/upuphone/xr/sapp/vm/Ring2ControlViewModel;", "h", "a1", "()Lcom/upuphone/xr/sapp/vm/Ring2ControlViewModel;", "mRing2ControlViewModel", "Lcom/upuphone/xr/sapp/receiver/StarryDeviceNameChangeReceiver;", "i", "e1", "()Lcom/upuphone/xr/sapp/receiver/StarryDeviceNameChangeReceiver;", "starryDeviceNameChangeReceiver", "j", "Ljava/lang/String;", "resetDeviceId", "k", "getFactoryRestFlag", "()Z", "D1", "factoryRestFlag", "forceInvalidate", "Lcom/xjmz/myvu/modules/home/HomeFragment;", "Lcom/xjmz/myvu/modules/home/HomeFragment;", "getHomeFragment", "()Lcom/xjmz/myvu/modules/home/HomeFragment;", "setHomeFragment", "(Lcom/xjmz/myvu/modules/home/HomeFragment;)V", "homeFragment", "n", "showUpdateDialogVersion", "Landroid/content/BroadcastReceiver;", "o", "Landroid/content/BroadcastReceiver;", "mNetworkReceiver", "p", "firstInit", "q", "Landroidx/navigation/NavController;", "navController", "r", "reInitViewModel", "s", "I", "currentDestinationId", "Lcom/upuphone/xr/sapp/entity/WindowFocusChangeListener;", "t", "Lcom/upuphone/xr/sapp/entity/WindowFocusChangeListener;", "windowFocusChangeListener", "Landroidx/activity/result/ActivityResultLauncher;", "u", "Landroidx/activity/result/ActivityResultLauncher;", "unicronPermissionLauncher", "v", "isConnect", "w", "manageUnknownAppSourcesLauncher", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "aiStateJob", "Lcom/upuphone/xr/sapp/vu/VuBaseGlassesActivity;", "y", "g1", "()Lcom/upuphone/xr/sapp/vu/VuBaseGlassesActivity;", "vuGlassesActivity", "z", "Landroidx/navigation/NavDestination;", "currentNavDestination", "A", "hideAndroidNaviJob", "B", "hideHomeFragmentJob", "C", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nMYVUActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MYVUActivity.kt\ncom/xjmz/myvu/MYVUActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n+ 3 GlobalViewStoreExt.kt\ncom/upuphone/xr/sapp/common/GlobalViewStoreExtKt\n+ 4 FragmentManager.kt\nandroidx/fragment/app/FragmentManagerKt\n+ 5 ContextExt.kt\ncom/upuphone/xr/sapp/utils/ContextExtKt\n+ 6 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,1080:1\n75#2,13:1081\n13#3,16:1094\n13#3,16:1110\n13#3,16:1126\n28#4,12:1142\n19#5,9:1154\n254#6:1163\n256#6,2:1164\n256#6,2:1166\n277#6,2:1168\n254#6:1170\n256#6,2:1171\n254#6:1173\n254#6:1174\n*S KotlinDebug\n*F\n+ 1 MYVUActivity.kt\ncom/xjmz/myvu/MYVUActivity\n*L\n139#1:1081,13\n140#1:1094,16\n141#1:1110,16\n142#1:1126,16\n213#1:1142,12\n463#1:1154,9\n557#1:1163\n793#1:1164,2\n795#1:1166,2\n856#1:1168,2\n896#1:1170\n899#1:1171,2\n900#1:1173\n901#1:1174\n*E\n"})
public final class MYVUActivity extends BaseActivity implements SuperGenericWindowView.IActionCallback, NavController.OnDestinationChangedListener, MainActivityInterface, INaviVoiceStateChanged {
    public static final Companion C = new Companion((DefaultConstructorMarker) null);
    public static final Handler D = new Handler(Looper.getMainLooper());
    public static boolean E;
    public Job A;
    public Job B;
    public Observer b;
    public boolean c;
    public ActivityMyvuBinding d;
    public final Lazy e = new ViewModelLazy(Reflection.getOrCreateKotlinClass(GlassUpdateViewModel.class), new MYVUActivity$special$$inlined$viewModels$default$2(this), new MYVUActivity$special$$inlined$viewModels$default$1(this), new MYVUActivity$special$$inlined$viewModels$default$3((Function0) null, this));
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public String j;
    public boolean k;
    public boolean l;
    public HomeFragment m;
    public String n;
    public BroadcastReceiver o;
    public boolean p;
    public NavController q;
    public boolean r;
    public int s;
    public WindowFocusChangeListener t;
    public ActivityResultLauncher u;
    public boolean v;
    public ActivityResultLauncher w;
    public Job x;
    public final Lazy y;
    public NavDestination z;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/xjmz/myvu/MYVUActivity$Companion;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "Landroid/os/Handler;", "delayHandler", "Landroid/os/Handler;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public MYVUActivity() {
        GlobalViewStoreExtKt$cachedViewModels$factoryPromise$1 globalViewStoreExtKt$cachedViewModels$factoryPromise$1 = new GlobalViewStoreExtKt$cachedViewModels$factoryPromise$1(this);
        Class<SuperViewModel> cls = SuperViewModel.class;
        String name = cls.getName();
        GlobalViewStoreOwner globalViewStoreOwner = GlobalViewStoreOwner.f6658a;
        Intrinsics.checkNotNull(name);
        globalViewStoreOwner.d(this, name);
        this.f = new CachedViewModelLazy(Reflection.getOrCreateKotlinClass(cls), new GlobalViewStoreExtKt$cachedViewModels$1(name), globalViewStoreExtKt$cachedViewModels$factoryPromise$1, new GlobalViewStoreExtKt$cachedViewModels$2((Function0<? extends CreationExtras>) null, this));
        GlobalViewStoreExtKt$cachedViewModels$factoryPromise$1 globalViewStoreExtKt$cachedViewModels$factoryPromise$12 = new GlobalViewStoreExtKt$cachedViewModels$factoryPromise$1(this);
        Class<DeviceControlModel> cls2 = DeviceControlModel.class;
        String name2 = cls2.getName();
        Intrinsics.checkNotNull(name2);
        globalViewStoreOwner.d(this, name2);
        this.g = new CachedViewModelLazy(Reflection.getOrCreateKotlinClass(cls2), new GlobalViewStoreExtKt$cachedViewModels$1(name2), globalViewStoreExtKt$cachedViewModels$factoryPromise$12, new GlobalViewStoreExtKt$cachedViewModels$2((Function0<? extends CreationExtras>) null, this));
        GlobalViewStoreExtKt$cachedViewModels$factoryPromise$1 globalViewStoreExtKt$cachedViewModels$factoryPromise$13 = new GlobalViewStoreExtKt$cachedViewModels$factoryPromise$1(this);
        Class<Ring2ControlViewModel> cls3 = Ring2ControlViewModel.class;
        String name3 = cls3.getName();
        Intrinsics.checkNotNull(name3);
        globalViewStoreOwner.d(this, name3);
        this.h = new CachedViewModelLazy(Reflection.getOrCreateKotlinClass(cls3), new GlobalViewStoreExtKt$cachedViewModels$1(name3), globalViewStoreExtKt$cachedViewModels$factoryPromise$13, new GlobalViewStoreExtKt$cachedViewModels$2((Function0<? extends CreationExtras>) null, this));
        this.i = LazyKt.lazy(MYVUActivity$starryDeviceNameChangeReceiver$2.INSTANCE);
        this.s = -1;
        this.y = LazyKt.lazy(new MYVUActivity$vuGlassesActivity$2(this));
    }

    private final void B1() {
        if (ModelIdExtKt.a(DynamicAdapterUtils.f7879a.a())) {
            boolean e2 = ControlUtils.f7858a.e();
            long currentTimeMillis = System.currentTimeMillis();
            SuperMessageManger.Companion companion = SuperMessageManger.m;
            Long x2 = companion.a().x();
            long longValue = x2 != null ? x2.longValue() : 0;
            Long y2 = companion.a().y();
            long longValue2 = y2 != null ? y2.longValue() : 0;
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("MYVUActivity", "currentTimeMillis is: " + currentTimeMillis + " and sunrise is: " + longValue + " and sunset is: " + longValue2);
            if (e2 && longValue != 0 && longValue2 != 0) {
                if (longValue > currentTimeMillis || currentTimeMillis >= longValue2) {
                    companion.a().s0("sunset");
                } else {
                    companion.a().s0("sunrise");
                }
            }
        }
    }

    public static final void F1(Boolean bool, GlassCheckUpdateState glassCheckUpdateState, MYVUActivity mYVUActivity) {
        Intrinsics.checkNotNullParameter(mYVUActivity, "this$0");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("MYVUActivity", "setupGlassUpdateUI, glassUpdateBadge: " + bool + ", glassCheckUpdateState: " + glassCheckUpdateState);
        Boolean bool2 = Boolean.TRUE;
        if (Intrinsics.areEqual((Object) bool, (Object) bool2) && glassCheckUpdateState != null) {
            if (GenericWindowManger.c.a().s()) {
                delegate.a("MYVUActivity", "setupGlassUpdateUI, windowShowing, return");
                return;
            }
            Pair<BasicGlassInfo, GlassCheckUpdateResult> resultOrNull = GlassCheckUpdateStateKt.getResultOrNull(glassCheckUpdateState);
            if (resultOrNull != null) {
                GlassUpdateInfo a2 = GlassCheckUpdateResultKt.a(resultOrNull.getSecond());
                String str = null;
                Boolean valueOf = a2 != null ? Boolean.valueOf(a2.getExistsUpdate()) : null;
                if (a2 != null) {
                    str = a2.getLatestVersion();
                }
                if (str != null && Intrinsics.areEqual((Object) valueOf, (Object) bool2)) {
                    String serial = resultOrNull.getFirst().getSerial();
                    GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
                    String f1 = glassUpdateHelper.f1(serial, str);
                    boolean Z = glassUpdateHelper.Z(f1);
                    String str2 = mYVUActivity.n;
                    delegate.a("MYVUActivity", "setupGlassUpdateUI, canShowUpdateDialog: " + Z + ", showUpdateDialogVersion: " + str2);
                    if (Z && !Intrinsics.areEqual((Object) mYVUActivity.n, (Object) f1)) {
                        mYVUActivity.n = f1;
                        StaticMethodUtilsKt.A(mYVUActivity, CollectionsKt.arrayListOf(100), false, false);
                        delegate.a("MYVUActivity", "setupGlassUpdateUI, show update dialog");
                    }
                }
            }
        }
    }

    public static /* synthetic */ void L1(MYVUActivity mYVUActivity, String str, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        mYVUActivity.K1(str, z2);
    }

    public static final void Q0(MYVUActivity mYVUActivity, NetDevice netDevice) {
        String str;
        Intrinsics.checkNotNullParameter(mYVUActivity, "this$0");
        Intrinsics.checkNotNullParameter(netDevice, "it");
        ULog.Delegate delegate = ULog.f6446a;
        ConnectState state = netDevice.getState();
        boolean z2 = mYVUActivity.k;
        MainApplication.Companion companion = MainApplication.k;
        String c2 = companion.c();
        boolean z3 = mYVUActivity.p;
        delegate.a("MYVUActivity", "receive device connect state " + state + ",factoryRestFlag=" + z2 + " and connectDeviceID is: " + c2 + " and firstInit is:" + z3);
        ConnectState state2 = netDevice.getState();
        ConnectState connectState = ConnectState.CONNECTED;
        mYVUActivity.v = state2 == connectState;
        mYVUActivity.g1().d(mYVUActivity.v);
        if (mYVUActivity.v) {
            SuperMessageManger.m.a().e0();
        }
        mYVUActivity.Z0().k0(false);
        ConnectState state3 = netDevice.getState();
        ConnectState connectState2 = ConnectState.UNCONNECTED;
        if (state3 == connectState2 && mYVUActivity.k) {
            mYVUActivity.f1().S0();
            mYVUActivity.k = false;
            String str2 = mYVUActivity.j;
            if (str2 != null) {
                boolean X = StaticMethodUtilsKt.X(str2);
                delegate.a("MYVUActivity", "unbound devices ... " + X);
            }
        }
        if (mYVUActivity.p && companion.c() != null) {
            delegate.a("MYVUActivity", "connect state--------------1");
            mYVUActivity.p = false;
        } else if (companion.c() == null && netDevice.getState() == connectState2) {
            delegate.a("MYVUActivity", "connect state--------------2");
        } else {
            if (netDevice.getState() == connectState) {
                delegate.a("MYVUActivity", "connect state--------------3");
                str = netDevice.getMIdentifier();
            } else {
                delegate.a("MYVUActivity", "connect state--------------4");
                str = null;
            }
            companion.l(str);
            if (!netDevice.getFromModifyGlassName() && !mYVUActivity.r) {
                GenericWindowManger.c.a().j(141);
                Application application = mYVUActivity.getApplication();
                Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.upuphone.xr.sapp.MainApplication");
                if (((MainApplication) application).q().size() > 0) {
                    delegate.a("MYVUActivity", "connect state--------------5");
                    Application application2 = mYVUActivity.getApplication();
                    Intrinsics.checkNotNull(application2, "null cannot be cast to non-null type com.upuphone.xr.sapp.MainApplication");
                    StaticMethodUtilsKt.F((Activity) ((MainApplication) application2).q().get(0), CollectionsKt.arrayListOf(141), MapsKt.hashMapOf(TuplesKt.to(141, netDevice)), false, false, 12, (Object) null);
                    if (netDevice.getState() == connectState) {
                        mYVUActivity.B1();
                    }
                } else {
                    delegate.a("MYVUActivity", "connect state--------------6");
                    Application application3 = mYVUActivity.getApplication();
                    Intrinsics.checkNotNull(application3, "null cannot be cast to non-null type com.upuphone.xr.sapp.MainApplication");
                    ((MainApplication) application3).z(netDevice);
                }
            }
            mYVUActivity.r = false;
        }
    }

    public static final void U0(MYVUActivity mYVUActivity) {
        Intrinsics.checkNotNullParameter(mYVUActivity, "this$0");
        BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(mYVUActivity), (CoroutineContext) null, (CoroutineStart) null, new MYVUActivity$checkResumeAccountState$1$1(mYVUActivity, (Continuation<? super MYVUActivity$checkResumeAccountState$1$1>) null), 3, (Object) null).r(new MYVUActivity$checkResumeAccountState$1$2(mYVUActivity));
    }

    /* access modifiers changed from: private */
    public final GlassUpdateViewModel Y0() {
        return (GlassUpdateViewModel) this.e.getValue();
    }

    private final DeviceControlModel Z0() {
        return (DeviceControlModel) this.g.getValue();
    }

    public static final void n1(Map map) {
        Intrinsics.checkNotNullParameter(map, "it");
        UnicronUpdateHelper.b.Q(map);
    }

    public static final void o1(ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(activityResult, "it");
        AppUpdateHelper.f7841a.F();
    }

    public static /* synthetic */ void r1(MYVUActivity mYVUActivity, int i2, Bundle bundle, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bundle = null;
        }
        mYVUActivity.q1(i2, bundle);
    }

    public static final void s1(MYVUActivity mYVUActivity) {
        Intrinsics.checkNotNullParameter(mYVUActivity, "this$0");
        ActivityMyvuBinding activityMyvuBinding = mYVUActivity.d;
        if (activityMyvuBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMyvuBinding = null;
        }
        ConstraintLayout b2 = activityMyvuBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        mYVUActivity.N0(b2);
    }

    public static final void t1() {
        ReceiveLocationEventManager.f6703a.j();
    }

    public static final void v1() {
        LocalSharePreference.b.a().c("international_privacy_out_date");
    }

    public static final void w1() {
        PhoneSappAbility.l(PhoneSappAbility.h.a(), "glass_pp", (String) null, 2, (Object) null);
    }

    private final void z1() {
        f1().w().removeObservers(this);
        LiveData L = Z0().L();
        Observer observer = this.b;
        if (observer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceConnectObserver");
            observer = null;
        }
        L.removeObserver(observer);
        f1().F0().removeObservers(this);
    }

    public final void A1(boolean z2) {
        ActivityMyvuBinding activityMyvuBinding = this.d;
        ActivityMyvuBinding activityMyvuBinding2 = null;
        if (activityMyvuBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMyvuBinding = null;
        }
        FragmentContainerView fragmentContainerView = activityMyvuBinding.b;
        Intrinsics.checkNotNullExpressionValue(fragmentContainerView, "androidNavi");
        boolean z3 = false;
        if ((fragmentContainerView.getVisibility() == 0) != z2) {
            ActivityMyvuBinding activityMyvuBinding3 = this.d;
            if (activityMyvuBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityMyvuBinding3 = null;
            }
            FragmentContainerView fragmentContainerView2 = activityMyvuBinding3.b;
            Intrinsics.checkNotNullExpressionValue(fragmentContainerView2, "androidNavi");
            fragmentContainerView2.setVisibility(z2 ? 0 : 8);
            ActivityMyvuBinding activityMyvuBinding4 = this.d;
            if (activityMyvuBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityMyvuBinding4 = null;
            }
            BlockEventFrameLayout blockEventFrameLayout = activityMyvuBinding4.e;
            ActivityMyvuBinding activityMyvuBinding5 = this.d;
            if (activityMyvuBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityMyvuBinding5 = null;
            }
            FragmentContainerView fragmentContainerView3 = activityMyvuBinding5.b;
            Intrinsics.checkNotNullExpressionValue(fragmentContainerView3, "androidNavi");
            blockEventFrameLayout.setEventEnabled(!(fragmentContainerView3.getVisibility() == 0));
            SuperViewModel f1 = f1();
            ActivityMyvuBinding activityMyvuBinding6 = this.d;
            if (activityMyvuBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityMyvuBinding2 = activityMyvuBinding6;
            }
            FragmentContainerView fragmentContainerView4 = activityMyvuBinding2.b;
            Intrinsics.checkNotNullExpressionValue(fragmentContainerView4, "androidNavi");
            if (fragmentContainerView4.getVisibility() == 0) {
                z3 = true;
            }
            f1.Q0(z3);
        }
    }

    public final void C1(String str) {
        System.out.println("setFactoryResetDev...." + str);
        this.j = str;
    }

    public final void D1(boolean z2) {
        this.k = z2;
    }

    public final void E1(GlassCheckUpdateState glassCheckUpdateState, Boolean bool) {
        D.postDelayed(new f(bool, glassCheckUpdateState, this), 500);
    }

    public final void G1() {
        Z0().n0();
        Z0().I();
    }

    public final void H1() {
        Z0().j0();
    }

    public final void I1() {
        BroadcastReceiver broadcastReceiver = this.o;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
    }

    public final void J1() {
        ContractEntry.f6691a.c(ProtocolType.CATEGORY_PP, MYVUActivity$upgradePolicyCheck$1.INSTANCE);
    }

    public final void K1(String str, boolean z2) {
        String str2 = "AI_MODEL_STATE_" + str;
        if (((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), str2, Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue() && !z2) {
            ULog.f6446a.a("MYVUActivity", "waitForAIState, AI_MODEL_STATE=true, return");
        } else if (!NetworkUtils.f7898a.g()) {
            ULog.f6446a.a("MYVUActivity", "waitForAIState, hasNetwork=false, return");
        } else {
            Job job = this.x;
            if (job == null || !job.isActive()) {
                this.x = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new MYVUActivity$waitForAIState$1(z2, str2, this, (Continuation<? super MYVUActivity$waitForAIState$1>) null), 3, (Object) null);
            } else {
                ULog.f6446a.a("MYVUActivity", "waitForAIState, aiStateJob.isActive=true, return");
            }
        }
    }

    public final int N0(View view) {
        WindowInsetsCompat H = ViewCompat.H(view);
        if (H != null) {
            int abs = Math.abs(H.f(WindowInsetsCompat.Type.d()).d - H.f(WindowInsetsCompat.Type.d()).b);
            f1().Y0(abs);
            SuperGenericWindowView.p.a(abs);
            ULog.f6446a.a("MYVUActivity", "1-getNavigationBarHeight ::height is: " + abs);
            ActivityMyvuBinding activityMyvuBinding = null;
            if (abs == 0) {
                ActivityMyvuBinding activityMyvuBinding2 = this.d;
                if (activityMyvuBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityMyvuBinding = activityMyvuBinding2;
                }
                View view2 = activityMyvuBinding.c;
                Intrinsics.checkNotNullExpressionValue(view2, "bottomView");
                view2.setVisibility(8);
            } else {
                ActivityMyvuBinding activityMyvuBinding3 = this.d;
                if (activityMyvuBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityMyvuBinding3 = null;
                }
                View view3 = activityMyvuBinding3.c;
                Intrinsics.checkNotNullExpressionValue(view3, "bottomView");
                view3.setVisibility(0);
                ActivityMyvuBinding activityMyvuBinding4 = this.d;
                if (activityMyvuBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityMyvuBinding4 = null;
                }
                ViewGroup.LayoutParams layoutParams = activityMyvuBinding4.c.getLayoutParams();
                layoutParams.height = f1().e0();
                ActivityMyvuBinding activityMyvuBinding5 = this.d;
                if (activityMyvuBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityMyvuBinding = activityMyvuBinding5;
                }
                activityMyvuBinding.c.setLayoutParams(layoutParams);
            }
            return abs;
        }
        ULog.f6446a.a("MYVUActivity", "windowInsets is null");
        return 0;
    }

    public void NaviVoiceStateChanged(boolean z2) {
        DataStoreUtils.e.a().p("hearing_assist_navi_status_change", Boolean.TRUE, true);
    }

    public final void O0() {
        Z0().M().observe(this, new MYVUActivity$sam$androidx_lifecycle_Observer$0(new MYVUActivity$addDeviceBoundObserve$1(this)));
    }

    public final void P0() {
        this.b = new e(this);
        LiveData L = Z0().L();
        Observer observer = this.b;
        if (observer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deviceConnectObserver");
            observer = null;
        }
        L.observeForever(observer);
    }

    public final void R0() {
        f1().w().observe(this, new MYVUActivity$sam$androidx_lifecycle_Observer$0(new MYVUActivity$addFactoryObserve$1(this)));
    }

    public final void S0() {
        f1().F0().observe(this, new MYVUActivity$sam$androidx_lifecycle_Observer$0(MYVUActivity$addPolicyStateObserve$1.INSTANCE));
    }

    public final void T0() {
        ActivityMyvuBinding activityMyvuBinding = this.d;
        if (activityMyvuBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMyvuBinding = null;
        }
        activityMyvuBinding.getRoot().postDelayed(new g(this), 500);
    }

    public final void V0(Intent intent) {
        if (intent != null) {
            boolean booleanExtra = intent.getBooleanExtra("open_touchpad", false);
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("MYVUActivity", "openTouchpad is: " + booleanExtra);
            if (booleanExtra) {
                NavDestination navDestination = this.z;
                if (navDestination == null || navDestination.k() != R.id.touchpadFragment) {
                    r1(this, R.id.touchpadFragment, (Bundle) null, 2, (Object) null);
                }
            }
        }
    }

    public final void W0(int i2, int i3, Intent intent) {
        HomeFragment homeFragment;
        ActivityMyvuBinding activityMyvuBinding = this.d;
        if (activityMyvuBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMyvuBinding = null;
        }
        FragmentContainerView fragmentContainerView = activityMyvuBinding.b;
        Intrinsics.checkNotNullExpressionValue(fragmentContainerView, "androidNavi");
        if (fragmentContainerView.getVisibility() != 0 && (homeFragment = this.m) != null) {
            homeFragment.onActivityResult(i2, i3, intent);
        }
    }

    public final void X0() {
        if (!BuildConfig.b.booleanValue()) {
            MainApplication.k.l((String) DataStoreUtils.i(DataStoreUtils.e.a(), "sp_device_connect_history", "null", (Context) null, 4, (Object) null));
        }
        ULog.Delegate delegate = ULog.f6446a;
        MainApplication.Companion companion = MainApplication.k;
        String c2 = companion.c();
        delegate.a("MYVUActivity", "getConnectDeviceWhenStart::MainApplication.connectDeviceID is: " + c2);
        if (Intrinsics.areEqual((Object) companion.c(), (Object) "null")) {
            this.p = false;
        }
    }

    public void a(int i2, int i3) {
        String str;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c("MYVUActivity", "buttonAction  windowType: " + i2 + " actionType=" + i3);
        if (i2 == 100) {
            if (!(((GlassCheckUpdateState) Y0().d().getValue()) == null || (str = this.n) == null)) {
                GlassUpdateHelper.b.E1(str);
            }
            if (i3 == 1101) {
                h1();
            }
        } else if (i2 != 104) {
            if (i2 != 120) {
                if (i2 != 122) {
                    if (i2 != 182) {
                        if (i2 != 186) {
                            if (i2 != 202) {
                                if (i2 != 2014) {
                                    if (i2 != 179) {
                                        if (i2 == 180 && i3 == 1101) {
                                            VersionCheckUtil.f7929a.d("com.upuphone.star.launcher.intl");
                                        }
                                    } else if (i3 == 1101) {
                                        startActivity(new Intent(this, GlassUpdateInfoActivity.class));
                                    }
                                } else if (i3 == 1101) {
                                    delegate.c("MYVUActivity", "WINDOW_TYPE_DEVICE_UNBOUND ACTION_CONFIRM");
                                    ActivityKt.a(this, R.id.android_navi).W(R.id.empty_fragment, false);
                                }
                            } else if (i3 == 1101) {
                                delegate.c("MYVUActivity", " ACTION_CONFIRM  ");
                                Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new MYVUActivity$buttonAction$2((Continuation<? super MYVUActivity$buttonAction$2>) null), 3, (Object) null);
                            } else if (i3 == 1102) {
                                finish();
                            }
                        } else if (i3 != 1101 && i3 == 1102) {
                            AppUpdateHelper.f7841a.t();
                        }
                    } else if (i3 == 1101) {
                        AppUpdateHelper.f7841a.P();
                    }
                } else if (i3 == 1101) {
                    delegate.c("MYVUActivity", "WINDOW_TYPE_DEVICE_UNBOUND ACTION_CONFIRM");
                    ActivityKt.a(this, R.id.android_navi).W(R.id.empty_fragment, false);
                }
            } else if (i3 == 1101) {
                AppUtils.q(AppUtils.f7842a, this, 0, 2, (Object) null);
            }
        } else if (i3 == 1101) {
            h1();
        }
        UnicronUpdateHelper.b.P(i2, i3);
        g1().a(i2, i3);
    }

    public final Ring2ControlViewModel a1() {
        return (Ring2ControlViewModel) this.h.getValue();
    }

    public void attachBaseContext(Context context) {
        AppCompatDelegate delegate = getDelegate();
        Intrinsics.checkNotNull(context);
        super.attachBaseContext(delegate.e(context));
        me.weishu.reflection.Reflection.unseal(context);
    }

    public final void b1(View view) {
        view.addOnAttachStateChangeListener(new MYVUActivity$getNavigationBarHeight$1(this, view));
    }

    public void c(int i2, Object obj) {
        if (i2 == 202) {
            ProtocolType protocolType = obj instanceof ProtocolType ? (ProtocolType) obj : null;
            if (protocolType != null) {
                ULog.Delegate delegate = ULog.f6446a;
                delegate.c("MYVUActivity", "jumpAction WINDOW_TYPE_UPGRADE_PRIVACY_AGREE windowType: " + i2 + " protocolType=" + protocolType);
                ContractEntry.w(ContractEntry.f6691a, this, protocolType, (String) null, 4, (Object) null);
            } else {
                return;
            }
        }
        g1().c(i2, obj);
    }

    public final void c1() {
        if (((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "sp_user_agreement_state", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue()) {
            HttpRequestUtil.f7890a.k();
        }
    }

    public final void d1() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "getDisplayMetrics(...)");
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("MYVUActivity", "width is: " + i2 + " and height is: " + i3);
        f1().X0(i3);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 1) {
            f1().t().setValue(Boolean.TRUE);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final StarryDeviceNameChangeReceiver e1() {
        return (StarryDeviceNameChangeReceiver) this.i.getValue();
    }

    public final SuperViewModel f1() {
        return (SuperViewModel) this.f.getValue();
    }

    public final VuBaseGlassesActivity g1() {
        return (VuBaseGlassesActivity) this.y.getValue();
    }

    public final void h1() {
        ActivityKt.a(this, R.id.android_navi).N(R.id.glassUpdateInfoActivity);
    }

    public final void i1() {
        MzAccountManager.c.b().d().observe(this, new MYVUActivity$sam$androidx_lifecycle_Observer$0(new MYVUActivity$initAccountObserve$1(this)));
    }

    public final void j1() {
        MainApplication.Companion companion = MainApplication.k;
        companion.k(false);
        SuperMessageManger.m.a().W(f1());
        Z0().m0(f1());
        a1().m();
        fitNavigationBar(true);
        fitSystemWindow(true);
        fitStatusBar(true);
        setStatusBarColor(0);
        setNavigationBarColor(getColor(R.color.app_background));
        ActivityMyvuBinding activityMyvuBinding = this.d;
        if (activityMyvuBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMyvuBinding = null;
        }
        ConstraintLayout b2 = activityMyvuBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        b1(b2);
        m1();
        l1();
        d1();
        x1();
        p1();
        X0();
        GenericWindowManger.c.a().h();
        DataStoreUtils.e.a().o("wifi_auto_connect", Boolean.FALSE);
        GlassFileTransferHelper glassFileTransferHelper = GlassFileTransferHelper.f7048a;
        AppUpdateHelper.f7841a.s(this);
        GlassScreenShotHelper.b.v(this);
        GlassCompatHelper glassCompatHelper = GlassCompatHelper.b;
        FastRecordManager.Companion.getInstance().init(companion.f());
        NaviManager.getInstance(getApplicationContext()).setNaviVoiceStateChanged(this);
    }

    public final void k1() {
        R0();
        P0();
        O0();
        S0();
        AssociateUserManager.c.a().e();
    }

    public void l() {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:com.upuphone.star.launcher.intl"));
        ActivityResultLauncher activityResultLauncher = this.w;
        if (activityResultLauncher != null) {
            activityResultLauncher.a(intent);
        }
    }

    public final void l1() {
        AspectHelper.INSTANCE.bindLifecycle(this);
        e1().b(this, Z0());
    }

    public void m(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        ActivityResultLauncher activityResultLauncher = this.u;
        if (activityResultLauncher != null) {
            activityResultLauncher.a(strArr);
        }
    }

    public final void m1() {
        GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
        glassUpdateHelper.X(this);
        UnicronUpdateHelper.b.w(this);
        Y0().d().observe(this, new MYVUActivity$sam$androidx_lifecycle_Observer$0(new MYVUActivity$initGlassUpdate$1(this)));
        glassUpdateHelper.C0().observe(this, new MYVUActivity$sam$androidx_lifecycle_Observer$0(new MYVUActivity$initGlassUpdate$2(this)));
        this.u = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new c());
        this.w = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new d());
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        W0(i2, i3, intent);
        if (i2 == 1001) {
            HuaWeiFeatureParser.b().h(i3, i3, intent);
        } else {
            UnicronUpdateHelper.b.N(i2, i3, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ULog.f6446a.a("MYVUActivity", "onCreate");
        getLifecycle().a(new MYVUActivity$onCreate$1());
        this.c = true;
        OnBackPressedDispatcherKt.b(getOnBackPressedDispatcher(), (LifecycleOwner) null, false, new MYVUActivity$onCreate$2(this), 3, (Object) null);
        StarryNetHelper.f7917a.f();
        ActivityMyvuBinding c2 = ActivityMyvuBinding.c(LayoutInflater.from(this));
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.d = c2;
        ActivityMyvuBinding activityMyvuBinding = null;
        if (c2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c2 = null;
        }
        setContentView((View) c2.getRoot());
        setRequestedOrientation(1);
        getWindow().getDecorView().setBackground((Drawable) null);
        this.p = true;
        this.l = true;
        k1();
        j1();
        y1();
        V0(getIntent());
        ActivityMyvuBinding activityMyvuBinding2 = this.d;
        if (activityMyvuBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMyvuBinding = activityMyvuBinding2;
        }
        FlymeUtils.a(activityMyvuBinding.getRoot(), GlobalExtKt.f());
        if (((Boolean) DataStoreUtils.i(DataStoreUtils.e.a(), "sp_user_agreement_state", Boolean.FALSE, (Context) null, 4, (Object) null)).booleanValue()) {
            HttpRequestUtil.f7890a.k();
            J1();
            i1();
        }
        this.m = new HomeFragment();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        FragmentTransaction s2 = supportFragmentManager.s();
        int i2 = R.id.home_fragment_container;
        HomeFragment homeFragment = this.m;
        Intrinsics.checkNotNull(homeFragment);
        s2.t(i2, homeFragment);
        s2.j();
        Locale locale = getResources().getConfiguration().locale;
        FlutterEngineManager e2 = MainApplication.k.e();
        Intrinsics.checkNotNull(locale);
        e2.f(CollectionsKt.mutableListOf(locale));
        g1().onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
        GlobalWindowDialog.f8235a.a(this);
        ULog.f6446a.a("MYVUActivity", "onDestroy  mainActivity");
        z1();
        I1();
        NavController navController = this.q;
        if (navController != null) {
            navController.f0(this);
        }
        this.q = null;
        f1().Z0((NetDevice) null);
        D.removeCallbacksAndMessages((Object) null);
        NaviManager.getInstance(getApplicationContext()).setNaviVoiceStateChanged((INaviVoiceStateChanged) null);
        g1().onDestroy();
    }

    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        ULog.f6446a.a("MYVUActivity", "onNewIntent");
        V0(intent);
        g1().onNewIntent(intent);
    }

    public void onPause() {
        super.onPause();
        g1().onPause();
    }

    public void onResume() {
        super.onResume();
        StarryNetHelper.f7917a.f();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("MYVUActivity", "onResume  mainActivity");
        T0();
        this.c = false;
        if (!MainApplication.k.h()) {
            this.r = true;
            delegate.a("MYVUActivity", "onResume  mainActivity init");
            SuperMessageManger.m.a().W(f1());
            Z0().i0(f1());
        }
        ActivityMyvuBinding activityMyvuBinding = this.d;
        ActivityMyvuBinding activityMyvuBinding2 = null;
        if (activityMyvuBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMyvuBinding = null;
        }
        activityMyvuBinding.getRoot().postDelayed(new a(this), 500);
        E = true;
        CompatibilityManager.INSTANCE.showVersionDialogWhenResume(this.v);
        g1().onResume();
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (bool.booleanValue()) {
            ActivityMyvuBinding activityMyvuBinding3 = this.d;
            if (activityMyvuBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityMyvuBinding2 = activityMyvuBinding3;
            }
            activityMyvuBinding2.getRoot().postDelayed(new b(), 1000);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        ULog.f6446a.a("MYVUActivity", "onSaveInstanceState");
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        WindowFocusChangeListener windowFocusChangeListener = this.t;
        if (windowFocusChangeListener != null) {
            windowFocusChangeListener.onWindowFocusChanged(z2);
        }
    }

    public final void p1() {
        if (PhoneTypeUtils.f7912a.c()) {
            HuaWeiFeatureParser.b().f(this);
            if (HuaWeiFeatureParser.b().g()) {
                HuaWeiFeatureParser.b().e(this);
            }
        }
    }

    public final void q1(int i2, Bundle bundle) {
        Unit unit;
        NavController navController = this.q;
        if (navController != null) {
            navController.P(i2, bundle, StaticMethodUtilsKt.j());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            ULog.f6446a.a("MYVUActivity", "naviFragment-> navController为空不能跳转");
        }
    }

    public final void u1() {
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        if (bool.booleanValue()) {
            DataStoreUtils.Companion companion = DataStoreUtils.e;
            DataStoreUtils a2 = companion.a();
            Boolean bool2 = Boolean.FALSE;
            if (((Boolean) DataStoreUtils.i(a2, "need_reconnect_device", bool2, (Context) null, 4, (Object) null)).booleanValue()) {
                ULog.f6446a.a("MYVUActivity", "reconnectDeviceByPP::notify reconnect");
                companion.a().o("need_reconnect_device", bool2);
                LocalSharePreference.b.a().b().putBoolean("international_privacy_out_date", false).commit();
                Handler handler = D;
                handler.postDelayed(new h(), 500);
                handler.postDelayed(new i(), 4000);
            }
        }
    }

    public void x(NavController navController, NavDestination navDestination, Bundle bundle) {
        Intrinsics.checkNotNullParameter(navController, "controller");
        Intrinsics.checkNotNullParameter(navDestination, RtspHeaders.Values.DESTINATION);
        ULog.f6446a.a("MYVUActivity", "onDestinationChanged, destination: " + navDestination + ", arguments: " + bundle);
        this.z = navDestination;
        if (navDestination.k() == R.id.empty_fragment) {
            Job job = this.B;
            if (job != null) {
                Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
            }
            ActivityMyvuBinding activityMyvuBinding = this.d;
            if (activityMyvuBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityMyvuBinding = null;
            }
            BlockEventFrameLayout blockEventFrameLayout = activityMyvuBinding.e;
            Intrinsics.checkNotNullExpressionValue(blockEventFrameLayout, "homeFragmentContainer");
            blockEventFrameLayout.setVisibility(0);
            u1();
            Job job2 = this.A;
            if (job2 != null) {
                Job.DefaultImpls.a(job2, (CancellationException) null, 1, (Object) null);
            }
            this.A = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new MYVUActivity$onDestinationChanged$1(this, (Continuation<? super MYVUActivity$onDestinationChanged$1>) null), 3, (Object) null);
        } else {
            Job job3 = this.B;
            if (job3 != null) {
                Job.DefaultImpls.a(job3, (CancellationException) null, 1, (Object) null);
            }
            this.B = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new MYVUActivity$onDestinationChanged$2(this, (Continuation<? super MYVUActivity$onDestinationChanged$2>) null), 3, (Object) null);
            Job job4 = this.A;
            if (job4 != null) {
                Job.DefaultImpls.a(job4, (CancellationException) null, 1, (Object) null);
            }
            A1(true);
        }
        this.s = navDestination.k();
    }

    public final void x1() {
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().o0(R.id.android_navi);
        if (navHostFragment != null) {
            NavController j0 = navHostFragment.j0();
            this.q = j0;
            if (j0 != null) {
                j0.p(this);
            }
            f1().c1(MYVUActivity$registerNaviCallback$1.INSTANCE);
        }
    }

    public final void y1() {
        ULog.f6446a.g("MYVUActivity", "register Network broadcast");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        MYVUActivity$registerNetworkBroadcast$1 mYVUActivity$registerNetworkBroadcast$1 = new MYVUActivity$registerNetworkBroadcast$1(this);
        this.o = mYVUActivity$registerNetworkBroadcast$1;
        Intrinsics.checkNotNull(mYVUActivity$registerNetworkBroadcast$1);
        ContextExtKt.a(this, mYVUActivity$registerNetworkBroadcast$1, intentFilter);
    }
}
