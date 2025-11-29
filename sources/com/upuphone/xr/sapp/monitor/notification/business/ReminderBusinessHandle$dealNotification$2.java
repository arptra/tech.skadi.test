package com.upuphone.xr.sapp.monitor.notification.business;

import android.service.notification.StatusBarNotification;
import com.upuphone.sdk.ResultType;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.monitor.notification.SuperNotificationManager;
import com.upuphone.xr.sapp.monitor.notification.mode.AiSdkResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.monitor.notification.business.ReminderBusinessHandle$dealNotification$2", f = "ReminderBusinessHandle.kt", i = {}, l = {146, 147}, m = "invokeSuspend", n = {}, s = {})
public final class ReminderBusinessHandle$dealNotification$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $content;
    final /* synthetic */ String $packageName;
    final /* synthetic */ StatusBarNotification $sbn;
    final /* synthetic */ Ref.ObjectRef<String> $title;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ReminderBusinessHandle this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.sapp.monitor.notification.business.ReminderBusinessHandle$dealNotification$2$1", f = "ReminderBusinessHandle.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.sapp.monitor.notification.business.ReminderBusinessHandle$dealNotification$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* renamed from: com.upuphone.xr.sapp.monitor.notification.business.ReminderBusinessHandle$dealNotification$2$1$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ResultType.values().length];
                try {
                    iArr[ResultType.ImportScene.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(aiSdkResult, reminderBusinessHandle, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                boolean E = SuperNotificationManager.f7749a.E();
                ULog.Delegate delegate = ULog.f6446a;
                ResultType type = aiSdkResult.getType();
                delegate.c("ReminderBusinessHandle", "handleDataResult type:" + type + " isSupportReminder:" + E);
                ResultType type2 = aiSdkResult.getType();
                if ((type2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type2.ordinal()]) != 1) {
                    reminderBusinessHandle.m(aiSdkResult);
                } else if (E) {
                    reminderBusinessHandle.n().a(aiSdkResult.getModel(), aiSdkResult.getType());
                } else {
                    reminderBusinessHandle.m(aiSdkResult);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReminderBusinessHandle$dealNotification$2(ReminderBusinessHandle reminderBusinessHandle, StatusBarNotification statusBarNotification, Ref.ObjectRef<String> objectRef, Ref.ObjectRef<String> objectRef2, String str, Continuation<? super ReminderBusinessHandle$dealNotification$2> continuation) {
        super(2, continuation);
        this.this$0 = reminderBusinessHandle;
        this.$sbn = statusBarNotification;
        this.$title = objectRef;
        this.$content = objectRef2;
        this.$packageName = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ReminderBusinessHandle$dealNotification$2 reminderBusinessHandle$dealNotification$2 = new ReminderBusinessHandle$dealNotification$2(this.this$0, this.$sbn, this.$title, this.$content, this.$packageName, continuation);
        reminderBusinessHandle$dealNotification$2.L$0 = obj;
        return reminderBusinessHandle$dealNotification$2;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Deferred b = BuildersKt__Builders_commonKt.b((CoroutineScope) this.L$0, (CoroutineContext) null, (CoroutineStart) null, new ReminderBusinessHandle$dealNotification$2$handleDataAsync$1(this.this$0, this.$sbn, this.$title, this.$content, this.$packageName, (Continuation<? super ReminderBusinessHandle$dealNotification$2$handleDataAsync$1>) null), 3, (Object) null);
            this.label = 1;
            obj = b.c(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final AiSdkResult aiSdkResult = (AiSdkResult) obj;
        MainCoroutineDispatcher c = Dispatchers.c();
        final ReminderBusinessHandle reminderBusinessHandle = this.this$0;
        AnonymousClass1 r3 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
        this.label = 2;
        if (BuildersKt.g(c, r3, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ReminderBusinessHandle$dealNotification$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
