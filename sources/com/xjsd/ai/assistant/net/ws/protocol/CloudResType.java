package com.xjsd.ai.assistant.net.ws.protocol;

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
@Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER})
@Retention(AnnotationRetention.SOURCE)
@java.lang.annotation.Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/xjsd/ai/assistant/net/ws/protocol/CloudResType;", "", "Companion", "lib_assistant_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@java.lang.annotation.Retention(RetentionPolicy.SOURCE)
public @interface CloudResType {
    @NotNull
    public static final String ASR_RESULT = "asr_result";
    @NotNull
    public static final Companion Companion = Companion.f8510a;
    @NotNull
    public static final String INIT_RESULT = "init_result";
    @NotNull
    public static final String INPUT_SENSITIVE_RESULT = "sensitive_request";
    @NotNull
    public static final String LLM_ANSWER_RESULT = "llm_answer_result";
    @NotNull
    public static final String LLM_RECOMMEND_RESULT = "llm_recommend";
    @NotNull
    public static final String NLU_RESULT = "nlp_result";
    @NotNull
    public static final String OUTPUT_SENSITIVE_RESULT = "sensitive_result";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/xjsd/ai/assistant/net/ws/protocol/CloudResType$Companion;", "", "<init>", "()V", "lib_assistant_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f8510a = new Companion();
    }
}
