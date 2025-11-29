package com.upuphone.ar.tici.phone.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.io.Closeable;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.utils.FileUtils$getFileNameFromUri$2", f = "FileUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FileUtils$getFileNameFromUri$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Uri $uri;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileUtils$getFileNameFromUri$2(Context context, Uri uri, Continuation<? super FileUtils$getFileNameFromUri$2> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$uri = uri;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FileUtils$getFileNameFromUri$2(this.$context, this.$uri, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Cursor cursor = null;
            try {
                Cursor query = this.$context.getContentResolver().query(this.$uri, (String[]) null, (String) null, (String[]) null, (String) null);
                if (query != null) {
                    try {
                        Closeable closeable = query;
                        try {
                            Cursor cursor2 = (Cursor) closeable;
                            if (cursor2.moveToFirst()) {
                                int columnIndex = cursor2.getColumnIndex("_display_name");
                                objectRef.element = columnIndex >= 0 ? cursor2.getString(columnIndex) : "";
                            }
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(closeable, (Throwable) null);
                        } catch (Throwable th) {
                            CloseableKt.closeFinally(closeable, th);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                    }
                }
                if (query != null) {
                    query.close();
                }
                return objectRef.element;
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        return ((FileUtils$getFileNameFromUri$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
