package com.upuphone.ar.tici.phone.db.entity;

import androidx.annotation.Keep;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.upuphone.ar.tici.phone.starrynet.msg.ParagraphItem;
import com.upuphone.ar.tici.phone.utils.StringExtKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b¢\u0006\u0002\u0010\u0010J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003Ji\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u000bHÖ\u0001J\u0006\u00100\u001a\u00020\u0006J\b\u00101\u001a\u00020\u0006H\u0016R\u0011\u0010\u000f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001a¨\u00062"}, d2 = {"Lcom/upuphone/ar/tici/phone/db/entity/TiciContentPart;", "", "id", "", "ticiId", "contentText", "", "paragraphIndexes", "", "Lcom/upuphone/ar/tici/phone/starrynet/msg/ParagraphItem;", "highlightIndex", "", "partSize", "partIndex", "contentOffsetStart", "contentOffsetEnd", "(JJLjava/lang/String;Ljava/util/List;IJIII)V", "getContentOffsetEnd", "()I", "getContentOffsetStart", "getContentText", "()Ljava/lang/String;", "getHighlightIndex", "setHighlightIndex", "(I)V", "getId", "()J", "getParagraphIndexes", "()Ljava/util/List;", "setParagraphIndexes", "(Ljava/util/List;)V", "getPartIndex", "getPartSize", "getTiciId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toSimpleString", "toString", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
@Entity
public final class TiciContentPart {
    private final int contentOffsetEnd;
    private final int contentOffsetStart;
    @NotNull
    private final String contentText;
    private int highlightIndex;
    @PrimaryKey
    private final long id;
    @ColumnInfo
    @NotNull
    private List<ParagraphItem> paragraphIndexes;
    private final int partIndex;
    private final long partSize;
    private final long ticiId;

    public TiciContentPart(long j, long j2, @NotNull String str, @NotNull List<ParagraphItem> list, int i, long j3, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "contentText");
        Intrinsics.checkNotNullParameter(list, "paragraphIndexes");
        this.id = j;
        this.ticiId = j2;
        this.contentText = str;
        this.paragraphIndexes = list;
        this.highlightIndex = i;
        this.partSize = j3;
        this.partIndex = i2;
        this.contentOffsetStart = i3;
        this.contentOffsetEnd = i4;
    }

    public static /* synthetic */ TiciContentPart copy$default(TiciContentPart ticiContentPart, long j, long j2, String str, List list, int i, long j3, int i2, int i3, int i4, int i5, Object obj) {
        TiciContentPart ticiContentPart2 = ticiContentPart;
        int i6 = i5;
        return ticiContentPart.copy((i6 & 1) != 0 ? ticiContentPart2.id : j, (i6 & 2) != 0 ? ticiContentPart2.ticiId : j2, (i6 & 4) != 0 ? ticiContentPart2.contentText : str, (i6 & 8) != 0 ? ticiContentPart2.paragraphIndexes : list, (i6 & 16) != 0 ? ticiContentPart2.highlightIndex : i, (i6 & 32) != 0 ? ticiContentPart2.partSize : j3, (i6 & 64) != 0 ? ticiContentPart2.partIndex : i2, (i6 & 128) != 0 ? ticiContentPart2.contentOffsetStart : i3, (i6 & 256) != 0 ? ticiContentPart2.contentOffsetEnd : i4);
    }

    public final long component1() {
        return this.id;
    }

    public final long component2() {
        return this.ticiId;
    }

    @NotNull
    public final String component3() {
        return this.contentText;
    }

    @NotNull
    public final List<ParagraphItem> component4() {
        return this.paragraphIndexes;
    }

    public final int component5() {
        return this.highlightIndex;
    }

    public final long component6() {
        return this.partSize;
    }

    public final int component7() {
        return this.partIndex;
    }

    public final int component8() {
        return this.contentOffsetStart;
    }

    public final int component9() {
        return this.contentOffsetEnd;
    }

    @NotNull
    public final TiciContentPart copy(long j, long j2, @NotNull String str, @NotNull List<ParagraphItem> list, int i, long j3, int i2, int i3, int i4) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "contentText");
        List<ParagraphItem> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "paragraphIndexes");
        return new TiciContentPart(j, j2, str2, list2, i, j3, i2, i3, i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TiciContentPart)) {
            return false;
        }
        TiciContentPart ticiContentPart = (TiciContentPart) obj;
        return this.id == ticiContentPart.id && this.ticiId == ticiContentPart.ticiId && Intrinsics.areEqual((Object) this.contentText, (Object) ticiContentPart.contentText) && Intrinsics.areEqual((Object) this.paragraphIndexes, (Object) ticiContentPart.paragraphIndexes) && this.highlightIndex == ticiContentPart.highlightIndex && this.partSize == ticiContentPart.partSize && this.partIndex == ticiContentPart.partIndex && this.contentOffsetStart == ticiContentPart.contentOffsetStart && this.contentOffsetEnd == ticiContentPart.contentOffsetEnd;
    }

    public final int getContentOffsetEnd() {
        return this.contentOffsetEnd;
    }

    public final int getContentOffsetStart() {
        return this.contentOffsetStart;
    }

    @NotNull
    public final String getContentText() {
        return this.contentText;
    }

    public final int getHighlightIndex() {
        return this.highlightIndex;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final List<ParagraphItem> getParagraphIndexes() {
        return this.paragraphIndexes;
    }

    public final int getPartIndex() {
        return this.partIndex;
    }

    public final long getPartSize() {
        return this.partSize;
    }

    public final long getTiciId() {
        return this.ticiId;
    }

    public int hashCode() {
        return (((((((((((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.ticiId)) * 31) + this.contentText.hashCode()) * 31) + this.paragraphIndexes.hashCode()) * 31) + Integer.hashCode(this.highlightIndex)) * 31) + Long.hashCode(this.partSize)) * 31) + Integer.hashCode(this.partIndex)) * 31) + Integer.hashCode(this.contentOffsetStart)) * 31) + Integer.hashCode(this.contentOffsetEnd);
    }

    public final void setHighlightIndex(int i) {
        this.highlightIndex = i;
    }

    public final void setParagraphIndexes(@NotNull List<ParagraphItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.paragraphIndexes = list;
    }

    @NotNull
    public final String toSimpleString() {
        long j = this.id;
        long j2 = this.ticiId;
        String j3 = StringExtKt.j(this.contentText, 50);
        int i = this.highlightIndex;
        long j4 = this.partSize;
        int i2 = this.partIndex;
        int i3 = this.contentOffsetStart;
        int i4 = this.contentOffsetEnd;
        int size = this.paragraphIndexes.size();
        return StringsKt.trimMargin$default("TiciContentPart(\n                |   id=" + j + ",\n                |   ticiId=" + j2 + ",\n                |   contentText='" + j3 + "',\n                |   highlightIndex=" + i + ",\n                |   partSize=" + j4 + ",\n                |   partIndex=" + i2 + ",\n                |   contentOffsetStart=" + i3 + ",\n                |   contentOffsetEnd=" + i4 + ",\n                |   paragraphIndexesSize='" + size + "',\n                |) ", (String) null, 1, (Object) null);
    }

    @NotNull
    public String toString() {
        long j = this.id;
        long j2 = this.ticiId;
        String str = this.contentText;
        int i = this.highlightIndex;
        long j3 = this.partSize;
        int i2 = this.partIndex;
        int i3 = this.contentOffsetStart;
        int i4 = this.contentOffsetEnd;
        List<ParagraphItem> list = this.paragraphIndexes;
        return StringsKt.trimMargin$default("TiciContentPart(\n                |   id=" + j + ",\n                |   ticiId=" + j2 + ",\n                |   contentText='" + str + "',\n                |   highlightIndex=" + i + ",\n                |   partSize=" + j3 + ",\n                |   partIndex=" + i2 + ",\n                |   contentOffsetStart=" + i3 + ",\n                |   contentOffsetEnd=" + i4 + ",\n                |   paragraphIndexes='" + list + "',\n                |) ", (String) null, 1, (Object) null);
    }
}
