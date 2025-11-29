package com.upuphone.ar.fastrecord.phone.starrynet.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import org.jetbrains.annotations.NotNull;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001:\u0002\u0002\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/starrynet/annotation/RecordInterConnectMsgCmd;", "", "Glass2Phone", "Phone2Glass", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Retention(AnnotationRetention.SOURCE)
@java.lang.annotation.Retention(RetentionPolicy.SOURCE)
public @interface RecordInterConnectMsgCmd {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/starrynet/annotation/RecordInterConnectMsgCmd$Glass2Phone;", "", "()V", "RECORD_REMOTE_AUDIO_DATA", "", "RECORD_SEND_CACHE_DATA", "RECORD_SEND_ERROR_CODE_DATA", "RECORD_STATUS_CHANGE", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Glass2Phone {
        @NotNull
        public static final Glass2Phone INSTANCE = new Glass2Phone();
        public static final int RECORD_REMOTE_AUDIO_DATA = 2;
        public static final int RECORD_SEND_CACHE_DATA = 3;
        public static final int RECORD_SEND_ERROR_CODE_DATA = 4;
        public static final int RECORD_STATUS_CHANGE = 1;

        private Glass2Phone() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/upuphone/ar/fastrecord/phone/starrynet/annotation/RecordInterConnectMsgCmd$Phone2Glass;", "", "()V", "RECORD_END_REC", "", "RECORD_FINISH_CACHE", "RECORD_REC_LOW_MEMORY", "RECORD_REC_PAUSE", "RECORD_REC_PRE_START", "RECORD_REC_RESUME", "RECORD_REC_RETRY_DOWNLOAD", "RECORD_REC_SEND_RECORD_ID", "RECORD_START_REC", "ar-fastrecord_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Phone2Glass {
        @NotNull
        public static final Phone2Glass INSTANCE = new Phone2Glass();
        public static final int RECORD_END_REC = 1002;
        public static final int RECORD_FINISH_CACHE = 1009;
        public static final int RECORD_REC_LOW_MEMORY = 1007;
        public static final int RECORD_REC_PAUSE = 1005;
        public static final int RECORD_REC_PRE_START = 1003;
        public static final int RECORD_REC_RESUME = 1006;
        public static final int RECORD_REC_RETRY_DOWNLOAD = 1004;
        public static final int RECORD_REC_SEND_RECORD_ID = 1008;
        public static final int RECORD_START_REC = 1001;

        private Phone2Glass() {
        }
    }
}
