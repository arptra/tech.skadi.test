package com.upuphone.ar.translation.phone.adapter;

import com.airbnb.lottie.LottieAnimationView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.meizu.common.widget.LoadingView;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.bean.DialogueRunning;
import com.upuphone.ar.translation.phone.view.ClipboardTextView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003!\"#B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\n\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001a¨\u0006$"}, d2 = {"Lcom/upuphone/ar/translation/phone/adapter/DialogueRunningAdapter;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/upuphone/ar/translation/phone/bean/DialogueRunning;", "", "data", "<init>", "(Ljava/util/List;)V", "", "", "position", "z0", "(Ljava/util/List;I)I", "", "isBroadcastTts", "", "G0", "(Z)V", "isRecordRtl", "isViewRtl", "H0", "(ZZ)V", "Lcom/upuphone/ar/translation/phone/view/ClipboardTextView;", "tv", "F0", "(Lcom/upuphone/ar/translation/phone/view/ClipboardTextView;)V", "D", "Z", "mIsBroadcastTts", "E", "mIsRecordRtl", "F", "mIsViewRtl", "G", "Companion", "ProximalItemProvider", "RemoteItemProvider", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class DialogueRunningAdapter extends BaseProviderMultiAdapter<DialogueRunning> {
    public static final Companion G = new Companion((DefaultConstructorMarker) null);
    public boolean D;
    public boolean E;
    public boolean F;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ar/translation/phone/adapter/DialogueRunningAdapter$Companion;", "", "()V", "ITEM_PROXIMAL", "", "ITEM_REMOTE", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @SourceDebugExtension({"SMAP\nDialogueRunningAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DialogueRunningAdapter.kt\ncom/upuphone/ar/translation/phone/adapter/DialogueRunningAdapter$ProximalItemProvider\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,217:1\n262#2,2:218\n262#2,2:220\n*S KotlinDebug\n*F\n+ 1 DialogueRunningAdapter.kt\ncom/upuphone/ar/translation/phone/adapter/DialogueRunningAdapter$ProximalItemProvider\n*L\n96#1:218,2\n99#1:220,2\n*E\n"})
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/upuphone/ar/translation/phone/adapter/DialogueRunningAdapter$ProximalItemProvider;", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "Lcom/upuphone/ar/translation/phone/bean/DialogueRunning;", "<init>", "(Lcom/upuphone/ar/translation/phone/adapter/DialogueRunningAdapter;)V", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "", "t", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/upuphone/ar/translation/phone/bean/DialogueRunning;)V", "", "g", "()I", "itemViewType", "h", "layoutId", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class ProximalItemProvider extends BaseItemProvider<DialogueRunning> {
        public ProximalItemProvider() {
        }

        public int g() {
            return 0;
        }

        public int h() {
            return R.layout.tl_item_dialogue_trans_running_proximal;
        }

        /* renamed from: t */
        public void a(BaseViewHolder baseViewHolder, DialogueRunning dialogueRunning) {
            String str;
            Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
            Intrinsics.checkNotNullParameter(dialogueRunning, "item");
            int Q = DialogueRunningAdapter.this.Q(dialogueRunning);
            boolean z = true;
            boolean z2 = dialogueRunning.getPlayStatus() == 2;
            boolean z3 = dialogueRunning.getPlayStatus() == 1;
            boolean z4 = !DialogueRunningAdapter.this.D || z2 || z3;
            baseViewHolder.setGone(R.id.iv_me_play, z4);
            if (!z4) {
                baseViewHolder.setImageResource(R.id.iv_me_play, dialogueRunning.isDone() ? R.drawable.icon_me_trans_play : R.drawable.icon_me_trans_mute);
            }
            int i = 8;
            ((LoadingView) baseViewHolder.getView(R.id.loading_view)).setVisibility(z2 ? 0 : 8);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) baseViewHolder.getView(R.id.lottie_tts);
            if (z3) {
                i = 0;
            }
            lottieAnimationView.setVisibility(i);
            lottieAnimationView.setScaleX(DialogueRunningAdapter.this.F ? -1.0f : 1.0f);
            if (z3) {
                lottieAnimationView.setRepeatCount(-1);
                lottieAnimationView.playAnimation();
            } else if (lottieAnimationView.isAnimating()) {
                lottieAnimationView.cancelAnimation();
            }
            String obj = StringsKt.trim((CharSequence) dialogueRunning.getText() + dialogueRunning.getTempText()).toString();
            baseViewHolder.setGone(R.id.ll_me_dst, StringsKt.isBlank(obj));
            ClipboardTextView clipboardTextView = (ClipboardTextView) baseViewHolder.getView(R.id.tv_me_dst);
            DialogueRunningAdapter.this.F0(clipboardTextView);
            if (dialogueRunning.isDone()) {
                str = obj;
            } else {
                str = obj + "...";
            }
            clipboardTextView.setText(str);
            int i2 = R.id.v_me_divider;
            if (Q != 0 && !StringsKt.isBlank(obj)) {
                z = false;
            }
            baseViewHolder.setGone(i2, z);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/upuphone/ar/translation/phone/adapter/DialogueRunningAdapter$RemoteItemProvider;", "Lcom/chad/library/adapter/base/provider/BaseItemProvider;", "Lcom/upuphone/ar/translation/phone/bean/DialogueRunning;", "<init>", "(Lcom/upuphone/ar/translation/phone/adapter/DialogueRunningAdapter;)V", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "", "t", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/upuphone/ar/translation/phone/bean/DialogueRunning;)V", "", "g", "()I", "itemViewType", "h", "layoutId", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class RemoteItemProvider extends BaseItemProvider<DialogueRunning> {
        public RemoteItemProvider() {
        }

        public int g() {
            return 1;
        }

        public int h() {
            return R.layout.tl_item_dialogue_trans_running_remote;
        }

        /* renamed from: t */
        public void a(BaseViewHolder baseViewHolder, DialogueRunning dialogueRunning) {
            String str;
            Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
            Intrinsics.checkNotNullParameter(dialogueRunning, "item");
            int Q = DialogueRunningAdapter.this.Q(dialogueRunning);
            String obj = StringsKt.trim((CharSequence) dialogueRunning.getText() + dialogueRunning.getTempText()).toString();
            baseViewHolder.setGone(R.id.tv_other_dst, StringsKt.isBlank(obj));
            ClipboardTextView clipboardTextView = (ClipboardTextView) baseViewHolder.getView(R.id.tv_other_dst);
            DialogueRunningAdapter.this.F0(clipboardTextView);
            if (dialogueRunning.isDone()) {
                str = obj;
            } else {
                str = obj + "...";
            }
            clipboardTextView.setText(str);
            baseViewHolder.setGone(R.id.v_other_divider, Q == 0 || StringsKt.isBlank(obj));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogueRunningAdapter(List list) {
        super(list);
        Intrinsics.checkNotNullParameter(list, "data");
        v0(new ProximalItemProvider());
        v0(new RemoteItemProvider());
        o(R.id.iv_me_play);
        o(R.id.lottie_tts);
    }

    public final void F0(ClipboardTextView clipboardTextView) {
        int i = 6;
        int i2 = 8388613;
        if (this.E) {
            if (this.F) {
                i2 = 8388611;
            }
            clipboardTextView.setGravity(i2);
            if (this.F) {
                i = 5;
            }
            clipboardTextView.setTextAlignment(i);
            return;
        }
        if (!this.F) {
            i2 = 8388611;
        }
        clipboardTextView.setGravity(i2);
        if (!this.F) {
            i = 5;
        }
        clipboardTextView.setTextAlignment(i);
    }

    public final void G0(boolean z) {
        this.D = z;
    }

    public final void H0(boolean z, boolean z2) {
        this.E = z;
        this.F = z2;
        if (!getData().isEmpty()) {
            notifyDataSetChanged();
        }
    }

    public int z0(List list, int i) {
        Intrinsics.checkNotNullParameter(list, "data");
        int speaker = ((DialogueRunning) list.get(i)).getSpeaker();
        return (speaker == 1 || speaker != 2) ? 0 : 1;
    }
}
