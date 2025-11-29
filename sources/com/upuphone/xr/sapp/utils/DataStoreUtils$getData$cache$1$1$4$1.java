package com.upuphone.xr.sapp.utils;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.utils.DataStoreUtils$getData$cache$1$1$4$1", f = "DataStoreUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DataStoreUtils$getData$cache$1$1$4$1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
    final /* synthetic */ Preferences.Key<? extends Object> $mPreferencesKey;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataStoreUtils$getData$cache$1$1$4$1(Preferences.Key<? extends Object> key, Continuation<? super DataStoreUtils$getData$cache$1$1$4$1> continuation) {
        super(2, continuation);
        this.$mPreferencesKey = key;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DataStoreUtils$getData$cache$1$1$4$1 dataStoreUtils$getData$cache$1$1$4$1 = new DataStoreUtils$getData$cache$1$1$4$1(this.$mPreferencesKey, continuation);
        dataStoreUtils$getData$cache$1$1$4$1.L$0 = obj;
        return dataStoreUtils$getData$cache$1$1$4$1;
    }

    @Nullable
    public final Object invoke(@NotNull MutablePreferences mutablePreferences, @Nullable Continuation<? super Unit> continuation) {
        return ((DataStoreUtils$getData$cache$1$1$4$1) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ((MutablePreferences) this.L$0).j(this.$mPreferencesKey);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
