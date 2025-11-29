package com.upuphone.ar.translation.phone;

import com.upuphone.ar.translation.ext.InterconnectMsgCodExtKt;
import com.upuphone.ar.translation.ext.LogExt;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.phone.helper.InterConnectHelper;
import com.upuphone.ar.translation.phone.helper.NoteSyncHelper;
import com.upuphone.ar.translation.phone.network.NetworkConnectManager;
import com.upuphone.ar.translation.statemachine.machine.TranslateStateManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranslationManager$handleUiStateChanged$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $expCode;
    final /* synthetic */ int $state;
    final /* synthetic */ TranslationManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslationManager$handleUiStateChanged$1(int i, int i2, TranslationManager translationManager) {
        super(0);
        this.$state = i;
        this.$expCode = i2;
        this.this$0 = translationManager;
    }

    public final void invoke() {
        Unit unit;
        String j = InterconnectMsgCodExtKt.j(this.$state);
        String i = InterconnectMsgCodExtKt.i(this.$expCode);
        LogExt.j("handleUiStateChanged state" + j + ", expCode" + i, "TranslationManager");
        this.this$0.C(this.$state, this.$expCode);
        this.this$0.D(this.$state, this.$expCode);
        TranslateStateManager p = this.this$0.p();
        if (p != null && p.f(this.$state)) {
            NoteBean j2 = NoteSyncHelper.j();
            if (j2 != null) {
                if (!StringsKt.isBlank(j2.getSrcContent())) {
                    InterConnectHelper.c.a().y();
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                LogExt.j("handleUiStateChanged noteBean is null", "TranslationManager");
            }
            NoteSyncHelper.t();
        }
        this.this$0.E(this.$state, this.$expCode);
        NetworkConnectManager b = this.this$0.e;
        if (b != null) {
            b.x(this.$state);
        }
    }
}
