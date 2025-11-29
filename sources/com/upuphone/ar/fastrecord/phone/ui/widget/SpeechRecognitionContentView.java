package com.upuphone.ar.fastrecord.phone.ui.widget;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.honey.account.a4.j;
import com.honey.account.a4.k;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.ar.fastrecord.databinding.FastRecordLayoutAsrContentBinding;
import com.upuphone.ar.fastrecord.phone.ui.viewmodel.bean.LocalRecognitionResultBean;
import com.upuphone.ar.fastrecord.phone.utils.RecordExtKt;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 02\u00020\u0001:\u00010B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010&\u001a\u00020\u000eJ\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020(J \u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020#H\u0002J\u0010\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020\u0015H\u0002R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u0016@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u001c@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/widget/SpeechRecognitionContentView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/upuphone/ar/fastrecord/databinding/FastRecordLayoutAsrContentBinding;", "getBinding", "()Lcom/upuphone/ar/fastrecord/databinding/FastRecordLayoutAsrContentBinding;", "binding$delegate", "Lkotlin/Lazy;", "value", "", "content", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "currentPieceBean", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/LocalRecognitionResultBean$PieceBean;", "", "currentPosition", "getCurrentPosition", "()J", "setCurrentPosition", "(J)V", "Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/LocalRecognitionResultBean;", "data", "getData", "()Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/LocalRecognitionResultBean;", "setData", "(Lcom/upuphone/ar/fastrecord/phone/ui/viewmodel/bean/LocalRecognitionResultBean;)V", "lastParagraph", "", "lastTouchTime", "scrollY", "getText", "reset", "", "resetResource", "scrollText", "startIndex", "paragraph", "paragraphCount", "syncPlayerContentTextColor", "pieceBean", "Companion", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SpeechRecognitionContentView extends FrameLayout {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int TOUCH_RESPOND_TIME = 3000;
    @NotNull
    private final Lazy binding$delegate;
    @NotNull
    private String content;
    @NotNull
    private LocalRecognitionResultBean.PieceBean currentPieceBean;
    private long currentPosition;
    @NotNull
    private LocalRecognitionResultBean data;
    private int lastParagraph;
    private long lastTouchTime;
    private int scrollY;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/ui/widget/SpeechRecognitionContentView$Companion;", "", "()V", "TOUCH_RESPOND_TIME", "", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SpeechRecognitionContentView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(SpeechRecognitionContentView speechRecognitionContentView, View view, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(speechRecognitionContentView, "this$0");
        speechRecognitionContentView.scrollY = i2;
    }

    /* access modifiers changed from: private */
    public static final boolean _init_$lambda$1(SpeechRecognitionContentView speechRecognitionContentView, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(speechRecognitionContentView, "this$0");
        speechRecognitionContentView.lastTouchTime = System.currentTimeMillis();
        speechRecognitionContentView.currentPieceBean = new LocalRecognitionResultBean.PieceBean(0, 0, (String) null, 0, false, 31, (DefaultConstructorMarker) null);
        return false;
    }

    private final FastRecordLayoutAsrContentBinding getBinding() {
        return (FastRecordLayoutAsrContentBinding) this.binding$delegate.getValue();
    }

    private final void scrollText(int i, int i2, int i3) {
        double height = ((double) getBinding().c.getHeight()) / ((double) (getBinding().c.getLineCount() < 1 ? 1 : getBinding().c.getLineCount()));
        Layout layout = getBinding().c.getLayout();
        if (layout != null) {
            int lineCount = layout.getLineCount();
            int i4 = 0;
            int i5 = 0;
            while (i4 < lineCount) {
                int lineEnd = layout.getLineEnd(i4);
                if (i5 + 1 > i || i >= lineEnd) {
                    i4++;
                    i5 = lineEnd;
                } else {
                    int i6 = (int) ((((double) i4) * height) - ((double) this.scrollY));
                    if (i6 >= 0) {
                        getBinding().b.smoothScrollBy(0, i6 - ((int) (((double) (getHeight() / 2)) + (((double) ((i2 - this.lastParagraph) - 1)) * height))));
                    } else {
                        getBinding().b.smoothScrollBy(0, (i6 - (getHeight() / 2)) - (((i3 - i2) + 1) * ((int) height)));
                    }
                    this.lastParagraph = i2;
                    return;
                }
            }
        }
    }

    private final void setContent(String str) {
        this.content = str;
        getBinding().c.setText(this.data.toContent());
    }

    private final void syncPlayerContentTextColor(LocalRecognitionResultBean.PieceBean pieceBean) {
        SpannableString spannableString = new SpannableString(this.content);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.speech_recognition_play_text)), pieceBean.getStartIndex(), pieceBean.getStartIndex() + pieceBean.getContent().length(), 17);
        getBinding().c.setText(spannableString);
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final long getCurrentPosition() {
        return this.currentPosition;
    }

    @NotNull
    public final LocalRecognitionResultBean getData() {
        return this.data;
    }

    @NotNull
    public final String getText() {
        return getBinding().c.getText().toString();
    }

    public final void reset() {
        setCurrentPosition(0);
        getBinding().c.setText(this.content);
    }

    public final void resetResource() {
        AppCompatTextView appCompatTextView = getBinding().c;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "tv");
        RecordExtKt.setTextColorRes(appCompatTextView, R.color.color_text_default);
    }

    public final void setCurrentPosition(long j) {
        this.currentPosition = j;
        int indexWithPlayPosition = this.data.getIndexWithPlayPosition(j);
        LocalRecognitionResultBean.PieceBean pieceBean = (LocalRecognitionResultBean.PieceBean) CollectionsKt.getOrNull(this.data.getPieceList(), indexWithPlayPosition);
        if (pieceBean != null && System.currentTimeMillis() - this.lastTouchTime >= 3000 && !getBinding().c.hasSelection() && !Intrinsics.areEqual((Object) this.currentPieceBean.getContent(), (Object) pieceBean.getContent())) {
            scrollText(pieceBean.getStartIndex(), this.data.getParagraph(indexWithPlayPosition), this.data.getParagraphCount());
            syncPlayerContentTextColor(pieceBean);
            this.currentPieceBean = pieceBean;
        }
    }

    public final void setData(@NotNull LocalRecognitionResultBean localRecognitionResultBean) {
        Intrinsics.checkNotNullParameter(localRecognitionResultBean, AccountConstantKt.RESPONSE_VALUE);
        this.data = localRecognitionResultBean;
        setContent(localRecognitionResultBean.toContent());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpeechRecognitionContentView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.binding$delegate = LazyKt.lazy(new SpeechRecognitionContentView$binding$2(context, this));
        this.currentPieceBean = new LocalRecognitionResultBean.PieceBean(0, 0, (String) null, 0, false, 31, (DefaultConstructorMarker) null);
        this.content = "";
        this.data = new LocalRecognitionResultBean((LinkedList) null, false, 3, (DefaultConstructorMarker) null);
        getBinding().b.setOnScrollChangeListener(new j(this));
        getBinding().getRoot().setOnTouchListener(new k(this));
    }
}
