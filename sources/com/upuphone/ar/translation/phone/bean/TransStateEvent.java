package com.upuphone.ar.translation.phone.bean;

import com.upuphone.ar.translation.interconnect.entity.TranslationState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/upuphone/ar/translation/phone/bean/TransStateEvent;", "", "transState", "Lcom/upuphone/ar/translation/interconnect/entity/TranslationState;", "noteBean", "Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "(Lcom/upuphone/ar/translation/interconnect/entity/TranslationState;Lcom/upuphone/ar/translation/phone/bean/NoteBean;)V", "getNoteBean", "()Lcom/upuphone/ar/translation/phone/bean/NoteBean;", "setNoteBean", "(Lcom/upuphone/ar/translation/phone/bean/NoteBean;)V", "getTransState", "()Lcom/upuphone/ar/translation/interconnect/entity/TranslationState;", "setTransState", "(Lcom/upuphone/ar/translation/interconnect/entity/TranslationState;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TransStateEvent {
    @Nullable
    private NoteBean noteBean;
    @NotNull
    private TranslationState transState;

    public TransStateEvent(@NotNull TranslationState translationState, @Nullable NoteBean noteBean2) {
        Intrinsics.checkNotNullParameter(translationState, "transState");
        this.transState = translationState;
        this.noteBean = noteBean2;
    }

    public static /* synthetic */ TransStateEvent copy$default(TransStateEvent transStateEvent, TranslationState translationState, NoteBean noteBean2, int i, Object obj) {
        if ((i & 1) != 0) {
            translationState = transStateEvent.transState;
        }
        if ((i & 2) != 0) {
            noteBean2 = transStateEvent.noteBean;
        }
        return transStateEvent.copy(translationState, noteBean2);
    }

    @NotNull
    public final TranslationState component1() {
        return this.transState;
    }

    @Nullable
    public final NoteBean component2() {
        return this.noteBean;
    }

    @NotNull
    public final TransStateEvent copy(@NotNull TranslationState translationState, @Nullable NoteBean noteBean2) {
        Intrinsics.checkNotNullParameter(translationState, "transState");
        return new TransStateEvent(translationState, noteBean2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransStateEvent)) {
            return false;
        }
        TransStateEvent transStateEvent = (TransStateEvent) obj;
        return Intrinsics.areEqual((Object) this.transState, (Object) transStateEvent.transState) && Intrinsics.areEqual((Object) this.noteBean, (Object) transStateEvent.noteBean);
    }

    @Nullable
    public final NoteBean getNoteBean() {
        return this.noteBean;
    }

    @NotNull
    public final TranslationState getTransState() {
        return this.transState;
    }

    public int hashCode() {
        int hashCode = this.transState.hashCode() * 31;
        NoteBean noteBean2 = this.noteBean;
        return hashCode + (noteBean2 == null ? 0 : noteBean2.hashCode());
    }

    public final void setNoteBean(@Nullable NoteBean noteBean2) {
        this.noteBean = noteBean2;
    }

    public final void setTransState(@NotNull TranslationState translationState) {
        Intrinsics.checkNotNullParameter(translationState, "<set-?>");
        this.transState = translationState;
    }

    @NotNull
    public String toString() {
        TranslationState translationState = this.transState;
        NoteBean noteBean2 = this.noteBean;
        return "TransStateEvent(transState=" + translationState + ", \nnoteBean=" + noteBean2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TransStateEvent(TranslationState translationState, NoteBean noteBean2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(translationState, (i & 2) != 0 ? null : noteBean2);
    }
}
