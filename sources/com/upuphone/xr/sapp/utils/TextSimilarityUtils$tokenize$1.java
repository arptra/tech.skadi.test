package com.upuphone.xr.sapp.utils;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.MatchResult;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lkotlin/text/MatchResult;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TextSimilarityUtils$tokenize$1 extends Lambda implements Function1<MatchResult, String> {
    public static final TextSimilarityUtils$tokenize$1 INSTANCE = new TextSimilarityUtils$tokenize$1();

    public TextSimilarityUtils$tokenize$1() {
        super(1);
    }

    @NotNull
    public final String invoke(@NotNull MatchResult matchResult) {
        Intrinsics.checkNotNullParameter(matchResult, "it");
        return matchResult.getValue();
    }
}
