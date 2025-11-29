package com.upuphone.ar.transcribe.phone.bean;

import com.upuphone.ar.transcribe.interconnect.entity.TranslationStateEntity;
import com.upuphone.ar.transcribe.phone.db.entity.TranscribeBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/bean/TransStateEvent;", "", "transState", "Lcom/upuphone/ar/transcribe/interconnect/entity/TranslationStateEntity;", "transcribeBean", "Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "(Lcom/upuphone/ar/transcribe/interconnect/entity/TranslationStateEntity;Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;)V", "getTransState", "()Lcom/upuphone/ar/transcribe/interconnect/entity/TranslationStateEntity;", "setTransState", "(Lcom/upuphone/ar/transcribe/interconnect/entity/TranslationStateEntity;)V", "getTranscribeBean", "()Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;", "setTranscribeBean", "(Lcom/upuphone/ar/transcribe/phone/db/entity/TranscribeBean;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TransStateEvent {
    @NotNull
    private TranslationStateEntity transState;
    @Nullable
    private TranscribeBean transcribeBean;

    public TransStateEvent(@NotNull TranslationStateEntity translationStateEntity, @Nullable TranscribeBean transcribeBean2) {
        Intrinsics.checkNotNullParameter(translationStateEntity, "transState");
        this.transState = translationStateEntity;
        this.transcribeBean = transcribeBean2;
    }

    public static /* synthetic */ TransStateEvent copy$default(TransStateEvent transStateEvent, TranslationStateEntity translationStateEntity, TranscribeBean transcribeBean2, int i, Object obj) {
        if ((i & 1) != 0) {
            translationStateEntity = transStateEvent.transState;
        }
        if ((i & 2) != 0) {
            transcribeBean2 = transStateEvent.transcribeBean;
        }
        return transStateEvent.copy(translationStateEntity, transcribeBean2);
    }

    @NotNull
    public final TranslationStateEntity component1() {
        return this.transState;
    }

    @Nullable
    public final TranscribeBean component2() {
        return this.transcribeBean;
    }

    @NotNull
    public final TransStateEvent copy(@NotNull TranslationStateEntity translationStateEntity, @Nullable TranscribeBean transcribeBean2) {
        Intrinsics.checkNotNullParameter(translationStateEntity, "transState");
        return new TransStateEvent(translationStateEntity, transcribeBean2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransStateEvent)) {
            return false;
        }
        TransStateEvent transStateEvent = (TransStateEvent) obj;
        return Intrinsics.areEqual((Object) this.transState, (Object) transStateEvent.transState) && Intrinsics.areEqual((Object) this.transcribeBean, (Object) transStateEvent.transcribeBean);
    }

    @NotNull
    public final TranslationStateEntity getTransState() {
        return this.transState;
    }

    @Nullable
    public final TranscribeBean getTranscribeBean() {
        return this.transcribeBean;
    }

    public int hashCode() {
        int hashCode = this.transState.hashCode() * 31;
        TranscribeBean transcribeBean2 = this.transcribeBean;
        return hashCode + (transcribeBean2 == null ? 0 : transcribeBean2.hashCode());
    }

    public final void setTransState(@NotNull TranslationStateEntity translationStateEntity) {
        Intrinsics.checkNotNullParameter(translationStateEntity, "<set-?>");
        this.transState = translationStateEntity;
    }

    public final void setTranscribeBean(@Nullable TranscribeBean transcribeBean2) {
        this.transcribeBean = transcribeBean2;
    }

    @NotNull
    public String toString() {
        TranslationStateEntity translationStateEntity = this.transState;
        TranscribeBean transcribeBean2 = this.transcribeBean;
        return "TransStateEvent(transState=" + translationStateEntity + ", noteBean=" + transcribeBean2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TransStateEvent(TranslationStateEntity translationStateEntity, TranscribeBean transcribeBean2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(translationStateEntity, (i & 2) != 0 ? null : transcribeBean2);
    }
}
