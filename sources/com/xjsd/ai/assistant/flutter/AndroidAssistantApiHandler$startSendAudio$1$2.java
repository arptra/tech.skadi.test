package com.xjsd.ai.assistant.flutter;

import com.xjsd.ai.assistant.asr.engine.protocol.AsrCloudResponse;
import com.xjsd.ai.assistant.flutter.AndroidAssistantApi;
import com.xjsd.ai.assistant.flutter.util.AudioRecordHelper;
import com.xjsd.ai.assistant.json.GsonUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nAndroidAssistantApiHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidAssistantApiHandler.kt\ncom/xjsd/ai/assistant/flutter/AndroidAssistantApiHandler$startSendAudio$1$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,564:1\n1#2:565\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AndroidAssistantApiHandler$startSendAudio$1$2 extends Lambda implements Function2<Integer, Integer, Unit> {
    final /* synthetic */ AudioRecordHelper $this_apply;
    final /* synthetic */ String $traceId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidAssistantApiHandler$startSendAudio$1$2(AudioRecordHelper audioRecordHelper, String str) {
        super(2);
        this.$this_apply = audioRecordHelper;
        this.$traceId = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i, int i2) {
        this.$this_apply.n();
        this.$this_apply.k();
        AndroidAssistantApi.CloudResponse.Builder d = new AndroidAssistantApi.CloudResponse.Builder().c(this.$traceId).d("asr_result");
        AsrCloudResponse asrCloudResponse = new AsrCloudResponse();
        asrCloudResponse.setEvent("asr_result_failed");
        AndroidAssistantApi.CloudResponse a2 = d.b(GsonUtils.e(asrCloudResponse)).a();
        Intrinsics.checkNotNullExpressionValue(a2, "build(...)");
        AndroidAssistantApiHandler.INSTANCE.sendResToFlutter(a2);
    }
}
