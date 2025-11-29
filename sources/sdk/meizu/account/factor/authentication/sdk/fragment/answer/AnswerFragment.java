package sdk.meizu.account.factor.authentication.sdk.fragment.answer;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.tc.a;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationUtil;
import sdk.meizu.account.factor.authentication.sdk.FactorAuthenticationViewModel;
import sdk.meizu.account.factor.authentication.sdk.R;
import sdk.meizu.account.factor.authentication.sdk.common.widget.MzButton;
import sdk.meizu.account.factor.authentication.sdk.fragment.answer.adapter.AnswerListAdapter;
import sdk.meizu.account.factor.authentication.sdk.fragment.base.BaseFragmentKt;
import sdk.meizu.account.factor.authentication.sdk.fragment.basic.ValidateViewModel;
import sdk.meizu.account.factor.authentication.sdk.fragment.basic.adapter.SpacesItemDecoration;
import sdk.meizu.account.factor.authentication.sdk.module.BuildConfigProvider;

@SourceDebugExtension({"SMAP\nAnswerFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnswerFragment.kt\nsdk/meizu/account/factor/authentication/sdk/fragment/answer/AnswerFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n*L\n1#1,170:1\n172#2,9:171\n106#2,15:180\n*S KotlinDebug\n*F\n+ 1 AnswerFragment.kt\nsdk/meizu/account/factor/authentication/sdk/fragment/answer/AnswerFragment\n*L\n45#1:171,9\n48#1:180,15\n*E\n"})
@AndroidEntryPoint
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0016H\u0016J\u001a\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010$\u001a\u00020\u00162\b\u0010%\u001a\u0004\u0018\u00010&H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013¨\u0006("}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/fragment/answer/AnswerFragment;", "Lsdk/meizu/account/factor/authentication/sdk/fragment/base/BaseFragment;", "()V", "complaintsTv", "Landroid/widget/TextView;", "errorTv", "nextBtn", "Lsdk/meizu/account/factor/authentication/sdk/common/widget/MzButton;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "validateViewModel", "Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/ValidateViewModel;", "getValidateViewModel", "()Lsdk/meizu/account/factor/authentication/sdk/fragment/basic/ValidateViewModel;", "validateViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lsdk/meizu/account/factor/authentication/sdk/FactorAuthenticationViewModel;", "getViewModel", "()Lsdk/meizu/account/factor/authentication/sdk/FactorAuthenticationViewModel;", "viewModel$delegate", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDetach", "onViewCreated", "view", "showError", "error", "", "Companion", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AnswerFragment extends Hilt_AnswerFragment {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private TextView complaintsTv;
    @Nullable
    private TextView errorTv;
    /* access modifiers changed from: private */
    @Nullable
    public MzButton nextBtn;
    /* access modifiers changed from: private */
    @Nullable
    public RecyclerView recyclerView;
    @NotNull
    private final Lazy validateViewModel$delegate;
    @NotNull
    private final Lazy viewModel$delegate = FragmentViewModelLazyKt.c(this, Reflection.getOrCreateKotlinClass(FactorAuthenticationViewModel.class), new AnswerFragment$special$$inlined$activityViewModels$default$1(this), new AnswerFragment$special$$inlined$activityViewModels$default$2((Function0) null, this), new AnswerFragment$special$$inlined$activityViewModels$default$3(this));

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lsdk/meizu/account/factor/authentication/sdk/fragment/answer/AnswerFragment$Companion;", "", "()V", "newInstance", "Lsdk/meizu/account/factor/authentication/sdk/fragment/answer/AnswerFragment;", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AnswerFragment newInstance() {
            return new AnswerFragment();
        }

        private Companion() {
        }
    }

    public AnswerFragment() {
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new AnswerFragment$special$$inlined$viewModels$default$2(new AnswerFragment$special$$inlined$viewModels$default$1(this)));
        this.validateViewModel$delegate = FragmentViewModelLazyKt.c(this, Reflection.getOrCreateKotlinClass(ValidateViewModel.class), new AnswerFragment$special$$inlined$viewModels$default$3(lazy), new AnswerFragment$special$$inlined$viewModels$default$4((Function0) null, lazy), new AnswerFragment$special$$inlined$viewModels$default$5(this, lazy));
    }

    private final ValidateViewModel getValidateViewModel() {
        return (ValidateViewModel) this.validateViewModel$delegate.getValue();
    }

    private final FactorAuthenticationViewModel getViewModel() {
        return (FactorAuthenticationViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$2$lambda$1(AnswerFragment answerFragment, View view) {
        Intrinsics.checkNotNullParameter(answerFragment, "this$0");
        ValidateViewModel validateViewModel = answerFragment.getValidateViewModel();
        RecyclerView recyclerView2 = answerFragment.recyclerView;
        RecyclerView.Adapter adapter = recyclerView2 != null ? recyclerView2.getAdapter() : null;
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type sdk.meizu.account.factor.authentication.sdk.fragment.answer.adapter.AnswerListAdapter");
        validateViewModel.confirm(((AnswerListAdapter) adapter).getAnswer());
    }

    /* access modifiers changed from: private */
    public final void showError(String str) {
        MzButton mzButton = this.nextBtn;
        if (mzButton != null) {
            mzButton.setEnabled(true ^ (str == null || str.length() == 0));
        }
        TextView textView = this.errorTv;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void onAttach(@NotNull Context context) {
        TextView textView;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null && (textView = (TextView) activity.findViewById(R.id.factor_title)) != null) {
            textView.setText(getString(R.string.verify_answer));
        }
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_answer, viewGroup, false);
    }

    public void onDetach() {
        TextView textView;
        super.onDetach();
        FragmentActivity activity = getActivity();
        if (activity != null && (textView = (TextView) activity.findViewById(R.id.factor_title)) != null) {
            textView.setText(getString(R.string.verify_identity));
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.errorTv = (TextView) view.findViewById(R.id.validate_answer_error);
        MzButton mzButton = (MzButton) view.findViewById(R.id.next);
        mzButton.setOnClickListener(new a(this));
        this.nextBtn = mzButton;
        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.answer_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(1);
        recyclerView2.setLayoutManager(linearLayoutManager);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.addItemDecoration(new SpacesItemDecoration(recyclerView2.getResources().getDimensionPixelOffset(R.dimen.adapter_item_spacing)));
        this.recyclerView = recyclerView2;
        TextView textView = (TextView) view.findViewById(R.id.all_complaints);
        String string = ContextCompat.getString(textView.getContext(), R.string.complaints);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = ContextCompat.getString(textView.getContext(), R.string._complaints);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        SpannableString spannableString = new SpannableString(string);
        String str = string;
        String str2 = string2;
        spannableString.setSpan(new AnswerFragment$onViewCreated$3$1$1(textView), StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null), StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null) + string2.length(), 18);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        int i = 0;
        textView.setHighlightColor(0);
        textView.setText(spannableString);
        BuildConfigProvider buildConfigProvider = FactorAuthenticationUtil.INSTANCE.getBuildConfigProvider();
        if (buildConfigProvider != null && buildConfigProvider.isOverseas()) {
            i = 8;
        }
        textView.setVisibility(i);
        this.complaintsTv = textView;
        BaseFragmentKt.collectLifecycleFlow(this, getViewModel().getValidateUiState(), new AnswerFragment$onViewCreated$4(this, (Continuation<? super AnswerFragment$onViewCreated$4>) null));
        BaseFragmentKt.collectLifecycleFlow(this, getValidateViewModel().getConfirmAnswerUiState(), new AnswerFragment$onViewCreated$5(this, (Continuation<? super AnswerFragment$onViewCreated$5>) null));
    }
}
