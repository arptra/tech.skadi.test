package com.upuphone.ar.translation.phone.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.honey.account.f5.a;
import com.honey.account.f5.b;
import com.honey.account.f5.c;
import com.honey.account.f5.d;
import com.honey.account.f5.e;
import com.honey.account.f5.f;
import com.honey.account.f5.g;
import com.honey.account.f5.h;
import com.honey.account.f5.i;
import com.honey.account.f5.j;
import com.honey.account.f5.k;
import com.honey.account.f5.l;
import com.honey.account.f5.m;
import com.honey.account.f5.n;
import com.honey.account.f5.o;
import com.honey.account.f5.p;
import com.honey.account.f5.q;
import com.upuphone.ar.translation.TranslationApp;
import com.upuphone.ar.translation.constants.GlassVersionHelper;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.ActivityExtKt;
import com.upuphone.ar.translation.ext.ContextExtKt;
import com.upuphone.ar.translation.ext.DialogExtKt;
import com.upuphone.ar.translation.ext.InterconnectMsgCodExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.interconnect.entity.TranslationState;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.TranslationManager;
import com.upuphone.ar.translation.phone.adapter.DialogueRunningAdapter;
import com.upuphone.ar.translation.phone.bean.DialogueRunning;
import com.upuphone.ar.translation.phone.bean.DialogueUserTips;
import com.upuphone.ar.translation.phone.bean.LanguageBean;
import com.upuphone.ar.translation.phone.bean.OperateMessage;
import com.upuphone.ar.translation.phone.bean.TransStateEvent;
import com.upuphone.ar.translation.phone.bean.TranslationLanguage;
import com.upuphone.ar.translation.phone.databinding.FragmentDialogueTranslationBinding;
import com.upuphone.ar.translation.phone.databinding.LayoutTlDialogCustomTitleBinding;
import com.upuphone.ar.translation.phone.helper.RunningRecordHelper;
import com.upuphone.ar.translation.phone.view.TranslationLangDialog;
import com.upuphone.ar.translation.phone.vm.DialogueTranslationViewModel;
import com.upuphone.ar.translation.statemachine.machine.TranslateStateManager;
import com.upuphone.ar.translation.utils.PreferencesUtils;
import com.upuphone.xr.sapp.context.IPhoneCallStatus;
import flyme.support.v7.app.AlertDialog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0018\u0010\u0003J5\u0010\u001f\u001a\u00020\u000e2\u0014\u0010\u001c\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u000eH\u0002¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010\"\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\"\u0010\u0003J#\u0010&\u001a\u00020\u000e\"\u0004\b\u0000\u0010#2\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b0\u0010/J\u000f\u00101\u001a\u00020\u000eH\u0002¢\u0006\u0004\b1\u0010\u0003J\u000f\u00102\u001a\u00020\u000eH\u0003¢\u0006\u0004\b2\u0010\u0003J\u000f\u00103\u001a\u00020\u000eH\u0003¢\u0006\u0004\b3\u0010\u0003J\u0017\u00106\u001a\u00020\u000e2\u0006\u00105\u001a\u000204H\u0002¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\u000e2\u0006\u00108\u001a\u000204H\u0002¢\u0006\u0004\b9\u00107J\u0017\u0010<\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020:H\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u000eH\u0002¢\u0006\u0004\b>\u0010\u0003J\u000f\u0010?\u001a\u00020\u000eH\u0002¢\u0006\u0004\b?\u0010\u0003J\u000f\u0010@\u001a\u00020\u000eH\u0002¢\u0006\u0004\b@\u0010\u0003J\u000f\u0010A\u001a\u00020\u000eH\u0002¢\u0006\u0004\bA\u0010\u0003J\u000f\u0010B\u001a\u00020\u000eH\u0002¢\u0006\u0004\bB\u0010\u0003J\u000f\u0010C\u001a\u00020\u000eH\u0002¢\u0006\u0004\bC\u0010\u0003J\u000f\u0010D\u001a\u00020\u000eH\u0002¢\u0006\u0004\bD\u0010\u0003J\u000f\u0010E\u001a\u00020\u000eH\u0002¢\u0006\u0004\bE\u0010\u0003J\u000f\u0010F\u001a\u00020\u000eH\u0002¢\u0006\u0004\bF\u0010\u0003J\u000f\u0010G\u001a\u00020\u000eH\u0002¢\u0006\u0004\bG\u0010\u0003J\u0017\u0010J\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020HH\u0002¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\u000eH\u0003¢\u0006\u0004\bL\u0010\u0003J\u000f\u0010M\u001a\u00020\u000eH\u0002¢\u0006\u0004\bM\u0010\u0003J\u000f\u0010N\u001a\u00020\u000eH\u0002¢\u0006\u0004\bN\u0010\u0003J\u0017\u0010Q\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020OH\u0002¢\u0006\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bT\u0010UR\u001b\u0010\\\u001a\u00020W8BX\u0002¢\u0006\f\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[R\u0016\u0010_\u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010b\u001a\u0002048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u0002048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bc\u0010aR\u0016\u0010f\u001a\u0002048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\be\u0010aR\u0016\u0010h\u001a\u0002048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bg\u0010aR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010p\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010r\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bq\u0010oR\u0018\u0010t\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bs\u0010oR\u0018\u0010x\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010{\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010}\u001a\u0002048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b|\u0010aR\u0016\u0010\u001a\u00020\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b~\u0010^R\u0018\u0010\u0001\u001a\u0002048\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010aR\u0018\u0010\u0001\u001a\u0002048\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010a¨\u0006\u0001"}, d2 = {"Lcom/upuphone/ar/translation/phone/fragment/DialogueTranslationFragment;", "Lcom/upuphone/ar/translation/phone/fragment/TransBaseFragment;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "onDestroyView", "initView", "initData", "initListener", "initViewModels", "initState", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "adapter", "", "position", "d1", "(Lcom/chad/library/adapter/base/BaseQuickAdapter;Landroid/view/View;I)V", "S1", "T1", "T", "Lcom/upuphone/ar/translation/phone/bean/OperateMessage;", "operateMessage", "h1", "(Lcom/upuphone/ar/translation/phone/bean/OperateMessage;)V", "Lcom/upuphone/ar/translation/phone/bean/TransStateEvent;", "transStateEvent", "g1", "(Lcom/upuphone/ar/translation/phone/bean/TransStateEvent;)V", "Lcom/upuphone/ar/translation/interconnect/entity/TranslationState;", "transState", "f1", "(Lcom/upuphone/ar/translation/interconnect/entity/TranslationState;)V", "e1", "P1", "Q1", "R1", "", "isPaused", "K1", "(Z)V", "isAlpha", "L1", "Lcom/upuphone/ar/translation/phone/bean/TranslationLanguage;", "language", "M1", "(Lcom/upuphone/ar/translation/phone/bean/TranslationLanguage;)V", "s1", "p1", "G1", "J1", "I1", "C1", "F1", "H1", "w1", "t1", "Lcom/upuphone/ar/translation/phone/bean/DialogueRunning;", "dialogueRunning", "b1", "(Lcom/upuphone/ar/translation/phone/bean/DialogueRunning;)V", "a1", "q1", "z1", "Landroidx/recyclerview/widget/LinearLayoutManager;", "manager", "B1", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "Lcom/upuphone/ar/translation/phone/databinding/FragmentDialogueTranslationBinding;", "a", "Lcom/upuphone/ar/translation/phone/databinding/FragmentDialogueTranslationBinding;", "mBinding", "Lcom/upuphone/ar/translation/phone/vm/DialogueTranslationViewModel;", "b", "Lkotlin/Lazy;", "c1", "()Lcom/upuphone/ar/translation/phone/vm/DialogueTranslationViewModel;", "mDialogueTranslationVm", "c", "I", "mCurrentTransType", "d", "Z", "mIsTransRunning", "e", "mIsTransStopping", "f", "mIsPreparingUI", "g", "mOppositeStartTrans", "Lcom/upuphone/ar/translation/phone/view/TranslationLangDialog;", "h", "Lcom/upuphone/ar/translation/phone/view/TranslationLangDialog;", "mTranslationLangDialog", "Lflyme/support/v7/app/AlertDialog;", "i", "Lflyme/support/v7/app/AlertDialog;", "mTransRunningDialog", "j", "mNotVprintDialog", "k", "mSwitchSpeakerDialog", "Lcom/upuphone/ar/translation/phone/adapter/DialogueRunningAdapter;", "l", "Lcom/upuphone/ar/translation/phone/adapter/DialogueRunningAdapter;", "mAdapter", "m", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mLayoutManager", "n", "mIsUserScrolling", "o", "mCurTtsPosition", "p", "mIsInterruptPreTts", "q", "mIsClickLowVersionUpdate", "r", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nDialogueTranslationFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DialogueTranslationFragment.kt\ncom/upuphone/ar/translation/phone/fragment/DialogueTranslationFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,1243:1\n106#2,15:1244\n262#3,2:1259\n262#3,2:1261\n262#3,2:1263\n262#3,2:1265\n262#3,2:1267\n262#3,2:1269\n262#3,2:1271\n262#3,2:1273\n262#3,2:1275\n262#3,2:1277\n262#3,2:1279\n262#3,2:1281\n262#3,2:1283\n262#3,2:1285\n262#3,2:1287\n262#3,2:1289\n262#3,2:1291\n262#3,2:1293\n262#3,2:1295\n262#3,2:1297\n262#3,2:1299\n262#3,2:1301\n262#3,2:1303\n262#3,2:1305\n262#3,2:1307\n262#3,2:1309\n*S KotlinDebug\n*F\n+ 1 DialogueTranslationFragment.kt\ncom/upuphone/ar/translation/phone/fragment/DialogueTranslationFragment\n*L\n82#1:1244,15\n135#1:1259,2\n212#1:1261,2\n628#1:1263,2\n632#1:1265,2\n634#1:1267,2\n649#1:1269,2\n651#1:1271,2\n652#1:1273,2\n655#1:1275,2\n659#1:1277,2\n660#1:1279,2\n668#1:1281,2\n669#1:1283,2\n688#1:1285,2\n691#1:1287,2\n692#1:1289,2\n695#1:1291,2\n697#1:1293,2\n698#1:1295,2\n706#1:1297,2\n707#1:1299,2\n708#1:1301,2\n967#1:1303,2\n1100#1:1305,2\n1142#1:1307,2\n1146#1:1309,2\n*E\n"})
public final class DialogueTranslationFragment extends TransBaseFragment {
    public static final Companion r = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public FragmentDialogueTranslationBinding f6274a;
    public final Lazy b;
    public int c = 3;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public TranslationLangDialog h;
    public AlertDialog i;
    public AlertDialog j;
    public AlertDialog k;
    public DialogueRunningAdapter l;
    public LinearLayoutManager m;
    public boolean n;
    public int o = -1;
    public boolean p;
    public boolean q;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/translation/phone/fragment/DialogueTranslationFragment$Companion;", "", "<init>", "()V", "Lcom/upuphone/ar/translation/phone/fragment/DialogueTranslationFragment;", "a", "()Lcom/upuphone/ar/translation/phone/fragment/DialogueTranslationFragment;", "", "TAG", "Ljava/lang/String;", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DialogueTranslationFragment a() {
            return new DialogueTranslationFragment();
        }

        public Companion() {
        }
    }

    public DialogueTranslationFragment() {
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new DialogueTranslationFragment$special$$inlined$viewModels$default$2(new DialogueTranslationFragment$special$$inlined$viewModels$default$1(this)));
        this.b = FragmentViewModelLazyKt.c(this, Reflection.getOrCreateKotlinClass(DialogueTranslationViewModel.class), new DialogueTranslationFragment$special$$inlined$viewModels$default$3(lazy), new DialogueTranslationFragment$special$$inlined$viewModels$default$4((Function0) null, lazy), new DialogueTranslationFragment$special$$inlined$viewModels$default$5(this, lazy));
    }

    public static final void A1(DialogueTranslationFragment dialogueTranslationFragment) {
        Intrinsics.checkNotNullParameter(dialogueTranslationFragment, "this$0");
        LinearLayoutManager linearLayoutManager = dialogueTranslationFragment.m;
        if (linearLayoutManager == null) {
            return;
        }
        if (!dialogueTranslationFragment.n) {
            dialogueTranslationFragment.B1(linearLayoutManager);
            return;
        }
        DialogueTranslationViewModel c1 = dialogueTranslationFragment.c1();
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding = dialogueTranslationFragment.f6274a;
        if (fragmentDialogueTranslationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding = null;
        }
        RecyclerView recyclerView = fragmentDialogueTranslationBinding.x;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "rvRecords");
        if (c1.x(recyclerView) == linearLayoutManager.getItemCount() - 1) {
            dialogueTranslationFragment.n = false;
            dialogueTranslationFragment.B1(linearLayoutManager);
        }
    }

    public static final void D1(DialogueTranslationFragment dialogueTranslationFragment, DialogInterface dialogInterface, int i2) {
        Intrinsics.checkNotNullParameter(dialogueTranslationFragment, "$this_run");
        dialogueTranslationFragment.c1().g0();
        DialogueRunningAdapter dialogueRunningAdapter = dialogueTranslationFragment.l;
        if (dialogueRunningAdapter != null) {
            dialogueRunningAdapter.G0(true);
        }
        dialogueTranslationFragment.H1();
    }

    public static final void E1(DialogueTranslationFragment dialogueTranslationFragment, DialogInterface dialogInterface, int i2) {
        Intrinsics.checkNotNullParameter(dialogueTranslationFragment, "$this_run");
        DialogueRunningAdapter dialogueRunningAdapter = dialogueTranslationFragment.l;
        if (dialogueRunningAdapter != null) {
            dialogueRunningAdapter.G0(false);
        }
        dialogueTranslationFragment.H1();
        dialogInterface.dismiss();
    }

    private final void G1() {
        if (this.f || this.d) {
            LogExt.j("startTranslation translate is preparing or running", "DialogueTranslationFragment");
        } else if (!c1().L()) {
            c1().j0(R.string.tl_toast_glass_disconnected_tap);
        } else if (TranslatorConstants.isAirOldLanguage()) {
            c1().j0(R.string.tl_upgrade_glass_version_tips);
        } else if (this.e) {
            c1().j0(R.string.tl_trans_start_abnormal);
        } else if (this.c != 3) {
            w1();
        } else {
            I1();
        }
    }

    public static final void N1(TranslationLanguage translationLanguage, DialogueTranslationFragment dialogueTranslationFragment) {
        Intrinsics.checkNotNullParameter(translationLanguage, "$language");
        Intrinsics.checkNotNullParameter(dialogueTranslationFragment, "this$0");
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding = null;
        if (Intrinsics.areEqual((Object) translationLanguage.getSrc().getLangType(), (Object) "cnen")) {
            FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding2 = dialogueTranslationFragment.f6274a;
            if (fragmentDialogueTranslationBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentDialogueTranslationBinding2 = null;
            }
            fragmentDialogueTranslationBinding2.M.setMaxLines(4);
            FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding3 = dialogueTranslationFragment.f6274a;
            if (fragmentDialogueTranslationBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentDialogueTranslationBinding = fragmentDialogueTranslationBinding3;
            }
            fragmentDialogueTranslationBinding.M.setAutoSizeTextTypeUniformWithConfiguration(10, 14, 1, 2);
            return;
        }
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding4 = dialogueTranslationFragment.f6274a;
        if (fragmentDialogueTranslationBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding4 = null;
        }
        fragmentDialogueTranslationBinding4.M.setMaxLines(Integer.MAX_VALUE);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding5 = dialogueTranslationFragment.f6274a;
        if (fragmentDialogueTranslationBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding5 = null;
        }
        fragmentDialogueTranslationBinding5.M.setAutoSizeTextTypeWithDefaults(0);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding6 = dialogueTranslationFragment.f6274a;
        if (fragmentDialogueTranslationBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentDialogueTranslationBinding = fragmentDialogueTranslationBinding6;
        }
        fragmentDialogueTranslationBinding.M.setTextSize(2, 14.0f);
    }

    public static final void O1(TranslationLanguage translationLanguage, DialogueTranslationFragment dialogueTranslationFragment) {
        Intrinsics.checkNotNullParameter(translationLanguage, "$language");
        Intrinsics.checkNotNullParameter(dialogueTranslationFragment, "this$0");
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding = null;
        if (Intrinsics.areEqual((Object) translationLanguage.getDst().getLangType(), (Object) "cnen")) {
            FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding2 = dialogueTranslationFragment.f6274a;
            if (fragmentDialogueTranslationBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentDialogueTranslationBinding2 = null;
            }
            fragmentDialogueTranslationBinding2.L.setMaxLines(4);
            FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding3 = dialogueTranslationFragment.f6274a;
            if (fragmentDialogueTranslationBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentDialogueTranslationBinding = fragmentDialogueTranslationBinding3;
            }
            fragmentDialogueTranslationBinding.L.setAutoSizeTextTypeUniformWithConfiguration(10, 14, 1, 2);
            return;
        }
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding4 = dialogueTranslationFragment.f6274a;
        if (fragmentDialogueTranslationBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding4 = null;
        }
        fragmentDialogueTranslationBinding4.L.setMaxLines(Integer.MAX_VALUE);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding5 = dialogueTranslationFragment.f6274a;
        if (fragmentDialogueTranslationBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding5 = null;
        }
        fragmentDialogueTranslationBinding5.L.setAutoSizeTextTypeWithDefaults(0);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding6 = dialogueTranslationFragment.f6274a;
        if (fragmentDialogueTranslationBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentDialogueTranslationBinding = fragmentDialogueTranslationBinding6;
        }
        fragmentDialogueTranslationBinding.L.setTextSize(2, 14.0f);
    }

    public static final void i1(DialogueTranslationFragment dialogueTranslationFragment, View view) {
        Intrinsics.checkNotNullParameter(dialogueTranslationFragment, "this$0");
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding = dialogueTranslationFragment.f6274a;
        if (fragmentDialogueTranslationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding = null;
        }
        fragmentDialogueTranslationBinding.t.playAnimation();
        dialogueTranslationFragment.c1().v();
    }

    private final void initData() {
        c1().H();
        initState();
    }

    private final void initListener() {
        TranslationApp.registerUiUpdateCallback$ar_translator_intlRelease("DialogueTranslationFragment", new DialogueTranslationFragment$initListener$1(this));
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding = this.f6274a;
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding2 = null;
        if (fragmentDialogueTranslationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding = null;
        }
        fragmentDialogueTranslationBinding.t.setOnClickListener(new a(this));
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding3 = this.f6274a;
        if (fragmentDialogueTranslationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding3 = null;
        }
        fragmentDialogueTranslationBinding3.i.setOnClickListener(new i(this));
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding4 = this.f6274a;
        if (fragmentDialogueTranslationBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding4 = null;
        }
        fragmentDialogueTranslationBinding4.g.setOnClickListener(new j(this));
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding5 = this.f6274a;
        if (fragmentDialogueTranslationBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding5 = null;
        }
        fragmentDialogueTranslationBinding5.e.setOnClickListener(new k(this));
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding6 = this.f6274a;
        if (fragmentDialogueTranslationBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding6 = null;
        }
        fragmentDialogueTranslationBinding6.I.setOnClickListener(new l(this));
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding7 = this.f6274a;
        if (fragmentDialogueTranslationBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding7 = null;
        }
        fragmentDialogueTranslationBinding7.x.addOnScrollListener(new DialogueTranslationFragment$initListener$7(this));
        DialogueRunningAdapter dialogueRunningAdapter = this.l;
        if (dialogueRunningAdapter != null) {
            dialogueRunningAdapter.n0(new m(this));
        }
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding8 = this.f6274a;
        if (fragmentDialogueTranslationBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentDialogueTranslationBinding2 = fragmentDialogueTranslationBinding8;
        }
        fragmentDialogueTranslationBinding2.B.setOnClickListener(new n(this));
    }

    private final void initState() {
        IPhoneCallStatus value = TranslatorConstants.getPhoneCallStatus().getValue();
        boolean z = false;
        c1().Z(value != null ? value.getCallStatus() : 0);
        int m2 = PreferencesUtils.m();
        this.c = m2;
        LogExt.j("initState curTransType" + InterconnectMsgCodExtKt.k(m2) + ", callStatus=" + value, "DialogueTranslationFragment");
        if (TranslationApp.isServiceOn()) {
            TranslateStateManager p2 = TranslationManager.q.a().p();
            if (p2 != null) {
                z = p2.e();
            }
            boolean z2 = !z;
            this.d = z2;
            LogExt.j("initState isTransRunning=" + z2, "DialogueTranslationFragment");
        }
        boolean z3 = this.d;
        if (!z3) {
            this.c = 3;
        }
        if (this.c == 3) {
            if (!z3) {
                R1();
                return;
            }
            TranslationManager.Companion companion = TranslationManager.q;
            if (companion.a().x()) {
                c1().g0();
                DialogueRunningAdapter dialogueRunningAdapter = this.l;
                if (dialogueRunningAdapter != null) {
                    dialogueRunningAdapter.G0(true);
                }
            }
            TranslateStateManager p3 = companion.a().p();
            if (p3 == null || !p3.g()) {
                Q1();
            } else {
                P1();
            }
        }
    }

    private final void initView() {
        this.l = new DialogueRunningAdapter(new ArrayList());
        boolean z = false;
        this.m = new LinearLayoutManager(requireActivity(), 1, false);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding = this.f6274a;
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding2 = null;
        if (fragmentDialogueTranslationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding = null;
        }
        fragmentDialogueTranslationBinding.x.setLayoutManager(this.m);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding3 = this.f6274a;
        if (fragmentDialogueTranslationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding3 = null;
        }
        fragmentDialogueTranslationBinding3.x.setItemAnimator((RecyclerView.ItemAnimator) null);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding4 = this.f6274a;
        if (fragmentDialogueTranslationBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding4 = null;
        }
        fragmentDialogueTranslationBinding4.x.setAdapter(this.l);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding5 = this.f6274a;
        if (fragmentDialogueTranslationBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding5 = null;
        }
        ConstraintLayout constraintLayout = fragmentDialogueTranslationBinding5.c;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "clLowVersionTip");
        constraintLayout.setVisibility(true ^ GlassVersionHelper.INSTANCE.isDomOta1ForAirPro() ? 0 : 8);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            z = ContextExtKt.f(activity);
        }
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding6 = this.f6274a;
        if (fragmentDialogueTranslationBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentDialogueTranslationBinding2 = fragmentDialogueTranslationBinding6;
        }
        fragmentDialogueTranslationBinding2.t.setScaleX(z ? -1.0f : 1.0f);
    }

    private final void initViewModels() {
        c1().y().observe(getViewLifecycleOwner(), new DialogueTranslationFragment$sam$androidx_lifecycle_Observer$0(new DialogueTranslationFragment$initViewModels$1(this)));
        TranslatorConstants.getPhoneCallStatus().observe(getViewLifecycleOwner(), new DialogueTranslationFragment$sam$androidx_lifecycle_Observer$0(new DialogueTranslationFragment$initViewModels$2(this)));
        c1().A().observe(getViewLifecycleOwner(), new DialogueTranslationFragment$sam$androidx_lifecycle_Observer$0(new DialogueTranslationFragment$initViewModels$3(this)));
    }

    public static final void j1(DialogueTranslationFragment dialogueTranslationFragment, View view) {
        Intrinsics.checkNotNullParameter(dialogueTranslationFragment, "this$0");
        dialogueTranslationFragment.s1();
    }

    public static final void k1(DialogueTranslationFragment dialogueTranslationFragment, View view) {
        Intrinsics.checkNotNullParameter(dialogueTranslationFragment, "this$0");
        dialogueTranslationFragment.s1();
    }

    public static final void l1(DialogueTranslationFragment dialogueTranslationFragment, View view) {
        Intrinsics.checkNotNullParameter(dialogueTranslationFragment, "this$0");
        dialogueTranslationFragment.G1();
    }

    public static final void m1(DialogueTranslationFragment dialogueTranslationFragment, View view) {
        Intrinsics.checkNotNullParameter(dialogueTranslationFragment, "this$0");
        dialogueTranslationFragment.J1();
    }

    public static final void n1(DialogueTranslationFragment dialogueTranslationFragment, BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        Intrinsics.checkNotNullParameter(dialogueTranslationFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        dialogueTranslationFragment.d1(baseQuickAdapter, view, i2);
    }

    public static final void o1(DialogueTranslationFragment dialogueTranslationFragment, View view) {
        Intrinsics.checkNotNullParameter(dialogueTranslationFragment, "this$0");
        FragmentActivity activity = dialogueTranslationFragment.getActivity();
        if (activity != null) {
            TranslationApp.startGlassUpdateInfoActivity$ar_translator_intlRelease(activity);
            dialogueTranslationFragment.q = true;
        }
    }

    /* access modifiers changed from: private */
    public final void p1() {
        LogExt.g("notifyTranslationStop 翻译Socket通道已经断开", "DialogueTranslationFragment");
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new DialogueTranslationFragment$notifyTranslationStop$1(this, (Continuation<? super DialogueTranslationFragment$notifyTranslationStop$1>) null), 3, (Object) null);
    }

    public static final void r1(DialogueTranslationFragment dialogueTranslationFragment) {
        Intrinsics.checkNotNullParameter(dialogueTranslationFragment, "this$0");
        LinearLayoutManager linearLayoutManager = dialogueTranslationFragment.m;
        if (linearLayoutManager != null) {
            int itemCount = linearLayoutManager.getItemCount() - 1;
            View findViewByPosition = linearLayoutManager.findViewByPosition(itemCount);
            int bottom = findViewByPosition != null ? findViewByPosition.getBottom() : 0;
            FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding = dialogueTranslationFragment.f6274a;
            FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding2 = null;
            if (fragmentDialogueTranslationBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentDialogueTranslationBinding = null;
            }
            RecyclerView recyclerView = fragmentDialogueTranslationBinding.x;
            int height = (recyclerView.getHeight() - recyclerView.getPaddingBottom()) - bottom;
            if (dialogueTranslationFragment.n) {
                DialogueTranslationViewModel c1 = dialogueTranslationFragment.c1();
                FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding3 = dialogueTranslationFragment.f6274a;
                if (fragmentDialogueTranslationBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    fragmentDialogueTranslationBinding2 = fragmentDialogueTranslationBinding3;
                }
                RecyclerView recyclerView2 = fragmentDialogueTranslationBinding2.x;
                Intrinsics.checkNotNullExpressionValue(recyclerView2, "rvRecords");
                if (c1.x(recyclerView2) == itemCount) {
                    dialogueTranslationFragment.n = false;
                    if (bottom == 0) {
                        linearLayoutManager.scrollToPositionWithOffset(itemCount, 0);
                    } else if (height <= 0) {
                        linearLayoutManager.scrollToPositionWithOffset(itemCount, height);
                    }
                }
            } else if (bottom == 0) {
                linearLayoutManager.scrollToPositionWithOffset(itemCount, 0);
            } else if (height <= 0) {
                linearLayoutManager.scrollToPositionWithOffset(itemCount, height);
            }
        }
    }

    public static final void u1(FragmentActivity fragmentActivity, DialogInterface dialogInterface, int i2) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "$fActivity");
        TranslationApp.startRoleVprintActivity$ar_translator_intlRelease(fragmentActivity);
    }

    public static final void v1(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
    }

    public static final void x1(DialogueTranslationFragment dialogueTranslationFragment, DialogInterface dialogInterface, int i2) {
        Intrinsics.checkNotNullParameter(dialogueTranslationFragment, "$this_run");
        TranslateStateManager p2 = TranslationManager.q.a().p();
        if (p2 != null) {
            p2.y();
        }
        dialogueTranslationFragment.c1().W(dialogueTranslationFragment.c);
        dialogueTranslationFragment.g = true;
        dialogueTranslationFragment.c = 3;
        dialogueTranslationFragment.P1();
    }

    public static final void y1(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
    }

    public final void B1(LinearLayoutManager linearLayoutManager) {
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding = this.f6274a;
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding2 = null;
        if (fragmentDialogueTranslationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding = null;
        }
        int computeVerticalScrollRange = fragmentDialogueTranslationBinding.x.computeVerticalScrollRange();
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding3 = this.f6274a;
        if (fragmentDialogueTranslationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding3 = null;
        }
        if (computeVerticalScrollRange >= fragmentDialogueTranslationBinding3.x.getHeight()) {
            FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding4 = this.f6274a;
            if (fragmentDialogueTranslationBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentDialogueTranslationBinding2 = fragmentDialogueTranslationBinding4;
            }
            DialogueTranslationFragment$smoothScrollToBottomInternal$scroller$1 dialogueTranslationFragment$smoothScrollToBottomInternal$scroller$1 = new DialogueTranslationFragment$smoothScrollToBottomInternal$scroller$1(fragmentDialogueTranslationBinding2.x.getContext());
            dialogueTranslationFragment$smoothScrollToBottomInternal$scroller$1.setTargetPosition(linearLayoutManager.getItemCount() - 1);
            linearLayoutManager.startSmoothScroll(dialogueTranslationFragment$smoothScrollToBottomInternal$scroller$1);
        }
    }

    public final void C1() {
        if (TranslatorConstants.getRoleVprint().length == 0) {
            t1();
        } else if (!c1().N()) {
            DialogueRunningAdapter dialogueRunningAdapter = this.l;
            if (dialogueRunningAdapter != null) {
                dialogueRunningAdapter.G0(false);
            }
            H1();
        } else {
            AlertDialog alertDialog = this.k;
            if (alertDialog != null) {
                alertDialog.show();
                return;
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                LayoutTlDialogCustomTitleBinding c2 = LayoutTlDialogCustomTitleBinding.c(activity.getLayoutInflater());
                c2.c.setText(R.string.tl_phone_speaker_broadcast);
                TextView textView = c2.b;
                Intrinsics.checkNotNullExpressionValue(textView, "tvDialogMessage");
                textView.setVisibility(0);
                c2.b.setText(R.string.tl_phone_speaker_broadcast_content);
                Intrinsics.checkNotNullExpressionValue(c2, "apply(...)");
                AlertDialog create = new AlertDialog.Builder(activity).setPositiveButton(R.string.tl_report, (DialogInterface.OnClickListener) new q(this)).setNegativeButton(R.string.tl_not_report, (DialogInterface.OnClickListener) new b(this)).create();
                Intrinsics.checkNotNull(create);
                DialogExtKt.a(create);
                create.setCustomTitle(c2.getRoot());
                create.setCanceledOnTouchOutside(false);
                create.setCancelable(false);
                create.show();
                this.k = create;
            }
        }
    }

    public final void F1() {
        if (!c1().M()) {
            FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding = this.f6274a;
            FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding2 = null;
            if (fragmentDialogueTranslationBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentDialogueTranslationBinding = null;
            }
            fragmentDialogueTranslationBinding.J.setText(R.string.tl_telephone_trans_support_language_tip);
            FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding3 = this.f6274a;
            if (fragmentDialogueTranslationBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentDialogueTranslationBinding2 = fragmentDialogueTranslationBinding3;
            }
            fragmentDialogueTranslationBinding2.e.setEnabled(false);
            return;
        }
        H1();
    }

    public final void H1() {
        this.c = 3;
        P1();
        c1().b0();
        c1().V();
    }

    public final void I1() {
        boolean K = c1().K();
        LogExt.j("startTranslation 是否正在通话中[" + K + "]", "DialogueTranslationFragment");
        if (K) {
            F1();
        } else {
            C1();
        }
    }

    public final void J1() {
        TranslateStateManager p2 = TranslationManager.q.a().p();
        if (p2 != null) {
            p2.y();
        }
        DialogueTranslationViewModel.X(c1(), 0, 1, (Object) null);
        this.e = true;
    }

    public final void K1(boolean z) {
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding = null;
        if (z) {
            FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding2 = this.f6274a;
            if (fragmentDialogueTranslationBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentDialogueTranslationBinding2 = null;
            }
            fragmentDialogueTranslationBinding2.E.setText(getString(R.string.tl_paused));
        } else {
            FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding3 = this.f6274a;
            if (fragmentDialogueTranslationBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentDialogueTranslationBinding3 = null;
            }
            fragmentDialogueTranslationBinding3.E.setText(getString(c1().K() ? R.string.tl_telephone_trans_running : R.string.tl_simultaneous_in_translate));
        }
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding4 = this.f6274a;
        if (fragmentDialogueTranslationBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentDialogueTranslationBinding = fragmentDialogueTranslationBinding4;
        }
        fragmentDialogueTranslationBinding.E.requestLayout();
    }

    public final void L1(boolean z) {
        float f2 = z ? 0.25f : 1.0f;
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding = this.f6274a;
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding2 = null;
        if (fragmentDialogueTranslationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding = null;
        }
        fragmentDialogueTranslationBinding.t.setAlpha(f2);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding3 = this.f6274a;
        if (fragmentDialogueTranslationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding3 = null;
        }
        fragmentDialogueTranslationBinding3.F.setAlpha(f2);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding4 = this.f6274a;
        if (fragmentDialogueTranslationBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentDialogueTranslationBinding2 = fragmentDialogueTranslationBinding4;
        }
        fragmentDialogueTranslationBinding2.y.setAlpha(f2);
    }

    public final void M1(TranslationLanguage translationLanguage) {
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding = this.f6274a;
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding2 = null;
        if (fragmentDialogueTranslationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding = null;
        }
        fragmentDialogueTranslationBinding.F.setText(translationLanguage.getSrc().getLangName());
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding3 = this.f6274a;
        if (fragmentDialogueTranslationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding3 = null;
        }
        fragmentDialogueTranslationBinding3.y.setText(translationLanguage.getDst().getLangName());
        DialogueUserTips F = c1().F();
        String component1 = F.component1();
        String component2 = F.component2();
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding4 = this.f6274a;
        if (fragmentDialogueTranslationBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding4 = null;
        }
        fragmentDialogueTranslationBinding4.M.setText(component1);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding5 = this.f6274a;
        if (fragmentDialogueTranslationBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding5 = null;
        }
        fragmentDialogueTranslationBinding5.L.setText(component2);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding6 = this.f6274a;
        if (fragmentDialogueTranslationBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding6 = null;
        }
        fragmentDialogueTranslationBinding6.M.post(new o(translationLanguage, this));
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding7 = this.f6274a;
        if (fragmentDialogueTranslationBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding7 = null;
        }
        fragmentDialogueTranslationBinding7.L.post(new p(translationLanguage, this));
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding8 = this.f6274a;
        if (fragmentDialogueTranslationBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding8 = null;
        }
        fragmentDialogueTranslationBinding8.K.setText(c1().D());
        IPhoneCallStatus value = TranslatorConstants.getPhoneCallStatus().getValue();
        if (value != null) {
            if (this.d || value.getCallStatus() != 2) {
                FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding9 = this.f6274a;
                if (fragmentDialogueTranslationBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentDialogueTranslationBinding9 = null;
                }
                fragmentDialogueTranslationBinding9.J.setText(R.string.tl_telephone_use_inst);
                FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding10 = this.f6274a;
                if (fragmentDialogueTranslationBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    fragmentDialogueTranslationBinding2 = fragmentDialogueTranslationBinding10;
                }
                fragmentDialogueTranslationBinding2.e.setEnabled(true);
            } else if (c1().M()) {
                FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding11 = this.f6274a;
                if (fragmentDialogueTranslationBinding11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentDialogueTranslationBinding11 = null;
                }
                fragmentDialogueTranslationBinding11.J.setText(R.string.tl_telephone_use_inst);
                FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding12 = this.f6274a;
                if (fragmentDialogueTranslationBinding12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    fragmentDialogueTranslationBinding2 = fragmentDialogueTranslationBinding12;
                }
                fragmentDialogueTranslationBinding2.e.setEnabled(true);
            }
        }
        DialogueRunningAdapter dialogueRunningAdapter = this.l;
        if (dialogueRunningAdapter != null) {
            boolean areEqual = Intrinsics.areEqual((Object) translationLanguage.getSrc().getLangType(), (Object) "ar");
            FragmentActivity activity = getActivity();
            dialogueRunningAdapter.H0(areEqual, activity != null ? ContextExtKt.f(activity) : false);
        }
    }

    public final void P1() {
        LogExt.g("updatePreparingUI ", "DialogueTranslationFragment");
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding = this.f6274a;
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding2 = null;
        if (fragmentDialogueTranslationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding = null;
        }
        Group group = fragmentDialogueTranslationBinding.k;
        Intrinsics.checkNotNullExpressionValue(group, "gpLangSelected");
        group.setVisibility(0);
        L1(true);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding3 = this.f6274a;
        if (fragmentDialogueTranslationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding3 = null;
        }
        TextView textView = fragmentDialogueTranslationBinding3.H;
        Intrinsics.checkNotNullExpressionValue(textView, "tvStartBtn");
        textView.setVisibility(8);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding4 = this.f6274a;
        if (fragmentDialogueTranslationBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding4 = null;
        }
        LottieAnimationView lottieAnimationView = fragmentDialogueTranslationBinding4.v;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "lottieStartLoading");
        lottieAnimationView.setVisibility(0);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding5 = this.f6274a;
        if (fragmentDialogueTranslationBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding5 = null;
        }
        fragmentDialogueTranslationBinding5.v.setRepeatCount(-1);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding6 = this.f6274a;
        if (fragmentDialogueTranslationBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentDialogueTranslationBinding2 = fragmentDialogueTranslationBinding6;
        }
        fragmentDialogueTranslationBinding2.v.playAnimation();
        this.f = true;
    }

    public final void Q1() {
        List data;
        LogExt.g("updateStartUI", "DialogueTranslationFragment");
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding = this.f6274a;
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding2 = null;
        if (fragmentDialogueTranslationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding = null;
        }
        Group group = fragmentDialogueTranslationBinding.k;
        Intrinsics.checkNotNullExpressionValue(group, "gpLangSelected");
        int i2 = 8;
        group.setVisibility(8);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding3 = this.f6274a;
        if (fragmentDialogueTranslationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding3 = null;
        }
        Group group2 = fragmentDialogueTranslationBinding3.n;
        Intrinsics.checkNotNullExpressionValue(group2, "gpUserTip");
        group2.setVisibility(8);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding4 = this.f6274a;
        if (fragmentDialogueTranslationBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding4 = null;
        }
        LinearLayout linearLayout = fragmentDialogueTranslationBinding4.r;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "llTeleUseInst");
        linearLayout.setVisibility(8);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding5 = this.f6274a;
        if (fragmentDialogueTranslationBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding5 = null;
        }
        Group group3 = fragmentDialogueTranslationBinding5.m;
        Intrinsics.checkNotNullExpressionValue(group3, "gpTransRunning");
        group3.setVisibility(0);
        K1(false);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding6 = this.f6274a;
        if (fragmentDialogueTranslationBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding6 = null;
        }
        fragmentDialogueTranslationBinding6.u.setRepeatCount(-1);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding7 = this.f6274a;
        if (fragmentDialogueTranslationBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding7 = null;
        }
        fragmentDialogueTranslationBinding7.u.playAnimation();
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding8 = this.f6274a;
        if (fragmentDialogueTranslationBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding8 = null;
        }
        TextView textView = fragmentDialogueTranslationBinding8.H;
        Intrinsics.checkNotNullExpressionValue(textView, "tvStartBtn");
        textView.setVisibility(0);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding9 = this.f6274a;
        if (fragmentDialogueTranslationBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding9 = null;
        }
        LottieAnimationView lottieAnimationView = fragmentDialogueTranslationBinding9.v;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "lottieStartLoading");
        lottieAnimationView.setVisibility(8);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding10 = this.f6274a;
        if (fragmentDialogueTranslationBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding10 = null;
        }
        fragmentDialogueTranslationBinding10.v.cancelAnimation();
        DialogueRunningAdapter dialogueRunningAdapter = this.l;
        if (!(dialogueRunningAdapter == null || (data = dialogueRunningAdapter.getData()) == null)) {
            data.clear();
        }
        DialogueRunningAdapter dialogueRunningAdapter2 = this.l;
        if (dialogueRunningAdapter2 != null) {
            dialogueRunningAdapter2.notifyDataSetChanged();
        }
        a1();
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding11 = this.f6274a;
        if (fragmentDialogueTranslationBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding11 = null;
        }
        ConstraintLayout constraintLayout = fragmentDialogueTranslationBinding11.d;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "clRecords");
        constraintLayout.setVisibility(0);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding12 = this.f6274a;
        if (fragmentDialogueTranslationBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentDialogueTranslationBinding2 = fragmentDialogueTranslationBinding12;
        }
        LinearLayout linearLayout2 = fragmentDialogueTranslationBinding2.s;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "llUseInst");
        if (!c1().K()) {
            i2 = 0;
        }
        linearLayout2.setVisibility(i2);
        this.n = false;
        this.o = -1;
        this.p = false;
        this.d = true;
    }

    public final void R1() {
        List data;
        LogExt.g("updateStopUI", "DialogueTranslationFragment");
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding = this.f6274a;
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding2 = null;
        if (fragmentDialogueTranslationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding = null;
        }
        Group group = fragmentDialogueTranslationBinding.k;
        Intrinsics.checkNotNullExpressionValue(group, "gpLangSelected");
        group.setVisibility(0);
        L1(false);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding3 = this.f6274a;
        if (fragmentDialogueTranslationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding3 = null;
        }
        Group group2 = fragmentDialogueTranslationBinding3.n;
        Intrinsics.checkNotNullExpressionValue(group2, "gpUserTip");
        group2.setVisibility(0);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding4 = this.f6274a;
        if (fragmentDialogueTranslationBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding4 = null;
        }
        LinearLayout linearLayout = fragmentDialogueTranslationBinding4.r;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "llTeleUseInst");
        linearLayout.setVisibility(c1().K() ? 0 : 8);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding5 = this.f6274a;
        if (fragmentDialogueTranslationBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding5 = null;
        }
        Group group3 = fragmentDialogueTranslationBinding5.m;
        Intrinsics.checkNotNullExpressionValue(group3, "gpTransRunning");
        group3.setVisibility(8);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding6 = this.f6274a;
        if (fragmentDialogueTranslationBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding6 = null;
        }
        fragmentDialogueTranslationBinding6.u.cancelAnimation();
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding7 = this.f6274a;
        if (fragmentDialogueTranslationBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding7 = null;
        }
        TextView textView = fragmentDialogueTranslationBinding7.H;
        Intrinsics.checkNotNullExpressionValue(textView, "tvStartBtn");
        textView.setVisibility(0);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding8 = this.f6274a;
        if (fragmentDialogueTranslationBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding8 = null;
        }
        LottieAnimationView lottieAnimationView = fragmentDialogueTranslationBinding8.v;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "lottieStartLoading");
        lottieAnimationView.setVisibility(8);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding9 = this.f6274a;
        if (fragmentDialogueTranslationBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding9 = null;
        }
        fragmentDialogueTranslationBinding9.v.cancelAnimation();
        DialogueRunningAdapter dialogueRunningAdapter = this.l;
        if (!(dialogueRunningAdapter == null || (data = dialogueRunningAdapter.getData()) == null)) {
            data.clear();
        }
        DialogueRunningAdapter dialogueRunningAdapter2 = this.l;
        if (dialogueRunningAdapter2 != null) {
            dialogueRunningAdapter2.notifyDataSetChanged();
        }
        DialogueRunningAdapter dialogueRunningAdapter3 = this.l;
        if (dialogueRunningAdapter3 != null) {
            dialogueRunningAdapter3.G0(false);
        }
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding10 = this.f6274a;
        if (fragmentDialogueTranslationBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding10 = null;
        }
        Group group4 = fragmentDialogueTranslationBinding10.l;
        Intrinsics.checkNotNullExpressionValue(group4, "gpNoData");
        group4.setVisibility(8);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding11 = this.f6274a;
        if (fragmentDialogueTranslationBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding11 = null;
        }
        ConstraintLayout constraintLayout = fragmentDialogueTranslationBinding11.d;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "clRecords");
        constraintLayout.setVisibility(8);
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding12 = this.f6274a;
        if (fragmentDialogueTranslationBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentDialogueTranslationBinding2 = fragmentDialogueTranslationBinding12;
        }
        LinearLayout linearLayout2 = fragmentDialogueTranslationBinding2.s;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "llUseInst");
        linearLayout2.setVisibility(8);
        this.n = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.o = -1;
        this.p = false;
        c1().e0();
        c1().Y();
    }

    public final void S1() {
        DialogueRunningAdapter dialogueRunningAdapter = this.l;
        if (dialogueRunningAdapter != null) {
            List data = dialogueRunningAdapter.getData();
            int i2 = this.o;
            if (i2 == -1 || i2 > CollectionsKt.getLastIndex(data)) {
                int i3 = this.o;
                LogExt.j("updateTtsStartStatus tts播报开始更新状态异常[" + i3 + "]", "DialogueTranslationFragment");
                return;
            }
            DialogueRunning dialogueRunning = (DialogueRunning) data.get(this.o);
            int i4 = this.o;
            LogExt.j("updateTtsStartStatus pos=" + i4 + ", data=" + dialogueRunning, "DialogueTranslationFragment");
            if (dialogueRunning.getPlayStatus() != 1) {
                dialogueRunning.setPlayStatus(1);
                dialogueRunningAdapter.j0(this.o, dialogueRunning);
            }
        }
    }

    public final void T1() {
        DialogueRunningAdapter dialogueRunningAdapter = this.l;
        if (dialogueRunningAdapter != null) {
            List data = dialogueRunningAdapter.getData();
            int i2 = this.o;
            if (i2 == -1 || i2 > CollectionsKt.getLastIndex(data)) {
                int i3 = this.o;
                LogExt.j("updateTtsStopStatus tts播报结束更新状态异常[" + i3 + "]", "DialogueTranslationFragment");
                return;
            }
            DialogueRunning dialogueRunning = (DialogueRunning) data.get(this.o);
            int i4 = this.o;
            LogExt.j("updateTtsStopStatus pos=" + i4 + ", data=" + dialogueRunning, "DialogueTranslationFragment");
            if (dialogueRunning.getPlayStatus() != 0) {
                dialogueRunning.setPlayStatus(0);
                dialogueRunningAdapter.j0(this.o, dialogueRunning);
            }
        }
    }

    public final void a1() {
        List e2;
        RunningRecordHelper o2 = TranslationManager.q.a().o();
        if (o2 != null && (e2 = o2.e()) != null) {
            FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding = this.f6274a;
            FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding2 = null;
            if (fragmentDialogueTranslationBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentDialogueTranslationBinding = null;
            }
            fragmentDialogueTranslationBinding.C.setText(getString(c1().K() ? R.string.tl_telephone_trans_no_data_tip : R.string.tl_dialog_trans_no_data_tip));
            if (e2.isEmpty()) {
                FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding3 = this.f6274a;
                if (fragmentDialogueTranslationBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    fragmentDialogueTranslationBinding2 = fragmentDialogueTranslationBinding3;
                }
                Group group = fragmentDialogueTranslationBinding2.l;
                Intrinsics.checkNotNullExpressionValue(group, "gpNoData");
                group.setVisibility(0);
                return;
            }
            FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding4 = this.f6274a;
            if (fragmentDialogueTranslationBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentDialogueTranslationBinding2 = fragmentDialogueTranslationBinding4;
            }
            Group group2 = fragmentDialogueTranslationBinding2.l;
            Intrinsics.checkNotNullExpressionValue(group2, "gpNoData");
            group2.setVisibility(8);
            DialogueRunningAdapter dialogueRunningAdapter = this.l;
            if (dialogueRunningAdapter != null) {
                dialogueRunningAdapter.r(e2);
            }
            q1();
        }
    }

    public final void b1(DialogueRunning dialogueRunning) {
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding = this.f6274a;
        if (fragmentDialogueTranslationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding = null;
        }
        Group group = fragmentDialogueTranslationBinding.l;
        Intrinsics.checkNotNullExpressionValue(group, "gpNoData");
        group.setVisibility(8);
        DialogueRunningAdapter dialogueRunningAdapter = this.l;
        if (dialogueRunningAdapter == null) {
            return;
        }
        if (dialogueRunning.getItemUpdateType() == 1) {
            dialogueRunningAdapter.q(dialogueRunning);
            z1();
            return;
        }
        for (IndexedValue indexedValue : CollectionsKt.reversed(CollectionsKt.withIndex(dialogueRunningAdapter.getData()))) {
            int component1 = indexedValue.component1();
            DialogueRunning dialogueRunning2 = (DialogueRunning) indexedValue.component2();
            if (dialogueRunning.getItemUpdateIndex() == dialogueRunning2.getItemUpdateIndex()) {
                LogExt.g("update[" + dialogueRunning + "], original=" + dialogueRunning2, "DialogueTranslationFragment");
                if (dialogueRunning.getSpeaker() != 1 || !dialogueRunning2.isDone() || dialogueRunning2.getPlayStatus() == 0) {
                    dialogueRunningAdapter.j0(component1, dialogueRunning);
                    z1();
                    return;
                }
                return;
            }
        }
    }

    public final DialogueTranslationViewModel c1() {
        return (DialogueTranslationViewModel) this.b.getValue();
    }

    public final void d1(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        int id = view.getId();
        if (id == R.id.iv_me_play) {
            List data = baseQuickAdapter.getData();
            Object obj = data.get(i2);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.upuphone.ar.translation.phone.bean.DialogueRunning");
            DialogueRunning dialogueRunning = (DialogueRunning) obj;
            if (dialogueRunning.isDone()) {
                int i3 = this.o;
                if (i3 == -1 || i3 > CollectionsKt.getLastIndex(data)) {
                    int i4 = this.o;
                    LogExt.j("handleItemChildClick playTts 上一次播报记录异常[" + i4 + "]", "DialogueTranslationFragment");
                } else {
                    Object obj2 = data.get(this.o);
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.upuphone.ar.translation.phone.bean.DialogueRunning");
                    DialogueRunning dialogueRunning2 = (DialogueRunning) obj2;
                    if (dialogueRunning2.getPlayStatus() != 0) {
                        dialogueRunning2.setPlayStatus(0);
                        baseQuickAdapter.j0(this.o, dialogueRunning2);
                        this.p = true;
                    }
                }
                dialogueRunning.setPlayStatus(2);
                baseQuickAdapter.j0(i2, dialogueRunning);
                this.o = i2;
                LogExt.j("handleItemChildClick playTts[curPos=" + i2 + "]", "DialogueTranslationFragment");
                String text = dialogueRunning.getText();
                String tempText = dialogueRunning.getTempText();
                c1().S(StringsKt.trim((CharSequence) text + tempText).toString());
            }
        } else if (id == R.id.lottie_tts) {
            Object obj3 = baseQuickAdapter.getData().get(i2);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type com.upuphone.ar.translation.phone.bean.DialogueRunning");
            DialogueRunning dialogueRunning3 = (DialogueRunning) obj3;
            int playStatus = dialogueRunning3.getPlayStatus();
            LogExt.j("handleItemChildClick StopTts position=" + i2 + ", data=" + playStatus, "DialogueTranslationFragment");
            if (dialogueRunning3.getPlayStatus() == 1 || dialogueRunning3.getPlayStatus() != 0) {
                dialogueRunning3.setPlayStatus(0);
                baseQuickAdapter.j0(i2, dialogueRunning3);
                c1().e0();
            }
        }
    }

    public final void e1(TranslationState translationState) {
        int extCode = translationState.getExtCode();
        String i2 = InterconnectMsgCodExtKt.i(extCode);
        LogExt.j("handleTransExtState extCode" + i2, "DialogueTranslationFragment");
        if (InterconnectMsgCodExtKt.d(extCode)) {
            R1();
        } else if (InterconnectMsgCodExtKt.b(extCode)) {
            K1(true);
        } else if (InterconnectMsgCodExtKt.c(extCode)) {
            K1(false);
        }
    }

    public final void f1(TranslationState translationState) {
        int transState = translationState.getTransState();
        String j2 = InterconnectMsgCodExtKt.j(transState);
        LogExt.j("handleTransState state" + j2, "DialogueTranslationFragment");
        if (transState == 2) {
            R1();
        } else if (transState == 3) {
            P1();
        } else if (transState == 4) {
            Q1();
        }
    }

    public final void g1(TransStateEvent transStateEvent) {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new DialogueTranslationFragment$handleTranslateState$1(transStateEvent, this, (Continuation<? super DialogueTranslationFragment$handleTranslateState$1>) null), 3, (Object) null);
    }

    public final void h1(OperateMessage operateMessage) {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new DialogueTranslationFragment$handleVariousMsg$1(operateMessage, this, (Continuation<? super DialogueTranslationFragment$handleVariousMsg$1>) null), 3, (Object) null);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentDialogueTranslationBinding c2 = FragmentDialogueTranslationBinding.c(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f6274a = c2;
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
        LogExt.j("onDestroyView 对话翻译页面销毁", "DialogueTranslationFragment");
        c1().k0();
        this.c = 3;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        TranslationLangDialog translationLangDialog = this.h;
        if (translationLangDialog != null) {
            translationLangDialog.dismiss();
        }
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding = null;
        this.h = null;
        AlertDialog alertDialog = this.i;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.i = null;
        AlertDialog alertDialog2 = this.j;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        this.j = null;
        AlertDialog alertDialog3 = this.k;
        if (alertDialog3 != null) {
            alertDialog3.dismiss();
        }
        this.k = null;
        this.n = false;
        this.o = -1;
        this.p = false;
        this.q = false;
        TranslationApp.unRegisterUiUpdateCallback$ar_translator_intlRelease("DialogueTranslationFragment");
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding2 = this.f6274a;
        if (fragmentDialogueTranslationBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding2 = null;
        }
        if (fragmentDialogueTranslationBinding2.t.isAnimating()) {
            FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding3 = this.f6274a;
            if (fragmentDialogueTranslationBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentDialogueTranslationBinding3 = null;
            }
            fragmentDialogueTranslationBinding3.t.cancelAnimation();
        }
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding4 = this.f6274a;
        if (fragmentDialogueTranslationBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding4 = null;
        }
        if (fragmentDialogueTranslationBinding4.u.isAnimating()) {
            FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding5 = this.f6274a;
            if (fragmentDialogueTranslationBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentDialogueTranslationBinding5 = null;
            }
            fragmentDialogueTranslationBinding5.u.cancelAnimation();
        }
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding6 = this.f6274a;
        if (fragmentDialogueTranslationBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding6 = null;
        }
        if (fragmentDialogueTranslationBinding6.v.isAnimating()) {
            FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding7 = this.f6274a;
            if (fragmentDialogueTranslationBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentDialogueTranslationBinding = fragmentDialogueTranslationBinding7;
            }
            fragmentDialogueTranslationBinding.v.cancelAnimation();
        }
    }

    public void onPause() {
        super.onPause();
        c1().e0();
    }

    public void onResume() {
        super.onResume();
        if (this.q) {
            FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding = this.f6274a;
            if (fragmentDialogueTranslationBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentDialogueTranslationBinding = null;
            }
            ConstraintLayout constraintLayout = fragmentDialogueTranslationBinding.c;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "clLowVersionTip");
            constraintLayout.setVisibility(GlassVersionHelper.INSTANCE.isDomOta1ForAirPro() ^ true ? 0 : 8);
            this.q = false;
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
        initData();
        initListener();
        initViewModels();
    }

    public final void q1() {
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding = this.f6274a;
        if (fragmentDialogueTranslationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding = null;
        }
        fragmentDialogueTranslationBinding.x.post(new c(this));
    }

    public final void s1() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (this.h == null) {
                TranslationLangDialog translationLangDialog = new TranslationLangDialog(activity, new DialogueTranslationFragment$showLanguageDialog$1$1(this));
                String string = getString(R.string.tl_dialogue_trans_lang_tip_opposite);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String string2 = getString(R.string.tl_dialogue_trans_lang_tip_myself);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                translationLangDialog.y(string, string2);
                this.h = translationLangDialog;
            }
            TranslationLanguage translationLanguage = (TranslationLanguage) c1().y().getValue();
            if (translationLanguage != null) {
                LanguageBean src = translationLanguage.getSrc();
                LanguageBean dst = translationLanguage.getDst();
                LogExt.j("showLanguageDialog src=" + src + ", dst=" + dst, "DialogueTranslationFragment");
                TranslationLangDialog translationLangDialog2 = this.h;
                if (translationLangDialog2 != null) {
                    translationLangDialog2.v(src, dst);
                }
            }
            TranslationLangDialog translationLangDialog3 = this.h;
            if (translationLangDialog3 != null) {
                translationLangDialog3.A(ActivityExtKt.b(activity));
            }
            TranslationLangDialog translationLangDialog4 = this.h;
            if (translationLangDialog4 != null) {
                translationLangDialog4.show();
            }
        }
    }

    public final void t1() {
        Unit unit;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            AlertDialog alertDialog = this.j;
            if (alertDialog != null) {
                alertDialog.show();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                LayoutTlDialogCustomTitleBinding c2 = LayoutTlDialogCustomTitleBinding.c(activity.getLayoutInflater());
                c2.c.setText(R.string.tl_dialog_not_role_vprint_title);
                Intrinsics.checkNotNullExpressionValue(c2, "apply(...)");
                AlertDialog create = new AlertDialog.Builder(activity).setPositiveButton(R.string.tl_dialog_not_role_vprint_entry, (DialogInterface.OnClickListener) new f(activity)).setNegativeButton(R.string.tl_dialog_cancel, (DialogInterface.OnClickListener) new g()).create();
                Intrinsics.checkNotNull(create);
                DialogExtKt.a(create);
                create.setCustomTitle(c2.getRoot());
                create.show();
                this.j = create;
            }
        }
    }

    public final void w1() {
        Unit unit;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            AlertDialog alertDialog = this.i;
            if (alertDialog != null) {
                alertDialog.show();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                LayoutTlDialogCustomTitleBinding c2 = LayoutTlDialogCustomTitleBinding.c(activity.getLayoutInflater());
                c2.c.setText(R.string.tl_translate_running_start_translate);
                Intrinsics.checkNotNullExpressionValue(c2, "apply(...)");
                AlertDialog create = new AlertDialog.Builder(activity).setPositiveButton(R.string.tl_dialog_ok, (DialogInterface.OnClickListener) new d(this)).setNegativeButton(R.string.tl_dialog_cancel, (DialogInterface.OnClickListener) new e()).create();
                Intrinsics.checkNotNull(create);
                DialogExtKt.a(create);
                create.setCustomTitle(c2.getRoot());
                create.show();
                this.i = create;
            }
        }
    }

    public final void z1() {
        FragmentDialogueTranslationBinding fragmentDialogueTranslationBinding = this.f6274a;
        if (fragmentDialogueTranslationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentDialogueTranslationBinding = null;
        }
        fragmentDialogueTranslationBinding.x.post(new h(this));
    }
}
