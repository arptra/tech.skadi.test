package com.upuphone.ar.transcribe.phone.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import com.upuphone.ar.transcribe.ext.ContextExtKt;
import com.upuphone.ar.transcribe.ext.LogExt;
import com.upuphone.ar.transcribe.phone.adapter.AiTodoAdapter;
import com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 AiTodoAdapter.kt\ncom/upuphone/ar/transcribe/phone/adapter/AiTodoAdapter$TodoItemProvider\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n122#2,17:98\n71#3:115\n77#4:116\n*E\n"})
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AiTodoAdapter$TodoItemProvider$convert$$inlined$addTextChangedListener$default$1 implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AiTodoAdapter f6075a;
    public final /* synthetic */ AiTodoEntity b;
    public final /* synthetic */ AiTodoAdapter.TodoItemProvider c;

    public AiTodoAdapter$TodoItemProvider$convert$$inlined$addTextChangedListener$default$1(AiTodoAdapter aiTodoAdapter, AiTodoEntity aiTodoEntity, AiTodoAdapter.TodoItemProvider todoItemProvider) {
        this.f6075a = aiTodoAdapter;
        this.b = aiTodoEntity;
        this.c = todoItemProvider;
    }

    public void afterTextChanged(Editable editable) {
        String str;
        if (editable == null || (str = editable.toString()) == null) {
            str = "";
        }
        LogExt.d("changed text: " + str, "AiTodoAdapter");
        if (!StringsKt.isBlank(str)) {
            if (this.f6075a.H == null) {
                this.f6075a.H = (AiTodoEntity) ContextExtKt.c(this.b, AiTodoEntity.class);
            }
            AiTodoEntity C0 = this.f6075a.H;
            if (C0 != null) {
                C0.setContent(str);
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.c.e > 200) {
            AiTodoEntity C02 = this.f6075a.H;
            if (C02 != null) {
                C02.setContent("");
            }
            this.c.e = currentTimeMillis;
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
