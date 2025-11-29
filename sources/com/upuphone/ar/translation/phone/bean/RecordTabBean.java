package com.upuphone.ar.translation.phone.bean;

import com.upuphone.ar.translation.phone.fragment.TransRecordFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/upuphone/ar/translation/phone/bean/RecordTabBean;", "", "tabName", "", "tabType", "fragment", "Lcom/upuphone/ar/translation/phone/fragment/TransRecordFragment;", "(Ljava/lang/String;Ljava/lang/String;Lcom/upuphone/ar/translation/phone/fragment/TransRecordFragment;)V", "getFragment", "()Lcom/upuphone/ar/translation/phone/fragment/TransRecordFragment;", "getTabName", "()Ljava/lang/String;", "setTabName", "(Ljava/lang/String;)V", "getTabType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecordTabBean {
    @NotNull
    private final TransRecordFragment fragment;
    @NotNull
    private String tabName;
    @NotNull
    private final String tabType;

    public RecordTabBean(@NotNull String str, @NotNull String str2, @NotNull TransRecordFragment transRecordFragment) {
        Intrinsics.checkNotNullParameter(str, "tabName");
        Intrinsics.checkNotNullParameter(str2, "tabType");
        Intrinsics.checkNotNullParameter(transRecordFragment, "fragment");
        this.tabName = str;
        this.tabType = str2;
        this.fragment = transRecordFragment;
    }

    public static /* synthetic */ RecordTabBean copy$default(RecordTabBean recordTabBean, String str, String str2, TransRecordFragment transRecordFragment, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recordTabBean.tabName;
        }
        if ((i & 2) != 0) {
            str2 = recordTabBean.tabType;
        }
        if ((i & 4) != 0) {
            transRecordFragment = recordTabBean.fragment;
        }
        return recordTabBean.copy(str, str2, transRecordFragment);
    }

    @NotNull
    public final String component1() {
        return this.tabName;
    }

    @NotNull
    public final String component2() {
        return this.tabType;
    }

    @NotNull
    public final TransRecordFragment component3() {
        return this.fragment;
    }

    @NotNull
    public final RecordTabBean copy(@NotNull String str, @NotNull String str2, @NotNull TransRecordFragment transRecordFragment) {
        Intrinsics.checkNotNullParameter(str, "tabName");
        Intrinsics.checkNotNullParameter(str2, "tabType");
        Intrinsics.checkNotNullParameter(transRecordFragment, "fragment");
        return new RecordTabBean(str, str2, transRecordFragment);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordTabBean)) {
            return false;
        }
        RecordTabBean recordTabBean = (RecordTabBean) obj;
        return Intrinsics.areEqual((Object) this.tabName, (Object) recordTabBean.tabName) && Intrinsics.areEqual((Object) this.tabType, (Object) recordTabBean.tabType) && Intrinsics.areEqual((Object) this.fragment, (Object) recordTabBean.fragment);
    }

    @NotNull
    public final TransRecordFragment getFragment() {
        return this.fragment;
    }

    @NotNull
    public final String getTabName() {
        return this.tabName;
    }

    @NotNull
    public final String getTabType() {
        return this.tabType;
    }

    public int hashCode() {
        return (((this.tabName.hashCode() * 31) + this.tabType.hashCode()) * 31) + this.fragment.hashCode();
    }

    public final void setTabName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tabName = str;
    }

    @NotNull
    public String toString() {
        String str = this.tabName;
        String str2 = this.tabType;
        TransRecordFragment transRecordFragment = this.fragment;
        return "RecordTabBean(tabName=" + str + ", tabType=" + str2 + ", fragment=" + transRecordFragment + ")";
    }
}
