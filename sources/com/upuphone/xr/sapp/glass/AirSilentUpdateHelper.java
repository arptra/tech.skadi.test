package com.upuphone.xr.sapp.glass;

import com.upuphone.star.fota.phone.GlassUpdateInfo;
import com.upuphone.xr.sapp.entity.AirSilentSendFileRequest;
import com.upuphone.xr.sapp.entity.AirSilentSendFileResponse;
import com.upuphone.xr.sapp.entity.AirSilentUpdateInfo;
import com.upuphone.xr.sapp.entity.AirUpdateFileInfo;
import com.upuphone.xr.sapp.entity.GlassUpdateDownloadEvent;
import java.io.File;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001+\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\u000b\u001a\u00020\nH@¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0003J\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J!\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010#\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020%8\u0002XD¢\u0006\u0006\n\u0004\b)\u0010'R\u0014\u0010.\u001a\u00020+8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0016X\u0005¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/upuphone/xr/sapp/glass/AirSilentUpdateHelper;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "", "msg", "", "t", "(Ljava/lang/String;)V", "v", "Ljava/io/File;", "file", "", "x", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "q", "r", "Lcom/upuphone/star/fota/phone/GlassUpdateInfo;", "glassUpdateInfo", "downloadFile", "B", "(Lcom/upuphone/star/fota/phone/GlassUpdateInfo;Ljava/io/File;)V", "Lcom/upuphone/xr/sapp/entity/GlassUpdateDownloadEvent;", "downloadEvent", "w", "(Lcom/upuphone/xr/sapp/entity/GlassUpdateDownloadEvent;)V", "p", "Lcom/upuphone/xr/sapp/entity/AirSilentSendFileRequest;", "request", "s", "(Lcom/upuphone/xr/sapp/entity/AirSilentSendFileRequest;)V", "Lcom/upuphone/xr/sapp/entity/AirSilentSendFileResponse;", "response", "", "bytes", "y", "(Lcom/upuphone/xr/sapp/entity/AirSilentSendFileResponse;[B)V", "", "c", "Z", "isGlassSupportSilentUpdate", "d", "isFeatureEnabled", "com/upuphone/xr/sapp/glass/AirSilentUpdateHelper$connectListener$1", "e", "Lcom/upuphone/xr/sapp/glass/AirSilentUpdateHelper$connectListener$1;", "connectListener", "Lcom/upuphone/xr/sapp/entity/AirSilentUpdateInfo;", "f", "Lcom/upuphone/xr/sapp/entity/AirSilentUpdateInfo;", "pendingSilentUpdateInfo", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nAirSilentUpdateHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AirSilentUpdateHelper.kt\ncom/upuphone/xr/sapp/glass/AirSilentUpdateHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 GlassMessageHelper.kt\ncom/upuphone/xr/sapp/glass/GlassMessageHelper\n*L\n1#1,285:1\n766#2:286\n857#2,2:287\n288#2,2:289\n162#3,8:291\n*S KotlinDebug\n*F\n+ 1 AirSilentUpdateHelper.kt\ncom/upuphone/xr/sapp/glass/AirSilentUpdateHelper\n*L\n191#1:286\n191#1:287,2\n240#1:289,2\n84#1:291,8\n*E\n"})
public final class AirSilentUpdateHelper implements CoroutineScope {
    public static final AirSilentUpdateHelper b;
    public static boolean c;
    public static final boolean d = false;
    public static final AirSilentUpdateHelper$connectListener$1 e;
    public static AirSilentUpdateInfo f;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f7038a = CoroutineScopeKt.b();

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.sapp.glass.AirSilentUpdateHelper$2", f = "AirSilentUpdateHelper.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.sapp.glass.AirSilentUpdateHelper$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SharedFlow F0 = GlassUpdateHelper.b.F0();
                AnonymousClass1 r1 = AnonymousClass1.f7039a;
                this.label = 1;
                if (F0.collect(r1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        AirSilentUpdateHelper airSilentUpdateHelper = new AirSilentUpdateHelper();
        b = airSilentUpdateHelper;
        AirSilentUpdateHelper$connectListener$1 airSilentUpdateHelper$connectListener$1 = new AirSilentUpdateHelper$connectListener$1();
        e = airSilentUpdateHelper$connectListener$1;
        GlassHelper.f7049a.l(airSilentUpdateHelper$connectListener$1);
        GlassUpdateHelper.b.I0().observeForever(new AirSilentUpdateHelper$sam$androidx_lifecycle_Observer$0(AnonymousClass1.INSTANCE));
        Job unused = BuildersKt__Builders_commonKt.d(airSilentUpdateHelper, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2((Continuation<? super AnonymousClass2>) null), 3, (Object) null);
        GlassMessageHelper.f7054a.c("air_ota_silence", "request_send_air_update_file", new AirSilentUpdateHelper$special$$inlined$addTwinActionResultListener$1());
    }

    public static /* synthetic */ void A(AirSilentUpdateHelper airSilentUpdateHelper, AirSilentSendFileResponse airSilentSendFileResponse, byte[] bArr, int i, Object obj) {
        if ((i & 2) != 0) {
            bArr = null;
        }
        airSilentUpdateHelper.y(airSilentSendFileResponse, bArr);
    }

    /* access modifiers changed from: private */
    public final void t(String str) {
        GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
        glassUpdateHelper.d1("AirSilentUpdateHelper|" + str);
    }

    /* access modifiers changed from: private */
    public final void v(String str) {
        GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
        glassUpdateHelper.e1("AirSilentUpdateHelper|" + str);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object x(java.io.File r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.upuphone.xr.sapp.glass.AirSilentUpdateHelper$processUpdateFile$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.upuphone.xr.sapp.glass.AirSilentUpdateHelper$processUpdateFile$1 r0 = (com.upuphone.xr.sapp.glass.AirSilentUpdateHelper$processUpdateFile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.glass.AirSilentUpdateHelper$processUpdateFile$1 r0 = new com.upuphone.xr.sapp.glass.AirSilentUpdateHelper$processUpdateFile$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r4 = r0.result
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L_0x0031
            if (r1 != r2) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x0047
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r4)
            kotlinx.coroutines.CoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.b()
            com.upuphone.xr.sapp.glass.AirSilentUpdateHelper$processUpdateFile$files$1 r1 = new com.upuphone.xr.sapp.glass.AirSilentUpdateHelper$processUpdateFile$files$1
            r3 = 0
            r1.<init>(r5, r3)
            r0.label = r2
            java.lang.Object r4 = kotlinx.coroutines.BuildersKt.g(r4, r1, r0)
            if (r4 != r6) goto L_0x0047
            return r6
        L_0x0047:
            java.util.List r4 = (java.util.List) r4
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r4 = r4.iterator()
        L_0x0052:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0069
            java.lang.Object r6 = r4.next()
            r0 = r6
            java.io.File r0 = (java.io.File) r0
            boolean r0 = r0.isFile()
            if (r0 == 0) goto L_0x0052
            r5.add(r6)
            goto L_0x0052
        L_0x0069:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.glass.AirSilentUpdateHelper.x(java.io.File, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void B(GlassUpdateInfo glassUpdateInfo, File file) {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new AirSilentUpdateHelper$syncGlassUpdateInfo$1(file, glassUpdateInfo, (Continuation<? super AirSilentUpdateHelper$syncGlassUpdateInfo$1>) null), 3, (Object) null);
    }

    public CoroutineContext getCoroutineContext() {
        return this.f7038a.getCoroutineContext();
    }

    public final void p() {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new AirSilentUpdateHelper$cancelSilentUpdate$1((Continuation<? super AirSilentUpdateHelper$cancelSilentUpdate$1>) null), 3, (Object) null);
    }

    public final void q() {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new AirSilentUpdateHelper$checkIfGlassSupportSilentUpdate$1((Continuation<? super AirSilentUpdateHelper$checkIfGlassSupportSilentUpdate$1>) null), 3, (Object) null);
    }

    public final void r() {
        if (!d) {
            t("checkIfSyncGlassUpdateInfo, isFeatureEnabled=false");
        } else if (!c) {
            t("checkIfSyncGlassUpdateInfo, isGlassSupportSilentUpdate=false");
        } else {
            GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
            GlassUpdateInfo glassUpdateInfo = (GlassUpdateInfo) glassUpdateHelper.I0().getValue();
            t("checkIfSyncGlassUpdateInfo, glassUpdateInfo: " + glassUpdateInfo);
            if (glassUpdateInfo != null) {
                if (glassUpdateInfo.getExistsUpdate()) {
                    t("checkIfSyncGlassUpdateInfo, startDownload");
                    glassUpdateHelper.H1(glassUpdateInfo, false, false, true);
                    return;
                }
                B(glassUpdateInfo, (File) null);
            }
        }
    }

    public final void s(AirSilentSendFileRequest airSilentSendFileRequest) {
        T t;
        t("handleSendFileRequest: " + airSilentSendFileRequest);
        if (!d) {
            t("handleSendFileRequest, isFeatureEnabled=false");
        } else if (!c) {
            v("handleSendFileRequest, isGlassSupportSilentUpdate=false");
            A(this, AirSilentSendFileResponse.Companion.fail(), (byte[]) null, 2, (Object) null);
        } else {
            AirSilentUpdateInfo airSilentUpdateInfo = f;
            if (airSilentUpdateInfo == null) {
                v("handleSendFileRequest, pendingSilentUpdateInfo is null");
                A(this, AirSilentSendFileResponse.Companion.fail(), (byte[]) null, 2, (Object) null);
                return;
            }
            Iterator<T> it = airSilentUpdateInfo.getInfo().iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                AirUpdateFileInfo airUpdateFileInfo = (AirUpdateFileInfo) t;
                if (Intrinsics.areEqual((Object) airUpdateFileInfo.getFileName(), (Object) airSilentSendFileRequest.getFileName()) && Intrinsics.areEqual((Object) airUpdateFileInfo.getMd5(), (Object) airSilentSendFileRequest.getMd5())) {
                    break;
                }
            }
            AirUpdateFileInfo airUpdateFileInfo2 = (AirUpdateFileInfo) t;
            if (airUpdateFileInfo2 == null || !new File(airUpdateFileInfo2.getFilePath()).exists()) {
                v("handleSendFileRequest, file not exist");
                A(this, AirSilentSendFileResponse.Companion.fail(), (byte[]) null, 2, (Object) null);
                return;
            }
            Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new AirSilentUpdateHelper$handleSendFileRequest$1(airSilentSendFileRequest, airUpdateFileInfo2, (Continuation<? super AirSilentUpdateHelper$handleSendFileRequest$1>) null), 3, (Object) null);
        }
    }

    public final void w(GlassUpdateDownloadEvent glassUpdateDownloadEvent) {
        if (!d) {
            t("onDownload, isFeatureEnabled=false");
        } else if (!c) {
            t("onDownload, isGlassSupportSilentUpdate=false");
        } else if (glassUpdateDownloadEvent.getInstallRequired()) {
            p();
        } else {
            B(glassUpdateDownloadEvent.getGlassUpdateInfo(), glassUpdateDownloadEvent.getDownloadFile());
        }
    }

    public final void y(AirSilentSendFileResponse airSilentSendFileResponse, byte[] bArr) {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new AirSilentUpdateHelper$sendFileResponse$1(airSilentSendFileResponse, bArr, (Continuation<? super AirSilentUpdateHelper$sendFileResponse$1>) null), 3, (Object) null);
    }
}
