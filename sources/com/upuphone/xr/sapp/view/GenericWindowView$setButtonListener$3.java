package com.upuphone.xr.sapp.view;

import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.view.DrawableEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nGenericWindowView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GenericWindowView.kt\ncom/upuphone/xr/sapp/view/GenericWindowView$setButtonListener$3\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,2045:1\n256#2,2:2046\n*S KotlinDebug\n*F\n+ 1 GenericWindowView.kt\ncom/upuphone/xr/sapp/view/GenericWindowView$setButtonListener$3\n*L\n1641#1:2046,2\n*E\n"})
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/upuphone/xr/sapp/view/GenericWindowView$setButtonListener$3", "Lcom/upuphone/xr/sapp/view/DrawableEditText$OnDrawableClickListener;", "", "direction", "Lcom/upuphone/xr/sapp/view/DrawableEditText;", "editText", "", "a", "(ILcom/upuphone/xr/sapp/view/DrawableEditText;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class GenericWindowView$setButtonListener$3 implements DrawableEditText.OnDrawableClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GenericWindowView f7963a;

    public GenericWindowView$setButtonListener$3(GenericWindowView genericWindowView) {
        this.f7963a = genericWindowView;
    }

    public void a(int i, DrawableEditText drawableEditText) {
        Intrinsics.checkNotNullParameter(drawableEditText, "editText");
        this.f7963a.d.w.setText("");
        TextView textView = this.f7963a.d.x;
        Intrinsics.checkNotNullExpressionValue(textView, "editInputLen");
        textView.setVisibility(8);
        this.f7963a.d.w.setBackground(ContextCompat.getDrawable(this.f7963a.getContext(), R.drawable.common_edit_bg));
    }
}
