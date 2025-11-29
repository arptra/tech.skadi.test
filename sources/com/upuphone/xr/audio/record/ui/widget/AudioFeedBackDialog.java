package com.upuphone.xr.audio.record.ui.widget;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.honey.account.q7.a;
import com.upuphone.xr.audio.record.ai.feedback.AiFeedBackManager;
import com.upuphone.xr.audio.record.common.FeedBackType;
import com.upuphone.xr.audio.record.ui.adpter.AudioRecordFeedBackViewAdapter;
import com.upuphone.xr.sapp.audio.record.R;
import com.upuphone.xr.sapp.audio.record.databinding.AudioRecordFeedBackDialogBinding;
import flyme.support.v7.app.LitePopupActivity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R$\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/upuphone/xr/audio/record/ui/widget/AudioFeedBackDialog;", "Lflyme/support/v7/app/LitePopupActivity;", "<init>", "()V", "", "initView", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "s0", "()Z", "n0", "Lcom/upuphone/xr/sapp/audio/record/databinding/AudioRecordFeedBackDialogBinding;", "a", "Lcom/upuphone/xr/sapp/audio/record/databinding/AudioRecordFeedBackDialogBinding;", "binding", "Lcom/upuphone/xr/audio/record/ui/adpter/AudioRecordFeedBackViewAdapter;", "b", "Lcom/upuphone/xr/audio/record/ui/adpter/AudioRecordFeedBackViewAdapter;", "viewAdapter", "Ljava/util/ArrayList;", "Lcom/upuphone/xr/audio/record/common/FeedBackType;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "audioFeedbackTypeList", "d", "Companion", "lib_audio_record_release"}, k = 1, mv = {1, 9, 0})
public class AudioFeedBackDialog extends LitePopupActivity {
    public static final Companion d = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public AudioRecordFeedBackDialogBinding f6565a;
    public AudioRecordFeedBackViewAdapter b;
    public final ArrayList c = new ArrayList();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/audio/record/ui/widget/AudioFeedBackDialog$Companion;", "", "()V", "TAG", "", "lib_audio_record_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    private final void initView() {
        AudioRecordFeedBackViewAdapter audioRecordFeedBackViewAdapter = new AudioRecordFeedBackViewAdapter();
        this.b = audioRecordFeedBackViewAdapter;
        audioRecordFeedBackViewAdapter.l(new AudioFeedBackDialog$initView$1(this));
        AudioRecordFeedBackDialogBinding audioRecordFeedBackDialogBinding = this.f6565a;
        AudioRecordFeedBackDialogBinding audioRecordFeedBackDialogBinding2 = null;
        if (audioRecordFeedBackDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            audioRecordFeedBackDialogBinding = null;
        }
        audioRecordFeedBackDialogBinding.c.setOnClickListener(new a(this));
        AudioRecordFeedBackDialogBinding audioRecordFeedBackDialogBinding3 = this.f6565a;
        if (audioRecordFeedBackDialogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            audioRecordFeedBackDialogBinding3 = null;
        }
        RecyclerView recyclerView = audioRecordFeedBackDialogBinding3.b;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recRecord");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        AudioRecordFeedBackViewAdapter audioRecordFeedBackViewAdapter2 = this.b;
        if (audioRecordFeedBackViewAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            audioRecordFeedBackViewAdapter2 = null;
        }
        recyclerView.setAdapter(audioRecordFeedBackViewAdapter2);
        AudioRecordFeedBackViewAdapter audioRecordFeedBackViewAdapter3 = this.b;
        if (audioRecordFeedBackViewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            audioRecordFeedBackViewAdapter3 = null;
        }
        audioRecordFeedBackViewAdapter3.notifyData(this.c);
        AudioRecordFeedBackDialogBinding audioRecordFeedBackDialogBinding4 = this.f6565a;
        if (audioRecordFeedBackDialogBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            audioRecordFeedBackDialogBinding4 = null;
        }
        audioRecordFeedBackDialogBinding4.c.setAlpha(0.3f);
        AudioRecordFeedBackDialogBinding audioRecordFeedBackDialogBinding5 = this.f6565a;
        if (audioRecordFeedBackDialogBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            audioRecordFeedBackDialogBinding5 = null;
        }
        audioRecordFeedBackDialogBinding5.c.setClickable(false);
        if (s0()) {
            getLitePopup().setUncollapsibleHeight(getResources().getDimensionPixelSize(R.dimen.feed_back_dialog_height_for_has_navigation));
            AudioRecordFeedBackDialogBinding audioRecordFeedBackDialogBinding6 = this.f6565a;
            if (audioRecordFeedBackDialogBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                audioRecordFeedBackDialogBinding2 = audioRecordFeedBackDialogBinding6;
            }
            audioRecordFeedBackDialogBinding2.b.setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.feed_back_padding_bottom_for_has_navigation));
            return;
        }
        getLitePopup().setUncollapsibleHeight(getResources().getDimensionPixelSize(R.dimen.feed_back_dialog_height));
        AudioRecordFeedBackDialogBinding audioRecordFeedBackDialogBinding7 = this.f6565a;
        if (audioRecordFeedBackDialogBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            audioRecordFeedBackDialogBinding2 = audioRecordFeedBackDialogBinding7;
        }
        audioRecordFeedBackDialogBinding2.b.setPadding(0, 0, 0, getResources().getDimensionPixelSize(R.dimen.feed_back_padding_bottom_for_no_has_navigation));
    }

    public static final void o0(AudioFeedBackDialog audioFeedBackDialog, View view) {
        Intrinsics.checkNotNullParameter(audioFeedBackDialog, "this$0");
        AudioRecordFeedBackViewAdapter audioRecordFeedBackViewAdapter = audioFeedBackDialog.b;
        if (audioRecordFeedBackViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAdapter");
            audioRecordFeedBackViewAdapter = null;
        }
        ArrayList h = audioRecordFeedBackViewAdapter.h();
        if (!h.isEmpty()) {
            AiFeedBackManager.f6560a.g(h);
            audioFeedBackDialog.finish();
        }
    }

    public final void n0() {
        ArrayList arrayList = this.c;
        String string = getResources().getString(R.string.fast_record_feedback_illegal_harmful);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        arrayList.add(new FeedBackType(3, string, false));
        ArrayList arrayList2 = this.c;
        String string2 = getResources().getString(R.string.fast_record_feedback_pornography);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        arrayList2.add(new FeedBackType(4, string2, false));
        ArrayList arrayList3 = this.c;
        String string3 = getResources().getString(R.string.fast_record_feedback_low_quality);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        arrayList3.add(new FeedBackType(5, string3, false));
        ArrayList arrayList4 = this.c;
        String string4 = getResources().getString(R.string.fast_record_feedback_abuse);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        arrayList4.add(new FeedBackType(6, string4, false));
        ArrayList arrayList5 = this.c;
        String string5 = getResources().getString(R.string.fast_record_feedback_dislike);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        arrayList5.add(new FeedBackType(7, string5, false));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AudioRecordFeedBackDialogBinding c2 = AudioRecordFeedBackDialogBinding.c(LayoutInflater.from(this));
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f6565a = c2;
        getLitePopup().hideTitleBar();
        getLitePopup().setCanceledOnTouchOutside(true);
        getLitePopup().setScrollPopupFirstOnTop(false);
        getLitePopup().setStyle(1);
        AudioRecordFeedBackDialogBinding audioRecordFeedBackDialogBinding = this.f6565a;
        if (audioRecordFeedBackDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            audioRecordFeedBackDialogBinding = null;
        }
        setContentView((View) audioRecordFeedBackDialogBinding.getRoot());
        n0();
        initView();
    }

    public final boolean s0() {
        Object systemService = getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        int[] iArr = new int[2];
        getWindow().getDecorView().getRootView().getLocationOnScreen(iArr);
        int i = point.y;
        return i - iArr[1] >= i / 4;
    }
}
