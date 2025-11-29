package com.upuphone.ar.fastrecord.phone.ui.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.honey.account.x3.a;
import com.honey.account.x3.b;
import com.honey.account.x3.c;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.databinding.FastRecordAllFragmentLayoutBinding;
import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ext.RecordViewKt;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordViewAdapter;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel;
import com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordDrawableEditText;
import com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordEditTitleInputFilter;
import flyme.support.v7.app.AlertDialog;
import flyme.support.v7.widget.MzRecyclerView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 32\u00020\u0001:\u00013B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u0012H\u0002J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0012H\u0016J\b\u0010#\u001a\u00020\u0012H\u0016J\b\u0010$\u001a\u00020\u0012H\u0016J\u001a\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J \u0010'\u001a\u00020\u00122\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00160)j\b\u0012\u0004\u0012\u00020\u0016`*H\u0002J\u0018\u0010+\u001a\u00020\u00122\u0006\u0010&\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0006H\u0002J \u0010.\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010/\u001a\u000200H\u0002J$\u00101\u001a\u00020\u00122\u001a\u00102\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010)j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`*H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordFragment;", "Lcom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordBaseFragment;", "()V", "binding", "Lcom/upuphone/ar/fastrecord/databinding/FastRecordAllFragmentLayoutBinding;", "isShowing", "", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mReNameDialog", "Lflyme/support/v7/app/AlertDialog;", "recordType", "", "viewAdapter", "Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordViewAdapter;", "viewModel", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordMainViewModel;", "changeTitle", "", "pos", "", "recordEntity", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "initFastRecordList", "initView", "initViewModel", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onPause", "onResume", "onViewCreated", "view", "setChooseData", "recordData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "setDrawable", "Landroid/widget/TextView;", "visible", "showChangeNameDialog", "activity", "Landroid/app/Activity;", "showRecordTip", "list", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFastRecordFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordFragment.kt\ncom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,476:1\n1855#2,2:477\n*S KotlinDebug\n*F\n+ 1 FastRecordFragment.kt\ncom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordFragment\n*L\n432#1:477,2\n*E\n"})
public final class FastRecordFragment extends FastRecordBaseFragment {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String RECORD_TYPE = "recordType";
    @NotNull
    private static final String TAG = "FastRecordFragment";
    private FastRecordAllFragmentLayoutBinding binding;
    /* access modifiers changed from: private */
    public boolean isShowing;
    /* access modifiers changed from: private */
    public LinearLayoutManager layoutManager;
    /* access modifiers changed from: private */
    @Nullable
    public AlertDialog mReNameDialog;
    /* access modifiers changed from: private */
    @Nullable
    public String recordType = "";
    /* access modifiers changed from: private */
    public FastRecordViewAdapter viewAdapter;
    /* access modifiers changed from: private */
    public FastRecordMainViewModel viewModel;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordFragment$Companion;", "", "()V", "RECORD_TYPE", "", "TAG", "getInstance", "Lcom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordFragment;", "param", "Landroid/os/Bundle;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FastRecordFragment getInstance(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "param");
            FastRecordFragment fastRecordFragment = new FastRecordFragment();
            fastRecordFragment.setArguments(bundle);
            return fastRecordFragment;
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final void changeTitle(int i, RecordEntity recordEntity) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            showChangeNameDialog(i, recordEntity, activity);
        }
    }

    /* access modifiers changed from: private */
    public final void initFastRecordList() {
        String str;
        String str2 = this.recordType;
        LogExt.logW("initFastRecordList type= " + str2, TAG);
        if (getActivity() != null && (str = this.recordType) != null) {
            int hashCode = str.hashCode();
            FastRecordMainViewModel fastRecordMainViewModel = null;
            if (hashCode != 3343801) {
                if (hashCode != 106642798) {
                    if (hashCode == 109254796 && str.equals(FastRecordMainViewModel.RECORD_TYPE_SCENE)) {
                        FastRecordMainViewModel fastRecordMainViewModel2 = this.viewModel;
                        if (fastRecordMainViewModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        } else {
                            fastRecordMainViewModel = fastRecordMainViewModel2;
                        }
                        fastRecordMainViewModel.initFragmentDataByType(1);
                    }
                } else if (str.equals("phone")) {
                    FastRecordMainViewModel fastRecordMainViewModel3 = this.viewModel;
                    if (fastRecordMainViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        fastRecordMainViewModel = fastRecordMainViewModel3;
                    }
                    fastRecordMainViewModel.initFragmentDataByType(0);
                }
            } else if (str.equals(FastRecordMainViewModel.RECORD_TYPE_ALL)) {
                FastRecordMainViewModel fastRecordMainViewModel4 = this.viewModel;
                if (fastRecordMainViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    fastRecordMainViewModel = fastRecordMainViewModel4;
                }
                fastRecordMainViewModel.initFragmentAllData();
            }
        }
    }

    private final void initView() {
        LogExt.logE("initView recordType = " + this.recordType, TAG);
        FastRecordAllFragmentLayoutBinding fastRecordAllFragmentLayoutBinding = this.binding;
        FastRecordViewAdapter fastRecordViewAdapter = null;
        if (fastRecordAllFragmentLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordAllFragmentLayoutBinding = null;
        }
        MzRecyclerView mzRecyclerView = fastRecordAllFragmentLayoutBinding.b;
        Intrinsics.checkNotNullExpressionValue(mzRecyclerView, "fastRecordRecycler");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.layoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        LinearLayoutManager linearLayoutManager2 = this.layoutManager;
        if (linearLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            linearLayoutManager2 = null;
        }
        mzRecyclerView.setLayoutManager(linearLayoutManager2);
        FastRecordViewAdapter fastRecordViewAdapter2 = new FastRecordViewAdapter();
        this.viewAdapter = fastRecordViewAdapter2;
        fastRecordViewAdapter2.setItemListener(new FastRecordFragment$initView$1(this));
        FastRecordViewAdapter fastRecordViewAdapter3 = this.viewAdapter;
        if (fastRecordViewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
        } else {
            fastRecordViewAdapter = fastRecordViewAdapter3;
        }
        mzRecyclerView.setAdapter(fastRecordViewAdapter);
        initViewModel();
    }

    private final void initViewModel() {
        FastRecordMainViewModel fastRecordMainViewModel = this.viewModel;
        FastRecordMainViewModel fastRecordMainViewModel2 = null;
        if (fastRecordMainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordMainViewModel = null;
        }
        fastRecordMainViewModel.getMPageStatus().observe(getViewLifecycleOwner(), new FastRecordFragment$sam$androidx_lifecycle_Observer$0(new FastRecordFragment$initViewModel$1(this)));
        FastRecordMainViewModel fastRecordMainViewModel3 = this.viewModel;
        if (fastRecordMainViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordMainViewModel3 = null;
        }
        fastRecordMainViewModel3.getMClearSelectStatus().observe(getViewLifecycleOwner(), new FastRecordFragment$sam$androidx_lifecycle_Observer$0(new FastRecordFragment$initViewModel$2(this)));
        FastRecordManager.Companion companion = FastRecordManager.Companion;
        companion.getInstance().appViewModel().getRecordStartRecordDetailIng().observe(getViewLifecycleOwner(), new FastRecordFragment$sam$androidx_lifecycle_Observer$0(new FastRecordFragment$initViewModel$3(this)));
        companion.getInstance().appViewModel().getRecordIngTime().observe(getViewLifecycleOwner(), new FastRecordFragment$sam$androidx_lifecycle_Observer$0(new FastRecordFragment$initViewModel$4(this)));
        FastRecordMainViewModel fastRecordMainViewModel4 = this.viewModel;
        if (fastRecordMainViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordMainViewModel4 = null;
        }
        fastRecordMainViewModel4.getAllFastRecordData().observe(getViewLifecycleOwner(), new FastRecordFragment$sam$androidx_lifecycle_Observer$0(new FastRecordFragment$initViewModel$5(this)));
        FastRecordMainViewModel fastRecordMainViewModel5 = this.viewModel;
        if (fastRecordMainViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordMainViewModel5 = null;
        }
        fastRecordMainViewModel5.getSceneFastRecordData().observe(getViewLifecycleOwner(), new FastRecordFragment$sam$androidx_lifecycle_Observer$0(new FastRecordFragment$initViewModel$6(this)));
        FastRecordMainViewModel fastRecordMainViewModel6 = this.viewModel;
        if (fastRecordMainViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            fastRecordMainViewModel2 = fastRecordMainViewModel6;
        }
        fastRecordMainViewModel2.getPhoneFastRecordData().observe(getViewLifecycleOwner(), new FastRecordFragment$sam$androidx_lifecycle_Observer$0(new FastRecordFragment$initViewModel$7(this)));
        companion.getInstance().appViewModel().getRecordAsrDuringProgress().observe(getViewLifecycleOwner(), new FastRecordFragment$sam$androidx_lifecycle_Observer$0(new FastRecordFragment$initViewModel$8(this)));
    }

    /* access modifiers changed from: private */
    public final void setChooseData(ArrayList<RecordEntity> arrayList) {
        FastRecordMainViewModel fastRecordMainViewModel = this.viewModel;
        if (fastRecordMainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordMainViewModel = null;
        }
        if (fastRecordMainViewModel.isChoosePageState()) {
            LogExt.logE("isChoosePageState start", TAG);
            for (RecordEntity recordEntity : arrayList) {
                FastRecordMainViewModel fastRecordMainViewModel2 = this.viewModel;
                if (fastRecordMainViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    fastRecordMainViewModel2 = null;
                }
                if (fastRecordMainViewModel2.isInChooseRecordEntityList(recordEntity)) {
                    LogExt.logE("isChoosePageState true id = " + recordEntity.getRecordId() + ",title =" + recordEntity.getShortHandTitle(), TAG);
                    recordEntity.setChoose(true);
                } else {
                    LogExt.logE("isChoosePageState false id = " + recordEntity.getRecordId() + ",title =" + recordEntity.getShortHandTitle(), TAG);
                    recordEntity.setChoose(false);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void setDrawable(TextView textView, boolean z) {
        Drawable drawable = getResources().getDrawable(R.drawable.ic_fast_record_item_del);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(...)");
        FragmentActivity activity = getActivity();
        if (activity == null || !RecordViewKt.isRtl(activity)) {
            if (!z) {
                drawable = null;
            }
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        } else {
            if (!z) {
                drawable = null;
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        textView.setSelected(true);
    }

    private final void showChangeNameDialog(int i, RecordEntity recordEntity, Activity activity) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        AlertDialog create = new AlertDialog.Builder(activity).setTitle(R.string.fast_record_change_title).setPositiveButton(R.string.fast_record_alert_dialog_ok, (DialogInterface.OnClickListener) new a(objectRef, recordEntity, this, i)).setNegativeButton(R.string.fast_record_alert_dialog_cancel, (DialogInterface.OnClickListener) new b()).create();
        this.mReNameDialog = create;
        if (create != null) {
            LayoutInflater layoutInflater = create.getLayoutInflater();
            Intrinsics.checkNotNullExpressionValue(layoutInflater, "getLayoutInflater(...)");
            View inflate = layoutInflater.inflate(R.layout.fast_record_alert_dialog_text_entry_singleline, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            T findViewById = inflate.findViewById(R.id.editText);
            objectRef.element = findViewById;
            FastRecordDrawableEditText fastRecordDrawableEditText = (FastRecordDrawableEditText) findViewById;
            if (fastRecordDrawableEditText != null) {
                fastRecordDrawableEditText.setFilters((InputFilter[]) new FastRecordEditTitleInputFilter[]{new FastRecordEditTitleInputFilter(0, 1, (DefaultConstructorMarker) null)});
            }
            FastRecordDrawableEditText fastRecordDrawableEditText2 = (FastRecordDrawableEditText) objectRef.element;
            if (fastRecordDrawableEditText2 != null) {
                fastRecordDrawableEditText2.addTextChangedListener(new FastRecordFragment$showChangeNameDialog$3$1(this, objectRef));
            }
            FastRecordDrawableEditText fastRecordDrawableEditText3 = (FastRecordDrawableEditText) objectRef.element;
            if (fastRecordDrawableEditText3 != null) {
                fastRecordDrawableEditText3.addOnLayoutChangeListener(new c(objectRef));
            }
            FastRecordDrawableEditText fastRecordDrawableEditText4 = (FastRecordDrawableEditText) objectRef.element;
            if (fastRecordDrawableEditText4 != null) {
                fastRecordDrawableEditText4.setOnDrawableClickListener(new FastRecordFragment$showChangeNameDialog$3$3(objectRef));
            }
            FastRecordDrawableEditText fastRecordDrawableEditText5 = (FastRecordDrawableEditText) objectRef.element;
            if (fastRecordDrawableEditText5 != null) {
                fastRecordDrawableEditText5.setText(recordEntity.getShortHandTitle());
            }
            AlertDialog alertDialog = this.mReNameDialog;
            if (alertDialog != null) {
                alertDialog.setView(inflate);
            }
            AlertDialog alertDialog2 = this.mReNameDialog;
            if (alertDialog2 != null) {
                alertDialog2.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void showChangeNameDialog$lambda$2(Ref.ObjectRef objectRef, RecordEntity recordEntity, FastRecordFragment fastRecordFragment, int i, DialogInterface dialogInterface, int i2) {
        Intrinsics.checkNotNullParameter(objectRef, "$inputValueEdt");
        Intrinsics.checkNotNullParameter(recordEntity, "$recordEntity");
        Intrinsics.checkNotNullParameter(fastRecordFragment, "this$0");
        FastRecordDrawableEditText fastRecordDrawableEditText = (FastRecordDrawableEditText) objectRef.element;
        FastRecordMainViewModel fastRecordMainViewModel = null;
        String valueOf = String.valueOf(fastRecordDrawableEditText != null ? fastRecordDrawableEditText.getText() : null);
        LogExt.logI("change title to value = " + valueOf, TAG);
        if (!TextUtils.isEmpty(valueOf)) {
            recordEntity.setShortHandTitle(valueOf);
            FastRecordMainViewModel fastRecordMainViewModel2 = fastRecordFragment.viewModel;
            if (fastRecordMainViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                fastRecordMainViewModel = fastRecordMainViewModel2;
            }
            fastRecordMainViewModel.updateRecordName(recordEntity.getRecordId(), valueOf, new FastRecordFragment$showChangeNameDialog$1$1(fastRecordFragment, i, recordEntity));
        }
    }

    /* access modifiers changed from: private */
    public static final void showChangeNameDialog$lambda$3(DialogInterface dialogInterface, int i) {
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r0 = r0.getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void showChangeNameDialog$lambda$5$lambda$4(kotlin.jvm.internal.Ref.ObjectRef r0, android.view.View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        /*
            java.lang.String r1 = "$inputValueEdt"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            T r0 = r0.element
            r1 = r0
            com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordDrawableEditText r1 = (com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordDrawableEditText) r1
            if (r1 == 0) goto L_0x001f
            com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordDrawableEditText r0 = (com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordDrawableEditText) r0
            if (r0 == 0) goto L_0x001b
            android.text.Editable r0 = r0.getText()
            if (r0 == 0) goto L_0x001b
            int r0 = r0.length()
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            r1.setSelection(r0)
        L_0x001f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordFragment.showChangeNameDialog$lambda$5$lambda$4(kotlin.jvm.internal.Ref$ObjectRef, android.view.View, int, int, int, int, int, int, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordViewAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.upuphone.ar.fastrecord.databinding.FastRecordAllFragmentLayoutBinding} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showRecordTip(java.util.ArrayList<com.upuphone.ar.fastrecord.phone.db.RecordEntity> r7) {
        /*
            r6 = this;
            java.lang.String r0 = "binding"
            java.lang.String r1 = "FastRecordFragment"
            r2 = 0
            if (r7 == 0) goto L_0x0035
            boolean r3 = r7.isEmpty()
            if (r3 == 0) goto L_0x000e
            goto L_0x0035
        L_0x000e:
            java.lang.String r7 = r6.recordType
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "list.isNullOrEmpty() is not type= "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logW(r7, r1)
            com.upuphone.ar.fastrecord.databinding.FastRecordAllFragmentLayoutBinding r6 = r6.binding
            if (r6 != 0) goto L_0x002c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L_0x002d
        L_0x002c:
            r2 = r6
        L_0x002d:
            android.widget.TextView r6 = r2.c
            r7 = 8
            r6.setVisibility(r7)
            goto L_0x006f
        L_0x0035:
            java.lang.String r3 = r6.recordType
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "list.isNullOrEmpty() type= "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.upuphone.ar.fastrecord.phone.ext.LogExt.logW(r3, r1)
            com.upuphone.ar.fastrecord.databinding.FastRecordAllFragmentLayoutBinding r1 = r6.binding
            if (r1 != 0) goto L_0x0053
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r1 = r2
        L_0x0053:
            android.widget.TextView r0 = r1.c
            r1 = 0
            r0.setVisibility(r1)
            com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordViewAdapter r6 = r6.viewAdapter
            if (r6 != 0) goto L_0x0064
            java.lang.String r6 = "viewAdapter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            goto L_0x0065
        L_0x0064:
            r2 = r6
        L_0x0065:
            if (r7 != 0) goto L_0x006c
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L_0x006c:
            r2.notifyData(r7)
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordFragment.showRecordTip(java.util.ArrayList):void");
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        String str;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FastRecordAllFragmentLayoutBinding c = FastRecordAllFragmentLayoutBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.binding = c;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        this.viewModel = (FastRecordMainViewModel) new ViewModelProvider(requireActivity).get(FastRecordMainViewModel.class);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString(RECORD_TYPE)) == null) {
            str = "";
        }
        this.recordType = str;
        FastRecordAllFragmentLayoutBinding fastRecordAllFragmentLayoutBinding = this.binding;
        if (fastRecordAllFragmentLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordAllFragmentLayoutBinding = null;
        }
        ConstraintLayout b = fastRecordAllFragmentLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onPause() {
        this.isShowing = false;
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        String str = this.recordType;
        if (str != null) {
            LogExt.logE("onResume recordType = " + str, TAG);
            int hashCode = str.hashCode();
            FastRecordMainViewModel fastRecordMainViewModel = null;
            if (hashCode != 3343801) {
                if (hashCode != 106642798) {
                    if (hashCode == 109254796 && str.equals(FastRecordMainViewModel.RECORD_TYPE_SCENE)) {
                        LogExt.logE("onResume sceneFastRecordData", TAG);
                        FastRecordMainViewModel fastRecordMainViewModel2 = this.viewModel;
                        if (fastRecordMainViewModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        } else {
                            fastRecordMainViewModel = fastRecordMainViewModel2;
                        }
                        fastRecordMainViewModel.initFragmentDataByType(1);
                    }
                } else if (str.equals("phone")) {
                    LogExt.logE("onResume phoneFastRecordData", TAG);
                    FastRecordMainViewModel fastRecordMainViewModel3 = this.viewModel;
                    if (fastRecordMainViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        fastRecordMainViewModel = fastRecordMainViewModel3;
                    }
                    fastRecordMainViewModel.initFragmentDataByType(0);
                }
            } else if (str.equals(FastRecordMainViewModel.RECORD_TYPE_ALL)) {
                LogExt.logE("onResume allFastRecordData", TAG);
                FastRecordMainViewModel fastRecordMainViewModel4 = this.viewModel;
                if (fastRecordMainViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    fastRecordMainViewModel = fastRecordMainViewModel4;
                }
                fastRecordMainViewModel.initFragmentAllData();
            }
        }
        this.isShowing = true;
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        LogExt.logI("onViewCreated init ", TAG);
        initView();
    }
}
