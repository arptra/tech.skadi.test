package com.upuphone.ar.fastrecord.phone.ui.widget;

import android.content.Context;
import android.graphics.Paint;
import androidx.core.content.ContextCompat;
import com.upuphone.ar.fastrecord.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Paint;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SpeechRecognitionPlayerView$linePaint$2 extends Lambda implements Function0<Paint> {
    final /* synthetic */ Context $context;
    final /* synthetic */ SpeechRecognitionPlayerView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpeechRecognitionPlayerView$linePaint$2(SpeechRecognitionPlayerView speechRecognitionPlayerView, Context context) {
        super(0);
        this.this$0 = speechRecognitionPlayerView;
        this.$context = context;
    }

    @NotNull
    public final Paint invoke() {
        Paint paint = new Paint();
        SpeechRecognitionPlayerView speechRecognitionPlayerView = this.this$0;
        Context context = this.$context;
        paint.setFlags(1);
        paint.setStrokeWidth((float) speechRecognitionPlayerView.space);
        paint.setColor(ContextCompat.getColor(context, R.color.edit_line_color));
        paint.setAntiAlias(true);
        return paint;
    }
}
