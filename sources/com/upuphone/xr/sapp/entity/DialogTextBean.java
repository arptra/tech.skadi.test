package com.upuphone.xr.sapp.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/upuphone/xr/sapp/entity/DialogTextBean;", "", "title", "", "content", "confirmText", "refuseText", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getConfirmText", "()Ljava/lang/String;", "getContent", "getRefuseText", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DialogTextBean {
    @NotNull
    private final String confirmText;
    @NotNull
    private final String content;
    @NotNull
    private final String refuseText;
    @NotNull
    private final String title;

    public DialogTextBean(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "content");
        Intrinsics.checkNotNullParameter(str3, "confirmText");
        Intrinsics.checkNotNullParameter(str4, "refuseText");
        this.title = str;
        this.content = str2;
        this.confirmText = str3;
        this.refuseText = str4;
    }

    public static /* synthetic */ DialogTextBean copy$default(DialogTextBean dialogTextBean, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dialogTextBean.title;
        }
        if ((i & 2) != 0) {
            str2 = dialogTextBean.content;
        }
        if ((i & 4) != 0) {
            str3 = dialogTextBean.confirmText;
        }
        if ((i & 8) != 0) {
            str4 = dialogTextBean.refuseText;
        }
        return dialogTextBean.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.content;
    }

    @NotNull
    public final String component3() {
        return this.confirmText;
    }

    @NotNull
    public final String component4() {
        return this.refuseText;
    }

    @NotNull
    public final DialogTextBean copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "content");
        Intrinsics.checkNotNullParameter(str3, "confirmText");
        Intrinsics.checkNotNullParameter(str4, "refuseText");
        return new DialogTextBean(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DialogTextBean)) {
            return false;
        }
        DialogTextBean dialogTextBean = (DialogTextBean) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) dialogTextBean.title) && Intrinsics.areEqual((Object) this.content, (Object) dialogTextBean.content) && Intrinsics.areEqual((Object) this.confirmText, (Object) dialogTextBean.confirmText) && Intrinsics.areEqual((Object) this.refuseText, (Object) dialogTextBean.refuseText);
    }

    @NotNull
    public final String getConfirmText() {
        return this.confirmText;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final String getRefuseText() {
        return this.refuseText;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.content.hashCode()) * 31) + this.confirmText.hashCode()) * 31) + this.refuseText.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.content;
        String str3 = this.confirmText;
        String str4 = this.refuseText;
        return "DialogTextBean(title=" + str + ", content=" + str2 + ", confirmText=" + str3 + ", refuseText=" + str4 + ")";
    }
}
