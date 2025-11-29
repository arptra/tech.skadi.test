package com.upuphone.ar.translation.phone.vm;

import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.RecyclerView;
import com.android.dingtalk.openauth.utils.DDAuthConstant;
import com.honey.account.i5.h;
import com.honey.account.i5.i;
import com.honey.account.i5.j;
import com.honey.account.i5.k;
import com.honey.account.i5.l;
import com.honey.account.i5.m;
import com.upuphone.ar.translation.constants.TranslatorConstants;
import com.upuphone.ar.translation.ext.DialogExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.bean.NoteDetailBean;
import com.upuphone.ar.translation.phone.bean.TransRecord;
import com.upuphone.ar.translation.phone.bean.TransRecordIndex;
import com.upuphone.ar.translation.phone.databinding.LayoutTlDialogCustomTitleBinding;
import com.upuphone.ar.translation.phone.view.CenterImageSpan;
import com.upuphone.ar.translation.utils.DateUtils;
import com.upuphone.ar.translation.utils.GsonUtils;
import com.upuphone.ar.translation.utils.JsonUtils;
import com.upuphone.star.common.phone.UToast;
import flyme.support.v7.app.AlertDialog;
import flyme.support.v7.app.ShowAtBottomAlertDialog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 p2\u00020\u0001:\u0001qB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\nJ&\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH@¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010 \u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b \u0010!J5\u0010%\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u000e2\u0006\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010&J8\u0010-\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020'2!\u0010,\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001f0)¢\u0006\u0004\b-\u0010.J(\u0010/\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H@¢\u0006\u0004\b/\u00100J.\u00101\u001a\b\u0012\u0004\u0012\u00020\"0\u000e2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H@¢\u0006\u0004\b1\u00100J\u0015\u00102\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b2\u00103J\u0015\u00104\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b4\u00105J%\u00109\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u000206¢\u0006\u0004\b9\u0010:J%\u0010;\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u000206¢\u0006\u0004\b;\u0010:J\u001d\u0010<\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b<\u0010=J\u0015\u0010@\u001a\u00020\u00062\u0006\u0010?\u001a\u00020>¢\u0006\u0004\b@\u0010AJ1\u0010E\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020B2\u0006\u0010?\u001a\u00020>2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\u001f0)¢\u0006\u0004\bE\u0010FJ7\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060J2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u00062\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0004\bK\u0010LJ\u001d\u0010N\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010M\u001a\u00020\u0006¢\u0006\u0004\bN\u0010OJ#\u0010P\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u000e¢\u0006\u0004\bP\u0010QJ\u0015\u0010R\u001a\u0002062\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\bR\u0010SJ\u0017\u0010U\u001a\u00020\u001f2\b\b\u0001\u0010T\u001a\u00020B¢\u0006\u0004\bU\u0010VJ\u001d\u0010W\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\bW\u0010=JC\u0010X\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u000e2\u0006\u0010$\u001a\u00020\u0006¢\u0006\u0004\bX\u0010YJ\u0015\u0010Z\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\bZ\u0010[R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R$\u0010d\u001a\u0010\u0012\f\u0012\n a*\u0004\u0018\u000106060`8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bb\u0010cR$\u0010f\u001a\u0010\u0012\f\u0012\n a*\u0004\u0018\u000106060`8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\be\u0010cR\u001d\u0010l\u001a\b\u0012\u0004\u0012\u0002060g8\u0006¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u001d\u0010o\u001a\b\u0012\u0004\u0012\u0002060g8\u0006¢\u0006\f\n\u0004\bm\u0010i\u001a\u0004\bn\u0010k¨\u0006r"}, d2 = {"Lcom/upuphone/ar/translation/phone/vm/TranslatorRecordViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/app/Application;", "app", "<init>", "(Landroid/app/Application;)V", "", "src", "Landroid/text/SpannableString;", "O", "(Ljava/lang/String;)Landroid/text/SpannableString;", "dst", "N", "text", "", "Lcom/upuphone/ar/translation/phone/bean/TransRecordIndex;", "list", "Landroid/text/SpannableStringBuilder;", "H", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "t", "()Ljava/util/List;", "Landroid/app/Activity;", "activity", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "noteBean", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/View;", "view", "", "S", "(Landroid/app/Activity;Lcom/upuphone/ar/translation/phone/bean/NoteBean;Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;)V", "Lcom/upuphone/ar/translation/phone/bean/NoteDetailBean;", "noteBeanList", "textRecord", "U", "(Landroid/app/Activity;Lcom/upuphone/ar/translation/phone/bean/NoteBean;Ljava/util/List;Ljava/lang/String;)V", "", "recordId", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "callback", "y", "(JLkotlin/jvm/functions/Function1;)V", "F", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "v", "B", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;)Ljava/lang/String;", "A", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;)Landroid/text/SpannableStringBuilder;", "", "isTitleUpdated", "isRecordUpdated", "Z", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;ZZ)V", "Y", "n", "(Landroid/app/Activity;Lcom/upuphone/ar/translation/phone/bean/NoteBean;)V", "Landroid/text/Editable;", "editable", "L", "(Landroid/text/Editable;)Ljava/lang/String;", "", "speaker", "Lcom/upuphone/ar/translation/phone/bean/NoteDetailUpdateBean;", "K", "(ILandroid/text/Editable;Lkotlin/jvm/functions/Function1;)V", "originalSrc", "originalDst", "detailBeans", "Lkotlin/Pair;", "G", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lkotlin/Pair;", "record", "E", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;Ljava/lang/String;)Ljava/lang/String;", "D", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;Ljava/util/List;)Ljava/lang/String;", "I", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;)Z", "strId", "M", "(I)V", "p", "P", "(Landroid/app/Activity;Lcom/upuphone/ar/translation/phone/bean/NoteBean;Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;Ljava/util/List;Ljava/lang/String;)V", "V", "(Landroid/app/Activity;)V", "b", "Landroid/app/Application;", "s", "()Landroid/app/Application;", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "c", "Landroidx/lifecycle/MutableLiveData;", "_mIsTextRecordRtl", "d", "_mIsListRecordRtl", "Landroidx/lifecycle/LiveData;", "e", "Landroidx/lifecycle/LiveData;", "x", "()Landroidx/lifecycle/LiveData;", "mIsTextRecordRtl", "f", "w", "mIsListRecordRtl", "g", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTranslatorRecordViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranslatorRecordViewModel.kt\ncom/upuphone/ar/translation/phone/vm/TranslatorRecordViewModel\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,1177:1\n262#2,2:1178\n*S KotlinDebug\n*F\n+ 1 TranslatorRecordViewModel.kt\ncom/upuphone/ar/translation/phone/vm/TranslatorRecordViewModel\n*L\n957#1:1178,2\n*E\n"})
public final class TranslatorRecordViewModel extends AndroidViewModel {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);
    public final Application b;
    public MutableLiveData c;
    public MutableLiveData d;
    public final LiveData e;
    public final LiveData f;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ar/translation/phone/vm/TranslatorRecordViewModel$Companion;", "", "()V", "SUBTITLE_SPLIT_MARK", "", "TAG", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorRecordViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, DDAuthConstant.AUTH_LOGIN_TYPE_APP);
        this.b = application;
        Boolean bool = Boolean.FALSE;
        this.c = new MutableLiveData(bool);
        this.d = new MutableLiveData(bool);
        MutableLiveData mutableLiveData = this.c;
        Intrinsics.checkNotNull(mutableLiveData, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.e = mutableLiveData;
        MutableLiveData mutableLiveData2 = this.d;
        Intrinsics.checkNotNull(mutableLiveData2, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        this.f = mutableLiveData2;
    }

    public static final void Q(TranslatorRecordViewModel translatorRecordViewModel, Activity activity, NoteBean noteBean, RecyclerView recyclerView, View view, List list, String str, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(translatorRecordViewModel, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(noteBean, "$noteBean");
        Intrinsics.checkNotNullParameter(recyclerView, "$recyclerView");
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(list, "$noteBeanList");
        Intrinsics.checkNotNullParameter(str, "$textRecord");
        if (i == 0) {
            translatorRecordViewModel.S(activity, noteBean, recyclerView, view);
        } else if (i == 1) {
            translatorRecordViewModel.U(activity, noteBean, list, str);
        }
    }

    public static final void R(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    public static final void W(Activity activity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        dialogInterface.dismiss();
        activity.finish();
    }

    public static final void X(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    public static final void q(TranslatorRecordViewModel translatorRecordViewModel, Activity activity, NoteBean noteBean, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(translatorRecordViewModel, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(noteBean, "$noteBean");
        translatorRecordViewModel.n(activity, noteBean);
    }

    public static final void r(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    public final SpannableStringBuilder A(NoteBean noteBean) {
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        String k = DateUtils.k(noteBean.getRecordTime());
        if (!TranslatorConstants.isAirPro()) {
            return new SpannableStringBuilder(k);
        }
        String geoAddress = noteBean.getGeoAddress();
        if (StringsKt.isBlank(geoAddress)) {
            geoAddress = noteBean.getGeoLocation();
        }
        if (!(!StringsKt.isBlank(geoAddress))) {
            return new SpannableStringBuilder(k);
        }
        String str = geoAddress + "&&" + k;
        Matcher matcher = new Regex("&&").toPattern().matcher(str);
        CenterImageSpan centerImageSpan = new CenterImageSpan(this.b, R.drawable.icon_record_subtitle_divider_margin, false, 4, (DefaultConstructorMarker) null);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        while (matcher.find()) {
            LogExt.j("getRecordSubtitle start=" + matcher.start() + ", end=" + matcher.end(), "TranslatorRecordViewModel");
            spannableStringBuilder.setSpan(centerImageSpan, matcher.start(), matcher.end(), 33);
        }
        return spannableStringBuilder;
    }

    public final String B(NoteBean noteBean) {
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        String title = noteBean.getTitle();
        if (!StringsKt.isBlank(title)) {
            return title;
        }
        int transType = noteBean.getTransType();
        if (transType == 2) {
            String string = this.b.getString(R.string.tl_simul_interpret);
            Intrinsics.checkNotNull(string);
            return string;
        } else if (transType != 3) {
            return "";
        } else {
            String string2 = this.b.getString(R.string.tl_dialogue_trans);
            Intrinsics.checkNotNull(string2);
            return string2;
        }
    }

    public final String D(NoteBean noteBean, List list) {
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        Intrinsics.checkNotNullParameter(list, "noteBeanList");
        StringBuilder sb = new StringBuilder();
        sb.append(noteBean.getTitle());
        sb.append("\n\n");
        String geoAddress = noteBean.getGeoAddress();
        if (StringsKt.isBlank(geoAddress)) {
            geoAddress = noteBean.getGeoLocation();
        }
        if (!StringsKt.isBlank(geoAddress)) {
            sb.append(geoAddress);
            sb.append("\n\n");
        }
        sb.append(DateUtils.k(noteBean.getRecordTime()));
        sb.append("\n\n");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            NoteDetailBean noteDetailBean = (NoteDetailBean) it.next();
            if (noteDetailBean.getSpeaker() == 0) {
                if (noteDetailBean.getTransType() == 1) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String string = this.b.getString(R.string.tl_share_i);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{StringsKt.trim((CharSequence) noteDetailBean.getSrc()).toString()}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    sb.append(format);
                    sb.append("\n\n");
                } else {
                    String obj = StringsKt.trim((CharSequence) noteDetailBean.getSrc()).toString();
                    String obj2 = StringsKt.trim((CharSequence) noteDetailBean.getDst()).toString();
                    if (noteDetailBean.isDisplaySrc()) {
                        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                        String string2 = this.b.getString(R.string.tl_share_i);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        String format2 = String.format(string2, Arrays.copyOf(new Object[]{obj}, 1));
                        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                        sb.append(format2);
                        sb.append(StringUtils.LF);
                        sb.append(obj2);
                        sb.append("\n\n");
                    } else {
                        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                        String string3 = this.b.getString(R.string.tl_share_i);
                        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                        String format3 = String.format(string3, Arrays.copyOf(new Object[]{obj2}, 1));
                        Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                        sb.append(format3);
                        sb.append("\n\n");
                    }
                }
            } else if (noteDetailBean.getTransType() == 1) {
                StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                String string4 = this.b.getString(R.string.tl_share_other);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                String format4 = String.format(string4, Arrays.copyOf(new Object[]{StringsKt.trim((CharSequence) noteDetailBean.getSrc()).toString()}, 1));
                Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
                sb.append(format4);
                sb.append("\n\n");
            } else {
                String obj3 = StringsKt.trim((CharSequence) noteDetailBean.getSrc()).toString();
                String obj4 = StringsKt.trim((CharSequence) noteDetailBean.getDst()).toString();
                if (noteDetailBean.isDisplaySrc()) {
                    StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
                    String string5 = this.b.getString(R.string.tl_share_other);
                    Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                    String format5 = String.format(string5, Arrays.copyOf(new Object[]{obj3}, 1));
                    Intrinsics.checkNotNullExpressionValue(format5, "format(...)");
                    sb.append(format5);
                    sb.append(StringUtils.LF);
                    sb.append(obj4);
                    sb.append("\n\n");
                } else {
                    StringCompanionObject stringCompanionObject6 = StringCompanionObject.INSTANCE;
                    String string6 = this.b.getString(R.string.tl_share_other);
                    Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                    String format6 = String.format(string6, Arrays.copyOf(new Object[]{obj4}, 1));
                    Intrinsics.checkNotNullExpressionValue(format6, "format(...)");
                    sb.append(format6);
                    sb.append("\n\n");
                }
            }
        }
        sb.append(this.b.getString(R.string.tl_share_record_mark));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final String E(NoteBean noteBean, String str) {
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        Intrinsics.checkNotNullParameter(str, "record");
        StringBuilder sb = new StringBuilder();
        sb.append(noteBean.getTitle());
        sb.append("\n\n");
        String geoAddress = noteBean.getGeoAddress();
        if (StringsKt.isBlank(geoAddress)) {
            geoAddress = noteBean.getGeoLocation();
        }
        if (!StringsKt.isBlank(geoAddress)) {
            sb.append(geoAddress);
            sb.append("\n\n");
        }
        sb.append(DateUtils.k(noteBean.getRecordTime()));
        sb.append("\n\n");
        sb.append(str);
        sb.append("\n\n");
        sb.append(this.b.getString(R.string.tl_share_record_mark));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object F(com.upuphone.ar.translation.phone.bean.NoteBean r18, java.lang.String r19, java.lang.String r20, kotlin.coroutines.Continuation r21) {
        /*
            r17 = this;
            r0 = r21
            boolean r1 = r0 instanceof com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$getTextRecordData$1
            if (r1 == 0) goto L_0x0017
            r1 = r0
            com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$getTextRecordData$1 r1 = (com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$getTextRecordData$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.label = r2
            r2 = r17
            goto L_0x001e
        L_0x0017:
            com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$getTextRecordData$1 r1 = new com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$getTextRecordData$1
            r2 = r17
            r1.<init>(r2, r0)
        L_0x001e:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            java.lang.String r5 = "\n\n"
            r6 = 2
            r8 = 1
            if (r4 == 0) goto L_0x0076
            if (r4 == r8) goto L_0x0059
            if (r4 != r6) goto L_0x0051
            int r2 = r1.I$1
            int r4 = r1.I$0
            java.lang.Object r9 = r1.L$5
            android.text.SpannableString r9 = (android.text.SpannableString) r9
            java.lang.Object r10 = r1.L$4
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            java.lang.Object r11 = r1.L$3
            android.text.SpannableStringBuilder r11 = (android.text.SpannableStringBuilder) r11
            java.lang.Object r12 = r1.L$2
            java.util.List r12 = (java.util.List) r12
            java.lang.Object r13 = r1.L$1
            java.util.List r13 = (java.util.List) r13
            java.lang.Object r14 = r1.L$0
            com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel r14 = (com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel) r14
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0194
        L_0x0051:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0059:
            int r2 = r1.I$1
            int r4 = r1.I$0
            java.lang.Object r9 = r1.L$4
            android.text.SpannableStringBuilder r9 = (android.text.SpannableStringBuilder) r9
            java.lang.Object r10 = r1.L$3
            android.text.SpannableStringBuilder r10 = (android.text.SpannableStringBuilder) r10
            java.lang.Object r11 = r1.L$2
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r12 = r1.L$1
            java.util.List r12 = (java.util.List) r12
            java.lang.Object r13 = r1.L$0
            com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel r13 = (com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel) r13
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0145
        L_0x0076:
            kotlin.ResultKt.throwOnFailure(r0)
            int r0 = r18.getTransType()
            java.lang.String r4 = com.upuphone.ar.translation.ext.InterconnectMsgCodExtKt.k(r0)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "getTextRecordData transType="
            r9.append(r10)
            r9.append(r4)
            java.lang.String r4 = r9.toString()
            java.lang.String r9 = "TranslatorRecordViewModel"
            com.upuphone.ar.translation.ext.LogExt.j(r4, r9)
            java.lang.Class<com.upuphone.ar.translation.phone.bean.TransRecord> r4 = com.upuphone.ar.translation.phone.bean.TransRecord.class
            r9 = r19
            java.util.List r9 = com.upuphone.ar.translation.utils.GsonUtils.b(r9, r4)
            r10 = r20
            java.util.List r4 = com.upuphone.ar.translation.utils.GsonUtils.b(r10, r4)
            android.text.SpannableStringBuilder r10 = new android.text.SpannableStringBuilder
            r10.<init>()
            if (r0 != r8) goto L_0x00e2
            java.util.Iterator r0 = r9.iterator()
            r7 = 0
        L_0x00b1:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01be
            int r1 = r7 + 1
            java.lang.Object r2 = r0.next()
            com.upuphone.ar.translation.phone.bean.TransRecord r2 = (com.upuphone.ar.translation.phone.bean.TransRecord) r2
            int r3 = kotlin.collections.CollectionsKt.getLastIndex(r9)
            if (r7 == r3) goto L_0x00d5
            java.lang.String r2 = r2.getRContent()
            java.lang.String r2 = com.upuphone.ar.translation.ext.StringExtKt.a(r2)
            android.text.SpannableStringBuilder r2 = r10.append(r2)
            r2.append(r5)
            goto L_0x00e0
        L_0x00d5:
            java.lang.String r2 = r2.getRContent()
            java.lang.String r2 = com.upuphone.ar.translation.ext.StringExtKt.a(r2)
            r10.append(r2)
        L_0x00e0:
            r7 = r1
            goto L_0x00b1
        L_0x00e2:
            int r0 = r9.size()
            r12 = r4
            r13 = r9
            r11 = r10
            r4 = 0
        L_0x00ea:
            if (r4 >= r0) goto L_0x01bd
            java.lang.Object r9 = r13.get(r4)
            com.upuphone.ar.translation.phone.bean.TransRecord r9 = (com.upuphone.ar.translation.phone.bean.TransRecord) r9
            java.lang.Object r10 = r12.get(r4)
            com.upuphone.ar.translation.phone.bean.TransRecord r10 = (com.upuphone.ar.translation.phone.bean.TransRecord) r10
            boolean r14 = r9.getRContentDisplay()
            java.lang.String r9 = r9.getRContent()
            java.lang.String r9 = com.upuphone.ar.translation.ext.StringExtKt.a(r9)
            java.lang.String r15 = r10.getRContent()
            java.lang.String r15 = com.upuphone.ar.translation.ext.StringExtKt.a(r15)
            java.lang.String r10 = r10.getRContentIndex()
            boolean r16 = kotlin.text.StringsKt.isBlank(r10)
            r16 = r16 ^ 1
            r7 = 0
            if (r16 == 0) goto L_0x0152
            boolean r16 = com.upuphone.ar.translation.utils.JsonUtils.b(r10)
            if (r16 == 0) goto L_0x0152
            java.lang.Class<com.upuphone.ar.translation.phone.bean.TransRecordIndex> r9 = com.upuphone.ar.translation.phone.bean.TransRecordIndex.class
            java.util.List r9 = com.upuphone.ar.translation.utils.GsonUtils.b(r10, r9)
            r1.L$0 = r2
            r1.L$1 = r13
            r1.L$2 = r12
            r1.L$3 = r11
            r1.L$4 = r11
            r1.L$5 = r7
            r1.I$0 = r4
            r1.I$1 = r0
            r1.label = r8
            java.lang.Object r7 = r2.H(r15, r9, r1)
            if (r7 != r3) goto L_0x013e
            return r3
        L_0x013e:
            r9 = r11
            r10 = r9
            r11 = r12
            r12 = r13
            r13 = r2
            r2 = r0
            r0 = r7
        L_0x0145:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.append(r0)
            r0 = r2
            r7 = r8
            r2 = r13
            r13 = r12
            r12 = r11
            r11 = r10
            goto L_0x01b9
        L_0x0152:
            if (r14 == 0) goto L_0x0159
            android.text.SpannableString r10 = r2.O(r9)
            goto L_0x015b
        L_0x0159:
            java.lang.String r10 = ""
        L_0x015b:
            android.text.SpannableString r14 = r2.N(r15)
            boolean r9 = com.upuphone.ar.translation.ext.StringExtKt.b(r9)
            if (r9 != 0) goto L_0x016e
            boolean r9 = com.upuphone.ar.translation.ext.StringExtKt.b(r15)
            if (r9 == 0) goto L_0x016c
            goto L_0x016e
        L_0x016c:
            r9 = 0
            goto L_0x016f
        L_0x016e:
            r9 = r8
        L_0x016f:
            kotlinx.coroutines.MainCoroutineDispatcher r15 = kotlinx.coroutines.Dispatchers.c()
            com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$getTextRecordData$2 r8 = new com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$getTextRecordData$2
            r8.<init>(r2, r9, r7)
            r1.L$0 = r2
            r1.L$1 = r13
            r1.L$2 = r12
            r1.L$3 = r11
            r1.L$4 = r10
            r1.L$5 = r14
            r1.I$0 = r4
            r1.I$1 = r0
            r1.label = r6
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.g(r15, r8, r1)
            if (r7 != r3) goto L_0x0191
            return r3
        L_0x0191:
            r9 = r14
            r14 = r2
            r2 = r0
        L_0x0194:
            boolean r0 = kotlin.text.StringsKt.isBlank(r10)
            r7 = 1
            r0 = r0 ^ r7
            if (r0 == 0) goto L_0x01aa
            android.text.SpannableStringBuilder r0 = r11.append(r10)
            java.lang.String r7 = "\n"
            android.text.SpannableStringBuilder r0 = r0.append(r7)
            r0.append(r9)
            goto L_0x01ad
        L_0x01aa:
            r11.append(r9)
        L_0x01ad:
            int r0 = kotlin.collections.CollectionsKt.getLastIndex(r13)
            if (r4 == r0) goto L_0x01b6
            r11.append(r5)
        L_0x01b6:
            r0 = r2
            r2 = r14
            r7 = 1
        L_0x01b9:
            int r4 = r4 + r7
            r8 = r7
            goto L_0x00ea
        L_0x01bd:
            r10 = r11
        L_0x01be:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel.F(com.upuphone.ar.translation.phone.bean.NoteBean, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Pair G(String str, String str2, List list) {
        int recordIndex;
        Intrinsics.checkNotNullParameter(str, "originalSrc");
        Intrinsics.checkNotNullParameter(str2, "originalDst");
        Intrinsics.checkNotNullParameter(list, "detailBeans");
        if (StringsKt.isBlank(str) || StringsKt.isBlank(str2)) {
            return new Pair(str, str2);
        }
        if (!JsonUtils.b(str) || !JsonUtils.b(str2)) {
            return new Pair(str, str2);
        }
        Class<TransRecord> cls = TransRecord.class;
        List b2 = GsonUtils.b(str, cls);
        List b3 = GsonUtils.b(str2, cls);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            NoteDetailBean noteDetailBean = (NoteDetailBean) it.next();
            if ((noteDetailBean.getNoteStatus() == 1 || noteDetailBean.getNoteStatus() == 2) && (recordIndex = noteDetailBean.getRecordIndex()) >= 0 && recordIndex <= CollectionsKt.getLastIndex(b2)) {
                if (noteDetailBean.getSpeaker() == 0) {
                    ((TransRecord) b2.get(recordIndex)).setPContent(noteDetailBean.getSrc());
                    ((TransRecord) b3.get(recordIndex)).setPContent(noteDetailBean.getDst());
                } else {
                    ((TransRecord) b2.get(recordIndex)).setRContent(noteDetailBean.getSrc());
                    ((TransRecord) b3.get(recordIndex)).setRContent(noteDetailBean.getDst());
                }
            }
        }
        int size = b2.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            TransRecord transRecord = (TransRecord) b2.get(i2);
            TransRecord transRecord2 = (TransRecord) b3.get(i2);
            String rContent = transRecord.getRContent();
            String rContent2 = transRecord2.getRContent();
            String pContent = transRecord.getPContent();
            String pContent2 = transRecord2.getPContent();
            if (StringsKt.isBlank(rContent) && StringsKt.isBlank(rContent2) && StringsKt.isBlank(pContent) && StringsKt.isBlank(pContent2)) {
                i++;
            }
        }
        String str3 = "";
        String d2 = i != b2.size() ? JsonUtils.d(b2) : str3;
        if (i != b2.size()) {
            str3 = JsonUtils.d(b3);
        }
        LogExt.j("getUpdateRecordList srcJson=" + d2, "TranslatorRecordViewModel");
        LogExt.j("getUpdateRecordList dstJson=" + str3, "TranslatorRecordViewModel");
        return new Pair(d2, str3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00fa, code lost:
        if (r12 != r6) goto L_0x00fd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object H(java.lang.String r18, java.util.List r19, kotlin.coroutines.Continuation r20) {
        /*
            r17 = this;
            r0 = r20
            boolean r1 = r0 instanceof com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$getUpdatedTextRecord$1
            if (r1 == 0) goto L_0x0017
            r1 = r0
            com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$getUpdatedTextRecord$1 r1 = (com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$getUpdatedTextRecord$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.label = r2
            r2 = r17
            goto L_0x001e
        L_0x0017:
            com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$getUpdatedTextRecord$1 r1 = new com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$getUpdatedTextRecord$1
            r2 = r17
            r1.<init>(r2, r0)
        L_0x001e:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 1
            if (r4 == 0) goto L_0x0064
            if (r4 != r5) goto L_0x005c
            int r2 = r1.I$2
            int r4 = r1.I$1
            int r6 = r1.I$0
            java.lang.Object r7 = r1.L$6
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r1.L$5
            com.upuphone.ar.translation.phone.bean.TransRecordIndex r8 = (com.upuphone.ar.translation.phone.bean.TransRecordIndex) r8
            java.lang.Object r9 = r1.L$4
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r10 = r1.L$3
            android.text.SpannableStringBuilder r10 = (android.text.SpannableStringBuilder) r10
            java.lang.Object r11 = r1.L$2
            java.util.List r11 = (java.util.List) r11
            java.lang.Object r12 = r1.L$1
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r1.L$0
            com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel r13 = (com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel) r13
            kotlin.ResultKt.throwOnFailure(r0)
            r0 = r12
            r12 = r2
            r2 = r13
            r16 = r4
            r4 = r1
            r1 = r11
            r11 = r8
            r8 = r16
            goto L_0x00e5
        L_0x005c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0064:
            kotlin.ResultKt.throwOnFailure(r0)
            android.text.SpannableStringBuilder r0 = new android.text.SpannableStringBuilder
            r0.<init>()
            int r4 = r18.length()
            java.util.Iterator r6 = r19.iterator()
            r7 = 0
            r10 = r0
            r9 = r6
            r0 = r18
            r6 = r4
            r4 = r1
            r1 = r19
        L_0x007d:
            boolean r8 = r9.hasNext()
            if (r8 == 0) goto L_0x0100
            int r8 = r7 + 1
            java.lang.Object r11 = r9.next()
            com.upuphone.ar.translation.phone.bean.TransRecordIndex r11 = (com.upuphone.ar.translation.phone.bean.TransRecordIndex) r11
            int r12 = kotlin.collections.CollectionsKt.getLastIndex(r1)
            if (r7 == r12) goto L_0x00a0
            int r7 = r11.getStartIndex()
            java.lang.Object r12 = r1.get(r8)
            com.upuphone.ar.translation.phone.bean.TransRecordIndex r12 = (com.upuphone.ar.translation.phone.bean.TransRecordIndex) r12
            int r12 = r12.getStartIndex()
            goto L_0x00a5
        L_0x00a0:
            int r7 = r11.getStartIndex()
            r12 = r6
        L_0x00a5:
            if (r12 <= r7) goto L_0x00aa
            if (r12 < r6) goto L_0x00aa
            r12 = r6
        L_0x00aa:
            int r13 = r7 + 1
            if (r13 > r12) goto L_0x00fd
            if (r12 > r6) goto L_0x00fd
            java.lang.String r7 = r0.substring(r7, r12)
            java.lang.String r13 = "substring(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r13)
            boolean r13 = com.upuphone.ar.translation.ext.StringExtKt.b(r7)
            kotlinx.coroutines.MainCoroutineDispatcher r14 = kotlinx.coroutines.Dispatchers.c()
            com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$getUpdatedTextRecord$2 r15 = new com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$getUpdatedTextRecord$2
            r5 = 0
            r15.<init>(r2, r13, r5)
            r4.L$0 = r2
            r4.L$1 = r0
            r4.L$2 = r1
            r4.L$3 = r10
            r4.L$4 = r9
            r4.L$5 = r11
            r4.L$6 = r7
            r4.I$0 = r6
            r4.I$1 = r8
            r4.I$2 = r12
            r5 = 1
            r4.label = r5
            java.lang.Object r13 = kotlinx.coroutines.BuildersKt.g(r14, r15, r4)
            if (r13 != r3) goto L_0x00e5
            return r3
        L_0x00e5:
            int r11 = r11.getRecordType()
            if (r11 != 0) goto L_0x00f3
            android.text.SpannableString r7 = r2.O(r7)
            r10.append(r7)
            goto L_0x00fa
        L_0x00f3:
            android.text.SpannableString r7 = r2.N(r7)
            r10.append(r7)
        L_0x00fa:
            if (r12 != r6) goto L_0x00fd
            goto L_0x0100
        L_0x00fd:
            r7 = r8
            goto L_0x007d
        L_0x0100:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getUpdatedTextRecord text=["
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = "], \nupdateText=["
            r1.append(r0)
            r1.append(r10)
            java.lang.String r0 = "]"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "TranslatorRecordViewModel"
            com.upuphone.ar.translation.ext.LogExt.g(r0, r1)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel.H(java.lang.String, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean I(NoteBean noteBean) {
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        int transType = noteBean.getTransType();
        if (transType == 2) {
            return t().contains(noteBean.getDstLanguage());
        }
        if (transType != 3) {
            return false;
        }
        return t().contains(noteBean.getDstLanguage());
    }

    public final void K(int i, Editable editable, Function1 function1) {
        Intrinsics.checkNotNullParameter(editable, "editable");
        Intrinsics.checkNotNullParameter(function1, "callback");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.b(), (CoroutineStart) null, new TranslatorRecordViewModel$parseListRecordSpans$1(editable, i, this, function1, (Continuation<? super TranslatorRecordViewModel$parseListRecordSpans$1>) null), 2, (Object) null);
    }

    public final String L(Editable editable) {
        Intrinsics.checkNotNullParameter(editable, "editable");
        ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) editable.getSpans(0, editable.length(), ForegroundColorSpan.class);
        int color = this.b.getColor(R.color.color_record_detail_other_src);
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNull(foregroundColorSpanArr);
        for (ForegroundColorSpan foregroundColorSpan : foregroundColorSpanArr) {
            int spanStart = editable.getSpanStart(foregroundColorSpan);
            int foregroundColor = foregroundColorSpan.getForegroundColor();
            TransRecordIndex transRecordIndex = new TransRecordIndex();
            transRecordIndex.setRecordType(foregroundColor == color ? 0 : 1);
            transRecordIndex.setStartIndex(spanStart);
            arrayList.add(transRecordIndex);
        }
        return JsonUtils.d(arrayList);
    }

    public final void M(int i) {
        UToast.Companion companion = UToast.f6444a;
        Application application = this.b;
        String string = application.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        companion.e(application, string, 0);
    }

    public final SpannableString N(String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(this.b.getColor(R.color.color_record_detail_other_dst)), 0, spannableString.length(), 18);
        return spannableString;
    }

    public final SpannableString O(String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(this.b.getColor(R.color.color_record_detail_other_src)), 0, spannableString.length(), 18);
        return spannableString;
    }

    public final void P(Activity activity, NoteBean noteBean, RecyclerView recyclerView, View view, List list, String str) {
        Activity activity2 = activity;
        Intrinsics.checkNotNullParameter(activity, "activity");
        NoteBean noteBean2 = noteBean;
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        RecyclerView recyclerView2 = recyclerView;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(list, "noteBeanList");
        Intrinsics.checkNotNullParameter(str, "textRecord");
        if (!TranslatorConstants.isAirPro()) {
            S(activity, noteBean, recyclerView, view);
            return;
        }
        ShowAtBottomAlertDialog create = new ShowAtBottomAlertDialog.Builder(activity).setItems((CharSequence[]) this.b.getResources().getStringArray(R.array.share_choice_type), (DialogInterface.OnClickListener) new h(this, activity, noteBean, recyclerView, view, list, str), true).create();
        Intrinsics.checkNotNull(create);
        DialogExtKt.a(create);
        create.setButton(-2, (CharSequence) this.b.getString(R.string.tl_dialog_cancel), (DialogInterface.OnClickListener) new i());
        create.show();
    }

    public final void S(Activity activity, NoteBean noteBean, RecyclerView recyclerView, View view) {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranslatorRecordViewModel$shareRecordImage$1(activity, noteBean, recyclerView, view, (Continuation<? super TranslatorRecordViewModel$shareRecordImage$1>) null), 2, (Object) null);
    }

    public final void U(Activity activity, NoteBean noteBean, List list, String str) {
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranslatorRecordViewModel$shareRecordText$1(activity, noteBean, this, list, str, (Continuation<? super TranslatorRecordViewModel$shareRecordText$1>) null), 2, (Object) null);
    }

    public final void V(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        LayoutTlDialogCustomTitleBinding c2 = LayoutTlDialogCustomTitleBinding.c(activity.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        c2.c.setText(R.string.tl_abandon_current_edit);
        AlertDialog create = new AlertDialog.Builder(activity).setPositiveButton(R.string.tl_abandon, (DialogInterface.OnClickListener) new l(activity)).setNegativeButton(R.string.tl_dialog_cancel, (DialogInterface.OnClickListener) new m()).create();
        Intrinsics.checkNotNull(create);
        DialogExtKt.a(create);
        create.setCustomTitle(c2.getRoot());
        create.show();
    }

    public final void Y(NoteBean noteBean, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranslatorRecordViewModel$updateListRecordData$1(noteBean, z, z2, (Continuation<? super TranslatorRecordViewModel$updateListRecordData$1>) null), 2, (Object) null);
    }

    public final void Z(NoteBean noteBean, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranslatorRecordViewModel$updateTextRecordData$1(noteBean, z, z2, (Continuation<? super TranslatorRecordViewModel$updateTextRecordData$1>) null), 2, (Object) null);
    }

    public final void n(Activity activity, NoteBean noteBean) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranslatorRecordViewModel$deleteRecordData$1(noteBean, activity, (Continuation<? super TranslatorRecordViewModel$deleteRecordData$1>) null), 2, (Object) null);
    }

    public final void p(Activity activity, NoteBean noteBean) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(noteBean, "noteBean");
        LayoutTlDialogCustomTitleBinding c2 = LayoutTlDialogCustomTitleBinding.c(activity.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        c2.c.setText(R.string.tl_dialog_delete);
        TextView textView = c2.b;
        Intrinsics.checkNotNullExpressionValue(textView, "tvDialogMessage");
        textView.setVisibility(0);
        c2.b.setText(R.string.tl_dialog_delete_tips);
        AlertDialog create = new AlertDialog.Builder(activity).setPositiveButton(R.string.tl_dialog_delete_ok, (DialogInterface.OnClickListener) new j(this, activity, noteBean)).setNegativeButton(R.string.tl_dialog_cancel, (DialogInterface.OnClickListener) new k()).create();
        Intrinsics.checkNotNull(create);
        DialogExtKt.a(create);
        create.setCustomTitle(c2.getRoot());
        create.show();
    }

    public final Application s() {
        return this.b;
    }

    public final List t() {
        return TranslatorConstants.isIntlVersion() ? CollectionsKt.arrayListOf("cn", "en", "cnen", "de", "ja") : CollectionsKt.arrayListOf("cn", "en", "cnen");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object v(com.upuphone.ar.translation.phone.bean.NoteBean r17, java.lang.String r18, java.lang.String r19, kotlin.coroutines.Continuation r20) {
        /*
            r16 = this;
            r0 = r20
            boolean r1 = r0 instanceof com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$getListRecordData$1
            if (r1 == 0) goto L_0x0017
            r1 = r0
            com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$getListRecordData$1 r1 = (com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$getListRecordData$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.label = r2
            r2 = r16
            goto L_0x001e
        L_0x0017:
            com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$getListRecordData$1 r1 = new com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$getListRecordData$1
            r2 = r16
            r1.<init>(r2, r0)
        L_0x001e:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r6 = 1
            if (r4 == 0) goto L_0x0057
            if (r4 != r6) goto L_0x004f
            int r2 = r1.I$1
            int r4 = r1.I$0
            java.lang.Object r7 = r1.L$4
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r1.L$3
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r1.L$2
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r10 = r1.L$1
            com.upuphone.ar.translation.phone.bean.NoteBean r10 = (com.upuphone.ar.translation.phone.bean.NoteBean) r10
            java.lang.Object r11 = r1.L$0
            com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel r11 = (com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel) r11
            kotlin.ResultKt.throwOnFailure(r0)
            r5 = r6
            r0 = r10
            r6 = 0
            r10 = r9
            r9 = r8
            r8 = r2
            r2 = r11
            goto L_0x0155
        L_0x004f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0057:
            kotlin.ResultKt.throwOnFailure(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.Class<com.upuphone.ar.translation.phone.bean.TransRecord> r4 = com.upuphone.ar.translation.phone.bean.TransRecord.class
            r7 = r18
            java.util.List r7 = com.upuphone.ar.translation.utils.GsonUtils.b(r7, r4)
            r8 = r19
            java.util.List r4 = com.upuphone.ar.translation.utils.GsonUtils.b(r8, r4)
            int r8 = r7.size()
            r10 = r0
            r9 = r7
            r0 = r17
            r7 = r4
            r4 = 0
        L_0x0077:
            if (r4 >= r8) goto L_0x0159
            java.lang.Object r11 = r9.get(r4)
            com.upuphone.ar.translation.phone.bean.TransRecord r11 = (com.upuphone.ar.translation.phone.bean.TransRecord) r11
            java.lang.Object r12 = r7.get(r4)
            com.upuphone.ar.translation.phone.bean.TransRecord r12 = (com.upuphone.ar.translation.phone.bean.TransRecord) r12
            java.lang.String r13 = r11.getRContent()
            java.lang.String r13 = com.upuphone.ar.translation.ext.StringExtKt.a(r13)
            java.lang.String r14 = r12.getRContent()
            java.lang.String r14 = com.upuphone.ar.translation.ext.StringExtKt.a(r14)
            boolean r15 = kotlin.text.StringsKt.isBlank(r13)
            r15 = r15 ^ r6
            if (r15 != 0) goto L_0x00a3
            boolean r15 = kotlin.text.StringsKt.isBlank(r14)
            r15 = r15 ^ r6
            if (r15 == 0) goto L_0x00cc
        L_0x00a3:
            com.upuphone.ar.translation.phone.bean.NoteDetailBean r15 = new com.upuphone.ar.translation.phone.bean.NoteDetailBean
            r15.<init>()
            r15.setSpeaker(r6)
            r15.setSrc(r13)
            r15.setDst(r14)
            boolean r5 = r11.getRContentDisplay()
            r15.setDisplaySrc(r5)
            int r5 = r0.getTransType()
            r15.setTransType(r5)
            int r5 = r0.getXrType()
            r15.setXrType(r5)
            r15.setRecordIndex(r4)
            r10.add(r15)
        L_0x00cc:
            java.lang.String r5 = r11.getPContent()
            java.lang.String r5 = com.upuphone.ar.translation.ext.StringExtKt.a(r5)
            java.lang.String r12 = r12.getPContent()
            java.lang.String r12 = com.upuphone.ar.translation.ext.StringExtKt.a(r12)
            boolean r15 = kotlin.text.StringsKt.isBlank(r5)
            r15 = r15 ^ r6
            if (r15 != 0) goto L_0x00ed
            boolean r15 = kotlin.text.StringsKt.isBlank(r12)
            r15 = r15 ^ r6
            if (r15 == 0) goto L_0x00eb
            goto L_0x00ed
        L_0x00eb:
            r6 = 0
            goto L_0x0117
        L_0x00ed:
            com.upuphone.ar.translation.phone.bean.NoteDetailBean r15 = new com.upuphone.ar.translation.phone.bean.NoteDetailBean
            r15.<init>()
            r6 = 0
            r15.setSpeaker(r6)
            r15.setSrc(r5)
            r15.setDst(r12)
            boolean r11 = r11.getRContentDisplay()
            r15.setDisplaySrc(r11)
            int r11 = r0.getTransType()
            r15.setTransType(r11)
            int r11 = r0.getXrType()
            r15.setXrType(r11)
            r15.setRecordIndex(r4)
            r10.add(r15)
        L_0x0117:
            boolean r11 = com.upuphone.ar.translation.ext.StringExtKt.b(r13)
            if (r11 != 0) goto L_0x0132
            boolean r11 = com.upuphone.ar.translation.ext.StringExtKt.b(r14)
            if (r11 != 0) goto L_0x0132
            boolean r5 = com.upuphone.ar.translation.ext.StringExtKt.b(r5)
            if (r5 != 0) goto L_0x0132
            boolean r5 = com.upuphone.ar.translation.ext.StringExtKt.b(r12)
            if (r5 == 0) goto L_0x0130
            goto L_0x0132
        L_0x0130:
            r5 = r6
            goto L_0x0133
        L_0x0132:
            r5 = 1
        L_0x0133:
            kotlinx.coroutines.MainCoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.c()
            com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$getListRecordData$6 r12 = new com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel$getListRecordData$6
            r13 = 0
            r12.<init>(r2, r5, r13)
            r1.L$0 = r2
            r1.L$1 = r0
            r1.L$2 = r10
            r1.L$3 = r9
            r1.L$4 = r7
            r1.I$0 = r4
            r1.I$1 = r8
            r5 = 1
            r1.label = r5
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.g(r11, r12, r1)
            if (r11 != r3) goto L_0x0155
            return r3
        L_0x0155:
            int r4 = r4 + r5
            r6 = r5
            goto L_0x0077
        L_0x0159:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.translation.phone.vm.TranslatorRecordViewModel.v(com.upuphone.ar.translation.phone.bean.NoteBean, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final LiveData w() {
        return this.f;
    }

    public final LiveData x() {
        return this.e;
    }

    public final void y(long j, Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        Job unused = BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), Dispatchers.c(), (CoroutineStart) null, new TranslatorRecordViewModel$getRecordForId$1(function1, j, (Continuation<? super TranslatorRecordViewModel$getRecordForId$1>) null), 2, (Object) null);
    }
}
