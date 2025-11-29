package com.upuphone.ar.translation.phone.adapter;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.bean.SimulRunning;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010 ¨\u0006$"}, d2 = {"Lcom/upuphone/ar/translation/phone/adapter/SimulRunningAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/upuphone/ar/translation/phone/bean/SimulRunning;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "", "layoutResId", "", "data", "<init>", "(ILjava/util/List;)V", "", "src", "Landroid/text/SpannableString;", "x0", "(Ljava/lang/String;)Landroid/text/SpannableString;", "dst", "w0", "holder", "item", "", "u0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/upuphone/ar/translation/phone/bean/SimulRunning;)V", "", "isRecordRtl", "isViewRtl", "y0", "(ZZ)V", "Landroid/widget/TextView;", "tv", "v0", "(Landroid/widget/TextView;)V", "C", "Z", "mIsRecordRtl", "D", "mIsViewRtl", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nSimulRunningAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SimulRunningAdapter.kt\ncom/upuphone/ar/translation/phone/adapter/SimulRunningAdapter\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,139:1\n262#2,2:140\n*S KotlinDebug\n*F\n+ 1 SimulRunningAdapter.kt\ncom/upuphone/ar/translation/phone/adapter/SimulRunningAdapter\n*L\n39#1:140,2\n*E\n"})
public final class SimulRunningAdapter extends BaseQuickAdapter<SimulRunning, BaseViewHolder> {
    public boolean C;
    public boolean D;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimulRunningAdapter(int i, List list) {
        super(i, list);
        Intrinsics.checkNotNullParameter(list, "data");
    }

    private final SpannableString w0(String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(H().getColor(R.color.color_record_detail_other_dst)), 0, spannableString.length(), 18);
        return spannableString;
    }

    private final SpannableString x0(String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(H().getColor(R.color.color_record_detail_other_src)), 0, str.length(), 18);
        return spannableString;
    }

    /* renamed from: u0 */
    public void A(BaseViewHolder baseViewHolder, SimulRunning simulRunning) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(simulRunning, "item");
        int Q = Q(simulRunning);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_record);
        v0(textView);
        String src = simulRunning.getSrc();
        String tempSrc = simulRunning.getTempSrc();
        String obj = StringsKt.trim((CharSequence) src + tempSrc).toString();
        String dst = simulRunning.getDst();
        String tempDst = simulRunning.getTempDst();
        String obj2 = StringsKt.trim((CharSequence) dst + tempDst).toString();
        textView.setVisibility(StringsKt.isBlank(obj2) ^ true ? 0 : 8);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableString x0 = x0(obj);
        SpannableString w0 = w0(obj2);
        if (simulRunning.isDisplaySrc()) {
            spannableStringBuilder.append(x0).append(StringUtils.LF).append(w0);
        } else {
            spannableStringBuilder.append(w0);
        }
        textView.setText(spannableStringBuilder);
        if (Q == 0) {
            baseViewHolder.setGone(R.id.v_divider, true);
        } else {
            baseViewHolder.setGone(R.id.v_divider, StringsKt.isBlank(obj2));
        }
    }

    public final void v0(TextView textView) {
        int i = 6;
        int i2 = 8388613;
        if (this.C) {
            if (this.D) {
                i2 = 8388611;
            }
            textView.setGravity(i2);
            if (this.D) {
                i = 5;
            }
            textView.setTextAlignment(i);
            return;
        }
        if (!this.D) {
            i2 = 8388611;
        }
        textView.setGravity(i2);
        if (!this.D) {
            i = 5;
        }
        textView.setTextAlignment(i);
    }

    public final void y0(boolean z, boolean z2) {
        this.C = z;
        this.D = z2;
        if (!getData().isEmpty()) {
            notifyDataSetChanged();
        }
    }
}
