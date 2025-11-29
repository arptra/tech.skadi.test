package com.upuphone.ar.fastrecord.phone.ui.fragment;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.upuphone.ar.fastrecord.databinding.FastRecordTodoFragmentLayoutBinding;
import com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordTodoViewAdapter;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel;
import com.upuphone.ar.fastrecord.phone.utils.ViewUtil;
import com.xjsd.ai.assistant.protocol.VuiModelType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nFastRecordTodoFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordTodoFragment.kt\ncom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordTodoFragment$initTodoRecyclerView$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,475:1\n1#2:476\n*E\n"})
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000e"}, d2 = {"com/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordTodoFragment$initTodoRecyclerView$1", "Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordTodoViewAdapter$ItemClickListener;", "addTodo", "", "todo", "Lcom/upuphone/ar/fastrecord/phone/db/RecordTodoItemEntity;", "position", "", "deleteAllItem", "deleteItem", "recordEntity", "onItemClick", "onLongClick", "onTodoSelect", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordTodoFragment$initTodoRecyclerView$1 implements FastRecordTodoViewAdapter.ItemClickListener {
    final /* synthetic */ FastRecordTodoFragment this$0;

    public FastRecordTodoFragment$initTodoRecyclerView$1(FastRecordTodoFragment fastRecordTodoFragment) {
        this.this$0 = fastRecordTodoFragment;
    }

    public void addTodo(@NotNull RecordTodoItemEntity recordTodoItemEntity, int i) {
        Intrinsics.checkNotNullParameter(recordTodoItemEntity, VuiModelType.TODO);
        LogExt.logE("addDealInfo Enter!", "TodoFragment");
        this.this$0.addSchedule(recordTodoItemEntity, i);
        this.this$0.exitEditMode();
    }

    public void deleteAllItem() {
        FastRecordTodoFragmentLayoutBinding access$getBinding$p = this.this$0.binding;
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding = null;
        if (access$getBinding$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p = null;
        }
        access$getBinding$p.f.setVisibility(0);
        FastRecordTodoFragmentLayoutBinding access$getBinding$p2 = this.this$0.binding;
        if (access$getBinding$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p2 = null;
        }
        access$getBinding$p2.l.setVisibility(0);
        FastRecordTodoFragmentLayoutBinding access$getBinding$p3 = this.this$0.binding;
        if (access$getBinding$p3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p3 = null;
        }
        access$getBinding$p3.c.setVisibility(0);
        FastRecordTodoFragmentLayoutBinding access$getBinding$p4 = this.this$0.binding;
        if (access$getBinding$p4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p4 = null;
        }
        access$getBinding$p4.d.setVisibility(0);
        FastRecordTodoFragmentLayoutBinding access$getBinding$p5 = this.this$0.binding;
        if (access$getBinding$p5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p5 = null;
        }
        access$getBinding$p5.h.setVisibility(8);
        FastRecordTodoFragmentLayoutBinding access$getBinding$p6 = this.this$0.binding;
        if (access$getBinding$p6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            access$getBinding$p6 = null;
        }
        access$getBinding$p6.k.setVisibility(4);
        this.this$0.showFeedBackState(false);
        FastRecordTodoViewModel access$getViewModel$p = this.this$0.viewModel;
        if (access$getViewModel$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            access$getViewModel$p = null;
        }
        access$getViewModel$p.deleteAllData();
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            FastRecordTodoFragment fastRecordTodoFragment = this.this$0;
            ViewUtil viewUtil = ViewUtil.INSTANCE;
            FastRecordTodoFragmentLayoutBinding access$getBinding$p7 = fastRecordTodoFragment.binding;
            if (access$getBinding$p7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fastRecordTodoFragmentLayoutBinding = access$getBinding$p7;
            }
            ConstraintLayout b = fastRecordTodoFragmentLayoutBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
            viewUtil.hideSoftInput(activity, b);
        }
    }

    public void deleteItem(@NotNull RecordTodoItemEntity recordTodoItemEntity) {
        Intrinsics.checkNotNullParameter(recordTodoItemEntity, "recordEntity");
        FastRecordTodoViewModel access$getViewModel$p = this.this$0.viewModel;
        if (access$getViewModel$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            access$getViewModel$p = null;
        }
        access$getViewModel$p.deleteTodo(recordTodoItemEntity);
    }

    public void onItemClick(int i) {
        LogExt.logE("onItemClick Enter ", "TodoFragment");
    }

    public void onLongClick(int i) {
        LogExt.logE("onLongClick Enter ", "TodoFragment");
    }

    public void onTodoSelect(int i) {
        LogExt.logE("onTodoSelect.", "TodoFragment");
        this.this$0.updateTodoList();
        this.this$0.exitEditMode();
    }
}
