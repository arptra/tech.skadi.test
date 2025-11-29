package com.upuphone.ar.translation;

import com.upuphone.ar.translation.phone.helper.NetworkTimeHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/upuphone/ar/translation/phone/helper/NetworkTimeHelper;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranslationApp$mNetworkTimeHelper$2 extends Lambda implements Function0<NetworkTimeHelper> {
    public static final TranslationApp$mNetworkTimeHelper$2 INSTANCE = new TranslationApp$mNetworkTimeHelper$2();

    public TranslationApp$mNetworkTimeHelper$2() {
        super(0);
    }

    @NotNull
    public final NetworkTimeHelper invoke() {
        return new NetworkTimeHelper();
    }
}
