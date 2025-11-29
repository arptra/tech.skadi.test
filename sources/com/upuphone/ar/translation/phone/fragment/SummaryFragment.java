package com.upuphone.ar.translation.phone.fragment;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import com.honey.account.f5.g0;
import com.honey.account.f5.h0;
import com.honey.account.f5.i0;
import com.honey.account.f5.j0;
import com.honey.account.f5.k0;
import com.meizu.common.widget.MzButton;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.AnyExtKt;
import com.upuphone.ar.translation.ext.ContextExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.ext.StringExtKt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.bean.IntelExtnSummary;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.databinding.FragmentSummaryBinding;
import com.upuphone.ar.translation.phone.helper.InterConnectHelper;
import com.upuphone.ar.translation.phone.view.ClipboardEditText;
import com.upuphone.ar.translation.phone.view.TranslatorLoadingView;
import com.upuphone.ar.translation.phone.vm.IntelExtnShareViewModel;
import com.upuphone.ar.translation.phone.vm.IntelExtnSummaryViewModel;
import com.xjsd.xr.sapp.asr.dao.SensitivePayload;
import com.xjsd.xr.sapp.asr.dao.SmartExSummary;
import com.xjsd.xr.sapp.asr.utils.AsrExtKt;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 M2\u00020\u0001:\u0001NB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ\u0019\u0010\u001e\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b \u0010\u001fJ\u000f\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\u0003J\u0017\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&J\u0019\u0010)\u001a\u00020\u00062\b\u0010(\u001a\u0004\u0018\u00010'H\u0002¢\u0006\u0004\b)\u0010*J\u0019\u0010-\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0006H\u0002¢\u0006\u0004\b/\u0010\u0003J\u0017\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020'H\u0002¢\u0006\u0004\b1\u0010*J\u001f\u00106\u001a\u0002052\u0006\u00102\u001a\u00020\r2\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0006H\u0002¢\u0006\u0004\b8\u0010\u0003J\u0017\u00109\u001a\u0002052\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0006H\u0002¢\u0006\u0004\b;\u0010\u0003R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u001b\u0010H\u001a\u00020C8BX\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006O"}, d2 = {"Lcom/upuphone/ar/translation/phone/fragment/SummaryFragment;", "Lcom/upuphone/ar/translation/phone/fragment/TransBaseFragment;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "initData", "initListener", "initViewModels", "getSummary", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "noteBean", "y0", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;)V", "N0", "Lcom/xjsd/xr/sapp/asr/dao/SmartExSummary;", "resSummary", "F0", "(Lcom/xjsd/xr/sapp/asr/dao/SmartExSummary;)V", "H0", "handleSummaryEmpty", "G0", "", "summary", "P0", "(Ljava/lang/String;)V", "Lcom/upuphone/ar/translation/phone/bean/IntelExtnSummary;", "extnSummary", "C0", "(Lcom/upuphone/ar/translation/phone/bean/IntelExtnSummary;)V", "Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;", "sensitive", "E0", "(Lcom/xjsd/xr/sapp/asr/dao/SensitivePayload;)V", "R0", "intelExtnSummary", "A0", "textView", "Landroid/view/MotionEvent;", "event", "", "O0", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "D0", "Q0", "(Landroid/view/MotionEvent;)Z", "I0", "Lcom/upuphone/ar/translation/phone/databinding/FragmentSummaryBinding;", "a", "Lcom/upuphone/ar/translation/phone/databinding/FragmentSummaryBinding;", "mBinding", "b", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "mNoteBean", "Lcom/upuphone/ar/translation/phone/vm/IntelExtnSummaryViewModel;", "c", "Lkotlin/Lazy;", "z0", "()Lcom/upuphone/ar/translation/phone/vm/IntelExtnSummaryViewModel;", "mSummaryViewModel", "Lcom/upuphone/ar/translation/phone/vm/IntelExtnShareViewModel;", "d", "Lcom/upuphone/ar/translation/phone/vm/IntelExtnShareViewModel;", "mIntelExtnShareVm", "e", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nSummaryFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SummaryFragment.kt\ncom/upuphone/ar/translation/phone/fragment/SummaryFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,678:1\n106#2,15:679\n262#3,2:694\n262#3,2:696\n262#3,2:698\n262#3,2:700\n262#3,2:702\n262#3,2:704\n262#3,2:706\n262#3,2:708\n262#3,2:710\n262#3,2:712\n262#3,2:714\n262#3,2:716\n262#3,2:718\n262#3,2:720\n262#3,2:722\n262#3,2:724\n262#3,2:726\n262#3,2:728\n262#3,2:730\n262#3,2:732\n262#3,2:734\n262#3,2:736\n262#3,2:738\n262#3,2:740\n262#3,2:742\n262#3,2:744\n262#3,2:746\n262#3,2:748\n262#3,2:750\n262#3,2:752\n262#3,2:754\n262#3,2:756\n262#3,2:758\n262#3,2:760\n262#3,2:762\n262#3,2:764\n262#3,2:766\n262#3,2:768\n262#3,2:770\n262#3,2:772\n262#3,2:774\n262#3,2:776\n260#3:778\n262#3,2:779\n262#3,2:781\n262#3,2:783\n262#3,2:785\n262#3,2:787\n262#3,2:789\n262#3,2:791\n262#3,2:793\n262#3,2:795\n262#3,2:797\n262#3,2:799\n262#3,2:801\n*S KotlinDebug\n*F\n+ 1 SummaryFragment.kt\ncom/upuphone/ar/translation/phone/fragment/SummaryFragment\n*L\n69#1:679,15\n206#1:694,2\n233#1:696,2\n239#1:698,2\n240#1:700,2\n241#1:702,2\n254#1:704,2\n281#1:706,2\n282#1:708,2\n301#1:710,2\n302#1:712,2\n318#1:714,2\n320#1:716,2\n341#1:718,2\n342#1:720,2\n351#1:722,2\n352#1:724,2\n397#1:726,2\n398#1:728,2\n399#1:730,2\n400#1:732,2\n401#1:734,2\n407#1:736,2\n408#1:738,2\n409#1:740,2\n420#1:742,2\n421#1:744,2\n422#1:746,2\n423#1:748,2\n428#1:750,2\n429#1:752,2\n430#1:754,2\n431#1:756,2\n432#1:758,2\n436#1:760,2\n437#1:762,2\n438#1:764,2\n439#1:766,2\n440#1:768,2\n462#1:770,2\n463#1:772,2\n465#1:774,2\n466#1:776,2\n508#1:778\n518#1:779,2\n519#1:781,2\n521#1:783,2\n527#1:785,2\n535#1:787,2\n540#1:789,2\n544#1:791,2\n545#1:793,2\n547#1:795,2\n553#1:797,2\n561#1:799,2\n566#1:801,2\n*E\n"})
public final class SummaryFragment extends TransBaseFragment {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public FragmentSummaryBinding f6284a;
    public NoteBean b;
    public final Lazy c;
    public IntelExtnShareViewModel d;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/ar/translation/phone/fragment/SummaryFragment$Companion;", "", "<init>", "()V", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "noteBean", "Lcom/upuphone/ar/translation/phone/fragment/SummaryFragment;", "a", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;)Lcom/upuphone/ar/translation/phone/fragment/SummaryFragment;", "", "TAG", "Ljava/lang/String;", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SummaryFragment a(NoteBean noteBean) {
            SummaryFragment summaryFragment = new SummaryFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(TranslatorConstants.TRANSFER_TRANS_RECORD, noteBean);
            summaryFragment.setArguments(bundle);
            return summaryFragment;
        }

        public Companion() {
        }
    }

    public SummaryFragment() {
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SummaryFragment$special$$inlined$viewModels$default$2(new SummaryFragment$special$$inlined$viewModels$default$1(this)));
        this.c = FragmentViewModelLazyKt.c(this, Reflection.getOrCreateKotlinClass(IntelExtnSummaryViewModel.class), new SummaryFragment$special$$inlined$viewModels$default$3(lazy), new SummaryFragment$special$$inlined$viewModels$default$4((Function0) null, lazy), new SummaryFragment$special$$inlined$viewModels$default$5(this, lazy));
    }

    public static final void B0(SummaryFragment summaryFragment, IntelExtnSummary intelExtnSummary) {
        Intrinsics.checkNotNullParameter(summaryFragment, "this$0");
        Intrinsics.checkNotNullParameter(intelExtnSummary, "$intelExtnSummary");
        FragmentSummaryBinding fragmentSummaryBinding = summaryFragment.f6284a;
        FragmentSummaryBinding fragmentSummaryBinding2 = null;
        if (fragmentSummaryBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSummaryBinding = null;
        }
        int height = fragmentSummaryBinding.c.getHeight();
        FragmentSummaryBinding fragmentSummaryBinding3 = summaryFragment.f6284a;
        if (fragmentSummaryBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSummaryBinding3 = null;
        }
        int height2 = fragmentSummaryBinding3.h.getHeight();
        boolean isReported = intelExtnSummary.isReported();
        LogExt.j("handleAiMark etHeight=" + height + ", svHeight=" + height2 + ", isReported=" + isReported, "SummaryFragment");
        if (height > height2) {
            FragmentSummaryBinding fragmentSummaryBinding4 = summaryFragment.f6284a;
            if (fragmentSummaryBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSummaryBinding4 = null;
            }
            TextView textView = fragmentSummaryBinding4.i;
            Intrinsics.checkNotNullExpressionValue(textView, "tvInnerAiMark");
            textView.setVisibility(8);
            FragmentSummaryBinding fragmentSummaryBinding5 = summaryFragment.f6284a;
            if (fragmentSummaryBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSummaryBinding5 = null;
            }
            TextView textView2 = fragmentSummaryBinding5.j;
            Intrinsics.checkNotNullExpressionValue(textView2, "tvInnerReported");
            textView2.setVisibility(8);
            FragmentSummaryBinding fragmentSummaryBinding6 = summaryFragment.f6284a;
            if (fragmentSummaryBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSummaryBinding6 = null;
            }
            TextView textView3 = fragmentSummaryBinding6.l;
            Intrinsics.checkNotNullExpressionValue(textView3, "tvOuterAiMark");
            textView3.setVisibility(0);
            if (!TranslatorConstants.isIntlVersion()) {
                FragmentSummaryBinding fragmentSummaryBinding7 = summaryFragment.f6284a;
                if (fragmentSummaryBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentSummaryBinding7 = null;
                }
                fragmentSummaryBinding7.l.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
                FragmentSummaryBinding fragmentSummaryBinding8 = summaryFragment.f6284a;
                if (fragmentSummaryBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    fragmentSummaryBinding2 = fragmentSummaryBinding8;
                }
                TextView textView4 = fragmentSummaryBinding2.m;
                Intrinsics.checkNotNullExpressionValue(textView4, "tvOuterReported");
                textView4.setVisibility(8);
            } else if (isReported) {
                FragmentSummaryBinding fragmentSummaryBinding9 = summaryFragment.f6284a;
                if (fragmentSummaryBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentSummaryBinding9 = null;
                }
                fragmentSummaryBinding9.l.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
                FragmentSummaryBinding fragmentSummaryBinding10 = summaryFragment.f6284a;
                if (fragmentSummaryBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    fragmentSummaryBinding2 = fragmentSummaryBinding10;
                }
                TextView textView5 = fragmentSummaryBinding2.m;
                Intrinsics.checkNotNullExpressionValue(textView5, "tvOuterReported");
                textView5.setVisibility(0);
            } else {
                FragmentSummaryBinding fragmentSummaryBinding11 = summaryFragment.f6284a;
                if (fragmentSummaryBinding11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentSummaryBinding11 = null;
                }
                fragmentSummaryBinding11.l.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.icon_tl_smart_extract_report, 0);
                FragmentSummaryBinding fragmentSummaryBinding12 = summaryFragment.f6284a;
                if (fragmentSummaryBinding12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    fragmentSummaryBinding2 = fragmentSummaryBinding12;
                }
                TextView textView6 = fragmentSummaryBinding2.m;
                Intrinsics.checkNotNullExpressionValue(textView6, "tvOuterReported");
                textView6.setVisibility(8);
            }
        } else {
            FragmentSummaryBinding fragmentSummaryBinding13 = summaryFragment.f6284a;
            if (fragmentSummaryBinding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSummaryBinding13 = null;
            }
            TextView textView7 = fragmentSummaryBinding13.l;
            Intrinsics.checkNotNullExpressionValue(textView7, "tvOuterAiMark");
            textView7.setVisibility(8);
            FragmentSummaryBinding fragmentSummaryBinding14 = summaryFragment.f6284a;
            if (fragmentSummaryBinding14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSummaryBinding14 = null;
            }
            TextView textView8 = fragmentSummaryBinding14.m;
            Intrinsics.checkNotNullExpressionValue(textView8, "tvOuterReported");
            textView8.setVisibility(8);
            FragmentSummaryBinding fragmentSummaryBinding15 = summaryFragment.f6284a;
            if (fragmentSummaryBinding15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSummaryBinding15 = null;
            }
            TextView textView9 = fragmentSummaryBinding15.i;
            Intrinsics.checkNotNullExpressionValue(textView9, "tvInnerAiMark");
            textView9.setVisibility(0);
            if (!TranslatorConstants.isIntlVersion()) {
                FragmentSummaryBinding fragmentSummaryBinding16 = summaryFragment.f6284a;
                if (fragmentSummaryBinding16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentSummaryBinding16 = null;
                }
                fragmentSummaryBinding16.i.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
                FragmentSummaryBinding fragmentSummaryBinding17 = summaryFragment.f6284a;
                if (fragmentSummaryBinding17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    fragmentSummaryBinding2 = fragmentSummaryBinding17;
                }
                TextView textView10 = fragmentSummaryBinding2.j;
                Intrinsics.checkNotNullExpressionValue(textView10, "tvInnerReported");
                textView10.setVisibility(8);
            } else if (isReported) {
                FragmentSummaryBinding fragmentSummaryBinding18 = summaryFragment.f6284a;
                if (fragmentSummaryBinding18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentSummaryBinding18 = null;
                }
                fragmentSummaryBinding18.i.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
                FragmentSummaryBinding fragmentSummaryBinding19 = summaryFragment.f6284a;
                if (fragmentSummaryBinding19 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    fragmentSummaryBinding2 = fragmentSummaryBinding19;
                }
                TextView textView11 = fragmentSummaryBinding2.j;
                Intrinsics.checkNotNullExpressionValue(textView11, "tvInnerReported");
                textView11.setVisibility(0);
            } else {
                FragmentSummaryBinding fragmentSummaryBinding20 = summaryFragment.f6284a;
                if (fragmentSummaryBinding20 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentSummaryBinding20 = null;
                }
                fragmentSummaryBinding20.i.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.icon_tl_smart_extract_report, 0);
                FragmentSummaryBinding fragmentSummaryBinding21 = summaryFragment.f6284a;
                if (fragmentSummaryBinding21 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    fragmentSummaryBinding2 = fragmentSummaryBinding21;
                }
                TextView textView12 = fragmentSummaryBinding2.j;
                Intrinsics.checkNotNullExpressionValue(textView12, "tvInnerReported");
                textView12.setVisibility(8);
            }
        }
    }

    private final void I0() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Object systemService = activity.getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    public static final void J0(SummaryFragment summaryFragment, View view) {
        Intrinsics.checkNotNullParameter(summaryFragment, "this$0");
        summaryFragment.getSummary();
    }

    public static final boolean K0(SummaryFragment summaryFragment, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(summaryFragment, "this$0");
        Intrinsics.checkNotNull(view);
        Intrinsics.checkNotNull(motionEvent);
        return summaryFragment.O0(view, motionEvent);
    }

    public static final boolean L0(SummaryFragment summaryFragment, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(summaryFragment, "this$0");
        Intrinsics.checkNotNull(view);
        Intrinsics.checkNotNull(motionEvent);
        return summaryFragment.O0(view, motionEvent);
    }

    public static final boolean M0(SummaryFragment summaryFragment, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(summaryFragment, "this$0");
        Intrinsics.checkNotNull(motionEvent);
        return summaryFragment.Q0(motionEvent);
    }

    private final void initData() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        this.d = (IntelExtnShareViewModel) new ViewModelProvider(requireActivity).get(IntelExtnShareViewModel.class);
        NoteBean noteBean = this.b;
        if (noteBean == null) {
            return;
        }
        if (StringsKt.isBlank(noteBean.getAccountId()) || StringsKt.isBlank(noteBean.getRecognizeId())) {
            LogExt.j("initData 无概要总结可被加载", "SummaryFragment");
        } else {
            z0().l(noteBean);
        }
    }

    private final void initListener() {
        FragmentSummaryBinding fragmentSummaryBinding = this.f6284a;
        FragmentSummaryBinding fragmentSummaryBinding2 = null;
        if (fragmentSummaryBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSummaryBinding = null;
        }
        fragmentSummaryBinding.g.setOnClickListener(new h0(this));
        FragmentSummaryBinding fragmentSummaryBinding3 = this.f6284a;
        if (fragmentSummaryBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSummaryBinding3 = null;
        }
        fragmentSummaryBinding3.c.i(new SummaryFragment$initListener$2(this));
        FragmentSummaryBinding fragmentSummaryBinding4 = this.f6284a;
        if (fragmentSummaryBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSummaryBinding4 = null;
        }
        fragmentSummaryBinding4.i.setOnTouchListener(new i0(this));
        FragmentSummaryBinding fragmentSummaryBinding5 = this.f6284a;
        if (fragmentSummaryBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSummaryBinding5 = null;
        }
        fragmentSummaryBinding5.l.setOnTouchListener(new j0(this));
        FragmentSummaryBinding fragmentSummaryBinding6 = this.f6284a;
        if (fragmentSummaryBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentSummaryBinding2 = fragmentSummaryBinding6;
        }
        fragmentSummaryBinding2.h.setOnTouchListener(new k0(this));
    }

    private final void initViewModels() {
        z0().j().observe(getViewLifecycleOwner(), new SummaryFragment$sam$androidx_lifecycle_Observer$0(new SummaryFragment$initViewModels$1(this)));
        z0().g().observe(getViewLifecycleOwner(), new SummaryFragment$sam$androidx_lifecycle_Observer$0(new SummaryFragment$initViewModels$2(this)));
        z0().h().observe(getViewLifecycleOwner(), new SummaryFragment$sam$androidx_lifecycle_Observer$0(new SummaryFragment$initViewModels$3(this)));
        IntelExtnShareViewModel intelExtnShareViewModel = this.d;
        if (intelExtnShareViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIntelExtnShareVm");
            intelExtnShareViewModel = null;
        }
        intelExtnShareViewModel.j().observe(getViewLifecycleOwner(), new SummaryFragment$sam$androidx_lifecycle_Observer$0(new SummaryFragment$initViewModels$4(this)));
    }

    public final void A0(IntelExtnSummary intelExtnSummary) {
        FragmentSummaryBinding fragmentSummaryBinding = this.f6284a;
        FragmentSummaryBinding fragmentSummaryBinding2 = null;
        if (fragmentSummaryBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSummaryBinding = null;
        }
        ScrollView scrollView = fragmentSummaryBinding.h;
        Intrinsics.checkNotNullExpressionValue(scrollView, "svSummary");
        if (scrollView.getVisibility() == 0) {
            FragmentSummaryBinding fragmentSummaryBinding3 = this.f6284a;
            if (fragmentSummaryBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentSummaryBinding2 = fragmentSummaryBinding3;
            }
            fragmentSummaryBinding2.c.post(new g0(this, intelExtnSummary));
        }
    }

    public final void C0(IntelExtnSummary intelExtnSummary) {
        Unit unit;
        Unit unit2;
        FragmentSummaryBinding fragmentSummaryBinding = null;
        if (intelExtnSummary != null) {
            if (intelExtnSummary.getDeleteStatus() == 1) {
                FragmentSummaryBinding fragmentSummaryBinding2 = this.f6284a;
                if (fragmentSummaryBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentSummaryBinding2 = null;
                }
                ScrollView scrollView = fragmentSummaryBinding2.h;
                Intrinsics.checkNotNullExpressionValue(scrollView, "svSummary");
                scrollView.setVisibility(8);
                FragmentSummaryBinding fragmentSummaryBinding3 = this.f6284a;
                if (fragmentSummaryBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentSummaryBinding3 = null;
                }
                TextView textView = fragmentSummaryBinding3.l;
                Intrinsics.checkNotNullExpressionValue(textView, "tvOuterAiMark");
                textView.setVisibility(8);
                FragmentSummaryBinding fragmentSummaryBinding4 = this.f6284a;
                if (fragmentSummaryBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentSummaryBinding4 = null;
                }
                TextView textView2 = fragmentSummaryBinding4.m;
                Intrinsics.checkNotNullExpressionValue(textView2, "tvOuterReported");
                textView2.setVisibility(8);
                FragmentSummaryBinding fragmentSummaryBinding5 = this.f6284a;
                if (fragmentSummaryBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentSummaryBinding5 = null;
                }
                Group group = fragmentSummaryBinding5.d;
                Intrinsics.checkNotNullExpressionValue(group, "gpSummaryTip");
                group.setVisibility(0);
                FragmentSummaryBinding fragmentSummaryBinding6 = this.f6284a;
                if (fragmentSummaryBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentSummaryBinding6 = null;
                }
                MzButton mzButton = fragmentSummaryBinding6.g;
                Intrinsics.checkNotNullExpressionValue(mzButton, "mbtSummary");
                mzButton.setVisibility(0);
                FragmentSummaryBinding fragmentSummaryBinding7 = this.f6284a;
                if (fragmentSummaryBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentSummaryBinding7 = null;
                }
                fragmentSummaryBinding7.g.setEnabled(true);
                IntelExtnShareViewModel intelExtnShareViewModel = this.d;
                if (intelExtnShareViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIntelExtnShareVm");
                    intelExtnShareViewModel = null;
                }
                intelExtnShareViewModel.q("");
            } else {
                FragmentSummaryBinding fragmentSummaryBinding8 = this.f6284a;
                if (fragmentSummaryBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentSummaryBinding8 = null;
                }
                ScrollView scrollView2 = fragmentSummaryBinding8.h;
                Intrinsics.checkNotNullExpressionValue(scrollView2, "svSummary");
                scrollView2.setVisibility(0);
                FragmentSummaryBinding fragmentSummaryBinding9 = this.f6284a;
                if (fragmentSummaryBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentSummaryBinding9 = null;
                }
                Group group2 = fragmentSummaryBinding9.d;
                Intrinsics.checkNotNullExpressionValue(group2, "gpSummaryTip");
                group2.setVisibility(8);
                FragmentSummaryBinding fragmentSummaryBinding10 = this.f6284a;
                if (fragmentSummaryBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentSummaryBinding10 = null;
                }
                MzButton mzButton2 = fragmentSummaryBinding10.g;
                Intrinsics.checkNotNullExpressionValue(mzButton2, "mbtSummary");
                mzButton2.setVisibility(8);
                P0(intelExtnSummary.getSummary());
                IntelExtnShareViewModel intelExtnShareViewModel2 = this.d;
                if (intelExtnShareViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIntelExtnShareVm");
                    intelExtnShareViewModel2 = null;
                }
                intelExtnShareViewModel2.q(intelExtnSummary.getSummary());
                A0(intelExtnSummary);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            NoteBean noteBean = this.b;
            if (noteBean != null) {
                if (z0().p(noteBean)) {
                    FragmentSummaryBinding fragmentSummaryBinding11 = this.f6284a;
                    if (fragmentSummaryBinding11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                        fragmentSummaryBinding11 = null;
                    }
                    Group group3 = fragmentSummaryBinding11.d;
                    Intrinsics.checkNotNullExpressionValue(group3, "gpSummaryTip");
                    group3.setVisibility(8);
                    FragmentSummaryBinding fragmentSummaryBinding12 = this.f6284a;
                    if (fragmentSummaryBinding12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                        fragmentSummaryBinding12 = null;
                    }
                    TranslatorLoadingView translatorLoadingView = fragmentSummaryBinding12.f;
                    Intrinsics.checkNotNullExpressionValue(translatorLoadingView, "loadingView");
                    translatorLoadingView.setVisibility(0);
                    FragmentSummaryBinding fragmentSummaryBinding13 = this.f6284a;
                    if (fragmentSummaryBinding13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                        fragmentSummaryBinding13 = null;
                    }
                    TextView textView3 = fragmentSummaryBinding13.k;
                    Intrinsics.checkNotNullExpressionValue(textView3, "tvLoadingBackground");
                    textView3.setVisibility(0);
                    FragmentSummaryBinding fragmentSummaryBinding14 = this.f6284a;
                    if (fragmentSummaryBinding14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                        fragmentSummaryBinding14 = null;
                    }
                    MzButton mzButton3 = fragmentSummaryBinding14.g;
                    Intrinsics.checkNotNullExpressionValue(mzButton3, "mbtSummary");
                    mzButton3.setVisibility(0);
                    FragmentSummaryBinding fragmentSummaryBinding15 = this.f6284a;
                    if (fragmentSummaryBinding15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                        fragmentSummaryBinding15 = null;
                    }
                    fragmentSummaryBinding15.g.setEnabled(false);
                    z0().m(noteBean);
                } else {
                    FragmentSummaryBinding fragmentSummaryBinding16 = this.f6284a;
                    if (fragmentSummaryBinding16 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                        fragmentSummaryBinding16 = null;
                    }
                    ScrollView scrollView3 = fragmentSummaryBinding16.h;
                    Intrinsics.checkNotNullExpressionValue(scrollView3, "svSummary");
                    scrollView3.setVisibility(8);
                    FragmentSummaryBinding fragmentSummaryBinding17 = this.f6284a;
                    if (fragmentSummaryBinding17 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                        fragmentSummaryBinding17 = null;
                    }
                    TextView textView4 = fragmentSummaryBinding17.l;
                    Intrinsics.checkNotNullExpressionValue(textView4, "tvOuterAiMark");
                    textView4.setVisibility(8);
                    FragmentSummaryBinding fragmentSummaryBinding18 = this.f6284a;
                    if (fragmentSummaryBinding18 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                        fragmentSummaryBinding18 = null;
                    }
                    TextView textView5 = fragmentSummaryBinding18.m;
                    Intrinsics.checkNotNullExpressionValue(textView5, "tvOuterReported");
                    textView5.setVisibility(8);
                    FragmentSummaryBinding fragmentSummaryBinding19 = this.f6284a;
                    if (fragmentSummaryBinding19 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                        fragmentSummaryBinding19 = null;
                    }
                    Group group4 = fragmentSummaryBinding19.d;
                    Intrinsics.checkNotNullExpressionValue(group4, "gpSummaryTip");
                    group4.setVisibility(0);
                    FragmentSummaryBinding fragmentSummaryBinding20 = this.f6284a;
                    if (fragmentSummaryBinding20 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                        fragmentSummaryBinding20 = null;
                    }
                    MzButton mzButton4 = fragmentSummaryBinding20.g;
                    Intrinsics.checkNotNullExpressionValue(mzButton4, "mbtSummary");
                    mzButton4.setVisibility(0);
                    FragmentSummaryBinding fragmentSummaryBinding21 = this.f6284a;
                    if (fragmentSummaryBinding21 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                        fragmentSummaryBinding21 = null;
                    }
                    fragmentSummaryBinding21.g.setEnabled(true);
                }
                unit2 = Unit.INSTANCE;
            } else {
                unit2 = null;
            }
            if (unit2 == null) {
                FragmentSummaryBinding fragmentSummaryBinding22 = this.f6284a;
                if (fragmentSummaryBinding22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentSummaryBinding22 = null;
                }
                ScrollView scrollView4 = fragmentSummaryBinding22.h;
                Intrinsics.checkNotNullExpressionValue(scrollView4, "svSummary");
                scrollView4.setVisibility(8);
                FragmentSummaryBinding fragmentSummaryBinding23 = this.f6284a;
                if (fragmentSummaryBinding23 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentSummaryBinding23 = null;
                }
                TextView textView6 = fragmentSummaryBinding23.l;
                Intrinsics.checkNotNullExpressionValue(textView6, "tvOuterAiMark");
                textView6.setVisibility(8);
                FragmentSummaryBinding fragmentSummaryBinding24 = this.f6284a;
                if (fragmentSummaryBinding24 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentSummaryBinding24 = null;
                }
                TextView textView7 = fragmentSummaryBinding24.m;
                Intrinsics.checkNotNullExpressionValue(textView7, "tvOuterReported");
                textView7.setVisibility(8);
                FragmentSummaryBinding fragmentSummaryBinding25 = this.f6284a;
                if (fragmentSummaryBinding25 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentSummaryBinding25 = null;
                }
                Group group5 = fragmentSummaryBinding25.d;
                Intrinsics.checkNotNullExpressionValue(group5, "gpSummaryTip");
                group5.setVisibility(0);
                FragmentSummaryBinding fragmentSummaryBinding26 = this.f6284a;
                if (fragmentSummaryBinding26 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    fragmentSummaryBinding26 = null;
                }
                MzButton mzButton5 = fragmentSummaryBinding26.g;
                Intrinsics.checkNotNullExpressionValue(mzButton5, "mbtSummary");
                mzButton5.setVisibility(0);
                FragmentSummaryBinding fragmentSummaryBinding27 = this.f6284a;
                if (fragmentSummaryBinding27 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    fragmentSummaryBinding = fragmentSummaryBinding27;
                }
                fragmentSummaryBinding.g.setEnabled(true);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r2v8, types: [kotlin.Unit] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void D0() {
        /*
            r7 = this;
            java.lang.String r0 = "handleIllegalContent 概要总结违规内容举报"
            java.lang.String r1 = "SummaryFragment"
            com.upuphone.ar.translation.ext.LogExt.j(r0, r1)
            com.upuphone.ar.translation.phone.bean.NoteBean r0 = r7.b
            r2 = 0
            if (r0 == 0) goto L_0x0045
            androidx.fragment.app.FragmentActivity r3 = r7.getActivity()
            if (r3 == 0) goto L_0x0045
            com.upuphone.xr.audio.record.ai.feedback.AiFeedBackManager r4 = com.upuphone.xr.audio.record.ai.feedback.AiFeedBackManager.f6560a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            com.upuphone.ar.translation.phone.vm.IntelExtnSummaryViewModel r5 = r7.z0()
            com.upuphone.ar.translation.phone.vm.IntelExtnShareViewModel r6 = r7.d
            if (r6 != 0) goto L_0x0025
            java.lang.String r6 = "mIntelExtnShareVm"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            goto L_0x0026
        L_0x0025:
            r2 = r6
        L_0x0026:
            androidx.lifecycle.LiveData r2 = r2.l()
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x0034
            java.lang.String r2 = ""
        L_0x0034:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            com.upuphone.xr.audio.record.ai.bean.AiFeedBackRequest r0 = r5.k(r0, r2)
            com.upuphone.ar.translation.phone.fragment.SummaryFragment$handleIllegalContent$1$1$1 r2 = new com.upuphone.ar.translation.phone.fragment.SummaryFragment$handleIllegalContent$1$1$1
            r2.<init>(r7)
            r4.k(r3, r0, r2)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x0045:
            if (r2 != 0) goto L_0x004c
            java.lang.String r7 = "handleIllegalContent 概要总结NoteBean对象为null"
            com.upuphone.ar.translation.ext.LogExt.j(r7, r1)
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.fragment.SummaryFragment.D0():void");
    }

    public final void E0(SensitivePayload sensitivePayload) {
        Unit unit;
        FragmentSummaryBinding fragmentSummaryBinding = null;
        if (sensitivePayload != null) {
            if (StringsKt.equals(sensitivePayload.getRiskLevel(), "LOCKED", true)) {
                z0().r(sensitivePayload.getRiskDescription());
            } else {
                z0().q(R.string.tl_generate_sensitive_disable_func);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            z0().q(R.string.tl_generate_content_sensitive_fail);
        }
        FragmentSummaryBinding fragmentSummaryBinding2 = this.f6284a;
        if (fragmentSummaryBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSummaryBinding2 = null;
        }
        TranslatorLoadingView translatorLoadingView = fragmentSummaryBinding2.f;
        Intrinsics.checkNotNullExpressionValue(translatorLoadingView, "loadingView");
        translatorLoadingView.setVisibility(8);
        FragmentSummaryBinding fragmentSummaryBinding3 = this.f6284a;
        if (fragmentSummaryBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSummaryBinding3 = null;
        }
        TextView textView = fragmentSummaryBinding3.k;
        Intrinsics.checkNotNullExpressionValue(textView, "tvLoadingBackground");
        textView.setVisibility(8);
        FragmentSummaryBinding fragmentSummaryBinding4 = this.f6284a;
        if (fragmentSummaryBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSummaryBinding4 = null;
        }
        fragmentSummaryBinding4.g.setEnabled(true);
        FragmentSummaryBinding fragmentSummaryBinding5 = this.f6284a;
        if (fragmentSummaryBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSummaryBinding5 = null;
        }
        MzButton mzButton = fragmentSummaryBinding5.g;
        Intrinsics.checkNotNullExpressionValue(mzButton, "mbtSummary");
        mzButton.setVisibility(0);
        FragmentSummaryBinding fragmentSummaryBinding6 = this.f6284a;
        if (fragmentSummaryBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentSummaryBinding = fragmentSummaryBinding6;
        }
        Group group = fragmentSummaryBinding.d;
        Intrinsics.checkNotNullExpressionValue(group, "gpSummaryTip");
        group.setVisibility(0);
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [kotlin.Unit] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void F0(com.xjsd.xr.sapp.asr.dao.SmartExSummary r7) {
        /*
            r6 = this;
            com.upuphone.ar.translation.phone.bean.NoteBean r0 = r6.b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "handleServerSummary resSummary="
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = ", noteBean="
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "SummaryFragment"
            com.upuphone.ar.translation.ext.LogExt.j(r0, r1)
            com.upuphone.ar.translation.phone.databinding.FragmentSummaryBinding r0 = r6.f6284a
            java.lang.String r2 = "mBinding"
            r3 = 0
            if (r0 != 0) goto L_0x002b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r3
        L_0x002b:
            com.upuphone.ar.translation.phone.view.TranslatorLoadingView r0 = r0.f
            java.lang.String r4 = "loadingView"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            r4 = 8
            r0.setVisibility(r4)
            com.upuphone.ar.translation.phone.databinding.FragmentSummaryBinding r0 = r6.f6284a
            if (r0 != 0) goto L_0x003f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r3
        L_0x003f:
            android.widget.TextView r0 = r0.k
            java.lang.String r5 = "tvLoadingBackground"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            r0.setVisibility(r4)
            com.upuphone.ar.translation.phone.databinding.FragmentSummaryBinding r0 = r6.f6284a
            if (r0 != 0) goto L_0x0052
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r3
        L_0x0052:
            com.meizu.common.widget.MzButton r0 = r0.g
            r4 = 1
            r0.setEnabled(r4)
            if (r7 == 0) goto L_0x00ad
            int r0 = r7.getBaseStatus()
            if (r0 == 0) goto L_0x00a8
            if (r0 == r4) goto L_0x00a4
            r7 = 2
            if (r0 == r7) goto L_0x00a0
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r4 = "handleServerSummary 异常情况需要云端查看"
            r7.append(r4)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            com.upuphone.ar.translation.ext.LogExt.j(r7, r1)
            com.upuphone.ar.translation.phone.databinding.FragmentSummaryBinding r7 = r6.f6284a
            if (r7 != 0) goto L_0x0081
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r7 = r3
        L_0x0081:
            com.meizu.common.widget.MzButton r7 = r7.g
            java.lang.String r0 = "mbtSummary"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            r0 = 0
            r7.setVisibility(r0)
            com.upuphone.ar.translation.phone.databinding.FragmentSummaryBinding r7 = r6.f6284a
            if (r7 != 0) goto L_0x0094
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x0095
        L_0x0094:
            r3 = r7
        L_0x0095:
            androidx.constraintlayout.widget.Group r7 = r3.d
            java.lang.String r1 = "gpSummaryTip"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            r7.setVisibility(r0)
            goto L_0x00ab
        L_0x00a0:
            r6.handleSummaryEmpty()
            goto L_0x00ab
        L_0x00a4:
            r6.handleSummaryEmpty()
            goto L_0x00ab
        L_0x00a8:
            r6.H0(r7)
        L_0x00ab:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x00ad:
            if (r3 != 0) goto L_0x00b2
            r6.G0()
        L_0x00b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.fragment.SummaryFragment.F0(com.xjsd.xr.sapp.asr.dao.SmartExSummary):void");
    }

    public final void G0() {
        z0().q(R.string.tl_generate_content_fail);
        FragmentSummaryBinding fragmentSummaryBinding = this.f6284a;
        FragmentSummaryBinding fragmentSummaryBinding2 = null;
        if (fragmentSummaryBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSummaryBinding = null;
        }
        MzButton mzButton = fragmentSummaryBinding.g;
        Intrinsics.checkNotNullExpressionValue(mzButton, "mbtSummary");
        mzButton.setVisibility(0);
        FragmentSummaryBinding fragmentSummaryBinding3 = this.f6284a;
        if (fragmentSummaryBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentSummaryBinding2 = fragmentSummaryBinding3;
        }
        Group group = fragmentSummaryBinding2.d;
        Intrinsics.checkNotNullExpressionValue(group, "gpSummaryTip");
        group.setVisibility(0);
    }

    public final void H0(SmartExSummary smartExSummary) {
        NoteBean noteBean = this.b;
        if (noteBean != null) {
            FragmentSummaryBinding fragmentSummaryBinding = this.f6284a;
            FragmentSummaryBinding fragmentSummaryBinding2 = null;
            if (fragmentSummaryBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSummaryBinding = null;
            }
            MzButton mzButton = fragmentSummaryBinding.g;
            Intrinsics.checkNotNullExpressionValue(mzButton, "mbtSummary");
            mzButton.setVisibility(8);
            FragmentSummaryBinding fragmentSummaryBinding3 = this.f6284a;
            if (fragmentSummaryBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentSummaryBinding2 = fragmentSummaryBinding3;
            }
            ScrollView scrollView = fragmentSummaryBinding2.h;
            Intrinsics.checkNotNullExpressionValue(scrollView, "svSummary");
            scrollView.setVisibility(0);
            String summary = smartExSummary.getSummary();
            P0(summary);
            IntelExtnSummaryViewModel z0 = z0();
            IntelExtnSummary intelExtnSummary = new IntelExtnSummary();
            intelExtnSummary.setAccountId(noteBean.getAccountId());
            intelExtnSummary.setRecognizeId(noteBean.getRecognizeId());
            intelExtnSummary.setSummary(summary);
            intelExtnSummary.setOriginalSummary(summary);
            intelExtnSummary.setRequestId(smartExSummary.getRequestId());
            z0.n(intelExtnSummary);
        }
    }

    public final void N0(NoteBean noteBean) {
        FragmentSummaryBinding fragmentSummaryBinding = this.f6284a;
        FragmentSummaryBinding fragmentSummaryBinding2 = null;
        if (fragmentSummaryBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSummaryBinding = null;
        }
        fragmentSummaryBinding.g.setEnabled(true);
        FragmentSummaryBinding fragmentSummaryBinding3 = this.f6284a;
        if (fragmentSummaryBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentSummaryBinding2 = fragmentSummaryBinding3;
        }
        MzButton mzButton = fragmentSummaryBinding2.g;
        Intrinsics.checkNotNullExpressionValue(mzButton, "mbtSummary");
        mzButton.setVisibility(0);
        InterConnectHelper.c.a().u(new SummaryFragment$notAgreeAiState$1(this, noteBean));
    }

    public final boolean O0(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && (view instanceof TextView)) {
            TextView textView = (TextView) view;
            Drawable drawable = textView.getCompoundDrawablesRelative()[2];
            if (drawable == null) {
                return false;
            }
            FragmentActivity activity = getActivity();
            boolean f = activity != null ? ContextExtKt.f(activity) : false;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (f) {
                if (motionEvent.getX() <= ((float) (textView.getPaddingEnd() + intrinsicWidth))) {
                    D0();
                    view.performClick();
                    return true;
                }
            } else if (motionEvent.getX() >= ((float) ((textView.getWidth() - textView.getPaddingEnd()) - intrinsicWidth)) && motionEvent.getX() <= ((float) (textView.getWidth() - textView.getPaddingEnd()))) {
                D0();
                view.performClick();
                return true;
            }
        }
        return false;
    }

    public final void P0(String str) {
        boolean b2 = StringExtKt.b(str);
        FragmentActivity activity = getActivity();
        boolean f = activity != null ? ContextExtKt.f(activity) : false;
        int i = 6;
        int i2 = 8388613;
        FragmentSummaryBinding fragmentSummaryBinding = null;
        if (b2) {
            FragmentSummaryBinding fragmentSummaryBinding2 = this.f6284a;
            if (fragmentSummaryBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSummaryBinding2 = null;
            }
            ClipboardEditText clipboardEditText = fragmentSummaryBinding2.c;
            if (f) {
                i2 = 8388611;
            }
            clipboardEditText.setGravity(i2);
            FragmentSummaryBinding fragmentSummaryBinding3 = this.f6284a;
            if (fragmentSummaryBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSummaryBinding3 = null;
            }
            ClipboardEditText clipboardEditText2 = fragmentSummaryBinding3.c;
            if (f) {
                i = 5;
            }
            clipboardEditText2.setTextAlignment(i);
        } else {
            FragmentSummaryBinding fragmentSummaryBinding4 = this.f6284a;
            if (fragmentSummaryBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSummaryBinding4 = null;
            }
            ClipboardEditText clipboardEditText3 = fragmentSummaryBinding4.c;
            if (!f) {
                i2 = 8388611;
            }
            clipboardEditText3.setGravity(i2);
            FragmentSummaryBinding fragmentSummaryBinding5 = this.f6284a;
            if (fragmentSummaryBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSummaryBinding5 = null;
            }
            ClipboardEditText clipboardEditText4 = fragmentSummaryBinding5.c;
            if (!f) {
                i = 5;
            }
            clipboardEditText4.setTextAlignment(i);
        }
        FragmentSummaryBinding fragmentSummaryBinding6 = this.f6284a;
        if (fragmentSummaryBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentSummaryBinding = fragmentSummaryBinding6;
        }
        fragmentSummaryBinding.c.setText(str);
    }

    public final boolean Q0(MotionEvent motionEvent) {
        View currentFocus;
        FragmentActivity activity = getActivity();
        if (activity == null || motionEvent.getAction() != 0 || (currentFocus = activity.getCurrentFocus()) == null || !(currentFocus instanceof EditText)) {
            return false;
        }
        Rect rect = new Rect();
        ((EditText) currentFocus).getGlobalVisibleRect(rect);
        if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            return false;
        }
        LogExt.j("touchEditOutside touch outside the EditText area", "SummaryFragment");
        I0();
        return false;
    }

    public final void R0() {
        IntelExtnSummary intelExtnSummary = (IntelExtnSummary) z0().g().getValue();
        LogExt.j("updateSummaryToDb extnSummary=" + intelExtnSummary, "SummaryFragment");
        if (intelExtnSummary != null) {
            String summary = intelExtnSummary.getSummary();
            FragmentSummaryBinding fragmentSummaryBinding = this.f6284a;
            if (fragmentSummaryBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSummaryBinding = null;
            }
            String valueOf = String.valueOf(fragmentSummaryBinding.c.getText());
            LogExt.j("updateSummaryToDb originalSummary=" + summary + ", inputSummary=" + valueOf, "SummaryFragment");
            if (!Intrinsics.areEqual((Object) summary, (Object) valueOf)) {
                Class<IntelExtnSummary> cls = IntelExtnSummary.class;
                if (StringsKt.isBlank(valueOf)) {
                    IntelExtnSummaryViewModel z0 = z0();
                    IntelExtnSummary intelExtnSummary2 = (IntelExtnSummary) AnyExtKt.a(intelExtnSummary, cls);
                    intelExtnSummary2.setDeleteStatus(1);
                    intelExtnSummary2.setReported(false);
                    z0.s(intelExtnSummary2);
                    return;
                }
                IntelExtnSummaryViewModel z02 = z0();
                IntelExtnSummary intelExtnSummary3 = (IntelExtnSummary) AnyExtKt.a(intelExtnSummary, cls);
                intelExtnSummary3.setSummary(valueOf);
                z02.s(intelExtnSummary3);
            }
        }
    }

    public final void getSummary() {
        IntelExtnSummary intelExtnSummary = (IntelExtnSummary) z0().g().getValue();
        if (intelExtnSummary != null) {
            LogExt.j("getSummary from db summary=" + intelExtnSummary, "SummaryFragment");
            IntelExtnSummaryViewModel z0 = z0();
            IntelExtnSummary intelExtnSummary2 = (IntelExtnSummary) AnyExtKt.a(intelExtnSummary, IntelExtnSummary.class);
            intelExtnSummary2.setDeleteStatus(0);
            String originalSummary = intelExtnSummary2.getOriginalSummary();
            if (StringsKt.isBlank(originalSummary)) {
                originalSummary = intelExtnSummary2.getSummary();
            }
            intelExtnSummary2.setSummary(originalSummary);
            z0.s(intelExtnSummary2);
            return;
        }
        LogExt.j("getSummary from server noteBean=" + this.b, "SummaryFragment");
        NoteBean noteBean = this.b;
        if (noteBean != null) {
            FragmentSummaryBinding fragmentSummaryBinding = this.f6284a;
            if (fragmentSummaryBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSummaryBinding = null;
            }
            fragmentSummaryBinding.g.setEnabled(false);
            FragmentSummaryBinding fragmentSummaryBinding2 = this.f6284a;
            if (fragmentSummaryBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSummaryBinding2 = null;
            }
            MzButton mzButton = fragmentSummaryBinding2.g;
            Intrinsics.checkNotNullExpressionValue(mzButton, "mbtSummary");
            mzButton.setVisibility(0);
            Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), Dispatchers.b(), (CoroutineStart) null, new SummaryFragment$getSummary$2$1$1(this, noteBean, (Continuation<? super SummaryFragment$getSummary$2$1$1>) null), 2, (Object) null);
        }
    }

    public final void handleSummaryEmpty() {
        z0().q(R.string.tl_generate_summary_empty);
        FragmentSummaryBinding fragmentSummaryBinding = this.f6284a;
        FragmentSummaryBinding fragmentSummaryBinding2 = null;
        if (fragmentSummaryBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSummaryBinding = null;
        }
        MzButton mzButton = fragmentSummaryBinding.g;
        Intrinsics.checkNotNullExpressionValue(mzButton, "mbtSummary");
        mzButton.setVisibility(0);
        FragmentSummaryBinding fragmentSummaryBinding3 = this.f6284a;
        if (fragmentSummaryBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentSummaryBinding2 = fragmentSummaryBinding3;
        }
        Group group = fragmentSummaryBinding2.d;
        Intrinsics.checkNotNullExpressionValue(group, "gpSummaryTip");
        group.setVisibility(0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                this.b = (NoteBean) arguments.getSerializable(TranslatorConstants.TRANSFER_TRANS_RECORD, NoteBean.class);
            } else {
                Serializable serializable = arguments.getSerializable(TranslatorConstants.TRANSFER_TRANS_RECORD);
                if (serializable != null && (serializable instanceof NoteBean)) {
                    this.b = (NoteBean) serializable;
                }
            }
        }
        NoteBean noteBean = this.b;
        LogExt.j("翻译记录对象 " + noteBean, "SummaryFragment");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentSummaryBinding c2 = FragmentSummaryBinding.c(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f6284a = c2;
        if (c2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            c2 = null;
        }
        ConstraintLayout b2 = c2.getRoot();
        Intrinsics.checkNotNullExpressionValue(b2, "getRoot(...)");
        return b2;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initData();
        initListener();
        initViewModels();
    }

    public final void y0(NoteBean noteBean) {
        LogExt.j("getSummary accountId=" + AsrExtKt.mixSpecialData(noteBean.getAccountId()) + ", recognizeId=" + noteBean.getRecognizeId(), "SummaryFragment");
        FragmentSummaryBinding fragmentSummaryBinding = null;
        if (StringsKt.isBlank(noteBean.getAccountId()) || StringsKt.isBlank(noteBean.getRecognizeId())) {
            FragmentSummaryBinding fragmentSummaryBinding2 = this.f6284a;
            if (fragmentSummaryBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                fragmentSummaryBinding2 = null;
            }
            fragmentSummaryBinding2.g.setEnabled(true);
            FragmentSummaryBinding fragmentSummaryBinding3 = this.f6284a;
            if (fragmentSummaryBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                fragmentSummaryBinding = fragmentSummaryBinding3;
            }
            MzButton mzButton = fragmentSummaryBinding.g;
            Intrinsics.checkNotNullExpressionValue(mzButton, "mbtSummary");
            mzButton.setVisibility(0);
            z0().q(R.string.tl_generate_summary_empty);
            return;
        }
        FragmentSummaryBinding fragmentSummaryBinding4 = this.f6284a;
        if (fragmentSummaryBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSummaryBinding4 = null;
        }
        Group group = fragmentSummaryBinding4.d;
        Intrinsics.checkNotNullExpressionValue(group, "gpSummaryTip");
        group.setVisibility(8);
        FragmentSummaryBinding fragmentSummaryBinding5 = this.f6284a;
        if (fragmentSummaryBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            fragmentSummaryBinding5 = null;
        }
        TranslatorLoadingView translatorLoadingView = fragmentSummaryBinding5.f;
        Intrinsics.checkNotNullExpressionValue(translatorLoadingView, "loadingView");
        translatorLoadingView.setVisibility(0);
        FragmentSummaryBinding fragmentSummaryBinding6 = this.f6284a;
        if (fragmentSummaryBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            fragmentSummaryBinding = fragmentSummaryBinding6;
        }
        TextView textView = fragmentSummaryBinding.k;
        Intrinsics.checkNotNullExpressionValue(textView, "tvLoadingBackground");
        textView.setVisibility(0);
        z0().m(noteBean);
    }

    public final IntelExtnSummaryViewModel z0() {
        return (IntelExtnSummaryViewModel) this.c.getValue();
    }
}
