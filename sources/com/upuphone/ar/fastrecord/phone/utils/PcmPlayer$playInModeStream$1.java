package com.upuphone.ar.fastrecord.phone.utils;

import android.media.AudioTrack;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.utils.PcmPlayer$playInModeStream$1", f = "PcmPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PcmPlayer$playInModeStream$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $minBufferSize;
    final /* synthetic */ String $pcmPath;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PcmPlayer$playInModeStream$1(String str, int i, Continuation<? super PcmPlayer$playInModeStream$1> continuation) {
        super(2, continuation);
        this.$pcmPath = str;
        this.$minBufferSize = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PcmPlayer$playInModeStream$1(this.$pcmPath, this.$minBufferSize, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        StringBuilder sb;
        String str;
        AudioTrack access$getAudioTrack$p;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(this.$pcmPath))));
            try {
                byte[] bArr = new byte[this.$minBufferSize];
                while (dataInputStream.available() > 0) {
                    int read = dataInputStream.read(bArr);
                    if (!(read == -3 || read == -2 || read == 0 || read == -1 || (access$getAudioTrack$p = PcmPlayer.audioTrack) == null)) {
                        Boxing.boxInt(access$getAudioTrack$p.write(bArr, 0, read));
                    }
                }
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    str = e.getMessage();
                    sb = new StringBuilder();
                }
            } catch (IOException e2) {
                String message = e2.getMessage();
                LogExt.logE("playInModeStream write error = " + message, "PcmPlayer");
                try {
                    dataInputStream.close();
                } catch (IOException e3) {
                    str = e3.getMessage();
                    sb = new StringBuilder();
                }
            } catch (Throwable th) {
                try {
                    dataInputStream.close();
                } catch (IOException e4) {
                    String message2 = e4.getMessage();
                    LogExt.logE("playInModeStream write finally error = " + message2, "PcmPlayer");
                }
                throw th;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        sb.append("playInModeStream write finally error = ");
        sb.append(str);
        LogExt.logE(sb.toString(), "PcmPlayer");
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PcmPlayer$playInModeStream$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
