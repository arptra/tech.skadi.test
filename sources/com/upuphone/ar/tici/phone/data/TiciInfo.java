package com.upuphone.ar.tici.phone.data;

import androidx.annotation.Keep;
import com.upuphone.ar.tici.phone.db.entity.TiciContentPart;
import com.upuphone.ar.tici.phone.db.entity.TiciEntity;
import com.upuphone.ar.tici.phone.starrynet.BaseJsonMsg;
import com.upuphone.ar.tici.phone.starrynet.msg.ParagraphItem;
import com.upuphone.ar.tici.phone.utils.StringExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTiciInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciInfo.kt\ncom/upuphone/ar/tici/phone/data/TiciInfo\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,110:1\n1549#2:111\n1620#2,3:112\n1864#2,3:115\n1864#2,3:118\n*S KotlinDebug\n*F\n+ 1 TiciInfo.kt\ncom/upuphone/ar/tici/phone/data/TiciInfo\n*L\n61#1:111\n61#1:112,3\n71#1:115,3\n88#1:118,3\n*E\n"})
@Keep
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\fJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\fJ\u0006\u0010!\u001a\u00020\u0005J\b\u0010\"\u001a\u00020\u0005H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/TiciInfo;", "Lcom/upuphone/ar/tici/phone/starrynet/BaseJsonMsg;", "ticiEntity", "Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "currentSourceText", "", "currentContentPart", "Lcom/upuphone/ar/tici/phone/db/entity/TiciContentPart;", "currentParagraphItems", "", "Lcom/upuphone/ar/tici/phone/starrynet/msg/ParagraphItem;", "totalParagraphItems", "", "totalParagraphSize", "(Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;Ljava/lang/String;Lcom/upuphone/ar/tici/phone/db/entity/TiciContentPart;Ljava/util/List;Ljava/util/List;I)V", "getCurrentContentPart", "()Lcom/upuphone/ar/tici/phone/db/entity/TiciContentPart;", "getCurrentParagraphItems", "()Ljava/util/List;", "getCurrentSourceText", "()Ljava/lang/String;", "getTiciEntity", "()Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "getTotalParagraphSize", "()I", "computeProgress", "targetPage", "index", "findPageInfo", "Lcom/upuphone/ar/tici/phone/data/PageInfo;", "progress", "isReachLast", "", "toSimpleString", "toString", "Companion", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TiciInfo extends BaseJsonMsg {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final TiciContentPart currentContentPart;
    @NotNull
    private final List<ParagraphItem> currentParagraphItems;
    @NotNull
    private final String currentSourceText;
    @NotNull
    private final TiciEntity ticiEntity;
    @NotNull
    private final List<Integer> totalParagraphItems;
    private final int totalParagraphSize;

    @SourceDebugExtension({"SMAP\nTiciInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciInfo.kt\ncom/upuphone/ar/tici/phone/data/TiciInfo$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,110:1\n1#2:111\n*E\n"})
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH@¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/TiciInfo$Companion;", "", "<init>", "()V", "Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "entity", "", "", "paragraphIndexes", "Lcom/upuphone/ar/tici/phone/db/entity/TiciContentPart;", "currentContentPart", "nextContentPart", "Lcom/upuphone/ar/tici/phone/data/TiciInfo;", "a", "(Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;Ljava/util/List;Lcom/upuphone/ar/tici/phone/db/entity/TiciContentPart;Lcom/upuphone/ar/tici/phone/db/entity/TiciContentPart;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: com.upuphone.ar.tici.phone.db.entity.TiciContentPart} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: com.upuphone.ar.tici.phone.db.entity.TiciContentPart} */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0083, code lost:
            if (r7 == null) goto L_0x0088;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0099 A[LOOP:0: B:23:0x0093->B:25:0x0099, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object a(com.upuphone.ar.tici.phone.db.entity.TiciEntity r8, java.util.List r9, com.upuphone.ar.tici.phone.db.entity.TiciContentPart r10, com.upuphone.ar.tici.phone.db.entity.TiciContentPart r11, kotlin.coroutines.Continuation r12) {
            /*
                r7 = this;
                boolean r0 = r12 instanceof com.upuphone.ar.tici.phone.data.TiciInfo$Companion$fromInfo$1
                if (r0 == 0) goto L_0x0013
                r0 = r12
                com.upuphone.ar.tici.phone.data.TiciInfo$Companion$fromInfo$1 r0 = (com.upuphone.ar.tici.phone.data.TiciInfo$Companion$fromInfo$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                com.upuphone.ar.tici.phone.data.TiciInfo$Companion$fromInfo$1 r0 = new com.upuphone.ar.tici.phone.data.TiciInfo$Companion$fromInfo$1
                r0.<init>(r7, r12)
            L_0x0018:
                java.lang.Object r7 = r0.result
                java.lang.Object r12 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r0.label
                r2 = 1
                if (r1 == 0) goto L_0x0041
                if (r1 != r2) goto L_0x0039
                java.lang.Object r8 = r0.L$2
                r11 = r8
                com.upuphone.ar.tici.phone.db.entity.TiciContentPart r11 = (com.upuphone.ar.tici.phone.db.entity.TiciContentPart) r11
                java.lang.Object r8 = r0.L$1
                r10 = r8
                com.upuphone.ar.tici.phone.db.entity.TiciContentPart r10 = (com.upuphone.ar.tici.phone.db.entity.TiciContentPart) r10
                java.lang.Object r8 = r0.L$0
                com.upuphone.ar.tici.phone.db.entity.TiciEntity r8 = (com.upuphone.ar.tici.phone.db.entity.TiciEntity) r8
                kotlin.ResultKt.throwOnFailure(r7)
            L_0x0036:
                r1 = r8
                r3 = r10
                goto L_0x005d
            L_0x0039:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L_0x0041:
                kotlin.ResultKt.throwOnFailure(r7)
                kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.a()
                com.upuphone.ar.tici.phone.data.TiciInfo$Companion$fromInfo$totalParagraphItems$1 r1 = new com.upuphone.ar.tici.phone.data.TiciInfo$Companion$fromInfo$totalParagraphItems$1
                r3 = 0
                r1.<init>(r9, r3)
                r0.L$0 = r8
                r0.L$1 = r10
                r0.L$2 = r11
                r0.label = r2
                java.lang.Object r7 = kotlinx.coroutines.BuildersKt.g(r7, r1, r0)
                if (r7 != r12) goto L_0x0036
                return r12
            L_0x005d:
                r5 = r7
                java.util.List r5 = (java.util.List) r5
                java.util.List r4 = r3.getParagraphIndexes()
                if (r11 == 0) goto L_0x0088
                java.lang.String r7 = r3.getContentText()
                java.lang.String r8 = r11.getContentText()
                r9 = 1400(0x578, float:1.962E-42)
                java.lang.String r8 = com.upuphone.ar.tici.phone.utils.StringExtKt.j(r8, r9)
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                r9.append(r7)
                r9.append(r8)
                java.lang.String r7 = r9.toString()
                if (r7 != 0) goto L_0x0086
                goto L_0x0088
            L_0x0086:
                r2 = r7
                goto L_0x008d
            L_0x0088:
                java.lang.String r7 = r3.getContentText()
                goto L_0x0086
            L_0x008d:
                java.util.Iterator r7 = r5.iterator()
                r8 = 0
                r6 = r8
            L_0x0093:
                boolean r8 = r7.hasNext()
                if (r8 == 0) goto L_0x00a5
                java.lang.Object r8 = r7.next()
                java.lang.Number r8 = (java.lang.Number) r8
                int r8 = r8.intValue()
                int r6 = r6 + r8
                goto L_0x0093
            L_0x00a5:
                com.upuphone.ar.tici.phone.data.TiciInfo r7 = new com.upuphone.ar.tici.phone.data.TiciInfo
                r0 = r7
                r0.<init>(r1, r2, r3, r4, r5, r6)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.data.TiciInfo.Companion.a(com.upuphone.ar.tici.phone.db.entity.TiciEntity, java.util.List, com.upuphone.ar.tici.phone.db.entity.TiciContentPart, com.upuphone.ar.tici.phone.db.entity.TiciContentPart, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public Companion() {
        }
    }

    public TiciInfo(@NotNull TiciEntity ticiEntity2, @NotNull String str, @NotNull TiciContentPart ticiContentPart, @NotNull List<ParagraphItem> list, @NotNull List<Integer> list2, int i) {
        Intrinsics.checkNotNullParameter(ticiEntity2, "ticiEntity");
        Intrinsics.checkNotNullParameter(str, "currentSourceText");
        Intrinsics.checkNotNullParameter(ticiContentPart, "currentContentPart");
        Intrinsics.checkNotNullParameter(list, "currentParagraphItems");
        Intrinsics.checkNotNullParameter(list2, "totalParagraphItems");
        this.ticiEntity = ticiEntity2;
        this.currentSourceText = str;
        this.currentContentPart = ticiContentPart;
        this.currentParagraphItems = list;
        this.totalParagraphItems = list2;
        this.totalParagraphSize = i;
    }

    public final int computeProgress(int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        for (T next : this.totalParagraphItems) {
            int i5 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int intValue = ((Number) next).intValue() + i4;
            if (i == i3) {
                return i4 + i2;
            }
            i4 = intValue;
            i3 = i5;
        }
        return 0;
    }

    @Nullable
    public final PageInfo findPageInfo(int i) {
        int i2 = 0;
        int i3 = 0;
        for (T next : this.totalParagraphItems) {
            int i4 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int intValue = ((Number) next).intValue() + i3;
            if (i3 <= i && i < intValue) {
                return new PageInfo(i2, i - i3);
            }
            i3 = intValue;
            i2 = i4;
        }
        return null;
    }

    @NotNull
    public final TiciContentPart getCurrentContentPart() {
        return this.currentContentPart;
    }

    @NotNull
    public final List<ParagraphItem> getCurrentParagraphItems() {
        return this.currentParagraphItems;
    }

    @NotNull
    public final String getCurrentSourceText() {
        return this.currentSourceText;
    }

    @NotNull
    public final TiciEntity getTiciEntity() {
        return this.ticiEntity;
    }

    public final int getTotalParagraphSize() {
        return this.totalParagraphSize;
    }

    public final boolean isReachLast(int i) {
        return i >= this.totalParagraphSize - 1;
    }

    @NotNull
    public final String toSimpleString() {
        String a2 = TiciInfoKt.a(this);
        int length = this.currentSourceText.length();
        String j = StringExtKt.j(this.currentSourceText, 100);
        int size = this.currentParagraphItems.size();
        List<Integer> list = this.totalParagraphItems;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Number intValue : list) {
            arrayList.add(Integer.valueOf(intValue.intValue()));
        }
        int i = this.totalParagraphSize;
        return StringsKt.trimMargin$default("TiciInfo(\n                |   fileName='" + a2 + "',\n                |   currentSourceTextLength=" + length + ",\n                |   currentSourceTextSub=" + j + ",\n                |   currentParagraphItems=" + size + ",\n                |   totalParagraphItems=" + arrayList + ",\n                |   totalParagraphSize=" + i + ",\n                |) ", (String) null, 1, (Object) null);
    }

    @NotNull
    public String toString() {
        return toJsonString();
    }
}
