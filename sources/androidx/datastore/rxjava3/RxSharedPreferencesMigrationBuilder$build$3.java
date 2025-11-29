package androidx.datastore.rxjava3;

import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.rx3.RxAwaitKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H@"}, d2 = {"<anonymous>", "", "T", "curData"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.rxjava3.RxSharedPreferencesMigrationBuilder$build$3", f = "RxSharedPreferencesMigration.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
final class RxSharedPreferencesMigrationBuilder$build$3 extends SuspendLambda implements Function2<Object, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RxSharedPreferencesMigrationBuilder<Object> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxSharedPreferencesMigrationBuilder$build$3(RxSharedPreferencesMigrationBuilder<Object> rxSharedPreferencesMigrationBuilder, Continuation<? super RxSharedPreferencesMigrationBuilder$build$3> continuation) {
        super(2, continuation);
        this.this$0 = rxSharedPreferencesMigrationBuilder;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RxSharedPreferencesMigrationBuilder$build$3 rxSharedPreferencesMigrationBuilder$build$3 = new RxSharedPreferencesMigrationBuilder$build$3(this.this$0, continuation);
        rxSharedPreferencesMigrationBuilder$build$3.L$0 = obj;
        return rxSharedPreferencesMigrationBuilder$build$3;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Single a2 = this.this$0.f1171a.a(this.L$0);
            this.label = 1;
            obj = RxAwaitKt.b(a2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Intrinsics.checkNotNullExpressionValue(obj, "rxSharedPreferencesMigration.shouldMigrate(curData).await()");
        return obj;
    }

    @Nullable
    public final Object invoke(Object obj, @Nullable Continuation<? super Boolean> continuation) {
        return ((RxSharedPreferencesMigrationBuilder$build$3) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
