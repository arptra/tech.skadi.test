package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.Gson;
import com.honey.account.u3.a1;
import com.honey.account.u3.w0;
import com.honey.account.u3.x0;
import com.honey.account.u3.y0;
import com.honey.account.u3.z0;
import com.meizu.common.widget.Switch;
import com.tencent.mmkv.MMKV;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.databinding.FastRecordSettingActivityBinding;
import com.upuphone.ar.fastrecord.phone.bean.FastRecordLanguageBean;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ext.RecordViewKt;
import com.upuphone.ar.fastrecord.phone.ui.widget.FastRecordLangDialog;
import com.upuphone.ar.fastrecord.phone.utils.RecordDataSaveUtil;
import com.upuphone.ar.fastrecord.phone.utils.RecordExtKt;
import com.upuphone.ar.fastrecord.phone.utils.ViewUtil;
import com.upuphone.xr.sapp.context.SdkContext;
import flyme.support.v7.app.AlertDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\u0012\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0012H\u0014J\b\u0010\u001c\u001a\u00020\u0012H\u0014J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\b\u0010\u001e\u001a\u00020\u0012H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordSettingActivity;", "Lcom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordBaseActivity;", "()V", "layout", "Lcom/upuphone/ar/fastrecord/databinding/FastRecordSettingActivityBinding;", "getLayout", "()Lcom/upuphone/ar/fastrecord/databinding/FastRecordSettingActivityBinding;", "layout$delegate", "Lkotlin/Lazy;", "mFastRecordLangDialog", "Lcom/upuphone/ar/fastrecord/phone/ui/widget/FastRecordLangDialog;", "mFastRecordLanguage", "Lcom/upuphone/ar/fastrecord/phone/bean/FastRecordLanguageBean;", "permissionList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "checkLocationPermission", "", "finish", "getTypeName", "langType", "initLanguage", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "showLanguageDialog", "sureOpenLocation", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFastRecordSettingActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordSettingActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordSettingActivity\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,215:1\n37#2,2:216\n37#2,2:222\n37#2,2:224\n262#3,2:218\n223#4,2:220\n*S KotlinDebug\n*F\n+ 1 FastRecordSettingActivity.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordSettingActivity\n*L\n80#1:216,2\n183#1:222,2\n191#1:224,2\n147#1:218,2\n153#1:220,2\n*E\n"})
public final class FastRecordSettingActivity extends FastRecordBaseActivity {
    @NotNull
    private static final String CHINESE = "Chinese";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String ENGLISH = "English";
    @NotNull
    private static final String FRENCH = "French";
    @NotNull
    private static final String GERMAN = "German";
    @NotNull
    private static final String INDONESIAN = "Indonesian";
    @NotNull
    public static final String IS_REC_SOUND_CHECK = "IS_REC_SOUND_CHECK";
    @NotNull
    public static final String IS_START_LOCATION = "IS_START_LOCATION";
    @NotNull
    private static final String IS_START_PRE_REC = "IS_START_PRE_REC";
    @NotNull
    public static final String IS_START_SOUND_CHECK = "IS_START_SOUND_CHECK";
    @NotNull
    private static final String MALAY = "Malay";
    @NotNull
    private static final String TAG = "FastRecordSettingActivity";
    @NotNull
    private static final String THAI = "Thai";
    @NotNull
    private final Lazy layout$delegate = LazyKt.lazy(new FastRecordSettingActivity$layout$2(this));
    @Nullable
    private FastRecordLangDialog mFastRecordLangDialog;
    /* access modifiers changed from: private */
    @Nullable
    public FastRecordLanguageBean mFastRecordLanguage;
    @NotNull
    private final ArrayList<String> permissionList;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordSettingActivity$Companion;", "", "()V", "CHINESE", "", "ENGLISH", "FRENCH", "GERMAN", "INDONESIAN", "IS_REC_SOUND_CHECK", "IS_START_LOCATION", "IS_START_PRE_REC", "IS_START_SOUND_CHECK", "MALAY", "TAG", "THAI", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public FastRecordSettingActivity() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        this.permissionList = arrayList;
    }

    private final void checkLocationPermission() {
        SdkContext sdkContext = SdkContext.f6675a;
        boolean a2 = sdkContext.f().a((String[]) this.permissionList.toArray(new String[0]));
        LogExt.logE("checkLocationPermission permissionState = " + a2, TAG);
        if (a2) {
            MMKV.n().w(IS_START_LOCATION, true);
            getLayout().f.setChecked(true);
            return;
        }
        sdkContext.f().d(this, (String[]) this.permissionList.toArray(new String[0]), new HashMap(), new FastRecordSettingActivity$checkLocationPermission$1(this));
    }

    /* access modifiers changed from: private */
    public final FastRecordSettingActivityBinding getLayout() {
        return (FastRecordSettingActivityBinding) this.layout$delegate.getValue();
    }

    private final String getTypeName(String str) {
        for (FastRecordLanguageBean fastRecordLanguageBean : ViewUtil.INSTANCE.getIntlLangList(this)) {
            if (Intrinsics.areEqual((Object) fastRecordLanguageBean.getLangType(), (Object) str)) {
                return fastRecordLanguageBean.getLangName();
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final void initLanguage() {
        Unit unit;
        String aiLanguageType = RecordDataSaveUtil.INSTANCE.getAiLanguageType();
        getLayout().k.setText(getString(R.string.fr_simultaneous_cn));
        try {
            Result.Companion companion = Result.Companion;
            FastRecordLanguageBean fastRecordLanguageBean = (FastRecordLanguageBean) new Gson().fromJson(aiLanguageType, FastRecordLanguageBean.class);
            this.mFastRecordLanguage = fastRecordLanguageBean;
            if (fastRecordLanguageBean != null) {
                getLayout().k.setText(getTypeName(fastRecordLanguageBean.getLangType()));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Result.m20constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m20constructorimpl(ResultKt.createFailure(th));
        }
        ConstraintLayout constraintLayout = getLayout().d;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "llSettingLanguage");
        constraintLayout.setVisibility(SdkContext.f6675a.c().e() ? 0 : 8);
    }

    private final void initView() {
        getLayout().i.getBackImg().setOnClickListener(new y0(this));
        getLayout().f.setChecked(MMKV.n().d(IS_START_LOCATION, false));
        getLayout().g.setChecked(MMKV.n().c(IS_START_PRE_REC));
        getLayout().h.setChecked(MMKV.n().c(IS_START_SOUND_CHECK));
        if (MMKV.n().c(IS_REC_SOUND_CHECK)) {
            getLayout().p.setVisibility(0);
        } else {
            getLayout().p.setVisibility(8);
        }
        getLayout().e.setOnClickListener(new z0(this));
        Switch switchR = getLayout().g;
        Intrinsics.checkNotNullExpressionValue(switchR, "swPreRec");
        RecordViewKt.recordOnCheckedChange(switchR, FastRecordSettingActivity$initView$3.INSTANCE);
        Switch switchR2 = getLayout().h;
        Intrinsics.checkNotNullExpressionValue(switchR2, "swSoundCheck");
        RecordViewKt.recordOnCheckedChange(switchR2, FastRecordSettingActivity$initView$4.INSTANCE);
        getLayout().d.setOnClickListener(new a1(this));
        initLanguage();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$1(FastRecordSettingActivity fastRecordSettingActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordSettingActivity, "this$0");
        fastRecordSettingActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$2(FastRecordSettingActivity fastRecordSettingActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordSettingActivity, "this$0");
        if (MMKV.n().d(IS_START_LOCATION, false)) {
            MMKV.n().w(IS_START_LOCATION, false);
            fastRecordSettingActivity.getLayout().f.setChecked(false);
            return;
        }
        fastRecordSettingActivity.sureOpenLocation();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$3(FastRecordSettingActivity fastRecordSettingActivity, View view) {
        Intrinsics.checkNotNullParameter(fastRecordSettingActivity, "this$0");
        fastRecordSettingActivity.showLanguageDialog();
    }

    private final void showLanguageDialog() {
        FastRecordLangDialog fastRecordLangDialog;
        if (this.mFastRecordLangDialog == null) {
            this.mFastRecordLangDialog = new FastRecordLangDialog(this, new FastRecordSettingActivity$showLanguageDialog$1(this));
        }
        FastRecordLanguageBean fastRecordLanguageBean = this.mFastRecordLanguage;
        if (!(fastRecordLanguageBean == null || (fastRecordLangDialog = this.mFastRecordLangDialog) == null)) {
            fastRecordLangDialog.refreshCurrent(fastRecordLanguageBean.getLangType());
        }
        FastRecordLangDialog fastRecordLangDialog2 = this.mFastRecordLangDialog;
        if (fastRecordLangDialog2 != null) {
            fastRecordLangDialog2.visibleNavigationBar(RecordExtKt.hasNavigationBar(this));
        }
        if (!isFinishing()) {
            FastRecordLangDialog fastRecordLangDialog3 = this.mFastRecordLangDialog;
            if (fastRecordLangDialog3 != null) {
                fastRecordLangDialog3.setCancelable(false);
            }
            FastRecordLangDialog fastRecordLangDialog4 = this.mFastRecordLangDialog;
            if (fastRecordLangDialog4 != null) {
                fastRecordLangDialog4.show();
            }
        }
    }

    private final void sureOpenLocation() {
        new AlertDialog.Builder(this).setTitle(R.string.fast_record_sure_open_location).setPositiveButton(R.string.fast_record_agree, (DialogInterface.OnClickListener) new w0(this)).setNegativeButton(R.string.fast_record_not_agree, (DialogInterface.OnClickListener) new x0(this)).show();
    }

    /* access modifiers changed from: private */
    public static final void sureOpenLocation$lambda$8(FastRecordSettingActivity fastRecordSettingActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(fastRecordSettingActivity, "this$0");
        fastRecordSettingActivity.checkLocationPermission();
    }

    /* access modifiers changed from: private */
    public static final void sureOpenLocation$lambda$9(FastRecordSettingActivity fastRecordSettingActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(fastRecordSettingActivity, "this$0");
        fastRecordSettingActivity.getLayout().f.setChecked(false);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        LogExt.logE("onCreate --->", TAG);
        setContentView((View) getLayout().getRoot());
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
        FastRecordLanguageBean fastRecordLanguageBean = this.mFastRecordLanguage;
        String langType = fastRecordLanguageBean != null ? fastRecordLanguageBean.getLangType() : null;
        LogExt.logE("onDestroy mFastRecordLanguage?.langType = " + langType, TAG);
        FastRecordLanguageBean fastRecordLanguageBean2 = this.mFastRecordLanguage;
        if (fastRecordLanguageBean2 != null) {
            if (!TextUtils.isEmpty(fastRecordLanguageBean2 != null ? fastRecordLanguageBean2.getLangType() : null)) {
                LogExt.logE("onDestroy lang type is change", TAG);
                Job unused = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(Dispatchers.b()), (CoroutineContext) null, (CoroutineStart) null, new FastRecordSettingActivity$onDestroy$1((Continuation<? super FastRecordSettingActivity$onDestroy$1>) null), 3, (Object) null);
            }
        }
    }

    public void onResume() {
        super.onResume();
        boolean a2 = SdkContext.f6675a.f().a((String[]) this.permissionList.toArray(new String[0]));
        LogExt.logE("onResume permissionState = " + a2, TAG);
        if (!a2) {
            MMKV.n().w(IS_START_LOCATION, false);
            getLayout().f.setChecked(false);
        }
    }
}
