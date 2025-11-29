package com.upuphone.xr.sapp.glass;

import android.net.Uri;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.entity.AirUpdateConfig;
import com.upuphone.xr.sapp.entity.AirUpdateFileInfo;
import com.upuphone.xr.sapp.entity.BasicGlassResponse;
import com.upuphone.xr.sapp.entity.RequestSendAirUpdateFile;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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

@SourceDebugExtension({"SMAP\nAirGlassUpdater.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AirGlassUpdater.kt\ncom/upuphone/xr/sapp/glass/AirGlassUpdater$handleRequestSendFile$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,553:1\n288#2,2:554\n*S KotlinDebug\n*F\n+ 1 AirGlassUpdater.kt\ncom/upuphone/xr/sapp/glass/AirGlassUpdater$handleRequestSendFile$1\n*L\n352#1:554,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.AirGlassUpdater$handleRequestSendFile$1", f = "AirGlassUpdater.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AirGlassUpdater$handleRequestSendFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<BasicGlassResponse, Unit> $callback;
    final /* synthetic */ RequestSendAirUpdateFile $request;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AirGlassUpdater this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirGlassUpdater$handleRequestSendFile$1(AirGlassUpdater airGlassUpdater, Function1<? super BasicGlassResponse, Unit> function1, RequestSendAirUpdateFile requestSendAirUpdateFile, Continuation<? super AirGlassUpdater$handleRequestSendFile$1> continuation) {
        super(2, continuation);
        this.this$0 = airGlassUpdater;
        this.$callback = function1;
        this.$request = requestSendAirUpdateFile;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AirGlassUpdater$handleRequestSendFile$1 airGlassUpdater$handleRequestSendFile$1 = new AirGlassUpdater$handleRequestSendFile$1(this.this$0, this.$callback, this.$request, continuation);
        airGlassUpdater$handleRequestSendFile$1.L$0 = obj;
        return airGlassUpdater$handleRequestSendFile$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        T t;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            AirUpdateConfig p = this.this$0.e;
            if (p == null) {
                Function1<BasicGlassResponse, Unit> function1 = this.$callback;
                AirGlassUpdater.g.d("handleRequestSendFile, airUpdateConfig is null");
                function1.invoke(BasicGlassResponse.Companion.fail("airUpdateConfig is null"));
                return Unit.INSTANCE;
            }
            List<AirUpdateFileInfo> info = p.getInfo();
            RequestSendAirUpdateFile requestSendAirUpdateFile = this.$request;
            Iterator<T> it = info.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (Intrinsics.areEqual((Object) ((AirUpdateFileInfo) t).getFileName(), (Object) requestSendAirUpdateFile.getFileName())) {
                    break;
                }
            }
            AirUpdateFileInfo airUpdateFileInfo = (AirUpdateFileInfo) t;
            if (airUpdateFileInfo == null) {
                AirGlassUpdater.g.d("handleRequestSendFile, file not found");
                this.$callback.invoke(BasicGlassResponse.Companion.fail("file not found"));
                return Unit.INSTANCE;
            }
            StarryNetDevice x = GlassHelper.f7049a.x();
            if (x == null) {
                AirGlassUpdater.g.d("handleRequestSendFile, connectedDevice is null");
                this.$callback.invoke(BasicGlassResponse.Companion.fail("connectedDevice is null"));
                return Unit.INSTANCE;
            }
            Uri j = GlassUpdateAdapter.b.j(new File(airUpdateFileInfo.getFilePath()));
            AirGlassUpdater$handleRequestSendFile$1$shareListener$1 airGlassUpdater$handleRequestSendFile$1$shareListener$1 = new AirGlassUpdater$handleRequestSendFile$1$shareListener$1(this.this$0, airUpdateFileInfo);
            String bleSend = this.this$0.G().bleSend(x.getDeviceId(), j, (String) null);
            AirGlassUpdater.g.c("handleRequestSendFile, ShareAbility#send uri: " + j + ", taskId=" + bleSend);
            if (bleSend == null) {
                this.$callback.invoke(BasicGlassResponse.Companion.fail("send file fail"));
            } else {
                this.this$0.d.a(airGlassUpdater$handleRequestSendFile$1$shareListener$1, bleSend);
                this.$callback.invoke(BasicGlassResponse.Companion.success());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AirGlassUpdater$handleRequestSendFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
