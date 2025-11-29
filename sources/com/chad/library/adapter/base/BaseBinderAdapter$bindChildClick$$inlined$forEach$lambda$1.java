package com.chad.library.adapter.base;

import android.view.View;
import com.chad.library.adapter.base.binder.BaseItemBinder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0007"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/chad/library/adapter/base/BaseBinderAdapter$bindChildClick$1$1$1", "com/chad/library/adapter/base/BaseBinderAdapter$$special$$inlined$let$lambda$1"}, k = 3, mv = {1, 1, 16})
public final class BaseBinderAdapter$bindChildClick$$inlined$forEach$lambda$1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseBinderAdapter f2761a;
    public final /* synthetic */ BaseViewHolder b;
    public final /* synthetic */ BaseItemBinder c;

    public BaseBinderAdapter$bindChildClick$$inlined$forEach$lambda$1(BaseBinderAdapter baseBinderAdapter, BaseViewHolder baseViewHolder, BaseItemBinder baseItemBinder) {
        this.f2761a = baseBinderAdapter;
        this.b = baseViewHolder;
        this.c = baseItemBinder;
    }

    public final void onClick(View view) {
        int adapterPosition = this.b.getAdapterPosition();
        if (adapterPosition != -1) {
            int M = adapterPosition - this.f2761a.M();
            BaseItemBinder baseItemBinder = this.c;
            BaseViewHolder baseViewHolder = this.b;
            Intrinsics.checkExpressionValueIsNotNull(view, ProtocolVersions.PROTOCOL_KEY_CONNECTION_VERSION);
            baseItemBinder.g(baseViewHolder, view, this.f2761a.getData().get(M), M);
        }
    }
}
