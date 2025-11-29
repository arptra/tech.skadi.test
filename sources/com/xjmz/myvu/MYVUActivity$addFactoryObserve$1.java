package com.xjmz.myvu;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.ViewKt;
import com.upuphone.star.core.log.ULog;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.databinding.ActivityMyvuBinding;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nMYVUActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MYVUActivity.kt\ncom/xjmz/myvu/MYVUActivity$addFactoryObserve$1\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,1080:1\n256#2,2:1081\n256#2,2:1083\n*S KotlinDebug\n*F\n+ 1 MYVUActivity.kt\ncom/xjmz/myvu/MYVUActivity$addFactoryObserve$1\n*L\n708#1:1081,2\n710#1:1083,2\n*E\n"})
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class MYVUActivity$addFactoryObserve$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ MYVUActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MYVUActivity$addFactoryObserve$1(MYVUActivity mYVUActivity) {
        super(1);
        this.this$0 = mYVUActivity;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(MYVUActivity mYVUActivity) {
        Intrinsics.checkNotNullParameter(mYVUActivity, "this$0");
        ActivityMyvuBinding E0 = mYVUActivity.d;
        ActivityMyvuBinding activityMyvuBinding = null;
        if (E0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            E0 = null;
        }
        ConstraintLayout constraintLayout = E0.d;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "factoryResettingLayout");
        constraintLayout.setVisibility(8);
        ActivityMyvuBinding E02 = mYVUActivity.d;
        if (E02 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMyvuBinding = E02;
        }
        FragmentContainerView fragmentContainerView = activityMyvuBinding.b;
        Intrinsics.checkNotNullExpressionValue(fragmentContainerView, "androidNavi");
        ViewKt.a(fragmentContainerView).W(R.id.empty_fragment, false);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Boolean bool) {
        Intrinsics.checkNotNull(bool);
        if (bool.booleanValue()) {
            ULog.f6446a.a("MYVUActivity", "receive factoryResetConfirm from launcher");
            this.this$0.D1(true);
            DataStoreUtils.e.a().o("sp_device_connect_history", "null");
            ActivityMyvuBinding E0 = this.this$0.d;
            if (E0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                E0 = null;
            }
            ConstraintLayout constraintLayout = E0.d;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "factoryResettingLayout");
            constraintLayout.setVisibility(0);
            MYVUActivity.D.postDelayed(new a(this.this$0), 5000);
            this.this$0.f1().U0(false);
        }
    }
}
