package com.upuphone.ar.fastrecord.phone.utils;

import android.content.Context;
import android.net.Uri;
import androidx.core.content.FileProvider;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nRecordVoiceUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordVoiceUtils.kt\ncom/upuphone/ar/fastrecord/phone/utils/RecordVoiceUtils$getSingleRecordShareVideoPath$1$1$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1189:1\n1#2:1190\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getSingleRecordShareVideoPath$1$1$1", f = "RecordVoiceUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RecordVoiceUtils$getSingleRecordShareVideoPath$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ArrayList<Uri>, Unit> $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ File $shareTempAudioFile;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordVoiceUtils$getSingleRecordShareVideoPath$1$1$1(Context context, File file, Function1<? super ArrayList<Uri>, Unit> function1, Continuation<? super RecordVoiceUtils$getSingleRecordShareVideoPath$1$1$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$shareTempAudioFile = file;
        this.$callback = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RecordVoiceUtils$getSingleRecordShareVideoPath$1$1$1(this.$context, this.$shareTempAudioFile, this.$callback, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Uri uriForFile = FileProvider.getUriForFile(this.$context, "com.upuphone.ar.shorthand.phone.fileprovider", this.$shareTempAudioFile);
            Function1<ArrayList<Uri>, Unit> function1 = this.$callback;
            ArrayList arrayList = new ArrayList();
            arrayList.add(uriForFile);
            function1.invoke(arrayList);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RecordVoiceUtils$getSingleRecordShareVideoPath$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
