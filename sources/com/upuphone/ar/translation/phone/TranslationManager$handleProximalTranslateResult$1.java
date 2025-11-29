package com.upuphone.ar.translation.phone;

import com.upuphone.ar.translation.phone.helper.InterConnectHelper;
import com.upuphone.ar.translation.statemachine.bean.AsrTtsResult;
import com.upuphone.ar.translation.utils.GsonUtils;
import com.upuphone.ar.translation.utils.JsonUtils;
import com.xjsd.xr.sapp.asr.dao.AsrResult;
import com.xjsd.xr.sapp.asr.dao.Dst;
import com.xjsd.xr.sapp.asr.dao.ResultExt;
import com.xjsd.xr.sapp.asr.dao.Src;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranslationManager$handleProximalTranslateResult$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Object $obj;
    final /* synthetic */ TranslationManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslationManager$handleProximalTranslateResult$1(Object obj, TranslationManager translationManager) {
        super(0);
        this.$obj = obj;
        this.this$0 = translationManager;
    }

    public final void invoke() {
        String str;
        Object obj = this.$obj;
        if (obj instanceof AsrTtsResult) {
            String asrJson = ((AsrTtsResult) obj).getAsrJson();
            if (this.this$0.l) {
                AsrResult asrResult = (AsrResult) GsonUtils.a(asrJson, AsrResult.class);
                Src src = asrResult.getSrc();
                Dst dst = asrResult.getDst();
                if (src != null) {
                    str = JsonUtils.d(new AsrResult(new Src(src.getType(), "", 0, 0, 0, 0, 0, 124, (DefaultConstructorMarker) null), (Dst) null, (ResultExt) null, 6, (DefaultConstructorMarker) null));
                } else {
                    str = dst != null ? JsonUtils.d(new AsrResult((Src) null, new Dst(dst.getType(), "", "", 0, 0, 0, 0, 0, 248, (DefaultConstructorMarker) null), (ResultExt) null, 5, (DefaultConstructorMarker) null)) : asrJson;
                }
                InterConnectHelper.c.a().l(str, ((AsrTtsResult) this.$obj).getTtsBytes());
            } else {
                InterConnectHelper.c.a().l(asrJson, ((AsrTtsResult) this.$obj).getTtsBytes());
            }
            if (!JsonUtils.f6365a.c(asrJson)) {
                this.this$0.I(asrJson, "proximal_trans");
            }
        }
    }
}
