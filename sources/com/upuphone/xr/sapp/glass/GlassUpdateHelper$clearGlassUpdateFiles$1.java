package com.upuphone.xr.sapp.glass;

import com.upuphone.xr.sapp.utils.FileUtils;
import java.io.File;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nGlassUpdateHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassUpdateHelper.kt\ncom/upuphone/xr/sapp/glass/GlassUpdateHelper$clearGlassUpdateFiles$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1750:1\n1855#2,2:1751\n*S KotlinDebug\n*F\n+ 1 GlassUpdateHelper.kt\ncom/upuphone/xr/sapp/glass/GlassUpdateHelper$clearGlassUpdateFiles$1\n*L\n1179#1:1751,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassUpdateHelper$clearGlassUpdateFiles$1", f = "GlassUpdateHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GlassUpdateHelper$clearGlassUpdateFiles$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<File> $excludeFiles;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassUpdateHelper$clearGlassUpdateFiles$1(List<? extends File> list, Continuation<? super GlassUpdateHelper$clearGlassUpdateFiles$1> continuation) {
        super(2, continuation);
        this.$excludeFiles = list;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassUpdateHelper$clearGlassUpdateFiles$1(this.$excludeFiles, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
            Set<String> l = glassUpdateHelper.w0();
            glassUpdateHelper.d1("clearGlassUpdateFiles, files: " + l);
            List<File> list = this.$excludeFiles;
            for (String str : l) {
                try {
                    GlassUpdateHelper glassUpdateHelper2 = GlassUpdateHelper.b;
                    glassUpdateHelper2.d1("clearGlassUpdateFiles, delete file in: " + str);
                    FileUtils.f7881a.d(str, list);
                } catch (Exception e) {
                    GlassUpdateHelper glassUpdateHelper3 = GlassUpdateHelper.b;
                    glassUpdateHelper3.e1("clearGlassUpdateFiles, delete file error: " + e);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlassUpdateHelper$clearGlassUpdateFiles$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
