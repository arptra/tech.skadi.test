package com.xjsd.ai.assistant.phone.export;

import androidx.core.util.Consumer;
import com.honey.account.ja.a;
import com.honey.account.ja.b;
import com.xjsd.ai.assistant.audio.AudioDataUtil;
import com.xjsd.ai.assistant.cloud.CloudAbility;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.phone.codec.PcmToAmrWbCoder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0003J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/xjsd/ai/assistant/phone/export/AmrWbStrategy;", "Lcom/xjsd/ai/assistant/phone/export/ParentFeedAudioDataToCloudStrategy;", "<init>", "()V", "", "g", "c", "a", "d", "", "data", "f", "([B)V", "", "e", "()Ljava/lang/String;", "Lcom/xjsd/ai/assistant/phone/codec/PcmToAmrWbCoder;", "b", "Lkotlin/Lazy;", "i", "()Lcom/xjsd/ai/assistant/phone/codec/PcmToAmrWbCoder;", "pcmToAmrWbCoder", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AmrWbStrategy extends ParentFeedAudioDataToCloudStrategy {
    public final Lazy b = LazyKt.lazy(AmrWbStrategy$pcmToAmrWbCoder$2.INSTANCE);

    public static final void j(Integer num) {
        CloudAbility cloudAbility;
        if (num != null && num.intValue() == 200 && (cloudAbility = (CloudAbility) AbilityManager.b.b(CloudAbility.class)) != null) {
            cloudAbility.flush();
        }
    }

    public static final void k(byte[] bArr) {
        AudioDataUtil.f(bArr);
        CloudAbility cloudAbility = (CloudAbility) AbilityManager.b.b(CloudAbility.class);
        if (cloudAbility != null) {
            cloudAbility.feedData(bArr);
        }
    }

    public void a() {
        i().c();
    }

    public void c() {
        byte[] bytes = "#!AMR-WB\n".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        CloudAbility cloudAbility = (CloudAbility) AbilityManager.b.b(CloudAbility.class);
        if (cloudAbility != null) {
            cloudAbility.feedData(bytes);
        }
    }

    public void d() {
        i().g((Consumer) null);
        i().f((Consumer) null);
    }

    public String e() {
        return "AMR_WB";
    }

    public void f(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        i().b(bArr);
    }

    public void g() {
        byte[] bytes = "#!AMR-WB\n".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        AudioDataUtil.f(bytes);
        PcmToAmrWbCoder i = i();
        i.g(new a());
        i.f(new b());
        i.h();
    }

    public final PcmToAmrWbCoder i() {
        return (PcmToAmrWbCoder) this.b.getValue();
    }
}
