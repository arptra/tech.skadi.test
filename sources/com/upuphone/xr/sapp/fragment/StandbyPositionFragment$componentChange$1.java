package com.upuphone.xr.sapp.fragment;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentStandbyPositionBinding;
import com.upuphone.xr.sapp.view.StandbyComponentChange;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JC\u0010\u000b\u001a\u00020\n2\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ3\u0010\u000f\u001a\u00020\n2\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0011\u001a\u00020\n2\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ3\u0010\u0013\u001a\u00020\n2\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u000e¨\u0006\u0015"}, d2 = {"com/upuphone/xr/sapp/fragment/StandbyPositionFragment$componentChange$1", "Lcom/upuphone/xr/sapp/view/StandbyComponentChange;", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "widgetMap", "", "isRemove", "componentName", "", "a", "(Ljava/util/LinkedHashMap;ZLjava/lang/String;)V", "b", "()V", "f", "(Ljava/util/LinkedHashMap;)V", "c", "g", "e", "d", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class StandbyPositionFragment$componentChange$1 implements StandbyComponentChange {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StandbyPositionFragment f7005a;

    public StandbyPositionFragment$componentChange$1(StandbyPositionFragment standbyPositionFragment) {
        this.f7005a = standbyPositionFragment;
    }

    public void a(LinkedHashMap linkedHashMap, boolean z, String str) {
        Intrinsics.checkNotNullParameter(linkedHashMap, "widgetMap");
        Intrinsics.checkNotNullParameter(str, "componentName");
        this.f7005a.e1(linkedHashMap, z, str);
    }

    public void b() {
        FragmentStandbyPositionBinding M0 = this.f7005a.l;
        FragmentStandbyPositionBinding fragmentStandbyPositionBinding = null;
        if (M0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            M0 = null;
        }
        TextView textView = M0.w;
        MainApplication.Companion companion = MainApplication.k;
        textView.setTextColor(companion.d().getResources().getColor(R.color.standby_component_edit_text_color));
        FragmentStandbyPositionBinding M02 = this.f7005a.l;
        if (M02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentStandbyPositionBinding = M02;
        }
        fragmentStandbyPositionBinding.h.setBackground(companion.d().getResources().getDrawable(R.drawable.shape_standby_component_bar_border));
        this.f7005a.z = true;
    }

    public void c(LinkedHashMap linkedHashMap) {
        Intrinsics.checkNotNullParameter(linkedHashMap, "widgetMap");
        this.f7005a.y1(linkedHashMap);
    }

    public void d() {
        this.f7005a.z = false;
    }

    public void e(LinkedHashMap linkedHashMap) {
        Intrinsics.checkNotNullParameter(linkedHashMap, "widgetMap");
        this.f7005a.B1(linkedHashMap);
    }

    public void f(LinkedHashMap linkedHashMap) {
        Intrinsics.checkNotNullParameter(linkedHashMap, "widgetMap");
        FragmentStandbyPositionBinding M0 = this.f7005a.l;
        if (M0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            M0 = null;
        }
        M0.w.setTextColor(this.f7005a.getResources().getColor(R.color.mz_theme_color_blue));
        FragmentStandbyPositionBinding M02 = this.f7005a.l;
        if (M02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            M02 = null;
        }
        M02.h.setBackground((Drawable) null);
    }

    public void g() {
        StandbyPositionFragment standbyPositionFragment = this.f7005a;
        standbyPositionFragment.q1(standbyPositionFragment.o);
    }
}
