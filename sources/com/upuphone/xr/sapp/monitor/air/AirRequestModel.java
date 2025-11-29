package com.upuphone.xr.sapp.monitor.air;

import androidx.annotation.Keep;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR-\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/upuphone/xr/sapp/monitor/air/AirRequestModel;", "", "functionName", "", "requestId", "param", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "targetPackage", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;)V", "getFunctionName", "()Ljava/lang/String;", "getParam", "()Ljava/util/HashMap;", "getRequestId", "getTargetPackage", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class AirRequestModel {
    @NotNull
    private final String functionName;
    @NotNull
    private final HashMap<String, Object> param;
    @NotNull
    private final String requestId;
    @NotNull
    private final String targetPackage;

    public AirRequestModel(@NotNull String str, @NotNull String str2, @NotNull HashMap<String, Object> hashMap, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "functionName");
        Intrinsics.checkNotNullParameter(str2, "requestId");
        Intrinsics.checkNotNullParameter(hashMap, "param");
        Intrinsics.checkNotNullParameter(str3, "targetPackage");
        this.functionName = str;
        this.requestId = str2;
        this.param = hashMap;
        this.targetPackage = str3;
    }

    @NotNull
    public final String getFunctionName() {
        return this.functionName;
    }

    @NotNull
    public final HashMap<String, Object> getParam() {
        return this.param;
    }

    @NotNull
    public final String getRequestId() {
        return this.requestId;
    }

    @NotNull
    public final String getTargetPackage() {
        return this.targetPackage;
    }
}
