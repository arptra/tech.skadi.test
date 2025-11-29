package com.upuphone.ar.translation.phone.view;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.honey.account.h5.m;
import com.honey.account.h5.n;
import com.honey.account.h5.o;
import com.upuphone.ar.translation.constants.GlassVersionHelper;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.bean.LanguageBean;
import com.upuphone.ar.translation.phone.databinding.TranscribeLangDialogBinding;
import com.upuphone.xr.sapp.utils.FlymeUtils;
import flyme.support.v7.app.AlertDialog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0006*\u00016\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001:B4\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\f\u0010\rB<\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0012J!\u0010\u0018\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u000e¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0015\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060%H\u0002¢\u0006\u0004\b&\u0010'J\u0015\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060%H\u0002¢\u0006\u0004\b(\u0010'J\u0015\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060%H\u0002¢\u0006\u0004\b)\u0010'J\u0017\u0010*\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R$\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u0006;"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/TranscribeLangDialog;", "Lflyme/support/v7/app/AlertDialog;", "Landroid/content/DialogInterface$OnClickListener;", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Lcom/upuphone/ar/translation/phone/bean/LanguageBean;", "Lkotlin/ParameterName;", "name", "languageBean", "", "onDateChanged", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "", "themeResId", "(Landroid/content/Context;ILkotlin/jvm/functions/Function1;)V", "j", "()V", "i", "show", "Landroid/content/DialogInterface;", "dialog", "which", "onClick", "(Landroid/content/DialogInterface;I)V", "current", "m", "(I)V", "", "langType", "n", "(Ljava/lang/String;)V", "", "isVisible", "p", "(Z)V", "", "g", "()Ljava/util/List;", "f", "h", "e", "(Ljava/lang/String;)I", "Lcom/upuphone/ar/translation/phone/databinding/TranscribeLangDialogBinding;", "a", "Lcom/upuphone/ar/translation/phone/databinding/TranscribeLangDialogBinding;", "mBinding", "b", "Lkotlin/jvm/functions/Function1;", "mOnDateChanged", "c", "Z", "mIsNavigationBar", "com/upuphone/ar/translation/phone/view/TranscribeLangDialog$mLangAdapter$1", "d", "Lcom/upuphone/ar/translation/phone/view/TranscribeLangDialog$mLangAdapter$1;", "mLangAdapter", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTranscribeLangDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranscribeLangDialog.kt\ncom/upuphone/ar/translation/phone/view/TranscribeLangDialog\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,246:1\n262#2,2:247\n*S KotlinDebug\n*F\n+ 1 TranscribeLangDialog.kt\ncom/upuphone/ar/translation/phone/view/TranscribeLangDialog\n*L\n77#1:247,2\n*E\n"})
public final class TranscribeLangDialog extends AlertDialog implements DialogInterface.OnClickListener {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public TranscribeLangDialogBinding f6332a;
    public Function1 b;
    public boolean c;
    public final TranscribeLangDialog$mLangAdapter$1 d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/TranscribeLangDialog$Companion;", "", "()V", "TAG", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TranscribeLangDialog(Context context, Function1 function1) {
        this(context, R.style.TranslatorLangPickerStyle, function1);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "onDateChanged");
    }

    private final void i() {
        this.f6332a.c.setData(this.d, 0, g().size(), 5);
        this.f6332a.c.setCyclic(false);
        this.f6332a.c.setTextColor(getContext().getColor(R.color.color_select_lang_item_select), (List<Integer>) CollectionsKt.arrayListOf(Integer.valueOf(getContext().getColor(R.color.color_select_lang_item_no_select_one)), Integer.valueOf(getContext().getColor(R.color.color_select_lang_item_no_select_two))));
        this.f6332a.c.setTextSize(getContext().getResources().getDimension(R.dimen.dimen_select_lang_item_select), (List<Float>) CollectionsKt.arrayListOf(Float.valueOf(getContext().getResources().getDimension(R.dimen.dimen_select_lang_item_no_select_one)), Float.valueOf(getContext().getResources().getDimension(R.dimen.dimen_select_lang_item_no_select_two))));
    }

    private final void j() {
        View decorView;
        Window window = getWindow();
        if (!(window == null || (decorView = window.getDecorView()) == null)) {
            decorView.setBackgroundColor(0);
        }
        this.f6332a.c.setIsDrawFading(false);
        this.f6332a.e.setOnClickListener(new n(this));
        this.f6332a.d.setOnClickListener(new o(this));
    }

    public static final void k(TranscribeLangDialog transcribeLangDialog, View view) {
        Intrinsics.checkNotNullParameter(transcribeLangDialog, "this$0");
        int currentItem = transcribeLangDialog.f6332a.c.getCurrentItem();
        LogExt.g("确定 currentItem: " + currentItem, "TranscribeLangDialog");
        Function1 function1 = transcribeLangDialog.b;
        if (function1 != null) {
            function1.invoke(transcribeLangDialog.g().get(currentItem));
        }
        transcribeLangDialog.dismiss();
    }

    public static final void l(TranscribeLangDialog transcribeLangDialog, View view) {
        Intrinsics.checkNotNullParameter(transcribeLangDialog, "this$0");
        LogExt.g("取消", "TranscribeLangDialog");
        transcribeLangDialog.dismiss();
    }

    public static final void o(TranscribeLangDialog transcribeLangDialog) {
        Intrinsics.checkNotNullParameter(transcribeLangDialog, "this$0");
        View view = transcribeLangDialog.f6332a.b;
        Intrinsics.checkNotNullExpressionValue(view, "dialogBottom");
        view.setVisibility(transcribeLangDialog.c ^ true ? 0 : 8);
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
        String string = getContext().getString(R.string.tl_simultaneous_cn);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        arrayList.add(new LanguageBean(string, "cn"));
        String string2 = getContext().getString(R.string.tl_simultaneous_en);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        arrayList.add(new LanguageBean(string2, "en"));
        String string3 = getContext().getString(R.string.tl_simultaneous_ms);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        arrayList.add(new LanguageBean(string3, "ms"));
        GlassVersionHelper glassVersionHelper = GlassVersionHelper.INSTANCE;
        if (glassVersionHelper.isIntlOta1ForAir()) {
            String string4 = getContext().getString(R.string.tl_simultaneous_ja);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            arrayList.add(new LanguageBean(string4, "ja"));
            String string5 = getContext().getString(R.string.tl_simultaneous_ru);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            arrayList.add(new LanguageBean(string5, "ru"));
            String string6 = getContext().getString(R.string.tl_simultaneous_fr);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            arrayList.add(new LanguageBean(string6, "fr"));
            String string7 = getContext().getString(R.string.tl_simultaneous_es);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            arrayList.add(new LanguageBean(string7, "es"));
            String string8 = getContext().getString(R.string.tl_simultaneous_vi);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
            arrayList.add(new LanguageBean(string8, "vi"));
            String string9 = getContext().getString(R.string.tl_simultaneous_th);
            Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
            arrayList.add(new LanguageBean(string9, "th"));
            String string10 = getContext().getString(R.string.tl_simultaneous_id);
            Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
            arrayList.add(new LanguageBean(string10, "id"));
        }
        if (glassVersionHelper.isIntlOta3ForAir()) {
            String string11 = getContext().getString(R.string.tl_simultaneous_it);
            Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
            arrayList.add(new LanguageBean(string11, "it"));
            String string12 = getContext().getString(R.string.tl_simultaneous_de);
            Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
            arrayList.add(new LanguageBean(string12, "de"));
            String string13 = getContext().getString(R.string.tl_simultaneous_tr);
            Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
            arrayList.add(new LanguageBean(string13, "tr"));
        }
        return arrayList;
    }

    public final List g() {
        return TranslatorConstants.isIntlVersion() ? f() : h();
    }

    public final List h() {
        ArrayList arrayList = new ArrayList();
        String string = getContext().getString(R.string.tl_simultaneous_cn);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        arrayList.add(new LanguageBean(string, "cn"));
        String string2 = getContext().getString(R.string.tl_simultaneous_en);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        arrayList.add(new LanguageBean(string2, "en"));
        String string3 = getContext().getString(R.string.tl_simultaneous_ja);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        arrayList.add(new LanguageBean(string3, "ja"));
        if (!TranslatorConstants.isAir()) {
            String string4 = getContext().getString(R.string.tl_simultaneous_ko);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            arrayList.add(new LanguageBean(string4, "ko"));
        }
        String string5 = getContext().getString(R.string.tl_simultaneous_ru);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        arrayList.add(new LanguageBean(string5, "ru"));
        String string6 = getContext().getString(R.string.tl_simultaneous_fr);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        arrayList.add(new LanguageBean(string6, "fr"));
        String string7 = getContext().getString(R.string.tl_simultaneous_es);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        arrayList.add(new LanguageBean(string7, "es"));
        String string8 = getContext().getString(R.string.tl_simultaneous_vi);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        arrayList.add(new LanguageBean(string8, "vi"));
        return arrayList;
    }

    public final void m(int i) {
        this.f6332a.c.refreshCurrent(i);
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
            LogExt.g("取消", "TranscribeLangDialog");
        } else if (i == -1) {
            int currentItem = this.f6332a.c.getCurrentItem();
            LogExt.g("确定 currentItem: " + currentItem, "TranscribeLangDialog");
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
        this.f6332a.getRoot().post(new m(this));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranscribeLangDialog(Context context, int i, Function1 function1) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "onDateChanged");
        this.d = new TranscribeLangDialog$mLangAdapter$1(this);
        this.b = function1;
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
        }
        TranscribeLangDialogBinding c2 = TranscribeLangDialogBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f6332a = c2;
        setView(c2.getRoot());
        FlymeUtils.a(this.f6332a.getRoot(), context);
        j();
        i();
    }
}
