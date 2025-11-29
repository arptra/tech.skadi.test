package com.upuphone.ar.transcribe.constants;

import com.upuphone.ar.transcribe.interconnect.TransInterConnectManager;
import com.upuphone.xr.interconnect.entity.NaviLocationInfo;
import com.upuphone.xr.sapp.context.SdkContext;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u001e\u001f B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u0006J\r\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0006J\r\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0006J\r\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0006J\r\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0006J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u0015J\r\u0010\u001a\u001a\u00020\u0013¢\u0006\u0004\b\u001a\u0010\u0015J\u001b\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/upuphone/ar/transcribe/constants/TranscribeConstants;", "", "<init>", "()V", "", "g", "()Z", "o", "l", "p", "n", "", "b", "()I", "j", "k", "h", "i", "m", "", "d", "()Ljava/lang/String;", "Lcom/upuphone/xr/interconnect/entity/NaviLocationInfo;", "e", "()Lcom/upuphone/xr/interconnect/entity/NaviLocationInfo;", "a", "c", "", "f", "()Ljava/util/Map;", "GlassModel", "IflytekCallbackMark", "TransRecordType", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class TranscribeConstants {

    /* renamed from: a  reason: collision with root package name */
    public static final TranscribeConstants f6027a = new TranscribeConstants();

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/transcribe/constants/TranscribeConstants$GlassModel;", "", "<init>", "()V", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface GlassModel {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/ar/transcribe/constants/TranscribeConstants$GlassModel$Companion;", "", "<init>", "()V", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class Companion {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ Companion f6028a = new Companion();
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/transcribe/constants/TranscribeConstants$IflytekCallbackMark;", "", "<init>", "()V", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface IflytekCallbackMark {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/ar/transcribe/constants/TranscribeConstants$IflytekCallbackMark$Companion;", "", "<init>", "()V", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class Companion {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ Companion f6029a = new Companion();
        }
    }

    @Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.CLASS, AnnotationTarget.VALUE_PARAMETER})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/upuphone/ar/transcribe/constants/TranscribeConstants$TransRecordType;", "", "<init>", "()V", "Companion", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface TransRecordType {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/ar/transcribe/constants/TranscribeConstants$TransRecordType$Companion;", "", "<init>", "()V", "ar-transcribe_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class Companion {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ Companion f6030a = new Companion();
        }
    }

    public static final int b() {
        return TransInterConnectManager.y.a().n();
    }

    public static final boolean g() {
        return TransInterConnectManager.y.a().q() || p() || f6027a.j();
    }

    public static final boolean l() {
        return TransInterConnectManager.y.a().s();
    }

    public static final boolean n() {
        return TransInterConnectManager.y.a().v() || SdkContext.f6675a.c().f();
    }

    public static final boolean o() {
        return TransInterConnectManager.y.a().w();
    }

    public static final boolean p() {
        return false;
    }

    public final String a() {
        return SdkContext.f6675a.e().d();
    }

    public final String c() {
        Map f = f();
        if (f.isEmpty()) {
            return "cnen";
        }
        String a2 = a();
        for (Map.Entry entry : f.entrySet()) {
            String str = (String) entry.getValue();
            if (Intrinsics.areEqual((Object) a2, (Object) (String) entry.getKey())) {
                return str;
            }
        }
        return "cnen";
    }

    public final String d() {
        return m() ? "国际版" : "国内版";
    }

    public final NaviLocationInfo e() {
        return TransInterConnectManager.y.a().o();
    }

    public final Map f() {
        HashMap hashMap = new HashMap();
        hashMap.put("zh-CN", "cn");
        hashMap.put("en-US", "cnen");
        hashMap.put("ms-MY", "ms");
        hashMap.put("th-TH", "th");
        hashMap.put("id-ID", "id");
        return hashMap;
    }

    public final boolean h() {
        return g() && i();
    }

    public final boolean i() {
        int b = b();
        return b != 0 && b <= 2;
    }

    public final boolean j() {
        return TransInterConnectManager.y.a().r() || SdkContext.f6675a.e().isAirPro();
    }

    public final boolean k() {
        return SdkContext.f6675a.c().d();
    }

    public final boolean m() {
        return SdkContext.f6675a.c().e();
    }
}
