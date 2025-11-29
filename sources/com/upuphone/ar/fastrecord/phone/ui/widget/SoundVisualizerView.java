package com.upuphone.ar.fastrecord.phone.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.View;
import com.honey.account.a4.f;
import com.honey.account.a4.g;
import com.honey.account.a4.h;
import com.honey.account.a4.i;
import com.upuphone.ar.fastrecord.phone.bean.AmplitudeBean;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.ext.RecordViewKt;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0016\u0018\u0000 K2\u00020\u0001:\u0002KLB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010.\u001a\u0012\u0012\u0004\u0012\u0002000/j\b\u0012\u0004\u0012\u000200`1H\u0002J\b\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u000203H\u0002J(\u00105\u001a\u0002032\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020#2\u0006\u0010:\u001a\u00020#H\u0002J \u0010;\u001a\u0002032\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020#H\u0002J\u000e\u0010<\u001a\b\u0012\u0004\u0012\u0002000=H\u0016J\n\u0010>\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u000203H\u0002J\b\u0010B\u001a\u000203H\u0014J\u0010\u0010C\u001a\u0002032\u0006\u00106\u001a\u000207H\u0014J(\u0010D\u001a\u0002032\u0006\u0010E\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\u00102\u0006\u0010G\u001a\u00020\u00102\u0006\u0010H\u001a\u00020\u0010H\u0014J\u0006\u0010I\u001a\u000203J\u0006\u0010J\u001a\u000203R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u0018\u0010\u0015R\u001b\u0010\u001a\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0002¢\u0006\f\n\u0004\b&\u0010\f\u001a\u0004\b$\u0010%R\u000e\u0010'\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b+\u0010\f\u001a\u0004\b)\u0010*R\u000e\u0010,\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/widget/SoundVisualizerView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "amplitudePaint", "Landroid/graphics/Paint;", "getAmplitudePaint", "()Landroid/graphics/Paint;", "amplitudePaint$delegate", "Lkotlin/Lazy;", "delayStartAction", "Ljava/lang/Runnable;", "drawingHeight", "", "drawingWidth", "indexPauseView", "Landroid/graphics/Bitmap;", "getIndexPauseView", "()Landroid/graphics/Bitmap;", "indexPauseView$delegate", "indexPlayView", "getIndexPlayView", "indexPlayView$delegate", "lineWidth", "getLineWidth", "()I", "lineWidth$delegate", "mRecordCptHandle", "Landroid/os/Handler;", "mRecordCptHandleThread", "Landroid/os/HandlerThread;", "maxDecibel", "", "getMaxDecibel", "()F", "maxDecibel$delegate", "maxLineHeight", "uiHandler", "getUiHandler", "()Landroid/os/Handler;", "uiHandler$delegate", "visibleMaxLineCount", "visualizeRepeatAction", "commandAmplitudeBeanList", "Ljava/util/ArrayList;", "Lcom/upuphone/ar/fastrecord/phone/bean/AmplitudeBean;", "Lkotlin/collections/ArrayList;", "continueRepeat", "", "delayStart", "drawIndex", "canvas", "Landroid/graphics/Canvas;", "currentX", "centerY", "amplitude", "drawLastIndex", "getAmplitudeBeanList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getDrawHandler", "getLogTag", "", "initCptHandle", "onDetachedFromWindow", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "startVisualizing", "stopVisualizing", "Companion", "RecordingState", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSoundVisualizerView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SoundVisualizerView.kt\ncom/upuphone/ar/fastrecord/phone/ui/widget/SoundVisualizerView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,268:1\n1864#2,3:269\n*S KotlinDebug\n*F\n+ 1 SoundVisualizerView.kt\ncom/upuphone/ar/fastrecord/phone/ui/widget/SoundVisualizerView\n*L\n170#1:269,3\n*E\n"})
public class SoundVisualizerView extends View {
    private static final long ACTION_INTERVAL = 25;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int INDEX_RATIO = 9;
    private static final int MAX_AMPLITUDE = 32767;
    private static final float MAX_DRAW_REGION_MATRIX = 1.0f;
    @NotNull
    private final Lazy amplitudePaint$delegate;
    @NotNull
    private final Runnable delayStartAction;
    private int drawingHeight;
    private int drawingWidth;
    @NotNull
    private final Lazy indexPauseView$delegate;
    @NotNull
    private final Lazy indexPlayView$delegate;
    @NotNull
    private final Lazy lineWidth$delegate;
    @Nullable
    private Handler mRecordCptHandle;
    @Nullable
    private HandlerThread mRecordCptHandleThread;
    @NotNull
    private final Lazy maxDecibel$delegate;
    private int maxLineHeight;
    @NotNull
    private final Lazy uiHandler$delegate;
    private int visibleMaxLineCount;
    @NotNull
    private final Runnable visualizeRepeatAction;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/widget/SoundVisualizerView$Companion;", "", "()V", "ACTION_INTERVAL", "", "INDEX_RATIO", "", "MAX_AMPLITUDE", "MAX_DRAW_REGION_MATRIX", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/widget/SoundVisualizerView$RecordingState;", "", "()V", "isRecording", "", "()Z", "setRecording", "(Z)V", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RecordingState {
        @NotNull
        public static final RecordingState INSTANCE = new RecordingState();
        private static boolean isRecording;

        private RecordingState() {
        }

        public final boolean isRecording() {
            return isRecording;
        }

        public final void setRecording(boolean z) {
            isRecording = z;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SoundVisualizerView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    private final ArrayList<AmplitudeBean> commandAmplitudeBeanList() {
        ArrayList<AmplitudeBean> arrayList = new ArrayList<>();
        arrayList.addAll(getAmplitudeBeanList());
        int size = (arrayList.size() - this.visibleMaxLineCount) + 9;
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                arrayList.remove(0);
            }
        }
        return arrayList;
    }

    private final void continueRepeat() {
        if (RecordingState.INSTANCE.isRecording()) {
            getUiHandler().post(new f(this));
            Handler drawHandler = getDrawHandler();
            if (drawHandler != null) {
                drawHandler.postDelayed(this.visualizeRepeatAction, ACTION_INTERVAL);
                return;
            }
            return;
        }
        Handler drawHandler2 = getDrawHandler();
        if (drawHandler2 != null) {
            drawHandler2.removeCallbacks(this.visualizeRepeatAction);
        }
    }

    /* access modifiers changed from: private */
    public static final void continueRepeat$lambda$4(SoundVisualizerView soundVisualizerView) {
        Intrinsics.checkNotNullParameter(soundVisualizerView, "this$0");
        soundVisualizerView.invalidate();
    }

    private final void delayStart() {
        if (isShown()) {
            Handler drawHandler = getDrawHandler();
            if (drawHandler != null) {
                drawHandler.removeCallbacks(this.delayStartAction);
            }
            startVisualizing();
            return;
        }
        Handler drawHandler2 = getDrawHandler();
        if (drawHandler2 != null) {
            drawHandler2.removeCallbacks(this.delayStartAction);
        }
        Handler drawHandler3 = getDrawHandler();
        if (drawHandler3 != null) {
            drawHandler3.postDelayed(this.delayStartAction, ACTION_INTERVAL);
        }
    }

    /* access modifiers changed from: private */
    public static final void delayStartAction$lambda$3(SoundVisualizerView soundVisualizerView) {
        Intrinsics.checkNotNullParameter(soundVisualizerView, "this$0");
        soundVisualizerView.getUiHandler().post(new i(soundVisualizerView));
    }

    /* access modifiers changed from: private */
    public static final void delayStartAction$lambda$3$lambda$2(SoundVisualizerView soundVisualizerView) {
        Intrinsics.checkNotNullParameter(soundVisualizerView, "this$0");
        soundVisualizerView.delayStart();
    }

    private final void drawIndex(Canvas canvas, float f, float f2, float f3) {
        if (f3 <= 0.0f) {
            f3 = 1.0f;
        }
        float maxDecibel = (float) ((int) ((((float) this.maxLineHeight) * f3) / getMaxDecibel()));
        canvas.drawLine(f, f2 - maxDecibel, f, f2 + maxDecibel, getAmplitudePaint());
    }

    private final void drawLastIndex(Canvas canvas, float f, float f2) {
        Bitmap indexPlayView = getIndexPlayView();
        if (!RecordingState.INSTANCE.isRecording()) {
            indexPlayView = getIndexPauseView();
        }
        canvas.drawBitmap(indexPlayView, f - ((float) (indexPlayView.getWidth() / 2)), f2 - ((float) (indexPlayView.getHeight() / 2)), (Paint) null);
    }

    private final Paint getAmplitudePaint() {
        return (Paint) this.amplitudePaint$delegate.getValue();
    }

    private final Bitmap getIndexPauseView() {
        return (Bitmap) this.indexPauseView$delegate.getValue();
    }

    private final Bitmap getIndexPlayView() {
        return (Bitmap) this.indexPlayView$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final int getLineWidth() {
        return ((Number) this.lineWidth$delegate.getValue()).intValue();
    }

    private final float getMaxDecibel() {
        return ((Number) this.maxDecibel$delegate.getValue()).floatValue();
    }

    private final Handler getUiHandler() {
        return (Handler) this.uiHandler$delegate.getValue();
    }

    private final void initCptHandle() {
        if (this.mRecordCptHandleThread == null) {
            HandlerThread handlerThread = new HandlerThread("SoundVisualizerView-thread");
            handlerThread.start();
            this.mRecordCptHandle = new Handler(handlerThread.getLooper());
            this.mRecordCptHandleThread = handlerThread;
        }
    }

    /* access modifiers changed from: private */
    public static final void visualizeRepeatAction$lambda$1(SoundVisualizerView soundVisualizerView) {
        Intrinsics.checkNotNullParameter(soundVisualizerView, "this$0");
        soundVisualizerView.continueRepeat();
    }

    @NotNull
    public CopyOnWriteArrayList<AmplitudeBean> getAmplitudeBeanList() {
        return new CopyOnWriteArrayList<>();
    }

    @Nullable
    public Handler getDrawHandler() {
        if (this.mRecordCptHandle == null) {
            initCptHandle();
        }
        return this.mRecordCptHandle;
    }

    @NotNull
    public String getLogTag() {
        return "SoundVisualizerView";
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Handler drawHandler = getDrawHandler();
        if (drawHandler != null) {
            drawHandler.removeCallbacks(this.delayStartAction);
        }
    }

    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        try {
            float f = ((float) this.drawingHeight) / 2.0f;
            ArrayList<AmplitudeBean> commandAmplitudeBeanList = commandAmplitudeBeanList();
            int i = 0;
            for (T next : commandAmplitudeBeanList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                AmplitudeBean amplitudeBean = (AmplitudeBean) next;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                float lineWidth = !RecordViewKt.isRtl(context) ? (float) ((getLineWidth() * i) + 1) : ((float) this.drawingWidth) - ((float) ((getLineWidth() * i) + 1));
                if (i == CollectionsKt.getLastIndex(commandAmplitudeBeanList)) {
                    drawLastIndex(canvas, lineWidth, f);
                } else {
                    drawIndex(canvas, lineWidth, f, amplitudeBean.getAmplitude());
                }
                i = i2;
            }
        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage();
            LogExt.logE("onDraw error = " + message, getLogTag());
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.drawingWidth = i;
        this.drawingHeight = i2;
        int lineWidth = (int) (((float) (i / getLineWidth())) * 1.0f);
        this.visibleMaxLineCount = lineWidth;
        int i5 = this.drawingHeight / 3;
        this.maxLineHeight = i5;
        LogExt.logW("onSizeChanged W = " + i + ",h = " + i2 + " ,oldw = " + i3 + ",oldh = " + i4 + ",visibleMaxLineCount = " + lineWidth + ",maxLineHeight = " + i5, getLogTag());
    }

    public final void startVisualizing() {
        if (!isShown()) {
            LogExt.logD("startVisualizing delay: isShown false", getLogTag());
            delayStart();
            return;
        }
        RecordingState.INSTANCE.setRecording(true);
        try {
            Handler drawHandler = getDrawHandler();
            if (drawHandler != null) {
                drawHandler.removeCallbacks(this.visualizeRepeatAction);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Handler drawHandler2 = getDrawHandler();
        if (drawHandler2 != null) {
            drawHandler2.post(this.visualizeRepeatAction);
        }
    }

    public final void stopVisualizing() {
        RecordingState.INSTANCE.setRecording(false);
        Handler drawHandler = getDrawHandler();
        if (drawHandler != null) {
            drawHandler.removeCallbacks(this.visualizeRepeatAction);
        }
        Handler drawHandler2 = getDrawHandler();
        if (drawHandler2 != null) {
            drawHandler2.removeCallbacks(this.delayStartAction);
        }
        invalidate();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SoundVisualizerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.lineWidth$delegate = LazyKt.lazy(new SoundVisualizerView$lineWidth$2(this));
        this.indexPlayView$delegate = LazyKt.lazy(new SoundVisualizerView$indexPlayView$2(this));
        this.indexPauseView$delegate = LazyKt.lazy(new SoundVisualizerView$indexPauseView$2(this));
        this.uiHandler$delegate = LazyKt.lazy(SoundVisualizerView$uiHandler$2.INSTANCE);
        this.maxDecibel$delegate = LazyKt.lazy(SoundVisualizerView$maxDecibel$2.INSTANCE);
        this.amplitudePaint$delegate = LazyKt.lazy(new SoundVisualizerView$amplitudePaint$2(context, this));
        this.visualizeRepeatAction = new g(this);
        this.delayStartAction = new h(this);
    }
}
