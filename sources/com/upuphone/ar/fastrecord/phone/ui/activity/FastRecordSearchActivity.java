package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.u3.u0;
import com.honey.account.u3.v0;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.databinding.FastRecordSearchActivityBinding;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ext.RecordViewKt;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordDetailHistoryViewAdapter;
import com.upuphone.ar.fastrecord.phone.ui.adapter.FastRecordSearchViewAdapter;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.search.FastRecordSearchViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0003J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0014H\u0014J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordSearchActivity;", "Lcom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordBaseActivity;", "()V", "keyWordValue", "", "layout", "Lcom/upuphone/ar/fastrecord/databinding/FastRecordSearchActivityBinding;", "getLayout", "()Lcom/upuphone/ar/fastrecord/databinding/FastRecordSearchActivityBinding;", "layout$delegate", "Lkotlin/Lazy;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "recordId", "", "viewAdapter", "Lcom/upuphone/ar/fastrecord/phone/ui/adapter/FastRecordSearchViewAdapter;", "viewModel", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/search/FastRecordSearchViewModel;", "hideSoftInput", "", "initView", "initViewModel", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "setDrawable", "view", "Landroid/widget/TextView;", "visible", "", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFastRecordSearchActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordSearchActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordSearchActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,207:1\n262#2,2:208\n262#2,2:210\n*S KotlinDebug\n*F\n+ 1 FastRecordSearchActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordSearchActivity\n*L\n77#1:208,2\n78#1:210,2\n*E\n"})
public final class FastRecordSearchActivity extends FastRecordBaseActivity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String RECORD_ID = "RECORD_ID";
    @NotNull
    private static final String TAG = "FastRecordSearchActivity";
    /* access modifiers changed from: private */
    @NotNull
    public String keyWordValue = "";
    @NotNull
    private final Lazy layout$delegate = LazyKt.lazy(new FastRecordSearchActivity$layout$2(this));
    private LinearLayoutManager layoutManager;
    private long recordId;
    /* access modifiers changed from: private */
    public FastRecordSearchViewAdapter viewAdapter;
    /* access modifiers changed from: private */
    public FastRecordSearchViewModel viewModel;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordSearchActivity$Companion;", "", "()V", "RECORD_ID", "", "TAG", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final FastRecordSearchActivityBinding getLayout() {
        return (FastRecordSearchActivityBinding) this.layout$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void hideSoftInput() {
        Object systemService = getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(getLayout().getRoot().getWindowToken(), 0);
    }

    @SuppressLint({"RtlHardcoded"})
    private final void initView() {
        LogExt.logE("initView --->", TAG);
        getLayout().g.setOnClickListener(new u0(this));
        LinearLayout linearLayout = getLayout().d;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "llEmpty");
        linearLayout.setVisibility(8);
        RecyclerView recyclerView = getLayout().f;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recRecord");
        recyclerView.setVisibility(0);
        RecyclerView recyclerView2 = getLayout().f;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recRecord");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.layoutManager = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        LinearLayoutManager linearLayoutManager2 = this.layoutManager;
        FastRecordSearchViewAdapter fastRecordSearchViewAdapter = null;
        if (linearLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            linearLayoutManager2 = null;
        }
        recyclerView2.setLayoutManager(linearLayoutManager2);
        FastRecordSearchViewAdapter fastRecordSearchViewAdapter2 = new FastRecordSearchViewAdapter();
        this.viewAdapter = fastRecordSearchViewAdapter2;
        fastRecordSearchViewAdapter2.setItemListener(new FastRecordSearchActivity$initView$2(this));
        recyclerView2.addOnScrollListener(new FastRecordSearchActivity$initView$3(this));
        FastRecordSearchViewAdapter fastRecordSearchViewAdapter3 = this.viewAdapter;
        if (fastRecordSearchViewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
        } else {
            fastRecordSearchViewAdapter = fastRecordSearchViewAdapter3;
        }
        recyclerView2.setAdapter(fastRecordSearchViewAdapter);
        getLayout().c.setOnDrawableClickListener(new FastRecordSearchActivity$initView$4(this));
        getLayout().c.addTextChangedListener(new FastRecordSearchActivity$initView$5(this));
        getLayout().c.postDelayed(new v0(this), 500);
        LogExt.logI("initView init ", TAG);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$0(FastRecordSearchActivity fastRecordSearchActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordSearchActivity, "this$0");
        fastRecordSearchActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$1(FastRecordSearchActivity fastRecordSearchActivity) {
        Intrinsics.checkNotNullParameter(fastRecordSearchActivity, "this$0");
        fastRecordSearchActivity.getLayout().c.requestFocus();
        Object systemService = fastRecordSearchActivity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(fastRecordSearchActivity.getLayout().c, 1);
        LogExt.logE("showSoftInput end ", FastRecordDetailHistoryViewAdapter.TAG);
    }

    private final void initViewModel() {
        FastRecordSearchViewModel fastRecordSearchViewModel = this.viewModel;
        if (fastRecordSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordSearchViewModel = null;
        }
        fastRecordSearchViewModel.getCurRecordData().observe(this, new FastRecordSearchActivity$sam$androidx_lifecycle_Observer$0(new FastRecordSearchActivity$initViewModel$1(this)));
    }

    /* access modifiers changed from: private */
    public final void setDrawable(TextView textView, boolean z) {
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.ic_fast_record_item_search_del);
        if (RecordViewKt.isRtl(this)) {
            if (!z) {
                drawable = null;
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            if (!z) {
                drawable = null;
            }
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
        textView.setSelected(true);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        FastRecordSearchViewModel fastRecordSearchViewModel = (FastRecordSearchViewModel) new ViewModelProvider(this).get(FastRecordSearchViewModel.class);
        this.viewModel = fastRecordSearchViewModel;
        if (fastRecordSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordSearchViewModel = null;
        }
        FastRecordSearchViewModel.queryAllRecordInfo$default(fastRecordSearchViewModel, (Function0) null, 1, (Object) null);
        setContentView((View) getLayout().getRoot());
        long longExtra = getIntent().getLongExtra("RECORD_ID", 0);
        this.recordId = longExtra;
        LogExt.logE("onCreate ---> recordId = " + longExtra, TAG);
        initView();
        initViewModel();
    }

    public void onResume() {
        super.onResume();
        String str = this.keyWordValue;
        LogExt.logE("onResume keyWordValue = " + str, TAG);
        if (!TextUtils.isEmpty(this.keyWordValue)) {
            FastRecordSearchViewModel fastRecordSearchViewModel = this.viewModel;
            if (fastRecordSearchViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                fastRecordSearchViewModel = null;
            }
            fastRecordSearchViewModel.queryAllRecordInfo(new FastRecordSearchActivity$onResume$1(this));
        }
    }
}
