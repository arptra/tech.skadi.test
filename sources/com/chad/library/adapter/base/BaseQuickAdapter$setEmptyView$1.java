package com.chad.library.adapter.base;

import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
final /* synthetic */ class BaseQuickAdapter$setEmptyView$1 extends MutablePropertyReference0 {
    public BaseQuickAdapter$setEmptyView$1(BaseQuickAdapter baseQuickAdapter) {
        super(baseQuickAdapter);
    }

    @Nullable
    public Object get() {
        return BaseQuickAdapter.g((BaseQuickAdapter) this.receiver);
    }

    public String getName() {
        return "mEmptyLayout";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(BaseQuickAdapter.class);
    }

    public String getSignature() {
        return "getMEmptyLayout()Landroid/widget/FrameLayout;";
    }

    public void set(@Nullable Object obj) {
        ((BaseQuickAdapter) this.receiver).l = (FrameLayout) obj;
    }
}
