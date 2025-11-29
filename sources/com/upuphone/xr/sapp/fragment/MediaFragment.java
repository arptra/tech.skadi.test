package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.honey.account.h8.w5;
import com.honey.account.h8.x5;
import com.honey.account.h8.y5;
import com.honey.account.h8.z5;
import com.luck.picture.lib.entity.LocalMedia;
import com.meizu.common.fastscrollletter.FastScrollLetterCursorColumn;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentMediaBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010!\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010\u001c¨\u0006$"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/MediaFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "", "initView", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/upuphone/xr/sapp/databinding/FragmentMediaBinding;", "j", "Lcom/upuphone/xr/sapp/databinding/FragmentMediaBinding;", "binding", "Lcom/luck/picture/lib/entity/LocalMedia;", "k", "Lcom/luck/picture/lib/entity/LocalMedia;", "localMedia", "", "l", "I", "count", "m", "dataIndex", "n", "isCheck", "o", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nMediaFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaFragment.kt\ncom/upuphone/xr/sapp/fragment/MediaFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,119:1\n1#2:120\n*E\n"})
public final class MediaFragment extends BaseFragment {
    public static final Companion o = new Companion((DefaultConstructorMarker) null);
    public FragmentMediaBinding j;
    public LocalMedia k;
    public int l;
    public int m = -1;
    public int n;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/MediaFragment$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final void F0(MediaFragment mediaFragment, View view) {
        SavedStateHandle i;
        Intrinsics.checkNotNullParameter(mediaFragment, "this$0");
        FragmentMediaBinding fragmentMediaBinding = mediaFragment.j;
        if (fragmentMediaBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMediaBinding = null;
        }
        fragmentMediaBinding.h.stopPlayback();
        NavController a2 = FragmentKt.a(mediaFragment);
        LocalMedia localMedia = mediaFragment.k;
        int i2 = 0;
        if (localMedia != null && localMedia.isChecked()) {
            i2 = 1;
        }
        mediaFragment.n = i2;
        NavBackStackEntry I = FragmentKt.a(mediaFragment).I();
        if (!(I == null || (i = I.i()) == null)) {
            i.i("back_data", new String[]{String.valueOf(mediaFragment.m), String.valueOf(mediaFragment.n)});
        }
        a2.V();
    }

    public static final void G0(MediaFragment mediaFragment, View view) {
        Intrinsics.checkNotNullParameter(mediaFragment, "this$0");
        LocalMedia localMedia = mediaFragment.k;
        Intrinsics.checkNotNull(localMedia);
        FragmentMediaBinding fragmentMediaBinding = null;
        if (localMedia.isChecked()) {
            mediaFragment.l--;
            FragmentMediaBinding fragmentMediaBinding2 = mediaFragment.j;
            if (fragmentMediaBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentMediaBinding2 = null;
            }
            fragmentMediaBinding2.c.setText(mediaFragment.getString(R.string.done) + "（" + mediaFragment.l + "/9）");
            LocalMedia localMedia2 = mediaFragment.k;
            Intrinsics.checkNotNull(localMedia2);
            LocalMedia localMedia3 = mediaFragment.k;
            Intrinsics.checkNotNull(localMedia3);
            localMedia2.setChecked(localMedia3.isChecked() ^ true);
            FragmentMediaBinding fragmentMediaBinding3 = mediaFragment.j;
            if (fragmentMediaBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentMediaBinding = fragmentMediaBinding3;
            }
            fragmentMediaBinding.f.setSelected(false);
            return;
        }
        int i = mediaFragment.l;
        if (i < 9) {
            mediaFragment.l = i + 1;
            FragmentMediaBinding fragmentMediaBinding4 = mediaFragment.j;
            if (fragmentMediaBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentMediaBinding4 = null;
            }
            fragmentMediaBinding4.c.setText(mediaFragment.getString(R.string.done) + "（" + mediaFragment.l + "/9）");
            LocalMedia localMedia4 = mediaFragment.k;
            Intrinsics.checkNotNull(localMedia4);
            LocalMedia localMedia5 = mediaFragment.k;
            Intrinsics.checkNotNull(localMedia5);
            localMedia4.setChecked(localMedia5.isChecked() ^ true);
            FragmentMediaBinding fragmentMediaBinding5 = mediaFragment.j;
            if (fragmentMediaBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentMediaBinding = fragmentMediaBinding5;
            }
            fragmentMediaBinding.f.setSelected(true);
            return;
        }
        Context context = mediaFragment.getContext();
        if (context != null) {
            UToast.Companion companion = UToast.f6444a;
            String string = mediaFragment.getString(R.string.max_9);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(context, string);
        }
    }

    public static final void H0(MediaFragment mediaFragment, View view) {
        Intrinsics.checkNotNullParameter(mediaFragment, "this$0");
        FragmentMediaBinding fragmentMediaBinding = mediaFragment.j;
        FragmentMediaBinding fragmentMediaBinding2 = null;
        if (fragmentMediaBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMediaBinding = null;
        }
        fragmentMediaBinding.d.setVisibility(8);
        FragmentMediaBinding fragmentMediaBinding3 = mediaFragment.j;
        if (fragmentMediaBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMediaBinding3 = null;
        }
        fragmentMediaBinding3.e.setVisibility(8);
        FragmentMediaBinding fragmentMediaBinding4 = mediaFragment.j;
        if (fragmentMediaBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMediaBinding4 = null;
        }
        fragmentMediaBinding4.h.setVisibility(0);
        FragmentMediaBinding fragmentMediaBinding5 = mediaFragment.j;
        if (fragmentMediaBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentMediaBinding2 = fragmentMediaBinding5;
        }
        fragmentMediaBinding2.h.start();
    }

    public static final void I0(MediaFragment mediaFragment, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(mediaFragment, "this$0");
        FragmentMediaBinding fragmentMediaBinding = mediaFragment.j;
        FragmentMediaBinding fragmentMediaBinding2 = null;
        if (fragmentMediaBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMediaBinding = null;
        }
        fragmentMediaBinding.d.setVisibility(0);
        FragmentMediaBinding fragmentMediaBinding3 = mediaFragment.j;
        if (fragmentMediaBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMediaBinding3 = null;
        }
        fragmentMediaBinding3.e.setVisibility(0);
        FragmentMediaBinding fragmentMediaBinding4 = mediaFragment.j;
        if (fragmentMediaBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentMediaBinding2 = fragmentMediaBinding4;
        }
        fragmentMediaBinding2.h.setVisibility(8);
    }

    private final void initView() {
        ULog.f6446a.a("MediaFragment", "initView");
        FragmentMediaBinding fragmentMediaBinding = this.j;
        FragmentMediaBinding fragmentMediaBinding2 = null;
        if (fragmentMediaBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMediaBinding = null;
        }
        fragmentMediaBinding.b.setOnClickListener(new w5(this));
        Context context = getContext();
        if (context != null) {
            RequestBuilder f = Glide.t(context).f();
            LocalMedia localMedia = this.k;
            Intrinsics.checkNotNull(localMedia);
            MediaFragment$initView$2$1 mediaFragment$initView$2$1 = (MediaFragment$initView$2$1) ((RequestBuilder) ((RequestBuilder) f.D0(localMedia.getAvailablePath()).V(R.color.default_img)).d()).w0(new MediaFragment$initView$2$1(this));
        }
        FragmentMediaBinding fragmentMediaBinding3 = this.j;
        if (fragmentMediaBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMediaBinding3 = null;
        }
        ImageView imageView = fragmentMediaBinding3.f;
        LocalMedia localMedia2 = this.k;
        Intrinsics.checkNotNull(localMedia2);
        imageView.setSelected(localMedia2.isChecked());
        FragmentMediaBinding fragmentMediaBinding4 = this.j;
        if (fragmentMediaBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMediaBinding4 = null;
        }
        fragmentMediaBinding4.c.setText(getString(R.string.done) + "（" + this.l + "/9）");
        FragmentMediaBinding fragmentMediaBinding5 = this.j;
        if (fragmentMediaBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMediaBinding5 = null;
        }
        fragmentMediaBinding5.f.setOnClickListener(new x5(this));
        FragmentMediaBinding fragmentMediaBinding6 = this.j;
        if (fragmentMediaBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMediaBinding6 = null;
        }
        fragmentMediaBinding6.e.setOnClickListener(new y5(this));
        FragmentMediaBinding fragmentMediaBinding7 = this.j;
        if (fragmentMediaBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMediaBinding7 = null;
        }
        fragmentMediaBinding7.h.setOnCompletionListener(new z5(this));
        FragmentMediaBinding fragmentMediaBinding8 = this.j;
        if (fragmentMediaBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentMediaBinding2 = fragmentMediaBinding8;
        }
        VideoView videoView = fragmentMediaBinding2.h;
        LocalMedia localMedia3 = this.k;
        Intrinsics.checkNotNull(localMedia3);
        videoView.setVideoURI(Uri.parse(localMedia3.getPath()));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentMediaBinding c = FragmentMediaBinding.c(layoutInflater, viewGroup, false);
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
