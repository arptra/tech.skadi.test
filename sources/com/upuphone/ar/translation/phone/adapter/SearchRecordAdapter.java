package com.upuphone.ar.translation.phone.adapter;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.upuphone.ar.translation.ext.ContextExtKt;
import com.upuphone.ar.translation.ext.StringExtKt;
import com.upuphone.ar.translation.phone.R;
import com.upuphone.ar.translation.phone.bean.NoteBean;
import com.upuphone.ar.translation.utils.DateUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@SourceDebugExtension({"SMAP\nSearchRecordAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchRecordAdapter.kt\ncom/upuphone/ar/translation/phone/adapter/SearchRecordAdapter\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,124:1\n262#2,2:125\n262#2,2:127\n262#2,2:129\n262#2,2:131\n262#2,2:133\n262#2,2:135\n*S KotlinDebug\n*F\n+ 1 SearchRecordAdapter.kt\ncom/upuphone/ar/translation/phone/adapter/SearchRecordAdapter\n*L\n53#1:125,2\n54#1:127,2\n66#1:129,2\n67#1:131,2\n75#1:133,2\n77#1:135,2\n*E\n"})
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B\u001f\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/upuphone/ar/translation/phone/adapter/SearchRecordAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "", "layoutResId", "", "data", "<init>", "(ILjava/util/List;)V", "", "isTextRtl", "isViewRtl", "Landroid/widget/TextView;", "tv", "", "v0", "(ZZLandroid/widget/TextView;)V", "holder", "item", "u0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/upuphone/ar/translation/phone/bean/NoteBean;)V", "C", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class SearchRecordAdapter extends BaseQuickAdapter<NoteBean, BaseViewHolder> {
    public static final Companion C = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/translation/phone/adapter/SearchRecordAdapter$Companion;", "", "()V", "CONTENT_SPLIT_MARK", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchRecordAdapter(int i, List list) {
        super(i, list);
        Intrinsics.checkNotNullParameter(list, "data");
    }

    private final void v0(boolean z, boolean z2, TextView textView) {
        int i = 6;
        int i2 = 8388613;
        if (z) {
            if (z2) {
                i2 = 8388611;
            }
            textView.setGravity(i2);
            if (z2) {
                i = 5;
            }
            textView.setTextAlignment(i);
            return;
        }
        if (!z2) {
            i2 = 8388611;
        }
        textView.setGravity(i2);
        if (!z2) {
            i = 5;
        }
        textView.setTextAlignment(i);
    }

    /* renamed from: u0 */
    public void A(BaseViewHolder baseViewHolder, NoteBean noteBean) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(noteBean, "item");
        String title = noteBean.getTitle();
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_item_title);
        textView.setText(StringsKt.trim((CharSequence) title).toString());
        boolean z = true;
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (noteBean.getTransType() == 3 && noteBean.getTelephoneTrans() == 1) ? ContextCompat.getDrawable(H(), R.drawable.icon_telephone_trans_item_mark) : null, (Drawable) null);
        String content = noteBean.getContent();
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_item_content);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_item_content_1);
        String str = "";
        int i = 0;
        if (noteBean.getTransType() == 3) {
            textView2.setMaxLines(1);
            if (StringsKt.contains$default((CharSequence) content, (CharSequence) "&##&", false, 2, (Object) null)) {
                textView2.setVisibility(0);
                textView3.setVisibility(0);
                List split$default = StringsKt.split$default((CharSequence) content, new String[]{"&##&"}, false, 0, 6, (Object) null);
                String obj = StringsKt.trim((CharSequence) (String) split$default.get(0)).toString();
                String obj2 = StringsKt.trim((CharSequence) (String) split$default.get(1)).toString();
                if (!StringExtKt.b(obj) && !StringExtKt.b(obj2)) {
                    z = false;
                }
                boolean f = ContextExtKt.f(H());
                v0(z, f, textView2);
                v0(z, f, textView3);
                textView2.setText(obj);
                textView3.setText(obj2);
            } else {
                String obj3 = StringsKt.isBlank(content) ? str : StringsKt.trim((CharSequence) content).toString();
                if (!(true ^ StringsKt.isBlank(obj3))) {
                    i = 8;
                }
                textView2.setVisibility(i);
                textView3.setVisibility(8);
                v0(StringExtKt.b(obj3), ContextExtKt.f(H()), textView2);
                textView2.setText(obj3);
            }
        } else {
            String obj4 = StringsKt.isBlank(content) ? str : StringsKt.trim((CharSequence) content).toString();
            if (!(true ^ StringsKt.isBlank(obj4))) {
                i = 8;
            }
            textView2.setVisibility(i);
            textView2.setMaxLines(2);
            textView3.setVisibility(8);
            v0(StringExtKt.b(obj4), ContextExtKt.f(H()), textView2);
            textView2.setText(obj4);
        }
        String geoLocation = noteBean.getGeoLocation();
        int i2 = R.id.tv_item_location;
        if (!StringsKt.isBlank(geoLocation)) {
            str = StringsKt.trim((CharSequence) geoLocation).toString();
        }
        baseViewHolder.setText(i2, (CharSequence) str);
        baseViewHolder.setText(R.id.tv_item_time, (CharSequence) DateUtils.k(noteBean.getRecordTime()));
    }
}
