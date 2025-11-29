package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.honey.account.h8.u5;
import com.honey.account.h8.v5;
import com.luck.picture.lib.entity.LocalMedia;
import com.meizu.common.fastscrollletter.FastScrollLetterCursorColumn;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentLargeBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010!\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010\u001c¨\u0006$"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/LargeFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/upuphone/xr/sapp/databinding/FragmentLargeBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentLargeBinding;", "binding", "Lcom/luck/picture/lib/entity/LocalMedia;", "k", "Lcom/luck/picture/lib/entity/LocalMedia;", "localMedia", "", "l", "I", "count", "m", "dataIndex", "n", "isCheck", "o", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nLargeFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LargeFragment.kt\ncom/upuphone/xr/sapp/fragment/LargeFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,106:1\n1#2:107\n*E\n"})
public final class LargeFragment extends BaseFragment {
    public static final Companion o = new Companion((DefaultConstructorMarker) null);
    public FragmentLargeBinding j;
    public LocalMedia k;
    public int l;
    public int m = -1;
    public int n;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/LargeFragment$Companion;", "", "()V", "BACK_DATA", "", "TAG", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final void D0(LargeFragment largeFragment, View view) {
        SavedStateHandle i;
        Intrinsics.checkNotNullParameter(largeFragment, "this$0");
        NavController a2 = FragmentKt.a(largeFragment);
        LocalMedia localMedia = largeFragment.k;
        int i2 = 0;
        if (localMedia != null && localMedia.isChecked()) {
            i2 = 1;
        }
        largeFragment.n = i2;
        NavBackStackEntry I = FragmentKt.a(largeFragment).I();
        if (!(I == null || (i = I.i()) == null)) {
            i.i("back_data", new String[]{String.valueOf(largeFragment.m), String.valueOf(largeFragment.n)});
        }
        a2.V();
    }

    public static final void E0(LargeFragment largeFragment, View view) {
        Intrinsics.checkNotNullParameter(largeFragment, "this$0");
        LocalMedia localMedia = largeFragment.k;
        Intrinsics.checkNotNull(localMedia);
        FragmentLargeBinding fragmentLargeBinding = null;
        if (localMedia.isChecked()) {
            largeFragment.l--;
            FragmentLargeBinding fragmentLargeBinding2 = largeFragment.j;
            if (fragmentLargeBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentLargeBinding2 = null;
            }
            fragmentLargeBinding2.c.setText(largeFragment.getString(R.string.done) + "（" + largeFragment.l + "/9）");
            LocalMedia localMedia2 = largeFragment.k;
            Intrinsics.checkNotNull(localMedia2);
            LocalMedia localMedia3 = largeFragment.k;
            Intrinsics.checkNotNull(localMedia3);
            localMedia2.setChecked(localMedia3.isChecked() ^ true);
            FragmentLargeBinding fragmentLargeBinding3 = largeFragment.j;
            if (fragmentLargeBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentLargeBinding = fragmentLargeBinding3;
            }
            fragmentLargeBinding.e.setSelected(false);
            return;
        }
        int i = largeFragment.l;
        if (i < 9) {
            largeFragment.l = i + 1;
            FragmentLargeBinding fragmentLargeBinding4 = largeFragment.j;
            if (fragmentLargeBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentLargeBinding4 = null;
            }
            fragmentLargeBinding4.c.setText(largeFragment.getString(R.string.done) + "（" + largeFragment.l + "/9）");
            LocalMedia localMedia4 = largeFragment.k;
            Intrinsics.checkNotNull(localMedia4);
            LocalMedia localMedia5 = largeFragment.k;
            Intrinsics.checkNotNull(localMedia5);
            localMedia4.setChecked(localMedia5.isChecked() ^ true);
            FragmentLargeBinding fragmentLargeBinding5 = largeFragment.j;
            if (fragmentLargeBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentLargeBinding = fragmentLargeBinding5;
            }
            fragmentLargeBinding.e.setSelected(true);
            return;
        }
        Context context = largeFragment.getContext();
        if (context != null) {
            UToast.Companion companion = UToast.f6444a;
            String string = largeFragment.getString(R.string.max_9);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(context, string);
        }
    }

    private final void initView() {
        ULog.f6446a.a("LargeFragment", "initView");
        FragmentLargeBinding fragmentLargeBinding = this.j;
        FragmentLargeBinding fragmentLargeBinding2 = null;
        if (fragmentLargeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentLargeBinding = null;
        }
        fragmentLargeBinding.b.setOnClickListener(new u5(this));
        Context context = getContext();
        if (context != null) {
            RequestBuilder f = Glide.t(context).f();
            LocalMedia localMedia = this.k;
            Intrinsics.checkNotNull(localMedia);
            LargeFragment$initView$2$1 largeFragment$initView$2$1 = (LargeFragment$initView$2$1) ((RequestBuilder) ((RequestBuilder) f.D0(localMedia.getAvailablePath()).V(R.color.default_img)).d()).w0(new LargeFragment$initView$2$1(this));
        }
        FragmentLargeBinding fragmentLargeBinding3 = this.j;
        if (fragmentLargeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentLargeBinding3 = null;
        }
        ImageView imageView = fragmentLargeBinding3.e;
        LocalMedia localMedia2 = this.k;
        Intrinsics.checkNotNull(localMedia2);
        imageView.setSelected(localMedia2.isChecked());
        FragmentLargeBinding fragmentLargeBinding4 = this.j;
        if (fragmentLargeBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentLargeBinding4 = null;
        }
        fragmentLargeBinding4.c.setText(getString(R.string.done) + "（" + this.l + "/9）");
        FragmentLargeBinding fragmentLargeBinding5 = this.j;
        if (fragmentLargeBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentLargeBinding2 = fragmentLargeBinding5;
        }
        fragmentLargeBinding2.e.setOnClickListener(new v5(this));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentLargeBinding c = FragmentLargeBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.j = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        return c.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        Integer num = null;
        this.k = arguments != null ? (LocalMedia) arguments.getParcelable("data") : null;
        Bundle arguments2 = getArguments();
        Integer valueOf = arguments2 != null ? Integer.valueOf(arguments2.getInt("data_account")) : null;
        Intrinsics.checkNotNull(valueOf);
        this.l = valueOf.intValue();
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            num = Integer.valueOf(arguments3.getInt(FastScrollLetterCursorColumn.DATA_INDEX));
        }
        Intrinsics.checkNotNull(num);
        this.m = num.intValue();
        initView();
    }
}
