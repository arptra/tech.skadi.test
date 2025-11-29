package com.upuphone.xr.sapp.utils;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/upuphone/xr/sapp/utils/GenericWindowResult;", "", "()V", "ButtonAction", "JumpAction", "Lcom/upuphone/xr/sapp/utils/GenericWindowResult$ButtonAction;", "Lcom/upuphone/xr/sapp/utils/GenericWindowResult$JumpAction;", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Keep
public abstract class GenericWindowResult {

    @Keep
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/utils/GenericWindowResult$ButtonAction;", "Lcom/upuphone/xr/sapp/utils/GenericWindowResult;", "windowType", "", "actionType", "(II)V", "getActionType", "()I", "getWindowType", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ButtonAction extends GenericWindowResult {
        private final int actionType;
        private final int windowType;

        public ButtonAction(int i, int i2) {
            super((DefaultConstructorMarker) null);
            this.windowType = i;
            this.actionType = i2;
        }

        public static /* synthetic */ ButtonAction copy$default(ButtonAction buttonAction, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = buttonAction.windowType;
            }
            if ((i3 & 2) != 0) {
                i2 = buttonAction.actionType;
            }
            return buttonAction.copy(i, i2);
        }

        public final int component1() {
            return this.windowType;
        }

        public final int component2() {
            return this.actionType;
        }

        @NotNull
        public final ButtonAction copy(int i, int i2) {
            return new ButtonAction(i, i2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ButtonAction)) {
                return false;
            }
            ButtonAction buttonAction = (ButtonAction) obj;
            return this.windowType == buttonAction.windowType && this.actionType == buttonAction.actionType;
        }

        public final int getActionType() {
            return this.actionType;
        }

        public final int getWindowType() {
            return this.windowType;
        }

        public int hashCode() {
            return (Integer.hashCode(this.windowType) * 31) + Integer.hashCode(this.actionType);
        }

        @NotNull
        public String toString() {
            int i = this.windowType;
            int i2 = this.actionType;
            return "ButtonAction(windowType=" + i + ", actionType=" + i2 + ")";
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/upuphone/xr/sapp/utils/GenericWindowResult$JumpAction;", "Lcom/upuphone/xr/sapp/utils/GenericWindowResult;", "windowType", "", "data", "", "(ILjava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "getWindowType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class JumpAction extends GenericWindowResult {
        @Nullable
        private final Object data;
        private final int windowType;

        public JumpAction(int i, @Nullable Object obj) {
            super((DefaultConstructorMarker) null);
            this.windowType = i;
            this.data = obj;
        }

        public static /* synthetic */ JumpAction copy$default(JumpAction jumpAction, int i, Object obj, int i2, Object obj2) {
            if ((i2 & 1) != 0) {
                i = jumpAction.windowType;
            }
            if ((i2 & 2) != 0) {
                obj = jumpAction.data;
            }
            return jumpAction.copy(i, obj);
        }

        public final int component1() {
            return this.windowType;
        }

        @Nullable
        public final Object component2() {
            return this.data;
        }

        @NotNull
        public final JumpAction copy(int i, @Nullable Object obj) {
            return new JumpAction(i, obj);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof JumpAction)) {
                return false;
            }
            JumpAction jumpAction = (JumpAction) obj;
            return this.windowType == jumpAction.windowType && Intrinsics.areEqual(this.data, jumpAction.data);
        }

        @Nullable
        public final Object getData() {
            return this.data;
        }

        public final int getWindowType() {
            return this.windowType;
        }

        public int hashCode() {
            int hashCode = Integer.hashCode(this.windowType) * 31;
            Object obj = this.data;
            return hashCode + (obj == null ? 0 : obj.hashCode());
        }

        @NotNull
        public String toString() {
            int i = this.windowType;
            Object obj = this.data;
            return "JumpAction(windowType=" + i + ", data=" + obj + ")";
        }
    }

    public /* synthetic */ GenericWindowResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private GenericWindowResult() {
    }
}
