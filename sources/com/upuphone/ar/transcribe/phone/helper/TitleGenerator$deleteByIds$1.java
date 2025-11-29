package com.upuphone.ar.transcribe.phone.helper;

import com.upuphone.ar.transcribe.phone.bean.IdTitleBean;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/ar/transcribe/phone/bean/IdTitleBean;", "invoke", "(Lcom/upuphone/ar/transcribe/phone/bean/IdTitleBean;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TitleGenerator$deleteByIds$1 extends Lambda implements Function1<IdTitleBean, Boolean> {
    final /* synthetic */ long[] $ids;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TitleGenerator$deleteByIds$1(long[] jArr) {
        super(1);
        this.$ids = jArr;
    }

    @NotNull
    public final Boolean invoke(@NotNull IdTitleBean idTitleBean) {
        Intrinsics.checkNotNullParameter(idTitleBean, "it");
        long[] jArr = this.$ids;
        Long id = idTitleBean.getId();
        return Boolean.valueOf(ArraysKt.indexOf(jArr, id != null ? id.longValue() : -1) >= 0);
    }
}
