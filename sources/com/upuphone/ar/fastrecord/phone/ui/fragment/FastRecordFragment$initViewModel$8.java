package com.upuphone.ar.fastrecord.phone.ui.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordViewAdapter;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.AsrDuringProgress;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nFastRecordFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordFragment.kt\ncom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordFragment$initViewModel$8\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,476:1\n1855#2,2:477\n*S KotlinDebug\n*F\n+ 1 FastRecordFragment.kt\ncom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordFragment$initViewModel$8\n*L\n400#1:477,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "asrResultList", "Ljava/util/ArrayList;", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/AsrDuringProgress;", "Lkotlin/collections/ArrayList;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class FastRecordFragment$initViewModel$8 extends Lambda implements Function1<ArrayList<AsrDuringProgress>, Unit> {
    final /* synthetic */ FastRecordFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordFragment$initViewModel$8(FastRecordFragment fastRecordFragment) {
        super(1);
        this.this$0 = fastRecordFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ArrayList<AsrDuringProgress>) (ArrayList) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable ArrayList<AsrDuringProgress> arrayList) {
        if (arrayList != null) {
            FastRecordFragment fastRecordFragment = this.this$0;
            for (AsrDuringProgress asrDuringProgress : arrayList) {
                LogExt.logE("event = " + asrDuringProgress + " ,isShowing = " + fastRecordFragment.isShowing + ",event.isFail = " + asrDuringProgress.isFail() + ",thread info = " + Thread.currentThread().getName(), "FastRecordFragment");
                LinearLayoutManager linearLayoutManager = null;
                if (!asrDuringProgress.isFail()) {
                    FastRecordViewAdapter access$getViewAdapter$p = fastRecordFragment.viewAdapter;
                    if (access$getViewAdapter$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                        access$getViewAdapter$p = null;
                    }
                    LinearLayoutManager access$getLayoutManager$p = fastRecordFragment.layoutManager;
                    if (access$getLayoutManager$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
                    } else {
                        linearLayoutManager = access$getLayoutManager$p;
                    }
                    access$getViewAdapter$p.showAsrState(asrDuringProgress, linearLayoutManager);
                } else if (fastRecordFragment.isShowing) {
                    FastRecordViewAdapter access$getViewAdapter$p2 = fastRecordFragment.viewAdapter;
                    if (access$getViewAdapter$p2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                        access$getViewAdapter$p2 = null;
                    }
                    LinearLayoutManager access$getLayoutManager$p2 = fastRecordFragment.layoutManager;
                    if (access$getLayoutManager$p2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
                    } else {
                        linearLayoutManager = access$getLayoutManager$p2;
                    }
                    access$getViewAdapter$p2.showAsrState(asrDuringProgress, linearLayoutManager);
                } else {
                    asrDuringProgress.setFail(false);
                    asrDuringProgress.setFinish(true);
                    asrDuringProgress.setStartAsr(false);
                    FastRecordViewAdapter access$getViewAdapter$p3 = fastRecordFragment.viewAdapter;
                    if (access$getViewAdapter$p3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                        access$getViewAdapter$p3 = null;
                    }
                    LinearLayoutManager access$getLayoutManager$p3 = fastRecordFragment.layoutManager;
                    if (access$getLayoutManager$p3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
                    } else {
                        linearLayoutManager = access$getLayoutManager$p3;
                    }
                    access$getViewAdapter$p3.showAsrState(asrDuringProgress, linearLayoutManager);
                }
            }
        }
    }
}
