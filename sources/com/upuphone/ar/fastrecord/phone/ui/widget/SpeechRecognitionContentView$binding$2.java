package com.upuphone.ar.fastrecord.phone.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import com.upuphone.ar.fastrecord.databinding.FastRecordLayoutAsrContentBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/upuphone/ar/fastrecord/databinding/FastRecordLayoutAsrContentBinding;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SpeechRecognitionContentView$binding$2 extends Lambda implements Function0<FastRecordLayoutAsrContentBinding> {
    final /* synthetic */ Context $context;
    final /* synthetic */ SpeechRecognitionContentView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpeechRecognitionContentView$binding$2(Context context, SpeechRecognitionContentView speechRecognitionContentView) {
        super(0);
        this.$context = context;
        this.this$0 = speechRecognitionContentView;
    }

    @NotNull
    public final FastRecordLayoutAsrContentBinding invoke() {
        return FastRecordLayoutAsrContentBinding.c(LayoutInflater.from(this.$context), this.this$0, true);
    }
}
