package com.upuphone.ar.fastrecord.phone.ui.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.ViewModelProvider;
import com.honey.account.u3.b1;
import com.honey.account.u3.c1;
import com.honey.account.u3.d1;
import com.honey.account.u3.e1;
import com.honey.account.u3.f1;
import com.honey.account.u3.g1;
import com.honey.account.u3.h1;
import com.honey.account.u3.i1;
import com.honey.account.u3.j1;
import com.honey.account.u3.k1;
import com.honey.account.u3.l1;
import com.honey.account.u3.m1;
import com.honey.account.u3.n1;
import com.honey.account.u3.o1;
import com.honey.account.u3.p1;
import com.honey.account.u3.q1;
import com.honey.account.u3.r1;
import com.honey.account.u3.s1;
import com.honey.account.u3.t1;
import com.honey.account.u3.u1;
import com.honey.account.u3.v1;
import com.honey.account.u3.w1;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.databinding.FastRecordTagContentLayoutBinding;
import com.upuphone.ar.fastrecord.databinding.FastRecordTagDialogBinding;
import com.upuphone.ar.fastrecord.databinding.FastRecordTagPersonLayoutBinding;
import com.upuphone.ar.fastrecord.phone.db.RecordContentHistoryTagEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordContentTagEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordHistoryPersonEntity;
import com.upuphone.ar.fastrecord.phone.db.RecordPersonEntity;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.FastRecordTagViewModel;
import com.upuphone.ar.fastrecord.phone.ui.widget.labels.RecordDetailInputTagView;
import com.upuphone.ar.fastrecord.phone.utils.RecordConstants;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersions;
import com.upuphone.xr.sapp.utils.FlymeUtils;
import flyme.support.v7.app.AlertDialog;
import flyme.support.v7.app.LitePopupActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000 >2\u00020\u0001:\u0001>B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\b\u0010 \u001a\u00020\u001bH\u0002J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\b\u0010#\u001a\u00020\u001bH\u0002J\b\u0010$\u001a\u00020\u001bH\u0002J\b\u0010%\u001a\u00020\u001bH\u0002J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020'H\u0002J\u0018\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020,H\u0014J\u0012\u0010-\u001a\u00020\u001b2\b\u0010.\u001a\u0004\u0018\u00010/H\u0014J\b\u00100\u001a\u00020\u001bH\u0014J\b\u00101\u001a\u00020\u001bH\u0002J\b\u00102\u001a\u00020\u001bH\u0002J\b\u00103\u001a\u00020\u001bH\u0002J\u0010\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u00020'H\u0002J\u0010\u00106\u001a\u00020\u001b2\u0006\u00107\u001a\u00020'H\u0002J\u0012\u00108\u001a\u00020\u001b2\b\u00109\u001a\u0004\u0018\u00010\"H\u0002J\b\u0010:\u001a\u00020\u001bH\u0002J\b\u0010;\u001a\u00020\u001bH\u0002J\u0010\u0010<\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020'H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordTagScheduleDialog;", "Lflyme/support/v7/app/LitePopupActivity;", "()V", "binding", "Lcom/upuphone/ar/fastrecord/databinding/FastRecordTagDialogBinding;", "contentTagBinding", "Lcom/upuphone/ar/fastrecord/databinding/FastRecordTagContentLayoutBinding;", "curModel", "", "curPersonType", "inputContentTagValue", "inputPersonTagValue", "mHandler", "Landroid/os/Handler;", "mOnGlobalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "mPreviousKeyboardHeight", "", "personTagBinding", "Lcom/upuphone/ar/fastrecord/databinding/FastRecordTagPersonLayoutBinding;", "recordId", "", "Ljava/lang/Long;", "recordTagType", "viewModel", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/FastRecordTagViewModel;", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "changeOkBtnState", "checkInputSoftMenu", "closeInputMethod", "getContentView", "Landroid/view/View;", "initShowTagType", "initView", "initViewModel", "isContentType", "", "isPersonTagType", "onApplyWindowInsets", "root", "windowInsets", "Landroidx/core/view/WindowInsetsCompat;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "saveAllDataBeforeFinish", "setOkTvStateForContentTag", "setOkTvStateForPersonTag", "setTvOkColor", "isNotEnable", "setTvOkIsWork", "isWork", "setupContentView", "view", "showPersonOther", "showPersonSelf", "showSaveChangeDialog", "isNeedFinish", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFastRecordTagScheduleDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastRecordTagScheduleDialog.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordTagScheduleDialog\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,539:1\n262#2,2:540\n262#2,2:542\n262#2,2:544\n262#2,2:546\n262#2,2:548\n262#2,2:550\n262#2,2:552\n262#2,2:554\n262#2,2:556\n262#2,2:558\n262#2,2:560\n262#2,2:562\n262#2,2:564\n262#2,2:566\n262#2,2:568\n262#2,2:570\n1#3:572\n*S KotlinDebug\n*F\n+ 1 FastRecordTagScheduleDialog.kt\ncom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordTagScheduleDialog\n*L\n227#1:540,2\n228#1:542,2\n231#1:544,2\n235#1:546,2\n246#1:548,2\n247#1:550,2\n250#1:552,2\n254#1:554,2\n517#1:556,2\n518#1:558,2\n519#1:560,2\n525#1:562,2\n526#1:564,2\n527#1:566,2\n528#1:568,2\n529#1:570,2\n*E\n"})
public class FastRecordTagScheduleDialog extends LitePopupActivity {
    @NotNull
    public static final String CONTENT_TAG = "CONTENT_TAG";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long DELAY_SHOW_TIME = 2500;
    @NotNull
    private static final String INPUT_MODE = "normal_mode";
    @NotNull
    private static final String PERSON_TYPE_CHOOSE_MODE = "person_type_choose_mode";
    @NotNull
    public static final String PHONE_PERSON_TAG = "PHONE_PERSON_TAG";
    @NotNull
    public static final String RECORD_ID = "RECORD_ID";
    @NotNull
    public static final String SCENE_PERSON_TAG = "SCENE_PERSON_TAG";
    @NotNull
    private static final String TAG = "FastRecordTagScheduleDialog";
    @NotNull
    public static final String TAG_TYPE = "TAG_TYPE";
    private FastRecordTagDialogBinding binding;
    /* access modifiers changed from: private */
    public FastRecordTagContentLayoutBinding contentTagBinding;
    /* access modifiers changed from: private */
    @NotNull
    public String curModel = INPUT_MODE;
    @NotNull
    private String curPersonType = "";
    @NotNull
    private String inputContentTagValue = "";
    @NotNull
    private String inputPersonTagValue = "";
    @NotNull
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    @Nullable
    private ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    private int mPreviousKeyboardHeight = -1;
    /* access modifiers changed from: private */
    public FastRecordTagPersonLayoutBinding personTagBinding;
    @Nullable
    private Long recordId;
    /* access modifiers changed from: private */
    @Nullable
    public String recordTagType;
    private FastRecordTagViewModel viewModel;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/activity/FastRecordTagScheduleDialog$Companion;", "", "()V", "CONTENT_TAG", "", "DELAY_SHOW_TIME", "", "INPUT_MODE", "PERSON_TYPE_CHOOSE_MODE", "PHONE_PERSON_TAG", "RECORD_ID", "SCENE_PERSON_TAG", "TAG", "TAG_TYPE", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void changeOkBtnState() {
        boolean z = false;
        FastRecordTagViewModel fastRecordTagViewModel = null;
        if (isContentType()) {
            FastRecordTagViewModel fastRecordTagViewModel2 = this.viewModel;
            if (fastRecordTagViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                fastRecordTagViewModel2 = null;
            }
            boolean hasContentIsChange = fastRecordTagViewModel2.hasContentIsChange();
            String str = this.inputContentTagValue;
            LogExt.logE("changeOkBtnState is ContentType,hasContentIsChange = " + hasContentIsChange + ",inputContentTagValue = " + str + ",state = " + (str.length() > 0), TAG);
            FastRecordTagViewModel fastRecordTagViewModel3 = this.viewModel;
            if (fastRecordTagViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                fastRecordTagViewModel = fastRecordTagViewModel3;
            }
            if (fastRecordTagViewModel.hasContentIsChange() || this.inputContentTagValue.length() > 0) {
                z = true;
            }
            setTvOkIsWork(z);
        } else if (isPersonTagType()) {
            FastRecordTagViewModel fastRecordTagViewModel4 = this.viewModel;
            if (fastRecordTagViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                fastRecordTagViewModel4 = null;
            }
            boolean hasPersonIsChange = fastRecordTagViewModel4.hasPersonIsChange();
            String str2 = this.inputPersonTagValue;
            LogExt.logE("changeOkBtnState is personType hasPersonIsChange =" + hasPersonIsChange + ",inputPersonTagValue = " + str2 + ",state = " + (str2.length() > 0), TAG);
            FastRecordTagViewModel fastRecordTagViewModel5 = this.viewModel;
            if (fastRecordTagViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                fastRecordTagViewModel = fastRecordTagViewModel5;
            }
            if (fastRecordTagViewModel.hasPersonIsChange() || this.inputPersonTagValue.length() > 0) {
                z = true;
            }
            setTvOkIsWork(z);
        }
    }

    private final void checkInputSoftMenu() {
        View decorView = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        this.mOnGlobalLayoutListener = new l1(decorView, this);
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
    }

    /* access modifiers changed from: private */
    public static final void checkInputSoftMenu$lambda$9(View view, FastRecordTagScheduleDialog fastRecordTagScheduleDialog) {
        Intrinsics.checkNotNullParameter(view, "$rootView");
        Intrinsics.checkNotNullParameter(fastRecordTagScheduleDialog, "this$0");
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int height = view.getRootView().getHeight();
        int i = height - rect.bottom;
        if (fastRecordTagScheduleDialog.mPreviousKeyboardHeight != i) {
            LogExt.logE("screenHeight = " + height + ",keypadHeight = " + i, TAG);
            FastRecordTagDialogBinding fastRecordTagDialogBinding = null;
            if (((double) i) > ((double) height) * 0.15d) {
                LogExt.logV("input is show", TAG);
                FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding = fastRecordTagScheduleDialog.personTagBinding;
                if (fastRecordTagPersonLayoutBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
                    fastRecordTagPersonLayoutBinding = null;
                }
                RecordDetailInputTagView recordDetailInputTagView = fastRecordTagPersonLayoutBinding.m;
                Boolean bool = Boolean.TRUE;
                recordDetailInputTagView.setShowSoftInput(bool);
                FastRecordTagContentLayoutBinding fastRecordTagContentLayoutBinding = fastRecordTagScheduleDialog.contentTagBinding;
                if (fastRecordTagContentLayoutBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentTagBinding");
                    fastRecordTagContentLayoutBinding = null;
                }
                fastRecordTagContentLayoutBinding.e.setShowSoftInput(bool);
            } else {
                LogExt.logV("input is hide", TAG);
                FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding2 = fastRecordTagScheduleDialog.personTagBinding;
                if (fastRecordTagPersonLayoutBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
                    fastRecordTagPersonLayoutBinding2 = null;
                }
                RecordDetailInputTagView recordDetailInputTagView2 = fastRecordTagPersonLayoutBinding2.m;
                Boolean bool2 = Boolean.FALSE;
                recordDetailInputTagView2.setShowSoftInput(bool2);
                FastRecordTagContentLayoutBinding fastRecordTagContentLayoutBinding2 = fastRecordTagScheduleDialog.contentTagBinding;
                if (fastRecordTagContentLayoutBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentTagBinding");
                    fastRecordTagContentLayoutBinding2 = null;
                }
                fastRecordTagContentLayoutBinding2.e.setShowSoftInput(bool2);
            }
            FastRecordTagDialogBinding fastRecordTagDialogBinding2 = fastRecordTagScheduleDialog.binding;
            if (fastRecordTagDialogBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fastRecordTagDialogBinding2 = null;
            }
            ViewGroup.LayoutParams layoutParams = fastRecordTagDialogBinding2.d.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.bottomMargin = i;
            FastRecordTagDialogBinding fastRecordTagDialogBinding3 = fastRecordTagScheduleDialog.binding;
            if (fastRecordTagDialogBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fastRecordTagDialogBinding = fastRecordTagDialogBinding3;
            }
            fastRecordTagDialogBinding.d.setLayoutParams(layoutParams2);
            fastRecordTagScheduleDialog.mPreviousKeyboardHeight = i;
        }
    }

    private final void closeInputMethod() {
        Object systemService = getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        FastRecordTagDialogBinding fastRecordTagDialogBinding = this.binding;
        if (fastRecordTagDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTagDialogBinding = null;
        }
        inputMethodManager.hideSoftInputFromWindow(fastRecordTagDialogBinding.getRoot().getWindowToken(), 0);
    }

    private final View getContentView() {
        ViewGroup viewGroup = (ViewGroup) findViewById(16908290);
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return null;
        }
        return viewGroup.getChildAt(0);
    }

    /* access modifiers changed from: private */
    public final void initShowTagType() {
        LogExt.logE("initShowTagType recordTagType = " + this.recordTagType, TAG);
        FastRecordTagDialogBinding fastRecordTagDialogBinding = null;
        if (isContentType()) {
            this.inputContentTagValue = "";
            FastRecordTagViewModel fastRecordTagViewModel = this.viewModel;
            if (fastRecordTagViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                fastRecordTagViewModel = null;
            }
            fastRecordTagViewModel.clearNeedDeleteData();
            FastRecordTagContentLayoutBinding fastRecordTagContentLayoutBinding = this.contentTagBinding;
            if (fastRecordTagContentLayoutBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentTagBinding");
                fastRecordTagContentLayoutBinding = null;
            }
            fastRecordTagContentLayoutBinding.e.clearAllData();
            FastRecordTagDialogBinding fastRecordTagDialogBinding2 = this.binding;
            if (fastRecordTagDialogBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fastRecordTagDialogBinding2 = null;
            }
            fastRecordTagDialogBinding2.g.setText(getString(R.string.fast_record_add_tag_title));
            FastRecordTagDialogBinding fastRecordTagDialogBinding3 = this.binding;
            if (fastRecordTagDialogBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fastRecordTagDialogBinding3 = null;
            }
            ConstraintLayout b = fastRecordTagDialogBinding3.c.getRoot();
            Intrinsics.checkNotNullExpressionValue(b, "getRoot(...)");
            b.setVisibility(0);
            FastRecordTagDialogBinding fastRecordTagDialogBinding4 = this.binding;
            if (fastRecordTagDialogBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fastRecordTagDialogBinding4 = null;
            }
            ConstraintLayout b2 = fastRecordTagDialogBinding4.b.getRoot();
            Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
            b2.setVisibility(8);
            FastRecordTagDialogBinding fastRecordTagDialogBinding5 = this.binding;
            if (fastRecordTagDialogBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fastRecordTagDialogBinding5 = null;
            }
            TextView textView = fastRecordTagDialogBinding5.f;
            Intrinsics.checkNotNullExpressionValue(textView, "tvOk");
            textView.setVisibility(0);
        } else {
            this.inputPersonTagValue = "";
            FastRecordTagViewModel fastRecordTagViewModel2 = this.viewModel;
            if (fastRecordTagViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                fastRecordTagViewModel2 = null;
            }
            fastRecordTagViewModel2.clearNeedDeleteData();
            FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding = this.personTagBinding;
            if (fastRecordTagPersonLayoutBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
                fastRecordTagPersonLayoutBinding = null;
            }
            fastRecordTagPersonLayoutBinding.m.clearAllData();
            FastRecordTagDialogBinding fastRecordTagDialogBinding6 = this.binding;
            if (fastRecordTagDialogBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fastRecordTagDialogBinding6 = null;
            }
            fastRecordTagDialogBinding6.g.setText(getString(R.string.fast_record_add_person_title));
            FastRecordTagDialogBinding fastRecordTagDialogBinding7 = this.binding;
            if (fastRecordTagDialogBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fastRecordTagDialogBinding7 = null;
            }
            TextView textView2 = fastRecordTagDialogBinding7.f;
            Intrinsics.checkNotNullExpressionValue(textView2, "tvOk");
            textView2.setVisibility(8);
            FastRecordTagDialogBinding fastRecordTagDialogBinding8 = this.binding;
            if (fastRecordTagDialogBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fastRecordTagDialogBinding8 = null;
            }
            ConstraintLayout b3 = fastRecordTagDialogBinding8.c.getRoot();
            Intrinsics.checkNotNullExpressionValue(b3, "getRoot(...)");
            b3.setVisibility(8);
            FastRecordTagDialogBinding fastRecordTagDialogBinding9 = this.binding;
            if (fastRecordTagDialogBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fastRecordTagDialogBinding9 = null;
            }
            ConstraintLayout b4 = fastRecordTagDialogBinding9.b.getRoot();
            Intrinsics.checkNotNullExpressionValue(b4, "getRoot(...)");
            b4.setVisibility(0);
            FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding2 = this.personTagBinding;
            if (fastRecordTagPersonLayoutBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
                fastRecordTagPersonLayoutBinding2 = null;
            }
            ConstraintLayout constraintLayout = fastRecordTagPersonLayoutBinding2.k;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "llPersonTagValueContentContainer");
            constraintLayout.setVisibility(8);
            FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding3 = this.personTagBinding;
            if (fastRecordTagPersonLayoutBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
                fastRecordTagPersonLayoutBinding3 = null;
            }
            ConstraintLayout constraintLayout2 = fastRecordTagPersonLayoutBinding3.j;
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "llPersonTagTipContentContainer");
            constraintLayout2.setVisibility(0);
            if (Intrinsics.areEqual((Object) SCENE_PERSON_TAG, (Object) this.recordTagType)) {
                showPersonSelf();
            } else {
                this.curModel = PERSON_TYPE_CHOOSE_MODE;
            }
        }
        FastRecordTagDialogBinding fastRecordTagDialogBinding10 = this.binding;
        if (fastRecordTagDialogBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fastRecordTagDialogBinding = fastRecordTagDialogBinding10;
        }
        fastRecordTagDialogBinding.e.setText(getString(R.string.fast_cancel));
    }

    private final void initView() {
        checkInputSoftMenu();
        initShowTagType();
        FastRecordTagDialogBinding fastRecordTagDialogBinding = this.binding;
        FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding = null;
        if (fastRecordTagDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTagDialogBinding = null;
        }
        fastRecordTagDialogBinding.e.setOnClickListener(new v1(this));
        FastRecordTagDialogBinding fastRecordTagDialogBinding2 = this.binding;
        if (fastRecordTagDialogBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTagDialogBinding2 = null;
        }
        fastRecordTagDialogBinding2.f.setOnClickListener(new w1(this));
        FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding2 = this.personTagBinding;
        if (fastRecordTagPersonLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
            fastRecordTagPersonLayoutBinding2 = null;
        }
        fastRecordTagPersonLayoutBinding2.i.setOnClickListener(new c1(this));
        FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding3 = this.personTagBinding;
        if (fastRecordTagPersonLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
            fastRecordTagPersonLayoutBinding3 = null;
        }
        fastRecordTagPersonLayoutBinding3.h.setOnClickListener(new d1(this));
        FastRecordTagContentLayoutBinding fastRecordTagContentLayoutBinding = this.contentTagBinding;
        if (fastRecordTagContentLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTagBinding");
            fastRecordTagContentLayoutBinding = null;
        }
        fastRecordTagContentLayoutBinding.d.post(new e1(this));
        FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding4 = this.personTagBinding;
        if (fastRecordTagPersonLayoutBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
            fastRecordTagPersonLayoutBinding4 = null;
        }
        fastRecordTagPersonLayoutBinding4.l.post(new f1(this));
        FastRecordTagContentLayoutBinding fastRecordTagContentLayoutBinding2 = this.contentTagBinding;
        if (fastRecordTagContentLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTagBinding");
            fastRecordTagContentLayoutBinding2 = null;
        }
        fastRecordTagContentLayoutBinding2.e.post(new g1(this));
        FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding5 = this.personTagBinding;
        if (fastRecordTagPersonLayoutBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
        } else {
            fastRecordTagPersonLayoutBinding = fastRecordTagPersonLayoutBinding5;
        }
        fastRecordTagPersonLayoutBinding.m.post(new h1(this));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$10(FastRecordTagScheduleDialog fastRecordTagScheduleDialog, View view) {
        Intrinsics.checkNotNullParameter(fastRecordTagScheduleDialog, "this$0");
        fastRecordTagScheduleDialog.closeInputMethod();
        FastRecordTagViewModel fastRecordTagViewModel = null;
        if (fastRecordTagScheduleDialog.isContentType()) {
            FastRecordTagViewModel fastRecordTagViewModel2 = fastRecordTagScheduleDialog.viewModel;
            if (fastRecordTagViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                fastRecordTagViewModel = fastRecordTagViewModel2;
            }
            if (fastRecordTagViewModel.hasContentIsChange() || fastRecordTagScheduleDialog.inputContentTagValue.length() > 0) {
                fastRecordTagScheduleDialog.showSaveChangeDialog(true);
            } else {
                fastRecordTagScheduleDialog.finish();
            }
        } else if (!Intrinsics.areEqual((Object) fastRecordTagScheduleDialog.curModel, (Object) INPUT_MODE)) {
            fastRecordTagScheduleDialog.finish();
        } else if (Intrinsics.areEqual((Object) SCENE_PERSON_TAG, (Object) fastRecordTagScheduleDialog.recordTagType)) {
            FastRecordTagViewModel fastRecordTagViewModel3 = fastRecordTagScheduleDialog.viewModel;
            if (fastRecordTagViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                fastRecordTagViewModel = fastRecordTagViewModel3;
            }
            if (fastRecordTagViewModel.hasPersonIsChange() || fastRecordTagScheduleDialog.inputPersonTagValue.length() > 0) {
                fastRecordTagScheduleDialog.showSaveChangeDialog(true);
            } else {
                fastRecordTagScheduleDialog.finish();
            }
        } else {
            FastRecordTagViewModel fastRecordTagViewModel4 = fastRecordTagScheduleDialog.viewModel;
            if (fastRecordTagViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                fastRecordTagViewModel = fastRecordTagViewModel4;
            }
            if (fastRecordTagViewModel.hasPersonIsChange() || fastRecordTagScheduleDialog.inputPersonTagValue.length() > 0) {
                fastRecordTagScheduleDialog.showSaveChangeDialog(false);
            } else {
                fastRecordTagScheduleDialog.initShowTagType();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$11(FastRecordTagScheduleDialog fastRecordTagScheduleDialog, View view) {
        Intrinsics.checkNotNullParameter(fastRecordTagScheduleDialog, "this$0");
        FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding = fastRecordTagScheduleDialog.personTagBinding;
        FastRecordTagContentLayoutBinding fastRecordTagContentLayoutBinding = null;
        if (fastRecordTagPersonLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
            fastRecordTagPersonLayoutBinding = null;
        }
        fastRecordTagPersonLayoutBinding.m.clearAllData();
        FastRecordTagContentLayoutBinding fastRecordTagContentLayoutBinding2 = fastRecordTagScheduleDialog.contentTagBinding;
        if (fastRecordTagContentLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTagBinding");
        } else {
            fastRecordTagContentLayoutBinding = fastRecordTagContentLayoutBinding2;
        }
        fastRecordTagContentLayoutBinding.e.clearAllData();
        fastRecordTagScheduleDialog.closeInputMethod();
        fastRecordTagScheduleDialog.saveAllDataBeforeFinish();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$12(FastRecordTagScheduleDialog fastRecordTagScheduleDialog, View view) {
        Intrinsics.checkNotNullParameter(fastRecordTagScheduleDialog, "this$0");
        fastRecordTagScheduleDialog.showPersonSelf();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$13(FastRecordTagScheduleDialog fastRecordTagScheduleDialog, View view) {
        Intrinsics.checkNotNullParameter(fastRecordTagScheduleDialog, "this$0");
        fastRecordTagScheduleDialog.showPersonOther();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$17(FastRecordTagScheduleDialog fastRecordTagScheduleDialog) {
        Intrinsics.checkNotNullParameter(fastRecordTagScheduleDialog, "this$0");
        FastRecordTagContentLayoutBinding fastRecordTagContentLayoutBinding = fastRecordTagScheduleDialog.contentTagBinding;
        FastRecordTagContentLayoutBinding fastRecordTagContentLayoutBinding2 = null;
        if (fastRecordTagContentLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTagBinding");
            fastRecordTagContentLayoutBinding = null;
        }
        fastRecordTagContentLayoutBinding.d.setOnDelIvClickListener(new q1(fastRecordTagScheduleDialog));
        FastRecordTagContentLayoutBinding fastRecordTagContentLayoutBinding3 = fastRecordTagScheduleDialog.contentTagBinding;
        if (fastRecordTagContentLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTagBinding");
        } else {
            fastRecordTagContentLayoutBinding2 = fastRecordTagContentLayoutBinding3;
        }
        fastRecordTagContentLayoutBinding2.d.setOnLabelClickListener(new r1(fastRecordTagScheduleDialog));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$17$lambda$14(FastRecordTagScheduleDialog fastRecordTagScheduleDialog, Object obj, int i) {
        Intrinsics.checkNotNullParameter(fastRecordTagScheduleDialog, "this$0");
        LogExt.logE("del recordContentHistoryTag  data, data = " + obj + ",position = " + i, TAG);
        FastRecordTagViewModel fastRecordTagViewModel = fastRecordTagScheduleDialog.viewModel;
        if (fastRecordTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTagViewModel = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.upuphone.ar.fastrecord.phone.db.RecordContentHistoryTagEntity");
        fastRecordTagViewModel.delHistoryContentTag((RecordContentHistoryTagEntity) obj);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$17$lambda$16(FastRecordTagScheduleDialog fastRecordTagScheduleDialog, View view, Object obj, int i) {
        Intrinsics.checkNotNullParameter(fastRecordTagScheduleDialog, "this$0");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.upuphone.ar.fastrecord.phone.db.RecordContentHistoryTagEntity");
        RecordContentHistoryTagEntity recordContentHistoryTagEntity = (RecordContentHistoryTagEntity) obj;
        FastRecordTagViewModel fastRecordTagViewModel = fastRecordTagScheduleDialog.viewModel;
        FastRecordTagViewModel fastRecordTagViewModel2 = null;
        if (fastRecordTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTagViewModel = null;
        }
        LogExt.logE("valueData = " + recordContentHistoryTagEntity + ",size = " + fastRecordTagViewModel.getRealContentTagSize(), TAG);
        FastRecordTagViewModel fastRecordTagViewModel3 = fastRecordTagScheduleDialog.viewModel;
        if (fastRecordTagViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTagViewModel3 = null;
        }
        if (fastRecordTagViewModel3.getRealContentTagSize() >= 10) {
            UToast.Companion companion = UToast.f6444a;
            String string = fastRecordTagScheduleDialog.getString(R.string.fast_record_max_tag_ten);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(fastRecordTagScheduleDialog, string);
            return;
        }
        String contentName = recordContentHistoryTagEntity.getContentName();
        if (contentName != null) {
            FastRecordTagViewModel fastRecordTagViewModel4 = fastRecordTagScheduleDialog.viewModel;
            if (fastRecordTagViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                fastRecordTagViewModel2 = fastRecordTagViewModel4;
            }
            fastRecordTagViewModel2.addContentTag(contentName, recordContentHistoryTagEntity.getCreateTime());
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$21(FastRecordTagScheduleDialog fastRecordTagScheduleDialog) {
        Intrinsics.checkNotNullParameter(fastRecordTagScheduleDialog, "this$0");
        FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding = fastRecordTagScheduleDialog.personTagBinding;
        FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding2 = null;
        if (fastRecordTagPersonLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
            fastRecordTagPersonLayoutBinding = null;
        }
        fastRecordTagPersonLayoutBinding.l.setOnDelIvClickListener(new b1(fastRecordTagScheduleDialog));
        FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding3 = fastRecordTagScheduleDialog.personTagBinding;
        if (fastRecordTagPersonLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
        } else {
            fastRecordTagPersonLayoutBinding2 = fastRecordTagPersonLayoutBinding3;
        }
        fastRecordTagPersonLayoutBinding2.l.setOnLabelClickListener(new m1(fastRecordTagScheduleDialog));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$21$lambda$18(FastRecordTagScheduleDialog fastRecordTagScheduleDialog, Object obj, int i) {
        Intrinsics.checkNotNullParameter(fastRecordTagScheduleDialog, "this$0");
        LogExt.logE("del recordContentHistoryTag data, data = " + obj + ",position = " + i, TAG);
        FastRecordTagViewModel fastRecordTagViewModel = fastRecordTagScheduleDialog.viewModel;
        if (fastRecordTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTagViewModel = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.upuphone.ar.fastrecord.phone.db.RecordHistoryPersonEntity");
        fastRecordTagViewModel.delPersonHistoryTag((RecordHistoryPersonEntity) obj);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$21$lambda$20(FastRecordTagScheduleDialog fastRecordTagScheduleDialog, View view, Object obj, int i) {
        Intrinsics.checkNotNullParameter(fastRecordTagScheduleDialog, "this$0");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.upuphone.ar.fastrecord.phone.db.RecordHistoryPersonEntity");
        RecordHistoryPersonEntity recordHistoryPersonEntity = (RecordHistoryPersonEntity) obj;
        FastRecordTagViewModel fastRecordTagViewModel = fastRecordTagScheduleDialog.viewModel;
        FastRecordTagViewModel fastRecordTagViewModel2 = null;
        if (fastRecordTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTagViewModel = null;
        }
        LogExt.logE("valueData = " + recordHistoryPersonEntity + ",size = " + fastRecordTagViewModel.getRealPersonTagSize(), TAG);
        FastRecordTagViewModel fastRecordTagViewModel3 = fastRecordTagScheduleDialog.viewModel;
        if (fastRecordTagViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTagViewModel3 = null;
        }
        if (fastRecordTagViewModel3.getRealPersonTagSize() >= 10) {
            UToast.Companion companion = UToast.f6444a;
            String string = fastRecordTagScheduleDialog.getString(R.string.fast_record_max_person_ten);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(fastRecordTagScheduleDialog, string);
            return;
        }
        String personName = recordHistoryPersonEntity.getPersonName();
        if (personName != null) {
            FastRecordTagViewModel fastRecordTagViewModel4 = fastRecordTagScheduleDialog.viewModel;
            if (fastRecordTagViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                fastRecordTagViewModel2 = fastRecordTagViewModel4;
            }
            fastRecordTagViewModel2.addPersonTag(personName, fastRecordTagScheduleDialog.curPersonType, recordHistoryPersonEntity.getCreateTime());
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$25(FastRecordTagScheduleDialog fastRecordTagScheduleDialog) {
        Intrinsics.checkNotNullParameter(fastRecordTagScheduleDialog, "this$0");
        FastRecordTagContentLayoutBinding fastRecordTagContentLayoutBinding = fastRecordTagScheduleDialog.contentTagBinding;
        FastRecordTagContentLayoutBinding fastRecordTagContentLayoutBinding2 = null;
        if (fastRecordTagContentLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTagBinding");
            fastRecordTagContentLayoutBinding = null;
        }
        fastRecordTagContentLayoutBinding.e.setOnDelIvClickListener(new s1(fastRecordTagScheduleDialog));
        FastRecordTagContentLayoutBinding fastRecordTagContentLayoutBinding3 = fastRecordTagScheduleDialog.contentTagBinding;
        if (fastRecordTagContentLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTagBinding");
            fastRecordTagContentLayoutBinding3 = null;
        }
        fastRecordTagContentLayoutBinding3.e.setOnLabelAddFinishListener(new t1(fastRecordTagScheduleDialog));
        FastRecordTagContentLayoutBinding fastRecordTagContentLayoutBinding4 = fastRecordTagScheduleDialog.contentTagBinding;
        if (fastRecordTagContentLayoutBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTagBinding");
        } else {
            fastRecordTagContentLayoutBinding2 = fastRecordTagContentLayoutBinding4;
        }
        fastRecordTagContentLayoutBinding2.e.setMonEditTextChange(new u1(fastRecordTagScheduleDialog));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$25$lambda$22(FastRecordTagScheduleDialog fastRecordTagScheduleDialog, Object obj, int i) {
        Intrinsics.checkNotNullParameter(fastRecordTagScheduleDialog, "this$0");
        LogExt.logE("del recordContentNormalTag  data, data = " + obj + ",position = " + i, TAG);
        FastRecordTagViewModel fastRecordTagViewModel = fastRecordTagScheduleDialog.viewModel;
        if (fastRecordTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTagViewModel = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.upuphone.ar.fastrecord.phone.db.RecordContentTagEntity");
        fastRecordTagViewModel.removeContentTag((RecordContentTagEntity) obj);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$25$lambda$23(FastRecordTagScheduleDialog fastRecordTagScheduleDialog, String str) {
        Intrinsics.checkNotNullParameter(fastRecordTagScheduleDialog, "this$0");
        FastRecordTagViewModel fastRecordTagViewModel = fastRecordTagScheduleDialog.viewModel;
        FastRecordTagViewModel fastRecordTagViewModel2 = null;
        if (fastRecordTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTagViewModel = null;
        }
        LogExt.logE("recordContentNormalTag add value " + str + ",size = " + fastRecordTagViewModel.getRealContentTagSize(), TAG);
        fastRecordTagScheduleDialog.inputContentTagValue = "";
        FastRecordTagViewModel fastRecordTagViewModel3 = fastRecordTagScheduleDialog.viewModel;
        if (fastRecordTagViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTagViewModel3 = null;
        }
        if (fastRecordTagViewModel3.getRealContentTagSize() >= 10) {
            UToast.Companion companion = UToast.f6444a;
            String string = fastRecordTagScheduleDialog.getString(R.string.fast_record_max_tag_ten);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(fastRecordTagScheduleDialog, string);
        } else if (str != null && str.length() != 0) {
            FastRecordTagViewModel fastRecordTagViewModel4 = fastRecordTagScheduleDialog.viewModel;
            if (fastRecordTagViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                fastRecordTagViewModel2 = fastRecordTagViewModel4;
            }
            Intrinsics.checkNotNull(str);
            fastRecordTagViewModel2.addContentTag(str, System.currentTimeMillis());
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$25$lambda$24(FastRecordTagScheduleDialog fastRecordTagScheduleDialog, String str, Object obj) {
        Intrinsics.checkNotNullParameter(fastRecordTagScheduleDialog, "this$0");
        Intrinsics.checkNotNull(str);
        fastRecordTagScheduleDialog.inputContentTagValue = str;
        LogExt.logE("inputContentTagValue = " + str, TAG);
        fastRecordTagScheduleDialog.changeOkBtnState();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$29(FastRecordTagScheduleDialog fastRecordTagScheduleDialog) {
        Intrinsics.checkNotNullParameter(fastRecordTagScheduleDialog, "this$0");
        FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding = fastRecordTagScheduleDialog.personTagBinding;
        FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding2 = null;
        if (fastRecordTagPersonLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
            fastRecordTagPersonLayoutBinding = null;
        }
        fastRecordTagPersonLayoutBinding.m.setOnDelIvClickListener(new i1(fastRecordTagScheduleDialog));
        FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding3 = fastRecordTagScheduleDialog.personTagBinding;
        if (fastRecordTagPersonLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
            fastRecordTagPersonLayoutBinding3 = null;
        }
        fastRecordTagPersonLayoutBinding3.m.setOnLabelAddFinishListener(new j1(fastRecordTagScheduleDialog));
        FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding4 = fastRecordTagScheduleDialog.personTagBinding;
        if (fastRecordTagPersonLayoutBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
        } else {
            fastRecordTagPersonLayoutBinding2 = fastRecordTagPersonLayoutBinding4;
        }
        fastRecordTagPersonLayoutBinding2.m.setMonEditTextChange(new k1(fastRecordTagScheduleDialog));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$29$lambda$26(FastRecordTagScheduleDialog fastRecordTagScheduleDialog, Object obj, int i) {
        Intrinsics.checkNotNullParameter(fastRecordTagScheduleDialog, "this$0");
        LogExt.logE("del recordPersonInputTag data, data = " + obj + ",position = " + i, TAG);
        FastRecordTagViewModel fastRecordTagViewModel = fastRecordTagScheduleDialog.viewModel;
        if (fastRecordTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTagViewModel = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.upuphone.ar.fastrecord.phone.db.RecordPersonEntity");
        fastRecordTagViewModel.removePersonTag((RecordPersonEntity) obj);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$29$lambda$27(FastRecordTagScheduleDialog fastRecordTagScheduleDialog, String str) {
        Intrinsics.checkNotNullParameter(fastRecordTagScheduleDialog, "this$0");
        FastRecordTagViewModel fastRecordTagViewModel = fastRecordTagScheduleDialog.viewModel;
        FastRecordTagViewModel fastRecordTagViewModel2 = null;
        if (fastRecordTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTagViewModel = null;
        }
        LogExt.logE("recordPersonInputTag add value " + str + ",size = " + fastRecordTagViewModel.getRealPersonTagSize(), TAG);
        fastRecordTagScheduleDialog.inputPersonTagValue = "";
        FastRecordTagViewModel fastRecordTagViewModel3 = fastRecordTagScheduleDialog.viewModel;
        if (fastRecordTagViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTagViewModel3 = null;
        }
        if (fastRecordTagViewModel3.getRealPersonTagSize() >= 10) {
            UToast.Companion companion = UToast.f6444a;
            String string = fastRecordTagScheduleDialog.getString(R.string.fast_record_max_person_ten);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.d(fastRecordTagScheduleDialog, string);
        } else if (str != null && str.length() != 0) {
            FastRecordTagViewModel fastRecordTagViewModel4 = fastRecordTagScheduleDialog.viewModel;
            if (fastRecordTagViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                fastRecordTagViewModel2 = fastRecordTagViewModel4;
            }
            Intrinsics.checkNotNull(str);
            fastRecordTagViewModel2.addPersonTag(str, fastRecordTagScheduleDialog.curPersonType, System.currentTimeMillis());
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$29$lambda$28(FastRecordTagScheduleDialog fastRecordTagScheduleDialog, String str, Object obj) {
        Intrinsics.checkNotNullParameter(fastRecordTagScheduleDialog, "this$0");
        Intrinsics.checkNotNull(str);
        fastRecordTagScheduleDialog.inputPersonTagValue = str;
        LogExt.logE("inputPersonTagValue = " + str, TAG);
        fastRecordTagScheduleDialog.changeOkBtnState();
    }

    private final void initViewModel() {
        FastRecordTagViewModel fastRecordTagViewModel = this.viewModel;
        FastRecordTagViewModel fastRecordTagViewModel2 = null;
        if (fastRecordTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTagViewModel = null;
        }
        fastRecordTagViewModel.getCurRecordData().observe(this, new FastRecordTagScheduleDialog$sam$androidx_lifecycle_Observer$0(FastRecordTagScheduleDialog$initViewModel$1.INSTANCE));
        Long l = this.recordId;
        if (l != null) {
            long longValue = l.longValue();
            FastRecordTagViewModel fastRecordTagViewModel3 = this.viewModel;
            if (fastRecordTagViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                fastRecordTagViewModel3 = null;
            }
            fastRecordTagViewModel3.queryRecordInfo(longValue);
            if (isContentType()) {
                FastRecordTagViewModel fastRecordTagViewModel4 = this.viewModel;
                if (fastRecordTagViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    fastRecordTagViewModel4 = null;
                }
                fastRecordTagViewModel4.queryRecordTagInfo(longValue, true);
            }
        }
        FastRecordTagViewModel fastRecordTagViewModel5 = this.viewModel;
        if (fastRecordTagViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTagViewModel5 = null;
        }
        fastRecordTagViewModel5.getCurRecordContentHistoryTagList().observe(this, new FastRecordTagScheduleDialog$sam$androidx_lifecycle_Observer$0(new FastRecordTagScheduleDialog$initViewModel$3(this)));
        FastRecordTagViewModel fastRecordTagViewModel6 = this.viewModel;
        if (fastRecordTagViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTagViewModel6 = null;
        }
        fastRecordTagViewModel6.getCurRecordContentNormalTagList().observe(this, new FastRecordTagScheduleDialog$sam$androidx_lifecycle_Observer$0(new FastRecordTagScheduleDialog$initViewModel$4(this)));
        FastRecordTagViewModel fastRecordTagViewModel7 = this.viewModel;
        if (fastRecordTagViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTagViewModel7 = null;
        }
        fastRecordTagViewModel7.getCurRecordPersonHistoryTagList().observe(this, new FastRecordTagScheduleDialog$sam$androidx_lifecycle_Observer$0(new FastRecordTagScheduleDialog$initViewModel$5(this)));
        FastRecordTagViewModel fastRecordTagViewModel8 = this.viewModel;
        if (fastRecordTagViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            fastRecordTagViewModel2 = fastRecordTagViewModel8;
        }
        fastRecordTagViewModel2.getCurRecordPersonNormalTagEntityList().observe(this, new FastRecordTagScheduleDialog$sam$androidx_lifecycle_Observer$0(new FastRecordTagScheduleDialog$initViewModel$6(this)));
    }

    private final boolean isContentType() {
        return Intrinsics.areEqual((Object) this.recordTagType, (Object) CONTENT_TAG);
    }

    /* access modifiers changed from: private */
    public final boolean isPersonTagType() {
        return Intrinsics.areEqual((Object) this.recordTagType, (Object) PHONE_PERSON_TAG) || Intrinsics.areEqual((Object) this.recordTagType, (Object) SCENE_PERSON_TAG);
    }

    private final void saveAllDataBeforeFinish() {
        FastRecordTagViewModel fastRecordTagViewModel = null;
        if (isContentType()) {
            FastRecordTagViewModel fastRecordTagViewModel2 = this.viewModel;
            if (fastRecordTagViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                fastRecordTagViewModel = fastRecordTagViewModel2;
            }
            fastRecordTagViewModel.saveAllContentTagData(this.inputContentTagValue, new FastRecordTagScheduleDialog$saveAllDataBeforeFinish$1(this));
            return;
        }
        FastRecordTagViewModel fastRecordTagViewModel3 = this.viewModel;
        if (fastRecordTagViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            fastRecordTagViewModel = fastRecordTagViewModel3;
        }
        fastRecordTagViewModel.saveAllPersonData(this.inputPersonTagValue, new FastRecordTagScheduleDialog$saveAllDataBeforeFinish$2(this), this.curPersonType);
    }

    /* access modifiers changed from: private */
    public final void setOkTvStateForContentTag() {
        LogExt.logE("setOkTvStateForContentTag,isContentType = " + isContentType(), TAG);
        if (isContentType()) {
            FastRecordTagViewModel fastRecordTagViewModel = this.viewModel;
            if (fastRecordTagViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                fastRecordTagViewModel = null;
            }
            boolean z = true;
            boolean z2 = fastRecordTagViewModel.hasContentIsChange() || this.inputContentTagValue.length() > 0;
            if (this.inputContentTagValue.length() <= 0) {
                z = false;
            }
            LogExt.logE("curRecordContentNormalTagList hasWork = " + z2 + ",input = " + z, TAG);
            setTvOkIsWork(z2);
        }
    }

    /* access modifiers changed from: private */
    public final void setOkTvStateForPersonTag() {
        LogExt.logE("setOkTvStateForPersonTag,isPersonTagType = " + isPersonTagType(), TAG);
        if (isPersonTagType()) {
            FastRecordTagViewModel fastRecordTagViewModel = this.viewModel;
            if (fastRecordTagViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                fastRecordTagViewModel = null;
            }
            boolean z = true;
            boolean z2 = fastRecordTagViewModel.hasPersonIsChange() || this.inputPersonTagValue.length() > 0;
            if (this.inputPersonTagValue.length() <= 0) {
                z = false;
            }
            LogExt.logE("curRecordPersonHistoryTagList hasWork = " + z2 + ",input = " + z, TAG);
            setTvOkIsWork(z2);
        }
    }

    private final void setTvOkColor(boolean z) {
        FastRecordTagDialogBinding fastRecordTagDialogBinding = null;
        if (z) {
            LogExt.logE("show is  isNotEnable", TAG);
            FastRecordTagDialogBinding fastRecordTagDialogBinding2 = this.binding;
            if (fastRecordTagDialogBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fastRecordTagDialogBinding2 = null;
            }
            fastRecordTagDialogBinding2.f.setAlpha(0.3f);
            FastRecordTagDialogBinding fastRecordTagDialogBinding3 = this.binding;
            if (fastRecordTagDialogBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fastRecordTagDialogBinding = fastRecordTagDialogBinding3;
            }
            fastRecordTagDialogBinding.f.setClickable(false);
            return;
        }
        LogExt.logE("show is  enable", TAG);
        FastRecordTagDialogBinding fastRecordTagDialogBinding4 = this.binding;
        if (fastRecordTagDialogBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTagDialogBinding4 = null;
        }
        fastRecordTagDialogBinding4.f.setAlpha(1.0f);
        FastRecordTagDialogBinding fastRecordTagDialogBinding5 = this.binding;
        if (fastRecordTagDialogBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fastRecordTagDialogBinding = fastRecordTagDialogBinding5;
        }
        fastRecordTagDialogBinding.f.setClickable(true);
    }

    private final void setTvOkIsWork(boolean z) {
        setTvOkColor(!z);
        FastRecordTagDialogBinding fastRecordTagDialogBinding = this.binding;
        FastRecordTagDialogBinding fastRecordTagDialogBinding2 = null;
        if (fastRecordTagDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTagDialogBinding = null;
        }
        fastRecordTagDialogBinding.f.setClickable(z);
        FastRecordTagDialogBinding fastRecordTagDialogBinding3 = this.binding;
        if (fastRecordTagDialogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fastRecordTagDialogBinding2 = fastRecordTagDialogBinding3;
        }
        fastRecordTagDialogBinding2.f.requestLayout();
    }

    private final void setupContentView(View view) {
        if (view != null) {
            FlymeUtils.a(view, this);
            boolean z = (getResources().getConfiguration().uiMode & 48) == 32;
            WindowInsetsControllerCompat a2 = WindowCompat.a(getWindow(), view);
            a2.c(!z);
            a2.d(!z);
            ViewCompat.M0(view, new p1(this));
        }
    }

    /* access modifiers changed from: private */
    public static final WindowInsetsCompat setupContentView$lambda$3$lambda$2(FastRecordTagScheduleDialog fastRecordTagScheduleDialog, View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(fastRecordTagScheduleDialog, "this$0");
        Intrinsics.checkNotNullParameter(view, ProtocolVersions.PROTOCOL_KEY_CONNECTION_VERSION);
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsets");
        fastRecordTagScheduleDialog.onApplyWindowInsets(view, windowInsetsCompat);
        return WindowInsetsCompat.b;
    }

    private final void showPersonOther() {
        FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding = this.personTagBinding;
        FastRecordTagViewModel fastRecordTagViewModel = null;
        if (fastRecordTagPersonLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
            fastRecordTagPersonLayoutBinding = null;
        }
        ConstraintLayout constraintLayout = fastRecordTagPersonLayoutBinding.j;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "llPersonTagTipContentContainer");
        int i = 8;
        constraintLayout.setVisibility(8);
        FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding2 = this.personTagBinding;
        if (fastRecordTagPersonLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
            fastRecordTagPersonLayoutBinding2 = null;
        }
        ConstraintLayout constraintLayout2 = fastRecordTagPersonLayoutBinding2.k;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "llPersonTagValueContentContainer");
        constraintLayout2.setVisibility(0);
        this.curModel = INPUT_MODE;
        this.curPersonType = RecordConstants.SCENE_PHONE_OTHER;
        FastRecordTagDialogBinding fastRecordTagDialogBinding = this.binding;
        if (fastRecordTagDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTagDialogBinding = null;
        }
        TextView textView = fastRecordTagDialogBinding.f;
        Intrinsics.checkNotNullExpressionValue(textView, "tvOk");
        textView.setVisibility(0);
        FastRecordTagDialogBinding fastRecordTagDialogBinding2 = this.binding;
        if (fastRecordTagDialogBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTagDialogBinding2 = null;
        }
        fastRecordTagDialogBinding2.e.setText(getString(R.string.fast_record_back));
        setTvOkIsWork(false);
        FastRecordTagViewModel fastRecordTagViewModel2 = this.viewModel;
        if (fastRecordTagViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTagViewModel2 = null;
        }
        List<RecordHistoryPersonEntity> personHistoryTagList = fastRecordTagViewModel2.getPersonHistoryTagList();
        int size = personHistoryTagList != null ? personHistoryTagList.size() : 0;
        FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding3 = this.personTagBinding;
        if (fastRecordTagPersonLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
            fastRecordTagPersonLayoutBinding3 = null;
        }
        TextView textView2 = fastRecordTagPersonLayoutBinding3.r;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvTipHistoryPerson");
        if (size > 0) {
            i = 0;
        }
        textView2.setVisibility(i);
        Long l = this.recordId;
        if (l != null) {
            long longValue = l.longValue();
            FastRecordTagViewModel fastRecordTagViewModel3 = this.viewModel;
            if (fastRecordTagViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                fastRecordTagViewModel = fastRecordTagViewModel3;
            }
            fastRecordTagViewModel.queryRecordPersonTagInfo(longValue, this.curPersonType, true);
        }
    }

    private final void showPersonSelf() {
        FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding = this.personTagBinding;
        FastRecordTagViewModel fastRecordTagViewModel = null;
        if (fastRecordTagPersonLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
            fastRecordTagPersonLayoutBinding = null;
        }
        ConstraintLayout constraintLayout = fastRecordTagPersonLayoutBinding.j;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "llPersonTagTipContentContainer");
        int i = 8;
        constraintLayout.setVisibility(8);
        FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding2 = this.personTagBinding;
        if (fastRecordTagPersonLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
            fastRecordTagPersonLayoutBinding2 = null;
        }
        ConstraintLayout constraintLayout2 = fastRecordTagPersonLayoutBinding2.k;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "llPersonTagValueContentContainer");
        constraintLayout2.setVisibility(0);
        this.curModel = INPUT_MODE;
        this.curPersonType = RecordConstants.SCENE_PHONE_MY_SELF;
        FastRecordTagDialogBinding fastRecordTagDialogBinding = this.binding;
        if (fastRecordTagDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTagDialogBinding = null;
        }
        TextView textView = fastRecordTagDialogBinding.f;
        Intrinsics.checkNotNullExpressionValue(textView, "tvOk");
        textView.setVisibility(0);
        FastRecordTagDialogBinding fastRecordTagDialogBinding2 = this.binding;
        if (fastRecordTagDialogBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTagDialogBinding2 = null;
        }
        fastRecordTagDialogBinding2.e.setText(getString(R.string.fast_record_back));
        setTvOkIsWork(false);
        FastRecordTagViewModel fastRecordTagViewModel2 = this.viewModel;
        if (fastRecordTagViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTagViewModel2 = null;
        }
        List<RecordHistoryPersonEntity> personHistoryTagList = fastRecordTagViewModel2.getPersonHistoryTagList();
        int size = personHistoryTagList != null ? personHistoryTagList.size() : 0;
        FastRecordTagPersonLayoutBinding fastRecordTagPersonLayoutBinding3 = this.personTagBinding;
        if (fastRecordTagPersonLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("personTagBinding");
            fastRecordTagPersonLayoutBinding3 = null;
        }
        TextView textView2 = fastRecordTagPersonLayoutBinding3.r;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvTipHistoryPerson");
        if (size > 0) {
            i = 0;
        }
        textView2.setVisibility(i);
        Long l = this.recordId;
        if (l != null) {
            long longValue = l.longValue();
            FastRecordTagViewModel fastRecordTagViewModel3 = this.viewModel;
            if (fastRecordTagViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                fastRecordTagViewModel = fastRecordTagViewModel3;
            }
            fastRecordTagViewModel.queryRecordPersonTagInfo(longValue, this.curPersonType, true);
        }
    }

    private final void showSaveChangeDialog(boolean z) {
        new AlertDialog.Builder(this).setTitle(R.string.fast_record_save_asr).setPositiveButton(R.string.fast_record_give_up, (DialogInterface.OnClickListener) new n1(this, z)).setNegativeButton(R.string.fast_cancel, (DialogInterface.OnClickListener) new o1()).show();
    }

    /* access modifiers changed from: private */
    public static final void showSaveChangeDialog$lambda$7(FastRecordTagScheduleDialog fastRecordTagScheduleDialog, boolean z, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(fastRecordTagScheduleDialog, "this$0");
        FastRecordTagViewModel fastRecordTagViewModel = fastRecordTagScheduleDialog.viewModel;
        if (fastRecordTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTagViewModel = null;
        }
        fastRecordTagViewModel.saveAllHistoryDataForGiveUpChange(fastRecordTagScheduleDialog.isContentType(), fastRecordTagScheduleDialog.isPersonTagType(), new FastRecordTagScheduleDialog$showSaveChangeDialog$1$1(fastRecordTagScheduleDialog, z));
    }

    /* access modifiers changed from: private */
    public static final void showSaveChangeDialog$lambda$8(DialogInterface dialogInterface, int i) {
    }

    public void attachBaseContext(@Nullable Context context) {
        Context context2;
        if (context != null) {
            Configuration configuration = context.getResources().getConfiguration();
            configuration.fontScale = 1.0f;
            context2 = context.createConfigurationContext(configuration);
        } else {
            context2 = null;
        }
        super.attachBaseContext(context2);
    }

    public void onApplyWindowInsets(@NotNull View view, @NotNull WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(view, "root");
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsets");
        Insets f = windowInsetsCompat.f(WindowInsetsCompat.Type.f());
        Intrinsics.checkNotNullExpressionValue(f, "getInsets(...)");
        view.setPadding(f.f712a, f.b, f.c, f.d);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.recordId = Long.valueOf(getIntent().getLongExtra("RECORD_ID", -1));
        FastRecordTagViewModel fastRecordTagViewModel = (FastRecordTagViewModel) new ViewModelProvider(this).get(FastRecordTagViewModel.class);
        this.viewModel = fastRecordTagViewModel;
        FastRecordTagDialogBinding fastRecordTagDialogBinding = null;
        if (fastRecordTagViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            fastRecordTagViewModel = null;
        }
        fastRecordTagViewModel.setRecordId(this.recordId);
        String stringExtra = getIntent().getStringExtra(TAG_TYPE);
        this.recordTagType = stringExtra;
        LogExt.logE("record = " + this.recordId + ",recordTagType = " + stringExtra, TAG);
        FastRecordTagDialogBinding c = FastRecordTagDialogBinding.c(LayoutInflater.from(this));
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.binding = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            c = null;
        }
        FastRecordTagContentLayoutBinding a2 = FastRecordTagContentLayoutBinding.a(c.c.getRoot());
        Intrinsics.checkNotNullExpressionValue(a2, "bind(...)");
        this.contentTagBinding = a2;
        FastRecordTagDialogBinding fastRecordTagDialogBinding2 = this.binding;
        if (fastRecordTagDialogBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fastRecordTagDialogBinding2 = null;
        }
        FastRecordTagPersonLayoutBinding a3 = FastRecordTagPersonLayoutBinding.a(fastRecordTagDialogBinding2.b.getRoot());
        Intrinsics.checkNotNullExpressionValue(a3, "bind(...)");
        this.personTagBinding = a3;
        getLitePopup().hideTitleBar();
        getLitePopup().setScrollPopupFirstOnTop(true);
        getLitePopup().setStyle(2);
        FastRecordTagDialogBinding fastRecordTagDialogBinding3 = this.binding;
        if (fastRecordTagDialogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fastRecordTagDialogBinding = fastRecordTagDialogBinding3;
        }
        setContentView((View) fastRecordTagDialogBinding.getRoot());
        setupContentView(getContentView());
        initView();
        initViewModel();
    }

    public void onDestroy() {
        super.onDestroy();
        LogExt.logE("onDestroy", TAG);
    }
}
