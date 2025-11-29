package com.upuphone.ar.tici.phone.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\"\u0015\u0010\n\u001a\u00020\u0007*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0015\u0010\f\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0003¨\u0006\r"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/OpenTiciConfig;", "", "c", "(Lcom/upuphone/ar/tici/phone/data/OpenTiciConfig;)Ljava/lang/String;", "msgId", "a", "fileKey", "", "b", "(Lcom/upuphone/ar/tici/phone/data/OpenTiciConfig;)J", "id", "d", "sourceText", "ar-tici_release"}, k = 2, mv = {1, 9, 0})
public final class OpenTiciConfigKt {
    public static final String a(OpenTiciConfig openTiciConfig) {
        Intrinsics.checkNotNullParameter(openTiciConfig, "<this>");
        return openTiciConfig.d().getFileKey();
    }

    public static final long b(OpenTiciConfig openTiciConfig) {
        Intrinsics.checkNotNullParameter(openTiciConfig, "<this>");
        return openTiciConfig.f().getId();
    }

    public static final String c(OpenTiciConfig openTiciConfig) {
        Intrinsics.checkNotNullParameter(openTiciConfig, "<this>");
        return openTiciConfig.d().getMsgId();
    }

    public static final String d(OpenTiciConfig openTiciConfig) {
        Intrinsics.checkNotNullParameter(openTiciConfig, "<this>");
        return openTiciConfig.e().getContentText();
    }
}
