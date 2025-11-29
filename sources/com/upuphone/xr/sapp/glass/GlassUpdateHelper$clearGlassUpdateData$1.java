package com.upuphone.xr.sapp.glass;

import com.upuphone.star.download.manager.DownloadManager;
import com.upuphone.star.download.manager.DownloadTask;
import com.upuphone.xr.sapp.entity.DownloadingUpdateConfig;
import com.upuphone.xr.sapp.entity.GlassUpdateDownloadProgress;
import com.upuphone.xr.sapp.utils.FileUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nGlassUpdateHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlassUpdateHelper.kt\ncom/upuphone/xr/sapp/glass/GlassUpdateHelper$clearGlassUpdateData$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1750:1\n1855#2,2:1751\n*S KotlinDebug\n*F\n+ 1 GlassUpdateHelper.kt\ncom/upuphone/xr/sapp/glass/GlassUpdateHelper$clearGlassUpdateData$1\n*L\n1159#1:1751,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassUpdateHelper$clearGlassUpdateData$1", f = "GlassUpdateHelper.kt", i = {}, l = {1148}, m = "invokeSuspend", n = {}, s = {})
public final class GlassUpdateHelper$clearGlassUpdateData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassUpdateHelper$clearGlassUpdateData$1$1", f = "GlassUpdateHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.sapp.glass.GlassUpdateHelper$clearGlassUpdateData$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GlassUpdateHelper.c.setValue((Object) null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public GlassUpdateHelper$clearGlassUpdateData$1(Continuation<? super GlassUpdateHelper$clearGlassUpdateData$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassUpdateHelper$clearGlassUpdateData$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MainCoroutineDispatcher c = Dispatchers.c();
            AnonymousClass1 r1 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.label = 1;
            if (BuildersKt.g(c, r1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        DownloadingUpdateConfig m = GlassUpdateHelper.r;
        if (m != null) {
            GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
            DownloadTask downloadTask = m.getDownloadTask();
            glassUpdateHelper.d1("clearGlassUpdateData, cancelDownload: " + downloadTask);
            DownloadManager.b.j(m.getDownloadTask(), true);
        }
        GlassUpdateHelper.r = null;
        GlassUpdateHelper glassUpdateHelper2 = GlassUpdateHelper.b;
        Set<String> l = glassUpdateHelper2.w0();
        glassUpdateHelper2.d1("clearGlassUpdateData, files: " + l);
        for (String str : l) {
            try {
                GlassUpdateHelper glassUpdateHelper3 = GlassUpdateHelper.b;
                glassUpdateHelper3.d1("clearGlassUpdateData, delete file in: " + str);
                FileUtils.f7881a.c(str);
            } catch (Exception e) {
                GlassUpdateHelper glassUpdateHelper4 = GlassUpdateHelper.b;
                glassUpdateHelper4.e1("clearGlassUpdateData, delete file error: " + e);
            }
        }
        GlassUpdateHelper glassUpdateHelper5 = GlassUpdateHelper.b;
        glassUpdateHelper5.o1(SetsKt.emptySet());
        glassUpdateHelper5.A1((GlassUpdateDownloadProgress) null);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlassUpdateHelper$clearGlassUpdateData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
