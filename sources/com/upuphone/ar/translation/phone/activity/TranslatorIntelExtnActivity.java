package com.upuphone.ar.translation.phone.activity;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.honey.account.d5.c;
import com.honey.account.d5.d;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.databinding.ActivityTranslatorIntelExtnBinding;
import com.upuphone.ar.translation.phone.databinding.TablayoutCustomTabBinding;
import com.upuphone.ar.translation.phone.vm.IntelExtnShareViewModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0003J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\u0012\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u0015H\u0014J\u0018\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0014J\b\u0010$\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/upuphone/ar/translation/phone/activity/TranslatorIntelExtnActivity;", "Lcom/upuphone/ar/translation/phone/activity/TranslatorBaseActivity;", "()V", "mBinding", "Lcom/upuphone/ar/translation/phone/databinding/ActivityTranslatorIntelExtnBinding;", "mIntelExtnShareVm", "Lcom/upuphone/ar/translation/phone/vm/IntelExtnShareViewModel;", "getMIntelExtnShareVm", "()Lcom/upuphone/ar/translation/phone/vm/IntelExtnShareViewModel;", "mIntelExtnShareVm$delegate", "Lkotlin/Lazy;", "mNoteBean", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "mOnPageChangeCallback", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "mTabLayoutMediator", "Lcom/google/android/material/tabs/TabLayoutMediator;", "mTabNames", "", "", "hideKeyboard", "", "initListener", "initTabLayout", "initViewModels", "initViews", "isUpdateBottomMargin", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onImeCallback", "imeVisible", "bottomMargin", "", "shareTextFile", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTranslatorIntelExtnActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranslatorIntelExtnActivity.kt\ncom/upuphone/ar/translation/phone/activity/TranslatorIntelExtnActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n*L\n1#1,286:1\n75#2,13:287\n*S KotlinDebug\n*F\n+ 1 TranslatorIntelExtnActivity.kt\ncom/upuphone/ar/translation/phone/activity/TranslatorIntelExtnActivity\n*L\n53#1:287,13\n*E\n"})
public final class TranslatorIntelExtnActivity extends TranslatorBaseActivity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "TranslatorIntelExtnActivity";
    /* access modifiers changed from: private */
    public ActivityTranslatorIntelExtnBinding mBinding;
    @NotNull
    private final Lazy mIntelExtnShareVm$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(IntelExtnShareViewModel.class), new TranslatorIntelExtnActivity$special$$inlined$viewModels$default$2(this), new TranslatorIntelExtnActivity$special$$inlined$viewModels$default$1(this), new TranslatorIntelExtnActivity$special$$inlined$viewModels$default$3((Function0) null, this));
    /* access modifiers changed from: private */
    @Nullable
    public NoteBean mNoteBean;
    @NotNull
    private final ViewPager2.OnPageChangeCallback mOnPageChangeCallback = new TranslatorIntelExtnActivity$mOnPageChangeCallback$1(this);
    @Nullable
    private TabLayoutMediator mTabLayoutMediator;
    @NotNull
    private List<String> mTabNames = new ArrayList();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/translation/phone/activity/TranslatorIntelExtnActivity$Companion;", "", "()V", "TAG", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final IntelExtnShareViewModel getMIntelExtnShareVm() {
        return (IntelExtnShareViewModel) this.mIntelExtnShareVm$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void hideKeyboard() {
        Object systemService = getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initListener() {
        ActivityTranslatorIntelExtnBinding activityTranslatorIntelExtnBinding = this.mBinding;
        ActivityTranslatorIntelExtnBinding activityTranslatorIntelExtnBinding2 = null;
        if (activityTranslatorIntelExtnBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorIntelExtnBinding = null;
        }
        activityTranslatorIntelExtnBinding.c.l(new TranslatorIntelExtnActivity$initListener$1(this));
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "<get-onBackPressedDispatcher>(...)");
        OnBackPressedDispatcherKt.a(onBackPressedDispatcher, this, true, new TranslatorIntelExtnActivity$initListener$2(this));
        ActivityTranslatorIntelExtnBinding activityTranslatorIntelExtnBinding3 = this.mBinding;
        if (activityTranslatorIntelExtnBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorIntelExtnBinding3 = null;
        }
        activityTranslatorIntelExtnBinding3.c.r(new TranslatorIntelExtnActivity$initListener$3(this));
        ActivityTranslatorIntelExtnBinding activityTranslatorIntelExtnBinding4 = this.mBinding;
        if (activityTranslatorIntelExtnBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            activityTranslatorIntelExtnBinding2 = activityTranslatorIntelExtnBinding4;
        }
        activityTranslatorIntelExtnBinding2.getRoot().setOnTouchListener(new d(this));
    }

    /* access modifiers changed from: private */
    public static final boolean initListener$lambda$1(TranslatorIntelExtnActivity translatorIntelExtnActivity, View view, MotionEvent motionEvent) {
        View currentFocus;
        Intrinsics.checkNotNullParameter(translatorIntelExtnActivity, "this$0");
        if (motionEvent.getAction() != 0 || (currentFocus = translatorIntelExtnActivity.getCurrentFocus()) == null || !(currentFocus instanceof EditText)) {
            return false;
        }
        Rect rect = new Rect();
        ((EditText) currentFocus).getGlobalVisibleRect(rect);
        if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            return false;
        }
        LogExt.j("SmartExtraction touch outside the EditText area", TAG);
        translatorIntelExtnActivity.hideKeyboard();
        return false;
    }

    private final void initTabLayout() {
        String string = getString(R.string.tl_summary);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(R.string.tl_to_do);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.mTabNames = CollectionsKt.arrayListOf(string, string2);
        List h = getMIntelExtnShareVm().h(this.mNoteBean);
        ActivityTranslatorIntelExtnBinding activityTranslatorIntelExtnBinding = this.mBinding;
        ActivityTranslatorIntelExtnBinding activityTranslatorIntelExtnBinding2 = null;
        if (activityTranslatorIntelExtnBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorIntelExtnBinding = null;
        }
        activityTranslatorIntelExtnBinding.d.setAdapter(new TranslatorIntelExtnActivity$initTabLayout$1(h, getSupportFragmentManager(), getLifecycle()));
        ActivityTranslatorIntelExtnBinding activityTranslatorIntelExtnBinding3 = this.mBinding;
        if (activityTranslatorIntelExtnBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorIntelExtnBinding3 = null;
        }
        activityTranslatorIntelExtnBinding3.d.g(this.mOnPageChangeCallback);
        ActivityTranslatorIntelExtnBinding activityTranslatorIntelExtnBinding4 = this.mBinding;
        if (activityTranslatorIntelExtnBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorIntelExtnBinding4 = null;
        }
        activityTranslatorIntelExtnBinding4.d.setOffscreenPageLimit(1);
        ActivityTranslatorIntelExtnBinding activityTranslatorIntelExtnBinding5 = this.mBinding;
        if (activityTranslatorIntelExtnBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorIntelExtnBinding5 = null;
        }
        TabLayout tabLayout = activityTranslatorIntelExtnBinding5.b;
        ActivityTranslatorIntelExtnBinding activityTranslatorIntelExtnBinding6 = this.mBinding;
        if (activityTranslatorIntelExtnBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorIntelExtnBinding6 = null;
        }
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, activityTranslatorIntelExtnBinding6.d, new c(this));
        this.mTabLayoutMediator = tabLayoutMediator;
        tabLayoutMediator.attach();
        Integer num = (Integer) getMIntelExtnShareVm().k().getValue();
        if (num != null) {
            LogExt.j("mIntelExtnTabPosition position=" + num, TAG);
            ActivityTranslatorIntelExtnBinding activityTranslatorIntelExtnBinding7 = this.mBinding;
            if (activityTranslatorIntelExtnBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                activityTranslatorIntelExtnBinding2 = activityTranslatorIntelExtnBinding7;
            }
            activityTranslatorIntelExtnBinding2.d.j(num.intValue(), false);
        }
    }

    /* access modifiers changed from: private */
    public static final void initTabLayout$lambda$2(TranslatorIntelExtnActivity translatorIntelExtnActivity, TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(translatorIntelExtnActivity, "this$0");
        Intrinsics.checkNotNullParameter(tab, "tab");
        TablayoutCustomTabBinding c = TablayoutCustomTabBinding.c(translatorIntelExtnActivity.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        c.b.setText(translatorIntelExtnActivity.mTabNames.get(i));
        tab.setCustomView((View) c.getRoot());
    }

    private final void initViewModels() {
        getMIntelExtnShareVm().l().observe(this, new TranslatorIntelExtnActivity$sam$androidx_lifecycle_Observer$0(new TranslatorIntelExtnActivity$initViewModels$1(this)));
        getMIntelExtnShareVm().m().observe(this, new TranslatorIntelExtnActivity$sam$androidx_lifecycle_Observer$0(new TranslatorIntelExtnActivity$initViewModels$2(this)));
    }

    private final void initViews() {
        initTabLayout();
    }

    /* access modifiers changed from: private */
    public final void shareTextFile() {
        NoteBean noteBean = this.mNoteBean;
        LogExt.j("shareTextFile noteBean=" + noteBean, TAG);
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranslatorIntelExtnActivity$shareTextFile$1(this, (Continuation<? super TranslatorIntelExtnActivity$shareTextFile$1>) null), 2, (Object) null);
    }

    public boolean isUpdateBottomMargin() {
        return false;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityTranslatorIntelExtnBinding c = ActivityTranslatorIntelExtnBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.mBinding = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            c = null;
        }
        setContentView((View) c.getRoot());
        if (Build.VERSION.SDK_INT >= 33) {
            this.mNoteBean = (NoteBean) getIntent().getSerializableExtra(TranslatorConstants.TRANSFER_TRANS_RECORD, NoteBean.class);
        } else {
            Serializable serializableExtra = getIntent().getSerializableExtra(TranslatorConstants.TRANSFER_TRANS_RECORD);
            if (serializableExtra != null && (serializableExtra instanceof NoteBean)) {
                this.mNoteBean = (NoteBean) serializableExtra;
            }
        }
        NoteBean noteBean = this.mNoteBean;
        LogExt.j("翻译记录对象 " + noteBean, TAG);
        initViews();
        initListener();
        initViewModels();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mTabNames.clear();
        ActivityTranslatorIntelExtnBinding activityTranslatorIntelExtnBinding = this.mBinding;
        if (activityTranslatorIntelExtnBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranslatorIntelExtnBinding = null;
        }
        activityTranslatorIntelExtnBinding.d.n(this.mOnPageChangeCallback);
        TabLayoutMediator tabLayoutMediator = this.mTabLayoutMediator;
        if (tabLayoutMediator != null) {
            tabLayoutMediator.detach();
        }
    }

    public void onImeCallback(boolean z, int i) {
        super.onImeCallback(z, i);
        getMIntelExtnShareVm().n(new IntelExtnShareViewModel.ImeBean(z, i));
    }
}
