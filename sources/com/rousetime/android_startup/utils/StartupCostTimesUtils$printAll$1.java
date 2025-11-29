package com.rousetime.android_startup.utils;

import com.rousetime.android_startup.model.CostTimesModel;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
public final class StartupCostTimesUtils$printAll$1 extends Lambda implements Function0<String> {
    public static final StartupCostTimesUtils$printAll$1 INSTANCE = new StartupCostTimesUtils$printAll$1();

    public StartupCostTimesUtils$printAll$1() {
        super(0);
    }

    @NotNull
    public final String invoke() {
        StringBuilder sb = new StringBuilder();
        sb.append("startup cost times detail:");
        sb.append(StringUtils.LF);
        sb.append("|=================================================================");
        Collection<CostTimesModel> values = StartupCostTimesUtils.d.c().values();
        Intrinsics.checkExpressionValueIsNotNull(values, "costTimesMap.values");
        for (CostTimesModel costTimesModel : values) {
            sb.append(StringUtils.LF);
            sb.append("|      Startup Name       |   " + costTimesModel.c());
            sb.append(StringUtils.LF);
            sb.append("| ----------------------- | --------------------------------------");
            sb.append(StringUtils.LF);
            sb.append("|   Call On Main Thread   |   " + costTimesModel.a());
            sb.append(StringUtils.LF);
            sb.append("| ----------------------- | --------------------------------------");
            sb.append(StringUtils.LF);
            sb.append("|   Wait On Main Thread   |   " + costTimesModel.e());
            sb.append(StringUtils.LF);
            sb.append("| ----------------------- | --------------------------------------");
            sb.append(StringUtils.LF);
            sb.append("|       Cost Times        |   " + (costTimesModel.b() - costTimesModel.d()) + " ms");
            sb.append(StringUtils.LF);
            sb.append("|=================================================================");
        }
        sb.append(StringUtils.LF);
        sb.append("| Total Main Thread Times |   " + (StartupCostTimesUtils.d.d() / 1000000) + " ms");
        sb.append(StringUtils.LF);
        sb.append("|=================================================================");
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
