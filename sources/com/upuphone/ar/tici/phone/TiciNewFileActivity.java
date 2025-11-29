package com.upuphone.ar.tici.phone;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.honey.account.p4.v0;
import com.honey.account.p4.w0;
import com.honey.account.p4.x0;
import com.honey.account.p4.y0;
import com.upuphone.ar.tici.R;
import com.upuphone.ar.tici.databinding.ActivityNewTiciFileBinding;
import com.upuphone.ar.tici.phone.db.entity.TiciEntity;
import com.upuphone.ar.tici.phone.utils.CommonExtKt;
import com.upuphone.ar.tici.phone.utils.EmojiFilter;
import com.upuphone.ar.tici.phone.utils.MaxLengthFilter;
import com.upuphone.ar.tici.phone.utils.SpecialSymbolsFilter;
import com.upuphone.ar.tici.phone.widget.TiciTitleBar;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.xr.sapp.utils.ActivityExtKt;
import com.upuphone.xr.sapp.utils.DimensExtKt;
import com.upuphone.xr.sapp.utils.ViewExtKt;
import flyme.support.v7.app.AlertDialog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0003J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/upuphone/ar/tici/phone/TiciNewFileActivity;", "Lcom/upuphone/ar/tici/phone/BaseTiciActivity;", "<init>", "()V", "", "initView", "initData", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "root", "Landroidx/core/view/WindowInsetsCompat;", "windowInsets", "onApplyWindowInsets", "(Landroid/view/View;Landroidx/core/view/WindowInsetsCompat;)V", "E0", "", "from", "M0", "(I)V", "G0", "", "J0", "()Z", "Lcom/upuphone/ar/tici/databinding/ActivityNewTiciFileBinding;", "b", "Lkotlin/Lazy;", "F0", "()Lcom/upuphone/ar/tici/databinding/ActivityNewTiciFileBinding;", "layout", "Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "c", "Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "oldTiciEntity", "", "d", "Ljava/lang/String;", "oldTiciContent", "e", "Companion", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTiciNewFileActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciNewFileActivity.kt\ncom/upuphone/ar/tici/phone/TiciNewFileActivity\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,325:1\n262#2,2:326\n262#2,2:328\n262#2,2:330\n329#2,4:384\n329#2,4:388\n58#3,23:332\n93#3,3:355\n58#3,23:358\n93#3,3:381\n*S KotlinDebug\n*F\n+ 1 TiciNewFileActivity.kt\ncom/upuphone/ar/tici/phone/TiciNewFileActivity\n*L\n94#1:326,2\n100#1:328,2\n101#1:330,2\n183#1:384,4\n187#1:388,4\n111#1:332,23\n111#1:355,3\n122#1:358,23\n122#1:381,3\n*E\n"})
public final class TiciNewFileActivity extends BaseTiciActivity {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);
    public final Lazy b = LazyKt.lazy(new TiciNewFileActivity$layout$2(this));
    public TiciEntity c;
    public String d;

    @SourceDebugExtension({"SMAP\nTiciNewFileActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciNewFileActivity.kt\ncom/upuphone/ar/tici/phone/TiciNewFileActivity$Companion\n+ 2 ContextExt.kt\ncom/upuphone/xr/sapp/utils/ContextExtKt\n*L\n1#1,325:1\n20#2,8:326\n*S KotlinDebug\n*F\n+ 1 TiciNewFileActivity.kt\ncom/upuphone/ar/tici/phone/TiciNewFileActivity$Companion\n*L\n58#1:326,8\n*E\n"})
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000b8\u0006XT¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000e8\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/upuphone/ar/tici/phone/TiciNewFileActivity$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "id", "", "a", "(Landroid/content/Context;J)V", "", "KEY_TICI_ID", "Ljava/lang/String;", "", "MAX_TITLE_LENGTH", "I", "TAG", "TICI_TEXT_PART_SIZE", "ar-tici_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, long j) {
            Intrinsics.checkNotNullParameter(context, "context");
            TiciNewFileActivity$Companion$startForEdit$1 ticiNewFileActivity$Companion$startForEdit$1 = new TiciNewFileActivity$Companion$startForEdit$1(j);
            Intent intent = new Intent(context, TiciNewFileActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
            }
            ticiNewFileActivity$Companion$startForEdit$1.invoke(intent);
            context.startActivity(intent);
        }

        public Companion() {
        }
    }

    public static final void H0(TiciNewFileActivity ticiNewFileActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(ticiNewFileActivity, "this$0");
        CommonExtKt.e("handleBackPressed, click save", "TiciNewFileActivity");
        ticiNewFileActivity.M0(1);
    }

    public static final void I0(TiciNewFileActivity ticiNewFileActivity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(ticiNewFileActivity, "this$0");
        CommonExtKt.e("handleBackPressed, click don`t save", "TiciNewFileActivity");
        ticiNewFileActivity.finish();
    }

    public static final void K0(TiciNewFileActivity ticiNewFileActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiNewFileActivity, "this$0");
        boolean b2 = ActivityExtKt.b(ticiNewFileActivity);
        CommonExtKt.e("back clicked, isImeVisible: " + b2, "TiciNewFileActivity");
        if (b2) {
            ActivityExtKt.a(ticiNewFileActivity);
        } else {
            ticiNewFileActivity.getOnBackPressedDispatcher().l();
        }
    }

    public static final void L0(TiciNewFileActivity ticiNewFileActivity, View view) {
        Intrinsics.checkNotNullParameter(ticiNewFileActivity, "this$0");
        CommonExtKt.e("save clicked", "TiciNewFileActivity");
        ticiNewFileActivity.M0(0);
    }

    private final void initData() {
        long longExtra = getIntent().getLongExtra("tici_id", 0);
        if (longExtra > 0) {
            Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciNewFileActivity$initData$1(longExtra, this, (Continuation<? super TiciNewFileActivity$initData$1>) null), 3, (Object) null);
        }
    }

    private final void initView() {
        TiciTitleBar ticiTitleBar = F0().e;
        ViewExtKt.b(ticiTitleBar.getBackImg(), new v0(this));
        ticiTitleBar.getTvSave().setVisibility(0);
        ViewExtKt.b(ticiTitleBar.getTvSave(), new w0(this));
        ticiTitleBar.getFolderImg().setVisibility(8);
        ticiTitleBar.getSettingImg().setVisibility(8);
        EditText editText = F0().c;
        editText.setFilters(new InputFilter[]{new EmojiFilter(), new SpecialSymbolsFilter(), new MaxLengthFilter(100, new TiciNewFileActivity$initView$2$1(this))});
        Intrinsics.checkNotNull(editText);
        editText.addTextChangedListener(new TiciNewFileActivity$initView$lambda$4$$inlined$doAfterTextChanged$1(this));
        EditText editText2 = F0().b;
        editText2.setFilters(new InputFilter[]{new EmojiFilter(), new MaxLengthFilter(60000, new TiciNewFileActivity$initView$3$1(this))});
        Intrinsics.checkNotNull(editText2);
        editText2.addTextChangedListener(new TiciNewFileActivity$initView$lambda$6$$inlined$doAfterTextChanged$1(this));
        E0();
    }

    public final void E0() {
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciNewFileActivity$checkSaveState$1(this, (Continuation<? super TiciNewFileActivity$checkSaveState$1>) null), 3, (Object) null);
    }

    public final ActivityNewTiciFileBinding F0() {
        return (ActivityNewTiciFileBinding) this.b.getValue();
    }

    public final void G0() {
        boolean J0 = J0();
        CommonExtKt.e("handleBackPressed, hasUnsavedContent: " + J0, "TiciNewFileActivity");
        if (J0) {
            new AlertDialog.Builder(this).setTitle(R.string.tici_unsaved_content_ask).setNegativeButton(R.string.tici_dont_save, (DialogInterface.OnClickListener) new x0(this)).setPositiveButton(R.string.tici_save, (DialogInterface.OnClickListener) new y0(this)).show();
        } else {
            finish();
        }
    }

    public final boolean J0() {
        Editable text = F0().c.getText();
        String str = null;
        String obj = text != null ? text.toString() : null;
        Editable text2 = F0().b.getText();
        if (text2 != null) {
            str = text2.toString();
        }
        boolean z = obj == null || obj.length() == 0 || StringsKt.isBlank(obj);
        boolean z2 = str == null || str.length() == 0 || StringsKt.isBlank(str);
        if (z && z2) {
            return false;
        }
        TiciEntity ticiEntity = this.c;
        return ticiEntity == null || !Intrinsics.areEqual((Object) ticiEntity.getFileName(), (Object) obj) || !Intrinsics.areEqual((Object) this.d, (Object) str);
    }

    public final void M0(int i) {
        Editable text = F0().c.getText();
        String obj = text != null ? text.toString() : null;
        if (obj == null || obj.length() == 0 || StringsKt.isBlank(obj)) {
            CommonExtKt.e("saveTici, title is empty or blank", "TiciNewFileActivity");
            CommonExtKt.j(this, R.string.tici_title_empty_tips, 0, 2, (Object) null);
            return;
        }
        Editable text2 = F0().b.getText();
        String obj2 = text2 != null ? text2.toString() : null;
        if (obj2 == null || obj2.length() == 0 || StringsKt.isBlank(obj2)) {
            CommonExtKt.e("saveTici, content is empty or blank", "TiciNewFileActivity");
            CommonExtKt.j(this, R.string.tici_content_empty_tips, 0, 2, (Object) null);
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), (CoroutineContext) null, (CoroutineStart) null, new TiciNewFileActivity$saveTici$1(obj, obj2, this, i, (Continuation<? super TiciNewFileActivity$saveTici$1>) null), 3, (Object) null);
    }

    public void onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(view, "root");
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "windowInsets");
        boolean q = windowInsetsCompat.q(WindowInsetsCompat.Type.a());
        Insets f = windowInsetsCompat.f(WindowInsetsCompat.Type.a());
        Intrinsics.checkNotNullExpressionValue(f, "getInsets(...)");
        CommonExtKt.e("onApplyWindowInsets2, isImeVisible: " + q + ", insets: " + f, "TiciNewFileActivity");
        if (q) {
            ScrollView scrollView = F0().d;
            Intrinsics.checkNotNullExpressionValue(scrollView, "layScroll");
            ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = f.d;
                scrollView.setLayoutParams(marginLayoutParams);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
        } else {
            ScrollView scrollView2 = F0().d;
            Intrinsics.checkNotNullExpressionValue(scrollView2, "layScroll");
            ViewGroup.LayoutParams layoutParams2 = scrollView2.getLayoutParams();
            if (layoutParams2 != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.bottomMargin = DimensExtKt.b(20);
                scrollView2.setLayoutParams(marginLayoutParams2);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
        }
        super.onApplyWindowInsets(view, windowInsetsCompat);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) F0().getRoot());
        initView();
        initData();
        getOnBackPressedDispatcher().i(this, new TiciNewFileActivity$onCreate$1(this));
    }
}
