package com.upuphone.ar.fastrecord.phone.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.phone.ext.LogExt;
import com.upuphone.ar.fastrecord.phone.utils.RecognitionSoundFile;
import com.upuphone.ar.fastrecord.phone.utils.RecordExtKt;
import com.upuphone.ar.fastrecord.phone.utils.ViewUtil;
import com.upuphone.starrynet.core.dns.ErrorCode;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010P\u001a\u00020\u00192\u0006\u0010Q\u001a\u00020F2\u0006\u0010R\u001a\u00020FH\u0002J\b\u0010S\u001a\u00020\u0019H\u0002J\u0010\u0010T\u001a\u00020\u00192\u0006\u0010U\u001a\u00020VH\u0016J\u0006\u0010W\u001a\u00020.J\n\u0010X\u001a\u0004\u0018\u00010+H\u0002J\b\u0010Y\u001a\u00020FH\u0002J\u0006\u0010Z\u001a\u00020FJ\u0018\u0010[\u001a\u00020\u00192\u0006\u0010Q\u001a\u00020\u00132\u0006\u0010\\\u001a\u00020\u0013H\u0002J\u0010\u0010]\u001a\u00020\u00192\u0006\u0010U\u001a\u00020VH\u0014J\u0010\u0010^\u001a\u00020.2\u0006\u0010_\u001a\u00020`H\u0017J\u0006\u0010a\u001a\u00020\u0019J\u000e\u0010b\u001a\u00020\u00192\u0006\u0010c\u001a\u00020.J\u000e\u0010d\u001a\u00020\u00192\u0006\u0010e\u001a\u00020.J\u0010\u0010f\u001a\u00020\u00192\b\u0010L\u001a\u0004\u0018\u00010MR\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR&\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R5\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00190\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR5\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00190\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR5\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00190\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR \u0010$\u001a\b\u0012\u0004\u0012\u00020\u00190%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u001e\u00102\u001a\u00020.2\u0006\u00101\u001a\u00020.@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u001b\u00104\u001a\u0002058BX\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b6\u00107R\u000e\u0010:\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010?\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00103\"\u0004\bA\u0010BR\u000e\u0010C\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020FX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020FX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020FX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020FX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020FX\u0004¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/widget/SpeechRecognitionPlayerView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "value", "", "currentPosition", "getCurrentPosition", "()J", "setCurrentPosition", "(J)V", "currentRawX", "", "doOnPlayBarChangeEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "position", "", "getDoOnPlayBarChangeEnd", "()Lkotlin/jvm/functions/Function1;", "setDoOnPlayBarChangeEnd", "(Lkotlin/jvm/functions/Function1;)V", "doOnPlayBarChanged", "getDoOnPlayBarChanged", "setDoOnPlayBarChanged", "doOnPlayClickPosition", "getDoOnPlayClickPosition", "setDoOnPlayClickPosition", "doOnTouchDown", "Lkotlin/Function0;", "getDoOnTouchDown", "()Lkotlin/jvm/functions/Function0;", "setDoOnTouchDown", "(Lkotlin/jvm/functions/Function0;)V", "indexView", "Landroid/graphics/Bitmap;", "indexViewForEdit", "isEditMode", "", "isHideState", "isRtl", "<set-?>", "isTouching", "()Z", "linePaint", "Landroid/graphics/Paint;", "getLinePaint", "()Landroid/graphics/Paint;", "linePaint$delegate", "Lkotlin/Lazy;", "mBgPaint", "mHeight", "", "mLineFocusRect", "Landroid/graphics/Rect;", "mPlayLineFocus", "getMPlayLineFocus", "setMPlayLineFocus", "(Z)V", "mTouchDownX", "mTouchDownY", "mViewHeight", "", "mViewHeightForEdit", "matrix", "", "maxSpectrumCount", "playLineX", "soundFile", "Lcom/upuphone/ar/fastrecord/phone/utils/RecognitionSoundFile;", "space", "unit", "choiceLine", "x", "y", "computeSpectrumHeightCalculation", "draw", "canvas", "Landroid/graphics/Canvas;", "getEditMode", "getIndexView", "getIndexViewHeight", "getMaxCount", "movePlayLine", "rawX", "onDraw", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "reset", "setEditMode", "mode", "setIndexHideState", "state", "setSoundFile", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSpeechRecognitionPlayerView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpeechRecognitionPlayerView.kt\ncom/upuphone/ar/fastrecord/phone/ui/widget/SpeechRecognitionPlayerView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,411:1\n1#2:412\n*E\n"})
public class SpeechRecognitionPlayerView extends View {
    @NotNull
    private final String TAG;
    private long currentPosition;
    private float currentRawX;
    @NotNull
    private Function1<? super Long, Unit> doOnPlayBarChangeEnd;
    @NotNull
    private Function1<? super Long, Unit> doOnPlayBarChanged;
    @NotNull
    private Function1<? super Long, Unit> doOnPlayClickPosition;
    @NotNull
    private Function0<Unit> doOnTouchDown;
    @Nullable
    private Bitmap indexView;
    @Nullable
    private Bitmap indexViewForEdit;
    private boolean isEditMode;
    private boolean isHideState;
    private final boolean isRtl;
    private boolean isTouching;
    @NotNull
    private final Lazy linePaint$delegate;
    @NotNull
    private Paint mBgPaint;
    @NotNull
    private double[] mHeight;
    @NotNull
    private Rect mLineFocusRect;
    private boolean mPlayLineFocus;
    private float mTouchDownX;
    private float mTouchDownY;
    private int mViewHeight;
    private int mViewHeightForEdit;
    private double matrix;
    private int maxSpectrumCount;
    private int playLineX;
    @Nullable
    private RecognitionSoundFile soundFile;
    /* access modifiers changed from: private */
    public int space;
    private final int unit;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SpeechRecognitionPlayerView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    private final void choiceLine(int i, int i2) {
        if (this.soundFile == null) {
            LogExt.logE("RecordEditSpectrumView00  choiceLine() mSoundFile == null", this.TAG);
        } else if (!this.mPlayLineFocus) {
            this.mLineFocusRect.setEmpty();
            Rect rect = this.mLineFocusRect;
            int i3 = this.playLineX;
            rect.set(i3 + ErrorCode.ERROR_START_DIS_EXCEPTION, 0, i3 + 200, getIndexViewHeight());
            this.mPlayLineFocus = this.mLineFocusRect.contains(i, i2);
        } else {
            this.mPlayLineFocus = false;
        }
    }

    private final void computeSpectrumHeightCalculation() {
        RecognitionSoundFile recognitionSoundFile = this.soundFile;
        if (recognitionSoundFile != null) {
            int numFrames = recognitionSoundFile.getNumFrames();
            int[] frameGains = recognitionSoundFile.getFrameGains();
            LogExt.logE("SpectrumView00 computeSpectrumHightCalculation  numFrames:" + numFrames + ", frameGains.size:" + frameGains.length, this.TAG);
            int i = this.maxSpectrumCount;
            float f = numFrames > i ? (float) (numFrames / i) : 1.0f;
            int width = getWidth() / this.unit;
            if (numFrames > width) {
                numFrames = width;
            }
            if (numFrames > 0 && frameGains.length != 0) {
                double[] dArr = new double[numFrames];
                if (numFrames == 1) {
                    dArr[0] = (double) frameGains[0];
                } else if (numFrames == 2) {
                    dArr[0] = (double) frameGains[0];
                    dArr[1] = (double) frameGains[1];
                } else if (numFrames > 2) {
                    LogExt.logE("computeSpectrumHightCalculation: frameMatix = " + f, this.TAG);
                    if (f == 1.0f) {
                        dArr[0] = (double) RecordExtKt.average((float) frameGains[0], (float) frameGains[1]);
                        int i2 = numFrames - 1;
                        int i3 = 1;
                        while (i3 < i2) {
                            int i4 = i3 + 1;
                            dArr[i3] = (double) RecordExtKt.average((float) frameGains[i3 - 1], (float) frameGains[i3], (float) frameGains[i4]);
                            i3 = i4;
                        }
                        dArr[i2] = (double) RecordExtKt.average((float) frameGains[numFrames - 2], (float) frameGains[i2]);
                    } else {
                        int i5 = (int) f;
                        for (int i6 = 0; i6 < i5; i6++) {
                            dArr[0] = dArr[0] + ((double) frameGains[i6]);
                        }
                        dArr[0] = dArr[0] / ((double) i5);
                        int i7 = this.maxSpectrumCount - 1;
                        int i8 = 0;
                        int i9 = 1;
                        while (i9 < i7) {
                            int i10 = i9 + 1;
                            int i11 = (int) (((float) i10) * f);
                            int i12 = i11 - i8;
                            int i13 = 0;
                            for (int i14 = 0; i14 < i12; i14++) {
                                i13 = i13 + frameGains[i11 + i14] + frameGains[(i11 - i12) + i14] + frameGains[(i11 + i12) - i14];
                            }
                            dArr[i9] = (double) (i13 / (i12 * 3));
                            i9 = i10;
                            i8 = i11;
                        }
                        int i15 = this.maxSpectrumCount - i8;
                        int i16 = 0;
                        if (1 <= i15) {
                            int i17 = 1;
                            while (true) {
                                int i18 = this.maxSpectrumCount;
                                i16 = i16 + frameGains[i18 - i17] + frameGains[(i18 - i15) - i17];
                                if (i17 == i15) {
                                    break;
                                }
                                i17++;
                            }
                        }
                        dArr[this.maxSpectrumCount - 1] = (double) (i16 / (i15 * 2));
                    }
                }
                double d = 0.0d;
                for (int i19 = 0; i19 < numFrames; i19++) {
                    double d2 = dArr[i19];
                    if (d2 > d) {
                        d = d2;
                    }
                }
                double indexViewHeight = (((double) getIndexViewHeight()) / d) / 2.0d;
                this.matrix = indexViewHeight;
                LogExt.logE("computeSpectrumHightCalculation: mMatrix  = " + indexViewHeight, this.TAG);
                this.mHeight = dArr;
            }
        }
    }

    private final Bitmap getIndexView() {
        if (this.isHideState) {
            return null;
        }
        return this.isEditMode ? this.indexViewForEdit : this.indexView;
    }

    private final int getIndexViewHeight() {
        return this.isEditMode ? this.mViewHeightForEdit : this.mViewHeight;
    }

    private final Paint getLinePaint() {
        return (Paint) this.linePaint$delegate.getValue();
    }

    private final void movePlayLine(float f, float f2) {
        if (this.mPlayLineFocus) {
            float f3 = f - this.mTouchDownX;
            if (f3 >= 0.0f) {
                this.playLineX += (int) f3;
                int width = (getWidth() - getPaddingRight()) - getPaddingLeft();
                if (this.playLineX > width) {
                    this.playLineX = width;
                }
            } else {
                int abs = this.playLineX - ((int) Math.abs(f3));
                this.playLineX = abs;
                if (abs < 1) {
                    this.playLineX = 1;
                }
            }
            this.mTouchDownX = f;
            this.doOnPlayBarChanged.invoke(Long.valueOf(getCurrentPosition()));
            this.currentRawX = f2;
            invalidate();
        }
    }

    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!this.isRtl) {
            super.draw(canvas);
            return;
        }
        canvas.save();
        canvas.scale(-1.0f, 1.0f, (float) (getWidth() / 2), (float) (getHeight() / 2));
        super.draw(canvas);
        canvas.restore();
    }

    public final long getCurrentPosition() {
        float width = ((float) this.playLineX) / ((float) ((getWidth() - getPaddingLeft()) - getPaddingRight()));
        RecognitionSoundFile recognitionSoundFile = this.soundFile;
        return (long) (width * ((float) RecordExtKt.default$default(recognitionSoundFile != null ? Long.valueOf(recognitionSoundFile.getDuration()) : null, 0, 1, (Object) null)));
    }

    @NotNull
    public final Function1<Long, Unit> getDoOnPlayBarChangeEnd() {
        return this.doOnPlayBarChangeEnd;
    }

    @NotNull
    public final Function1<Long, Unit> getDoOnPlayBarChanged() {
        return this.doOnPlayBarChanged;
    }

    @NotNull
    public final Function1<Long, Unit> getDoOnPlayClickPosition() {
        return this.doOnPlayClickPosition;
    }

    @NotNull
    public final Function0<Unit> getDoOnTouchDown() {
        return this.doOnTouchDown;
    }

    public final boolean getEditMode() {
        return this.isEditMode;
    }

    public final boolean getMPlayLineFocus() {
        return this.mPlayLineFocus;
    }

    public final int getMaxCount() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return ((RecordExtKt.getScreenWidth(context) - getPaddingLeft()) - getPaddingRight()) / this.unit;
    }

    @NotNull
    public final String getTAG() {
        return this.TAG;
    }

    public final boolean isTouching() {
        return this.isTouching;
    }

    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        this.mBgPaint.setColor(ContextCompat.getColor(getContext(), R.color.edit_bg_color));
        getLinePaint().setColor(ContextCompat.getColor(getContext(), R.color.edit_line_color));
        canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getIndexViewHeight(), this.mBgPaint);
        int indexViewHeight = getIndexViewHeight() / 2;
        int length = this.mHeight.length;
        for (int i = 0; i < length; i++) {
            int i2 = (int) (this.mHeight[i] * this.matrix);
            if (this.isEditMode) {
                i2 /= 2;
            }
            int i3 = indexViewHeight - i2;
            int i4 = indexViewHeight + 1 + i2;
            float f = (float) ((this.unit * i) + 1);
            canvas.drawLine(f + ((float) getPaddingLeft()), (float) i3, f + ((float) getPaddingLeft()) + ((float) 1), (float) i4, getLinePaint());
        }
        Bitmap indexView2 = getIndexView();
        if (indexView2 != null) {
            canvas.drawBitmap(indexView2, (float) ((this.playLineX - (indexView2.getWidth() / 2)) + getPaddingLeft()), 0.0f, (Paint) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0037, code lost:
        if (r2 != 3) goto L_0x00a9;
     */
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(@org.jetbrains.annotations.NotNull android.view.MotionEvent r8) {
        /*
            r7 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.upuphone.ar.fastrecord.phone.utils.RecognitionSoundFile r0 = r7.soundFile
            r1 = 0
            if (r0 != 0) goto L_0x000b
            return r1
        L_0x000b:
            int r0 = r7.getPaddingLeft()
            int r2 = r8.getAction()
            float r3 = r8.getX()
            float r4 = (float) r0
            float r3 = r3 - r4
            float r4 = r8.getY()
            r5 = 0
            int r6 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r6 >= 0) goto L_0x0023
            r3 = r5
        L_0x0023:
            boolean r5 = r7.isRtl
            if (r5 == 0) goto L_0x002e
            int r5 = r7.getWidth()
            float r5 = (float) r5
            float r3 = r5 - r3
        L_0x002e:
            r5 = 1
            if (r2 == 0) goto L_0x008d
            if (r2 == r5) goto L_0x0042
            r4 = 2
            if (r2 == r4) goto L_0x003a
            r3 = 3
            if (r2 == r3) goto L_0x0042
            goto L_0x00a9
        L_0x003a:
            float r8 = r8.getRawX()
            r7.movePlayLine(r3, r8)
            goto L_0x00a9
        L_0x0042:
            r7.isTouching = r1
            boolean r2 = r7.mPlayLineFocus
            if (r2 == 0) goto L_0x0056
            kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> r8 = r7.doOnPlayBarChangeEnd
            long r2 = r7.getCurrentPosition()
            java.lang.Long r0 = java.lang.Long.valueOf(r2)
            r8.invoke(r0)
            goto L_0x0087
        L_0x0056:
            float r8 = r8.getX()
            int r2 = r7.getWidth()
            int r2 = r2 - r0
            int r0 = r7.getPaddingRight()
            int r2 = r2 - r0
            float r0 = (float) r2
            float r8 = r8 / r0
            com.upuphone.ar.fastrecord.phone.utils.RecognitionSoundFile r0 = r7.soundFile
            r2 = 0
            if (r0 == 0) goto L_0x0074
            long r3 = r0.getDuration()
            java.lang.Long r0 = java.lang.Long.valueOf(r3)
            goto L_0x0075
        L_0x0074:
            r0 = r2
        L_0x0075:
            r3 = 0
            long r2 = com.upuphone.ar.fastrecord.phone.utils.RecordExtKt.default$default((java.lang.Long) r0, (long) r3, (int) r5, (java.lang.Object) r2)
            float r0 = (float) r2
            float r8 = r8 * r0
            long r2 = (long) r8
            kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> r8 = r7.doOnPlayClickPosition
            java.lang.Long r0 = java.lang.Long.valueOf(r2)
            r8.invoke(r0)
        L_0x0087:
            r7.mPlayLineFocus = r1
            r7.invalidate()
            goto L_0x00a9
        L_0x008d:
            r7.isTouching = r5
            int r0 = (int) r3
            float r0 = (float) r0
            r7.mTouchDownX = r0
            int r0 = (int) r4
            float r0 = (float) r0
            r7.mTouchDownY = r0
            float r0 = r8.getX()
            int r0 = (int) r0
            float r8 = r8.getY()
            int r8 = (int) r8
            r7.choiceLine(r0, r8)
            kotlin.jvm.functions.Function0<kotlin.Unit> r7 = r7.doOnTouchDown
            r7.invoke()
        L_0x00a9:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.ar.fastrecord.phone.ui.widget.SpeechRecognitionPlayerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void reset() {
        setCurrentPosition(0);
    }

    public final void setCurrentPosition(long j) {
        this.currentPosition = j;
        RecognitionSoundFile recognitionSoundFile = this.soundFile;
        long default$default = RecordExtKt.default$default(recognitionSoundFile != null ? Long.valueOf(recognitionSoundFile.getDuration()) : null, 0, 1, (Object) null);
        float f = (float) j;
        if (default$default <= 0) {
            default$default = 1;
        }
        this.playLineX = (int) ((f / ((float) default$default)) * ((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())));
        invalidate();
    }

    public final void setDoOnPlayBarChangeEnd(@NotNull Function1<? super Long, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.doOnPlayBarChangeEnd = function1;
    }

    public final void setDoOnPlayBarChanged(@NotNull Function1<? super Long, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.doOnPlayBarChanged = function1;
    }

    public final void setDoOnPlayClickPosition(@NotNull Function1<? super Long, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.doOnPlayClickPosition = function1;
    }

    public final void setDoOnTouchDown(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.doOnTouchDown = function0;
    }

    public final void setEditMode(boolean z) {
        this.isEditMode = z;
        requestLayout();
    }

    public final void setIndexHideState(boolean z) {
        this.isHideState = z;
    }

    public final void setMPlayLineFocus(boolean z) {
        this.mPlayLineFocus = z;
    }

    public final void setSoundFile(@Nullable RecognitionSoundFile recognitionSoundFile) {
        if (recognitionSoundFile != null) {
            this.soundFile = recognitionSoundFile;
            int measuredWidth = ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) / this.unit;
            this.maxSpectrumCount = measuredWidth;
            if (measuredWidth > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                computeSpectrumHeightCalculation();
                LogExt.logE("time:" + (System.currentTimeMillis() - currentTimeMillis), this.TAG);
                this.playLineX = 0;
                invalidate();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpeechRecognitionPlayerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "SpeechRecognitionPlayerView";
        this.linePaint$delegate = LazyKt.lazy(new SpeechRecognitionPlayerView$linePaint$2(this, context));
        this.mLineFocusRect = new Rect();
        boolean z = false;
        this.mHeight = new double[0];
        this.mBgPaint = new Paint();
        this.doOnPlayBarChanged = SpeechRecognitionPlayerView$doOnPlayBarChanged$1.INSTANCE;
        this.doOnPlayBarChangeEnd = SpeechRecognitionPlayerView$doOnPlayBarChangeEnd$1.INSTANCE;
        this.doOnPlayClickPosition = SpeechRecognitionPlayerView$doOnPlayClickPosition$1.INSTANCE;
        this.doOnTouchDown = SpeechRecognitionPlayerView$doOnTouchDown$1.INSTANCE;
        this.isHideState = true;
        this.isRtl = getResources().getConfiguration().getLayoutDirection() == 1 ? true : z;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.speech_recognition_player_line_space);
        this.space = dimensionPixelSize;
        this.unit = dimensionPixelSize * 2;
        Bitmap bitmap = null;
        VectorDrawableCompat b = VectorDrawableCompat.b(getResources(), R.drawable.ic_speech_recognition_player_index, (Resources.Theme) null);
        this.indexView = b != null ? RecordExtKt.toBitmap(b) : null;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.speech_recognition_player_height);
        this.mViewHeight = dimensionPixelOffset;
        this.mViewHeightForEdit = dimensionPixelOffset / 2;
        Bitmap bitmap2 = this.indexView;
        this.indexViewForEdit = bitmap2 != null ? ViewUtil.INSTANCE.shrinkBitmapHeight(bitmap2) : bitmap;
    }
}
