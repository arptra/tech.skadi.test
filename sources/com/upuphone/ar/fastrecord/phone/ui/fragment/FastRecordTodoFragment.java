package com.upuphone.ar.fastrecord.phone.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.x3.i;
import com.honey.account.x3.j;
import com.honey.account.x3.k;
import com.honey.account.x3.l;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.databinding.FastRecordTodoFragmentLayoutBinding;
import com.upuphone.ar.fastrecord.phone.db.RecordTodoItemEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.schedule.ScheduleUtils;
import com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordExtractActivity;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordTodoViewAdapter;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiTodoOperatorManager;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.xr.audio.record.ai.feedback.AiFeedBackManager;
import com.upuphone.xr.sapp.context.PermissionContext;
import com.upuphone.xr.sapp.context.SdkContext;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0012\u001a\u00020\fJ\b\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J\b\u0010\u0015\u001a\u00020\fH\u0002J\b\u0010\u0016\u001a\u00020\fH\u0003J\b\u0010\u0017\u001a\u00020\fH\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\fH\u0016J\b\u0010#\u001a\u00020\fH\u0016J\b\u0010$\u001a\u00020\fH\u0016J\u001a\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010'\u001a\u00020\fH\u0002J\b\u0010(\u001a\u00020\fH\u0002J\u0010\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u0019H\u0002J\b\u0010+\u001a\u00020\fH\u0002J\b\u0010,\u001a\u00020\fH\u0002J\b\u0010-\u001a\u00020\fH\u0002J\b\u0010.\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\n8\u0002X\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordTodoFragment;", "Lcom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordBaseFragment;", "()V", "binding", "Lcom/upuphone/ar/fastrecord/databinding/FastRecordTodoFragmentLayoutBinding;", "viewAdapter", "Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordTodoViewAdapter;", "viewModel", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTodoViewModel;", "viewTouchListener", "Landroid/view/View$OnTouchListener;", "addEventToCalendar", "", "todo", "Lcom/upuphone/ar/fastrecord/phone/db/RecordTodoItemEntity;", "position", "", "addSchedule", "exitEditMode", "getExtractTodo", "hideSystemKeyBoard", "initTodoRecyclerView", "initTodoView", "initViewModel", "isInWorkingTaskList", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onPause", "onResume", "onViewCreated", "view", "setBottomBtnState", "showFailView", "showFeedBackState", "isShow", "showLoadingAndStartTask", "showLoadingStateUi", "updateTitleBarStatus", "updateTodoList", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFastRecordTodoFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordTodoFragment.kt\ncom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordTodoFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,475:1\n262#2,2:476\n262#2,2:478\n262#2,2:480\n262#2,2:482\n262#2,2:484\n262#2,2:486\n262#2,2:488\n*S KotlinDebug\n*F\n+ 1 FastRecordTodoFragment.kt\ncom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordTodoFragment\n*L\n115#1:476,2\n116#1:478,2\n155#1:480,2\n156#1:482,2\n243#1:484,2\n394#1:486,2\n399#1:488,2\n*E\n"})
public final class FastRecordTodoFragment extends FastRecordBaseFragment {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "TodoFragment";
    /* access modifiers changed from: private */
    public FastRecordTodoFragmentLayoutBinding binding;
    /* access modifiers changed from: private */
    public FastRecordTodoViewAdapter viewAdapter;
    /* access modifiers changed from: private */
    public FastRecordTodoViewModel viewModel;
    @NotNull
    @SuppressLint({"ClickableViewAccessibility"})
    private final View.OnTouchListener viewTouchListener = new l(this);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordTodoFragment$Companion;", "", "()V", "TAG", "", "getInstance", "Lcom/upuphone/ar/fastrecord/phone/ui/fragment/FastRecordTodoFragment;", "param", "Landroid/os/Bundle;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FastRecordTodoFragment getInstance(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "param");
            FastRecordTodoFragment fastRecordTodoFragment = new FastRecordTodoFragment();
            fastRecordTodoFragment.setArguments(bundle);
            return fastRecordTodoFragment;
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final void addEventToCalendar(RecordTodoItemEntity recordTodoItemEntity, int i) {
        FastRecordTodoViewModel fastRecordTodoViewModel = this.viewModel;
        if (fastRecordTodoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTodoViewModel = null;
        }
        fastRecordTodoViewModel.addEventToCalendar(recordTodoItemEntity, new FastRecordTodoFragment$addEventToCalendar$1(this, i));
    }

    /* access modifiers changed from: private */
    public final void addSchedule(RecordTodoItemEntity recordTodoItemEntity, int i) {
        ScheduleUtils scheduleUtils = ScheduleUtils.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        if (scheduleUtils.hasCalendarPermission(requireActivity)) {
            LogExt.logE("addSchedule ############ Enter! ", TAG);
            addEventToCalendar(recordTodoItemEntity, i);
            return;
        }
        LogExt.logE("addSchedule @@@@@@@@@@@@ requestPermission! ", TAG);
        PermissionContext f = SdkContext.f6675a.f();
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity(...)");
        f.d(requireActivity2, FastRecordTodoViewModel.Companion.getCalendarPermissions(), new HashMap(), new FastRecordTodoFragment$addSchedule$1(this, recordTodoItemEntity, i));
    }

    /* access modifiers changed from: private */
    public final void getExtractTodo() {
        showLoadingStateUi();
        FastRecordTodoViewModel fastRecordTodoViewModel = this.viewModel;
        if (fastRecordTodoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTodoViewModel = null;
        }
        fastRecordTodoViewModel.requestTodoListInfo();
    }

    private final void hideSystemKeyBoard() {
        try {
            FragmentActivity activity = getActivity();
            FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding = null;
            Object systemService = activity != null ? activity.getSystemService("input_method") : null;
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding2 = this.binding;
            if (fastRecordTodoFragmentLayoutBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fastRecordTodoFragmentLayoutBinding = fastRecordTodoFragmentLayoutBinding2;
            }
            inputMethodManager.hideSoftInputFromWindow(fastRecordTodoFragmentLayoutBinding.getRoot().getWindowToken(), 0);
        } catch (Exception unused) {
        }
    }

    private final void initTodoRecyclerView() {
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding = this.binding;
        FastRecordTodoViewAdapter fastRecordTodoViewAdapter = null;
        if (fastRecordTodoFragmentLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding = null;
        }
        fastRecordTodoFragmentLayoutBinding.h.setVisibility(8);
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding2 = this.binding;
        if (fastRecordTodoFragmentLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding2 = null;
        }
        fastRecordTodoFragmentLayoutBinding2.k.setVisibility(4);
        showFeedBackState(false);
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding3 = this.binding;
        if (fastRecordTodoFragmentLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding3 = null;
        }
        RecyclerView recyclerView = fastRecordTodoFragmentLayoutBinding3.h;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "todoRecycler");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        FastRecordTodoViewAdapter fastRecordTodoViewAdapter2 = new FastRecordTodoViewAdapter();
        this.viewAdapter = fastRecordTodoViewAdapter2;
        fastRecordTodoViewAdapter2.setItemListener(new FastRecordTodoFragment$initTodoRecyclerView$1(this));
        recyclerView.addOnScrollListener(new FastRecordTodoFragment$initTodoRecyclerView$2(this));
        FastRecordTodoViewAdapter fastRecordTodoViewAdapter3 = this.viewAdapter;
        if (fastRecordTodoViewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            fastRecordTodoViewAdapter3 = null;
        }
        recyclerView.setAdapter(fastRecordTodoViewAdapter3);
        FastRecordTodoViewAdapter fastRecordTodoViewAdapter4 = this.viewAdapter;
        if (fastRecordTodoViewAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
        } else {
            fastRecordTodoViewAdapter = fastRecordTodoViewAdapter4;
        }
        fastRecordTodoViewAdapter.setEditClearCallback(new FastRecordTodoFragment$initTodoRecyclerView$3(this));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initTodoView() {
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding = this.binding;
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding2 = null;
        if (fastRecordTodoFragmentLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding = null;
        }
        fastRecordTodoFragmentLayoutBinding.f.setVisibility(0);
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding3 = this.binding;
        if (fastRecordTodoFragmentLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding3 = null;
        }
        fastRecordTodoFragmentLayoutBinding3.f.setOnClickListener(new i(this));
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding4 = this.binding;
        if (fastRecordTodoFragmentLayoutBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding4 = null;
        }
        fastRecordTodoFragmentLayoutBinding4.getRoot().setOnTouchListener(this.viewTouchListener);
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding5 = this.binding;
        if (fastRecordTodoFragmentLayoutBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding5 = null;
        }
        fastRecordTodoFragmentLayoutBinding5.k.setOnTouchListener(this.viewTouchListener);
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding6 = this.binding;
        if (fastRecordTodoFragmentLayoutBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding6 = null;
        }
        fastRecordTodoFragmentLayoutBinding6.k.post(new j(this));
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding7 = this.binding;
        if (fastRecordTodoFragmentLayoutBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding7 = null;
        }
        ImageView imageView = fastRecordTodoFragmentLayoutBinding7.b;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivFeedback");
        imageView.setVisibility(8);
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding8 = this.binding;
        if (fastRecordTodoFragmentLayoutBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding8 = null;
        }
        TextView textView = fastRecordTodoFragmentLayoutBinding8.j;
        Intrinsics.checkNotNullExpressionValue(textView, "tvFeedback");
        textView.setVisibility(8);
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding9 = this.binding;
        if (fastRecordTodoFragmentLayoutBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fastRecordTodoFragmentLayoutBinding2 = fastRecordTodoFragmentLayoutBinding9;
        }
        fastRecordTodoFragmentLayoutBinding2.b.setOnClickListener(new k(this));
    }

    /* access modifiers changed from: private */
    public static final void initTodoView$lambda$1(FastRecordTodoFragment fastRecordTodoFragment, View view) {
        Intrinsics.checkNotNullParameter(fastRecordTodoFragment, "this$0");
        fastRecordTodoFragment.showFeedBackState(false);
        FastRecordTodoViewModel fastRecordTodoViewModel = fastRecordTodoFragment.viewModel;
        if (fastRecordTodoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTodoViewModel = null;
        }
        if (!fastRecordTodoViewModel.isAsrLanguageSupport()) {
            FragmentActivity activity = fastRecordTodoFragment.getActivity();
            if (activity != null) {
                UToast.Companion companion = UToast.f6444a;
                String string = activity.getString(R.string.fr_ai_analysis_support_tip);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                companion.d(activity, string);
                return;
            }
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(fastRecordTodoFragment), Dispatchers.b(), (CoroutineStart) null, new FastRecordTodoFragment$initTodoView$1$2(fastRecordTodoFragment, (Continuation<? super FastRecordTodoFragment$initTodoView$1$2>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initTodoView$lambda$2(FastRecordTodoFragment fastRecordTodoFragment) {
        Intrinsics.checkNotNullParameter(fastRecordTodoFragment, "this$0");
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding = fastRecordTodoFragment.binding;
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding2 = null;
        if (fastRecordTodoFragmentLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding = null;
        }
        int height = fastRecordTodoFragmentLayoutBinding.k.getHeight();
        LogExt.logE("tvSummaryStatement paddingBottom = " + height, TAG);
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding3 = fastRecordTodoFragment.binding;
        if (fastRecordTodoFragmentLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fastRecordTodoFragmentLayoutBinding2 = fastRecordTodoFragmentLayoutBinding3;
        }
        fastRecordTodoFragmentLayoutBinding2.h.setPadding(0, 0, 0, height);
    }

    /* access modifiers changed from: private */
    public static final void initTodoView$lambda$4(FastRecordTodoFragment fastRecordTodoFragment, View view) {
        Intrinsics.checkNotNullParameter(fastRecordTodoFragment, "this$0");
        FragmentActivity activity = fastRecordTodoFragment.getActivity();
        if (activity != null) {
            AiFeedBackManager aiFeedBackManager = AiFeedBackManager.f6560a;
            FastRecordTodoViewModel fastRecordTodoViewModel = fastRecordTodoFragment.viewModel;
            if (fastRecordTodoViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                fastRecordTodoViewModel = null;
            }
            aiFeedBackManager.k(activity, fastRecordTodoViewModel.getFeedBackBean(), new FastRecordTodoFragment$initTodoView$3$1$1(fastRecordTodoFragment));
        }
    }

    private final void initViewModel() {
        FastRecordTodoViewModel fastRecordTodoViewModel = this.viewModel;
        FastRecordTodoViewModel fastRecordTodoViewModel2 = null;
        if (fastRecordTodoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTodoViewModel = null;
        }
        fastRecordTodoViewModel.getMTodoResult().observe(getViewLifecycleOwner(), new FastRecordTodoFragment$sam$androidx_lifecycle_Observer$0(new FastRecordTodoFragment$initViewModel$1(this)));
        FastRecordTodoViewModel fastRecordTodoViewModel3 = this.viewModel;
        if (fastRecordTodoViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTodoViewModel3 = null;
        }
        fastRecordTodoViewModel3.getTodoLiveData().observe(getViewLifecycleOwner(), new FastRecordTodoFragment$sam$androidx_lifecycle_Observer$0(new FastRecordTodoFragment$initViewModel$2(this)));
        FastRecordTodoViewModel fastRecordTodoViewModel4 = this.viewModel;
        if (fastRecordTodoViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTodoViewModel4 = null;
        }
        fastRecordTodoViewModel4.getTodoSensitiveLiveData().observe(getViewLifecycleOwner(), new FastRecordTodoFragment$sam$androidx_lifecycle_Observer$0(new FastRecordTodoFragment$initViewModel$3(this)));
        FastRecordTodoViewModel fastRecordTodoViewModel5 = this.viewModel;
        if (fastRecordTodoViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTodoViewModel5 = null;
        }
        fastRecordTodoViewModel5.getTodoEditModeLiveData().observe(getViewLifecycleOwner(), new FastRecordTodoFragment$sam$androidx_lifecycle_Observer$0(new FastRecordTodoFragment$initViewModel$4(this)));
        FastRecordTodoViewModel fastRecordTodoViewModel6 = this.viewModel;
        if (fastRecordTodoViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTodoViewModel6 = null;
        }
        fastRecordTodoViewModel6.getSummaryLockedLiveData().observe(getViewLifecycleOwner(), new FastRecordTodoFragment$sam$androidx_lifecycle_Observer$0(new FastRecordTodoFragment$initViewModel$5(this)));
        FastRecordTodoViewModel fastRecordTodoViewModel7 = this.viewModel;
        if (fastRecordTodoViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            fastRecordTodoViewModel2 = fastRecordTodoViewModel7;
        }
        fastRecordTodoViewModel2.getCurRecordData().observe(getViewLifecycleOwner(), new FastRecordTodoFragment$sam$androidx_lifecycle_Observer$0(new FastRecordTodoFragment$initViewModel$6(this)));
    }

    private final boolean isInWorkingTaskList() {
        FastRecordTodoViewModel fastRecordTodoViewModel = this.viewModel;
        if (fastRecordTodoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTodoViewModel = null;
        }
        SummaryRequestBean requestBean = fastRecordTodoViewModel.getRequestBean();
        if (requestBean == null) {
            return false;
        }
        FastRecordAiTodoOperatorManager fastRecordAiTodoOperatorManager = FastRecordAiTodoOperatorManager.INSTANCE;
        String recognizeId = requestBean.getRecognizeId();
        if (recognizeId == null) {
            recognizeId = "";
        } else {
            Intrinsics.checkNotNull(recognizeId);
        }
        return fastRecordAiTodoOperatorManager.isInWorkingTaskList(recognizeId);
    }

    /* access modifiers changed from: private */
    public final void setBottomBtnState() {
        if (isInWorkingTaskList()) {
            LogExt.logI("setBottomBtnState in task list", TAG);
            return;
        }
        FastRecordTodoViewModel fastRecordTodoViewModel = this.viewModel;
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding = null;
        if (fastRecordTodoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTodoViewModel = null;
        }
        boolean isAsrLanguageSupport = fastRecordTodoViewModel.isAsrLanguageSupport();
        LogExt.logI("setBottomBtnState asrLanguageSupport=" + isAsrLanguageSupport, TAG);
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding2 = this.binding;
        if (fastRecordTodoFragmentLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fastRecordTodoFragmentLayoutBinding = fastRecordTodoFragmentLayoutBinding2;
        }
        View view = fastRecordTodoFragmentLayoutBinding.m;
        Intrinsics.checkNotNullExpressionValue(view, "vTranBottom");
        view.setVisibility(isAsrLanguageSupport ^ true ? 0 : 8);
    }

    /* access modifiers changed from: private */
    public final void showFailView() {
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding = this.binding;
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding2 = null;
        if (fastRecordTodoFragmentLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding = null;
        }
        fastRecordTodoFragmentLayoutBinding.g.setVisibility(8);
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding3 = this.binding;
        if (fastRecordTodoFragmentLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding3 = null;
        }
        TextView textView = fastRecordTodoFragmentLayoutBinding3.i;
        Intrinsics.checkNotNullExpressionValue(textView, "tvExtractTip");
        textView.setVisibility(8);
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding4 = this.binding;
        if (fastRecordTodoFragmentLayoutBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding4 = null;
        }
        fastRecordTodoFragmentLayoutBinding4.f.setVisibility(0);
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding5 = this.binding;
        if (fastRecordTodoFragmentLayoutBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding5 = null;
        }
        fastRecordTodoFragmentLayoutBinding5.l.setVisibility(0);
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding6 = this.binding;
        if (fastRecordTodoFragmentLayoutBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding6 = null;
        }
        fastRecordTodoFragmentLayoutBinding6.c.setVisibility(0);
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding7 = this.binding;
        if (fastRecordTodoFragmentLayoutBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding7 = null;
        }
        fastRecordTodoFragmentLayoutBinding7.d.setVisibility(0);
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding8 = this.binding;
        if (fastRecordTodoFragmentLayoutBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding8 = null;
        }
        fastRecordTodoFragmentLayoutBinding8.h.setVisibility(8);
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding9 = this.binding;
        if (fastRecordTodoFragmentLayoutBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fastRecordTodoFragmentLayoutBinding2 = fastRecordTodoFragmentLayoutBinding9;
        }
        fastRecordTodoFragmentLayoutBinding2.k.setVisibility(4);
        showFeedBackState(false);
    }

    /* access modifiers changed from: private */
    public final void showFeedBackState(boolean z) {
        boolean e = SdkContext.f6675a.c().e();
        LogExt.logE("showFeedBackState isShow = " + z + ",isIntl = " + e, TAG);
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding = this.binding;
        if (fastRecordTodoFragmentLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding = null;
        }
        LinearLayout linearLayout = fastRecordTodoFragmentLayoutBinding.e;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "llFeedBack");
        int i = 0;
        if (!(z && e)) {
            i = 8;
        }
        linearLayout.setVisibility(i);
    }

    private final void showLoadingAndStartTask() {
        showLoadingStateUi();
        FastRecordTodoViewModel fastRecordTodoViewModel = this.viewModel;
        if (fastRecordTodoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTodoViewModel = null;
        }
        fastRecordTodoViewModel.startAiToDoTask();
    }

    private final void showLoadingStateUi() {
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding = this.binding;
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding2 = null;
        if (fastRecordTodoFragmentLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding = null;
        }
        fastRecordTodoFragmentLayoutBinding.g.setVisibility(0);
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding3 = this.binding;
        if (fastRecordTodoFragmentLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding3 = null;
        }
        TextView textView = fastRecordTodoFragmentLayoutBinding3.i;
        Intrinsics.checkNotNullExpressionValue(textView, "tvExtractTip");
        textView.setVisibility(0);
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding4 = this.binding;
        if (fastRecordTodoFragmentLayoutBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding4 = null;
        }
        View view = fastRecordTodoFragmentLayoutBinding4.m;
        Intrinsics.checkNotNullExpressionValue(view, "vTranBottom");
        view.setVisibility(0);
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding5 = this.binding;
        if (fastRecordTodoFragmentLayoutBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding5 = null;
        }
        fastRecordTodoFragmentLayoutBinding5.l.setVisibility(8);
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding6 = this.binding;
        if (fastRecordTodoFragmentLayoutBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding6 = null;
        }
        fastRecordTodoFragmentLayoutBinding6.c.setVisibility(8);
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding7 = this.binding;
        if (fastRecordTodoFragmentLayoutBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding7 = null;
        }
        fastRecordTodoFragmentLayoutBinding7.d.setVisibility(8);
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding8 = this.binding;
        if (fastRecordTodoFragmentLayoutBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding8 = null;
        }
        fastRecordTodoFragmentLayoutBinding8.h.setVisibility(0);
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding9 = this.binding;
        if (fastRecordTodoFragmentLayoutBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fastRecordTodoFragmentLayoutBinding2 = fastRecordTodoFragmentLayoutBinding9;
        }
        fastRecordTodoFragmentLayoutBinding2.k.setVisibility(4);
        showFeedBackState(false);
    }

    /* access modifiers changed from: private */
    public final void updateTitleBarStatus() {
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordExtractActivity");
        ((FastRecordExtractActivity) activity).updateTitleBarStatus();
    }

    /* access modifiers changed from: private */
    public final void updateTodoList() {
        FastRecordTodoViewAdapter fastRecordTodoViewAdapter = this.viewAdapter;
        FastRecordTodoViewAdapter fastRecordTodoViewAdapter2 = null;
        if (fastRecordTodoViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            fastRecordTodoViewAdapter = null;
        }
        if (!fastRecordTodoViewAdapter.getTodoIList().isEmpty()) {
            FastRecordTodoViewModel fastRecordTodoViewModel = this.viewModel;
            if (fastRecordTodoViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                fastRecordTodoViewModel = null;
            }
            FastRecordTodoViewAdapter fastRecordTodoViewAdapter3 = this.viewAdapter;
            if (fastRecordTodoViewAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            } else {
                fastRecordTodoViewAdapter2 = fastRecordTodoViewAdapter3;
            }
            fastRecordTodoViewModel.updateTodoList(fastRecordTodoViewAdapter2.getTodoIList());
            return;
        }
        LogExt.logE("updateTodoList todoList is isNotEmpty", TAG);
    }

    /* access modifiers changed from: private */
    public static final boolean viewTouchListener$lambda$5(FastRecordTodoFragment fastRecordTodoFragment, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(fastRecordTodoFragment, "this$0");
        if (motionEvent != null && motionEvent.getAction() == 0) {
            FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding = fastRecordTodoFragment.binding;
            if (fastRecordTodoFragmentLayoutBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fastRecordTodoFragmentLayoutBinding = null;
            }
            boolean z = fastRecordTodoFragmentLayoutBinding.g.getVisibility() == 8;
            LogExt.logE("OnTouchListener isNotLoadingData = " + z, TAG);
            if (z) {
                fastRecordTodoFragment.exitEditMode();
            }
        }
        return true;
    }

    public final void exitEditMode() {
        LogExt.logE("exitEditMode Enter.", TAG);
        FastRecordTodoViewAdapter fastRecordTodoViewAdapter = this.viewAdapter;
        FastRecordTodoViewAdapter fastRecordTodoViewAdapter2 = null;
        if (fastRecordTodoViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            fastRecordTodoViewAdapter = null;
        }
        fastRecordTodoViewAdapter.clearEditState();
        FastRecordTodoViewAdapter fastRecordTodoViewAdapter3 = this.viewAdapter;
        if (fastRecordTodoViewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
        } else {
            fastRecordTodoViewAdapter2 = fastRecordTodoViewAdapter3;
        }
        fastRecordTodoViewAdapter2.changeItemToDisEnabled();
        hideSystemKeyBoard();
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FastRecordTodoFragmentLayoutBinding c = FastRecordTodoFragmentLayoutBinding.c(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.binding = c;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        this.viewModel = (FastRecordTodoViewModel) new ViewModelProvider(requireActivity).get(FastRecordTodoViewModel.class);
        FastRecordTodoFragmentLayoutBinding fastRecordTodoFragmentLayoutBinding = this.binding;
        if (fastRecordTodoFragmentLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTodoFragmentLayoutBinding = null;
        }
        ConstraintLayout b = fastRecordTodoFragmentLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
        return b;
    }

    public void onDestroyView() {
        super.onDestroyView();
        FastRecordTodoViewModel fastRecordTodoViewModel = this.viewModel;
        FastRecordTodoViewAdapter fastRecordTodoViewAdapter = null;
        if (fastRecordTodoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTodoViewModel = null;
        }
        fastRecordTodoViewModel.getTodoLiveData().removeObservers(getViewLifecycleOwner());
        FastRecordTodoViewModel fastRecordTodoViewModel2 = this.viewModel;
        if (fastRecordTodoViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTodoViewModel2 = null;
        }
        fastRecordTodoViewModel2.getTodoSensitiveLiveData().removeObservers(getViewLifecycleOwner());
        FastRecordTodoViewModel fastRecordTodoViewModel3 = this.viewModel;
        if (fastRecordTodoViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTodoViewModel3 = null;
        }
        fastRecordTodoViewModel3.getTodoEditModeLiveData().removeObservers(getViewLifecycleOwner());
        FastRecordTodoViewAdapter fastRecordTodoViewAdapter2 = this.viewAdapter;
        if (fastRecordTodoViewAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
        } else {
            fastRecordTodoViewAdapter = fastRecordTodoViewAdapter2;
        }
        fastRecordTodoViewAdapter.clearMap();
    }

    public void onPause() {
        super.onPause();
        LogExt.logE("onPause.", TAG);
        updateTodoList();
    }

    public void onResume() {
        super.onResume();
        LogExt.logE("onResume ", TAG);
        if (isInWorkingTaskList()) {
            showLoadingAndStartTask();
            return;
        }
        FastRecordTodoViewModel fastRecordTodoViewModel = this.viewModel;
        if (fastRecordTodoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTodoViewModel = null;
        }
        fastRecordTodoViewModel.getTodoListFromLocal(new FastRecordTodoFragment$onResume$1(this));
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        LogExt.logI("onViewCreated init ", TAG);
        initTodoView();
        initTodoRecyclerView();
        initViewModel();
    }
}
