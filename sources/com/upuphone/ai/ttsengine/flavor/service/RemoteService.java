package com.upuphone.ai.ttsengine.flavor.service;

import android.content.Context;
import com.honey.account.r3.b;
import com.upuphone.ai.ttsengine.TtsSdk;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import com.upuphone.ai.ttsengine.base.utils.GsonUtils;
import com.upuphone.ai.ttsengine.flavor.service.connect.Communicator;
import com.upuphone.ai.ttsengine.flavor.service.connect.DeviceUtils;
import com.upuphone.ai.ttsengine.protocol.bean.StatusBean;
import com.upuphone.ai.ttsengine.protocol.bean.StopBean;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001BB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u000fJ#\u0010\u0014\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J+\u0010\u0019\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010\u001e\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001b\u001a\u00020\u00172\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#R\u001c\u0010(\u001a\n %*\u0004\u0018\u00010$0$8\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'RT\u0010.\u001aB\u0012\f\u0012\n %*\u0004\u0018\u00010\u00110\u0011\u0012\f\u0012\n %*\u0004\u0018\u00010*0* %* \u0012\f\u0012\n %*\u0004\u0018\u00010\u00110\u0011\u0012\f\u0012\n %*\u0004\u0018\u00010*0*\u0018\u00010+0)8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u00048\u0002@\u0002X.¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X.¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b?\u0010@\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006C"}, d2 = {"Lcom/upuphone/ai/ttsengine/flavor/service/RemoteService;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "j", "(Landroid/content/Context;)V", "k", "", "bytes", "Lkotlin/Result;", "Landroid/os/Bundle;", "p", "([B)Ljava/lang/Object;", "r", "", "caller", "id", "m", "(Ljava/lang/String;Ljava/lang/String;)V", "n", "", "code", "o", "(Ljava/lang/String;Ljava/lang/String;I)V", "status", "Lkotlin/Function0;", "action", "i", "(Ljava/lang/String;ILkotlin/jvm/functions/Function0;)V", "Lcom/upuphone/ai/ttsengine/protocol/bean/StatusBean;", "info", "q", "(Lcom/upuphone/ai/ttsengine/protocol/bean/StatusBean;)V", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "kotlin.jvm.PlatformType", "b", "Lcom/upuphone/ai/ttsengine/base/utils/AILOG;", "aiLog", "", "Lcom/upuphone/ai/ttsengine/flavor/service/RemoteService$SpeakingCallerInfo;", "", "c", "Ljava/util/Map;", "speakingCallers", "Lcom/upuphone/ai/ttsengine/flavor/service/connect/Communicator;", "d", "Lcom/upuphone/ai/ttsengine/flavor/service/connect/Communicator;", "communicator", "e", "Landroid/content/Context;", "application", "Lcom/upuphone/ai/ttsengine/flavor/service/LicenceSender;", "f", "Lcom/upuphone/ai/ttsengine/flavor/service/LicenceSender;", "licenceChecker", "", "g", "Z", "hasInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "h", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInitializing", "SpeakingCallerInfo", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nRemoteService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteService.kt\ncom/upuphone/ai/ttsengine/flavor/service/RemoteService\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,251:1\n1#2:252\n*E\n"})
public final class RemoteService {

    /* renamed from: a  reason: collision with root package name */
    public static final RemoteService f5563a = new RemoteService();
    public static final AILOG b = AILOG.a("RemoteService");
    public static final Map c = Collections.synchronizedMap(new LinkedHashMap());
    public static Communicator d;
    public static Context e;
    public static LicenceSender f;
    public static volatile boolean g;
    public static AtomicBoolean h = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u0019R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u001a\u0010\u0019R\"\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u001b\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/upuphone/ai/ttsengine/flavor/service/RemoteService$SpeakingCallerInfo;", "", "", "caller", "", "priority", "count", "queueMode", "<init>", "(Ljava/lang/String;III)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getCaller", "b", "I", "getPriority", "d", "(I)V", "c", "e", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class SpeakingCallerInfo {

        /* renamed from: a  reason: collision with root package name */
        public final String f5564a;
        public int b;
        public volatile int c;
        public int d;

        public SpeakingCallerInfo(String str, int i, int i2, int i3) {
            Intrinsics.checkNotNullParameter(str, "caller");
            this.f5564a = str;
            this.b = i;
            this.c = i2;
            this.d = i3;
        }

        public final int a() {
            return this.c;
        }

        public final int b() {
            return this.d;
        }

        public final void c(int i) {
            this.c = i;
        }

        public final void d(int i) {
            this.b = i;
        }

        public final void e(int i) {
            this.d = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SpeakingCallerInfo)) {
                return false;
            }
            SpeakingCallerInfo speakingCallerInfo = (SpeakingCallerInfo) obj;
            return Intrinsics.areEqual((Object) this.f5564a, (Object) speakingCallerInfo.f5564a) && this.b == speakingCallerInfo.b && this.c == speakingCallerInfo.c && this.d == speakingCallerInfo.d;
        }

        public int hashCode() {
            return (((((this.f5564a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d);
        }

        public String toString() {
            String str = this.f5564a;
            int i = this.b;
            int i2 = this.c;
            int i3 = this.d;
            return "SpeakingCallerInfo(caller=" + str + ", priority=" + i + ", count=" + i2 + ", queueMode=" + i3 + ")";
        }
    }

    public static final void l(boolean z) {
        if (!z) {
            TtsSdk.u(TtsSdk.f5490a, (String) null, (String) null, 2, (Object) null);
        }
    }

    public final void i(String str, int i, Function0 function0) {
        Object obj;
        if (str != null) {
            if (DeviceUtils.f5567a.a()) {
                function0.invoke();
                obj = Unit.INSTANCE;
            } else {
                Map map = c;
                SpeakingCallerInfo speakingCallerInfo = (SpeakingCallerInfo) map.get(str);
                if (speakingCallerInfo != null) {
                    if (speakingCallerInfo.a() > 0) {
                        function0.invoke();
                        if (i > 0) {
                            speakingCallerInfo.c(speakingCallerInfo.a() - 1);
                        }
                    } else if (i > 0) {
                        map.remove(str);
                    }
                    obj = speakingCallerInfo;
                } else {
                    obj = null;
                }
            }
            if (obj != null) {
                return;
            }
        }
        b.h("caller is null", new Object[0]);
        Unit unit = Unit.INSTANCE;
    }

    public final void j(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AILOG ailog = b;
        ailog.c("init start", new Object[0]);
        if (g) {
            ailog.c("has initialized", new Object[0]);
        } else if (!h.compareAndSet(false, true)) {
            ailog.c("is now initializing", new Object[0]);
        } else {
            h.set(true);
            e = context;
            TtsSdk.f5490a.h(new RemoteService$init$1());
            k();
            Communicator communicator = d;
            if (communicator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("communicator");
                communicator = null;
            }
            f = new LicenceSender(context, communicator, "com.upuphone.ai.ttsengine");
            h.set(false);
            g = true;
            ailog.c("init finished", new Object[0]);
        }
    }

    public final void k() {
        Communicator communicator = new Communicator("com.upuphone.ai.ttsengine.phone");
        d = communicator;
        communicator.g(new RemoteService$initCommunicator$1());
        Communicator communicator2 = d;
        if (communicator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("communicator");
            communicator2 = null;
        }
        communicator2.f(new b());
    }

    public final void m(String str, String str2) {
        AILOG ailog = b;
        ailog.c("onStart caller: " + str + ", id: " + str2, new Object[0]);
        i(str, 0, new RemoteService$onSpeakBegin$1(str, str2));
    }

    public final void n(String str, String str2) {
        AILOG ailog = b;
        ailog.c("onDone caller: " + str + ", id: " + str2, new Object[0]);
        i(str, 1, new RemoteService$onSpeakEnd$1(str, str2));
    }

    public final void o(String str, String str2, int i) {
        AILOG ailog = b;
        ailog.c("onError caller: " + str + ", id: " + str2 + ", code: " + i, new Object[0]);
        i(str, 2, new RemoteService$onSpeakError$1(str, str2, i));
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0086 A[Catch:{ all -> 0x0039 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a9 A[SYNTHETIC, Splitter:B:19:0x00a9] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00cb A[Catch:{ all -> 0x0039 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d5 A[Catch:{ all -> 0x0039 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e2 A[Catch:{ all -> 0x0039 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e6 A[Catch:{ all -> 0x0039 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0104 A[Catch:{ all -> 0x0039 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0121 A[Catch:{ all -> 0x0039 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object p(byte[] r17) {
        /*
            r16 = this;
            r1 = 0
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0039 }
            java.lang.String r0 = kotlin.text.StringsKt.decodeToString(r17)     // Catch:{ all -> 0x0039 }
            java.lang.Class<com.upuphone.ai.ttsengine.protocol.bean.ReadBean> r2 = com.upuphone.ai.ttsengine.protocol.bean.ReadBean.class
            java.lang.Object r0 = com.upuphone.ai.ttsengine.base.utils.GsonUtils.a(r0, r2)     // Catch:{ all -> 0x0039 }
            com.upuphone.ai.ttsengine.protocol.bean.ReadBean r0 = (com.upuphone.ai.ttsengine.protocol.bean.ReadBean) r0     // Catch:{ all -> 0x0039 }
            com.upuphone.ai.ttsengine.base.utils.AILOG r2 = b     // Catch:{ all -> 0x0039 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0039 }
            r3.<init>()     // Catch:{ all -> 0x0039 }
            java.lang.String r4 = "read tts info: "
            r3.append(r4)     // Catch:{ all -> 0x0039 }
            r3.append(r0)     // Catch:{ all -> 0x0039 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0039 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x0039 }
            r2.c(r3, r4)     // Catch:{ all -> 0x0039 }
            java.lang.String r3 = r0.getId()     // Catch:{ all -> 0x0039 }
            if (r3 == 0) goto L_0x003c
            int r3 = r3.length()     // Catch:{ all -> 0x0039 }
            if (r3 != 0) goto L_0x0034
            goto L_0x003c
        L_0x0034:
            java.lang.String r3 = r0.getId()     // Catch:{ all -> 0x0039 }
            goto L_0x0044
        L_0x0039:
            r0 = move-exception
            goto L_0x0192
        L_0x003c:
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0039 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0039 }
        L_0x0044:
            r0.setId(r3)     // Catch:{ all -> 0x0039 }
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x0039 }
            r3.<init>()     // Catch:{ all -> 0x0039 }
            java.lang.String r4 = "utteranceId"
            java.lang.String r5 = r0.getId()     // Catch:{ all -> 0x0039 }
            r3.putString(r4, r5)     // Catch:{ all -> 0x0039 }
            java.lang.String r4 = "caller_priority"
            int r5 = r0.getPriority()     // Catch:{ all -> 0x0039 }
            r3.putInt(r4, r5)     // Catch:{ all -> 0x0039 }
            java.lang.String r4 = "audio_focus_type"
            int r5 = r0.getFocusType()     // Catch:{ all -> 0x0039 }
            r3.putInt(r4, r5)     // Catch:{ all -> 0x0039 }
            java.lang.String r4 = "function_id"
            java.lang.String r5 = r0.getFunctionId()     // Catch:{ all -> 0x0039 }
            r3.putString(r4, r5)     // Catch:{ all -> 0x0039 }
            java.lang.String r4 = "nlg_id"
            java.lang.String r5 = r0.getNlgId()     // Catch:{ all -> 0x0039 }
            r3.putString(r4, r5)     // Catch:{ all -> 0x0039 }
            com.upuphone.ai.ttsengine.helper.ParamsHelper r4 = com.upuphone.ai.ttsengine.helper.ParamsHelper.f5570a     // Catch:{ all -> 0x0039 }
            r4.f(r0, r3)     // Catch:{ all -> 0x0039 }
            java.util.Map r4 = r0.getSlots()     // Catch:{ all -> 0x0039 }
            r13 = 1
            if (r4 == 0) goto L_0x00a2
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)     // Catch:{ all -> 0x0039 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0039 }
            r4 = r4 ^ r13
            if (r4 != r13) goto L_0x00a2
            java.lang.String r4 = "slots"
            java.util.Map r5 = r0.getSlots()     // Catch:{ all -> 0x0039 }
            java.lang.String r6 = "getSlots(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ all -> 0x0039 }
            android.os.Bundle r5 = com.upuphone.ai.ttsengine.base.utils.ExtentionUtilsKt.a(r5)     // Catch:{ all -> 0x0039 }
            r3.putBundle(r4, r5)     // Catch:{ all -> 0x0039 }
        L_0x00a2:
            com.upuphone.ai.ttsengine.flavor.service.connect.Communicator r4 = d     // Catch:{ all -> 0x0039 }
            java.lang.String r5 = "communicator"
            r14 = 0
            if (r4 != 0) goto L_0x00ad
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)     // Catch:{ all -> 0x0039 }
            r4 = r14
        L_0x00ad:
            boolean r4 = r4.h()     // Catch:{ all -> 0x0039 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0039 }
            r6.<init>()     // Catch:{ all -> 0x0039 }
            java.lang.String r7 = "is BR connected: "
            r6.append(r7)     // Catch:{ all -> 0x0039 }
            r6.append(r4)     // Catch:{ all -> 0x0039 }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x0039 }
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x0039 }
            r2.c(r4, r6)     // Catch:{ all -> 0x0039 }
            com.upuphone.ai.ttsengine.flavor.service.connect.Communicator r4 = d     // Catch:{ all -> 0x0039 }
            if (r4 != 0) goto L_0x00cf
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)     // Catch:{ all -> 0x0039 }
            r4 = r14
        L_0x00cf:
            boolean r4 = r4.h()     // Catch:{ all -> 0x0039 }
            if (r4 != 0) goto L_0x00dc
            java.lang.String r4 = "delay_time"
            r5 = 3000(0xbb8, double:1.482E-320)
            r3.putLong(r4, r5)     // Catch:{ all -> 0x0039 }
        L_0x00dc:
            java.lang.String r4 = r0.getCaller()     // Catch:{ all -> 0x0039 }
            if (r4 != 0) goto L_0x00e6
            java.lang.String r4 = "common_caller"
        L_0x00e4:
            r15 = r4
            goto L_0x00ea
        L_0x00e6:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)     // Catch:{ all -> 0x0039 }
            goto L_0x00e4
        L_0x00ea:
            com.upuphone.ai.ttsengine.TtsSdk r4 = com.upuphone.ai.ttsengine.TtsSdk.f5490a     // Catch:{ all -> 0x0039 }
            java.lang.String r6 = r0.getRead()     // Catch:{ all -> 0x0039 }
            int r7 = r0.getQueueMode()     // Catch:{ all -> 0x0039 }
            java.lang.String r9 = r0.getId()     // Catch:{ all -> 0x0039 }
            r11 = 32
            r12 = 0
            r10 = 0
            r5 = r15
            r8 = r3
            boolean r4 = com.upuphone.ai.ttsengine.TtsSdk.q(r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0039 }
            if (r4 != 0) goto L_0x0121
            com.upuphone.ai.ttsengine.protocol.bean.StatusBean r2 = new com.upuphone.ai.ttsengine.protocol.bean.StatusBean     // Catch:{ all -> 0x0039 }
            r2.<init>()     // Catch:{ all -> 0x0039 }
            r2.setCaller(r15)     // Catch:{ all -> 0x0039 }
            java.lang.String r0 = r0.getId()     // Catch:{ all -> 0x0039 }
            r2.setId(r0)     // Catch:{ all -> 0x0039 }
            r0 = 2
            r2.setStatus(r0)     // Catch:{ all -> 0x0039 }
            r0 = 4
            r2.setErrorCode(r0)     // Catch:{ all -> 0x0039 }
            r0 = r16
            r0.q(r2)     // Catch:{ all -> 0x0039 }
            goto L_0x018d
        L_0x0121:
            com.upuphone.ai.ttsengine.flavor.service.connect.DeviceUtils r4 = com.upuphone.ai.ttsengine.flavor.service.connect.DeviceUtils.f5567a     // Catch:{ all -> 0x0039 }
            boolean r4 = r4.a()     // Catch:{ all -> 0x0039 }
            if (r4 != 0) goto L_0x018d
            java.util.Map r4 = c     // Catch:{ all -> 0x0039 }
            java.lang.Object r5 = r4.get(r15)     // Catch:{ all -> 0x0039 }
            com.upuphone.ai.ttsengine.flavor.service.RemoteService$SpeakingCallerInfo r5 = (com.upuphone.ai.ttsengine.flavor.service.RemoteService.SpeakingCallerInfo) r5     // Catch:{ all -> 0x0039 }
            if (r5 == 0) goto L_0x015c
            int r6 = r0.getPriority()     // Catch:{ all -> 0x0039 }
            r5.d(r6)     // Catch:{ all -> 0x0039 }
            int r6 = r5.b()     // Catch:{ all -> 0x0039 }
            r7 = 3
            if (r6 != r7) goto L_0x014b
            int r6 = r0.getQueueMode()     // Catch:{ all -> 0x0039 }
            if (r6 != r7) goto L_0x014b
            r5.c(r13)     // Catch:{ all -> 0x0039 }
            goto L_0x0153
        L_0x014b:
            int r6 = r5.a()     // Catch:{ all -> 0x0039 }
            int r6 = r6 + r13
            r5.c(r6)     // Catch:{ all -> 0x0039 }
        L_0x0153:
            int r6 = r0.getQueueMode()     // Catch:{ all -> 0x0039 }
            r5.e(r6)     // Catch:{ all -> 0x0039 }
            kotlin.Unit r14 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0039 }
        L_0x015c:
            if (r14 != 0) goto L_0x0173
            java.lang.String r5 = "speakingCallers"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ all -> 0x0039 }
            com.upuphone.ai.ttsengine.flavor.service.RemoteService$SpeakingCallerInfo r5 = new com.upuphone.ai.ttsengine.flavor.service.RemoteService$SpeakingCallerInfo     // Catch:{ all -> 0x0039 }
            int r6 = r0.getPriority()     // Catch:{ all -> 0x0039 }
            int r0 = r0.getQueueMode()     // Catch:{ all -> 0x0039 }
            r5.<init>(r15, r6, r13, r0)     // Catch:{ all -> 0x0039 }
            r4.put(r15, r5)     // Catch:{ all -> 0x0039 }
        L_0x0173:
            java.lang.Object r0 = r4.get(r15)     // Catch:{ all -> 0x0039 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0039 }
            r4.<init>()     // Catch:{ all -> 0x0039 }
            java.lang.String r5 = "current count for caller: "
            r4.append(r5)     // Catch:{ all -> 0x0039 }
            r4.append(r0)     // Catch:{ all -> 0x0039 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0039 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x0039 }
            r2.c(r0, r4)     // Catch:{ all -> 0x0039 }
        L_0x018d:
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r3)     // Catch:{ all -> 0x0039 }
            goto L_0x019c
        L_0x0192:
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m20constructorimpl(r0)
        L_0x019c:
            java.lang.Throwable r2 = kotlin.Result.m23exceptionOrNullimpl(r0)
            if (r2 == 0) goto L_0x01be
            com.upuphone.ai.ttsengine.base.utils.AILOG r3 = b
            java.lang.String r2 = r2.getMessage()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "[SaiLog]: call tts speak error: "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r3.h(r2, r1)
        L_0x01be:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ai.ttsengine.flavor.service.RemoteService.p(byte[]):java.lang.Object");
    }

    public final void q(StatusBean statusBean) {
        AILOG ailog = b;
        ailog.c("status tts info: " + statusBean, new Object[0]);
        byte[] bytes = GsonUtils.b(statusBean).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArr = new byte[(bytes.length + 2)];
        bArr[0] = 10;
        bArr[1] = 2;
        ArraysKt.copyInto(bytes, bArr, 2, 0, bytes.length);
        Communicator communicator = d;
        if (communicator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("communicator");
            communicator = null;
        }
        Communicator.j(communicator, bArr, (String) null, "com.upuphone.ai.ttsengine", 2, (Object) null);
    }

    public final Object r(byte[] bArr) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            StopBean stopBean = (StopBean) GsonUtils.a(StringsKt.decodeToString(bArr), StopBean.class);
            AILOG ailog = b;
            ailog.c("stop tts info: " + stopBean, new Object[0]);
            if (stopBean.getType() == 3) {
                TtsSdk ttsSdk = TtsSdk.f5490a;
                String caller = stopBean.getCaller();
                if (caller == null) {
                    caller = "common_caller";
                } else {
                    Intrinsics.checkNotNull(caller);
                }
                TtsSdk.u(ttsSdk, caller, (String) null, 2, (Object) null);
            } else {
                TtsSdk.f5490a.t(stopBean.getPriority(), stopBean.getType());
            }
            obj = Result.m20constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        Throwable r0 = Result.m23exceptionOrNullimpl(obj);
        if (r0 != null) {
            AILOG ailog2 = b;
            String message = r0.getMessage();
            ailog2.h("call stop tts error: " + message, new Object[0]);
        }
        return obj;
    }
}
