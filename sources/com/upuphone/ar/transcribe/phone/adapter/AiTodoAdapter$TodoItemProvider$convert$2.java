package com.upuphone.ar.transcribe.phone.adapter;

import com.upuphone.ar.transcribe.ext.ContextExtKt;
import com.upuphone.ar.transcribe.phone.db.entity.AiTodoEntity;
import com.upuphone.ar.transcribe.phone.view.ClipboardEditText;
import com.upuphone.star.core.log.ULog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AiTodoAdapter$TodoItemProvider$convert$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ ClipboardEditText $etContent;
    final /* synthetic */ AiTodoEntity $item;
    final /* synthetic */ int $position;
    final /* synthetic */ AiTodoAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AiTodoAdapter$TodoItemProvider$convert$2(ClipboardEditText clipboardEditText, AiTodoEntity aiTodoEntity, AiTodoAdapter aiTodoAdapter, int i) {
        super(1);
        this.$etContent = clipboardEditText;
        this.$item = aiTodoEntity;
        this.this$0 = aiTodoAdapter;
        this.$position = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (!z) {
            String valueOf = String.valueOf(this.$etContent.getText());
            String content = this.$item.getContent();
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("AiTodoAdapter", "text change: " + valueOf);
            delegate.a("AiTodoAdapter", "text change origin: " + content);
            if (!Intrinsics.areEqual((Object) valueOf, (Object) content) && (!StringsKt.isBlank(valueOf))) {
                this.$item.setContent(valueOf);
                this.this$0.F0().invoke(Integer.valueOf(this.$position), ContextExtKt.c(this.$item, AiTodoEntity.class));
            }
            this.this$0.H = null;
        }
    }
}
