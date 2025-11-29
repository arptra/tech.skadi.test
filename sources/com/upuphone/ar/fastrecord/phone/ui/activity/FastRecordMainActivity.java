package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.honey.account.u3.j0;
import com.honey.account.u3.k0;
import com.honey.account.u3.l0;
import com.honey.account.u3.m0;
import com.honey.account.u3.n0;
import com.honey.account.u3.o0;
import com.honey.account.u3.p0;
import com.honey.account.u3.q0;
import com.honey.account.u3.r0;
import com.honey.account.u3.s0;
import com.honey.account.u3.t0;
import com.meizu.common.app.LoadingDialog;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.databinding.FastRecordMainActivityBinding;
import com.upuphone.ar.fastrecord.databinding.FastRecordTablayoutCustomTabBinding;
import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.db.RecordEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.starrynet.RecordInterConnectHelper;
import com.upuphone.ar.fastrecord.phone.ui.dialog.FastRecordDeleteDialog;
import com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordFragment;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordMainViewModel;
import com.upuphone.ar.fastrecord.phone.utils.RecordExtKt;
import com.upuphone.ar.fastrecord.phone.utils.RecordVoiceUtils;
import com.upuphone.ar.fastrecord.phone.utils.ViewUtil;
import com.upuphone.star.common.phone.UToast;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 52\u00020\u0001:\u00015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0003J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0019H\u0002J\b\u0010!\u001a\u00020\u0019H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0003J\b\u0010#\u001a\u00020\u0019H\u0002J\u0012\u0010$\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\b\u0010'\u001a\u00020\u0019H\u0014J\b\u0010(\u001a\u00020\u0019H\u0014J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\bH\u0002J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u0014H\u0002J(\u0010-\u001a\u00020\u00192\u0016\u0010.\u001a\u0012\u0012\u0004\u0012\u00020/0\u0004j\b\u0012\u0004\u0012\u00020/`\u00062\u0006\u0010,\u001a\u00020\u0014H\u0002J\b\u00100\u001a\u00020\u0019H\u0002J\b\u00101\u001a\u00020\u0019H\u0002J \u00102\u001a\u00020\u00192\u0016\u00103\u001a\u0012\u0012\u0004\u0012\u0002040\u0004j\b\u0012\u0004\u0012\u000204`\u0006H\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0004j\b\u0012\u0004\u0012\u00020\u0014`\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0004j\b\u0012\u0004\u0012\u00020\u0014`\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordMainActivity;", "Lcom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordBaseActivity;", "()V", "fragments", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "isFinishCreate", "", "layout", "Lcom/upuphone/ar/fastrecord/databinding/FastRecordMainActivityBinding;", "getLayout", "()Lcom/upuphone/ar/fastrecord/databinding/FastRecordMainActivityBinding;", "layout$delegate", "Lkotlin/Lazy;", "mLoadingDialog", "Lcom/meizu/common/app/LoadingDialog;", "mOnPageChangeCallback", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "tabTitles", "", "tabTypes", "viewModel", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordMainViewModel;", "checkRecordIngState", "", "clearSelectDataAndExitStatus", "createMainPage", "delRecord", "gotoRecordIngDetail", "recordId", "", "initTabLayout", "initView", "initViewModel", "initViewPager", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "setPageChooseMode", "choose", "shareByType", "type", "shareFilePath", "shareTempFileUirList", "Landroid/net/Uri;", "shareRecord", "showShareLoadingDialog", "showShareType", "chooseRecordList", "Lcom/upuphone/ar/fastrecord/phone/db/RecordEntity;", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFastRecordMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordMainActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordMainActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,558:1\n1864#2,3:559\n*S KotlinDebug\n*F\n+ 1 FastRecordMainActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordMainActivity\n*L\n543#1:559,3\n*E\n"})
public final class FastRecordMainActivity extends FastRecordBaseActivity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "FastRecordMainActivity";
    @NotNull
    private static final String TAG_DO_NOT_START = "TAG_DO_NOT_START";
    @NotNull
    private static final String TAG_START = "tag_start";
    /* access modifiers changed from: private */
    @NotNull
    public ArrayList<Fragment> fragments = new ArrayList<>();
    private boolean isFinishCreate;
    @NotNull
    private final Lazy layout$delegate = LazyKt.lazy(new FastRecordMainActivity$layout$2(this));
    /* access modifiers changed from: private */
    @Nullable
    public LoadingDialog mLoadingDialog;
    @NotNull
    private final ViewPager.OnPageChangeListener mOnPageChangeCallback = new FastRecordMainActivity$mOnPageChangeCallback$1(this);
    /* access modifiers changed from: private */
    @NotNull
    public ArrayList<String> tabTitles = new ArrayList<>();
    /* access modifiers changed from: private */
    @NotNull
    public ArrayList<String> tabTypes = new ArrayList<>();
    /* access modifiers changed from: private */
    public FastRecordMainViewModel viewModel;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordMainActivity$Companion;", "", "()V", "TAG", "", "TAG_DO_NOT_START", "TAG_START", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void checkRecordIngState() {
        FastRecordManager.Companion.getInstance().appViewModel().getRecordIngItem(new FastRecordMainActivity$checkRecordIngState$1(this));
    }

    /* access modifiers changed from: private */
    public final void clearSelectDataAndExitStatus() {
        runOnUiThread(new l0(this));
    }

    /* access modifiers changed from: private */
    public static final void clearSelectDataAndExitStatus$lambda$11(FastRecordMainActivity fastRecordMainActivity) {
        Intrinsics.checkNotNullParameter(fastRecordMainActivity, "this$0");
        FastRecordMainViewModel fastRecordMainViewModel = fastRecordMainActivity.viewModel;
        FastRecordMainViewModel fastRecordMainViewModel2 = null;
        if (fastRecordMainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordMainViewModel = null;
        }
        fastRecordMainViewModel.setPageModeStatus(2);
        fastRecordMainActivity.setPageChooseMode(false);
        FastRecordMainViewModel fastRecordMainViewModel3 = fastRecordMainActivity.viewModel;
        if (fastRecordMainViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            fastRecordMainViewModel2 = fastRecordMainViewModel3;
        }
        fastRecordMainViewModel2.setClearSelectStatus();
    }

    /* access modifiers changed from: private */
    public final void createMainPage() {
        runOnUiThread(new k0(this));
    }

    /* access modifiers changed from: private */
    public static final void createMainPage$lambda$0(FastRecordMainActivity fastRecordMainActivity) {
        Intrinsics.checkNotNullParameter(fastRecordMainActivity, "this$0");
        if (fastRecordMainActivity.isFinishCreate) {
            LogExt.logE("createMainPage isFinishCreate = true", TAG);
            return;
        }
        LogExt.logE("createMainPage start", TAG);
        fastRecordMainActivity.isFinishCreate = true;
        fastRecordMainActivity.initView();
        fastRecordMainActivity.initViewModel();
    }

    @SuppressLint({"StringFormatInvalid"})
    private final void delRecord() {
        String str;
        FastRecordDeleteDialog fastRecordDeleteDialog = new FastRecordDeleteDialog(this);
        FastRecordMainViewModel fastRecordMainViewModel = this.viewModel;
        if (fastRecordMainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordMainViewModel = null;
        }
        ArrayList value = fastRecordMainViewModel.getMChooseRecordEntityList().getValue();
        int i = 0;
        if ((value != null ? value.size() : 0) > 1) {
            int i2 = R.string.fast_record_del_choose_num;
            FastRecordMainViewModel fastRecordMainViewModel2 = this.viewModel;
            if (fastRecordMainViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                fastRecordMainViewModel2 = null;
            }
            ArrayList value2 = fastRecordMainViewModel2.getMChooseRecordEntityList().getValue();
            if (value2 != null) {
                i = value2.size();
            }
            str = getString(i2, new Object[]{Integer.valueOf(i)});
        } else {
            int i3 = R.string.fast_record_del_choose_single;
            FastRecordMainViewModel fastRecordMainViewModel3 = this.viewModel;
            if (fastRecordMainViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                fastRecordMainViewModel3 = null;
            }
            ArrayList value3 = fastRecordMainViewModel3.getMChooseRecordEntityList().getValue();
            if (value3 != null) {
                i = value3.size();
            }
            str = getString(i3, new Object[]{Integer.valueOf(i)});
        }
        Intrinsics.checkNotNull(str);
        fastRecordDeleteDialog.setTitleText(str);
        FastRecordDeleteDialog.registerButtonClick$default(fastRecordDeleteDialog, new FastRecordMainActivity$delRecord$1(this), (Function0) null, 2, (Object) null);
        fastRecordDeleteDialog.show();
    }

    /* access modifiers changed from: private */
    public final FastRecordMainActivityBinding getLayout() {
        return (FastRecordMainActivityBinding) this.layout$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void gotoRecordIngDetail(long j) {
        clearSelectDataAndExitStatus();
        ViewUtil.startFastRecordIngDetailActivity$default(ViewUtil.INSTANCE, j, this, (Function0) null, 4, (Object) null);
    }

    private final void initTabLayout() {
        getLayout().j.setupWithViewPager(getLayout().i);
        int i = 0;
        for (T next : this.tabTitles) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str = (String) next;
            FastRecordTablayoutCustomTabBinding c = FastRecordTablayoutCustomTabBinding.c(RecordExtKt.fastRecordTabLayoutInflater(this));
            Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
            TabLayout.Tab tabAt = getLayout().j.getTabAt(i);
            if (tabAt != null) {
                tabAt.setCustomView((View) c.getRoot());
            }
            c.b.setText(str);
            i = i2;
        }
    }

    private final void initView() {
        getLayout().k.getTitle().setText(getString(R.string.rec_app_name));
        getLayout().k.getSettingImg().setVisibility(0);
        getLayout().k.getSearchImage().setVisibility(8);
        getLayout().k.getSearchImage().setOnClickListener(new m0(this));
        getLayout().k.getBackImg().setOnClickListener(new n0(this));
        getLayout().k.getSettingImg().setOnClickListener(new o0(this));
        getLayout().d.b.setOnClickListener(new p0(this));
        getLayout().h.d.setOnClickListener(new q0(this));
        getLayout().h.e.setOnClickListener(new r0(this));
        getLayout().e.b.setOnClickListener(new s0(this));
        getLayout().e.c.setOnClickListener(new t0(this));
        initViewPager();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$1(FastRecordMainActivity fastRecordMainActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordMainActivity, "this$0");
        fastRecordMainActivity.startActivity(new Intent(fastRecordMainActivity, FastRecordSearchActivity.class));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$2(FastRecordMainActivity fastRecordMainActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordMainActivity, "this$0");
        fastRecordMainActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$3(FastRecordMainActivity fastRecordMainActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordMainActivity, "this$0");
        fastRecordMainActivity.startActivity(new Intent(fastRecordMainActivity, FastRecordSettingActivity.class));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$4(FastRecordMainActivity fastRecordMainActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordMainActivity, "this$0");
        Object tag = fastRecordMainActivity.getLayout().d.b.getTag();
        LogExt.logW("layout.llCommand.ivStartRec , ivTag is " + tag, TAG);
        if (Intrinsics.areEqual((Object) TAG_DO_NOT_START, tag)) {
            LogExt.logE("ivStartRec tag is TAG_STOP", TAG);
            if (FastRecordManager.Companion.getInstance().appViewModel().getRecordIngState() == 3) {
                UToast.Companion companion = UToast.f6444a;
                String string = fastRecordMainActivity.getString(R.string.fast_record_click_play_tip_for_pasue);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                companion.d(fastRecordMainActivity, string);
                return;
            }
            UToast.Companion companion2 = UToast.f6444a;
            String string2 = fastRecordMainActivity.getString(R.string.fast_record_click_play_tip_for_recording);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            companion2.d(fastRecordMainActivity, string2);
            return;
        }
        RecordInterConnectHelper.Companion.getInstance().sendMsgStartRec();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$5(FastRecordMainActivity fastRecordMainActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordMainActivity, "this$0");
        FastRecordMainViewModel fastRecordMainViewModel = fastRecordMainActivity.viewModel;
        FastRecordMainViewModel fastRecordMainViewModel2 = null;
        if (fastRecordMainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordMainViewModel = null;
        }
        fastRecordMainViewModel.setPageModeStatus(2);
        fastRecordMainActivity.setPageChooseMode(false);
        FastRecordMainViewModel fastRecordMainViewModel3 = fastRecordMainActivity.viewModel;
        if (fastRecordMainViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            fastRecordMainViewModel2 = fastRecordMainViewModel3;
        }
        fastRecordMainViewModel2.setClearSelectStatus();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$6(FastRecordMainActivity fastRecordMainActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordMainActivity, "this$0");
        FastRecordMainViewModel fastRecordMainViewModel = fastRecordMainActivity.viewModel;
        FastRecordMainViewModel fastRecordMainViewModel2 = null;
        if (fastRecordMainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordMainViewModel = null;
        }
        int curPageItemSize = fastRecordMainViewModel.getCurPageItemSize();
        FastRecordMainViewModel fastRecordMainViewModel3 = fastRecordMainActivity.viewModel;
        if (fastRecordMainViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordMainViewModel3 = null;
        }
        LogExt.logE("viewModel.getCurPageItemSize() = " + curPageItemSize + ",viewModel.getChooseRecordEntityListSize() = " + fastRecordMainViewModel3.getChooseRecordEntityListSize(), TAG);
        FastRecordMainViewModel fastRecordMainViewModel4 = fastRecordMainActivity.viewModel;
        if (fastRecordMainViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordMainViewModel4 = null;
        }
        int chooseRecordEntityListSize = fastRecordMainViewModel4.getChooseRecordEntityListSize();
        FastRecordMainViewModel fastRecordMainViewModel5 = fastRecordMainActivity.viewModel;
        if (fastRecordMainViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordMainViewModel5 = null;
        }
        if (chooseRecordEntityListSize != fastRecordMainViewModel5.getCurPageItemSize()) {
            FastRecordMainViewModel fastRecordMainViewModel6 = fastRecordMainActivity.viewModel;
            if (fastRecordMainViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                fastRecordMainViewModel2 = fastRecordMainViewModel6;
            }
            fastRecordMainViewModel2.selectAllItemStatus();
            return;
        }
        FastRecordMainViewModel fastRecordMainViewModel7 = fastRecordMainActivity.viewModel;
        if (fastRecordMainViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            fastRecordMainViewModel2 = fastRecordMainViewModel7;
        }
        fastRecordMainViewModel2.setClearSelectStatus();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$7(FastRecordMainActivity fastRecordMainActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordMainActivity, "this$0");
        FastRecordMainViewModel fastRecordMainViewModel = fastRecordMainActivity.viewModel;
        if (fastRecordMainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordMainViewModel = null;
        }
        if (fastRecordMainViewModel.getChooseRecordEntityListSize() > 0) {
            fastRecordMainActivity.delRecord();
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$8(FastRecordMainActivity fastRecordMainActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordMainActivity, "this$0");
        FastRecordMainViewModel fastRecordMainViewModel = fastRecordMainActivity.viewModel;
        if (fastRecordMainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordMainViewModel = null;
        }
        if (fastRecordMainViewModel.getChooseRecordEntityList().size() > 0) {
            fastRecordMainActivity.shareRecord();
        }
    }

    @SuppressLint({"SetTextI18n"})
    private final void initViewModel() {
        FastRecordMainViewModel fastRecordMainViewModel = this.viewModel;
        FastRecordMainViewModel fastRecordMainViewModel2 = null;
        if (fastRecordMainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordMainViewModel = null;
        }
        fastRecordMainViewModel.getAllFastRecordData().observe(this, new FastRecordMainActivity$sam$androidx_lifecycle_Observer$0(new FastRecordMainActivity$initViewModel$1(this)));
        FastRecordMainViewModel fastRecordMainViewModel3 = this.viewModel;
        if (fastRecordMainViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordMainViewModel3 = null;
        }
        fastRecordMainViewModel3.getMPageStatus().observe(this, new FastRecordMainActivity$sam$androidx_lifecycle_Observer$0(new FastRecordMainActivity$initViewModel$2(this)));
        FastRecordMainViewModel fastRecordMainViewModel4 = this.viewModel;
        if (fastRecordMainViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            fastRecordMainViewModel2 = fastRecordMainViewModel4;
        }
        fastRecordMainViewModel2.getMChooseRecordEntityList().observe(this, new FastRecordMainActivity$sam$androidx_lifecycle_Observer$0(new FastRecordMainActivity$initViewModel$3(this)));
        FastRecordManager.Companion companion = FastRecordManager.Companion;
        companion.getInstance().appViewModel().getRecordStartRecordDetailIng().observe(this, new FastRecordMainActivity$sam$androidx_lifecycle_Observer$0(new FastRecordMainActivity$initViewModel$4(this)));
        companion.getInstance().appViewModel().getRecordGlassCacheInfo().observe(this, new FastRecordMainActivity$sam$androidx_lifecycle_Observer$0(new FastRecordMainActivity$initViewModel$5(this)));
        companion.getInstance().appViewModel().getRecordConnectState().observe(this, new FastRecordMainActivity$sam$androidx_lifecycle_Observer$0(new FastRecordMainActivity$initViewModel$6(this)));
    }

    private final void initViewPager() {
        this.tabTitles.add(getString(R.string.rec_all_record));
        this.tabTitles.add(getString(R.string.rec_scene_record));
        this.tabTitles.add(getString(R.string.rec_phone_record));
        this.tabTypes.add(FastRecordMainViewModel.RECORD_TYPE_ALL);
        this.tabTypes.add(FastRecordMainViewModel.RECORD_TYPE_SCENE);
        this.tabTypes.add("phone");
        ArrayList<Fragment> arrayList = this.fragments;
        FastRecordFragment.Companion companion = FastRecordFragment.Companion;
        Bundle bundle = new Bundle();
        bundle.putString(FastRecordFragment.RECORD_TYPE, FastRecordMainViewModel.RECORD_TYPE_ALL);
        Unit unit = Unit.INSTANCE;
        arrayList.add(companion.getInstance(bundle));
        ArrayList<Fragment> arrayList2 = this.fragments;
        Bundle bundle2 = new Bundle();
        bundle2.putString(FastRecordFragment.RECORD_TYPE, FastRecordMainViewModel.RECORD_TYPE_SCENE);
        arrayList2.add(companion.getInstance(bundle2));
        ArrayList<Fragment> arrayList3 = this.fragments;
        Bundle bundle3 = new Bundle();
        bundle3.putString(FastRecordFragment.RECORD_TYPE, "phone");
        arrayList3.add(companion.getInstance(bundle3));
        getLayout().i.setOffscreenPageLimit(3);
        getLayout().i.addOnPageChangeListener(this.mOnPageChangeCallback);
        getLayout().i.setAdapter(new FastRecordMainActivity$initViewPager$4(this, getSupportFragmentManager()));
        initTabLayout();
        FastRecordMainViewModel fastRecordMainViewModel = this.viewModel;
        if (fastRecordMainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordMainViewModel = null;
        }
        fastRecordMainViewModel.setCurPage(FastRecordMainViewModel.RECORD_TYPE_ALL);
    }

    /* access modifiers changed from: private */
    public final void setPageChooseMode(boolean z) {
        int i = 0;
        if (z) {
            getLayout().k.setVisibility(8);
            getLayout().h.b.setVisibility(0);
            getLayout().j.setVisibility(8);
            getLayout().d.getRoot().setVisibility(8);
            getLayout().e.getRoot().setVisibility(0);
            TextView textView = getLayout().h.c;
            int i2 = R.string.fast_choose_num;
            FastRecordMainViewModel fastRecordMainViewModel = this.viewModel;
            if (fastRecordMainViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                fastRecordMainViewModel = null;
            }
            ArrayList value = fastRecordMainViewModel.getMChooseRecordEntityList().getValue();
            if (value != null) {
                i = value.size();
            }
            textView.setText(getString(i2, new Object[]{Integer.valueOf(i)}));
            return;
        }
        getLayout().k.setVisibility(0);
        getLayout().h.b.setVisibility(8);
        getLayout().j.setVisibility(0);
        getLayout().d.getRoot().setVisibility(0);
        getLayout().e.getRoot().setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void shareByType(String str) {
        LogExt.logV("shareByType type = " + str, TAG);
        FastRecordMainViewModel fastRecordMainViewModel = this.viewModel;
        if (fastRecordMainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordMainViewModel = null;
        }
        fastRecordMainViewModel.getFastRecordShareFilePath(this, str, new FastRecordMainActivity$shareByType$1(this, str));
    }

    /* access modifiers changed from: private */
    public final void shareFilePath(ArrayList<Uri> arrayList, String str) {
        Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.c()), (CoroutineContext) null, (CoroutineStart) null, new FastRecordMainActivity$shareFilePath$1(this, arrayList, str, (Continuation<? super FastRecordMainActivity$shareFilePath$1>) null), 3, (Object) null);
    }

    private final void shareRecord() {
        FastRecordMainViewModel fastRecordMainViewModel = this.viewModel;
        FastRecordMainViewModel fastRecordMainViewModel2 = null;
        if (fastRecordMainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordMainViewModel = null;
        }
        ArrayList<RecordEntity> chooseRecordEntityList = fastRecordMainViewModel.getChooseRecordEntityList();
        showShareLoadingDialog();
        LogExt.logE("shareRecord chooseRecordList.size = " + chooseRecordEntityList.size(), TAG);
        FastRecordMainViewModel fastRecordMainViewModel3 = this.viewModel;
        if (fastRecordMainViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            fastRecordMainViewModel2 = fastRecordMainViewModel3;
        }
        fastRecordMainViewModel2.checkAndMergeFastRecordVideoFile(new FastRecordMainActivity$shareRecord$1(this, chooseRecordEntityList));
    }

    private final void showShareLoadingDialog() {
        LoadingDialog loadingDialog = this.mLoadingDialog;
        if (loadingDialog == null) {
            LoadingDialog loadingDialog2 = new LoadingDialog(this);
            loadingDialog2.setMessage((CharSequence) getString(R.string.fast_record_share_record_wait_text));
            loadingDialog2.setMessageTextColorResource(R.color.fast_record_color_tl_loading_msg_text);
            loadingDialog2.setBackgroundDrawableResource(R.drawable.bg_fast_record_loading_alert);
            loadingDialog2.show();
            this.mLoadingDialog = loadingDialog2;
            loadingDialog2.setOnDismissListener(new j0(this));
        } else if (loadingDialog != null) {
            loadingDialog.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void showShareLoadingDialog$lambda$10(FastRecordMainActivity fastRecordMainActivity, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(fastRecordMainActivity, "this$0");
        FastRecordMainViewModel fastRecordMainViewModel = fastRecordMainActivity.viewModel;
        if (fastRecordMainViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordMainViewModel = null;
        }
        fastRecordMainViewModel.cancelShareJob();
    }

    /* access modifiers changed from: private */
    public final void showShareType(ArrayList<RecordEntity> arrayList) {
        RecordVoiceUtils.INSTANCE.checkFastRecordShareType(arrayList, new FastRecordMainActivity$showShareType$1(this));
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        LogExt.logE("onCreate --->", TAG);
        this.isFinishCreate = false;
        this.viewModel = (FastRecordMainViewModel) new ViewModelProvider(this).get(FastRecordMainViewModel.class);
        setContentView((View) getLayout().getRoot());
    }

    public void onDestroy() {
        super.onDestroy();
        this.tabTitles.clear();
        this.fragments.clear();
        getLayout().i.removeOnPageChangeListener(this.mOnPageChangeCallback);
    }

    public void onResume() {
        super.onResume();
        LogExt.logE("onResume --->", TAG);
        checkRecordIngState();
    }
}
