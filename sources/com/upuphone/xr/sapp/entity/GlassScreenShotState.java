package com.upuphone.xr.sapp.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassScreenShotState;", "", "()V", "Idle", "Running", "Success", "Lcom/upuphone/xr/sapp/entity/GlassScreenShotState$Idle;", "Lcom/upuphone/xr/sapp/entity/GlassScreenShotState$Running;", "Lcom/upuphone/xr/sapp/entity/GlassScreenShotState$Success;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class GlassScreenShotState {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassScreenShotState$Idle;", "Lcom/upuphone/xr/sapp/entity/GlassScreenShotState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Idle extends GlassScreenShotState {
        @NotNull
        public static final Idle INSTANCE = new Idle();

        private Idle() {
            super((DefaultConstructorMarker) null);
        }

        public boolean equals(@Nullable Object obj) {
            return this == obj || (obj instanceof Idle);
        }

        public int hashCode() {
            return 1225010881;
        }

        @NotNull
        public String toString() {
            return "Idle";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassScreenShotState$Running;", "Lcom/upuphone/xr/sapp/entity/GlassScreenShotState;", "taskId", "", "progress", "", "(Ljava/lang/String;I)V", "getProgress", "()I", "getTaskId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Running extends GlassScreenShotState {
        private final int progress;
        @Nullable
        private final String taskId;

        public Running(@Nullable String str, int i) {
            super((DefaultConstructorMarker) null);
            this.taskId = str;
            this.progress = i;
        }

        public static /* synthetic */ Running copy$default(Running running, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = running.taskId;
            }
            if ((i2 & 2) != 0) {
                i = running.progress;
            }
            return running.copy(str, i);
        }

        @Nullable
        public final String component1() {
            return this.taskId;
        }

        public final int component2() {
            return this.progress;
        }

        @NotNull
        public final Running copy(@Nullable String str, int i) {
            return new Running(str, i);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Running)) {
                return false;
            }
            Running running = (Running) obj;
            return Intrinsics.areEqual((Object) this.taskId, (Object) running.taskId) && this.progress == running.progress;
        }

        public final int getProgress() {
            return this.progress;
        }

        @Nullable
        public final String getTaskId() {
            return this.taskId;
        }

        public int hashCode() {
            String str = this.taskId;
            return ((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.progress);
        }

        @NotNull
        public String toString() {
            String str = this.taskId;
            int i = this.progress;
            return "Running(taskId=" + str + ", progress=" + i + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/entity/GlassScreenShotState$Success;", "Lcom/upuphone/xr/sapp/entity/GlassScreenShotState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Success extends GlassScreenShotState {
        @NotNull
        public static final Success INSTANCE = new Success();

        private Success() {
            super((DefaultConstructorMarker) null);
        }

        public boolean equals(@Nullable Object obj) {
            return this == obj || (obj instanceof Success);
        }

        public int hashCode() {
            return 725569014;
        }

        @NotNull
        public String toString() {
            return "Success";
        }
    }

    public /* synthetic */ GlassScreenShotState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private GlassScreenShotState() {
    }
}
