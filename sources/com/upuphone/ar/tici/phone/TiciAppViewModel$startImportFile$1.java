package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.phone.data.ImportFileState;
import com.upuphone.ar.tici.phone.data.SystemFileInfo;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.ar.tici.phone.utils.EventBus;
import com.upuphone.ar.tici.phone.utils.TiciHelper;
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
@DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciAppViewModel$startImportFile$1", f = "TiciAppViewModel.kt", i = {}, l = {526}, m = "invokeSuspend", n = {}, s = {})
public final class TiciAppViewModel$startImportFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SystemFileInfo $fileInfo;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciAppViewModel$startImportFile$1(SystemFileInfo systemFileInfo, Continuation<? super TiciAppViewModel$startImportFile$1> continuation) {
        super(2, continuation);
        this.$fileInfo = systemFileInfo;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciAppViewModel$startImportFile$1(this.$fileInfo, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SystemFileInfo systemFileInfo = this.$fileInfo;
            CommonExtKt.e("startImportFile, fileInfo: " + systemFileInfo, "TiciAppViewModel");
            EventBus.b.h(new ImportFileState.Importing(this.$fileInfo));
            TiciHelper ticiHelper = TiciHelper.f6002a;
            String path = this.$fileInfo.getPath();
            boolean l = TiciApp.b.l();
            this.label = 1;
            obj = ticiHelper.h(path, l, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        EventBus eventBus = EventBus.b;
        eventBus.j(ImportFileState.Importing.class);
        eventBus.f((ImportFileState) obj);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciAppViewModel$startImportFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
