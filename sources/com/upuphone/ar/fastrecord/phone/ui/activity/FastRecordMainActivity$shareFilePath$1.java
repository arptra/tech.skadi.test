package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.net.Uri;
import com.upuphone.ar.fastrecord.phone.utils.RecordFileUtils;
import java.util.ArrayList;
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
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordMainActivity$shareFilePath$1", f = "FastRecordMainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FastRecordMainActivity$shareFilePath$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayList<Uri> $shareTempFileUirList;
    final /* synthetic */ String $type;
    int label;
    final /* synthetic */ FastRecordMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordMainActivity$shareFilePath$1(FastRecordMainActivity fastRecordMainActivity, ArrayList<Uri> arrayList, String str, Continuation<? super FastRecordMainActivity$shareFilePath$1> continuation) {
        super(2, continuation);
        this.this$0 = fastRecordMainActivity;
        this.$shareTempFileUirList = arrayList;
        this.$type = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FastRecordMainActivity$shareFilePath$1(this.this$0, this.$shareTempFileUirList, this.$type, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            RecordFileUtils.INSTANCE.shareUriList(this.this$0, this.$shareTempFileUirList, this.$type);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FastRecordMainActivity$shareFilePath$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
