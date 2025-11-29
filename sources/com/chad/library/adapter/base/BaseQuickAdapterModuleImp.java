package com.chad.library.adapter.base;

import com.chad.library.adapter.base.module.BaseDraggableModule;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.chad.library.adapter.base.module.BaseUpFetchModule;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bb\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/chad/library/adapter/base/BaseQuickAdapterModuleImp;", "", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
interface BaseQuickAdapterModuleImp {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public static final class DefaultImpls {
        public static BaseDraggableModule a(BaseQuickAdapterModuleImp baseQuickAdapterModuleImp, BaseQuickAdapter baseQuickAdapter) {
            return new BaseDraggableModule(baseQuickAdapter);
        }

        public static BaseLoadMoreModule b(BaseQuickAdapterModuleImp baseQuickAdapterModuleImp, BaseQuickAdapter baseQuickAdapter) {
            return new BaseLoadMoreModule(baseQuickAdapter);
        }

        public static BaseUpFetchModule c(BaseQuickAdapterModuleImp baseQuickAdapterModuleImp, BaseQuickAdapter baseQuickAdapter) {
            return new BaseUpFetchModule(baseQuickAdapter);
        }
    }
}
