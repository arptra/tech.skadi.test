package com.upuphone.xr.sapp.utils;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.core.PreferencesKt;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "Landroidx/datastore/preferences/core/Preferences;", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.utils.DataStoreUtils$putData$1", f = "DataStoreUtils.kt", i = {}, l = {146}, m = "invokeSuspend", n = {}, s = {})
public final class DataStoreUtils$putData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Preferences>, Object> {
    final /* synthetic */ boolean $associateUser;
    final /* synthetic */ String $key;
    final /* synthetic */ Object $value;
    int label;
    final /* synthetic */ DataStoreUtils this$0;

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "it", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.sapp.utils.DataStoreUtils$putData$1$1", f = "DataStoreUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.sapp.utils.DataStoreUtils$putData$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(obj3, str2, continuation);
            r0.L$0 = obj;
            return r0;
        }

        @Nullable
        public final Object invoke(@NotNull MutablePreferences mutablePreferences, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
                Object obj2 = obj3;
                if (obj2 instanceof Integer) {
                    mutablePreferences.k(PreferencesKeys.d(str2), obj3);
                } else if (obj2 instanceof Long) {
                    mutablePreferences.k(PreferencesKeys.e(str2), obj3);
                } else if (obj2 instanceof Double) {
                    mutablePreferences.k(PreferencesKeys.b(str2), obj3);
                } else if (obj2 instanceof Float) {
                    mutablePreferences.k(PreferencesKeys.c(str2), obj3);
                } else if (obj2 instanceof Boolean) {
                    mutablePreferences.k(PreferencesKeys.a(str2), obj3);
                } else if (obj2 instanceof String) {
                    mutablePreferences.k(PreferencesKeys.f(str2), obj3);
                } else {
                    throw new IllegalArgumentException("This type can be saved into DataStore");
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataStoreUtils$putData$1(DataStoreUtils dataStoreUtils, boolean z, String str, Object obj, Continuation<? super DataStoreUtils$putData$1> continuation) {
        super(2, continuation);
        this.this$0 = dataStoreUtils;
        this.$associateUser = z;
        this.$key = str;
        this.$value = obj;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DataStoreUtils$putData$1(this.this$0, this.$associateUser, this.$key, this.$value, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DataStore d = this.this$0.m();
            if (!this.$associateUser || d == null) {
                d = this.this$0.k(GlobalExtKt.f());
            }
            ULog.Delegate delegate = ULog.f6446a;
            String str = this.$key;
            Object obj2 = this.$value;
            boolean z = this.$associateUser;
            delegate.a("DataStoreUtils", "putData key:" + str + " value:" + obj2 + "  associateUser" + z);
            final Object obj3 = this.$value;
            final String str2 = this.$key;
            AnonymousClass1 r1 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.label = 1;
            obj = PreferencesKt.a(d, r1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Preferences> continuation) {
        return ((DataStoreUtils$putData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
