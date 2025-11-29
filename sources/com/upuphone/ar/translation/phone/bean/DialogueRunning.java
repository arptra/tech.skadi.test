package com.upuphone.ar.translation.phone.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001a\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\b\u0010#\u001a\u00020\u0005H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000f\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006$"}, d2 = {"Lcom/upuphone/ar/translation/phone/bean/DialogueRunning;", "", "speaker", "", "text", "", "tempText", "itemUpdateType", "itemUpdateIndex", "isDone", "", "playStatus", "(ILjava/lang/String;Ljava/lang/String;IIZI)V", "()Z", "getItemUpdateIndex", "()I", "getItemUpdateType", "getPlayStatus", "setPlayStatus", "(I)V", "getSpeaker", "getTempText", "()Ljava/lang/String;", "getText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "ar-translator_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DialogueRunning {
    private final boolean isDone;
    private final int itemUpdateIndex;
    private final int itemUpdateType;
    private int playStatus;
    private final int speaker;
    @NotNull
    private final String tempText;
    @NotNull
    private final String text;

    public DialogueRunning(int i, @NotNull String str, @NotNull String str2, int i2, int i3, boolean z, int i4) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "tempText");
        this.speaker = i;
        this.text = str;
        this.tempText = str2;
        this.itemUpdateType = i2;
        this.itemUpdateIndex = i3;
        this.isDone = z;
        this.playStatus = i4;
    }

    public static /* synthetic */ DialogueRunning copy$default(DialogueRunning dialogueRunning, int i, String str, String str2, int i2, int i3, boolean z, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = dialogueRunning.speaker;
        }
        if ((i5 & 2) != 0) {
            str = dialogueRunning.text;
        }
        String str3 = str;
        if ((i5 & 4) != 0) {
            str2 = dialogueRunning.tempText;
        }
        String str4 = str2;
        if ((i5 & 8) != 0) {
            i2 = dialogueRunning.itemUpdateType;
        }
        int i6 = i2;
        if ((i5 & 16) != 0) {
            i3 = dialogueRunning.itemUpdateIndex;
        }
        int i7 = i3;
        if ((i5 & 32) != 0) {
            z = dialogueRunning.isDone;
        }
        boolean z2 = z;
        if ((i5 & 64) != 0) {
            i4 = dialogueRunning.playStatus;
        }
        return dialogueRunning.copy(i, str3, str4, i6, i7, z2, i4);
    }

    public final int component1() {
        return this.speaker;
    }

    @NotNull
    public final String component2() {
        return this.text;
    }

    @NotNull
    public final String component3() {
        return this.tempText;
    }

    public final int component4() {
        return this.itemUpdateType;
    }

    public final int component5() {
        return this.itemUpdateIndex;
    }

    public final boolean component6() {
        return this.isDone;
    }

    public final int component7() {
        return this.playStatus;
    }

    @NotNull
    public final DialogueRunning copy(int i, @NotNull String str, @NotNull String str2, int i2, int i3, boolean z, int i4) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "tempText");
        return new DialogueRunning(i, str, str2, i2, i3, z, i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DialogueRunning)) {
            return false;
        }
        DialogueRunning dialogueRunning = (DialogueRunning) obj;
        return this.speaker == dialogueRunning.speaker && Intrinsics.areEqual((Object) this.text, (Object) dialogueRunning.text) && Intrinsics.areEqual((Object) this.tempText, (Object) dialogueRunning.tempText) && this.itemUpdateType == dialogueRunning.itemUpdateType && this.itemUpdateIndex == dialogueRunning.itemUpdateIndex && this.isDone == dialogueRunning.isDone && this.playStatus == dialogueRunning.playStatus;
    }

    public final int getItemUpdateIndex() {
        return this.itemUpdateIndex;
    }

    public final int getItemUpdateType() {
        return this.itemUpdateType;
    }

    public final int getPlayStatus() {
        return this.playStatus;
    }

    public final int getSpeaker() {
        return this.speaker;
    }

    @NotNull
    public final String getTempText() {
        return this.tempText;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.speaker) * 31) + this.text.hashCode()) * 31) + this.tempText.hashCode()) * 31) + Integer.hashCode(this.itemUpdateType)) * 31) + Integer.hashCode(this.itemUpdateIndex)) * 31) + Boolean.hashCode(this.isDone)) * 31) + Integer.hashCode(this.playStatus);
    }

    public final boolean isDone() {
        return this.isDone;
    }

    public final void setPlayStatus(int i) {
        this.playStatus = i;
    }

    @NotNull
    public String toString() {
        int i = this.speaker;
        String str = this.text;
        String str2 = this.tempText;
        int i2 = this.itemUpdateType;
        int i3 = this.itemUpdateIndex;
        boolean z = this.isDone;
        int i4 = this.playStatus;
        return "DialogueRunning(speaker=" + i + ", text='" + str + "', tempText='" + str2 + "', itemUpdateType=" + i2 + ", itemUpdateIndex=" + i3 + ", isDone=" + z + ", playStatus=" + i4 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DialogueRunning(int i, String str, String str2, int i2, int i3, boolean z, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, i2, i3, (i5 & 32) != 0 ? false : z, (i5 & 64) != 0 ? 0 : i4);
    }
}
