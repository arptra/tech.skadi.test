package com.upuphone.ar.tici.phone;

import com.upuphone.ar.tici.phone.db.entity.TiciEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nTiciMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TiciMainActivity.kt\ncom/upuphone/ar/tici/phone/TiciMainActivity$initViewModels$6\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,760:1\n260#2,4:761\n260#2:765\n260#2:766\n262#2,2:767\n*S KotlinDebug\n*F\n+ 1 TiciMainActivity.kt\ncom/upuphone/ar/tici/phone/TiciMainActivity$initViewModels$6\n*L\n332#1:761,4\n334#1:765\n341#1:766\n340#1:767,2\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "ticiEntity", "Lcom/upuphone/ar/tici/phone/db/entity/TiciEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TiciMainActivity$initViewModels$6 extends Lambda implements Function1<TiciEntity, Unit> {
    final /* synthetic */ TiciMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciMainActivity$initViewModels$6(TiciMainActivity ticiMainActivity) {
        super(1);
        this.this$0 = ticiMainActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TiciEntity) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b9, code lost:
        if (com.upuphone.ar.tici.phone.utils.SpUtilKt.j() != 1) goto L_0x00bc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.Nullable com.upuphone.ar.tici.phone.db.entity.TiciEntity r7) {
        /*
            r6 = this;
            java.lang.String r0 = "ticiLoadingView"
            if (r7 != 0) goto L_0x0013
            com.upuphone.ar.tici.phone.TiciMainActivity r7 = r6.this$0
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r7 = r7.d1()
            androidx.constraintlayout.widget.ConstraintLayout r7 = r7.s
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            com.upuphone.ar.tici.phone.utils.CommonExtKt.f(r7)
            goto L_0x0030
        L_0x0013:
            com.upuphone.ar.tici.phone.TiciMainActivity r1 = r6.this$0
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r1 = r1.d1()
            android.widget.TextView r1 = r1.i
            java.lang.String r7 = r7.getFileName()
            r1.setText(r7)
            com.upuphone.ar.tici.phone.TiciMainActivity r7 = r6.this$0
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r7 = r7.d1()
            androidx.constraintlayout.widget.ConstraintLayout r7 = r7.s
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            com.upuphone.ar.tici.phone.utils.CommonExtKt.g(r7)
        L_0x0030:
            com.upuphone.ar.tici.phone.TiciMainActivity r7 = r6.this$0
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r7 = r7.d1()
            android.view.View r7 = r7.z
            java.lang.String r1 = "viewMask"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            com.upuphone.ar.tici.phone.TiciMainActivity r2 = r6.this$0
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r2 = r2.d1()
            androidx.constraintlayout.widget.ConstraintLayout r2 = r2.s
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            int r2 = r2.getVisibility()
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L_0x0053
            r2 = r3
            goto L_0x0054
        L_0x0053:
            r2 = r4
        L_0x0054:
            r5 = 8
            if (r2 == 0) goto L_0x005a
            r2 = r4
            goto L_0x005b
        L_0x005a:
            r2 = r5
        L_0x005b:
            r7.setVisibility(r2)
            com.upuphone.ar.tici.phone.TiciMainActivity r7 = r6.this$0
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r7 = r7.d1()
            androidx.constraintlayout.widget.ConstraintLayout r7 = r7.s
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            int r7 = r7.getVisibility()
            if (r7 != 0) goto L_0x0081
            com.upuphone.ar.tici.phone.TiciMainActivity r7 = r6.this$0
            android.view.Window r7 = r7.getWindow()
            com.upuphone.ar.tici.phone.TiciMainActivity r0 = r6.this$0
            int r2 = com.upuphone.ar.tici.R.color.tici_mask
            int r0 = r0.getColor(r2)
            r7.setNavigationBarColor(r0)
            goto L_0x008a
        L_0x0081:
            com.upuphone.ar.tici.phone.TiciMainActivity r7 = r6.this$0
            android.view.Window r7 = r7.getWindow()
            r7.setNavigationBarColor(r4)
        L_0x008a:
            com.upuphone.ar.tici.phone.TiciMainActivity r7 = r6.this$0
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r7 = r7.d1()
            com.airbnb.lottie.LottieAnimationView r7 = r7.j
            java.lang.String r0 = "lottieAutoTici"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            com.upuphone.ar.tici.phone.TiciMainActivity r0 = r6.this$0
            com.upuphone.ar.tici.phone.TiciAppViewModel r0 = r0.d
            boolean r0 = r0.o0()
            if (r0 == 0) goto L_0x00bc
            com.upuphone.ar.tici.phone.TiciMainActivity r6 = r6.this$0
            com.upuphone.ar.tici.databinding.TiciMainActivityLayoutBinding r6 = r6.d1()
            android.view.View r6 = r6.z
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
            int r6 = r6.getVisibility()
            if (r6 != 0) goto L_0x00b5
            goto L_0x00bc
        L_0x00b5:
            int r6 = com.upuphone.ar.tici.phone.utils.SpUtilKt.j()
            if (r6 != r3) goto L_0x00bc
            goto L_0x00bd
        L_0x00bc:
            r3 = r4
        L_0x00bd:
            if (r3 == 0) goto L_0x00c0
            goto L_0x00c1
        L_0x00c0:
            r4 = r5
        L_0x00c1:
            r7.setVisibility(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.tici.phone.TiciMainActivity$initViewModels$6.invoke(com.upuphone.ar.tici.phone.db.entity.TiciEntity):void");
    }
}
