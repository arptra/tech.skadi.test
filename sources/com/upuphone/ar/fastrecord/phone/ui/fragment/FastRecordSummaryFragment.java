package com.upuphone.ar.fastrecord.phone.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import com.honey.account.x3.d;
import com.honey.account.x3.e;
import com.honey.account.x3.f;
import com.honey.account.x3.g;
import com.honey.account.x3.h;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.databinding.FastRecordSummaryFragmentLayoutBinding;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordExtractActivity;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordSummaryViewModel;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiSummaryOperatorManager;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean;
import com.upuphone.ar.fastrecord.phone.ui.widget.CopyEditText;
import com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordLoadingView;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.xr.audio.record.ai.feedback.AiFeedBackManager;
import com.upuphone.xr.sapp.context.SdkContext;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0003J\b\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\u001a\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0011H\u0002J\u0010\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\nH\u0002J\u0010\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0011H\u0002J\b\u0010(\u001a\u00020\nH\u0002J\b\u0010)\u001a\u00020\nH\u0002J\b\u0010*\u001a\u00020\nH\u0002J\b\u0010+\u001a\u00020\nH\u0002J\b\u0010,\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordSummaryFragment;", "Lcom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordBaseFragment;", "()V", "binding", "Lcom/upuphone/ar/fastrecord/databinding/FastRecordSummaryFragmentLayoutBinding;", "viewModel", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordSummaryViewModel;", "viewTouchListener", "Landroid/view/View$OnTouchListener;", "enterEditMode", "", "exitEditMode", "getExtractSummary", "hideSystemKeyBoard", "initView", "initViewModel", "isInWorkingTaskList", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDestroyView", "onPause", "onResume", "onViewCreated", "view", "refreshViewShow", "showBottom", "requestSoftInput", "contentEdt", "Landroid/widget/EditText;", "setBottomBtnState", "showFeedBackState", "isShow", "showLoadingAndStartTask", "showLoadingStateUi", "startExtractSummary", "toToastCopied", "updateTitleBarStatus", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFastRecordSummaryFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordSummaryFragment.kt\ncom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordSummaryFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,429:1\n262#2,2:430\n262#2,2:432\n302#2:434\n262#2,2:435\n262#2,2:437\n262#2,2:439\n262#2,2:441\n262#2,2:443\n262#2,2:445\n302#2:447\n*S KotlinDebug\n*F\n+ 1 FastRecordSummaryFragment.kt\ncom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordSummaryFragment\n*L\n142#1:430,2\n143#1:432,2\n190#1:434\n224#1:435,2\n251#1:437,2\n252#1:439,2\n362#1:441,2\n368#1:443,2\n376#1:445,2\n180#1:447\n*E\n"})
public final class FastRecordSummaryFragment extends FastRecordBaseFragment {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "SummaryFragment";
    /* access modifiers changed from: private */
    public FastRecordSummaryFragmentLayoutBinding binding;
    /* access modifiers changed from: private */
    public FastRecordSummaryViewModel viewModel;
    @NotNull
    @SuppressLint({"ClickableViewAccessibility"})
    private final View.OnTouchListener viewTouchListener = new e(this);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordSummaryFragment$Companion;", "", "()V", "TAG", "", "getInstance", "Lcom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordSummaryFragment;", "param", "Landroid/os/Bundle;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FastRecordSummaryFragment getInstance(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "param");
            FastRecordSummaryFragment fastRecordSummaryFragment = new FastRecordSummaryFragment();
            fastRecordSummaryFragment.setArguments(bundle);
            return fastRecordSummaryFragment;
        }

        private Companion() {
        }
    }

    private final void enterEditMode() {
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding = this.binding;
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding2 = null;
        if (fastRecordSummaryFragmentLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding = null;
        }
        FastRecordLoadingView fastRecordLoadingView = fastRecordSummaryFragmentLayoutBinding.j;
        Intrinsics.checkNotNullExpressionValue(fastRecordLoadingView, "summaryExtractLoading");
        boolean z = fastRecordLoadingView.getVisibility() == 8;
        LogExt.logE("enterEditMode isNotLoadingData = " + z, TAG);
        if (z) {
            LogExt.logE("enterEditMode Enter.", TAG);
            FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding3 = this.binding;
            if (fastRecordSummaryFragmentLayoutBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fastRecordSummaryFragmentLayoutBinding3 = null;
            }
            fastRecordSummaryFragmentLayoutBinding3.d.setVisibility(0);
            FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding4 = this.binding;
            if (fastRecordSummaryFragmentLayoutBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fastRecordSummaryFragmentLayoutBinding4 = null;
            }
            fastRecordSummaryFragmentLayoutBinding4.l.setVisibility(8);
            FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding5 = this.binding;
            if (fastRecordSummaryFragmentLayoutBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fastRecordSummaryFragmentLayoutBinding2 = fastRecordSummaryFragmentLayoutBinding5;
            }
            CopyEditText copyEditText = fastRecordSummaryFragmentLayoutBinding2.d;
            Intrinsics.checkNotNullExpressionValue(copyEditText, "edtContent");
            requestSoftInput(copyEditText);
        }
    }

    /* access modifiers changed from: private */
    public final void exitEditMode() {
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding = this.binding;
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding2 = null;
        if (fastRecordSummaryFragmentLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding = null;
        }
        LogExt.logE("exitEditMode Enter. value = " + fastRecordSummaryFragmentLayoutBinding.d.getText(), TAG);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding3 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding3 = null;
        }
        TextView textView = fastRecordSummaryFragmentLayoutBinding3.l;
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding4 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding4 = null;
        }
        Editable text = fastRecordSummaryFragmentLayoutBinding4.d.getText();
        textView.setText(text != null ? StringsKt.trim((CharSequence) text) : null);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding5 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding5 = null;
        }
        fastRecordSummaryFragmentLayoutBinding5.d.setVisibility(8);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding6 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding6 = null;
        }
        fastRecordSummaryFragmentLayoutBinding6.l.setVisibility(0);
        hideSystemKeyBoard();
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding7 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding7 = null;
        }
        Editable text2 = fastRecordSummaryFragmentLayoutBinding7.d.getText();
        if (text2 == null || text2.length() == 0) {
            FastRecordSummaryViewModel fastRecordSummaryViewModel = this.viewModel;
            if (fastRecordSummaryViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                fastRecordSummaryViewModel = null;
            }
            fastRecordSummaryViewModel.updateSummary((String) null);
        } else {
            FastRecordSummaryViewModel fastRecordSummaryViewModel2 = this.viewModel;
            if (fastRecordSummaryViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                fastRecordSummaryViewModel2 = null;
            }
            FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding8 = this.binding;
            if (fastRecordSummaryFragmentLayoutBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fastRecordSummaryFragmentLayoutBinding8 = null;
            }
            fastRecordSummaryViewModel2.updateSummary(String.valueOf(fastRecordSummaryFragmentLayoutBinding8.d.getText()));
        }
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding9 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding9 = null;
        }
        LogExt.logE("textContent text. value = " + fastRecordSummaryFragmentLayoutBinding9.l.getText(), TAG);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding10 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding10 = null;
        }
        Editable text3 = fastRecordSummaryFragmentLayoutBinding10.d.getText();
        if (text3 == null || text3.length() == 0) {
            FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding11 = this.binding;
            if (fastRecordSummaryFragmentLayoutBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fastRecordSummaryFragmentLayoutBinding2 = fastRecordSummaryFragmentLayoutBinding11;
            }
            fastRecordSummaryFragmentLayoutBinding2.o.setVisibility(4);
            showFeedBackState(false);
            refreshViewShow(true);
        }
    }

    /* access modifiers changed from: private */
    public final void getExtractSummary() {
        showLoadingStateUi();
        FastRecordSummaryViewModel fastRecordSummaryViewModel = this.viewModel;
        if (fastRecordSummaryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordSummaryViewModel = null;
        }
        fastRecordSummaryViewModel.requestSummaryInfo();
    }

    private final void hideSystemKeyBoard() {
        try {
            FragmentActivity activity = getActivity();
            FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding = null;
            Object systemService = activity != null ? activity.getSystemService("input_method") : null;
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding2 = this.binding;
            if (fastRecordSummaryFragmentLayoutBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fastRecordSummaryFragmentLayoutBinding = fastRecordSummaryFragmentLayoutBinding2;
            }
            inputMethodManager.hideSoftInputFromWindow(fastRecordSummaryFragmentLayoutBinding.getRoot().getWindowToken(), 0);
        } catch (Exception e) {
            String message = e.getMessage();
            LogExt.logE("error msg = " + message, TAG);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initView() {
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding = this.binding;
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding2 = null;
        if (fastRecordSummaryFragmentLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding = null;
        }
        fastRecordSummaryFragmentLayoutBinding.b.setVisibility(0);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding3 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding3 = null;
        }
        fastRecordSummaryFragmentLayoutBinding3.d.setText("");
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding4 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding4 = null;
        }
        fastRecordSummaryFragmentLayoutBinding4.l.setText("");
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding5 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding5 = null;
        }
        fastRecordSummaryFragmentLayoutBinding5.d.setOnPasteCallback(new FastRecordSummaryFragment$initView$1(this));
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding6 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding6 = null;
        }
        fastRecordSummaryFragmentLayoutBinding6.i.setVisibility(8);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding7 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding7 = null;
        }
        fastRecordSummaryFragmentLayoutBinding7.o.setVisibility(4);
        showFeedBackState(false);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding8 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding8 = null;
        }
        fastRecordSummaryFragmentLayoutBinding8.c.setOnTouchListener(this.viewTouchListener);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding9 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding9 = null;
        }
        fastRecordSummaryFragmentLayoutBinding9.o.setOnTouchListener(this.viewTouchListener);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding10 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding10 = null;
        }
        fastRecordSummaryFragmentLayoutBinding10.l.setOnLongClickListener(new f(this));
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding11 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding11 = null;
        }
        fastRecordSummaryFragmentLayoutBinding11.b.setOnClickListener(new g(this));
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding12 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding12 = null;
        }
        ImageView imageView = fastRecordSummaryFragmentLayoutBinding12.e;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivFeedback");
        imageView.setVisibility(8);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding13 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding13 = null;
        }
        TextView textView = fastRecordSummaryFragmentLayoutBinding13.n;
        Intrinsics.checkNotNullExpressionValue(textView, "tvFeedback");
        textView.setVisibility(8);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding14 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fastRecordSummaryFragmentLayoutBinding2 = fastRecordSummaryFragmentLayoutBinding14;
        }
        fastRecordSummaryFragmentLayoutBinding2.e.setOnClickListener(new h(this));
    }

    /* access modifiers changed from: private */
    public static final boolean initView$lambda$1(FastRecordSummaryFragment fastRecordSummaryFragment, View view) {
        Intrinsics.checkNotNullParameter(fastRecordSummaryFragment, "this$0");
        fastRecordSummaryFragment.enterEditMode();
        return false;
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$3(FastRecordSummaryFragment fastRecordSummaryFragment, View view) {
        Intrinsics.checkNotNullParameter(fastRecordSummaryFragment, "this$0");
        fastRecordSummaryFragment.showFeedBackState(false);
        FastRecordSummaryViewModel fastRecordSummaryViewModel = fastRecordSummaryFragment.viewModel;
        if (fastRecordSummaryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordSummaryViewModel = null;
        }
        if (fastRecordSummaryViewModel.isAsrLanguageSupport()) {
            fastRecordSummaryFragment.startExtractSummary();
            return;
        }
        FragmentActivity activity = fastRecordSummaryFragment.getActivity();
        if (activity != null) {
            UToast.Companion companion = UToast.f6444a;
            String string = activity.getString(R.string.fr_ai_analysis_support_tip);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(activity, string);
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$5(FastRecordSummaryFragment fastRecordSummaryFragment, View view) {
        Intrinsics.checkNotNullParameter(fastRecordSummaryFragment, "this$0");
        FragmentActivity activity = fastRecordSummaryFragment.getActivity();
        if (activity != null) {
            AiFeedBackManager aiFeedBackManager = AiFeedBackManager.f6560a;
            FastRecordSummaryViewModel fastRecordSummaryViewModel = fastRecordSummaryFragment.viewModel;
            if (fastRecordSummaryViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                fastRecordSummaryViewModel = null;
            }
            aiFeedBackManager.k(activity, fastRecordSummaryViewModel.getFeedBackBean(), new FastRecordSummaryFragment$initView$4$1$1(fastRecordSummaryFragment));
        }
    }

    private final void initViewModel() {
        FastRecordSummaryViewModel fastRecordSummaryViewModel = this.viewModel;
        FastRecordSummaryViewModel fastRecordSummaryViewModel2 = null;
        if (fastRecordSummaryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordSummaryViewModel = null;
        }
        fastRecordSummaryViewModel.getSummaryLiveData().observe(getViewLifecycleOwner(), new FastRecordSummaryFragment$sam$androidx_lifecycle_Observer$0(new FastRecordSummaryFragment$initViewModel$1(this)));
        FastRecordSummaryViewModel fastRecordSummaryViewModel3 = this.viewModel;
        if (fastRecordSummaryViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordSummaryViewModel3 = null;
        }
        fastRecordSummaryViewModel3.getSummarySensitiveLiveData().observe(getViewLifecycleOwner(), new FastRecordSummaryFragment$sam$androidx_lifecycle_Observer$0(new FastRecordSummaryFragment$initViewModel$2(this)));
        FastRecordSummaryViewModel fastRecordSummaryViewModel4 = this.viewModel;
        if (fastRecordSummaryViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordSummaryViewModel4 = null;
        }
        fastRecordSummaryViewModel4.getSummaryLockedLiveData().observe(getViewLifecycleOwner(), new FastRecordSummaryFragment$sam$androidx_lifecycle_Observer$0(new FastRecordSummaryFragment$initViewModel$3(this)));
        FastRecordSummaryViewModel fastRecordSummaryViewModel5 = this.viewModel;
        if (fastRecordSummaryViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordSummaryViewModel5 = null;
        }
        fastRecordSummaryViewModel5.getSummaryEditModeLiveData().observe(getViewLifecycleOwner(), new FastRecordSummaryFragment$sam$androidx_lifecycle_Observer$0(new FastRecordSummaryFragment$initViewModel$4(this)));
        FastRecordSummaryViewModel fastRecordSummaryViewModel6 = this.viewModel;
        if (fastRecordSummaryViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordSummaryViewModel6 = null;
        }
        fastRecordSummaryViewModel6.getMSummaryResult().observe(getViewLifecycleOwner(), new FastRecordSummaryFragment$sam$androidx_lifecycle_Observer$0(new FastRecordSummaryFragment$initViewModel$5(this)));
        FastRecordSummaryViewModel fastRecordSummaryViewModel7 = this.viewModel;
        if (fastRecordSummaryViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            fastRecordSummaryViewModel2 = fastRecordSummaryViewModel7;
        }
        fastRecordSummaryViewModel2.getCurRecordData().observe(getViewLifecycleOwner(), new FastRecordSummaryFragment$sam$androidx_lifecycle_Observer$0(new FastRecordSummaryFragment$initViewModel$6(this)));
    }

    private final boolean isInWorkingTaskList() {
        FastRecordSummaryViewModel fastRecordSummaryViewModel = this.viewModel;
        if (fastRecordSummaryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordSummaryViewModel = null;
        }
        SummaryRequestBean requestBean = fastRecordSummaryViewModel.getRequestBean();
        if (requestBean == null) {
            return false;
        }
        FastRecordAiSummaryOperatorManager fastRecordAiSummaryOperatorManager = FastRecordAiSummaryOperatorManager.INSTANCE;
        String recognizeId = requestBean.getRecognizeId();
        if (recognizeId == null) {
            recognizeId = "";
        } else {
            Intrinsics.checkNotNull(recognizeId);
        }
        return fastRecordAiSummaryOperatorManager.isInWorkingTaskList(recognizeId);
    }

    /* access modifiers changed from: private */
    public final void refreshViewShow(boolean z) {
        LogExt.logI("refreshViewShow showBottom=" + z, TAG);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding = this.binding;
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding2 = null;
        if (fastRecordSummaryFragmentLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding = null;
        }
        int i = 8;
        fastRecordSummaryFragmentLayoutBinding.j.setVisibility(8);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding3 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding3 = null;
        }
        TextView textView = fastRecordSummaryFragmentLayoutBinding3.m;
        Intrinsics.checkNotNullExpressionValue(textView, "tvExtractTip");
        textView.setVisibility(8);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding4 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding4 = null;
        }
        fastRecordSummaryFragmentLayoutBinding4.i.setVisibility(z ? 8 : 0);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding5 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding5 = null;
        }
        fastRecordSummaryFragmentLayoutBinding5.d.setVisibility(8);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding6 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding6 = null;
        }
        fastRecordSummaryFragmentLayoutBinding6.l.setVisibility(z ? 8 : 0);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding7 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding7 = null;
        }
        fastRecordSummaryFragmentLayoutBinding7.b.setVisibility(z ? 0 : 8);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding8 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding8 = null;
        }
        fastRecordSummaryFragmentLayoutBinding8.p.setVisibility(z ? 0 : 8);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding9 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding9 = null;
        }
        fastRecordSummaryFragmentLayoutBinding9.f.setVisibility(z ? 0 : 8);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding10 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding10 = null;
        }
        fastRecordSummaryFragmentLayoutBinding10.g.setVisibility(z ? 0 : 8);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding11 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fastRecordSummaryFragmentLayoutBinding2 = fastRecordSummaryFragmentLayoutBinding11;
        }
        View view = fastRecordSummaryFragmentLayoutBinding2.q;
        Intrinsics.checkNotNullExpressionValue(view, "vTranBottom");
        if (!z) {
            i = 0;
        }
        view.setVisibility(i);
    }

    private final void requestSoftInput(EditText editText) {
        editText.postDelayed(new d(editText, this), 150);
    }

    /* access modifiers changed from: private */
    public static final void requestSoftInput$lambda$8(EditText editText, FastRecordSummaryFragment fastRecordSummaryFragment) {
        Intrinsics.checkNotNullParameter(editText, "$contentEdt");
        Intrinsics.checkNotNullParameter(fastRecordSummaryFragment, "this$0");
        editText.requestFocus();
        editText.setSelection(editText.getText().toString().length());
        Object systemService = fastRecordSummaryFragment.requireActivity().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(editText, 1);
    }

    /* access modifiers changed from: private */
    public final void setBottomBtnState() {
        if (isInWorkingTaskList()) {
            LogExt.logI("setBottomBtnState in task list", TAG);
            return;
        }
        FastRecordSummaryViewModel fastRecordSummaryViewModel = this.viewModel;
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding = null;
        if (fastRecordSummaryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordSummaryViewModel = null;
        }
        boolean isAsrLanguageSupport = fastRecordSummaryViewModel.isAsrLanguageSupport();
        LogExt.logI("setBottomBtnState asrLanguageSupport=" + isAsrLanguageSupport, TAG);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding2 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fastRecordSummaryFragmentLayoutBinding = fastRecordSummaryFragmentLayoutBinding2;
        }
        View view = fastRecordSummaryFragmentLayoutBinding.q;
        Intrinsics.checkNotNullExpressionValue(view, "vTranBottom");
        view.setVisibility(isAsrLanguageSupport ^ true ? 0 : 8);
    }

    /* access modifiers changed from: private */
    public final void showFeedBackState(boolean z) {
        boolean e = SdkContext.f6675a.c().e();
        LogExt.logE("showFeedBackState isShow = " + z + ",isIntl = " + e, TAG);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding = null;
        }
        LinearLayout linearLayout = fastRecordSummaryFragmentLayoutBinding.h;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "llFeedBack");
        int i = 0;
        if (!(z && e)) {
            i = 8;
        }
        linearLayout.setVisibility(i);
    }

    private final void showLoadingAndStartTask() {
        showFeedBackState(false);
        showLoadingStateUi();
        FastRecordSummaryViewModel fastRecordSummaryViewModel = this.viewModel;
        if (fastRecordSummaryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordSummaryViewModel = null;
        }
        fastRecordSummaryViewModel.startAiSummaryTask();
    }

    private final void showLoadingStateUi() {
        LogExt.logI("showLoadingStateUi", TAG);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding = this.binding;
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding2 = null;
        if (fastRecordSummaryFragmentLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding = null;
        }
        fastRecordSummaryFragmentLayoutBinding.j.setVisibility(0);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding3 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding3 = null;
        }
        TextView textView = fastRecordSummaryFragmentLayoutBinding3.m;
        Intrinsics.checkNotNullExpressionValue(textView, "tvExtractTip");
        textView.setVisibility(0);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding4 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding4 = null;
        }
        View view = fastRecordSummaryFragmentLayoutBinding4.q;
        Intrinsics.checkNotNullExpressionValue(view, "vTranBottom");
        view.setVisibility(0);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding5 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding5 = null;
        }
        fastRecordSummaryFragmentLayoutBinding5.p.setVisibility(8);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding6 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding6 = null;
        }
        fastRecordSummaryFragmentLayoutBinding6.f.setVisibility(8);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding7 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding7 = null;
        }
        fastRecordSummaryFragmentLayoutBinding7.g.setVisibility(8);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding8 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding8 = null;
        }
        fastRecordSummaryFragmentLayoutBinding8.i.setVisibility(0);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding9 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding9 = null;
        }
        fastRecordSummaryFragmentLayoutBinding9.d.setVisibility(0);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding10 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fastRecordSummaryFragmentLayoutBinding2 = fastRecordSummaryFragmentLayoutBinding10;
        }
        fastRecordSummaryFragmentLayoutBinding2.l.setVisibility(8);
    }

    private final void startExtractSummary() {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.b(), (CoroutineStart) null, new FastRecordSummaryFragment$startExtractSummary$1(this, (Continuation<? super FastRecordSummaryFragment$startExtractSummary$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void toToastCopied() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            UToast.Companion companion = UToast.f6444a;
            String string = activity.getString(R.string.fast_record_copy_success);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.e(activity, string, 0);
        }
    }

    /* access modifiers changed from: private */
    public final void updateTitleBarStatus() {
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordExtractActivity");
        ((FastRecordExtractActivity) activity).updateTitleBarStatus();
    }

    /* access modifiers changed from: private */
    public static final boolean viewTouchListener$lambda$7(FastRecordSummaryFragment fastRecordSummaryFragment, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(fastRecordSummaryFragment, "this$0");
        if (motionEvent != null && motionEvent.getAction() == 0) {
            FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding = fastRecordSummaryFragment.binding;
            if (fastRecordSummaryFragmentLayoutBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fastRecordSummaryFragmentLayoutBinding = null;
            }
            FastRecordLoadingView fastRecordLoadingView = fastRecordSummaryFragmentLayoutBinding.j;
            Intrinsics.checkNotNullExpressionValue(fastRecordLoadingView, "summaryExtractLoading");
            boolean z = fastRecordLoadingView.getVisibility() == 8;
            LogExt.logE("OnTouchListener isNotLoadingData = " + z, TAG);
            if (z) {
                fastRecordSummaryFragment.exitEditMode();
            }
        }
        return true;
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FastRecordSummaryFragmentLayoutBinding c = FastRecordSummaryFragmentLayoutBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.binding = c;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        this.viewModel = (FastRecordSummaryViewModel) new ViewModelProvider(requireActivity).get(FastRecordSummaryViewModel.class);
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding = null;
        }
        ConstraintLayout b = fastRecordSummaryFragmentLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onDestroyView() {
        super.onDestroyView();
        FastRecordSummaryViewModel fastRecordSummaryViewModel = this.viewModel;
        FastRecordSummaryViewModel fastRecordSummaryViewModel2 = null;
        if (fastRecordSummaryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordSummaryViewModel = null;
        }
        fastRecordSummaryViewModel.getSummaryLiveData().removeObservers(getViewLifecycleOwner());
        FastRecordSummaryViewModel fastRecordSummaryViewModel3 = this.viewModel;
        if (fastRecordSummaryViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordSummaryViewModel3 = null;
        }
        fastRecordSummaryViewModel3.getSummarySensitiveLiveData().removeObservers(getViewLifecycleOwner());
        FastRecordSummaryViewModel fastRecordSummaryViewModel4 = this.viewModel;
        if (fastRecordSummaryViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            fastRecordSummaryViewModel2 = fastRecordSummaryViewModel4;
        }
        fastRecordSummaryViewModel2.getSummaryEditModeLiveData().removeObservers(getViewLifecycleOwner());
    }

    public void onPause() {
        super.onPause();
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding = this.binding;
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding2 = null;
        if (fastRecordSummaryFragmentLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordSummaryFragmentLayoutBinding = null;
        }
        Editable text = fastRecordSummaryFragmentLayoutBinding.d.getText();
        if (text == null || text.length() == 0) {
            FastRecordSummaryViewModel fastRecordSummaryViewModel = this.viewModel;
            if (fastRecordSummaryViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                fastRecordSummaryViewModel = null;
            }
            fastRecordSummaryViewModel.updateSummary((String) null);
            return;
        }
        FastRecordSummaryViewModel fastRecordSummaryViewModel2 = this.viewModel;
        if (fastRecordSummaryViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordSummaryViewModel2 = null;
        }
        FastRecordSummaryFragmentLayoutBinding fastRecordSummaryFragmentLayoutBinding3 = this.binding;
        if (fastRecordSummaryFragmentLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fastRecordSummaryFragmentLayoutBinding2 = fastRecordSummaryFragmentLayoutBinding3;
        }
        fastRecordSummaryViewModel2.updateSummary(StringsKt.trim((CharSequence) String.valueOf(fastRecordSummaryFragmentLayoutBinding2.d.getText())).toString());
    }

    public void onResume() {
        super.onResume();
        updateTitleBarStatus();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        LogExt.logI("onViewCreated init ", TAG);
        initView();
        initViewModel();
        if (isInWorkingTaskList()) {
            showLoadingAndStartTask();
            return;
        }
        FastRecordSummaryViewModel fastRecordSummaryViewModel = this.viewModel;
        if (fastRecordSummaryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordSummaryViewModel = null;
        }
        fastRecordSummaryViewModel.getSummaryFromLocal();
    }
}
