package com.upuphone.xr.sapp.glass;

import com.upuphone.xr.sapp.entity.AirSilentSendFileRequest;
import com.upuphone.xr.sapp.entity.AirSilentSendFileResponse;
import com.upuphone.xr.sapp.entity.AirUpdateConfig;
import com.upuphone.xr.sapp.entity.AirUpdateFileInfo;
import com.upuphone.xr.sapp.glass.AirGlassUpdater;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nAirGlassUpdater.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AirGlassUpdater.kt\ncom/upuphone/xr/sapp/glass/AirGlassUpdater$handleRequestSendUpdateFileStream$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,553:1\n288#2,2:554\n*S KotlinDebug\n*F\n+ 1 AirGlassUpdater.kt\ncom/upuphone/xr/sapp/glass/AirGlassUpdater$handleRequestSendUpdateFileStream$1\n*L\n505#1:554,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.AirGlassUpdater$handleRequestSendUpdateFileStream$1", f = "AirGlassUpdater.kt", i = {0, 0}, l = {516}, m = "invokeSuspend", n = {"fileInfo", "bytes"}, s = {"L$0", "L$1"})
public final class AirGlassUpdater$handleRequestSendUpdateFileStream$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AirSilentSendFileRequest $request;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AirGlassUpdater this$0;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.sapp.glass.AirGlassUpdater$handleRequestSendUpdateFileStream$1$1", f = "AirGlassUpdater.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.sapp.glass.AirGlassUpdater$handleRequestSendUpdateFileStream$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(airUpdateFileInfo, airSilentSendFileRequest2, bArr2, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(airUpdateFileInfo.getFilePath()), "r");
                randomAccessFile.seek((long) airSilentSendFileRequest2.getFileOffset());
                return Boxing.boxInt(randomAccessFile.read(bArr2));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Integer> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirGlassUpdater$handleRequestSendUpdateFileStream$1(AirSilentSendFileRequest airSilentSendFileRequest, AirGlassUpdater airGlassUpdater, Continuation<? super AirGlassUpdater$handleRequestSendUpdateFileStream$1> continuation) {
        super(2, continuation);
        this.$request = airSilentSendFileRequest;
        this.this$0 = airGlassUpdater;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AirGlassUpdater$handleRequestSendUpdateFileStream$1 airGlassUpdater$handleRequestSendUpdateFileStream$1 = new AirGlassUpdater$handleRequestSendUpdateFileStream$1(this.$request, this.this$0, continuation);
        airGlassUpdater$handleRequestSendUpdateFileStream$1.L$0 = obj;
        return airGlassUpdater$handleRequestSendUpdateFileStream$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        final AirUpdateFileInfo airUpdateFileInfo;
        byte[] bArr;
        T t;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            AirGlassUpdater.Companion companion = AirGlassUpdater.g;
            companion.c("handleRequestSendUpdateFileStream, request: " + this.$request);
            AirUpdateConfig p = this.this$0.e;
            if (p == null) {
                companion.d("handleRequestSendUpdateFileStream, airUpdateConfig is null");
                return Unit.INSTANCE;
            }
            List<AirUpdateFileInfo> info = p.getInfo();
            AirSilentSendFileRequest airSilentSendFileRequest = this.$request;
            Iterator<T> it = info.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                AirUpdateFileInfo airUpdateFileInfo2 = (AirUpdateFileInfo) t;
                if (Intrinsics.areEqual((Object) airUpdateFileInfo2.getFileName(), (Object) airSilentSendFileRequest.getFileName()) && Intrinsics.areEqual((Object) airUpdateFileInfo2.getMd5(), (Object) airSilentSendFileRequest.getMd5())) {
                    break;
                }
            }
            airUpdateFileInfo = (AirUpdateFileInfo) t;
            if (airUpdateFileInfo == null || !new File(airUpdateFileInfo.getFilePath()).exists()) {
                AirGlassUpdater.g.d("handleRequestSendUpdateFileStream, file not exist");
                AirGlassUpdater.Q(this.this$0, AirSilentSendFileResponse.Companion.fail(), (byte[]) null, 2, (Object) null);
                return Unit.INSTANCE;
            }
            final byte[] bArr2 = new byte[this.$request.getFileLength()];
            CoroutineDispatcher b = Dispatchers.b();
            final AirSilentSendFileRequest airSilentSendFileRequest2 = this.$request;
            AnonymousClass1 r6 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.L$0 = airUpdateFileInfo;
            this.L$1 = bArr2;
            this.label = 1;
            if (BuildersKt.g(b, r6, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            bArr = bArr2;
        } else if (i == 1) {
            bArr = (byte[]) this.L$1;
            airUpdateFileInfo = (AirUpdateFileInfo) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception unused) {
                AirGlassUpdater.g.d("");
                AirGlassUpdater.Q(this.this$0, AirSilentSendFileResponse.Companion.fail(), (byte[]) null, 2, (Object) null);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.P(new AirSilentSendFileResponse(0, airUpdateFileInfo.getFileName(), airUpdateFileInfo.getMd5(), Boxing.boxInt(this.$request.getFileOffset()), Boxing.boxInt(this.$request.getFileLength())), bArr);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AirGlassUpdater$handleRequestSendUpdateFileStream$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
