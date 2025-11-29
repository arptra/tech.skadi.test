package com.upuphone.ar.tici.phone.starrynet;

import com.upuphone.ar.tici.phone.db.entity.TiciContentPart;
import com.upuphone.ar.tici.phone.db.entity.TiciEntity;
import com.upuphone.ar.tici.phone.db.entity.TiciEntityKt;
import com.upuphone.ar.tici.phone.starrynet.msg.SendTiciContentPageMsg;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.ar.tici.phone.utils.StringExtKt;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.starrynet.TiciStarryMsgManager$sendTiciContentPage$1", f = "TiciStarryMsgManager.kt", i = {0, 0, 0}, l = {716}, m = "invokeSuspend", n = {"sourceText", "fileKey", "totalPart"}, s = {"L$0", "L$1", "I$0"})
public final class TiciStarryMsgManager$sendTiciContentPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TiciContentPart $contentPart;
    final /* synthetic */ Integer $currentIndex;
    final /* synthetic */ int $currentPage;
    final /* synthetic */ TiciEntity $ticiEntity;
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TiciStarryMsgManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciStarryMsgManager$sendTiciContentPage$1(TiciContentPart ticiContentPart, TiciEntity ticiEntity, Integer num, int i, TiciStarryMsgManager ticiStarryMsgManager, Continuation<? super TiciStarryMsgManager$sendTiciContentPage$1> continuation) {
        super(2, continuation);
        this.$contentPart = ticiContentPart;
        this.$ticiEntity = ticiEntity;
        this.$currentIndex = num;
        this.$currentPage = i;
        this.this$0 = ticiStarryMsgManager;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciStarryMsgManager$sendTiciContentPage$1(this.$contentPart, this.$ticiEntity, this.$currentIndex, this.$currentPage, this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        String str;
        String str2;
        int i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            String contentText = this.$contentPart.getContentText();
            String a2 = TiciEntityKt.a(this.$ticiEntity);
            int ceil = (int) ((float) Math.ceil((double) (((float) contentText.length()) / 10240.0f)));
            String uuid = UUID.randomUUID().toString();
            int a3 = StringExtKt.a(contentText);
            Integer num = this.$currentIndex;
            int intValue = num != null ? num.intValue() : 0;
            int contentOffsetStart = this.$contentPart.getContentOffsetStart();
            Intrinsics.checkNotNull(uuid);
            SendTiciContentPageMsg sendTiciContentPageMsg = new SendTiciContentPageMsg(uuid, a2, a3, ceil, intValue, this.$currentPage, contentOffsetStart);
            CommonExtKt.e("sendTiciContentPage, start: " + sendTiciContentPageMsg, "TiciStarryMsgManager");
            TiciMessageHelper ticiMessageHelper = TiciMessageHelper.f5973a;
            this.L$0 = contentText;
            this.L$1 = a2;
            this.I$0 = ceil;
            this.label = 1;
            Object j = ticiMessageHelper.j(sendTiciContentPageMsg, this);
            if (j == coroutine_suspended) {
                return coroutine_suspended;
            }
            i = ceil;
            Object obj3 = j;
            str = contentText;
            str2 = a2;
            obj2 = obj3;
        } else if (i2 == 1) {
            i = this.I$0;
            str2 = (String) this.L$1;
            str = (String) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                obj2 = ((Result) obj).m29unboximpl();
            } catch (Exception e) {
                CommonExtKt.e("sendTiciContentPage, error: " + e, "TiciStarryMsgManager");
                return Unit.INSTANCE;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj2);
        this.this$0.sendTiciContentPart(str2, str, i, this.$currentPage);
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TiciStarryMsgManager$sendTiciContentPage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
