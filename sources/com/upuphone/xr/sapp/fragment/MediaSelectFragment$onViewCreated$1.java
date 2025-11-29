package com.upuphone.xr.sapp.fragment;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.entity.LocalMedia;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.FragmentMediaSelectBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nMediaSelectFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MediaSelectFragment.kt\ncom/upuphone/xr/sapp/fragment/MediaSelectFragment$onViewCreated$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,285:1\n1#2:286\n*E\n"})
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "it", "", "", "kotlin.jvm.PlatformType", "invoke", "([Ljava/lang/String;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class MediaSelectFragment$onViewCreated$1 extends Lambda implements Function1<String[], Unit> {
    final /* synthetic */ MediaSelectFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaSelectFragment$onViewCreated$1(MediaSelectFragment mediaSelectFragment) {
        super(1);
        this.this$0 = mediaSelectFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String[]) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String[] strArr) {
        ULog.f6446a.a("MediaSelectFragment", "数据回传");
        boolean z = false;
        Object obj = this.this$0.k.get(Integer.parseInt(strArr[0]));
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        LocalMedia localMedia = (LocalMedia) obj;
        if (Integer.parseInt(strArr[1]) != 0) {
            z = true;
        }
        localMedia.setChecked(z);
        FragmentMediaSelectBinding D0 = this.this$0.j;
        FragmentMediaSelectBinding fragmentMediaSelectBinding = null;
        if (D0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            D0 = null;
        }
        RecyclerView.Adapter adapter = D0.d.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        Context context = this.this$0.getContext();
        if (context != null) {
            MediaSelectFragment mediaSelectFragment = this.this$0;
            FragmentMediaSelectBinding D02 = mediaSelectFragment.j;
            if (D02 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentMediaSelectBinding = D02;
            }
            fragmentMediaSelectBinding.b.setText(context.getString(R.string.done) + "（" + mediaSelectFragment.H0() + "/9）");
        }
    }
}
