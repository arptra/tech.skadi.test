package com.upuphone.xr.sapp.glass;

import com.upuphone.star.fota.phone.GlassUpdateInfo;
import com.upuphone.xr.sapp.entity.GlassUpdateDownloadEvent;
import com.upuphone.xr.sapp.entity.GlassUpdateState;
import java.io.File;
import java.util.UUID;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassUpdateHelper$downloadCompleted$1", f = "GlassUpdateHelper.kt", i = {0}, l = {1002, 1011}, m = "invokeSuspend", n = {"uid"}, s = {"L$0"})
public final class GlassUpdateHelper$downloadCompleted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $digest;
    final /* synthetic */ File $downloadFile;
    final /* synthetic */ GlassUpdateInfo $glassUpdateInfo;
    final /* synthetic */ boolean $installRequired;
    final /* synthetic */ boolean $silent;
    Object L$0;
    int label;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.upuphone.xr.sapp.glass.GlassUpdateHelper$downloadCompleted$1$1", f = "GlassUpdateHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.upuphone.xr.sapp.glass.GlassUpdateHelper$downloadCompleted$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(file, continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(file.delete());
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlassUpdateHelper$downloadCompleted$1(boolean z, GlassUpdateInfo glassUpdateInfo, File file, String str, boolean z2, Continuation<? super GlassUpdateHelper$downloadCompleted$1> continuation) {
        super(2, continuation);
        this.$silent = z;
        this.$glassUpdateInfo = glassUpdateInfo;
        this.$downloadFile = file;
        this.$digest = str;
        this.$installRequired = z2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GlassUpdateHelper$downloadCompleted$1(this.$silent, this.$glassUpdateInfo, this.$downloadFile, this.$digest, this.$installRequired, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        String absolutePath;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            GlassUpdateHelper glassUpdateHelper = GlassUpdateHelper.b;
            glassUpdateHelper.d1("downloadCompleted, verifying");
            if (!this.$silent) {
                glassUpdateHelper.v1(new GlassUpdateState.Verifying(this.$glassUpdateInfo));
            }
            str = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
            if (!this.$downloadFile.exists()) {
                glassUpdateHelper.e1("downloadCompleted, downloadFile not exist");
                if (!this.$silent) {
                    glassUpdateHelper.v1(new GlassUpdateState.VerifyFail(str, this.$glassUpdateInfo));
                }
                return Unit.INSTANCE;
            }
            CoroutineDispatcher b = Dispatchers.b();
            GlassUpdateHelper$downloadCompleted$1$md5$1 glassUpdateHelper$downloadCompleted$1$md5$1 = new GlassUpdateHelper$downloadCompleted$1$md5$1(this.$downloadFile, (Continuation<? super GlassUpdateHelper$downloadCompleted$1$md5$1>) null);
            this.L$0 = str;
            this.label = 1;
            obj = BuildersKt.g(b, glassUpdateHelper$downloadCompleted$1$md5$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String str2 = (String) obj;
        if (!Intrinsics.areEqual((Object) this.$digest, (Object) str2)) {
            GlassUpdateHelper glassUpdateHelper2 = GlassUpdateHelper.b;
            String str3 = this.$digest;
            glassUpdateHelper2.d1("downloadCompleted, verify fail: " + str3 + " <=> " + str2);
            if (!this.$silent) {
                glassUpdateHelper2.v1(new GlassUpdateState.VerifyFail(str, this.$glassUpdateInfo));
            }
            CoroutineDispatcher b2 = Dispatchers.b();
            final File file = this.$downloadFile;
            AnonymousClass1 r1 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.L$0 = null;
            this.label = 2;
            if (BuildersKt.g(b2, r1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        GlassUpdateHelper glassUpdateHelper3 = GlassUpdateHelper.b;
        glassUpdateHelper3.d1("downloadCompleted, verify success");
        if (!this.$silent) {
            glassUpdateHelper3.v1(new GlassUpdateState.VerifySuccess(this.$glassUpdateInfo, this.$installRequired));
        }
        File parentFile = this.$downloadFile.getParentFile();
        if (!(parentFile == null || (absolutePath = parentFile.getAbsolutePath()) == null)) {
            glassUpdateHelper3.V(absolutePath);
        }
        glassUpdateHelper3.o0(new GlassUpdateDownloadEvent(this.$glassUpdateInfo, this.$downloadFile, this.$installRequired));
        if (this.$installRequired) {
            glassUpdateHelper3.j1();
            GlassUpdateAdapter.b.x(this.$glassUpdateInfo, this.$downloadFile, AnonymousClass3.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GlassUpdateHelper$downloadCompleted$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
