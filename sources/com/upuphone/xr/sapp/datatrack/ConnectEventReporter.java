package com.upuphone.xr.sapp.datatrack;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u001f !\"B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u0006H@¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u000fR\"\u0010\u001a\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u000fR\u0014\u0010\u001e\u001a\u00020\u001b8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006#"}, d2 = {"Lcom/upuphone/xr/sapp/datatrack/ConnectEventReporter;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "", "code", "", "reason", "", "h", "(ILjava/lang/String;)V", "e", "", "success", "k", "(Z)V", "g", "p", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "Z", "()Z", "n", "unpairFromMyvu", "d", "m", "isNeedTipGlassUnbind", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "ConnectEvent", "DisconnectEvent", "PairEvent", "UnpairEvent", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ConnectEventReporter implements CoroutineScope {
    public static final ConnectEventReporter b = new ConnectEventReporter();
    public static boolean c;
    public static boolean d;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f6913a = CoroutineScopeKt.b();

    public static /* synthetic */ void f(ConnectEventReporter connectEventReporter, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "";
        }
        connectEventReporter.e(i, str);
    }

    public static /* synthetic */ void j(ConnectEventReporter connectEventReporter, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "";
        }
        connectEventReporter.h(i, str);
    }

    public static /* synthetic */ void l(ConnectEventReporter connectEventReporter, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        connectEventReporter.k(z);
    }

    public final boolean c() {
        return c;
    }

    public final boolean d() {
        return d;
    }

    public final void e(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "reason");
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new ConnectEventReporter$reportConnectEvent$1(i, str, (Continuation<? super ConnectEventReporter$reportConnectEvent$1>) null), 3, (Object) null);
    }

    public final void g() {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new ConnectEventReporter$reportDisconnectEvent$1((Continuation<? super ConnectEventReporter$reportDisconnectEvent$1>) null), 3, (Object) null);
    }

    public CoroutineContext getCoroutineContext() {
        return this.f6913a.getCoroutineContext();
    }

    public final void h(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "reason");
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new ConnectEventReporter$reportPairEvent$1(i, str, (Continuation<? super ConnectEventReporter$reportPairEvent$1>) null), 3, (Object) null);
    }

    public final void k(boolean z) {
        Job unused = BuildersKt__Builders_commonKt.d(this, (CoroutineContext) null, (CoroutineStart) null, new ConnectEventReporter$reportUnpairEvent$1(z, (Continuation<? super ConnectEventReporter$reportUnpairEvent$1>) null), 3, (Object) null);
    }

    public final void m(boolean z) {
        d = z;
    }

    public final void n(boolean z) {
        c = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object p(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.upuphone.xr.sapp.datatrack.ConnectEventReporter$waitRomVersion$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.upuphone.xr.sapp.datatrack.ConnectEventReporter$waitRomVersion$1 r0 = (com.upuphone.xr.sapp.datatrack.ConnectEventReporter$waitRomVersion$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.upuphone.xr.sapp.datatrack.ConnectEventReporter$waitRomVersion$1 r0 = new com.upuphone.xr.sapp.datatrack.ConnectEventReporter$waitRomVersion$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r4 = r0.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L_0x0031
            if (r1 != r2) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r4)     // Catch:{ Exception -> 0x0046 }
            goto L_0x0045
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r4)
            com.upuphone.xr.sapp.datatrack.ConnectEventReporter$waitRomVersion$2 r4 = new com.upuphone.xr.sapp.datatrack.ConnectEventReporter$waitRomVersion$2     // Catch:{ Exception -> 0x0046 }
            r1 = 0
            r4.<init>(r1)     // Catch:{ Exception -> 0x0046 }
            r0.label = r2     // Catch:{ Exception -> 0x0046 }
            r1 = 3000(0xbb8, double:1.482E-320)
            java.lang.Object r4 = kotlinx.coroutines.TimeoutKt.c(r1, r4, r0)     // Catch:{ Exception -> 0x0046 }
            if (r4 != r5) goto L_0x0045
            return r5
        L_0x0045:
            return r4
        L_0x0046:
            com.upuphone.star.core.log.ULog$Delegate r4 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r5 = "ConnectEventReporter"
            java.lang.String r0 = "checkDeviceInfoReady  timeout, rom version is empty"
            r4.g(r5, r0)
            java.lang.String r4 = ""
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.datatrack.ConnectEventReporter.p(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Keep
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/upuphone/xr/sapp/datatrack/ConnectEventReporter$UnpairEvent;", "Lcom/upuphone/xr/sapp/datatrack/DataTrackEvent;", "unpair_result", "", "unpair_ways", "ver", "", "rom_version", "devices_type", "phone_starrynet_version", "(IILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getUnpair_result", "()I", "getUnpair_ways", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class UnpairEvent extends DataTrackEvent {
        private final int unpair_result;
        private final int unpair_ways;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ UnpairEvent(int i, int i2, String str, String str2, int i3, String str3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 3 : i2, (i4 & 4) != 0 ? "1.0.0" : str, str2, i3, str3);
        }

        public final int getUnpair_result() {
            return this.unpair_result;
        }

        public final int getUnpair_ways() {
            return this.unpair_ways;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public UnpairEvent(int r14, int r15, @org.jetbrains.annotations.NotNull java.lang.String r16, @org.jetbrains.annotations.NotNull java.lang.String r17, int r18, @org.jetbrains.annotations.NotNull java.lang.String r19) {
            /*
                r13 = this;
                r12 = r13
                java.lang.String r0 = "ver"
                r2 = r16
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r0 = "rom_version"
                r3 = r17
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                java.lang.String r0 = "phone_starrynet_version"
                r7 = r19
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                r10 = 432(0x1b0, float:6.05E-43)
                r11 = 0
                java.lang.String r1 = "starrynet_unpair"
                r5 = 0
                r6 = 0
                r8 = 0
                r9 = 0
                r0 = r13
                r4 = r18
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                r0 = r14
                r12.unpair_result = r0
                r0 = r15
                r12.unpair_ways = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.datatrack.ConnectEventReporter.UnpairEvent.<init>(int, int, java.lang.String, java.lang.String, int, java.lang.String):void");
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0002\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/datatrack/ConnectEventReporter$ConnectEvent;", "Lcom/upuphone/xr/sapp/datatrack/DataTrackEvent;", "devices_reconnect_result", "", "time_devices_reconnect", "reason_devices_reconnect", "", "bt_reconnect_times", "result_bt_reconnect", "ver", "rom_version", "devices_type", "phone_starrynet_version", "(IILjava/lang/String;IILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getBt_reconnect_times", "()I", "getDevices_reconnect_result", "getReason_devices_reconnect", "()Ljava/lang/String;", "getResult_bt_reconnect", "getTime_devices_reconnect", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ConnectEvent extends DataTrackEvent {
        private final int bt_reconnect_times;
        private final int devices_reconnect_result;
        @NotNull
        private final String reason_devices_reconnect;
        private final int result_bt_reconnect;
        private final int time_devices_reconnect;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ConnectEvent(int i, int i2, String str, int i3, int i4, String str2, String str3, int i5, String str4, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? -1 : i2, (i6 & 4) != 0 ? "" : str, (i6 & 8) != 0 ? -1 : i3, i4, (i6 & 32) != 0 ? "1.0.0" : str2, str3, i5, str4);
        }

        public final int getBt_reconnect_times() {
            return this.bt_reconnect_times;
        }

        public final int getDevices_reconnect_result() {
            return this.devices_reconnect_result;
        }

        @NotNull
        public final String getReason_devices_reconnect() {
            return this.reason_devices_reconnect;
        }

        public final int getResult_bt_reconnect() {
            return this.result_bt_reconnect;
        }

        public final int getTime_devices_reconnect() {
            return this.time_devices_reconnect;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ConnectEvent(int r15, int r16, @org.jetbrains.annotations.NotNull java.lang.String r17, int r18, int r19, @org.jetbrains.annotations.NotNull java.lang.String r20, @org.jetbrains.annotations.NotNull java.lang.String r21, int r22, @org.jetbrains.annotations.NotNull java.lang.String r23) {
            /*
                r14 = this;
                r12 = r14
                r13 = r17
                java.lang.String r0 = "reason_devices_reconnect"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
                java.lang.String r0 = "ver"
                r2 = r20
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r0 = "rom_version"
                r3 = r21
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                java.lang.String r0 = "phone_starrynet_version"
                r7 = r23
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                r10 = 432(0x1b0, float:6.05E-43)
                r11 = 0
                java.lang.String r1 = "starrynet_devices_reconnect"
                r5 = 0
                r6 = 0
                r8 = 0
                r9 = 0
                r0 = r14
                r4 = r22
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                r0 = r15
                r12.devices_reconnect_result = r0
                r0 = r16
                r12.time_devices_reconnect = r0
                r12.reason_devices_reconnect = r13
                r0 = r18
                r12.bt_reconnect_times = r0
                r0 = r19
                r12.result_bt_reconnect = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.datatrack.ConnectEventReporter.ConnectEvent.<init>(int, int, java.lang.String, int, int, java.lang.String, java.lang.String, int, java.lang.String):void");
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/datatrack/ConnectEventReporter$DisconnectEvent;", "Lcom/upuphone/xr/sapp/datatrack/DataTrackEvent;", "reason_devices_disconnect", "", "wear_state", "", "ver", "rom_version", "devices_type", "phone_starrynet_version", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getReason_devices_disconnect", "()Ljava/lang/String;", "getWear_state", "()I", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DisconnectEvent extends DataTrackEvent {
        @NotNull
        private final String reason_devices_disconnect;
        private final int wear_state;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ DisconnectEvent(String str, int i, String str2, String str3, int i2, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? -1 : i, (i3 & 4) != 0 ? "1.0.0" : str2, str3, i2, str4);
        }

        @NotNull
        public final String getReason_devices_disconnect() {
            return this.reason_devices_disconnect;
        }

        public final int getWear_state() {
            return this.wear_state;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public DisconnectEvent(@org.jetbrains.annotations.NotNull java.lang.String r15, int r16, @org.jetbrains.annotations.NotNull java.lang.String r17, @org.jetbrains.annotations.NotNull java.lang.String r18, int r19, @org.jetbrains.annotations.NotNull java.lang.String r20) {
            /*
                r14 = this;
                r12 = r14
                r13 = r15
                java.lang.String r0 = "reason_devices_disconnect"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
                java.lang.String r0 = "ver"
                r2 = r17
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r0 = "rom_version"
                r3 = r18
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                java.lang.String r0 = "phone_starrynet_version"
                r7 = r20
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                r10 = 432(0x1b0, float:6.05E-43)
                r11 = 0
                java.lang.String r1 = "starrynet_devices_disconnect"
                r5 = 0
                r6 = 0
                r8 = 0
                r9 = 0
                r0 = r14
                r4 = r19
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                r12.reason_devices_disconnect = r13
                r0 = r16
                r12.wear_state = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.datatrack.ConnectEventReporter.DisconnectEvent.<init>(java.lang.String, int, java.lang.String, java.lang.String, int, java.lang.String):void");
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0002\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/datatrack/ConnectEventReporter$PairEvent;", "Lcom/upuphone/xr/sapp/datatrack/DataTrackEvent;", "devices_match_result", "", "devices_match_times", "reason_fail_devices_match_result", "", "time_ble_connect", "time_bt_connect", "ver", "rom_version", "devices_type", "phone_starrynet_version", "(IILjava/lang/String;IILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getDevices_match_result", "()I", "getDevices_match_times", "getReason_fail_devices_match_result", "()Ljava/lang/String;", "getTime_ble_connect", "getTime_bt_connect", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PairEvent extends DataTrackEvent {
        private final int devices_match_result;
        private final int devices_match_times;
        @NotNull
        private final String reason_fail_devices_match_result;
        private final int time_ble_connect;
        private final int time_bt_connect;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PairEvent(int i, int i2, String str, int i3, int i4, String str2, String str3, int i5, String str4, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? -1 : i2, (i6 & 4) != 0 ? "" : str, (i6 & 8) != 0 ? -1 : i3, (i6 & 16) != 0 ? -1 : i4, (i6 & 32) != 0 ? "1.0.0" : str2, str3, i5, str4);
        }

        public final int getDevices_match_result() {
            return this.devices_match_result;
        }

        public final int getDevices_match_times() {
            return this.devices_match_times;
        }

        @NotNull
        public final String getReason_fail_devices_match_result() {
            return this.reason_fail_devices_match_result;
        }

        public final int getTime_ble_connect() {
            return this.time_ble_connect;
        }

        public final int getTime_bt_connect() {
            return this.time_bt_connect;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public PairEvent(int r15, int r16, @org.jetbrains.annotations.NotNull java.lang.String r17, int r18, int r19, @org.jetbrains.annotations.NotNull java.lang.String r20, @org.jetbrains.annotations.NotNull java.lang.String r21, int r22, @org.jetbrains.annotations.NotNull java.lang.String r23) {
            /*
                r14 = this;
                r12 = r14
                r13 = r17
                java.lang.String r0 = "reason_fail_devices_match_result"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
                java.lang.String r0 = "ver"
                r2 = r20
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r0 = "rom_version"
                r3 = r21
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                java.lang.String r0 = "phone_starrynet_version"
                r7 = r23
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                r10 = 432(0x1b0, float:6.05E-43)
                r11 = 0
                java.lang.String r1 = "starrynet_devices_match"
                r5 = 0
                r6 = 0
                r8 = 0
                r9 = 0
                r0 = r14
                r4 = r22
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
                r0 = r15
                r12.devices_match_result = r0
                r0 = r16
                r12.devices_match_times = r0
                r12.reason_fail_devices_match_result = r13
                r0 = r18
                r12.time_ble_connect = r0
                r0 = r19
                r12.time_bt_connect = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.datatrack.ConnectEventReporter.PairEvent.<init>(int, int, java.lang.String, int, int, java.lang.String, java.lang.String, int, java.lang.String):void");
        }
    }
}
