package com.xjsd.ai.assistant.phone.export;

import com.xjsd.ai.assistant.audio.AudioDataUtil;
import com.xjsd.ai.assistant.cloud.CloudAbility;
import com.xjsd.ai.assistant.common.util.OpusUtil;
import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.xr.sapp.asr.constants.AsrConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/xjsd/ai/assistant/phone/export/OpusStrategy;", "Lcom/xjsd/ai/assistant/phone/export/ParentFeedAudioDataToCloudStrategy;", "<init>", "()V", "", "c", "a", "d", "", "data", "f", "([B)V", "", "e", "()Ljava/lang/String;", "b", "([B)[B", "[B", "tempBuffer", "Lcom/xjsd/ai/assistant/common/util/OpusUtil;", "Lcom/xjsd/ai/assistant/common/util/OpusUtil;", "mOpusUtil", "", "I", "filterCount", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class OpusStrategy extends ParentFeedAudioDataToCloudStrategy {
    public byte[] b;
    public final OpusUtil c = new OpusUtil();
    public int d;

    public void a() {
        CloudAbility cloudAbility = (CloudAbility) AbilityManager.b.b(CloudAbility.class);
        if (cloudAbility != null) {
            cloudAbility.flush();
        }
    }

    public final byte[] b(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[(length + 2)];
        bArr2[0] = (byte) (length >> 8);
        bArr2[1] = (byte) (length & 255);
        System.arraycopy(bArr, 0, bArr2, 2, length);
        return bArr2;
    }

    public void c() {
        this.b = null;
        this.d = 0;
    }

    public void d() {
        this.b = null;
    }

    public String e() {
        return AsrConstants.AUDIO_OPUS;
    }

    public void f(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        byte[] bArr2 = this.b;
        Unit unit = null;
        if (bArr2 != null) {
            byte[] bArr3 = new byte[640];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            System.arraycopy(bArr, 0, bArr3, bArr2.length, bArr.length);
            byte[] b2 = this.c.b(bArr3);
            AudioDataUtil.b(b2);
            Intrinsics.checkNotNull(b2);
            byte[] b3 = b(b2);
            AudioDataUtil.f(b3);
            int i = this.d;
            if (i < 15) {
                this.d = i + 1;
                return;
            }
            CloudAbility cloudAbility = (CloudAbility) AbilityManager.b.b(CloudAbility.class);
            if (cloudAbility != null) {
                cloudAbility.feedData(b3);
            }
            this.b = null;
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this.b = bArr;
        }
    }
}
