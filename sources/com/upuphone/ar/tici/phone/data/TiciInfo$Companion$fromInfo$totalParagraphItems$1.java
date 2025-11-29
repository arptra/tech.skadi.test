package com.upuphone.ar.tici.phone.data;

import com.upuphone.ar.tici.phone.starrynet.msg.OpenTiciMsgReplyKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTiciInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciInfo.kt\ncom/upuphone/ar/tici/phone/data/TiciInfo$Companion$fromInfo$totalParagraphItems$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,110:1\n1549#2:111\n1620#2,3:112\n*S KotlinDebug\n*F\n+ 1 TiciInfo.kt\ncom/upuphone/ar/tici/phone/data/TiciInfo$Companion$fromInfo$totalParagraphItems$1\n*L\n33#1:111\n33#1:112,3\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.upuphone.ar.tici.phone.data.TiciInfo$Companion$fromInfo$totalParagraphItems$1", f = "TiciInfo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TiciInfo$Companion$fromInfo$totalParagraphItems$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Integer>>, Object> {
    final /* synthetic */ List<String> $paragraphIndexes;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciInfo$Companion$fromInfo$totalParagraphItems$1(List<String> list, Continuation<? super TiciInfo$Companion$fromInfo$totalParagraphItems$1> continuation) {
        super(2, continuation);
        this.$paragraphIndexes = list;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TiciInfo$Companion$fromInfo$totalParagraphItems$1(this.$paragraphIndexes, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List<String> list = this.$paragraphIndexes;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (String d : list) {
                arrayList.add(Boxing.boxInt(OpenTiciMsgReplyKt.d(d).size()));
            }
            return arrayList;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<Integer>> continuation) {
        return ((TiciInfo$Companion$fromInfo$totalParagraphItems$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
