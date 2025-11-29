package com.upuphone.ai.ttsengine.base.helper;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.MatchResult;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lkotlin/text/MatchResult;", "invoke", "(Lkotlin/text/MatchResult;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class TextComposer$matchBest$1 extends Lambda implements Function1<MatchResult, Boolean> {
    public static final TextComposer$matchBest$1 INSTANCE = new TextComposer$matchBest$1();

    public TextComposer$matchBest$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull MatchResult matchResult) {
        Intrinsics.checkNotNullParameter(matchResult, "it");
        return Boolean.valueOf(Intrinsics.areEqual((Object) matchResult.getValue(), (Object) "！"));
    }
}
