package com.xjsd.ai.assistant.phone.helper;

import android.os.LocaleList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/xjsd/ai/assistant/phone/helper/LocaleUtil;", "", "<init>", "()V", "Ljava/util/Locale;", "a", "()Ljava/util/Locale;", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class LocaleUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final LocaleUtil f8565a = new LocaleUtil();

    public final Locale a() {
        Locale locale = LocaleList.getDefault().get(0);
        Intrinsics.checkNotNull(locale);
        return locale;
    }
}
