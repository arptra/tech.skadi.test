package com.upuphone.ar.fastrecord.phone.ui.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.honey.account.w3.c;
import com.honey.account.w3.d;
import com.honey.account.w3.e;
import com.honey.account.w3.f;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.databinding.FastRecordShareDialogBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\fH\u0002JN\u0010\u0011\u001a\u00020\f2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bJ\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0006J\b\u0010\u0018\u001a\u00020\fH\u0016J\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\fR\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/dialog/FastRecordShareDialog;", "Landroid/app/AlertDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "themeResId", "", "(Landroid/content/Context;I)V", "mBinding", "Lcom/upuphone/ar/fastrecord/databinding/FastRecordShareDialogBinding;", "mClickCancel", "Lkotlin/Function0;", "", "mClickVideo", "mClickVideoAndWord", "mClickWord", "initView", "registerButtonClick", "clickShareVideoAndWord", "clickShareVideo", "clickShareWord", "clickCancel", "setShowType", "type", "show", "showTvIsClickable", "textView", "Landroid/widget/TextView;", "isClickable", "", "unRegisterButtonClick", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FastRecordShareDialog extends AlertDialog {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int SHOW_TYPE_AUDIO = 2;
    public static final int SHOW_TYPE_AUDIO_WORD = 3;
    public static final int SHOW_TYPE_WORD = 1;
    @NotNull
    private FastRecordShareDialogBinding mBinding;
    @Nullable
    private Function0<Unit> mClickCancel;
    @Nullable
    private Function0<Unit> mClickVideo;
    @Nullable
    private Function0<Unit> mClickVideoAndWord;
    @Nullable
    private Function0<Unit> mClickWord;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/dialog/FastRecordShareDialog$Companion;", "", "()V", "SHOW_TYPE_AUDIO", "", "SHOW_TYPE_AUDIO_WORD", "SHOW_TYPE_WORD", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FastRecordShareDialog(@NotNull Context context) {
        this(context, R.style.FastRecordLangPickerStyle);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void initView() {
        this.mBinding.f.setOnClickListener(new c(this));
        this.mBinding.e.setOnClickListener(new d(this));
        this.mBinding.g.setOnClickListener(new e(this));
        this.mBinding.b.setOnClickListener(new f(this));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$2(FastRecordShareDialog fastRecordShareDialog, View view) {
        Intrinsics.checkNotNullParameter(fastRecordShareDialog, "this$0");
        fastRecordShareDialog.dismiss();
        Function0<Unit> function0 = fastRecordShareDialog.mClickVideoAndWord;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$3(FastRecordShareDialog fastRecordShareDialog, View view) {
        Intrinsics.checkNotNullParameter(fastRecordShareDialog, "this$0");
        fastRecordShareDialog.dismiss();
        Function0<Unit> function0 = fastRecordShareDialog.mClickVideo;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$4(FastRecordShareDialog fastRecordShareDialog, View view) {
        Intrinsics.checkNotNullParameter(fastRecordShareDialog, "this$0");
        fastRecordShareDialog.dismiss();
        Function0<Unit> function0 = fastRecordShareDialog.mClickWord;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$5(FastRecordShareDialog fastRecordShareDialog, View view) {
        Intrinsics.checkNotNullParameter(fastRecordShareDialog, "this$0");
        fastRecordShareDialog.dismiss();
        Function0<Unit> function0 = fastRecordShareDialog.mClickCancel;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static /* synthetic */ void registerButtonClick$default(FastRecordShareDialog fastRecordShareDialog, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        if ((i & 2) != 0) {
            function02 = null;
        }
        if ((i & 4) != 0) {
            function03 = null;
        }
        if ((i & 8) != 0) {
            function04 = null;
        }
        fastRecordShareDialog.registerButtonClick(function0, function02, function03, function04);
    }

    private final void showTvIsClickable(TextView textView, boolean z) {
        textView.setClickable(z);
        if (z) {
            textView.setTextColor(getContext().getColor(R.color.fast_record_dialog_type_color));
        } else {
            textView.setTextColor(getContext().getColor(R.color.fast_record_dialog_title_tip_color));
        }
    }

    public final void registerButtonClick(@Nullable Function0<Unit> function0, @Nullable Function0<Unit> function02, @Nullable Function0<Unit> function03, @Nullable Function0<Unit> function04) {
        this.mClickVideoAndWord = function0;
        this.mClickVideo = function02;
        this.mClickWord = function03;
        this.mClickCancel = function04;
    }

    public final void setShowType(int i) {
        if (i == 1) {
            TextView textView = this.mBinding.g;
            Intrinsics.checkNotNullExpressionValue(textView, "tvShareTypeWord");
            showTvIsClickable(textView, true);
            TextView textView2 = this.mBinding.e;
            Intrinsics.checkNotNullExpressionValue(textView2, "tvShareTypeVideo");
            showTvIsClickable(textView2, false);
            TextView textView3 = this.mBinding.f;
            Intrinsics.checkNotNullExpressionValue(textView3, "tvShareTypeVideoWord");
            showTvIsClickable(textView3, false);
        } else if (i == 2) {
            TextView textView4 = this.mBinding.g;
            Intrinsics.checkNotNullExpressionValue(textView4, "tvShareTypeWord");
            showTvIsClickable(textView4, false);
            TextView textView5 = this.mBinding.e;
            Intrinsics.checkNotNullExpressionValue(textView5, "tvShareTypeVideo");
            showTvIsClickable(textView5, true);
            TextView textView6 = this.mBinding.f;
            Intrinsics.checkNotNullExpressionValue(textView6, "tvShareTypeVideoWord");
            showTvIsClickable(textView6, false);
        } else if (i == 3) {
            TextView textView7 = this.mBinding.g;
            Intrinsics.checkNotNullExpressionValue(textView7, "tvShareTypeWord");
            showTvIsClickable(textView7, true);
            TextView textView8 = this.mBinding.e;
            Intrinsics.checkNotNullExpressionValue(textView8, "tvShareTypeVideo");
            showTvIsClickable(textView8, true);
            TextView textView9 = this.mBinding.f;
            Intrinsics.checkNotNullExpressionValue(textView9, "tvShareTypeVideoWord");
            showTvIsClickable(textView9, true);
        }
    }

    public void show() {
        super.show();
        ConstraintLayout b = this.mBinding.getRoot();
        ViewGroup.LayoutParams layoutParams = this.mBinding.getRoot().getLayoutParams();
        layoutParams.width = getContext().getResources().getDisplayMetrics().widthPixels - (getContext().getResources().getDimensionPixelSize(R.dimen.record_dimen_dialog_margin) * 2);
        b.setLayoutParams(layoutParams);
    }

    public final void unRegisterButtonClick() {
        this.mClickVideoAndWord = null;
        this.mClickVideo = null;
        this.mClickWord = null;
        this.mClickCancel = null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastRecordShareDialog(@NotNull Context context, int i) {
        super(context, i);
        View decorView;
        Intrinsics.checkNotNullParameter(context, "context");
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = context.getResources().getDimensionPixelSize(R.dimen.fast_record_delete_dialog_bottom_margin);
            window.setAttributes(attributes);
        }
        FastRecordShareDialogBinding c = FastRecordShareDialogBinding.c(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.mBinding = c;
        setView(c.getRoot());
        Window window2 = getWindow();
        if (!(window2 == null || (decorView = window2.getDecorView()) == null)) {
            decorView.setBackgroundColor(0);
        }
        initView();
    }
}
