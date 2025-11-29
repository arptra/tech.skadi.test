package io.flutter.plugins.sharedpreferences;

import android.content.Context;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getBool$1", f = "SharedPreferencesPlugin.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
public final class SharedPreferencesPlugin$getBool$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ Ref.ObjectRef<Boolean> $value;
    Object L$0;
    int label;
    final /* synthetic */ SharedPreferencesPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SharedPreferencesPlugin$getBool$1(String str, SharedPreferencesPlugin sharedPreferencesPlugin, Ref.ObjectRef<Boolean> objectRef, Continuation<? super SharedPreferencesPlugin$getBool$1> continuation) {
        super(2, continuation);
        this.$key = str;
        this.this$0 = sharedPreferencesPlugin;
        this.$value = objectRef;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SharedPreferencesPlugin$getBool$1(this.$key, this.this$0, this.$value, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull T t) {
        Ref.ObjectRef<Boolean> objectRef;
        T coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(t);
            Preferences.Key a2 = PreferencesKeys.a(this.$key);
            Context access$getContext$p = this.this$0.context;
            if (access$getContext$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                access$getContext$p = null;
            }
            SharedPreferencesPlugin$getBool$1$invokeSuspend$$inlined$map$1 sharedPreferencesPlugin$getBool$1$invokeSuspend$$inlined$map$1 = new SharedPreferencesPlugin$getBool$1$invokeSuspend$$inlined$map$1(SharedPreferencesPluginKt.getSharedPreferencesDataStore(access$getContext$p).getData(), a2);
            Ref.ObjectRef<Boolean> objectRef2 = this.$value;
            this.L$0 = objectRef2;
            this.label = 1;
            T y = FlowKt.y(sharedPreferencesPlugin$getBool$1$invokeSuspend$$inlined$map$1, this);
            if (y == coroutine_suspended) {
                return coroutine_suspended;
            }
            Ref.ObjectRef<Boolean> objectRef3 = objectRef2;
            t = y;
            objectRef = objectRef3;
        } else if (i == 1) {
            objectRef = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(t);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        objectRef.element = t;
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SharedPreferencesPlugin$getBool$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
