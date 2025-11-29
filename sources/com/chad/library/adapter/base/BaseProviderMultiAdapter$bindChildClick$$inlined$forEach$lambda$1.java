package com.chad.library.adapter.base;

import android.view.View;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/chad/library/adapter/base/BaseProviderMultiAdapter$bindChildClick$1$1$1", "com/chad/library/adapter/base/BaseProviderMultiAdapter$$special$$inlined$let$lambda$1"}, k = 3, mv = {1, 1, 16})
public final class BaseProviderMultiAdapter$bindChildClick$$inlined$forEach$lambda$1 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseProviderMultiAdapter f2766a;
    public final /* synthetic */ BaseViewHolder b;
    public final /* synthetic */ BaseItemProvider c;

    public BaseProviderMultiAdapter$bindChildClick$$inlined$forEach$lambda$1(BaseProviderMultiAdapter baseProviderMultiAdapter, BaseViewHolder baseViewHolder, BaseItemProvider baseItemProvider) {
        this.f2766a = baseProviderMultiAdapter;
        this.b = baseViewHolder;
        this.c = baseItemProvider;
    }

    public final void onClick(View view) {
        int adapterPosition = this.b.getAdapterPosition();
        if (adapterPosition != -1) {
            int M = adapterPosition - this.f2766a.M();
            BaseItemProvider baseItemProvider = this.c;
            BaseViewHolder baseViewHolder = this.b;
            Intrinsics.checkExpressionValueIsNotNull(view, ProtocolVersions.PROTOCOL_KEY_CONNECTION_VERSION);
            baseItemProvider.j(baseViewHolder, view, this.f2766a.getData().get(M), M);
        }
    }
}
