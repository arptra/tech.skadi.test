package com.upuphone.xr.sapp.air;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.view.web.WebJs;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.StarryNetDeviceManager;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.entity.AirSilentSendFileResponse;
import com.upuphone.xr.sapp.entity.AirSilentUpdateInfo;
import com.upuphone.xr.sapp.entity.BasicGlassResponse;
import com.upuphone.xr.sapp.entity.GlassUpdateProgress;
import com.upuphone.xr.sapp.glass.GlassMessageHelper;
import com.upuphone.xr.sapp.glass.TwinActionMessageListener;
import com.upuphone.xr.sapp.utils.JsonUtils;
import com.upuphone.xr.sapp.utils.ModelIdExtKt;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\rJ\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u0010\u0010\bJ\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u0011\u0010\bJ\"\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u0019\u001a\u00020\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\b\u0002\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u0019\u0010\u001aJ\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u001c\u0010\bJ\u0015\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b!\u0010 J%\u0010%\u001a\u00020\u00132\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00130\"j\u0002`#¢\u0006\u0004\b%\u0010&J%\u0010)\u001a\u00020\u00132\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00130\"j\u0002`(¢\u0006\u0004\b)\u0010&J%\u0010,\u001a\u00020\u00132\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00130\"j\u0002`+¢\u0006\u0004\b,\u0010&J\u001f\u0010/\u001a\u00020\u00132\u0010\u0010$\u001a\f\u0012\u0004\u0012\u00020\u00130-j\u0002`.¢\u0006\u0004\b/\u00100J\u001c\u00102\u001a\u0004\u0018\u0001012\b\b\u0002\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b2\u0010\bJ%\u00105\u001a\u00020\u00132\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00130\"j\u0002`4¢\u0006\u0004\b5\u0010&J\u001c\u00107\u001a\u0004\u0018\u0001062\b\b\u0002\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b7\u0010\bJ\"\u0010:\u001a\u00020\u00132\u0006\u00109\u001a\u0002082\b\b\u0002\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b:\u0010;J\u001a\u0010<\u001a\u00020\u00132\b\b\u0002\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b<\u0010\bJ,\u0010@\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020=2\b\u0010?\u001a\u0004\u0018\u00010>2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b@\u0010AJ\"\u0010B\u001a\u00020\u00132\u0006\u00109\u001a\u0002082\b\b\u0002\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\bB\u0010;J,\u0010C\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020=2\b\u0010?\u001a\u0004\u0018\u00010>2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\bC\u0010AR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001d0D8\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR*\u0010I\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00130\"j\u0002`#0D8\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010FR*\u0010K\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00130\"j\u0002`(0D8\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010FR*\u0010M\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00130\"j\u0002`+0D8\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010FR$\u0010O\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00130-j\u0002`.0D8\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010FR*\u0010Q\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00130\"j\u0002`40D8\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010FR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00130R8\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u001d\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00130V8\u0006¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u001a\u0010^\u001a\b\u0012\u0004\u0012\u00020\\0R8\u0002X\u0004¢\u0006\u0006\n\u0004\b]\u0010TR\u001d\u0010`\u001a\b\u0012\u0004\u0012\u00020\\0V8\u0006¢\u0006\f\n\u0004\b\u001f\u0010X\u001a\u0004\b_\u0010ZR\u001a\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00130R8\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010TR\u001d\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00130V8\u0006¢\u0006\f\n\u0004\b5\u0010X\u001a\u0004\bb\u0010ZR\u0014\u0010g\u001a\u00020d8\u0016X\u0005¢\u0006\u0006\u001a\u0004\be\u0010f¨\u0006h"}, d2 = {"Lcom/upuphone/xr/sapp/air/AirHelper;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "", "timeout", "Lcom/upuphone/xr/sapp/entity/AirGlassInfo;", "v", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "device", "", "I", "(Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;)Z", "K", "Lcom/upuphone/xr/sapp/entity/BasicGlassResponse;", "V", "S", "response", "", "M", "(Lcom/upuphone/xr/sapp/entity/BasicGlassResponse;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/upuphone/xr/sapp/entity/UpdateFileInfo;", "fileInfo", "O", "(Ljava/util/List;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/xr/sapp/entity/AirGlassUpdateResult;", "x", "Ljava/lang/Runnable;", "listener", "l", "(Ljava/lang/Runnable;)V", "L", "Lkotlin/Function1;", "Lcom/upuphone/xr/sapp/glass/SyncAirGlassUpdateResultCallback;", "callback", "r", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/upuphone/xr/sapp/entity/GlassUpdateDialogResult;", "Lcom/upuphone/xr/sapp/glass/GlassUpdateDialogResultCallback;", "m", "Lcom/upuphone/xr/sapp/entity/RequestSendAirUpdateFile;", "Lcom/upuphone/xr/sapp/glass/RequestSendAirUpdateFileCallback;", "p", "Lkotlin/Function0;", "Lcom/upuphone/xr/sapp/glass/RequestSyncAirUpdateFileInfoCallback;", "q", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/upuphone/xr/sapp/entity/RemoteAirGlassUpdateState;", "G", "Lcom/upuphone/xr/sapp/entity/GlassUpdateProgress;", "Lcom/upuphone/xr/sapp/glass/GlassUpdateProgressCallback;", "n", "Lcom/upuphone/xr/sapp/entity/AirSilentUpdateVersion;", "A", "Lcom/upuphone/xr/sapp/entity/AirSilentUpdateInfo;", "info", "b0", "(Lcom/upuphone/xr/sapp/entity/AirSilentUpdateInfo;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s", "Lcom/upuphone/xr/sapp/entity/AirSilentSendFileResponse;", "", "bytes", "Q", "(Lcom/upuphone/xr/sapp/entity/AirSilentSendFileResponse;[BJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "X", "Z", "Ljava/util/concurrent/CopyOnWriteArraySet;", "c", "Ljava/util/concurrent/CopyOnWriteArraySet;", "airGlassUpdateAppReadyListeners", "d", "airGlassUpdateResultCallbacks", "e", "airGlassUpdateDialogResultCallbacks", "f", "requestSendAirUpdateFileCallbacks", "g", "requestSyncAirUpdateFileInfoCallbacks", "h", "glassUpdateProgressCallbacks", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "i", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_glassRequestSyncUpdateInfoStreamEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "j", "Lkotlinx/coroutines/flow/SharedFlow;", "E", "()Lkotlinx/coroutines/flow/SharedFlow;", "glassRequestSyncUpdateInfoStreamEvent", "Lcom/upuphone/xr/sapp/entity/AirSilentSendFileRequest;", "k", "_glassRequestSendUpdateFileStreamEvent", "D", "glassRequestSendUpdateFileStreamEvent", "_glassSyncCheckingBusinessEvent", "F", "glassSyncCheckingBusinessEvent", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nAirHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AirHelper.kt\ncom/upuphone/xr/sapp/air/AirHelper\n+ 2 GlassMessageHelper.kt\ncom/upuphone/xr/sapp/glass/GlassMessageHelper\n*L\n1#1,576:1\n162#2,8:577\n162#2,8:585\n162#2,8:593\n162#2,8:601\n162#2,8:609\n*S KotlinDebug\n*F\n+ 1 AirHelper.kt\ncom/upuphone/xr/sapp/air/AirHelper\n*L\n96#1:577,8\n104#1:585,8\n118#1:593,8\n126#1:601,8\n159#1:609,8\n*E\n"})
public final class AirHelper implements CoroutineScope {
    public static final AirHelper b = new AirHelper();
    public static final CopyOnWriteArraySet c = new CopyOnWriteArraySet();
    public static final CopyOnWriteArraySet d = new CopyOnWriteArraySet();
    public static final CopyOnWriteArraySet e = new CopyOnWriteArraySet();
    public static final CopyOnWriteArraySet f = new CopyOnWriteArraySet();
    public static final CopyOnWriteArraySet g = new CopyOnWriteArraySet();
    public static final CopyOnWriteArraySet h = new CopyOnWriteArraySet();
    public static final MutableSharedFlow i;
    public static final SharedFlow j;
    public static final MutableSharedFlow k;
    public static final SharedFlow l;
    public static final MutableSharedFlow m;
    public static final SharedFlow n;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f6630a = CoroutineScopeKt.b();

    static {
        MutableSharedFlow b2 = SharedFlowKt.b(0, 0, (BufferOverflow) null, 7, (Object) null);
        i = b2;
        j = FlowKt.b(b2);
        MutableSharedFlow b3 = SharedFlowKt.b(0, 0, (BufferOverflow) null, 7, (Object) null);
        k = b3;
        l = FlowKt.b(b3);
        MutableSharedFlow b4 = SharedFlowKt.b(0, 0, (BufferOverflow) null, 7, (Object) null);
        m = b4;
        n = FlowKt.b(b4);
        GlassMessageHelper glassMessageHelper = GlassMessageHelper.f7054a;
        glassMessageHelper.c("air_ota", "air_glass_update_app_ready", new TwinActionMessageListener() {
            public void a(String str, String str2, String str3) {
                Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
                Intrinsics.checkNotNullParameter(str2, "subAction");
                for (Runnable run : AirHelper.c) {
                    run.run();
                }
                GlassMessageHelper.f7054a.h("air_ota", "air_glass_update_app_ready", JsonUtils.f7893a.d(BasicGlassResponse.Companion.success()));
            }
        });
        glassMessageHelper.c("air_ota", "sync_air_glass_update_result", new AirHelper$special$$inlined$addTwinActionResultListener$1());
        glassMessageHelper.c("air_ota", "sync_air_glass_update_dialog_result", new AirHelper$special$$inlined$addTwinActionResultListener$2());
        glassMessageHelper.c("air_ota", "request_send_air_update_file", new AirHelper$special$$inlined$addTwinActionResultListener$3());
        glassMessageHelper.c("air_ota", "request_sync_air_update_file_info", new AirHelper$special$$inlined$addTwinActionResultListener$4());
        glassMessageHelper.c("air_ota", "sync_air_glass_update_progress", new TwinActionMessageListener() {
            public void a(String str, String str2, String str3) {
                Integer intOrNull;
                Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
                Intrinsics.checkNotNullParameter(str2, "subAction");
                if (str3 != null && (intOrNull = StringsKt.toIntOrNull(str3)) != null) {
                    int intValue = intOrNull.intValue();
                    for (Function1 invoke : AirHelper.h) {
                        invoke.invoke(new GlassUpdateProgress(intValue));
                    }
                }
            }
        });
        glassMessageHelper.c("air_ota", "request_sync_update_info_stream", new TwinActionMessageListener() {
            public void a(String str, String str2, String str3) {
                Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
                Intrinsics.checkNotNullParameter(str2, "subAction");
                Job unused = BuildersKt__Builders_commonKt.d(AirHelper.b, (CoroutineContext) null, (CoroutineStart) null, new AirHelper$7$onMessageReceive$1((Continuation<? super AirHelper$7$onMessageReceive$1>) null), 3, (Object) null);
            }
        });
        glassMessageHelper.c("air_ota", "request_send_update_file_stream", new AirHelper$special$$inlined$addTwinActionResultListener$5());
        glassMessageHelper.c("air_ota", "sync_air_glass_checking_business", new TwinActionMessageListener() {
            public void a(String str, String str2, String str3) {
                Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
                Intrinsics.checkNotNullParameter(str2, "subAction");
                Job unused = BuildersKt__Builders_commonKt.d(AirHelper.b, (CoroutineContext) null, (CoroutineStart) null, new AirHelper$9$onMessageReceive$1((Continuation<? super AirHelper$9$onMessageReceive$1>) null), 3, (Object) null);
            }
        });
    }

    public static /* synthetic */ Object B(AirHelper airHelper, long j2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = 10000;
        }
        return airHelper.A(j2, continuation);
    }

    public static /* synthetic */ Object H(AirHelper airHelper, long j2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = 10000;
        }
        return airHelper.G(j2, continuation);
    }

    public static /* synthetic */ Object N(AirHelper airHelper, BasicGlassResponse basicGlassResponse, long j2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 10000;
        }
        return airHelper.M(basicGlassResponse, j2, continuation);
    }

    public static /* synthetic */ Object P(AirHelper airHelper, List list, long j2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 10000;
        }
        return airHelper.O(list, j2, continuation);
    }

    public static /* synthetic */ Object R(AirHelper airHelper, AirSilentSendFileResponse airSilentSendFileResponse, byte[] bArr, long j2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            j2 = 10000;
        }
        return airHelper.Q(airSilentSendFileResponse, bArr, j2, continuation);
    }

    public static /* synthetic */ Object U(AirHelper airHelper, long j2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = 10000;
        }
        return airHelper.S(j2, continuation);
    }

    public static /* synthetic */ Object W(AirHelper airHelper, long j2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = 10000;
        }
        return airHelper.V(j2, continuation);
    }

    public static /* synthetic */ Object Y(AirHelper airHelper, AirSilentUpdateInfo airSilentUpdateInfo, long j2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 10000;
        }
        return airHelper.X(airSilentUpdateInfo, j2, continuation);
    }

    public static /* synthetic */ Object a0(AirHelper airHelper, AirSilentSendFileResponse airSilentSendFileResponse, byte[] bArr, long j2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            j2 = 10000;
        }
        return airHelper.Z(airSilentSendFileResponse, bArr, j2, continuation);
    }

    public static /* synthetic */ Object c0(AirHelper airHelper, AirSilentUpdateInfo airSilentUpdateInfo, long j2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 10000;
        }
        return airHelper.b0(airSilentUpdateInfo, j2, continuation);
    }

    public static /* synthetic */ Object t(AirHelper airHelper, long j2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = 10000;
        }
        return airHelper.s(j2, continuation);
    }

    public static /* synthetic */ Object w(AirHelper airHelper, long j2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = 10000;
        }
        return airHelper.v(j2, continuation);
    }

    public static /* synthetic */ Object y(AirHelper airHelper, long j2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = 10000;
        }
        return airHelper.x(j2, continuation);
    }

    public final Object A(long j2, Continuation continuation) {
        return TimeoutKt.c(j2, new AirHelper$getAirSilentUpdateVersion$2((Continuation<? super AirHelper$getAirSilentUpdateVersion$2>) null), continuation);
    }

    public final SharedFlow D() {
        return l;
    }

    public final SharedFlow E() {
        return j;
    }

    public final SharedFlow F() {
        return n;
    }

    public final Object G(long j2, Continuation continuation) {
        return TimeoutKt.c(j2, new AirHelper$getRemoteGlassUpdateState$2((Continuation<? super AirHelper$getRemoteGlassUpdateState$2>) null), continuation);
    }

    public final boolean I(StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        StarryNetDeviceManager starryNetDeviceManager = InterconnectManager.getInstance().getStarryNetDeviceManager();
        String deviceInfo = starryNetDeviceManager != null ? starryNetDeviceManager.getDeviceInfo(starryNetDevice.getDeviceId(), 5) : null;
        if (deviceInfo == null) {
            deviceInfo = "";
        }
        return ModelIdExtKt.a(deviceInfo);
    }

    public final boolean K(StarryNetDevice starryNetDevice) {
        String deviceInfo;
        Intrinsics.checkNotNullParameter(starryNetDevice, "device");
        StarryNetDeviceManager starryNetDeviceManager = InterconnectManager.getInstance().getStarryNetDeviceManager();
        if (starryNetDeviceManager == null || (deviceInfo = starryNetDeviceManager.getDeviceInfo(starryNetDevice.getDeviceId(), 5)) == null) {
            return false;
        }
        return ModelIdExtKt.d(deviceInfo);
    }

    public final void L(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        c.remove(runnable);
    }

    public final Object M(BasicGlassResponse basicGlassResponse, long j2, Continuation continuation) {
        Object c2 = TimeoutKt.c(j2, new AirHelper$responseRequestSendFile$2(basicGlassResponse, (Continuation<? super AirHelper$responseRequestSendFile$2>) null), continuation);
        return c2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? c2 : Unit.INSTANCE;
    }

    public final Object O(List list, long j2, Continuation continuation) {
        Object c2 = TimeoutKt.c(j2, new AirHelper$responseRequestSyncUpdateFileInfo$2(list, (Continuation<? super AirHelper$responseRequestSyncUpdateFileInfo$2>) null), continuation);
        return c2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? c2 : Unit.INSTANCE;
    }

    public final Object Q(AirSilentSendFileResponse airSilentSendFileResponse, byte[] bArr, long j2, Continuation continuation) {
        Object c2 = TimeoutKt.c(j2, new AirHelper$sendAirSilentSendFileResponse$2(airSilentSendFileResponse, bArr, (Continuation<? super AirHelper$sendAirSilentSendFileResponse$2>) null), continuation);
        return c2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? c2 : Unit.INSTANCE;
    }

    public final Object S(long j2, Continuation continuation) {
        return TimeoutKt.c(j2, new AirHelper$sendOpenGlassUpdateAppCmd$2((Continuation<? super AirHelper$sendOpenGlassUpdateAppCmd$2>) null), continuation);
    }

    public final Object V(long j2, Continuation continuation) {
        return TimeoutKt.c(j2, new AirHelper$sendShowUpdateDialogCmd$2((Continuation<? super AirHelper$sendShowUpdateDialogCmd$2>) null), continuation);
    }

    public final Object X(AirSilentUpdateInfo airSilentUpdateInfo, long j2, Continuation continuation) {
        Object c2 = TimeoutKt.c(j2, new AirHelper$sendSyncUpdateInfoStream$2(airSilentUpdateInfo, (Continuation<? super AirHelper$sendSyncUpdateInfoStream$2>) null), continuation);
        return c2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? c2 : Unit.INSTANCE;
    }

    public final Object Z(AirSilentSendFileResponse airSilentSendFileResponse, byte[] bArr, long j2, Continuation continuation) {
        Object c2 = TimeoutKt.c(j2, new AirHelper$sendUpdateFileStreamResponse$2(airSilentSendFileResponse, bArr, (Continuation<? super AirHelper$sendUpdateFileStreamResponse$2>) null), continuation);
        return c2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? c2 : Unit.INSTANCE;
    }

    public final Object b0(AirSilentUpdateInfo airSilentUpdateInfo, long j2, Continuation continuation) {
        Object c2 = TimeoutKt.c(j2, new AirHelper$syncAirUpdateFileInfo$2(airSilentUpdateInfo, (Continuation<? super AirHelper$syncAirUpdateFileInfo$2>) null), continuation);
        return c2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? c2 : Unit.INSTANCE;
    }

    public CoroutineContext getCoroutineContext() {
        return this.f6630a.getCoroutineContext();
    }

    public final void l(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        c.add(runnable);
    }

    public final void m(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        e.add(function1);
    }

    public final void n(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        h.add(function1);
    }

    public final void p(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        f.add(function1);
    }

    public final void q(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "callback");
        g.add(function0);
    }

    public final void r(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        d.add(function1);
    }

    public final Object s(long j2, Continuation continuation) {
        Object c2 = TimeoutKt.c(j2, new AirHelper$cancelSilentUpdate$2((Continuation<? super AirHelper$cancelSilentUpdate$2>) null), continuation);
        return c2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? c2 : Unit.INSTANCE;
    }

    public final Object v(long j2, Continuation continuation) {
        return TimeoutKt.c(j2, new AirHelper$getAirGlassInfo$2((Continuation<? super AirHelper$getAirGlassInfo$2>) null), continuation);
    }

    public final Object x(long j2, Continuation continuation) {
        return TimeoutKt.c(j2, new AirHelper$getAirGlassUpdateResult$2((Continuation<? super AirHelper$getAirGlassUpdateResult$2>) null), continuation);
    }
}
