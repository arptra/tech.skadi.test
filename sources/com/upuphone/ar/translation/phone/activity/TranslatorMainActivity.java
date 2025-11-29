package com.upuphone.ar.translation.phone.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.honey.account.d5.e;
import com.honey.account.d5.f;
import com.honey.account.d5.g;
import com.honey.account.d5.h;
import com.honey.account.d5.i;
import com.honey.account.d5.j;
import com.honey.account.d5.k;
import com.honey.account.d5.l;
import com.honey.account.d5.m;
import com.honey.account.d5.n;
import com.honey.account.d5.o;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.audio.debug.AudioDebugHelper;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.eventtrack.EventTrackingHelper;
import com.upuphone.ar.translation.eventtrack.event.ClickEvent;
import com.upuphone.ar.translation.ext.ContextExtKt;
import com.upuphone.ar.translation.ext.InterconnectMsgCodExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.interconnect.entity.TranslationState;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.bean.OperateMessage;
import com.upuphone.ar.translation.phone.bean.RecordTabBean;
import com.upuphone.ar.translation.phone.bean.TransStateEvent;
import com.upuphone.ar.translation.phone.databinding.ActivityTranslatorMainBinding;
import com.upuphone.ar.translation.phone.databinding.TablayoutCustomTabBinding;
import com.upuphone.ar.translation.phone.helper.MuteAudioHelper;
import com.upuphone.ar.translation.phone.helper.NoteSyncHelper;
import com.upuphone.ar.translation.phone.helper.SwitchLangHelper;
import com.upuphone.ar.translation.phone.view.TransFuncItem;
import com.upuphone.ar.translation.phone.vm.TranslatorMainViewModel;
import com.upuphone.ar.translation.phone.vm.TranslatorRecordShareViewModel;
import com.upuphone.ar.translation.utils.PreferencesUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004*\u0002\u0011\u001d\u0018\u0000 =2\u00020\u0001:\u0001=B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020 2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'H\u0002J\u001c\u0010(\u001a\u00020 \"\u0004\b\u0000\u0010)2\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H)0+H\u0002J\b\u0010,\u001a\u00020 H\u0002J\b\u0010-\u001a\u00020 H\u0002J\b\u0010.\u001a\u00020 H\u0002J\b\u0010/\u001a\u00020 H\u0002J\u0010\u00100\u001a\u00020 2\u0006\u00101\u001a\u000202H\u0002J\u0012\u00103\u001a\u00020 2\b\u00104\u001a\u0004\u0018\u000105H\u0014J\b\u00106\u001a\u00020 H\u0016J\b\u00107\u001a\u00020 H\u0014J\u0010\u00108\u001a\u00020 2\u0006\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020 H\u0002J\b\u0010<\u001a\u00020 H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0004\n\u0002\u0010\u001e¨\u0006>"}, d2 = {"Lcom/upuphone/ar/translation/phone/activity/TranslatorMainActivity;", "Lcom/upuphone/ar/translation/phone/activity/TranslatorBaseActivity;", "()V", "mBinding", "Lcom/upuphone/ar/translation/phone/databinding/ActivityTranslatorMainBinding;", "getMBinding", "()Lcom/upuphone/ar/translation/phone/databinding/ActivityTranslatorMainBinding;", "mBinding$delegate", "Lkotlin/Lazy;", "mMainVm", "Lcom/upuphone/ar/translation/phone/vm/TranslatorMainViewModel;", "getMMainVm", "()Lcom/upuphone/ar/translation/phone/vm/TranslatorMainViewModel;", "mMainVm$delegate", "mOnPageChangeCallback", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "mPageAdapter", "com/upuphone/ar/translation/phone/activity/TranslatorMainActivity$mPageAdapter$1", "Lcom/upuphone/ar/translation/phone/activity/TranslatorMainActivity$mPageAdapter$1;", "mRecordShareVm", "Lcom/upuphone/ar/translation/phone/vm/TranslatorRecordShareViewModel;", "getMRecordShareVm", "()Lcom/upuphone/ar/translation/phone/vm/TranslatorRecordShareViewModel;", "mRecordShareVm$delegate", "mTabLayoutMediator", "Lcom/google/android/material/tabs/TabLayoutMediator;", "mTempNoteBean", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "mUiUpdateCallback", "com/upuphone/ar/translation/phone/activity/TranslatorMainActivity$mUiUpdateCallback$1", "Lcom/upuphone/ar/translation/phone/activity/TranslatorMainActivity$mUiUpdateCallback$1;", "handleDiffGlass", "", "handleTransExtState", "translationState", "Lcom/upuphone/ar/translation/interconnect/entity/TranslationState;", "handleTransNormalState", "handleTranslateState", "transStateEvent", "Lcom/upuphone/ar/translation/phone/bean/TransStateEvent;", "handleVariousMsg", "T", "operateMessage", "Lcom/upuphone/ar/translation/phone/bean/OperateMessage;", "initListener", "initTabLayout", "initView", "initViewModels", "notifyTransRecordsUI", "isHaveData", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "startTransFuncActivity", "transType", "", "updateListView", "updateTransFuncLang", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTranslatorMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranslatorMainActivity.kt\ncom/upuphone/ar/translation/phone/activity/TranslatorMainActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,606:1\n75#2,13:607\n75#2,13:620\n262#3,2:633\n262#3,2:635\n262#3,2:637\n262#3,2:639\n262#3,2:641\n262#3,2:643\n262#3,2:645\n262#3,2:647\n262#3,2:649\n*S KotlinDebug\n*F\n+ 1 TranslatorMainActivity.kt\ncom/upuphone/ar/translation/phone/activity/TranslatorMainActivity\n*L\n63#1:607,13\n65#1:620,13\n309#1:633,2\n430#1:635,2\n431#1:637,2\n432#1:639,2\n583#1:641,2\n584#1:643,2\n587#1:645,2\n588#1:647,2\n168#1:649,2\n*E\n"})
public final class TranslatorMainActivity extends TranslatorBaseActivity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "TranslatorMainActivity";
    @NotNull
    private final Lazy mBinding$delegate = LazyKt.lazy(new TranslatorMainActivity$mBinding$2(this));
    @NotNull
    private final Lazy mMainVm$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(TranslatorMainViewModel.class), new TranslatorMainActivity$special$$inlined$viewModels$default$2(this), new TranslatorMainActivity$special$$inlined$viewModels$default$1(this), new TranslatorMainActivity$special$$inlined$viewModels$default$3((Function0) null, this));
    @NotNull
    private final ViewPager2.OnPageChangeCallback mOnPageChangeCallback = new TranslatorMainActivity$mOnPageChangeCallback$1(this);
    @NotNull
    private final TranslatorMainActivity$mPageAdapter$1 mPageAdapter = new TranslatorMainActivity$mPageAdapter$1(this, getSupportFragmentManager(), getLifecycle());
    @NotNull
    private final Lazy mRecordShareVm$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(TranslatorRecordShareViewModel.class), new TranslatorMainActivity$special$$inlined$viewModels$default$5(this), new TranslatorMainActivity$special$$inlined$viewModels$default$4(this), new TranslatorMainActivity$special$$inlined$viewModels$default$6((Function0) null, this));
    @Nullable
    private TabLayoutMediator mTabLayoutMediator;
    @Nullable
    private NoteBean mTempNoteBean;
    @NotNull
    private final TranslatorMainActivity$mUiUpdateCallback$1 mUiUpdateCallback = new TranslatorMainActivity$mUiUpdateCallback$1(this);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/translation/phone/activity/TranslatorMainActivity$Companion;", "", "()V", "TAG", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final ActivityTranslatorMainBinding getMBinding() {
        return (ActivityTranslatorMainBinding) this.mBinding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final TranslatorMainViewModel getMMainVm() {
        return (TranslatorMainViewModel) this.mMainVm$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final TranslatorRecordShareViewModel getMRecordShareVm() {
        return (TranslatorRecordShareViewModel) this.mRecordShareVm$delegate.getValue();
    }

    private final void handleDiffGlass() {
        if (TranslatorConstants.isAir()) {
            TransFuncItem transFuncItem = getMBinding().m;
            Intrinsics.checkNotNullExpressionValue(transFuncItem, "tfDialogTrans");
            transFuncItem.setVisibility(8);
            TransFuncItem transFuncItem2 = getMBinding().o;
            Intrinsics.checkNotNullExpressionValue(transFuncItem2, "tfTranscribe");
            transFuncItem2.setVisibility(0);
            getMBinding().p.setIconMenu1Visible(false);
            return;
        }
        TransFuncItem transFuncItem3 = getMBinding().m;
        Intrinsics.checkNotNullExpressionValue(transFuncItem3, "tfDialogTrans");
        transFuncItem3.setVisibility(0);
        TransFuncItem transFuncItem4 = getMBinding().o;
        Intrinsics.checkNotNullExpressionValue(transFuncItem4, "tfTranscribe");
        transFuncItem4.setVisibility(8);
        getMBinding().p.setIconMenu1Visible(true);
    }

    private final void handleTransExtState(TranslationState translationState) {
        int extCode = translationState.getExtCode();
        LogExt.j("handleTransExtState " + translationState, TAG);
        if (extCode == 11) {
            getMMainVm().v(R.string.tl_network_off);
        } else if (extCode == 15) {
            MuteAudioHelper.e(translationState);
        } else if (extCode == 18) {
            getMMainVm().v(R.string.tl_toast_server_disconnected);
        } else if (extCode == 23) {
            getMMainVm().v(R.string.tl_in_call);
        } else if (extCode != 24) {
            LogExt.g("handlerExtState 无需处理指令", TAG);
        } else {
            getMMainVm().v(R.string.tl_in_wechat_answer);
        }
        if (translationState.getTransState() == 2 && InterconnectMsgCodExtKt.d(extCode)) {
            updateListView();
        }
    }

    private final void handleTransNormalState(TranslationState translationState) {
        int transState = translationState.getTransState();
        LogExt.j("handleTransNormalState " + translationState, TAG);
        if (transState == 2) {
            updateListView();
        }
    }

    /* access modifiers changed from: private */
    public final void handleTranslateState(TransStateEvent transStateEvent) {
        runOnUiThread(new o(transStateEvent, this));
    }

    /* access modifiers changed from: private */
    public static final void handleTranslateState$lambda$13(TransStateEvent transStateEvent, TranslatorMainActivity translatorMainActivity) {
        Intrinsics.checkNotNullParameter(transStateEvent, "$transStateEvent");
        Intrinsics.checkNotNullParameter(translatorMainActivity, "this$0");
        LogExt.j("handleTranslateState transStateEvent=" + transStateEvent, TAG);
        translatorMainActivity.mTempNoteBean = transStateEvent.getNoteBean();
        TranslationState transState = transStateEvent.getTransState();
        if (transState.getExtCode() == -1) {
            translatorMainActivity.handleTransNormalState(transState);
        } else {
            translatorMainActivity.handleTransExtState(transState);
        }
    }

    /* access modifiers changed from: private */
    public final <T> void handleVariousMsg(OperateMessage<T> operateMessage) {
        runOnUiThread(new e(operateMessage, this));
    }

    /* access modifiers changed from: private */
    public static final void handleVariousMsg$lambda$11(OperateMessage operateMessage, TranslatorMainActivity translatorMainActivity) {
        Intrinsics.checkNotNullParameter(operateMessage, "$operateMessage");
        Intrinsics.checkNotNullParameter(translatorMainActivity, "this$0");
        int type = operateMessage.getType();
        if (type == 7) {
            LogExt.j("眼镜端退出翻译应用", TAG);
            translatorMainActivity.updateListView();
            MuteAudioHelper.d(false, 1, (Object) null);
        } else if (type == 11) {
            LogExt.j("收到眼镜端启动完成消息", TAG);
        } else if (type == 12) {
            LogExt.j("眼镜端静音5分钟弹窗消失", TAG);
            MuteAudioHelper.d(false, 1, (Object) null);
        } else if (type == 101) {
            LogExt.j("眼镜和手机连接成功", TAG);
        } else if (type == 102) {
            LogExt.j("眼镜和手机断开连接", TAG);
            translatorMainActivity.updateListView();
        } else if (type == 1000) {
            LogExt.g("删除翻译记录 DELETE_TRANS_RECORD", TAG);
            if (operateMessage.getOperateObject() instanceof NoteBean) {
                Object operateObject = operateMessage.getOperateObject();
                Intrinsics.checkNotNull(operateObject, "null cannot be cast to non-null type com.upuphone.ar.translation.phone.bean.NoteBean");
                translatorMainActivity.getMMainVm().j((NoteBean) operateObject, translatorMainActivity.getMMainVm().r());
            }
        } else if (type == 1001) {
            LogExt.g("通知是否有翻译记录 NOTIFY_TRANS_RECORDS", TAG);
            if (operateMessage.getOperateObject() instanceof Boolean) {
                Object operateObject2 = operateMessage.getOperateObject();
                Intrinsics.checkNotNull(operateObject2, "null cannot be cast to non-null type kotlin.Boolean");
                translatorMainActivity.notifyTransRecordsUI(((Boolean) operateObject2).booleanValue());
            }
        } else if (type == 1005) {
            LogExt.g("更新翻译记录 UPDATE_TRANS_RECORD", TAG);
            if (operateMessage.getOperateObject() instanceof NoteBean) {
                Object operateObject3 = operateMessage.getOperateObject();
                Intrinsics.checkNotNull(operateObject3, "null cannot be cast to non-null type com.upuphone.ar.translation.phone.bean.NoteBean");
                translatorMainActivity.getMMainVm().B((NoteBean) operateObject3, translatorMainActivity.getMMainVm().r());
            }
        } else if (type != 1006) {
            LogExt.g("handleVariousMsg 无需处理指令[" + type + "]", TAG);
        } else {
            LogExt.j("系统时间改变，刷新翻译记录", TAG);
            translatorMainActivity.getMMainVm().s(translatorMainActivity.getMMainVm().r());
        }
    }

    private final void initListener() {
        TranslationApp.registerUiUpdateCallback$ar_translator_intlRelease(TAG, this.mUiUpdateCallback);
        getMBinding().p.l(new TranslatorMainActivity$initListener$1(this));
        getMBinding().p.r(new TranslatorMainActivity$initListener$2(this));
        getMBinding().p.n(new TranslatorMainActivity$initListener$3(this));
        getMBinding().p.setIconMenu2Visible(AudioDebugHelper.b());
        getMBinding().p.p(new TranslatorMainActivity$initListener$4(this));
        AudioDebugHelper.d(new TranslatorMainActivity$initListener$5(this));
        getMBinding().j.setOnClickListener(new g(this));
        getMBinding().n.setOnClickListener(new h(this));
        getMBinding().o.setOnClickListener(new i(this));
        getMBinding().m.setOnClickListener(new j(this));
        SwitchLangHelper.j(TAG, new k(this));
        getMBinding().q.setOnClickListener(new l(this));
        getMBinding().t.setOnClickListener(new m(this));
        getMBinding().c.setOnClickListener(new n(this));
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "<get-onBackPressedDispatcher>(...)");
        OnBackPressedDispatcherKt.a(onBackPressedDispatcher, this, true, new TranslatorMainActivity$initListener$14(this));
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$0(TranslatorMainActivity translatorMainActivity, View view) {
        Intrinsics.checkNotNullParameter(translatorMainActivity, "this$0");
        PreferencesUtils.y(false);
        ConstraintLayout constraintLayout = translatorMainActivity.getMBinding().e;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "clTelephoneUserTip");
        constraintLayout.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$1(TranslatorMainActivity translatorMainActivity, View view) {
        Intrinsics.checkNotNullParameter(translatorMainActivity, "this$0");
        translatorMainActivity.startTransFuncActivity(2);
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$2(TranslatorMainActivity translatorMainActivity, View view) {
        Intrinsics.checkNotNullParameter(translatorMainActivity, "this$0");
        translatorMainActivity.startTransFuncActivity(1);
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$3(TranslatorMainActivity translatorMainActivity, View view) {
        Intrinsics.checkNotNullParameter(translatorMainActivity, "this$0");
        translatorMainActivity.startTransFuncActivity(3);
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$4(TranslatorMainActivity translatorMainActivity, int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(translatorMainActivity, "this$0");
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(str2, "dst");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(translatorMainActivity), (CoroutineContext) null, (CoroutineStart) null, new TranslatorMainActivity$initListener$10$1(i, str, str2, translatorMainActivity, (Continuation<? super TranslatorMainActivity$initListener$10$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$5(TranslatorMainActivity translatorMainActivity, View view) {
        Intrinsics.checkNotNullParameter(translatorMainActivity, "this$0");
        translatorMainActivity.getMRecordShareVm().n(false);
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$6(TranslatorMainActivity translatorMainActivity, View view) {
        Intrinsics.checkNotNullParameter(translatorMainActivity, "this$0");
        translatorMainActivity.getMRecordShareVm().q();
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$8(TranslatorMainActivity translatorMainActivity, View view) {
        Intrinsics.checkNotNullParameter(translatorMainActivity, "this$0");
        List list = (List) translatorMainActivity.getMRecordShareVm().k().getValue();
        if (list != null && !list.isEmpty()) {
            translatorMainActivity.getMMainVm().x(translatorMainActivity, list.size());
        }
    }

    private final void initTabLayout() {
        getMBinding().x.setOffscreenPageLimit(2);
        getMBinding().x.setAdapter(this.mPageAdapter);
        getMBinding().x.g(this.mOnPageChangeCallback);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(getMBinding().l, getMBinding().x, new f(this));
        this.mTabLayoutMediator = tabLayoutMediator;
        tabLayoutMediator.attach();
        Integer num = (Integer) getMMainVm().n().getValue();
        if (num != null) {
            LogExt.j("mRecordTabPosition position=" + num, TAG);
            getMBinding().x.j(num.intValue(), false);
        }
        TabLayout tabLayout = getMBinding().l;
        Intrinsics.checkNotNullExpressionValue(tabLayout, "tbRecords");
        tabLayout.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public static final void initTabLayout$lambda$9(TranslatorMainActivity translatorMainActivity, TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(translatorMainActivity, "this$0");
        Intrinsics.checkNotNullParameter(tab, "tab");
        TablayoutCustomTabBinding c = TablayoutCustomTabBinding.c(translatorMainActivity.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        c.b.setText(((RecordTabBean) translatorMainActivity.getMMainVm().r().get(i)).getTabName());
        tab.setCustomView((View) c.getRoot());
    }

    private final void initView() {
        LogExt.j("[initView] 翻译官首页", TAG);
        TranslationApp.setActivityOn$ar_translator_intlRelease(true);
        TranslationApp.initService$ar_translator_intlRelease$default(this, (Function0) null, 2, (Object) null);
        handleDiffGlass();
        initTabLayout();
        getMMainVm().y();
        getMMainVm().A();
        EventTrackingHelper.f6200a.b(new ClickEvent(1, 0, 2, (DefaultConstructorMarker) null));
    }

    private final void initViewModels() {
        getMMainVm().p().observe(this, new TranslatorMainActivity$sam$androidx_lifecycle_Observer$0(new TranslatorMainActivity$initViewModels$1(this)));
        getMMainVm().q().observe(this, new TranslatorMainActivity$sam$androidx_lifecycle_Observer$0(new TranslatorMainActivity$initViewModels$2(this)));
        getMRecordShareVm().h().observe(this, new TranslatorMainActivity$sam$androidx_lifecycle_Observer$0(new TranslatorMainActivity$initViewModels$3(this)));
        getMRecordShareVm().j().observe(this, new TranslatorMainActivity$sam$androidx_lifecycle_Observer$0(new TranslatorMainActivity$initViewModels$4(this)));
        getMRecordShareVm().k().observe(this, new TranslatorMainActivity$sam$androidx_lifecycle_Observer$0(new TranslatorMainActivity$initViewModels$5(this)));
        getMMainVm().m().observe(this, new TranslatorMainActivity$sam$androidx_lifecycle_Observer$0(new TranslatorMainActivity$initViewModels$6(this)));
    }

    private final void notifyTransRecordsUI(boolean z) {
        LogExt.j("notifyTransRecordsUI NOTIFY_TRANS_RECORDS=" + z, TAG);
        TabLayout tabLayout = getMBinding().l;
        Intrinsics.checkNotNullExpressionValue(tabLayout, "tbRecords");
        int i = 8;
        tabLayout.setVisibility(z ? 0 : 8);
        ViewPager2 viewPager2 = getMBinding().x;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "vpRecords");
        viewPager2.setVisibility(z ? 0 : 8);
        LinearLayout linearLayout = getMBinding().k;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "llNoData");
        if (!z) {
            i = 0;
        }
        linearLayout.setVisibility(i);
        ViewGroup.LayoutParams layoutParams = getMBinding().f.getLayoutParams();
        if (layoutParams != null) {
            LogExt.j("notifyTransRecordsUI layoutParams=" + layoutParams, TAG);
            if (layoutParams instanceof AppBarLayout.LayoutParams) {
                if (z) {
                    AppBarLayout.LayoutParams layoutParams2 = (AppBarLayout.LayoutParams) layoutParams;
                    if (layoutParams2.getScrollFlags() != 1) {
                        layoutParams2.setScrollFlags(1);
                        return;
                    }
                    return;
                }
                AppBarLayout.LayoutParams layoutParams3 = (AppBarLayout.LayoutParams) layoutParams;
                if (layoutParams3.getScrollFlags() != 0) {
                    layoutParams3.setScrollFlags(0);
                }
            }
        }
    }

    private final void startTransFuncActivity(int i) {
        Intent intent = new Intent(this, TranslatorStartActivity.class);
        intent.putExtra(TranslatorStartActivity.TRANS_TYPE_KEY, i);
        startActivity(intent);
    }

    private final void updateListView() {
        NoteBean j = NoteSyncHelper.j();
        boolean z = false;
        boolean z2 = j != null;
        if (this.mTempNoteBean != null) {
            z = true;
        }
        LogExt.g("updateListView noteBean not null=" + z2 + " ,mTempNoteBean not null=" + z, TAG);
        if (j != null) {
            getMMainVm().h(j, getMMainVm().r());
            this.mTempNoteBean = null;
            return;
        }
        NoteBean noteBean = this.mTempNoteBean;
        if (noteBean != null) {
            getMMainVm().h(noteBean, getMMainVm().r());
            this.mTempNoteBean = null;
        }
    }

    /* access modifiers changed from: private */
    public final void updateTransFuncLang() {
        getMBinding().n.g(ContextExtKt.L(this, 2), 1);
        TransFuncItem transFuncItem = getMBinding().o;
        Intrinsics.checkNotNullExpressionValue(transFuncItem, "tfTranscribe");
        TransFuncItem.h(transFuncItem, ContextExtKt.J(this), 0, 2, (Object) null);
        getMBinding().m.g(ContextExtKt.L(this, 3), 2);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) getMBinding().getRoot());
        initView();
        initListener();
        initViewModels();
    }

    public void onDestroy() {
        super.onDestroy();
        LogExt.j("[onDestroy] 翻译官首页", TAG);
        getMBinding().x.n(this.mOnPageChangeCallback);
        TabLayoutMediator tabLayoutMediator = this.mTabLayoutMediator;
        if (tabLayoutMediator != null) {
            tabLayoutMediator.detach();
        }
        this.mTempNoteBean = null;
        AudioDebugHelper.C();
        TranslationApp.unRegisterUiUpdateCallback$ar_translator_intlRelease(TAG);
        TranslationApp.clearUiUpdateCallback$ar_translator_intlRelease();
        SwitchLangHelper.A(TAG);
        SwitchLangHelper.f6304a.a();
        TranslationApp.setActivityOn$ar_translator_intlRelease(false);
        TranslationApp.unInitService$ar_translator_intlRelease();
        TranslationApp.clearActivity$ar_translator_intlRelease();
    }

    public void onResume() {
        super.onResume();
        updateTransFuncLang();
        getMMainVm().y();
    }
}
