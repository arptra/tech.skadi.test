package com.upuphone.ai.ttsengine.engines.cache;

import android.app.Application;
import com.upuphone.ai.ttsengine.base.player.Mp3Player;
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
@DebugMetadata(c = "com.upuphone.ai.ttsengine.engines.cache.CacheTtsAgent$playMp3$1", f = "CacheTtsAgent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CacheTtsAgent$playMp3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $cacheFile;
    int label;
    final /* synthetic */ CacheTtsAgent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CacheTtsAgent$playMp3$1(CacheTtsAgent cacheTtsAgent, File file, Continuation<? super CacheTtsAgent$playMp3$1> continuation) {
        super(2, continuation);
        this.this$0 = cacheTtsAgent;
        this.$cacheFile = file;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CacheTtsAgent$playMp3$1(this.this$0, this.$cacheFile, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.setAudioPlaying(true);
            this.this$0.getAiLog().c("play mp3 cache file", new Object[0]);
            CacheTtsAgent cacheTtsAgent = this.this$0;
            Application access$getApplication = this.this$0.getApplication();
            Intrinsics.checkNotNull(access$getApplication);
            Mp3Player mp3Player = new Mp3Player(access$getApplication, this.this$0.getCallingState(), this.this$0.getDisableBT());
            CacheTtsAgent cacheTtsAgent2 = this.this$0;
            File file = this.$cacheFile;
            mp3Player.m(cacheTtsAgent2.ttsPlayListener);
            String path = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
            mp3Player.w(path);
            mp3Player.o();
            cacheTtsAgent.audioPlayer = mp3Player;
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CacheTtsAgent$playMp3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
