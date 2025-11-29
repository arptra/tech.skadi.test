package com.upuphone.ar.translation.phone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.databinding.ItemBroadcastAudioTtsBinding;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nBroadcastAudioTypeAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastAudioTypeAdapter.kt\ncom/upuphone/ar/translation/phone/adapter/BroadcastAudioTypeAdapter\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,90:1\n262#2,2:91\n262#2,2:93\n262#2,2:95\n262#2,2:97\n*S KotlinDebug\n*F\n+ 1 BroadcastAudioTypeAdapter.kt\ncom/upuphone/ar/translation/phone/adapter/BroadcastAudioTypeAdapter\n*L\n57#1:91,2\n63#1:93,2\n66#1:95,2\n69#1:97,2\n*E\n"})
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B'\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ)\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u000b2\b\b\u0003\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0018R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001c¨\u0006\""}, d2 = {"Lcom/upuphone/ar/translation/phone/adapter/BroadcastAudioTypeAdapter;", "Landroid/widget/ArrayAdapter;", "", "Landroid/content/Context;", "adapterContext", "", "dataArr", "", "isIntlVersion", "<init>", "(Landroid/content/Context;[Ljava/lang/String;Z)V", "", "position", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", "parent", "getView", "(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;", "selectedIndex", "audioPlayState", "", "a", "(II)V", "[Ljava/lang/String;", "b", "Z", "c", "I", "mSelectedIndex", "d", "mAudioPlayState", "e", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class BroadcastAudioTypeAdapter extends ArrayAdapter<String> {
    public static final Companion e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final String[] f6219a;
    public final boolean b;
    public int c;
    public int d;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ar/translation/phone/adapter/BroadcastAudioTypeAdapter$Companion;", "", "()V", "AUDIO_PAUSE", "", "AUDIO_PLAY", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BroadcastAudioTypeAdapter(Context context, String[] strArr, boolean z) {
        super(context, 0, strArr);
        Intrinsics.checkNotNullParameter(context, "adapterContext");
        Intrinsics.checkNotNullParameter(strArr, "dataArr");
        this.f6219a = strArr;
        this.b = z;
    }

    public static /* synthetic */ void b(BroadcastAudioTypeAdapter broadcastAudioTypeAdapter, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        broadcastAudioTypeAdapter.a(i, i2);
    }

    public final void a(int i, int i2) {
        this.c = i;
        this.d = i2;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ConstraintLayout constraintLayout;
        ItemBroadcastAudioTtsBinding itemBroadcastAudioTtsBinding;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (view == null) {
            itemBroadcastAudioTtsBinding = ItemBroadcastAudioTtsBinding.c(LayoutInflater.from(getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(itemBroadcastAudioTtsBinding, "inflate(...)");
            constraintLayout = itemBroadcastAudioTtsBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "getRoot(...)");
            constraintLayout.setTag(itemBroadcastAudioTtsBinding);
        } else {
            Object tag = view.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.upuphone.ar.translation.phone.databinding.ItemBroadcastAudioTtsBinding");
            itemBroadcastAudioTtsBinding = (ItemBroadcastAudioTtsBinding) tag;
            constraintLayout = itemBroadcastAudioTtsBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "getRoot(...)");
        }
        itemBroadcastAudioTtsBinding.f.setText(this.f6219a[i]);
        TextView textView = itemBroadcastAudioTtsBinding.e;
        Intrinsics.checkNotNullExpressionValue(textView, "tvItemTips");
        textView.setVisibility(i == ArraysKt.getLastIndex((T[]) this.f6219a) && this.b ? 0 : 8);
        itemBroadcastAudioTtsBinding.e.setText(R.string.tl_broadcast_tts_thai_support_tips);
        boolean z = this.c == i;
        itemBroadcastAudioTtsBinding.b.setSelected(z);
        itemBroadcastAudioTtsBinding.f.setSelected(z);
        ImageView imageView = itemBroadcastAudioTtsBinding.c;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivItemSelected");
        imageView.setVisibility(z ? 0 : 8);
        if (!z || this.d != 1) {
            LottieAnimationView lottieAnimationView = itemBroadcastAudioTtsBinding.d;
            Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "lottieAudioPlaying");
            lottieAnimationView.setVisibility(8);
            itemBroadcastAudioTtsBinding.d.cancelAnimation();
        } else {
            LottieAnimationView lottieAnimationView2 = itemBroadcastAudioTtsBinding.d;
            Intrinsics.checkNotNullExpressionValue(lottieAnimationView2, "lottieAudioPlaying");
            lottieAnimationView2.setVisibility(0);
            itemBroadcastAudioTtsBinding.d.playAnimation();
        }
        return constraintLayout;
    }
}
