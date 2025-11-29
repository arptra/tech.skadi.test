package com.upuphone.ar.fastrecord.phone.ui.widget;

import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGFile;
import org.libpag.PAGImageView;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/widget/AiLoadingPag;", "", "()V", "TAG", "", "loadPagAnim", "", "view", "Lorg/libpag/PAGImageView;", "pagParam", "Lcom/upuphone/ar/fastrecord/phone/ui/widget/AiPagParam;", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AiLoadingPag {
    @NotNull
    public static final AiLoadingPag INSTANCE = new AiLoadingPag();
    @NotNull
    private static final String TAG = "AiLoadingPag";

    private AiLoadingPag() {
    }

    @JvmStatic
    public static final void loadPagAnim(@NotNull PAGImageView pAGImageView, @NotNull AiPagParam aiPagParam) {
        Intrinsics.checkNotNullParameter(pAGImageView, "view");
        Intrinsics.checkNotNullParameter(aiPagParam, "pagParam");
        LogExt.logI("loadPagAnim-> " + aiPagParam, TAG);
        PAGFile Load = PAGFile.Load(pAGImageView.getContext().getAssets(), aiPagParam.getPath());
        pAGImageView.setRepeatCount(aiPagParam.getRepeatTime());
        pAGImageView.setComposition(Load);
        pAGImageView.play();
    }
}
