package com.upuphone.ar.fastrecord.phone.ui.fragment;

import com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordDrawableEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordFragment$showChangeNameDialog$3$3", "Lcom/upuphone/ar/fastrecord/phone/ui/widget/FastRecordDrawableEditText$OnDrawableClickListener;", "onDrawableClick", "", "direction", "", "editText", "Lcom/upuphone/ar/fastrecord/phone/ui/widget/FastRecordDrawableEditText;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordFragment$showChangeNameDialog$3$3 implements FastRecordDrawableEditText.OnDrawableClickListener {
    final /* synthetic */ Ref.ObjectRef<FastRecordDrawableEditText> $inputValueEdt;

    public FastRecordFragment$showChangeNameDialog$3$3(Ref.ObjectRef<FastRecordDrawableEditText> objectRef) {
        this.$inputValueEdt = objectRef;
    }

    public void onDrawableClick(int i, @NotNull FastRecordDrawableEditText fastRecordDrawableEditText) {
        Intrinsics.checkNotNullParameter(fastRecordDrawableEditText, "editText");
        FastRecordDrawableEditText fastRecordDrawableEditText2 = (FastRecordDrawableEditText) this.$inputValueEdt.element;
        if (fastRecordDrawableEditText2 != null) {
            fastRecordDrawableEditText2.setText("");
        }
    }
}
