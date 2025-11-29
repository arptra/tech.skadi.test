package com.upuphone.ai.ttsengine.flavor.service;

import android.content.Context;
import com.upuphone.ai.ttsengine.base.utils.AILOG;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ai.ttsengine.flavor.service.LicenceSender$check$1", f = "LicenceSender.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
public final class LicenceSender$check$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ byte[] $data;
    Object L$0;
    int label;
    final /* synthetic */ LicenceSender this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LicenceSender$check$1(LicenceSender licenceSender, Context context, byte[] bArr, Continuation<? super LicenceSender$check$1> continuation) {
        super(2, continuation);
        this.this$0 = licenceSender;
        this.$context = context;
        this.$data = bArr;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LicenceSender$check$1(this.this$0, this.$context, this.$data, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Throwable th;
        InputStream inputStream;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.c.c("enter scope", new Object[0]);
            InputStream open = this.$context.getAssets().open("glass/licence/version");
            byte[] bArr = this.$data;
            LicenceSender licenceSender = this.this$0;
            Context context = this.$context;
            try {
                long parseLong = Long.parseLong(new String(bArr, Charsets.UTF_8));
                String readLine = new LineNumberReader(new InputStreamReader(open)).readLine();
                Intrinsics.checkNotNullExpressionValue(readLine, "readLine(...)");
                long parseLong2 = Long.parseLong(readLine);
                AILOG d = licenceSender.c;
                d.c("check version remote: " + parseLong + ", local: " + parseLong2, new Object[0]);
                if (parseLong2 > parseLong) {
                    this.L$0 = open;
                    this.label = 1;
                    if (licenceSender.k(context, parseLong2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                inputStream = open;
            } catch (Throwable th2) {
                InputStream inputStream2 = open;
                th = th2;
                inputStream = inputStream2;
                try {
                    throw th;
                } catch (Throwable th3) {
                    CloseableKt.closeFinally(inputStream, th);
                    throw th3;
                }
            }
        } else if (i == 1) {
            inputStream = (Closeable) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th4) {
                th = th4;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Unit unit = Unit.INSTANCE;
        CloseableKt.closeFinally(inputStream, (Throwable) null);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LicenceSender$check$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
