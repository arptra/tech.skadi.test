package com.upuphone.ar.transcribe.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001:\u0002\u0002\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/upuphone/ar/transcribe/annotation/IntlLanguageType;", "", "DstLangType", "SrcLangType", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Retention(AnnotationRetention.SOURCE)
@java.lang.annotation.Retention(RetentionPolicy.SOURCE)
public @interface IntlLanguageType {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/ar/transcribe/annotation/IntlLanguageType$DstLangType;", "", "<init>", "()V", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class DstLangType {

        /* renamed from: a  reason: collision with root package name */
        public static final DstLangType f6014a = new DstLangType();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/ar/transcribe/annotation/IntlLanguageType$SrcLangType;", "", "<init>", "()V", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class SrcLangType {

        /* renamed from: a  reason: collision with root package name */
        public static final SrcLangType f6015a = new SrcLangType();
    }
}
