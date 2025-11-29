package com.upuphone.ar.fastrecord.phone.ui.fragment;

import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordViewAdapter;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"com/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordFragment$initView$1", "Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordViewAdapter$ItemClickListener;", "commandRecordEntity", "", "isAdd", "", "recordEntity", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "commandTitleClick", "pos", "", "onItemClick", "position", "onLongClick", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordFragment$initView$1 implements FastRecordViewAdapter.ItemClickListener {
    final /* synthetic */ FastRecordFragment this$0;

    public FastRecordFragment$initView$1(FastRecordFragment fastRecordFragment) {
        this.this$0 = fastRecordFragment;
    }

    public void commandRecordEntity(boolean z, @NotNull RecordEntity recordEntity) {
        Intrinsics.checkNotNullParameter(recordEntity, "recordEntity");
        FastRecordMainViewModel fastRecordMainViewModel = null;
        if (z) {
            FastRecordMainViewModel access$getViewModel$p = this.this$0.viewModel;
            if (access$getViewModel$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                fastRecordMainViewModel = access$getViewModel$p;
            }
            fastRecordMainViewModel.addSelectEntity(recordEntity);
            return;
        }
        FastRecordMainViewModel access$getViewModel$p2 = this.this$0.viewModel;
        if (access$getViewModel$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            fastRecordMainViewModel = access$getViewModel$p2;
        }
        fastRecordMainViewModel.removeSelectEntity(recordEntity);
    }

    public void commandTitleClick(int i, @NotNull RecordEntity recordEntity) {
        Intrinsics.checkNotNullParameter(recordEntity, "recordEntity");
        LogExt.logI("change title", "FastRecordFragment");
        this.this$0.changeTitle(i, recordEntity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordViewAdapter} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onItemClick(int r10) {
        /*
            r9 = this;
            com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordFragment r0 = r9.this$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel r0 = r0.viewModel
            java.lang.String r1 = "viewModel"
            r2 = 0
            if (r0 != 0) goto L_0x0010
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0010:
            androidx.lifecycle.LiveData r0 = r0.getMPageStatus()
            java.lang.Object r0 = r0.getValue()
            java.lang.Integer r0 = (java.lang.Integer) r0
            java.lang.String r3 = "viewAdapter"
            if (r0 != 0) goto L_0x0020
            goto L_0x0039
        L_0x0020:
            int r0 = r0.intValue()
            r4 = 1
            if (r0 != r4) goto L_0x0039
            com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordFragment r9 = r9.this$0
            com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordViewAdapter r9 = r9.viewAdapter
            if (r9 != 0) goto L_0x0033
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L_0x0034
        L_0x0033:
            r2 = r9
        L_0x0034:
            r2.setItemChooseStatus(r10)
            goto L_0x00c8
        L_0x0039:
            com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordFragment r0 = r9.this$0
            com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordViewAdapter r0 = r0.viewAdapter
            if (r0 != 0) goto L_0x0045
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r2
        L_0x0045:
            com.upuphone.ar.fastrecord.phone.db.RecordEntity r0 = r0.getPositionData(r10)
            java.lang.String r4 = "FastRecordFragment"
            if (r0 != 0) goto L_0x0067
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "onItemClick position = "
            r9.append(r0)
            r9.append(r10)
            java.lang.String r10 = ",index"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logW(r9, r4)
            return
        L_0x0067:
            boolean r5 = r0.getAsrFail()
            int r6 = r0.getRecordStatus()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "onItemClick to detail page state = "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = ",isAsrFail = "
            r7.append(r6)
            r7.append(r5)
            java.lang.String r6 = r7.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logI(r6, r4)
            r4 = 0
            r0.setNewRecordItem(r4)
            com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordFragment r6 = r9.this$0
            com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordViewAdapter r6 = r6.viewAdapter
            if (r6 != 0) goto L_0x009b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r6 = r2
        L_0x009b:
            r6.resetAsrFailState(r10)
            com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordFragment r6 = r9.this$0
            com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordViewAdapter r6 = r6.viewAdapter
            if (r6 != 0) goto L_0x00aa
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r6 = r2
        L_0x00aa:
            r6.notifyItemChanged(r10)
            com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordFragment r10 = r9.this$0
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel r10 = r10.viewModel
            if (r10 != 0) goto L_0x00b9
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x00ba
        L_0x00b9:
            r2 = r10
        L_0x00ba:
            long r6 = r0.getRecordId()
            com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordFragment$initView$1$onItemClick$1 r10 = new com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordFragment$initView$1$onItemClick$1
            com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordFragment r9 = r9.this$0
            r10.<init>(r0, r9, r5)
            r2.updateRecordIsNewRecordItemState(r6, r4, r10)
        L_0x00c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordFragment$initView$1.onItemClick(int):void");
    }

    public void onLongClick(int i) {
        LogExt.logI("onLongClick init ", "FastRecordFragment");
        FastRecordViewAdapter access$getViewAdapter$p = this.this$0.viewAdapter;
        FastRecordMainViewModel fastRecordMainViewModel = null;
        if (access$getViewAdapter$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            access$getViewAdapter$p = null;
        }
        RecordEntity positionData = access$getViewAdapter$p.getPositionData(i);
        if (positionData == null) {
            LogExt.logW("onLongClick position = " + i + ",index", "FastRecordFragment");
            return;
        }
        FastRecordViewAdapter access$getViewAdapter$p2 = this.this$0.viewAdapter;
        if (access$getViewAdapter$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            access$getViewAdapter$p2 = null;
        }
        if (!access$getViewAdapter$p2.isRecording(positionData)) {
            LogExt.logI("onLongClick isRecording is false ", "FastRecordFragment");
            FastRecordMainViewModel access$getViewModel$p = this.this$0.viewModel;
            if (access$getViewModel$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                access$getViewModel$p = null;
            }
            access$getViewModel$p.setPageModeStatus(1);
            FastRecordViewAdapter access$getViewAdapter$p3 = this.this$0.viewAdapter;
            if (access$getViewAdapter$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                access$getViewAdapter$p3 = null;
            }
            access$getViewAdapter$p3.setChooseMode(true);
            FastRecordViewAdapter access$getViewAdapter$p4 = this.this$0.viewAdapter;
            if (access$getViewAdapter$p4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
                access$getViewAdapter$p4 = null;
            }
            access$getViewAdapter$p4.setItemChooseStatus(i);
            FastRecordMainViewModel access$getViewModel$p2 = this.this$0.viewModel;
            if (access$getViewModel$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                fastRecordMainViewModel = access$getViewModel$p2;
            }
            fastRecordMainViewModel.addSelectEntity(positionData);
        }
    }
}
