package com.upuphone.xr.sapp.view;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nGenericWindowView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GenericWindowView.kt\ncom/upuphone/xr/sapp/view/GenericWindowView$setButtonListener$4\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,2045:1\n1183#2,3:2046\n*S KotlinDebug\n*F\n+ 1 GenericWindowView.kt\ncom/upuphone/xr/sapp/view/GenericWindowView$setButtonListener$4\n*L\n1670#1:2046,3\n*E\n"})
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/upuphone/xr/sapp/view/GenericWindowView$setButtonListener$4", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GenericWindowView$setButtonListener$4 implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GenericWindowView f7964a;

    public GenericWindowView$setButtonListener$4(GenericWindowView genericWindowView) {
        this.f7964a = genericWindowView;
    }

    public void afterTextChanged(Editable editable) {
        this.f7964a.e = String.valueOf(editable);
        boolean z = false;
        this.f7964a.d.u0.n(false);
        if (editable == null || editable.length() == 0) {
            this.f7964a.d.f.setEnabled(false);
        } else if (editable.length() > 0) {
            int i = 0;
            int i2 = 0;
            while (i < editable.length()) {
                char charAt = editable.charAt(i);
                int i3 = i2 + 1;
                if (Intrinsics.compare((int) charAt, 19968) >= 0 && Intrinsics.compare((int) charAt, 40959) <= 0) {
                    editable.delete(i2, i3);
                }
                i++;
                i2 = i3;
            }
            this.f7964a.d.f.setEnabled(editable.length() > 7);
        }
        WifiPasswordEditView wifiPasswordEditView = this.f7964a.d.u0;
        if (editable != null && editable.length() > 0) {
            z = true;
        }
        wifiPasswordEditView.m(z);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
