package com.xjsd.ai.assistant.phone.helper;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/xjsd/ai/assistant/phone/helper/AssistantSettingUtils;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "Landroid/content/Context;", "context", "", "mark", "", "isChecked", "", "c", "(Landroid/content/Context;Ljava/lang/String;Z)V", "", "timbreValue", "d", "(Landroid/content/Context;I)V", "e", "(Landroid/content/Context;Ljava/lang/String;)Z", "a", "(Landroid/content/Context;)V", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "ar-assistant_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class AssistantSettingUtils implements CoroutineScope {
    public static final AssistantSettingUtils b = new AssistantSettingUtils();

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f8559a = CoroutineScopeKt.b();

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new AssistantSettingUtils$cacheAssistantSettings$1(context, (Continuation<? super AssistantSettingUtils$cacheAssistantSettings$1>) null), 3, (Object) null);
    }

    public final void c(Context context, String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "mark");
        if (context != null) {
            AssistantSettingsHelper.n(context, str, z);
        }
    }

    public final void d(Context context, int i) {
        if (context != null) {
            AssistantSettingsHelper.o(context, i);
        }
    }

    public final boolean e(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "mark");
        return ((Boolean) BuildersKt__BuildersKt.b((CoroutineContext) null, new AssistantSettingUtils$isSettingOn$1(str, context, (Continuation<? super AssistantSettingUtils$isSettingOn$1>) null), 1, (Object) null)).booleanValue();
    }

    public CoroutineContext getCoroutineContext() {
        return this.f8559a.getCoroutineContext();
    }
}
