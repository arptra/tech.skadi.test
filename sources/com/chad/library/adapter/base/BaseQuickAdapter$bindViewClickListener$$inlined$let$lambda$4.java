package com.chad.library.adapter.base;

import android.view.View;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b¨\u0006\n"}, d2 = {"<anonymous>", "", "T", "VH", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/chad/library/adapter/base/BaseQuickAdapter$bindViewClickListener$4$1$1", "com/chad/library/adapter/base/BaseQuickAdapter$$special$$inlined$let$lambda$2"}, k = 3, mv = {1, 1, 16})
public final class BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$4 implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseQuickAdapter f2774a;
    public final /* synthetic */ BaseViewHolder b;

    public BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$4(BaseQuickAdapter baseQuickAdapter, BaseViewHolder baseViewHolder) {
        this.f2774a = baseQuickAdapter;
        this.b = baseViewHolder;
    }

    public final boolean onLongClick(View view) {
        int adapterPosition = this.b.getAdapterPosition();
        if (adapterPosition == -1) {
            return false;
        }
        BaseQuickAdapter baseQuickAdapter = this.f2774a;
        Intrinsics.checkExpressionValueIsNotNull(view, ProtocolVersions.PROTOCOL_KEY_CONNECTION_VERSION);
        return baseQuickAdapter.o0(view, adapterPosition - this.f2774a.M());
    }
}
