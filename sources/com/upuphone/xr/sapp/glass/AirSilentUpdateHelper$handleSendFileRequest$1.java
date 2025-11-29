package com.upuphone.xr.sapp.glass;

import com.upuphone.xr.sapp.entity.AirSilentSendFileRequest;
import com.upuphone.xr.sapp.entity.AirSilentSendFileResponse;
import com.upuphone.xr.sapp.entity.AirUpdateFileInfo;
import java.io.File;
import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.AirSilentUpdateHelper$handleSendFileRequest$1", f = "AirSilentUpdateHelper.kt", i = {0}, l = {251}, m = "invokeSuspend", n = {"bytes"}, s = {"L$0"})
public final class AirSilentUpdateHelper$handleSendFileRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AirUpdateFileInfo $fileInfo;
    final /* synthetic */ AirSilentSendFileRequest $request;
    Object L$0;
    int label;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.sapp.glass.AirSilentUpdateHelper$handleSendFileRequest$1$1", f = "AirSilentUpdateHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.sapp.glass.AirSilentUpdateHelper$handleSendFileRequest$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(airUpdateFileInfo, airSilentSendFileRequest, bArr2, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(airUpdateFileInfo.getFilePath()), "r");
                randomAccessFile.seek((long) airSilentSendFileRequest.getFileOffset());
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
    public AirSilentUpdateHelper$handleSendFileRequest$1(AirSilentSendFileRequest airSilentSendFileRequest, AirUpdateFileInfo airUpdateFileInfo, Continuation<? super AirSilentUpdateHelper$handleSendFileRequest$1> continuation) {
        super(2, continuation);
        this.$request = airSilentSendFileRequest;
        this.$fileInfo = airUpdateFileInfo;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AirSilentUpdateHelper$handleSendFileRequest$1(this.$request, this.$fileInfo, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        byte[] bArr;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final byte[] bArr2 = new byte[this.$request.getFileLength()];
            CoroutineDispatcher b = Dispatchers.b();
            final AirUpdateFileInfo airUpdateFileInfo = this.$fileInfo;
            final AirSilentSendFileRequest airSilentSendFileRequest = this.$request;
            AnonymousClass1 r4 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.L$0 = bArr2;
            this.label = 1;
            if (BuildersKt.g(b, r4, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            bArr = bArr2;
        } else if (i == 1) {
            bArr = (byte[]) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                AirSilentUpdateHelper airSilentUpdateHelper = AirSilentUpdateHelper.b;
                airSilentUpdateHelper.v("handleSendFileRequest, error: " + e);
                AirSilentUpdateHelper.A(airSilentUpdateHelper, AirSilentSendFileResponse.Companion.fail(), (byte[]) null, 2, (Object) null);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AirSilentUpdateHelper.b.y(new AirSilentSendFileResponse(0, this.$fileInfo.getFileName(), this.$fileInfo.getMd5(), Boxing.boxInt(this.$request.getFileOffset()), Boxing.boxInt(this.$request.getFileLength())), bArr);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AirSilentUpdateHelper$handleSendFileRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
