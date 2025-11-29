package com.upuphone.xr.audio.record.ai.feedback;

import com.upuphone.xr.audio.record.ai.bean.AiFeedBackResponse;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/audio/record/ai/feedback/ReportCallback;", "", "onFail", "", "result", "Lcom/upuphone/xr/audio/record/ai/bean/AiFeedBackResponse;", "onSuccess", "lib_audio_record_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ReportCallback {
    void onFail(AiFeedBackResponse aiFeedBackResponse);

    void onSuccess(AiFeedBackResponse aiFeedBackResponse);
}
