package com.upuphone.xr.sapp.vu.utils;

import android.net.Uri;
import com.upuphone.xr.sapp.vu.utils.ArSpaceReportHelper;
import java.io.File;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Landroid/net/Uri;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.vu.utils.VuScreenRecordHelper$screenShot$1$1$uri$1", f = "VuScreenRecordHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VuScreenRecordHelper$screenShot$1$1$uri$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {
    final /* synthetic */ File $file;
    int label;
    final /* synthetic */ VuScreenRecordHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VuScreenRecordHelper$screenShot$1$1$uri$1(File file, VuScreenRecordHelper vuScreenRecordHelper, Continuation<? super VuScreenRecordHelper$screenShot$1$1$uri$1> continuation) {
        super(2, continuation);
        this.$file = file;
        this.this$0 = vuScreenRecordHelper;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VuScreenRecordHelper$screenShot$1$1$uri$1(this.$file, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$file.exists() && this.$file.length() != 0) {
                return this.this$0.P(this.$file);
            }
            ArSpaceReportHelper.g(ArSpaceReportHelper.f8088a, ArSpaceReportHelper.ScreenshotResult.FILE_NOT_EXIST, (String) null, 2, (Object) null);
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Uri> continuation) {
        return ((VuScreenRecordHelper$screenShot$1$1$uri$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
