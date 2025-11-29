package com.upuphone.runasone;

import com.upuphone.runasone.ability.SystemApiImpl;
import com.upuphone.runasone.core.api.sys.ApiSystemAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/upuphone/runasone/core/api/sys/ApiSystemAdapter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SystemApiAbility$adapter$2 extends Lambda implements Function0<ApiSystemAdapter> {
    public static final SystemApiAbility$adapter$2 INSTANCE = new SystemApiAbility$adapter$2();

    public SystemApiAbility$adapter$2() {
        super(0);
    }

    @NotNull
    public final ApiSystemAdapter invoke() {
        return new ApiSystemAdapter(SystemApiImpl.INSTANCE);
    }
}
