package com.upuphone.ar.fastrecord.phone.ui.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.honey.account.a4.a;
import com.honey.account.a4.b;
import com.honey.account.a4.c;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.databinding.FastRecordLangDialogBinding;
import com.upuphone.ar.fastrecord.phone.bean.FastRecordLanguageBean;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.xr.sapp.utils.FlymeUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0015\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B2\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0002\u0010\fB:\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cH\u0002J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020\u000bH\u0002J\u001a\u0010 \u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u000eH\u0016J\u000e\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000eJ\u000e\u0010$\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010&\u001a\u00020\u000bH\u0016J\u000e\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u0013R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u001c\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/widget/FastRecordLangDialog;", "Landroid/app/AlertDialog;", "Landroid/content/DialogInterface$OnClickListener;", "context", "Landroid/content/Context;", "onDateChanged", "Lkotlin/Function1;", "Lcom/upuphone/ar/fastrecord/phone/bean/FastRecordLanguageBean;", "Lkotlin/ParameterName;", "name", "languageBean", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "themeResId", "", "(Landroid/content/Context;ILkotlin/jvm/functions/Function1;)V", "mBinding", "Lcom/upuphone/ar/fastrecord/databinding/FastRecordLangDialogBinding;", "mIsNavigationBar", "", "mLangAdapter", "com/upuphone/ar/fastrecord/phone/ui/widget/FastRecordLangDialog$mLangAdapter$1", "Lcom/upuphone/ar/fastrecord/phone/ui/widget/FastRecordLangDialog$mLangAdapter$1;", "mOnDateChanged", "getIndexLangType", "langType", "", "getIntlLangList", "", "getLangList", "initData", "initView", "onClick", "dialog", "Landroid/content/DialogInterface;", "which", "refreshCurrent", "current", "show", "visibleNavigationBar", "isVisible", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFastRecordLangDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordLangDialog.kt\ncom/upuphone/ar/fastrecord/phone/ui/widget/FastRecordLangDialog\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,215:1\n262#2,2:216\n*S KotlinDebug\n*F\n+ 1 FastRecordLangDialog.kt\ncom/upuphone/ar/fastrecord/phone/ui/widget/FastRecordLangDialog\n*L\n77#1:216,2\n*E\n"})
public final class FastRecordLangDialog extends AlertDialog implements DialogInterface.OnClickListener {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "FastRecordLangDialog";
    @NotNull
    private FastRecordLangDialogBinding mBinding;
    private boolean mIsNavigationBar;
    @NotNull
    private final FastRecordLangDialog$mLangAdapter$1 mLangAdapter;
    @Nullable
    private Function1<? super FastRecordLanguageBean, Unit> mOnDateChanged;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/widget/FastRecordLangDialog$Companion;", "", "()V", "TAG", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FastRecordLangDialog(@NotNull Context context, @NotNull Function1<? super FastRecordLanguageBean, Unit> function1) {
        this(context, R.style.LangPickerStyle, function1);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "onDateChanged");
    }

    private final int getIndexLangType(String str) {
        int i = 0;
        for (FastRecordLanguageBean langType : getLangList()) {
            int i2 = i + 1;
            if (Intrinsics.areEqual((Object) str, (Object) langType.getLangType())) {
                return i;
            }
            i = i2;
        }
        return -1;
    }

    private final List<FastRecordLanguageBean> getIntlLangList() {
        ArrayList arrayList = new ArrayList();
        String string = getContext().getString(R.string.fr_simultaneous_cn);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        arrayList.add(new FastRecordLanguageBean(string, "cmn-Hans-CN"));
        String string2 = getContext().getString(R.string.fr_simultaneous_en);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        arrayList.add(new FastRecordLanguageBean(string2, "en-GB"));
        String string3 = getContext().getString(R.string.fr_simultaneous_fr);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        arrayList.add(new FastRecordLanguageBean(string3, "fr-FR"));
        String string4 = getContext().getString(R.string.fr_simultaneous_de);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        arrayList.add(new FastRecordLanguageBean(string4, "de-DE"));
        String string5 = getContext().getString(R.string.fr_simultaneous_ms);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        arrayList.add(new FastRecordLanguageBean(string5, "ms-MY"));
        String string6 = getContext().getString(R.string.fr_simultaneous_id);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        arrayList.add(new FastRecordLanguageBean(string6, "id-ID"));
        String string7 = getContext().getString(R.string.fr_simultaneous_th);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        arrayList.add(new FastRecordLanguageBean(string7, "th-TH"));
        String string8 = getContext().getString(R.string.fr_simultaneous_ja);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        arrayList.add(new FastRecordLanguageBean(string8, "ja-JP"));
        String string9 = getContext().getString(R.string.fr_simultaneous_ko);
        Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
        arrayList.add(new FastRecordLanguageBean(string9, "ko-KR"));
        String string10 = getContext().getString(R.string.fr_simultaneous_ar);
        Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
        arrayList.add(new FastRecordLanguageBean(string10, "ar-SA"));
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final List<FastRecordLanguageBean> getLangList() {
        return getIntlLangList();
    }

    private final void initData() {
        this.mBinding.c.setData(this.mLangAdapter, 0, getLangList().size(), 5);
        this.mBinding.c.setCyclic(false);
        this.mBinding.c.setTextColor(getContext().getColor(R.color.fast_record_color_select_lang_item_select), (List<Integer>) CollectionsKt.arrayListOf(Integer.valueOf(getContext().getColor(R.color.fast_record_color_select_lang_item_no_select_one)), Integer.valueOf(getContext().getColor(R.color.fast_record_color_select_lang_item_no_select_two))));
        this.mBinding.c.setTextSize(getContext().getResources().getDimension(R.dimen.fast_record_dimen_select_lang_item_select), (List<Float>) CollectionsKt.arrayListOf(Float.valueOf(getContext().getResources().getDimension(R.dimen.fast_record_dimen_select_lang_item_no_select_one)), Float.valueOf(getContext().getResources().getDimension(R.dimen.fast_record_dimen_select_lang_item_no_select_two))));
    }

    private final void initView() {
        View decorView;
        Window window = getWindow();
        if (!(window == null || (decorView = window.getDecorView()) == null)) {
            decorView.setBackgroundColor(0);
        }
        this.mBinding.c.setIsDrawFading(false);
        this.mBinding.e.setOnClickListener(new a(this));
        this.mBinding.d.setOnClickListener(new b(this));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$2(FastRecordLangDialog fastRecordLangDialog, View view) {
        Intrinsics.checkNotNullParameter(fastRecordLangDialog, "this$0");
        int currentItem = fastRecordLangDialog.mBinding.c.getCurrentItem();
        LogExt.logE("确定 currentItem: " + currentItem, TAG);
        Function1<? super FastRecordLanguageBean, Unit> function1 = fastRecordLangDialog.mOnDateChanged;
        if (function1 != null) {
            function1.invoke(fastRecordLangDialog.getLangList().get(currentItem));
        }
        fastRecordLangDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$3(FastRecordLangDialog fastRecordLangDialog, View view) {
        Intrinsics.checkNotNullParameter(fastRecordLangDialog, "this$0");
        LogExt.logE("取消", TAG);
        fastRecordLangDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void show$lambda$1(FastRecordLangDialog fastRecordLangDialog) {
        Intrinsics.checkNotNullParameter(fastRecordLangDialog, "this$0");
        View view = fastRecordLangDialog.mBinding.b;
        Intrinsics.checkNotNullExpressionValue(view, "dialogBottom");
        view.setVisibility(fastRecordLangDialog.mIsNavigationBar ^ true ? 0 : 8);
    }

    public void onClick(@Nullable DialogInterface dialogInterface, int i) {
        if (i == -2) {
            LogExt.logE("取消", TAG);
        } else if (i == -1) {
            int currentItem = this.mBinding.c.getCurrentItem();
            LogExt.logE("确定 currentItem: " + currentItem, TAG);
            Function1<? super FastRecordLanguageBean, Unit> function1 = this.mOnDateChanged;
            if (function1 != null) {
                function1.invoke(getLangList().get(currentItem));
            }
        }
    }

    public final void refreshCurrent(int i) {
        this.mBinding.c.refreshCurrent(i);
    }

    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(window.getAttributes());
            layoutParams.width = -1;
            window.setAttributes(layoutParams);
        }
        this.mBinding.getRoot().post(new c(this));
    }

    public final void visibleNavigationBar(boolean z) {
        this.mIsNavigationBar = z;
    }

    public final void refreshCurrent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "langType");
        int indexLangType = getIndexLangType(str);
        if (indexLangType != -1) {
            refreshCurrent(indexLangType);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordLangDialog(@NotNull Context context, int i, @NotNull Function1<? super FastRecordLanguageBean, Unit> function1) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "onDateChanged");
        this.mLangAdapter = new FastRecordLangDialog$mLangAdapter$1(this);
        this.mOnDateChanged = function1;
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
        }
        FastRecordLangDialogBinding c = FastRecordLangDialogBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.mBinding = c;
        setView(c.getRoot());
        FlymeUtils.a(this.mBinding.getRoot(), context);
        initView();
        initData();
    }
}
