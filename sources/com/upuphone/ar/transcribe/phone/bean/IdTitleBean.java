package com.upuphone.ar.transcribe.phone.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/bean/IdTitleBean;", "", "id", "", "superTitle", "", "(Ljava/lang/Long;Ljava/lang/String;)V", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getSuperTitle", "()Ljava/lang/String;", "setSuperTitle", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/String;)Lcom/upuphone/ar/transcribe/phone/bean/IdTitleBean;", "equals", "", "other", "hashCode", "", "toString", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class IdTitleBean {
    @Nullable
    private Long id;
    @Nullable
    private String superTitle;

    public IdTitleBean(@Nullable Long l, @Nullable String str) {
        this.id = l;
        this.superTitle = str;
    }

    public static /* synthetic */ IdTitleBean copy$default(IdTitleBean idTitleBean, Long l, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            l = idTitleBean.id;
        }
        if ((i & 2) != 0) {
            str = idTitleBean.superTitle;
        }
        return idTitleBean.copy(l, str);
    }

    @Nullable
    public final Long component1() {
        return this.id;
    }

    @Nullable
    public final String component2() {
        return this.superTitle;
    }

    @NotNull
    public final IdTitleBean copy(@Nullable Long l, @Nullable String str) {
        return new IdTitleBean(l, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IdTitleBean)) {
            return false;
        }
        IdTitleBean idTitleBean = (IdTitleBean) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) idTitleBean.id) && Intrinsics.areEqual((Object) this.superTitle, (Object) idTitleBean.superTitle);
    }

    @Nullable
    public final Long getId() {
        return this.id;
    }

    @Nullable
    public final String getSuperTitle() {
        return this.superTitle;
    }

    public int hashCode() {
        Long l = this.id;
        int i = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.superTitle;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public final void setId(@Nullable Long l) {
        this.id = l;
    }

    public final void setSuperTitle(@Nullable String str) {
        this.superTitle = str;
    }

    @NotNull
    public String toString() {
        Long l = this.id;
        String str = this.superTitle;
        return "IdTitleBean(id=" + l + ", superTitle=" + str + ")";
    }
}
