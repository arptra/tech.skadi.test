package com.upuphone.ar.translation.phone.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.airbnb.lottie.LottieAnimationView;
import com.honey.account.f5.a0;
import com.honey.account.f5.b0;
import com.honey.account.f5.c0;
import com.honey.account.f5.d0;
import com.honey.account.f5.e0;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.eventtrack.EventTrackingHelper;
import com.upuphone.ar.translation.eventtrack.event.ClickEvent;
import com.upuphone.ar.translation.ext.ActivityExtKt;
import com.upuphone.ar.translation.ext.DialogExtKt;
import com.upuphone.ar.translation.ext.InterconnectMsgCodExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.interconnect.entity.TranslationState;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.TranslationManager;
import com.upuphone.ar.translation.phone.bean.LanguageBean;
import com.upuphone.ar.translation.phone.bean.OperateMessage;
import com.upuphone.ar.translation.phone.bean.TransStateEvent;
import com.upuphone.ar.translation.phone.databinding.FragmentSpeechTranscribeBinding;
import com.upuphone.ar.translation.phone.helper.InterConnectHelper;
import com.upuphone.ar.translation.phone.helper.SwitchLangHelper;
import com.upuphone.ar.translation.phone.view.TranscribeLangDialog;
import com.upuphone.ar.translation.statemachine.machine.TranslateStateManager;
import com.upuphone.ar.translation.utils.LanguageUtils;
import com.upuphone.ar.translation.utils.NetworkUtils;
import com.upuphone.ar.translation.utils.PreferencesUtils;
import com.upuphone.star.common.phone.UToast;
import flyme.support.v7.app.AlertDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001X\u0018\u0000 \\2\u00020\u0001:\u0001]B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0003J#\u0010\u0017\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b!\u0010 J\u000f\u0010\"\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\"\u0010\u0003J\u000f\u0010#\u001a\u00020\u000eH\u0002¢\u0006\u0004\b#\u0010\u0003J\u000f\u0010$\u001a\u00020\u000eH\u0002¢\u0006\u0004\b$\u0010\u0003J\u000f\u0010%\u001a\u00020\u000eH\u0002¢\u0006\u0004\b%\u0010\u0003J\u0017\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)J\u0019\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u000eH\u0002¢\u0006\u0004\b/\u0010\u0003J\u000f\u00100\u001a\u00020\u000eH\u0002¢\u0006\u0004\b0\u0010\u0003J\u000f\u00101\u001a\u00020\u000eH\u0002¢\u0006\u0004\b1\u0010\u0003J\u000f\u00102\u001a\u00020\u000eH\u0002¢\u0006\u0004\b2\u0010\u0003J\u000f\u00103\u001a\u00020\u000eH\u0002¢\u0006\u0004\b3\u0010\u0003J\u000f\u00104\u001a\u00020&H\u0002¢\u0006\u0004\b4\u00105J\u0019\u00108\u001a\u00020\u000e2\b\b\u0001\u00107\u001a\u000206H\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u000eH\u0002¢\u0006\u0004\b:\u0010\u0003J\u0019\u0010<\u001a\u00020\u000e2\b\b\u0002\u0010;\u001a\u000206H\u0002¢\u0006\u0004\b<\u00109J\u000f\u0010=\u001a\u00020\u000eH\u0002¢\u0006\u0004\b=\u0010\u0003J\u000f\u0010>\u001a\u00020\u000eH\u0002¢\u0006\u0004\b>\u0010\u0003R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010H\u001a\u0002068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010JR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u0010JR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010[\u001a\u00020X8\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010Z¨\u0006^"}, d2 = {"Lcom/upuphone/ar/translation/phone/fragment/SpeechTranscribeFragment;", "Lcom/upuphone/ar/translation/phone/fragment/TransBaseFragment;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "initData", "initListener", "T", "Lcom/upuphone/ar/translation/phone/bean/OperateMessage;", "operateMessage", "M0", "(Lcom/upuphone/ar/translation/phone/bean/OperateMessage;)V", "Lcom/upuphone/ar/translation/phone/bean/TransStateEvent;", "transStateEvent", "L0", "(Lcom/upuphone/ar/translation/phone/bean/TransStateEvent;)V", "Lcom/upuphone/ar/translation/interconnect/entity/TranslationState;", "transState", "K0", "(Lcom/upuphone/ar/translation/interconnect/entity/TranslationState;)V", "J0", "initState", "e1", "f1", "g1", "", "isAlpha", "d1", "(Z)V", "", "langType", "Lcom/upuphone/ar/translation/phone/bean/LanguageBean;", "I0", "(Ljava/lang/String;)Lcom/upuphone/ar/translation/phone/bean/LanguageBean;", "W0", "X0", "V0", "c1", "b1", "Q0", "()Z", "", "strId", "toToast", "(I)V", "S0", "transType", "T0", "R0", "Y0", "Lcom/upuphone/ar/translation/phone/databinding/FragmentSpeechTranscribeBinding;", "a", "Lcom/upuphone/ar/translation/phone/databinding/FragmentSpeechTranscribeBinding;", "mBinding", "b", "Lcom/upuphone/ar/translation/phone/bean/LanguageBean;", "mTranscribeLanguage", "c", "I", "mCurrentTransType", "d", "Z", "mIsTransRunning", "e", "mIsTransStopping", "Lcom/upuphone/ar/translation/phone/view/TranscribeLangDialog;", "f", "Lcom/upuphone/ar/translation/phone/view/TranscribeLangDialog;", "mTranscribeLangDialog", "g", "mOppositeStartTrans", "Lflyme/support/v7/app/AlertDialog;", "h", "Lflyme/support/v7/app/AlertDialog;", "mTransRunningDialog", "com/upuphone/ar/translation/phone/fragment/SpeechTranscribeFragment$mUiUpdateCallback$1", "i", "Lcom/upuphone/ar/translation/phone/fragment/SpeechTranscribeFragment$mUiUpdateCallback$1;", "mUiUpdateCallback", "j", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nSpeechTranscribeFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpeechTranscribeFragment.kt\ncom/upuphone/ar/translation/phone/fragment/SpeechTranscribeFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,641:1\n262#2,2:642\n262#2,2:644\n262#2,2:646\n262#2,2:648\n262#2,2:650\n262#2,2:652\n262#2,2:654\n262#2,2:656\n262#2,2:658\n262#2,2:660\n262#2,2:662\n*S KotlinDebug\n*F\n+ 1 SpeechTranscribeFragment.kt\ncom/upuphone/ar/translation/phone/fragment/SpeechTranscribeFragment\n*L\n336#1:642,2\n340#1:644,2\n342#1:646,2\n353#1:648,2\n355#1:650,2\n358#1:652,2\n360#1:654,2\n372#1:656,2\n376#1:658,2\n378#1:660,2\n380#1:662,2\n*E\n"})
public final class SpeechTranscribeFragment extends TransBaseFragment {
    public static final Companion j = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public FragmentSpeechTranscribeBinding f6282a;
    public LanguageBean b;
    public int c = 1;
    public boolean d;
    public boolean e;
    public TranscribeLangDialog f;
    public boolean g;
    public AlertDialog h;
    public final SpeechTranscribeFragment$mUiUpdateCallback$1 i = new SpeechTranscribeFragment$mUiUpdateCallback$1(this);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/translation/phone/fragment/SpeechTranscribeFragment$Companion;", "", "<init>", "()V", "Lcom/upuphone/ar/translation/phone/fragment/SpeechTranscribeFragment;", "a", "()Lcom/upuphone/ar/translation/phone/fragment/SpeechTranscribeFragment;", "", "TAG", "Ljava/lang/String;", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SpeechTranscribeFragment a() {
            return new SpeechTranscribeFragment();
        }

        public Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final LanguageBean I0(String str) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return new LanguageBean(LanguageUtils.e(activity, str), str);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final void J0(TranslationState translationState) {
        int extCode = translationState.getExtCode();
        String i2 = InterconnectMsgCodExtKt.i(extCode);
        LogExt.j("handleTransExtState extCode" + i2, "SpeechTranscribeFragment");
        if (InterconnectMsgCodExtKt.d(extCode)) {
            g1();
        }
    }

    /* access modifiers changed from: private */
    public final void K0(TranslationState translationState) {
        int transState = translationState.getTransState();
        String j2 = InterconnectMsgCodExtKt.j(transState);
        LogExt.j("handleTransState state" + j2, "SpeechTranscribeFragment");
        if (transState == 2) {
            g1();
        } else if (transState == 3) {
            e1();
        } else if (transState == 4) {
            f1();
        }
    }

    /* access modifiers changed from: private */
    public final void L0(TransStateEvent transStateEvent) {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new SpeechTranscribeFragment$handleTranslateState$1(transStateEvent, this, (Continuation<? super SpeechTranscribeFragment$handleTranslateState$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void M0(OperateMessage operateMessage) {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new SpeechTranscribeFragment$handleVariousMsg$1(operateMessage, this, (Continuation<? super SpeechTranscribeFragment$handleVariousMsg$1>) null), 3, (Object) null);
    }

    public static final void N0(SpeechTranscribeFragment speechTranscribeFragment, int i2, String str, String str2) {
        Intrinsics.checkNotNullParameter(speechTranscribeFragment, "this$0");
        Intrinsics.checkNotNullParameter(str, "src");
        Intrinsics.checkNotNullParameter(str2, "dst");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(speechTranscribeFragment), (CoroutineContext) null, (CoroutineStart) null, new SpeechTranscribeFragment$initListener$1$1(i2, str, str2, speechTranscribeFragment, (Continuation<? super SpeechTranscribeFragment$initListener$1$1>) null), 3, (Object) null);
    }

    public static final void O0(SpeechTranscribeFragment speechTranscribeFragment, View view) {
        Intrinsics.checkNotNullParameter(speechTranscribeFragment, "this$0");
        speechTranscribeFragment.X0();
    }

    public static final void P0(SpeechTranscribeFragment speechTranscribeFragment, View view) {
        Intrinsics.checkNotNullParameter(speechTranscribeFragment, "this$0");
        speechTranscribeFragment.c1();
    }

    private final boolean Q0() {
        return InterConnectHelper.c.a().j();
    }

    /* access modifiers changed from: private */
    public final void R0() {
        LogExt.g("notifyTranslationStop 翻译Socket通道已经断开", "SpeechTranscribeFragment");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new SpeechTranscribeFragment$notifyTranslationStop$1(this, (Continuation<? super SpeechTranscribeFragment$notifyTranslationStop$1>) null), 3, (Object) null);
    }

    private final void S0() {
        EventTrackingHelper.f6200a.b(new ClickEvent(6, 0, 2, (DefaultConstructorMarker) null));
    }

    private final void T0(int i2) {
        EventTrackingHelper.f6200a.b(new ClickEvent(i2 == 1 ? 7 : 4, 0, 2, (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ void U0(SpeechTranscribeFragment speechTranscribeFragment, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 1;
        }
        speechTranscribeFragment.T0(i2);
    }

    private final void X0() {
        TranscribeLangDialog transcribeLangDialog;
        LanguageBean languageBean = this.b;
        LogExt.j("showLanguageDialog language=" + languageBean, "SpeechTranscribeFragment");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (this.f == null) {
                this.f = new TranscribeLangDialog(activity, new SpeechTranscribeFragment$showLanguageDialog$1$1(this));
            }
            LanguageBean languageBean2 = this.b;
            if (!(languageBean2 == null || (transcribeLangDialog = this.f) == null)) {
                transcribeLangDialog.n(languageBean2.getLangType());
            }
            TranscribeLangDialog transcribeLangDialog2 = this.f;
            if (transcribeLangDialog2 != null) {
                transcribeLangDialog2.p(ActivityExtKt.b(activity));
            }
            TranscribeLangDialog transcribeLangDialog3 = this.f;
            if (transcribeLangDialog3 != null) {
                transcribeLangDialog3.show();
            }
        }
    }

    private final void Y0() {
        Unit unit;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            AlertDialog alertDialog = this.h;
            if (alertDialog != null) {
                alertDialog.show();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                AlertDialog create = new AlertDialog.Builder(activity).setTitle(R.string.tl_translate_running_start_transcribe).setPositiveButton(R.string.tl_dialog_ok, (DialogInterface.OnClickListener) new d0(this)).setNegativeButton(R.string.tl_dialog_cancel, (DialogInterface.OnClickListener) new e0()).create();
                Intrinsics.checkNotNull(create);
                DialogExtKt.a(create);
                create.show();
                this.h = create;
            }
        }
    }

    public static final void Z0(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
    }

    public static final void a1(SpeechTranscribeFragment speechTranscribeFragment, DialogInterface dialogInterface, int i2) {
        Intrinsics.checkNotNullParameter(speechTranscribeFragment, "$this_run");
        TranslateStateManager p = TranslationManager.q.a().p();
        if (p != null) {
            p.y();
        }
        speechTranscribeFragment.T0(speechTranscribeFragment.c);
        speechTranscribeFragment.g = true;
        speechTranscribeFragment.c = 1;
        speechTranscribeFragment.e1();
    }

    private final void d1(boolean z) {
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding = this.f6282a;
        if (fragmentSpeechTranscribeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSpeechTranscribeBinding = null;
        }
        fragmentSpeechTranscribeBinding.j.setAlpha(z ? 0.25f : 1.0f);
    }

    private final void e1() {
        LogExt.g("updatePreparingUI ", "SpeechTranscribeFragment");
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding = this.f6282a;
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding2 = null;
        if (fragmentSpeechTranscribeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSpeechTranscribeBinding = null;
        }
        TextView textView = fragmentSpeechTranscribeBinding.j;
        Intrinsics.checkNotNullExpressionValue(textView, "tvTranscribeSrc");
        textView.setVisibility(0);
        d1(true);
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding3 = this.f6282a;
        if (fragmentSpeechTranscribeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSpeechTranscribeBinding3 = null;
        }
        TextView textView2 = fragmentSpeechTranscribeBinding3.h;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvTranscribeBtn");
        textView2.setVisibility(8);
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding4 = this.f6282a;
        if (fragmentSpeechTranscribeBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSpeechTranscribeBinding4 = null;
        }
        LottieAnimationView lottieAnimationView = fragmentSpeechTranscribeBinding4.f;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "lottieTranscribeLoading");
        lottieAnimationView.setVisibility(0);
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding5 = this.f6282a;
        if (fragmentSpeechTranscribeBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSpeechTranscribeBinding5 = null;
        }
        fragmentSpeechTranscribeBinding5.f.setRepeatCount(-1);
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding6 = this.f6282a;
        if (fragmentSpeechTranscribeBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentSpeechTranscribeBinding2 = fragmentSpeechTranscribeBinding6;
        }
        fragmentSpeechTranscribeBinding2.f.playAnimation();
    }

    private final void f1() {
        LogExt.g("updateStartUI", "SpeechTranscribeFragment");
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding = this.f6282a;
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding2 = null;
        if (fragmentSpeechTranscribeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSpeechTranscribeBinding = null;
        }
        TextView textView = fragmentSpeechTranscribeBinding.j;
        Intrinsics.checkNotNullExpressionValue(textView, "tvTranscribeSrc");
        textView.setVisibility(8);
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding3 = this.f6282a;
        if (fragmentSpeechTranscribeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSpeechTranscribeBinding3 = null;
        }
        Group group = fragmentSpeechTranscribeBinding3.d;
        Intrinsics.checkNotNullExpressionValue(group, "gpTranscribeRunning");
        group.setVisibility(0);
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding4 = this.f6282a;
        if (fragmentSpeechTranscribeBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSpeechTranscribeBinding4 = null;
        }
        fragmentSpeechTranscribeBinding4.g.setRepeatCount(-1);
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding5 = this.f6282a;
        if (fragmentSpeechTranscribeBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSpeechTranscribeBinding5 = null;
        }
        fragmentSpeechTranscribeBinding5.g.playAnimation();
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding6 = this.f6282a;
        if (fragmentSpeechTranscribeBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSpeechTranscribeBinding6 = null;
        }
        TextView textView2 = fragmentSpeechTranscribeBinding6.h;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvTranscribeBtn");
        textView2.setVisibility(0);
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding7 = this.f6282a;
        if (fragmentSpeechTranscribeBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSpeechTranscribeBinding7 = null;
        }
        fragmentSpeechTranscribeBinding7.h.setText(R.string.tl_transcribe_stop);
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding8 = this.f6282a;
        if (fragmentSpeechTranscribeBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSpeechTranscribeBinding8 = null;
        }
        LottieAnimationView lottieAnimationView = fragmentSpeechTranscribeBinding8.f;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "lottieTranscribeLoading");
        lottieAnimationView.setVisibility(8);
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding9 = this.f6282a;
        if (fragmentSpeechTranscribeBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentSpeechTranscribeBinding2 = fragmentSpeechTranscribeBinding9;
        }
        fragmentSpeechTranscribeBinding2.f.cancelAnimation();
        this.d = true;
    }

    /* access modifiers changed from: private */
    public final void g1() {
        LogExt.g("updateStopUI", "SpeechTranscribeFragment");
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding = this.f6282a;
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding2 = null;
        if (fragmentSpeechTranscribeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSpeechTranscribeBinding = null;
        }
        TextView textView = fragmentSpeechTranscribeBinding.j;
        Intrinsics.checkNotNullExpressionValue(textView, "tvTranscribeSrc");
        textView.setVisibility(0);
        d1(false);
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding3 = this.f6282a;
        if (fragmentSpeechTranscribeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSpeechTranscribeBinding3 = null;
        }
        Group group = fragmentSpeechTranscribeBinding3.d;
        Intrinsics.checkNotNullExpressionValue(group, "gpTranscribeRunning");
        group.setVisibility(8);
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding4 = this.f6282a;
        if (fragmentSpeechTranscribeBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSpeechTranscribeBinding4 = null;
        }
        fragmentSpeechTranscribeBinding4.g.cancelAnimation();
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding5 = this.f6282a;
        if (fragmentSpeechTranscribeBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSpeechTranscribeBinding5 = null;
        }
        TextView textView2 = fragmentSpeechTranscribeBinding5.h;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvTranscribeBtn");
        textView2.setVisibility(0);
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding6 = this.f6282a;
        if (fragmentSpeechTranscribeBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSpeechTranscribeBinding6 = null;
        }
        fragmentSpeechTranscribeBinding6.h.setText(R.string.tl_transcribe_start);
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding7 = this.f6282a;
        if (fragmentSpeechTranscribeBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSpeechTranscribeBinding7 = null;
        }
        LottieAnimationView lottieAnimationView = fragmentSpeechTranscribeBinding7.f;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "lottieTranscribeLoading");
        lottieAnimationView.setVisibility(8);
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding8 = this.f6282a;
        if (fragmentSpeechTranscribeBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentSpeechTranscribeBinding2 = fragmentSpeechTranscribeBinding8;
        }
        fragmentSpeechTranscribeBinding2.f.cancelAnimation();
        this.d = false;
        this.e = false;
    }

    private final void initData() {
        this.b = I0(LanguageUtils.g().e());
        W0();
        initState();
    }

    private final void initListener() {
        TranslationApp.registerUiUpdateCallback$ar_translator_intlRelease("SpeechTranscribeFragment", this.i);
        SwitchLangHelper.j("SpeechTranscribeFragment", new a0(this));
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding = this.f6282a;
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding2 = null;
        if (fragmentSpeechTranscribeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSpeechTranscribeBinding = null;
        }
        fragmentSpeechTranscribeBinding.j.setOnClickListener(new b0(this));
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding3 = this.f6282a;
        if (fragmentSpeechTranscribeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentSpeechTranscribeBinding2 = fragmentSpeechTranscribeBinding3;
        }
        fragmentSpeechTranscribeBinding2.b.setOnClickListener(new c0(this));
    }

    private final void initState() {
        int m = PreferencesUtils.m();
        this.c = m;
        LogExt.j("initState currentTransType=" + InterconnectMsgCodExtKt.k(m), "SpeechTranscribeFragment");
        if (TranslationApp.isServiceOn()) {
            TranslateStateManager p = TranslationManager.q.a().p();
            boolean z = !(p != null ? p.e() : false);
            this.d = z;
            LogExt.j("initState isTransRunning=" + z, "SpeechTranscribeFragment");
        }
        boolean z2 = this.d;
        if (!z2) {
            this.c = 1;
        }
        if (this.c == 1) {
            if (!z2) {
                g1();
                return;
            }
            TranslateStateManager p2 = TranslationManager.q.a().p();
            if (p2 == null || !p2.g()) {
                f1();
            } else {
                e1();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void toToast(int i2) {
        UToast.Companion companion = UToast.f6444a;
        Context applicationContext = requireActivity().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        companion.c(applicationContext, i2, 0);
    }

    public final void V0() {
        LanguageBean languageBean = this.b;
        LogExt.j("setTranscribeLang mTranscribeLanguage=" + languageBean, "SpeechTranscribeFragment");
        LanguageBean languageBean2 = this.b;
        if (languageBean2 != null) {
            W0();
            PreferencesUtils.p(1, languageBean2.getLangType(), languageBean2.getLangType());
            InterConnectHelper.c.a().B(1, languageBean2.getLangType(), languageBean2.getLangType());
        }
    }

    public final void W0() {
        String str;
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding = this.f6282a;
        if (fragmentSpeechTranscribeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSpeechTranscribeBinding = null;
        }
        TextView textView = fragmentSpeechTranscribeBinding.j;
        LanguageBean languageBean = this.b;
        if (languageBean == null || (str = languageBean.getLangName()) == null) {
            str = "";
        }
        textView.setText(str);
    }

    public final void b1() {
        String str;
        String str2;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.c = 1;
            e1();
            PreferencesUtils.A(1);
            LanguageUtils.StoredLanguage g2 = LanguageUtils.g();
            LanguageBean languageBean = this.b;
            if (languageBean == null || (str = languageBean.getLangType()) == null) {
                str = g2.e();
            }
            LanguageBean languageBean2 = this.b;
            if (languageBean2 == null || (str2 = languageBean2.getLangType()) == null) {
                str2 = g2.e();
            }
            TranslationManager.Companion companion = TranslationManager.q;
            TranslateStateManager p = companion.a().p();
            boolean z = false;
            boolean c2 = p != null ? p.c() : false;
            TranslateStateManager p2 = companion.a().p();
            if (p2 != null) {
                z = p2.e();
            }
            if (c2 || z) {
                LogExt.j("startTranslation 翻译服务已启动，开始语音转写", "SpeechTranscribeFragment");
                NetworkUtils.f6368a.e(activity, new SpeechTranscribeFragment$startTranscribe$1$1(str, str2));
                return;
            }
            LogExt.j("startTranslation 翻译服务未启动，开始语音转写", "SpeechTranscribeFragment");
            Context applicationContext = activity.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            TranslationApp.startService(applicationContext);
        }
    }

    public final void c1() {
        if (!Q0()) {
            toToast(R.string.tl_toast_glass_disconnected_tap);
        } else if (TranslatorConstants.isAirOldLanguage()) {
            toToast(R.string.tl_upgrade_glass_version_tips);
        } else if (this.d) {
            if (this.c != 1) {
                Y0();
                return;
            }
            TranslateStateManager p = TranslationManager.q.a().p();
            if (p != null) {
                p.y();
            }
            U0(this, 0, 1, (Object) null);
            this.e = true;
        } else if (this.e) {
            toToast(R.string.tl_trans_start_abnormal);
        } else {
            b1();
            S0();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentSpeechTranscribeBinding c2 = FragmentSpeechTranscribeBinding.c(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f6282a = c2;
        if (c2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            c2 = null;
        }
        ConstraintLayout b2 = c2.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        return b2;
    }

    public void onDestroyView() {
        super.onDestroyView();
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding = null;
        this.b = null;
        this.c = 1;
        this.d = false;
        this.e = false;
        TranscribeLangDialog transcribeLangDialog = this.f;
        if (transcribeLangDialog != null) {
            transcribeLangDialog.dismiss();
        }
        this.f = null;
        this.g = false;
        AlertDialog alertDialog = this.h;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.h = null;
        TranslationApp.unRegisterUiUpdateCallback$ar_translator_intlRelease("SpeechTranscribeFragment");
        SwitchLangHelper.A("SpeechTranscribeFragment");
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding2 = this.f6282a;
        if (fragmentSpeechTranscribeBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSpeechTranscribeBinding2 = null;
        }
        if (fragmentSpeechTranscribeBinding2.f.isAnimating()) {
            FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding3 = this.f6282a;
            if (fragmentSpeechTranscribeBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSpeechTranscribeBinding3 = null;
            }
            fragmentSpeechTranscribeBinding3.f.cancelAnimation();
        }
        FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding4 = this.f6282a;
        if (fragmentSpeechTranscribeBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSpeechTranscribeBinding4 = null;
        }
        if (fragmentSpeechTranscribeBinding4.g.isAnimating()) {
            FragmentSpeechTranscribeBinding fragmentSpeechTranscribeBinding5 = this.f6282a;
            if (fragmentSpeechTranscribeBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentSpeechTranscribeBinding = fragmentSpeechTranscribeBinding5;
            }
            fragmentSpeechTranscribeBinding.g.cancelAnimation();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initData();
        initListener();
    }
}
