package com.upuphone.ar.transcribe.phone.db.entity;

import androidx.annotation.Keep;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u0000 -2\u00020\u0001:\u0001-B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003JB\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\u001d2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0007HÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006."}, d2 = {"Lcom/upuphone/ar/transcribe/phone/db/entity/MessageEntity;", "", "id", "", "message", "", "owner", "", "timestamp", "transcribeId", "(Ljava/lang/Long;Ljava/lang/String;IJJ)V", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getOwner", "()I", "getTimestamp", "()J", "setTimestamp", "(J)V", "getTranscribeId", "setTranscribeId", "wraped", "", "getWraped", "()Z", "setWraped", "(Z)V", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/String;IJJ)Lcom/upuphone/ar/transcribe/phone/db/entity/MessageEntity;", "equals", "other", "hashCode", "toString", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Entity
public final class MessageEntity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final MessageEntity EMPTY = new MessageEntity((Long) null, "", 0, 0, -1, 1, (DefaultConstructorMarker) null);
    @Nullable
    @PrimaryKey
    private Long id;
    @NotNull
    private String message;
    private final int owner;
    private long timestamp;
    private long transcribeId;
    @Ignore
    private boolean wraped;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/ar/transcribe/phone/db/entity/MessageEntity$Companion;", "", "<init>", "()V", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public MessageEntity(@Nullable Long l, @NotNull String str, int i, long j, long j2) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.id = l;
        this.message = str;
        this.owner = i;
        this.timestamp = j;
        this.transcribeId = j2;
    }

    public static /* synthetic */ MessageEntity copy$default(MessageEntity messageEntity, Long l, String str, int i, long j, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            l = messageEntity.id;
        }
        if ((i2 & 2) != 0) {
            str = messageEntity.message;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            i = messageEntity.owner;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            j = messageEntity.timestamp;
        }
        long j3 = j;
        if ((i2 & 16) != 0) {
            j2 = messageEntity.transcribeId;
        }
        return messageEntity.copy(l, str2, i3, j3, j2);
    }

    @Nullable
    public final Long component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.message;
    }

    public final int component3() {
        return this.owner;
    }

    public final long component4() {
        return this.timestamp;
    }

    public final long component5() {
        return this.transcribeId;
    }

    @NotNull
    public final MessageEntity copy(@Nullable Long l, @NotNull String str, int i, long j, long j2) {
        Intrinsics.checkNotNullParameter(str, "message");
        return new MessageEntity(l, str, i, j, j2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageEntity)) {
            return false;
        }
        MessageEntity messageEntity = (MessageEntity) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) messageEntity.id) && Intrinsics.areEqual((Object) this.message, (Object) messageEntity.message) && this.owner == messageEntity.owner && this.timestamp == messageEntity.timestamp && this.transcribeId == messageEntity.transcribeId;
    }

    @Nullable
    public final Long getId() {
        return this.id;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public final int getOwner() {
        return this.owner;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final long getTranscribeId() {
        return this.transcribeId;
    }

    public final boolean getWraped() {
        return this.wraped;
    }

    public int hashCode() {
        Long l = this.id;
        return ((((((((l == null ? 0 : l.hashCode()) * 31) + this.message.hashCode()) * 31) + Integer.hashCode(this.owner)) * 31) + Long.hashCode(this.timestamp)) * 31) + Long.hashCode(this.transcribeId);
    }

    public final void setId(@Nullable Long l) {
        this.id = l;
    }

    public final void setMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    public final void setTranscribeId(long j) {
        this.transcribeId = j;
    }

    public final void setWraped(boolean z) {
        this.wraped = z;
    }

    @NotNull
    public String toString() {
        Long l = this.id;
        String str = this.message;
        int i = this.owner;
        long j = this.timestamp;
        long j2 = this.transcribeId;
        return "MessageEntity(id=" + l + ", message=" + str + ", owner=" + i + ", timestamp=" + j + ", transcribeId=" + j2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageEntity(Long l, String str, int i, long j, long j2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : l, str, i, j, j2);
    }
}
