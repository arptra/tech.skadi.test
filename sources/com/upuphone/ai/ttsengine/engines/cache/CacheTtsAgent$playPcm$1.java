package com.upuphone.ai.ttsengine.engines.cache;

import com.upuphone.ai.ttsengine.base.player.PcmPlayer;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ai.ttsengine.engines.cache.CacheTtsAgent$playPcm$1", f = "CacheTtsAgent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CacheTtsAgent$playPcm$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $cacheFile;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CacheTtsAgent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CacheTtsAgent$playPcm$1(File file, CacheTtsAgent cacheTtsAgent, Continuation<? super CacheTtsAgent$playPcm$1> continuation) {
        super(2, continuation);
        this.$cacheFile = file;
        this.this$0 = cacheTtsAgent;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CacheTtsAgent$playPcm$1 cacheTtsAgent$playPcm$1 = new CacheTtsAgent$playPcm$1(this.$cacheFile, this.this$0, continuation);
        cacheTtsAgent$playPcm$1.L$0 = obj;
        return cacheTtsAgent$playPcm$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(this.$cacheFile));
            CacheTtsAgent cacheTtsAgent = this.this$0;
            File file = this.$cacheFile;
            try {
                cacheTtsAgent.setAudioPlaying(true);
                PcmPlayer pcmPlayer = new PcmPlayer(cacheTtsAgent.getApplication(), cacheTtsAgent.getCallingState(), 0, 0, cacheTtsAgent.getDisableBT(), 12, (DefaultConstructorMarker) null);
                pcmPlayer.m(cacheTtsAgent.ttsPlayListener);
                pcmPlayer.o();
                byte[] bArr = new byte[(pcmPlayer.y() * 2)];
                int i = 0;
                while (true) {
                    CoroutineScopeKt.g(coroutineScope);
                    int read = dataInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    int i2 = i + read;
                    PcmPlayer.w(pcmPlayer, bArr, read, false, 4, (Object) null);
                    i = i2;
                }
                if (i > 0) {
                    pcmPlayer.x();
                } else {
                    file.delete();
                    cacheTtsAgent.onPlayError(7);
                    cacheTtsAgent.getAiLog().h("cache file is empty error", new Object[0]);
                }
                cacheTtsAgent.audioPlayer = pcmPlayer;
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(dataInputStream, (Throwable) null);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                CloseableKt.closeFinally(dataInputStream, th);
                throw th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CacheTtsAgent$playPcm$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
