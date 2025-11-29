package com.upuphone.ar.fastrecord.phone.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.upuphone.ar.fastrecord.phone.bean.AmplitudeBean;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/widget/RecordItemSoundVisualizerView;", "Lcom/upuphone/ar/fastrecord/phone/ui/widget/SoundVisualizerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "getAmplitudeBeanList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/upuphone/ar/fastrecord/phone/bean/AmplitudeBean;", "getLogTag", "", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RecordItemSoundVisualizerView extends SoundVisualizerView {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static CopyOnWriteArrayList<AmplitudeBean> amplitudeListForRecordItem = new CopyOnWriteArrayList<>();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/widget/RecordItemSoundVisualizerView$Companion;", "", "()V", "amplitudeListForRecordItem", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/upuphone/ar/fastrecord/phone/bean/AmplitudeBean;", "clearAmplitudeBeans", "", "getItemAmplitudeBeanToList", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void clearAmplitudeBeans() {
            LogExt.logE("clearAmplitudeBeans", "RecordItemSoundVisualizerView");
            RecordItemSoundVisualizerView.amplitudeListForRecordItem.clear();
        }

        @NotNull
        public final CopyOnWriteArrayList<AmplitudeBean> getItemAmplitudeBeanToList() {
            return RecordItemSoundVisualizerView.amplitudeListForRecordItem;
        }

        private Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecordItemSoundVisualizerView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    @NotNull
    public CopyOnWriteArrayList<AmplitudeBean> getAmplitudeBeanList() {
        return amplitudeListForRecordItem;
    }

    @NotNull
    public String getLogTag() {
        return "RecordItemSoundVisualizerView";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecordItemSoundVisualizerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
