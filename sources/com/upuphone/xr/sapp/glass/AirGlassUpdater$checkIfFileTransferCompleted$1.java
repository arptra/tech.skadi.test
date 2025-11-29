package com.upuphone.xr.sapp.glass;

import com.upuphone.star.fota.phone.GlassUpdateInfo;
import com.upuphone.xr.sapp.entity.AirUpdateConfig;
import com.upuphone.xr.sapp.entity.AirUpdateFileInfo;
import com.upuphone.xr.sapp.entity.GlassUpdateState;
import com.upuphone.xr.sapp.glass.AirGlassUpdater;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nAirGlassUpdater.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AirGlassUpdater.kt\ncom/upuphone/xr/sapp/glass/AirGlassUpdater$checkIfFileTransferCompleted$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,553:1\n1549#2:554\n1620#2,3:555\n*S KotlinDebug\n*F\n+ 1 AirGlassUpdater.kt\ncom/upuphone/xr/sapp/glass/AirGlassUpdater$checkIfFileTransferCompleted$1\n*L\n434#1:554\n434#1:555,3\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.AirGlassUpdater$checkIfFileTransferCompleted$1", f = "AirGlassUpdater.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AirGlassUpdater$checkIfFileTransferCompleted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AirGlassUpdater this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirGlassUpdater$checkIfFileTransferCompleted$1(AirGlassUpdater airGlassUpdater, Continuation<? super AirGlassUpdater$checkIfFileTransferCompleted$1> continuation) {
        super(2, continuation);
        this.this$0 = airGlassUpdater;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AirGlassUpdater$checkIfFileTransferCompleted$1 airGlassUpdater$checkIfFileTransferCompleted$1 = new AirGlassUpdater$checkIfFileTransferCompleted$1(this.this$0, continuation);
        airGlassUpdater$checkIfFileTransferCompleted$1.L$0 = obj;
        return airGlassUpdater$checkIfFileTransferCompleted$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            AirGlassUpdater.Companion companion = AirGlassUpdater.g;
            companion.c("checkIfFileTransferCompleted");
            AirUpdateConfig p = this.this$0.e;
            if (p == null) {
                companion.d("checkIfFileTransferCompleted, airUpdateConfig is null");
                return Unit.INSTANCE;
            }
            List<AirUpdateFileInfo> info = p.getInfo();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(info, 10));
            for (AirUpdateFileInfo filePath : info) {
                arrayList.add(filePath.getFilePath());
            }
            boolean containsAll = this.this$0.f.containsAll(arrayList);
            AirGlassUpdater.Companion companion2 = AirGlassUpdater.g;
            companion2.c("checkIfFileTransferCompleted, transferCompleted: " + containsAll);
            if (containsAll) {
                Function1 H = this.this$0.H();
                GlassUpdateInfo glassUpdateInfo = p.getGlassUpdateInfo();
                String uuid = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
                H.invoke(new GlassUpdateState.Installing(glassUpdateInfo, uuid));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AirGlassUpdater$checkIfFileTransferCompleted$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
