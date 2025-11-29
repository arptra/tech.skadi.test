package com.upuphone.ar.transcribe.phone.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import com.airbnb.lottie.LottieAnimationView;
import com.honey.account.constant.AccountConstantKt;
import com.honey.account.v4.i0;
import com.honey.account.v4.j0;
import com.honey.account.v4.k0;
import com.honey.account.v4.l0;
import com.honey.account.v4.m0;
import com.honey.account.v4.n0;
import com.honey.account.v4.o0;
import com.honey.account.v4.p0;
import com.honey.account.v4.q0;
import com.honey.account.v4.r0;
import com.honey.account.v4.s0;
import com.honey.account.v4.t0;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.TranscribeApp;
import com.upuphone.ar.transcribe.constants.TranscribeConstants;
import com.upuphone.ar.transcribe.databinding.ActivityTranscribeStartBinding;
import com.upuphone.ar.transcribe.eventtrack.EventTrackingHelper;
import com.upuphone.ar.transcribe.eventtrack.event.ClickEvent;
import com.upuphone.ar.transcribe.ext.ActivityExtKt;
import com.upuphone.ar.transcribe.ext.ContextExtKt;
import com.upuphone.ar.transcribe.ext.InterconnectMsgCodExtKt;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.interconnect.entity.TranslationStateEntity;
import com.upuphone.ar.transcribe.phone.TranscribeManager;
import com.upuphone.ar.transcribe.phone.bean.LanguageBean;
import com.upuphone.ar.transcribe.phone.bean.OperateMessage;
import com.upuphone.ar.transcribe.phone.bean.RecordTabBean;
import com.upuphone.ar.transcribe.phone.bean.TransStateEvent;
import com.upuphone.ar.transcribe.phone.helper.InterConnectHelper;
import com.upuphone.ar.transcribe.phone.helper.MuteAudioHelper;
import com.upuphone.ar.transcribe.phone.helper.SwitchLangHelper;
import com.upuphone.ar.transcribe.phone.view.TransTitleBar;
import com.upuphone.ar.transcribe.phone.view.TranscribeLanguageDialog;
import com.upuphone.ar.transcribe.phone.vm.TranscribeEditViewModel;
import com.upuphone.ar.transcribe.utils.LanguageUtils;
import com.upuphone.ar.transcribe.utils.NetworkUtils;
import com.upuphone.ar.transcribe.utils.PreferencesUtils;
import com.upuphone.star.common.phone.UToast;
import com.upuphone.xr.sapp.context.IPhoneCallStatus;
import com.upuphone.xr.sapp.context.SdkContext;
import flyme.support.v7.app.ShowAtBottomAlertDialog;
import java.util.Arrays;
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
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001\u0018\u0018\u0000 K2\u00020\u0001:\u0001KB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&H\u0002J\u001c\u0010'\u001a\u00020\u001b\"\u0004\b\u0000\u0010(2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H(0*H\u0002J\b\u0010+\u001a\u00020\u001bH\u0002J\b\u0010,\u001a\u00020\u001bH\u0002J\b\u0010-\u001a\u00020\u001bH\u0002J\b\u0010.\u001a\u00020\u001bH\u0002J\b\u0010/\u001a\u00020\u001bH\u0002J\b\u00100\u001a\u00020\u001bH\u0002J\b\u00101\u001a\u00020\u001bH\u0002J\b\u00102\u001a\u00020\u000eH\u0002J\u0010\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u001fH\u0002J\u0006\u00105\u001a\u00020\u001bJ\u0012\u00106\u001a\u00020\u001b2\b\u00107\u001a\u0004\u0018\u000108H\u0014J\b\u00109\u001a\u00020\u001bH\u0014J\b\u0010:\u001a\u00020\u001bH\u0002J\b\u0010;\u001a\u00020\u001bH\u0002J\b\u0010<\u001a\u00020\u001bH\u0002J\u0010\u0010=\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\fH\u0002J\b\u0010?\u001a\u00020\u001bH\u0002J\b\u0010@\u001a\u00020\u001bH\u0002J\u0010\u0010A\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020\u001fH\u0002J\u0010\u0010C\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020\fH\u0002J\b\u0010E\u001a\u00020\u001bH\u0002J\u0010\u0010F\u001a\u00020\u001b2\u0006\u0010G\u001a\u00020\u000eH\u0002J\b\u0010H\u001a\u00020\u001bH\u0002J\b\u0010I\u001a\u00020\u001bH\u0002J\b\u0010J\u001a\u00020\u001bH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0004\n\u0002\u0010\u0019¨\u0006L"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/activity/TranscribeStartActivity;", "Lcom/upuphone/ar/transcribe/phone/activity/TranscribeBaseActivity;", "()V", "editViewModel", "Lcom/upuphone/ar/transcribe/phone/vm/TranscribeEditViewModel;", "getEditViewModel", "()Lcom/upuphone/ar/transcribe/phone/vm/TranscribeEditViewModel;", "editViewModel$delegate", "Lkotlin/Lazy;", "mBinding", "Lcom/upuphone/ar/transcribe/databinding/ActivityTranscribeStartBinding;", "mCurrentTransType", "", "mIsTransRunning", "", "mIsTransStopping", "mOppositeStartTrans", "mRecord", "Lcom/upuphone/ar/transcribe/phone/bean/RecordTabBean;", "mTranscribeLanguage", "Lcom/upuphone/ar/transcribe/phone/bean/LanguageBean;", "mTranscribeLanguageDialog", "Lcom/upuphone/ar/transcribe/phone/view/TranscribeLanguageDialog;", "mUiUpdateCallback", "com/upuphone/ar/transcribe/phone/activity/TranscribeStartActivity$mUiUpdateCallback$1", "Lcom/upuphone/ar/transcribe/phone/activity/TranscribeStartActivity$mUiUpdateCallback$1;", "enterEditModel", "", "enter", "getLanguageBean", "langType", "", "handleTransExtState", "transState", "Lcom/upuphone/ar/transcribe/interconnect/entity/TranslationStateEntity;", "handleTransState", "handleTranslateState", "transStateEvent", "Lcom/upuphone/ar/transcribe/phone/bean/TransStateEvent;", "handleVariousMsg", "T", "operateMessage", "Lcom/upuphone/ar/transcribe/phone/bean/OperateMessage;", "initData", "initLangSetting", "initListener", "initState", "initTabLayout", "initTransLayout", "initViewModel", "isDeviceConnected", "isSupport", "lan", "notifyTranslationStop", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "reportClickTransStart", "reportClickTransStop", "setTranscribeLang", "showDeleteDialog", "count", "showLanguage", "showTranscribeLangPop", "toToast", "msg", "transStart", "transType", "transStartOrStop", "updateLangSelectAlpha", "isAlpha", "updatePreparingUI", "updateStartUI", "updateStopUI", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTranscribeStartActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranscribeStartActivity.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeStartActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,809:1\n75#2,13:810\n262#3,2:823\n262#3,2:825\n262#3,2:827\n262#3,2:829\n262#3,2:831\n262#3,2:833\n262#3,2:835\n262#3,2:837\n262#3,2:839\n262#3,2:841\n262#3,2:843\n262#3,2:845\n262#3,2:847\n262#3,2:849\n262#3,2:851\n262#3,2:853\n262#3,2:855\n262#3,2:857\n*S KotlinDebug\n*F\n+ 1 TranscribeStartActivity.kt\ncom/upuphone/ar/transcribe/phone/activity/TranscribeStartActivity\n*L\n88#1:810,13\n213#1:823,2\n216#1:825,2\n217#1:827,2\n230#1:829,2\n231#1:831,2\n234#1:833,2\n236#1:835,2\n256#1:837,2\n258#1:839,2\n260#1:841,2\n262#1:843,2\n338#1:845,2\n344#1:847,2\n372#1:849,2\n373#1:851,2\n444#1:853,2\n340#1:855,2\n628#1:857,2\n*E\n"})
public final class TranscribeStartActivity extends TranscribeBaseActivity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "TranscribeStartActivity";
    @NotNull
    private final Lazy editViewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(TranscribeEditViewModel.class), new TranscribeStartActivity$special$$inlined$viewModels$default$2(this), new TranscribeStartActivity$special$$inlined$viewModels$default$1(this), new TranscribeStartActivity$special$$inlined$viewModels$default$3((Function0) null, this));
    /* access modifiers changed from: private */
    public ActivityTranscribeStartBinding mBinding;
    /* access modifiers changed from: private */
    public int mCurrentTransType = 1;
    private boolean mIsTransRunning;
    private boolean mIsTransStopping;
    private boolean mOppositeStartTrans;
    /* access modifiers changed from: private */
    @Nullable
    public RecordTabBean mRecord;
    /* access modifiers changed from: private */
    @Nullable
    public LanguageBean mTranscribeLanguage;
    @Nullable
    private TranscribeLanguageDialog mTranscribeLanguageDialog;
    @NotNull
    private final TranscribeStartActivity$mUiUpdateCallback$1 mUiUpdateCallback = new TranscribeStartActivity$mUiUpdateCallback$1(this);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/activity/TranscribeStartActivity$Companion;", "", "()V", "TAG", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final void enterEditModel(boolean z) {
        ActivityTranscribeStartBinding activityTranscribeStartBinding = this.mBinding;
        ActivityTranscribeStartBinding activityTranscribeStartBinding2 = null;
        if (activityTranscribeStartBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding = null;
        }
        Group group = activityTranscribeStartBinding.g;
        Intrinsics.checkNotNullExpressionValue(group, "editModeGroup");
        int i = 8;
        group.setVisibility(z ? 0 : 8);
        ActivityTranscribeStartBinding activityTranscribeStartBinding3 = this.mBinding;
        if (activityTranscribeStartBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding3 = null;
        }
        TransTitleBar transTitleBar = activityTranscribeStartBinding3.r;
        Intrinsics.checkNotNullExpressionValue(transTitleBar, "titleBar");
        if (!z) {
            i = 0;
        }
        transTitleBar.setVisibility(i);
        ActivityTranscribeStartBinding activityTranscribeStartBinding4 = this.mBinding;
        if (activityTranscribeStartBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding4 = null;
        }
        activityTranscribeStartBinding4.c.setEnabled(!z);
        ActivityTranscribeStartBinding activityTranscribeStartBinding5 = this.mBinding;
        if (activityTranscribeStartBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding5 = null;
        }
        activityTranscribeStartBinding5.x.setEnabled(!z);
        ActivityTranscribeStartBinding activityTranscribeStartBinding6 = this.mBinding;
        if (activityTranscribeStartBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding6 = null;
        }
        activityTranscribeStartBinding6.f.setEnabled(!z);
        ActivityTranscribeStartBinding activityTranscribeStartBinding7 = this.mBinding;
        if (activityTranscribeStartBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            activityTranscribeStartBinding2 = activityTranscribeStartBinding7;
        }
        activityTranscribeStartBinding2.z.setEnabled(!z);
    }

    /* access modifiers changed from: private */
    public final TranscribeEditViewModel getEditViewModel() {
        return (TranscribeEditViewModel) this.editViewModel$delegate.getValue();
    }

    private final LanguageBean getLanguageBean(String str) {
        return new LanguageBean(LanguageUtils.a(this, str), str);
    }

    private final void handleTransExtState(TranslationStateEntity translationStateEntity) {
        int extCode = translationStateEntity.getExtCode();
        String d = InterconnectMsgCodExtKt.d(extCode);
        LogExt.g("handleTransExtState extCode[" + extCode + AccountConstantKt.CODE_SEPARTOR + d + "]", TAG);
        if (extCode == 11) {
            UToast.Companion companion = UToast.f6444a;
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            String string = getString(R.string.trsb_network_off);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            companion.e(applicationContext, string, 0);
        } else if (extCode == 15) {
            handleTransState(translationStateEntity);
            MuteAudioHelper.e(translationStateEntity);
        } else if (extCode == 18) {
            UToast.Companion companion2 = UToast.f6444a;
            Context applicationContext2 = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
            String string2 = getString(R.string.trsb_toast_server_disconnected);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            companion2.e(applicationContext2, string2, 0);
        } else if (extCode == 27) {
            LogExt.d("电话挂断", TAG);
        } else if (extCode != 31) {
            LogExt.d("无需处理的指令", TAG);
        } else {
            updateStopUI();
        }
    }

    private final void handleTransState(TranslationStateEntity translationStateEntity) {
        int transState = translationStateEntity.getTransState();
        String e = InterconnectMsgCodExtKt.e(transState);
        LogExt.g("handleTransState state[" + transState + AccountConstantKt.CODE_SEPARTOR + e + "]}", TAG);
        if (transState == 2) {
            updateStopUI();
        } else if (transState != 4) {
            LogExt.d("无需处理的状态", TAG);
        }
    }

    /* access modifiers changed from: private */
    public final void handleTranslateState(TransStateEvent transStateEvent) {
        runOnUiThread(new m0(transStateEvent, this));
    }

    /* access modifiers changed from: private */
    public static final void handleTranslateState$lambda$12(TransStateEvent transStateEvent, TranscribeStartActivity transcribeStartActivity) {
        Intrinsics.checkNotNullParameter(transStateEvent, "$transStateEvent");
        Intrinsics.checkNotNullParameter(transcribeStartActivity, "this$0");
        TranslationStateEntity transState = transStateEvent.getTransState();
        int transState2 = transState.getTransState();
        String e = InterconnectMsgCodExtKt.e(transState.getTransState());
        int extCode = transState.getExtCode();
        String d = InterconnectMsgCodExtKt.d(transState.getExtCode());
        LogExt.g("handleTranslateState state[" + transState2 + AccountConstantKt.CODE_SEPARTOR + e + "], extCode[" + extCode + AccountConstantKt.CODE_SEPARTOR + d + "]", TAG);
        TranscribeManager.Companion companion = TranscribeManager.j;
        if (!companion.a().h().n()) {
            LogExt.g("handleTranslateState stateMachine not started", TAG);
            return;
        }
        if (companion.a().h().h(transState.getTransState())) {
            transcribeStartActivity.updateStopUI();
        } else if (companion.a().h().k()) {
            transcribeStartActivity.mCurrentTransType = companion.a().l();
            transcribeStartActivity.updateStartUI();
        }
        if (transState.getExtCode() == -1) {
            transcribeStartActivity.handleTransState(transState);
        } else {
            transcribeStartActivity.handleTransExtState(transState);
        }
    }

    /* access modifiers changed from: private */
    public final <T> void handleVariousMsg(OperateMessage<T> operateMessage) {
        runOnUiThread(new i0(operateMessage, this));
    }

    /* access modifiers changed from: private */
    public static final void handleVariousMsg$lambda$10(OperateMessage operateMessage, TranscribeStartActivity transcribeStartActivity) {
        Intrinsics.checkNotNullParameter(operateMessage, "$operateMessage");
        Intrinsics.checkNotNullParameter(transcribeStartActivity, "this$0");
        int type = operateMessage.getType();
        String b = InterconnectMsgCodExtKt.b(type);
        LogExt.g("handleVariousMsg type=" + type + AccountConstantKt.CODE_SEPARTOR + b, TAG);
        int i = 0;
        ActivityTranscribeStartBinding activityTranscribeStartBinding = null;
        if (type == 7) {
            transcribeStartActivity.updateStopUI();
            MuteAudioHelper.d(false, 1, (Object) null);
        } else if (type == 1001) {
            LogExt.d("通知是否有翻译记录 NOTIFY_TRANS_RECORDS", TAG);
            if (operateMessage.getObject() instanceof Boolean) {
                ActivityTranscribeStartBinding activityTranscribeStartBinding2 = transcribeStartActivity.mBinding;
                if (activityTranscribeStartBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    activityTranscribeStartBinding = activityTranscribeStartBinding2;
                }
                TextView textView = activityTranscribeStartBinding.p;
                Intrinsics.checkNotNullExpressionValue(textView, "recordTitle");
                Object object = operateMessage.getObject();
                Intrinsics.checkNotNull(object, "null cannot be cast to non-null type kotlin.Boolean");
                if (!((Boolean) object).booleanValue()) {
                    i = 8;
                }
                textView.setVisibility(i);
            }
        } else if (type == 11) {
            LogExt.g("眼镜翻译启动完成", TAG);
        } else if (type == 12) {
            MuteAudioHelper.d(false, 1, (Object) null);
        } else if (type == 101) {
        } else {
            if (type != 102) {
                LogExt.d("无需处理的指令", TAG);
            } else {
                transcribeStartActivity.updateStopUI();
            }
        }
    }

    private final void initData() {
        initTransLayout();
        initLangSetting();
        initState();
    }

    private final void initLangSetting() {
        this.mTranscribeLanguage = getLanguageBean(LanguageUtils.c(this, false, false, 6, (Object) null).a());
        showLanguage();
    }

    private final void initListener() {
        TranscribeApp.registerUiUpdateCallback(TAG, this.mUiUpdateCallback);
        SwitchLangHelper.k(new p0(this));
        SdkContext.f6675a.c().h().observe(this, new TranscribeStartActivity$sam$androidx_lifecycle_Observer$0(new TranscribeStartActivity$initListener$2(this)));
        ActivityTranscribeStartBinding activityTranscribeStartBinding = this.mBinding;
        ActivityTranscribeStartBinding activityTranscribeStartBinding2 = null;
        if (activityTranscribeStartBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding = null;
        }
        activityTranscribeStartBinding.r.l(new TranscribeStartActivity$initListener$3(this));
        ActivityTranscribeStartBinding activityTranscribeStartBinding3 = this.mBinding;
        if (activityTranscribeStartBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding3 = null;
        }
        activityTranscribeStartBinding3.r.setIconMenu(R.drawable.trcb_setting_icon);
        ActivityTranscribeStartBinding activityTranscribeStartBinding4 = this.mBinding;
        if (activityTranscribeStartBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding4 = null;
        }
        activityTranscribeStartBinding4.r.setIconMenu2(R.drawable.trsb_serach_icon);
        ActivityTranscribeStartBinding activityTranscribeStartBinding5 = this.mBinding;
        if (activityTranscribeStartBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding5 = null;
        }
        activityTranscribeStartBinding5.r.setIconMenuVisible(true);
        ActivityTranscribeStartBinding activityTranscribeStartBinding6 = this.mBinding;
        if (activityTranscribeStartBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding6 = null;
        }
        activityTranscribeStartBinding6.r.setIconMenu2Visible(true);
        ActivityTranscribeStartBinding activityTranscribeStartBinding7 = this.mBinding;
        if (activityTranscribeStartBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding7 = null;
        }
        activityTranscribeStartBinding7.r.r(new TranscribeStartActivity$initListener$4(this));
        ActivityTranscribeStartBinding activityTranscribeStartBinding8 = this.mBinding;
        if (activityTranscribeStartBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding8 = null;
        }
        activityTranscribeStartBinding8.r.n(new TranscribeStartActivity$initListener$5(this));
        ActivityTranscribeStartBinding activityTranscribeStartBinding9 = this.mBinding;
        if (activityTranscribeStartBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding9 = null;
        }
        activityTranscribeStartBinding9.z.setOnClickListener(new q0(this));
        ActivityTranscribeStartBinding activityTranscribeStartBinding10 = this.mBinding;
        if (activityTranscribeStartBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding10 = null;
        }
        activityTranscribeStartBinding10.c.setOnClickListener(new r0(this));
        if (PreferencesUtils.j(this)) {
            ActivityTranscribeStartBinding activityTranscribeStartBinding11 = this.mBinding;
            if (activityTranscribeStartBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                activityTranscribeStartBinding11 = null;
            }
            ConstraintLayout constraintLayout = activityTranscribeStartBinding11.e;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "dialTransContainer");
            constraintLayout.setVisibility(0);
            ActivityTranscribeStartBinding activityTranscribeStartBinding12 = this.mBinding;
            if (activityTranscribeStartBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                activityTranscribeStartBinding12 = null;
            }
            activityTranscribeStartBinding12.f.setOnClickListener(new s0(this));
        } else {
            ActivityTranscribeStartBinding activityTranscribeStartBinding13 = this.mBinding;
            if (activityTranscribeStartBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                activityTranscribeStartBinding13 = null;
            }
            ConstraintLayout constraintLayout2 = activityTranscribeStartBinding13.e;
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "dialTransContainer");
            constraintLayout2.setVisibility(8);
        }
        ActivityTranscribeStartBinding activityTranscribeStartBinding14 = this.mBinding;
        if (activityTranscribeStartBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding14 = null;
        }
        activityTranscribeStartBinding14.t.setOnClickListener(new t0(this));
        ActivityTranscribeStartBinding activityTranscribeStartBinding15 = this.mBinding;
        if (activityTranscribeStartBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding15 = null;
        }
        activityTranscribeStartBinding15.w.setOnClickListener(new j0(this));
        ActivityTranscribeStartBinding activityTranscribeStartBinding16 = this.mBinding;
        if (activityTranscribeStartBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            activityTranscribeStartBinding2 = activityTranscribeStartBinding16;
        }
        activityTranscribeStartBinding2.h.setOnClickListener(new k0(this));
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "<get-onBackPressedDispatcher>(...)");
        OnBackPressedDispatcherKt.b(onBackPressedDispatcher, (LifecycleOwner) null, false, new TranscribeStartActivity$initListener$12(this), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$1(TranscribeStartActivity transcribeStartActivity, int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(transcribeStartActivity, "this$0");
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(str2, "<anonymous parameter 2>");
        transcribeStartActivity.mTranscribeLanguage = transcribeStartActivity.getLanguageBean(str);
        transcribeStartActivity.runOnUiThread(new l0(transcribeStartActivity));
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$1$lambda$0(TranscribeStartActivity transcribeStartActivity) {
        Intrinsics.checkNotNullParameter(transcribeStartActivity, "this$0");
        transcribeStartActivity.showLanguage();
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$2(TranscribeStartActivity transcribeStartActivity, View view) {
        Intrinsics.checkNotNullParameter(transcribeStartActivity, "this$0");
        transcribeStartActivity.showTranscribeLangPop();
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$3(TranscribeStartActivity transcribeStartActivity, View view) {
        Intrinsics.checkNotNullParameter(transcribeStartActivity, "this$0");
        transcribeStartActivity.transStartOrStop();
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$4(TranscribeStartActivity transcribeStartActivity, View view) {
        Intrinsics.checkNotNullParameter(transcribeStartActivity, "this$0");
        ActivityTranscribeStartBinding activityTranscribeStartBinding = transcribeStartActivity.mBinding;
        if (activityTranscribeStartBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding = null;
        }
        ConstraintLayout constraintLayout = activityTranscribeStartBinding.e;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "dialTransContainer");
        constraintLayout.setVisibility(8);
        PreferencesUtils.l(transcribeStartActivity, false);
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$5(TranscribeStartActivity transcribeStartActivity, View view) {
        Intrinsics.checkNotNullParameter(transcribeStartActivity, "this$0");
        transcribeStartActivity.getEditViewModel().h(false);
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$6(TranscribeStartActivity transcribeStartActivity, View view) {
        Intrinsics.checkNotNullParameter(transcribeStartActivity, "this$0");
        transcribeStartActivity.getEditViewModel().v();
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$7(TranscribeStartActivity transcribeStartActivity, View view) {
        Intrinsics.checkNotNullParameter(transcribeStartActivity, "this$0");
        transcribeStartActivity.showDeleteDialog(transcribeStartActivity.getEditViewModel().p());
    }

    private final void initState() {
        TranscribeManager.Companion companion = TranscribeManager.j;
        this.mCurrentTransType = companion.a().l();
        if (TranscribeApp.isServiceOn()) {
            int e = companion.a().h().e();
            this.mIsTransRunning = !companion.a().h().j(e);
            String e2 = InterconnectMsgCodExtKt.e(e);
            boolean z = this.mIsTransRunning;
            LogExt.g("initState currentState=" + e + AccountConstantKt.CODE_SEPARTOR + e2 + ", mIsTransRunning=" + z, TAG);
        }
        if (this.mIsTransRunning) {
            updateStartUI();
        } else {
            updateStopUI();
        }
    }

    private final void initTabLayout() {
        String string = getString(R.string.trsb_speech_transcribe);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.mRecord = new RecordTabBean(string, TranscribeRecordFragment.Companion.newInstance());
        ActivityTranscribeStartBinding activityTranscribeStartBinding = this.mBinding;
        ActivityTranscribeStartBinding activityTranscribeStartBinding2 = null;
        if (activityTranscribeStartBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding = null;
        }
        activityTranscribeStartBinding.s.setOffscreenPageLimit(1);
        ActivityTranscribeStartBinding activityTranscribeStartBinding3 = this.mBinding;
        if (activityTranscribeStartBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            activityTranscribeStartBinding2 = activityTranscribeStartBinding3;
        }
        activityTranscribeStartBinding2.s.setAdapter(new TranscribeStartActivity$initTabLayout$1(this, getSupportFragmentManager(), getLifecycle()));
    }

    private final void initTransLayout() {
        TranscribeApp.registerTransStartActivity(this);
        EventTrackingHelper.f6058a.c(new ClickEvent(5, 0, this.mCurrentTransType, 2, (DefaultConstructorMarker) null));
    }

    private final void initViewModel() {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TranscribeStartActivity$initViewModel$1(this, (Continuation<? super TranscribeStartActivity$initViewModel$1>) null), 3, (Object) null);
    }

    private final boolean isDeviceConnected() {
        return InterConnectHelper.c.a().k();
    }

    /* access modifiers changed from: private */
    public final boolean isSupport(String str) {
        return this.mCurrentTransType != 4 || CollectionsKt.arrayListOf("cn", "en", "cnen", "ja").contains(str);
    }

    /* access modifiers changed from: private */
    public static final void notifyTranslationStop$lambda$15(TranscribeStartActivity transcribeStartActivity) {
        Intrinsics.checkNotNullParameter(transcribeStartActivity, "this$0");
        transcribeStartActivity.mIsTransStopping = false;
        if (!transcribeStartActivity.mOppositeStartTrans) {
            transcribeStartActivity.mOppositeStartTrans = false;
            return;
        }
        String f = InterconnectMsgCodExtKt.f(transcribeStartActivity.mCurrentTransType);
        LogExt.d("notifyTranslationStop 启动翻译类型=" + f, TAG);
        transcribeStartActivity.transStart(transcribeStartActivity.mCurrentTransType);
        transcribeStartActivity.mOppositeStartTrans = false;
    }

    private final void reportClickTransStart() {
        EventTrackingHelper.f6058a.c(new ClickEvent(6, 0, this.mCurrentTransType, 2, (DefaultConstructorMarker) null));
    }

    private final void reportClickTransStop() {
        EventTrackingHelper.f6058a.c(new ClickEvent(7, 0, this.mCurrentTransType, 2, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    public final void setTranscribeLang() {
        LanguageBean languageBean = this.mTranscribeLanguage;
        LogExt.g("setTranscribeLang mTranscribeLanguage=" + languageBean, TAG);
        LanguageBean languageBean2 = this.mTranscribeLanguage;
        if (languageBean2 != null) {
            showLanguage();
            PreferencesUtils.n(this, languageBean2.getLangType(), TranscribeConstants.g(), TranscribeConstants.f6027a.m());
            InterConnectHelper.c.a().A(1, languageBean2.getLangType(), languageBean2.getLangType());
        }
    }

    private final void showDeleteDialog(int i) {
        ShowAtBottomAlertDialog.Builder builder = new ShowAtBottomAlertDialog.Builder(this);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.trsb_deleted_options);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        ShowAtBottomAlertDialog create = builder.setItems((CharSequence[]) new String[]{format}, (DialogInterface.OnClickListener) new n0(this), true, new ColorStateList[]{ContextCompat.getColorStateList(this, R.color.tb_choice_multi_delete_dialog_item)}).create();
        Intrinsics.checkNotNull(create);
        ActivityExtKt.a(create);
        create.show();
    }

    /* access modifiers changed from: private */
    public static final void showDeleteDialog$lambda$16(TranscribeStartActivity transcribeStartActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(transcribeStartActivity, "this$0");
        transcribeStartActivity.getEditViewModel().j();
    }

    private final void showLanguage() {
        String str;
        ActivityTranscribeStartBinding activityTranscribeStartBinding = this.mBinding;
        if (activityTranscribeStartBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding = null;
        }
        TextView textView = activityTranscribeStartBinding.z;
        LanguageBean languageBean = this.mTranscribeLanguage;
        if (languageBean == null || (str = languageBean.getLangName()) == null) {
            str = "";
        }
        textView.setText(str);
    }

    private final void showTranscribeLangPop() {
        TranscribeLanguageDialog transcribeLanguageDialog;
        if (this.mTranscribeLanguageDialog == null) {
            this.mTranscribeLanguageDialog = new TranscribeLanguageDialog(this, new TranscribeStartActivity$showTranscribeLangPop$1(this));
        }
        LanguageBean languageBean = this.mTranscribeLanguage;
        if (!(languageBean == null || (transcribeLanguageDialog = this.mTranscribeLanguageDialog) == null)) {
            transcribeLanguageDialog.n(languageBean.getLangType());
        }
        TranscribeLanguageDialog transcribeLanguageDialog2 = this.mTranscribeLanguageDialog;
        if (transcribeLanguageDialog2 != null) {
            transcribeLanguageDialog2.p(ActivityExtKt.c(this));
        }
        TranscribeLanguageDialog transcribeLanguageDialog3 = this.mTranscribeLanguageDialog;
        if (transcribeLanguageDialog3 != null) {
            transcribeLanguageDialog3.show();
        }
    }

    private final void toToast(String str) {
        UToast.Companion companion = UToast.f6444a;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        companion.e(applicationContext, str, 0);
    }

    private final void transStart(int i) {
        String str;
        String str2;
        this.mCurrentTransType = i;
        ActivityTranscribeStartBinding activityTranscribeStartBinding = null;
        LanguageUtils.StoredLanguage c = LanguageUtils.c(this, false, false, 6, (Object) null);
        LanguageBean languageBean = this.mTranscribeLanguage;
        if (languageBean == null || (str = languageBean.getLangType()) == null) {
            str = c.a();
        }
        LanguageBean languageBean2 = this.mTranscribeLanguage;
        if (languageBean2 == null || (str2 = languageBean2.getLangType()) == null) {
            str2 = c.a();
        }
        if (!isSupport(str)) {
            ActivityTranscribeStartBinding activityTranscribeStartBinding2 = this.mBinding;
            if (activityTranscribeStartBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                activityTranscribeStartBinding2 = null;
            }
            LinearLayout linearLayout = activityTranscribeStartBinding2.q;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "tipsContainer");
            linearLayout.setVisibility(0);
            ActivityTranscribeStartBinding activityTranscribeStartBinding3 = this.mBinding;
            if (activityTranscribeStartBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                activityTranscribeStartBinding3 = null;
            }
            activityTranscribeStartBinding3.c.setEnabled(false);
            ActivityTranscribeStartBinding activityTranscribeStartBinding4 = this.mBinding;
            if (activityTranscribeStartBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                activityTranscribeStartBinding = activityTranscribeStartBinding4;
            }
            activityTranscribeStartBinding.x.setEnabled(false);
            this.mCurrentTransType = 1;
            LogExt.d("not support language for call trans: " + str, TAG);
            return;
        }
        updatePreparingUI();
        NetworkUtils.f6189a.b(this, new TranscribeStartActivity$transStart$1(i, str, str2, this));
    }

    private final void transStartOrStop() {
        if (!isDeviceConnected()) {
            String string = getString(R.string.trsb_toast_glass_disconnected_tap);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            toToast(string);
        } else if (TranscribeConstants.f6027a.h()) {
            String string2 = getString(R.string.trsb_upgrade_glass_version_tips);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            toToast(string2);
        } else {
            int i = 1;
            if (this.mIsTransRunning) {
                String f = InterconnectMsgCodExtKt.f(this.mCurrentTransType);
                LogExt.g("点击转写按钮，暂停当前服务=" + f, TAG);
                TranscribeManager.j.a().h().E();
                reportClickTransStop();
                if (this.mCurrentTransType == 1) {
                    this.mIsTransStopping = true;
                    return;
                }
                this.mOppositeStartTrans = true;
                this.mCurrentTransType = 1;
                updatePreparingUI();
            } else if (this.mIsTransStopping) {
                String string3 = getString(R.string.trsb_trans_start_abnormal);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                toToast(string3);
            } else {
                IPhoneCallStatus iPhoneCallStatus = (IPhoneCallStatus) SdkContext.f6675a.c().h().getValue();
                if (iPhoneCallStatus != null && iPhoneCallStatus.getCallStatus() == 2) {
                    i = 4;
                }
                transStart(i);
                reportClickTransStart();
            }
        }
    }

    private final void updateLangSelectAlpha(boolean z) {
        if (this.mCurrentTransType == 1) {
            ActivityTranscribeStartBinding activityTranscribeStartBinding = this.mBinding;
            if (activityTranscribeStartBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                activityTranscribeStartBinding = null;
            }
            activityTranscribeStartBinding.z.setAlpha(z ? 0.25f : 1.0f);
        }
    }

    private final void updatePreparingUI() {
        LogExt.d("updatePreparingUI mCurrentTransType=" + this.mCurrentTransType, TAG);
        ActivityTranscribeStartBinding activityTranscribeStartBinding = this.mBinding;
        ActivityTranscribeStartBinding activityTranscribeStartBinding2 = null;
        if (activityTranscribeStartBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding = null;
        }
        TextView textView = activityTranscribeStartBinding.z;
        Intrinsics.checkNotNullExpressionValue(textView, "tvTranscribeSrc");
        textView.setVisibility(0);
        updateLangSelectAlpha(true);
        ActivityTranscribeStartBinding activityTranscribeStartBinding3 = this.mBinding;
        if (activityTranscribeStartBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding3 = null;
        }
        TextView textView2 = activityTranscribeStartBinding3.x;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvTranscribeBtn");
        textView2.setVisibility(8);
        ActivityTranscribeStartBinding activityTranscribeStartBinding4 = this.mBinding;
        if (activityTranscribeStartBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding4 = null;
        }
        LottieAnimationView lottieAnimationView = activityTranscribeStartBinding4.n;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "lottieTranscribeLoading");
        lottieAnimationView.setVisibility(0);
        ActivityTranscribeStartBinding activityTranscribeStartBinding5 = this.mBinding;
        if (activityTranscribeStartBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding5 = null;
        }
        activityTranscribeStartBinding5.n.setRepeatCount(-1);
        ActivityTranscribeStartBinding activityTranscribeStartBinding6 = this.mBinding;
        if (activityTranscribeStartBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            activityTranscribeStartBinding2 = activityTranscribeStartBinding6;
        }
        activityTranscribeStartBinding2.n.playAnimation();
    }

    private final void updateStartUI() {
        String str;
        int i;
        LogExt.d("updateStartUI mCurrentTransType=" + this.mCurrentTransType, TAG);
        ActivityTranscribeStartBinding activityTranscribeStartBinding = this.mBinding;
        ActivityTranscribeStartBinding activityTranscribeStartBinding2 = null;
        if (activityTranscribeStartBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding = null;
        }
        TextView textView = activityTranscribeStartBinding.z;
        Intrinsics.checkNotNullExpressionValue(textView, "tvTranscribeSrc");
        textView.setVisibility(8);
        ActivityTranscribeStartBinding activityTranscribeStartBinding3 = this.mBinding;
        if (activityTranscribeStartBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding3 = null;
        }
        Group group = activityTranscribeStartBinding3.i;
        Intrinsics.checkNotNullExpressionValue(group, "gpTranscribeRunning");
        group.setVisibility(0);
        ActivityTranscribeStartBinding activityTranscribeStartBinding4 = this.mBinding;
        if (activityTranscribeStartBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding4 = null;
        }
        activityTranscribeStartBinding4.o.setRepeatCount(-1);
        ActivityTranscribeStartBinding activityTranscribeStartBinding5 = this.mBinding;
        if (activityTranscribeStartBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding5 = null;
        }
        activityTranscribeStartBinding5.o.playAnimation();
        ActivityTranscribeStartBinding activityTranscribeStartBinding6 = this.mBinding;
        if (activityTranscribeStartBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding6 = null;
        }
        TextView textView2 = activityTranscribeStartBinding6.x;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvTranscribeBtn");
        textView2.setVisibility(0);
        ActivityTranscribeStartBinding activityTranscribeStartBinding7 = this.mBinding;
        if (activityTranscribeStartBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding7 = null;
        }
        activityTranscribeStartBinding7.x.setText(R.string.trsb_transcribe_stop);
        ActivityTranscribeStartBinding activityTranscribeStartBinding8 = this.mBinding;
        if (activityTranscribeStartBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding8 = null;
        }
        LottieAnimationView lottieAnimationView = activityTranscribeStartBinding8.n;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "lottieTranscribeLoading");
        lottieAnimationView.setVisibility(8);
        ActivityTranscribeStartBinding activityTranscribeStartBinding9 = this.mBinding;
        if (activityTranscribeStartBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding9 = null;
        }
        activityTranscribeStartBinding9.n.cancelAnimation();
        ActivityTranscribeStartBinding activityTranscribeStartBinding10 = this.mBinding;
        if (activityTranscribeStartBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding10 = null;
        }
        TextView textView3 = activityTranscribeStartBinding10.y;
        int i2 = this.mCurrentTransType;
        if (i2 == 1) {
            str = getString(R.string.trsb_bt_transcribe_running);
        } else if (i2 == 4) {
            str = getString(R.string.trsb_calling_transcribing);
        } else {
            throw new IllegalArgumentException("Un support type: " + this.mCurrentTransType);
        }
        textView3.setText(str);
        ActivityTranscribeStartBinding activityTranscribeStartBinding11 = this.mBinding;
        if (activityTranscribeStartBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            activityTranscribeStartBinding2 = activityTranscribeStartBinding11;
        }
        ImageView imageView = activityTranscribeStartBinding2.l;
        int i3 = this.mCurrentTransType;
        if (i3 == 1) {
            i = R.drawable.icon_func_transcribe_running;
        } else if (i3 == 4) {
            i = R.drawable.trsb_calling_icon;
        } else {
            throw new IllegalArgumentException("Un support type: " + this.mCurrentTransType);
        }
        imageView.setImageResource(i);
        this.mIsTransRunning = true;
    }

    /* access modifiers changed from: private */
    public final void updateStopUI() {
        LogExt.d("updateStopUI CurrentTransType=" + this.mCurrentTransType, TAG);
        ActivityTranscribeStartBinding activityTranscribeStartBinding = this.mBinding;
        ActivityTranscribeStartBinding activityTranscribeStartBinding2 = null;
        if (activityTranscribeStartBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding = null;
        }
        TextView textView = activityTranscribeStartBinding.z;
        Intrinsics.checkNotNullExpressionValue(textView, "tvTranscribeSrc");
        textView.setVisibility(0);
        updateLangSelectAlpha(false);
        ActivityTranscribeStartBinding activityTranscribeStartBinding3 = this.mBinding;
        if (activityTranscribeStartBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding3 = null;
        }
        Group group = activityTranscribeStartBinding3.i;
        Intrinsics.checkNotNullExpressionValue(group, "gpTranscribeRunning");
        group.setVisibility(8);
        ActivityTranscribeStartBinding activityTranscribeStartBinding4 = this.mBinding;
        if (activityTranscribeStartBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding4 = null;
        }
        activityTranscribeStartBinding4.o.cancelAnimation();
        ActivityTranscribeStartBinding activityTranscribeStartBinding5 = this.mBinding;
        if (activityTranscribeStartBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding5 = null;
        }
        TextView textView2 = activityTranscribeStartBinding5.x;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvTranscribeBtn");
        textView2.setVisibility(0);
        ActivityTranscribeStartBinding activityTranscribeStartBinding6 = this.mBinding;
        if (activityTranscribeStartBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding6 = null;
        }
        activityTranscribeStartBinding6.x.setText(R.string.trsb_transcribe_start);
        ActivityTranscribeStartBinding activityTranscribeStartBinding7 = this.mBinding;
        if (activityTranscribeStartBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding7 = null;
        }
        LottieAnimationView lottieAnimationView = activityTranscribeStartBinding7.n;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "lottieTranscribeLoading");
        lottieAnimationView.setVisibility(8);
        ActivityTranscribeStartBinding activityTranscribeStartBinding8 = this.mBinding;
        if (activityTranscribeStartBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            activityTranscribeStartBinding2 = activityTranscribeStartBinding8;
        }
        activityTranscribeStartBinding2.n.cancelAnimation();
        this.mIsTransRunning = false;
        this.mIsTransStopping = false;
    }

    public final void notifyTranslationStop() {
        LogExt.d("notifyTranslationStop 翻译Socket通道已经断开", TAG);
        runOnUiThread(new o0(this));
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityTranscribeStartBinding c = ActivityTranscribeStartBinding.c(ContextExtKt.a(this));
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.mBinding = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            c = null;
        }
        setContentView((View) c.getRoot());
        TranscribeApp.setActivityOn(true);
        TranscribeApp.init(this);
        initData();
        initListener();
        initTabLayout();
        initViewModel();
    }

    public void onDestroy() {
        super.onDestroy();
        TranscribeLanguageDialog transcribeLanguageDialog = this.mTranscribeLanguageDialog;
        if (transcribeLanguageDialog != null) {
            transcribeLanguageDialog.dismiss();
        }
        ActivityTranscribeStartBinding activityTranscribeStartBinding = null;
        this.mTranscribeLanguageDialog = null;
        this.mIsTransRunning = false;
        SwitchLangHelper.z();
        TranscribeApp.unRegisterTransStartActivity();
        this.mOppositeStartTrans = false;
        this.mIsTransStopping = false;
        TranscribeApp.unRegisterUiUpdateCallback(TAG);
        ActivityTranscribeStartBinding activityTranscribeStartBinding2 = this.mBinding;
        if (activityTranscribeStartBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding2 = null;
        }
        if (activityTranscribeStartBinding2.n.isAnimating()) {
            ActivityTranscribeStartBinding activityTranscribeStartBinding3 = this.mBinding;
            if (activityTranscribeStartBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                activityTranscribeStartBinding3 = null;
            }
            activityTranscribeStartBinding3.n.cancelAnimation();
        }
        ActivityTranscribeStartBinding activityTranscribeStartBinding4 = this.mBinding;
        if (activityTranscribeStartBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTranscribeStartBinding4 = null;
        }
        if (activityTranscribeStartBinding4.o.isAnimating()) {
            ActivityTranscribeStartBinding activityTranscribeStartBinding5 = this.mBinding;
            if (activityTranscribeStartBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                activityTranscribeStartBinding = activityTranscribeStartBinding5;
            }
            activityTranscribeStartBinding.o.cancelAnimation();
        }
        TranscribeApp.setActivityOn(false);
        TranscribeApp.release();
        TranscribeApp.clearActivity();
    }
}
