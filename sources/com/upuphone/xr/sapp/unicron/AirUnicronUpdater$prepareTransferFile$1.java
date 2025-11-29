package com.upuphone.xr.sapp.unicron;

import com.upuphone.xr.sapp.entity.BasicGlassResponse;
import com.upuphone.xr.sapp.entity.RequestUpdateFileReq;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.unicron.AirUnicronUpdater$prepareTransferFile$1", f = "AirUnicronUpdater.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AirUnicronUpdater$prepareTransferFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RequestUpdateFileReq $req;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirUnicronUpdater$prepareTransferFile$1(RequestUpdateFileReq requestUpdateFileReq, Continuation<? super AirUnicronUpdater$prepareTransferFile$1> continuation) {
        super(2, continuation);
        this.$req = requestUpdateFileReq;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AirUnicronUpdater$prepareTransferFile$1 airUnicronUpdater$prepareTransferFile$1 = new AirUnicronUpdater$prepareTransferFile$1(this.$req, continuation);
        airUnicronUpdater$prepareTransferFile$1.L$0 = obj;
        return airUnicronUpdater$prepareTransferFile$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String version;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            String digest = this.$req.getDigest();
            if (digest == null || digest.length() == 0 || (version = this.$req.getVersion()) == null || version.length() == 0) {
                AirUnicronUpdater.b.r("prepareTransferFile, wrong data");
                UnicronHelper.f7834a.k(BasicGlassResponse.Companion.fail("wrong data"));
                return Unit.INSTANCE;
            }
            AirUnicronUpdater airUnicronUpdater = AirUnicronUpdater.b;
            UnicronUpdateConfig g = airUnicronUpdater.n();
            if (g == null) {
                airUnicronUpdater.r("prepareTransferFile, savedUpdateConfig is null");
                UnicronHelper.f7834a.k(BasicGlassResponse.Companion.fail("no update config"));
                return Unit.INSTANCE;
            } else if (!Intrinsics.areEqual((Object) g.getUpdateInfo().getDigest(), (Object) this.$req.getDigest()) || !Intrinsics.areEqual((Object) g.getUpdateInfo().getLatestVersion(), (Object) this.$req.getVersion())) {
                airUnicronUpdater.r("prepareTransferFile, digest or version not match");
                UnicronHelper.f7834a.k(BasicGlassResponse.Companion.fail("no match update"));
                return Unit.INSTANCE;
            } else {
                File file = new File(g.getFilePath());
                if (!file.exists()) {
                    String filePath = g.getFilePath();
                    airUnicronUpdater.r("prepareTransferFile, file not exists: " + filePath);
                    UnicronHelper.f7834a.k(BasicGlassResponse.Companion.fail("file not exists"));
                    return Unit.INSTANCE;
                }
                airUnicronUpdater.v(file, AnonymousClass1.INSTANCE);
                return Unit.INSTANCE;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AirUnicronUpdater$prepareTransferFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
