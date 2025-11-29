package com.upuphone.ar.fastrecord.phone.utils;

import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.starrynet.bean.glass.RecordCacheTag;
import com.upuphone.ar.fastrecord.phone.utils.RecordOpusCodecUtils;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class RecordVoiceUtils$saveCachePhoneToFile$1 extends Lambda implements Function1<RecordEntity, Unit> {
    final /* synthetic */ RecordCacheTag $recordCacheTag;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordVoiceUtils$saveCachePhoneToFile$1(RecordCacheTag recordCacheTag) {
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
        Object obj = RecordVoiceUtils.excessPhoneDownloadingTagMap.get(Long.valueOf(this.$recordCacheTag.getId()));
        int length = this.$recordCacheTag.getByteArray().length;
        LogExt.logE("saveCachePhoneToFile recordCacheTag list = " + obj + ",size = " + length, RecordVoiceUtils.TAG);
        int length2 = this.$recordCacheTag.getByteArray().length;
        byte[] sliceArray = ArraysKt.sliceArray(this.$recordCacheTag.getByteArray(), RangesKt.until(0, length2 / 2));
        RecordOpusCodecUtils.Companion companion = RecordOpusCodecUtils.Companion;
        byte[] decodePhoneRemoteFrame = companion.getInstance().decodePhoneRemoteFrame(sliceArray, true);
        ArrayList arrayList = (ArrayList) RecordVoiceUtils.excessPhoneDownloadingTagMap.get(Long.valueOf(this.$recordCacheTag.getId()));
        if (arrayList != null) {
            RecordCacheTag recordCacheTag = this.$recordCacheTag;
            RecordVoiceUtils recordVoiceUtils = RecordVoiceUtils.INSTANCE;
            byte[] copyOf = Arrays.copyOf(decodePhoneRemoteFrame, decodePhoneRemoteFrame.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            recordVoiceUtils.saveCachePcmData(recordCacheTag, copyOf, RecordConstants.UP_RECORD_TYPE, arrayList);
        }
        Object obj2 = RecordVoiceUtils.excessPhoneDownloadingTagMap.get(Long.valueOf(this.$recordCacheTag.getId()));
        int length3 = decodePhoneRemoteFrame.length;
        LogExt.logE("saveCachePhoneToFile  decodePreBytes list = " + obj2 + ",decodePreBytes size = " + length3, RecordVoiceUtils.TAG);
        byte[] decodePhoneProximalFrame = companion.getInstance().decodePhoneProximalFrame(ArraysKt.sliceArray(this.$recordCacheTag.getByteArray(), RangesKt.until(this.$recordCacheTag.getByteArray().length / 2, length2)), true);
        ArrayList arrayList2 = (ArrayList) RecordVoiceUtils.excessPhoneDownloadingTagMap.get(Long.valueOf(this.$recordCacheTag.getId()));
        if (arrayList2 != null) {
            RecordCacheTag recordCacheTag2 = this.$recordCacheTag;
            RecordVoiceUtils recordVoiceUtils2 = RecordVoiceUtils.INSTANCE;
            byte[] copyOf2 = Arrays.copyOf(decodePhoneProximalFrame, decodePhoneProximalFrame.length);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(...)");
            recordVoiceUtils2.saveCachePcmData(recordCacheTag2, copyOf2, RecordConstants.DOWN_RECORD_TYPE, arrayList2);
        }
        Object obj3 = RecordVoiceUtils.excessPhoneDownloadingTagMap.get(Long.valueOf(this.$recordCacheTag.getId()));
        int length4 = decodePhoneRemoteFrame.length;
        LogExt.logE("saveCachePhoneToFile  decodeLastBytes list = " + obj3 + ",decodeLastBytes size = " + length4, RecordVoiceUtils.TAG);
    }
}
