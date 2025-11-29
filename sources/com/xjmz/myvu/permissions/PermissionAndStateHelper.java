package com.xjmz.myvu.permissions;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.bluetooth.BluetoothHelper;
import com.xjmz.myvu.exception.ContinuationException;
import com.xjmz.myvu.location.LocationHelper;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0007*\u00015\u0018\u0000 92\u00020\u0001:\u0001:B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005H@¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005H@¢\u0006\u0004\b\u0011\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0005H@¢\u0006\u0004\b\u0012\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\tH@¢\u0006\u0004\b\u0013\u0010\u0010J\u0010\u0010\u0014\u001a\u00020\u0005H@¢\u0006\u0004\b\u0014\u0010\u0010J\u0010\u0010\u0015\u001a\u00020\u0005H@¢\u0006\u0004\b\u0015\u0010\u0010J\u0010\u0010\u0016\u001a\u00020\tH@¢\u0006\u0004\b\u0016\u0010\u0010J\u0010\u0010\u0017\u001a\u00020\u0005H@¢\u0006\u0004\b\u0017\u0010\u0010J\u0010\u0010\u0018\u001a\u00020\u0005H@¢\u0006\u0004\b\u0018\u0010\u0010J\u0010\u0010\u0019\u001a\u00020\tH@¢\u0006\u0004\b\u0019\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010(\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010#R\u0016\u0010*\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010#R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u001e\u00102\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u001e\u00104\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00101R\u0014\u00108\u001a\u0002058\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/xjmz/myvu/permissions/PermissionAndStateHelper;", "", "Landroidx/fragment/app/FragmentActivity;", "activity", "Lkotlin/Function0;", "", "onEnd", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lkotlin/jvm/functions/Function0;)V", "", "isRestart", "m", "(Z)V", "p", "()V", "o", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "w", "x", "t", "s", "z", "r", "y", "v", "u", "a", "Landroidx/fragment/app/FragmentActivity;", "q", "()Landroidx/fragment/app/FragmentActivity;", "b", "Lkotlin/jvm/functions/Function0;", "getOnEnd", "()Lkotlin/jvm/functions/Function0;", "c", "Z", "needLocationState", "d", "needLocationPermission", "e", "needBtState", "f", "needBtPermission", "Lkotlinx/coroutines/Job;", "g", "Lkotlinx/coroutines/Job;", "permissionJob", "Lkotlinx/coroutines/Deferred;", "h", "Lkotlinx/coroutines/Deferred;", "waitBluetoothStateJob", "i", "waitGpsStateJob", "com/xjmz/myvu/permissions/PermissionAndStateHelper$bluetoothListener$1", "j", "Lcom/xjmz/myvu/permissions/PermissionAndStateHelper$bluetoothListener$1;", "bluetoothListener", "k", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PermissionAndStateHelper {
    public static final Companion k = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final FragmentActivity f8370a;
    public final Function0 b;
    public boolean c = true;
    public boolean d = true;
    public boolean e = true;
    public boolean f = true;
    public Job g;
    public Deferred h;
    public Deferred i;
    public final PermissionAndStateHelper$bluetoothListener$1 j;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.xjmz.myvu.permissions.PermissionAndStateHelper$1", f = "PermissionAndStateHelper.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.xjmz.myvu.permissions.PermissionAndStateHelper$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PermissionAndStateHelper this$0;

        {
            this.this$0 = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SharedFlow b = LocationHelper.f8361a.b();
                final PermissionAndStateHelper permissionAndStateHelper = this.this$0;
                AnonymousClass1 r1 = new FlowCollector() {
                    /* renamed from: d */
                    public final Object emit(Unit unit, Continuation continuation) {
                        ULog.Delegate delegate = ULog.f6446a;
                        delegate.g("PermissionAndStateHelper", "providerChangedEvent");
                        Deferred c = permissionAndStateHelper.i;
                        if (c != null && c.isActive() && LocationHelper.f8361a.c()) {
                            delegate.g("PermissionAndStateHelper", "providerChangedEvent, waitGpsStateJob.cancel");
                            Deferred c2 = permissionAndStateHelper.i;
                            if (c2 != null) {
                                c2.a(new ContinuationException("GPS enabled"));
                            }
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (b.collect(r1, this) == coroutine_suspended) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjmz/myvu/permissions/PermissionAndStateHelper$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public PermissionAndStateHelper(FragmentActivity fragmentActivity, Function0 function0) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(function0, "onEnd");
        this.f8370a = fragmentActivity;
        this.b = function0;
        PermissionAndStateHelper$bluetoothListener$1 permissionAndStateHelper$bluetoothListener$1 = new PermissionAndStateHelper$bluetoothListener$1(this);
        this.j = permissionAndStateHelper$bluetoothListener$1;
        BluetoothHelper.f6650a.b(fragmentActivity, permissionAndStateHelper$bluetoothListener$1);
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(fragmentActivity), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    public static /* synthetic */ void n(PermissionAndStateHelper permissionAndStateHelper, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        permissionAndStateHelper.m(z);
    }

    public final void m(boolean z) {
        Job job;
        if (z && (job = this.g) != null) {
            Job.DefaultImpls.a(job, (CancellationException) null, 1, (Object) null);
        }
        Job job2 = this.g;
        if (job2 == null || !job2.isActive()) {
            this.g = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this.f8370a), (CoroutineContext) null, (CoroutineStart) null, new PermissionAndStateHelper$check$1(this, (Continuation<? super PermissionAndStateHelper$check$1>) null), 3, (Object) null);
        } else {
            ULog.f6446a.g("PermissionAndStateHelper", "check, permissionJob?.isActive=true, return");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object o(kotlin.coroutines.Continuation r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.xjmz.myvu.permissions.PermissionAndStateHelper$checkPermissionAndState$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.xjmz.myvu.permissions.PermissionAndStateHelper$checkPermissionAndState$1 r0 = (com.xjmz.myvu.permissions.PermissionAndStateHelper$checkPermissionAndState$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjmz.myvu.permissions.PermissionAndStateHelper$checkPermissionAndState$1 r0 = new com.xjmz.myvu.permissions.PermissionAndStateHelper$checkPermissionAndState$1
            r0.<init>(r12, r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            java.lang.String r5 = "PermissionAndStateHelper"
            switch(r2) {
                case 0: goto L_0x0077;
                case 1: goto L_0x006b;
                case 2: goto L_0x0062;
                case 3: goto L_0x0053;
                case 4: goto L_0x004a;
                case 5: goto L_0x0041;
                case 6: goto L_0x0038;
                case 7: goto L_0x002f;
                default: goto L_0x0027;
            }
        L_0x0027:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x002f:
            java.lang.Object r12 = r0.L$0
            com.xjmz.myvu.permissions.PermissionAndStateHelper r12 = (com.xjmz.myvu.permissions.PermissionAndStateHelper) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x01c9
        L_0x0038:
            java.lang.Object r12 = r0.L$0
            com.xjmz.myvu.permissions.PermissionAndStateHelper r12 = (com.xjmz.myvu.permissions.PermissionAndStateHelper) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x01d9
        L_0x0041:
            java.lang.Object r12 = r0.L$0
            com.xjmz.myvu.permissions.PermissionAndStateHelper r12 = (com.xjmz.myvu.permissions.PermissionAndStateHelper) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0169
        L_0x004a:
            java.lang.Object r12 = r0.L$0
            com.xjmz.myvu.permissions.PermissionAndStateHelper r12 = (com.xjmz.myvu.permissions.PermissionAndStateHelper) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0139
        L_0x0053:
            java.lang.Object r12 = r0.L$0
            com.xjmz.myvu.permissions.PermissionAndStateHelper r12 = (com.xjmz.myvu.permissions.PermissionAndStateHelper) r12
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ ContinuationException -> 0x005f, CancellationException -> 0x005c }
            goto L_0x0125
        L_0x005c:
            r12 = move-exception
            goto L_0x010d
        L_0x005f:
            r13 = move-exception
            goto L_0x010e
        L_0x0062:
            java.lang.Object r12 = r0.L$0
            com.xjmz.myvu.permissions.PermissionAndStateHelper r12 = (com.xjmz.myvu.permissions.PermissionAndStateHelper) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00ea
        L_0x006b:
            java.lang.Object r12 = r0.L$0
            com.xjmz.myvu.permissions.PermissionAndStateHelper r12 = (com.xjmz.myvu.permissions.PermissionAndStateHelper) r12
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ ContinuationException -> 0x0075, CancellationException -> 0x0073 }
            goto L_0x00de
        L_0x0073:
            r12 = move-exception
            goto L_0x00c6
        L_0x0075:
            r13 = move-exception
            goto L_0x00c7
        L_0x0077:
            kotlin.ResultKt.throwOnFailure(r13)
            com.upuphone.star.core.log.ULog$Delegate r13 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.Boolean r2 = com.upuphone.xr.sapp.BuildConfig.b
            java.lang.Boolean r6 = com.upuphone.xr.sapp.BuildConfig.f6575a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "checkPermissionAndState, start, THIRD_PLATFORM: "
            r7.append(r8)
            r7.append(r2)
            java.lang.String r2 = ", COUNTRY_INTL: "
            r7.append(r2)
            r7.append(r6)
            java.lang.String r2 = r7.toString()
            r13.g(r5, r2)
            com.upuphone.xr.sapp.utils.OSHelper r13 = com.upuphone.xr.sapp.utils.OSHelper.f7904a
            boolean r13 = r13.b()
            if (r13 == 0) goto L_0x00ea
            androidx.fragment.app.FragmentActivity r13 = r12.f8370a
            androidx.lifecycle.LifecycleCoroutineScope r6 = androidx.lifecycle.LifecycleOwnerKt.a(r13)
            com.xjmz.myvu.permissions.PermissionAndStateHelper$checkPermissionAndState$2 r9 = new com.xjmz.myvu.permissions.PermissionAndStateHelper$checkPermissionAndState$2
            r9.<init>(r12, r3)
            r10 = 3
            r11 = 0
            r7 = 0
            r8 = 0
            kotlinx.coroutines.Deferred r13 = kotlinx.coroutines.BuildersKt__Builders_commonKt.b(r6, r7, r8, r9, r10, r11)
            r12.i = r13
            if (r13 == 0) goto L_0x00de
            r0.L$0 = r12     // Catch:{ ContinuationException -> 0x0075, CancellationException -> 0x0073 }
            r0.label = r4     // Catch:{ ContinuationException -> 0x0075, CancellationException -> 0x0073 }
            java.lang.Object r13 = r13.c(r0)     // Catch:{ ContinuationException -> 0x0075, CancellationException -> 0x0073 }
            if (r13 != r1) goto L_0x00de
            return r1
        L_0x00c6:
            throw r12
        L_0x00c7:
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "waitForLocationState, continue with: "
            r6.append(r7)
            r6.append(r13)
            java.lang.String r13 = r6.toString()
            r2.c(r5, r13)
        L_0x00de:
            r0.L$0 = r12
            r13 = 2
            r0.label = r13
            java.lang.Object r13 = r12.x(r0)
            if (r13 != r1) goto L_0x00ea
            return r1
        L_0x00ea:
            androidx.fragment.app.FragmentActivity r13 = r12.f8370a
            androidx.lifecycle.LifecycleCoroutineScope r6 = androidx.lifecycle.LifecycleOwnerKt.a(r13)
            com.xjmz.myvu.permissions.PermissionAndStateHelper$checkPermissionAndState$3 r9 = new com.xjmz.myvu.permissions.PermissionAndStateHelper$checkPermissionAndState$3
            r9.<init>(r12, r3)
            r10 = 3
            r11 = 0
            r7 = 0
            r8 = 0
            kotlinx.coroutines.Deferred r13 = kotlinx.coroutines.BuildersKt__Builders_commonKt.b(r6, r7, r8, r9, r10, r11)
            r12.h = r13
            if (r13 == 0) goto L_0x0125
            r0.L$0 = r12     // Catch:{ ContinuationException -> 0x005f, CancellationException -> 0x005c }
            r2 = 3
            r0.label = r2     // Catch:{ ContinuationException -> 0x005f, CancellationException -> 0x005c }
            java.lang.Object r13 = r13.c(r0)     // Catch:{ ContinuationException -> 0x005f, CancellationException -> 0x005c }
            if (r13 != r1) goto L_0x0125
            return r1
        L_0x010d:
            throw r12
        L_0x010e:
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "waitForBluetoothState, continue with : "
            r3.append(r6)
            r3.append(r13)
            java.lang.String r13 = r3.toString()
            r2.c(r5, r13)
        L_0x0125:
            com.upuphone.xr.sapp.utils.OSHelper r13 = com.upuphone.xr.sapp.utils.OSHelper.f7904a
            boolean r13 = r13.a()
            if (r13 == 0) goto L_0x0139
            r0.L$0 = r12
            r13 = 4
            r0.label = r13
            java.lang.Object r13 = r12.s(r0)
            if (r13 != r1) goto L_0x0139
            return r1
        L_0x0139:
            java.lang.Boolean r13 = com.upuphone.xr.sapp.BuildConfig.b
            boolean r13 = r13.booleanValue()
            r2 = 0
            if (r13 != 0) goto L_0x01a1
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r13 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r6 = r13.a()
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            r10 = 4
            r11 = 0
            java.lang.String r7 = "flyme_permission_check"
            r9 = 0
            java.lang.Object r13 = com.upuphone.xr.sapp.utils.DataStoreUtils.i(r6, r7, r8, r9, r10, r11)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L_0x0195
            r0.L$0 = r12
            r13 = 5
            r0.label = r13
            java.lang.Object r13 = r12.u(r0)
            if (r13 != r1) goto L_0x0169
            return r1
        L_0x0169:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r2 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r2 = r2.a()
            java.lang.String r3 = "flyme_permission_check"
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            r2.o(r3, r4)
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "waitForFlymePermissionResult, hasPermission: "
            r3.append(r4)
            r3.append(r13)
            java.lang.String r13 = r3.toString()
            r2.g(r5, r13)
        L_0x0195:
            r0.L$0 = r12
            r13 = 6
            r0.label = r13
            java.lang.Object r13 = r12.v(r0)
            if (r13 != r1) goto L_0x01d9
            return r1
        L_0x01a1:
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r13 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r6 = r13.a()
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            r10 = 4
            r11 = 0
            java.lang.String r7 = "third_platform_permission_check"
            r9 = 0
            java.lang.Object r13 = com.upuphone.xr.sapp.utils.DataStoreUtils.i(r6, r7, r8, r9, r10, r11)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L_0x01d9
            r0.L$0 = r12
            r13 = 7
            r0.label = r13
            java.lang.Object r13 = r12.z(r0)
            if (r13 != r1) goto L_0x01c9
            return r1
        L_0x01c9:
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r13 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r13 = r13.a()
            java.lang.String r0 = "third_platform_permission_check"
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            r13.o(r0, r1)
        L_0x01d9:
            com.upuphone.star.core.log.ULog$Delegate r13 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r0 = "checkPermissionAndState, end"
            r13.g(r5, r0)
            kotlin.jvm.functions.Function0 r12 = r12.b
            r12.invoke()
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.permissions.PermissionAndStateHelper.o(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void p() {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this.f8370a), (CoroutineContext) null, (CoroutineStart) null, new PermissionAndStateHelper$checkView$1(this, (Continuation<? super PermissionAndStateHelper$checkView$1>) null), 3, (Object) null);
    }

    public final FragmentActivity q() {
        return this.f8370a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object r(kotlin.coroutines.Continuation r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForAgreeLocation$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForAgreeLocation$1 r0 = (com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForAgreeLocation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForAgreeLocation$1 r0 = new com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForAgreeLocation$1
            r0.<init>(r12, r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "PermissionAndStateHelper"
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0034
            if (r2 != r5) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x006a
        L_0x002c:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r13)
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r13 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r6 = r13.a()
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            r10 = 4
            r11 = 0
            java.lang.String r7 = "action_user_refuse_location"
            r9 = 0
            java.lang.Object r13 = com.upuphone.xr.sapp.utils.DataStoreUtils.i(r6, r7, r8, r9, r10, r11)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L_0x005f
            com.upuphone.star.core.log.ULog$Delegate r12 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r13 = "waitForAgreeLocation, USER_REFUSED, return"
            r12.g(r3, r13)
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r12
        L_0x005f:
            androidx.fragment.app.FragmentActivity r12 = r12.f8370a
            r0.label = r5
            java.lang.Object r13 = com.upuphone.xr.sapp.utils.DialogExtKt.a(r12, r0)
            if (r13 != r1) goto L_0x006a
            return r1
        L_0x006a:
            com.upuphone.xr.sapp.utils.DialogResult r13 = (com.upuphone.xr.sapp.utils.DialogResult) r13
            com.upuphone.star.core.log.ULog$Delegate r12 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "waitForAgreeLocation, dialogResult: "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            r12.g(r3, r0)
            com.upuphone.xr.sapp.utils.DialogAction r12 = r13.getAction()
            com.upuphone.xr.sapp.utils.DialogAction r13 = com.upuphone.xr.sapp.utils.DialogAction.Confirm
            if (r12 == r13) goto L_0x009f
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r12 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r12 = r12.a()
            java.lang.String r13 = "action_user_refuse_location"
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            r12.o(r13, r0)
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r12
        L_0x009f:
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.permissions.PermissionAndStateHelper.r(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object s(kotlin.coroutines.Continuation r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForBluetoothPermission$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForBluetoothPermission$1 r0 = (com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForBluetoothPermission$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForBluetoothPermission$1 r0 = new com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForBluetoothPermission$1
            r0.<init>(r12, r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            java.lang.String r6 = "PermissionAndStateHelper"
            if (r2 == 0) goto L_0x0044
            if (r2 == r5) goto L_0x003c
            if (r2 != r4) goto L_0x0034
            java.lang.Object r12 = r0.L$0
            com.xjmz.myvu.permissions.PermissionAndStateHelper r12 = (com.xjmz.myvu.permissions.PermissionAndStateHelper) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00cc
        L_0x0034:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x003c:
            java.lang.Object r12 = r0.L$0
            com.xjmz.myvu.permissions.PermissionAndStateHelper r12 = (com.xjmz.myvu.permissions.PermissionAndStateHelper) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0097
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r13)
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r13 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            java.lang.String[] r13 = r13.z()
            com.upuphone.xr.sapp.permission.PermissionHelper r2 = com.upuphone.xr.sapp.permission.PermissionHelper.f7819a
            androidx.fragment.app.FragmentActivity r7 = r12.f8370a
            boolean r7 = r2.n(r7, r13)
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a
            boolean r9 = r12.f
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "waitForBluetoothPermission, hasBtPermission: "
            r10.append(r11)
            r10.append(r7)
            java.lang.String r11 = ", needBtPermission: "
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.g(r6, r9)
            if (r7 != 0) goto L_0x00ff
            boolean r7 = r12.f
            if (r7 != 0) goto L_0x007e
            goto L_0x00ff
        L_0x007e:
            androidx.fragment.app.FragmentActivity r7 = r12.f8370a
            com.upuphone.xr.sapp.entity.PermissionNote r2 = r2.e(r7, r13)
            java.lang.String r7 = "waitForBluetoothPermission, requestPermission"
            r8.g(r6, r7)
            androidx.fragment.app.FragmentActivity r7 = r12.f8370a
            r0.L$0 = r12
            r0.label = r5
            java.lang.Object r13 = com.upuphone.xr.sapp.permission.PermissionExtKt.a(r7, r13, r2, r3, r0)
            if (r13 != r1) goto L_0x0097
            return r1
        L_0x0097:
            com.upuphone.xr.sapp.permission.PermissionResult r13 = (com.upuphone.xr.sapp.permission.PermissionResult) r13
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "waitForBluetoothPermission, permissionResult: "
            r5.append(r7)
            r5.append(r13)
            java.lang.String r5 = r5.toString()
            r2.g(r6, r5)
            boolean r13 = com.upuphone.xr.sapp.permission.PermissionResultKt.a(r13)
            if (r13 == 0) goto L_0x00b9
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x00b9:
            java.lang.String r13 = "waitForBluetoothPermission, waitForBluetoothPermissionDialog"
            r2.g(r6, r13)
            androidx.fragment.app.FragmentActivity r13 = r12.f8370a
            r0.L$0 = r12
            r0.label = r4
            java.lang.Object r13 = com.upuphone.xr.sapp.utils.DialogExtKt.b(r13, r0)
            if (r13 != r1) goto L_0x00cc
            return r1
        L_0x00cc:
            com.upuphone.xr.sapp.utils.DialogResult r13 = (com.upuphone.xr.sapp.utils.DialogResult) r13
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "waitForBluetoothPermission, dialogResult: "
            r1.append(r2)
            r1.append(r13)
            java.lang.String r1 = r1.toString()
            r0.g(r6, r1)
            com.upuphone.xr.sapp.utils.DialogAction r13 = r13.getAction()
            com.upuphone.xr.sapp.utils.DialogAction r0 = com.upuphone.xr.sapp.utils.DialogAction.Confirm
            if (r13 == r0) goto L_0x00f2
            r12.f = r3
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x00f2:
            androidx.fragment.app.FragmentActivity r12 = r12.f8370a
            com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.o(r12)
            java.util.concurrent.CancellationException r12 = new java.util.concurrent.CancellationException
            java.lang.String r13 = "jumpToSuperAppDetails"
            r12.<init>(r13)
            throw r12
        L_0x00ff:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.permissions.PermissionAndStateHelper.s(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object t(kotlin.coroutines.Continuation r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForBluetoothState$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForBluetoothState$1 r0 = (com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForBluetoothState$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForBluetoothState$1 r0 = new com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForBluetoothState$1
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            java.lang.String r5 = "PermissionAndStateHelper"
            if (r2 == 0) goto L_0x0038
            if (r2 != r4) goto L_0x0030
            java.lang.Object r8 = r0.L$0
            com.xjmz.myvu.permissions.PermissionAndStateHelper r8 = (com.xjmz.myvu.permissions.PermissionAndStateHelper) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0083
        L_0x0030:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r9)
            boolean r9 = r8.e
            if (r9 != 0) goto L_0x004c
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r9 = "waitForBluetoothState, needBtState=false"
            r8.g(r5, r9)
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r8
        L_0x004c:
            com.upuphone.xr.sapp.bluetooth.BluetoothHelper r9 = com.upuphone.xr.sapp.bluetooth.BluetoothHelper.f6650a
            boolean r9 = r9.f()
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "waitForBluetoothState, isBluetoothEnabled: "
            r6.append(r7)
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r2.g(r5, r6)
            if (r9 == 0) goto L_0x0070
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r8
        L_0x0070:
            java.lang.String r9 = "waitForBluetoothState, waitForEnableBluetoothDialog"
            r2.g(r5, r9)
            androidx.fragment.app.FragmentActivity r9 = r8.f8370a
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r9 = com.upuphone.xr.sapp.utils.DialogExtKt.d(r9, r0)
            if (r9 != r1) goto L_0x0083
            return r1
        L_0x0083:
            com.upuphone.xr.sapp.utils.DialogResult r9 = (com.upuphone.xr.sapp.utils.DialogResult) r9
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "waitForBluetoothState, dialogResult: "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            r0.g(r5, r1)
            com.upuphone.xr.sapp.utils.DialogAction r9 = r9.getAction()
            com.upuphone.xr.sapp.utils.DialogAction r0 = com.upuphone.xr.sapp.utils.DialogAction.Confirm
            if (r9 == r0) goto L_0x00ab
            r8.e = r3
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r8
        L_0x00ab:
            androidx.fragment.app.FragmentActivity r8 = r8.f8370a
            android.content.Intent r9 = new android.content.Intent
            java.lang.String r0 = "android.settings.BLUETOOTH_SETTINGS"
            r9.<init>(r0)
            r8.startActivity(r9)
            java.util.concurrent.CancellationException r8 = new java.util.concurrent.CancellationException
            java.lang.String r9 = "goto bluetooth setting"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.permissions.PermissionAndStateHelper.t(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object u(kotlin.coroutines.Continuation r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForFlymePermissionResult$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForFlymePermissionResult$1 r0 = (com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForFlymePermissionResult$1) r0
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
            com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForFlymePermissionResult$1 r0 = new com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForFlymePermissionResult$1
            r0.<init>(r8, r9)
            goto L_0x0012
        L_0x001a:
            java.lang.Object r9 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            java.lang.String r7 = "PermissionAndStateHelper"
            r2 = 1
            if (r1 == 0) goto L_0x0035
            if (r1 != r2) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0055
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r9)
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r9 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            java.lang.String[] r9 = r9.o()
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r3 = "waitForFlymePermissionResult, start"
            r1.g(r7, r3)
            androidx.fragment.app.FragmentActivity r1 = r8.f8370a
            r4.label = r2
            r3 = 0
            r5 = 2
            r6 = 0
            r2 = r9
            java.lang.Object r9 = com.upuphone.xr.sapp.permission.PermissionExtKt.e(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L_0x0055
            return r0
        L_0x0055:
            com.upuphone.xr.sapp.permission.PermissionResult r9 = (com.upuphone.xr.sapp.permission.PermissionResult) r9
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "waitForFlymePermissionResult, permissionResult: "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            r8.g(r7, r0)
            boolean r8 = com.upuphone.xr.sapp.permission.PermissionResultKt.a(r9)
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.permissions.PermissionAndStateHelper.u(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object v(kotlin.coroutines.Continuation r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForListenNotificationPermission$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForListenNotificationPermission$1 r0 = (com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForListenNotificationPermission$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForListenNotificationPermission$1 r0 = new com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForListenNotificationPermission$1
            r0.<init>(r12, r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            java.lang.String r4 = "PermissionAndStateHelper"
            r5 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 == r5) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00dc
        L_0x002f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0037:
            java.lang.Object r12 = r0.L$0
            com.xjmz.myvu.permissions.PermissionAndStateHelper r12 = (com.xjmz.myvu.permissions.PermissionAndStateHelper) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00a0
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r13)
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r13 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r6 = r13.a()
            r2 = 0
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            r10 = 4
            r11 = 0
            java.lang.String r7 = "listen_notification_permission"
            r9 = 0
            java.lang.Object r2 = com.upuphone.xr.sapp.utils.DataStoreUtils.i(r6, r7, r8, r9, r10, r11)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0061
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x0061:
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r6 = "waitForListenNotificationPermission, start"
            r2.g(r4, r6)
            com.upuphone.xr.sapp.utils.DataStoreUtils r13 = r13.a()
            java.lang.String r2 = "listen_notification_permission"
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            r13.o(r2, r6)
            androidx.fragment.app.FragmentActivity r13 = r12.f8370a
            com.upuphone.xr.sapp.entity.DialogTextBean r2 = new com.upuphone.xr.sapp.entity.DialogTextBean
            int r6 = com.upuphone.xr.sapp.R.string.notification_title
            java.lang.String r6 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r6)
            int r7 = com.upuphone.xr.sapp.R.string.notification_content
            java.lang.String r7 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r7)
            int r8 = com.upuphone.xr.sapp.R.string.open_notification
            java.lang.String r8 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r8)
            int r9 = com.upuphone.xr.sapp.R.string.cancel
            java.lang.String r9 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r9)
            r2.<init>(r6, r7, r8, r9)
            r0.L$0 = r12
            r0.label = r5
            java.lang.Object r13 = com.upuphone.xr.sapp.utils.DialogExtKt.c(r13, r2, r0)
            if (r13 != r1) goto L_0x00a0
            return r1
        L_0x00a0:
            com.upuphone.xr.sapp.utils.DialogResult r13 = (com.upuphone.xr.sapp.utils.DialogResult) r13
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "waitForListenNotificationPermission, notifyListenerResult: "
            r5.append(r6)
            r5.append(r13)
            java.lang.String r5 = r5.toString()
            r2.g(r4, r5)
            com.upuphone.xr.sapp.utils.DialogAction r13 = r13.getAction()
            com.upuphone.xr.sapp.utils.DialogAction r5 = com.upuphone.xr.sapp.utils.DialogAction.Confirm
            if (r13 != r5) goto L_0x00df
            java.lang.String r13 = "waitForListenNotificationPermission, goto NOTIFICATION_LISTENER_SETTINGS"
            r2.g(r4, r13)
            android.content.Intent r13 = new android.content.Intent
            java.lang.String r2 = "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"
            r13.<init>(r2)
            androidx.fragment.app.FragmentActivity r12 = r12.f8370a
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r12 = com.upuphone.xr.sapp.permission.PermissionExtKt.c(r12, r13, r0)
            if (r12 != r1) goto L_0x00dc
            return r1
        L_0x00dc:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x00df:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.permissions.PermissionAndStateHelper.v(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object w(kotlin.coroutines.Continuation r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForLocationState$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForLocationState$1 r0 = (com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForLocationState$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForLocationState$1 r0 = new com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForLocationState$1
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            java.lang.String r4 = "PermissionAndStateHelper"
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r8 = r0.L$0
            com.xjmz.myvu.permissions.PermissionAndStateHelper r8 = (com.xjmz.myvu.permissions.PermissionAndStateHelper) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x007d
        L_0x002f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r9)
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r9 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            androidx.fragment.app.FragmentActivity r2 = r8.f8370a
            boolean r9 = r9.f(r2)
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a
            boolean r5 = r8.c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "waitForLocationState, locationState: "
            r6.append(r7)
            r6.append(r9)
            java.lang.String r7 = ", needLocationState: "
            r6.append(r7)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            r2.g(r4, r5)
            if (r9 != 0) goto L_0x00b8
            boolean r9 = r8.c
            if (r9 != 0) goto L_0x006a
            goto L_0x00b8
        L_0x006a:
            java.lang.String r9 = "waitForLocationState, waitForEnableLocationServiceDialog"
            r2.g(r4, r9)
            androidx.fragment.app.FragmentActivity r9 = r8.f8370a
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r9 = com.upuphone.xr.sapp.utils.DialogExtKt.e(r9, r0)
            if (r9 != r1) goto L_0x007d
            return r1
        L_0x007d:
            com.upuphone.xr.sapp.utils.DialogResult r9 = (com.upuphone.xr.sapp.utils.DialogResult) r9
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "waitForLocationState, dialogResult: "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            r0.g(r4, r1)
            com.upuphone.xr.sapp.utils.DialogAction r9 = r9.getAction()
            com.upuphone.xr.sapp.utils.DialogAction r0 = com.upuphone.xr.sapp.utils.DialogAction.Confirm
            if (r9 == r0) goto L_0x00a4
            r9 = 0
            r8.c = r9
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x00a4:
            androidx.fragment.app.FragmentActivity r8 = r8.f8370a
            android.content.Intent r9 = new android.content.Intent
            java.lang.String r0 = "android.settings.LOCATION_SOURCE_SETTINGS"
            r9.<init>(r0)
            r8.startActivity(r9)
            java.util.concurrent.CancellationException r8 = new java.util.concurrent.CancellationException
            java.lang.String r9 = "goto location source setting"
            r8.<init>(r9)
            throw r8
        L_0x00b8:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.permissions.PermissionAndStateHelper.w(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object x(kotlin.coroutines.Continuation r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForNecessaryLocationPermission$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForNecessaryLocationPermission$1 r0 = (com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForNecessaryLocationPermission$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForNecessaryLocationPermission$1 r0 = new com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForNecessaryLocationPermission$1
            r0.<init>(r12, r13)
        L_0x0018:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            java.lang.String r6 = "PermissionAndStateHelper"
            if (r2 == 0) goto L_0x0044
            if (r2 == r5) goto L_0x003c
            if (r2 != r4) goto L_0x0034
            java.lang.Object r12 = r0.L$0
            com.xjmz.myvu.permissions.PermissionAndStateHelper r12 = (com.xjmz.myvu.permissions.PermissionAndStateHelper) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00e5
        L_0x0034:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x003c:
            java.lang.Object r12 = r0.L$0
            com.xjmz.myvu.permissions.PermissionAndStateHelper r12 = (com.xjmz.myvu.permissions.PermissionAndStateHelper) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00b0
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r13)
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r13 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            java.lang.String[] r13 = r13.A()
            com.upuphone.xr.sapp.permission.PermissionHelper r2 = com.upuphone.xr.sapp.permission.PermissionHelper.f7819a
            androidx.fragment.app.FragmentActivity r7 = r12.f8370a
            boolean r7 = r2.n(r7, r13)
            com.upuphone.star.core.log.ULog$Delegate r8 = com.upuphone.star.core.log.ULog.f6446a
            boolean r9 = r12.d
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "waitForLocationPermission, hasLocationPermission: "
            r10.append(r11)
            r10.append(r7)
            java.lang.String r11 = ", needLocationPermission: "
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.g(r6, r9)
            if (r7 != 0) goto L_0x0118
            boolean r7 = r12.d
            if (r7 != 0) goto L_0x007e
            goto L_0x0118
        L_0x007e:
            java.lang.String r7 = java.util.Arrays.toString(r13)
            java.lang.String r9 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "waitForLocationPermission, permissions: "
            r9.append(r10)
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            r8.g(r6, r7)
            androidx.fragment.app.FragmentActivity r7 = r12.f8370a
            com.upuphone.xr.sapp.entity.PermissionNote r2 = r2.e(r7, r13)
            androidx.fragment.app.FragmentActivity r7 = r12.f8370a
            r0.L$0 = r12
            r0.label = r5
            java.lang.Object r13 = com.upuphone.xr.sapp.permission.PermissionExtKt.a(r7, r13, r2, r3, r0)
            if (r13 != r1) goto L_0x00b0
            return r1
        L_0x00b0:
            com.upuphone.xr.sapp.permission.PermissionResult r13 = (com.upuphone.xr.sapp.permission.PermissionResult) r13
            com.upuphone.star.core.log.ULog$Delegate r2 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "waitForLocationPermission, permissionResult: "
            r5.append(r7)
            r5.append(r13)
            java.lang.String r5 = r5.toString()
            r2.g(r6, r5)
            boolean r13 = com.upuphone.xr.sapp.permission.PermissionResultKt.a(r13)
            if (r13 == 0) goto L_0x00d2
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x00d2:
            java.lang.String r13 = "waitForLocationPermission, waitForLocationPermissionDialog"
            r2.g(r6, r13)
            androidx.fragment.app.FragmentActivity r13 = r12.f8370a
            r0.L$0 = r12
            r0.label = r4
            java.lang.Object r13 = com.upuphone.xr.sapp.utils.DialogExtKt.f(r13, r0)
            if (r13 != r1) goto L_0x00e5
            return r1
        L_0x00e5:
            com.upuphone.xr.sapp.utils.DialogResult r13 = (com.upuphone.xr.sapp.utils.DialogResult) r13
            com.upuphone.star.core.log.ULog$Delegate r0 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "waitForLocationPermission, dialogResult: "
            r1.append(r2)
            r1.append(r13)
            java.lang.String r1 = r1.toString()
            r0.g(r6, r1)
            com.upuphone.xr.sapp.utils.DialogAction r13 = r13.getAction()
            com.upuphone.xr.sapp.utils.DialogAction r0 = com.upuphone.xr.sapp.utils.DialogAction.Confirm
            if (r13 == r0) goto L_0x010b
            r12.d = r3
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x010b:
            androidx.fragment.app.FragmentActivity r12 = r12.f8370a
            com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.o(r12)
            java.util.concurrent.CancellationException r12 = new java.util.concurrent.CancellationException
            java.lang.String r13 = "jumpToSuperAppDetails"
            r12.<init>(r13)
            throw r12
        L_0x0118:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.permissions.PermissionAndStateHelper.x(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object y(kotlin.coroutines.Continuation r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForNotificationPermission$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForNotificationPermission$1 r0 = (com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForNotificationPermission$1) r0
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
            com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForNotificationPermission$1 r0 = new com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForNotificationPermission$1
            r0.<init>(r14, r15)
            goto L_0x0012
        L_0x001a:
            java.lang.Object r15 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 3
            r3 = 2
            r5 = 1
            java.lang.String r7 = "PermissionAndStateHelper"
            if (r1 == 0) goto L_0x0049
            if (r1 == r5) goto L_0x0041
            if (r1 == r3) goto L_0x003c
            if (r1 != r2) goto L_0x0034
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x011f
        L_0x0034:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0101
        L_0x0041:
            java.lang.Object r14 = r4.L$0
            com.xjmz.myvu.permissions.PermissionAndStateHelper r14 = (com.xjmz.myvu.permissions.PermissionAndStateHelper) r14
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00b8
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r15)
            com.upuphone.xr.sapp.utils.DataStoreUtils$Companion r15 = com.upuphone.xr.sapp.utils.DataStoreUtils.e
            com.upuphone.xr.sapp.utils.DataStoreUtils r8 = r15.a()
            r1 = 0
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            r12 = 4
            r13 = 0
            java.lang.String r9 = "notification_permission"
            r11 = 0
            java.lang.Object r1 = com.upuphone.xr.sapp.utils.DataStoreUtils.i(r8, r9, r10, r11, r12, r13)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x006b
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x006b:
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r6 = "waitForNotificationPermission, start"
            r1.g(r7, r6)
            com.upuphone.xr.sapp.utils.DataStoreUtils r15 = r15.a()
            java.lang.String r6 = "notification_permission"
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            r15.o(r6, r8)
            com.upuphone.xr.sapp.utils.OSHelper r15 = com.upuphone.xr.sapp.utils.OSHelper.f7904a
            boolean r15 = r15.e()
            if (r15 == 0) goto L_0x0104
            android.content.Context r15 = com.upuphone.xr.sapp.utils.GlobalExtKt.f()
            androidx.core.app.NotificationManagerCompat r15 = androidx.core.app.NotificationManagerCompat.g(r15)
            boolean r15 = r15.a()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "waitForNotificationPermission, areNotificationsEnabled: "
            r2.append(r6)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r1.g(r7, r2)
            if (r15 != 0) goto L_0x0138
            androidx.fragment.app.FragmentActivity r15 = r14.f8370a
            r4.L$0 = r14
            r4.label = r5
            java.lang.Object r15 = com.upuphone.xr.sapp.utils.DialogExtKt.g(r15, r4)
            if (r15 != r0) goto L_0x00b8
            return r0
        L_0x00b8:
            com.upuphone.xr.sapp.utils.DialogResult r15 = (com.upuphone.xr.sapp.utils.DialogResult) r15
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "waitForNotificationPermission, dialogResult: "
            r2.append(r5)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r1.g(r7, r2)
            com.upuphone.xr.sapp.utils.DialogAction r15 = r15.getAction()
            com.upuphone.xr.sapp.utils.DialogAction r2 = com.upuphone.xr.sapp.utils.DialogAction.Confirm
            if (r15 != r2) goto L_0x0138
            java.lang.String r15 = "waitForNotificationPermission, goto APP_NOTIFICATION_SETTINGS"
            r1.g(r7, r15)
            android.content.Intent r15 = new android.content.Intent
            java.lang.String r1 = "android.settings.APP_NOTIFICATION_SETTINGS"
            r15.<init>(r1)
            android.content.Context r1 = com.upuphone.xr.sapp.utils.GlobalExtKt.f()
            java.lang.String r1 = r1.getPackageName()
            java.lang.String r2 = "android.provider.extra.APP_PACKAGE"
            r15.putExtra(r2, r1)
            androidx.fragment.app.FragmentActivity r14 = r14.f8370a
            r1 = 0
            r4.L$0 = r1
            r4.label = r3
            java.lang.Object r14 = com.upuphone.xr.sapp.permission.PermissionExtKt.c(r14, r15, r4)
            if (r14 != r0) goto L_0x0101
            return r0
        L_0x0101:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x0104:
            java.lang.String r15 = "waitForNotificationPermission, request POST_NOTIFICATIONS"
            r1.g(r7, r15)
            androidx.fragment.app.FragmentActivity r1 = r14.f8370a
            java.lang.String r14 = "android.permission.POST_NOTIFICATIONS"
            java.lang.String[] r14 = new java.lang.String[]{r14}
            r4.label = r2
            r3 = 0
            r5 = 2
            r6 = 0
            r2 = r14
            java.lang.Object r15 = com.upuphone.xr.sapp.permission.PermissionExtKt.e(r1, r2, r3, r4, r5, r6)
            if (r15 != r0) goto L_0x011f
            return r0
        L_0x011f:
            com.upuphone.xr.sapp.permission.PermissionResult r15 = (com.upuphone.xr.sapp.permission.PermissionResult) r15
            com.upuphone.star.core.log.ULog$Delegate r14 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "waitForNotificationPermission, notifyPermissionResult: "
            r0.append(r1)
            r0.append(r15)
            java.lang.String r15 = r0.toString()
            r14.g(r7, r15)
        L_0x0138:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.permissions.PermissionAndStateHelper.y(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x009f, code lost:
        r1 = com.upuphone.star.core.log.ULog.f6446a;
        r1.g("PermissionAndStateHelper", "waitForThirdPlatformAppPermissions, contactPermissionResult: " + ((com.upuphone.xr.sapp.permission.PermissionResult) r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00be, code lost:
        if (com.upuphone.xr.sapp.BuildConfig.f6575a.booleanValue() != false) goto L_0x00fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00c0, code lost:
        r1 = r10.f8370a;
        r11 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a;
        r2 = r11.m();
        r3 = com.upuphone.xr.sapp.permission.PermissionHelper.f7819a.e(r10.f8370a, r11.m());
        r0.L$0 = r10;
        r0.label = 2;
        r11 = com.upuphone.xr.sapp.permission.PermissionExtKt.b(r1, r2, r3, false, r0, 4, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00e1, code lost:
        if (r11 != r8) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e3, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00e4, code lost:
        r1 = com.upuphone.star.core.log.ULog.f6446a;
        r1.g("PermissionAndStateHelper", "waitForThirdPlatformAppPermissions, callLogPermissionResult: " + ((com.upuphone.xr.sapp.permission.PermissionResult) r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00fd, code lost:
        r1 = r10.f8370a;
        r11 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a;
        r2 = r11.q();
        r3 = com.upuphone.xr.sapp.permission.PermissionHelper.f7819a.e(r10.f8370a, r11.q());
        r0.L$0 = r10;
        r0.label = 3;
        r11 = com.upuphone.xr.sapp.permission.PermissionExtKt.b(r1, r2, r3, false, r0, 4, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x011e, code lost:
        if (r11 != r8) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0120, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0121, code lost:
        r1 = com.upuphone.star.core.log.ULog.f6446a;
        r1.g("PermissionAndStateHelper", "waitForThirdPlatformAppPermissions, callPhonePermissionResult: " + ((com.upuphone.xr.sapp.permission.PermissionResult) r11));
        r1 = r10.f8370a;
        r11 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a;
        r2 = r11.r();
        r3 = com.upuphone.xr.sapp.permission.PermissionHelper.f7819a.e(r10.f8370a, r11.r());
        r0.L$0 = r10;
        r0.label = 4;
        r11 = com.upuphone.xr.sapp.permission.PermissionExtKt.b(r1, r2, r3, false, r0, 4, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x015b, code lost:
        if (r11 != r8) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x015d, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x015e, code lost:
        r1 = com.upuphone.star.core.log.ULog.f6446a;
        r1.g("PermissionAndStateHelper", "waitForThirdPlatformAppPermissions, calendarPermissionResult: " + ((com.upuphone.xr.sapp.permission.PermissionResult) r11));
        r0.L$0 = r10;
        r0.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0180, code lost:
        if (r10.y(r0) != r8) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0182, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0183, code lost:
        r0.L$0 = r10;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x018c, code lost:
        if (r10.v(r0) != r8) goto L_0x018f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x018e, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x018f, code lost:
        r11 = com.upuphone.xr.sapp.BuildConfig.f6575a;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, "COUNTRY_INTL");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x019a, code lost:
        if (r11.booleanValue() == false) goto L_0x01bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x019c, code lost:
        r0.L$0 = r10;
        r0.label = 7;
        r11 = r10.r(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x01a5, code lost:
        if (r11 != r8) goto L_0x01a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x01a7, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01ae, code lost:
        if (((java.lang.Boolean) r11).booleanValue() != false) goto L_0x01bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01b0, code lost:
        com.upuphone.star.core.log.ULog.f6446a.g("PermissionAndStateHelper", "waitForThirdPlatformAppPermissions, locationAgreed=false, return");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01ba, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01bb, code lost:
        r1 = r10.f8370a;
        r11 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a;
        r2 = r11.A();
        r3 = com.upuphone.xr.sapp.permission.PermissionHelper.f7819a.e(r10.f8370a, r11.A());
        r0.L$0 = null;
        r0.label = 8;
        r11 = com.upuphone.xr.sapp.permission.PermissionExtKt.b(r1, r2, r3, false, r0, 4, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01de, code lost:
        if (r11 != r8) goto L_0x01e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01e0, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01e1, code lost:
        r10 = com.upuphone.star.core.log.ULog.f6446a;
        r10.g("PermissionAndStateHelper", "waitForThirdPlatformAppPermissions, locationPermissionResult: " + ((com.upuphone.xr.sapp.permission.PermissionResult) r11));
        r10.g("PermissionAndStateHelper", "waitForThirdPlatformAppPermissions, end");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0202, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object z(kotlin.coroutines.Continuation r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForThirdPlatformAppPermissions$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForThirdPlatformAppPermissions$1 r0 = (com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForThirdPlatformAppPermissions$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForThirdPlatformAppPermissions$1 r0 = new com.xjmz.myvu.permissions.PermissionAndStateHelper$waitForThirdPlatformAppPermissions$1
            r0.<init>(r10, r11)
        L_0x0018:
            java.lang.Object r11 = r0.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            java.lang.String r9 = "PermissionAndStateHelper"
            switch(r1) {
                case 0: goto L_0x0070;
                case 1: goto L_0x0068;
                case 2: goto L_0x005f;
                case 3: goto L_0x0056;
                case 4: goto L_0x004d;
                case 5: goto L_0x0044;
                case 6: goto L_0x003b;
                case 7: goto L_0x0032;
                case 8: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x01e1
        L_0x0032:
            java.lang.Object r10 = r0.L$0
            com.xjmz.myvu.permissions.PermissionAndStateHelper r10 = (com.xjmz.myvu.permissions.PermissionAndStateHelper) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x01a8
        L_0x003b:
            java.lang.Object r10 = r0.L$0
            com.xjmz.myvu.permissions.PermissionAndStateHelper r10 = (com.xjmz.myvu.permissions.PermissionAndStateHelper) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x018f
        L_0x0044:
            java.lang.Object r10 = r0.L$0
            com.xjmz.myvu.permissions.PermissionAndStateHelper r10 = (com.xjmz.myvu.permissions.PermissionAndStateHelper) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0183
        L_0x004d:
            java.lang.Object r10 = r0.L$0
            com.xjmz.myvu.permissions.PermissionAndStateHelper r10 = (com.xjmz.myvu.permissions.PermissionAndStateHelper) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x015e
        L_0x0056:
            java.lang.Object r10 = r0.L$0
            com.xjmz.myvu.permissions.PermissionAndStateHelper r10 = (com.xjmz.myvu.permissions.PermissionAndStateHelper) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0121
        L_0x005f:
            java.lang.Object r10 = r0.L$0
            com.xjmz.myvu.permissions.PermissionAndStateHelper r10 = (com.xjmz.myvu.permissions.PermissionAndStateHelper) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00e4
        L_0x0068:
            java.lang.Object r10 = r0.L$0
            com.xjmz.myvu.permissions.PermissionAndStateHelper r10 = (com.xjmz.myvu.permissions.PermissionAndStateHelper) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x009f
        L_0x0070:
            kotlin.ResultKt.throwOnFailure(r11)
            com.upuphone.star.core.log.ULog$Delegate r11 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r1 = "waitForThirdPlatformAppPermissions, start"
            r11.g(r9, r1)
            androidx.fragment.app.FragmentActivity r1 = r10.f8370a
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r11 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            java.lang.String[] r2 = r11.n()
            com.upuphone.xr.sapp.permission.PermissionHelper r3 = com.upuphone.xr.sapp.permission.PermissionHelper.f7819a
            androidx.fragment.app.FragmentActivity r4 = r10.f8370a
            java.lang.String[] r11 = r11.n()
            com.upuphone.xr.sapp.entity.PermissionNote r3 = r3.e(r4, r11)
            r0.L$0 = r10
            r11 = 1
            r0.label = r11
            r4 = 0
            r6 = 4
            r7 = 0
            r5 = r0
            java.lang.Object r11 = com.upuphone.xr.sapp.permission.PermissionExtKt.b(r1, r2, r3, r4, r5, r6, r7)
            if (r11 != r8) goto L_0x009f
            return r8
        L_0x009f:
            com.upuphone.xr.sapp.permission.PermissionResult r11 = (com.upuphone.xr.sapp.permission.PermissionResult) r11
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "waitForThirdPlatformAppPermissions, contactPermissionResult: "
            r2.append(r3)
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            r1.g(r9, r11)
            java.lang.Boolean r11 = com.upuphone.xr.sapp.BuildConfig.f6575a
            boolean r11 = r11.booleanValue()
            if (r11 != 0) goto L_0x00fd
            androidx.fragment.app.FragmentActivity r1 = r10.f8370a
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r11 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            java.lang.String[] r2 = r11.m()
            com.upuphone.xr.sapp.permission.PermissionHelper r3 = com.upuphone.xr.sapp.permission.PermissionHelper.f7819a
            androidx.fragment.app.FragmentActivity r4 = r10.f8370a
            java.lang.String[] r11 = r11.m()
            com.upuphone.xr.sapp.entity.PermissionNote r3 = r3.e(r4, r11)
            r0.L$0 = r10
            r11 = 2
            r0.label = r11
            r4 = 0
            r6 = 4
            r7 = 0
            r5 = r0
            java.lang.Object r11 = com.upuphone.xr.sapp.permission.PermissionExtKt.b(r1, r2, r3, r4, r5, r6, r7)
            if (r11 != r8) goto L_0x00e4
            return r8
        L_0x00e4:
            com.upuphone.xr.sapp.permission.PermissionResult r11 = (com.upuphone.xr.sapp.permission.PermissionResult) r11
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "waitForThirdPlatformAppPermissions, callLogPermissionResult: "
            r2.append(r3)
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            r1.g(r9, r11)
        L_0x00fd:
            androidx.fragment.app.FragmentActivity r1 = r10.f8370a
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r11 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            java.lang.String[] r2 = r11.q()
            com.upuphone.xr.sapp.permission.PermissionHelper r3 = com.upuphone.xr.sapp.permission.PermissionHelper.f7819a
            androidx.fragment.app.FragmentActivity r4 = r10.f8370a
            java.lang.String[] r11 = r11.q()
            com.upuphone.xr.sapp.entity.PermissionNote r3 = r3.e(r4, r11)
            r0.L$0 = r10
            r11 = 3
            r0.label = r11
            r4 = 0
            r6 = 4
            r7 = 0
            r5 = r0
            java.lang.Object r11 = com.upuphone.xr.sapp.permission.PermissionExtKt.b(r1, r2, r3, r4, r5, r6, r7)
            if (r11 != r8) goto L_0x0121
            return r8
        L_0x0121:
            com.upuphone.xr.sapp.permission.PermissionResult r11 = (com.upuphone.xr.sapp.permission.PermissionResult) r11
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "waitForThirdPlatformAppPermissions, callPhonePermissionResult: "
            r2.append(r3)
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            r1.g(r9, r11)
            androidx.fragment.app.FragmentActivity r1 = r10.f8370a
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r11 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            java.lang.String[] r2 = r11.r()
            com.upuphone.xr.sapp.permission.PermissionHelper r3 = com.upuphone.xr.sapp.permission.PermissionHelper.f7819a
            androidx.fragment.app.FragmentActivity r4 = r10.f8370a
            java.lang.String[] r11 = r11.r()
            com.upuphone.xr.sapp.entity.PermissionNote r3 = r3.e(r4, r11)
            r0.L$0 = r10
            r11 = 4
            r0.label = r11
            r4 = 0
            r6 = 4
            r7 = 0
            r5 = r0
            java.lang.Object r11 = com.upuphone.xr.sapp.permission.PermissionExtKt.b(r1, r2, r3, r4, r5, r6, r7)
            if (r11 != r8) goto L_0x015e
            return r8
        L_0x015e:
            com.upuphone.xr.sapp.permission.PermissionResult r11 = (com.upuphone.xr.sapp.permission.PermissionResult) r11
            com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "waitForThirdPlatformAppPermissions, calendarPermissionResult: "
            r2.append(r3)
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            r1.g(r9, r11)
            r0.L$0 = r10
            r11 = 5
            r0.label = r11
            java.lang.Object r11 = r10.y(r0)
            if (r11 != r8) goto L_0x0183
            return r8
        L_0x0183:
            r0.L$0 = r10
            r11 = 6
            r0.label = r11
            java.lang.Object r11 = r10.v(r0)
            if (r11 != r8) goto L_0x018f
            return r8
        L_0x018f:
            java.lang.Boolean r11 = com.upuphone.xr.sapp.BuildConfig.f6575a
            java.lang.String r1 = "COUNTRY_INTL"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r1)
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x01bb
            r0.L$0 = r10
            r11 = 7
            r0.label = r11
            java.lang.Object r11 = r10.r(r0)
            if (r11 != r8) goto L_0x01a8
            return r8
        L_0x01a8:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 != 0) goto L_0x01bb
            com.upuphone.star.core.log.ULog$Delegate r10 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.String r11 = "waitForThirdPlatformAppPermissions, locationAgreed=false, return"
            r10.g(r9, r11)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x01bb:
            androidx.fragment.app.FragmentActivity r1 = r10.f8370a
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r11 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            java.lang.String[] r2 = r11.A()
            com.upuphone.xr.sapp.permission.PermissionHelper r3 = com.upuphone.xr.sapp.permission.PermissionHelper.f7819a
            androidx.fragment.app.FragmentActivity r10 = r10.f8370a
            java.lang.String[] r11 = r11.A()
            com.upuphone.xr.sapp.entity.PermissionNote r3 = r3.e(r10, r11)
            r10 = 0
            r0.L$0 = r10
            r10 = 8
            r0.label = r10
            r4 = 0
            r6 = 4
            r7 = 0
            r5 = r0
            java.lang.Object r11 = com.upuphone.xr.sapp.permission.PermissionExtKt.b(r1, r2, r3, r4, r5, r6, r7)
            if (r11 != r8) goto L_0x01e1
            return r8
        L_0x01e1:
            com.upuphone.xr.sapp.permission.PermissionResult r11 = (com.upuphone.xr.sapp.permission.PermissionResult) r11
            com.upuphone.star.core.log.ULog$Delegate r10 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "waitForThirdPlatformAppPermissions, locationPermissionResult: "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            r10.g(r9, r11)
            java.lang.String r11 = "waitForThirdPlatformAppPermissions, end"
            r10.g(r9, r11)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.permissions.PermissionAndStateHelper.z(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
