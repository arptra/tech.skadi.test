package com.chad.library.adapter.base;

import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
final /* synthetic */ class BaseQuickAdapter$hasHeaderLayout$1 extends MutablePropertyReference0 {
    public BaseQuickAdapter$hasHeaderLayout$1(BaseQuickAdapter baseQuickAdapter) {
        super(baseQuickAdapter);
    }

    @Nullable
    public Object get() {
        return BaseQuickAdapter.i((BaseQuickAdapter) this.receiver);
    }

    public String getName() {
        return "mHeaderLayout";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(BaseQuickAdapter.class);
    }

    public String getSignature() {
        return "getMHeaderLayout()Landroid/widget/LinearLayout;";
    }

    public void set(@Nullable Object obj) {
        ((BaseQuickAdapter) this.receiver).j = (LinearLayout) obj;
    }
}
