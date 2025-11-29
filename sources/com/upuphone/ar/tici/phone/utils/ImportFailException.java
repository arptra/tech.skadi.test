package com.upuphone.ar.tici.phone.utils;

import com.upuphone.ar.tici.phone.data.ImportFileState;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/upuphone/ar/tici/phone/utils/ImportFailException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "fail", "Lcom/upuphone/ar/tici/phone/data/ImportFileState$Fail;", "(Lcom/upuphone/ar/tici/phone/data/ImportFileState$Fail;)V", "getFail", "()Lcom/upuphone/ar/tici/phone/data/ImportFileState$Fail;", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ImportFailException extends Exception {
    @NotNull
    private final ImportFileState.Fail fail;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ImportFailException(@org.jetbrains.annotations.NotNull com.upuphone.ar.tici.phone.data.ImportFileState.Fail r4) {
        /*
            r3 = this;
            java.lang.String r0 = "fail"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            com.upuphone.ar.tici.phone.data.ImportFailReason r0 = r4.getFailReason()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "ImportFileFail: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r3.<init>(r0)
            r3.fail = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.utils.ImportFailException.<init>(com.upuphone.ar.tici.phone.data.ImportFileState$Fail):void");
    }

    @NotNull
    public final ImportFileState.Fail getFail() {
        return this.fail;
    }
}
