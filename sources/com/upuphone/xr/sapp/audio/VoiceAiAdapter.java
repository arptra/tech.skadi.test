package com.upuphone.xr.sapp.audio;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.audio.VoiceStatus;
import com.xjsd.ai.annotation.AudioConfigFile;
import com.xjsd.ai.assistant.audio.AudioDataUtil;
import com.xjsd.ai.voice.IVoiceListener;
import com.xjsd.ai.voice.VoiceAdapter;
import io.flutter.plugin.platform.PlatformPlugin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 72\u00020\u0001:\u00018B2\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u000eJ\r\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u000eJ\u001d\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ9\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b\u001a\u0010!J!\u0010%\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010$\u001a\u00020\u0013H\u0016¢\u0006\u0004\b%\u0010&J!\u0010(\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010'\u001a\u00020\u0013H\u0016¢\u0006\u0004\b(\u0010&J'\u0010+\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u0013H\u0016¢\u0006\u0004\b+\u0010,R2\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010-\u001a\u0004\b.\u0010/R\u0014\u00102\u001a\u0002008\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u00101R\u0016\u00105\u001a\u0002038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u00104R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u00104¨\u00069"}, d2 = {"Lcom/upuphone/xr/sapp/audio/VoiceAiAdapter;", "Lcom/xjsd/ai/voice/IVoiceListener;", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Lcom/upuphone/xr/sapp/audio/VoiceStatus;", "Lkotlin/ParameterName;", "name", "status", "", "listener", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "c", "()V", "d", "b", "", "data", "", "len", "a", "([BI)V", "vadStatus", "bytes", "wavId", "onData", "(I[BI)V", "vad", "p2", "p3", "", "p4", "(I[BIIF)V", "", "s", "msgId", "onMsg", "(Ljava/lang/String;I)V", "i", "onWakeup", "i1", "i2", "oneshotCallBack", "(III)V", "Lkotlin/jvm/functions/Function1;", "getListener", "()Lkotlin/jvm/functions/Function1;", "Lcom/xjsd/ai/voice/VoiceAdapter;", "Lcom/xjsd/ai/voice/VoiceAdapter;", "adapter", "", "Z", "isLowPowerWakeupSuccess", "initialized", "e", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class VoiceAiAdapter implements IVoiceListener {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f6645a;
    public final VoiceAdapter b;
    public volatile boolean c;
    public volatile boolean d;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/xr/sapp/audio/VoiceAiAdapter$Companion;", "", "()V", "TAG", "", "VOICE_AI_CONFIG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public VoiceAiAdapter(Context context, Function1 function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f6645a = function1;
        VoiceAdapter voiceAdapter = new VoiceAdapter();
        this.b = voiceAdapter;
        try {
            voiceAdapter.init(context, AudioConfigFile.GLOABLE_ASSISTANT_STAR_WKPVADCWRONLY);
            voiceAdapter.registerListener(this);
            voiceAdapter.Start();
            ULog.Delegate delegate = ULog.f6446a;
            String Version = voiceAdapter.Version();
            int GetSizePerSend = voiceAdapter.GetSizePerSend();
            delegate.a("VoiceAiAdapter", "voice ai version: " + Version + ", size per send: " + GetSizePerSend);
            this.d = true;
        } catch (Exception e2) {
            ULog.Delegate delegate2 = ULog.f6446a;
            String message = e2.getMessage();
            delegate2.c("VoiceAiAdapter", "Voice ai init error: " + message);
            this.d = false;
        }
    }

    public final void a(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        if (this.c) {
            ULog.f6446a.g("VoiceAiAdapter", "二级唤醒已处理完成，后续数据无需处理");
            AudioDataUtil.c(bArr);
            return;
        }
        int i2 = 0;
        while (i2 != i) {
            int i3 = i2 + PlatformPlugin.DEFAULT_SYSTEM_UI > i ? i - i2 : 1280;
            byte[] bArr2 = new byte[PlatformPlugin.DEFAULT_SYSTEM_UI];
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            i2 += i3;
            AudioDataUtil.c(bArr2);
            this.b.Feed(bArr2);
        }
    }

    public final void b() {
        this.b.unregisterListener();
        this.b.Destory();
    }

    public final void c() {
        this.c = false;
        this.b.Reset();
        this.b.setPttEvent();
        if (this.d) {
            this.b.switchOn();
        } else {
            this.b.Start();
        }
    }

    public final void d() {
        this.c = false;
        this.b.switchOff();
    }

    public void onData(int i, byte[] bArr, int i2, int i3, float f) {
    }

    public void onMsg(String str, int i) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("VoiceAiAdapter", "onMsg size: " + str);
    }

    public void onWakeup(String str, int i) {
        this.c = true;
        this.f6645a.invoke(VoiceStatus.Wakeup.f6647a);
    }

    public void oneshotCallBack(int i, int i2, int i3) {
    }

    public void onData(int i, byte[] bArr, int i2) {
        if (i == 2) {
            ULog.f6446a.a("VoiceAiAdapter", "vad start");
        } else if (i == 4) {
            ULog.f6446a.a("VoiceAiAdapter", "vad end");
        }
        this.f6645a.invoke(new VoiceStatus.Data(i, bArr));
    }
}
