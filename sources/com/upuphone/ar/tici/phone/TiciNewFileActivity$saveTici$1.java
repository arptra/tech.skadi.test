package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.R;
import com.upuphone.ar.tici.phone.db.TiciDBHelper;
import com.upuphone.ar.tici.phone.db.entity.TiciEntity;
import com.upuphone.ar.tici.phone.db.entity.TiciEntityKt;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.ar.tici.phone.utils.StringExtKt;
import com.upuphone.ar.tici.phone.utils.TiciDataTrack;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.TiciNewFileActivity$saveTici$1", f = "TiciNewFileActivity.kt", i = {0, 1, 1}, l = {232, 259}, m = "invokeSuspend", n = {"ticiEntity", "oldEntity", "ticiEntity"}, s = {"L$0", "L$0", "L$1"})
public final class TiciNewFileActivity$saveTici$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $from;
    final /* synthetic */ String $rawContent;
    final /* synthetic */ String $rawTitle;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TiciNewFileActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciNewFileActivity$saveTici$1(String str, String str2, TiciNewFileActivity ticiNewFileActivity, int i, Continuation<? super TiciNewFileActivity$saveTici$1> continuation) {
        super(2, continuation);
        this.$rawTitle = str;
        this.$rawContent = str2;
        this.this$0 = ticiNewFileActivity;
        this.$from = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciNewFileActivity$saveTici$1(this.$rawTitle, this.$rawContent, this.this$0, this.$from, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        TiciEntity ticiEntity;
        TiciEntity ticiEntity2;
        TiciEntity ticiEntity3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        int i2 = 1;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String f = StringExtKt.f(this.$rawTitle);
            String e = StringExtKt.e(this.$rawContent);
            long a2 = (long) StringExtKt.a(e);
            long currentTimeMillis = System.currentTimeMillis();
            TiciEntity A0 = this.this$0.c;
            if (A0 == null) {
                TiciApp ticiApp = TiciApp.b;
                TiciEntity e2 = TiciEntityKt.e(f, e, (Integer) null, ticiApp.g());
                TiciDBHelper ticiDBHelper = TiciDBHelper.f5925a;
                boolean l = ticiApp.l();
                this.L$0 = e2;
                this.label = 1;
                if (ticiDBHelper.e(e2, e, l, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ticiEntity = e2;
            } else {
                String j = StringExtKt.j(e, 100);
                List emptyList = CollectionsKt.emptyList();
                TiciApp ticiApp2 = TiciApp.b;
                TiciEntity ticiEntity4 = A0;
                TiciEntity copy$default = TiciEntity.copy$default(ticiEntity4, 0, f, j, emptyList, 0, a2, 0, currentTimeMillis, (Integer) null, 0, ticiApp2.g(), 0, 1, e.length(), 2641, (Object) null);
                TiciDBHelper ticiDBHelper2 = TiciDBHelper.f5925a;
                boolean l2 = ticiApp2.l();
                TiciEntity ticiEntity5 = ticiEntity4;
                this.L$0 = ticiEntity5;
                this.L$1 = copy$default;
                this.label = 2;
                if (ticiDBHelper2.e(copy$default, e, l2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ticiEntity3 = copy$default;
                ticiEntity2 = ticiEntity5;
                CommonExtKt.e("saveTici, update ticiEntity: " + ticiEntity.toSimpleString(), "TiciNewFileActivity");
                TiciEntity ticiEntity6 = (TiciEntity) TiciApp.b.c().R().getValue();
                i2 = 2;
                TiciDataTrack.f6001a.c("app_prompt_save", MapsKt.mapOf(TuplesKt.to("type", Boxing.boxInt(this.$from)), TuplesKt.to("page", Boxing.boxInt(i2))));
                CommonExtKt.j(this.this$0, R.string.tici_saved, 0, 2, (Object) null);
                TiciApp.b.c().z0(ticiEntity);
                this.this$0.finish();
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            ticiEntity = (TiciEntity) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ticiEntity3 = (TiciEntity) this.L$1;
            ticiEntity2 = (TiciEntity) this.L$0;
            ResultKt.throwOnFailure(obj);
            CommonExtKt.e("saveTici, update ticiEntity: " + ticiEntity.toSimpleString(), "TiciNewFileActivity");
            TiciEntity ticiEntity62 = (TiciEntity) TiciApp.b.c().R().getValue();
            if (ticiEntity62 == null || ticiEntity62.getId() != ticiEntity2.getId()) {
                i2 = 2;
            }
            TiciDataTrack.f6001a.c("app_prompt_save", MapsKt.mapOf(TuplesKt.to("type", Boxing.boxInt(this.$from)), TuplesKt.to("page", Boxing.boxInt(i2))));
            CommonExtKt.j(this.this$0, R.string.tici_saved, 0, 2, (Object) null);
            TiciApp.b.c().z0(ticiEntity);
            this.this$0.finish();
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CommonExtKt.e("saveTici, insert ticiEntity: " + ticiEntity.toSimpleString(), "TiciNewFileActivity");
        TiciDataTrack.f6001a.c("app_prompt_add_suc", MapsKt.mapOf(TuplesKt.to("type", Boxing.boxInt(0)), TuplesKt.to("byte_size", Boxing.boxLong(ticiEntity.getFileSize())), TuplesKt.to("string_size", Boxing.boxInt(ticiEntity.getTotalTextLength()))));
        CommonExtKt.j(this.this$0, R.string.tici_saved, 0, 2, (Object) null);
        TiciApp.b.c().z0(ticiEntity);
        this.this$0.finish();
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciNewFileActivity$saveTici$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
