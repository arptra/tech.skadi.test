package com.upuphone.ar.tici.phone.widget;

import com.upuphone.ar.tici.phone.data.DefaultTiciContent;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.ar.tici.phone.utils.TiciHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.widget.TiciTutorialSwitcher$loadDefaultContent$1", f = "TiciTutorialSwitcher.kt", i = {0}, l = {71}, m = "invokeSuspend", n = {"stringBuilder"}, s = {"L$0"})
public final class TiciTutorialSwitcher$loadDefaultContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ TiciTutorialSwitcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciTutorialSwitcher$loadDefaultContent$1(TiciTutorialSwitcher ticiTutorialSwitcher, Continuation<? super TiciTutorialSwitcher$loadDefaultContent$1> continuation) {
        super(2, continuation);
        this.this$0 = ticiTutorialSwitcher;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(TiciTutorialSwitcher ticiTutorialSwitcher) {
        ticiTutorialSwitcher.g();
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciTutorialSwitcher$loadDefaultContent$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        StringBuilder sb;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CommonExtKt.b("loadDefaultContent, start", "TiciTutorialSwitcher");
            StringBuilder sb2 = new StringBuilder();
            TiciHelper ticiHelper = TiciHelper.f6002a;
            this.L$0 = sb2;
            this.label = 1;
            Object d = ticiHelper.d(this);
            if (d == coroutine_suspended) {
                return coroutine_suspended;
            }
            sb = sb2;
            obj = d;
        } else if (i == 1) {
            sb = (StringBuilder) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        DefaultTiciContent defaultTiciContent = (DefaultTiciContent) obj;
        String component1 = defaultTiciContent.component1();
        String component2 = defaultTiciContent.component2();
        sb.append(component1);
        sb.append(StringUtils.LF);
        sb.append(component2);
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
        this.this$0.d.setText(sb3);
        this.this$0.e.setText(sb3);
        TiciTutorialSwitcher ticiTutorialSwitcher = this.this$0;
        ticiTutorialSwitcher.post(new a(ticiTutorialSwitcher));
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciTutorialSwitcher$loadDefaultContent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
