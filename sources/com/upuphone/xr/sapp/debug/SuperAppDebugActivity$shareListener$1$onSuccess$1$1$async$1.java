package com.upuphone.xr.sapp.debug;

import android.net.Uri;
import com.upuphone.xr.sapp.utils.FileUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.debug.SuperAppDebugActivity$shareListener$1$onSuccess$1$1$async$1", f = "SuperAppDebugActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SuperAppDebugActivity$shareListener$1$onSuccess$1$1$async$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    final /* synthetic */ Uri $receiveUri;
    int label;
    final /* synthetic */ SuperAppDebugActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuperAppDebugActivity$shareListener$1$onSuccess$1$1$async$1(SuperAppDebugActivity superAppDebugActivity, Uri uri, Continuation<? super SuperAppDebugActivity$shareListener$1$onSuccess$1$1$async$1> continuation) {
        super(2, continuation);
        this.this$0 = superAppDebugActivity;
        this.$receiveUri = uri;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SuperAppDebugActivity$shareListener$1$onSuccess$1$1$async$1(this.this$0, this.$receiveUri, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SuperAppDebugActivity superAppDebugActivity = this.this$0;
            String path = this.$receiveUri.getPath();
            superAppDebugActivity.S0("glass log file path->" + path);
            String path2 = this.$receiveUri.getPath();
            if (path2 == null) {
                path2 = "";
            }
            File file = new File(path2);
            String name = file.getName();
            return Boxing.boxLong(FileUtils.f7881a.a(file, new File("/data/data/com.upuphone.star.launcher.intl/files/ulog/glass_log_" + name)));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Long> continuation) {
        return ((SuperAppDebugActivity$shareListener$1$onSuccess$1$1$async$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
