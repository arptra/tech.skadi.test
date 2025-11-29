package com.upuphone.ar.transcribe.phone.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b$\b\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010-\u001a\u00020\u000fHÆ\u0003Jk\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010/\u001a\u00020\u000f2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0006HÖ\u0001J\t\u00102\u001a\u00020\u000bHÖ\u0001R\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00063"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/bean/ListItemBean;", "", "id", "", "recordTime", "type", "", "title", "", "content", "content2", "", "messageId", "simpleLocation", "isSelected", "", "(JJILjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/String;JLjava/lang/String;Z)V", "getContent", "()Ljava/lang/CharSequence;", "setContent", "(Ljava/lang/CharSequence;)V", "getContent2", "()Ljava/lang/String;", "setContent2", "(Ljava/lang/String;)V", "getId", "()J", "()Z", "setSelected", "(Z)V", "getMessageId", "getRecordTime", "getSimpleLocation", "getTitle", "setTitle", "getType", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ListItemBean {
    @Nullable
    private CharSequence content;
    @Nullable
    private String content2;
    private final long id;
    private boolean isSelected;
    private final long messageId;
    private final long recordTime;
    @Nullable
    private final String simpleLocation;
    @Nullable
    private CharSequence title;
    private final int type;

    public ListItemBean(long j, long j2, int i, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable String str, long j3, @Nullable String str2, boolean z) {
        this.id = j;
        this.recordTime = j2;
        this.type = i;
        this.title = charSequence;
        this.content = charSequence2;
        this.content2 = str;
        this.messageId = j3;
        this.simpleLocation = str2;
        this.isSelected = z;
    }

    public static /* synthetic */ ListItemBean copy$default(ListItemBean listItemBean, long j, long j2, int i, CharSequence charSequence, CharSequence charSequence2, String str, long j3, String str2, boolean z, int i2, Object obj) {
        ListItemBean listItemBean2 = listItemBean;
        int i3 = i2;
        return listItemBean.copy((i3 & 1) != 0 ? listItemBean2.id : j, (i3 & 2) != 0 ? listItemBean2.recordTime : j2, (i3 & 4) != 0 ? listItemBean2.type : i, (i3 & 8) != 0 ? listItemBean2.title : charSequence, (i3 & 16) != 0 ? listItemBean2.content : charSequence2, (i3 & 32) != 0 ? listItemBean2.content2 : str, (i3 & 64) != 0 ? listItemBean2.messageId : j3, (i3 & 128) != 0 ? listItemBean2.simpleLocation : str2, (i3 & 256) != 0 ? listItemBean2.isSelected : z);
    }

    public final long component1() {
        return this.id;
    }

    public final long component2() {
        return this.recordTime;
    }

    public final int component3() {
        return this.type;
    }

    @Nullable
    public final CharSequence component4() {
        return this.title;
    }

    @Nullable
    public final CharSequence component5() {
        return this.content;
    }

    @Nullable
    public final String component6() {
        return this.content2;
    }

    public final long component7() {
        return this.messageId;
    }

    @Nullable
    public final String component8() {
        return this.simpleLocation;
    }

    public final boolean component9() {
        return this.isSelected;
    }

    @NotNull
    public final ListItemBean copy(long j, long j2, int i, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable String str, long j3, @Nullable String str2, boolean z) {
        return new ListItemBean(j, j2, i, charSequence, charSequence2, str, j3, str2, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListItemBean)) {
            return false;
        }
        ListItemBean listItemBean = (ListItemBean) obj;
        return this.id == listItemBean.id && this.recordTime == listItemBean.recordTime && this.type == listItemBean.type && Intrinsics.areEqual((Object) this.title, (Object) listItemBean.title) && Intrinsics.areEqual((Object) this.content, (Object) listItemBean.content) && Intrinsics.areEqual((Object) this.content2, (Object) listItemBean.content2) && this.messageId == listItemBean.messageId && Intrinsics.areEqual((Object) this.simpleLocation, (Object) listItemBean.simpleLocation) && this.isSelected == listItemBean.isSelected;
    }

    @Nullable
    public final CharSequence getContent() {
        return this.content;
    }

    @Nullable
    public final String getContent2() {
        return this.content2;
    }

    public final long getId() {
        return this.id;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final long getRecordTime() {
        return this.recordTime;
    }

    @Nullable
    public final String getSimpleLocation() {
        return this.simpleLocation;
    }

    @Nullable
    public final CharSequence getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = ((((Long.hashCode(this.id) * 31) + Long.hashCode(this.recordTime)) * 31) + Integer.hashCode(this.type)) * 31;
        CharSequence charSequence = this.title;
        int i = 0;
        int hashCode2 = (hashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
        CharSequence charSequence2 = this.content;
        int hashCode3 = (hashCode2 + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
        String str = this.content2;
        int hashCode4 = (((hashCode3 + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.messageId)) * 31;
        String str2 = this.simpleLocation;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode4 + i) * 31) + Boolean.hashCode(this.isSelected);
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setContent(@Nullable CharSequence charSequence) {
        this.content = charSequence;
    }

    public final void setContent2(@Nullable String str) {
        this.content2 = str;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final void setTitle(@Nullable CharSequence charSequence) {
        this.title = charSequence;
    }

    @NotNull
    public String toString() {
        long j = this.id;
        long j2 = this.recordTime;
        int i = this.type;
        CharSequence charSequence = this.title;
        CharSequence charSequence2 = this.content;
        String str = this.content2;
        long j3 = this.messageId;
        String str2 = this.simpleLocation;
        boolean z = this.isSelected;
        return "ListItemBean(id=" + j + ", recordTime=" + j2 + ", type=" + i + ", title=" + charSequence + ", content=" + charSequence2 + ", content2=" + str + ", messageId=" + j3 + ", simpleLocation=" + str2 + ", isSelected=" + z + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ListItemBean(long j, long j2, int i, CharSequence charSequence, CharSequence charSequence2, String str, long j3, String str2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, i, charSequence, charSequence2, str, j3, str2, (i2 & 256) != 0 ? false : z);
    }
}
