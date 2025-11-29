package com.upuphone.xr.sapp.pag;

import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGFile;
import org.libpag.PAGImageView;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/pag/LibPag;", "", "<init>", "()V", "Lorg/libpag/PAGImageView;", "view", "Lcom/upuphone/xr/sapp/pag/PagParam;", "pagParam", "", "a", "(Lorg/libpag/PAGImageView;Lcom/upuphone/xr/sapp/pag/PagParam;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class LibPag {

    /* renamed from: a  reason: collision with root package name */
    public static final LibPag f7811a = new LibPag();

    public static final void a(PAGImageView pAGImageView, PagParam pagParam) {
        Intrinsics.checkNotNullParameter(pAGImageView, "view");
        Intrinsics.checkNotNullParameter(pagParam, "pagParam");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("LibPag", "loadPagAnim-> " + pagParam);
        PAGFile Load = PAGFile.Load(pAGImageView.getContext().getAssets(), pagParam.a());
        pAGImageView.setRepeatCount(pagParam.b());
        pAGImageView.setComposition(Load);
        pAGImageView.play();
    }
}
