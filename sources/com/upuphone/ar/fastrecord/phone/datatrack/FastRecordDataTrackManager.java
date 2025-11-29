package com.upuphone.ar.fastrecord.phone.datatrack;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0007J \u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/datatrack/FastRecordDataTrackManager;", "", "()V", "TAG", "", "reportAIExtractionDataTrack", "", "textLength", "", "recognizeId", "reportRecordingDataTrack", "recordTime", "recordId", "reportTranscribingDataTrack", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordDataTrackManager {
    @NotNull
    public static final FastRecordDataTrackManager INSTANCE = new FastRecordDataTrackManager();
    @NotNull
    private static final String TAG = "FastRecordDataTrackManager";

    private FastRecordDataTrackManager() {
    }

    @JvmStatic
    public static final void reportAIExtractionDataTrack(long j, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "recognizeId");
        HashMap hashMap = new HashMap();
        hashMap.put("text_length", String.valueOf(j));
        hashMap.put("recognize_id", str);
        LogExt.logW("reportAIExtractionDataTrack dataInfo = " + hashMap, TAG);
        FastRecordDataTrackUtil.INSTANCE.reportEvent("ConferenceAssistant_AIExtraction", hashMap);
    }

    @JvmStatic
    public static final void reportRecordingDataTrack(long j, long j2) {
        HashMap hashMap = new HashMap();
        hashMap.put("recording_duration", String.valueOf(j));
        hashMap.put("record_id", String.valueOf(j2));
        LogExt.logW("reportRecordingDataTrack dataInfo = " + hashMap, TAG);
        FastRecordDataTrackUtil.INSTANCE.reportEvent("ConferenceAssistant_Recording", hashMap);
    }

    @JvmStatic
    public static final void reportTranscribingDataTrack(@NotNull String str, long j, long j2) {
        Intrinsics.checkNotNullParameter(str, "recognizeId");
        HashMap hashMap = new HashMap();
        hashMap.put("recording_duration", String.valueOf(j));
        hashMap.put("record_id", String.valueOf(j2));
        hashMap.put("recognize_id", str);
        LogExt.logW("reportTranscribingDataTrack dataInfo = " + hashMap, TAG);
        FastRecordDataTrackUtil.INSTANCE.reportEvent("ConferenceAssistant_Transcribing", hashMap);
    }
}
