package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.honey.account.u3.b;
import com.honey.account.u3.c;
import com.honey.account.u3.d;
import com.honey.account.u3.e;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.databinding.FastRecordExtractActivityBinding;
import com.upuphone.ar.fastrecord.databinding.FastRecordTablayoutCustomTabBinding;
import com.upuphone.ar.fastrecord.phone.FastRecordManager;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordSummaryFragment;
import com.upuphone.ar.fastrecord.phone.ui.fragment.FastRecordTodoFragment;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordSummaryViewModel;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiSummaryOperatorManager;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.ai.FastRecordAiTodoOperatorManager;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean;
import com.upuphone.ar.fastrecord.phone.utils.RecordConstants;
import com.upuphone.ar.fastrecord.phone.utils.RecordExtKt;
import com.upuphone.ar.fastrecord.phone.utils.RecordFileUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0019H\u0002J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\b\u0010$\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020 H\u0002J\b\u0010&\u001a\u00020 H\u0002J\b\u0010'\u001a\u00020 H\u0002J\b\u0010(\u001a\u00020 H\u0002J\u0012\u0010)\u001a\u00020 2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J\b\u0010,\u001a\u00020 H\u0014J\u0010\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020#H\u0002J\u0006\u0010/\u001a\u00020 R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0004j\b\u0012\u0004\u0012\u00020\u0012`\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordExtractActivity;", "Lcom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordBaseActivity;", "()V", "fragments", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "layout", "Lcom/upuphone/ar/fastrecord/databinding/FastRecordExtractActivityBinding;", "getLayout", "()Lcom/upuphone/ar/fastrecord/databinding/FastRecordExtractActivityBinding;", "layout$delegate", "Lkotlin/Lazy;", "mOnPageChangeCallback", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "requestBean", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/SummaryRequestBean;", "shareFile", "", "summaryViewModel", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordSummaryViewModel;", "tabTitles", "todoViewModel", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTodoViewModel;", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "exitExitEditMode", "", "isAll", "getSharFile", "Ljava/io/File;", "initData", "initTab", "initTabTitles", "initView", "initViewPager", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "shareTextFile", "file", "updateTitleBarStatus", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFastRecordExtractActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordExtractActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordExtractActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,258:1\n1864#2,3:259\n1#3:262\n*S KotlinDebug\n*F\n+ 1 FastRecordExtractActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordExtractActivity\n*L\n134#1:259,3\n*E\n"})
public final class FastRecordExtractActivity extends FastRecordBaseActivity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int EXTRACT_TYPE_SUMMARY = 0;
    private static final int EXTRACT_TYPE_TODO = 1;
    @NotNull
    private static final String TAG = "ExtractActivity";
    /* access modifiers changed from: private */
    @NotNull
    public ArrayList<Fragment> fragments = new ArrayList<>();
    @NotNull
    private final Lazy layout$delegate = LazyKt.lazy(new FastRecordExtractActivity$layout$2(this));
    @NotNull
    private final ViewPager.OnPageChangeListener mOnPageChangeCallback = new FastRecordExtractActivity$mOnPageChangeCallback$1(this);
    private SummaryRequestBean requestBean;
    @NotNull
    private String shareFile = "";
    private FastRecordSummaryViewModel summaryViewModel;
    /* access modifiers changed from: private */
    @NotNull
    public ArrayList<String> tabTitles = new ArrayList<>();
    private FastRecordTodoViewModel todoViewModel;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordExtractActivity$Companion;", "", "()V", "EXTRACT_TYPE_SUMMARY", "", "EXTRACT_TYPE_TODO", "TAG", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordSummaryViewModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void exitExitEditMode(boolean r4) {
        /*
            r3 = this;
            java.lang.String r0 = "todoViewModel"
            java.lang.String r1 = "summaryViewModel"
            r2 = 0
            if (r4 == 0) goto L_0x0020
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordSummaryViewModel r4 = r3.summaryViewModel
            if (r4 != 0) goto L_0x0010
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r4 = r2
        L_0x0010:
            r4.editModeNotify()
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel r3 = r3.todoViewModel
            if (r3 != 0) goto L_0x001b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L_0x001c
        L_0x001b:
            r2 = r3
        L_0x001c:
            r2.editModeNotify()
            goto L_0x0045
        L_0x0020:
            com.upuphone.ar.fastrecord.databinding.FastRecordExtractActivityBinding r4 = r3.getLayout()
            androidx.viewpager.widget.ViewPager r4 = r4.d
            int r4 = r4.getCurrentItem()
            if (r4 != 0) goto L_0x0039
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordSummaryViewModel r3 = r3.summaryViewModel
            if (r3 != 0) goto L_0x0034
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x0035
        L_0x0034:
            r2 = r3
        L_0x0035:
            r2.editModeNotify()
            goto L_0x0045
        L_0x0039:
            com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTodoViewModel r3 = r3.todoViewModel
            if (r3 != 0) goto L_0x0041
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L_0x0042
        L_0x0041:
            r2 = r3
        L_0x0042:
            r2.editModeNotify()
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.activity.FastRecordExtractActivity.exitExitEditMode(boolean):void");
    }

    /* access modifiers changed from: private */
    public final FastRecordExtractActivityBinding getLayout() {
        return (FastRecordExtractActivityBinding) this.layout$delegate.getValue();
    }

    private final File getSharFile() {
        FastRecordSummaryViewModel fastRecordSummaryViewModel = this.summaryViewModel;
        String str = null;
        if (fastRecordSummaryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryViewModel");
            fastRecordSummaryViewModel = null;
        }
        String summaryShareText = fastRecordSummaryViewModel.getSummaryShareText();
        FastRecordTodoViewModel fastRecordTodoViewModel = this.todoViewModel;
        if (fastRecordTodoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("todoViewModel");
            fastRecordTodoViewModel = null;
        }
        String todoShareText = fastRecordTodoViewModel.getTodoShareText();
        FastRecordSummaryViewModel fastRecordSummaryViewModel2 = this.summaryViewModel;
        if (fastRecordSummaryViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryViewModel");
            fastRecordSummaryViewModel2 = null;
        }
        SummaryRequestBean requestBean2 = fastRecordSummaryViewModel2.getRequestBean();
        String shortHandTitle = requestBean2 != null ? requestBean2.getShortHandTitle() : null;
        if (shortHandTitle == null || shortHandTitle.length() == 0) {
            LogExt.logE("getSharFile::shortHandTitle is null or empty.", TAG);
            FastRecordSummaryViewModel fastRecordSummaryViewModel3 = this.summaryViewModel;
            if (fastRecordSummaryViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("summaryViewModel");
                fastRecordSummaryViewModel3 = null;
            }
            SummaryRequestBean requestBean3 = fastRecordSummaryViewModel3.getRequestBean();
            if (requestBean3 != null) {
                requestBean3.setShortHandTitle(getString(R.string.fast_record_scene));
            }
        } else {
            FastRecordSummaryViewModel fastRecordSummaryViewModel4 = this.summaryViewModel;
            if (fastRecordSummaryViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("summaryViewModel");
                fastRecordSummaryViewModel4 = null;
            }
            SummaryRequestBean requestBean4 = fastRecordSummaryViewModel4.getRequestBean();
            LogExt.logE("getSharFile  shortHandTitle=" + (requestBean4 != null ? requestBean4.getShortHandTitle() : null), TAG);
        }
        LogExt.logE("summary = " + summaryShareText + ",todo = " + todoShareText, TAG);
        FastRecordSummaryViewModel fastRecordSummaryViewModel5 = this.summaryViewModel;
        if (fastRecordSummaryViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryViewModel");
            fastRecordSummaryViewModel5 = null;
        }
        SummaryRequestBean requestBean5 = fastRecordSummaryViewModel5.getRequestBean();
        if (requestBean5 != null) {
            RecordFileUtils recordFileUtils = RecordFileUtils.INSTANCE;
            String shortHandTitle2 = requestBean5.getShortHandTitle();
            Intrinsics.checkNotNullExpressionValue(shortHandTitle2, "getShortHandTitle(...)");
            str = recordFileUtils.getTxtFileName(shortHandTitle2);
        }
        RecordFileUtils recordFileUtils2 = RecordFileUtils.INSTANCE;
        recordFileUtils2.delete(new File(str));
        StringBuilder sb = new StringBuilder();
        FastRecordManager.Companion companion = FastRecordManager.Companion;
        String string = companion.getInstance().appContext().getString(R.string.fr_extract_statement);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        sb.append("/*");
        sb.append(string);
        sb.append("*/");
        sb.append(StringUtils.LF);
        sb.append(todoShareText);
        sb.append(summaryShareText);
        LogExt.logE("getSharFile::fileName is: " + str + " sb.toString()=" + sb, TAG);
        Context appContext = companion.getInstance().appContext();
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        File createExtractShareFile = recordFileUtils2.createExtractShareFile(appContext, sb2, str);
        if (createExtractShareFile != null) {
            createExtractShareFile.setReadOnly();
        }
        return createExtractShareFile;
    }

    private final void initData() {
        Bundle extras = getIntent().getExtras();
        FastRecordTodoViewModel fastRecordTodoViewModel = null;
        Serializable serializable = extras != null ? extras.getSerializable(RecordConstants.FR_EXTRACT_REQ_KEY) : null;
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.SummaryRequestBean");
        SummaryRequestBean summaryRequestBean = (SummaryRequestBean) serializable;
        this.requestBean = summaryRequestBean;
        if (summaryRequestBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestBean");
            summaryRequestBean = null;
        }
        LogExt.logV("initData  requestBean is :" + summaryRequestBean, TAG);
        FastRecordSummaryViewModel fastRecordSummaryViewModel = this.summaryViewModel;
        if (fastRecordSummaryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryViewModel");
            fastRecordSummaryViewModel = null;
        }
        SummaryRequestBean summaryRequestBean2 = this.requestBean;
        if (summaryRequestBean2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestBean");
            summaryRequestBean2 = null;
        }
        fastRecordSummaryViewModel.setSummaryRequestBean(summaryRequestBean2);
        FastRecordTodoViewModel fastRecordTodoViewModel2 = this.todoViewModel;
        if (fastRecordTodoViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("todoViewModel");
            fastRecordTodoViewModel2 = null;
        }
        SummaryRequestBean summaryRequestBean3 = this.requestBean;
        if (summaryRequestBean3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestBean");
            summaryRequestBean3 = null;
        }
        fastRecordTodoViewModel2.setSummaryRequestBean(summaryRequestBean3);
        FastRecordSummaryViewModel fastRecordSummaryViewModel2 = this.summaryViewModel;
        if (fastRecordSummaryViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryViewModel");
            fastRecordSummaryViewModel2 = null;
        }
        SummaryRequestBean summaryRequestBean4 = this.requestBean;
        if (summaryRequestBean4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestBean");
            summaryRequestBean4 = null;
        }
        Long recordId = summaryRequestBean4.getRecordId();
        Intrinsics.checkNotNullExpressionValue(recordId, "getRecordId(...)");
        fastRecordSummaryViewModel2.queryRecordInfo(recordId.longValue());
        FastRecordTodoViewModel fastRecordTodoViewModel3 = this.todoViewModel;
        if (fastRecordTodoViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("todoViewModel");
            fastRecordTodoViewModel3 = null;
        }
        SummaryRequestBean summaryRequestBean5 = this.requestBean;
        if (summaryRequestBean5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestBean");
            summaryRequestBean5 = null;
        }
        Long recordId2 = summaryRequestBean5.getRecordId();
        Intrinsics.checkNotNullExpressionValue(recordId2, "getRecordId(...)");
        fastRecordTodoViewModel3.queryRecordInfo(recordId2.longValue());
        FastRecordSummaryViewModel fastRecordSummaryViewModel3 = this.summaryViewModel;
        if (fastRecordSummaryViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryViewModel");
            fastRecordSummaryViewModel3 = null;
        }
        fastRecordSummaryViewModel3.getCurIsFinishAiSummary().observe(this, new FastRecordExtractActivity$sam$androidx_lifecycle_Observer$0(new FastRecordExtractActivity$initData$1(this)));
        FastRecordSummaryViewModel fastRecordSummaryViewModel4 = this.summaryViewModel;
        if (fastRecordSummaryViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryViewModel");
            fastRecordSummaryViewModel4 = null;
        }
        SummaryRequestBean summaryRequestBean6 = this.requestBean;
        if (summaryRequestBean6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestBean");
            summaryRequestBean6 = null;
        }
        Long recordId3 = summaryRequestBean6.getRecordId();
        Intrinsics.checkNotNullExpressionValue(recordId3, "getRecordId(...)");
        fastRecordSummaryViewModel4.getTodoAndSummaryData(recordId3.longValue());
        FastRecordTodoViewModel fastRecordTodoViewModel4 = this.todoViewModel;
        if (fastRecordTodoViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("todoViewModel");
        } else {
            fastRecordTodoViewModel = fastRecordTodoViewModel4;
        }
        fastRecordTodoViewModel.getTodoListFromLocal(FastRecordExtractActivity$initData$2.INSTANCE);
    }

    private final void initTab() {
        getLayout().b.setupWithViewPager(getLayout().d);
        int i = 0;
        for (T next : this.tabTitles) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str = (String) next;
            FastRecordTablayoutCustomTabBinding c = FastRecordTablayoutCustomTabBinding.c(RecordExtKt.fastRecordTabLayoutInflater(this));
            Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
            TabLayout.Tab tabAt = getLayout().b.getTabAt(i);
            if (tabAt != null) {
                tabAt.setCustomView((View) c.getRoot());
            }
            c.b.setText(str);
            i = i2;
        }
    }

    private final void initTabTitles() {
        this.tabTitles.add(getString(R.string.fast_record_summary_total_type));
        this.tabTitles.add(getString(R.string.fast_record_summary_dealt_type));
    }

    private final void initView() {
        getLayout().e.getAiImg().setVisibility(8);
        getLayout().e.getDelImage().setVisibility(8);
        getLayout().e.getShare().setVisibility(0);
        getLayout().e.getShare().setAlpha(0.3f);
        getLayout().e.getBackImg().setOnClickListener(new b(this));
        getLayout().e.getShare().setSelected(false);
        getLayout().e.getShare().setOnClickListener(new c(this));
        getLayout().e.setOnClickListener(new d(this));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$0(FastRecordExtractActivity fastRecordExtractActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordExtractActivity, "this$0");
        fastRecordExtractActivity.exitExitEditMode(false);
        fastRecordExtractActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$2(FastRecordExtractActivity fastRecordExtractActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordExtractActivity, "this$0");
        int currentItem = fastRecordExtractActivity.getLayout().d.getCurrentItem();
        LogExt.logV("share  currentItem is : " + currentItem, TAG);
        fastRecordExtractActivity.exitExitEditMode(false);
        if (fastRecordExtractActivity.getLayout().e.getShare().isSelected()) {
            fastRecordExtractActivity.runOnUiThread(new e(fastRecordExtractActivity));
        } else {
            LogExt.logV("share summary not is enable!", TAG);
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$2$lambda$1(FastRecordExtractActivity fastRecordExtractActivity) {
        Intrinsics.checkNotNullParameter(fastRecordExtractActivity, "this$0");
        RecordFileUtils.INSTANCE.delete(new File(fastRecordExtractActivity.shareFile));
        File sharFile = fastRecordExtractActivity.getSharFile();
        if (sharFile != null) {
            fastRecordExtractActivity.shareTextFile(sharFile);
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$3(FastRecordExtractActivity fastRecordExtractActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordExtractActivity, "this$0");
        fastRecordExtractActivity.exitExitEditMode(false);
    }

    private final void initViewPager() {
        this.fragments.add(FastRecordSummaryFragment.Companion.getInstance(new Bundle()));
        this.fragments.add(FastRecordTodoFragment.Companion.getInstance(new Bundle()));
        getLayout().d.addOnPageChangeListener(this.mOnPageChangeCallback);
        getLayout().d.setOffscreenPageLimit(2);
        getLayout().d.setAdapter(new FastRecordExtractActivity$initViewPager$1(this, getSupportFragmentManager()));
    }

    private final void shareTextFile(File file) {
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        this.shareFile = path;
        Uri uriForFile = FileProvider.getUriForFile(this, "com.upuphone.ar.shorthand.phone.fileprovider", file);
        Intrinsics.checkNotNull(uriForFile);
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        RecordExtKt.shareFile(this, uriForFile, "text/plain", name);
    }

    public boolean dispatchKeyEvent(@Nullable KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchTouchEvent(@Nullable MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) getLayout().getRoot());
        this.summaryViewModel = (FastRecordSummaryViewModel) new ViewModelProvider(this).get(FastRecordSummaryViewModel.class);
        this.todoViewModel = (FastRecordTodoViewModel) new ViewModelProvider(this).get(FastRecordTodoViewModel.class);
        initData();
        initView();
        initTabTitles();
        initViewPager();
        initTab();
    }

    public void onDestroy() {
        super.onDestroy();
        this.tabTitles.clear();
        this.fragments.clear();
        FastRecordAiSummaryOperatorManager fastRecordAiSummaryOperatorManager = FastRecordAiSummaryOperatorManager.INSTANCE;
        SummaryRequestBean summaryRequestBean = this.requestBean;
        SummaryRequestBean summaryRequestBean2 = null;
        if (summaryRequestBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestBean");
            summaryRequestBean = null;
        }
        String recognizeId = summaryRequestBean.getRecognizeId();
        Intrinsics.checkNotNullExpressionValue(recognizeId, "getRecognizeId(...)");
        fastRecordAiSummaryOperatorManager.removeCallback(recognizeId);
        FastRecordAiTodoOperatorManager fastRecordAiTodoOperatorManager = FastRecordAiTodoOperatorManager.INSTANCE;
        SummaryRequestBean summaryRequestBean3 = this.requestBean;
        if (summaryRequestBean3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestBean");
        } else {
            summaryRequestBean2 = summaryRequestBean3;
        }
        String recognizeId2 = summaryRequestBean2.getRecognizeId();
        Intrinsics.checkNotNullExpressionValue(recognizeId2, "getRecognizeId(...)");
        fastRecordAiTodoOperatorManager.removeCallback(recognizeId2);
    }

    public final void updateTitleBarStatus() {
        FastRecordSummaryViewModel fastRecordSummaryViewModel = this.summaryViewModel;
        SummaryRequestBean summaryRequestBean = null;
        if (fastRecordSummaryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryViewModel");
            fastRecordSummaryViewModel = null;
        }
        SummaryRequestBean summaryRequestBean2 = this.requestBean;
        if (summaryRequestBean2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestBean");
        } else {
            summaryRequestBean = summaryRequestBean2;
        }
        Long recordId = summaryRequestBean.getRecordId();
        Intrinsics.checkNotNullExpressionValue(recordId, "getRecordId(...)");
        fastRecordSummaryViewModel.getTodoAndSummaryData(recordId.longValue());
    }
}
