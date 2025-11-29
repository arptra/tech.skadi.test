package com.xjmz.myvu.dialog.starrynet;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.here.posclient.analytics.TrackerEvent;
import com.honey.account.q9.d;
import com.honey.account.q9.e;
import com.honey.account.q9.f;
import com.honey.account.q9.g;
import com.honey.account.q9.h;
import com.honey.account.q9.i;
import com.honey.account.q9.j;
import com.honey.account.q9.k;
import com.honey.account.q9.l;
import com.honey.account.q9.m;
import com.meizu.common.widget.MzButton;
import com.upuphone.ar.fastrecord.R;
import com.upuphone.runasone.error.ConnectErrorCode;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.common.utils.tracker.Ring2TrackerConstant;
import com.upuphone.starrynet.core.dns.ErrorCode;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.StarryNetDeviceManager;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.databinding.DialogStarrynetConnectBinding;
import com.upuphone.xr.sapp.guide.model.ConnectResult;
import com.upuphone.xr.sapp.pag.LibPag;
import com.upuphone.xr.sapp.pag.PagParam;
import com.upuphone.xr.sapp.utils.ClickSpanHelper;
import com.upuphone.xr.sapp.utils.CustomFrameAnimation;
import com.upuphone.xr.sapp.utils.FlymeUtils;
import com.upuphone.xr.sapp.utils.StarryNetHelper;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.libpag.PAGImageView;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 D2\u00020\u0001:\u0001EB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0011J\u000f\u0010\u0016\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001c\u0010\u0017J\u0017\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010!\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020 H\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\bH\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020\bH\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b*\u0010\u001fJ!\u0010-\u001a\u00020\u000f2\b\u0010+\u001a\u0004\u0018\u00010$2\u0006\u0010,\u001a\u00020\u0018H\u0002¢\u0006\u0004\b-\u0010.J!\u00100\u001a\u00020 2\b\u0010/\u001a\u0004\u0018\u00010$2\u0006\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b0\u00101R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010\u001d\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u00188\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010B¨\u0006F"}, d2 = {"Lcom/xjmz/myvu/dialog/starrynet/StarryNetConnectDialog;", "Landroid/app/AlertDialog;", "Landroid/content/Context;", "context", "Lcom/xjmz/myvu/dialog/starrynet/ConnectDeviceInterFace;", "mConnectDeviceInterFace", "<init>", "(Landroid/content/Context;Lcom/xjmz/myvu/dialog/starrynet/ConnectDeviceInterFace;)V", "", "themeResId", "interFace", "(Landroid/content/Context;ILcom/xjmz/myvu/dialog/starrynet/ConnectDeviceInterFace;)V", "type", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "data", "", "r", "(ILcom/upuphone/xr/interconnect/entity/StarryNetDevice;)V", "Lcom/upuphone/xr/sapp/guide/model/ConnectResult;", "E", "(Lcom/upuphone/xr/sapp/guide/model/ConnectResult;)V", "D", "show", "()V", "", "isVisible", "G", "(Z)V", "o", "windowType", "s", "(I)V", "", "F", "(ILjava/lang/Object;)V", "errorCode", "", "m", "(I)Ljava/lang/String;", "error", "l", "(I)I", "y", "deviceModel", "animRepeat", "B", "(Ljava/lang/String;Z)V", "deviceInfo", "n", "(Ljava/lang/String;I)Ljava/lang/Object;", "Lcom/upuphone/xr/sapp/databinding/DialogStarrynetConnectBinding;", "a", "Lcom/upuphone/xr/sapp/databinding/DialogStarrynetConnectBinding;", "binding", "b", "Lcom/xjmz/myvu/dialog/starrynet/ConnectDeviceInterFace;", "c", "I", "d", "Lcom/upuphone/xr/interconnect/entity/StarryNetDevice;", "device", "Landroid/os/Handler;", "e", "Landroid/os/Handler;", "handler", "f", "Z", "mIsNavigationBar", "g", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nStarryNetConnectDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StarryNetConnectDialog.kt\ncom/xjmz/myvu/dialog/starrynet/StarryNetConnectDialog\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,519:1\n256#2,2:520\n256#2,2:522\n277#2,2:524\n256#2,2:526\n256#2,2:528\n256#2,2:530\n256#2,2:532\n256#2,2:534\n256#2,2:536\n256#2,2:538\n256#2,2:540\n256#2,2:542\n256#2,2:544\n256#2,2:546\n256#2,2:548\n256#2,2:550\n256#2,2:552\n256#2,2:554\n*S KotlinDebug\n*F\n+ 1 StarryNetConnectDialog.kt\ncom/xjmz/myvu/dialog/starrynet/StarryNetConnectDialog\n*L\n101#1:520,2\n102#1:522,2\n188#1:524,2\n189#1:526,2\n190#1:528,2\n191#1:530,2\n298#1:532,2\n299#1:534,2\n302#1:536,2\n303#1:538,2\n304#1:540,2\n305#1:542,2\n313#1:544,2\n314#1:546,2\n347#1:548,2\n348#1:550,2\n128#1:552,2\n506#1:554,2\n*E\n"})
public final class StarryNetConnectDialog extends AlertDialog {
    public static final Companion g = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public DialogStarrynetConnectBinding f8238a;
    public ConnectDeviceInterFace b;
    public int c;
    public StarryNetDevice d;
    public Handler e;
    public boolean f;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xjmz/myvu/dialog/starrynet/StarryNetConnectDialog$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StarryNetConnectDialog(Context context, ConnectDeviceInterFace connectDeviceInterFace) {
        this(context, R.style.LangPickerStyle, connectDeviceInterFace);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(connectDeviceInterFace, "mConnectDeviceInterFace");
    }

    public static final void A(StarryNetConnectDialog starryNetConnectDialog) {
        Intrinsics.checkNotNullParameter(starryNetConnectDialog, "this$0");
        View view = starryNetConnectDialog.f8238a.m;
        Intrinsics.checkNotNullExpressionValue(view, "dialogBottom");
        view.setVisibility(starryNetConnectDialog.f ^ true ? 0 : 8);
    }

    public static final void C(StarryNetConnectDialog starryNetConnectDialog, String str, boolean z) {
        Intrinsics.checkNotNullParameter(starryNetConnectDialog, "this$0");
        Object n = starryNetConnectDialog.n(str, starryNetConnectDialog.c);
        if (n instanceof Integer) {
            starryNetConnectDialog.f8238a.j.setVisibility(0);
            starryNetConnectDialog.f8238a.k.setVisibility(8);
            CustomFrameAnimation b2 = CustomFrameAnimation.d.b();
            int intValue = ((Number) n).intValue();
            ImageView imageView = starryNetConnectDialog.f8238a.j;
            Intrinsics.checkNotNullExpressionValue(imageView, "deviceImg");
            b2.h(intValue, imageView, z, (CustomFrameAnimation.IAnimState) null);
        } else if (n instanceof PagParam) {
            starryNetConnectDialog.f8238a.j.setVisibility(8);
            starryNetConnectDialog.f8238a.k.setVisibility(0);
            PAGImageView pAGImageView = starryNetConnectDialog.f8238a.k;
            Intrinsics.checkNotNullExpressionValue(pAGImageView, "devicePag");
            LibPag.a(pAGImageView, (PagParam) n);
        }
    }

    public static final void p(StarryNetConnectDialog starryNetConnectDialog, View view) {
        Intrinsics.checkNotNullParameter(starryNetConnectDialog, "this$0");
        starryNetConnectDialog.f8238a.q.setChecked(false);
        starryNetConnectDialog.dismiss();
    }

    public static final void q(StarryNetConnectDialog starryNetConnectDialog, View view) {
        Intrinsics.checkNotNullParameter(starryNetConnectDialog, "this$0");
        starryNetConnectDialog.f8238a.q.setChecked(false);
        starryNetConnectDialog.dismiss();
    }

    public static final void t(StarryNetConnectDialog starryNetConnectDialog, int i, View view) {
        Intrinsics.checkNotNullParameter(starryNetConnectDialog, "this$0");
        ConnectDeviceInterFace connectDeviceInterFace = starryNetConnectDialog.b;
        if (connectDeviceInterFace != null) {
            connectDeviceInterFace.a(i, Ring2TrackerConstant.MSG_BT_OFF);
        }
    }

    public static final void u(StarryNetConnectDialog starryNetConnectDialog, int i, View view) {
        Intrinsics.checkNotNullParameter(starryNetConnectDialog, "this$0");
        MainApplication.Companion companion = MainApplication.k;
        companion.m(true);
        companion.o(false);
        starryNetConnectDialog.f8238a.e.setVisibility(4);
        starryNetConnectDialog.f8238a.c.setVisibility(4);
        LinearLayout linearLayout = starryNetConnectDialog.f8238a.n;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "glassProtocol");
        linearLayout.setVisibility(8);
        starryNetConnectDialog.f8238a.l.setText(starryNetConnectDialog.getContext().getString(com.upuphone.xr.sapp.R.string.connecting));
        TextView textView = starryNetConnectDialog.f8238a.h;
        StarryNetDevice starryNetDevice = starryNetConnectDialog.d;
        String str = null;
        textView.setText(starryNetDevice != null ? starryNetDevice.getDeviceName() : null);
        StarryNetHelper.f7917a.k();
        StarryNetDeviceManager starryNetDeviceManager = InterconnectManager.getInstance().getStarryNetDeviceManager();
        StarryNetDevice starryNetDevice2 = starryNetConnectDialog.d;
        int connectDevice = starryNetDeviceManager.connectDevice(starryNetDevice2 != null ? starryNetDevice2.getDeviceId() : null);
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("StarryNetConnectDialog", "connectDevice code is: " + connectDevice);
        if (connectDevice != 202000) {
            StarryNetDevice starryNetDevice3 = starryNetConnectDialog.d;
            if (starryNetDevice3 != null) {
                str = starryNetDevice3.getDeviceId();
            }
            if (str == null) {
                str = "";
            }
            starryNetConnectDialog.F(i, new ConnectResult(false, str, starryNetConnectDialog.l(connectDevice)));
        }
    }

    public static final void v(StarryNetConnectDialog starryNetConnectDialog, int i, View view) {
        Intrinsics.checkNotNullParameter(starryNetConnectDialog, "this$0");
        ConnectDeviceInterFace connectDeviceInterFace = starryNetConnectDialog.b;
        if (connectDeviceInterFace != null) {
            connectDeviceInterFace.a(i, Ring2TrackerConstant.MSG_RING_EVENT_HANDLER);
        }
    }

    public static final void w(StarryNetConnectDialog starryNetConnectDialog, int i, View view) {
        Intrinsics.checkNotNullParameter(starryNetConnectDialog, "this$0");
        ConnectDeviceInterFace connectDeviceInterFace = starryNetConnectDialog.b;
        if (connectDeviceInterFace != null) {
            connectDeviceInterFace.a(i, Ring2TrackerConstant.MSG_BT_OFF);
        }
    }

    public static final void x(StarryNetConnectDialog starryNetConnectDialog, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(starryNetConnectDialog, "this$0");
        if (z) {
            starryNetConnectDialog.f8238a.e.setAlpha(1.0f);
            starryNetConnectDialog.f8238a.e.setEnabled(true);
            return;
        }
        starryNetConnectDialog.f8238a.e.setAlpha(0.5f);
        starryNetConnectDialog.f8238a.e.setEnabled(false);
    }

    public static final void z(StarryNetConnectDialog starryNetConnectDialog) {
        Intrinsics.checkNotNullParameter(starryNetConnectDialog, "this$0");
        if (starryNetConnectDialog.f8238a.g.getLineCount() == 1) {
            starryNetConnectDialog.f8238a.g.setGravity(1);
        } else {
            starryNetConnectDialog.f8238a.g.setGravity(3);
        }
    }

    public final void B(String str, boolean z) {
        new Handler(Looper.getMainLooper()).postDelayed(new k(this, str, z), 100);
    }

    public final void D(int i, StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "data");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c("StarryNetConnectDialog", "updateConnectState type = " + i + ",data =" + starryNetDevice);
        this.c = i;
        this.d = starryNetDevice;
        y(i);
        s(this.c);
    }

    public final void E(ConnectResult connectResult) {
        Intrinsics.checkNotNullParameter(connectResult, "data");
        F(132, connectResult);
    }

    public final void F(int i, Object obj) {
        Context context;
        int i2;
        if (i == 132) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.upuphone.xr.sapp.guide.model.ConnectResult");
            ConnectResult connectResult = (ConnectResult) obj;
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("StarryNetConnectDialog", "connectState is: " + connectResult);
            String m = m(connectResult.getMErrorCode());
            MzButton mzButton = this.f8238a.d;
            Intrinsics.checkNotNullExpressionValue(mzButton, "deviceConfirm");
            mzButton.setVisibility(connectResult.getMResult() ^ true ? 4 : 0);
            MzButton mzButton2 = this.f8238a.c;
            Intrinsics.checkNotNullExpressionValue(mzButton2, "deviceCancel");
            mzButton2.setVisibility(connectResult.getMResult() ^ true ? 0 : 8);
            MzButton mzButton3 = this.f8238a.e;
            Intrinsics.checkNotNullExpressionValue(mzButton3, "deviceConnect");
            mzButton3.setVisibility(connectResult.getMResult() ^ true ? 0 : 8);
            LinearLayout linearLayout = this.f8238a.n;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "glassProtocol");
            linearLayout.setVisibility(8);
            this.f8238a.d.setText(getContext().getString(com.upuphone.xr.sapp.R.string.text_done));
            this.f8238a.c.setText(getContext().getString(com.upuphone.xr.sapp.R.string.cancel));
            this.f8238a.e.setText(getContext().getString(com.upuphone.xr.sapp.R.string.reconnect));
            TextView textView = this.f8238a.h;
            if (connectResult.getMResult()) {
                m = getContext().getString(com.upuphone.xr.sapp.R.string.enjoy_your_ar_world);
            }
            textView.setText(m);
            TextView textView2 = this.f8238a.l;
            if (connectResult.getMResult()) {
                context = getContext();
                i2 = com.upuphone.xr.sapp.R.string.connect_success;
            } else {
                context = getContext();
                i2 = com.upuphone.xr.sapp.R.string.connect_fail;
            }
            textView2.setText(context.getString(i2));
            if (connectResult.getMResult()) {
                String deviceInfo = InterconnectManager.getInstance().getStarryNetDeviceManager().getDeviceInfo(connectResult.getMDeviceID(), 5);
                delegate.a("StarryNetConnectDialog", "getDeviceInfo deviceModel = " + deviceInfo);
                CustomFrameAnimation.Companion companion = CustomFrameAnimation.d;
                companion.b().p(true);
                Object n = n(deviceInfo, TrackerEvent.PositioningOfflineOutdoor);
                if (n instanceof Integer) {
                    this.f8238a.j.setVisibility(4);
                    this.f8238a.k.setVisibility(8);
                    CustomFrameAnimation b2 = companion.b();
                    int intValue = ((Number) n).intValue();
                    ImageView imageView = this.f8238a.j;
                    Intrinsics.checkNotNullExpressionValue(imageView, "deviceImg");
                    b2.h(intValue, imageView, false, (CustomFrameAnimation.IAnimState) null);
                } else if (n instanceof PagParam) {
                    this.f8238a.j.setVisibility(4);
                    this.f8238a.k.setVisibility(0);
                    PAGImageView pAGImageView = this.f8238a.k;
                    Intrinsics.checkNotNullExpressionValue(pAGImageView, "devicePag");
                    LibPag.a(pAGImageView, (PagParam) n);
                }
            }
        }
    }

    public final void G(boolean z) {
        this.f = z;
    }

    public final int l(int i) {
        switch (i) {
            case StErrorCode.CONNECT_STRATEGY_BLE_AUTH_TIMEOUT:
                return -300;
            case StErrorCode.CONNECT_STRATEGY_BLE_PARAM_ERROR:
            case StErrorCode.CONNECT_STRATEGY_BLE_CONNECT_PARAM_ERROR:
            case ConnectErrorCode.CONNECT_NOT_FOUND_DEVICEID:
                return ErrorCode.ERROR_START_DIS_EXCEPTION;
            default:
                return -100;
        }
    }

    public final String m(int i) {
        if (i == -300) {
            String string = getContext().getString(com.upuphone.xr.sapp.R.string.connect_timeout_please_retry);
            Intrinsics.checkNotNull(string);
            return string;
        } else if (i == -200) {
            String string2 = getContext().getString(com.upuphone.xr.sapp.R.string.connect_fail_please_retry);
            Intrinsics.checkNotNull(string2);
            return string2;
        } else if (i != -100) {
            String string3 = getContext().getString(com.upuphone.xr.sapp.R.string.connect_fail_please_retry);
            Intrinsics.checkNotNull(string3);
            return string3;
        } else {
            String string4 = getContext().getString(com.upuphone.xr.sapp.R.string.connect_fail_please_retry);
            Intrinsics.checkNotNull(string4);
            return string4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0052, code lost:
        if (r6.equals("1004") == false) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0056, code lost:
        if (r7 == 188) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0058, code lost:
        if (r7 == 189) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005a, code lost:
        if (r7 == 203) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005e, code lost:
        switch(r7) {
            case com.here.posclient.analytics.TrackerEvent.PositioningOfflineOutdoor :int: goto L_0x006d;
            case 132: goto L_0x0067;
            case 133: goto L_0x0075;
            default: goto L_0x0061;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0082, code lost:
        if (r6.equals("1003") == false) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0085, code lost:
        if (r7 == 188) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0087, code lost:
        if (r7 == 189) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0089, code lost:
        if (r7 == 203) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008d, code lost:
        switch(r7) {
            case com.here.posclient.analytics.TrackerEvent.PositioningOfflineOutdoor :int: goto L_0x009c;
            case 132: goto L_0x0096;
            case 133: goto L_0x00a4;
            default: goto L_0x0090;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b1, code lost:
        if (r6.equals("1002") == false) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ba, code lost:
        if (r6.equals("1001") != false) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bc, code lost:
        if (r7 == 188) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00be, code lost:
        if (r7 == 189) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c0, code lost:
        if (r7 == 203) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c4, code lost:
        switch(r7) {
            case com.here.posclient.analytics.TrackerEvent.PositioningOfflineOutdoor :int: goto L_0x00d3;
            case 132: goto L_0x00cd;
            case 133: goto L_0x00db;
            default: goto L_0x00c7;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return java.lang.Integer.valueOf(com.upuphone.xr.sapp.R.drawable.air_find_connect_other_anim);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return new com.upuphone.xr.sapp.pag.PagParam("ap_fail_bmp.pag", Integer.MAX_VALUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return new com.upuphone.xr.sapp.pag.PagParam("ap_fail_bmp.pag", Integer.MAX_VALUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        return new com.upuphone.xr.sapp.pag.PagParam("ap_success_bmp.pag", 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return java.lang.Integer.valueOf(com.upuphone.xr.sapp.R.drawable.air_find_connect_other_anim);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        return new com.upuphone.xr.sapp.pag.PagParam("a_fail_bmp.pag", Integer.MAX_VALUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return new com.upuphone.xr.sapp.pag.PagParam("a_fail_bmp.pag", Integer.MAX_VALUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return new com.upuphone.xr.sapp.pag.PagParam("a_success_bmp.pag", 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return java.lang.Integer.valueOf(com.upuphone.xr.sapp.R.drawable.star_find_connect_other_anim);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return new com.upuphone.xr.sapp.pag.PagParam("s_fail_bmp.pag", Integer.MAX_VALUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return new com.upuphone.xr.sapp.pag.PagParam("s_fail_bmp.pag", Integer.MAX_VALUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return new com.upuphone.xr.sapp.pag.PagParam("s_success_bmp.pag", 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x003e, code lost:
        if (r6.equals("5002") == false) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0048, code lost:
        if (r6.equals("5001") == false) goto L_0x00e2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n(java.lang.String r6, int r7) {
        /*
            r5 = this;
            com.upuphone.star.core.log.ULog$Delegate r5 = com.upuphone.star.core.log.ULog.f6446a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "deviceInfo is: "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r1 = " and windowType is: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "StarryNetConnectDialog"
            r5.a(r1, r0)
            if (r6 == 0) goto L_0x00e2
            int r5 = r6.hashCode()
            r0 = 1
            r1 = 203(0xcb, float:2.84E-43)
            r2 = 189(0xbd, float:2.65E-43)
            r3 = 188(0xbc, float:2.63E-43)
            r4 = 2147483647(0x7fffffff, float:NaN)
            switch(r5) {
                case 1507424: goto L_0x00b4;
                case 1507425: goto L_0x00ab;
                case 1507426: goto L_0x007c;
                case 1507427: goto L_0x004c;
                default: goto L_0x0033;
            }
        L_0x0033:
            switch(r5) {
                case 1626588: goto L_0x0042;
                case 1626589: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x00e2
        L_0x0038:
            java.lang.String r5 = "5002"
            boolean r5 = r6.equals(r5)
            if (r5 != 0) goto L_0x0056
            goto L_0x00e2
        L_0x0042:
            java.lang.String r5 = "5001"
            boolean r5 = r6.equals(r5)
            if (r5 != 0) goto L_0x0085
            goto L_0x00e2
        L_0x004c:
            java.lang.String r5 = "1004"
            boolean r5 = r6.equals(r5)
            if (r5 != 0) goto L_0x0056
            goto L_0x00e2
        L_0x0056:
            if (r7 == r3) goto L_0x0075
            if (r7 == r2) goto L_0x0075
            if (r7 == r1) goto L_0x0075
            java.lang.String r5 = "ap_fail_bmp.pag"
            switch(r7) {
                case 131: goto L_0x006d;
                case 132: goto L_0x0067;
                case 133: goto L_0x0075;
                default: goto L_0x0061;
            }
        L_0x0061:
            com.upuphone.xr.sapp.pag.PagParam r6 = new com.upuphone.xr.sapp.pag.PagParam
            r6.<init>(r5, r4)
            goto L_0x007b
        L_0x0067:
            com.upuphone.xr.sapp.pag.PagParam r6 = new com.upuphone.xr.sapp.pag.PagParam
            r6.<init>(r5, r4)
            goto L_0x007b
        L_0x006d:
            com.upuphone.xr.sapp.pag.PagParam r6 = new com.upuphone.xr.sapp.pag.PagParam
            java.lang.String r5 = "ap_success_bmp.pag"
            r6.<init>(r5, r0)
            goto L_0x007b
        L_0x0075:
            int r5 = com.upuphone.xr.sapp.R.drawable.air_find_connect_other_anim
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
        L_0x007b:
            return r6
        L_0x007c:
            java.lang.String r5 = "1003"
            boolean r5 = r6.equals(r5)
            if (r5 != 0) goto L_0x0085
            goto L_0x00e2
        L_0x0085:
            if (r7 == r3) goto L_0x00a4
            if (r7 == r2) goto L_0x00a4
            if (r7 == r1) goto L_0x00a4
            java.lang.String r5 = "a_fail_bmp.pag"
            switch(r7) {
                case 131: goto L_0x009c;
                case 132: goto L_0x0096;
                case 133: goto L_0x00a4;
                default: goto L_0x0090;
            }
        L_0x0090:
            com.upuphone.xr.sapp.pag.PagParam r6 = new com.upuphone.xr.sapp.pag.PagParam
            r6.<init>(r5, r4)
            goto L_0x00aa
        L_0x0096:
            com.upuphone.xr.sapp.pag.PagParam r6 = new com.upuphone.xr.sapp.pag.PagParam
            r6.<init>(r5, r4)
            goto L_0x00aa
        L_0x009c:
            com.upuphone.xr.sapp.pag.PagParam r6 = new com.upuphone.xr.sapp.pag.PagParam
            java.lang.String r5 = "a_success_bmp.pag"
            r6.<init>(r5, r0)
            goto L_0x00aa
        L_0x00a4:
            int r5 = com.upuphone.xr.sapp.R.drawable.air_find_connect_other_anim
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
        L_0x00aa:
            return r6
        L_0x00ab:
            java.lang.String r5 = "1002"
            boolean r5 = r6.equals(r5)
            if (r5 != 0) goto L_0x00bc
            goto L_0x00e2
        L_0x00b4:
            java.lang.String r5 = "1001"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x00e2
        L_0x00bc:
            if (r7 == r3) goto L_0x00db
            if (r7 == r2) goto L_0x00db
            if (r7 == r1) goto L_0x00db
            java.lang.String r5 = "s_fail_bmp.pag"
            switch(r7) {
                case 131: goto L_0x00d3;
                case 132: goto L_0x00cd;
                case 133: goto L_0x00db;
                default: goto L_0x00c7;
            }
        L_0x00c7:
            com.upuphone.xr.sapp.pag.PagParam r6 = new com.upuphone.xr.sapp.pag.PagParam
            r6.<init>(r5, r4)
            goto L_0x00e1
        L_0x00cd:
            com.upuphone.xr.sapp.pag.PagParam r6 = new com.upuphone.xr.sapp.pag.PagParam
            r6.<init>(r5, r4)
            goto L_0x00e1
        L_0x00d3:
            com.upuphone.xr.sapp.pag.PagParam r6 = new com.upuphone.xr.sapp.pag.PagParam
            java.lang.String r5 = "s_success_bmp.pag"
            r6.<init>(r5, r0)
            goto L_0x00e1
        L_0x00db:
            int r5 = com.upuphone.xr.sapp.R.drawable.star_find_connect_other_anim
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
        L_0x00e1:
            return r6
        L_0x00e2:
            r5 = -1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xjmz.myvu.dialog.starrynet.StarryNetConnectDialog.n(java.lang.String, int):java.lang.Object");
    }

    public final void o() {
        int i = this.c;
        if (i != 154) {
            if (!(i == 203 || i == 188 || i == 189)) {
                switch (i) {
                    case TrackerEvent.PositioningOfflineOutdoor /*131*/:
                    case 132:
                    case 133:
                        break;
                }
            }
            y(i);
            s(this.c);
        } else {
            LinearLayout linearLayout = this.f8238a.f;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "deviceConnectMain");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = this.f8238a.s;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "removeDeviceFromSetting");
            linearLayout2.setVisibility(0);
            this.f8238a.b.setOnClickListener(new l(this));
        }
        this.f8238a.c.setOnClickListener(new m(this));
    }

    public final void r(int i, StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(starryNetDevice, "data");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.c("StarryNetConnectDialog", "windowType = " + i + ",data = " + starryNetDevice);
        this.c = i;
        this.d = starryNetDevice;
        o();
    }

    public final void s(int i) {
        this.f8238a.d.setOnClickListener(new e(this, i));
        this.f8238a.e.setOnClickListener(new f(this, i));
        this.f8238a.c.setOnClickListener(new g(this, i));
        this.f8238a.g.setOnClickListener(new h(this, i));
        this.f8238a.q.setOnCheckedChangeListener(new i(this));
    }

    public void show() {
        super.show();
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(window.getAttributes());
            layoutParams.width = -1;
            window.setAttributes(layoutParams);
        }
        this.f8238a.getRoot().post(new d(this));
    }

    public final void y(int i) {
        String str;
        StarryNetDevice starryNetDevice = this.d;
        String str2 = "AR Glass";
        String str3 = null;
        if (starryNetDevice != null) {
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("StarryNetConnectDialog", "setDeviceConnectUI::StarryNetDevice is: " + starryNetDevice);
            StarryNetDevice starryNetDevice2 = this.d;
            str = starryNetDevice2 != null ? starryNetDevice2.getDeviceName() : null;
            if (str == null) {
                str = "unknown glass";
            }
            StarryNetDeviceManager starryNetDeviceManager = InterconnectManager.getInstance().getStarryNetDeviceManager();
            StarryNetDevice starryNetDevice3 = this.d;
            String deviceId = starryNetDevice3 != null ? starryNetDevice3.getDeviceId() : null;
            if (deviceId == null) {
                deviceId = "-1";
            }
            String deviceInfo = starryNetDeviceManager.getDeviceInfo(deviceId, 5);
            if (deviceInfo == null) {
                StarryNetDevice starryNetDevice4 = this.d;
                if (starryNetDevice4 != null) {
                    str3 = starryNetDevice4.getModelId();
                }
            } else {
                str3 = deviceInfo;
            }
            delegate.a("StarryNetConnectDialog", "setDeviceConnectUI::StarryNetDevice:deviceModel: " + str3);
        } else {
            str = str2;
        }
        LinearLayout linearLayout = this.f8238a.f;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "deviceConnectMain");
        boolean z = false;
        linearLayout.setVisibility(0);
        LinearLayout linearLayout2 = this.f8238a.s;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "removeDeviceFromSetting");
        linearLayout2.setVisibility(8);
        if (!(i == 188 || i == 189 || i == 203)) {
            switch (i) {
                case TrackerEvent.PositioningOfflineOutdoor /*131*/:
                    LinearLayout linearLayout3 = this.f8238a.o;
                    Intrinsics.checkNotNullExpressionValue(linearLayout3, "llBindDevice");
                    linearLayout3.setVisibility(8);
                    LinearLayout linearLayout4 = this.f8238a.p;
                    Intrinsics.checkNotNullExpressionValue(linearLayout4, "llBindOtherDevice");
                    linearLayout4.setVisibility(0);
                    TextView textView = this.f8238a.g;
                    Intrinsics.checkNotNullExpressionValue(textView, "deviceConnectOther");
                    textView.setVisibility(8);
                    MzButton mzButton = this.f8238a.d;
                    Intrinsics.checkNotNullExpressionValue(mzButton, "deviceConfirm");
                    mzButton.setVisibility(0);
                    str2 = getContext().getString(com.upuphone.xr.sapp.R.string.connect_title);
                    Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
                    this.f8238a.d.setText(getContext().getString(com.upuphone.xr.sapp.R.string.go_function));
                    break;
                case 132:
                    LinearLayout linearLayout5 = this.f8238a.o;
                    Intrinsics.checkNotNullExpressionValue(linearLayout5, "llBindDevice");
                    linearLayout5.setVisibility(0);
                    LinearLayout linearLayout6 = this.f8238a.p;
                    Intrinsics.checkNotNullExpressionValue(linearLayout6, "llBindOtherDevice");
                    linearLayout6.setVisibility(8);
                    this.f8238a.r.setMovementMethod(LinkMovementMethod.getInstance());
                    this.f8238a.r.setHighlightColor(0);
                    String string = getContext().getString(com.upuphone.xr.sapp.R.string.read_protocol_tips);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    String string2 = getContext().getString(com.upuphone.xr.sapp.R.string.superapp_privacy_policy);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    String string3 = getContext().getString(com.upuphone.xr.sapp.R.string.service_protocol_anchor);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    this.f8238a.r.setText(ClickSpanHelper.f7853a.a(string, CollectionsKt.arrayListOf(string2, string3), new StarryNetConnectDialog$setDeviceConnectUI$buildAgreementClickSpan$1(string3, this, i)));
                    this.f8238a.e.setEnabled(false);
                    str2 = getContext().getString(com.upuphone.xr.sapp.R.string.discover_ar_glass);
                    Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
                    if (!this.f8238a.q.isChecked()) {
                        this.f8238a.e.setAlpha(0.5f);
                        this.f8238a.e.setEnabled(false);
                        break;
                    } else {
                        this.f8238a.e.setAlpha(1.0f);
                        this.f8238a.e.setEnabled(true);
                        break;
                    }
                case 133:
                    break;
            }
        }
        LinearLayout linearLayout7 = this.f8238a.o;
        Intrinsics.checkNotNullExpressionValue(linearLayout7, "llBindDevice");
        linearLayout7.setVisibility(8);
        LinearLayout linearLayout8 = this.f8238a.p;
        Intrinsics.checkNotNullExpressionValue(linearLayout8, "llBindOtherDevice");
        linearLayout8.setVisibility(0);
        if (188 == i) {
            this.f8238a.g.setText(getContext().getString(com.upuphone.xr.sapp.R.string.connect_error_china_app_init_glass_ip_init));
        } else if (189 == i) {
            this.f8238a.g.setText(getContext().getString(com.upuphone.xr.sapp.R.string.connect_error_intl_app_china_glass));
        } else if (203 == i) {
            this.f8238a.g.setText(getContext().getString(com.upuphone.xr.sapp.R.string.connect_error_update_rom_for_fly_me));
        }
        this.f8238a.d.setText(getContext().getString(com.upuphone.xr.sapp.R.string.i_known));
        str2 = getContext().getString(com.upuphone.xr.sapp.R.string.discover_ar_glass);
        Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
        z = true;
        this.f8238a.l.setText(str2);
        this.f8238a.h.setText(str);
        B(str3, z);
        this.f8238a.g.post(new j(this));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StarryNetConnectDialog(Context context, int i, ConnectDeviceInterFace connectDeviceInterFace) {
        super(context, i);
        View decorView;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(connectDeviceInterFace, "interFace");
        this.e = new Handler(Looper.getMainLooper());
        this.b = connectDeviceInterFace;
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
        }
        DialogStarrynetConnectBinding c2 = DialogStarrynetConnectBinding.c(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(c2, "inflate(...)");
        this.f8238a = c2;
        setView(c2.getRoot());
        FlymeUtils.a(this.f8238a.getRoot(), context);
        Window window2 = getWindow();
        if (window2 != null && (decorView = window2.getDecorView()) != null) {
            decorView.setBackgroundColor(0);
        }
    }
}
