package defpackage;

import com.xjsd.ai.assistant.skill.navigation.checknavi.VoiceCheckNaviSupportCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u000b¨\u0006\r"}, d2 = {"LVoiceCheckNaviSupportManager;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/skill/navigation/checknavi/VoiceCheckNaviSupportCallback;", "checkNaviSupportCallback", "", "b", "(Lcom/xjsd/ai/assistant/skill/navigation/checknavi/VoiceCheckNaviSupportCallback;)V", "a", "()Lcom/xjsd/ai/assistant/skill/navigation/checknavi/VoiceCheckNaviSupportCallback;", "Lcom/xjsd/ai/assistant/skill/navigation/checknavi/VoiceCheckNaviSupportCallback;", "callback", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
/* renamed from: VoiceCheckNaviSupportManager  reason: default package */
public final class VoiceCheckNaviSupportManager {

    /* renamed from: a  reason: collision with root package name */
    public static final VoiceCheckNaviSupportManager f42a = new VoiceCheckNaviSupportManager();
    public static VoiceCheckNaviSupportCallback b;

    public final VoiceCheckNaviSupportCallback a() {
        return b;
    }

    public final void b(VoiceCheckNaviSupportCallback voiceCheckNaviSupportCallback) {
        Intrinsics.checkNotNullParameter(voiceCheckNaviSupportCallback, "checkNaviSupportCallback");
        b = voiceCheckNaviSupportCallback;
    }
}
