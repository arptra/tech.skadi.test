package com.upuphone.xr.sapp.utils;

import androidx.annotation.Keep;
import com.honey.account.view.web.WebJs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/upuphone/xr/sapp/utils/DialogResult;", "", "action", "Lcom/upuphone/xr/sapp/utils/DialogAction;", "(Lcom/upuphone/xr/sapp/utils/DialogAction;)V", "getAction", "()Lcom/upuphone/xr/sapp/utils/DialogAction;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public final class DialogResult {
    @NotNull
    private final DialogAction action;

    public DialogResult(@NotNull DialogAction dialogAction) {
        Intrinsics.checkNotNullParameter(dialogAction, WebJs.ACTION);
        this.action = dialogAction;
    }

    public static /* synthetic */ DialogResult copy$default(DialogResult dialogResult, DialogAction dialogAction, int i, Object obj) {
        if ((i & 1) != 0) {
            dialogAction = dialogResult.action;
        }
        return dialogResult.copy(dialogAction);
    }

    @NotNull
    public final DialogAction component1() {
        return this.action;
    }

    @NotNull
    public final DialogResult copy(@NotNull DialogAction dialogAction) {
        Intrinsics.checkNotNullParameter(dialogAction, WebJs.ACTION);
        return new DialogResult(dialogAction);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DialogResult) && this.action == ((DialogResult) obj).action;
    }

    @NotNull
    public final DialogAction getAction() {
        return this.action;
    }

    public int hashCode() {
        return this.action.hashCode();
    }

    @NotNull
    public String toString() {
        DialogAction dialogAction = this.action;
        return "DialogResult(action=" + dialogAction + ")";
    }
}
