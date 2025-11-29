package com.upuphone.xr.sapp.glass;

import com.honey.account.i8.k;
import com.upuphone.star.fota.phone.GlassUpdateInfo;
import com.upuphone.starrynetsdk.StarryNet;
import com.upuphone.starrynetsdk.ability.share.ShareAbility;
import com.upuphone.xr.sapp.entity.GlassUpdateState;
import com.xjsd.ai.assistant.protocol.AssistantConstants;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001NB\u001f\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0006¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nH@¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH@¢\u0006\u0004\b\u000e\u0010\fJ\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH@¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H@¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0019H@¢\u0006\u0004\b\u001a\u0010\fJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0019H@¢\u0006\u0004\b\u001b\u0010\fJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0004H@¢\u0006\u0004\b\u001c\u0010\fJ\u001f\u0010!\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\"\u0010#\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H@¢\u0006\u0004\b#\u0010\u0018J'\u0010%\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u0016H\u0002¢\u0006\u0004\b%\u0010&J'\u0010(\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u0013H\u0002¢\u0006\u0004\b(\u0010)J)\u0010+\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010*\u001a\u00020\u000fH\u0002¢\u0006\u0004\b+\u0010,J/\u0010/\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u000fH\u0002¢\u0006\u0004\b/\u00100J\u0019\u00101\u001a\u00020\u00052\b\b\u0002\u0010*\u001a\u00020\u000fH\u0002¢\u0006\u0004\b1\u00102J)\u00103\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020\u000fH\u0002¢\u0006\u0004\b3\u00104R$\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u00105R\u001b\u0010:\u001a\u0002068BX\u0002¢\u0006\f\n\u0004\b\u001b\u00107\u001a\u0004\b8\u00109R\u0014\u0010=\u001a\u00020;8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010?R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010?R\u0016\u0010B\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010+R\u0016\u0010D\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010CR\u0018\u0010F\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bE\u0010?R\u0014\u0010J\u001a\u00020G8\u0016X\u0005¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0014\u0010M\u001a\u00020\u000f8BX\u0004¢\u0006\u0006\u001a\u0004\bK\u0010L¨\u0006O"}, d2 = {"Lcom/upuphone/xr/sapp/glass/StarGlassUpdater;", "Lcom/upuphone/xr/sapp/glass/IGlassUpdater;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Function1;", "Lcom/upuphone/xr/sapp/entity/GlassUpdateState;", "", "Lcom/upuphone/xr/sapp/glass/GlassUpdateStateCallback;", "stateCallback", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/upuphone/xr/sapp/entity/StarGlassInfo;", "j", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "e", "", "requiredStorage", "f", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "version", "digest", "", "h", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/upuphone/xr/sapp/entity/BasicGlassResponse;", "a", "c", "d", "Ljava/io/File;", "downloadFile", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "glassUpdateInfo", "g", "(Ljava/io/File;Lcom/upuphone/star/fota/phone/GlassUpdateInfo;)V", "D", "isFirstTime", "M", "(Ljava/io/File;Lcom/upuphone/star/fota/phone/GlassUpdateInfo;Z)V", "uid", "H", "(Ljava/io/File;Lcom/upuphone/star/fota/phone/GlassUpdateInfo;Ljava/lang/String;)V", "delayTime", "I", "(Ljava/io/File;Lcom/upuphone/star/fota/phone/GlassUpdateInfo;J)V", "taskId", "delayFailTime", "L", "(Ljava/lang/String;Lcom/upuphone/star/fota/phone/GlassUpdateInfo;Ljava/lang/String;J)V", "N", "(J)V", "G", "(Lcom/upuphone/star/fota/phone/GlassUpdateInfo;Ljava/lang/String;J)V", "Lkotlin/jvm/functions/Function1;", "Lcom/upuphone/starrynetsdk/ability/share/ShareAbility;", "Lkotlin/Lazy;", "F", "()Lcom/upuphone/starrynetsdk/ability/share/ShareAbility;", "shareAbility", "Lcom/upuphone/xr/sapp/glass/FilterShareListener;", "Lcom/upuphone/xr/sapp/glass/FilterShareListener;", "filterShareListener", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "transferFileJob", "restartTransferFileJob", "transferCount", "Z", "isTransferCanceled", "i", "installUpdateJob", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "E", "()J", "glassDelayFailTime", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class StarGlassUpdater implements IGlassUpdater, CoroutineScope {
    public static final Companion j = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f7070a;
    public final /* synthetic */ CoroutineScope b = CoroutineScopeKt.b();
    public final Lazy c = LazyKt.lazy(StarGlassUpdater$shareAbility$2.INSTANCE);
    public final FilterShareListener d = new FilterShareListener();
    public Job e;
    public Job f;
    public int g;
    public volatile boolean h;
    public Job i;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\r8\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0014\u0010\u0014\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/upuphone/xr/sapp/glass/StarGlassUpdater$Companion;", "", "<init>", "()V", "", "msg", "", "c", "(Ljava/lang/String;)V", "d", "", "GLASS_DELAY_FAIL_TIME", "J", "", "MAX_RETRY_COUNT", "I", "MAX_RETRY_INTERVAL", "MAX_TRANSFER_COUNT", "MIN_RETRY_INTERVAL", "RESTART_TRANSFER_DELAY", "TAG", "Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void c(String str) {
            GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
            glassUpdateHelper.d1("StarGlassUpdater|" + str);
        }

        public final void d(String str) {
            GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
            glassUpdateHelper.e1("StarGlassUpdater|" + str);
        }

        public Companion() {
        }
    }

    public StarGlassUpdater(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "stateCallback");
        this.f7070a = function1;
        StarryNet.getInstance().registerInstallListener(new k(this));
    }

    /* access modifiers changed from: private */
    public final ShareAbility F() {
        return (ShareAbility) this.c.getValue();
    }

    public static /* synthetic */ void K(StarGlassUpdater starGlassUpdater, File file, GlassUpdateInfo glassUpdateInfo, long j2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            j2 = AssistantConstants.TIMEOUT_VAD_MUTE;
        }
        starGlassUpdater.I(file, glassUpdateInfo, j2);
    }

    public static final void l(StarGlassUpdater starGlassUpdater) {
        Intrinsics.checkNotNullParameter(starGlassUpdater, "this$0");
        Companion companion = j;
        companion.c("StarryNet onInstalled, initShareAbility");
        ShareAbility F = starGlassUpdater.F();
        int unregisterSendListener = F.unregisterSendListener(starGlassUpdater.d);
        companion.c("unregisterSendListener code: " + unregisterSendListener);
        int registerSendListener = F.registerSendListener(starGlassUpdater.d);
        companion.c("registerSendListener code: " + registerSendListener);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0086 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.upuphone.xr.sapp.glass.StarGlassUpdater$checkGlassUpdateFileInner$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.upuphone.xr.sapp.glass.StarGlassUpdater$checkGlassUpdateFileInner$1 r0 = (com.upuphone.xr.sapp.glass.StarGlassUpdater$checkGlassUpdateFileInner$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0014
            int r1 = r1 - r2
            r0.label = r1
        L_0x0012:
            r5 = r0
            goto L_0x001a
        L_0x0014:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$checkGlassUpdateFileInner$1 r0 = new com.upuphone.xr.sapp.glass.StarGlassUpdater$checkGlassUpdateFileInner$1
            r0.<init>(r10, r13)
            goto L_0x0012
        L_0x001a:
            java.lang.Object r10 = r5.result
            java.lang.Object r13 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r5.label
            r8 = 0
            r9 = 1
            if (r0 == 0) goto L_0x0036
            if (r0 != r9) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ Exception -> 0x002c }
            goto L_0x0054
        L_0x002c:
            r10 = move-exception
            goto L_0x0057
        L_0x002e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r10)
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r10 = j     // Catch:{ Exception -> 0x002c }
            java.lang.String r0 = "checkGlassUpdateFile start"
            r10.c(r0)     // Catch:{ Exception -> 0x002c }
            com.upuphone.xr.sapp.glass.GlassHelper r1 = com.upuphone.xr.sapp.glass.GlassHelper.f7049a     // Catch:{ Exception -> 0x002c }
            com.upuphone.xr.sapp.entity.CheckGlassUpdateFileCmd r2 = new com.upuphone.xr.sapp.entity.CheckGlassUpdateFileCmd     // Catch:{ Exception -> 0x002c }
            r2.<init>(r11, r12)     // Catch:{ Exception -> 0x002c }
            r5.label = r9     // Catch:{ Exception -> 0x002c }
            r3 = 0
            r6 = 2
            r7 = 0
            java.lang.Object r10 = com.upuphone.xr.sapp.glass.GlassHelper.t(r1, r2, r3, r5, r6, r7)     // Catch:{ Exception -> 0x002c }
            if (r10 != r13) goto L_0x0054
            return r13
        L_0x0054:
            com.upuphone.xr.sapp.entity.CheckGlassUpdateFileResult r10 = (com.upuphone.xr.sapp.entity.CheckGlassUpdateFileResult) r10     // Catch:{ Exception -> 0x002c }
            goto L_0x006e
        L_0x0057:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r11 = j
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "checkGlassUpdateFile error: "
            r12.append(r13)
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            r11.d(r10)
            r10 = r8
        L_0x006e:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r11 = j
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "checkGlassUpdateFile result: "
            r12.append(r13)
            r12.append(r10)
            java.lang.String r12 = r12.toString()
            r11.c(r12)
            if (r10 != 0) goto L_0x0087
            return r8
        L_0x0087:
            boolean r11 = r10.isSuccess()
            if (r11 == 0) goto L_0x009c
            java.lang.Boolean r10 = r10.getExist()
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            if (r10 == 0) goto L_0x009c
            goto L_0x009d
        L_0x009c:
            r9 = 0
        L_0x009d:
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.StarGlassUpdater.D(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final long E() {
        return this.g >= 2 ? 0 : 10000;
    }

    public final void G(GlassUpdateInfo glassUpdateInfo, String str, long j2) {
        Job job = this.i;
        if (job == null || !job.isActive()) {
            this.i = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new StarGlassUpdater$installUpdate$1(j2, this, str, glassUpdateInfo, (Continuation<? super StarGlassUpdater$installUpdate$1>) null), 3, (Object) null);
        } else {
            j.c("installUpdate, installUpdateJob.isActive, return");
        }
    }

    public final void H(File file, GlassUpdateInfo glassUpdateInfo, String str) {
        Companion companion = j;
        int i2 = this.g;
        boolean z = this.h;
        companion.c("onTransferFileFail, transferCount: " + i2 + ", isTransferCanceled: " + z + ", glassUpdateInfo: " + glassUpdateInfo);
        if (this.g >= 2 || this.h) {
            this.f7070a.invoke(new GlassUpdateState.TransferFail(str, glassUpdateInfo, 114, (String) null, 8, (DefaultConstructorMarker) null));
        } else {
            K(this, file, glassUpdateInfo, 0, 4, (Object) null);
        }
    }

    public final void I(File file, GlassUpdateInfo glassUpdateInfo, long j2) {
        Job job = this.f;
        if (job == null || !job.isActive()) {
            this.f = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new StarGlassUpdater$restartTransferFile$1(j2, glassUpdateInfo, this, file, (Continuation<? super StarGlassUpdater$restartTransferFile$1>) null), 3, (Object) null);
        } else {
            j.c("restartTransferFileJob.isActive, return");
        }
    }

    public final void L(String str, GlassUpdateInfo glassUpdateInfo, String str2, long j2) {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new StarGlassUpdater$sendReceiveGlassUpdateCmd$1(glassUpdateInfo, this, str2, str, j2, (Continuation<? super StarGlassUpdater$sendReceiveGlassUpdateCmd$1>) null), 3, (Object) null);
    }

    public final void M(File file, GlassUpdateInfo glassUpdateInfo, boolean z) {
        Job job = this.e;
        if (job == null || !job.isActive()) {
            this.e = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new StarGlassUpdater$transferFileInner$1(glassUpdateInfo, this, z, file, (Continuation<? super StarGlassUpdater$transferFileInner$1>) null), 3, (Object) null);
        } else {
            j.c("transferFileInner, transferFileJob.isActive=true, return");
        }
    }

    public final void N(long j2) {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new StarGlassUpdater$tryReleaseP2p$1(j2, (Continuation<? super StarGlassUpdater$tryReleaseP2p$1>) null), 3, (Object) null);
    }

    public Object a(Continuation continuation) {
        return GlassHelper.R(GlassHelper.f7049a, 0, continuation, 1, (Object) null);
    }

    public Object c(Continuation continuation) {
        return GlassHelper.L(GlassHelper.f7049a, 0, continuation, 1, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object d(kotlin.coroutines.Continuation r18) {
        /*
            r17 = this;
            r0 = r18
            boolean r1 = r0 instanceof com.upuphone.xr.sapp.glass.StarGlassUpdater$fetchGlassUpdateState$1
            if (r1 == 0) goto L_0x0017
            r1 = r0
            com.upuphone.xr.sapp.glass.StarGlassUpdater$fetchGlassUpdateState$1 r1 = (com.upuphone.xr.sapp.glass.StarGlassUpdater$fetchGlassUpdateState$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.label = r2
            r2 = r17
            goto L_0x001e
        L_0x0017:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$fetchGlassUpdateState$1 r1 = new com.upuphone.xr.sapp.glass.StarGlassUpdater$fetchGlassUpdateState$1
            r2 = r17
            r1.<init>(r2, r0)
        L_0x001e:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 2
            r6 = 1
            r7 = 0
            if (r4 == 0) goto L_0x004f
            if (r4 == r6) goto L_0x0043
            if (r4 != r5) goto L_0x003b
            int r2 = r1.I$0
            java.lang.Object r4 = r1.L$0
            com.upuphone.xr.sapp.glass.StarGlassUpdater r4 = (com.upuphone.xr.sapp.glass.StarGlassUpdater) r4
            kotlin.ResultKt.throwOnFailure(r0)
        L_0x0038:
            r0 = r2
            r2 = r4
            goto L_0x0053
        L_0x003b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0043:
            int r2 = r1.I$0
            java.lang.Object r4 = r1.L$0
            com.upuphone.xr.sapp.glass.StarGlassUpdater r4 = (com.upuphone.xr.sapp.glass.StarGlassUpdater) r4
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ Exception -> 0x004d }
            goto L_0x00ae
        L_0x004d:
            r0 = move-exception
            goto L_0x00b7
        L_0x004f:
            kotlin.ResultKt.throwOnFailure(r0)
            r0 = 0
        L_0x0053:
            kotlin.coroutines.CoroutineContext r4 = r2.getCoroutineContext()
            boolean r4 = kotlinx.coroutines.JobKt.l(r4)
            if (r4 == 0) goto L_0x0173
            com.upuphone.xr.sapp.glass.GlassHelper r8 = com.upuphone.xr.sapp.glass.GlassHelper.f7049a
            boolean r4 = r8.E()
            if (r4 != 0) goto L_0x006e
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r0 = j
            java.lang.String r1 = "fetchGlassUpdateState, isGlassConnected=false, break"
            r0.c(r1)
            goto L_0x0173
        L_0x006e:
            com.upuphone.xr.sapp.glass.GlassUpdateHelper r4 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.b
            boolean r4 = r4.Q0()
            if (r4 != 0) goto L_0x007f
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r0 = j
            java.lang.String r1 = "fetchGlassUpdateState, needCheckGlassUpdateResult=false, break"
            r0.c(r1)
            goto L_0x0173
        L_0x007f:
            int r4 = r0 + 1
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r0 = j
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "fetchGlassUpdateState start: "
            r9.append(r10)
            r9.append(r4)
            java.lang.String r9 = r9.toString()
            r0.c(r9)
            r1.L$0 = r2     // Catch:{ Exception -> 0x00b1 }
            r1.I$0 = r4     // Catch:{ Exception -> 0x00b1 }
            r1.label = r6     // Catch:{ Exception -> 0x00b1 }
            r9 = 0
            r12 = 1
            r13 = 0
            r11 = r1
            java.lang.Object r0 = com.upuphone.xr.sapp.glass.GlassHelper.C(r8, r9, r11, r12, r13)     // Catch:{ Exception -> 0x00b1 }
            if (r0 != r3) goto L_0x00a9
            return r3
        L_0x00a9:
            r16 = r4
            r4 = r2
            r2 = r16
        L_0x00ae:
            com.upuphone.xr.sapp.entity.RemoteGlassUpdateState r0 = (com.upuphone.xr.sapp.entity.RemoteGlassUpdateState) r0     // Catch:{ Exception -> 0x004d }
            goto L_0x00ce
        L_0x00b1:
            r0 = move-exception
            r16 = r4
            r4 = r2
            r2 = r16
        L_0x00b7:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r8 = j
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "fetchGlassUpdateState error: "
            r9.append(r10)
            r9.append(r0)
            java.lang.String r0 = r9.toString()
            r8.d(r0)
            r0 = r7
        L_0x00ce:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r8 = j
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "fetchGlassUpdateState result: "
            r9.append(r10)
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            r8.c(r9)
            if (r0 == 0) goto L_0x013e
            boolean r9 = r0.isSuccess()
            if (r9 == 0) goto L_0x013e
            java.lang.String r12 = r0.getVersion()
            int r9 = r0.getStateCode()
            switch(r9) {
                case 100: goto L_0x0136;
                case 101: goto L_0x0130;
                case 102: goto L_0x0110;
                case 103: goto L_0x0130;
                case 104: goto L_0x0110;
                case 105: goto L_0x0130;
                case 106: goto L_0x0110;
                case 107: goto L_0x00f7;
                case 108: goto L_0x00fd;
                case 109: goto L_0x0130;
                default: goto L_0x00f7;
            }
        L_0x00f7:
            java.lang.String r0 = "remoteGlassUpdateState, unknown, return"
            r8.c(r0)
            return r7
        L_0x00fd:
            java.lang.String r1 = "remoteGlassUpdateState, SUCCESS, return"
            r8.c(r1)
            com.upuphone.xr.sapp.entity.GlassUpdateState$GlassUpdateSuccess r1 = new com.upuphone.xr.sapp.entity.GlassUpdateState$GlassUpdateSuccess
            java.lang.String r2 = r0.getUid()
            java.lang.String r0 = r0.getDigest()
            r1.<init>(r2, r12, r0)
            return r1
        L_0x0110:
            java.lang.String r1 = "remoteGlassUpdateState, FAIL, return"
            r8.c(r1)
            com.upuphone.xr.sapp.entity.GlassUpdateState$GlassUpdateFail r1 = new com.upuphone.xr.sapp.entity.GlassUpdateState$GlassUpdateFail
            java.lang.String r11 = r0.getUid()
            java.lang.String r13 = r0.getDigest()
            java.lang.String r14 = r0.getMsg()
            int r0 = r0.getCode()
            java.lang.String r15 = java.lang.String.valueOf(r0)
            r10 = r1
            r10.<init>(r11, r12, r13, r14, r15)
            return r1
        L_0x0130:
            java.lang.String r0 = "remoteGlassUpdateState, INSTALLING, keep trying"
            r8.c(r0)
            goto L_0x013e
        L_0x0136:
            java.lang.String r0 = "remoteGlassUpdateState, IDLE, return GlassUpdateIdle"
            r8.c(r0)
            com.upuphone.xr.sapp.entity.GlassUpdateState$GlassUpdateIdle r0 = com.upuphone.xr.sapp.entity.GlassUpdateState.GlassUpdateIdle.INSTANCE
            return r0
        L_0x013e:
            r0 = 300(0x12c, float:4.2E-43)
            if (r2 <= r0) goto L_0x015c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "fetchGlassUpdateState, reach maximum count: "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r1 = ", return"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.c(r0)
            return r7
        L_0x015c:
            r8 = 5000(0x1388, double:2.4703E-320)
            long r10 = (long) r2
            long r10 = r10 * r8
            r8 = 30000(0x7530, double:1.4822E-319)
            long r8 = kotlin.ranges.RangesKt.coerceAtMost((long) r10, (long) r8)
            r1.L$0 = r4
            r1.I$0 = r2
            r1.label = r5
            java.lang.Object r0 = kotlinx.coroutines.DelayKt.b(r8, r1)
            if (r0 != r3) goto L_0x0038
            return r3
        L_0x0173:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r0 = j
            java.lang.String r1 = "fetchGlassUpdateState, end"
            r0.c(r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.StarGlassUpdater.d(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object e(kotlin.coroutines.Continuation r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.upuphone.xr.sapp.glass.StarGlassUpdater$checkRemoteGlassUpdateState$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.upuphone.xr.sapp.glass.StarGlassUpdater$checkRemoteGlassUpdateState$1 r0 = (com.upuphone.xr.sapp.glass.StarGlassUpdater$checkRemoteGlassUpdateState$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0014
            int r1 = r1 - r2
            r0.label = r1
        L_0x0012:
            r4 = r0
            goto L_0x001a
        L_0x0014:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$checkRemoteGlassUpdateState$1 r0 = new com.upuphone.xr.sapp.glass.StarGlassUpdater$checkRemoteGlassUpdateState$1
            r0.<init>(r9, r10)
            goto L_0x0012
        L_0x001a:
            java.lang.Object r9 = r4.result
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r4.label
            java.lang.String r7 = "checkRemoteGlassUpdateState, getRemoteGlassUpdateState error: "
            r8 = 1
            if (r0 == 0) goto L_0x0039
            if (r0 != r8) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ TimeoutCancellationException -> 0x002f, Exception -> 0x002d }
            goto L_0x0052
        L_0x002d:
            r9 = move-exception
            goto L_0x0055
        L_0x002f:
            r9 = move-exception
            goto L_0x009f
        L_0x0031:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r9)
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r9 = j     // Catch:{ TimeoutCancellationException -> 0x002f, Exception -> 0x002d }
            java.lang.String r0 = "checkRemoteGlassUpdateState, getRemoteGlassUpdateState start"
            r9.c(r0)     // Catch:{ TimeoutCancellationException -> 0x002f, Exception -> 0x002d }
            com.upuphone.xr.sapp.glass.GlassHelper r1 = com.upuphone.xr.sapp.glass.GlassHelper.f7049a     // Catch:{ TimeoutCancellationException -> 0x002f, Exception -> 0x002d }
            r4.label = r8     // Catch:{ TimeoutCancellationException -> 0x002f, Exception -> 0x002d }
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r9 = com.upuphone.xr.sapp.glass.GlassHelper.C(r1, r2, r4, r5, r6)     // Catch:{ TimeoutCancellationException -> 0x002f, Exception -> 0x002d }
            if (r9 != r10) goto L_0x0052
            return r10
        L_0x0052:
            com.upuphone.xr.sapp.entity.RemoteGlassUpdateState r9 = (com.upuphone.xr.sapp.entity.RemoteGlassUpdateState) r9     // Catch:{ TimeoutCancellationException -> 0x002f, Exception -> 0x002d }
            goto L_0x006a
        L_0x0055:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r10 = j
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r10.d(r9)
            r9 = 0
        L_0x006a:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r10 = j
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "checkRemoteGlassUpdateState, remoteGlassUpdateState: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            r10.c(r0)
            if (r9 != 0) goto L_0x0089
            r9 = 115(0x73, float:1.61E-43)
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            return r9
        L_0x0089:
            boolean r9 = r9.isUpdating()
            if (r9 == 0) goto L_0x0099
            java.lang.String r9 = "checkRemoteGlassUpdateState, remoteGlassUpdateState isUpdating"
            r10.c(r9)
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            return r9
        L_0x0099:
            r9 = 0
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            return r9
        L_0x009f:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r10 = j
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r10.d(r9)
            r9 = 116(0x74, float:1.63E-43)
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.StarGlassUpdater.e(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object f(long r7, kotlin.coroutines.Continuation r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.upuphone.xr.sapp.glass.StarGlassUpdater$checkGlassInfo$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.upuphone.xr.sapp.glass.StarGlassUpdater$checkGlassInfo$1 r0 = (com.upuphone.xr.sapp.glass.StarGlassUpdater$checkGlassInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$checkGlassInfo$1 r0 = new com.upuphone.xr.sapp.glass.StarGlassUpdater$checkGlassInfo$1
            r0.<init>(r6, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "checkGlassInfo, getGlassInfo error: "
            r4 = 103(0x67, float:1.44E-43)
            r5 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r5) goto L_0x0035
            long r7 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ TimeoutCancellationException -> 0x0032, Exception -> 0x002f }
            goto L_0x0052
        L_0x002f:
            r6 = move-exception
            goto L_0x00d6
        L_0x0032:
            r6 = move-exception
            goto L_0x00ef
        L_0x0035:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r9 = j     // Catch:{ TimeoutCancellationException -> 0x0032, Exception -> 0x002f }
            java.lang.String r2 = "checkGlassInfo, getGlassInfo start"
            r9.c(r2)     // Catch:{ TimeoutCancellationException -> 0x0032, Exception -> 0x002f }
            r0.J$0 = r7     // Catch:{ TimeoutCancellationException -> 0x0032, Exception -> 0x002f }
            r0.label = r5     // Catch:{ TimeoutCancellationException -> 0x0032, Exception -> 0x002f }
            java.lang.Object r9 = r6.j(r0)     // Catch:{ TimeoutCancellationException -> 0x0032, Exception -> 0x002f }
            if (r9 != r1) goto L_0x0052
            return r1
        L_0x0052:
            com.upuphone.xr.sapp.entity.StarGlassInfo r9 = (com.upuphone.xr.sapp.entity.StarGlassInfo) r9     // Catch:{ TimeoutCancellationException -> 0x0032, Exception -> 0x002f }
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r6 = j
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "checkGlassInfo, glassInfo: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            r6.c(r0)
            if (r9 != 0) goto L_0x0071
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            return r6
        L_0x0071:
            int r0 = r9.getBattery()
            com.upuphone.xr.sapp.glass.GlassUpdateHelper r1 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.b
            int r1 = r1.E0()
            if (r0 >= r1) goto L_0x009c
            int r7 = r9.getBattery()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "checkGlassInfo, low battery: "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            r6.c(r7)
            r6 = 105(0x69, float:1.47E-43)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        L_0x009c:
            long r0 = r9.getStorageAvailableBytes()
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x00d0
            long r0 = r9.getStorageAvailableBytes()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r2 = "checkGlassInfo, storageAvailableBytes("
            r9.append(r2)
            r9.append(r0)
            java.lang.String r0 = ") < requiredStorage("
            r9.append(r0)
            r9.append(r7)
            java.lang.String r7 = ")"
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            r6.c(r7)
            r6 = 106(0x6a, float:1.49E-43)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        L_0x00d0:
            r6 = 0
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        L_0x00d6:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r7 = j
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r3)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r7.d(r6)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            return r6
        L_0x00ef:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$Companion r7 = j
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r3)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r7.d(r6)
            r6 = 104(0x68, float:1.46E-43)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.StarGlassUpdater.f(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void g(File file, GlassUpdateInfo glassUpdateInfo) {
        Intrinsics.checkNotNullParameter(file, "downloadFile");
        Intrinsics.checkNotNullParameter(glassUpdateInfo, "glassUpdateInfo");
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new StarGlassUpdater$transferFileAndInstall$1(this, glassUpdateInfo, file, (Continuation<? super StarGlassUpdater$transferFileAndInstall$1>) null), 3, (Object) null);
    }

    public CoroutineContext getCoroutineContext() {
        return this.b.getCoroutineContext();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object h(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.upuphone.xr.sapp.glass.StarGlassUpdater$checkGlassUpdateFile$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.upuphone.xr.sapp.glass.StarGlassUpdater$checkGlassUpdateFile$1 r0 = (com.upuphone.xr.sapp.glass.StarGlassUpdater$checkGlassUpdateFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.glass.StarGlassUpdater$checkGlassUpdateFile$1 r0 = new com.upuphone.xr.sapp.glass.StarGlassUpdater$checkGlassUpdateFile$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x003d
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.label = r3
            java.lang.Object r7 = r4.D(r5, r6, r0)
            if (r7 != r1) goto L_0x003d
            return r1
        L_0x003d:
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r4)
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.StarGlassUpdater.h(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object j(Continuation continuation) {
        return GlassHelper.A(GlassHelper.f7049a, 0, continuation, 1, (Object) null);
    }
}
