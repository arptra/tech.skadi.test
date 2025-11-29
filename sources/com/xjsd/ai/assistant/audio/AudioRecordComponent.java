package com.xjsd.ai.assistant.audio;

import android.app.Application;
import com.xjsd.ai.assistant.core.Component;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/xjsd/ai/assistant/audio/AudioRecordComponent;", "Lcom/xjsd/ai/assistant/core/Component;", "<init>", "()V", "", "c", "()Ljava/lang/String;", "Landroid/app/Application;", "application", "", "a", "(Landroid/app/Application;)V", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AudioRecordComponent extends Component {
    public void a(Application application) {
        Intrinsics.checkNotNullParameter(application, VuiModelType.APPLICATION);
        AudioDataUtil.a(application, true);
    }

    public String c() {
        return "AudioRecordComponent";
    }
}
