package io.ktor.client.request.forms;

import io.ktor.utils.io.core.ByteReadPacket;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class FormDslKt$formData$1$part$7 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Object $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FormDslKt$formData$1$part$7(Object obj) {
        super(0);
        this.$value = obj;
    }

    public final void invoke() {
        ((ByteReadPacket) this.$value).close();
    }
}
