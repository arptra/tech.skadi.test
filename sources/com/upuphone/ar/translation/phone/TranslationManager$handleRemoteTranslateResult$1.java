package com.upuphone.ar.translation.phone;

import com.upuphone.ar.translation.phone.helper.InterConnectHelper;
import com.upuphone.ar.translation.statemachine.bean.AsrTtsResult;
import com.upuphone.ar.translation.utils.JsonUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranslationManager$handleRemoteTranslateResult$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Object $obj;
    final /* synthetic */ TranslationManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslationManager$handleRemoteTranslateResult$1(Object obj, TranslationManager translationManager) {
        super(0);
        this.$obj = obj;
        this.this$0 = translationManager;
    }

    public final void invoke() {
        Object obj = this.$obj;
        if (obj instanceof AsrTtsResult) {
            String asrJson = ((AsrTtsResult) obj).getAsrJson();
            InterConnectHelper.c.a().n(asrJson, ((AsrTtsResult) this.$obj).getTtsBytes());
            if (!JsonUtils.f6365a.c(asrJson)) {
                this.this$0.I(asrJson, "remote_trans");
            }
        }
    }
}
