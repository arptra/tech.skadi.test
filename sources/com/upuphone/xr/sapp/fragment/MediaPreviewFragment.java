package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.honey.account.h8.a6;
import com.upuphone.xr.sapp.adapter.MediaPreviewAdapter;
import com.upuphone.xr.sapp.databinding.FragmentMediaPreviewBinding;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/MediaPreviewFragment;", "Lcom/upuphone/xr/sapp/fragment/BaseFragment;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "j", "I", "mediaIndex", "", "Landroid/net/Uri;", "k", "Ljava/util/List;", "mediaArray", "Lcom/upuphone/xr/sapp/databinding/FragmentMediaPreviewBinding;", "l", "Lcom/upuphone/xr/sapp/databinding/FragmentMediaPreviewBinding;", "binding", "Lcom/upuphone/xr/sapp/adapter/MediaPreviewAdapter;", "m", "Lcom/upuphone/xr/sapp/adapter/MediaPreviewAdapter;", "mAdapter", "n", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class MediaPreviewFragment extends BaseFragment {
    public static final Companion n = new Companion((DefaultConstructorMarker) null);
    public int j;
    public List k = CollectionsKt.emptyList();
    public FragmentMediaPreviewBinding l;
    public MediaPreviewAdapter m;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/xr/sapp/fragment/MediaPreviewFragment$Companion;", "", "()V", "MEDIA_ARRAY", "", "MEDIA_INDEX", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public static final void B0(MediaPreviewFragment mediaPreviewFragment, View view) {
        Intrinsics.checkNotNullParameter(mediaPreviewFragment, "this$0");
        StaticMethodUtilsKt.q(mediaPreviewFragment);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentMediaPreviewBinding c = FragmentMediaPreviewBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.l = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        RelativeLayout b = c.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            List parcelableArrayList = arguments.getParcelableArrayList("MEDIA_ARRAY");
            if (parcelableArrayList == null) {
                parcelableArrayList = CollectionsKt.emptyList();
            } else {
                Intrinsics.checkNotNull(parcelableArrayList);
            }
            this.k = parcelableArrayList;
            this.j = arguments.getInt("MEDIA_INDEX");
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        this.m = new MediaPreviewAdapter(requireContext, this.k);
        FragmentMediaPreviewBinding fragmentMediaPreviewBinding = this.l;
        FragmentMediaPreviewBinding fragmentMediaPreviewBinding2 = null;
        if (fragmentMediaPreviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMediaPreviewBinding = null;
        }
        ViewPager viewPager = fragmentMediaPreviewBinding.d;
        MediaPreviewAdapter mediaPreviewAdapter = this.m;
        if (mediaPreviewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            mediaPreviewAdapter = null;
        }
        viewPager.setAdapter(mediaPreviewAdapter);
        FragmentMediaPreviewBinding fragmentMediaPreviewBinding3 = this.l;
        if (fragmentMediaPreviewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMediaPreviewBinding3 = null;
        }
        fragmentMediaPreviewBinding3.b.setOnClickListener(new a6(this));
        FragmentMediaPreviewBinding fragmentMediaPreviewBinding4 = this.l;
        if (fragmentMediaPreviewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentMediaPreviewBinding2 = fragmentMediaPreviewBinding4;
        }
        fragmentMediaPreviewBinding2.d.setCurrentItem(this.j);
    }
}
