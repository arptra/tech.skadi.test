package com.upuphone.ar.tici.phone;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 TiciFileSearchActivity.kt\ncom/upuphone/ar/tici/phone/TiciFileSearchActivity\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 5 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n89#2,3:98\n92#2,2:103\n262#3,2:101\n71#4:105\n77#5:106\n*S KotlinDebug\n*F\n+ 1 TiciFileSearchActivity.kt\ncom/upuphone/ar/tici/phone/TiciFileSearchActivity\n*L\n91#1:101,2\n*E\n"})
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release", "androidx/core/widget/TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TiciFileSearchActivity$initViews$$inlined$doAfterTextChanged$1 implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TiciFileSearchActivity f5881a;

    public TiciFileSearchActivity$initViews$$inlined$doAfterTextChanged$1(TiciFileSearchActivity ticiFileSearchActivity) {
        this.f5881a = ticiFileSearchActivity;
    }

    public void afterTextChanged(Editable editable) {
        String obj = editable != null ? editable.toString() : null;
        CommonExtKt.b("afterTextChanged, text: " + editable, "TiciFileSearchActivity");
        ImageView imageView = this.f5881a.G0().h;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivSearchDelete");
        int i = 0;
        if (!(!(obj == null || obj.length() == 0))) {
            i = 8;
        }
        imageView.setVisibility(i);
        this.f5881a.P0();
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
