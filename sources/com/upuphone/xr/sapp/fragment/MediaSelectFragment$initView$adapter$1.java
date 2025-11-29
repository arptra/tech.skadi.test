package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.widget.RecyclerPreloadView;
import com.meizu.common.fastscrollletter.FastScrollLetterCursorColumn;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentMediaSelectBinding;
import com.upuphone.xr.sapp.fragment.MediaSelectFragment;
import com.upuphone.xr.sapp.utils.StaticMethodUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nMediaSelectFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaSelectFragment.kt\ncom/upuphone/xr/sapp/fragment/MediaSelectFragment$initView$adapter$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,285:1\n1#2:286\n*E\n"})
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/upuphone/xr/sapp/fragment/MediaSelectFragment$initView$adapter$1", "Lcom/upuphone/xr/sapp/fragment/MediaSelectFragment$ItemOnClickListener;", "", "i", "", "b", "(I)V", "Landroid/view/View;", "view", "a", "(Landroid/view/View;I)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class MediaSelectFragment$initView$adapter$1 implements MediaSelectFragment.ItemOnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediaSelectFragment f6978a;
    public final /* synthetic */ RecyclerPreloadView b;

    public MediaSelectFragment$initView$adapter$1(MediaSelectFragment mediaSelectFragment, RecyclerPreloadView recyclerPreloadView) {
        this.f6978a = mediaSelectFragment;
        this.b = recyclerPreloadView;
    }

    public void a(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f6978a.o = i;
        this.b.setVisibility(8);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("data", this.f6978a.k);
        bundle.putInt("data_account", this.f6978a.H0());
        bundle.putInt(FastScrollLetterCursorColumn.DATA_INDEX, i);
        bundle.putBoolean("show_key", false);
        StaticMethodUtilsKt.v(this.f6978a, R.id.mediaShowListFragment, bundle);
    }

    public void b(int i) {
        Object obj = this.f6978a.k.get(i);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        LocalMedia localMedia = (LocalMedia) obj;
        if (localMedia.isChecked()) {
            localMedia.setChecked(false);
        } else if (this.f6978a.H0() < 9) {
            localMedia.setChecked(true);
        } else {
            Context context = this.f6978a.getContext();
            if (context != null) {
                MediaSelectFragment mediaSelectFragment = this.f6978a;
                UToast.Companion companion = UToast.f6444a;
                String string = mediaSelectFragment.getString(R.string.max_9);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                companion.d(context, string);
            }
        }
        RecyclerView.Adapter adapter = this.b.getAdapter();
        Intrinsics.checkNotNull(adapter);
        adapter.notifyDataSetChanged();
        Context context2 = this.f6978a.getContext();
        if (context2 != null) {
            MediaSelectFragment mediaSelectFragment2 = this.f6978a;
            FragmentMediaSelectBinding D0 = mediaSelectFragment2.j;
            if (D0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                D0 = null;
            }
            TextView textView = D0.b;
            String string2 = context2.getString(R.string.done);
            int F0 = mediaSelectFragment2.H0();
            textView.setText(string2 + "（" + F0 + "/9）");
        }
    }
}
