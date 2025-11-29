package com.upuphone.ar.transcribe.phone.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J<\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\r¨\u0006$"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/bean/NoteDetailBean;", "", "id", "", "content", "", "ownerType", "", "timestamp", "(Ljava/lang/Long;Ljava/lang/String;ILjava/lang/String;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getOwnerType", "()I", "setOwnerType", "(I)V", "getTimestamp", "setTimestamp", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/String;ILjava/lang/String;)Lcom/upuphone/ar/transcribe/phone/bean/NoteDetailBean;", "equals", "", "other", "hashCode", "toString", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NoteDetailBean {
    @Nullable
    private String content;
    @Nullable
    private Long id;
    private int ownerType;
    @Nullable
    private String timestamp;

    public NoteDetailBean() {
        this((Long) null, (String) null, 0, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ NoteDetailBean copy$default(NoteDetailBean noteDetailBean, Long l, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            l = noteDetailBean.id;
        }
        if ((i2 & 2) != 0) {
            str = noteDetailBean.content;
        }
        if ((i2 & 4) != 0) {
            i = noteDetailBean.ownerType;
        }
        if ((i2 & 8) != 0) {
            str2 = noteDetailBean.timestamp;
        }
        return noteDetailBean.copy(l, str, i, str2);
    }

    @Nullable
    public final Long component1() {
        return this.id;
    }

    @Nullable
    public final String component2() {
        return this.content;
    }

    public final int component3() {
        return this.ownerType;
    }

    @Nullable
    public final String component4() {
        return this.timestamp;
    }

    @NotNull
    public final NoteDetailBean copy(@Nullable Long l, @Nullable String str, int i, @Nullable String str2) {
        return new NoteDetailBean(l, str, i, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NoteDetailBean)) {
            return false;
        }
        NoteDetailBean noteDetailBean = (NoteDetailBean) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) noteDetailBean.id) && Intrinsics.areEqual((Object) this.content, (Object) noteDetailBean.content) && this.ownerType == noteDetailBean.ownerType && Intrinsics.areEqual((Object) this.timestamp, (Object) noteDetailBean.timestamp);
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final Long getId() {
        return this.id;
    }

    public final int getOwnerType() {
        return this.ownerType;
    }

    @Nullable
    public final String getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        Long l = this.id;
        int i = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.content;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.ownerType)) * 31;
        String str2 = this.timestamp;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public final void setContent(@Nullable String str) {
        this.content = str;
    }

    public final void setId(@Nullable Long l) {
        this.id = l;
    }

    public final void setOwnerType(int i) {
        this.ownerType = i;
    }

    public final void setTimestamp(@Nullable String str) {
        this.timestamp = str;
    }

    @NotNull
    public String toString() {
        Long l = this.id;
        String str = this.content;
        int i = this.ownerType;
        String str2 = this.timestamp;
        return "NoteDetailBean(id=" + l + ", content=" + str + ", ownerType=" + i + ", timestamp=" + str2 + ")";
    }

    public NoteDetailBean(@Nullable Long l, @Nullable String str, int i, @Nullable String str2) {
        this.id = l;
        this.content = str;
        this.ownerType = i;
        this.timestamp = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NoteDetailBean(Long l, String str, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1L : l, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? 1 : i, (i2 & 8) != 0 ? null : str2);
    }
}
