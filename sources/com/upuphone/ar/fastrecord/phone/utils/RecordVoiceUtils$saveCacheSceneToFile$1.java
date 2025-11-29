package com.upuphone.ar.fastrecord.phone.utils;

import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordCacheTag;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class RecordVoiceUtils$saveCacheSceneToFile$1 extends Lambda implements Function1<RecordEntity, Unit> {
    final /* synthetic */ RecordCacheTag $recordCacheTag;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordVoiceUtils$saveCacheSceneToFile$1(RecordCacheTag recordCacheTag) {
        super(1);
        this.$recordCacheTag = recordCacheTag;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RecordEntity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull RecordEntity recordEntity) {
        Intrinsics.checkNotNullParameter(recordEntity, "it");
        LogExt.logV("queryRecordOrCreateForDownloading success", RecordVoiceUtils.TAG);
        byte[] decodeScreenFrame = RecordOpusCodecUtils.Companion.getInstance().decodeScreenFrame(this.$recordCacheTag.getByteArray(), true);
        ArrayList arrayList = (ArrayList) RecordVoiceUtils.excessSceneDownloadingTagMap.get(Long.valueOf(this.$recordCacheTag.getId()));
        if (arrayList != null) {
            RecordCacheTag recordCacheTag = this.$recordCacheTag;
            RecordVoiceUtils recordVoiceUtils = RecordVoiceUtils.INSTANCE;
            byte[] copyOf = Arrays.copyOf(decodeScreenFrame, decodeScreenFrame.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            recordVoiceUtils.saveCachePcmData(recordCacheTag, copyOf, RecordConstants.SCENE_RECORD_TYPE, arrayList);
        }
    }
}
