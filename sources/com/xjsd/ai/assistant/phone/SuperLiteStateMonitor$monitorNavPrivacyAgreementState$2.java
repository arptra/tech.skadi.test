package com.xjsd.ai.assistant.phone;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.xjsd.ai.assistant.phone.SuperLiteStateMonitor$monitorNavPrivacyAgreementState$2", f = "SuperLiteStateMonitor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SuperLiteStateMonitor$monitorNavPrivacyAgreementState$2 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
    final /* synthetic */ Preferences.Key<Boolean> $key;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperLiteStateMonitor$monitorNavPrivacyAgreementState$2(Preferences.Key<Boolean> key, Continuation<? super SuperLiteStateMonitor$monitorNavPrivacyAgreementState$2> continuation) {
        super(2, continuation);
        this.$key = key;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SuperLiteStateMonitor$monitorNavPrivacyAgreementState$2 superLiteStateMonitor$monitorNavPrivacyAgreementState$2 = new SuperLiteStateMonitor$monitorNavPrivacyAgreementState$2(this.$key, continuation);
        superLiteStateMonitor$monitorNavPrivacyAgreementState$2.L$0 = obj;
        return superLiteStateMonitor$monitorNavPrivacyAgreementState$2;
    }

    @Nullable
    public final Object invoke(@NotNull MutablePreferences mutablePreferences, @Nullable Continuation<? super Unit> continuation) {
        return ((SuperLiteStateMonitor$monitorNavPrivacyAgreementState$2) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ((MutablePreferences) this.L$0).k(this.$key, Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
