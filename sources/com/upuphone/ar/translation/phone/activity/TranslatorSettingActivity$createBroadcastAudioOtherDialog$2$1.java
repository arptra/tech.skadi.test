package com.upuphone.ar.translation.phone.activity;

import com.upuphone.ar.translation.phone.adapter.BroadcastAudioTypeAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranslatorSettingActivity$createBroadcastAudioOtherDialog$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BroadcastAudioTypeAdapter $singleAdapter;
    final /* synthetic */ int $which;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranslatorSettingActivity$createBroadcastAudioOtherDialog$2$1(BroadcastAudioTypeAdapter broadcastAudioTypeAdapter, int i) {
        super(0);
        this.$singleAdapter = broadcastAudioTypeAdapter;
        this.$which = i;
    }

    public final void invoke() {
        this.$singleAdapter.a(this.$which, 0);
        this.$singleAdapter.notifyDataSetChanged();
    }
}
