package com.upuphone.ar.transcribe.phone.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.honey.account.v4.g;
import com.honey.account.v4.h;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.databinding.ActivityTranscribeAiBinding;
import com.upuphone.ar.transcribe.databinding.TranscribeAiTabBinding;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import com.upuphone.ar.transcribe.phone.helper.InterConnectHelper;
import com.upuphone.ar.transcribe.phone.vm.AiShareViewModel;
import com.upuphone.star.core.log.ULog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\u0012\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u001aH\u0014J\b\u0010\"\u001a\u00020\u001aH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\rX\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/activity/TranscribeAIActivity;", "Lcom/upuphone/ar/transcribe/phone/activity/TranscribeBaseActivity;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "aiShareViewModel", "Lcom/upuphone/ar/transcribe/phone/vm/AiShareViewModel;", "getAiShareViewModel", "()Lcom/upuphone/ar/transcribe/phone/vm/AiShareViewModel;", "aiShareViewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/upuphone/ar/transcribe/databinding/ActivityTranscribeAiBinding;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "mOnPageChangeCallback", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "noteBean", "Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "tabLayoutMediator", "Lcom/google/android/material/tabs/TabLayoutMediator;", "tabNames", "", "", "initListener", "", "initTabLayout", "initViewModels", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "shareTextFile", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTranscribeAIActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranscribeAIActivity.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeAIActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,261:1\n75#2,13:262\n1#3:275\n*S KotlinDebug\n*F\n+ 1 TranscribeAIActivity.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeAIActivity\n*L\n55#1:262,13\n*E\n"})
public final class TranscribeAIActivity extends TranscribeBaseActivity implements CoroutineScope {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int SUMMARY_PAGE_INDEX = 0;
    @NotNull
    private static final String TAG = "TranscribeAIActivity";
    private static final int TODO_PAGE_INDEX = 1;
    private final /* synthetic */ CoroutineScope $$delegate_0 = CoroutineScopeKt.b();
    @NotNull
    private final Lazy aiShareViewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(AiShareViewModel.class), new TranscribeAIActivity$special$$inlined$viewModels$default$2(this), new TranscribeAIActivity$special$$inlined$viewModels$default$1(this), new TranscribeAIActivity$special$$inlined$viewModels$default$3((Function0) null, this));
    /* access modifiers changed from: private */
    public ActivityTranscribeAiBinding binding;
    @NotNull
    private final ViewPager2.OnPageChangeCallback mOnPageChangeCallback = new TranscribeAIActivity$mOnPageChangeCallback$1();
    /* access modifiers changed from: private */
    @Nullable
    public TranscribeBean noteBean;
    @Nullable
    private TabLayoutMediator tabLayoutMediator;
    /* access modifiers changed from: private */
    @NotNull
    public List<String> tabNames = new ArrayList();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/activity/TranscribeAIActivity$Companion;", "", "()V", "SUMMARY_PAGE_INDEX", "", "TAG", "", "TODO_PAGE_INDEX", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final AiShareViewModel getAiShareViewModel() {
        return (AiShareViewModel) this.aiShareViewModel$delegate.getValue();
    }

    private final void initListener() {
        ActivityTranscribeAiBinding activityTranscribeAiBinding = this.binding;
        ActivityTranscribeAiBinding activityTranscribeAiBinding2 = null;
        if (activityTranscribeAiBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscribeAiBinding = null;
        }
        activityTranscribeAiBinding.c.l(new TranscribeAIActivity$initListener$1(this));
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "<get-onBackPressedDispatcher>(...)");
        OnBackPressedDispatcherKt.a(onBackPressedDispatcher, this, true, new TranscribeAIActivity$initListener$2(this));
        ActivityTranscribeAiBinding activityTranscribeAiBinding3 = this.binding;
        if (activityTranscribeAiBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTranscribeAiBinding2 = activityTranscribeAiBinding3;
        }
        activityTranscribeAiBinding2.c.r(new TranscribeAIActivity$initListener$3(this));
        findViewById(16908290).setOnClickListener(new g());
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$0(View view) {
        ULog.f6446a.a(TAG, "root clicked");
        view.requestFocus();
    }

    private final void initTabLayout() {
        String string = getString(R.string.tl_summary);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(R.string.tl_to_do);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.tabNames = CollectionsKt.arrayListOf(string, string2);
        ActivityTranscribeAiBinding activityTranscribeAiBinding = this.binding;
        ActivityTranscribeAiBinding activityTranscribeAiBinding2 = null;
        if (activityTranscribeAiBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscribeAiBinding = null;
        }
        activityTranscribeAiBinding.d.setAdapter(new TranscribeAIActivity$initTabLayout$1(this, getSupportFragmentManager(), getLifecycle()));
        ActivityTranscribeAiBinding activityTranscribeAiBinding3 = this.binding;
        if (activityTranscribeAiBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscribeAiBinding3 = null;
        }
        activityTranscribeAiBinding3.d.g(this.mOnPageChangeCallback);
        ActivityTranscribeAiBinding activityTranscribeAiBinding4 = this.binding;
        if (activityTranscribeAiBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscribeAiBinding4 = null;
        }
        TabLayout tabLayout = activityTranscribeAiBinding4.b;
        ActivityTranscribeAiBinding activityTranscribeAiBinding5 = this.binding;
        if (activityTranscribeAiBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscribeAiBinding5 = null;
        }
        TabLayoutMediator tabLayoutMediator2 = new TabLayoutMediator(tabLayout, activityTranscribeAiBinding5.d, new h(this));
        this.tabLayoutMediator = tabLayoutMediator2;
        tabLayoutMediator2.attach();
        ActivityTranscribeAiBinding activityTranscribeAiBinding6 = this.binding;
        if (activityTranscribeAiBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityTranscribeAiBinding2 = activityTranscribeAiBinding6;
        }
        activityTranscribeAiBinding2.b.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TranscribeAIActivity$initTabLayout$3(this));
    }

    /* access modifiers changed from: private */
    public static final void initTabLayout$lambda$1(TranscribeAIActivity transcribeAIActivity, TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(transcribeAIActivity, "this$0");
        Intrinsics.checkNotNullParameter(tab, "tab");
        TranscribeAiTabBinding c = TranscribeAiTabBinding.c(transcribeAIActivity.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        c.b.setText(transcribeAIActivity.tabNames.get(i));
        tab.setCustomView((View) c.getRoot());
    }

    private final void initViewModels() {
        String recognizeId;
        getAiShareViewModel().j().observe(this, new TranscribeAIActivity$sam$androidx_lifecycle_Observer$0(new TranscribeAIActivity$initViewModels$1(this)));
        getAiShareViewModel().k().observe(this, new TranscribeAIActivity$sam$androidx_lifecycle_Observer$0(new TranscribeAIActivity$initViewModels$2(this)));
        TranscribeBean transcribeBean = this.noteBean;
        if (transcribeBean != null && (recognizeId = transcribeBean.getRecognizeId()) != null) {
            getAiShareViewModel().l(recognizeId);
        }
    }

    private final void initViews() {
        initTabLayout();
    }

    /* access modifiers changed from: private */
    public final void shareTextFile() {
        TranscribeBean transcribeBean = this.noteBean;
        LogExt.g("shareTextFile noteBean=" + transcribeBean, TAG);
        Job unused = BuildersKt__Builders_commonKt.d(this, Dispatchers.c(), (CoroutineStart) null, new TranscribeAIActivity$shareTextFile$1(this, (Continuation<? super TranscribeAIActivity$shareTextFile$1>) null), 2, (Object) null);
    }

    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        InterConnectHelper a2 = InterConnectHelper.c.a();
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        a2.i(applicationContext);
        ActivityTranscribeAiBinding c = ActivityTranscribeAiBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.binding = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        setContentView((View) c.getRoot());
        TranscribeBean transcribeBean = Build.VERSION.SDK_INT >= 33 ? (TranscribeBean) getIntent().getParcelableExtra("key_record_bean", TranscribeBean.class) : (TranscribeBean) getIntent().getParcelableExtra("key_record_bean");
        this.noteBean = transcribeBean;
        LogExt.g("翻译记录对象 " + transcribeBean, TAG);
        initViews();
        initListener();
        initViewModels();
    }

    public void onDestroy() {
        super.onDestroy();
        this.tabNames.clear();
        ActivityTranscribeAiBinding activityTranscribeAiBinding = this.binding;
        if (activityTranscribeAiBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityTranscribeAiBinding = null;
        }
        activityTranscribeAiBinding.d.n(this.mOnPageChangeCallback);
        TabLayoutMediator tabLayoutMediator2 = this.tabLayoutMediator;
        if (tabLayoutMediator2 != null) {
            tabLayoutMediator2.detach();
        }
        CoroutineScopeKt.e(this, (CancellationException) null, 1, (Object) null);
    }
}
