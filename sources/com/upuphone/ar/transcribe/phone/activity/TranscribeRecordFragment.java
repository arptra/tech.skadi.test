package com.upuphone.ar.transcribe.phone.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.honey.account.v4.q;
import com.honey.account.v4.r;
import com.honey.account.v4.s;
import com.honey.account.v4.t;
import com.honey.account.v4.u;
import com.honey.account.v4.v;
import com.honey.account.v4.w;
import com.honey.account.v4.x;
import com.honey.account.v4.y;
import com.honey.account.v4.z;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.TranscribeApp;
import com.upuphone.ar.transcribe.databinding.TranscribeRecordFragmentBinding;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.adapter.NoteListAdapter;
import com.upuphone.ar.transcribe.phone.bean.ListItemBean;
import com.upuphone.ar.transcribe.phone.bean.OperateMessage;
import com.upuphone.ar.transcribe.phone.bean.TranscribeStoreExtKt;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import com.upuphone.ar.transcribe.phone.helper.TranscribeDBHelper;
import com.upuphone.ar.transcribe.phone.listener.RefreshLoadListener;
import com.upuphone.ar.transcribe.phone.view.GridSpacingItemDecoration;
import com.upuphone.ar.transcribe.phone.view.TbTitleInputFilter;
import com.upuphone.ar.transcribe.phone.vm.TranscribeEditViewModel;
import com.upuphone.ar.transcribe.utils.GraphicUtils;
import com.upuphone.ar.transcribe.utils.RecycleHelper;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.star.core.log.ULog;
import flyme.support.v7.app.AlertDialog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTranscribeRecordFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranscribeRecordFragment.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeRecordFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,488:1\n262#2,2:489\n262#2,2:491\n262#2,2:493\n262#2,2:521\n58#3,23:495\n93#3,3:518\n*S KotlinDebug\n*F\n+ 1 TranscribeRecordFragment.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeRecordFragment\n*L\n252#1:489,2\n362#1:491,2\n363#1:493,2\n133#1:521,2\n448#1:495,23\n448#1:518,3\n*E\n"})
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 @2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001@B\u0005¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030 H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0016H\u0002J\b\u0010$\u001a\u00020\u0016H\u0016J\u0012\u0010%\u001a\u00020\u00162\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J$\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010.\u001a\u00020\u0016H\u0016J\"\u0010/\u001a\u00020\u00162\b\u00100\u001a\u0004\u0018\u00010\u00032\u0006\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u001dH\u0016J\b\u00103\u001a\u00020\u0016H\u0016J\u001a\u00104\u001a\u00020\u00162\u0006\u00105\u001a\u00020)2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u00106\u001a\u00020\u0016H\u0002J\u0010\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u000209H\u0002J(\u0010:\u001a\u00020\u00162\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010 2\u0006\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u001dH\u0016J\u0010\u0010<\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\u0012H\u0002J\u000e\u0010>\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003J\f\u0010?\u001a\u00020\u0012*\u00020\u0003H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\tX\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/activity/TranscribeRecordFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/upuphone/ar/transcribe/phone/listener/RefreshLoadListener;", "Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "binding", "Lcom/upuphone/ar/transcribe/databinding/TranscribeRecordFragmentBinding;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "editViewModel", "Lcom/upuphone/ar/transcribe/phone/vm/TranscribeEditViewModel;", "recordAdapter", "Lcom/upuphone/ar/transcribe/phone/adapter/NoteListAdapter;", "recycleHelper", "Lcom/upuphone/ar/transcribe/utils/RecycleHelper;", "Lcom/upuphone/ar/transcribe/phone/bean/ListItemBean;", "renameDialog", "Lflyme/support/v7/app/AlertDialog;", "addRecords", "", "transcribeBean", "deleteRecord", "formatContent", "", "source", "getDbLoadOffset", "", "getDbRecordCount", "getDiaryFromDB", "", "initAdapter", "initSmartRefresh", "initViews", "noMoreData", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onLoadMoreData", "lastModel", "pageIndex", "pageSize", "onResume", "onViewCreated", "view", "refreshList", "showControl", "haveData", "", "showData", "dataList", "showRenameDialog", "bean", "updateRecord", "toItemBean", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranscribeRecordFragment extends Fragment implements RefreshLoadListener<TranscribeBean>, CoroutineScope {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "TransRecordFragment";
    private final /* synthetic */ CoroutineScope $$delegate_0 = CoroutineScopeKt.b();
    /* access modifiers changed from: private */
    public TranscribeRecordFragmentBinding binding;
    /* access modifiers changed from: private */
    public TranscribeEditViewModel editViewModel;
    /* access modifiers changed from: private */
    public NoteListAdapter recordAdapter;
    /* access modifiers changed from: private */
    public RecycleHelper<ListItemBean> recycleHelper;
    /* access modifiers changed from: private */
    @Nullable
    public AlertDialog renameDialog;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/activity/TranscribeRecordFragment$Companion;", "", "()V", "TAG", "", "newInstance", "Lcom/upuphone/ar/transcribe/phone/activity/TranscribeRecordFragment;", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final TranscribeRecordFragment newInstance() {
            return new TranscribeRecordFragment();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public static final void addRecords$lambda$8(TranscribeBean transcribeBean, TranscribeRecordFragment transcribeRecordFragment) {
        Intrinsics.checkNotNullParameter(transcribeBean, "$transcribeBean");
        Intrinsics.checkNotNullParameter(transcribeRecordFragment, "this$0");
        TranscribeStoreExtKt.assembleTitle(transcribeBean);
        NoteListAdapter noteListAdapter = transcribeRecordFragment.recordAdapter;
        NoteListAdapter noteListAdapter2 = null;
        if (noteListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recordAdapter");
            noteListAdapter = null;
        }
        boolean z = false;
        noteListAdapter.p(0, transcribeRecordFragment.toItemBean(transcribeBean));
        TranscribeEditViewModel transcribeEditViewModel = transcribeRecordFragment.editViewModel;
        if (transcribeEditViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editViewModel");
            transcribeEditViewModel = null;
        }
        NoteListAdapter noteListAdapter3 = transcribeRecordFragment.recordAdapter;
        if (noteListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recordAdapter");
            noteListAdapter3 = null;
        }
        transcribeEditViewModel.x(noteListAdapter3.getItemCount());
        TranscribeRecordFragmentBinding transcribeRecordFragmentBinding = transcribeRecordFragment.binding;
        if (transcribeRecordFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            transcribeRecordFragmentBinding = null;
        }
        transcribeRecordFragmentBinding.f.scrollToPosition(0);
        NoteListAdapter noteListAdapter4 = transcribeRecordFragment.recordAdapter;
        if (noteListAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recordAdapter");
        } else {
            noteListAdapter2 = noteListAdapter4;
        }
        if (noteListAdapter2.getItemCount() > 0) {
            z = true;
        }
        transcribeRecordFragment.showControl(z);
    }

    private final String formatContent(String str) {
        List split$default = StringsKt.split$default((CharSequence) str, new String[]{StringUtils.LF}, false, 0, 6, (Object) null);
        return split$default.size() > 1 ? (String) split$default.get(0) : str;
    }

    private final int getDbLoadOffset() {
        NoteListAdapter noteListAdapter = null;
        if (TranscribeDBHelper.f6108a.k() == null) {
            NoteListAdapter noteListAdapter2 = this.recordAdapter;
            if (noteListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recordAdapter");
            } else {
                noteListAdapter = noteListAdapter2;
            }
            return noteListAdapter.getItemCount();
        }
        NoteListAdapter noteListAdapter3 = this.recordAdapter;
        if (noteListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recordAdapter");
        } else {
            noteListAdapter = noteListAdapter3;
        }
        return noteListAdapter.getItemCount() + 1;
    }

    /* access modifiers changed from: private */
    public final int getDbRecordCount() {
        return TranscribeDBHelper.f6108a.a();
    }

    /* access modifiers changed from: private */
    public final List<TranscribeBean> getDiaryFromDB() {
        int dbLoadOffset = getDbLoadOffset();
        LogExt.g("getDiaryFromDB 转写 loadOffset=" + dbLoadOffset, TAG);
        TranscribeDBHelper transcribeDBHelper = TranscribeDBHelper.f6108a;
        RecycleHelper<ListItemBean> recycleHelper2 = this.recycleHelper;
        if (recycleHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleHelper");
            recycleHelper2 = null;
        }
        List<TranscribeBean> mutableList = CollectionsKt.toMutableList(transcribeDBHelper.h(recycleHelper2.d(), dbLoadOffset));
        int size = mutableList.size();
        LogExt.d("getDiaryFromDB: 转写, noteBeanList size=" + size, TAG);
        int i = 0;
        for (TranscribeBean next : mutableList) {
            TranscribeStoreExtKt.assembleTitle(next);
            next.setTransResult("");
            Unit unit = Unit.INSTANCE;
            mutableList.set(i, next);
            i++;
        }
        return mutableList;
    }

    private final void initAdapter() {
        NoteListAdapter noteListAdapter = new NoteListAdapter(R.layout.trsb_item_list_note, new ArrayList(), new r(this));
        this.recordAdapter = noteListAdapter;
        noteListAdapter.q0(new s(this));
        NoteListAdapter noteListAdapter2 = this.recordAdapter;
        TranscribeRecordFragmentBinding transcribeRecordFragmentBinding = null;
        if (noteListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recordAdapter");
            noteListAdapter2 = null;
        }
        noteListAdapter2.s0(new t(this));
        TranscribeRecordFragmentBinding transcribeRecordFragmentBinding2 = this.binding;
        if (transcribeRecordFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            transcribeRecordFragmentBinding2 = null;
        }
        transcribeRecordFragmentBinding2.f.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        TranscribeRecordFragmentBinding transcribeRecordFragmentBinding3 = this.binding;
        if (transcribeRecordFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            transcribeRecordFragmentBinding3 = null;
        }
        transcribeRecordFragmentBinding3.f.addItemDecoration(new GridSpacingItemDecoration(1, GraphicUtils.a(12.0f), false));
        TranscribeRecordFragmentBinding transcribeRecordFragmentBinding4 = this.binding;
        if (transcribeRecordFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            transcribeRecordFragmentBinding4 = null;
        }
        transcribeRecordFragmentBinding4.f.setItemAnimator((RecyclerView.ItemAnimator) null);
        TranscribeRecordFragmentBinding transcribeRecordFragmentBinding5 = this.binding;
        if (transcribeRecordFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            transcribeRecordFragmentBinding5 = null;
        }
        RecyclerView recyclerView = transcribeRecordFragmentBinding5.f;
        NoteListAdapter noteListAdapter3 = this.recordAdapter;
        if (noteListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recordAdapter");
            noteListAdapter3 = null;
        }
        recyclerView.setAdapter(noteListAdapter3);
        TranscribeRecordFragmentBinding transcribeRecordFragmentBinding6 = this.binding;
        if (transcribeRecordFragmentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            transcribeRecordFragmentBinding = transcribeRecordFragmentBinding6;
        }
        transcribeRecordFragmentBinding.f.addOnScrollListener(new TranscribeRecordFragment$initAdapter$4(this));
    }

    /* access modifiers changed from: private */
    public static final void initAdapter$lambda$1(TranscribeRecordFragment transcribeRecordFragment, ListItemBean listItemBean) {
        Intrinsics.checkNotNullParameter(transcribeRecordFragment, "this$0");
        Intrinsics.checkNotNullParameter(listItemBean, "it");
        transcribeRecordFragment.showRenameDialog(listItemBean);
    }

    /* access modifiers changed from: private */
    public static final void initAdapter$lambda$5(TranscribeRecordFragment transcribeRecordFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(transcribeRecordFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        NoteListAdapter noteListAdapter = transcribeRecordFragment.recordAdapter;
        NoteListAdapter noteListAdapter2 = null;
        if (noteListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recordAdapter");
            noteListAdapter = null;
        }
        if (noteListAdapter.x0()) {
            Object item = baseQuickAdapter.getItem(i);
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.upuphone.ar.transcribe.phone.bean.ListItemBean");
            ListItemBean listItemBean = (ListItemBean) item;
            listItemBean.setSelected(!listItemBean.isSelected());
            if (listItemBean.isSelected()) {
                TranscribeEditViewModel transcribeEditViewModel = transcribeRecordFragment.editViewModel;
                if (transcribeEditViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editViewModel");
                    transcribeEditViewModel = null;
                }
                transcribeEditViewModel.f(listItemBean.getId());
            } else {
                TranscribeEditViewModel transcribeEditViewModel2 = transcribeRecordFragment.editViewModel;
                if (transcribeEditViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editViewModel");
                    transcribeEditViewModel2 = null;
                }
                transcribeEditViewModel2.t(listItemBean.getId());
            }
            NoteListAdapter noteListAdapter3 = transcribeRecordFragment.recordAdapter;
            if (noteListAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recordAdapter");
            } else {
                noteListAdapter2 = noteListAdapter3;
            }
            noteListAdapter2.j0(i, listItemBean);
            return;
        }
        FragmentActivity activity = transcribeRecordFragment.getActivity();
        if (activity != null) {
            Intent intent = new Intent(activity, TranscribeDetailActivity.class);
            ListItemBean listItemBean2 = (ListItemBean) baseQuickAdapter.getItem(i);
            intent.putExtra(TranslatorConstants.TRANSLATION_RECORD_ITEM_ID, listItemBean2 != null ? listItemBean2.getId() : -1);
            transcribeRecordFragment.startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    public static final boolean initAdapter$lambda$6(TranscribeRecordFragment transcribeRecordFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(transcribeRecordFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        NoteListAdapter noteListAdapter = transcribeRecordFragment.recordAdapter;
        TranscribeEditViewModel transcribeEditViewModel = null;
        if (noteListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recordAdapter");
            noteListAdapter = null;
        }
        if (!noteListAdapter.x0()) {
            NoteListAdapter noteListAdapter2 = transcribeRecordFragment.recordAdapter;
            if (noteListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recordAdapter");
                noteListAdapter2 = null;
            }
            noteListAdapter2.y0(true);
            Object item = baseQuickAdapter.getItem(i);
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.upuphone.ar.transcribe.phone.bean.ListItemBean");
            ListItemBean listItemBean = (ListItemBean) item;
            listItemBean.setSelected(true);
            TranscribeEditViewModel transcribeEditViewModel2 = transcribeRecordFragment.editViewModel;
            if (transcribeEditViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editViewModel");
                transcribeEditViewModel2 = null;
            }
            transcribeEditViewModel2.f(listItemBean.getId());
            NoteListAdapter noteListAdapter3 = transcribeRecordFragment.recordAdapter;
            if (noteListAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recordAdapter");
                noteListAdapter3 = null;
            }
            noteListAdapter3.notifyDataSetChanged();
            TranscribeEditViewModel transcribeEditViewModel3 = transcribeRecordFragment.editViewModel;
            if (transcribeEditViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editViewModel");
            } else {
                transcribeEditViewModel = transcribeEditViewModel3;
            }
            transcribeEditViewModel.h(true);
        }
        return true;
    }

    private final void initSmartRefresh() {
        TranscribeRecordFragmentBinding transcribeRecordFragmentBinding = this.binding;
        TranscribeRecordFragmentBinding transcribeRecordFragmentBinding2 = null;
        if (transcribeRecordFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            transcribeRecordFragmentBinding = null;
        }
        transcribeRecordFragmentBinding.g.z(false);
        TranscribeRecordFragmentBinding transcribeRecordFragmentBinding3 = this.binding;
        if (transcribeRecordFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            transcribeRecordFragmentBinding3 = null;
        }
        transcribeRecordFragmentBinding3.g.B(new TranscribeRecordFragment$initSmartRefresh$1(this));
        TranscribeRecordFragmentBinding transcribeRecordFragmentBinding4 = this.binding;
        if (transcribeRecordFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            transcribeRecordFragmentBinding2 = transcribeRecordFragmentBinding4;
        }
        this.recycleHelper = new RecycleHelper<>(this, transcribeRecordFragmentBinding2.g);
    }

    private final void initViews() {
        TranscribeRecordFragmentBinding transcribeRecordFragmentBinding = this.binding;
        if (transcribeRecordFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            transcribeRecordFragmentBinding = null;
        }
        transcribeRecordFragmentBinding.d.setOnClickListener(new q(this));
        TranscribeDBHelper.f6108a.u(TAG, new TranscribeRecordFragment$initViews$2(this));
        initAdapter();
        initSmartRefresh();
        refreshList();
        TranscribeApp.registerUiUpdateCallback(TAG, new TranscribeRecordFragment$initViews$3(this));
    }

    /* access modifiers changed from: private */
    public static final void initViews$lambda$0(TranscribeRecordFragment transcribeRecordFragment, View view) {
        Intrinsics.checkNotNullParameter(transcribeRecordFragment, "this$0");
        TranscribeRecordFragmentBinding transcribeRecordFragmentBinding = transcribeRecordFragment.binding;
        TranscribeRecordFragmentBinding transcribeRecordFragmentBinding2 = null;
        if (transcribeRecordFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            transcribeRecordFragmentBinding = null;
        }
        transcribeRecordFragmentBinding.f.scrollToPosition(0);
        TranscribeRecordFragmentBinding transcribeRecordFragmentBinding3 = transcribeRecordFragment.binding;
        if (transcribeRecordFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            transcribeRecordFragmentBinding2 = transcribeRecordFragmentBinding3;
        }
        ImageView imageView = transcribeRecordFragmentBinding2.d;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivToTop");
        imageView.setVisibility(8);
    }

    @JvmStatic
    @NotNull
    public static final TranscribeRecordFragment newInstance() {
        return Companion.newInstance();
    }

    private final void refreshList() {
        RecycleHelper<ListItemBean> recycleHelper2 = this.recycleHelper;
        if (recycleHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleHelper");
            recycleHelper2 = null;
        }
        recycleHelper2.h();
    }

    /* access modifiers changed from: private */
    public final void showControl(boolean z) {
        TranscribeRecordFragmentBinding transcribeRecordFragmentBinding = this.binding;
        TranscribeRecordFragmentBinding transcribeRecordFragmentBinding2 = null;
        if (transcribeRecordFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            transcribeRecordFragmentBinding = null;
        }
        Group group = transcribeRecordFragmentBinding.b;
        Intrinsics.checkNotNullExpressionValue(group, "gpNoData");
        int i = 8;
        group.setVisibility(z ^ true ? 0 : 8);
        TranscribeRecordFragmentBinding transcribeRecordFragmentBinding3 = this.binding;
        if (transcribeRecordFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            transcribeRecordFragmentBinding2 = transcribeRecordFragmentBinding3;
        }
        SmartRefreshLayout smartRefreshLayout = transcribeRecordFragmentBinding2.g;
        Intrinsics.checkNotNullExpressionValue(smartRefreshLayout, "smartRefresh");
        if (z) {
            i = 0;
        }
        smartRefreshLayout.setVisibility(i);
        TranscribeApp.notifyVariousMsg(new OperateMessage(1001, Boolean.valueOf(z)));
    }

    private final void showRenameDialog(ListItemBean listItemBean) {
        if (getActivity() != null) {
            View inflate = getLayoutInflater().inflate(R.layout.transcribe_dialog_input_view, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.iv_input_del);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            ImageView imageView = (ImageView) findViewById;
            View findViewById2 = inflate.findViewById(R.id.et_input_text);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            EditText editText = (EditText) findViewById2;
            editText.setFilters((InputFilter[]) new TbTitleInputFilter[]{new TbTitleInputFilter()});
            editText.addTextChangedListener(new TranscribeRecordFragment$showRenameDialog$$inlined$doAfterTextChanged$1(this, listItemBean, imageView));
            imageView.setOnClickListener(new v(editText));
            editText.addOnLayoutChangeListener(new w(editText));
            editText.setText(listItemBean.getTitle());
            AlertDialog create = new AlertDialog.Builder(requireActivity()).setTitle(R.string.trsb_rename).setPositiveButton(R.string.fast_record_save, (DialogInterface.OnClickListener) new x(editText, this, listItemBean)).setNegativeButton(R.string.trsb_dialog_cancel, (DialogInterface.OnClickListener) new y()).create();
            this.renameDialog = create;
            if (create != null) {
                create.setView(inflate);
            }
            AlertDialog alertDialog = this.renameDialog;
            if (alertDialog != null) {
                alertDialog.setOnShowListener(new z(this));
            }
            AlertDialog alertDialog2 = this.renameDialog;
            if (alertDialog2 != null) {
                alertDialog2.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void showRenameDialog$lambda$10(EditText editText, View view) {
        Intrinsics.checkNotNullParameter(editText, "$editText");
        editText.setText((CharSequence) null);
    }

    /* access modifiers changed from: private */
    public static final void showRenameDialog$lambda$11(EditText editText, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(editText, "$editText");
        editText.setSelection(editText.getText().length());
    }

    /* access modifiers changed from: private */
    public static final void showRenameDialog$lambda$12(EditText editText, TranscribeRecordFragment transcribeRecordFragment, ListItemBean listItemBean, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(editText, "$editText");
        Intrinsics.checkNotNullParameter(transcribeRecordFragment, "this$0");
        Intrinsics.checkNotNullParameter(listItemBean, "$bean");
        String obj = editText.getText().toString();
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g(TAG, "change title to value = " + obj);
        if (!TextUtils.isEmpty(obj)) {
            Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(transcribeRecordFragment), Dispatchers.b(), (CoroutineStart) null, new TranscribeRecordFragment$showRenameDialog$4$1(listItemBean, obj, transcribeRecordFragment, (Continuation<? super TranscribeRecordFragment$showRenameDialog$4$1>) null), 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void showRenameDialog$lambda$13(DialogInterface dialogInterface, int i) {
    }

    /* access modifiers changed from: private */
    public static final void showRenameDialog$lambda$14(TranscribeRecordFragment transcribeRecordFragment, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(transcribeRecordFragment, "this$0");
        AlertDialog alertDialog = transcribeRecordFragment.renameDialog;
        Button button = alertDialog != null ? alertDialog.getButton(-1) : null;
        if (button != null) {
            button.setEnabled(false);
        }
    }

    /* access modifiers changed from: private */
    public final ListItemBean toItemBean(TranscribeBean transcribeBean) {
        Long id = transcribeBean.getId();
        long longValue = id != null ? id.longValue() : 0;
        long recordTime = transcribeBean.getRecordTime();
        int type = transcribeBean.getType();
        String superTitle = transcribeBean.getSuperTitle();
        String title = transcribeBean.getTitle();
        String str = "";
        if (title == null) {
            title = str;
        }
        String formatContent = formatContent(title);
        String title2 = transcribeBean.getTitle2();
        if (title2 != null) {
            str = title2;
        }
        return new ListItemBean(longValue, recordTime, type, superTitle, formatContent, formatContent(str), -1, transcribeBean.getSimpleLocation(), false, 256, (DefaultConstructorMarker) null);
    }

    public final void addRecords(@NotNull TranscribeBean transcribeBean) {
        Intrinsics.checkNotNullParameter(transcribeBean, "transcribeBean");
        LogExt.g("notifyItemChanged id=" + transcribeBean.getId(), TAG);
        NoteListAdapter noteListAdapter = this.recordAdapter;
        TranscribeRecordFragmentBinding transcribeRecordFragmentBinding = null;
        if (noteListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recordAdapter");
            noteListAdapter = null;
        }
        if (!noteListAdapter.getData().contains(toItemBean(transcribeBean))) {
            TranscribeRecordFragmentBinding transcribeRecordFragmentBinding2 = this.binding;
            if (transcribeRecordFragmentBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                transcribeRecordFragmentBinding = transcribeRecordFragmentBinding2;
            }
            transcribeRecordFragmentBinding.f.post(new u(transcribeBean, this));
        }
    }

    public final void deleteRecord(@NotNull TranscribeBean transcribeBean) {
        Intrinsics.checkNotNullParameter(transcribeBean, "transcribeBean");
        LogExt.g("deleteRecord noteBean=" + transcribeBean, TAG);
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranscribeRecordFragment$deleteRecord$1(this, transcribeBean, (Continuation<? super TranscribeRecordFragment$deleteRecord$1>) null), 2, (Object) null);
    }

    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public void noMoreData() {
        LogExt.d("noMoreData 转写 无数据需要被加载", TAG);
        NoteListAdapter noteListAdapter = this.recordAdapter;
        if (noteListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recordAdapter");
            noteListAdapter = null;
        }
        if (noteListAdapter.getItemCount() == 0) {
            showControl(false);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        this.editViewModel = (TranscribeEditViewModel) new ViewModelProvider(requireActivity).get(TranscribeEditViewModel.class);
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TranscribeRecordFragment$onCreate$1(this, (Continuation<? super TranscribeRecordFragment$onCreate$1>) null), 3, (Object) null);
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        TranscribeRecordFragmentBinding c = TranscribeRecordFragmentBinding.c(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.binding = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        ConstraintLayout b = c.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onDestroy() {
        super.onDestroy();
        TranscribeDBHelper.f6108a.z(TAG);
        CoroutineScopeKt.e(this, (CancellationException) null, 1, (Object) null);
        AlertDialog alertDialog = this.renameDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.renameDialog = null;
    }

    public void onResume() {
        super.onResume();
        TranscribeRecordFragmentBinding transcribeRecordFragmentBinding = this.binding;
        TranscribeRecordFragmentBinding transcribeRecordFragmentBinding2 = null;
        if (transcribeRecordFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            transcribeRecordFragmentBinding = null;
        }
        RecyclerView.LayoutManager layoutManager = transcribeRecordFragmentBinding.f.getLayoutManager();
        if (layoutManager != null && (layoutManager instanceof LinearLayoutManager)) {
            int findLastCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
            TranscribeRecordFragmentBinding transcribeRecordFragmentBinding3 = this.binding;
            if (transcribeRecordFragmentBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                transcribeRecordFragmentBinding2 = transcribeRecordFragmentBinding3;
            }
            ImageView imageView = transcribeRecordFragmentBinding2.d;
            Intrinsics.checkNotNullExpressionValue(imageView, "ivToTop");
            int i = 0;
            if (!(findLastCompletelyVisibleItemPosition > 5)) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        LogExt.g("initData recordType=转写", TAG);
        initViews();
    }

    public void showData(@Nullable List<TranscribeBean> list, int i, int i2) {
        TranscribeRecordFragmentBinding transcribeRecordFragmentBinding = this.binding;
        NoteListAdapter noteListAdapter = null;
        if (transcribeRecordFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            transcribeRecordFragmentBinding = null;
        }
        boolean z = false;
        transcribeRecordFragmentBinding.g.a(false);
        NoteListAdapter noteListAdapter2 = this.recordAdapter;
        if (noteListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recordAdapter");
        } else {
            noteListAdapter = noteListAdapter2;
        }
        if (noteListAdapter.getItemCount() > 0) {
            z = true;
        }
        showControl(z);
    }

    public final void updateRecord(@NotNull TranscribeBean transcribeBean) {
        Intrinsics.checkNotNullParameter(transcribeBean, "transcribeBean");
        LogExt.g("updateRecord noteBean=" + transcribeBean, TAG);
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranscribeRecordFragment$updateRecord$1(this, transcribeBean, (Continuation<? super TranscribeRecordFragment$updateRecord$1>) null), 2, (Object) null);
    }

    public void onLoadMoreData(@Nullable TranscribeBean transcribeBean, int i, int i2) {
        Job unused = BuildersKt__Builders_commonKt.d(this, Dispatchers.c(), (CoroutineStart) null, new TranscribeRecordFragment$onLoadMoreData$1(this, i, i2, (Continuation<? super TranscribeRecordFragment$onLoadMoreData$1>) null), 2, (Object) null);
    }
}
