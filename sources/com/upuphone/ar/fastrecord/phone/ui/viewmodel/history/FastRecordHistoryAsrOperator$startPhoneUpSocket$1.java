package com.upuphone.ar.fastrecord.phone.ui.viewmodel.history;

import java.io.FileInputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordHistoryAsrOperator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordHistoryAsrOperator.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/history/FastRecordHistoryAsrOperator$startPhoneUpSocket$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1092:1\n1#2:1093\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.viewmodel.history.FastRecordHistoryAsrOperator$startPhoneUpSocket$1", f = "FastRecordHistoryAsrOperator.kt", i = {0, 0, 0}, l = {1009}, m = "invokeSuspend", n = {"pcmFileInputStream", "buffer", "length"}, s = {"L$0", "L$1", "L$2"})
public final class FastRecordHistoryAsrOperator$startPhoneUpSocket$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $upPcmPath;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ FastRecordHistoryAsrOperator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordHistoryAsrOperator$startPhoneUpSocket$1(String str, FastRecordHistoryAsrOperator fastRecordHistoryAsrOperator, Continuation<? super FastRecordHistoryAsrOperator$startPhoneUpSocket$1> continuation) {
        super(2, continuation);
        this.$upPcmPath = str;
        this.this$0 = fastRecordHistoryAsrOperator;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordHistoryAsrOperator$startPhoneUpSocket$1(this.$upPcmPath, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        FileInputStream fileInputStream;
        byte[] bArr;
        Ref.IntRef intRef;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            fileInputStream = new FileInputStream(this.$upPcmPath);
            bArr = new byte[3200];
            intRef = new Ref.IntRef();
        } else if (i == 1) {
            intRef = (Ref.IntRef) this.L$2;
            bArr = (byte[]) this.L$1;
            fileInputStream = (FileInputStream) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        do {
            int read = fileInputStream.read(bArr);
            intRef.element = read;
            if (read > 0) {
                this.this$0.getMLongAudioAsrTwoSocketHelper().sendRemoteAudioData(ArraysKt.copyOfRange(bArr, 0, intRef.element));
                this.L$0 = fileInputStream;
                this.L$1 = bArr;
                this.L$2 = intRef;
                this.label = 1;
            } else {
                this.this$0.sendUpFileDataFinish = true;
                this.this$0.checkSendFileState();
                return Unit.INSTANCE;
            }
        } while (DelayKt.b(5, this) != coroutine_suspended);
        return coroutine_suspended;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordHistoryAsrOperator$startPhoneUpSocket$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
