package com.upuphone.xr.sapp.utils;

import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.view.SuperGenericWindowView;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nGenericWindowManger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GenericWindowManger.kt\ncom/upuphone/xr/sapp/utils/GenericWindowManger$dismissGenericWindow$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,662:1\n1855#2,2:663\n*S KotlinDebug\n*F\n+ 1 GenericWindowManger.kt\ncom/upuphone/xr/sapp/utils/GenericWindowManger$dismissGenericWindow$1\n*L\n465#1:663,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.utils.GenericWindowManger$dismissGenericWindow$1", f = "GenericWindowManger.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GenericWindowManger$dismissGenericWindow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $windowType;
    int label;
    final /* synthetic */ GenericWindowManger this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenericWindowManger$dismissGenericWindow$1(int i, GenericWindowManger genericWindowManger, Continuation<? super GenericWindowManger$dismissGenericWindow$1> continuation) {
        super(2, continuation);
        this.$windowType = i;
        this.this$0 = genericWindowManger;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$2(GenericWindowManger genericWindowManger, int i) {
        genericWindowManger.j(i);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GenericWindowManger$dismissGenericWindow$1(this.$windowType, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ULog.Delegate delegate = ULog.f6446a;
            int i = this.$windowType;
            delegate.c("GenericWindowManger", "dismissGenericWindow windowType = " + i);
            try {
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                List<SuperGenericWindowView> d = this.this$0.f7886a;
                if (d != null) {
                    int i2 = this.$windowType;
                    GenericWindowManger genericWindowManger = this.this$0;
                    for (SuperGenericWindowView superGenericWindowView : d) {
                        if (superGenericWindowView.l(i2)) {
                            genericWindowManger.b = 0;
                            booleanRef.element = true;
                            superGenericWindowView.s(i2);
                        }
                    }
                }
                if (booleanRef.element || this.this$0.b >= 2 || this.$windowType == 161) {
                    this.this$0.b = 0;
                } else {
                    GenericWindowManger genericWindowManger2 = this.this$0;
                    genericWindowManger2.b = genericWindowManger2.b + 1;
                    GenericWindowManger.c.b().postDelayed(new a(this.this$0, this.$windowType), 1000);
                }
            } catch (Exception e) {
                ULog.Delegate delegate2 = ULog.f6446a;
                String message = e.getMessage();
                delegate2.c("GenericWindowManger", "dismissGenericWindow::error:" + message);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GenericWindowManger$dismissGenericWindow$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
