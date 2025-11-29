package com.upuphone.ar.transcribe.phone.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import com.upuphone.ar.transcribe.databinding.ActivityTranscribeShareBinding;
import com.upuphone.ar.transcribe.ext.LogExt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.ShareActivity$initData$1$1$1", f = "ShareActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ShareActivity$initData$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ShareActivity $this_runCatching;
    final /* synthetic */ Uri $url;
    private /* synthetic */ Object L$0;
    int label;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.ar.transcribe.phone.activity.ShareActivity$initData$1$1$1$1", f = "ShareActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.ar.transcribe.phone.activity.ShareActivity$initData$1$1$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(shareActivity, decodeStream, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ActivityTranscribeShareBinding access$getBinding$p = shareActivity.binding;
                if (access$getBinding$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    access$getBinding$p = null;
                }
                access$getBinding$p.d.setImageBitmap(decodeStream);
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
    public ShareActivity$initData$1$1$1(ShareActivity shareActivity, Uri uri, Continuation<? super ShareActivity$initData$1$1$1> continuation) {
        super(2, continuation);
        this.$this_runCatching = shareActivity;
        this.$url = uri;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ShareActivity$initData$1$1$1 shareActivity$initData$1$1$1 = new ShareActivity$initData$1$1$1(this.$this_runCatching, this.$url, continuation);
        shareActivity$initData$1$1$1.L$0 = obj;
        return shareActivity$initData$1$1$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(this.$this_runCatching.getContentResolver().openInputStream(this.$url), (Rect) null, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int ordinal = options.outConfig.ordinal();
            LogExt.d("option width: " + i + ", height: " + i2 + ", bit: " + ordinal, "ShareActivity");
            int ordinal2 = options.outWidth * options.outHeight * options.outConfig.ordinal();
            StringBuilder sb = new StringBuilder();
            sb.append("bitmap byte count: ");
            sb.append(ordinal2);
            LogExt.d(sb.toString(), "ShareActivity");
            if (ordinal2 >= this.$this_runCatching.getMaxBitmapSize()) {
                LogExt.d("large bitmap", "ShareActivity");
                options.inSampleSize = 2;
            } else {
                options.inSampleSize = 1;
            }
            options.inJustDecodeBounds = false;
            final Bitmap decodeStream = BitmapFactory.decodeStream(this.$this_runCatching.getContentResolver().openInputStream(this.$url), (Rect) null, options);
            Integer boxInt = decodeStream != null ? Boxing.boxInt(decodeStream.getWidth()) : null;
            Integer boxInt2 = decodeStream != null ? Boxing.boxInt(decodeStream.getHeight()) : null;
            Integer boxInt3 = decodeStream != null ? Boxing.boxInt(decodeStream.getByteCount()) : null;
            LogExt.d("bit map width: " + boxInt + ", height: " + boxInt2 + ", byte count: " + boxInt3, "ShareActivity");
            MainCoroutineDispatcher c = Dispatchers.c();
            final ShareActivity shareActivity = this.$this_runCatching;
            Job unused = BuildersKt__Builders_commonKt.d(coroutineScope, c, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 2, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ShareActivity$initData$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
