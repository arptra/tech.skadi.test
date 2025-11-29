package com.upuphone.xr.sapp.fragment;

import android.content.Intent;
import android.widget.TextView;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.adapter.FeedbackViewAdapter;
import com.upuphone.xr.sapp.databinding.FragmentOpinionFeedbackBinding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/upuphone/xr/sapp/fragment/OpinionFeedbackFragment$initRecyclerView$1", "Lcom/upuphone/xr/sapp/adapter/FeedbackViewAdapter$ItemClickListener;", "", "position", "", "b", "(I)V", "a", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class OpinionFeedbackFragment$initRecyclerView$1 implements FeedbackViewAdapter.ItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OpinionFeedbackFragment f6985a;

    public OpinionFeedbackFragment$initRecyclerView$1(OpinionFeedbackFragment opinionFeedbackFragment) {
        this.f6985a = opinionFeedbackFragment;
    }

    public void a(int i) {
        ArrayList G0 = this.f6985a.k;
        if (G0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mData");
            G0 = null;
        }
        if (((String) G0.get(i)).equals("addScreenshotPic")) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.PICK");
            intent.setType("image/*");
            this.f6985a.startActivityForResult(intent, 100);
            return;
        }
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("AppFragment", "点击第 " + i + " 张图片, 具体响应待定义");
    }

    public void b(int i) {
        ULog.f6446a.a("AppFragment", "移除第 " + i + " 张图片");
        ArrayList G0 = this.f6985a.k;
        ArrayList arrayList = null;
        if (G0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mData");
            G0 = null;
        }
        ArrayList G02 = this.f6985a.k;
        if (G02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mData");
            G02 = null;
        }
        if (!((String) G0.get(G02.size() - 1)).equals("addScreenshotPic")) {
            ArrayList G03 = this.f6985a.k;
            if (G03 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mData");
                G03 = null;
            }
            G03.set(8, "addScreenshotPic");
            FeedbackViewAdapter H0 = this.f6985a.l;
            if (H0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                H0 = null;
            }
            H0.notifyItemChanged(8);
        } else {
            ArrayList G04 = this.f6985a.k;
            if (G04 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mData");
                G04 = null;
            }
            G04.remove(i);
            FeedbackViewAdapter H02 = this.f6985a.l;
            if (H02 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                H02 = null;
            }
            H02.notifyItemRemoved(i);
        }
        FragmentOpinionFeedbackBinding F0 = this.f6985a.j;
        if (F0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            F0 = null;
        }
        TextView textView = F0.r;
        ArrayList G05 = this.f6985a.k;
        if (G05 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mData");
        } else {
            arrayList = G05;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(arrayList.size() - 1);
        sb.append("/9");
        textView.setText(sb.toString());
    }
}
