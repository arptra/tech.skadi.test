package com.upuphone.xr.sapp.vu.utils;

import android.os.SystemClock;
import com.honey.account.constant.AccountConstantKt;
import com.upuphone.ar.translation.statemachine.annotation.MSG;
import com.upuphone.xr.sapp.entity.DeviceInfo;
import com.upuphone.xr.sapp.utils.DataTrackUtil;
import com.upuphone.xr.sapp.vu.vm.VuGlassesDeviceInfoModel;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003 !\"B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0015\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001cR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/upuphone/xr/sapp/vu/utils/ArSpaceReportHelper;", "", "<init>", "()V", "", "isAutoOpen", "", "h", "(Z)V", "Lcom/upuphone/xr/sapp/vu/utils/ArSpaceReportHelper$OpenArSpaceResult;", "result", "", "extra", "b", "(Lcom/upuphone/xr/sapp/vu/utils/ArSpaceReportHelper$OpenArSpaceResult;Ljava/lang/String;)V", "Lcom/upuphone/xr/sapp/vu/utils/ArSpaceReportHelper$ScreenshotResult;", "f", "(Lcom/upuphone/xr/sapp/vu/utils/ArSpaceReportHelper$ScreenshotResult;Ljava/lang/String;)V", "Lcom/upuphone/xr/sapp/vu/utils/ArSpaceReportHelper$ScreenRecordResult;", "", "duration", "d", "(Lcom/upuphone/xr/sapp/vu/utils/ArSpaceReportHelper$ScreenRecordResult;JLjava/lang/String;)V", "eventName", "", "attributes", "a", "(Ljava/lang/String;Ljava/util/Map;)V", "J", "startOpenArSpaceTime", "c", "Z", "OpenArSpaceResult", "ScreenRecordResult", "ScreenshotResult", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class ArSpaceReportHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final ArSpaceReportHelper f8088a = new ArSpaceReportHelper();
    public static long b;
    public static boolean c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/upuphone/xr/sapp/vu/utils/ArSpaceReportHelper$OpenArSpaceResult;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "SUCCESS", "INTL_NOT_SUPPORT", "UPDATING", "NO_PERMISSION", "DISPLAY_INVALID", "DISPLAY_NOT_READY", "GLASSES_NOT_CONNECT", "OPENING", "DISPLAY_CHIP_NOT_READY", "SET_3D_MODE_ERROR", "DOUBLE_CHECK_USB_FAIL", "CANCELED", "APP_BACKGROUND", "CANNOT_START_ACTIVITY", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum OpenArSpaceResult {
        SUCCESS(0),
        INTL_NOT_SUPPORT(1000),
        UPDATING(1001),
        NO_PERMISSION(1002),
        DISPLAY_INVALID(1003),
        DISPLAY_NOT_READY(1004),
        GLASSES_NOT_CONNECT(1005),
        OPENING(MSG.MSG_PREPARING_SUCCESS),
        DISPLAY_CHIP_NOT_READY(MSG.MSG_IFLY_CONNECT_FAILED),
        SET_3D_MODE_ERROR(MSG.MSG_PREPARING_RETRY),
        DOUBLE_CHECK_USB_FAIL(MSG.MSG_PREPARING_SHOW_WAITING),
        CANCELED(MSG.MSG_PREPARING_HINT_WAITING),
        APP_BACKGROUND(2006),
        CANNOT_START_ACTIVITY(2007);
        
        private final int code;

        static {
            OpenArSpaceResult[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
        }

        private OpenArSpaceResult(int i) {
            this.code = i;
        }

        @NotNull
        public static EnumEntries<OpenArSpaceResult> getEntries() {
            return $ENTRIES;
        }

        public final int getCode() {
            return this.code;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/upuphone/xr/sapp/vu/utils/ArSpaceReportHelper$ScreenRecordResult;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "SUCCESS", "AR_SPACE_NOT_READY", "SCREEN_RECORDING", "FILE_NOT_EXIST", "FILE_SAVE_ERROR", "NO_PERMISSION", "NOT_AUTHORIZE", "ERROR", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum ScreenRecordResult {
        SUCCESS(0),
        AR_SPACE_NOT_READY(1000),
        SCREEN_RECORDING(1001),
        FILE_NOT_EXIST(1002),
        FILE_SAVE_ERROR(1003),
        NO_PERMISSION(1004),
        NOT_AUTHORIZE(1005),
        ERROR(2000);
        
        private final int code;

        static {
            ScreenRecordResult[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
        }

        private ScreenRecordResult(int i) {
            this.code = i;
        }

        @NotNull
        public static EnumEntries<ScreenRecordResult> getEntries() {
            return $ENTRIES;
        }

        public final int getCode() {
            return this.code;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/upuphone/xr/sapp/vu/utils/ArSpaceReportHelper$ScreenshotResult;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "SUCCESS", "AR_SPACE_NOT_READY", "SCREEN_RECORDING", "FILE_NOT_EXIST", "FILE_SAVE_ERROR", "ERROR", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum ScreenshotResult {
        SUCCESS(0),
        AR_SPACE_NOT_READY(1000),
        SCREEN_RECORDING(1001),
        FILE_NOT_EXIST(1002),
        FILE_SAVE_ERROR(1003),
        ERROR(2000);
        
        private final int code;

        static {
            ScreenshotResult[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) $values);
        }

        private ScreenshotResult(int i) {
            this.code = i;
        }

        @NotNull
        public static EnumEntries<ScreenshotResult> getEntries() {
            return $ENTRIES;
        }

        public final int getCode() {
            return this.code;
        }
    }

    public static /* synthetic */ void c(ArSpaceReportHelper arSpaceReportHelper, OpenArSpaceResult openArSpaceResult, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        arSpaceReportHelper.b(openArSpaceResult, str);
    }

    public static /* synthetic */ void e(ArSpaceReportHelper arSpaceReportHelper, ScreenRecordResult screenRecordResult, long j, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        if ((i & 4) != 0) {
            str = "";
        }
        arSpaceReportHelper.d(screenRecordResult, j, str);
    }

    public static /* synthetic */ void g(ArSpaceReportHelper arSpaceReportHelper, ScreenshotResult screenshotResult, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        arSpaceReportHelper.f(screenshotResult, str);
    }

    public final void a(String str, Map map) {
        DeviceInfo d = VuGlassesDeviceInfoModel.f8112a.d();
        DataTrackUtil dataTrackUtil = DataTrackUtil.f7875a;
        String serialNo = d.getSerialNo();
        if (serialNo == null) {
            serialNo = "";
        }
        DataTrackUtil.m(dataTrackUtil, str, map, dataTrackUtil.f(serialNo), d.getModel(), d.getRomVersion(), false, 32, (Object) null);
    }

    public final void b(OpenArSpaceResult openArSpaceResult, String str) {
        Intrinsics.checkNotNullParameter(openArSpaceResult, "result");
        Intrinsics.checkNotNullParameter(str, "extra");
        long elapsedRealtime = SystemClock.elapsedRealtime() - b;
        String lowerCase = openArSpaceResult.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String replace$default = StringsKt.replace$default(lowerCase, AccountConstantKt.DEFAULT_SEGMENT, " ", false, 4, (Object) null);
        if (str.length() > 0) {
            replace$default = replace$default + " " + str;
        }
        a("open_ar_space", MapsKt.mapOf(TuplesKt.to("auto_open", Integer.valueOf(c ? 1 : 0)), TuplesKt.to("result", Integer.valueOf(openArSpaceResult.getCode())), TuplesKt.to("error_msg", replace$default), TuplesKt.to(RtspHeaders.Values.TIME, Long.valueOf(elapsedRealtime))));
    }

    public final void d(ScreenRecordResult screenRecordResult, long j, String str) {
        Intrinsics.checkNotNullParameter(screenRecordResult, "result");
        Intrinsics.checkNotNullParameter(str, "extra");
        String lowerCase = screenRecordResult.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String replace$default = StringsKt.replace$default(lowerCase, AccountConstantKt.DEFAULT_SEGMENT, " ", false, 4, (Object) null);
        if (str.length() > 0) {
            replace$default = replace$default + " " + str;
        }
        a("screen_record", MapsKt.mapOf(TuplesKt.to("result", Integer.valueOf(screenRecordResult.getCode())), TuplesKt.to(RtspHeaders.Values.TIME, Long.valueOf(j)), TuplesKt.to("error_msg", replace$default)));
    }

    public final void f(ScreenshotResult screenshotResult, String str) {
        Intrinsics.checkNotNullParameter(screenshotResult, "result");
        Intrinsics.checkNotNullParameter(str, "extra");
        String lowerCase = screenshotResult.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String replace$default = StringsKt.replace$default(lowerCase, AccountConstantKt.DEFAULT_SEGMENT, " ", false, 4, (Object) null);
        if (str.length() > 0) {
            replace$default = replace$default + " " + str;
        }
        a("screenshot", MapsKt.mapOf(TuplesKt.to("result", Integer.valueOf(screenshotResult.getCode())), TuplesKt.to("error_msg", replace$default)));
    }

    public final void h(boolean z) {
        c = z;
        b = SystemClock.elapsedRealtime();
    }
}
