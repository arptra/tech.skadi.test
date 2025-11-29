package com.upuphone.ai.ttsengine.base.bean;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.collections.CollectionsKt;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0005\b\u0002\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/bean/EmotionType;", "", "<init>", "()V", "a", "Companion", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
@Retention(AnnotationRetention.SOURCE)
@java.lang.annotation.Retention(RetentionPolicy.SOURCE)
public @interface EmotionType {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f5495a = Companion.f5496a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/upuphone/ai/ttsengine/base/bean/EmotionType$Companion;", "", "<init>", "()V", "", "", "b", "Ljava/util/List;", "a", "()Ljava/util/List;", "emotions", "aar_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f5496a = new Companion();
        public static final List b = CollectionsKt.listOf("neutral", "happy", "sad", "angry", "scare", "hate", "surprise");

        public final List a() {
            return b;
        }
    }
}
