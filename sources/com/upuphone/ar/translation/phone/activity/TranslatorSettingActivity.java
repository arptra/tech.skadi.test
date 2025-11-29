package com.upuphone.ar.translation.phone.activity;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import com.honey.account.d5.a0;
import com.honey.account.d5.b0;
import com.honey.account.d5.c0;
import com.honey.account.d5.d0;
import com.honey.account.d5.e0;
import com.honey.account.d5.f0;
import com.honey.account.d5.u;
import com.honey.account.d5.v;
import com.honey.account.d5.w;
import com.honey.account.d5.x;
import com.honey.account.d5.y;
import com.honey.account.d5.z;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.DialogExtKt;
import com.upuphone.ar.translation.ext.InterconnectMsgCodExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.TranslationManager;
import com.upuphone.ar.translation.phone.adapter.BroadcastAudioTypeAdapter;
import com.upuphone.ar.translation.phone.databinding.ActivityTranslatorSettingBinding;
import com.upuphone.ar.translation.phone.databinding.LayoutTlDialogCustomTitleBinding;
import com.upuphone.ar.translation.phone.helper.InterConnectHelper;
import com.upuphone.ar.translation.phone.helper.NoteSyncHelper;
import com.upuphone.ar.translation.phone.helper.RunningRecordHelper;
import com.upuphone.ar.translation.phone.view.TransSettingItem;
import com.upuphone.ar.translation.phone.view.TransSubtitleCard;
import com.upuphone.ar.translation.phone.vm.TranslatorSettingsViewModel;
import com.upuphone.ar.translation.utils.PreferencesUtils;
import com.upuphone.xr.sapp.context.SdkContext;
import flyme.support.v7.app.AlertDialog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 52\u00020\u0001:\u00015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\b\u0010\u001d\u001a\u00020\u0013H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\u0012\u0010$\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\b\u0010'\u001a\u00020\u001fH\u0014J\b\u0010(\u001a\u00020\u001fH\u0014J\u0018\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u000eH\u0002J\u0010\u0010/\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u000eH\u0002J\u0010\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u000eH\u0002J\b\u00102\u001a\u00020\u001fH\u0002J\u0012\u00103\u001a\u00020\u001f2\b\b\u0002\u0010*\u001a\u00020\u000eH\u0002J\b\u00104\u001a\u00020\u001fH\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u0018\u0010\u0019¨\u00066"}, d2 = {"Lcom/upuphone/ar/translation/phone/activity/TranslatorSettingActivity;", "Lcom/upuphone/ar/translation/phone/activity/TranslatorBaseActivity;", "()V", "locationPermissions", "", "", "[Ljava/lang/String;", "mBinding", "Lcom/upuphone/ar/translation/phone/databinding/ActivityTranslatorSettingBinding;", "getMBinding", "()Lcom/upuphone/ar/translation/phone/databinding/ActivityTranslatorSettingBinding;", "mBinding$delegate", "Lkotlin/Lazy;", "mCallAudio", "", "mLastTranslateModeType", "mMyselfAudioType", "mOtherAudioType", "mSingleSelectDialog", "Lflyme/support/v7/app/AlertDialog;", "mTempMyselfAudioType", "mTempOtherAudioType", "mTranslatorSettingsVm", "Lcom/upuphone/ar/translation/phone/vm/TranslatorSettingsViewModel;", "getMTranslatorSettingsVm", "()Lcom/upuphone/ar/translation/phone/vm/TranslatorSettingsViewModel;", "mTranslatorSettingsVm$delegate", "createBroadcastAudioMyselfDialog", "createBroadcastAudioOtherDialog", "createCallAudioDialog", "handleDisplaySettingsItem", "", "handleSubtitleCardContent", "initListener", "initStatus", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "selectOtherSub", "type", "isSend", "", "setAudioTypeMyselfStr", "audioType", "setAudioTypeOtherStr", "setCallAudioStr", "callAudio", "showLocationReminder", "singleSelectDialog", "updateRoleVprint", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTranslatorSettingActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranslatorSettingActivity.kt\ncom/upuphone/ar/translation/phone/activity/TranslatorSettingActivity\n+ 2 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,604:1\n75#2,13:605\n262#3,2:618\n262#3,2:620\n262#3,2:622\n262#3,2:624\n262#3,2:626\n262#3,2:628\n262#3,2:630\n262#3,2:632\n*S KotlinDebug\n*F\n+ 1 TranslatorSettingActivity.kt\ncom/upuphone/ar/translation/phone/activity/TranslatorSettingActivity\n*L\n61#1:605,13\n244#1:618,2\n247#1:620,2\n248#1:622,2\n249#1:624,2\n251#1:626,2\n252#1:628,2\n253#1:630,2\n254#1:632,2\n*E\n"})
public final class TranslatorSettingActivity extends TranslatorBaseActivity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DIALOG_BROADCAST_AUDIO_TYPE_MYSELF = 2;
    private static final int DIALOG_BROADCAST_AUDIO_TYPE_OTHER = 3;
    private static final int DIALOG_CALL_AUDIO_CONTENT = 1;
    @NotNull
    private static final String TAG = "TranslatorSettingActivity";
    /* access modifiers changed from: private */
    @NotNull
    public final String[] locationPermissions = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    @NotNull
    private final Lazy mBinding$delegate = LazyKt.lazy(new TranslatorSettingActivity$mBinding$2(this));
    /* access modifiers changed from: private */
    public int mCallAudio;
    private int mLastTranslateModeType;
    /* access modifiers changed from: private */
    public int mMyselfAudioType;
    /* access modifiers changed from: private */
    public int mOtherAudioType;
    @Nullable
    private AlertDialog mSingleSelectDialog;
    private int mTempMyselfAudioType;
    private int mTempOtherAudioType;
    @NotNull
    private final Lazy mTranslatorSettingsVm$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(TranslatorSettingsViewModel.class), new TranslatorSettingActivity$special$$inlined$viewModels$default$2(this), new TranslatorSettingActivity$special$$inlined$viewModels$default$1(this), new TranslatorSettingActivity$special$$inlined$viewModels$default$3((Function0) null, this));

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/ar/translation/phone/activity/TranslatorSettingActivity$Companion;", "", "()V", "DIALOG_BROADCAST_AUDIO_TYPE_MYSELF", "", "DIALOG_BROADCAST_AUDIO_TYPE_OTHER", "DIALOG_CALL_AUDIO_CONTENT", "TAG", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final AlertDialog createBroadcastAudioMyselfDialog() {
        this.mTempMyselfAudioType = this.mMyselfAudioType;
        String[] stringArray = getResources().getStringArray(R.array.call_broadcast_audio_type);
        Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
        BroadcastAudioTypeAdapter broadcastAudioTypeAdapter = new BroadcastAudioTypeAdapter(this, stringArray, TranslatorConstants.isIntlVersion());
        BroadcastAudioTypeAdapter.b(broadcastAudioTypeAdapter, getMTranslatorSettingsVm().f(this.mMyselfAudioType), 0, 2, (Object) null);
        LayoutTlDialogCustomTitleBinding c = LayoutTlDialogCustomTitleBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        c.c.setText(R.string.tl_telephone_trans_setting_broadcast_myself);
        AlertDialog create = new AlertDialog.Builder(this).setPositiveButton(R.string.tl_finish, (DialogInterface.OnClickListener) new u(this)).setSingleChoiceItems((ListAdapter) broadcastAudioTypeAdapter, getMTranslatorSettingsVm().f(this.mMyselfAudioType), (DialogInterface.OnClickListener) new x(broadcastAudioTypeAdapter, this)).setOnDismissListener(new y(this)).create();
        create.getListView().setSelector(new ColorDrawable(getColor(R.color.transparent)));
        Intrinsics.checkNotNull(create);
        DialogExtKt.a(create);
        create.setCustomTitle(c.getRoot());
        Intrinsics.checkNotNullExpressionValue(create, "apply(...)");
        return create;
    }

    /* access modifiers changed from: private */
    public static final void createBroadcastAudioMyselfDialog$lambda$6(TranslatorSettingActivity translatorSettingActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(translatorSettingActivity, "this$0");
        int i2 = translatorSettingActivity.mTempMyselfAudioType;
        translatorSettingActivity.mMyselfAudioType = i2;
        translatorSettingActivity.setAudioTypeMyselfStr(i2);
        PreferencesUtils.u(translatorSettingActivity.mMyselfAudioType);
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void createBroadcastAudioMyselfDialog$lambda$7(BroadcastAudioTypeAdapter broadcastAudioTypeAdapter, TranslatorSettingActivity translatorSettingActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(broadcastAudioTypeAdapter, "$singleAdapter");
        Intrinsics.checkNotNullParameter(translatorSettingActivity, "this$0");
        LogExt.j("BroadcastAudioMyself choice=" + i, TAG);
        broadcastAudioTypeAdapter.a(i, 1);
        broadcastAudioTypeAdapter.notifyDataSetChanged();
        translatorSettingActivity.mTempMyselfAudioType = translatorSettingActivity.getMTranslatorSettingsVm().h(i);
        translatorSettingActivity.getMTranslatorSettingsVm().n(translatorSettingActivity.mTempMyselfAudioType, new TranslatorSettingActivity$createBroadcastAudioMyselfDialog$2$1(broadcastAudioTypeAdapter, i));
    }

    /* access modifiers changed from: private */
    public static final void createBroadcastAudioMyselfDialog$lambda$8(TranslatorSettingActivity translatorSettingActivity, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(translatorSettingActivity, "this$0");
        translatorSettingActivity.getMTranslatorSettingsVm().r();
    }

    private final AlertDialog createBroadcastAudioOtherDialog() {
        this.mTempOtherAudioType = this.mOtherAudioType;
        String[] stringArray = getResources().getStringArray(R.array.call_broadcast_audio_type);
        Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
        BroadcastAudioTypeAdapter broadcastAudioTypeAdapter = new BroadcastAudioTypeAdapter(this, stringArray, TranslatorConstants.isIntlVersion());
        BroadcastAudioTypeAdapter.b(broadcastAudioTypeAdapter, getMTranslatorSettingsVm().f(this.mOtherAudioType), 0, 2, (Object) null);
        LayoutTlDialogCustomTitleBinding c = LayoutTlDialogCustomTitleBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        c.c.setText(R.string.tl_telephone_trans_setting_broadcast_other);
        AlertDialog create = new AlertDialog.Builder(this).setPositiveButton(R.string.tl_finish, (DialogInterface.OnClickListener) new f0(this)).setSingleChoiceItems((ListAdapter) broadcastAudioTypeAdapter, getMTranslatorSettingsVm().f(this.mOtherAudioType), (DialogInterface.OnClickListener) new v(broadcastAudioTypeAdapter, this)).setOnDismissListener(new w(this)).create();
        create.getListView().setSelector(new ColorDrawable(getColor(R.color.transparent)));
        Intrinsics.checkNotNull(create);
        DialogExtKt.a(create);
        create.setCustomTitle(c.getRoot());
        Intrinsics.checkNotNullExpressionValue(create, "apply(...)");
        return create;
    }

    /* access modifiers changed from: private */
    public static final void createBroadcastAudioOtherDialog$lambda$11(TranslatorSettingActivity translatorSettingActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(translatorSettingActivity, "this$0");
        int i2 = translatorSettingActivity.mTempOtherAudioType;
        translatorSettingActivity.mOtherAudioType = i2;
        translatorSettingActivity.setAudioTypeOtherStr(i2);
        PreferencesUtils.v(translatorSettingActivity.mOtherAudioType);
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void createBroadcastAudioOtherDialog$lambda$12(BroadcastAudioTypeAdapter broadcastAudioTypeAdapter, TranslatorSettingActivity translatorSettingActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(broadcastAudioTypeAdapter, "$singleAdapter");
        Intrinsics.checkNotNullParameter(translatorSettingActivity, "this$0");
        LogExt.j("BroadcastAudioOther choice=" + i, TAG);
        broadcastAudioTypeAdapter.a(i, 1);
        broadcastAudioTypeAdapter.notifyDataSetChanged();
        translatorSettingActivity.mTempOtherAudioType = translatorSettingActivity.getMTranslatorSettingsVm().h(i);
        translatorSettingActivity.getMTranslatorSettingsVm().n(translatorSettingActivity.mTempOtherAudioType, new TranslatorSettingActivity$createBroadcastAudioOtherDialog$2$1(broadcastAudioTypeAdapter, i));
    }

    /* access modifiers changed from: private */
    public static final void createBroadcastAudioOtherDialog$lambda$13(TranslatorSettingActivity translatorSettingActivity, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(translatorSettingActivity, "this$0");
        translatorSettingActivity.getMTranslatorSettingsVm().r();
    }

    private final AlertDialog createCallAudioDialog() {
        LayoutTlDialogCustomTitleBinding c = LayoutTlDialogCustomTitleBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        c.c.setText(R.string.tl_telephone_trans_setting_call_audio_title);
        AlertDialog create = new AlertDialog.Builder(this).setSingleChoiceItems(R.array.call_audio_content, getMTranslatorSettingsVm().j(this.mCallAudio), (DialogInterface.OnClickListener) new d0(this)).setNegativeButton(R.string.tl_dialog_cancel, (DialogInterface.OnClickListener) new e0()).create();
        Intrinsics.checkNotNull(create);
        DialogExtKt.a(create);
        create.setCustomTitle(c.getRoot());
        Intrinsics.checkNotNullExpressionValue(create, "apply(...)");
        return create;
    }

    /* access modifiers changed from: private */
    public static final void createCallAudioDialog$lambda$2(TranslatorSettingActivity translatorSettingActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(translatorSettingActivity, "this$0");
        LogExt.j("CallAudioContent choice=" + i, TAG);
        int l = translatorSettingActivity.getMTranslatorSettingsVm().l(i);
        translatorSettingActivity.mCallAudio = l;
        translatorSettingActivity.setCallAudioStr(l);
        PreferencesUtils.w(translatorSettingActivity.mCallAudio);
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void createCallAudioDialog$lambda$3(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public final ActivityTranslatorSettingBinding getMBinding() {
        return (ActivityTranslatorSettingBinding) this.mBinding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final TranslatorSettingsViewModel getMTranslatorSettingsVm() {
        return (TranslatorSettingsViewModel) this.mTranslatorSettingsVm$delegate.getValue();
    }

    private final void handleDisplaySettingsItem() {
        if (TranslatorConstants.isAirPro()) {
            TextView textView = getMBinding().o;
            Intrinsics.checkNotNullExpressionValue(textView, "tvSettingsGeneral");
            textView.setVisibility(0);
            TransSettingItem transSettingItem = getMBinding().n;
            Intrinsics.checkNotNullExpressionValue(transSettingItem, "tsiVprint");
            transSettingItem.setVisibility(8);
            TransSettingItem transSettingItem2 = getMBinding().i;
            Intrinsics.checkNotNullExpressionValue(transSettingItem2, "tsiGeoLocation");
            transSettingItem2.setVisibility(0);
            Group group = getMBinding().e;
            Intrinsics.checkNotNullExpressionValue(group, "gpTelephoneTrans");
            group.setVisibility(0);
            return;
        }
        TextView textView2 = getMBinding().o;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvSettingsGeneral");
        textView2.setVisibility(8);
        TransSettingItem transSettingItem3 = getMBinding().n;
        Intrinsics.checkNotNullExpressionValue(transSettingItem3, "tsiVprint");
        transSettingItem3.setVisibility(8);
        TransSettingItem transSettingItem4 = getMBinding().i;
        Intrinsics.checkNotNullExpressionValue(transSettingItem4, "tsiGeoLocation");
        transSettingItem4.setVisibility(8);
        Group group2 = getMBinding().e;
        Intrinsics.checkNotNullExpressionValue(group2, "gpTelephoneTrans");
        group2.setVisibility(8);
    }

    private final void handleSubtitleCardContent() {
        if (TranslatorConstants.isIntlVersion()) {
            TransSubtitleCard transSubtitleCard = getMBinding().d;
            String string = getString(R.string.tl_setting_hello_fr);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = getString(R.string.tl_setting_hello_en);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            transSubtitleCard.g(string, string2);
            TransSubtitleCard transSubtitleCard2 = getMBinding().c;
            String string3 = getString(R.string.tl_setting_hello_fr);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            String string4 = getString(R.string.tl_setting_hello_en);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            transSubtitleCard2.g(string3, string4);
            return;
        }
        TransSubtitleCard transSubtitleCard3 = getMBinding().d;
        String string5 = getString(R.string.tl_setting_hello_en);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        String string6 = getString(R.string.tl_setting_hello_cn);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        transSubtitleCard3.g(string5, string6);
        TransSubtitleCard transSubtitleCard4 = getMBinding().c;
        String string7 = getString(R.string.tl_setting_hello_en);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        String string8 = getString(R.string.tl_setting_hello_cn);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        transSubtitleCard4.g(string7, string8);
    }

    private final void initListener() {
        getMBinding().f.l(new TranslatorSettingActivity$initListener$1(this));
        TransSettingItem transSettingItem = getMBinding().k;
        Intrinsics.checkNotNullExpressionValue(transSettingItem, "tsiRecord");
        TransSettingItem.o(transSettingItem, TranslatorSettingActivity$initListener$2.INSTANCE, (Function0) null, 2, (Object) null);
        TransSettingItem transSettingItem2 = getMBinding().i;
        Intrinsics.checkNotNullExpressionValue(transSettingItem2, "tsiGeoLocation");
        TransSettingItem.o(transSettingItem2, new TranslatorSettingActivity$initListener$3(this), (Function0) null, 2, (Object) null);
        TransSettingItem transSettingItem3 = getMBinding().h;
        Intrinsics.checkNotNullExpressionValue(transSettingItem3, "tsiCallTransTip");
        TransSettingItem.o(transSettingItem3, TranslatorSettingActivity$initListener$4.INSTANCE, (Function0) null, 2, (Object) null);
        TransSettingItem transSettingItem4 = getMBinding().g;
        Intrinsics.checkNotNullExpressionValue(transSettingItem4, "tsiCallAudio");
        TransSettingItem.o(transSettingItem4, (Function1) null, new TranslatorSettingActivity$initListener$5(this), 1, (Object) null);
        TransSettingItem transSettingItem5 = getMBinding().l;
        Intrinsics.checkNotNullExpressionValue(transSettingItem5, "tsiVoiceMyself");
        TransSettingItem.o(transSettingItem5, (Function1) null, new TranslatorSettingActivity$initListener$6(this), 1, (Object) null);
        TransSettingItem transSettingItem6 = getMBinding().m;
        Intrinsics.checkNotNullExpressionValue(transSettingItem6, "tsiVoiceOther");
        TransSettingItem.o(transSettingItem6, (Function1) null, new TranslatorSettingActivity$initListener$7(this), 1, (Object) null);
        TransSettingItem transSettingItem7 = getMBinding().n;
        Intrinsics.checkNotNullExpressionValue(transSettingItem7, "tsiVprint");
        TransSettingItem.o(transSettingItem7, (Function1) null, new TranslatorSettingActivity$initListener$8(this), 1, (Object) null);
        TransSettingItem transSettingItem8 = getMBinding().j;
        Intrinsics.checkNotNullExpressionValue(transSettingItem8, "tsiOnlyOther");
        TransSettingItem.o(transSettingItem8, TranslatorSettingActivity$initListener$9.INSTANCE, (Function0) null, 2, (Object) null);
        getMBinding().c.setOnClickListener(new b0(this));
        getMBinding().d.setOnClickListener(new c0(this));
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$0(TranslatorSettingActivity translatorSettingActivity, View view) {
        Intrinsics.checkNotNullParameter(translatorSettingActivity, "this$0");
        translatorSettingActivity.selectOtherSub(3, true);
    }

    /* access modifiers changed from: private */
    public static final void initListener$lambda$1(TranslatorSettingActivity translatorSettingActivity, View view) {
        Intrinsics.checkNotNullParameter(translatorSettingActivity, "this$0");
        translatorSettingActivity.selectOtherSub(4, true);
    }

    private final void initStatus() {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TranslatorSettingActivity$initStatus$1(this, (Continuation<? super TranslatorSettingActivity$initStatus$1>) null), 3, (Object) null);
    }

    private final void initView() {
        handleDisplaySettingsItem();
        handleSubtitleCardContent();
    }

    /* access modifiers changed from: private */
    public final void selectOtherSub(int i, boolean z) {
        if (this.mLastTranslateModeType == i) {
            String h = InterconnectMsgCodExtKt.h(i);
            LogExt.j("selectOtherSub 设置的相同类型的字幕设置" + h, TAG);
            return;
        }
        String h2 = InterconnectMsgCodExtKt.h(i);
        LogExt.j("selectOtherSub type" + h2 + " " + i, TAG);
        if (i == 3) {
            getMBinding().c.setCardSelected(true);
            getMBinding().d.setCardSelected(false);
        } else {
            getMBinding().c.setCardSelected(false);
            getMBinding().d.setCardSelected(true);
        }
        if (z) {
            InterConnectHelper.Companion companion = InterConnectHelper.c;
            if (companion.a().j()) {
                companion.a().A(i);
            }
        }
        PreferencesUtils.B(i);
        NoteSyncHelper.z(i);
        RunningRecordHelper o = TranslationManager.q.a().o();
        if (o != null) {
            o.o();
        }
        this.mLastTranslateModeType = i;
    }

    /* access modifiers changed from: private */
    public final void setAudioTypeMyselfStr(int i) {
        getMBinding().l.setSettingContent(getMTranslatorSettingsVm().g(i));
    }

    /* access modifiers changed from: private */
    public final void setAudioTypeOtherStr(int i) {
        getMBinding().m.setSettingContent(getMTranslatorSettingsVm().g(i));
    }

    /* access modifiers changed from: private */
    public final void setCallAudioStr(int i) {
        getMBinding().g.setSettingContent(getMTranslatorSettingsVm().k(i));
    }

    /* access modifiers changed from: private */
    public final void showLocationReminder() {
        LayoutTlDialogCustomTitleBinding c = LayoutTlDialogCustomTitleBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        c.c.setText(R.string.tl_setting_geo_location_compliance_reminder);
        AlertDialog create = new AlertDialog.Builder(this).setPositiveButton(R.string.tl_turn_on, (DialogInterface.OnClickListener) new z(this)).setNegativeButton(R.string.tl_refuse, (DialogInterface.OnClickListener) new a0(this)).create();
        getMBinding().i.setSettingChecked(false);
        Intrinsics.checkNotNull(create);
        DialogExtKt.a(create);
        create.setCustomTitle(c.getRoot());
        create.show();
    }

    /* access modifiers changed from: private */
    public static final void showLocationReminder$lambda$15(TranslatorSettingActivity translatorSettingActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(translatorSettingActivity, "this$0");
        SdkContext sdkContext = SdkContext.f6675a;
        if (sdkContext.f().a(translatorSettingActivity.locationPermissions)) {
            translatorSettingActivity.getMBinding().i.setSettingChecked(true);
            PreferencesUtils.z(true);
            return;
        }
        sdkContext.f().c(translatorSettingActivity, translatorSettingActivity.locationPermissions, true, new TranslatorSettingActivity$showLocationReminder$1$1(translatorSettingActivity));
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void showLocationReminder$lambda$16(TranslatorSettingActivity translatorSettingActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(translatorSettingActivity, "this$0");
        translatorSettingActivity.getMBinding().i.setSettingChecked(false);
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public final void singleSelectDialog(int i) {
        AlertDialog createCallAudioDialog = i != 1 ? i != 2 ? i != 3 ? createCallAudioDialog() : createBroadcastAudioOtherDialog() : createBroadcastAudioMyselfDialog() : createCallAudioDialog();
        this.mSingleSelectDialog = createCallAudioDialog;
        if (createCallAudioDialog != null) {
            createCallAudioDialog.show();
        }
    }

    public static /* synthetic */ void singleSelectDialog$default(TranslatorSettingActivity translatorSettingActivity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        translatorSettingActivity.singleSelectDialog(i);
    }

    private final void updateRoleVprint() {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TranslatorSettingActivity$updateRoleVprint$1(this, (Continuation<? super TranslatorSettingActivity$updateRoleVprint$1>) null), 3, (Object) null);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) getMBinding().getRoot());
        initView();
        initListener();
        initStatus();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mLastTranslateModeType = 0;
        AlertDialog alertDialog = this.mSingleSelectDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.mSingleSelectDialog = null;
        this.mCallAudio = 0;
        this.mMyselfAudioType = 0;
        this.mTempMyselfAudioType = 0;
        this.mOtherAudioType = 0;
        this.mTempOtherAudioType = 0;
    }

    public void onResume() {
        super.onResume();
        updateRoleVprint();
    }
}
