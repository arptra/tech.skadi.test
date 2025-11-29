package com.upuphone.ar.transcribe.phone.repo;

import com.upuphone.ar.transcribe.phone.db.AiDao;
import com.upuphone.ar.transcribe.phone.db.TcbDb;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/upuphone/ar/transcribe/phone/db/AiDao;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class TranscribeAiRepo$aiDao$2 extends Lambda implements Function0<AiDao> {
    final /* synthetic */ TranscribeAiRepo this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TranscribeAiRepo$aiDao$2(TranscribeAiRepo transcribeAiRepo) {
        super(0);
        this.this$0 = transcribeAiRepo;
    }

    @NotNull
    public final AiDao invoke() {
        return TcbDb.f6095a.a(this.this$0.m()).n();
    }
}
