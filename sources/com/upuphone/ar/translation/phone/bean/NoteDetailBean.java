package com.upuphone.ar.translation.phone.bean;

import com.upuphone.ar.translation.utils.JsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010&\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001a\u0010\u0017\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR\u001a\u0010\u001a\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR\u001a\u0010\u001d\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u001a\u0010 \u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000eR\u001a\u0010#\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\u000e¨\u0006'"}, d2 = {"Lcom/upuphone/ar/translation/phone/bean/NoteDetailBean;", "", "()V", "dst", "", "getDst", "()Ljava/lang/String;", "setDst", "(Ljava/lang/String;)V", "editStatus", "", "getEditStatus", "()I", "setEditStatus", "(I)V", "isDisplaySrc", "", "()Z", "setDisplaySrc", "(Z)V", "noteStatus", "getNoteStatus", "setNoteStatus", "recordIndex", "getRecordIndex", "setRecordIndex", "speaker", "getSpeaker", "setSpeaker", "src", "getSrc", "setSrc", "transType", "getTransType", "setTransType", "xrType", "getXrType", "setXrType", "toString", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NoteDetailBean {
    @NotNull
    private String dst = "";
    private int editStatus;
    private boolean isDisplaySrc;
    private int noteStatus;
    private int recordIndex;
    private int speaker;
    @NotNull
    private String src = "";
    private int transType = 2;
    private int xrType;

    @NotNull
    public final String getDst() {
        return this.dst;
    }

    public final int getEditStatus() {
        return this.editStatus;
    }

    public final int getNoteStatus() {
        return this.noteStatus;
    }

    public final int getRecordIndex() {
        return this.recordIndex;
    }

    public final int getSpeaker() {
        return this.speaker;
    }

    @NotNull
    public final String getSrc() {
        return this.src;
    }

    public final int getTransType() {
        return this.transType;
    }

    public final int getXrType() {
        return this.xrType;
    }

    public final boolean isDisplaySrc() {
        return this.isDisplaySrc;
    }

    public final void setDisplaySrc(boolean z) {
        this.isDisplaySrc = z;
    }

    public final void setDst(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dst = str;
    }

    public final void setEditStatus(int i) {
        this.editStatus = i;
    }

    public final void setNoteStatus(int i) {
        this.noteStatus = i;
    }

    public final void setRecordIndex(int i) {
        this.recordIndex = i;
    }

    public final void setSpeaker(int i) {
        this.speaker = i;
    }

    public final void setSrc(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.src = str;
    }

    public final void setTransType(int i) {
        this.transType = i;
    }

    public final void setXrType(int i) {
        this.xrType = i;
    }

    @NotNull
    public String toString() {
        return JsonUtils.d(this);
    }
}
