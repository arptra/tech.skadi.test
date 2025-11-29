package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.phone.db.entity.TiciContentPart;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/ar/tici/phone/db/entity/TiciContentPart;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TiciNewFileActivity$initData$1$sourceText$1 extends Lambda implements Function1<TiciContentPart, CharSequence> {
    public static final TiciNewFileActivity$initData$1$sourceText$1 INSTANCE = new TiciNewFileActivity$initData$1$sourceText$1();

    public TiciNewFileActivity$initData$1$sourceText$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull TiciContentPart ticiContentPart) {
        Intrinsics.checkNotNullParameter(ticiContentPart, "it");
        return ticiContentPart.getContentText();
    }
}
