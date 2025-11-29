package com.upuphone.xr.sapp.unicron;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.honey.account.view.web.WebJs;
import com.upuphone.xr.sapp.entity.BasicGlassResponse;
import com.upuphone.xr.sapp.entity.CheckUpdateFileReq;
import com.upuphone.xr.sapp.entity.ReceiveUnicronUpdateFileCmd;
import com.upuphone.xr.sapp.entity.RequestUpdateFileReq;
import com.upuphone.xr.sapp.entity.UnicronInfo;
import com.upuphone.xr.sapp.entity.UnicronUpdateInfo;
import com.upuphone.xr.sapp.glass.GlassMessageHelper;
import com.upuphone.xr.sapp.glass.TwinActionMessageListener;
import com.upuphone.xr.sapp.utils.JsonUtils;
import java.lang.reflect.Type;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutKt;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\f\u0010\rJ$\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u0011\u0010\u0012J$\u0010\u0015\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0005\u001a\u00020\u0004H@¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u001b\u001a\u00020\u00182\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00180\u0017j\u0002`\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001f\u001a\u00020\u00182\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00180\u0017j\u0002`\u001e¢\u0006\u0004\b\u001f\u0010\u001cJ\u0015\u0010!\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0010¢\u0006\u0004\b!\u0010\"R*\u0010&\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00180\u0017j\u0002`\u00190#8\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R*\u0010'\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00180\u0017j\u0002`\u001e0#8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010%¨\u0006("}, d2 = {"Lcom/upuphone/xr/sapp/unicron/UnicronHelper;", "", "<init>", "()V", "", "timeout", "Lcom/upuphone/xr/sapp/entity/UnicronInfo;", "g", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/xr/sapp/entity/CheckUpdateFileReq;", "req", "Lcom/upuphone/xr/sapp/entity/CheckUpdateFileResp;", "e", "(Lcom/upuphone/xr/sapp/entity/CheckUpdateFileReq;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/xr/sapp/entity/ReceiveUnicronUpdateFileCmd;", "receiveUnicronUpdateFileCmd", "Lcom/upuphone/xr/sapp/entity/BasicGlassResponse;", "i", "(Lcom/upuphone/xr/sapp/entity/ReceiveUnicronUpdateFileCmd;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/xr/sapp/entity/UnicronUpdateInfo;", "unicronUpdateInfo", "l", "(Lcom/upuphone/xr/sapp/entity/UnicronUpdateInfo;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "Lcom/upuphone/xr/sapp/unicron/CheckUnicronUpdateListener;", "listener", "c", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/upuphone/xr/sapp/entity/RequestUpdateFileReq;", "Lcom/upuphone/xr/sapp/unicron/RequestUpdateFileListener;", "d", "response", "k", "(Lcom/upuphone/xr/sapp/entity/BasicGlassResponse;)V", "Ljava/util/concurrent/CopyOnWriteArraySet;", "b", "Ljava/util/concurrent/CopyOnWriteArraySet;", "checkUnicronUpdateListeners", "requestUpdateFileListeners", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class UnicronHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final UnicronHelper f7834a = new UnicronHelper();
    public static final CopyOnWriteArraySet b = new CopyOnWriteArraySet();
    public static final CopyOnWriteArraySet c = new CopyOnWriteArraySet();

    static {
        GlassMessageHelper glassMessageHelper = GlassMessageHelper.f7054a;
        glassMessageHelper.c("unicron_ota", "check_unicron_update", new TwinActionMessageListener() {
            public void a(String str, String str2, String str3) {
                Object obj;
                Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
                Intrinsics.checkNotNullParameter(str2, "subAction");
                JsonUtils jsonUtils = JsonUtils.f7893a;
                Type type = new UnicronHelper$1$onMessageReceive$$inlined$fromJson$1().getType();
                if (Intrinsics.areEqual((Object) type, (Object) Unit.INSTANCE.getClass()) || Intrinsics.areEqual((Object) type, (Object) Void.class)) {
                    Intrinsics.checkNotNull(type);
                    obj = jsonUtils.a("{}", type);
                } else {
                    Intrinsics.checkNotNull(type);
                    obj = jsonUtils.a(str3, type);
                }
                UnicronInfo unicronInfo = (UnicronInfo) obj;
                if (unicronInfo != null) {
                    for (Function1 invoke : UnicronHelper.b) {
                        invoke.invoke(unicronInfo);
                    }
                }
            }
        });
        glassMessageHelper.c("unicron_ota", "request_send_update_file", new TwinActionMessageListener() {
            public void a(String str, String str2, String str3) {
                Object obj;
                Intrinsics.checkNotNullParameter(str, WebJs.ACTION);
                Intrinsics.checkNotNullParameter(str2, "subAction");
                JsonUtils jsonUtils = JsonUtils.f7893a;
                Type type = new UnicronHelper$2$onMessageReceive$$inlined$fromJson$1().getType();
                if (Intrinsics.areEqual((Object) type, (Object) Unit.INSTANCE.getClass()) || Intrinsics.areEqual((Object) type, (Object) Void.class)) {
                    Intrinsics.checkNotNull(type);
                    obj = jsonUtils.a("{}", type);
                } else {
                    Intrinsics.checkNotNull(type);
                    obj = jsonUtils.a(str3, type);
                }
                RequestUpdateFileReq requestUpdateFileReq = (RequestUpdateFileReq) obj;
                if (requestUpdateFileReq != null) {
                    for (Function1 invoke : UnicronHelper.c) {
                        invoke.invoke(requestUpdateFileReq);
                    }
                }
            }
        });
    }

    public static /* synthetic */ Object f(UnicronHelper unicronHelper, CheckUpdateFileReq checkUpdateFileReq, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 10000;
        }
        return unicronHelper.e(checkUpdateFileReq, j, continuation);
    }

    public static /* synthetic */ Object h(UnicronHelper unicronHelper, long j, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 10000;
        }
        return unicronHelper.g(j, continuation);
    }

    public static /* synthetic */ Object j(UnicronHelper unicronHelper, ReceiveUnicronUpdateFileCmd receiveUnicronUpdateFileCmd, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 10000;
        }
        return unicronHelper.i(receiveUnicronUpdateFileCmd, j, continuation);
    }

    public static /* synthetic */ Object m(UnicronHelper unicronHelper, UnicronUpdateInfo unicronUpdateInfo, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 10000;
        }
        return unicronHelper.l(unicronUpdateInfo, j, continuation);
    }

    public final void c(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        b.add(function1);
    }

    public final void d(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        c.add(function1);
    }

    public final Object e(CheckUpdateFileReq checkUpdateFileReq, long j, Continuation continuation) {
        return TimeoutKt.c(j, new UnicronHelper$checkUpdateFile$2(checkUpdateFileReq, (Continuation<? super UnicronHelper$checkUpdateFile$2>) null), continuation);
    }

    public final Object g(long j, Continuation continuation) {
        return TimeoutKt.c(j, new UnicronHelper$getUnicronInfo$2((Continuation<? super UnicronHelper$getUnicronInfo$2>) null), continuation);
    }

    public final Object i(ReceiveUnicronUpdateFileCmd receiveUnicronUpdateFileCmd, long j, Continuation continuation) {
        return TimeoutKt.c(j, new UnicronHelper$sendReceiveUpdateFileCmd$2(receiveUnicronUpdateFileCmd, (Continuation<? super UnicronHelper$sendReceiveUpdateFileCmd$2>) null), continuation);
    }

    public final void k(BasicGlassResponse basicGlassResponse) {
        Intrinsics.checkNotNullParameter(basicGlassResponse, "response");
        GlassMessageHelper.f7054a.h("unicron_ota", "request_send_update_file", JsonUtils.f7893a.d(basicGlassResponse));
    }

    public final Object l(UnicronUpdateInfo unicronUpdateInfo, long j, Continuation continuation) {
        return TimeoutKt.c(j, new UnicronHelper$syncUnicronUpdateInfo$2(unicronUpdateInfo, (Continuation<? super UnicronHelper$syncUnicronUpdateInfo$2>) null), continuation);
    }
}
