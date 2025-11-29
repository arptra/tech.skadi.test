package com.upuphone.ar.tici.phone.utils;

import android.content.Context;
import android.net.Uri;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.utils.FileUtils$copyTiciTxtFile$2", f = "FileUtils.kt", i = {0}, l = {24, 31}, m = "invokeSuspend", n = {"fileName"}, s = {"L$0"})
public final class FileUtils$copyTiciTxtFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Uri $uri;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileUtils$copyTiciTxtFile$2(Context context, Uri uri, Continuation<? super FileUtils$copyTiciTxtFile$2> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$uri = uri;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FileUtils$copyTiciTxtFile$2(this.$context, this.$uri, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull T t) {
        File file;
        InputStream inputStream;
        InputStream inputStream2;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        T coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(t);
            objectRef2 = new Ref.ObjectRef();
            FileUtils fileUtils = FileUtils.f5991a;
            Context context = this.$context;
            Uri uri = this.$uri;
            this.L$0 = objectRef2;
            this.L$1 = objectRef2;
            this.label = 1;
            t = fileUtils.b(context, uri, this);
            if (t == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        } else if (i == 1) {
            objectRef2 = (Ref.ObjectRef) this.L$1;
            objectRef = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(t);
        } else if (i == 2) {
            inputStream2 = (Closeable) this.L$0;
            try {
                ResultKt.throwOnFailure(t);
                file = (File) t;
                inputStream = inputStream2;
                CloseableKt.closeFinally(inputStream, (Throwable) null);
                return file;
            } catch (Throwable th) {
                th = th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        objectRef2.element = t;
        CharSequence charSequence = (CharSequence) objectRef.element;
        if (charSequence == null || charSequence.length() == 0) {
            objectRef.element = UUID.randomUUID() + ".txt";
        }
        String str = this.$context.getFilesDir().getPath() + "/tici";
        InputStream openInputStream = this.$context.getContentResolver().openInputStream(this.$uri);
        if (openInputStream != null) {
            try {
                this.L$0 = openInputStream;
                this.L$1 = null;
                this.label = 2;
                t = FileUtils.f5991a.d(openInputStream, str, (String) objectRef.element, this);
                if (t == coroutine_suspended) {
                    return coroutine_suspended;
                }
                inputStream2 = openInputStream;
                file = (File) t;
                inputStream = inputStream2;
                CloseableKt.closeFinally(inputStream, (Throwable) null);
                return file;
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = openInputStream;
                try {
                    throw th;
                } catch (Throwable th3) {
                    CloseableKt.closeFinally(inputStream2, th);
                    throw th3;
                }
            }
        } else {
            file = null;
            inputStream = openInputStream;
            CloseableKt.closeFinally(inputStream, (Throwable) null);
            return file;
        }
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super File> continuation) {
        return ((FileUtils$copyTiciTxtFile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
