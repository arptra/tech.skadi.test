package com.upuphone.ar.fastrecord.phone.utils;

import android.content.Context;
import android.net.Uri;
import androidx.core.content.FileProvider;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getSingleRecordShareWordPath$1", f = "RecordVoiceUtils.kt", i = {}, l = {510, 526}, m = "invokeSuspend", n = {}, s = {})
public final class RecordVoiceUtils$getSingleRecordShareWordPath$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ArrayList<Uri>, Unit> $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ long $createTime;
    final /* synthetic */ long $recordId;
    final /* synthetic */ String $recordTitle;
    int label;

    @SourceDebugExtension({"SMAP\nRecordVoiceUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecordVoiceUtils.kt\ncom/upuphone/ar/fastrecord/phone/utils/RecordVoiceUtils$getSingleRecordShareWordPath$1$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1189:1\n1#2:1190\n*E\n"})
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getSingleRecordShareWordPath$1$1", f = "RecordVoiceUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils$getSingleRecordShareWordPath$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(context2, file, function1, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Uri uriForFile = FileProvider.getUriForFile(context2, "com.upuphone.ar.shorthand.phone.fileprovider", file);
                Function1<ArrayList<Uri>, Unit> function1 = function1;
                ArrayList arrayList = new ArrayList();
                arrayList.add(uriForFile);
                function1.invoke(arrayList);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordVoiceUtils$getSingleRecordShareWordPath$1(Context context, long j, String str, long j2, Function1<? super ArrayList<Uri>, Unit> function1, Continuation<? super RecordVoiceUtils$getSingleRecordShareWordPath$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$recordId = j;
        this.$recordTitle = str;
        this.$createTime = j2;
        this.$callback = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RecordVoiceUtils$getSingleRecordShareWordPath$1(this.$context, this.$recordId, this.$recordTitle, this.$createTime, this.$callback, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RecordVoiceUtils recordVoiceUtils = RecordVoiceUtils.INSTANCE;
            Context context = this.$context;
            long j = this.$recordId;
            String str = this.$recordTitle;
            if (str == null) {
                str = "";
            }
            this.label = 1;
            obj = recordVoiceUtils.getRecordWordShareFile(context, j, recordVoiceUtils.getFileShareName(str, this.$createTime) + ".txt", this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                LogExt.logE("getRecordShareWordTempPath error msg = " + e.getMessage(), RecordVoiceUtils.TAG);
            }
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final File file = (File) obj;
        LogExt.logE("last file share word path = " + (file != null ? file.getPath() : null), RecordVoiceUtils.TAG);
        if (file == null) {
            LogExt.logE("last file shareTempFile == null", RecordVoiceUtils.TAG);
            return Unit.INSTANCE;
        }
        MainCoroutineDispatcher c = Dispatchers.c();
        final Context context2 = this.$context;
        final Function1<ArrayList<Uri>, Unit> function1 = this.$callback;
        AnonymousClass1 r5 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
        this.label = 2;
        if (BuildersKt.g(c, r5, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RecordVoiceUtils$getSingleRecordShareWordPath$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
