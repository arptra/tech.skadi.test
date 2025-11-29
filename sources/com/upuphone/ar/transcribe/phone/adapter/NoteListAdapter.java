package com.upuphone.ar.transcribe.phone.adapter;

import android.view.View;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.honey.account.w4.c;
import com.meizu.common.widget.AnimCheckBox;
import com.upuphone.ar.transcribe.R;
import com.upuphone.ar.transcribe.phone.bean.ListItemBean;
import com.upuphone.ar.transcribe.utils.DateUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@SourceDebugExtension({"SMAP\nNoteListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoteListAdapter.kt\ncom/upuphone/ar/transcribe/phone/adapter/NoteListAdapter\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,82:1\n262#2,2:83\n262#2,2:85\n262#2,2:87\n262#2,2:89\n*S KotlinDebug\n*F\n+ 1 NoteListAdapter.kt\ncom/upuphone/ar/transcribe/phone/adapter/NoteListAdapter\n*L\n55#1:83,2\n60#1:85,2\n63#1:87,2\n72#1:89,2\n*E\n"})
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001bB+\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/adapter/NoteListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/upuphone/ar/transcribe/phone/bean/ListItemBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "", "layoutResId", "", "data", "Lcom/upuphone/ar/transcribe/phone/adapter/NoteListAdapter$OnRenameTitleListener;", "onRenameTitleListener", "<init>", "(ILjava/util/List;Lcom/upuphone/ar/transcribe/phone/adapter/NoteListAdapter$OnRenameTitleListener;)V", "holder", "item", "", "v0", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/upuphone/ar/transcribe/phone/bean/ListItemBean;)V", "C", "Lcom/upuphone/ar/transcribe/phone/adapter/NoteListAdapter$OnRenameTitleListener;", "", "D", "Z", "x0", "()Z", "y0", "(Z)V", "isEditMode", "OnRenameTitleListener", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class NoteListAdapter extends BaseQuickAdapter<ListItemBean, BaseViewHolder> {
    public final OnRenameTitleListener C;
    public boolean D;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bæ\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/adapter/NoteListAdapter$OnRenameTitleListener;", "", "Lcom/upuphone/ar/transcribe/phone/bean/ListItemBean;", "bean", "", "a", "(Lcom/upuphone/ar/transcribe/phone/bean/ListItemBean;)V", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface OnRenameTitleListener {
        void a(ListItemBean listItemBean);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NoteListAdapter(int i, List list, OnRenameTitleListener onRenameTitleListener, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, (i2 & 4) != 0 ? null : onRenameTitleListener);
    }

    public static final void w0(NoteListAdapter noteListAdapter, ListItemBean listItemBean, View view) {
        Intrinsics.checkNotNullParameter(noteListAdapter, "this$0");
        Intrinsics.checkNotNullParameter(listItemBean, "$item");
        OnRenameTitleListener onRenameTitleListener = noteListAdapter.C;
        if (onRenameTitleListener != null) {
            onRenameTitleListener.a(listItemBean);
        }
    }

    /* renamed from: v0 */
    public void A(BaseViewHolder baseViewHolder, ListItemBean listItemBean) {
        CharSequence charSequence;
        CharSequence charSequence2;
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(listItemBean, "item");
        TextView textView = (TextView) baseViewHolder.getView(R.id.item_time_tv);
        textView.setText(DateUtils.l(textView.getContext(), listItemBean.getRecordTime()));
        int i = R.id.item_content_tv;
        CharSequence content = listItemBean.getContent();
        String str = "";
        if (content == null || StringsKt.isBlank(content)) {
            charSequence = str;
        } else {
            CharSequence content2 = listItemBean.getContent();
            charSequence = content2 != null ? StringsKt.trim(content2) : null;
        }
        baseViewHolder.setText(i, charSequence);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.item_title_tv);
        CharSequence title = listItemBean.getTitle();
        if (title == null || title.length() == 0) {
            charSequence2 = H().getString(R.string.transcribe_app_name);
        } else {
            CharSequence title2 = listItemBean.getTitle();
            Intrinsics.checkNotNull(title2);
            charSequence2 = StringsKt.trim(title2);
        }
        textView2.setText(charSequence2);
        if (!this.D) {
            textView2.setOnClickListener(new c(this, listItemBean));
        } else {
            textView2.setOnClickListener((View.OnClickListener) null);
        }
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.item_content_tv);
        TextView textView4 = (TextView) baseViewHolder.getView(R.id.item_content_tv2);
        int i2 = 8;
        if (listItemBean.getType() == 1) {
            baseViewHolder.setGone(R.id.iv_call_mark, true);
            textView3.setMaxLines(2);
            textView4.setVisibility(8);
        } else {
            baseViewHolder.setGone(R.id.iv_call_mark, false);
            textView3.setMaxLines(1);
            String content22 = listItemBean.getContent2();
            if (content22 == null || !(!StringsKt.isBlank(content22))) {
                textView4.setVisibility(8);
            } else {
                textView4.setVisibility(0);
                textView4.setText(listItemBean.getContent2());
            }
        }
        int i3 = R.id.item_location;
        String simpleLocation = listItemBean.getSimpleLocation();
        if (!(simpleLocation == null || simpleLocation.length() == 0)) {
            str = listItemBean.getSimpleLocation();
        }
        baseViewHolder.setText(i3, (CharSequence) str);
        AnimCheckBox animCheckBox = (AnimCheckBox) baseViewHolder.getView(R.id.cb_item);
        if (this.D) {
            i2 = 0;
        }
        animCheckBox.setVisibility(i2);
        if (this.D) {
            animCheckBox.setInitVisible(0);
            animCheckBox.setChecked(listItemBean.isSelected());
        }
    }

    public final boolean x0() {
        return this.D;
    }

    public final void y0(boolean z) {
        this.D = z;
    }

    public NoteListAdapter(int i, List list, OnRenameTitleListener onRenameTitleListener) {
        super(i, list);
        this.C = onRenameTitleListener;
    }
}
