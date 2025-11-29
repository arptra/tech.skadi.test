package com.upuphone.ar.transcribe.phone.adapter;

import android.text.Editable;
import com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity;
import com.upuphone.ar.transcribe.phone.view.ClipboardEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "hasFocus", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AiTodoAdapter$TodoItemProvider$convert$4 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ ClipboardEditText $etContent;
    final /* synthetic */ AiTodoEntity $item;
    final /* synthetic */ int $position;
    final /* synthetic */ AiTodoAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AiTodoAdapter$TodoItemProvider$convert$4(ClipboardEditText clipboardEditText, AiTodoAdapter aiTodoAdapter, int i, AiTodoEntity aiTodoEntity) {
        super(1);
        this.$etContent = clipboardEditText;
        this.this$0 = aiTodoAdapter;
        this.$position = i;
        this.$item = aiTodoEntity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (!z) {
            Editable text = this.$etContent.getText();
            if (text == null || StringsKt.isBlank(text)) {
                this.this$0.E0().invoke(Integer.valueOf(this.$position), this.$item);
                this.this$0.H = null;
            }
        }
    }
}
