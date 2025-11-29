package com.upuphone.ar.tici.phone;

import android.content.Context;
import android.net.Uri;
import com.upuphone.ar.tici.phone.data.ImportFileState;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.ar.tici.phone.utils.EventBus;
import com.upuphone.ar.tici.phone.utils.FileUtils;
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
@DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciAppViewModel$startImportFile$2", f = "TiciAppViewModel.kt", i = {}, l = {535, 539}, m = "invokeSuspend", n = {}, s = {})
public final class TiciAppViewModel$startImportFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $uri;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciAppViewModel$startImportFile$2(Uri uri, Continuation<? super TiciAppViewModel$startImportFile$2> continuation) {
        super(2, continuation);
        this.$uri = uri;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciAppViewModel$startImportFile$2(this.$uri, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Uri uri = this.$uri;
            CommonExtKt.e("startImportFile, uri: " + uri, "TiciAppViewModel");
            FileUtils fileUtils = FileUtils.f5991a;
            Context a2 = TiciApp.b.a();
            Uri uri2 = this.$uri;
            this.label = 1;
            obj = fileUtils.b(a2, uri2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            EventBus eventBus = EventBus.b;
            eventBus.j(ImportFileState.ImportingUri.class);
            eventBus.f((ImportFileState) obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        EventBus.b.h(new ImportFileState.ImportingUri(this.$uri, (String) obj));
        TiciHelper ticiHelper = TiciHelper.f6002a;
        TiciApp ticiApp = TiciApp.b;
        Context a3 = ticiApp.a();
        Uri uri3 = this.$uri;
        boolean l = ticiApp.l();
        this.label = 2;
        obj = ticiHelper.i(a3, uri3, l, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        EventBus eventBus2 = EventBus.b;
        eventBus2.j(ImportFileState.ImportingUri.class);
        eventBus2.f((ImportFileState) obj);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciAppViewModel$startImportFile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
