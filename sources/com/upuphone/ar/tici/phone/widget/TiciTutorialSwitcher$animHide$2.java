package com.upuphone.ar.tici.phone.widget;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.upuphone.ar.tici.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TiciTutorialSwitcher$animHide$2 extends Lambda implements Function0<Animation> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TiciTutorialSwitcher$animHide$2(Context context) {
        super(0);
        this.$context = context;
    }

    public final Animation invoke() {
        return AnimationUtils.loadAnimation(this.$context, R.anim.tici_tutorial_content_out);
    }
}
