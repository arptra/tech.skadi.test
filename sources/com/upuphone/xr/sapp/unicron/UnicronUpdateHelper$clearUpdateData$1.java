package com.upuphone.xr.sapp.unicron;

import com.upuphone.star.download.manager.DownloadManager;
import com.upuphone.star.download.manager.DownloadTask;
import com.upuphone.xr.sapp.entity.DownloadingUpdateConfig;
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
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nUnicronUpdateHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnicronUpdateHelper.kt\ncom/upuphone/xr/sapp/unicron/UnicronUpdateHelper$clearUpdateData$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,760:1\n1855#2,2:761\n*S KotlinDebug\n*F\n+ 1 UnicronUpdateHelper.kt\ncom/upuphone/xr/sapp/unicron/UnicronUpdateHelper$clearUpdateData$1\n*L\n686#1:761,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.unicron.UnicronUpdateHelper$clearUpdateData$1", f = "UnicronUpdateHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UnicronUpdateHelper$clearUpdateData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public UnicronUpdateHelper$clearUpdateData$1(Continuation<? super UnicronUpdateHelper$clearUpdateData$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new UnicronUpdateHelper$clearUpdateData$1(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DownloadingUpdateConfig j = UnicronUpdateHelper.g;
            if (j != null) {
                UnicronUpdateHelper unicronUpdateHelper = UnicronUpdateHelper.b;
                DownloadTask downloadTask = j.getDownloadTask();
                unicronUpdateHelper.L("clearUpdateData, cancelDownload: " + downloadTask);
                DownloadManager.b.j(j.getDownloadTask(), true);
            }
            UnicronUpdateHelper.g = null;
            UnicronUpdateHelper unicronUpdateHelper2 = UnicronUpdateHelper.b;
            Set<String> h = unicronUpdateHelper2.H();
            unicronUpdateHelper2.L("clear glass update files size: " + h);
            for (String str : h) {
                try {
                    UnicronUpdateHelper unicronUpdateHelper3 = UnicronUpdateHelper.b;
                    unicronUpdateHelper3.L("delete file in: " + str);
                    FileUtils.f7881a.c(str);
                } catch (Exception e) {
                    UnicronUpdateHelper unicronUpdateHelper4 = UnicronUpdateHelper.b;
                    unicronUpdateHelper4.M("delete file error: " + e);
                }
            }
            UnicronUpdateHelper.b.X(SetsKt.emptySet());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((UnicronUpdateHelper$clearUpdateData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
