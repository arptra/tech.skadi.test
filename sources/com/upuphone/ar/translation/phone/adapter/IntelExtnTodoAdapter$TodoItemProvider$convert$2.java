package com.upuphone.ar.translation.phone.adapter;

import com.upuphone.ar.translation.ext.AnyExtKt;
import com.upuphone.ar.translation.phone.bean.IntelExtnTodo;
import com.upuphone.ar.translation.phone.view.ClipboardEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class IntelExtnTodoAdapter$TodoItemProvider$convert$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ ClipboardEditText $etContent;
    final /* synthetic */ IntelExtnTodo $item;
    final /* synthetic */ int $position;
    final /* synthetic */ IntelExtnTodoAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntelExtnTodoAdapter$TodoItemProvider$convert$2(ClipboardEditText clipboardEditText, IntelExtnTodo intelExtnTodo, IntelExtnTodoAdapter intelExtnTodoAdapter, int i) {
        super(1);
        this.$etContent = clipboardEditText;
        this.$item = intelExtnTodo;
        this.this$0 = intelExtnTodoAdapter;
        this.$position = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (!z) {
            String valueOf = String.valueOf(this.$etContent.getText());
            if (!Intrinsics.areEqual((Object) valueOf, (Object) this.$item.getContent()) && (!StringsKt.isBlank(valueOf))) {
                Function2 D0 = this.this$0.D0();
                Integer valueOf2 = Integer.valueOf(this.$position);
                Object a2 = AnyExtKt.a(this.$item, IntelExtnTodo.class);
                ((IntelExtnTodo) a2).setContent(valueOf);
                Unit unit = Unit.INSTANCE;
                D0.invoke(valueOf2, a2);
            } else if (StringsKt.isBlank(valueOf)) {
                this.this$0.C0().invoke(Integer.valueOf(this.$position), this.$item);
            }
        }
    }
}
