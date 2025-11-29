package com.upuphone.runasone.core.api.sys;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import org.jetbrains.annotations.NotNull;

@Target({ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.TYPE_PARAMETER})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/upuphone/runasone/core/api/sys/SysAction;", "", "Companion", "core-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Retention(AnnotationRetention.SOURCE)
@java.lang.annotation.Retention(RetentionPolicy.SOURCE)
public @interface SysAction {
    public static final int AUDIO_DEVICE_CHANGED = 8;
    public static final int CALLSTATE_CHANGED = 9;
    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int DIAL = 4;
    public static final int GET_AUDIOPLAY_DEVICE = 2;
    public static final int GET_BR_DEVICE_LIST = 11;
    public static final int GET_CALLSTATE = 3;
    public static final int OPERATE_ACTION = 5;
    public static final int PHONEBOOK_CHANGED = 10;
    public static final int REGISTER_CALLBACK = 6;
    public static final int SWITCH_AUDIO_DEVICE = 1;
    public static final int UNREGISTER_CALLBACK = 7;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/upuphone/runasone/core/api/sys/SysAction$Companion;", "", "()V", "AUDIO_DEVICE_CHANGED", "", "CALLSTATE_CHANGED", "DIAL", "GET_AUDIOPLAY_DEVICE", "GET_BR_DEVICE_LIST", "GET_CALLSTATE", "OPERATE_ACTION", "PHONEBOOK_CHANGED", "REGISTER_CALLBACK", "SWITCH_AUDIO_DEVICE", "UNREGISTER_CALLBACK", "core-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int AUDIO_DEVICE_CHANGED = 8;
        public static final int CALLSTATE_CHANGED = 9;
        public static final int DIAL = 4;
        public static final int GET_AUDIOPLAY_DEVICE = 2;
        public static final int GET_BR_DEVICE_LIST = 11;
        public static final int GET_CALLSTATE = 3;
        public static final int OPERATE_ACTION = 5;
        public static final int PHONEBOOK_CHANGED = 10;
        public static final int REGISTER_CALLBACK = 6;
        public static final int SWITCH_AUDIO_DEVICE = 1;
        public static final int UNREGISTER_CALLBACK = 7;

        private Companion() {
        }
    }
}
