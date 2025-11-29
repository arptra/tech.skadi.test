package com.upuphone.xr.interconnect.business.connect;

import com.upuphone.xr.interconnect.util.log.ILog;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class PeerDeviceStatusManager$startVersionSendJob$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ int $version;
    final /* synthetic */ PeerDeviceStatusManager this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.interconnect.business.connect.PeerDeviceStatusManager$startVersionSendJob$1$1", f = "PeerDeviceStatusManager.kt", i = {}, l = {215}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.interconnect.business.connect.PeerDeviceStatusManager$startVersionSendJob$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(peerDeviceStatusManager2, str2, i2, continuation);
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x00fa  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0039  */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r13.label
                r2 = 1
                if (r1 == 0) goto L_0x0026
                if (r1 != r2) goto L_0x001e
                int r1 = r13.I$2
                int r3 = r13.I$1
                int r4 = r13.I$0
                java.lang.Object r5 = r13.L$1
                java.lang.String r5 = (java.lang.String) r5
                java.lang.Object r6 = r13.L$0
                com.upuphone.xr.interconnect.business.connect.PeerDeviceStatusManager r6 = (com.upuphone.xr.interconnect.business.connect.PeerDeviceStatusManager) r6
                kotlin.ResultKt.throwOnFailure(r14)
                goto L_0x00f7
            L_0x001e:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r14)
                throw r13
            L_0x0026:
                kotlin.ResultKt.throwOnFailure(r14)
                com.upuphone.xr.interconnect.business.connect.PeerDeviceStatusManager r14 = r2
                java.lang.String r1 = r4
                int r3 = r9
                r4 = 2147483647(0x7fffffff, float:NaN)
                r5 = 0
                r6 = r14
                r12 = r5
                r5 = r1
                r1 = r12
            L_0x0037:
                if (r1 >= r4) goto L_0x00fa
                java.util.Map r14 = r6.versionMap
                java.lang.Object r14 = r14.get(r5)
                java.lang.Integer r14 = (java.lang.Integer) r14
                r7 = 0
                if (r14 == 0) goto L_0x006d
                java.lang.String r13 = r6.getTag()
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "startVersionSendJob has get version = "
                r0.append(r1)
                r0.append(r14)
                java.lang.String r14 = r0.toString()
                com.upuphone.xr.interconnect.util.log.ILog.w(r13, r14)
                kotlinx.coroutines.Job r13 = r6.checkVersionSendJob
                if (r13 == 0) goto L_0x0067
                kotlinx.coroutines.Job.DefaultImpls.a(r13, r7, r2, r7)
            L_0x0067:
                r6.checkVersionSendJob = r7
                kotlin.Unit r13 = kotlin.Unit.INSTANCE
                return r13
            L_0x006d:
                java.lang.String r14 = r6.getTag()
                int r8 = r6.mCurSendVersion
                int r9 = r6.mMaxSendCount
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                java.lang.String r11 = "startVersionSendJob launchVersionSendJob to "
                r10.append(r11)
                r10.append(r5)
                java.lang.String r11 = ",version = "
                r10.append(r11)
                r10.append(r3)
                java.lang.String r11 = ",mCurSendVersion = "
                r10.append(r11)
                r10.append(r8)
                java.lang.String r8 = ",mMaxSendCount = "
                r10.append(r8)
                r10.append(r9)
                java.lang.String r8 = r10.toString()
                com.upuphone.xr.interconnect.util.log.ILog.w(r14, r8)
                int r14 = r6.mCurSendVersion
                int r8 = r6.mMaxSendCount
                if (r14 < r8) goto L_0x00c8
                java.lang.String r14 = r6.getTag()
                java.lang.String r8 = "startVersionSendJob downToFirstVersion start"
                com.upuphone.xr.interconnect.util.log.ILog.w(r14, r8)
                r6.downToFirstVersion(r5)
                kotlinx.coroutines.Job r14 = r6.checkVersionSendJob
                if (r14 == 0) goto L_0x00c4
                kotlinx.coroutines.Job.DefaultImpls.a(r14, r7, r2, r7)
            L_0x00c4:
                r6.checkVersionSendJob = r7
                goto L_0x00e0
            L_0x00c8:
                java.lang.String r14 = r6.getTag()
                java.lang.String r7 = "startVersionSendJob launchVersionSendJob start"
                com.upuphone.xr.interconnect.util.log.ILog.w(r14, r7)
                int r14 = r6.mCurSendVersion
                int r14 = r14 + r2
                r6.mCurSendVersion = r14
                com.upuphone.xr.interconnect.business.connect.primary.VersionSendManager r14 = r6.versionSendManager
                r14.launchVersionSendJob(r5, r3)
            L_0x00e0:
                long r7 = r6.mMaxSendVersionDuringTime
                r13.L$0 = r6
                r13.L$1 = r5
                r13.I$0 = r4
                r13.I$1 = r3
                r13.I$2 = r1
                r13.label = r2
                java.lang.Object r14 = kotlinx.coroutines.DelayKt.b(r7, r13)
                if (r14 != r0) goto L_0x00f7
                return r0
            L_0x00f7:
                int r1 = r1 + r2
                goto L_0x0037
            L_0x00fa:
                kotlin.Unit r13 = kotlin.Unit.INSTANCE
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.interconnect.business.connect.PeerDeviceStatusManager$startVersionSendJob$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PeerDeviceStatusManager$startVersionSendJob$1(PeerDeviceStatusManager peerDeviceStatusManager, int i, String str) {
        super(0);
        this.this$0 = peerDeviceStatusManager;
        this.$version = i;
        this.$deviceId = str;
    }

    public final void invoke() {
        String access$getTag = this.this$0.getTag();
        int i = this.$version;
        String str = this.$deviceId;
        ILog.d(access$getTag, "startVersionSendJob to send version " + i + " to #" + str + ".");
        Job access$getCheckVersionSendJob$p = this.this$0.checkVersionSendJob;
        if (access$getCheckVersionSendJob$p != null) {
            Job.DefaultImpls.a(access$getCheckVersionSendJob$p, (CancellationException) null, 1, (Object) null);
        }
        this.this$0.mCurSendVersion = 0;
        PeerDeviceStatusManager peerDeviceStatusManager = this.this$0;
        CoroutineScope a2 = CoroutineScopeKt.a(Dispatchers.b());
        final PeerDeviceStatusManager peerDeviceStatusManager2 = this.this$0;
        final String str2 = this.$deviceId;
        final int i2 = this.$version;
        peerDeviceStatusManager.checkVersionSendJob = BuildersKt__Builders_commonKt.d(a2, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }
}
