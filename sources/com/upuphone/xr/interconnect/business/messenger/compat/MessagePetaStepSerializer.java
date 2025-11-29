package com.upuphone.xr.interconnect.business.messenger.compat;

import com.honey.account.view.web.WebJs;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.interconnect.util.statemachine.ChannelExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b¨\u0006\n"}, d2 = {"Lcom/upuphone/xr/interconnect/business/messenger/compat/MessagePetaStepSerializer;", "", "()V", "serializeMsg", "", "description", "", "action", "Lkotlin/Function0;", "Companion", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class MessagePetaStepSerializer {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TAG = "MessagePetaStepSerializer";
    /* access modifiers changed from: private */
    @NotNull
    public static final Channel<Function0<Unit>> actionFlow = ChannelKt.b(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Lazy<MessagePetaStepSerializer> instance$delegate = LazyKt.lazy(MessagePetaStepSerializer$Companion$instance$2.INSTANCE);
    /* access modifiers changed from: private */
    @NotNull
    public static final CoroutineScope scope;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8FX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/interconnect/business/messenger/compat/MessagePetaStepSerializer$Companion;", "", "()V", "TAG", "", "actionFlow", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/Function0;", "", "instance", "Lcom/upuphone/xr/interconnect/business/messenger/compat/MessagePetaStepSerializer;", "getInstance", "()Lcom/upuphone/xr/interconnect/business/messenger/compat/MessagePetaStepSerializer;", "instance$delegate", "Lkotlin/Lazy;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "SharedImpl_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.upuphone.xr.interconnect.business.messenger.compat.MessagePetaStepSerializer$Companion$1", f = "MessagePetaStepSerializer.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.upuphone.xr.interconnect.business.messenger.compat.MessagePetaStepSerializer$Companion$1  reason: invalid class name */
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
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
                /*
                    r5 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r5.label
                    r2 = 1
                    if (r1 == 0) goto L_0x0019
                    if (r1 != r2) goto L_0x0011
                    kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ RuntimeException -> 0x000f }
                    goto L_0x0029
                L_0x000f:
                    r6 = move-exception
                    goto L_0x002f
                L_0x0011:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L_0x0019:
                    kotlin.ResultKt.throwOnFailure(r6)
                L_0x001c:
                    kotlinx.coroutines.channels.Channel r6 = com.upuphone.xr.interconnect.business.messenger.compat.MessagePetaStepSerializer.actionFlow     // Catch:{ RuntimeException -> 0x000f }
                    r5.label = r2     // Catch:{ RuntimeException -> 0x000f }
                    java.lang.Object r6 = r6.K(r5)     // Catch:{ RuntimeException -> 0x000f }
                    if (r6 != r0) goto L_0x0029
                    return r0
                L_0x0029:
                    kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6     // Catch:{ RuntimeException -> 0x000f }
                    r6.invoke()     // Catch:{ RuntimeException -> 0x000f }
                    goto L_0x001c
                L_0x002f:
                    com.upuphone.star.core.log.ULog$Delegate r1 = com.upuphone.star.core.log.ULog.f6446a
                    java.lang.String r6 = r6.getLocalizedMessage()
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = "Receiving failed: "
                    r3.append(r4)
                    r3.append(r6)
                    java.lang.String r6 = "."
                    r3.append(r6)
                    java.lang.String r6 = r3.toString()
                    java.lang.String r3 = "MessagePetaStepSerializer"
                    r1.c(r3, r6)
                    goto L_0x001c
                */
                throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.interconnect.business.messenger.compat.MessagePetaStepSerializer.Companion.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
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
        public final MessagePetaStepSerializer getInstance() {
            return (MessagePetaStepSerializer) MessagePetaStepSerializer.instance$delegate.getValue();
        }

        @NotNull
        public final CoroutineScope getScope() {
            return MessagePetaStepSerializer.scope;
        }

        private Companion() {
        }
    }

    static {
        CoroutineScope a2 = CoroutineScopeKt.a(Dispatchers.a().plus(SupervisorKt.b((Job) null, 1, (Object) null)));
        scope = a2;
        Job unused = BuildersKt__Builders_commonKt.d(a2, (CoroutineContext) null, (CoroutineStart) null, new Companion.AnonymousClass1((Continuation<? super Companion.AnonymousClass1>) null), 3, (Object) null);
    }

    public final void serializeMsg(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "description");
        Intrinsics.checkNotNullParameter(function0, WebJs.ACTION);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.o(TAG, "Will be handling " + str + ".");
        ChannelExtKt.sendOrErr(actionFlow, function0);
    }
}
