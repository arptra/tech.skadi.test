package com.upuphone.ar.translation.phone.adapter;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.meizu.common.widget.AnimCheckBox;
import com.upuphone.ar.translation.constants.TranslatorConstants;
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

@SourceDebugExtension({"SMAP\nNoteListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoteListAdapter.kt\ncom/upuphone/ar/translation/phone/adapter/NoteListAdapter\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,217:1\n262#2,2:218\n262#2,2:220\n262#2,2:222\n262#2,2:224\n262#2,2:226\n262#2,2:228\n262#2,2:230\n*S KotlinDebug\n*F\n+ 1 NoteListAdapter.kt\ncom/upuphone/ar/translation/phone/adapter/NoteListAdapter\n*L\n86#1:218,2\n87#1:220,2\n99#1:222,2\n100#1:224,2\n108#1:226,2\n110#1:228,2\n125#1:230,2\n*E\n"})
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001 B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/upuphone/ar/translation/phone/adapter/NoteListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "", "layoutResId", "", "data", "<init>", "(ILjava/util/List;)V", "holder", "item", "", "v0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/upuphone/ar/translation/phone/bean/NoteBean;)V", "", "isChoice", "isNotifyAll", "y0", "(ZZ)V", "x0", "()Z", "isTextRtl", "isViewRtl", "Landroid/widget/TextView;", "tv", "w0", "(ZZLandroid/widget/TextView;)V", "C", "Z", "mIsMultiChoiceDeleted", "D", "Companion", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class NoteListAdapter extends BaseQuickAdapter<NoteBean, BaseViewHolder> {
    public static final Companion D = new Companion((DefaultConstructorMarker) null);
    public static boolean E;
    public boolean C;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/upuphone/ar/translation/phone/adapter/NoteListAdapter$Companion;", "", "<init>", "()V", "", "a", "()I", "", "CONTENT_SPLIT_MARK", "Ljava/lang/String;", "", "mIsNewUI", "Z", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            if (TranslatorConstants.isAirPro()) {
                NoteListAdapter.E = true;
                return R.layout.item_list_record_new;
            }
            NoteListAdapter.E = false;
            return R.layout.item_list_record_old;
        }

        public Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NoteListAdapter(int i, List list) {
        super(i, list);
        Intrinsics.checkNotNullParameter(list, "data");
        if (E) {
            o(R.id.tv_item_title);
        }
    }

    /* renamed from: v0 */
    public void A(BaseViewHolder baseViewHolder, NoteBean noteBean) {
        int i;
        BaseViewHolder baseViewHolder2 = baseViewHolder;
        Intrinsics.checkNotNullParameter(baseViewHolder2, "holder");
        Intrinsics.checkNotNullParameter(noteBean, "item");
        String str = "";
        boolean z = true;
        if (E) {
            String title = noteBean.getTitle();
            TextView textView = (TextView) baseViewHolder2.getView(R.id.tv_item_title);
            textView.setText(StringsKt.trim((CharSequence) title).toString());
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (noteBean.getTransType() == 3 && noteBean.getTelephoneTrans() == 1) ? ContextCompat.getDrawable(H(), R.drawable.icon_telephone_trans_item_mark) : null, (Drawable) null);
            String content = noteBean.getContent();
            TextView textView2 = (TextView) baseViewHolder2.getView(R.id.tv_item_content);
            TextView textView3 = (TextView) baseViewHolder2.getView(R.id.tv_item_content_1);
            int i2 = 8;
            if (noteBean.getTransType() == 3) {
                textView2.setMaxLines(1);
                if (StringsKt.contains$default((CharSequence) content, (CharSequence) "&##&", false, 2, (Object) null)) {
                    textView2.setVisibility(0);
                    textView3.setVisibility(0);
                    i = 0;
                    List split$default = StringsKt.split$default((CharSequence) content, new String[]{"&##&"}, false, 0, 6, (Object) null);
                    String obj = StringsKt.trim((CharSequence) (String) split$default.get(0)).toString();
                    String obj2 = StringsKt.trim((CharSequence) (String) split$default.get(1)).toString();
                    if (!StringExtKt.b(obj) && !StringExtKt.b(obj2)) {
                        z = false;
                    }
                    boolean f = ContextExtKt.f(H());
                    w0(z, f, textView2);
                    w0(z, f, textView3);
                    textView2.setText(obj);
                    textView3.setText(obj2);
                } else {
                    i = 0;
                    String obj3 = StringsKt.isBlank(content) ? str : StringsKt.trim((CharSequence) content).toString();
                    textView2.setVisibility(true ^ StringsKt.isBlank(obj3) ? 0 : 8);
                    textView3.setVisibility(8);
                    w0(StringExtKt.b(obj3), ContextExtKt.f(H()), textView2);
                    textView2.setText(obj3);
                }
            } else {
                i = 0;
                String obj4 = StringsKt.isBlank(content) ? str : StringsKt.trim((CharSequence) content).toString();
                textView2.setVisibility(true ^ StringsKt.isBlank(obj4) ? 0 : 8);
                textView2.setMaxLines(2);
                textView3.setVisibility(8);
                w0(StringExtKt.b(obj4), ContextExtKt.f(H()), textView2);
                textView2.setText(obj4);
            }
            String geoLocation = noteBean.getGeoLocation();
            int i3 = R.id.tv_item_location;
            if (!StringsKt.isBlank(geoLocation)) {
                str = StringsKt.trim((CharSequence) geoLocation).toString();
            }
            baseViewHolder2.setText(i3, (CharSequence) str);
            baseViewHolder2.setText(R.id.tv_item_time, (CharSequence) DateUtils.k(noteBean.getRecordTime()));
            AnimCheckBox animCheckBox = (AnimCheckBox) baseViewHolder2.getView(R.id.cb_item);
            if (this.C) {
                i2 = i;
            }
            animCheckBox.setVisibility(i2);
            animCheckBox.setInitVisible(i);
            animCheckBox.setChecked(noteBean.isDeleted());
            return;
        }
        String content2 = noteBean.getContent();
        int i4 = R.id.tv_item_content;
        if (!StringsKt.isBlank(content2)) {
            str = StringsKt.trim((CharSequence) content2).toString();
        }
        baseViewHolder2.setText(i4, (CharSequence) str);
        TextView textView4 = (TextView) baseViewHolder2.getView(R.id.tv_trans_mark);
        if (noteBean.getTransType() == 1) {
            textView4.setText(H().getString(R.string.tl_speech_transcribe));
            textView4.setCompoundDrawablesRelativeWithIntrinsicBounds(ContextCompat.getDrawable(H(), R.drawable.icon_transcribe_record), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            textView4.setText(H().getString(R.string.tl_simul_interpret));
            textView4.setCompoundDrawablesRelativeWithIntrinsicBounds(ContextCompat.getDrawable(H(), R.drawable.icon_simul_trans_record), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        baseViewHolder2.setText(R.id.tv_item_time, (CharSequence) DateUtils.k(noteBean.getRecordTime()));
    }

    public final void w0(boolean z, boolean z2, TextView textView) {
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

    public final boolean x0() {
        return this.C;
    }

    public final void y0(boolean z, boolean z2) {
        if (E) {
            this.C = z;
            if (z2) {
                notifyDataSetChanged();
            }
        }
    }
}
