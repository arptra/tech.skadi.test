package com.upuphone.xr.sapp.contract;

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
@Retention(AnnotationRetention.SOURCE)
@java.lang.annotation.Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/upuphone/xr/sapp/contract/ProtocolCategory;", "", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@java.lang.annotation.Retention(RetentionPolicy.SOURCE)
public @interface ProtocolCategory {
    @NotNull
    public static final Companion Companion = Companion.f6700a;
    @NotNull
    public static final String FLYME = "flyme";
    @NotNull
    public static final String GLASS_AIR = "glass_air";
    @NotNull
    public static final String GLASS_STAR = "glass_star";
    @NotNull
    public static final String GLASS_VIEW = "glass_view";
    @NotNull
    public static final String LLM = "llm";
    @NotNull
    public static final String MYVU = "myvu";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/xr/sapp/contract/ProtocolCategory$Companion;", "", "<init>", "()V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f6700a = new Companion();
    }
}
