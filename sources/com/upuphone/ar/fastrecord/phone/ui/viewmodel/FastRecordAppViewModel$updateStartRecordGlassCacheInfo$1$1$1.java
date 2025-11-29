package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordAppViewModel$updateStartRecordGlassCacheInfo$1$1$1 extends Lambda implements Function1<RecordEntity, Unit> {
    final /* synthetic */ RecordEntity $record;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordAppViewModel$updateStartRecordGlassCacheInfo$1$1$1(RecordEntity recordEntity) {
        super(1);
        this.$record = recordEntity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RecordEntity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull RecordEntity recordEntity) {
        Intrinsics.checkNotNullParameter(recordEntity, "it");
        String shortHandTitle = this.$record.getShortHandTitle();
        LogExt.logE("updateStartRecordGlassCacheInfo state shortHandTitle = " + shortHandTitle, "FastRecordAppViewModel");
    }
}
