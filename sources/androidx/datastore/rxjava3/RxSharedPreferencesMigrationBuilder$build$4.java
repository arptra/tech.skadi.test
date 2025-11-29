package androidx.datastore.rxjava3;

import androidx.datastore.migrations.SharedPreferencesView;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.rx3.RxAwaitKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0001H@"}, d2 = {"<anonymous>", "T", "spView", "Landroidx/datastore/migrations/SharedPreferencesView;", "curData"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.rxjava3.RxSharedPreferencesMigrationBuilder$build$4", f = "RxSharedPreferencesMigration.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
final class RxSharedPreferencesMigrationBuilder$build$4 extends SuspendLambda implements Function3<SharedPreferencesView, Object, Continuation<Object>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ RxSharedPreferencesMigrationBuilder<Object> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxSharedPreferencesMigrationBuilder$build$4(RxSharedPreferencesMigrationBuilder<Object> rxSharedPreferencesMigrationBuilder, Continuation<? super RxSharedPreferencesMigrationBuilder$build$4> continuation) {
        super(3, continuation);
        this.this$0 = rxSharedPreferencesMigrationBuilder;
    }

    @Nullable
    public final Object invoke(@NotNull SharedPreferencesView sharedPreferencesView, Object obj, @Nullable Continuation<Object> continuation) {
        RxSharedPreferencesMigrationBuilder$build$4 rxSharedPreferencesMigrationBuilder$build$4 = new RxSharedPreferencesMigrationBuilder$build$4(this.this$0, continuation);
        rxSharedPreferencesMigrationBuilder$build$4.L$0 = sharedPreferencesView;
        rxSharedPreferencesMigrationBuilder$build$4.L$1 = obj;
        return rxSharedPreferencesMigrationBuilder$build$4.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.L$1;
            Single b = this.this$0.f1171a.b((SharedPreferencesView) this.L$0, obj2);
            this.L$0 = null;
            this.label = 1;
            obj = RxAwaitKt.b(b, this);
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
}
