package com.rousetime.android_startup.sort;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 16})
public final class TopologySort$printResult$1 extends Lambda implements Function0<String> {
    final /* synthetic */ String $printBuilder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopologySort$printResult$1(String str) {
        super(0);
        this.$printBuilder = str;
    }

    @NotNull
    public final String invoke() {
        return this.$printBuilder;
    }
}
