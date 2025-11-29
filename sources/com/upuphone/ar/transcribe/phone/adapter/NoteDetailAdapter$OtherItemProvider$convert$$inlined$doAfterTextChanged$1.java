package com.upuphone.ar.transcribe.phone.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import com.upuphone.ar.transcribe.phone.adapter.NoteDetailAdapter;
import com.upuphone.ar.transcribe.phone.bean.NoteDetailBean;
import com.upuphone.ar.transcribe.phone.view.ClipboardEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 NoteDetailAdapter.kt\ncom/upuphone/ar/transcribe/phone/adapter/NoteDetailAdapter$OtherItemProvider\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n79#2:98\n71#3:99\n77#4:100\n*E\n"})
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release", "androidx/core/widget/TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NoteDetailAdapter$OtherItemProvider$convert$$inlined$doAfterTextChanged$1 implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NoteDetailAdapter.OtherItemProvider f6076a;
    public final /* synthetic */ int b;
    public final /* synthetic */ NoteDetailBean c;
    public final /* synthetic */ ClipboardEditText d;

    public NoteDetailAdapter$OtherItemProvider$convert$$inlined$doAfterTextChanged$1(NoteDetailAdapter.OtherItemProvider otherItemProvider, int i, NoteDetailBean noteDetailBean, ClipboardEditText clipboardEditText) {
        this.f6076a = otherItemProvider;
        this.b = i;
        this.c = noteDetailBean;
        this.d = clipboardEditText;
    }

    public void afterTextChanged(Editable editable) {
        this.f6076a.u().onTextChange(this.b, this.c, String.valueOf(editable), this.d);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
