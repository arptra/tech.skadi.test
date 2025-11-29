package com.upuphone.ar.fastrecord.phone.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/widget/CopyEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onPasteCallback", "Lcom/upuphone/ar/fastrecord/phone/ui/widget/CopyEditText$OnPasteCallback;", "getOnPasteCallback", "()Lcom/upuphone/ar/fastrecord/phone/ui/widget/CopyEditText$OnPasteCallback;", "setOnPasteCallback", "(Lcom/upuphone/ar/fastrecord/phone/ui/widget/CopyEditText$OnPasteCallback;)V", "onTextContextMenuItem", "", "id", "", "OnPasteCallback", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SuppressLint({"AppCompatCustomView"})
public final class CopyEditText extends AppCompatEditText {
    @Nullable
    private OnPasteCallback onPasteCallback;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/widget/CopyEditText$OnPasteCallback;", "", "onCopy", "", "content", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnPasteCallback {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class DefaultImpls {
            public static /* synthetic */ boolean onCopy$default(OnPasteCallback onPasteCallback, String str, int i, Object obj) {
                if (obj == null) {
                    if ((i & 1) != 0) {
                        str = null;
                    }
                    return onPasteCallback.onCopy(str);
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCopy");
            }
        }

        boolean onCopy(@Nullable String str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CopyEditText(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Nullable
    public final OnPasteCallback getOnPasteCallback() {
        return this.onPasteCallback;
    }

    public boolean onTextContextMenuItem(int i) {
        OnPasteCallback onPasteCallback2;
        if (i == 16908321 && (onPasteCallback2 = this.onPasteCallback) != null) {
            OnPasteCallback.DefaultImpls.onCopy$default(onPasteCallback2, (String) null, 1, (Object) null);
        }
        return super.onTextContextMenuItem(i);
    }

    public final void setOnPasteCallback(@Nullable OnPasteCallback onPasteCallback2) {
        this.onPasteCallback = onPasteCallback2;
    }
}
