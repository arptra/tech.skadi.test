package com.upuphone.xr.sapp.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/upuphone/xr/sapp/view/MultiFuncEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/upuphone/xr/sapp/view/MultiFuncEditText$OnEditTextCopiedListener;", "listener", "", "setOnCopiedListener", "(Lcom/upuphone/xr/sapp/view/MultiFuncEditText$OnEditTextCopiedListener;)V", "id", "", "onTextContextMenuItem", "(I)Z", "a", "Lcom/upuphone/xr/sapp/view/MultiFuncEditText$OnEditTextCopiedListener;", "onEditTextCopiedListener", "EmojiExcludeFilter", "OnEditTextCopiedListener", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class MultiFuncEditText extends AppCompatEditText {

    /* renamed from: a  reason: collision with root package name */
    public OnEditTextCopiedListener f7977a;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/sapp/view/MultiFuncEditText$EmojiExcludeFilter;", "Landroid/text/InputFilter;", "()V", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class EmojiExcludeFilter implements InputFilter {
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            Intrinsics.checkNotNullParameter(charSequence, "source");
            while (i < i2) {
                int type = Character.getType(charSequence.charAt(i));
                if (type == 19 || type == 28) {
                    return "";
                }
                i++;
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/view/MultiFuncEditText$OnEditTextCopiedListener;", "", "", "a", "()V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface OnEditTextCopiedListener {
        void a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiFuncEditText(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setFilters((InputFilter[]) new EmojiExcludeFilter[]{new EmojiExcludeFilter()});
    }

    public boolean onTextContextMenuItem(int i) {
        OnEditTextCopiedListener onEditTextCopiedListener;
        if (i == 16908321 && (onEditTextCopiedListener = this.f7977a) != null) {
            onEditTextCopiedListener.a();
        }
        return super.onTextContextMenuItem(i);
    }

    public final void setOnCopiedListener(@NotNull OnEditTextCopiedListener onEditTextCopiedListener) {
        Intrinsics.checkNotNullParameter(onEditTextCopiedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f7977a = onEditTextCopiedListener;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiFuncEditText(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        setFilters((InputFilter[]) new EmojiExcludeFilter[]{new EmojiExcludeFilter()});
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiFuncEditText(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        setFilters((InputFilter[]) new EmojiExcludeFilter[]{new EmojiExcludeFilter()});
    }
}
