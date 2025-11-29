package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModelProvider;
import com.honey.account.u3.g0;
import com.honey.account.u3.h0;
import com.honey.account.u3.i0;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.databinding.FastRecordDuringDetailActivityBinding;
import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.starrynet.RecordInterConnectHelper;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.recording.FastRecordDetailRecordIngViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordIngDetailActivity;", "Lcom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordBaseActivity;", "()V", "layout", "Lcom/upuphone/ar/fastrecord/databinding/FastRecordDuringDetailActivityBinding;", "getLayout", "()Lcom/upuphone/ar/fastrecord/databinding/FastRecordDuringDetailActivityBinding;", "layout$delegate", "Lkotlin/Lazy;", "recordId", "", "viewModel", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/recording/FastRecordDetailRecordIngViewModel;", "finishPageWhenRecordIdChange", "", "curRecordId", "initView", "initViewModel", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordIngDetailActivity extends FastRecordBaseActivity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String RECORD_ID = "RECORD_ID";
    @NotNull
    private static final String TAG = "FastRecordIngDetailActivity";
    @NotNull
    public static final String TAG_PAUSE = "TAG_PAUSE";
    @NotNull
    public static final String TAG_RESUME = "TAG_RESUME";
    @NotNull
    private final Lazy layout$delegate = LazyKt.lazy(new FastRecordIngDetailActivity$layout$2(this));
    private long recordId;
    /* access modifiers changed from: private */
    public FastRecordDetailRecordIngViewModel viewModel;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordIngDetailActivity$Companion;", "", "()V", "RECORD_ID", "", "TAG", "TAG_PAUSE", "TAG_RESUME", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final void finishPageWhenRecordIdChange(long j) {
        long j2 = this.recordId;
        if (j != j2) {
            LogExt.logE("finishPageWhenRecordIdChange curRecordId = " + j + ",recordId = " + j2, TAG);
            FastRecordDetailRecordIngViewModel fastRecordDetailRecordIngViewModel = this.viewModel;
            if (fastRecordDetailRecordIngViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                fastRecordDetailRecordIngViewModel = null;
            }
            fastRecordDetailRecordIngViewModel.changeRecordFinishState(2, new FastRecordIngDetailActivity$finishPageWhenRecordIdChange$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final FastRecordDuringDetailActivityBinding getLayout() {
        return (FastRecordDuringDetailActivityBinding) this.layout$delegate.getValue();
    }

    private final void initView() {
        LogExt.logE("initView --->", TAG);
        getLayout().c.getTitle().setText(getString(R.string.fast_record_ing));
        getLayout().c.getBackImg().setOnClickListener(new g0(this));
        getLayout().b.b.setOnClickListener(new h0());
        getLayout().b.c.setOnClickListener(new i0(this));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$0(FastRecordIngDetailActivity fastRecordIngDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordIngDetailActivity, "this$0");
        fastRecordIngDetailActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$1(View view) {
        RecordInterConnectHelper.Companion.getInstance().sendMsgEndRec();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$2(FastRecordIngDetailActivity fastRecordIngDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordIngDetailActivity, "this$0");
        Object tag = fastRecordIngDetailActivity.getLayout().b.c.getTag();
        LogExt.logW("layout.llCommand.ivStartRec tag = " + tag, TAG);
        if (Intrinsics.areEqual(tag, (Object) TAG_RESUME)) {
            RecordInterConnectHelper.Companion.getInstance().sendMsgResume();
        } else {
            RecordInterConnectHelper.Companion.getInstance().sendMsgPause();
        }
    }

    private final void initViewModel() {
        FastRecordDetailRecordIngViewModel fastRecordDetailRecordIngViewModel = this.viewModel;
        FastRecordDetailRecordIngViewModel fastRecordDetailRecordIngViewModel2 = null;
        if (fastRecordDetailRecordIngViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordDetailRecordIngViewModel = null;
        }
        fastRecordDetailRecordIngViewModel.getCurRecordData().observe(this, new FastRecordIngDetailActivity$sam$androidx_lifecycle_Observer$0(new FastRecordIngDetailActivity$initViewModel$1(this)));
        FastRecordDetailRecordIngViewModel fastRecordDetailRecordIngViewModel3 = this.viewModel;
        if (fastRecordDetailRecordIngViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            fastRecordDetailRecordIngViewModel2 = fastRecordDetailRecordIngViewModel3;
        }
        fastRecordDetailRecordIngViewModel2.queryRecordAndUpdate(this.recordId);
        FastRecordManager.Companion companion = FastRecordManager.Companion;
        companion.getInstance().appViewModel().getRecordStartRecordDetailIng().observe(this, new FastRecordIngDetailActivity$sam$androidx_lifecycle_Observer$0(new FastRecordIngDetailActivity$initViewModel$2(this)));
        companion.getInstance().appViewModel().getRecordIngTime().observe(this, new FastRecordIngDetailActivity$sam$androidx_lifecycle_Observer$0(new FastRecordIngDetailActivity$initViewModel$3(this)));
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) getLayout().getRoot());
        long longExtra = getIntent().getLongExtra("RECORD_ID", 0);
        this.recordId = longExtra;
        LogExt.logE("onCreate ---> recordId = " + longExtra, TAG);
        this.viewModel = (FastRecordDetailRecordIngViewModel) new ViewModelProvider(this).get(FastRecordDetailRecordIngViewModel.class);
        initView();
        initViewModel();
    }
}
