package com.upuphone.ai.ttsengine;

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
@Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD})
@Retention(AnnotationRetention.SOURCE)
@java.lang.annotation.Target({ElementType.FIELD, ElementType.PARAMETER})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/upuphone/ai/ttsengine/VoiceType;", "", "Companion", "aar_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@java.lang.annotation.Retention(RetentionPolicy.SOURCE)
public @interface VoiceType {
    @NotNull
    public static final String BT_BV700 = "BV700_streaming";
    @NotNull
    public static final Companion Companion = Companion.f5491a;
    @NotNull
    public static final String GOOGLE = "google";
    @NotNull
    public static final String MN_CUTE_BOY = "cute_boy";
    @NotNull
    public static final String MN_FEMALE_TIANMEI = "female-tianmei";
    @NotNull
    public static final String MN_FEMALE_YUJIE = "female-yujie";
    @NotNull
    public static final String MN_MALE_QN = "male-qn-qingse";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/ai/ttsengine/VoiceType$Companion;", "", "<init>", "()V", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f5491a = new Companion();
    }
}
