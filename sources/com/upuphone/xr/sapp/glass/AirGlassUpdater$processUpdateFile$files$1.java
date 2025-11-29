package com.upuphone.xr.sapp.glass;

import com.upuphone.xr.sapp.glass.AirGlassUpdater;
import com.upuphone.xr.sapp.utils.ZipUtils;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.AirGlassUpdater$processUpdateFile$files$1", f = "AirGlassUpdater.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AirGlassUpdater$processUpdateFile$files$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends File>>, Object> {
    final /* synthetic */ File $file;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirGlassUpdater$processUpdateFile$files$1(File file, Continuation<? super AirGlassUpdater$processUpdateFile$files$1> continuation) {
        super(2, continuation);
        this.$file = file;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AirGlassUpdater$processUpdateFile$files$1(this.$file, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                return ZipUtils.f7938a.d(this.$file);
            } catch (Exception e) {
                AirGlassUpdater.Companion companion = AirGlassUpdater.g;
                companion.d("processUpdateFile error: " + e);
                return CollectionsKt.emptyList();
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<? extends File>> continuation) {
        return ((AirGlassUpdater$processUpdateFile$files$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
