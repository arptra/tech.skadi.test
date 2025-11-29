package com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean;

import androidx.annotation.Keep;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nLocalRecognitionResultBean.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LocalRecognitionResultBean.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/LocalRecognitionResultBean\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,138:1\n1864#2,3:139\n37#3,2:142\n*S KotlinDebug\n*F\n+ 1 LocalRecognitionResultBean.kt\ncom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/LocalRecognitionResultBean\n*L\n49#1:139,3\n93#1:142,2\n*E\n"})
@Keep
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001&B\u001f\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J#\u0010\r\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010\u0012J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J#\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0011J\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fJ\u0006\u0010\u001c\u001a\u00020\fJ\t\u0010\u001d\u001a\u00020\fHÖ\u0001J\u0006\u0010\u001e\u001a\u00020\u0006J(\u0010\u001f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\fH\u0002J\u0006\u0010#\u001a\u00020$J\t\u0010%\u001a\u00020$HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/LocalRecognitionResultBean;", "", "pieceList", "Ljava/util/LinkedList;", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/LocalRecognitionResultBean$PieceBean;", "isEmptyFile", "", "(Ljava/util/LinkedList;Z)V", "()Z", "getPieceList", "()Ljava/util/LinkedList;", "splitIndexList", "", "binarySearch", "arr", "", "key", "", "([Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/LocalRecognitionResultBean$PieceBean;J)I", "component1", "component2", "copy", "equals", "other", "getIndexWithPlayPosition", "position", "getParagraph", "index", "getParagraphCount", "hashCode", "isAvailable", "recursionBinarySearch", "", "low", "high", "toContent", "", "toString", "PieceBean", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LocalRecognitionResultBean {
    private final boolean isEmptyFile;
    @NotNull
    private final LinkedList<PieceBean> pieceList;
    @NotNull
    private LinkedList<Integer> splitIndexList;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J;\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010$\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\bHÖ\u0001J\t\u0010'\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006("}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/LocalRecognitionResultBean$PieceBean;", "", "begin", "", "end", "content", "", "startIndex", "", "split", "", "(JJLjava/lang/String;IZ)V", "getBegin", "()J", "setBegin", "(J)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getEnd", "setEnd", "getSplit", "()Z", "setSplit", "(Z)V", "getStartIndex", "()I", "setStartIndex", "(I)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PieceBean {
        private long begin;
        @NotNull
        private String content;
        private long end;
        private boolean split;
        private int startIndex;

        public PieceBean() {
            this(0, 0, (String) null, 0, false, 31, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PieceBean copy$default(PieceBean pieceBean, long j, long j2, String str, int i, boolean z, int i2, Object obj) {
            PieceBean pieceBean2 = pieceBean;
            return pieceBean.copy((i2 & 1) != 0 ? pieceBean2.begin : j, (i2 & 2) != 0 ? pieceBean2.end : j2, (i2 & 4) != 0 ? pieceBean2.content : str, (i2 & 8) != 0 ? pieceBean2.startIndex : i, (i2 & 16) != 0 ? pieceBean2.split : z);
        }

        public final long component1() {
            return this.begin;
        }

        public final long component2() {
            return this.end;
        }

        @NotNull
        public final String component3() {
            return this.content;
        }

        public final int component4() {
            return this.startIndex;
        }

        public final boolean component5() {
            return this.split;
        }

        @NotNull
        public final PieceBean copy(long j, long j2, @NotNull String str, int i, boolean z) {
            Intrinsics.checkNotNullParameter(str, "content");
            return new PieceBean(j, j2, str, i, z);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PieceBean)) {
                return false;
            }
            PieceBean pieceBean = (PieceBean) obj;
            return this.begin == pieceBean.begin && this.end == pieceBean.end && Intrinsics.areEqual((Object) this.content, (Object) pieceBean.content) && this.startIndex == pieceBean.startIndex && this.split == pieceBean.split;
        }

        public final long getBegin() {
            return this.begin;
        }

        @NotNull
        public final String getContent() {
            return this.content;
        }

        public final long getEnd() {
            return this.end;
        }

        public final boolean getSplit() {
            return this.split;
        }

        public final int getStartIndex() {
            return this.startIndex;
        }

        public int hashCode() {
            return (((((((Long.hashCode(this.begin) * 31) + Long.hashCode(this.end)) * 31) + this.content.hashCode()) * 31) + Integer.hashCode(this.startIndex)) * 31) + Boolean.hashCode(this.split);
        }

        public final void setBegin(long j) {
            this.begin = j;
        }

        public final void setContent(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.content = str;
        }

        public final void setEnd(long j) {
            this.end = j;
        }

        public final void setSplit(boolean z) {
            this.split = z;
        }

        public final void setStartIndex(int i) {
            this.startIndex = i;
        }

        @NotNull
        public String toString() {
            long j = this.begin;
            long j2 = this.end;
            String str = this.content;
            int i = this.startIndex;
            boolean z = this.split;
            return "PieceBean(begin=" + j + ", end=" + j2 + ", content=" + str + ", startIndex=" + i + ", split=" + z + ")";
        }

        public PieceBean(long j, long j2, @NotNull String str, int i, boolean z) {
            Intrinsics.checkNotNullParameter(str, "content");
            this.begin = j;
            this.end = j2;
            this.content = str;
            this.startIndex = i;
            this.split = z;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PieceBean(long j, long j2, String str, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : j, (i2 & 2) != 0 ? 0 : j2, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? false : z);
        }
    }

    public LocalRecognitionResultBean() {
        this((LinkedList) null, false, 3, (DefaultConstructorMarker) null);
    }

    private final int binarySearch(PieceBean[] pieceBeanArr, long j) {
        int length = pieceBeanArr.length - 1;
        int i = -1;
        if (pieceBeanArr.length == 0) {
            return -1;
        }
        int i2 = 0;
        if (j < pieceBeanArr[0].getBegin() || j > pieceBeanArr[length].getEnd() || length < 0) {
            return -1;
        }
        while (i2 <= length) {
            i = (i2 + length) / 2;
            if (pieceBeanArr[i].getEnd() > j) {
                if (pieceBeanArr[i].getBegin() <= j) {
                    return i;
                }
                length = i - 1;
            } else if (pieceBeanArr[i].getBegin() >= j) {
                if (i > 0) {
                    int i3 = i - 1;
                    if (pieceBeanArr[i3].getEnd() < j && ((long) pieceBeanArr[i].getStartIndex()) > j) {
                        return Math.abs(pieceBeanArr[i3].getEnd() - j) > Math.abs(((long) pieceBeanArr[i].getStartIndex()) - j) ? i : i3;
                    }
                }
                if (i >= pieceBeanArr.length || pieceBeanArr[i].getEnd() >= j) {
                    return i;
                }
                int i4 = i + 1;
                return (((long) pieceBeanArr[i4].getStartIndex()) <= j || Math.abs(((long) pieceBeanArr[i4].getStartIndex()) - j) > Math.abs(pieceBeanArr[i].getEnd() - j)) ? i : i4;
            } else if (pieceBeanArr[i].getEnd() >= j) {
                return i;
            } else {
                i2 = i + 1;
            }
        }
        return i;
    }

    public static /* synthetic */ LocalRecognitionResultBean copy$default(LocalRecognitionResultBean localRecognitionResultBean, LinkedList<PieceBean> linkedList, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            linkedList = localRecognitionResultBean.pieceList;
        }
        if ((i & 2) != 0) {
            z = localRecognitionResultBean.isEmptyFile;
        }
        return localRecognitionResultBean.copy(linkedList, z);
    }

    private final int recursionBinarySearch(int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[i3];
        if (i > i4) {
            return i3 + 1;
        }
        if (i < iArr[i2] || i > i4 || i2 > i3) {
            return 0;
        }
        int i5 = (i2 + i3) / 2;
        int i6 = iArr[i5];
        return i6 > i ? (i5 <= 0 || iArr[i5 + -1] >= i) ? recursionBinarySearch(iArr, i, i2, i5 - 1) : i5 : i6 < i ? (i5 > ArraysKt.getLastIndex(iArr) || iArr[i5 + 1] <= i) ? recursionBinarySearch(iArr, i, i5 + 1, i3) : i5 : i5;
    }

    @NotNull
    public final LinkedList<PieceBean> component1() {
        return this.pieceList;
    }

    public final boolean component2() {
        return this.isEmptyFile;
    }

    @NotNull
    public final LocalRecognitionResultBean copy(@NotNull LinkedList<PieceBean> linkedList, boolean z) {
        Intrinsics.checkNotNullParameter(linkedList, "pieceList");
        return new LocalRecognitionResultBean(linkedList, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalRecognitionResultBean)) {
            return false;
        }
        LocalRecognitionResultBean localRecognitionResultBean = (LocalRecognitionResultBean) obj;
        return Intrinsics.areEqual((Object) this.pieceList, (Object) localRecognitionResultBean.pieceList) && this.isEmptyFile == localRecognitionResultBean.isEmptyFile;
    }

    public final int getIndexWithPlayPosition(long j) {
        return binarySearch((PieceBean[]) this.pieceList.toArray(new PieceBean[0]), j);
    }

    public final int getParagraph(int i) {
        if (this.splitIndexList.isEmpty()) {
            return 1;
        }
        return recursionBinarySearch(CollectionsKt.toIntArray(this.splitIndexList), i, 0, CollectionsKt.getLastIndex(this.splitIndexList));
    }

    public final int getParagraphCount() {
        return this.splitIndexList.size();
    }

    @NotNull
    public final LinkedList<PieceBean> getPieceList() {
        return this.pieceList;
    }

    public int hashCode() {
        return (this.pieceList.hashCode() * 31) + Boolean.hashCode(this.isEmptyFile);
    }

    public final boolean isAvailable() {
        return this.isEmptyFile || (this.pieceList.isEmpty() ^ true);
    }

    public final boolean isEmptyFile() {
        return this.isEmptyFile;
    }

    @NotNull
    public final String toContent() {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        for (T next : this.pieceList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            PieceBean pieceBean = (PieceBean) next;
            if (pieceBean.getSplit()) {
                this.splitIndexList.add(Integer.valueOf(i));
            }
            stringBuffer.append(pieceBean.getContent());
            i = i2;
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "toString(...)");
        return stringBuffer2;
    }

    @NotNull
    public String toString() {
        LinkedList<PieceBean> linkedList = this.pieceList;
        boolean z = this.isEmptyFile;
        return "LocalRecognitionResultBean(pieceList=" + linkedList + ", isEmptyFile=" + z + ")";
    }

    public LocalRecognitionResultBean(@NotNull LinkedList<PieceBean> linkedList, boolean z) {
        Intrinsics.checkNotNullParameter(linkedList, "pieceList");
        this.pieceList = linkedList;
        this.isEmptyFile = z;
        this.splitIndexList = new LinkedList<>();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocalRecognitionResultBean(LinkedList linkedList, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new LinkedList() : linkedList, (i & 2) != 0 ? false : z);
    }
}
