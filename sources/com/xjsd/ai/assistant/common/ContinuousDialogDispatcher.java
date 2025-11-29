package com.xjsd.ai.assistant.common;

import com.xjsd.ai.assistant.core.AbilityManager;
import com.xjsd.ai.assistant.core.api.cache.CacheAbility;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ;\u0010\u0010\u001a\u00020\u00062\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\r2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/xjsd/ai/assistant/common/ContinuousDialogDispatcher;", "", "<init>", "()V", "Lcom/xjsd/ai/assistant/common/ContinuousDialogDispatcher$ActionExecutor;", "executor", "", "e", "(Lcom/xjsd/ai/assistant/common/ContinuousDialogDispatcher$ActionExecutor;)V", "", "exit", "c", "(Z)V", "Lkotlin/Function0;", "continueFunc", "closeFunc", "b", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Z)V", "Lcom/xjsd/ai/assistant/common/ContinuousDialogDispatcher$ActionExecutor;", "mExecutor", "ActionExecutor", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ContinuousDialogDispatcher {

    /* renamed from: a  reason: collision with root package name */
    public static final ContinuousDialogDispatcher f8412a = new ContinuousDialogDispatcher();
    public static ActionExecutor b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/xjsd/ai/assistant/common/ContinuousDialogDispatcher$ActionExecutor;", "", "", "d", "()V", "b", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface ActionExecutor {
        void b();

        void d();
    }

    public static final void b(Function0 function0, Function0 function02, boolean z) {
        if (!z) {
            CacheAbility cacheAbility = (CacheAbility) AbilityManager.b.b(CacheAbility.class);
            Boolean bool = cacheAbility != null ? (Boolean) cacheAbility.getCacheWithDefault("continuous_dialogue", Boolean.FALSE) : null;
            if (bool == null ? false : bool.booleanValue()) {
                if (function0 != null) {
                    Unit unit = (Unit) function0.invoke();
                }
            } else if (function02 != null) {
                Unit unit2 = (Unit) function02.invoke();
            }
        } else if (function02 != null) {
            Unit unit3 = (Unit) function02.invoke();
        }
    }

    public static final void c(boolean z) {
        b(ContinuousDialogDispatcher$dispatch$1.INSTANCE, ContinuousDialogDispatcher$dispatch$2.INSTANCE, z);
    }

    public static /* synthetic */ void d(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        c(z);
    }

    public static final void e(ActionExecutor actionExecutor) {
        Intrinsics.checkNotNullParameter(actionExecutor, "executor");
        b = actionExecutor;
    }
}
