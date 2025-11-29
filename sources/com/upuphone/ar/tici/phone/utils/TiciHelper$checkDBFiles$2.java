package com.upuphone.ar.tici.phone.utils;

import com.upuphone.ar.tici.phone.TiciApp;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTiciHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciHelper.kt\ncom/upuphone/ar/tici/phone/utils/TiciHelper$checkDBFiles$2\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,623:1\n13309#2,2:624\n*S KotlinDebug\n*F\n+ 1 TiciHelper.kt\ncom/upuphone/ar/tici/phone/utils/TiciHelper$checkDBFiles$2\n*L\n509#1:624,2\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.utils.TiciHelper$checkDBFiles$2", f = "TiciHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TiciHelper$checkDBFiles$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public TiciHelper$checkDBFiles$2(Continuation<? super TiciHelper$checkDBFiles$2> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TiciHelper$checkDBFiles$2 ticiHelper$checkDBFiles$2 = new TiciHelper$checkDBFiles$2(continuation);
        ticiHelper$checkDBFiles$2.L$0 = obj;
        return ticiHelper$checkDBFiles$2;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Unit unit;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            try {
                File file = new File(TiciApp.b.a().getDataDir(), "databases");
                CommonExtKt.b("checkDBFiles, dir: " + file, "TiciHelper");
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        CommonExtKt.b("checkDBFiles, dbFileList: " + file2, "TiciHelper");
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    CommonExtKt.d("checkDBFiles, dbFileList is null", "TiciHelper", (Throwable) null, 2, (Object) null);
                }
            } catch (Exception e) {
                CommonExtKt.d("checkDBFiles error: " + e, "TiciHelper", (Throwable) null, 2, (Object) null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciHelper$checkDBFiles$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
