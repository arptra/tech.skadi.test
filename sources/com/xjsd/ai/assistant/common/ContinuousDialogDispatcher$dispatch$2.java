package com.xjsd.ai.assistant.common;

import com.xjsd.ai.assistant.common.ContinuousDialogDispatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Lkotlin/Unit;"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class ContinuousDialogDispatcher$dispatch$2 extends Lambda implements Function0<Unit> {
    public static final ContinuousDialogDispatcher$dispatch$2 INSTANCE = new ContinuousDialogDispatcher$dispatch$2();

    public ContinuousDialogDispatcher$dispatch$2() {
        super(0);
    }

    @Nullable
    public final Unit invoke() {
        ContinuousDialogDispatcher.ActionExecutor a2 = ContinuousDialogDispatcher.b;
        if (a2 == null) {
            return null;
        }
        a2.b();
        return Unit.INSTANCE;
    }
}
