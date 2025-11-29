package com.xjsd.ai.assistant.phone.export;

import com.xjsd.ai.assistant.cloud.CloudAbility;
import com.xjsd.ai.assistant.core.AbilityManager;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/xjsd/ai/assistant/phone/export/PcmStrategy;", "Lcom/xjsd/ai/assistant/phone/export/ParentFeedAudioDataToCloudStrategy;", "", "a", "()V", "", "data", "f", "([B)V", "", "e", "()Ljava/lang/String;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class PcmStrategy extends ParentFeedAudioDataToCloudStrategy {
    public void a() {
        CloudAbility cloudAbility = (CloudAbility) AbilityManager.b.b(CloudAbility.class);
        if (cloudAbility != null) {
            cloudAbility.flush();
        }
    }

    public String e() {
        return "pcm";
    }

    public void f(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        CloudAbility cloudAbility = (CloudAbility) AbilityManager.b.b(CloudAbility.class);
        if (cloudAbility != null) {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            cloudAbility.feedData(copyOf);
        }
    }
}
