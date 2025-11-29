package com.upuphone.xr.sapp.common;

import androidx.annotation.Keep;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import org.jetbrains.annotations.NotNull;

@Keep
@Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER})
@Retention(AnnotationRetention.BINARY)
@java.lang.annotation.Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/upuphone/xr/sapp/common/BrightAndVolType;", "", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@java.lang.annotation.Retention(RetentionPolicy.CLASS)
public @interface BrightAndVolType {
    @NotNull
    public static final Companion Companion = Companion.f6655a;
    @NotNull
    public static final String DEVICES_CONNECT = "DEVICES_CONNECT";
    @NotNull
    public static final String DEVICES_DISCONNECT = "DEVICES_DISCONNECT";
    @NotNull
    public static final String HIDE_ALL = "HIDE_ALL";
    @NotNull
    public static final String INIT_STATE = "INIT_STATE";
    @NotNull
    public static final String SHOW_BRIGHT_SEEKBAR = "SHOW_BRIGHT_SEEKBAR";
    @NotNull
    public static final String SHOW_BRIGHT_UI = "SHOW_BRIGHT_UI";
    @NotNull
    public static final String SHOW_VOL_SEEKBAR = "SHOW_VOL_SEEKBAR";
    @NotNull
    public static final String SHOW_VOL_UI = "SHOW_VOL_UI";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/xr/sapp/common/BrightAndVolType$Companion;", "", "<init>", "()V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f6655a = new Companion();
    }
}
