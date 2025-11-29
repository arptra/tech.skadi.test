package com.upuphone.ar.tici.phone.db.entity;

import androidx.annotation.Keep;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.upuphone.ar.tici.phone.starrynet.msg.ParagraphItem;
import com.upuphone.ar.tici.phone.utils.StringExtKt;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\bA\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000b¢\u0006\u0002\u0010\u0015J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u000bHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u000bHÆ\u0003J\t\u0010@\u001a\u00020\u000bHÆ\u0003J\t\u0010A\u001a\u00020\u000bHÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\u000f\u0010D\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010E\u001a\u00020\u000bHÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010#J¤\u0001\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010KJ\u0013\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010O\u001a\u00020\u000bHÖ\u0001J\u0006\u0010P\u001a\u00020\u0005J\b\u0010Q\u001a\u00020\u0005H\u0016R\u001e\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001d\"\u0004\b&\u0010\u001fR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R\u001a\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001d\"\u0004\b*\u0010\u001fR\u001a\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001d\"\u0004\b,\u0010\u001fR*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010.\u001a\u0004\b4\u0010\u001bR\u001e\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0017\"\u0004\b6\u0010\u0019R\u001e\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0017\"\u0004\b8\u0010\u0019R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001b\"\u0004\b:\u0010;¨\u0006R"}, d2 = {"Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "", "id", "", "fileName", "", "sourceText", "paragraphIndexes", "", "Lcom/upuphone/ar/tici/phone/starrynet/msg/ParagraphItem;", "index", "", "fileSize", "lastShowTime", "lastModified", "fileType", "fileStatus", "userId", "currentPage", "totalPage", "totalTextLength", "(JLjava/lang/String;Ljava/lang/String;Ljava/util/List;IJJJLjava/lang/Integer;ILjava/lang/String;III)V", "getCurrentPage", "()I", "setCurrentPage", "(I)V", "getFileName", "()Ljava/lang/String;", "getFileSize", "()J", "setFileSize", "(J)V", "getFileStatus", "setFileStatus", "getFileType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "setId", "getIndex", "setIndex", "getLastModified", "setLastModified", "getLastShowTime", "setLastShowTime", "getParagraphIndexes$annotations", "()V", "getParagraphIndexes", "()Ljava/util/List;", "setParagraphIndexes", "(Ljava/util/List;)V", "getSourceText$annotations", "getSourceText", "getTotalPage", "setTotalPage", "getTotalTextLength", "setTotalTextLength", "getUserId", "setUserId", "(Ljava/lang/String;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/util/List;IJJJLjava/lang/Integer;ILjava/lang/String;III)Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "equals", "", "other", "hashCode", "toSimpleString", "toString", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
@Entity
public final class TiciEntity {
    @ColumnInfo
    private int currentPage;
    @NotNull
    private final String fileName;
    private long fileSize;
    private int fileStatus;
    @Nullable
    private final Integer fileType;
    @PrimaryKey
    private long id;
    private int index;
    private long lastModified;
    private long lastShowTime;
    @ColumnInfo
    @NotNull
    private List<ParagraphItem> paragraphIndexes;
    @NotNull
    private final String sourceText;
    @ColumnInfo
    private int totalPage;
    @ColumnInfo
    private int totalTextLength;
    @Nullable
    private String userId;

    public TiciEntity(long j, @NotNull String str, @NotNull String str2, @NotNull List<ParagraphItem> list, int i, long j2, long j3, long j4, @Nullable Integer num, int i2, @Nullable String str3, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        Intrinsics.checkNotNullParameter(str2, "sourceText");
        Intrinsics.checkNotNullParameter(list, "paragraphIndexes");
        this.id = j;
        this.fileName = str;
        this.sourceText = str2;
        this.paragraphIndexes = list;
        this.index = i;
        this.fileSize = j2;
        this.lastShowTime = j3;
        this.lastModified = j4;
        this.fileType = num;
        this.fileStatus = i2;
        this.userId = str3;
        this.currentPage = i3;
        this.totalPage = i4;
        this.totalTextLength = i5;
    }

    public static /* synthetic */ TiciEntity copy$default(TiciEntity ticiEntity, long j, String str, String str2, List list, int i, long j2, long j3, long j4, Integer num, int i2, String str3, int i3, int i4, int i5, int i6, Object obj) {
        TiciEntity ticiEntity2 = ticiEntity;
        int i7 = i6;
        return ticiEntity.copy((i7 & 1) != 0 ? ticiEntity2.id : j, (i7 & 2) != 0 ? ticiEntity2.fileName : str, (i7 & 4) != 0 ? ticiEntity2.sourceText : str2, (i7 & 8) != 0 ? ticiEntity2.paragraphIndexes : list, (i7 & 16) != 0 ? ticiEntity2.index : i, (i7 & 32) != 0 ? ticiEntity2.fileSize : j2, (i7 & 64) != 0 ? ticiEntity2.lastShowTime : j3, (i7 & 128) != 0 ? ticiEntity2.lastModified : j4, (i7 & 256) != 0 ? ticiEntity2.fileType : num, (i7 & 512) != 0 ? ticiEntity2.fileStatus : i2, (i7 & 1024) != 0 ? ticiEntity2.userId : str3, (i7 & 2048) != 0 ? ticiEntity2.currentPage : i3, (i7 & 4096) != 0 ? ticiEntity2.totalPage : i4, (i7 & 8192) != 0 ? ticiEntity2.totalTextLength : i5);
    }

    @Deprecated(message = "已废弃，不再使用")
    public static /* synthetic */ void getParagraphIndexes$annotations() {
    }

    @Deprecated(message = "已废弃，不再使用")
    public static /* synthetic */ void getSourceText$annotations() {
    }

    public final long component1() {
        return this.id;
    }

    public final int component10() {
        return this.fileStatus;
    }

    @Nullable
    public final String component11() {
        return this.userId;
    }

    public final int component12() {
        return this.currentPage;
    }

    public final int component13() {
        return this.totalPage;
    }

    public final int component14() {
        return this.totalTextLength;
    }

    @NotNull
    public final String component2() {
        return this.fileName;
    }

    @NotNull
    public final String component3() {
        return this.sourceText;
    }

    @NotNull
    public final List<ParagraphItem> component4() {
        return this.paragraphIndexes;
    }

    public final int component5() {
        return this.index;
    }

    public final long component6() {
        return this.fileSize;
    }

    public final long component7() {
        return this.lastShowTime;
    }

    public final long component8() {
        return this.lastModified;
    }

    @Nullable
    public final Integer component9() {
        return this.fileType;
    }

    @NotNull
    public final TiciEntity copy(long j, @NotNull String str, @NotNull String str2, @NotNull List<ParagraphItem> list, int i, long j2, long j3, long j4, @Nullable Integer num, int i2, @Nullable String str3, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        Intrinsics.checkNotNullParameter(str2, "sourceText");
        Intrinsics.checkNotNullParameter(list, "paragraphIndexes");
        return new TiciEntity(j, str, str2, list, i, j2, j3, j4, num, i2, str3, i3, i4, i5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TiciEntity)) {
            return false;
        }
        TiciEntity ticiEntity = (TiciEntity) obj;
        return this.id == ticiEntity.id && Intrinsics.areEqual((Object) this.fileName, (Object) ticiEntity.fileName) && Intrinsics.areEqual((Object) this.sourceText, (Object) ticiEntity.sourceText) && Intrinsics.areEqual((Object) this.paragraphIndexes, (Object) ticiEntity.paragraphIndexes) && this.index == ticiEntity.index && this.fileSize == ticiEntity.fileSize && this.lastShowTime == ticiEntity.lastShowTime && this.lastModified == ticiEntity.lastModified && Intrinsics.areEqual((Object) this.fileType, (Object) ticiEntity.fileType) && this.fileStatus == ticiEntity.fileStatus && Intrinsics.areEqual((Object) this.userId, (Object) ticiEntity.userId) && this.currentPage == ticiEntity.currentPage && this.totalPage == ticiEntity.totalPage && this.totalTextLength == ticiEntity.totalTextLength;
    }

    public final int getCurrentPage() {
        return this.currentPage;
    }

    @NotNull
    public final String getFileName() {
        return this.fileName;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final int getFileStatus() {
        return this.fileStatus;
    }

    @Nullable
    public final Integer getFileType() {
        return this.fileType;
    }

    public final long getId() {
        return this.id;
    }

    public final int getIndex() {
        return this.index;
    }

    public final long getLastModified() {
        return this.lastModified;
    }

    public final long getLastShowTime() {
        return this.lastShowTime;
    }

    @NotNull
    public final List<ParagraphItem> getParagraphIndexes() {
        return this.paragraphIndexes;
    }

    @NotNull
    public final String getSourceText() {
        return this.sourceText;
    }

    public final int getTotalPage() {
        return this.totalPage;
    }

    public final int getTotalTextLength() {
        return this.totalTextLength;
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((Long.hashCode(this.id) * 31) + this.fileName.hashCode()) * 31) + this.sourceText.hashCode()) * 31) + this.paragraphIndexes.hashCode()) * 31) + Integer.hashCode(this.index)) * 31) + Long.hashCode(this.fileSize)) * 31) + Long.hashCode(this.lastShowTime)) * 31) + Long.hashCode(this.lastModified)) * 31;
        Integer num = this.fileType;
        int i = 0;
        int hashCode2 = (((hashCode + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.fileStatus)) * 31;
        String str = this.userId;
        if (str != null) {
            i = str.hashCode();
        }
        return ((((((hashCode2 + i) * 31) + Integer.hashCode(this.currentPage)) * 31) + Integer.hashCode(this.totalPage)) * 31) + Integer.hashCode(this.totalTextLength);
    }

    public final void setCurrentPage(int i) {
        this.currentPage = i;
    }

    public final void setFileSize(long j) {
        this.fileSize = j;
    }

    public final void setFileStatus(int i) {
        this.fileStatus = i;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final void setLastModified(long j) {
        this.lastModified = j;
    }

    public final void setLastShowTime(long j) {
        this.lastShowTime = j;
    }

    public final void setParagraphIndexes(@NotNull List<ParagraphItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.paragraphIndexes = list;
    }

    public final void setTotalPage(int i) {
        this.totalPage = i;
    }

    public final void setTotalTextLength(int i) {
        this.totalTextLength = i;
    }

    public final void setUserId(@Nullable String str) {
        this.userId = str;
    }

    @NotNull
    public final String toSimpleString() {
        long j = this.id;
        String str = this.fileName;
        int i = this.index;
        long j2 = this.lastShowTime;
        long j3 = this.fileSize;
        long j4 = this.lastModified;
        Integer num = this.fileType;
        int i2 = this.fileStatus;
        String str2 = this.userId;
        int i3 = this.currentPage;
        int i4 = this.totalPage;
        int i5 = this.totalTextLength;
        int length = this.sourceText.length();
        String j5 = StringExtKt.j(this.sourceText, 50);
        return StringsKt.trimMargin$default("TiciEntity(\n                |   id=" + j + ",\n                |   fileName='" + str + "',\n                |   index=" + i + ",\n                |   lastShowTime=" + j2 + ",\n                |   fileSize=" + j3 + ",\n                |   lastModified=" + j4 + ",\n                |   fileType=" + num + ",\n                |   fileStatus=" + i2 + ",\n                |   userId='" + str2 + "',\n                |   currentPage=" + i3 + ",\n                |   totalPage=" + i4 + ",\n                |   totalTextLength=" + i5 + ",\n                |   sourceTextLength=" + length + ",\n                |   sourceText='" + j5 + "',\n                |) ", (String) null, 1, (Object) null);
    }

    @NotNull
    public String toString() {
        long j = this.id;
        String str = this.fileName;
        int i = this.index;
        long j2 = this.lastShowTime;
        long j3 = this.fileSize;
        long j4 = this.lastModified;
        Integer num = this.fileType;
        int i2 = this.fileStatus;
        String str2 = this.userId;
        int i3 = this.currentPage;
        int i4 = this.totalPage;
        int i5 = this.totalTextLength;
        List<ParagraphItem> list = this.paragraphIndexes;
        String str3 = this.sourceText;
        return StringsKt.trimMargin$default("TiciEntity(\n                |   id=" + j + ",\n                |   fileName='" + str + "',\n                |   index=" + i + ",\n                |   lastShowTime=" + j2 + ",\n                |   fileSize=" + j3 + ",\n                |   lastModified=" + j4 + ",\n                |   fileType=" + num + ",\n                |   fileStatus=" + i2 + ",\n                |   userId='" + str2 + "',\n                |   currentPage=" + i3 + ",\n                |   totalPage=" + i4 + ",\n                |   totalTextLength=" + i5 + ",\n                |   paragraphIndexes='" + list + "',\n                |   sourceText='" + str3 + "',\n                |) ", (String) null, 1, (Object) null);
    }
}
