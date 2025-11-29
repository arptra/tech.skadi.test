package com.upuphone.ar.fastrecord.phone.ui.widget;

import android.content.res.Resources;
import android.graphics.Bitmap;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.utils.RecordExtKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class SoundVisualizerView$indexPauseView$2 extends Lambda implements Function0<Bitmap> {
    final /* synthetic */ SoundVisualizerView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SoundVisualizerView$indexPauseView$2(SoundVisualizerView soundVisualizerView) {
        super(0);
        this.this$0 = soundVisualizerView;
    }

    @NotNull
    public final Bitmap invoke() {
        VectorDrawableCompat b = VectorDrawableCompat.b(this.this$0.getResources(), R.drawable.ic_speech_recognition_pause_index, (Resources.Theme) null);
        Intrinsics.checkNotNull(b);
        return RecordExtKt.toBitmap(b);
    }
}
