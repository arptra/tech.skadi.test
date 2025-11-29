package com.upuphone.xr.sapp.vu;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;
import com.upuphone.xr.sapp.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.ArSpaceStarterActivity$showScreenCapture$1", f = "ArSpaceStarterActivity.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
public final class ArSpaceStarterActivity$showScreenCapture$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $file;
    int label;
    final /* synthetic */ ArSpaceStarterActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArSpaceStarterActivity$showScreenCapture$1(ArSpaceStarterActivity arSpaceStarterActivity, String str, Continuation<? super ArSpaceStarterActivity$showScreenCapture$1> continuation) {
        super(2, continuation);
        this.this$0 = arSpaceStarterActivity;
        this.$file = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ArSpaceStarterActivity$showScreenCapture$1(this.this$0, this.$file, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher b = Dispatchers.b();
            ArSpaceStarterActivity$showScreenCapture$1$bitmap$1 arSpaceStarterActivity$showScreenCapture$1$bitmap$1 = new ArSpaceStarterActivity$showScreenCapture$1$bitmap$1(this.$file, this.this$0, (Continuation<? super ArSpaceStarterActivity$showScreenCapture$1$bitmap$1>) null);
            this.label = 1;
            obj = BuildersKt.g(b, arSpaceStarterActivity$showScreenCapture$1$bitmap$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Bitmap bitmap = (Bitmap) obj;
        Log.d("ArSpaceStarterActivity", "showScreenCapture: " + bitmap);
        ((ImageView) this.this$0.findViewById(R.id.image_view)).setImageBitmap(bitmap);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ArSpaceStarterActivity$showScreenCapture$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
