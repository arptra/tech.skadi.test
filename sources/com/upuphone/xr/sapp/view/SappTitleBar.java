package com.upuphone.xr.sapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import com.honey.account.x8.v;
import com.honey.account.x8.w;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.SappTitleBarLayoutBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002#$B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0014J\u0015\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001c\u001a\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001e\u001a\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001a¢\u0006\u0004\b\u001e\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/upuphone/xr/sapp/view/SappTitleBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/graphics/drawable/Drawable;", "drawable", "", "setBackIcon", "(Landroid/graphics/drawable/Drawable;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "backText", "setBackText", "model", "setTbModel", "(I)V", "Lkotlin/Function0;", "onClick", "i", "(Lkotlin/jvm/functions/Function0;)V", "k", "Lcom/upuphone/xr/sapp/databinding/SappTitleBarLayoutBinding;", "a", "Lcom/upuphone/xr/sapp/databinding/SappTitleBarLayoutBinding;", "mTitleBinding", "BackClickListener", "TbModel", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nSappTitleBar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SappTitleBar.kt\ncom/upuphone/xr/sapp/view/SappTitleBar\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,171:1\n256#2,2:172\n256#2,2:174\n256#2,2:176\n256#2,2:178\n256#2,2:180\n256#2,2:182\n*S KotlinDebug\n*F\n+ 1 SappTitleBar.kt\ncom/upuphone/xr/sapp/view/SappTitleBar\n*L\n76#1:172,2\n77#1:174,2\n81#1:176,2\n82#1:178,2\n86#1:180,2\n87#1:182,2\n*E\n"})
public final class SappTitleBar extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    public SappTitleBarLayoutBinding f7982a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/upuphone/xr/sapp/view/SappTitleBar$BackClickListener;", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface BackClickListener {
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/view/SappTitleBar$TbModel;", "", "<init>", "()V", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface TbModel {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/xr/sapp/view/SappTitleBar$TbModel$Companion;", "", "<init>", "()V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class Companion {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ Companion f7983a = new Companion();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SappTitleBar(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void j(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onClick");
        function0.invoke();
    }

    public static final void l(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onClick");
        function0.invoke();
    }

    public final void i(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "onClick");
        this.f7982a.c.setOnClickListener(new w(function0));
    }

    public final void k(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "onClick");
        this.f7982a.d.setOnClickListener(new v(function0));
    }

    public final void setBackIcon(@Nullable Drawable drawable) {
        this.f7982a.c.setImageDrawable(drawable);
    }

    public final void setBackText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "backText");
        this.f7982a.d.setText(str);
    }

    public final void setTbModel(int i) {
        if (i == 1) {
            Group group = this.f7982a.b;
            Intrinsics.checkNotNullExpressionValue(group, "gpBackIcon");
            group.setVisibility(0);
            TextView textView = this.f7982a.d;
            Intrinsics.checkNotNullExpressionValue(textView, "tvBack");
            textView.setVisibility(8);
        } else if (i != 2) {
            Group group2 = this.f7982a.b;
            Intrinsics.checkNotNullExpressionValue(group2, "gpBackIcon");
            group2.setVisibility(0);
            TextView textView2 = this.f7982a.d;
            Intrinsics.checkNotNullExpressionValue(textView2, "tvBack");
            textView2.setVisibility(8);
        } else {
            Group group3 = this.f7982a.b;
            Intrinsics.checkNotNullExpressionValue(group3, "gpBackIcon");
            group3.setVisibility(8);
            TextView textView3 = this.f7982a.d;
            Intrinsics.checkNotNullExpressionValue(textView3, "tvBack");
            textView3.setVisibility(0);
        }
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.f7982a.e.setText(str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SappTitleBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SappTitleBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        SappTitleBarLayoutBinding c = SappTitleBarLayoutBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.f7982a = c;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SappTitleBar);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.SappTitleBar_tb_icon_back);
        setBackIcon(drawable == null ? ContextCompat.getDrawable(context, R.drawable.icon_system_back) : drawable);
        String string = obtainStyledAttributes.getString(R.styleable.SappTitleBar_tb_title);
        String str = "";
        string = string == null ? str : string;
        Intrinsics.checkNotNull(string);
        setTitle(string);
        String string2 = obtainStyledAttributes.getString(R.styleable.SappTitleBar_tb_text_back);
        str = string2 != null ? string2 : str;
        Intrinsics.checkNotNull(str);
        setBackText(str);
        setTbModel(obtainStyledAttributes.getInt(R.styleable.SappTitleBar_tb_model, 1));
        obtainStyledAttributes.recycle();
    }
}
