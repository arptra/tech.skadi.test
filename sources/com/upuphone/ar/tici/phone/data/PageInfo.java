package com.upuphone.ar.tici.phone.data;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/upuphone/ar/tici/phone/data/PageInfo;", "", "page", "", "index", "(II)V", "getIndex", "()I", "getPage", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ar-tici_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class PageInfo {
    private final int index;
    private final int page;

    public PageInfo(int i, int i2) {
        this.page = i;
        this.index = i2;
    }

    public static /* synthetic */ PageInfo copy$default(PageInfo pageInfo, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = pageInfo.page;
        }
        if ((i3 & 2) != 0) {
            i2 = pageInfo.index;
        }
        return pageInfo.copy(i, i2);
    }

    public final int component1() {
        return this.page;
    }

    public final int component2() {
        return this.index;
    }

    @NotNull
    public final PageInfo copy(int i, int i2) {
        return new PageInfo(i, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PageInfo)) {
            return false;
        }
        PageInfo pageInfo = (PageInfo) obj;
        return this.page == pageInfo.page && this.index == pageInfo.index;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getPage() {
        return this.page;
    }

    public int hashCode() {
        return (Integer.hashCode(this.page) * 31) + Integer.hashCode(this.index);
    }

    @NotNull
    public String toString() {
        int i = this.page;
        int i2 = this.index;
        return "PageInfo(page=" + i + ", index=" + i2 + ")";
    }
}
