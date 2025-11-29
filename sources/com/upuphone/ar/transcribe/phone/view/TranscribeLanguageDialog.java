package com.upuphone.ar.transcribe.phone.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.honey.account.y4.o;
import com.honey.account.y4.p;
import com.honey.account.y4.q;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.constants.TranscribeConstants;
import com.upuphone.ar.transcribe.databinding.TranscribeLanguageDialogBinding;
import com.upuphone.ar.transcribe.ext.ContextExtKt;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.bean.LanguageBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0006*\u00016\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001:B4\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\f\u0010\rB<\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0016\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\nH\u0002¢\u0006\u0004\b#\u0010\u0012J\u000f\u0010$\u001a\u00020\nH\u0002¢\u0006\u0004\b$\u0010\u0012J\u0015\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060%H\u0002¢\u0006\u0004\b&\u0010'J\u0015\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060%H\u0002¢\u0006\u0004\b(\u0010'J\u0015\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060%H\u0002¢\u0006\u0004\b)\u0010'J\u0017\u0010*\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R$\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006;"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/view/TranscribeLanguageDialog;", "Landroid/app/AlertDialog;", "Landroid/content/DialogInterface$OnClickListener;", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Lcom/upuphone/ar/transcribe/phone/bean/LanguageBean;", "Lkotlin/ParameterName;", "name", "languageBean", "", "onDateChanged", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "", "themeResId", "(Landroid/content/Context;ILkotlin/jvm/functions/Function1;)V", "show", "()V", "Landroid/content/DialogInterface;", "dialog", "which", "onClick", "(Landroid/content/DialogInterface;I)V", "current", "m", "(I)V", "", "langType", "n", "(Ljava/lang/String;)V", "", "isVisible", "p", "(Z)V", "j", "i", "", "g", "()Ljava/util/List;", "f", "h", "e", "(Ljava/lang/String;)I", "Lcom/upuphone/ar/transcribe/databinding/TranscribeLanguageDialogBinding;", "a", "Lcom/upuphone/ar/transcribe/databinding/TranscribeLanguageDialogBinding;", "mBinding", "b", "Lkotlin/jvm/functions/Function1;", "mOnDateChanged", "c", "Z", "mIsNavigationBar", "com/upuphone/ar/transcribe/phone/view/TranscribeLanguageDialog$mLangAdapter$1", "d", "Lcom/upuphone/ar/transcribe/phone/view/TranscribeLanguageDialog$mLangAdapter$1;", "mLangAdapter", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTranscribeLanguageDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranscribeLanguageDialog.kt\ncom/upuphone/ar/transcribe/phone/view/TranscribeLanguageDialog\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,240:1\n262#2,2:241\n*S KotlinDebug\n*F\n+ 1 TranscribeLanguageDialog.kt\ncom/upuphone/ar/transcribe/phone/view/TranscribeLanguageDialog\n*L\n73#1:241,2\n*E\n"})
public final class TranscribeLanguageDialog extends AlertDialog implements DialogInterface.OnClickListener {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public TranscribeLanguageDialogBinding f6137a;
    public Function1 b;
    public boolean c;
    public final TranscribeLanguageDialog$mLangAdapter$1 d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/view/TranscribeLanguageDialog$Companion;", "", "()V", "TAG", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TranscribeLanguageDialog(Context context, Function1 function1) {
        this(context, R.style.LangPickerStyle, function1);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "onDateChanged");
    }

    public static final void k(TranscribeLanguageDialog transcribeLanguageDialog, View view) {
        Intrinsics.checkNotNullParameter(transcribeLanguageDialog, "this$0");
        int currentItem = transcribeLanguageDialog.f6137a.c.getCurrentItem();
        LogExt.d("确定 currentItem: " + currentItem, "TranscribeLangDialog");
        Function1 function1 = transcribeLanguageDialog.b;
        if (function1 != null) {
            function1.invoke(transcribeLanguageDialog.g().get(currentItem));
        }
        transcribeLanguageDialog.dismiss();
    }

    public static final void l(TranscribeLanguageDialog transcribeLanguageDialog, View view) {
        Intrinsics.checkNotNullParameter(transcribeLanguageDialog, "this$0");
        LogExt.d("取消", "TranscribeLangDialog");
        transcribeLanguageDialog.dismiss();
    }

    public static final void o(TranscribeLanguageDialog transcribeLanguageDialog) {
        Intrinsics.checkNotNullParameter(transcribeLanguageDialog, "this$0");
        View view = transcribeLanguageDialog.f6137a.b;
        Intrinsics.checkNotNullExpressionValue(view, "dialogBottom");
        view.setVisibility(transcribeLanguageDialog.c ^ true ? 0 : 8);
    }

    public final int e(String str) {
        int i = 0;
        for (LanguageBean langType : g()) {
            int i2 = i + 1;
            if (Intrinsics.areEqual((Object) str, (Object) langType.getLangType())) {
                return i;
            }
            i = i2;
        }
        return -1;
    }

    public final List f() {
        ArrayList arrayList = new ArrayList();
        String string = getContext().getString(R.string.trsb_simultaneous_cn);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        arrayList.add(new LanguageBean(string, "cn"));
        String string2 = getContext().getString(R.string.trsb_simultaneous_en);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        arrayList.add(new LanguageBean(string2, "en"));
        String string3 = getContext().getString(R.string.trsb_simultaneous_ms);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        arrayList.add(new LanguageBean(string3, "ms"));
        String string4 = getContext().getString(R.string.trsb_simultaneous_ja);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        arrayList.add(new LanguageBean(string4, "ja"));
        String string5 = getContext().getString(R.string.trsb_simultaneous_ru);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        arrayList.add(new LanguageBean(string5, "ru"));
        String string6 = getContext().getString(R.string.trsb_simultaneous_fr);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        arrayList.add(new LanguageBean(string6, "fr"));
        String string7 = getContext().getString(R.string.trsb_simultaneous_es);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        arrayList.add(new LanguageBean(string7, "es"));
        String string8 = getContext().getString(R.string.trsb_simultaneous_vi);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        arrayList.add(new LanguageBean(string8, "vi"));
        String string9 = getContext().getString(R.string.trsb_simultaneous_th);
        Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
        arrayList.add(new LanguageBean(string9, "th"));
        String string10 = getContext().getString(R.string.trsb_simultaneous_id);
        Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
        arrayList.add(new LanguageBean(string10, "id"));
        String string11 = getContext().getString(R.string.tl_simultaneous_it);
        Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
        arrayList.add(new LanguageBean(string11, "it"));
        String string12 = getContext().getString(R.string.tl_simultaneous_de);
        Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
        arrayList.add(new LanguageBean(string12, "de"));
        String string13 = getContext().getString(R.string.tl_simultaneous_tr);
        Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
        arrayList.add(new LanguageBean(string13, "tr"));
        String string14 = getContext().getString(R.string.tl_simultaneous_ko);
        Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
        arrayList.add(new LanguageBean(string14, "ko"));
        String string15 = getContext().getString(R.string.tl_simultaneous_ar);
        Intrinsics.checkNotNullExpressionValue(string15, "getString(...)");
        arrayList.add(new LanguageBean(string15, "ar"));
        return arrayList;
    }

    public final List g() {
        return TranscribeConstants.f6027a.m() ? f() : h();
    }

    public final List h() {
        ArrayList arrayList = new ArrayList();
        String string = getContext().getString(R.string.trsb_simultaneous_cn);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        arrayList.add(new LanguageBean(string, "cn"));
        String string2 = getContext().getString(R.string.trsb_simultaneous_en);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        arrayList.add(new LanguageBean(string2, "en"));
        String string3 = getContext().getString(R.string.trsb_simultaneous_ja);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        arrayList.add(new LanguageBean(string3, "ja"));
        if (!TranscribeConstants.g()) {
            String string4 = getContext().getString(R.string.trsb_simultaneous_ko);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            arrayList.add(new LanguageBean(string4, "ko"));
        }
        String string5 = getContext().getString(R.string.trsb_simultaneous_ru);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        arrayList.add(new LanguageBean(string5, "ru"));
        String string6 = getContext().getString(R.string.trsb_simultaneous_fr);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        arrayList.add(new LanguageBean(string6, "fr"));
        String string7 = getContext().getString(R.string.trsb_simultaneous_es);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        arrayList.add(new LanguageBean(string7, "es"));
        String string8 = getContext().getString(R.string.trsb_simultaneous_vi);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        arrayList.add(new LanguageBean(string8, "vi"));
        return arrayList;
    }

    public final void i() {
        this.f6137a.c.setData(this.d, 0, g().size(), 5);
        this.f6137a.c.setCyclic(false);
        this.f6137a.c.setTextColor(getContext().getColor(R.color.color_select_lang_item_select), (List<Integer>) CollectionsKt.arrayListOf(Integer.valueOf(getContext().getColor(R.color.color_select_lang_item_no_select_one)), Integer.valueOf(getContext().getColor(R.color.color_select_lang_item_no_select_two))));
        this.f6137a.c.setTextSize(getContext().getResources().getDimension(R.dimen.dimen_select_lang_item_select), (List<Float>) CollectionsKt.arrayListOf(Float.valueOf(getContext().getResources().getDimension(R.dimen.dimen_select_lang_item_no_select_one)), Float.valueOf(getContext().getResources().getDimension(R.dimen.dimen_select_lang_item_no_select_two))));
    }

    public final void j() {
        View decorView;
        Window window = getWindow();
        if (!(window == null || (decorView = window.getDecorView()) == null)) {
            decorView.setBackgroundColor(0);
        }
        this.f6137a.c.setIsDrawFading(false);
        this.f6137a.e.setOnClickListener(new o(this));
        this.f6137a.d.setOnClickListener(new p(this));
    }

    public final void m(int i) {
        this.f6137a.c.refreshCurrent(i);
    }

    public final void n(String str) {
        Intrinsics.checkNotNullParameter(str, "langType");
        int e2 = e(str);
        if (e2 != -1) {
            m(e2);
        }
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -2) {
            LogExt.d("取消", "TranscribeLangDialog");
        } else if (i == -1) {
            int currentItem = this.f6137a.c.getCurrentItem();
            LogExt.d("确定 currentItem: " + currentItem, "TranscribeLangDialog");
            Function1 function1 = this.b;
            if (function1 != null) {
                function1.invoke(g().get(currentItem));
            }
        }
    }

    public final void p(boolean z) {
        this.c = z;
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
        this.f6137a.getRoot().post(new q(this));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranscribeLanguageDialog(Context context, int i, Function1 function1) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "onDateChanged");
        this.d = new TranscribeLanguageDialog$mLangAdapter$1(this);
        this.b = function1;
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
        }
        TranscribeLanguageDialogBinding c2 = TranscribeLanguageDialogBinding.c(ContextExtKt.a(context));
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f6137a = c2;
        setView(c2.getRoot());
        j();
        i();
    }
}
