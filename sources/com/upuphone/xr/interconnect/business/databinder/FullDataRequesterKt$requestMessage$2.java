package com.upuphone.xr.interconnect.business.databinder;

import com.upuphone.xr.interconnect.entity.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FullDataRequesterKt$requestMessage$2 extends Lambda implements Function0<String> {
    public static final FullDataRequesterKt$requestMessage$2 INSTANCE = new FullDataRequesterKt$requestMessage$2();

    public FullDataRequesterKt$requestMessage$2() {
        super(0);
    }

    public final String invoke() {
        return new Function(16, (Object) null).toString(DataBinderManager.Companion.getGson());
    }
}
