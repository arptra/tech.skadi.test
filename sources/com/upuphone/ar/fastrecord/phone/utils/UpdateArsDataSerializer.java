package com.upuphone.ar.fastrecord.phone.utils;

import com.honey.account.view.web.WebJs;
import com.upuphone.xr.interconnect.util.statemachine.ChannelExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB/\b\u0007\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\u001e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0004R\"\u0010\u0002\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/utils/UpdateArsDataSerializer;", "", "log", "Lkotlin/Function2;", "", "", "name", "(Lkotlin/jvm/functions/Function2;Ljava/lang/String;)V", "tag", "getTag", "()Ljava/lang/String;", "commandAsrData", "description", "action", "Lkotlin/Function0;", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUpdateArsDataSerializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UpdateArsDataSerializer.kt\ncom/upuphone/ar/fastrecord/phone/utils/UpdateArsDataSerializer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,47:1\n1#2:48\n*E\n"})
public class UpdateArsDataSerializer {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TAG = "PetaStepSerializer";
    /* access modifiers changed from: private */
    @NotNull
    public static final Channel<Function0<Unit>> actionFlow = ChannelKt.b(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final CoroutineScope scope;
    @NotNull
    private final Function2<String, String, Unit> log;
    @NotNull
    private final String tag;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/utils/UpdateArsDataSerializer$Companion;", "", "()V", "TAG", "", "actionFlow", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/Function0;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "getActionFlow", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.utils.UpdateArsDataSerializer$Companion$1", f = "UpdateArsDataSerializer.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.upuphone.ar.fastrecord.phone.utils.UpdateArsDataSerializer$Companion$1  reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass1(continuation);
            }

            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
                	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
                */
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0028 A[Catch:{ RuntimeException -> 0x000f }, RETURN] */
            @org.jetbrains.annotations.Nullable
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r5) {
                /*
                    r4 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r4.label
                    r2 = 1
                    if (r1 == 0) goto L_0x0019
                    if (r1 != r2) goto L_0x0011
                    kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ RuntimeException -> 0x000f }
                    goto L_0x0029
                L_0x000f:
                    r5 = move-exception
                    goto L_0x002f
                L_0x0011:
                    java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                    java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                    r4.<init>(r5)
                    throw r4
                L_0x0019:
                    kotlin.ResultKt.throwOnFailure(r5)
                L_0x001c:
                    kotlinx.coroutines.channels.Channel r5 = com.upuphone.ar.fastrecord.phone.utils.UpdateArsDataSerializer.actionFlow     // Catch:{ RuntimeException -> 0x000f }
                    r4.label = r2     // Catch:{ RuntimeException -> 0x000f }
                    java.lang.Object r5 = r5.K(r4)     // Catch:{ RuntimeException -> 0x000f }
                    if (r5 != r0) goto L_0x0029
                    return r0
                L_0x0029:
                    kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5     // Catch:{ RuntimeException -> 0x000f }
                    r5.invoke()     // Catch:{ RuntimeException -> 0x000f }
                    goto L_0x001c
                L_0x002f:
                    java.lang.String r5 = r5.getLocalizedMessage()
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r3 = "Receiving failed: "
                    r1.append(r3)
                    r1.append(r5)
                    java.lang.String r5 = "."
                    r1.append(r5)
                    java.lang.String r5 = r1.toString()
                    java.lang.String r1 = "PetaStepSerializer"
                    android.util.Log.e(r1, r5)
                    goto L_0x001c
                */
                throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.utils.UpdateArsDataSerializer.Companion.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Channel<Function0<Unit>> getActionFlow() {
            return UpdateArsDataSerializer.actionFlow;
        }

        @NotNull
        public final CoroutineScope getScope() {
            return UpdateArsDataSerializer.scope;
        }

        private Companion() {
        }
    }

    static {
        CoroutineScope a2 = CoroutineScopeKt.a(Dispatchers.a().plus(SupervisorKt.b((Job) null, 1, (Object) null)));
        scope = a2;
        Job unused = BuildersKt__Builders_commonKt.d(a2, (CoroutineContext) null, (CoroutineStart) null, new Companion.AnonymousClass1((Continuation<? super Companion.AnonymousClass1>) null), 3, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UpdateArsDataSerializer(@NotNull Function2<? super String, ? super String, Unit> function2) {
        this(function2, (String) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(function2, "log");
    }

    public final void commandAsrData(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "description");
        Intrinsics.checkNotNullParameter(function0, WebJs.ACTION);
        Function2<String, String, Unit> function2 = this.log;
        String str2 = this.tag;
        function2.invoke(str2, "Will be handling " + str + ".");
        ChannelExtKt.sendOrErr(actionFlow, function0);
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r2 = com.upuphone.xr.interconnect.util.log.PrettyPrintExtKt.stringify(r1, r3);
     */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public UpdateArsDataSerializer(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> r2, @org.jetbrains.annotations.Nullable java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "log"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r1.<init>()
            r1.log = r2
            if (r3 == 0) goto L_0x0012
            java.lang.String r2 = com.upuphone.xr.interconnect.util.log.PrettyPrintExtKt.stringify(r1, r3)
            if (r2 != 0) goto L_0x0016
        L_0x0012:
            java.lang.String r2 = com.upuphone.xr.interconnect.util.log.PrettyPrintExtKt.stringify(r1)
        L_0x0016:
            r1.tag = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.utils.UpdateArsDataSerializer.<init>(kotlin.jvm.functions.Function2, java.lang.String):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UpdateArsDataSerializer(Function2 function2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function2, (i & 2) != 0 ? null : str);
    }
}
