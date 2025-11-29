package com.upuphone.ai.ttsengine.engines.wav.internal;

import android.app.Application;
import android.content.res.AssetManager;
import com.upuphone.ai.ttsengine.base.player.PcmPlayer;
import java.io.DataInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ai.ttsengine.engines.wav.internal.PcmTtsAgent$startSpeak$1", f = "PcmTtsAgent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PcmTtsAgent$startSpeak$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $paramString;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PcmTtsAgent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PcmTtsAgent$startSpeak$1(PcmTtsAgent pcmTtsAgent, String str, Continuation<? super PcmTtsAgent$startSpeak$1> continuation) {
        super(2, continuation);
        this.this$0 = pcmTtsAgent;
        this.$paramString = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PcmTtsAgent$startSpeak$1 pcmTtsAgent$startSpeak$1 = new PcmTtsAgent$startSpeak$1(this.this$0, this.$paramString, continuation);
        pcmTtsAgent$startSpeak$1.L$0 = obj;
        return pcmTtsAgent$startSpeak$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        InputStream inputStream;
        AssetManager assets;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Application access$getApplication = this.this$0.getApplication();
            if (access$getApplication == null || (assets = access$getApplication.getAssets()) == null) {
                inputStream = null;
            } else {
                Object obj2 = this.this$0.supportWords.get(StringsKt.trim((CharSequence) StringsKt.replace$default(this.$paramString, StringUtils.LF, " ", false, 4, (Object) null)).toString());
                Intrinsics.checkNotNull(obj2);
                inputStream = assets.open((String) obj2);
            }
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            PcmTtsAgent pcmTtsAgent = this.this$0;
            String str = this.$paramString;
            pcmTtsAgent.setAudioPlaying(true);
            PcmPlayer pcmPlayer = new PcmPlayer(pcmTtsAgent.getApplication(), pcmTtsAgent.getCallingState(), 0, 0, pcmTtsAgent.getDisableBT(), 12, (DefaultConstructorMarker) null);
            pcmPlayer.m(pcmTtsAgent.ttsPlayListener);
            pcmPlayer.o();
            pcmTtsAgent.audioPlayer = pcmPlayer;
            PcmPlayer access$getAudioPlayer$p = pcmTtsAgent.audioPlayer;
            Intrinsics.checkNotNull(access$getAudioPlayer$p);
            byte[] bArr = new byte[(access$getAudioPlayer$p.y() * 2)];
            int i = 0;
            while (true) {
                CoroutineScopeKt.g(coroutineScope);
                int read = dataInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                int i2 = i + read;
                PcmPlayer access$getAudioPlayer$p2 = pcmTtsAgent.audioPlayer;
                if (access$getAudioPlayer$p2 != null) {
                    PcmPlayer.w(access$getAudioPlayer$p2, bArr, read, false, 4, (Object) null);
                }
                i = i2;
            }
            if (i > 0) {
                PcmPlayer access$getAudioPlayer$p3 = pcmTtsAgent.audioPlayer;
                if (access$getAudioPlayer$p3 != null) {
                    Boxing.boxInt(access$getAudioPlayer$p3.x());
                }
            } else {
                pcmTtsAgent.supportWords.remove(str);
                pcmTtsAgent.onPlayError(7);
                pcmTtsAgent.getAiLog().h("cache file is empty error", new Object[0]);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PcmTtsAgent$startSpeak$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
