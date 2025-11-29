package com.upuphone.ar.tici.phone.viewmodel;

import com.upuphone.ar.tici.phone.TiciApp;
import com.upuphone.ar.tici.phone.data.PageInfo;
import com.upuphone.ar.tici.phone.data.ParagraphProgress;
import com.upuphone.ar.tici.phone.data.TiciInfo;
import com.upuphone.ar.tici.phone.data.TiciInfoKt;
import com.upuphone.ar.tici.phone.db.TiciDao;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.viewmodel.TiciMainViewModel$highlightByPage$1", f = "TiciMainViewModel.kt", i = {1}, l = {172, 179}, m = "invokeSuspend", n = {"pageInfo"}, s = {"L$0"})
public final class TiciMainViewModel$highlightByPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ boolean $isMandatory;
    final /* synthetic */ int $page;
    final /* synthetic */ TiciInfo $ticiInfo;
    Object L$0;
    int label;
    final /* synthetic */ TiciMainViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciMainViewModel$highlightByPage$1(int i, int i2, boolean z, TiciInfo ticiInfo, TiciMainViewModel ticiMainViewModel, Continuation<? super TiciMainViewModel$highlightByPage$1> continuation) {
        super(2, continuation);
        this.$page = i;
        this.$index = i2;
        this.$isMandatory = z;
        this.$ticiInfo = ticiInfo;
        this.this$0 = ticiMainViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciMainViewModel$highlightByPage$1(this.$page, this.$index, this.$isMandatory, this.$ticiInfo, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        PageInfo pageInfo;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PageInfo pageInfo2 = new PageInfo(this.$page, this.$index);
            boolean z = this.$isMandatory;
            CommonExtKt.e("highlightByPage, pageInfo: " + pageInfo2 + ", isMandatory: " + z, "TiciMainViewModel");
            if (pageInfo2.getPage() == this.$ticiInfo.getTiciEntity().getCurrentPage()) {
                TiciDao w = TiciApp.b.w();
                int index = pageInfo2.getIndex();
                long b = TiciInfoKt.b(this.$ticiInfo);
                this.L$0 = pageInfo2;
                this.label = 2;
                if (w.x(index, b, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pageInfo = pageInfo2;
                int index2 = pageInfo.getIndex();
                long b2 = TiciInfoKt.b(this.$ticiInfo);
                CommonExtKt.e("highlightByPage, updateIndex, index: " + index2 + ", id: " + b2, "TiciMainViewModel");
                int computeProgress = this.$ticiInfo.computeProgress(pageInfo.getPage(), pageInfo.getIndex());
                this.this$0.e.setValue(new ParagraphProgress(pageInfo, computeProgress));
                this.this$0.g.postValue(this.this$0.n(computeProgress + 1, this.$ticiInfo.getTotalParagraphSize()));
                return Unit.INSTANCE;
            } else if (this.$isMandatory) {
                CommonExtKt.d("highlightByPage, currentPage changed, reloadTiciContent", "TiciMainViewModel", (Throwable) null, 2, (Object) null);
                TiciDao w2 = TiciApp.b.w();
                int page = pageInfo2.getPage();
                int index3 = pageInfo2.getIndex();
                long b3 = TiciInfoKt.b(this.$ticiInfo);
                this.label = 1;
                if (w2.w(page, index3, b3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                CommonExtKt.d("highlightByPage, currentPage changed, ignore", "TiciMainViewModel", (Throwable) null, 2, (Object) null);
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            pageInfo = (PageInfo) this.L$0;
            ResultKt.throwOnFailure(obj);
            int index22 = pageInfo.getIndex();
            long b22 = TiciInfoKt.b(this.$ticiInfo);
            CommonExtKt.e("highlightByPage, updateIndex, index: " + index22 + ", id: " + b22, "TiciMainViewModel");
            int computeProgress2 = this.$ticiInfo.computeProgress(pageInfo.getPage(), pageInfo.getIndex());
            this.this$0.e.setValue(new ParagraphProgress(pageInfo, computeProgress2));
            this.this$0.g.postValue(this.this$0.n(computeProgress2 + 1, this.$ticiInfo.getTotalParagraphSize()));
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        TiciMainViewModel.F(this.this$0, (Long) null, (Integer) null, false, false, 15, (Object) null);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciMainViewModel$highlightByPage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
