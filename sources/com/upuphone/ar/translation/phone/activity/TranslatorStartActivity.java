package com.upuphone.ar.translation.phone.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.upuphone.ar.translation.eventtrack.EventTrackingHelper;
import com.upuphone.ar.translation.eventtrack.event.ClickEvent;
import com.upuphone.ar.translation.ext.InterconnectMsgCodExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.databinding.ActivityTransStartBinding;
import com.upuphone.ar.translation.phone.fragment.DialogueTranslationFragment;
import com.upuphone.ar.translation.phone.fragment.SimulTranslationFragment;
import com.upuphone.ar.translation.phone.fragment.SpeechTranscribeFragment;
import com.upuphone.ar.translation.phone.view.TransTitleBar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/upuphone/ar/translation/phone/activity/TranslatorStartActivity;", "Lcom/upuphone/ar/translation/phone/activity/TranslatorBaseActivity;", "()V", "mBinding", "Lcom/upuphone/ar/translation/phone/databinding/ActivityTransStartBinding;", "mTransPageType", "", "addDialogueTranslation", "", "addSimulTranslation", "addTranscribe", "initData", "initListener", "initTransLayout", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "reportClickTrans", "status", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TranslatorStartActivity extends TranslatorBaseActivity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "TranslatorStartActivity";
    @NotNull
    private static final String TAG_DIALOGUE_FRAGMENT = "DialogueFragment";
    @NotNull
    private static final String TAG_SIMUL_FRAGMENT = "SimulFragment";
    @NotNull
    private static final String TAG_TRANSCRIBE_FRAGMENT = "TranscribeFragment";
    @NotNull
    public static final String TRANS_TYPE_KEY = "transType";
    private ActivityTransStartBinding mBinding;
    private int mTransPageType = 2;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/ar/translation/phone/activity/TranslatorStartActivity$Companion;", "", "()V", "TAG", "", "TAG_DIALOGUE_FRAGMENT", "TAG_SIMUL_FRAGMENT", "TAG_TRANSCRIBE_FRAGMENT", "TRANS_TYPE_KEY", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void addDialogueTranslation() {
        DialogueTranslationFragment a2 = DialogueTranslationFragment.r.a();
        FragmentTransaction s = getSupportFragmentManager().s();
        Intrinsics.checkNotNullExpressionValue(s, "beginTransaction(...)");
        if (getSupportFragmentManager().p0(TAG_DIALOGUE_FRAGMENT) == null) {
            s.u(R.id.fragment_container, a2, TAG_DIALOGUE_FRAGMENT);
        }
        s.j();
        reportClickTrans(9);
    }

    private final void addSimulTranslation() {
        SimulTranslationFragment a2 = SimulTranslationFragment.m.a();
        FragmentTransaction s = getSupportFragmentManager().s();
        Intrinsics.checkNotNullExpressionValue(s, "beginTransaction(...)");
        if (getSupportFragmentManager().p0(TAG_SIMUL_FRAGMENT) == null) {
            s.u(R.id.fragment_container, a2, TAG_SIMUL_FRAGMENT);
        }
        s.j();
        reportClickTrans(2);
    }

    private final void addTranscribe() {
        SpeechTranscribeFragment a2 = SpeechTranscribeFragment.j.a();
        FragmentTransaction s = getSupportFragmentManager().s();
        Intrinsics.checkNotNullExpressionValue(s, "beginTransaction(...)");
        if (getSupportFragmentManager().p0(TAG_TRANSCRIBE_FRAGMENT) == null) {
            s.u(R.id.fragment_container, a2, TAG_TRANSCRIBE_FRAGMENT);
        }
        s.j();
        reportClickTrans(5);
    }

    private final void initData() {
        initTransLayout();
    }

    private final void initListener() {
        ActivityTransStartBinding activityTransStartBinding = this.mBinding;
        if (activityTransStartBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            activityTransStartBinding = null;
        }
        activityTransStartBinding.c.l(new TranslatorStartActivity$initListener$1(this));
    }

    private final void initTransLayout() {
        Intent intent = getIntent();
        int intExtra = intent != null ? intent.getIntExtra(TRANS_TYPE_KEY, 2) : 2;
        this.mTransPageType = intExtra;
        String k = InterconnectMsgCodExtKt.k(intExtra);
        LogExt.j("initTransLayout pageType=" + k, TAG);
        int i = this.mTransPageType;
        ActivityTransStartBinding activityTransStartBinding = null;
        if (i == 1) {
            ActivityTransStartBinding activityTransStartBinding2 = this.mBinding;
            if (activityTransStartBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                activityTransStartBinding = activityTransStartBinding2;
            }
            TransTitleBar transTitleBar = activityTransStartBinding.c;
            String string = getString(R.string.tl_speech_transcribe);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            transTitleBar.setBarTitle(string);
            addTranscribe();
        } else if (i != 2) {
            ActivityTransStartBinding activityTransStartBinding3 = this.mBinding;
            if (activityTransStartBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                activityTransStartBinding = activityTransStartBinding3;
            }
            TransTitleBar transTitleBar2 = activityTransStartBinding.c;
            String string2 = getString(R.string.tl_dialogue_trans);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            transTitleBar2.setBarTitle(string2);
            addDialogueTranslation();
        } else {
            ActivityTransStartBinding activityTransStartBinding4 = this.mBinding;
            if (activityTransStartBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                activityTransStartBinding = activityTransStartBinding4;
            }
            TransTitleBar transTitleBar3 = activityTransStartBinding.c;
            String string3 = getString(R.string.tl_simul_interpret);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            transTitleBar3.setBarTitle(string3);
            addSimulTranslation();
        }
    }

    private final void reportClickTrans(int i) {
        EventTrackingHelper.f6200a.b(new ClickEvent(i, 0, 2, (DefaultConstructorMarker) null));
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityTransStartBinding c = ActivityTransStartBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.mBinding = c;
        if (c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            c = null;
        }
        setContentView((View) c.getRoot());
        initData();
        initListener();
    }
}
