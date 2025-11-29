package com.upuphone.xr.sapp.vm.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import androidx.lifecycle.MutableLiveData;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.honey.account.a9.a;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.view.web.WebJs;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.runasone.constant.Constants;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.SuperAppServiceManager;
import com.upuphone.xr.interconnect.api.OperatorManager;
import com.upuphone.xr.interconnect.entity.StarryNetMessage;
import com.upuphone.xr.interconnect.listener.MessageReceiver;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.common.MzAccountManager;
import com.upuphone.xr.sapp.entity.AdjustmentMode;
import com.upuphone.xr.sapp.entity.GlassFeatureList;
import com.upuphone.xr.sapp.entity.GlassFontSize;
import com.upuphone.xr.sapp.entity.GlassWifiData;
import com.upuphone.xr.sapp.entity.ReportInfo;
import com.upuphone.xr.sapp.entity.ReqGlassBrightnessData;
import com.upuphone.xr.sapp.entity.ReqGlassData;
import com.upuphone.xr.sapp.entity.ReqGlassLogInfo;
import com.upuphone.xr.sapp.entity.ReqGlassWifiData;
import com.upuphone.xr.sapp.entity.ReqGlassWifiStateData;
import com.upuphone.xr.sapp.entity.ReqPolicyData;
import com.upuphone.xr.sapp.entity.ResGlassData;
import com.upuphone.xr.sapp.entity.ResPolicyData;
import com.upuphone.xr.sapp.entity.StabilizationMode;
import com.upuphone.xr.sapp.entity.StandbyWidgetOrderInfo;
import com.upuphone.xr.sapp.entity.SubPolicyData;
import com.upuphone.xr.sapp.entity.UnicronBatteryInfo;
import com.upuphone.xr.sapp.entity.UnicronInfo;
import com.upuphone.xr.sapp.entity.WifiListInfo;
import com.upuphone.xr.sapp.glass.GlassHelper;
import com.upuphone.xr.sapp.guide.model.WifiInfoModel;
import com.upuphone.xr.sapp.guide.model.WifiResultModel;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.unicron.UnicronUpdateHelper;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.DeviceCaptifyHelper;
import com.upuphone.xr.sapp.utils.DynamicAdapterUtils;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.utils.LocalSharePreference;
import com.upuphone.xr.sapp.utils.ModelIdExtKt;
import com.upuphone.xr.sapp.utils.SingleLiveData;
import com.upuphone.xr.sapp.vm.SuperViewModel;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\u0001\u0018\u0000 \u00142\u00020\u0001:\u0006\u0001\u0001\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\u000eJ\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0016\u0010\u000eJ\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u000eJ\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0018\u0010\u000eJ%\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010 \u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190\u001bH\u0002¢\u0006\u0004\b \u0010\u001eJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b!\u0010\u000eJ\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010$J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010$J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b'\u0010\u000eJ\u0017\u0010(\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010$J\u0017\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010$J\u000f\u0010+\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010\u0003J\u0017\u0010,\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b,\u0010\u000eJ\u000f\u0010-\u001a\u00020\u0004H\u0002¢\u0006\u0004\b-\u0010\u0003J\u000f\u0010.\u001a\u00020\u0004H\u0002¢\u0006\u0004\b.\u0010\u0003J\u0015\u00100\u001a\b\u0012\u0004\u0012\u00020/0\u001bH\u0002¢\u0006\u0004\b0\u00101J\u0015\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u000202¢\u0006\u0004\b4\u00105J\u0017\u00108\u001a\u0004\u0018\u0001072\u0006\u00106\u001a\u00020\u0006¢\u0006\u0004\b8\u00109J%\u0010?\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u00062\u0006\u0010<\u001a\u00020;2\u0006\u0010>\u001a\u00020=¢\u0006\u0004\b?\u0010@J\u0015\u0010A\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0006¢\u0006\u0004\bA\u0010$J\u0015\u0010B\u001a\u00020\u00042\u0006\u0010:\u001a\u00020;¢\u0006\u0004\bB\u0010CJ\u0015\u0010E\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u0006¢\u0006\u0004\bE\u0010$J\r\u0010F\u001a\u00020\u0004¢\u0006\u0004\bF\u0010\u0003J\r\u0010G\u001a\u00020\u0004¢\u0006\u0004\bG\u0010\u0003J-\u0010L\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u00062\u0006\u0010J\u001a\u00020\u00062\u0006\u0010K\u001a\u00020\u0006¢\u0006\u0004\bL\u0010MJ\r\u0010N\u001a\u00020\u0004¢\u0006\u0004\bN\u0010\u0003J\r\u0010O\u001a\u00020\u0004¢\u0006\u0004\bO\u0010\u0003J\u0015\u0010Q\u001a\u00020\u00042\u0006\u0010P\u001a\u00020=¢\u0006\u0004\bQ\u0010RJ\u0017\u0010T\u001a\u00020\u00042\b\u0010S\u001a\u0004\u0018\u00010;¢\u0006\u0004\bT\u0010UJ\r\u0010V\u001a\u00020\u0004¢\u0006\u0004\bV\u0010\u0003J\u0015\u0010W\u001a\u00020\u00042\u0006\u0010:\u001a\u00020;¢\u0006\u0004\bW\u0010CJ\u0015\u0010Y\u001a\u00020\u00042\u0006\u0010X\u001a\u00020;¢\u0006\u0004\bY\u0010CJ\r\u0010Z\u001a\u00020\u0004¢\u0006\u0004\bZ\u0010\u0003J\r\u0010[\u001a\u00020\u0004¢\u0006\u0004\b[\u0010\u0003J\r\u0010\\\u001a\u00020\u0004¢\u0006\u0004\b\\\u0010\u0003J\u0015\u0010^\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\u0006¢\u0006\u0004\b^\u0010$J\u0015\u0010`\u001a\u00020\u00042\u0006\u0010_\u001a\u00020\u0006¢\u0006\u0004\b`\u0010$J\r\u0010a\u001a\u00020\u0004¢\u0006\u0004\ba\u0010\u0003J\u001d\u0010d\u001a\u00020\u00042\u0006\u0010b\u001a\u00020=2\u0006\u0010c\u001a\u00020\u0006¢\u0006\u0004\bd\u0010eJ\u0015\u0010f\u001a\u00020\u00042\u0006\u0010b\u001a\u00020=¢\u0006\u0004\bf\u0010RJ\r\u0010g\u001a\u00020\u0004¢\u0006\u0004\bg\u0010\u0003J\r\u0010h\u001a\u00020\u0004¢\u0006\u0004\bh\u0010\u0003J\r\u0010i\u001a\u00020\u0004¢\u0006\u0004\bi\u0010\u0003R\u0014\u0010m\u001a\u00020j8\u0002X\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0014\u0010q\u001a\u00020n8\u0002X\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010t\u001a\u0004\u0018\u0001028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\br\u0010sR\"\u0010z\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010$R&\u0010\u0001\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u0010\u0001R)\u0010\u0001\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0016\n\u0005\b\u0001\u0010|\u001a\u0005\b\u0001\u0010~\"\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0017\u0010\u0001\u001a\u00030\u00018\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0010\u0010\u0001R\u001c\u0010\u0001\u001a\b0\u0001j\u0003`\u00018\u0002X\u0004¢\u0006\u0007\n\u0005\bF\u0010\u0001R\u0018\u0010\u0001\u001a\u00030\u00018\u0016X\u0005¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/upuphone/xr/sapp/vm/internal/SuperMessageManger;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "", "a0", "", "formatStr", "", "A0", "(Ljava/lang/String;)Ljava/lang/Long;", "Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;", "it", "G", "(Lcom/upuphone/xr/interconnect/entity/StarryNetMessage;)V", "msg", "k", "(Ljava/lang/String;)Ljava/lang/String;", "A", "q", "m", "V", "Q", "R", "U", "Lcom/upuphone/xr/sapp/guide/model/WifiInfoModel;", "info", "Ljava/util/ArrayList;", "pairedList", "M", "(Lcom/upuphone/xr/sapp/guide/model/WifiInfoModel;Ljava/util/ArrayList;)V", "unpairList", "S", "I", "data", "H", "(Ljava/lang/String;)V", "K", "O", "N", "j0", "pkg", "Z", "k0", "L", "c0", "F", "Lcom/upuphone/xr/sapp/entity/SubPolicyData$Status;", "v", "()Ljava/util/ArrayList;", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "superViewModel", "W", "(Lcom/upuphone/xr/sapp/vm/SuperViewModel;)V", "message", "Lcom/upuphone/xr/sapp/entity/SubPolicyData;", "w", "(Ljava/lang/String;)Lcom/upuphone/xr/sapp/entity/SubPolicyData;", "value", "", "streamType", "", "needReply", "z0", "(Ljava/lang/String;IZ)V", "n0", "o0", "(I)V", "model", "s0", "l", "r", "ssid", "password", "action", "change", "g0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "D", "E", "toggle", "B0", "(Z)V", "batteryInfo", "l0", "(Ljava/lang/Integer;)V", "n", "u0", "type", "v0", "s", "t", "B", "filePath", "p", "policyType", "Y", "e0", "state", "accountId", "b0", "(ZLjava/lang/String;)V", "X", "m0", "i0", "h0", "Lcom/google/gson/Gson;", "b", "Lcom/google/gson/Gson;", "mGson", "Lcom/upuphone/xr/interconnect/listener/MessageReceiver;", "c", "Lcom/upuphone/xr/interconnect/listener/MessageReceiver;", "mMessageReceiver", "d", "Lcom/upuphone/xr/sapp/vm/SuperViewModel;", "mSuperViewModel", "e", "Ljava/lang/String;", "getMInvalidWifiSsid", "()Ljava/lang/String;", "setMInvalidWifiSsid", "mInvalidWifiSsid", "f", "Ljava/lang/Long;", "x", "()Ljava/lang/Long;", "w0", "(Ljava/lang/Long;)V", "sunRiseTime", "g", "y", "y0", "sunSetTime", "Landroid/os/Handler;", "h", "Landroid/os/Handler;", "mHandler", "i", "activationHandler", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "j", "Lcom/upuphone/xr/interconnect/listener/SendMessageListener;", "mMessageCallback", "com/upuphone/xr/sapp/vm/internal/SuperMessageManger$glassBatteryInfoCallback$1", "Lcom/upuphone/xr/sapp/vm/internal/SuperMessageManger$glassBatteryInfoCallback$1;", "glassBatteryInfoCallback", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Ljava/lang/Runnable;", "activeStateRunnable", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Companion", "SetVolumeData", "VolumeData", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nSuperMessageManger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuperMessageManger.kt\ncom/upuphone/xr/sapp/vm/internal/SuperMessageManger\n+ 2 Runnable.kt\nkotlinx/coroutines/RunnableKt\n+ 3 JsonUtils.kt\ncom/upuphone/xr/sapp/utils/JsonUtils\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1466:1\n17#2:1467\n83#3,2:1468\n1855#4,2:1470\n*S KotlinDebug\n*F\n+ 1 SuperMessageManger.kt\ncom/upuphone/xr/sapp/vm/internal/SuperMessageManger\n*L\n1293#1:1467\n297#1:1468,2\n557#1:1470,2\n*E\n"})
public final class SuperMessageManger implements CoroutineScope {
    public static final Companion m = new Companion((DefaultConstructorMarker) null);
    public static String n = "SuperMessageManger";
    public static final Lazy o = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, SuperMessageManger$Companion$instance$2.INSTANCE);

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f8015a = CoroutineScopeKt.b();
    public final Gson b = new Gson();
    public final MessageReceiver c;
    public SuperViewModel d;
    public String e = "";
    public Long f = 0L;
    public Long g = 0L;
    public Handler h = new Handler(Looper.getMainLooper());
    public Handler i = new Handler(Looper.getMainLooper());
    public SendMessageListener j = new SuperMessageManger$mMessageCallback$1();
    public final SuperMessageManger$glassBatteryInfoCallback$1 k;
    public final Runnable l;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/upuphone/xr/sapp/vm/internal/SuperMessageManger$Companion;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/vm/internal/SuperMessageManger;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/upuphone/xr/sapp/vm/internal/SuperMessageManger;", "instance", "", "RECV_MSG_PKG", "Ljava/lang/String;", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SuperMessageManger a() {
            return (SuperMessageManger) SuperMessageManger.o.getValue();
        }

        public Companion() {
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/upuphone/xr/sapp/vm/internal/SuperMessageManger$SetVolumeData;", "Lcom/upuphone/xr/sapp/entity/ReqGlassData$Data;", "streamType", "", "needReply", "", "(ILjava/lang/Boolean;)V", "getNeedReply", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStreamType", "()I", "component1", "component2", "copy", "(ILjava/lang/Boolean;)Lcom/upuphone/xr/sapp/vm/internal/SuperMessageManger$SetVolumeData;", "equals", "other", "", "hashCode", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SetVolumeData extends ReqGlassData.Data {
        @Nullable
        private final Boolean needReply;
        private final int streamType;

        public SetVolumeData(int i, @Nullable Boolean bool) {
            this.streamType = i;
            this.needReply = bool;
        }

        public static /* synthetic */ SetVolumeData copy$default(SetVolumeData setVolumeData, int i, Boolean bool, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = setVolumeData.streamType;
            }
            if ((i2 & 2) != 0) {
                bool = setVolumeData.needReply;
            }
            return setVolumeData.copy(i, bool);
        }

        public final int component1() {
            return this.streamType;
        }

        @Nullable
        public final Boolean component2() {
            return this.needReply;
        }

        @NotNull
        public final SetVolumeData copy(int i, @Nullable Boolean bool) {
            return new SetVolumeData(i, bool);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SetVolumeData)) {
                return false;
            }
            SetVolumeData setVolumeData = (SetVolumeData) obj;
            return this.streamType == setVolumeData.streamType && Intrinsics.areEqual((Object) this.needReply, (Object) setVolumeData.needReply);
        }

        @Nullable
        public final Boolean getNeedReply() {
            return this.needReply;
        }

        public final int getStreamType() {
            return this.streamType;
        }

        public int hashCode() {
            int hashCode = Integer.hashCode(this.streamType) * 31;
            Boolean bool = this.needReply;
            return hashCode + (bool == null ? 0 : bool.hashCode());
        }

        @NotNull
        public String toString() {
            int i = this.streamType;
            Boolean bool = this.needReply;
            return "SetVolumeData(streamType=" + i + ", needReply=" + bool + ")";
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/upuphone/xr/sapp/vm/internal/SuperMessageManger$VolumeData;", "Lcom/upuphone/xr/sapp/entity/ReqGlassData$Data;", "streamType", "", "(I)V", "getStreamType", "()I", "setStreamType", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class VolumeData extends ReqGlassData.Data {
        private int streamType;

        public VolumeData() {
            this(0, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ VolumeData copy$default(VolumeData volumeData, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = volumeData.streamType;
            }
            return volumeData.copy(i);
        }

        public final int component1() {
            return this.streamType;
        }

        @NotNull
        public final VolumeData copy(int i) {
            return new VolumeData(i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof VolumeData) && this.streamType == ((VolumeData) obj).streamType;
        }

        public final int getStreamType() {
            return this.streamType;
        }

        public int hashCode() {
            return Integer.hashCode(this.streamType);
        }

        public final void setStreamType(int i) {
            this.streamType = i;
        }

        @NotNull
        public String toString() {
            int i = this.streamType;
            return "VolumeData(streamType=" + i + ")";
        }

        public VolumeData(int i) {
            this.streamType = i;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ VolumeData(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 3 : i);
        }
    }

    public SuperMessageManger() {
        SuperMessageManger$glassBatteryInfoCallback$1 superMessageManger$glassBatteryInfoCallback$1 = new SuperMessageManger$glassBatteryInfoCallback$1(this);
        this.k = superMessageManger$glassBatteryInfoCallback$1;
        this.c = new MessageReceiver(this) {
            final /* synthetic */ SuperMessageManger this$0;

            {
                this.this$0 = r1;
            }

            public void onMessageReceive(@Nullable StarryNetMessage starryNetMessage) {
                if (starryNetMessage != null) {
                    SuperMessageManger superMessageManger = this.this$0;
                    ULog.Delegate delegate = ULog.f6446a;
                    String f = SuperMessageManger.n;
                    String message = starryNetMessage.getMessage();
                    SuperViewModel e = superMessageManger.d;
                    delegate.g(f, "onMessageReceive::message is: " + message + " and mMainViewModel is: " + e);
                    try {
                        superMessageManger.G(starryNetMessage);
                    } catch (Exception e2) {
                        ULog.Delegate delegate2 = ULog.f6446a;
                        String f2 = SuperMessageManger.n;
                        String message2 = e2.getMessage();
                        delegate2.c(f2, "handle launcher jason info error: " + message2);
                    }
                }
            }
        };
        Z("com.upuphone.star.launcher");
        GlassHelper.f7049a.m(superMessageManger$glassBatteryInfoCallback$1);
        a0();
        this.l = new SuperMessageManger$special$$inlined$Runnable$1(this);
    }

    public static final void P() {
        LocalSharePreference.b.a().c("international_privacy_out_date");
    }

    public final String A(String str) {
        JsonElement parseString = JsonParser.parseString(str);
        if (!(parseString instanceof JsonObject)) {
            return "";
        }
        JsonObject jsonObject = (JsonObject) parseString;
        if (!jsonObject.has(AccountConstantKt.RESPONSE_VALUE)) {
            return "";
        }
        if (jsonObject.get(AccountConstantKt.RESPONSE_VALUE).isJsonObject()) {
            String jsonElement = jsonObject.get(AccountConstantKt.RESPONSE_VALUE).toString();
            Intrinsics.checkNotNullExpressionValue(jsonElement, "toString(...)");
            return jsonElement;
        }
        String asString = jsonObject.get(AccountConstantKt.RESPONSE_VALUE).getAsString();
        Intrinsics.checkNotNullExpressionValue(asString, "getAsString(...)");
        return asString;
    }

    public final Long A0(String str) {
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
            if (parse != null) {
                return Long.valueOf(parse.getTime());
            }
            return null;
        } catch (Exception e2) {
            ULog.Delegate delegate = ULog.f6446a;
            String str2 = n;
            String message = e2.getMessage();
            delegate.c(str2, "stringDateToStamp error: " + message);
            return null;
        }
    }

    public final void B() {
        ReqGlassData reqGlassData = new ReqGlassData();
        ReqGlassData.Data data = new ReqGlassData.Data();
        data.setAction("get_volume_stream_type");
        reqGlassData.setAction("system");
        reqGlassData.setData(data);
        String json = this.b.toJson((Object) reqGlassData);
        Intrinsics.checkNotNull(json);
        j0(json);
    }

    public final void B0(boolean z) {
        ReqGlassWifiStateData reqGlassWifiStateData = new ReqGlassWifiStateData();
        ReqGlassWifiStateData.Data data = new ReqGlassWifiStateData.Data();
        data.setAction("toggle_wifi");
        data.setValue(z);
        reqGlassWifiStateData.setAction("system");
        reqGlassWifiStateData.setData(data);
        String json = this.b.toJson((Object) reqGlassWifiStateData);
        Intrinsics.checkNotNull(json);
        j0(json);
    }

    public final void D() {
        ReqGlassData reqGlassData = new ReqGlassData();
        ReqGlassData.Data data = new ReqGlassData.Data();
        data.setAction("request_wifi_list");
        reqGlassData.setAction("system");
        reqGlassData.setData(data);
        String json = this.b.toJson((Object) reqGlassData);
        Intrinsics.checkNotNull(json);
        j0(json);
    }

    public final void E() {
        ReqGlassData reqGlassData = new ReqGlassData();
        ReqGlassData.Data data = new ReqGlassData.Data();
        data.setAction("wifi_enable_state");
        reqGlassData.setAction("system");
        reqGlassData.setData(data);
        String json = this.b.toJson((Object) reqGlassData);
        Intrinsics.checkNotNull(json);
        j0(json);
    }

    public final void F() {
        SubPolicyData subPolicyData = new SubPolicyData();
        SubPolicyData.Data data = new SubPolicyData.Data();
        subPolicyData.setAction("system");
        data.setAction("notify_statement_change");
        data.setType("privacy_agreement");
        data.setValue(v());
        subPolicyData.setData(data);
        String json = this.b.toJson((Object) subPolicyData);
        ULog.Delegate delegate = ULog.f6446a;
        String str = n;
        delegate.a(str, "handelPolicyState = " + json);
        Intrinsics.checkNotNull(json);
        j0(json);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Integer} */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v1, types: [androidx.lifecycle.MutableLiveData] */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: type inference failed for: r5v9 */
    /* JADX WARNING: type inference failed for: r5v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void G(com.upuphone.xr.interconnect.entity.StarryNetMessage r12) {
        /*
            r11 = this;
            java.lang.String r0 = r12.getMessage()
            java.lang.String r1 = "getMessage(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r0 = r11.k(r0)
            if (r0 == 0) goto L_0x0592
            int r2 = r0.hashCode()
            java.lang.String r3 = "value"
            java.lang.Class<com.upuphone.xr.sapp.entity.ResGlassData> r4 = com.upuphone.xr.sapp.entity.ResGlassData.class
            r5 = 0
            switch(r2) {
                case -1932804357: goto L_0x056d;
                case -1520509648: goto L_0x0560;
                case -1171059630: goto L_0x053a;
                case -1045474393: goto L_0x04a0;
                case -887328209: goto L_0x0480;
                case -810883302: goto L_0x03f5;
                case -418144039: goto L_0x03bb;
                case -355365575: goto L_0x0342;
                case -214427568: goto L_0x02db;
                case -140950151: goto L_0x028c;
                case -47430062: goto L_0x027a;
                case 172839209: goto L_0x0220;
                case 312945340: goto L_0x01c9;
                case 483362201: goto L_0x01b7;
                case 648162385: goto L_0x016a;
                case 779492240: goto L_0x012b;
                case 791856973: goto L_0x0107;
                case 1137940009: goto L_0x00f8;
                case 1176822412: goto L_0x00d5;
                case 1382381275: goto L_0x00c5;
                case 1400208976: goto L_0x0081;
                case 1400954760: goto L_0x0068;
                case 1408073292: goto L_0x0058;
                case 1588033520: goto L_0x001e;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x0575
        L_0x001e:
            java.lang.String r1 = "callStatus"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0028
            goto L_0x0575
        L_0x0028:
            com.google.gson.Gson r11 = r11.b
            java.lang.String r12 = r12.getMessage()
            java.lang.Class<com.upuphone.xr.sapp.entity.PhoneCallStatus> r0 = com.upuphone.xr.sapp.entity.PhoneCallStatus.class
            java.lang.Object r11 = r11.fromJson((java.lang.String) r12, r0)
            com.upuphone.xr.sapp.entity.PhoneCallStatus r11 = (com.upuphone.xr.sapp.entity.PhoneCallStatus) r11
            com.upuphone.star.core.log.ULog$Delegate r12 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r0 = n
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "PhoneCallStatus="
            r1.append(r2)
            r1.append(r11)
            java.lang.String r1 = r1.toString()
            r12.a(r0, r1)
            com.upuphone.xr.sapp.utils.PhoneCallStatusHelper r12 = com.upuphone.xr.sapp.utils.PhoneCallStatusHelper.f7909a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            r12.b(r11)
            goto L_0x0595
        L_0x0058:
            java.lang.String r1 = "unicron_battery"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0063
            goto L_0x0575
        L_0x0063:
            r11.Q(r12)
            goto L_0x0595
        L_0x0068:
            java.lang.String r1 = "wifi_list"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0073
            goto L_0x0575
        L_0x0073:
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r1 = n
            java.lang.String r2 = "ACTION_WIFI_LIST in"
            r0.a(r1, r2)
            r11.U(r12)
            goto L_0x0595
        L_0x0081:
            java.lang.String r2 = "show_version_no_match"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x008b
            goto L_0x0575
        L_0x008b:
            java.lang.String r12 = r12.getMessage()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r1)
            java.lang.String r12 = r11.A(r12)
            com.google.gson.Gson r11 = r11.b     // Catch:{ Exception -> 0x00aa }
            java.lang.Class<com.upuphone.xr.sapp.glass.CompatibilityManager$ConsultResult> r0 = com.upuphone.xr.sapp.glass.CompatibilityManager.ConsultResult.class
            java.lang.Object r11 = r11.fromJson((java.lang.String) r12, r0)     // Catch:{ Exception -> 0x00aa }
            com.upuphone.xr.sapp.glass.CompatibilityManager$ConsultResult r11 = (com.upuphone.xr.sapp.glass.CompatibilityManager.ConsultResult) r11     // Catch:{ Exception -> 0x00aa }
            com.upuphone.xr.sapp.glass.CompatibilityManager r0 = com.upuphone.xr.sapp.glass.CompatibilityManager.INSTANCE     // Catch:{ Exception -> 0x00aa }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)     // Catch:{ Exception -> 0x00aa }
            r0.showIncompatibleDialog(r11)     // Catch:{ Exception -> 0x00aa }
            goto L_0x0595
        L_0x00aa:
            r11 = move-exception
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r1 = n
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "error value parse failed:"
            r2.append(r3)
            r2.append(r12)
            java.lang.String r12 = r2.toString()
            r0.d(r1, r12, r11)
            goto L_0x0595
        L_0x00c5:
            java.lang.String r1 = "unicron_ota"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x00d0
            goto L_0x0575
        L_0x00d0:
            r11.R(r12)
            goto L_0x0595
        L_0x00d5:
            java.lang.String r12 = "request_phone_battery"
            boolean r12 = r0.equals(r12)
            if (r12 != 0) goto L_0x00df
            goto L_0x0575
        L_0x00df:
            com.upuphone.xr.sapp.utils.BatteryUtils$Companion r12 = com.upuphone.xr.sapp.utils.BatteryUtils.b
            com.upuphone.xr.sapp.utils.BatteryUtils r12 = r12.a()
            com.upuphone.xr.sapp.entity.BatteryInfo r12 = r12.b()
            if (r12 == 0) goto L_0x00f3
            int r12 = r12.getBatteryCapacity()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r12)
        L_0x00f3:
            r11.l0(r5)
            goto L_0x0595
        L_0x00f8:
            java.lang.String r1 = "res_wifi_state_change"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0102
            goto L_0x0575
        L_0x0102:
            r11.V(r12)
            goto L_0x0595
        L_0x0107:
            java.lang.String r2 = "AIR_FUNCTION"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x0111
            goto L_0x0575
        L_0x0111:
            com.upuphone.xr.sapp.vm.SuperViewModel r0 = r11.d
            if (r0 == 0) goto L_0x0595
            com.upuphone.xr.sapp.monitor.air.AirFunctionHelper r0 = r0.l()
            if (r0 == 0) goto L_0x0595
            java.lang.String r12 = r12.getMessage()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r1)
            java.lang.String r11 = r11.A(r12)
            r0.a(r11)
            goto L_0x0595
        L_0x012b:
            java.lang.String r1 = "audio_multi"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0135
            goto L_0x0575
        L_0x0135:
            com.google.gson.Gson r11 = r11.b
            java.lang.String r0 = r12.getMessage()
            java.lang.Class<com.upuphone.xr.sapp.entity.AudioMulti> r1 = com.upuphone.xr.sapp.entity.AudioMulti.class
            java.lang.Object r11 = r11.fromJson((java.lang.String) r0, r1)
            com.upuphone.xr.sapp.entity.AudioMulti r11 = (com.upuphone.xr.sapp.entity.AudioMulti) r11
            com.upuphone.xr.sapp.entity.AudioMulti r0 = new com.upuphone.xr.sapp.entity.AudioMulti
            java.lang.String r1 = r11.getAction()
            com.upuphone.xr.sapp.context.IAudioMulti$Data r11 = r11.getData()
            byte[] r12 = r12.getData()
            java.lang.String r2 = "getData(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r2)
            int r2 = r12.length
            byte[] r12 = java.util.Arrays.copyOf(r12, r2)
            java.lang.String r2 = "copyOf(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r2)
            r0.<init>(r1, r11, r12)
            com.upuphone.xr.sapp.utils.AudioMultiHelper r11 = com.upuphone.xr.sapp.utils.AudioMultiHelper.f7846a
            r11.c(r0)
            goto L_0x0595
        L_0x016a:
            java.lang.String r1 = "brightness"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0174
            goto L_0x0575
        L_0x0174:
            com.google.gson.Gson r0 = r11.b
            java.lang.String r12 = r12.getMessage()
            java.lang.Object r12 = r0.fromJson((java.lang.String) r12, r4)
            com.upuphone.xr.sapp.entity.ResGlassData r12 = (com.upuphone.xr.sapp.entity.ResGlassData) r12
            com.upuphone.xr.sapp.vm.SuperViewModel r0 = r11.d
            if (r0 == 0) goto L_0x018d
            androidx.lifecycle.MutableLiveData r0 = r0.z0()
            if (r0 == 0) goto L_0x018d
            r0.postValue(r12)
        L_0x018d:
            com.upuphone.xr.sapp.vm.SuperViewModel r11 = r11.d
            if (r11 == 0) goto L_0x01a6
            androidx.lifecycle.MutableLiveData r11 = r11.y0()
            if (r11 == 0) goto L_0x01a6
            java.lang.String r0 = r12.getValue()
            int r0 = java.lang.Integer.parseInt(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r11.postValue(r0)
        L_0x01a6:
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r11 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r11 = r11.a()
            java.lang.String r0 = "brightness_store"
            java.lang.String r12 = r12.getValue()
            r11.o(r0, r12)
            goto L_0x0595
        L_0x01b7:
            java.lang.String r11 = "syncSport"
            boolean r11 = r0.equals(r11)
            if (r11 != 0) goto L_0x01c2
            goto L_0x0575
        L_0x01c2:
            com.upuphone.xr.sapp.monitor.sport.SportMonitor r11 = com.upuphone.xr.sapp.monitor.sport.SportMonitor.f7796a
            r11.e()
            goto L_0x0595
        L_0x01c9:
            java.lang.String r2 = "event_tracking"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x01d3
            goto L_0x0575
        L_0x01d3:
            java.lang.String r12 = r12.getMessage()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r1)
            java.lang.String r12 = r11.m(r12)
            if (r12 == 0) goto L_0x0595
            java.lang.String r11 = r11.q(r12)     // Catch:{ Exception -> 0x0205 }
            com.upuphone.xr.sapp.utils.JsonUtils r12 = com.upuphone.xr.sapp.utils.JsonUtils.f7893a     // Catch:{ Exception -> 0x0205 }
            com.upuphone.xr.sapp.vm.internal.SuperMessageManger$handleCommonMsg$lambda$0$$inlined$fromJsonList$1 r0 = new com.upuphone.xr.sapp.vm.internal.SuperMessageManger$handleCommonMsg$lambda$0$$inlined$fromJsonList$1     // Catch:{ Exception -> 0x0205 }
            r0.<init>()     // Catch:{ Exception -> 0x0205 }
            java.lang.reflect.Type r0 = r0.getType()     // Catch:{ Exception -> 0x0205 }
            com.google.gson.Gson r12 = r12.c()     // Catch:{ Exception -> 0x0205 }
            java.lang.Object r11 = r12.fromJson((java.lang.String) r11, (java.lang.reflect.Type) r0)     // Catch:{ Exception -> 0x0205 }
            java.lang.String r12 = "fromJson(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)     // Catch:{ Exception -> 0x0205 }
            java.util.List r11 = (java.util.List) r11     // Catch:{ Exception -> 0x0205 }
            com.upuphone.xr.sapp.datatrack.GlassEventReporter r12 = com.upuphone.xr.sapp.datatrack.GlassEventReporter.f6918a     // Catch:{ Exception -> 0x0205 }
            r12.a(r11)     // Catch:{ Exception -> 0x0205 }
            goto L_0x0595
        L_0x0205:
            r11 = move-exception
            com.upuphone.star.core.log.ULog$Delegate r12 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r0 = n
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "EVENT_TRACKING, error: "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            r12.c(r0, r11)
            goto L_0x0595
        L_0x0220:
            java.lang.String r1 = "glass_active"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x022a
            goto L_0x0575
        L_0x022a:
            com.google.gson.Gson r0 = r11.b
            java.lang.String r12 = r12.getMessage()
            java.lang.Object r12 = r0.fromJson((java.lang.String) r12, r4)
            com.upuphone.xr.sapp.entity.ResGlassData r12 = (com.upuphone.xr.sapp.entity.ResGlassData) r12
            com.google.gson.Gson r11 = r11.b
            java.lang.String r0 = r12.getValue()
            java.lang.Class<com.upuphone.xr.sapp.entity.GlassActiveData> r1 = com.upuphone.xr.sapp.entity.GlassActiveData.class
            java.lang.Object r11 = r11.fromJson((java.lang.String) r0, r1)
            com.upuphone.xr.sapp.entity.GlassActiveData r11 = (com.upuphone.xr.sapp.entity.GlassActiveData) r11
            com.upuphone.xr.sapp.utils.NpsUtils r0 = com.upuphone.xr.sapp.utils.NpsUtils.b()
            long r1 = r11.getTimestamp()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r11 = r11.getModel()
            r0.g(r1, r11)
            java.lang.Boolean r11 = com.upuphone.xr.sapp.BuildConfig.f6575a
            java.lang.String r0 = "COUNTRY_INTL"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x026f
            com.upuphone.xr.sapp.utils.DataTrackUtil r11 = com.upuphone.xr.sapp.utils.DataTrackUtil.f7875a
            java.lang.String r12 = r12.getValue()
            r11.u(r12)
            goto L_0x0595
        L_0x026f:
            com.upuphone.xr.sapp.utils.DataTrackUtil r11 = com.upuphone.xr.sapp.utils.DataTrackUtil.f7875a
            java.lang.String r12 = r12.getValue()
            r11.s(r12)
            goto L_0x0595
        L_0x027a:
            java.lang.String r11 = "syncSchedule"
            boolean r11 = r0.equals(r11)
            if (r11 != 0) goto L_0x0285
            goto L_0x0575
        L_0x0285:
            com.upuphone.xr.sapp.monitor.schedule.calendar.CalendarScheduleProvider r11 = com.upuphone.xr.sapp.monitor.schedule.calendar.CalendarScheduleProvider.f7784a
            r11.c()
            goto L_0x0595
        L_0x028c:
            java.lang.String r1 = "user_feedback"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0297
            goto L_0x0575
        L_0x0297:
            com.google.gson.Gson r0 = r11.b
            java.lang.String r12 = r12.getMessage()
            java.lang.Class<com.upuphone.xr.sapp.entity.ReqGlassLogInfo> r1 = com.upuphone.xr.sapp.entity.ReqGlassLogInfo.class
            java.lang.Object r12 = r0.fromJson((java.lang.String) r12, r1)
            com.upuphone.xr.sapp.entity.ReqGlassLogInfo r12 = (com.upuphone.xr.sapp.entity.ReqGlassLogInfo) r12
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r1 = n
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "ACTION_USER_FEEDBACK in logReq is: "
            r2.append(r3)
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            r0.a(r1, r2)
            com.upuphone.xr.sapp.entity.ReqGlassLogInfo$Data r12 = r12.getData()
            java.lang.String r12 = r12.getAction()
            java.lang.String r1 = "need_send_glass_log"
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r1)
            if (r12 == 0) goto L_0x0595
            java.lang.String r12 = n
            java.lang.String r1 = "ACTION_USER_FEEDBACK in send req"
            r0.a(r12, r1)
            java.lang.String r12 = "/data/data/com.upuphone.star.launcher.intl/files/ulog/"
            r11.p(r12)
            goto L_0x0595
        L_0x02db:
            java.lang.String r1 = "get_user_feedback"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x02e5
            goto L_0x0575
        L_0x02e5:
            com.google.gson.Gson r0 = r11.b
            java.lang.String r12 = r12.getMessage()
            java.lang.Class<com.upuphone.xr.sapp.entity.ResGlassLogInfo> r1 = com.upuphone.xr.sapp.entity.ResGlassLogInfo.class
            java.lang.Object r12 = r0.fromJson((java.lang.String) r12, r1)
            com.upuphone.xr.sapp.entity.ResGlassLogInfo r12 = (com.upuphone.xr.sapp.entity.ResGlassLogInfo) r12
            com.google.gson.Gson r11 = r11.b
            java.lang.String r0 = r12.getValue()
            java.lang.Class<com.upuphone.xr.sapp.entity.GlassLogTaskInfo> r1 = com.upuphone.xr.sapp.entity.GlassLogTaskInfo.class
            java.lang.Object r11 = r11.fromJson((java.lang.String) r0, r1)
            com.upuphone.xr.sapp.entity.GlassLogTaskInfo r11 = (com.upuphone.xr.sapp.entity.GlassLogTaskInfo) r11
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r1 = n
            java.lang.String r2 = r11.getTaskId()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "ACTION_GET_USER_FEEDBACK in logInfo is: "
            r3.append(r4)
            r3.append(r12)
            java.lang.String r12 = " and task id: "
            r3.append(r12)
            r3.append(r2)
            java.lang.String r12 = r3.toString()
            r0.a(r1, r12)
            java.lang.String r12 = r11.getTaskId()
            int r12 = r12.length()
            if (r12 <= 0) goto L_0x0595
            com.upuphone.xr.sapp.glass.GlassLogUpdateHelper$Companion r12 = com.upuphone.xr.sapp.glass.GlassLogUpdateHelper.e
            com.upuphone.xr.sapp.glass.GlassLogUpdateHelper r12 = r12.a()
            java.lang.String r0 = r11.getTaskId()
            int r11 = r11.getErrorCode()
            r12.h(r0, r11)
            goto L_0x0595
        L_0x0342:
            java.lang.String r1 = "system_glass_active"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x034d
            goto L_0x0575
        L_0x034d:
            com.google.gson.Gson r0 = r11.b
            java.lang.String r12 = r12.getMessage()
            java.lang.Class<com.upuphone.xr.sapp.entity.ReportInfo> r1 = com.upuphone.xr.sapp.entity.ReportInfo.class
            java.lang.Object r12 = r0.fromJson((java.lang.String) r12, r1)
            com.upuphone.xr.sapp.entity.ReportInfo r12 = (com.upuphone.xr.sapp.entity.ReportInfo) r12
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r1 = n
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "ACTION_GLASS_ACTIVE in activeState is: "
            r2.append(r3)
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            r0.a(r1, r2)
            com.upuphone.xr.sapp.entity.ReportInfo$Data r1 = r12.getData()
            java.lang.String r1 = r1.getAction()
            java.lang.String r2 = "req_active_state"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0595
            com.upuphone.xr.sapp.entity.ReportInfo$Data r1 = r12.getData()
            boolean r1 = r1.getValue()
            if (r1 != 0) goto L_0x0399
            java.lang.String r12 = n
            java.lang.String r1 = "ACTION_GLASS_ACTIVE req info"
            r0.a(r12, r1)
            r11.c0()
            goto L_0x0595
        L_0x0399:
            java.lang.String r11 = n
            java.lang.String r1 = "ACTION_GLASS_ACTIVE requestNpsExist"
            r0.a(r11, r1)
            com.upuphone.xr.sapp.utils.ControlUtils r11 = com.upuphone.xr.sapp.utils.ControlUtils.f7858a
            com.upuphone.xr.sapp.entity.DeviceInfo r11 = r11.g()
            com.upuphone.xr.sapp.utils.NpsUtils r0 = com.upuphone.xr.sapp.utils.NpsUtils.b()
            com.upuphone.xr.sapp.entity.ReportInfo$Data r12 = r12.getData()
            java.lang.String r12 = r12.getActive_time()
            java.lang.String r11 = r11.getModel()
            r0.g(r12, r11)
            goto L_0x0595
        L_0x03bb:
            java.lang.String r12 = "syncWeather"
            boolean r12 = r0.equals(r12)
            if (r12 != 0) goto L_0x03c6
            goto L_0x0575
        L_0x03c6:
            com.upuphone.star.core.log.ULog$Delegate r12 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r0 = n
            com.upuphone.xr.sapp.vm.SuperViewModel r1 = r11.d
            if (r1 == 0) goto L_0x03d2
            kotlin.jvm.functions.Function0 r5 = r1.N0()
        L_0x03d2:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "SYNC_WEATHER in call:"
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r12.a(r0, r1)
            com.upuphone.xr.sapp.vm.SuperViewModel r11 = r11.d
            if (r11 == 0) goto L_0x0595
            kotlin.jvm.functions.Function0 r11 = r11.N0()
            if (r11 == 0) goto L_0x0595
            r11.invoke()
            goto L_0x0595
        L_0x03f5:
            java.lang.String r1 = "volume"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0400
            goto L_0x0575
        L_0x0400:
            com.google.gson.Gson r0 = r11.b
            java.lang.String r1 = r12.getMessage()
            java.lang.Class<com.upuphone.xr.sapp.audio.ResVolumeData> r2 = com.upuphone.xr.sapp.audio.ResVolumeData.class
            java.lang.Object r0 = r0.fromJson((java.lang.String) r1, r2)
            com.upuphone.xr.sapp.audio.ResVolumeData r0 = (com.upuphone.xr.sapp.audio.ResVolumeData) r0
            long r1 = java.lang.System.currentTimeMillis()
            r0.setTime(r1)
            org.json.JSONObject r0 = new org.json.JSONObject
            java.lang.String r12 = r12.getMessage()
            r0.<init>(r12)
            java.lang.String r12 = "streamType"
            r1 = 3
            int r12 = r0.optInt(r12, r1)
            com.upuphone.xr.sapp.audio.GlassVolInfo r1 = new com.upuphone.xr.sapp.audio.GlassVolInfo
            r9 = 15
            r10 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r4 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r1.setStreamType(r12)
            java.lang.String r12 = "max"
            r2 = 15
            int r12 = r0.optInt(r12, r2)
            r1.setMax(r12)
            java.lang.String r12 = "min"
            r2 = 0
            int r12 = r0.optInt(r12, r2)
            r1.setMin(r12)
            int r12 = r0.optInt(r3)
            r1.setCurrent(r12)
            com.upuphone.xr.sapp.vm.SuperViewModel r11 = r11.d
            if (r11 == 0) goto L_0x045f
            androidx.lifecycle.MutableLiveData r11 = r11.Z()
            if (r11 == 0) goto L_0x045f
            r11.postValue(r1)
        L_0x045f:
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r11 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r11 = r11.a()
            com.upuphone.xr.sapp.utils.JsonUtils r12 = com.upuphone.xr.sapp.utils.JsonUtils.f7893a
            java.lang.String r12 = r12.d(r1)
            java.lang.String r0 = "volume_info_store"
            r11.o(r0, r12)
            com.upuphone.xr.sapp.context.SdkContext r11 = com.upuphone.xr.sapp.context.SdkContext.f6675a
            com.upuphone.xr.sapp.context.GlassContext r11 = r11.e()
            int r12 = r1.getCurrent()
            r11.f(r12)
            goto L_0x0595
        L_0x0480:
            java.lang.String r2 = "system"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x048b
            goto L_0x0575
        L_0x048b:
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r2 = n
            java.lang.String r3 = "deal MESSAGE_FUNCTION_LAUNCHER type"
            r0.a(r2, r3)
            java.lang.String r12 = r12.getMessage()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r1)
            r11.H(r12)
            goto L_0x0595
        L_0x04a0:
            java.lang.String r1 = "sync_glass_battery_info"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x04ab
            goto L_0x0575
        L_0x04ab:
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r1 = n
            java.lang.String r2 = "SYNC_GLASS_BATTERY_INFO"
            r0.a(r1, r2)
            java.lang.String r12 = r12.getMessage()     // Catch:{ Exception -> 0x0516 }
            com.google.gson.JsonElement r12 = com.google.gson.JsonParser.parseString(r12)     // Catch:{ Exception -> 0x0516 }
            boolean r1 = r12 instanceof com.google.gson.JsonObject     // Catch:{ Exception -> 0x0516 }
            if (r1 == 0) goto L_0x0595
            com.google.gson.JsonObject r12 = (com.google.gson.JsonObject) r12     // Catch:{ Exception -> 0x0516 }
            com.google.gson.JsonElement r12 = r12.get(r3)     // Catch:{ Exception -> 0x0516 }
            java.lang.String r12 = r12.getAsString()     // Catch:{ Exception -> 0x0516 }
            java.lang.String r1 = n     // Catch:{ Exception -> 0x0516 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0516 }
            r2.<init>()     // Catch:{ Exception -> 0x0516 }
            java.lang.String r3 = "asJsonObject: "
            r2.append(r3)     // Catch:{ Exception -> 0x0516 }
            r2.append(r12)     // Catch:{ Exception -> 0x0516 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0516 }
            r0.g(r1, r2)     // Catch:{ Exception -> 0x0516 }
            com.google.gson.Gson r1 = r11.b     // Catch:{ Exception -> 0x0516 }
            java.lang.Class<com.upuphone.xr.sapp.entity.GlassBatteryInfo> r2 = com.upuphone.xr.sapp.entity.GlassBatteryInfo.class
            java.lang.Object r12 = r1.fromJson((java.lang.String) r12, r2)     // Catch:{ Exception -> 0x0516 }
            com.upuphone.xr.sapp.entity.GlassBatteryInfo r12 = (com.upuphone.xr.sapp.entity.GlassBatteryInfo) r12     // Catch:{ Exception -> 0x0516 }
            java.lang.String r1 = n     // Catch:{ Exception -> 0x0516 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0516 }
            r2.<init>()     // Catch:{ Exception -> 0x0516 }
            java.lang.String r3 = "glassInfo: "
            r2.append(r3)     // Catch:{ Exception -> 0x0516 }
            r2.append(r12)     // Catch:{ Exception -> 0x0516 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0516 }
            r0.g(r1, r2)     // Catch:{ Exception -> 0x0516 }
            com.upuphone.xr.sapp.entity.GlassBatteryInfo r0 = new com.upuphone.xr.sapp.entity.GlassBatteryInfo     // Catch:{ Exception -> 0x0516 }
            int r1 = r12.getBattery()     // Catch:{ Exception -> 0x0516 }
            boolean r12 = r12.isCharging()     // Catch:{ Exception -> 0x0516 }
            r0.<init>(r1, r12)     // Catch:{ Exception -> 0x0516 }
            com.upuphone.xr.sapp.vm.SuperViewModel r11 = r11.d     // Catch:{ Exception -> 0x0516 }
            if (r11 == 0) goto L_0x0518
            androidx.lifecycle.MutableLiveData r5 = r11.n0()     // Catch:{ Exception -> 0x0516 }
            goto L_0x0518
        L_0x0516:
            r11 = move-exception
            goto L_0x0521
        L_0x0518:
            if (r5 != 0) goto L_0x051c
            goto L_0x0595
        L_0x051c:
            r5.setValue(r0)     // Catch:{ Exception -> 0x0516 }
            goto L_0x0595
        L_0x0521:
            com.upuphone.star.core.log.ULog$Delegate r12 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r0 = n
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "SYNC_GLASS_BATTERY_INFO::e : "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            r12.o(r0, r11)
            goto L_0x0595
        L_0x053a:
            java.lang.String r1 = "wearState"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0544
            goto L_0x0575
        L_0x0544:
            com.google.gson.Gson r11 = r11.b
            java.lang.String r12 = r12.getMessage()
            java.lang.Object r11 = r11.fromJson((java.lang.String) r12, r4)
            com.upuphone.xr.sapp.entity.ResGlassData r11 = (com.upuphone.xr.sapp.entity.ResGlassData) r11
            java.lang.String r12 = "1"
            java.lang.String r11 = r11.getValue()
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r11)
            com.upuphone.xr.sapp.monitor.GlassWearStateMonitor r12 = com.upuphone.xr.sapp.monitor.GlassWearStateMonitor.f7735a
            r12.c(r11)
            goto L_0x0595
        L_0x0560:
            java.lang.String r1 = "open_app_failed"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0569
            goto L_0x0575
        L_0x0569:
            r11.L(r12)
            goto L_0x0595
        L_0x056d:
            java.lang.String r12 = "SyncOffSetTime"
            boolean r12 = r0.equals(r12)
            if (r12 != 0) goto L_0x058e
        L_0x0575:
            com.upuphone.star.core.log.ULog$Delegate r11 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r12 = n
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "error action:"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r11.c(r12, r0)
            goto L_0x0595
        L_0x058e:
            r11.k0()
            goto L_0x0595
        L_0x0592:
            r11.N(r12)
        L_0x0595:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vm.internal.SuperMessageManger.G(com.upuphone.xr.interconnect.entity.StarryNetMessage):void");
    }

    public final void H(String str) {
        MutableLiveData U;
        MutableLiveData i0;
        MutableLiveData V;
        MutableLiveData Y;
        MutableLiveData Q;
        MutableLiveData b0;
        MutableLiveData a0;
        MutableLiveData S;
        String m2 = m(str);
        String k2 = m2 != null ? k(m2) : null;
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(n, "handleGlassSystemInfo::action:system businessAction:" + k2 + " full message is: " + str + "\n businessData=" + m2 + "\n businessAction=" + k2);
        if (k2 != null) {
            switch (k2.hashCode()) {
                case -2102414714:
                    if (k2.equals("get_app_fast_open")) {
                        String A = A(m2);
                        SuperViewModel superViewModel = this.d;
                        if (superViewModel != null && (U = superViewModel.U()) != null) {
                            U.postValue(A);
                            return;
                        }
                        return;
                    }
                    break;
                case -1966763915:
                    if (k2.equals("get_glass_sound_effect_mode")) {
                        Boolean booleanStrictOrNull = StringsKt.toBooleanStrictOrNull(A(m2));
                        SuperViewModel superViewModel2 = this.d;
                        if (superViewModel2 != null && (i0 = superViewModel2.i0()) != null) {
                            i0.postValue(booleanStrictOrNull);
                            return;
                        }
                        return;
                    }
                    break;
                case -1025239574:
                    if (k2.equals("get_font_mode")) {
                        Integer intOrNull = StringsKt.toIntOrNull(A(m2));
                        if (intOrNull != null) {
                            int intValue = intOrNull.intValue();
                            SuperViewModel superViewModel3 = this.d;
                            if (superViewModel3 != null && (V = superViewModel3.V()) != null) {
                                V.postValue(intValue == 1 ? GlassFontSize.NORMAL : GlassFontSize.BIG);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    break;
                case -869682315:
                    if (k2.equals("get_standby_widget_lists")) {
                        StandbyWidgetOrderInfo standbyWidgetOrderInfo = (StandbyWidgetOrderInfo) this.b.fromJson(m2, StandbyWidgetOrderInfo.class);
                        delegate.a(n, "StandbyWidgetOrderInfo=" + standbyWidgetOrderInfo);
                        SuperViewModel superViewModel4 = this.d;
                        if (superViewModel4 != null && (Y = superViewModel4.Y()) != null) {
                            Y.postValue(standbyWidgetOrderInfo.getValue().getWidgets());
                            return;
                        }
                        return;
                    }
                    break;
                case -591076352:
                    if (k2.equals(AccountConstantKt.REQUEST_PARAM_DEVICE_MODEL)) {
                        try {
                            String valueOf = String.valueOf(((HashMap) new Gson().fromJson(m2, new SuperMessageManger$handleGlassSystemInfo$businessDataMap$1().getType())).get(Constants.DEVICE_ID));
                            Locale locale = Locale.getDefault();
                            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                            String lowerCase = valueOf.toLowerCase(locale);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            Boolean bool = Boolean.TRUE;
                            DataStoreUtils.e.a().p("captify_KEY_" + lowerCase, bool, true);
                            DeviceCaptifyHelper.f7877a.c().setValue(bool);
                            return;
                        } catch (Exception e2) {
                            ULog.f6446a.a(n, "device_model deal error:" + e2);
                            return;
                        }
                    }
                    break;
                case 318934954:
                    if (k2.equals("notify_statement_change_response")) {
                        K(str);
                        return;
                    }
                    break;
                case 589390730:
                    if (k2.equals("get_auto_brightness_mode")) {
                        Boolean booleanStrictOrNull2 = StringsKt.toBooleanStrictOrNull(A(m2));
                        SuperViewModel superViewModel5 = this.d;
                        if (superViewModel5 != null && (Q = superViewModel5.Q()) != null) {
                            Q.postValue(booleanStrictOrNull2);
                            return;
                        }
                        return;
                    }
                    break;
                case 1015917104:
                    if (k2.equals("get_image_stabilization_mode")) {
                        StabilizationMode stabilizationMode = (StabilizationMode) new Gson().fromJson(A(m2), StabilizationMode.class);
                        SuperViewModel superViewModel6 = this.d;
                        if (superViewModel6 != null && (b0 = superViewModel6.b0()) != null) {
                            b0.postValue(stabilizationMode);
                            return;
                        }
                        return;
                    }
                    break;
                case 1102337576:
                    if (k2.equals("get_image_adjustment_mode")) {
                        AdjustmentMode adjustmentMode = (AdjustmentMode) new Gson().fromJson(A(m2), AdjustmentMode.class);
                        SuperViewModel superViewModel7 = this.d;
                        if (superViewModel7 != null && (a0 = superViewModel7.a0()) != null) {
                            a0.postValue(adjustmentMode);
                            return;
                        }
                        return;
                    }
                    break;
                case 1310785750:
                    if (k2.equals("get_demo_mode")) {
                        Boolean booleanStrictOrNull3 = StringsKt.toBooleanStrictOrNull(A(m2));
                        SuperViewModel superViewModel8 = this.d;
                        if (superViewModel8 != null && (S = superViewModel8.S()) != null) {
                            S.postValue(booleanStrictOrNull3);
                            return;
                        }
                        return;
                    }
                    break;
            }
        }
        delegate.c(n, "handleGlassSystemInfo::Unsupported messages");
        O(str);
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [androidx.lifecycle.MutableLiveData] */
    /* JADX WARNING: type inference failed for: r2v4, types: [androidx.lifecycle.MutableLiveData] */
    /* JADX WARNING: type inference failed for: r2v6, types: [androidx.lifecycle.MutableLiveData] */
    /* JADX WARNING: type inference failed for: r2v18, types: [androidx.lifecycle.MutableLiveData] */
    /* JADX WARNING: type inference failed for: r2v22, types: [androidx.lifecycle.MutableLiveData] */
    /* JADX WARNING: type inference failed for: r2v24, types: [androidx.lifecycle.MutableLiveData] */
    /* JADX WARNING: type inference failed for: r2v26, types: [androidx.lifecycle.MutableLiveData] */
    /* JADX WARNING: type inference failed for: r2v28, types: [androidx.lifecycle.MutableLiveData] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void I(com.upuphone.xr.interconnect.entity.StarryNetMessage r8) {
        /*
            r7 = this;
            java.lang.String r8 = r8.getMessage()
            com.google.gson.JsonElement r8 = com.google.gson.JsonParser.parseString(r8)
            java.lang.String r0 = "null cannot be cast to non-null type com.google.gson.JsonObject"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8, r0)
            com.google.gson.JsonObject r8 = (com.google.gson.JsonObject) r8
            java.lang.String r0 = "language"
            boolean r1 = r8.has(r0)
            r2 = 0
            if (r1 == 0) goto L_0x0080
            java.lang.String r1 = "country"
            boolean r3 = r8.has(r1)
            if (r3 == 0) goto L_0x0080
            com.upuphone.star.core.log.ULog$Delegate r3 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r4 = n
            java.lang.String r5 = "receive msg language and set to navi"
            r3.a(r4, r5)
            com.google.gson.JsonElement r0 = r8.get(r0)
            java.lang.String r0 = r0.getAsString()
            com.google.gson.JsonElement r8 = r8.get(r1)
            java.lang.String r8 = r8.getAsString()
            com.upuphone.xr.sapp.utils.ControlUtils r1 = com.upuphone.xr.sapp.utils.ControlUtils.f7858a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r4 = "-"
            r3.append(r4)
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            r1.o0(r3)
            android.content.Context r1 = com.upuphone.xr.sapp.utils.GlobalExtKt.f()
            com.upuphone.ar.navi.lite.manger.NaviManager r1 = com.upuphone.ar.navi.lite.manger.NaviManager.getInstance(r1)
            r1.setGlassLanguage(r8, r0)
            com.upuphone.xr.sapp.vm.SuperViewModel r7 = r7.d
            if (r7 == 0) goto L_0x0065
            androidx.lifecycle.MutableLiveData r2 = r7.o0()
        L_0x0065:
            if (r2 != 0) goto L_0x0069
            goto L_0x037d
        L_0x0069:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r0)
            r7.append(r4)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r2.setValue(r7)
            goto L_0x037d
        L_0x0080:
            java.lang.String r0 = "zen_mode"
            boolean r1 = r8.has(r0)
            if (r1 == 0) goto L_0x00ab
            com.google.gson.JsonElement r8 = r8.get(r0)
            boolean r8 = r8.getAsBoolean()
            com.upuphone.xr.sapp.utils.ControlUtils r0 = com.upuphone.xr.sapp.utils.ControlUtils.f7858a
            r0.n0(r8)
            com.upuphone.xr.sapp.vm.SuperViewModel r7 = r7.d
            if (r7 == 0) goto L_0x009e
            androidx.lifecycle.MutableLiveData r2 = r7.v0()
        L_0x009e:
            if (r2 != 0) goto L_0x00a2
            goto L_0x037d
        L_0x00a2:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r8)
            r2.setValue(r7)
            goto L_0x037d
        L_0x00ab:
            java.lang.String r0 = "air_mode"
            boolean r1 = r8.has(r0)
            if (r1 == 0) goto L_0x00d5
            com.google.gson.JsonElement r8 = r8.get(r0)
            boolean r8 = r8.getAsBoolean()
            com.upuphone.xr.sapp.utils.ControlUtils r0 = com.upuphone.xr.sapp.utils.ControlUtils.f7858a
            r0.g0(r8)
            com.upuphone.xr.sapp.vm.SuperViewModel r7 = r7.d
            if (r7 == 0) goto L_0x00c8
            androidx.lifecycle.MutableLiveData r2 = r7.k0()
        L_0x00c8:
            if (r2 != 0) goto L_0x00cc
            goto L_0x037d
        L_0x00cc:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r8)
            r2.setValue(r7)
            goto L_0x037d
        L_0x00d5:
            java.lang.String r0 = "screen_off_time"
            boolean r1 = r8.has(r0)
            if (r1 == 0) goto L_0x00ff
            com.google.gson.JsonElement r8 = r8.get(r0)
            int r8 = r8.getAsInt()
            com.upuphone.xr.sapp.utils.ControlUtils r0 = com.upuphone.xr.sapp.utils.ControlUtils.f7858a
            r0.q0(r8)
            com.upuphone.xr.sapp.vm.SuperViewModel r7 = r7.d
            if (r7 == 0) goto L_0x00f2
            androidx.lifecycle.MutableLiveData r2 = r7.l0()
        L_0x00f2:
            if (r2 != 0) goto L_0x00f6
            goto L_0x037d
        L_0x00f6:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            r2.setValue(r7)
            goto L_0x037d
        L_0x00ff:
            java.lang.String r0 = "device_info"
            boolean r1 = r8.has(r0)
            if (r1 == 0) goto L_0x0142
            com.google.gson.Gson r1 = r7.b
            com.google.gson.JsonElement r8 = r8.get(r0)
            java.lang.Class<com.upuphone.xr.sapp.entity.DeviceInfo> r0 = com.upuphone.xr.sapp.entity.DeviceInfo.class
            java.lang.Object r8 = r1.fromJson((com.google.gson.JsonElement) r8, r0)
            com.upuphone.xr.sapp.entity.DeviceInfo r8 = (com.upuphone.xr.sapp.entity.DeviceInfo) r8
            com.upuphone.xr.sapp.utils.ControlUtils r0 = com.upuphone.xr.sapp.utils.ControlUtils.f7858a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r0.k0(r8)
            com.upuphone.xr.sapp.vm.SuperViewModel r0 = r7.d
            if (r0 == 0) goto L_0x0126
            androidx.lifecycle.MutableLiveData r0 = r0.M()
            goto L_0x0127
        L_0x0126:
            r0 = r2
        L_0x0127:
            if (r0 != 0) goto L_0x012a
            goto L_0x012d
        L_0x012a:
            r0.setValue(r8)
        L_0x012d:
            com.upuphone.xr.sapp.vm.SuperViewModel r7 = r7.d
            if (r7 == 0) goto L_0x0135
            com.upuphone.xr.sapp.utils.SingleLiveData r2 = r7.I0()
        L_0x0135:
            if (r2 != 0) goto L_0x0139
            goto L_0x037d
        L_0x0139:
            java.lang.String r7 = r8.getSerialNo()
            r2.setValue(r7)
            goto L_0x037d
        L_0x0142:
            java.lang.String r0 = "do_recovery_state"
            boolean r1 = r8.has(r0)
            if (r1 == 0) goto L_0x0167
            com.upuphone.xr.sapp.vm.SuperViewModel r7 = r7.d
            if (r7 == 0) goto L_0x0152
            androidx.lifecycle.MutableLiveData r2 = r7.m0()
        L_0x0152:
            if (r2 != 0) goto L_0x0156
            goto L_0x037d
        L_0x0156:
            com.google.gson.JsonElement r7 = r8.get(r0)
            boolean r7 = r7.getAsBoolean()
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            r2.setValue(r7)
            goto L_0x037d
        L_0x0167:
            java.lang.String r0 = "dock_ids"
            boolean r1 = r8.has(r0)
            if (r1 == 0) goto L_0x017e
            com.upuphone.xr.sapp.utils.DynamicOperateUtil r7 = com.upuphone.xr.sapp.utils.DynamicOperateUtil.f7880a
            com.google.gson.JsonElement r8 = r8.get(r0)
            java.lang.String r8 = r8.getAsString()
            r7.z(r8)
            goto L_0x037d
        L_0x017e:
            java.lang.String r0 = "is_wifi_enable"
            boolean r1 = r8.has(r0)
            java.lang.String r3 = "ssid"
            if (r1 == 0) goto L_0x01d9
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r2 = n
            java.lang.String r4 = "receive wifi state"
            r1.a(r2, r4)
            com.google.gson.JsonElement r1 = r8.get(r0)
            boolean r1 = r1.getAsBoolean()
            com.google.gson.JsonElement r2 = r8.get(r3)
            java.lang.String r2 = r2.getAsString()
            java.lang.String r4 = "bssid"
            com.google.gson.JsonElement r8 = r8.get(r4)
            java.lang.String r8 = r8.getAsString()
            com.upuphone.xr.sapp.entity.GlassWifiData r4 = new com.upuphone.xr.sapp.entity.GlassWifiData
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r4.<init>(r1, r2, r8)
            com.upuphone.xr.sapp.vm.SuperViewModel r7 = r7.d
            if (r7 == 0) goto L_0x01c3
            androidx.lifecycle.MutableLiveData r7 = r7.s0()
            if (r7 == 0) goto L_0x01c3
            r7.postValue(r4)
        L_0x01c3:
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r7 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r8 = r7.a()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r8.o(r0, r1)
            com.upuphone.xr.sapp.utils.DataStoreUtils r7 = r7.a()
            r7.o(r3, r2)
            goto L_0x037d
        L_0x01d9:
            java.lang.String r1 = "network_state_change"
            boolean r4 = r8.has(r1)
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x0227
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r4 = n
            java.lang.String r6 = "receive wifi change"
            r2.a(r4, r6)
            com.google.gson.JsonElement r1 = r8.get(r1)
            boolean r1 = r1.getAsBoolean()
            com.google.gson.JsonElement r8 = r8.get(r3)
            java.lang.String r8 = r8.getAsString()
            com.upuphone.xr.sapp.entity.GlassWifiData r2 = new com.upuphone.xr.sapp.entity.GlassWifiData
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r2.<init>(r1, r8, r5)
            com.upuphone.xr.sapp.vm.SuperViewModel r7 = r7.d
            if (r7 == 0) goto L_0x0211
            androidx.lifecycle.MutableLiveData r7 = r7.s0()
            if (r7 == 0) goto L_0x0211
            r7.postValue(r2)
        L_0x0211:
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r7 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r2 = r7.a()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r2.o(r0, r1)
            com.upuphone.xr.sapp.utils.DataStoreUtils r7 = r7.a()
            r7.o(r3, r8)
            goto L_0x037d
        L_0x0227:
            java.lang.String r1 = "toggle_wifi_result"
            boolean r4 = r8.has(r1)
            if (r4 == 0) goto L_0x0270
            com.google.gson.JsonElement r8 = r8.get(r1)
            boolean r8 = r8.getAsBoolean()
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r2 = n
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "receive toggle result: "
            r3.append(r4)
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            r1.a(r2, r3)
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r1 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r1 = r1.a()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r8)
            r1.o(r0, r2)
            com.upuphone.xr.sapp.vm.SuperViewModel r7 = r7.d
            if (r7 == 0) goto L_0x037d
            com.upuphone.xr.sapp.utils.SingleLiveData r7 = r7.K()
            if (r7 == 0) goto L_0x037d
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            r7.postValue(r8)
            goto L_0x037d
        L_0x0270:
            java.lang.String r0 = "network_valid"
            boolean r1 = r8.has(r0)
            if (r1 == 0) goto L_0x02c9
            com.google.gson.JsonElement r0 = r8.get(r0)
            boolean r0 = r0.getAsBoolean()
            com.google.gson.JsonElement r8 = r8.get(r3)
            java.lang.String r8 = r8.getAsString()
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r2 = n
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "receive network_valid valid: "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r4 = " and ssid is:"
            r3.append(r4)
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            r1.a(r2, r3)
            com.upuphone.xr.sapp.vm.SuperViewModel r1 = r7.d
            if (r1 == 0) goto L_0x02bf
            androidx.lifecycle.MutableLiveData r1 = r1.u0()
            if (r1 == 0) goto L_0x02bf
            com.upuphone.xr.sapp.entity.GlassWifiValidInfo r2 = new com.upuphone.xr.sapp.entity.GlassWifiValidInfo
            r3 = r0 ^ 1
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r2.<init>(r3, r8)
            r1.postValue(r2)
        L_0x02bf:
            if (r0 != 0) goto L_0x02c5
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r5 = r8
        L_0x02c5:
            r7.e = r5
            goto L_0x037d
        L_0x02c9:
            java.lang.String r0 = "contact_clean"
            boolean r0 = r8.has(r0)
            if (r0 == 0) goto L_0x02db
            com.upuphone.xr.sapp.vm.SuperViewModel r7 = r7.d
            if (r7 == 0) goto L_0x037d
            r8 = 1
            r7.T0(r8)
            goto L_0x037d
        L_0x02db:
            java.lang.String r0 = "fov_pos"
            boolean r1 = r8.has(r0)
            if (r1 == 0) goto L_0x030a
            com.google.gson.JsonElement r8 = r8.get(r0)     // Catch:{ Exception -> 0x02fe }
            int r8 = r8.getAsInt()     // Catch:{ Exception -> 0x02fe }
            com.upuphone.xr.sapp.vm.SuperViewModel r7 = r7.d     // Catch:{ Exception -> 0x02fe }
            if (r7 == 0) goto L_0x037d
            androidx.lifecycle.MutableLiveData r7 = r7.W()     // Catch:{ Exception -> 0x02fe }
            if (r7 == 0) goto L_0x037d
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x02fe }
            r7.postValue(r8)     // Catch:{ Exception -> 0x02fe }
            goto L_0x037d
        L_0x02fe:
            r7 = move-exception
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r0 = n
            java.lang.String r1 = "receive DISPALY_POSITION invalid"
            r8.b(r0, r1, r7)
            goto L_0x037d
        L_0x030a:
            java.lang.String r0 = "wear_detection_mode"
            boolean r1 = r8.has(r0)
            if (r1 == 0) goto L_0x0333
            com.google.gson.JsonElement r8 = r8.get(r0)
            boolean r8 = r8.getAsBoolean()
            com.upuphone.xr.sapp.utils.ControlUtils r0 = com.upuphone.xr.sapp.utils.ControlUtils.f7858a
            r0.u0(r8)
            com.upuphone.xr.sapp.vm.SuperViewModel r7 = r7.d
            if (r7 == 0) goto L_0x0328
            androidx.lifecycle.MutableLiveData r2 = r7.j0()
        L_0x0328:
            if (r2 != 0) goto L_0x032b
            goto L_0x037d
        L_0x032b:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r8)
            r2.setValue(r7)
            goto L_0x037d
        L_0x0333:
            java.lang.String r0 = "standby_position"
            boolean r1 = r8.has(r0)
            if (r1 == 0) goto L_0x0356
            com.google.gson.JsonElement r8 = r8.get(r0)
            int r8 = r8.getAsInt()
            com.upuphone.xr.sapp.vm.SuperViewModel r7 = r7.d
            if (r7 == 0) goto L_0x034b
            androidx.lifecycle.MutableLiveData r2 = r7.X()
        L_0x034b:
            if (r2 != 0) goto L_0x034e
            goto L_0x037d
        L_0x034e:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            r2.setValue(r7)
            goto L_0x037d
        L_0x0356:
            java.lang.String r0 = "music_tp_control_mode"
            boolean r1 = r8.has(r0)
            if (r1 == 0) goto L_0x037d
            com.google.gson.JsonElement r8 = r8.get(r0)
            boolean r8 = r8.getAsBoolean()
            com.upuphone.xr.sapp.utils.ControlUtils r0 = com.upuphone.xr.sapp.utils.ControlUtils.f7858a
            r0.p0(r8)
            com.upuphone.xr.sapp.vm.SuperViewModel r7 = r7.d
            if (r7 == 0) goto L_0x0373
            androidx.lifecycle.MutableLiveData r2 = r7.c0()
        L_0x0373:
            if (r2 != 0) goto L_0x0376
            goto L_0x037d
        L_0x0376:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r8)
            r2.setValue(r7)
        L_0x037d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vm.internal.SuperMessageManger.I(com.upuphone.xr.interconnect.entity.StarryNetMessage):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r8 = r8.getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void K(java.lang.String r8) {
        /*
            r7 = this;
            com.upuphone.xr.sapp.entity.SubPolicyData r8 = r7.w(r8)
            r0 = 0
            if (r8 == 0) goto L_0x0012
            com.upuphone.xr.sapp.entity.SubPolicyData$Data r8 = r8.getData()
            if (r8 == 0) goto L_0x0012
            java.util.List r8 = r8.getValue()
            goto L_0x0013
        L_0x0012:
            r8 = r0
        L_0x0013:
            if (r8 == 0) goto L_0x0070
            boolean r1 = r8.isEmpty()
            if (r1 != 0) goto L_0x0070
            r1 = 0
            java.lang.Object r8 = r8.get(r1)
            com.upuphone.xr.sapp.entity.SubPolicyData$Status r8 = (com.upuphone.xr.sapp.entity.SubPolicyData.Status) r8
            if (r8 == 0) goto L_0x002d
            int r8 = r8.getPkg()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x002e
        L_0x002d:
            r8 = r0
        L_0x002e:
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r2 = n
            com.upuphone.xr.sapp.MainApplication$Companion r3 = com.upuphone.xr.sapp.MainApplication.k
            com.upuphone.xr.sapp.MainApplication r4 = r3.f()
            boolean r4 = r4.v()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "isForeground="
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r1.a(r2, r4)
            if (r8 == 0) goto L_0x0063
            int r8 = r8.intValue()
            com.upuphone.xr.sapp.entity.SubPolicyInfo r0 = new com.upuphone.xr.sapp.entity.SubPolicyInfo
            com.upuphone.xr.sapp.MainApplication r1 = r3.f()
            boolean r1 = r1.v()
            r0.<init>(r8, r1)
        L_0x0063:
            com.upuphone.xr.sapp.vm.SuperViewModel r7 = r7.d
            if (r7 == 0) goto L_0x0070
            androidx.lifecycle.MutableLiveData r7 = r7.g0()
            if (r7 == 0) goto L_0x0070
            r7.postValue(r0)
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.vm.internal.SuperMessageManger.K(java.lang.String):void");
    }

    public final void L(StarryNetMessage starryNetMessage) {
        MutableLiveData w0;
        JsonElement parseString = JsonParser.parseString(starryNetMessage.getMessage());
        if (parseString instanceof JsonObject) {
            String asString = ((JsonObject) parseString).get(AccountConstantKt.REQUEST_HEADER_PKG).getAsString();
            SuperViewModel superViewModel = this.d;
            if (superViewModel != null && (w0 = superViewModel.w0()) != null) {
                w0.postValue(asString);
            }
        }
    }

    public final void M(WifiInfoModel wifiInfoModel, ArrayList arrayList) {
        WifiInfoModel wifiInfoModel2 = wifiInfoModel;
        ArrayList arrayList2 = arrayList;
        wifiInfoModel2.setItemType(1);
        if (arrayList.size() == 0) {
            arrayList2.add(0, new WifiInfoModel("", "", 0, 0, false, false, false, false, false, false, false, false, false, 8176, (DefaultConstructorMarker) null));
        }
        if (this.e.length() > 0 && Intrinsics.areEqual((Object) this.e, (Object) wifiInfoModel.getSSid())) {
            wifiInfoModel2.setWifiInValid(true);
        }
        arrayList2.add(wifiInfoModel2);
    }

    public final void N(StarryNetMessage starryNetMessage) {
        ULog.Delegate delegate = ULog.f6446a;
        String str = n;
        String message = starryNetMessage.getMessage();
        delegate.a(str, "receive " + message);
        try {
            if (JsonParser.parseString(starryNetMessage.getMessage()) instanceof JsonObject) {
                I(starryNetMessage);
            } else if (starryNetMessage.getMessage().equals("dlna_launched")) {
                delegate.a(n, "receive dlna on");
                SuperViewModel superViewModel = this.d;
                if (superViewModel != null) {
                    superViewModel.V0(true);
                }
            } else if (starryNetMessage.getMessage().equals("dlna_closed")) {
                delegate.a(n, "receive dlna off");
                SuperViewModel superViewModel2 = this.d;
                if (superViewModel2 != null) {
                    superViewModel2.V0(false);
                }
            }
        } catch (JsonSyntaxException e2) {
            ULog.f6446a.a(n, e2.getMessage());
        } catch (UnsupportedOperationException e3) {
            ULog.f6446a.c(n, e3.getMessage());
        }
    }

    public final void O(String str) {
        SingleLiveData F0;
        ResPolicyData.Data data;
        try {
            ResPolicyData resPolicyData = (ResPolicyData) this.b.fromJson(str, ResPolicyData.class);
            ULog.Delegate delegate = ULog.f6446a;
            String str2 = n;
            delegate.a(str2, "handleGlassSystemInfo::ACTION_NOTIFY_GLASS_STATE in policyData is: " + resPolicyData);
            if (resPolicyData != null && (data = resPolicyData.getData()) != null && data.getState() == 1 && Intrinsics.areEqual((Object) resPolicyData.getData().getPp(), (Object) "myvu_pp")) {
                delegate.a(n, "handleGlassSystemInfo::ACTION_NOTIFY_GLASS_STATE VALUE_MYVU_PP");
                LocalSharePreference.b.a().b().putBoolean("international_privacy_out_date", true).commit();
                this.h.postDelayed(new a(), 100);
                DataStoreUtils.Companion companion = DataStoreUtils.e;
                companion.a().o("need_reconnect_device", Boolean.TRUE);
                companion.a().o("sp_user_agreement_state", Boolean.FALSE);
                MzAccountManager.Companion companion2 = MzAccountManager.c;
                companion2.b().c();
                companion2.b().f();
            }
            SuperViewModel superViewModel = this.d;
            if (superViewModel != null && (F0 = superViewModel.F0()) != null) {
                F0.postValue(resPolicyData);
            }
        } catch (Exception e2) {
            ULog.Delegate delegate2 = ULog.f6446a;
            String str3 = n;
            String message = e2.getMessage();
            delegate2.c(str3, "handleGlassSystemInfo::e is: " + message);
        }
    }

    public final void Q(StarryNetMessage starryNetMessage) {
        JsonElement parseString = JsonParser.parseString(starryNetMessage.getMessage());
        if (parseString instanceof JsonObject) {
            UnicronBatteryInfo unicronBatteryInfo = (UnicronBatteryInfo) this.b.fromJson((JsonElement) ((JsonObject) parseString).get(AccountConstantKt.RESPONSE_VALUE).getAsJsonObject(), UnicronBatteryInfo.class);
            SuperViewModel superViewModel = this.d;
            MutableLiveData A0 = superViewModel != null ? superViewModel.A0() : null;
            if (A0 != null) {
                A0.setValue(unicronBatteryInfo);
            }
            SuperViewModel superViewModel2 = this.d;
            if (superViewModel2 != null) {
                superViewModel2.b1(unicronBatteryInfo.isConnect());
            }
            ControlUtils controlUtils = ControlUtils.f7858a;
            Intrinsics.checkNotNull(unicronBatteryInfo);
            controlUtils.e0(unicronBatteryInfo);
            if (!unicronBatteryInfo.getBound()) {
                controlUtils.f0((UnicronInfo) null);
            } else if (unicronBatteryInfo.isConnect()) {
                UnicronUpdateHelper.b.S(unicronBatteryInfo.getBluetooth());
            }
        }
    }

    public final void R(StarryNetMessage starryNetMessage) {
        JsonElement parseString = JsonParser.parseString(starryNetMessage.getMessage());
        if (parseString instanceof JsonObject) {
            JsonObject asJsonObject = ((JsonObject) parseString).get("data").getAsJsonObject();
            if ("get_unicron_info".equals(StringsKt.trim((CharSequence) asJsonObject.get(WebJs.ACTION).getAsString().toString()).toString())) {
                try {
                    UnicronInfo unicronInfo = (UnicronInfo) this.b.fromJson(((ResGlassData) this.b.fromJson((JsonElement) asJsonObject, ResGlassData.class)).getValue(), UnicronInfo.class);
                    ULog.Delegate delegate = ULog.f6446a;
                    String str = n;
                    delegate.a(str, "handleUnicronVersion() result=" + unicronInfo);
                    SuperViewModel superViewModel = this.d;
                    MutableLiveData B0 = superViewModel != null ? superViewModel.B0() : null;
                    if (B0 != null) {
                        B0.setValue(unicronInfo);
                    }
                    ControlUtils.f7858a.f0(unicronInfo);
                } catch (Exception e2) {
                    ULog.Delegate delegate2 = ULog.f6446a;
                    String str2 = n;
                    delegate2.o(str2, "handleUnicronVersion() error: " + e2);
                }
            }
        }
    }

    public final void S(WifiInfoModel wifiInfoModel, ArrayList arrayList) {
        WifiInfoModel wifiInfoModel2 = wifiInfoModel;
        ArrayList arrayList2 = arrayList;
        wifiInfoModel2.setItemType(3);
        if (arrayList.size() == 0) {
            arrayList2.add(0, new WifiInfoModel("", "", 0, 2, false, false, false, false, false, false, false, false, false, 8176, (DefaultConstructorMarker) null));
        }
        arrayList2.add(wifiInfoModel2);
    }

    public final void U(StarryNetMessage starryNetMessage) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(n, "handleWifiListData in");
        JsonElement parseString = JsonParser.parseString(starryNetMessage.getMessage());
        if (parseString instanceof JsonObject) {
            JsonArray<JsonElement> asJsonArray = ((JsonObject) parseString).get(AccountConstantKt.RESPONSE_VALUE).getAsJsonArray();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Intrinsics.checkNotNull(asJsonArray);
            for (JsonElement fromJson : asJsonArray) {
                WifiInfoModel wifiInfoModel = (WifiInfoModel) this.b.fromJson(fromJson, WifiInfoModel.class);
                if (wifiInfoModel.getWifiState() == 1 || wifiInfoModel.getWifiState() == 2) {
                    Intrinsics.checkNotNull(wifiInfoModel);
                    M(wifiInfoModel, arrayList3);
                } else {
                    Intrinsics.checkNotNull(wifiInfoModel);
                    S(wifiInfoModel, arrayList2);
                }
                ULog.Delegate delegate2 = ULog.f6446a;
                String str = n;
                String sSid = wifiInfoModel.getSSid();
                delegate2.a(str, "handleWifiListData::wifiInfoModel is: " + sSid);
            }
            arrayList.addAll(arrayList3);
            arrayList.addAll(arrayList2);
            if (arrayList.size() > 0) {
                arrayList.add(new WifiInfoModel("", "", 0, 4, false, false, false, false, false, false, false, false, false, 8176, (DefaultConstructorMarker) null));
            }
            ULog.f6446a.a(n, "handleWifiListData to ui");
            SuperViewModel superViewModel = this.d;
            SingleLiveData P0 = superViewModel != null ? superViewModel.P0() : null;
            if (P0 != null) {
                P0.setValue(new WifiListInfo(arrayList, System.currentTimeMillis()));
                return;
            }
            return;
        }
        delegate.c(n, "handleWifiListData::list is invalid");
    }

    public final void V(StarryNetMessage starryNetMessage) {
        SuperViewModel superViewModel;
        MutableLiveData s0;
        JsonElement parseString = JsonParser.parseString(starryNetMessage.getMessage());
        ULog.Delegate delegate = ULog.f6446a;
        String str = n;
        delegate.c(str, "handleWifiState parseString is: " + parseString);
        if (parseString instanceof JsonObject) {
            WifiResultModel wifiResultModel = (WifiResultModel) this.b.fromJson((JsonElement) ((JsonObject) parseString).get(AccountConstantKt.RESPONSE_VALUE).getAsJsonObject(), WifiResultModel.class);
            if (wifiResultModel.getMState() == 0 && Intrinsics.areEqual((Object) wifiResultModel.getMSetChange(), (Object) "0") && (superViewModel = this.d) != null && (s0 = superViewModel.s0()) != null) {
                s0.postValue(new GlassWifiData(true, wifiResultModel.getMSsid(), wifiResultModel.getMBssid()));
            }
            SuperViewModel superViewModel2 = this.d;
            SingleLiveData O0 = superViewModel2 != null ? superViewModel2.O0() : null;
            if (O0 != null) {
                O0.setValue(wifiResultModel);
            }
        }
    }

    public final void W(SuperViewModel superViewModel) {
        Intrinsics.checkNotNullParameter(superViewModel, "superViewModel");
        this.d = superViewModel;
    }

    public final void X(boolean z) {
        MutableLiveData P;
        ULog.Delegate delegate = ULog.f6446a;
        String str = n;
        delegate.a(str, "notifyAccountLoginState  state = " + z);
        SuperViewModel superViewModel = this.d;
        if (superViewModel != null && (P = superViewModel.P()) != null) {
            P.postValue(Boolean.valueOf(z));
        }
    }

    public final void Y(String str) {
        Intrinsics.checkNotNullParameter(str, "policyType");
        ReqPolicyData reqPolicyData = new ReqPolicyData();
        ReqPolicyData.Data data = new ReqPolicyData.Data();
        reqPolicyData.setAction("system");
        data.setAction("notify_privacy_expired");
        data.setPp(str);
        reqPolicyData.setData(data);
        String json = this.b.toJson((Object) reqPolicyData);
        ULog.Delegate delegate = ULog.f6446a;
        String str2 = n;
        delegate.a(str2, "notifyPrivacyExpired = " + json);
        Intrinsics.checkNotNull(json);
        j0(json);
    }

    public final void Z(String str) {
        ULog.Delegate delegate = ULog.f6446a;
        String str2 = n;
        delegate.a(str2, "registerMessageReceiver " + str + MzContactsContract.MzGroups.GROUP_SPLIT_MARK_EXTRA);
        OperatorManager init = SuperAppServiceManager.getInstance().init(str);
        if (init != null) {
            delegate.c(n, "SuperAppServiceManager init pkg");
            init.getMessageOperator().registerMessageReceiver(this.c);
        }
    }

    public final void a0() {
        Job unused = BuildersKt__Builders_commonKt.d(GlobalScope.f3732a, Dispatchers.a(), (CoroutineStart) null, new SuperMessageManger$registerWeatherDataCallback$1(this, (Continuation<? super SuperMessageManger$registerWeatherDataCallback$1>) null), 2, (Object) null);
    }

    public final void b0(boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "accountId");
        ReportInfo reportInfo = new ReportInfo();
        ReportInfo.Data data = new ReportInfo.Data();
        data.setAction("account_state");
        data.setValue(z);
        data.setAccountId(str);
        reportInfo.setAction("system_account");
        reportInfo.setData(data);
        String json = this.b.toJson((Object) reportInfo);
        ULog.Delegate delegate = ULog.f6446a;
        String str2 = n;
        delegate.a(str2, "reportFlymeAccountLoginState = " + json);
        Intrinsics.checkNotNull(json);
        j0(json);
    }

    public final void c0() {
        ReportInfo reportInfo = new ReportInfo();
        ReportInfo.Data data = new ReportInfo.Data();
        data.setAction("req_active_info");
        reportInfo.setAction("system_glass_active");
        reportInfo.setData(data);
        String json = this.b.toJson((Object) reportInfo);
        ULog.Delegate delegate = ULog.f6446a;
        String str = n;
        delegate.a(str, "reqGlassActiveInfo = " + json);
        Intrinsics.checkNotNull(json);
        j0(json);
    }

    public final void e0() {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a(n, "req Glass Active State");
        if (!MzAccountManager.c.c()) {
            delegate.a(n, "req Glass Active State need login");
            return;
        }
        this.i.removeCallbacks(this.l);
        this.i.postDelayed(this.l, 1000);
    }

    public final void g0(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "ssid");
        Intrinsics.checkNotNullParameter(str2, AccountConstantKt.INTENT_PARAM_PASSWORD);
        Intrinsics.checkNotNullParameter(str3, WebJs.ACTION);
        Intrinsics.checkNotNullParameter(str4, "change");
        ReqGlassWifiData reqGlassWifiData = new ReqGlassWifiData();
        ReqGlassWifiData.Data data = new ReqGlassWifiData.Data();
        ReqGlassWifiData.Value value = new ReqGlassWifiData.Value();
        data.setAction(str3);
        data.setValue(value);
        value.setChange(str4);
        value.setSsid(str);
        value.setPassword(str2);
        reqGlassWifiData.setAction("system");
        reqGlassWifiData.setData(data);
        String json = this.b.toJson((Object) reqGlassWifiData);
        Intrinsics.checkNotNull(json);
        j0(json);
    }

    public CoroutineContext getCoroutineContext() {
        return this.f8015a.getCoroutineContext();
    }

    public final void h0() {
        String json = this.b.toJson((Object) new GlassFeatureList("feature_list", new GlassFeatureList.Data("2.40.51", CollectionsKt.arrayListOf("audio_multi", "screenoff_time_extend"))));
        Intrinsics.checkNotNullExpressionValue(json, "run(...)");
        ULog.Delegate delegate = ULog.f6446a;
        String str = n;
        delegate.a(str, "sendGlassFeatureList json=" + json);
        j0(json);
    }

    public final void i0() {
        Boolean bool = (Boolean) DataStoreUtils.j(DataStoreUtils.e.a(), "hearing_assist_status", Boolean.FALSE, true, (Context) null, 8, (Object) null);
        bool.booleanValue();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(WebJs.ACTION, "set_hear_impairment_mode");
        jsonObject.addProperty(AccountConstantKt.RESPONSE_VALUE, bool);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty(WebJs.ACTION, "system");
        jsonObject2.add("data", jsonObject);
        ULog.Delegate delegate = ULog.f6446a;
        String str = n;
        delegate.a(str, "sendHearingAssinstStatusMessage: " + jsonObject2);
        String jsonElement = jsonObject2.toString();
        Intrinsics.checkNotNullExpressionValue(jsonElement, "toString(...)");
        j0(jsonElement);
    }

    public final void j0(String str) {
        StarryNetMessage starryNetMessage = new StarryNetMessage();
        starryNetMessage.setSenderPkg(GlobalExtKt.f().getPackageName());
        starryNetMessage.setMessage(str);
        starryNetMessage.setReceiverPkg("com.upuphone.star.launcher");
        InterconnectManager.getInstance().getStarryNetMessenger().sendMessage(starryNetMessage, this.j);
    }

    public final String k(String str) {
        JsonElement parseString = JsonParser.parseString(str);
        if (!(parseString instanceof JsonObject)) {
            return null;
        }
        JsonObject jsonObject = (JsonObject) parseString;
        if (jsonObject.has(WebJs.ACTION)) {
            return jsonObject.get(WebJs.ACTION).getAsString();
        }
        return null;
    }

    public final void k0() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("syncTimeData", String.valueOf(System.currentTimeMillis()));
        int totalSeconds = ZonedDateTime.now(ZoneId.of(TimeZone.getDefault().getID())).getOffset().getTotalSeconds() * 1000;
        ULog.Delegate delegate = ULog.f6446a;
        String str = n;
        delegate.a(str, "sendOffsetTimeToGlass  offset " + totalSeconds);
        jsonObject.addProperty("timeZoneOffSet", (Number) Integer.valueOf(totalSeconds));
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty(WebJs.ACTION, "SyncOffSetTime");
        jsonObject2.add("data", jsonObject);
        String str2 = n;
        delegate.a(str2, "sendOffsetTimeToGlass " + jsonObject2);
        StarryMessageHelper starryMessageHelper = StarryMessageHelper.f7799a;
        String jsonElement = jsonObject2.toString();
        Intrinsics.checkNotNullExpressionValue(jsonElement, "toString(...)");
        starryMessageHelper.k(jsonElement, new SuperMessageManger$sendOffsetTimeToGlass$1());
    }

    public final void l() {
        ReqGlassData reqGlassData = new ReqGlassData();
        ReqGlassData.Data data = new ReqGlassData.Data();
        data.setAction("get_brightness");
        reqGlassData.setAction("system");
        reqGlassData.setData(data);
        String json = this.b.toJson((Object) reqGlassData);
        Intrinsics.checkNotNull(json);
        j0(json);
    }

    public final void l0(Integer num) {
        ReqGlassData reqGlassData = new ReqGlassData();
        ReqGlassData.Data data = new ReqGlassData.Data();
        data.setAction("request_phone_battery");
        data.setValue(String.valueOf(num != null ? num.intValue() : 0));
        reqGlassData.setAction("system");
        reqGlassData.setData(data);
        String json = this.b.toJson((Object) reqGlassData);
        ULog.Delegate delegate = ULog.f6446a;
        String str = n;
        delegate.a(str, "sendPhoneBattery batteryInfoJson = " + json);
        Intrinsics.checkNotNull(json);
        j0(json);
    }

    public final String m(String str) {
        JsonElement parseString = JsonParser.parseString(str);
        if (!(parseString instanceof JsonObject)) {
            return null;
        }
        JsonObject jsonObject = (JsonObject) parseString;
        if (jsonObject.has("data")) {
            return jsonObject.get("data").toString();
        }
        return null;
    }

    public final void m0() {
        if (ModelIdExtKt.c(DynamicAdapterUtils.f7879a.a())) {
            F();
        }
    }

    public final void n() {
        ReqGlassData reqGlassData = new ReqGlassData();
        ReqGlassData.Data data = new ReqGlassData.Data();
        data.setAction("get_fov_pos_type");
        reqGlassData.setAction("system");
        reqGlassData.setData(data);
        String json = this.b.toJson((Object) reqGlassData);
        Intrinsics.checkNotNull(json);
        j0(json);
    }

    public final void n0(String str) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        ReqGlassData reqGlassData = new ReqGlassData();
        ReqGlassData.Data data = new ReqGlassData.Data();
        data.setAction("set_brightness");
        data.setValue(str);
        reqGlassData.setAction("system");
        reqGlassData.setData(data);
        String json = this.b.toJson((Object) reqGlassData);
        Intrinsics.checkNotNull(json);
        j0(json);
    }

    public final void o0(int i2) {
        ReqGlassData reqGlassData = new ReqGlassData();
        ReqGlassData.Data data = new ReqGlassData.Data();
        data.setAction("set_brightness_finish");
        data.setValue(String.valueOf(i2));
        reqGlassData.setAction("system");
        reqGlassData.setData(data);
        String json = this.b.toJson((Object) reqGlassData);
        Intrinsics.checkNotNull(json);
        j0(json);
        SuperViewModel superViewModel = this.d;
        MutableLiveData y0 = superViewModel != null ? superViewModel.y0() : null;
        if (y0 != null) {
            y0.setValue(Integer.valueOf(i2));
        }
    }

    public final void p(String str) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        ReqGlassLogInfo reqGlassLogInfo = new ReqGlassLogInfo();
        ReqGlassLogInfo.Data data = new ReqGlassLogInfo.Data();
        data.setAction("get_glass_log");
        if (ModelIdExtKt.a(DynamicAdapterUtils.f7879a.a())) {
            data.setChannel("BLE");
        } else {
            data.setChannel("WiFi");
        }
        data.setFilePath(str);
        reqGlassLogInfo.setAction("user_feedback");
        reqGlassLogInfo.setData(data);
        String json = this.b.toJson((Object) reqGlassLogInfo);
        ULog.Delegate delegate = ULog.f6446a;
        String str2 = n;
        delegate.a(str2, "getGlassLog = " + json);
        Intrinsics.checkNotNull(json);
        j0(json);
    }

    public final String q(String str) {
        JsonElement parseString = JsonParser.parseString(str);
        if (parseString instanceof JsonObject) {
            JsonObject jsonObject = (JsonObject) parseString;
            if (jsonObject.has(AccountConstantKt.RESPONSE_VALUE)) {
                JsonElement jsonElement = jsonObject.get(AccountConstantKt.RESPONSE_VALUE);
                if (jsonElement.isJsonObject() || jsonElement.isJsonArray()) {
                    String jsonElement2 = jsonElement.toString();
                    Intrinsics.checkNotNullExpressionValue(jsonElement2, "toString(...)");
                    return jsonElement2;
                } else if (!jsonElement.isJsonPrimitive()) {
                    return "";
                } else {
                    String asString = jsonElement.getAsString();
                    Intrinsics.checkNotNullExpressionValue(asString, "getAsString(...)");
                    return asString;
                }
            }
        }
        return "";
    }

    public final void r() {
        ReqGlassData reqGlassData = new ReqGlassData();
        ReqGlassData.Data data = new ReqGlassData.Data();
        data.setAction("get_network_valid");
        reqGlassData.setAction("system");
        reqGlassData.setData(data);
        String json = this.b.toJson((Object) reqGlassData);
        Intrinsics.checkNotNull(json);
        j0(json);
    }

    public final void s() {
        ReqGlassData reqGlassData = new ReqGlassData();
        ReqGlassData.Data data = new ReqGlassData.Data();
        data.setAction("get_standby_position");
        reqGlassData.setAction("system");
        reqGlassData.setData(data);
        String json = this.b.toJson((Object) reqGlassData);
        Intrinsics.checkNotNull(json);
        j0(json);
    }

    public final void s0(String str) {
        Intrinsics.checkNotNullParameter(str, "model");
        DataStoreUtils.e.a().p("brightness_model", str, true);
        ReqGlassBrightnessData reqGlassBrightnessData = new ReqGlassBrightnessData();
        reqGlassBrightnessData.setAction("brightness_model");
        reqGlassBrightnessData.setValue(str);
        String json = this.b.toJson((Object) reqGlassBrightnessData);
        Intrinsics.checkNotNull(json);
        j0(json);
    }

    public final void t() {
        ReqGlassData reqGlassData = new ReqGlassData();
        ReqGlassData.Data data = new ReqGlassData.Data();
        data.setAction("get_standby_widget_lists");
        reqGlassData.setAction("system");
        reqGlassData.setData(data);
        String json = this.b.toJson((Object) reqGlassData);
        Intrinsics.checkNotNull(json);
        j0(json);
    }

    public final void u0(int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("fov_pos", Integer.valueOf(i2));
        HashMap hashMap2 = new HashMap();
        hashMap2.put(WebJs.ACTION, "set_fov_pos_type");
        hashMap2.put(AccountConstantKt.RESPONSE_VALUE, hashMap);
        HashMap hashMap3 = new HashMap();
        hashMap3.put(WebJs.ACTION, "system");
        hashMap3.put("data", hashMap2);
        String json = this.b.toJson((Object) hashMap3);
        Intrinsics.checkNotNull(json);
        j0(json);
    }

    public final ArrayList v() {
        ArrayList arrayList = new ArrayList();
        DataStoreUtils.Companion companion = DataStoreUtils.e;
        DataStoreUtils a2 = companion.a();
        Boolean bool = Boolean.FALSE;
        arrayList.add(new SubPolicyData.Status(1, ((Boolean) DataStoreUtils.i(a2, "privacy_argreement_key_ar_navi", bool, (Context) null, 4, (Object) null)).booleanValue()));
        Boolean bool2 = bool;
        arrayList.add(new SubPolicyData.Status(2, ((Boolean) DataStoreUtils.i(companion.a(), "privacy_argreement_key_ar_tran", bool2, (Context) null, 4, (Object) null)).booleanValue()));
        arrayList.add(new SubPolicyData.Status(3, ((Boolean) DataStoreUtils.i(companion.a(), "privacy_argreement_key_ar_tici", bool2, (Context) null, 4, (Object) null)).booleanValue()));
        arrayList.add(new SubPolicyData.Status(4, ((Boolean) DataStoreUtils.i(companion.a(), "privacy_argreement_key_ai_asst", bool2, (Context) null, 4, (Object) null)).booleanValue()));
        return arrayList;
    }

    public final void v0(int i2) {
        DataStoreUtils.e.a().p("set_standby_position", Integer.valueOf(i2), true);
        HashMap hashMap = new HashMap();
        hashMap.put("standby_position", Integer.valueOf(i2));
        HashMap hashMap2 = new HashMap();
        hashMap2.put(WebJs.ACTION, "set_standby_position");
        hashMap2.put(AccountConstantKt.RESPONSE_VALUE, hashMap);
        HashMap hashMap3 = new HashMap();
        hashMap3.put(WebJs.ACTION, "system");
        hashMap3.put("data", hashMap2);
        String json = this.b.toJson((Object) hashMap3);
        Intrinsics.checkNotNull(json);
        j0(json);
    }

    public final SubPolicyData w(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        try {
            return (SubPolicyData) this.b.fromJson(str, SubPolicyData.class);
        } catch (Exception e2) {
            ULog.Delegate delegate = ULog.f6446a;
            String str2 = n;
            delegate.c(str2, "getSubPolicyData::e is: " + e2);
            return null;
        }
    }

    public final void w0(Long l2) {
        this.f = l2;
    }

    public final Long x() {
        return this.f;
    }

    public final Long y() {
        return this.g;
    }

    public final void y0(Long l2) {
        this.g = l2;
    }

    public final void z0(String str, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(str, AccountConstantKt.RESPONSE_VALUE);
        SetVolumeData setVolumeData = new SetVolumeData(i2, Boolean.valueOf(z));
        setVolumeData.setAction("set_volume");
        setVolumeData.setValue(str);
        ReqGlassData reqGlassData = new ReqGlassData();
        reqGlassData.setAction("system");
        reqGlassData.setData(setVolumeData);
        String json = this.b.toJson((Object) reqGlassData);
        Intrinsics.checkNotNull(json);
        j0(json);
    }
}
