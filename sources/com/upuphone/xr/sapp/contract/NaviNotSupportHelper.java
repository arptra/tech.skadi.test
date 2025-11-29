package com.upuphone.xr.sapp.contract;

import com.upuphone.xr.interconnect.checknavi.NaviNotSupportCallback;
import com.upuphone.xr.interconnect.listener.SendMessageListener;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.monitor.starry.StarryMessageHelper;
import com.upuphone.xr.sapp.monitor.starry.StarryNotificationBase;
import com.upuphone.xr.sapp.utils.ContextExtKt;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.xjsd.ai.assistant.skill.navigation.checknavi.VoiceCheckNaviSupportCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u00012\u00020\u0002:\u0001\u000bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\t¨\u0006\f"}, d2 = {"Lcom/upuphone/xr/sapp/contract/NaviNotSupportHelper;", "Lcom/upuphone/xr/interconnect/checknavi/NaviNotSupportCallback;", "Lcom/xjsd/ai/assistant/skill/navigation/checknavi/VoiceCheckNaviSupportCallback;", "<init>", "()V", "", "type", "", "a", "(I)V", "naviNotSupport", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class NaviNotSupportHelper implements NaviNotSupportCallback, VoiceCheckNaviSupportCallback {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f6695a = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\r\u001a\u00020\f8\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/upuphone/xr/sapp/contract/NaviNotSupportHelper$Companion;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/contract/NaviNotSupportHelper;", "a", "()Lcom/upuphone/xr/sapp/contract/NaviNotSupportHelper;", "", "OPEN_NAVI_FROM_GLASS", "I", "OPEN_NAVI_FROM_HOME_PAGE", "OPEN_NAVI_FROM_VOICE", "", "TAG", "Ljava/lang/String;", "Holder", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/upuphone/xr/sapp/contract/NaviNotSupportHelper$Companion$Holder;", "", "a", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
        public static final class Holder {

            /* renamed from: a  reason: collision with root package name */
            public static final C0025Companion f6696a = new C0025Companion((DefaultConstructorMarker) null);
            public static final NaviNotSupportHelper b = new NaviNotSupportHelper();

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/upuphone/xr/sapp/contract/NaviNotSupportHelper$Companion$Holder$Companion;", "", "<init>", "()V", "Lcom/upuphone/xr/sapp/contract/NaviNotSupportHelper;", "INSTANCE", "Lcom/upuphone/xr/sapp/contract/NaviNotSupportHelper;", "a", "()Lcom/upuphone/xr/sapp/contract/NaviNotSupportHelper;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
            /* renamed from: com.upuphone.xr.sapp.contract.NaviNotSupportHelper$Companion$Holder$Companion  reason: collision with other inner class name */
            public static final class C0025Companion {
                public /* synthetic */ C0025Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final NaviNotSupportHelper a() {
                    return Holder.b;
                }

                public C0025Companion() {
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NaviNotSupportHelper a() {
            return Holder.f6696a.a();
        }

        public Companion() {
        }
    }

    public void a(int i) {
        naviNotSupport(i);
    }

    public void naviNotSupport(int i) {
        String str;
        String str2;
        Boolean bool = BuildConfig.f6575a;
        Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
        boolean booleanValue = bool.booleanValue();
        if (i == 1) {
            if (!booleanValue) {
                str = MainApplication.k.d().getResources().getString(R.string.navi_not_support_for_cn_region);
            } else {
                String f = ReceiveLocationEventManager.f6703a.f();
                int hashCode = f.hashCode();
                if (hashCode != 66697) {
                    if (hashCode != 74606) {
                        if (hashCode == 81520 && f.equals("RUS")) {
                            str = MainApplication.k.d().getResources().getString(R.string.navi_not_support_for_russia);
                        }
                    } else if (f.equals("KOR")) {
                        str = MainApplication.k.d().getResources().getString(R.string.navi_not_support_for_korea);
                    }
                } else if (f.equals("CHN")) {
                    str = MainApplication.k.d().getResources().getString(R.string.navi_not_support_for_china);
                }
                str = MainApplication.k.d().getResources().getString(R.string.navi_not_support_for_cn_region);
            }
            Intrinsics.checkNotNull(str);
            ContextExtKt.h(str, 0, 2, (Object) null);
        } else if (i == 2 || i == 3) {
            if (!booleanValue) {
                str2 = GlobalExtKt.g(R.string.navi_not_support_for_cn_region, new Object[0]);
            } else {
                String f2 = ReceiveLocationEventManager.f6703a.f();
                int hashCode2 = f2.hashCode();
                if (hashCode2 != 66697) {
                    if (hashCode2 != 74606) {
                        if (hashCode2 == 81520 && f2.equals("RUS")) {
                            str2 = GlobalExtKt.g(R.string.navi_not_support_for_russia, new Object[0]);
                        }
                    } else if (f2.equals("KOR")) {
                        str2 = GlobalExtKt.g(R.string.navi_not_support_for_korea, new Object[0]);
                    }
                } else if (f2.equals("CHN")) {
                    str2 = GlobalExtKt.g(R.string.navi_not_support_for_china, new Object[0]);
                }
                str2 = GlobalExtKt.g(R.string.navi_not_support_for_cn_region, new Object[0]);
            }
            StarryMessageHelper.t(StarryMessageHelper.f7799a, (byte[]) null, new StarryNotificationBase("SHOW_TOAST", str2), (SendMessageListener) null, 5, (Object) null);
        }
    }
}
