package com.upuphone.ar.translation.phone.view;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.honey.account.h5.p;
import com.honey.account.h5.q;
import com.honey.account.h5.r;
import com.meizu.common.widget.ScrollTextView;
import com.upuphone.ar.translation.constants.GlassVersionHelper;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.bean.LanguageBean;
import com.upuphone.ar.translation.phone.databinding.TranslationLangDialogBinding;
import com.upuphone.xr.sapp.utils.FlymeUtils;
import flyme.support.v7.app.AlertDialog;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 L2\u00020\u00012\u00020\u0002:\u0003MNOBI\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00126\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\u0004\b\r\u0010\u000eBQ\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00126\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\u0004\b\r\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u0013J!\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u001d\u0010&\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#¢\u0006\u0004\b&\u0010'J\u001f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060)2\b\b\u0002\u0010(\u001a\u00020\u000fH\u0002¢\u0006\u0004\b*\u0010+J\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00060)2\u0006\u0010(\u001a\u00020\u000fH\u0002¢\u0006\u0004\b,\u0010+J\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060)2\u0006\u0010(\u001a\u00020\u000fH\u0002¢\u0006\u0004\b-\u0010+J\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060)2\u0006\u0010(\u001a\u00020\u000fH\u0002¢\u0006\u0004\b.\u0010+J\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00060)2\u0006\u0010(\u001a\u00020\u000fH\u0002¢\u0006\u0004\b/\u0010+J\u001f\u00101\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u000f2\u0006\u00100\u001a\u00020#H\u0002¢\u0006\u0004\b1\u00102J\u001f\u00104\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u000fH\u0002¢\u0006\u0004\b4\u00105J\u001f\u00106\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000f2\u0006\u00100\u001a\u00020#H\u0002¢\u0006\u0004\b6\u00107J\u001f\u00108\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b8\u0010\u001eJ\u001f\u00109\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b9\u0010\u001eR\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<RH\u0010@\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00060)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00060)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010ER\u0016\u0010K\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006P"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/TranslationLangDialog;", "Lflyme/support/v7/app/AlertDialog;", "Landroid/content/DialogInterface$OnClickListener;", "Landroid/content/Context;", "context", "Lkotlin/Function2;", "Lcom/upuphone/ar/translation/phone/bean/LanguageBean;", "Lkotlin/ParameterName;", "name", "src", "dst", "", "onDateChanged", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;)V", "", "themeResId", "(Landroid/content/Context;ILkotlin/jvm/functions/Function2;)V", "q", "()V", "p", "show", "Landroid/content/DialogInterface;", "dialog", "which", "onClick", "(Landroid/content/DialogInterface;I)V", "srcLang", "dstLang", "v", "(Lcom/upuphone/ar/translation/phone/bean/LanguageBean;Lcom/upuphone/ar/translation/phone/bean/LanguageBean;)V", "", "isVisible", "A", "(Z)V", "", "srcSubtitle", "dstSubtitle", "y", "(Ljava/lang/String;Ljava/lang/String;)V", "type", "", "k", "(I)Ljava/util/List;", "m", "o", "n", "l", "langType", "j", "(ILjava/lang/String;)I", "current", "t", "(II)V", "u", "(ILjava/lang/String;)V", "x", "w", "Lcom/upuphone/ar/translation/phone/databinding/TranslationLangDialogBinding;", "a", "Lcom/upuphone/ar/translation/phone/databinding/TranslationLangDialogBinding;", "mBinding", "b", "Lkotlin/jvm/functions/Function2;", "mOnDateChanged", "c", "Z", "mIsNavigationBar", "d", "Ljava/util/List;", "mSrcLangList", "e", "mDstLangList", "f", "I", "mDstFreshItem", "g", "Companion", "LangDataAdapter", "LangListType", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTranslationLangDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranslationLangDialog.kt\ncom/upuphone/ar/translation/phone/view/TranslationLangDialog\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,580:1\n262#2,2:581\n*S KotlinDebug\n*F\n+ 1 TranslationLangDialog.kt\ncom/upuphone/ar/translation/phone/view/TranslationLangDialog\n*L\n118#1:581,2\n*E\n"})
public final class TranslationLangDialog extends AlertDialog implements DialogInterface.OnClickListener {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public TranslationLangDialogBinding f6334a;
    public Function2 b;
    public boolean c;
    public List d;
    public List e;
    public int f;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/TranslationLangDialog$Companion;", "", "()V", "DEFAULT_ON_SCREEN_COUNT", "", "TAG", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ)\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/TranslationLangDialog$LangDataAdapter;", "Lcom/meizu/common/widget/ScrollTextView$IDataAdapter;", "", "type", "<init>", "(Lcom/upuphone/ar/translation/phone/view/TranslationLangDialog;I)V", "position", "", "getItemText", "(I)Ljava/lang/String;", "Landroid/view/View;", "view", "fromOld", "toNew", "", "onChanged", "(Landroid/view/View;II)V", "a", "I", "getType", "()I", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class LangDataAdapter implements ScrollTextView.IDataAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final int f6335a;

        public LangDataAdapter(int i) {
            this.f6335a = i;
        }

        public String getItemText(int i) {
            int i2 = this.f6335a;
            return i2 != 1 ? i2 != 2 ? "" : ((LanguageBean) TranslationLangDialog.this.e.get(i)).getLangName() : ((LanguageBean) TranslationLangDialog.this.d.get(i)).getLangName();
        }

        public void onChanged(View view, int i, int i2) {
            int i3 = this.f6335a;
            LogExt.g("onChanged type=" + i3 + ", fromOld=" + i + ", toNew=" + i2, "TranslationLangDialog");
            int i4 = this.f6335a;
            if (i4 == 1) {
                TranslationLangDialog.this.e.clear();
                List g = TranslationLangDialog.this.e;
                List d = TranslationLangDialog.this.k(2);
                TranslationLangDialog translationLangDialog = TranslationLangDialog.this;
                LogExt.g("onChanged 切换源语言，更新目标语言列表=" + d, "TranslationLangDialog");
                if (!d.isEmpty()) {
                    translationLangDialog.f = translationLangDialog.f >= d.size() ? d.size() - 1 : translationLangDialog.f;
                    int f = translationLangDialog.f;
                    LogExt.g("onChanged 切换源语言，目标语言刷新位置=" + f, "TranslationLangDialog");
                    translationLangDialog.f6334a.e.refreshCountAndCurrent(d.size(), translationLangDialog.f);
                }
                g.addAll(d);
            } else if (i4 != 2) {
                LogExt.g("异常类型 type=" + i4, "TranslationLangDialog");
            } else {
                LogExt.g("onChanged 切换目标语言位置=" + i2, "TranslationLangDialog");
                TranslationLangDialog.this.f = i2;
            }
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/TranslationLangDialog$LangListType;", "", "<init>", "()V", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface LangListType {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/ar/translation/phone/view/TranslationLangDialog$LangListType$Companion;", "", "<init>", "()V", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class Companion {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ Companion f6336a = new Companion();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TranslationLangDialog(Context context, Function2 function2) {
        this(context, R.style.TranslatorLangPickerStyle, function2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function2, "onDateChanged");
    }

    private final void p() {
        this.d.clear();
        List list = this.d;
        List k = k(1);
        this.f6334a.f.setData(new LangDataAdapter(1), 0, k.size(), 5);
        list.addAll(k);
        this.f6334a.f.setCyclic(false);
        this.f6334a.f.setTextColor(getContext().getColor(R.color.color_select_lang_item_select), (List<Integer>) CollectionsKt.arrayListOf(Integer.valueOf(getContext().getColor(R.color.color_select_lang_item_no_select_one)), Integer.valueOf(getContext().getColor(R.color.color_select_lang_item_no_select_two))));
        this.f6334a.f.setTextSize(getContext().getResources().getDimension(R.dimen.dimen_select_lang_item_select), (List<Float>) CollectionsKt.arrayListOf(Float.valueOf(getContext().getResources().getDimension(R.dimen.dimen_select_lang_item_no_select_one)), Float.valueOf(getContext().getResources().getDimension(R.dimen.dimen_select_lang_item_no_select_two))));
        this.e.clear();
        List list2 = this.e;
        List k2 = k(2);
        this.f6334a.e.setData(new LangDataAdapter(2), 0, k2.size(), 5);
        list2.addAll(k2);
        this.f6334a.e.setCyclic(false);
        this.f6334a.e.setTextColor(getContext().getColor(R.color.color_select_lang_item_select), (List<Integer>) CollectionsKt.arrayListOf(Integer.valueOf(getContext().getColor(R.color.color_select_lang_item_no_select_one)), Integer.valueOf(getContext().getColor(R.color.color_select_lang_item_no_select_two))));
        this.f6334a.e.setTextSize(getContext().getResources().getDimension(R.dimen.dimen_select_lang_item_select), (List<Float>) CollectionsKt.arrayListOf(Float.valueOf(getContext().getResources().getDimension(R.dimen.dimen_select_lang_item_no_select_one)), Float.valueOf(getContext().getResources().getDimension(R.dimen.dimen_select_lang_item_no_select_two))));
    }

    private final void q() {
        View decorView;
        Window window = getWindow();
        if (!(window == null || (decorView = window.getDecorView()) == null)) {
            decorView.setBackgroundColor(0);
        }
        this.f6334a.f.setIsDrawFading(false);
        this.f6334a.e.setIsDrawFading(false);
        this.f6334a.j.setOnClickListener(new q(this));
        this.f6334a.g.setOnClickListener(new r(this));
    }

    public static final void r(TranslationLangDialog translationLangDialog, View view) {
        Function2 function2;
        Intrinsics.checkNotNullParameter(translationLangDialog, "this$0");
        int currentItem = translationLangDialog.f6334a.f.getCurrentItem();
        int currentItem2 = translationLangDialog.f6334a.e.getCurrentItem();
        int lastIndex = CollectionsKt.getLastIndex(translationLangDialog.d);
        int lastIndex2 = CollectionsKt.getLastIndex(translationLangDialog.e);
        LogExt.g("确定 src=[currentItem=" + currentItem + ", lastIndex=" + lastIndex + "], dst=[currentItem=" + currentItem2 + ", lastIndex=" + lastIndex2 + "]", "TranslationLangDialog");
        if (currentItem <= lastIndex && currentItem2 <= lastIndex2 && (function2 = translationLangDialog.b) != null) {
            function2.invoke(translationLangDialog.d.get(currentItem), translationLangDialog.e.get(currentItem2));
        }
        translationLangDialog.dismiss();
    }

    public static final void s(TranslationLangDialog translationLangDialog, View view) {
        Intrinsics.checkNotNullParameter(translationLangDialog, "this$0");
        LogExt.g("取消", "TranslationLangDialog");
        translationLangDialog.dismiss();
    }

    public static final void z(TranslationLangDialog translationLangDialog) {
        Intrinsics.checkNotNullParameter(translationLangDialog, "this$0");
        View view = translationLangDialog.f6334a.b;
        Intrinsics.checkNotNullExpressionValue(view, "dialogBottom");
        view.setVisibility(translationLangDialog.c ^ true ? 0 : 8);
    }

    public final void A(boolean z) {
        this.c = z;
    }

    public final int j(int i, String str) {
        int i2 = 0;
        for (LanguageBean langType : i == 1 ? this.d : this.e) {
            int i3 = i2 + 1;
            if (Intrinsics.areEqual((Object) str, (Object) langType.getLangType())) {
                return i2;
            }
            i2 = i3;
        }
        return -1;
    }

    public final List k(int i) {
        return TranslatorConstants.isAirPro() ? TranslatorConstants.isIntlVersion() ? o(i) : m(i) : TranslatorConstants.isIntlVersion() ? n(i) : l(i);
    }

    public final List l(int i) {
        ArrayList arrayList = new ArrayList();
        String string = getContext().getString(R.string.tl_simultaneous_cn);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        arrayList.add(new LanguageBean(string, "cn"));
        String string2 = getContext().getString(R.string.tl_simultaneous_en);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        arrayList.add(new LanguageBean(string2, "cnen"));
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
        if (i == 1) {
            return arrayList;
        }
        int currentItem = this.f6334a.f.getCurrentItem();
        Object obj = arrayList.get(currentItem);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        if (Intrinsics.areEqual((Object) ((LanguageBean) obj).getLangType(), (Object) "cn")) {
            arrayList.remove(currentItem);
            return arrayList;
        }
        String string9 = getContext().getString(R.string.tl_simultaneous_cn);
        Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
        return CollectionsKt.arrayListOf(new LanguageBean(string9, "cn"));
    }

    public final List m(int i) {
        ArrayList arrayList = new ArrayList();
        String string = getContext().getString(R.string.tl_simultaneous_cn);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        arrayList.add(new LanguageBean(string, "cn"));
        String string2 = getContext().getString(R.string.tl_simultaneous_en);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        arrayList.add(new LanguageBean(string2, "cnen"));
        String string3 = getContext().getString(R.string.tl_simultaneous_ms);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        arrayList.add(new LanguageBean(string3, "ms"));
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
        String string11 = getContext().getString(R.string.tl_simultaneous_ko);
        Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
        arrayList.add(new LanguageBean(string11, "ko"));
        String string12 = getContext().getString(R.string.tl_simultaneous_it);
        Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
        arrayList.add(new LanguageBean(string12, "it"));
        String string13 = getContext().getString(R.string.tl_simultaneous_de);
        Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
        arrayList.add(new LanguageBean(string13, "de"));
        if (i == 2) {
            arrayList.remove(this.f6334a.f.getCurrentItem());
        }
        return arrayList;
    }

    public final List n(int i) {
        ArrayList arrayList = new ArrayList();
        String string = getContext().getString(R.string.tl_simultaneous_cn);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        arrayList.add(new LanguageBean(string, "cn"));
        String string2 = getContext().getString(R.string.tl_simultaneous_en);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        arrayList.add(new LanguageBean(string2, "cnen"));
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
        if (i == 2) {
            arrayList.remove(this.f6334a.f.getCurrentItem());
        }
        return arrayList;
    }

    public final List o(int i) {
        ArrayList arrayList = new ArrayList();
        String string = getContext().getString(R.string.tl_simultaneous_cn);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        arrayList.add(new LanguageBean(string, "cn"));
        String string2 = getContext().getString(R.string.tl_simultaneous_en);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        arrayList.add(new LanguageBean(string2, "cnen"));
        String string3 = getContext().getString(R.string.tl_simultaneous_ms);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        arrayList.add(new LanguageBean(string3, "ms"));
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
        String string11 = getContext().getString(R.string.tl_simultaneous_ko);
        Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
        arrayList.add(new LanguageBean(string11, "ko"));
        String string12 = getContext().getString(R.string.tl_simultaneous_it);
        Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
        arrayList.add(new LanguageBean(string12, "it"));
        String string13 = getContext().getString(R.string.tl_simultaneous_de);
        Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
        arrayList.add(new LanguageBean(string13, "de"));
        if (GlassVersionHelper.INSTANCE.isIntlOta1ForAirPro()) {
            String string14 = getContext().getString(R.string.tl_simultaneous_ar);
            Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
            arrayList.add(new LanguageBean(string14, "ar"));
        }
        if (i == 2) {
            arrayList.remove(this.f6334a.f.getCurrentItem());
        }
        return arrayList;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        Function2 function2;
        if (i == -2) {
            LogExt.g("取消", "TranslationLangDialog");
            dismiss();
        } else if (i == -1) {
            int currentItem = this.f6334a.f.getCurrentItem();
            int currentItem2 = this.f6334a.e.getCurrentItem();
            int lastIndex = CollectionsKt.getLastIndex(this.d);
            int lastIndex2 = CollectionsKt.getLastIndex(this.e);
            LogExt.g("确定 src=[currentItem=" + currentItem + ", lastIndex=" + lastIndex + "], dst=[currentItem=" + currentItem2 + ", lastIndex=" + lastIndex2 + "]", "TranslationLangDialog");
            if (currentItem <= lastIndex && currentItem2 <= lastIndex2 && (function2 = this.b) != null) {
                function2.invoke(this.d.get(currentItem), this.e.get(currentItem2));
            }
            dismiss();
        }
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
        this.f6334a.getRoot().post(new p(this));
    }

    public final void t(int i, int i2) {
        if (i == 1) {
            this.f6334a.f.refreshCurrent(i2);
        } else {
            this.f6334a.e.refreshCurrent(i2);
        }
    }

    public final void u(int i, String str) {
        int j = j(i, str);
        if (j != -1) {
            t(i, j);
        }
    }

    public final void v(LanguageBean languageBean, LanguageBean languageBean2) {
        Intrinsics.checkNotNullParameter(languageBean, "srcLang");
        Intrinsics.checkNotNullParameter(languageBean2, "dstLang");
        if (TranslatorConstants.isMicroSoftAsr()) {
            x(languageBean, languageBean2);
        } else {
            w(languageBean, languageBean2);
        }
    }

    public final void w(LanguageBean languageBean, LanguageBean languageBean2) {
        if ((!Intrinsics.areEqual((Object) languageBean.getLangType(), (Object) "cn") || Intrinsics.areEqual((Object) languageBean2.getLangType(), (Object) "cn")) && (Intrinsics.areEqual((Object) languageBean.getLangType(), (Object) "cn") || !Intrinsics.areEqual((Object) languageBean2.getLangType(), (Object) "cn"))) {
            String langType = languageBean.getLangType();
            String langType2 = languageBean2.getLangType();
            LogExt.j("异常的语言切换类型, src=" + langType + ", dst=" + langType2, "TranslationLangDialog");
            return;
        }
        u(1, languageBean.getLangType());
        u(2, languageBean2.getLangType());
    }

    public final void x(LanguageBean languageBean, LanguageBean languageBean2) {
        if (!Intrinsics.areEqual((Object) languageBean.getLangType(), (Object) languageBean2.getLangType())) {
            u(1, languageBean.getLangType());
            u(2, languageBean2.getLangType());
            return;
        }
        String langType = languageBean.getLangType();
        String langType2 = languageBean2.getLangType();
        LogExt.j("异常的语言切换类型, src=" + langType + ", dst=" + langType2, "TranslationLangDialog");
    }

    public final void y(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "srcSubtitle");
        Intrinsics.checkNotNullParameter(str2, "dstSubtitle");
        TextView textView = this.f6334a.l;
        if (StringsKt.isBlank(str)) {
            str = getContext().getResources().getString(R.string.tl_lang_src_hint);
            Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
        }
        textView.setText(str);
        TextView textView2 = this.f6334a.i;
        if (StringsKt.isBlank(str2)) {
            str2 = getContext().getResources().getString(R.string.tl_lang_dst_hint);
            Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
        }
        textView2.setText(str2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslationLangDialog(Context context, int i, Function2 function2) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function2, "onDateChanged");
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.b = function2;
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
        }
        TranslationLangDialogBinding c2 = TranslationLangDialogBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f6334a = c2;
        setView(c2.getRoot());
        FlymeUtils.a(this.f6334a.getRoot(), context);
        q();
        p();
    }
}
