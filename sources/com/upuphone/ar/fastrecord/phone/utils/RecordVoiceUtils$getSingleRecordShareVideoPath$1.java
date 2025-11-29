package com.upuphone.ar.fastrecord.phone.utils;

import android.content.Context;
import android.net.Uri;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getSingleRecordShareVideoPath$1", f = "RecordVoiceUtils.kt", i = {}, l = {659}, m = "invokeSuspend", n = {}, s = {})
public final class RecordVoiceUtils$getSingleRecordShareVideoPath$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ArrayList<Uri>, Unit> $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ long $createTime;
    final /* synthetic */ String $recordTitle;
    final /* synthetic */ String $tempPath;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordVoiceUtils$getSingleRecordShareVideoPath$1(String str, Context context, String str2, long j, Function1<? super ArrayList<Uri>, Unit> function1, Continuation<? super RecordVoiceUtils$getSingleRecordShareVideoPath$1> continuation) {
        super(2, continuation);
        this.$tempPath = str;
        this.$context = context;
        this.$recordTitle = str2;
        this.$createTime = j;
        this.$callback = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RecordVoiceUtils$getSingleRecordShareVideoPath$1(this.$tempPath, this.$context, this.$recordTitle, this.$createTime, this.$callback, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.$tempPath;
            LogExt.logW("copyDataPathToCachePath tempPath=" + str, RecordVoiceUtils.TAG);
            String str2 = this.$tempPath;
            if (str2 != null) {
                Context context = this.$context;
                String str3 = this.$recordTitle;
                long j = this.$createTime;
                Function1<ArrayList<Uri>, Unit> function1 = this.$callback;
                LogExt.logE("copyDataPathToCachePath shareFilePath path = " + str2, RecordVoiceUtils.TAG);
                File file = new File(str2);
                String name = file.getName();
                LogExt.logE("copyDataPathToCachePath shareFilePath name = " + name, RecordVoiceUtils.TAG);
                RecordFileUtils recordFileUtils = RecordFileUtils.INSTANCE;
                RecordVoiceUtils recordVoiceUtils = RecordVoiceUtils.INSTANCE;
                if (str3 == null) {
                    str3 = "";
                }
                String access$getFileShareName = recordVoiceUtils.getFileShareName(str3, j);
                File tempShareFile = recordFileUtils.getTempShareFile(context, access$getFileShareName + ".wav");
                String path = file.getPath();
                String path2 = tempShareFile.getPath();
                LogExt.logE("copyDataPathToCachePath shareAudioFile path = " + path + ",  shareTempFile path = " + path2, RecordVoiceUtils.TAG);
                String path3 = file.getPath();
                Intrinsics.checkNotNullExpressionValue(path3, "getPath(...)");
                String path4 = tempShareFile.getPath();
                Intrinsics.checkNotNullExpressionValue(path4, "getPath(...)");
                recordFileUtils.copyFile(path3, path4);
                MainCoroutineDispatcher c = Dispatchers.c();
                RecordVoiceUtils$getSingleRecordShareVideoPath$1$1$1 recordVoiceUtils$getSingleRecordShareVideoPath$1$1$1 = new RecordVoiceUtils$getSingleRecordShareVideoPath$1$1$1(context, tempShareFile, function1, (Continuation<? super RecordVoiceUtils$getSingleRecordShareVideoPath$1$1$1>) null);
                this.label = 1;
                if (BuildersKt.g(c, recordVoiceUtils$getSingleRecordShareVideoPath$1$1$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RecordVoiceUtils$getSingleRecordShareVideoPath$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
