package com.upuphone.xr.sapp.glass;

import com.upuphone.star.fota.phone.utils.ExtendsKt;
import com.upuphone.xr.sapp.entity.AirUpdateFileInfo;
import java.io.File;
import java.util.ArrayList;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nAirGlassUpdater.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AirGlassUpdater.kt\ncom/upuphone/xr/sapp/glass/AirGlassUpdater$transferFileAndInstall$1$fileInfo$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,553:1\n1549#2:554\n1620#2,3:555\n*S KotlinDebug\n*F\n+ 1 AirGlassUpdater.kt\ncom/upuphone/xr/sapp/glass/AirGlassUpdater$transferFileAndInstall$1$fileInfo$1\n*L\n296#1:554\n296#1:555,3\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lcom/upuphone/xr/sapp/entity/AirUpdateFileInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.AirGlassUpdater$transferFileAndInstall$1$fileInfo$1", f = "AirGlassUpdater.kt", i = {}, l = {296}, m = "invokeSuspend", n = {}, s = {})
public final class AirGlassUpdater$transferFileAndInstall$1$fileInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends AirUpdateFileInfo>>, Object> {
    final /* synthetic */ File $downloadFile;
    int label;
    final /* synthetic */ AirGlassUpdater this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirGlassUpdater$transferFileAndInstall$1$fileInfo$1(AirGlassUpdater airGlassUpdater, File file, Continuation<? super AirGlassUpdater$transferFileAndInstall$1$fileInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = airGlassUpdater;
        this.$downloadFile = file;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AirGlassUpdater$transferFileAndInstall$1$fileInfo$1(this.this$0, this.$downloadFile, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AirGlassUpdater airGlassUpdater = this.this$0;
            File file = this.$downloadFile;
            this.label = 1;
            obj = airGlassUpdater.O(file, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable<File> iterable = (Iterable) obj;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (File file2 : iterable) {
            String name = file2.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            long length = file2.length();
            String a2 = ExtendsKt.a(file2);
            String absolutePath = file2.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            arrayList.add(new AirUpdateFileInfo(name, length, a2, absolutePath));
        }
        return arrayList;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<AirUpdateFileInfo>> continuation) {
        return ((AirGlassUpdater$transferFileAndInstall$1$fileInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
