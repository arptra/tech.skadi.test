package com.upuphone.ar.transcribe.phone.adapter;

import com.upuphone.ar.transcribe.phone.adapter.NoteDetailAdapter;
import com.upuphone.ar.transcribe.phone.bean.NoteDetailBean;
import com.upuphone.ar.transcribe.phone.view.ClipboardEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J*\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"com/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter$editListener$1", "Lcom/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter$OnItemEditListener;", "onModeChange", "", "isEdit", "", "view", "Lcom/upuphone/ar/transcribe/phone/view/ClipboardEditText;", "onTextChange", "position", "", "item", "Lcom/upuphone/ar/transcribe/phone/bean/NoteDetailBean;", "newStr", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NoteDetailAdapter$editListener$1 implements NoteDetailAdapter.OnItemEditListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NoteDetailAdapter f6078a;
    public final /* synthetic */ NoteDetailAdapter.OnItemEditListener b;

    public NoteDetailAdapter$editListener$1(NoteDetailAdapter noteDetailAdapter, NoteDetailAdapter.OnItemEditListener onItemEditListener) {
        this.f6078a = noteDetailAdapter;
        this.b = onItemEditListener;
    }

    public void onModeChange(boolean z, ClipboardEditText clipboardEditText) {
        Intrinsics.checkNotNullParameter(clipboardEditText, "view");
        if (z) {
            this.f6078a.K0(true);
            this.f6078a.H = clipboardEditText;
        } else if (Intrinsics.areEqual((Object) this.f6078a.H, (Object) clipboardEditText)) {
            this.f6078a.K0(false);
            this.f6078a.H = null;
        }
        this.b.onModeChange(z, clipboardEditText);
    }

    public void onTextChange(int i, NoteDetailBean noteDetailBean, String str, ClipboardEditText clipboardEditText) {
        Intrinsics.checkNotNullParameter(noteDetailBean, "item");
        Intrinsics.checkNotNullParameter(clipboardEditText, "view");
        this.f6078a.I0(i);
        this.f6078a.J0(!Intrinsics.areEqual((Object) noteDetailBean.getContent(), (Object) str));
        this.f6078a.L0(clipboardEditText);
        this.b.onTextChange(i, noteDetailBean, str, clipboardEditText);
    }
}
