package com.upuphone.ar.fastrecord.phone.ui.viewmodel.search;

import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "value1", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "kotlin.jvm.PlatformType", "value2", "invoke", "(Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;)Ljava/lang/Integer;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordSearchViewModel$sortRecordData$2 extends Lambda implements Function2<RecordEntity, RecordEntity, Integer> {
    public static final FastRecordSearchViewModel$sortRecordData$2 INSTANCE = new FastRecordSearchViewModel$sortRecordData$2();

    public FastRecordSearchViewModel$sortRecordData$2() {
        super(2);
    }

    @NotNull
    public final Integer invoke(RecordEntity recordEntity, RecordEntity recordEntity2) {
        long searchWeight = (recordEntity2 != null ? recordEntity2.getSearchWeight() : 0) - (recordEntity != null ? recordEntity.getSearchWeight() : 0);
        long createTime = (recordEntity2 != null ? recordEntity2.getCreateTime() : 0) - (recordEntity != null ? recordEntity.getCreateTime() : 0);
        int i = (searchWeight > 0 ? 1 : (searchWeight == 0 ? 0 : -1));
        int i2 = 1;
        if (i <= 0 && (i < 0 || createTime <= 0)) {
            i2 = -1;
        }
        return Integer.valueOf(i2);
    }
}
