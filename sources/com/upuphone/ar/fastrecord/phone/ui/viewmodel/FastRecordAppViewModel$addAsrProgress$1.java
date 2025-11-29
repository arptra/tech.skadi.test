package com.upuphone.ar.fastrecord.phone.ui.viewmodel;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.AsrDuringProgress;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordAppViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordAppViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordAppViewModel$addAsrProgress$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,321:1\n1855#2,2:322\n1#3:324\n*S KotlinDebug\n*F\n+ 1 FastRecordAppViewModel.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordAppViewModel$addAsrProgress$1\n*L\n70#1:322,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordAppViewModel$addAsrProgress$1", f = "FastRecordAppViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordAppViewModel$addAsrProgress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AsrDuringProgress $asrResult;
    int label;
    final /* synthetic */ FastRecordAppViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordAppViewModel$addAsrProgress$1(AsrDuringProgress asrDuringProgress, FastRecordAppViewModel fastRecordAppViewModel, Continuation<? super FastRecordAppViewModel$addAsrProgress$1> continuation) {
        super(2, continuation);
        this.$asrResult = asrDuringProgress;
        this.this$0 = fastRecordAppViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordAppViewModel$addAsrProgress$1(this.$asrResult, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            AsrDuringProgress asrDuringProgress = this.$asrResult;
            LogExt.logE("addAsrProgress asrResult = " + asrDuringProgress, "FastRecordAppViewModel");
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            T value = this.this$0._recordAsrDuringProgress.getValue();
            objectRef.element = value;
            Collection collection = (Collection) value;
            if (collection == null || collection.isEmpty()) {
                objectRef.element = new ArrayList();
            }
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            AsrDuringProgress asrDuringProgress2 = this.$asrResult;
            for (T t : (Iterable) objectRef.element) {
                if (t.getRecordId() == asrDuringProgress2.getRecordId()) {
                    objectRef2.element = t;
                }
            }
            T t2 = objectRef2.element;
            LogExt.logE("addAsrProgress needDelData = " + t2, "FastRecordAppViewModel");
            T t3 = objectRef2.element;
            if (((AsrDuringProgress) t3) != null) {
                Boxing.boxBoolean(TypeIntrinsics.asMutableCollection((Collection) objectRef.element).remove(t3));
            }
            ((ArrayList) objectRef.element).add(this.$asrResult);
            this.this$0._recordAsrDuringProgress.postValue(objectRef.element);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordAppViewModel$addAsrProgress$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
