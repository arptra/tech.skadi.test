package com.upuphone.ar.translation.phone.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.honey.account.f5.q0;
import com.honey.account.f5.r0;
import com.honey.account.f5.s0;
import com.honey.account.f5.t0;
import com.honey.account.f5.u0;
import com.honey.account.f5.v0;
import com.meizu.common.widget.MzContactsContract;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordFragment;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.DialogExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.TranslationManager;
import com.upuphone.ar.translation.phone.activity.TranslatorRecordActivity;
import com.upuphone.ar.translation.phone.adapter.NoteListAdapter;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.bean.OperateMessage;
import com.upuphone.ar.translation.phone.databinding.AlertDialogInputSingleTextBinding;
import com.upuphone.ar.translation.phone.databinding.LayoutTlDialogCustomTitleBinding;
import com.upuphone.ar.translation.phone.databinding.TransRecordFragmentBinding;
import com.upuphone.ar.translation.phone.helper.RecordTitleHelper;
import com.upuphone.ar.translation.phone.listener.RefreshLoadListener;
import com.upuphone.ar.translation.phone.view.EditTitleInputFilter;
import com.upuphone.ar.translation.phone.view.GridSpacingItemDecoration;
import com.upuphone.ar.translation.phone.vm.TranslatorRecordListViewModel;
import com.upuphone.ar.translation.phone.vm.TranslatorRecordShareViewModel;
import com.upuphone.ar.translation.utils.GraphicUtils;
import com.upuphone.ar.translation.utils.RecycleHelper;
import flyme.support.v7.app.AlertDialog;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@SourceDebugExtension({"SMAP\nTransRecordFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransRecordFragment.kt\ncom/upuphone/ar/translation/phone/fragment/TransRecordFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,565:1\n106#2,15:566\n262#3,2:581\n262#3,2:583\n262#3,2:585\n262#3,2:606\n65#4,16:587\n93#4,3:603\n*S KotlinDebug\n*F\n+ 1 TransRecordFragment.kt\ncom/upuphone/ar/translation/phone/fragment/TransRecordFragment\n*L\n83#1:566,15\n116#1:581,2\n405#1:583,2\n406#1:585,2\n141#1:606,2\n546#1:587,16\n546#1:603,3\n*E\n"})
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Q2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001RB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0005J)\u0010\u0019\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001b\u0010\u0005J/\u0010\u001e\u001a\u00020\u00102\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001c2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0003¢\u0006\u0004\b!\u0010\"J\u001f\u0010%\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u001f\u0010'\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020#¢\u0006\u0004\b'\u0010&J\u000f\u0010(\u001a\u00020\u0010H\u0007¢\u0006\u0004\b(\u0010\u0005J\u000f\u0010)\u001a\u00020\u0010H\u0002¢\u0006\u0004\b)\u0010\u0005J\u000f\u0010*\u001a\u00020\u0010H\u0002¢\u0006\u0004\b*\u0010\u0005J\u000f\u0010+\u001a\u00020\u0010H\u0002¢\u0006\u0004\b+\u0010\u0005J\u000f\u0010,\u001a\u00020\u0010H\u0002¢\u0006\u0004\b,\u0010\u0005J\u000f\u0010-\u001a\u00020\u0010H\u0002¢\u0006\u0004\b-\u0010\u0005J\u000f\u0010.\u001a\u00020\u0010H\u0002¢\u0006\u0004\b.\u0010\u0005J\u0017\u00100\u001a\u00020\u00102\u0006\u0010/\u001a\u00020#H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0003H\u0002¢\u0006\u0004\b2\u0010\"R\u0016\u00106\u001a\u0002038\u0002@\u0002X.¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00030;8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bH\u0010IR\u001b\u0010P\u001a\u00020K8BX\u0002¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O¨\u0006S"}, d2 = {"Lcom/upuphone/ar/translation/phone/fragment/TransRecordFragment;", "Lcom/upuphone/ar/translation/phone/fragment/TransBaseFragment;", "Lcom/upuphone/ar/translation/phone/listener/RefreshLoadListener;", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onDestroy", "lastModel", "", "pageIndex", "pageSize", "G0", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;II)V", "noMoreData", "", "dataList", "showData", "(Ljava/util/List;II)V", "noteBean", "w0", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;)V", "", "isUpdateTitle", "y0", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;Z)V", "K0", "E0", "initData", "initAdapter", "initSmartRefresh", "initViewModels", "F0", "refreshList", "isHaveData", "showControl", "(Z)V", "H0", "Lcom/upuphone/ar/translation/phone/databinding/TransRecordFragmentBinding;", "a", "Lcom/upuphone/ar/translation/phone/databinding/TransRecordFragmentBinding;", "mBinding", "", "b", "Ljava/lang/String;", "mRecordType", "Lcom/upuphone/ar/translation/utils/RecycleHelper;", "c", "Lcom/upuphone/ar/translation/utils/RecycleHelper;", "mRecycleHelper", "Lcom/upuphone/ar/translation/phone/adapter/NoteListAdapter;", "d", "Lcom/upuphone/ar/translation/phone/adapter/NoteListAdapter;", "mRecordAdapter", "Lflyme/support/v7/app/AlertDialog;", "e", "Lflyme/support/v7/app/AlertDialog;", "mSingleInputDialog", "Lcom/upuphone/ar/translation/phone/vm/TranslatorRecordShareViewModel;", "f", "Lcom/upuphone/ar/translation/phone/vm/TranslatorRecordShareViewModel;", "mRecordShareVm", "Lcom/upuphone/ar/translation/phone/vm/TranslatorRecordListViewModel;", "g", "Lkotlin/Lazy;", "z0", "()Lcom/upuphone/ar/translation/phone/vm/TranslatorRecordListViewModel;", "mRecordListVm", "h", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TransRecordFragment extends TransBaseFragment implements RefreshLoadListener<NoteBean> {
    public static final Companion h = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public TransRecordFragmentBinding f6290a;
    public String b = "all_records";
    public RecycleHelper c;
    public NoteListAdapter d;
    public AlertDialog e;
    public TranslatorRecordShareViewModel f;
    public final Lazy g;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/upuphone/ar/translation/phone/fragment/TransRecordFragment$Companion;", "", "<init>", "()V", "", "recordType", "Lcom/upuphone/ar/translation/phone/fragment/TransRecordFragment;", "a", "(Ljava/lang/String;)Lcom/upuphone/ar/translation/phone/fragment/TransRecordFragment;", "RECORD_TYPE", "Ljava/lang/String;", "TAG", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TransRecordFragment a(String str) {
            Intrinsics.checkNotNullParameter(str, FastRecordFragment.RECORD_TYPE);
            TransRecordFragment transRecordFragment = new TransRecordFragment();
            Bundle bundle = new Bundle();
            bundle.putString(MzContactsContract.MzContactColumns.RECORD_TYPE, str);
            transRecordFragment.setArguments(bundle);
            return transRecordFragment;
        }

        public Companion() {
        }
    }

    public TransRecordFragment() {
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new TransRecordFragment$special$$inlined$viewModels$default$2(new TransRecordFragment$special$$inlined$viewModels$default$1(this)));
        this.g = FragmentViewModelLazyKt.c(this, Reflection.getOrCreateKotlinClass(TranslatorRecordListViewModel.class), new TransRecordFragment$special$$inlined$viewModels$default$3(lazy), new TransRecordFragment$special$$inlined$viewModels$default$4((Function0) null, lazy), new TransRecordFragment$special$$inlined$viewModels$default$5(this, lazy));
    }

    public static final void A0(TransRecordFragment transRecordFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(transRecordFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        NoteListAdapter noteListAdapter = transRecordFragment.d;
        NoteListAdapter noteListAdapter2 = null;
        if (noteListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
            noteListAdapter = null;
        }
        if (noteListAdapter.x0()) {
            Object item = baseQuickAdapter.getItem(i);
            if (item instanceof NoteBean) {
                NoteBean noteBean = (NoteBean) item;
                noteBean.setDeleted(!noteBean.isDeleted());
                NoteListAdapter noteListAdapter3 = transRecordFragment.d;
                if (noteListAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
                } else {
                    noteListAdapter2 = noteListAdapter3;
                }
                noteListAdapter2.j0(i, item);
            }
            transRecordFragment.F0();
            return;
        }
        FragmentActivity activity = transRecordFragment.getActivity();
        if (activity != null) {
            Intent intent = new Intent(activity, TranslatorRecordActivity.class);
            NoteBean noteBean2 = (NoteBean) baseQuickAdapter.getItem(i);
            intent.putExtra(TranslatorConstants.TRANSLATION_RECORD_ITEM_ID, noteBean2 != null ? noteBean2.getId() : -1);
            transRecordFragment.startActivity(intent);
        }
    }

    public static final void B0(TransRecordFragment transRecordFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(transRecordFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        NoteListAdapter noteListAdapter = transRecordFragment.d;
        if (noteListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
            noteListAdapter = null;
        }
        if (!noteListAdapter.x0()) {
            Object obj = baseQuickAdapter.getData().get(i);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.upuphone.ar.translation.phone.bean.NoteBean");
            NoteBean noteBean = (NoteBean) obj;
            if (view.getId() == R.id.tv_item_title) {
                transRecordFragment.H0(noteBean);
            }
        }
    }

    public static final boolean C0(TransRecordFragment transRecordFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(transRecordFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (!TranslatorConstants.isAirPro()) {
            return false;
        }
        NoteListAdapter noteListAdapter = transRecordFragment.d;
        TranslatorRecordShareViewModel translatorRecordShareViewModel = null;
        if (noteListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
            noteListAdapter = null;
        }
        if (!noteListAdapter.x0()) {
            NoteListAdapter noteListAdapter2 = transRecordFragment.d;
            if (noteListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
                noteListAdapter2 = null;
            }
            noteListAdapter2.y0(true, true);
            transRecordFragment.z0().k(true);
            Object item = baseQuickAdapter.getItem(i);
            if (item instanceof NoteBean) {
                NoteBean noteBean = (NoteBean) item;
                noteBean.setDeleted(!noteBean.isDeleted());
                NoteListAdapter noteListAdapter3 = transRecordFragment.d;
                if (noteListAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
                    noteListAdapter3 = null;
                }
                noteListAdapter3.j0(i, item);
            }
            TranslatorRecordShareViewModel translatorRecordShareViewModel2 = transRecordFragment.f;
            if (translatorRecordShareViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecordShareVm");
            } else {
                translatorRecordShareViewModel = translatorRecordShareViewModel2;
            }
            translatorRecordShareViewModel.n(true);
            transRecordFragment.F0();
        }
        return false;
    }

    public static final void D0(TransRecordFragment transRecordFragment, View view) {
        Intrinsics.checkNotNullParameter(transRecordFragment, "this$0");
        TransRecordFragmentBinding transRecordFragmentBinding = transRecordFragment.f6290a;
        TransRecordFragmentBinding transRecordFragmentBinding2 = null;
        if (transRecordFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            transRecordFragmentBinding = null;
        }
        transRecordFragmentBinding.f.scrollToPosition(0);
        TransRecordFragmentBinding transRecordFragmentBinding3 = transRecordFragment.f6290a;
        if (transRecordFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            transRecordFragmentBinding2 = transRecordFragmentBinding3;
        }
        ImageView imageView = transRecordFragmentBinding2.d;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivToTop");
        imageView.setVisibility(8);
    }

    public static final void I0(NoteBean noteBean, TransRecordFragment transRecordFragment, AlertDialogInputSingleTextBinding alertDialogInputSingleTextBinding, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(noteBean, "$noteBean");
        Intrinsics.checkNotNullParameter(transRecordFragment, "this$0");
        Intrinsics.checkNotNullParameter(alertDialogInputSingleTextBinding, "$inputBinding");
        noteBean.setTitle(alertDialogInputSingleTextBinding.b.getText().toString());
        Unit unit = Unit.INSTANCE;
        TranslationApp.notifyVariousMsg$ar_translator_intlRelease(new OperateMessage(1005, noteBean));
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(transRecordFragment), Dispatchers.b(), (CoroutineStart) null, new TransRecordFragment$showSingleInputDialog$1$1$2(noteBean, (Continuation<? super TransRecordFragment$showSingleInputDialog$1$1$2>) null), 2, (Object) null);
        dialogInterface.dismiss();
    }

    public static final void J0(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    private final void initData() {
        Bundle arguments = getArguments();
        TransRecordFragmentBinding transRecordFragmentBinding = null;
        String str = "all_records";
        String string = arguments != null ? arguments.getString(MzContactsContract.MzContactColumns.RECORD_TYPE, str) : null;
        if (string != null) {
            str = string;
        }
        this.b = str;
        LogExt.j("initData recordType=" + str, "TransRecordFragment");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        this.f = (TranslatorRecordShareViewModel) new ViewModelProvider(requireActivity).get(TranslatorRecordShareViewModel.class);
        TransRecordFragmentBinding transRecordFragmentBinding2 = this.f6290a;
        if (transRecordFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            transRecordFragmentBinding = transRecordFragmentBinding2;
        }
        transRecordFragmentBinding.d.setOnClickListener(new t0(this));
    }

    private final void initViewModels() {
        TranslatorRecordShareViewModel translatorRecordShareViewModel = this.f;
        TranslatorRecordShareViewModel translatorRecordShareViewModel2 = null;
        if (translatorRecordShareViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecordShareVm");
            translatorRecordShareViewModel = null;
        }
        translatorRecordShareViewModel.j().observe(getViewLifecycleOwner(), new TransRecordFragment$sam$androidx_lifecycle_Observer$0(new TransRecordFragment$initViewModels$1(this)));
        TranslatorRecordShareViewModel translatorRecordShareViewModel3 = this.f;
        if (translatorRecordShareViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecordShareVm");
        } else {
            translatorRecordShareViewModel2 = translatorRecordShareViewModel3;
        }
        translatorRecordShareViewModel2.l().observe(getViewLifecycleOwner(), new TransRecordFragment$sam$androidx_lifecycle_Observer$0(new TransRecordFragment$initViewModels$2(this)));
    }

    public final void E0() {
        NoteListAdapter noteListAdapter = this.d;
        NoteListAdapter noteListAdapter2 = null;
        if (noteListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
            noteListAdapter = null;
        }
        if (!noteListAdapter.getData().isEmpty()) {
            NoteListAdapter noteListAdapter3 = this.d;
            if (noteListAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
            } else {
                noteListAdapter2 = noteListAdapter3;
            }
            noteListAdapter2.notifyDataSetChanged();
        }
    }

    public final void F0() {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.b(), (CoroutineStart) null, new TransRecordFragment$notifyMultiDelete$1(this, (Continuation<? super TransRecordFragment$notifyMultiDelete$1>) null), 2, (Object) null);
    }

    /* renamed from: G0 */
    public void onLoadMoreData(NoteBean noteBean, int i, int i2) {
        LogExt.j("onLoadMoreData outer", "TransRecordFragment");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TransRecordFragment$onLoadMoreData$1(this, i, i2, (Continuation<? super TransRecordFragment$onLoadMoreData$1>) null), 2, (Object) null);
    }

    public final void H0(NoteBean noteBean) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            AlertDialogInputSingleTextBinding c2 = AlertDialogInputSingleTextBinding.c(getLayoutInflater());
            Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
            LayoutTlDialogCustomTitleBinding c3 = LayoutTlDialogCustomTitleBinding.c(getLayoutInflater());
            Intrinsics.checkNotNullExpressionValue(c3, "inflate(...)");
            c3.c.setText(R.string.tl_rename);
            AlertDialog create = new AlertDialog.Builder(activity).setPositiveButton(R.string.tl_save, (DialogInterface.OnClickListener) new u0(noteBean, this, c2)).setNegativeButton(R.string.tl_dialog_cancel, (DialogInterface.OnClickListener) new v0()).create();
            this.e = create;
            if (create != null) {
                DialogExtKt.a(create);
                create.setCustomTitle(c3.getRoot());
                c2.b.setText(noteBean.getTitle());
                c2.b.setSelection(0, noteBean.getTitle().length());
                c2.b.setFilters((InputFilter[]) new EditTitleInputFilter[]{new EditTitleInputFilter()});
                EditText editText = c2.b;
                Intrinsics.checkNotNullExpressionValue(editText, "etInputText");
                editText.addTextChangedListener(new TransRecordFragment$showSingleInputDialog$lambda$15$lambda$14$$inlined$addTextChangedListener$default$1(noteBean, create));
                create.setView(c2.getRoot());
                create.show();
                create.getButton(-1).setEnabled(false);
            }
        }
    }

    public final void K0(NoteBean noteBean, boolean z) {
        RecordTitleHelper m;
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        LogExt.j("updateRecord noteBean=" + noteBean, "TransRecordFragment");
        NoteListAdapter noteListAdapter = this.d;
        NoteListAdapter noteListAdapter2 = null;
        if (noteListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
            noteListAdapter = null;
        }
        int i = 0;
        for (NoteBean id : noteListAdapter.getData()) {
            int i2 = i + 1;
            if (noteBean.getId() == id.getId()) {
                NoteListAdapter noteListAdapter3 = this.d;
                if (noteListAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
                } else {
                    noteListAdapter2 = noteListAdapter3;
                }
                noteListAdapter2.j0(i, noteBean);
                if (z && (m = TranslationManager.q.a().m()) != null) {
                    m.l(noteBean);
                    return;
                }
                return;
            }
            i = i2;
        }
    }

    public final void initAdapter() {
        NoteListAdapter noteListAdapter = new NoteListAdapter(NoteListAdapter.D.a(), z0().j());
        this.d = noteListAdapter;
        noteListAdapter.q0(new q0(this));
        NoteListAdapter noteListAdapter2 = this.d;
        TransRecordFragmentBinding transRecordFragmentBinding = null;
        if (noteListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
            noteListAdapter2 = null;
        }
        noteListAdapter2.n0(new r0(this));
        NoteListAdapter noteListAdapter3 = this.d;
        if (noteListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
            noteListAdapter3 = null;
        }
        noteListAdapter3.s0(new s0(this));
        TransRecordFragmentBinding transRecordFragmentBinding2 = this.f6290a;
        if (transRecordFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            transRecordFragmentBinding2 = null;
        }
        transRecordFragmentBinding2.f.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        TransRecordFragmentBinding transRecordFragmentBinding3 = this.f6290a;
        if (transRecordFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            transRecordFragmentBinding3 = null;
        }
        transRecordFragmentBinding3.f.addItemDecoration(new GridSpacingItemDecoration(1, GraphicUtils.a(12.0f), false));
        TransRecordFragmentBinding transRecordFragmentBinding4 = this.f6290a;
        if (transRecordFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            transRecordFragmentBinding4 = null;
        }
        transRecordFragmentBinding4.f.setItemAnimator((RecyclerView.ItemAnimator) null);
        TransRecordFragmentBinding transRecordFragmentBinding5 = this.f6290a;
        if (transRecordFragmentBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            transRecordFragmentBinding5 = null;
        }
        RecyclerView recyclerView = transRecordFragmentBinding5.f;
        NoteListAdapter noteListAdapter4 = this.d;
        if (noteListAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
            noteListAdapter4 = null;
        }
        recyclerView.setAdapter(noteListAdapter4);
        TransRecordFragmentBinding transRecordFragmentBinding6 = this.f6290a;
        if (transRecordFragmentBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            transRecordFragmentBinding = transRecordFragmentBinding6;
        }
        transRecordFragmentBinding.f.addOnScrollListener(new TransRecordFragment$initAdapter$4(this));
    }

    public final void initSmartRefresh() {
        TransRecordFragmentBinding transRecordFragmentBinding = this.f6290a;
        NoteListAdapter noteListAdapter = null;
        if (transRecordFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            transRecordFragmentBinding = null;
        }
        transRecordFragmentBinding.g.z(false);
        TransRecordFragmentBinding transRecordFragmentBinding2 = this.f6290a;
        if (transRecordFragmentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            transRecordFragmentBinding2 = null;
        }
        transRecordFragmentBinding2.g.B(new TransRecordFragment$initSmartRefresh$1(this));
        TransRecordFragmentBinding transRecordFragmentBinding3 = this.f6290a;
        if (transRecordFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            transRecordFragmentBinding3 = null;
        }
        this.c = new RecycleHelper(this, transRecordFragmentBinding3.g);
        NoteListAdapter noteListAdapter2 = this.d;
        if (noteListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
            noteListAdapter2 = null;
        }
        List data = noteListAdapter2.getData();
        LogExt.j(this.b + " Recover record list " + data.size(), "TransRecordFragment");
        if (data.isEmpty()) {
            refreshList();
            return;
        }
        Boolean bool = (Boolean) z0().h().getValue();
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        if (bool.booleanValue()) {
            NoteListAdapter noteListAdapter3 = this.d;
            if (noteListAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
            } else {
                noteListAdapter = noteListAdapter3;
            }
            noteListAdapter.y0(true, true);
        }
        showControl(true);
    }

    public void noMoreData() {
        String str = this.b;
        LogExt.g("noMoreData " + str + " 无数据需要被加载", "TransRecordFragment");
        NoteListAdapter noteListAdapter = this.d;
        if (noteListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
            noteListAdapter = null;
        }
        if (noteListAdapter.getItemCount() == 0) {
            showControl(false);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        TransRecordFragmentBinding c2 = TransRecordFragmentBinding.c(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f6290a = c2;
        if (c2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            c2 = null;
        }
        ConstraintLayout b2 = c2.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        return b2;
    }

    public void onDestroy() {
        super.onDestroy();
        AlertDialog alertDialog = this.e;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.e = null;
    }

    public void onResume() {
        super.onResume();
        TransRecordFragmentBinding transRecordFragmentBinding = this.f6290a;
        TransRecordFragmentBinding transRecordFragmentBinding2 = null;
        if (transRecordFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            transRecordFragmentBinding = null;
        }
        RecyclerView.LayoutManager layoutManager = transRecordFragmentBinding.f.getLayoutManager();
        if (layoutManager != null && (layoutManager instanceof LinearLayoutManager)) {
            int findLastCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
            TransRecordFragmentBinding transRecordFragmentBinding3 = this.f6290a;
            if (transRecordFragmentBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                transRecordFragmentBinding2 = transRecordFragmentBinding3;
            }
            ImageView imageView = transRecordFragmentBinding2.d;
            Intrinsics.checkNotNullExpressionValue(imageView, "ivToTop");
            int i = 0;
            if (!(findLastCompletelyVisibleItemPosition > 5)) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Unit unit;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        LogExt.j("savedInstanceState=" + bundle, "TransRecordFragment");
        if (bundle != null) {
            LogExt.j("savedInstanceState is not null, no initialization process required", "TransRecordFragment");
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            initData();
            initAdapter();
            initSmartRefresh();
            initViewModels();
        }
    }

    public final void refreshList() {
        RecycleHelper recycleHelper = this.c;
        if (recycleHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecycleHelper");
            recycleHelper = null;
        }
        recycleHelper.h();
    }

    public final void showControl(boolean z) {
        LogExt.j("showControl isHaveData=" + z + ", recordType=" + this.b, "TransRecordFragment");
        TransRecordFragmentBinding transRecordFragmentBinding = this.f6290a;
        TransRecordFragmentBinding transRecordFragmentBinding2 = null;
        if (transRecordFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            transRecordFragmentBinding = null;
        }
        transRecordFragmentBinding.h.setText(Intrinsics.areEqual((Object) this.b, (Object) "transcribe_records") ? getString(R.string.tl_transcribe_no_data_tips) : getString(R.string.tl_translation_no_data_tips));
        TransRecordFragmentBinding transRecordFragmentBinding3 = this.f6290a;
        if (transRecordFragmentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            transRecordFragmentBinding3 = null;
        }
        Group group = transRecordFragmentBinding3.b;
        Intrinsics.checkNotNullExpressionValue(group, "gpNoData");
        int i = 8;
        group.setVisibility(z ^ true ? 0 : 8);
        TransRecordFragmentBinding transRecordFragmentBinding4 = this.f6290a;
        if (transRecordFragmentBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            transRecordFragmentBinding2 = transRecordFragmentBinding4;
        }
        SmartRefreshLayout smartRefreshLayout = transRecordFragmentBinding2.g;
        Intrinsics.checkNotNullExpressionValue(smartRefreshLayout, "smartRefresh");
        if (z) {
            i = 0;
        }
        smartRefreshLayout.setVisibility(i);
        if (Intrinsics.areEqual((Object) this.b, (Object) "all_records")) {
            TranslationApp.notifyVariousMsg$ar_translator_intlRelease(new OperateMessage(1001, Boolean.valueOf(z)));
        }
    }

    public void showData(List list, int i, int i2) {
        TransRecordFragmentBinding transRecordFragmentBinding = this.f6290a;
        NoteListAdapter noteListAdapter = null;
        if (transRecordFragmentBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            transRecordFragmentBinding = null;
        }
        boolean z = false;
        transRecordFragmentBinding.g.a(false);
        NoteListAdapter noteListAdapter2 = this.d;
        if (noteListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
        } else {
            noteListAdapter = noteListAdapter2;
        }
        if (noteListAdapter.getItemCount() != 0) {
            z = true;
        }
        showControl(z);
    }

    public final void w0(NoteBean noteBean) {
        NoteBean noteBean2;
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        NoteListAdapter noteListAdapter = this.d;
        NoteListAdapter noteListAdapter2 = null;
        if (noteListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
            noteListAdapter = null;
        }
        if (!noteListAdapter.getData().isEmpty()) {
            NoteListAdapter noteListAdapter3 = this.d;
            if (noteListAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
                noteListAdapter3 = null;
            }
            noteBean2 = (NoteBean) noteListAdapter3.getItem(0);
        } else {
            noteBean2 = null;
        }
        LogExt.j("addRecord firstNoteBean=" + noteBean2, "TransRecordFragment");
        LogExt.j("notifyItemChanged id=" + noteBean.getId(), "TransRecordFragment");
        if (noteBean2 == null || noteBean.getId() != noteBean2.getId()) {
            NoteListAdapter noteListAdapter4 = this.d;
            if (noteListAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
                noteListAdapter4 = null;
            }
            noteListAdapter4.p(0, noteBean);
            TransRecordFragmentBinding transRecordFragmentBinding = this.f6290a;
            if (transRecordFragmentBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                transRecordFragmentBinding = null;
            }
            transRecordFragmentBinding.f.scrollToPosition(0);
        }
        NoteListAdapter noteListAdapter5 = this.d;
        if (noteListAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
        } else {
            noteListAdapter2 = noteListAdapter5;
        }
        if (noteListAdapter2.getItemCount() == 1) {
            showControl(true);
        }
    }

    public final void y0(NoteBean noteBean, boolean z) {
        RecordTitleHelper m;
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        LogExt.j("deleteRecord noteBean=" + noteBean, "TransRecordFragment");
        NoteListAdapter noteListAdapter = this.d;
        RecycleHelper recycleHelper = null;
        if (noteListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
            noteListAdapter = null;
        }
        Iterator it = noteListAdapter.getData().iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            int i2 = i + 1;
            if (noteBean.getId() == ((NoteBean) it.next()).getId()) {
                NoteListAdapter noteListAdapter2 = this.d;
                if (noteListAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
                    noteListAdapter2 = null;
                }
                noteListAdapter2.i0(i);
                if (z && (m = TranslationManager.q.a().m()) != null) {
                    m.f(noteBean);
                }
            } else {
                i = i2;
            }
        }
        NoteListAdapter noteListAdapter3 = this.d;
        if (noteListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecordAdapter");
            noteListAdapter3 = null;
        }
        if (noteListAdapter3.getItemCount() == 0) {
            RecycleHelper recycleHelper2 = this.c;
            if (recycleHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecycleHelper");
            } else {
                recycleHelper = recycleHelper2;
            }
            LogExt.j("deleteRecord loadMore=" + recycleHelper.b(), "TransRecordFragment");
        }
    }

    public final TranslatorRecordListViewModel z0() {
        return (TranslatorRecordListViewModel) this.g.getValue();
    }
}
