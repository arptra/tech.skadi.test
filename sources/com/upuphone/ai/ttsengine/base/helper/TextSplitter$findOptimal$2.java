package com.upuphone.ai.ttsengine.base.helper;

import com.upuphone.ai.ttsengine.base.helper.TextSplitter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/upuphone/ai/ttsengine/base/helper/TextSplitter$SymbolString;", "invoke", "(Lcom/upuphone/ai/ttsengine/base/helper/TextSplitter$SymbolString;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TextSplitter$findOptimal$2 extends Lambda implements Function1<TextSplitter.SymbolString, Boolean> {
    public static final TextSplitter$findOptimal$2 INSTANCE = new TextSplitter$findOptimal$2();

    public TextSplitter$findOptimal$2() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull TextSplitter.SymbolString symbolString) {
        Intrinsics.checkNotNullParameter(symbolString, "it");
        return Boolean.valueOf(Intrinsics.areEqual((Object) symbolString.b(), (Object) "！"));
    }
}
