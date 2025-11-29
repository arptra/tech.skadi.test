package com.upuphone.xr.sapp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.alibaba.fastjson.asm.Opcodes;
import com.here.posclient.analytics.TrackerEvent;
import com.honey.account.x8.h;
import com.honey.account.x8.i;
import com.honey.account.x8.j;
import com.honey.account.x8.k;
import com.honey.account.x8.l;
import com.honey.account.x8.n;
import com.honey.account.x8.o;
import com.honey.account.x8.p;
import com.honey.account.x8.q;
import com.honey.account.x8.r;
import com.honey.account.x8.s;
import com.honey.account.x8.t;
import com.honey.account.x8.u;
import com.meizu.common.widget.MzButton;
import com.meizu.flyme.policy.sdk.config.PolicySdkConstants;
import com.upuphone.runasone.error.ConnectErrorCode;
import com.upuphone.runasone.uupcast.CaptureType;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynet.api.StErrorCode;
import com.upuphone.starrynet.common.utils.tracker.Ring2TrackerConstant;
import com.upuphone.starrynet.core.dns.ErrorCode;
import com.upuphone.xr.interconnect.InterconnectManager;
import com.upuphone.xr.interconnect.api.StarryNetDeviceManager;
import com.upuphone.xr.interconnect.entity.StarryNetDevice;
import com.upuphone.xr.sapp.BuildConfig;
import com.upuphone.xr.sapp.MainApplication;
import com.upuphone.xr.sapp.R;
import com.upuphone.xr.sapp.contract.ProtocolType;
import com.upuphone.xr.sapp.databinding.GenericWindowBinding;
import com.upuphone.xr.sapp.entity.AppUpdateInfo;
import com.upuphone.xr.sapp.entity.NetDevice;
import com.upuphone.xr.sapp.entity.PermissionNote;
import com.upuphone.xr.sapp.guide.model.ConnectResult;
import com.upuphone.xr.sapp.guide.model.PasswordInfo;
import com.upuphone.xr.sapp.pag.LibPag;
import com.upuphone.xr.sapp.pag.PagParam;
import com.upuphone.xr.sapp.utils.BuglyManager;
import com.upuphone.xr.sapp.utils.ControlUtils;
import com.upuphone.xr.sapp.utils.CustomFrameAnimation;
import com.upuphone.xr.sapp.utils.DataStoreUtils;
import com.upuphone.xr.sapp.utils.FileSizeExtKt;
import com.upuphone.xr.sapp.utils.GlobalExtKt;
import com.upuphone.xr.sapp.utils.SuperFunctionUtils;
import com.upuphone.xr.sapp.view.popup.GenericWindowViewContainer;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.libpag.PAGImageView;

@SourceDebugExtension({"SMAP\nGenericWindowView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GenericWindowView.kt\ncom/upuphone/xr/sapp/view/GenericWindowView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,2045:1\n256#2,2:2046\n256#2,2:2048\n256#2,2:2050\n256#2,2:2052\n256#2,2:2054\n256#2,2:2056\n256#2,2:2058\n256#2,2:2060\n256#2,2:2062\n256#2,2:2064\n256#2,2:2066\n256#2,2:2068\n256#2,2:2070\n256#2,2:2072\n256#2,2:2074\n256#2,2:2076\n256#2,2:2078\n256#2,2:2080\n256#2,2:2082\n277#2,2:2084\n256#2,2:2086\n256#2,2:2088\n256#2,2:2090\n256#2,2:2092\n256#2,2:2094\n256#2,2:2096\n256#2,2:2098\n256#2,2:2100\n256#2,2:2102\n277#2,2:2104\n256#2,2:2106\n256#2,2:2108\n256#2,2:2110\n256#2,2:2112\n256#2,2:2114\n256#2,2:2116\n256#2,2:2118\n256#2,2:2120\n256#2,2:2122\n256#2,2:2124\n256#2,2:2126\n256#2,2:2128\n256#2,2:2130\n256#2,2:2132\n256#2,2:2134\n256#2,2:2136\n256#2,2:2138\n256#2,2:2140\n256#2,2:2142\n256#2,2:2144\n256#2,2:2146\n256#2,2:2148\n256#2,2:2150\n256#2,2:2152\n256#2,2:2154\n256#2,2:2156\n256#2,2:2158\n256#2,2:2160\n256#2,2:2162\n256#2,2:2164\n256#2,2:2166\n256#2,2:2168\n256#2,2:2170\n256#2,2:2172\n256#2,2:2174\n256#2,2:2176\n256#2,2:2178\n256#2,2:2180\n256#2,2:2182\n256#2,2:2184\n256#2,2:2186\n256#2,2:2188\n256#2,2:2190\n256#2,2:2192\n256#2,2:2194\n256#2,2:2196\n256#2,2:2198\n256#2,2:2200\n256#2,2:2202\n256#2,2:2204\n256#2,2:2206\n256#2,2:2208\n256#2,2:2210\n256#2,2:2212\n256#2,2:2214\n256#2,2:2216\n256#2,2:2218\n256#2,2:2220\n256#2,2:2222\n256#2,2:2224\n256#2,2:2226\n256#2,2:2228\n256#2,2:2230\n256#2,2:2232\n256#2,2:2234\n256#2,2:2236\n256#2,2:2238\n256#2,2:2240\n256#2,2:2242\n256#2,2:2244\n256#2,2:2246\n256#2,2:2248\n256#2,2:2250\n256#2,2:2252\n256#2,2:2254\n256#2,2:2256\n256#2,2:2258\n256#2,2:2260\n256#2,2:2262\n256#2,2:2264\n256#2,2:2266\n256#2,2:2268\n256#2,2:2270\n256#2,2:2272\n256#2,2:2274\n256#2,2:2276\n256#2,2:2278\n256#2,2:2280\n256#2,2:2282\n256#2,2:2284\n256#2,2:2286\n256#2,2:2288\n256#2,2:2290\n254#2:2292\n254#2:2293\n256#2,2:2294\n256#2,2:2296\n254#2:2298\n256#2,2:2299\n254#2:2301\n254#2:2302\n256#2,2:2303\n256#2,2:2305\n256#2,2:2307\n254#2:2309\n254#2:2310\n*S KotlinDebug\n*F\n+ 1 GenericWindowView.kt\ncom/upuphone/xr/sapp/view/GenericWindowView\n*L\n103#1:2046,2\n104#1:2048,2\n105#1:2050,2\n107#1:2052,2\n108#1:2054,2\n109#1:2056,2\n135#1:2058,2\n136#1:2060,2\n137#1:2062,2\n139#1:2064,2\n140#1:2066,2\n192#1:2068,2\n193#1:2070,2\n195#1:2072,2\n198#1:2074,2\n199#1:2076,2\n200#1:2078,2\n201#1:2080,2\n202#1:2082,2\n209#1:2084,2\n210#1:2086,2\n211#1:2088,2\n212#1:2090,2\n218#1:2092,2\n234#1:2094,2\n235#1:2096,2\n236#1:2098,2\n237#1:2100,2\n238#1:2102,2\n452#1:2104,2\n453#1:2106,2\n454#1:2108,2\n455#1:2110,2\n501#1:2112,2\n536#1:2114,2\n537#1:2116,2\n538#1:2118,2\n541#1:2120,2\n542#1:2122,2\n567#1:2124,2\n568#1:2126,2\n569#1:2128,2\n570#1:2130,2\n581#1:2132,2\n590#1:2134,2\n609#1:2136,2\n624#1:2138,2\n631#1:2140,2\n638#1:2142,2\n645#1:2144,2\n672#1:2146,2\n673#1:2148,2\n674#1:2150,2\n684#1:2152,2\n685#1:2154,2\n686#1:2156,2\n745#1:2158,2\n746#1:2160,2\n747#1:2162,2\n760#1:2164,2\n761#1:2166,2\n774#1:2168,2\n775#1:2170,2\n776#1:2172,2\n782#1:2174,2\n789#1:2176,2\n803#1:2178,2\n810#1:2180,2\n824#1:2182,2\n825#1:2184,2\n826#1:2186,2\n827#1:2188,2\n838#1:2190,2\n839#1:2192,2\n840#1:2194,2\n847#1:2196,2\n848#1:2198,2\n849#1:2200,2\n868#1:2202,2\n869#1:2204,2\n870#1:2206,2\n871#1:2208,2\n953#1:2210,2\n981#1:2212,2\n982#1:2214,2\n984#1:2216,2\n985#1:2218,2\n1070#1:2220,2\n1147#1:2222,2\n1149#1:2224,2\n1150#1:2226,2\n1151#1:2228,2\n1157#1:2230,2\n1164#1:2232,2\n1171#1:2234,2\n1190#1:2236,2\n1191#1:2238,2\n1192#1:2240,2\n1195#1:2242,2\n1196#1:2244,2\n1197#1:2246,2\n1213#1:2248,2\n1214#1:2250,2\n1215#1:2252,2\n1218#1:2254,2\n1219#1:2256,2\n1220#1:2258,2\n1237#1:2260,2\n1238#1:2262,2\n1239#1:2264,2\n1242#1:2266,2\n1243#1:2268,2\n1244#1:2270,2\n1254#1:2272,2\n1255#1:2274,2\n1256#1:2276,2\n1262#1:2278,2\n1465#1:2280,2\n1466#1:2282,2\n1467#1:2284,2\n1480#1:2286,2\n1481#1:2288,2\n1482#1:2290,2\n1491#1:2292\n1506#1:2293\n1529#1:2294,2\n1532#1:2296,2\n1536#1:2298\n1535#1:2299,2\n1537#1:2301\n1548#1:2302\n1719#1:2303,2\n1743#1:2305,2\n385#1:2307,2\n1586#1:2309\n1597#1:2310\n*E\n"})
@SuppressLint({"ViewConstructor"})
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 P2\u00020\u0001:\u0004QRSTB!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001b\u0010\fJ\u0017\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001c\u0010\fJ!\u0010\u001d\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001d\u0010\u0013J\u001f\u0010 \u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010&\u001a\u00020\n2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b(\u0010\fJ\u0017\u0010)\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b)\u0010*J'\u0010.\u001a\u00020-2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020$H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020-2\u0006\u0010+\u001a\u00020\rH\u0002¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020-2\u0006\u0010+\u001a\u00020\rH\u0002¢\u0006\u0004\b2\u00101J\u001f\u00105\u001a\u00020\n2\u0006\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020\rH\u0002¢\u0006\u0004\b5\u00106J\u0019\u00109\u001a\u00020$2\b\u00108\u001a\u0004\u0018\u000107H\u0017¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\nH\u0014¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\nH\u0014¢\u0006\u0004\b=\u0010<J\u001f\u0010?\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u000fH\u0016¢\u0006\u0004\b?\u0010@J\u0015\u0010A\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\bA\u0010BR\u0014\u0010F\u001a\u00020C8\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010N¨\u0006U"}, d2 = {"Lcom/upuphone/xr/sapp/view/GenericWindowView;", "Lcom/upuphone/xr/sapp/view/popup/GenericWindowViewContainer;", "", "windowType", "Landroid/content/Context;", "context", "Lcom/upuphone/xr/sapp/view/GenericWindowView$IClickCallback;", "callback", "<init>", "(ILandroid/content/Context;Lcom/upuphone/xr/sapp/view/GenericWindowView$IClickCallback;)V", "", "setDeviceConnectUI", "(I)V", "", "deviceInfo", "", "A", "(Ljava/lang/String;I)Ljava/lang/Object;", "K", "(Lcom/upuphone/xr/sapp/view/GenericWindowView$IClickCallback;I)V", "error", "y", "(I)I", "errorCode", "z", "(I)Ljava/lang/String;", "type", "setLoadingUI", "setUI", "E", "string", "limit", "T", "(Ljava/lang/String;I)V", "Landroid/widget/TextView;", "view", "", "visible", "S", "(Landroid/widget/TextView;Z)V", "D", "X", "(Landroid/content/Context;)V", "text", "more", "Landroid/text/SpannableString;", "J", "(ILjava/lang/String;Z)Landroid/text/SpannableString;", "w", "(Ljava/lang/String;)Landroid/text/SpannableString;", "x", "textView", "prefix", "W", "(Landroid/widget/TextView;Ljava/lang/String;)V", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "onAttachedToWindow", "()V", "onDetachedFromWindow", "data", "b", "(ILjava/lang/Object;)V", "B", "(I)Z", "Lcom/upuphone/xr/sapp/databinding/GenericWindowBinding;", "d", "Lcom/upuphone/xr/sapp/databinding/GenericWindowBinding;", "binding", "e", "Ljava/lang/String;", "mEditContent", "f", "Z", "isEdit", "g", "I", "mIgnoreNotify", "h", "Companion", "IClickCallback", "PolicyClickableSpan", "PolicyJapClickableSpan", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class GenericWindowView extends GenericWindowViewContainer {
    public static final Companion h = new Companion((DefaultConstructorMarker) null);
    public final GenericWindowBinding d;
    public String e = "";
    public boolean f;
    public int g;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/upuphone/xr/sapp/view/GenericWindowView$Companion;", "", "()V", "TAG", "", "app_intlRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/upuphone/xr/sapp/view/GenericWindowView$IClickCallback;", "", "", "windowType", "action", "", "a", "(II)V", "data", "b", "(ILjava/lang/Object;)V", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public interface IClickCallback {
        void a(int i, int i2);

        void b(int i, Object obj);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/view/GenericWindowView$PolicyClickableSpan;", "Landroid/text/style/ClickableSpan;", "", "policy", "<init>", "(Lcom/upuphone/xr/sapp/view/GenericWindowView;Ljava/lang/String;)V", "Landroid/view/View;", "widget", "", "onClick", "(Landroid/view/View;)V", "Landroid/text/TextPaint;", "ds", "updateDrawState", "(Landroid/text/TextPaint;)V", "a", "Ljava/lang/String;", "getPolicy", "()Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class PolicyClickableSpan extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        public final String f7961a;
        public final /* synthetic */ GenericWindowView b;

        public PolicyClickableSpan(GenericWindowView genericWindowView, String str) {
            Intrinsics.checkNotNullParameter(str, PolicySdkConstants.policyFileDir);
            this.b = genericWindowView;
            this.f7961a = str;
        }

        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "widget");
            String string = this.b.getResources().getString(R.string.superapp_privacy_policy);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            if (StringsKt.contains$default((CharSequence) this.f7961a, (CharSequence) string, false, 2, (Object) null)) {
                IClickCallback callback = this.b.getCallback();
                if (callback != null) {
                    callback.b(this.b.getWindowType(), ProtocolType.CATEGORY_PP);
                    return;
                }
                return;
            }
            IClickCallback callback2 = this.b.getCallback();
            if (callback2 != null) {
                callback2.b(this.b.getWindowType(), ProtocolType.CATEGORY_UP);
            }
        }

        public void updateDrawState(TextPaint textPaint) {
            Intrinsics.checkNotNullParameter(textPaint, "ds");
            textPaint.setUnderlineText(false);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/upuphone/xr/sapp/view/GenericWindowView$PolicyJapClickableSpan;", "Landroid/text/style/ClickableSpan;", "", "policy", "<init>", "(Lcom/upuphone/xr/sapp/view/GenericWindowView;Ljava/lang/String;)V", "Landroid/view/View;", "widget", "", "onClick", "(Landroid/view/View;)V", "Landroid/text/TextPaint;", "ds", "updateDrawState", "(Landroid/text/TextPaint;)V", "a", "Ljava/lang/String;", "getPolicy", "()Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public final class PolicyJapClickableSpan extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        public final String f7962a;
        public final /* synthetic */ GenericWindowView b;

        public PolicyJapClickableSpan(GenericWindowView genericWindowView, String str) {
            Intrinsics.checkNotNullParameter(str, PolicySdkConstants.policyFileDir);
            this.b = genericWindowView;
            this.f7962a = str;
        }

        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "widget");
            IClickCallback callback = this.b.getCallback();
            if (callback != null) {
                callback.b(this.b.getWindowType(), this.f7962a);
            }
        }

        public void updateDrawState(TextPaint textPaint) {
            Intrinsics.checkNotNullParameter(textPaint, "ds");
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenericWindowView(int i, Context context, IClickCallback iClickCallback) {
        super(context, i, iClickCallback);
        Intrinsics.checkNotNullParameter(context, "context");
        GenericWindowBinding c = GenericWindowBinding.c(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(c, "inflate(...)");
        this.d = c;
    }

    public static final void C(GenericWindowView genericWindowView, View view) {
        Intrinsics.checkNotNullParameter(genericWindowView, "this$0");
        IClickCallback callback = genericWindowView.getCallback();
        if (callback != null) {
            callback.a(genericWindowView.getWindowType(), Ring2TrackerConstant.MSG_BT_OFF);
        }
    }

    public static final void F(int i, GenericWindowView genericWindowView, IClickCallback iClickCallback, View view) {
        Intrinsics.checkNotNullParameter(genericWindowView, "this$0");
        if (i != 100) {
            if (i != 114) {
                if (i != 137) {
                    if (i != 158) {
                        if (i != 10001) {
                            if (i != 10002) {
                                switch (i) {
                                    case 103:
                                    case 104:
                                    case 105:
                                        break;
                                    case 106:
                                        DataStoreUtils.e.a().o("sp_user_agreement_state", Boolean.TRUE);
                                        BuglyManager.f7849a.n();
                                        break;
                                    default:
                                        genericWindowView.D(i);
                                        break;
                                }
                            } else if (!TextUtils.isEmpty(genericWindowView.d.w.getText())) {
                                DrawableEditText drawableEditText = genericWindowView.d.w;
                                Intrinsics.checkNotNullExpressionValue(drawableEditText, "editInput");
                                if (drawableEditText.getVisibility() == 0) {
                                    ULog.Delegate delegate = ULog.f6446a;
                                    String str = genericWindowView.e;
                                    delegate.a("jesson", "WINDOW_TYPE_MODIFY_RING_NAME::mEditContent is: " + str);
                                    if (iClickCallback != null) {
                                        iClickCallback.b(i, genericWindowView.e);
                                    }
                                }
                            }
                        } else if (!TextUtils.isEmpty(genericWindowView.d.w.getText())) {
                            DrawableEditText drawableEditText2 = genericWindowView.d.w;
                            Intrinsics.checkNotNullExpressionValue(drawableEditText2, "editInput");
                            if (drawableEditText2.getVisibility() == 0) {
                                ULog.Delegate delegate2 = ULog.f6446a;
                                String str2 = genericWindowView.e;
                                delegate2.a("jesson", "WINDOW_TYPE_MODIFY_RING_NAME::mEditContent is: " + str2);
                                ControlUtils.f7858a.m0(genericWindowView.e);
                                if (iClickCallback != null) {
                                    iClickCallback.b(i, genericWindowView.e);
                                }
                            }
                        }
                    } else if (iClickCallback != null) {
                        iClickCallback.b(i, Integer.valueOf(genericWindowView.g));
                    }
                } else if (iClickCallback != null) {
                    iClickCallback.b(i, Integer.valueOf(genericWindowView.g));
                }
            } else if (genericWindowView.getMExtra() instanceof PasswordInfo) {
                Object mExtra = genericWindowView.getMExtra();
                Intrinsics.checkNotNull(mExtra, "null cannot be cast to non-null type com.upuphone.xr.sapp.guide.model.PasswordInfo");
                PasswordInfo passwordInfo = (PasswordInfo) mExtra;
                passwordInfo.setMPassword(genericWindowView.e);
                if (iClickCallback != null) {
                    iClickCallback.b(i, passwordInfo);
                }
            }
        }
        if (iClickCallback != null) {
            iClickCallback.a(i, Ring2TrackerConstant.MSG_BT_OFF);
        }
    }

    public static final void G(IClickCallback iClickCallback, int i, View view) {
        if (iClickCallback != null) {
            iClickCallback.a(i, Ring2TrackerConstant.MSG_RING_EVENT_HANDLER);
        }
        if (i == 101) {
            DataStoreUtils.e.a().o("sp_refuse_notice_state", Boolean.TRUE);
        }
    }

    public static final void H(IClickCallback iClickCallback, int i, View view) {
        if (iClickCallback != null) {
            iClickCallback.a(i, Ring2TrackerConstant.MSG_BT_OFF);
        }
    }

    public static final void I(GenericWindowView genericWindowView, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(genericWindowView, "this$0");
        genericWindowView.g = z ? 2 : 1;
    }

    public static final void L(IClickCallback iClickCallback, int i, View view) {
        if (iClickCallback != null) {
            iClickCallback.a(i, Ring2TrackerConstant.MSG_BT_OFF);
        }
    }

    public static final void M(GenericWindowView genericWindowView, int i, View view) {
        Intrinsics.checkNotNullParameter(genericWindowView, "this$0");
        MainApplication.Companion companion = MainApplication.k;
        companion.m(true);
        companion.o(false);
        Object mExtra = genericWindowView.getMExtra();
        Intrinsics.checkNotNull(mExtra, "null cannot be cast to non-null type com.upuphone.xr.interconnect.entity.StarryNetDevice");
        StarryNetDevice starryNetDevice = (StarryNetDevice) mExtra;
        genericWindowView.d.l.setVisibility(4);
        genericWindowView.d.j.setVisibility(4);
        LinearLayout linearLayout = genericWindowView.d.A;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "glassProtocol");
        linearLayout.setVisibility(8);
        genericWindowView.d.s.setText(genericWindowView.getContext().getString(R.string.connecting));
        genericWindowView.d.o.setText(starryNetDevice.getDeviceName());
        int connectDevice = InterconnectManager.getInstance().getStarryNetDeviceManager().connectDevice(starryNetDevice.getDeviceId());
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("setDeviceConnectButtonEvent", "connectDevice code is: " + connectDevice);
        genericWindowView.getHandler().postDelayed(new l(connectDevice, genericWindowView, i, starryNetDevice), 1000);
    }

    public static final void N(int i, GenericWindowView genericWindowView, int i2, StarryNetDevice starryNetDevice) {
        Intrinsics.checkNotNullParameter(genericWindowView, "this$0");
        Intrinsics.checkNotNullParameter(starryNetDevice, "$starryNetDevice");
        if (i != 202000) {
            String deviceId = starryNetDevice.getDeviceId();
            Intrinsics.checkNotNullExpressionValue(deviceId, "getDeviceId(...)");
            genericWindowView.b(i2, new ConnectResult(false, deviceId, genericWindowView.y(i)));
        }
    }

    public static final void O(IClickCallback iClickCallback, int i, View view) {
        if (iClickCallback != null) {
            iClickCallback.a(i, Ring2TrackerConstant.MSG_RING_EVENT_HANDLER);
        }
    }

    public static final void P(IClickCallback iClickCallback, int i, View view) {
        if (iClickCallback != null) {
            iClickCallback.a(i, Ring2TrackerConstant.MSG_BT_OFF);
        }
    }

    public static final void Q(GenericWindowView genericWindowView, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(genericWindowView, "this$0");
        if (z) {
            genericWindowView.d.l.setAlpha(1.0f);
            genericWindowView.d.l.setEnabled(true);
            return;
        }
        genericWindowView.d.l.setAlpha(0.5f);
        genericWindowView.d.l.setEnabled(false);
    }

    public static final void R(GenericWindowView genericWindowView, Ref.ObjectRef objectRef, int i, Ref.BooleanRef booleanRef) {
        Intrinsics.checkNotNullParameter(genericWindowView, "this$0");
        Intrinsics.checkNotNullParameter(objectRef, "$deviceModel");
        Intrinsics.checkNotNullParameter(booleanRef, "$animRepeat");
        Object A = genericWindowView.A((String) objectRef.element, i);
        if (A instanceof Integer) {
            genericWindowView.d.q.setVisibility(0);
            genericWindowView.d.r.setVisibility(8);
            CustomFrameAnimation b = CustomFrameAnimation.d.b();
            int intValue = ((Number) A).intValue();
            ImageView imageView = genericWindowView.d.q;
            Intrinsics.checkNotNullExpressionValue(imageView, "deviceImg");
            b.h(intValue, imageView, booleanRef.element, (CustomFrameAnimation.IAnimState) null);
        } else if (A instanceof PagParam) {
            genericWindowView.d.q.setVisibility(8);
            genericWindowView.d.r.setVisibility(0);
            PAGImageView pAGImageView = genericWindowView.d.r;
            Intrinsics.checkNotNullExpressionValue(pAGImageView, "devicePag");
            LibPag.a(pAGImageView, (PagParam) A);
        }
    }

    public static final void U(GenericWindowView genericWindowView, int i, View view) {
        Intrinsics.checkNotNullParameter(genericWindowView, "this$0");
        IClickCallback callback = genericWindowView.getCallback();
        if (callback != null) {
            callback.b(i, "");
        }
    }

    public static final void V(GenericWindowView genericWindowView, int i, View view) {
        Intrinsics.checkNotNullParameter(genericWindowView, "this$0");
        IClickCallback callback = genericWindowView.getCallback();
        if (callback != null) {
            callback.b(i, "");
        }
    }

    private final void setDeviceConnectUI(int i) {
        int i2 = i;
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        String str = "-1";
        String str2 = "unknown glass";
        String str3 = "AR Glass";
        if (getMExtra() instanceof StarryNetDevice) {
            Object mExtra = getMExtra();
            Intrinsics.checkNotNull(mExtra, "null cannot be cast to non-null type com.upuphone.xr.interconnect.entity.StarryNetDevice");
            StarryNetDevice starryNetDevice = (StarryNetDevice) mExtra;
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("GenericNoticeView", "setDeviceConnectUI::StarryNetDevice is: " + starryNetDevice);
            String deviceName = starryNetDevice.getDeviceName();
            if (deviceName != null) {
                str2 = deviceName;
            }
            StarryNetDeviceManager starryNetDeviceManager = InterconnectManager.getInstance().getStarryNetDeviceManager();
            String deviceId = starryNetDevice.getDeviceId();
            if (deviceId != null) {
                str = deviceId;
            }
            T deviceInfo = starryNetDeviceManager.getDeviceInfo(str, 5);
            if (deviceInfo == null) {
                deviceInfo = starryNetDevice.getModelId();
            }
            objectRef.element = deviceInfo;
            delegate.a("GenericNoticeView", "setDeviceConnectUI::StarryNetDevice:deviceModel: " + deviceInfo);
        } else if (getMExtra() instanceof NetDevice) {
            Object mExtra2 = getMExtra();
            Intrinsics.checkNotNull(mExtra2, "null cannot be cast to non-null type com.upuphone.xr.sapp.entity.NetDevice");
            NetDevice netDevice = (NetDevice) mExtra2;
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.a("GenericNoticeView", "setDeviceConnectUI::NetDevice is: " + netDevice);
            String mDeviceName = netDevice.getMDeviceName();
            if (mDeviceName != null) {
                str2 = mDeviceName;
            }
            StarryNetDeviceManager starryNetDeviceManager2 = InterconnectManager.getInstance().getStarryNetDeviceManager();
            String mIdentifier = netDevice.getMIdentifier();
            if (mIdentifier != null) {
                str = mIdentifier;
            }
            T deviceInfo2 = starryNetDeviceManager2.getDeviceInfo(str, 5);
            if (deviceInfo2 == null) {
                deviceInfo2 = netDevice.getModelID();
            }
            objectRef.element = deviceInfo2;
            delegate2.a("GenericNoticeView", "setDeviceConnectUI::NetDevice:deviceModel: " + deviceInfo2);
        } else {
            str2 = str3;
        }
        objectRef.element = "1003";
        ConstraintLayout constraintLayout = this.d.J;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "noticeMain");
        constraintLayout.setVisibility(8);
        ConstraintLayout constraintLayout2 = this.d.e;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "commonLoading");
        constraintLayout2.setVisibility(8);
        this.d.F.cancelAnimation();
        ConstraintLayout constraintLayout3 = this.d.m;
        Intrinsics.checkNotNullExpressionValue(constraintLayout3, "deviceConnectMain");
        constraintLayout3.setVisibility(0);
        if (!(i2 == 188 || i2 == 189 || i2 == 203)) {
            switch (i2) {
                case TrackerEvent.PositioningOfflineOutdoor /*131*/:
                    MzButton mzButton = this.d.k;
                    Intrinsics.checkNotNullExpressionValue(mzButton, "deviceConfirm");
                    mzButton.setVisibility(0);
                    MzButton mzButton2 = this.d.j;
                    Intrinsics.checkNotNullExpressionValue(mzButton2, "deviceCancel");
                    mzButton2.setVisibility(8);
                    MzButton mzButton3 = this.d.l;
                    Intrinsics.checkNotNullExpressionValue(mzButton3, "deviceConnect");
                    mzButton3.setVisibility(8);
                    LinearLayout linearLayout = this.d.A;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "glassProtocol");
                    linearLayout.setVisibility(8);
                    TextView textView = this.d.n;
                    Intrinsics.checkNotNullExpressionValue(textView, "deviceConnectOther");
                    textView.setVisibility(8);
                    booleanRef.element = false;
                    str3 = getContext().getString(R.string.connect_title);
                    Intrinsics.checkNotNullExpressionValue(str3, "getString(...)");
                    this.d.k.setText(getContext().getString(R.string.go_function));
                    break;
                case 132:
                    MzButton mzButton4 = this.d.k;
                    Intrinsics.checkNotNullExpressionValue(mzButton4, "deviceConfirm");
                    mzButton4.setVisibility(4);
                    MzButton mzButton5 = this.d.j;
                    Intrinsics.checkNotNullExpressionValue(mzButton5, "deviceCancel");
                    mzButton5.setVisibility(0);
                    MzButton mzButton6 = this.d.l;
                    Intrinsics.checkNotNullExpressionValue(mzButton6, "deviceConnect");
                    mzButton6.setVisibility(0);
                    LinearLayout linearLayout2 = this.d.A;
                    Intrinsics.checkNotNullExpressionValue(linearLayout2, "glassProtocol");
                    linearLayout2.setVisibility(0);
                    this.d.V.setMovementMethod(LinkMovementMethod.getInstance());
                    this.d.V.setHighlightColor(0);
                    TextView textView2 = this.d.V;
                    String string = getContext().getString(R.string.read_protocol_tips);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    textView2.setText(J(i2, string, true));
                    this.d.l.setEnabled(false);
                    TextView textView3 = this.d.n;
                    Intrinsics.checkNotNullExpressionValue(textView3, "deviceConnectOther");
                    textView3.setVisibility(8);
                    booleanRef.element = true;
                    str3 = getContext().getString(R.string.discover_ar_glass);
                    Intrinsics.checkNotNullExpressionValue(str3, "getString(...)");
                    if (!this.d.U.isChecked()) {
                        this.d.l.setAlpha(0.5f);
                        this.d.l.setEnabled(false);
                        break;
                    } else {
                        this.d.l.setAlpha(1.0f);
                        this.d.l.setEnabled(true);
                        break;
                    }
                case 133:
                    break;
            }
        }
        MzButton mzButton7 = this.d.k;
        Intrinsics.checkNotNullExpressionValue(mzButton7, "deviceConfirm");
        mzButton7.setVisibility(0);
        MzButton mzButton8 = this.d.j;
        Intrinsics.checkNotNullExpressionValue(mzButton8, "deviceCancel");
        mzButton8.setVisibility(8);
        MzButton mzButton9 = this.d.l;
        Intrinsics.checkNotNullExpressionValue(mzButton9, "deviceConnect");
        mzButton9.setVisibility(8);
        LinearLayout linearLayout3 = this.d.A;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "glassProtocol");
        linearLayout3.setVisibility(8);
        TextView textView4 = this.d.n;
        Intrinsics.checkNotNullExpressionValue(textView4, "deviceConnectOther");
        textView4.setVisibility(0);
        if (188 == i2) {
            this.d.n.setText(getContext().getString(R.string.connect_error_china_app_init_glass_ip_init));
        } else if (189 == i2) {
            this.d.n.setText(getContext().getString(R.string.connect_error_intl_app_china_glass));
        } else if (203 == i2) {
            this.d.n.setText(getContext().getString(R.string.connect_error_update_rom_for_fly_me));
        }
        booleanRef.element = true;
        this.d.k.setText(getContext().getString(R.string.i_known));
        str3 = getContext().getString(R.string.discover_ar_glass);
        Intrinsics.checkNotNullExpressionValue(str3, "getString(...)");
        this.d.s.setText(str3);
        this.d.o.setText(str2);
        new Handler(Looper.getMainLooper()).postDelayed(new n(this, objectRef, i2, booleanRef), 100);
        this.d.n.post(new o(this));
    }

    /* access modifiers changed from: private */
    public static final void setDeviceConnectUI$lambda$2(GenericWindowView genericWindowView) {
        Intrinsics.checkNotNullParameter(genericWindowView, "this$0");
        if (genericWindowView.d.n.getLineCount() == 1) {
            genericWindowView.d.n.setGravity(1);
        } else {
            genericWindowView.d.n.setGravity(3);
        }
    }

    private final void setLoadingUI(int i) {
        ConstraintLayout constraintLayout = this.d.J;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "noticeMain");
        constraintLayout.setVisibility(8);
        ConstraintLayout constraintLayout2 = this.d.m;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "deviceConnectMain");
        constraintLayout2.setVisibility(8);
        ConstraintLayout constraintLayout3 = this.d.e;
        Intrinsics.checkNotNullExpressionValue(constraintLayout3, "commonLoading");
        constraintLayout3.setVisibility(0);
        this.d.F.setRepeatCount(-1);
        this.d.F.playAnimation();
        LinearLayout linearLayout = this.d.X;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "removeDeviceFromSetting");
        linearLayout.setVisibility(8);
        ConstraintLayout constraintLayout4 = this.d.i0;
        Intrinsics.checkNotNullExpressionValue(constraintLayout4, "syncVolMain");
        constraintLayout4.setVisibility(8);
        if (i == 123) {
            this.d.G.setText(GlobalExtKt.h(R.string.get_in_the_list));
        } else if (i != 150) {
            switch (i) {
                case Opcodes.IF_ACMPEQ:
                    this.d.G.setText(R.string.feedback_submitting);
                    return;
                case Opcodes.IF_ACMPNE:
                    this.d.G.setText(R.string.clearing_contact);
                    return;
                case Opcodes.GOTO:
                    this.d.G.setText(R.string.picture_compress);
                    return;
                default:
                    return;
            }
        } else {
            this.d.G.setText(R.string.switch_language_loading);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v23, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v25, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v27, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v27, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v29, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v31, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v33, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v34, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v37, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v39, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v41, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v43, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v65, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v66, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v44, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v46, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v69, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v48, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v72, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v50, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v75, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v52, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v79, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v81, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v83, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v15, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v87, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v57, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v16, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v64, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v66, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v68, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v106, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v74, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v115, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v120, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v83, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v124, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v84, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v125, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v85, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v86, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v127, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v87, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v128, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v88, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v91, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v130, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v93, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v95, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v134, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v101, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v138, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v103, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v143, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v105, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v146, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v107, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v149, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v109, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v111, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v113, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v115, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v120, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v124, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v174, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v126, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v177, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v128, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v180, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v129, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v150, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v191, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v152, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v193, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v154, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v195, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v156, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v197, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v158, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v199, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v160, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v201, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v162, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v164, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v208, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v166, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v210, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v168, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v213, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v174, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v217, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v180, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v221, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v186, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v225, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v192, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v229, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v198, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v233, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v204, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v237, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v210, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v241, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v216, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v245, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v218, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v248, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v220, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v250, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v222, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v252, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v233, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v235, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v268, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v342, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v271, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v239, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v272, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v240, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v245, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v277, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v279, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v251, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v253, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v259, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v307, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v260, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v262, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v319, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v390, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v263, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v323, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v391, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v324, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v264, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v266, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v326, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v268, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v270, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v336, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v272, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v274, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v276, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v352, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v282, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v284, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v364, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v366, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v368, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v286, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v370, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v288, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v373, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v375, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v376, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v292, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v379, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v381, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v383, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v296, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v386, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v302, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v304, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v306, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v308, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v413, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v319, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v431, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v330, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v477, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v332, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v457, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v345, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v462, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v347, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v465, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v349, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v468, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v356, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v358, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v479, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v481, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v483, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v528, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v531, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v532, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v533, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v534, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r4v344, types: [java.lang.CharSequence] */
    /* JADX WARNING: type inference failed for: r4v346, types: [java.lang.CharSequence] */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x07bf, code lost:
        r4 = r3;
        r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0909, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x095f, code lost:
        r4 = r17;
        r7 = r18;
        r6 = r19;
        r20 = r3;
        r3 = r2;
        r2 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0ee0, code lost:
        r2 = r17;
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00d9, code lost:
        r4 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00db, code lost:
        r7 = r18;
        r6 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x13fb, code lost:
        r4 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x15c1, code lost:
        r3 = r17;
        r4 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x1700, code lost:
        r0.d.m0.setText(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x170b, code lost:
        if (B(r22) == false) goto L_0x1714;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x170d, code lost:
        r0.d.i.setText(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x1714, code lost:
        r5 = r0.d.w;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "editInput");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x171f, code lost:
        if (r5.getVisibility() != 0) goto L_0x1743;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x1721, code lost:
        r0.d.w.setText(r4);
        r0.d.w.setSelection(r4.length());
        r0.d.w.getViewTreeObserver().addOnGlobalLayoutListener(new com.upuphone.xr.sapp.view.GenericWindowView$setUI$4(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x1743, code lost:
        r4 = r0.d.u0;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x174e, code lost:
        if (r4.getVisibility() != 0) goto L_0x17b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x1750, code lost:
        r5 = 0;
        r0.d.f.setEnabled(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x175e, code lost:
        if ((getMExtra() instanceof com.upuphone.xr.sapp.guide.model.PasswordInfo) == false) goto L_0x17a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x1760, code lost:
        r4 = getMExtra();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r6);
        r4 = (com.upuphone.xr.sapp.guide.model.PasswordInfo) r4;
        r6 = r0.d.u0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x1772, code lost:
        if (r4.getMState() != -1) goto L_0x1776;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x1774, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x1776, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:282:0x1777, code lost:
        r6.n(r7);
        r4.setMPassword(r17);
        r4 = r4.getMPassword();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x1787, code lost:
        if (r4.length() <= 0) goto L_0x178a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x178a, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x178b, code lost:
        if (r4 == null) goto L_0x17a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x178d, code lost:
        r7 = 1;
        r0.d.f.setEnabled(true);
        r0.d.u0.setEditTextContent(r4);
        r0.d.u0.m(true);
        r4 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x17a6, code lost:
        r7 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x17a7, code lost:
        r0.d.u0.getViewTreeObserver().addOnGlobalLayoutListener(new com.upuphone.xr.sapp.view.GenericWindowView$setUI$7(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x17b8, code lost:
        r5 = 0;
        r7 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x17be, code lost:
        if (kotlin.text.StringsKt.isBlank(r2) == false) goto L_0x17cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x17c0, code lost:
        r2 = r0.d.m0;
        r4 = r16;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4);
        r6 = 8;
        r2.setVisibility(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x17cf, code lost:
        r4 = r16;
        r6 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x17d7, code lost:
        if (kotlin.text.StringsKt.isBlank(r3) == false) goto L_0x17e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x17db, code lost:
        if (r1 == 106) goto L_0x17e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x17dd, code lost:
        r2 = r0.d.i;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "content");
        r2.setVisibility(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x17e7, code lost:
        r2 = r0.d.E;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "layScrollContent");
        r3 = r0.d.i;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "content");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x17fb, code lost:
        if (r3.getVisibility() != 0) goto L_0x17fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x17fe, code lost:
        r3 = r0.d.I;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "myContentIv");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x180b, code lost:
        if (r3.getVisibility() != 0) goto L_0x180f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x180d, code lost:
        r15 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:304:0x180f, code lost:
        r15 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x1810, code lost:
        if (r15 == 0) goto L_0x1814;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x1812, code lost:
        r8 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x1814, code lost:
        r8 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x1815, code lost:
        r2.setVisibility(r8);
        r2 = r0.d.i;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "content");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:309:0x1823, code lost:
        if (r2.getVisibility() != 0) goto L_0x1835;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x1825, code lost:
        r0.d.i.getViewTreeObserver().addOnPreDrawListener(new com.upuphone.xr.sapp.view.GenericWindowView$setUI$8(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:311:0x1835, code lost:
        r2 = r0.d.m0;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x1840, code lost:
        if (r2.getVisibility() != 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:314:0x1844, code lost:
        if (r1 == 181) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:315:0x1846, code lost:
        r0.d.m0.getViewTreeObserver().addOnPreDrawListener(new com.upuphone.xr.sapp.view.GenericWindowView$setUI$9(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:317:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:318:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0173, code lost:
        r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0175, code lost:
        r4 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x02b2, code lost:
        if (r3 != null) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x04d3, code lost:
        r2 = r3;
        r4 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x04d4, code lost:
        r3 = r4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setUI(int r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            java.lang.String r2 = "title"
            java.lang.String r3 = "wifiEdit"
            java.lang.String r4 = "null cannot be cast to non-null type com.upuphone.xr.sapp.guide.model.PasswordInfo"
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r6 = r0.d
            androidx.constraintlayout.widget.ConstraintLayout r6 = r6.J
            java.lang.String r7 = "noticeMain"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            r8 = 0
            r6.setVisibility(r8)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r6 = r0.d
            androidx.constraintlayout.widget.ConstraintLayout r6 = r6.m
            java.lang.String r9 = "deviceConnectMain"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r9)
            r10 = 8
            r6.setVisibility(r10)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r6 = r0.d
            androidx.constraintlayout.widget.ConstraintLayout r6 = r6.e
            java.lang.String r11 = "commonLoading"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r11)
            r6.setVisibility(r10)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r6 = r0.d
            androidx.constraintlayout.widget.ConstraintLayout r6 = r6.i0
            java.lang.String r12 = "syncVolMain"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r12)
            r6.setVisibility(r10)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r6 = r0.d
            com.airbnb.lottie.LottieAnimationView r6 = r6.F
            r6.cancelAnimation()
            java.lang.String r12 = "editInput"
            java.lang.String r14 = "COUNTRY_INTL"
            java.lang.String r13 = "content"
            java.lang.String r5 = "getString(...)"
            java.lang.String r15 = ""
            switch(r1) {
                case 100: goto L_0x16c3;
                case 101: goto L_0x1693;
                case 102: goto L_0x165d;
                case 103: goto L_0x162a;
                case 104: goto L_0x15f8;
                case 105: goto L_0x15c6;
                case 106: goto L_0x1535;
                case 107: goto L_0x14f1;
                default: goto L_0x0054;
            }
        L_0x0054:
            java.lang.String r8 = "editMain"
            switch(r1) {
                case 110: goto L_0x14bd;
                case 111: goto L_0x1489;
                case 112: goto L_0x1455;
                case 113: goto L_0x13ff;
                case 114: goto L_0x1383;
                default: goto L_0x0059;
            }
        L_0x0059:
            java.lang.String r10 = "null cannot be cast to non-null type kotlin.String"
            java.lang.String r6 = "oneConfirm"
            r16 = r2
            java.lang.String r2 = "confirm"
            r17 = r15
            java.lang.String r15 = "refuse"
            switch(r1) {
                case 116: goto L_0x134f;
                case 117: goto L_0x1322;
                case 118: goto L_0x12fd;
                case 119: goto L_0x12c0;
                case 120: goto L_0x128f;
                case 121: goto L_0x1248;
                case 122: goto L_0x11dd;
                default: goto L_0x0068;
            }
        L_0x0068:
            switch(r1) {
                case 124: goto L_0x1192;
                case 125: goto L_0x114b;
                case 126: goto L_0x10ff;
                case 127: goto L_0x10c5;
                case 128: goto L_0x1093;
                case 129: goto L_0x104b;
                case 130: goto L_0x102d;
                default: goto L_0x006b;
            }
        L_0x006b:
            r18 = r3
            java.lang.String r3 = "dontNotifyMain"
            r19 = r4
            java.lang.String r4 = "getContext(...)"
            switch(r1) {
                case 134: goto L_0x1013;
                case 135: goto L_0x0ff9;
                case 136: goto L_0x0fdf;
                case 137: goto L_0x0f6f;
                case 138: goto L_0x0f41;
                case 139: goto L_0x0f13;
                case 140: goto L_0x0ee5;
                case 141: goto L_0x0e60;
                case 142: goto L_0x0e40;
                case 143: goto L_0x0e20;
                case 144: goto L_0x0e00;
                case 145: goto L_0x0de0;
                case 146: goto L_0x0dc0;
                case 147: goto L_0x0da0;
                case 148: goto L_0x0d7f;
                case 149: goto L_0x0d5f;
                case 168: goto L_0x0d3f;
                case 190: goto L_0x0cef;
                case 191: goto L_0x0cac;
                case 192: goto L_0x0c69;
                case 193: goto L_0x0c26;
                case 194: goto L_0x0be3;
                case 195: goto L_0x0ba4;
                case 196: goto L_0x0b65;
                case 197: goto L_0x0b26;
                case 198: goto L_0x0ae7;
                case 199: goto L_0x0ab9;
                case 200: goto L_0x0a99;
                case 201: goto L_0x0a79;
                case 202: goto L_0x0a14;
                case 2003: goto L_0x09fa;
                case 2004: goto L_0x09da;
                case 2005: goto L_0x096c;
                case 2008: goto L_0x093a;
                case 2010: goto L_0x090c;
                case 2011: goto L_0x08ca;
                case 2012: goto L_0x088a;
                case 2013: goto L_0x085d;
                case 2014: goto L_0x080f;
                case 10001: goto L_0x07c4;
                case 10002: goto L_0x076b;
                default: goto L_0x0076;
            }
        L_0x0076:
            switch(r1) {
                case 151: goto L_0x0735;
                case 152: goto L_0x0708;
                case 153: goto L_0x06e1;
                default: goto L_0x0079;
            }
        L_0x0079:
            switch(r1) {
                case 155: goto L_0x06b4;
                case 156: goto L_0x0687;
                case 157: goto L_0x0667;
                case 158: goto L_0x05cb;
                case 159: goto L_0x0597;
                default: goto L_0x007c;
            }
        L_0x007c:
            switch(r1) {
                case 162: goto L_0x0577;
                case 163: goto L_0x053b;
                case 164: goto L_0x04fe;
                default: goto L_0x007f;
            }
        L_0x007f:
            switch(r1) {
                case 170: goto L_0x04d7;
                case 171: goto L_0x0480;
                case 172: goto L_0x0453;
                case 173: goto L_0x0426;
                case 174: goto L_0x03f9;
                default: goto L_0x0082;
            }
        L_0x0082:
            java.lang.String r3 = "null cannot be cast to non-null type com.upuphone.xr.sapp.glass.CompatibilityManager.ConsultResult"
            switch(r1) {
                case 179: goto L_0x0375;
                case 180: goto L_0x02e3;
                case 181: goto L_0x02b6;
                case 182: goto L_0x0224;
                case 183: goto L_0x01f6;
                case 184: goto L_0x01a6;
                case 185: goto L_0x0178;
                case 186: goto L_0x00e1;
                case 187: goto L_0x0089;
                default: goto L_0x0087;
            }
        L_0x0087:
            goto L_0x0ee0
        L_0x0089:
            android.content.Context r2 = r21.getContext()
            int r3 = com.upuphone.xr.sapp.R.string.location_title
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 31
            if (r3 >= r4) goto L_0x00aa
            android.content.Context r3 = r21.getContext()
            int r4 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_location_text_android_r
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            goto L_0x00b7
        L_0x00aa:
            android.content.Context r3 = r21.getContext()
            int r4 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_location_text
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
        L_0x00b7:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            android.content.Context r5 = r21.getContext()
            int r6 = com.upuphone.xr.sapp.R.string.permission_refuse
            java.lang.CharSequence r5 = r5.getText(r6)
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            android.content.Context r5 = r21.getContext()
            int r6 = com.upuphone.xr.sapp.R.string.agree
            java.lang.String r5 = r5.getString(r6)
            r4.setText(r5)
        L_0x00d9:
            r4 = r17
        L_0x00db:
            r7 = r18
            r6 = r19
            goto L_0x1700
        L_0x00e1:
            java.lang.Object r3 = r21.getMExtra()
            boolean r4 = r3 instanceof com.upuphone.xr.sapp.entity.AppUpdateInfo
            if (r4 == 0) goto L_0x00ec
            com.upuphone.xr.sapp.entity.AppUpdateInfo r3 = (com.upuphone.xr.sapp.entity.AppUpdateInfo) r3
            goto L_0x00ed
        L_0x00ec:
            r3 = 0
        L_0x00ed:
            if (r3 != 0) goto L_0x00f0
            return
        L_0x00f0:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.M
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            r5 = 8
            r4.setVisibility(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            r2 = 0
            r4.setVisibility(r2)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r15)
            r4.setVisibility(r2)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.W
            int r4 = com.upuphone.xr.sapp.R.string.cancel_download
            r2.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.f
            int r4 = com.upuphone.xr.sapp.R.string.hide_dialog
            r2.setText(r4)
            int r2 = com.upuphone.xr.sapp.R.string.app_name
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            androidx.constraintlayout.widget.ConstraintLayout r5 = r4.D
            java.lang.String r6 = "layDownloadInfo"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r6 = 0
            r5.setVisibility(r6)
            android.widget.TextView r5 = r4.o0
            int r6 = com.upuphone.xr.sapp.R.string.latest_version_param
            java.lang.String r7 = r3.getLatestVersion()
            if (r7 != 0) goto L_0x0142
            r7 = r17
        L_0x0142:
            java.lang.Object[] r7 = new java.lang.Object[]{r7}
            java.lang.String r6 = com.upuphone.xr.sapp.utils.GlobalExtKt.i(r6, r7)
            r5.setText(r6)
            android.widget.TextView r5 = r4.p0
            java.lang.Long r6 = r3.getApkSize()
            if (r6 == 0) goto L_0x015a
            long r6 = r6.longValue()
            goto L_0x015c
        L_0x015a:
            r6 = 0
        L_0x015c:
            java.lang.String r6 = com.upuphone.xr.sapp.utils.FileSizeExtKt.a(r6)
            r5.setText(r6)
            android.widget.ProgressBar r4 = r4.P
            float r3 = r3.getDownloadProgress()
            r5 = 100
            float r5 = (float) r5
            float r3 = r3 * r5
            int r3 = (int) r3
            r4.setProgress(r3)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        L_0x0173:
            r3 = r17
        L_0x0175:
            r4 = r3
            goto L_0x00db
        L_0x0178:
            android.content.Context r2 = r21.getContext()
            int r3 = com.upuphone.xr.sapp.R.string.vp_separate_role_record_more_tip_title
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            android.content.Context r3 = r21.getContext()
            int r4 = com.upuphone.xr.sapp.R.string.vp_separate_role_record_more_tip_content
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.vp_separate_role_record_start
            r4.setText(r5)
            goto L_0x00d9
        L_0x01a6:
            android.content.Context r2 = r21.getContext()
            int r3 = com.upuphone.xr.sapp.R.string.vp_separate_role_clear_voiceprint
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            android.content.Context r3 = r21.getContext()
            int r4 = com.upuphone.xr.sapp.R.string.vp_separate_role_clear_tip_content
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.vp_clear
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            android.content.Context r5 = r21.getContext()
            int r6 = com.upuphone.xr.sapp.R.color.vp_separate_role_clear_confirm_bt
            int r5 = androidx.core.content.ContextCompat.getColor(r5, r6)
            r4.setTextColor(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            android.content.Context r5 = r21.getContext()
            int r6 = com.upuphone.xr.sapp.R.drawable.bg_confirm_button_warning
            android.graphics.drawable.Drawable r5 = androidx.core.content.ContextCompat.getDrawable(r5, r6)
            r4.setBackground(r5)
            goto L_0x00d9
        L_0x01f6:
            android.content.Context r2 = r21.getContext()
            int r3 = com.upuphone.xr.sapp.R.string.vp_separate_role_reject_record_title
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            android.content.Context r3 = r21.getContext()
            int r4 = com.upuphone.xr.sapp.R.string.vp_separate_role_use_mic_content
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.open_notification
            r4.setText(r5)
            goto L_0x00d9
        L_0x0224:
            java.lang.Object r3 = r21.getMExtra()
            boolean r4 = r3 instanceof com.upuphone.xr.sapp.entity.AppUpdateInfo
            if (r4 == 0) goto L_0x022f
            com.upuphone.xr.sapp.entity.AppUpdateInfo r3 = (com.upuphone.xr.sapp.entity.AppUpdateInfo) r3
            goto L_0x0230
        L_0x022f:
            r3 = 0
        L_0x0230:
            if (r3 != 0) goto L_0x0233
            return
        L_0x0233:
            boolean r4 = com.upuphone.xr.sapp.entity.AppUpdateInfoKt.isForceUpdate(r3)
            if (r4 == 0) goto L_0x0264
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.M
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            r5 = 0
            r4.setVisibility(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            r5 = 8
            r4.setVisibility(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.W
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r15)
            r2.setVisibility(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.M
            int r4 = com.upuphone.xr.sapp.R.string.update_now
            r2.setText(r4)
            goto L_0x0297
        L_0x0264:
            r5 = 8
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.M
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            r4.setVisibility(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            r2 = 0
            r4.setVisibility(r2)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r15)
            r4.setVisibility(r2)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.W
            int r4 = com.upuphone.xr.sapp.R.string.cancel
            r2.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.f
            int r4 = com.upuphone.xr.sapp.R.string.update_now
            r2.setText(r4)
        L_0x0297:
            com.upuphone.xr.sapp.entity.AppUpdateModel r2 = r3.getModal()
            java.lang.String r4 = "unknown"
            if (r2 == 0) goto L_0x02a7
            java.lang.String r2 = r2.getTitle()
            if (r2 == 0) goto L_0x02a7
            goto L_0x02a8
        L_0x02a7:
            r2 = r4
        L_0x02a8:
            com.upuphone.xr.sapp.entity.AppUpdateModel r3 = r3.getModal()
            if (r3 == 0) goto L_0x04d4
            java.lang.String r3 = r3.getContent()
            if (r3 == 0) goto L_0x04d4
            goto L_0x00d9
        L_0x02b6:
            android.content.Context r2 = r21.getContext()
            int r3 = com.upuphone.xr.sapp.R.string.flyme_link_content
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.i
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            r4 = 8
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            int r4 = com.upuphone.xr.sapp.R.string.cancel
            r3.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            int r4 = com.upuphone.xr.sapp.R.string.enable
            r3.setText(r4)
            goto L_0x0173
        L_0x02e3:
            java.lang.Object r4 = r21.getMExtra()
            boolean r4 = r4 instanceof com.upuphone.xr.sapp.glass.CompatibilityManager.ConsultResult
            if (r4 != 0) goto L_0x02ec
            return
        L_0x02ec:
            java.lang.Object r4 = r21.getMExtra()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r3)
            com.upuphone.xr.sapp.glass.CompatibilityManager$ConsultResult r4 = (com.upuphone.xr.sapp.glass.CompatibilityManager.ConsultResult) r4
            boolean r3 = r4.isForcedUpgrade()
            if (r3 == 0) goto L_0x0326
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.M
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
            r4 = 0
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
            r4 = 8
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.W
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r15)
            r2.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.M
            int r3 = com.upuphone.xr.sapp.R.string.go_to_update
            r2.setText(r3)
            goto L_0x0359
        L_0x0326:
            r4 = 8
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.M
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
            r2 = 0
            r3.setVisibility(r2)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r15)
            r3.setVisibility(r2)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.W
            int r3 = com.upuphone.xr.sapp.R.string.update_not_now
            r2.setText(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.f
            int r3 = com.upuphone.xr.sapp.R.string.go_to_update
            r2.setText(r3)
        L_0x0359:
            int r2 = com.upuphone.xr.sapp.R.string.app_upgrade
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            java.lang.Boolean r3 = com.upuphone.xr.sapp.BuildConfig.f6575a
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r14)
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x036d
            int r3 = com.upuphone.xr.sapp.R.string.app_upgrade_content_oversea
            goto L_0x036f
        L_0x036d:
            int r3 = com.upuphone.xr.sapp.R.string.app_upgrade_content
        L_0x036f:
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            goto L_0x00d9
        L_0x0375:
            java.lang.Object r4 = r21.getMExtra()
            boolean r4 = r4 instanceof com.upuphone.xr.sapp.glass.CompatibilityManager.ConsultResult
            if (r4 != 0) goto L_0x037e
            return
        L_0x037e:
            java.lang.Object r4 = r21.getMExtra()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r3)
            com.upuphone.xr.sapp.glass.CompatibilityManager$ConsultResult r4 = (com.upuphone.xr.sapp.glass.CompatibilityManager.ConsultResult) r4
            boolean r3 = r4.isForcedUpgrade()
            if (r3 == 0) goto L_0x03b8
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.M
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
            r4 = 0
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
            r4 = 8
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.W
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r15)
            r2.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.M
            int r3 = com.upuphone.xr.sapp.R.string.go_to_update
            r2.setText(r3)
            goto L_0x03eb
        L_0x03b8:
            r4 = 8
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.M
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
            r2 = 0
            r3.setVisibility(r2)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r15)
            r3.setVisibility(r2)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.W
            int r3 = com.upuphone.xr.sapp.R.string.update_not_now
            r2.setText(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.f
            int r3 = com.upuphone.xr.sapp.R.string.go_to_update
            r2.setText(r3)
        L_0x03eb:
            int r2 = com.upuphone.xr.sapp.R.string.glass_upgrade
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            int r3 = com.upuphone.xr.sapp.R.string.glass_upgrade_content_phone
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            goto L_0x00d9
        L_0x03f9:
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.unicron_update_nearby_devices_tips
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.i
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            r4 = 8
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            int r4 = com.upuphone.xr.sapp.R.string.cancel
            r3.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            int r4 = com.upuphone.xr.sapp.R.string.go_to_open
            r3.setText(r4)
            goto L_0x0173
        L_0x0426:
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.unicron_update_hotspot_tips
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.i
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            r4 = 8
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            int r4 = com.upuphone.xr.sapp.R.string.cancel
            r3.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            int r4 = com.upuphone.xr.sapp.R.string.go_to_close
            r3.setText(r4)
            goto L_0x0173
        L_0x0453:
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.unicron_update_wifi_tips
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.i
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            r4 = 8
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            int r4 = com.upuphone.xr.sapp.R.string.cancel
            r3.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            int r4 = com.upuphone.xr.sapp.R.string.go_to_open
            r3.setText(r4)
            goto L_0x0173
        L_0x0480:
            android.content.res.Resources r3 = r21.getResources()
            int r4 = com.upuphone.xr.sapp.R.string.unicron_update_transfer_tips
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            int r4 = com.upuphone.xr.sapp.R.string.unicron_update_on_glass_tips
            java.lang.String r4 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r5 = r0.d
            android.widget.ImageView r5 = r5.B
            java.lang.String r7 = "ivContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
            r7 = 0
            r5.setVisibility(r7)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r5 = r0.d
            android.widget.ImageView r5 = r5.B
            int r7 = com.upuphone.xr.sapp.R.mipmap.ic_unicron_update_on_glass
            r5.setImageResource(r7)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r5 = r0.d
            com.meizu.common.widget.MzButton r5 = r5.W
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r15)
            r7 = 8
            r5.setVisibility(r7)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r5 = r0.d
            com.meizu.common.widget.MzButton r5 = r5.f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            r5.setVisibility(r7)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.M
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            r5 = 0
            r2.setVisibility(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.M
            int r5 = com.upuphone.xr.sapp.R.string.i_known
            r2.setText(r5)
        L_0x04d3:
            r2 = r3
        L_0x04d4:
            r3 = r4
            goto L_0x00d9
        L_0x04d7:
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.unicron_update_permission_tips
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            int r3 = com.upuphone.xr.sapp.R.string.unicron_update_permission_tips_content
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.ignore
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.enable
            r4.setText(r5)
            goto L_0x00d9
        L_0x04fe:
            java.lang.Boolean r2 = com.upuphone.xr.sapp.BuildConfig.f6575a
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r14)
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x050c
            int r2 = com.upuphone.xr.sapp.R.string.permission_read_write_title_oversea
            goto L_0x050e
        L_0x050c:
            int r2 = com.upuphone.xr.sapp.R.string.permission_read_write_title
        L_0x050e:
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            com.upuphone.xr.sapp.utils.OSHelper r3 = com.upuphone.xr.sapp.utils.OSHelper.f7904a
            boolean r3 = r3.e()
            if (r3 == 0) goto L_0x0521
            int r3 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_storage_text
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            goto L_0x0527
        L_0x0521:
            int r3 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_media_visual_text
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
        L_0x0527:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.go_to_open
            r4.setText(r5)
            goto L_0x00d9
        L_0x053b:
            int r2 = com.upuphone.xr.sapp.R.string.permission_read_calendar
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            com.upuphone.xr.sapp.permission.PermissionHelper r3 = com.upuphone.xr.sapp.permission.PermissionHelper.f7819a
            android.content.Context r5 = r21.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)
            com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils r4 = com.upuphone.xr.sapp.utils.PermissionAndStateCheckUtils.f7907a
            java.lang.String[] r4 = r4.r()
            com.upuphone.xr.sapp.entity.PermissionNote r3 = r3.e(r5, r4)
            if (r3 == 0) goto L_0x055d
            java.lang.String r3 = r3.getContent()
            if (r3 == 0) goto L_0x055d
            goto L_0x0563
        L_0x055d:
            int r3 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_calendar_text
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
        L_0x0563:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.open_notification
            r4.setText(r5)
            goto L_0x00d9
        L_0x0577:
            int r2 = com.upuphone.xr.sapp.R.string.permission_read_call_log
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            int r3 = com.upuphone.xr.sapp.R.string.permission_read_call_log_tips
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.open_notification
            r4.setText(r5)
            goto L_0x00d9
        L_0x0597:
            int r2 = com.upuphone.xr.sapp.R.string.close_service_title
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            java.lang.Boolean r3 = com.upuphone.xr.sapp.BuildConfig.b
            java.lang.String r4 = "THIRD_PLATFOM"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x05b1
            int r3 = com.upuphone.xr.sapp.R.string.close_service_content
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            goto L_0x05b7
        L_0x05b1:
            int r3 = com.upuphone.xr.sapp.R.string.close_navi_notification
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
        L_0x05b7:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.word_close
            r4.setText(r5)
            goto L_0x00d9
        L_0x05cb:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            android.widget.TextView r2 = r2.i
            android.text.method.MovementMethod r4 = android.text.method.LinkMovementMethod.getInstance()
            r2.setMovementMethod(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            android.widget.TextView r2 = r2.i
            r4 = 0
            r2.setHighlightColor(r4)
            int r2 = com.upuphone.xr.sapp.R.string.about_cancel_agree_confirm
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            com.upuphone.xr.sapp.contract.ContractEntry r4 = com.upuphone.xr.sapp.contract.ContractEntry.f6691a
            java.lang.String r4 = r4.d()
            int r5 = com.upuphone.xr.sapp.R.string.cancel_agree_notify
            java.lang.String r5 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r5)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            java.lang.String r4 = "\n"
            r6.append(r4)
            r6.append(r5)
            java.lang.String r4 = r6.toString()
            androidx.constraintlayout.widget.ConstraintSet r5 = new androidx.constraintlayout.widget.ConstraintSet
            r5.<init>()
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r6 = r0.d
            androidx.constraintlayout.widget.ConstraintLayout r6 = r6.Y
            r5.o(r6)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r6 = r0.d
            android.widget.LinearLayout r6 = r6.u
            int r6 = r6.getId()
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r7 = r0.d
            android.widget.ScrollView r7 = r7.E
            int r7 = r7.getId()
            r8 = 4
            r9 = 3
            r5.r(r6, r9, r7, r8)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r6 = r0.d
            androidx.constraintlayout.widget.ConstraintLayout r6 = r6.Y
            r5.i(r6)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r5 = r0.d
            android.widget.LinearLayout r5 = r5.u
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
            r3 = 0
            r5.setVisibility(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r5 = r0.d
            android.widget.CheckBox r5 = r5.t
            r5.setChecked(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.v
            int r5 = com.upuphone.xr.sapp.R.string.cancel_agree_check_notify
            r3.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.i
            r5 = 1
            android.text.SpannableString r6 = r0.J(r1, r4, r5)
            r3.setText(r6)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r3.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            int r5 = com.upuphone.xr.sapp.R.string.about_cancel_agree_confirm
            r3.setText(r5)
            goto L_0x04d4
        L_0x0667:
            int r2 = com.upuphone.xr.sapp.R.string.permission_reminder_title_location
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            int r3 = com.upuphone.xr.sapp.R.string.glass_update_need_fine_location
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.open_notification
            r4.setText(r5)
            goto L_0x00d9
        L_0x0687:
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.glass_update_need_close_hotspot
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.i
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            r4 = 8
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            int r4 = com.upuphone.xr.sapp.R.string.cancel
            r3.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            int r4 = com.upuphone.xr.sapp.R.string.go_to_close
            r3.setText(r4)
            goto L_0x0173
        L_0x06b4:
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.glass_update_need_nearby_wifi_devices
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.i
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            r4 = 8
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            int r4 = com.upuphone.xr.sapp.R.string.cancel
            r3.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            int r4 = com.upuphone.xr.sapp.R.string.go_to_open
            r3.setText(r4)
            goto L_0x0173
        L_0x06e1:
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.glass_update_need_gps
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            int r3 = com.upuphone.xr.sapp.R.string.glass_update_need_gps_desc
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.go_to_open
            r4.setText(r5)
            goto L_0x00d9
        L_0x0708:
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.glass_update_need_wifi
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.i
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            r4 = 8
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            int r4 = com.upuphone.xr.sapp.R.string.cancel
            r3.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            int r4 = com.upuphone.xr.sapp.R.string.go_to_open
            r3.setText(r4)
            goto L_0x0173
        L_0x0735:
            int r2 = com.upuphone.xr.sapp.R.string.unbound_device_title
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            int r3 = com.upuphone.xr.sapp.R.string.unbound_device_content
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.app_confirm
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            android.widget.TextView r4 = r4.m0
            int r5 = r21.getLeft()
            r4.setGravity(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            android.widget.TextView r4 = r4.i
            int r5 = r21.getLeft()
            r4.setGravity(r5)
            goto L_0x00d9
        L_0x076b:
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.word_name
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.i
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            r4 = 8
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.FrameLayout r3 = r3.y
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r8)
            r4 = 0
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.upuphone.xr.sapp.view.DrawableEditText r3 = r3.w
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r12)
            r3.setVisibility(r4)
            java.lang.Object r3 = r21.getMExtra()
            boolean r3 = r3 instanceof java.lang.String
            if (r3 == 0) goto L_0x07ab
            java.lang.Object r3 = r21.getMExtra()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r10)
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x07ad
        L_0x07ab:
            r3 = r17
        L_0x07ad:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.app_confirm
            r4.setText(r5)
        L_0x07bf:
            r4 = r3
            r3 = r17
            goto L_0x00db
        L_0x07c4:
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.ring_name
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.i
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            r4 = 8
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.FrameLayout r3 = r3.y
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r8)
            r4 = 0
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.upuphone.xr.sapp.view.DrawableEditText r3 = r3.w
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r12)
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.utils.ControlUtils r3 = com.upuphone.xr.sapp.utils.ControlUtils.f7858a
            com.upuphone.xr.sapp.entity.UnicronBatteryInfo r3 = r3.m()
            java.lang.String r3 = r3.getDevName()
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.app_confirm
            r4.setText(r5)
            goto L_0x07bf
        L_0x080f:
            android.content.Context r3 = r21.getContext()
            int r4 = com.upuphone.xr.sapp.R.string.glass_unbound_when_no_connect
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            android.content.Context r4 = r21.getContext()
            int r7 = com.upuphone.xr.sapp.R.string.glass_unbound_when_no_connect_tip
            java.lang.String r4 = r4.getString(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r5 = r0.d
            com.meizu.common.widget.MzButton r5 = r5.W
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r15)
            r7 = 8
            r5.setVisibility(r7)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r5 = r0.d
            com.meizu.common.widget.MzButton r5 = r5.f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            r5.setVisibility(r7)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.M
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            r5 = 0
            r2.setVisibility(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.M
            android.content.Context r5 = r21.getContext()
            int r6 = com.upuphone.xr.sapp.R.string.i_known
            java.lang.String r5 = r5.getString(r6)
            r2.setText(r5)
            goto L_0x04d3
        L_0x085d:
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.glass_update_fail_msg
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.i
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            r4 = 8
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            int r4 = com.upuphone.xr.sapp.R.string.cancel
            r3.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            int r4 = com.upuphone.xr.sapp.R.string.retry
            r3.setText(r4)
            goto L_0x0173
        L_0x088a:
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.new_glass_update_found_param
            java.lang.Object r4 = r21.getMExtra()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r10)
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            java.lang.String r2 = r2.getString(r3, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.i
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            r4 = 8
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.i
            r4 = 1
            r3.setGravity(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            int r4 = com.upuphone.xr.sapp.R.string.update_not_now
            r3.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            int r4 = com.upuphone.xr.sapp.R.string.go_to_update
            r3.setText(r4)
            goto L_0x0173
        L_0x08ca:
            android.content.res.Resources r3 = r21.getResources()
            int r4 = com.upuphone.xr.sapp.R.string.always_allow_access_view_glasses_tip
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r15)
            r5 = 8
            r4.setVisibility(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            r4.setVisibility(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.M
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            r4 = 0
            r2.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.M
            android.content.Context r4 = r21.getContext()
            int r5 = com.upuphone.xr.sapp.R.string.i_known
            java.lang.String r4 = r4.getString(r5)
            r2.setText(r4)
        L_0x0909:
            r2 = r3
            goto L_0x0173
        L_0x090c:
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.view_float_window_permission_title
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            android.content.res.Resources r3 = r21.getResources()
            int r4 = com.upuphone.xr.sapp.R.string.view_float_window_permission_content
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.app_confirm
            r4.setText(r5)
            goto L_0x00d9
        L_0x093a:
            java.lang.Object r2 = r21.getMExtra()
            java.lang.String r3 = "null cannot be cast to non-null type com.upuphone.xr.sapp.entity.PermissionNote"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r3)
            com.upuphone.xr.sapp.entity.PermissionNote r2 = (com.upuphone.xr.sapp.entity.PermissionNote) r2
            java.lang.String r3 = r2.getTitle()
            java.lang.String r2 = r2.getContent()
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.open_notification
            r4.setText(r5)
        L_0x095f:
            r4 = r17
            r7 = r18
            r6 = r19
            r20 = r3
            r3 = r2
            r2 = r20
            goto L_0x1700
        L_0x096c:
            int r3 = com.upuphone.xr.sapp.R.string.unable_connect_view_glasses
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.utils.PhoneTypeUtils r5 = com.upuphone.xr.sapp.utils.PhoneTypeUtils.f7912a
            boolean r5 = r5.d()
            if (r5 == 0) goto L_0x098f
            android.content.Context r5 = r21.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)
            int r4 = com.upuphone.xr.sapp.R.string.unable_connect_view_glasses_detail_huawei
            int r7 = com.upuphone.xr.sapp.R.string.adapted_phones
            com.honey.account.x8.g r8 = new com.honey.account.x8.g
            r8.<init>(r0, r1)
            java.lang.CharSequence r4 = com.upuphone.xr.sapp.vu.utils.ContextExtKt.a(r5, r4, r7, r8)
            goto L_0x09a3
        L_0x098f:
            android.content.Context r5 = r21.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)
            int r4 = com.upuphone.xr.sapp.R.string.unable_connect_view_glasses_detail
            int r7 = com.upuphone.xr.sapp.R.string.adapted_phones
            com.honey.account.x8.m r8 = new com.honey.account.x8.m
            r8.<init>(r0, r1)
            java.lang.CharSequence r4 = com.upuphone.xr.sapp.vu.utils.ContextExtKt.a(r5, r4, r7, r8)
        L_0x09a3:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r5 = r0.d
            android.widget.TextView r5 = r5.i
            android.text.method.MovementMethod r7 = android.text.method.LinkMovementMethod.getInstance()
            r5.setMovementMethod(r7)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r5 = r0.d
            com.meizu.common.widget.MzButton r5 = r5.M
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r6 = 0
            r5.setVisibility(r6)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r5 = r0.d
            com.meizu.common.widget.MzButton r5 = r5.f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            r2 = 8
            r5.setVisibility(r2)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r5 = r0.d
            com.meizu.common.widget.MzButton r5 = r5.W
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r15)
            r5.setVisibility(r2)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.M
            int r5 = com.upuphone.xr.sapp.R.string.i_known
            r2.setText(r5)
            goto L_0x04d3
        L_0x09da:
            int r2 = com.upuphone.xr.sapp.R.string.remove_myvu_tip_title
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            int r3 = com.upuphone.xr.sapp.R.string.remove_myvu_tip_content
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.app_confirm
            r4.setText(r5)
            goto L_0x00d9
        L_0x09fa:
            int r2 = com.upuphone.xr.sapp.R.string.remove_view_tip_title
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            int r4 = com.upuphone.xr.sapp.R.string.cancel
            r3.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            int r4 = com.upuphone.xr.sapp.R.string.app_confirm
            r3.setText(r4)
            goto L_0x0173
        L_0x0a14:
            java.lang.Object r2 = r21.getMExtra()
            boolean r3 = r2 instanceof com.upuphone.xr.sapp.entity.AppUpdateInfo
            if (r3 == 0) goto L_0x0a1f
            com.upuphone.xr.sapp.entity.AppUpdateInfo r2 = (com.upuphone.xr.sapp.entity.AppUpdateInfo) r2
            goto L_0x0a20
        L_0x0a1f:
            r2 = 0
        L_0x0a20:
            if (r2 != 0) goto L_0x0a23
            return
        L_0x0a23:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.i
            android.text.method.MovementMethod r4 = android.text.method.LinkMovementMethod.getInstance()
            r3.setMovementMethod(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.i
            r4 = 0
            r3.setHighlightColor(r4)
            com.upuphone.xr.sapp.entity.ProtocolModel r3 = r2.getProtocol()
            if (r3 == 0) goto L_0x0a41
            java.lang.String r3 = r3.getProtoTitle()
            goto L_0x0a42
        L_0x0a41:
            r3 = 0
        L_0x0a42:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            com.upuphone.xr.sapp.entity.ProtocolModel r2 = r2.getProtocol()
            if (r2 == 0) goto L_0x0a51
            java.lang.String r2 = r2.getProtoContent()
            goto L_0x0a52
        L_0x0a51:
            r2 = 0
        L_0x0a52:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            android.widget.TextView r4 = r4.i
            android.text.SpannableString r5 = r0.x(r2)
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.permission_refuse
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.agree
            java.lang.String r5 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r5)
            r4.setText(r5)
            goto L_0x095f
        L_0x0a79:
            int r2 = com.upuphone.xr.sapp.R.string.permission_camera_dialog_title
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            int r3 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_camera_text
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.go_to_open
            r4.setText(r5)
            goto L_0x00d9
        L_0x0a99:
            int r2 = com.upuphone.xr.sapp.R.string.permission_record_audio_dialog_title
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            int r3 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_microphone_text
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.go_to_open
            r4.setText(r5)
            goto L_0x00d9
        L_0x0ab9:
            android.content.Context r2 = r21.getContext()
            int r3 = com.upuphone.xr.sapp.R.string.wakeup_record_conflict_title
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            android.content.Context r3 = r21.getContext()
            int r4 = com.upuphone.xr.sapp.R.string.wakeup_record_conflict_tips
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.go_to_set
            r4.setText(r5)
            goto L_0x00d9
        L_0x0ae7:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            android.widget.TextView r2 = r2.i
            android.text.method.MovementMethod r3 = android.text.method.LinkMovementMethod.getInstance()
            r2.setMovementMethod(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            android.widget.TextView r2 = r2.i
            r3 = 0
            r2.setHighlightColor(r3)
            int r2 = com.upuphone.xr.sapp.R.string.about_cancel_agree_confirm
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            int r3 = com.upuphone.xr.sapp.R.string.myvu_cancel_agree_privacy_tici
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            android.widget.TextView r4 = r4.i
            r5 = 1
            android.text.SpannableString r6 = r0.J(r1, r3, r5)
            r4.setText(r6)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.permission_refuse
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.about_cancel_agree_confirm
            r4.setText(r5)
            goto L_0x00d9
        L_0x0b26:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            android.widget.TextView r2 = r2.i
            android.text.method.MovementMethod r3 = android.text.method.LinkMovementMethod.getInstance()
            r2.setMovementMethod(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            android.widget.TextView r2 = r2.i
            r3 = 0
            r2.setHighlightColor(r3)
            int r2 = com.upuphone.xr.sapp.R.string.about_cancel_agree_confirm
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            int r3 = com.upuphone.xr.sapp.R.string.myvu_cancel_agree_privacy_tran
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            android.widget.TextView r4 = r4.i
            r5 = 1
            android.text.SpannableString r6 = r0.J(r1, r3, r5)
            r4.setText(r6)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.permission_refuse
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.about_cancel_agree_confirm
            r4.setText(r5)
            goto L_0x00d9
        L_0x0b65:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            android.widget.TextView r2 = r2.i
            android.text.method.MovementMethod r3 = android.text.method.LinkMovementMethod.getInstance()
            r2.setMovementMethod(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            android.widget.TextView r2 = r2.i
            r3 = 0
            r2.setHighlightColor(r3)
            int r2 = com.upuphone.xr.sapp.R.string.about_cancel_agree_confirm
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            int r3 = com.upuphone.xr.sapp.R.string.myvu_cancel_agree_privacy_navi
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            android.widget.TextView r4 = r4.i
            r5 = 1
            android.text.SpannableString r6 = r0.J(r1, r3, r5)
            r4.setText(r6)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.permission_refuse
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.about_cancel_agree_confirm
            r4.setText(r5)
            goto L_0x00d9
        L_0x0ba4:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            android.widget.TextView r2 = r2.i
            android.text.method.MovementMethod r3 = android.text.method.LinkMovementMethod.getInstance()
            r2.setMovementMethod(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            android.widget.TextView r2 = r2.i
            r3 = 0
            r2.setHighlightColor(r3)
            int r2 = com.upuphone.xr.sapp.R.string.about_cancel_agree_confirm
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            int r3 = com.upuphone.xr.sapp.R.string.myvu_cancel_agree_privacy_asst
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            android.widget.TextView r4 = r4.i
            r5 = 1
            android.text.SpannableString r6 = r0.J(r1, r3, r5)
            r4.setText(r6)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.permission_refuse
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.about_cancel_agree_confirm
            r4.setText(r5)
            goto L_0x00d9
        L_0x0be3:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            android.widget.TextView r2 = r2.i
            android.text.method.MovementMethod r3 = android.text.method.LinkMovementMethod.getInstance()
            r2.setMovementMethod(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            android.widget.TextView r2 = r2.i
            r3 = 0
            r2.setHighlightColor(r3)
            int r2 = com.upuphone.xr.sapp.R.string.myvu_modules_privacy_common_title
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            int r3 = com.upuphone.xr.sapp.R.string.myvu_region_privacy_tici
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            android.widget.TextView r4 = r4.i
            r5 = 1
            android.text.SpannableString r6 = r0.J(r1, r3, r5)
            r4.setText(r6)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.agree
            java.lang.String r5 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r5)
            r4.setText(r5)
            goto L_0x00d9
        L_0x0c26:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            android.widget.TextView r2 = r2.i
            android.text.method.MovementMethod r3 = android.text.method.LinkMovementMethod.getInstance()
            r2.setMovementMethod(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            android.widget.TextView r2 = r2.i
            r3 = 0
            r2.setHighlightColor(r3)
            int r2 = com.upuphone.xr.sapp.R.string.myvu_modules_privacy_common_title
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            int r3 = com.upuphone.xr.sapp.R.string.myvu_region_privacy_tran
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            android.widget.TextView r4 = r4.i
            r5 = 1
            android.text.SpannableString r6 = r0.J(r1, r3, r5)
            r4.setText(r6)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.agree
            java.lang.String r5 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r5)
            r4.setText(r5)
            goto L_0x00d9
        L_0x0c69:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            android.widget.TextView r2 = r2.i
            android.text.method.MovementMethod r3 = android.text.method.LinkMovementMethod.getInstance()
            r2.setMovementMethod(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            android.widget.TextView r2 = r2.i
            r3 = 0
            r2.setHighlightColor(r3)
            int r2 = com.upuphone.xr.sapp.R.string.myvu_modules_privacy_common_title
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            int r3 = com.upuphone.xr.sapp.R.string.myvu_region_privacy_navi
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            android.widget.TextView r4 = r4.i
            r5 = 1
            android.text.SpannableString r6 = r0.J(r1, r3, r5)
            r4.setText(r6)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.agree
            java.lang.String r5 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r5)
            r4.setText(r5)
            goto L_0x00d9
        L_0x0cac:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            android.widget.TextView r2 = r2.i
            android.text.method.MovementMethod r3 = android.text.method.LinkMovementMethod.getInstance()
            r2.setMovementMethod(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            android.widget.TextView r2 = r2.i
            r3 = 0
            r2.setHighlightColor(r3)
            int r2 = com.upuphone.xr.sapp.R.string.myvu_modules_privacy_common_title
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            int r3 = com.upuphone.xr.sapp.R.string.myvu_region_privacy_asst
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            android.widget.TextView r4 = r4.i
            r5 = 1
            android.text.SpannableString r6 = r0.J(r1, r3, r5)
            r4.setText(r6)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.agree
            java.lang.String r5 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r5)
            r4.setText(r5)
            goto L_0x00d9
        L_0x0cef:
            android.content.Context r2 = r21.getContext()
            int r3 = com.upuphone.xr.sapp.R.string.wakeup_record_clear
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            android.content.Context r3 = r21.getContext()
            int r4 = com.upuphone.xr.sapp.R.string.wakeup_record_clear_tips
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.vp_clear
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            android.content.Context r5 = r21.getContext()
            int r6 = com.upuphone.xr.sapp.R.color.vp_separate_role_clear_confirm_bt
            int r5 = androidx.core.content.ContextCompat.getColor(r5, r6)
            r4.setTextColor(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            android.content.Context r5 = r21.getContext()
            int r6 = com.upuphone.xr.sapp.R.drawable.bg_confirm_button_warning
            android.graphics.drawable.Drawable r5 = androidx.core.content.ContextCompat.getDrawable(r5, r6)
            r4.setBackground(r5)
            goto L_0x00d9
        L_0x0d3f:
            int r2 = com.upuphone.xr.sapp.R.string.permission_dial_read_phone_state_title
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            int r3 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_phone_text
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.open_notification
            r4.setText(r5)
            goto L_0x00d9
        L_0x0d5f:
            int r2 = com.upuphone.xr.sapp.R.string.switch_language_toast_title
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            int r3 = com.upuphone.xr.sapp.R.string.switch_language_toast_content
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.app_confirm
            r4.setText(r5)
            goto L_0x00d9
        L_0x0d7f:
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.customer_server_number_tel
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            int r4 = com.upuphone.xr.sapp.R.string.cancel
            r3.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            int r4 = com.upuphone.xr.sapp.R.string.customer_server_number_call
            r3.setText(r4)
            goto L_0x0173
        L_0x0da0:
            int r2 = com.upuphone.xr.sapp.R.string.permission_reminder_title_bluetooth
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            int r3 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_nearby_devices_text
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.open_notification
            r4.setText(r5)
            goto L_0x00d9
        L_0x0dc0:
            int r2 = com.upuphone.xr.sapp.R.string.permission_reminder_title_location
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            int r3 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_location_text
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.open_notification
            r4.setText(r5)
            goto L_0x00d9
        L_0x0de0:
            int r2 = com.upuphone.xr.sapp.R.string.permission_reminder_title_contact
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            int r3 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_contacts_text
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.open_notification
            r4.setText(r5)
            goto L_0x00d9
        L_0x0e00:
            int r2 = com.upuphone.xr.sapp.R.string.permission_reminder_title_dial
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            int r3 = com.upuphone.xr.sapp.R.string.permission_reminder_title_dial_subtitle
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.open_notification
            r4.setText(r5)
            goto L_0x00d9
        L_0x0e20:
            int r2 = com.upuphone.xr.sapp.R.string.permission_reminder_title_store
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            int r3 = com.upuphone.xr.sapp.R.string.permission_reminder_subtitle
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.open_notification
            r4.setText(r5)
            goto L_0x00d9
        L_0x0e40:
            int r2 = com.upuphone.xr.sapp.R.string.permission_reminder_title_notification
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            int r3 = com.upuphone.xr.sapp.R.string.permission_reminder_subtitle
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.open_notification
            r4.setText(r5)
            goto L_0x00d9
        L_0x0e60:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            androidx.constraintlayout.widget.ConstraintLayout r2 = r2.J
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)
            r3 = 8
            r2.setVisibility(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            androidx.constraintlayout.widget.ConstraintLayout r2 = r2.e
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r11)
            r2.setVisibility(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.airbnb.lottie.LottieAnimationView r2 = r2.F
            r2.cancelAnimation()
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            androidx.constraintlayout.widget.ConstraintLayout r2 = r2.m
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r9)
            r2.setVisibility(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            androidx.constraintlayout.widget.ConstraintLayout r2 = r2.K
            java.lang.String r3 = "notificationConnectMain"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r3 = 0
            r2.setVisibility(r3)
            java.lang.Object r2 = r21.getMExtra()
            boolean r2 = r2 instanceof com.upuphone.xr.sapp.entity.NetDevice
            if (r2 == 0) goto L_0x0ee0
            java.lang.Object r2 = r21.getMExtra()
            java.lang.String r3 = "null cannot be cast to non-null type com.upuphone.xr.sapp.entity.NetDevice"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r3)
            com.upuphone.xr.sapp.entity.NetDevice r2 = (com.upuphone.xr.sapp.entity.NetDevice) r2
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.q0
            java.lang.String r4 = r2.getMDeviceName()
            if (r4 == 0) goto L_0x0eb2
            goto L_0x0ebc
        L_0x0eb2:
            android.content.Context r4 = r21.getContext()
            int r5 = com.upuphone.xr.sapp.R.string.glass_default_name
            java.lang.String r4 = r4.getString(r5)
        L_0x0ebc:
            r3.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.n0
            com.upuphone.xr.sapp.entity.ConnectState r2 = r2.getState()
            com.upuphone.xr.sapp.entity.ConnectState r4 = com.upuphone.xr.sapp.entity.ConnectState.CONNECTED
            if (r2 != r4) goto L_0x0ed6
            android.content.Context r2 = r21.getContext()
            int r4 = com.upuphone.xr.sapp.R.string.device_connect
        L_0x0ed1:
            java.lang.String r2 = r2.getString(r4)
            goto L_0x0edd
        L_0x0ed6:
            android.content.Context r2 = r21.getContext()
            int r4 = com.upuphone.xr.sapp.R.string.device_disconnected
            goto L_0x0ed1
        L_0x0edd:
            r3.setText(r2)
        L_0x0ee0:
            r2 = r17
            r3 = r2
            goto L_0x0175
        L_0x0ee5:
            android.content.Context r2 = r21.getContext()
            int r3 = com.upuphone.xr.sapp.R.string.permission_reminder_title_bluetooth
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            android.content.Context r3 = r21.getContext()
            int r4 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_nearby_devices_text
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.open_notification
            r4.setText(r5)
            goto L_0x00d9
        L_0x0f13:
            android.content.Context r2 = r21.getContext()
            int r3 = com.upuphone.xr.sapp.R.string.permission_reminder_title_location
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            android.content.Context r3 = r21.getContext()
            int r4 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_location_text
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.open_notification
            r4.setText(r5)
            goto L_0x00d9
        L_0x0f41:
            android.content.Context r2 = r21.getContext()
            int r3 = com.upuphone.xr.sapp.R.string.should_close_glass_wifi
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            android.content.Context r3 = r21.getContext()
            int r4 = com.upuphone.xr.sapp.R.string.dlna_disabled_warning
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.app_confirm
            r4.setText(r5)
            goto L_0x00d9
        L_0x0f6f:
            android.content.Context r2 = r21.getContext()
            int r4 = com.upuphone.xr.sapp.R.string.screen_cast
            java.lang.String r2 = r2.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            java.lang.Object r4 = r21.getMExtra()
            boolean r4 = r4 instanceof java.lang.String
            if (r4 == 0) goto L_0x0f9b
            java.lang.Object r4 = r21.getMExtra()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r10)
            java.lang.String r4 = (java.lang.String) r4
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x0f9b
            java.lang.Object r2 = r21.getMExtra()
            java.lang.String r2 = java.lang.String.valueOf(r2)
        L_0x0f9b:
            android.content.Context r4 = r21.getContext()
            int r6 = com.upuphone.xr.sapp.R.string.connect_wifi_by_close_p2p
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            java.lang.String r2 = r4.getString(r6, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.app_confirm
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            android.widget.LinearLayout r4 = r4.u
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r3)
            r3 = 0
            r4.setVisibility(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.m0
            r4 = 1063675494(0x3f666666, float:0.9)
            r3.setAlpha(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.m0
            r4 = 8388611(0x800003, float:1.1754948E-38)
            r3.setGravity(r4)
            goto L_0x0173
        L_0x0fdf:
            int r2 = com.upuphone.xr.sapp.R.string.abandon_adjust_mini
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            int r4 = com.upuphone.xr.sapp.R.string.cancel
            r3.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            int r4 = com.upuphone.xr.sapp.R.string.abandon
            r3.setText(r4)
            goto L_0x0173
        L_0x0ff9:
            int r2 = com.upuphone.xr.sapp.R.string.install_quick_worker
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            int r4 = com.upuphone.xr.sapp.R.string.cancel
            r3.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            int r4 = com.upuphone.xr.sapp.R.string.confirm_install
            r3.setText(r4)
            goto L_0x0173
        L_0x1013:
            int r2 = com.upuphone.xr.sapp.R.string.install_tiktok
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            int r4 = com.upuphone.xr.sapp.R.string.cancel
            r3.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            int r4 = com.upuphone.xr.sapp.R.string.confirm_install
            r3.setText(r4)
            goto L_0x0173
        L_0x102d:
            r18 = r3
            r19 = r4
            int r2 = com.upuphone.xr.sapp.R.string.abandon_adjust
            java.lang.String r2 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r2)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            int r4 = com.upuphone.xr.sapp.R.string.cancel
            r3.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            int r4 = com.upuphone.xr.sapp.R.string.abandon
            r3.setText(r4)
            goto L_0x0173
        L_0x104b:
            r18 = r3
            r19 = r4
            android.content.Context r2 = r21.getContext()
            int r3 = com.upuphone.xr.sapp.R.string.permission_request
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            android.content.Context r3 = r21.getContext()
            java.lang.Boolean r4 = com.upuphone.xr.sapp.BuildConfig.f6575a
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r14)
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x106e
            int r4 = com.upuphone.xr.sapp.R.string.myvu_permission_request_tips_oversea
            goto L_0x1070
        L_0x106e:
            int r4 = com.upuphone.xr.sapp.R.string.myvu_permission_request_tips
        L_0x1070:
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            android.content.Context r5 = r21.getContext()
            int r6 = com.upuphone.xr.sapp.R.string.set_out
            java.lang.String r5 = r5.getString(r6)
            r4.setText(r5)
            goto L_0x00d9
        L_0x1093:
            r18 = r3
            r19 = r4
            android.content.Context r2 = r21.getContext()
            int r3 = com.upuphone.xr.sapp.R.string.should_open_translation
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            android.content.Context r3 = r21.getContext()
            int r4 = com.upuphone.xr.sapp.R.string.auto_exit_when_naving
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.app_confirm
            r4.setText(r5)
            goto L_0x00d9
        L_0x10c5:
            r18 = r3
            r19 = r4
            android.content.Context r2 = r21.getContext()
            int r3 = com.upuphone.xr.sapp.R.string.should_go_to_check
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            android.content.Context r3 = r21.getContext()
            int r4 = com.upuphone.xr.sapp.R.string.itinerary_change_tips
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            android.content.Context r5 = r21.getContext()
            int r6 = com.upuphone.xr.sapp.R.string.set_out
            java.lang.String r5 = r5.getString(r6)
            r4.setText(r5)
            goto L_0x00d9
        L_0x10ff:
            r18 = r3
            r19 = r4
            android.content.Context r2 = r21.getContext()
            java.lang.Boolean r3 = com.upuphone.xr.sapp.BuildConfig.f6575a
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r14)
            boolean r4 = r3.booleanValue()
            if (r4 == 0) goto L_0x1115
            int r4 = com.upuphone.xr.sapp.R.string.enable_myvu_backgroud_behavior_oversea
            goto L_0x1117
        L_0x1115:
            int r4 = com.upuphone.xr.sapp.R.string.enable_myvu_backgroud_behavior
        L_0x1117:
            java.lang.String r2 = r2.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            android.content.Context r4 = r21.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r14)
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x112e
            int r3 = com.upuphone.xr.sapp.R.string.myvu_backgroud_behavior_tips_oversea
            goto L_0x1130
        L_0x112e:
            int r3 = com.upuphone.xr.sapp.R.string.myvu_backgroud_behavior_tips
        L_0x1130:
            java.lang.String r3 = r4.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.open_notification
            r4.setText(r5)
            goto L_0x00d9
        L_0x114b:
            r18 = r3
            r19 = r4
            android.content.res.Resources r3 = r21.getResources()
            int r4 = com.upuphone.xr.sapp.R.string.glass_is_updating_tips
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            android.widget.TextView r4 = r4.i
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r13)
            r5 = 8
            r4.setVisibility(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r15)
            r4.setVisibility(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            r4.setVisibility(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.M
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            r4 = 0
            r2.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.M
            int r4 = com.upuphone.xr.sapp.R.string.i_known
            r2.setText(r4)
            goto L_0x0909
        L_0x1192:
            r18 = r3
            r19 = r4
            java.lang.Boolean r2 = com.upuphone.xr.sapp.BuildConfig.f6575a
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r14)
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x11af
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.float_permission_title_oversea
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            goto L_0x11bc
        L_0x11af:
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.float_permission_title
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
        L_0x11bc:
            android.content.res.Resources r3 = r21.getResources()
            int r4 = com.upuphone.xr.sapp.R.string.float_permission_content
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.app_confirm
            r4.setText(r5)
            goto L_0x00d9
        L_0x11dd:
            r18 = r3
            r19 = r4
            java.lang.Object r3 = r21.getMExtra()
            boolean r3 = r3 instanceof java.lang.String
            if (r3 == 0) goto L_0x11f3
            java.lang.Object r3 = r21.getMExtra()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r10)
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x11f5
        L_0x11f3:
            java.lang.String r3 = "AR Glass"
        L_0x11f5:
            android.content.Context r4 = r21.getContext()
            int r7 = com.upuphone.xr.sapp.R.string.glass_unbound
            java.lang.String r4 = r4.getString(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            android.content.Context r7 = r21.getContext()
            int r8 = com.upuphone.xr.sapp.R.string.device_unbound_content
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r3 = r7.getString(r8, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r5 = r0.d
            com.meizu.common.widget.MzButton r5 = r5.W
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r15)
            r7 = 8
            r5.setVisibility(r7)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r5 = r0.d
            com.meizu.common.widget.MzButton r5 = r5.f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            r5.setVisibility(r7)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.M
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            r5 = 0
            r2.setVisibility(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.M
            android.content.Context r5 = r21.getContext()
            int r6 = com.upuphone.xr.sapp.R.string.i_known
            java.lang.String r5 = r5.getString(r6)
            r2.setText(r5)
            r2 = r4
            goto L_0x00d9
        L_0x1248:
            r18 = r3
            r19 = r4
            android.content.res.Resources r3 = r21.getResources()
            int r4 = com.upuphone.xr.sapp.R.string.network_error_pls_retry_later
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            android.widget.TextView r4 = r4.i
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r13)
            r5 = 8
            r4.setVisibility(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r15)
            r4.setVisibility(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            r4.setVisibility(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.M
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            r4 = 0
            r2.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.M
            int r4 = com.upuphone.xr.sapp.R.string.app_confirm
            r2.setText(r4)
            goto L_0x0909
        L_0x128f:
            r18 = r3
            r19 = r4
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.network_not_available_pls_check
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.i
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            r4 = 8
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            int r4 = com.upuphone.xr.sapp.R.string.cancel
            r3.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            int r4 = com.upuphone.xr.sapp.R.string.network_setting
            r3.setText(r4)
            goto L_0x0173
        L_0x12c0:
            r18 = r3
            r19 = r4
            android.content.res.Resources r3 = r21.getResources()
            int r4 = com.upuphone.xr.sapp.R.string.glass_storage_is_not_enough
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r15)
            r5 = 8
            r4.setVisibility(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            r4.setVisibility(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.M
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            r4 = 0
            r2.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.M
            int r4 = com.upuphone.xr.sapp.R.string.i_known
            r2.setText(r4)
            goto L_0x0909
        L_0x12fd:
            r18 = r3
            r19 = r4
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.phone_storage_is_not_enough
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            int r4 = com.upuphone.xr.sapp.R.string.cancel
            r3.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            int r4 = com.upuphone.xr.sapp.R.string.phone_storage_go_to_clean
            r3.setText(r4)
            goto L_0x0173
        L_0x1322:
            r18 = r3
            r19 = r4
            android.content.Context r2 = r21.getContext()
            int r3 = com.upuphone.xr.sapp.R.string.phone_storage_is_not_enough
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            int r4 = com.upuphone.xr.sapp.R.string.cancel
            r3.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            android.content.Context r4 = r21.getContext()
            int r5 = com.upuphone.xr.sapp.R.string.phone_storage_go_to_clean
            java.lang.String r4 = r4.getString(r5)
            r3.setText(r4)
            goto L_0x0173
        L_0x134f:
            r18 = r3
            r19 = r4
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r15)
            r4 = 8
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            com.meizu.common.widget.MzButton r2 = r2.M
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            r3 = 0
            r2.setVisibility(r3)
            android.content.Context r2 = r21.getContext()
            int r3 = com.upuphone.xr.sapp.R.string.glass_storage_is_not_enough
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            goto L_0x0173
        L_0x1383:
            r16 = r2
            r18 = r3
            r19 = r4
            r17 = r15
            android.content.Context r2 = r21.getContext()
            int r3 = com.upuphone.xr.sapp.R.string.unknow_network
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            java.lang.Object r3 = r21.getMExtra()
            boolean r3 = r3 instanceof com.upuphone.xr.sapp.guide.model.PasswordInfo
            if (r3 == 0) goto L_0x13c2
            android.content.Context r2 = r21.getContext()
            int r3 = com.upuphone.xr.sapp.R.string.network_name
            java.lang.Object r4 = r21.getMExtra()
            r6 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r6)
            com.upuphone.xr.sapp.guide.model.PasswordInfo r4 = (com.upuphone.xr.sapp.guide.model.PasswordInfo) r4
            java.lang.String r4 = r4.getMSid()
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            java.lang.String r2 = r2.getString(r3, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
        L_0x13c0:
            r3 = r2
            goto L_0x13c5
        L_0x13c2:
            r6 = r19
            goto L_0x13c0
        L_0x13c5:
            android.content.Context r2 = r21.getContext()
            int r4 = com.upuphone.xr.sapp.R.string.input_pwd
            java.lang.String r2 = r2.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.upuphone.xr.sapp.view.WifiPasswordEditView r4 = r4.u0
            r7 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
            r5 = 0
            r4.setVisibility(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            android.widget.FrameLayout r4 = r4.y
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r8)
            r4.setVisibility(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.app_confirm
            r4.setText(r5)
        L_0x13fb:
            r4 = r17
            goto L_0x1700
        L_0x13ff:
            r16 = r2
            r7 = r3
            r6 = r4
            r17 = r15
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.factory_reset_dlg_title
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            java.lang.Boolean r3 = com.upuphone.xr.sapp.BuildConfig.f6575a
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r14)
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x142b
            android.content.res.Resources r3 = r21.getResources()
            int r4 = com.upuphone.xr.sapp.R.string.factory_reset_dlg_tips_oversea
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            goto L_0x1438
        L_0x142b:
            android.content.res.Resources r3 = r21.getResources()
            int r4 = com.upuphone.xr.sapp.R.string.factory_reset_dlg_tips
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
        L_0x1438:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.app_confirm
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            android.widget.TextView r4 = r4.i
            r5 = 8388611(0x800003, float:1.1754948E-38)
            r4.setGravity(r5)
            goto L_0x13fb
        L_0x1455:
            r16 = r2
            r7 = r3
            r6 = r4
            r17 = r15
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.is_remove_device
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            android.content.res.Resources r3 = r21.getResources()
            int r4 = com.upuphone.xr.sapp.R.string.is_remove_device_note
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.is_remove_device_cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.is_remove_device_confirm
            r4.setText(r5)
            goto L_0x13fb
        L_0x1489:
            r16 = r2
            r7 = r3
            r6 = r4
            r17 = r15
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.air_open_confirm_title
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            android.content.res.Resources r3 = r21.getResources()
            int r4 = com.upuphone.xr.sapp.R.string.air_open_confirm_content
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.app_confirm
            r4.setText(r5)
            goto L_0x13fb
        L_0x14bd:
            r16 = r2
            r7 = r3
            r6 = r4
            r17 = r15
            android.content.Context r2 = r21.getContext()
            int r3 = com.upuphone.xr.sapp.R.string.please_open_bluetooth
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            android.content.Context r3 = r21.getContext()
            int r4 = com.upuphone.xr.sapp.R.string.please_open_bluetooth_tips
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.open_notification
            r4.setText(r5)
            goto L_0x13fb
        L_0x14f1:
            r16 = r2
            r7 = r3
            r6 = r4
            r17 = r15
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.notification_title
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            android.content.res.Resources r3 = r21.getResources()
            int r4 = com.upuphone.xr.sapp.R.string.notification_content
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.open_notification
            r4.setText(r5)
            com.upuphone.xr.sapp.context.SdkContext r4 = com.upuphone.xr.sapp.context.SdkContext.f6675a
            com.upuphone.xr.sapp.context.DataTrackContext r4 = r4.d()
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.lang.String r8 = "app_remind_pop"
            r4.reportEvent(r8, r5)
            goto L_0x13fb
        L_0x1535:
            r16 = r2
            r7 = r3
            r6 = r4
            r17 = r15
            java.lang.Boolean r2 = com.upuphone.xr.sapp.BuildConfig.f6575a
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r14)
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x1554
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.app_name_oversea
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            goto L_0x1561
        L_0x1554:
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.app_name
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
        L_0x1561:
            android.content.Context r3 = r21.getContext()
            int r4 = com.upuphone.xr.sapp.R.string.agreement_tips_content
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            android.widget.FrameLayout r4 = r4.getRoot()
            android.content.Context r4 = r4.getContext()
            int r5 = com.upuphone.xr.sapp.R.color.text_click_span
            int r4 = r4.getColor(r5)
            com.upuphone.xr.sapp.view.GenericWindowView$setUI$span$1 r5 = new com.upuphone.xr.sapp.view.GenericWindowView$setUI$span$1
            r5.<init>(r0, r1)
            java.lang.String r8 = "《"
            java.lang.String r9 = "》"
            android.text.SpannableString r3 = com.upuphone.xr.sapp.utils.StaticMethodUtilsKt.J(r3, r8, r9, r4, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            android.widget.TextView r4 = r4.i
            r4.setText(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.i
            android.text.method.MovementMethod r4 = android.text.method.LinkMovementMethod.getInstance()
            r3.setMovementMethod(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            android.content.Context r4 = r21.getContext()
            int r5 = com.upuphone.xr.sapp.R.string.word_exit
            java.lang.String r4 = r4.getString(r5)
            r3.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            android.content.Context r4 = r21.getContext()
            int r5 = com.upuphone.xr.sapp.R.string.agree
            java.lang.String r4 = r4.getString(r5)
            r3.setText(r4)
        L_0x15c1:
            r3 = r17
            r4 = r3
            goto L_0x1700
        L_0x15c6:
            r16 = r2
            r7 = r3
            r6 = r4
            r17 = r15
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.glass_update_verify_fail_msg
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.i
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            r4 = 8
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            int r4 = com.upuphone.xr.sapp.R.string.cancel
            r3.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            int r4 = com.upuphone.xr.sapp.R.string.restart_download
            r3.setText(r4)
            goto L_0x15c1
        L_0x15f8:
            r16 = r2
            r7 = r3
            r6 = r4
            r17 = r15
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.glass_update_fail_msg
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.i
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            r4 = 8
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            int r4 = com.upuphone.xr.sapp.R.string.cancel
            r3.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            int r4 = com.upuphone.xr.sapp.R.string.retry
            r3.setText(r4)
            goto L_0x15c1
        L_0x162a:
            r16 = r2
            r7 = r3
            r6 = r4
            r17 = r15
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.download_via_mobile_tips
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.i
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            r4 = 8
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            int r4 = com.upuphone.xr.sapp.R.string.cancel
            r3.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            int r4 = com.upuphone.xr.sapp.R.string.download
            r3.setText(r4)
            goto L_0x15c1
        L_0x165d:
            r16 = r2
            r7 = r3
            r6 = r4
            r17 = r15
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.location_permission_title
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 31
            if (r3 >= r4) goto L_0x1679
            int r3 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_location_text_android_r
            goto L_0x167b
        L_0x1679:
            int r3 = com.upuphone.xr.sapp.R.string.flyme_internal_app_permission_location_text
        L_0x167b:
            java.lang.String r3 = com.upuphone.xr.sapp.utils.GlobalExtKt.h(r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.W
            int r5 = com.upuphone.xr.sapp.R.string.cancel
            r4.setText(r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            int r5 = com.upuphone.xr.sapp.R.string.open_notification
            r4.setText(r5)
            goto L_0x13fb
        L_0x1693:
            r16 = r2
            r7 = r3
            r6 = r4
            r17 = r15
            android.content.res.Resources r2 = r21.getResources()
            java.lang.Boolean r3 = com.upuphone.xr.sapp.BuildConfig.f6575a
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r14)
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x16ab
            int r3 = com.upuphone.xr.sapp.R.string.notice_permission_title_oversea
            goto L_0x16ad
        L_0x16ab:
            int r3 = com.upuphone.xr.sapp.R.string.notice_permission_title
        L_0x16ad:
            java.lang.String r2 = r2.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            android.content.res.Resources r3 = r21.getResources()
            int r4 = com.upuphone.xr.sapp.R.string.notice_permission_content
            java.lang.String r3 = r3.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            goto L_0x13fb
        L_0x16c3:
            r16 = r2
            r7 = r3
            r6 = r4
            r17 = r15
            android.content.res.Resources r2 = r21.getResources()
            int r3 = com.upuphone.xr.sapp.R.string.new_glass_update_found_param
            com.upuphone.xr.sapp.glass.GlassUpdateHelper r4 = com.upuphone.xr.sapp.glass.GlassUpdateHelper.b
            java.lang.String r4 = r4.u0()
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            java.lang.String r2 = r2.getString(r3, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.i
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            r4 = 8
            r3.setVisibility(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.W
            int r4 = com.upuphone.xr.sapp.R.string.update_not_now
            r3.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            com.meizu.common.widget.MzButton r3 = r3.f
            int r4 = com.upuphone.xr.sapp.R.string.go_to_update
            r3.setText(r4)
            goto L_0x15c1
        L_0x1700:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r5 = r0.d
            android.widget.TextView r5 = r5.m0
            r5.setText(r2)
            boolean r5 = r21.B(r22)
            if (r5 == 0) goto L_0x1714
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r5 = r0.d
            android.widget.TextView r5 = r5.i
            r5.setText(r3)
        L_0x1714:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r5 = r0.d
            com.upuphone.xr.sapp.view.DrawableEditText r5 = r5.w
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r12)
            int r5 = r5.getVisibility()
            if (r5 != 0) goto L_0x1743
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r5 = r0.d
            com.upuphone.xr.sapp.view.DrawableEditText r5 = r5.w
            r5.setText(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r5 = r0.d
            com.upuphone.xr.sapp.view.DrawableEditText r5 = r5.w
            int r4 = r4.length()
            r5.setSelection(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.upuphone.xr.sapp.view.DrawableEditText r4 = r4.w
            android.view.ViewTreeObserver r4 = r4.getViewTreeObserver()
            com.upuphone.xr.sapp.view.GenericWindowView$setUI$4 r5 = new com.upuphone.xr.sapp.view.GenericWindowView$setUI$4
            r5.<init>(r0)
            r4.addOnGlobalLayoutListener(r5)
        L_0x1743:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.upuphone.xr.sapp.view.WifiPasswordEditView r4 = r4.u0
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
            int r4 = r4.getVisibility()
            if (r4 != 0) goto L_0x17b8
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.meizu.common.widget.MzButton r4 = r4.f
            r5 = 0
            r4.setEnabled(r5)
            java.lang.Object r4 = r21.getMExtra()
            boolean r4 = r4 instanceof com.upuphone.xr.sapp.guide.model.PasswordInfo
            if (r4 == 0) goto L_0x17a6
            java.lang.Object r4 = r21.getMExtra()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r6)
            com.upuphone.xr.sapp.guide.model.PasswordInfo r4 = (com.upuphone.xr.sapp.guide.model.PasswordInfo) r4
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r6 = r0.d
            com.upuphone.xr.sapp.view.WifiPasswordEditView r6 = r6.u0
            int r7 = r4.getMState()
            r8 = -1
            if (r7 != r8) goto L_0x1776
            r7 = 1
            goto L_0x1777
        L_0x1776:
            r7 = r5
        L_0x1777:
            r6.n(r7)
            r6 = r17
            r4.setMPassword(r6)
            java.lang.String r4 = r4.getMPassword()
            int r6 = r4.length()
            if (r6 <= 0) goto L_0x178a
            goto L_0x178b
        L_0x178a:
            r4 = 0
        L_0x178b:
            if (r4 == 0) goto L_0x17a6
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r6 = r0.d
            com.meizu.common.widget.MzButton r6 = r6.f
            r7 = 1
            r6.setEnabled(r7)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r6 = r0.d
            com.upuphone.xr.sapp.view.WifiPasswordEditView r6 = r6.u0
            r6.setEditTextContent(r4)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.upuphone.xr.sapp.view.WifiPasswordEditView r4 = r4.u0
            r4.m(r7)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            goto L_0x17a7
        L_0x17a6:
            r7 = 1
        L_0x17a7:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r4 = r0.d
            com.upuphone.xr.sapp.view.WifiPasswordEditView r4 = r4.u0
            android.view.ViewTreeObserver r4 = r4.getViewTreeObserver()
            com.upuphone.xr.sapp.view.GenericWindowView$setUI$7 r6 = new com.upuphone.xr.sapp.view.GenericWindowView$setUI$7
            r6.<init>(r0)
            r4.addOnGlobalLayoutListener(r6)
            goto L_0x17ba
        L_0x17b8:
            r5 = 0
            r7 = 1
        L_0x17ba:
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)
            if (r2 == 0) goto L_0x17cf
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            android.widget.TextView r2 = r2.m0
            r4 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            r6 = 8
            r2.setVisibility(r6)
            goto L_0x17d3
        L_0x17cf:
            r4 = r16
            r6 = 8
        L_0x17d3:
            boolean r2 = kotlin.text.StringsKt.isBlank(r3)
            if (r2 == 0) goto L_0x17e7
            r2 = 106(0x6a, float:1.49E-43)
            if (r1 == r2) goto L_0x17e7
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            android.widget.TextView r2 = r2.i
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r13)
            r2.setVisibility(r6)
        L_0x17e7:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            android.widget.ScrollView r2 = r2.E
            java.lang.String r3 = "layScrollContent"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.TextView r3 = r3.i
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            int r3 = r3.getVisibility()
            if (r3 != 0) goto L_0x17fe
            goto L_0x180d
        L_0x17fe:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r3 = r0.d
            android.widget.ImageView r3 = r3.I
            java.lang.String r8 = "myContentIv"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r8)
            int r3 = r3.getVisibility()
            if (r3 != 0) goto L_0x180f
        L_0x180d:
            r15 = r7
            goto L_0x1810
        L_0x180f:
            r15 = r5
        L_0x1810:
            if (r15 == 0) goto L_0x1814
            r8 = r5
            goto L_0x1815
        L_0x1814:
            r8 = r6
        L_0x1815:
            r2.setVisibility(r8)
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            android.widget.TextView r2 = r2.i
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r13)
            int r2 = r2.getVisibility()
            if (r2 != 0) goto L_0x1835
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            android.widget.TextView r2 = r2.i
            android.view.ViewTreeObserver r2 = r2.getViewTreeObserver()
            com.upuphone.xr.sapp.view.GenericWindowView$setUI$8 r3 = new com.upuphone.xr.sapp.view.GenericWindowView$setUI$8
            r3.<init>(r0)
            r2.addOnPreDrawListener(r3)
        L_0x1835:
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r2 = r0.d
            android.widget.TextView r2 = r2.m0
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            int r2 = r2.getVisibility()
            if (r2 != 0) goto L_0x1856
            r2 = 181(0xb5, float:2.54E-43)
            if (r1 == r2) goto L_0x1856
            com.upuphone.xr.sapp.databinding.GenericWindowBinding r1 = r0.d
            android.widget.TextView r1 = r1.m0
            android.view.ViewTreeObserver r1 = r1.getViewTreeObserver()
            com.upuphone.xr.sapp.view.GenericWindowView$setUI$9 r2 = new com.upuphone.xr.sapp.view.GenericWindowView$setUI$9
            r2.<init>(r0)
            r1.addOnPreDrawListener(r2)
        L_0x1856:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.view.GenericWindowView.setUI(int):void");
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
    public final java.lang.Object A(java.lang.String r6, int r7) {
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
            java.lang.String r1 = "getGlassAnimRes"
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
        throw new UnsupportedOperationException("Method not decompiled: com.upuphone.xr.sapp.view.GenericWindowView.A(java.lang.String, int):java.lang.Object");
    }

    public final boolean B(int i) {
        return (i == 158 || i == 191 || i == 192 || i == 193 || i == 194 || i == 195 || i == 196 || i == 197 || i == 198 || i == 202) ? false : true;
    }

    public final void D(int i) {
        int windowType = getWindowType();
        if (windowType == 101) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            X(context);
        } else if (windowType == 107) {
            IClickCallback callback = getCallback();
            if (callback != null) {
                callback.b(i, (Object) null);
            }
        } else if (windowType != 110) {
            switch (windowType) {
                case 126:
                    IClickCallback callback2 = getCallback();
                    if (callback2 != null) {
                        callback2.b(i, (Object) null);
                        return;
                    }
                    return;
                case 127:
                    SuperFunctionUtils.b.a().f();
                    return;
                case 128:
                    IClickCallback callback3 = getCallback();
                    if (callback3 != null) {
                        callback3.b(i, (Object) null);
                        return;
                    }
                    return;
                case 129:
                    Intent intent = new Intent();
                    intent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
                    intent.setAction("android.settings.SETTINGS");
                    intent.putExtra("android.provider.extra.APP_PACKAGE", getContext().getPackageName());
                    getContext().startActivity(intent);
                    return;
                case 130:
                    IClickCallback callback4 = getCallback();
                    if (callback4 != null) {
                        callback4.b(i, (Object) null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            IClickCallback callback5 = getCallback();
            if (callback5 != null) {
                callback5.b(i, (Object) null);
            }
        }
    }

    public final void E(IClickCallback iClickCallback, int i) {
        this.d.f.setOnClickListener(new q(i, this, iClickCallback));
        this.d.W.setOnClickListener(new r(iClickCallback, i));
        this.d.w.setOnDrawableClickListener(new GenericWindowView$setButtonListener$3(this));
        this.d.u0.l(new GenericWindowView$setButtonListener$4(this));
        this.d.w.addTextChangedListener(new GenericWindowView$setButtonListener$5(this, i));
        this.d.M.setOnClickListener(new s(iClickCallback, i));
        this.d.t.setOnCheckedChangeListener(new t(this));
    }

    public final SpannableString J(int i, String str, boolean z) {
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("setClickSpan", "type is: " + i + " and text is: " + str);
        boolean areEqual = Intrinsics.areEqual((Object) getResources().getConfiguration().locale.getLanguage(), (Object) "ja");
        if (str.length() > 0 && areEqual) {
            return w(str);
        }
        if (str.length() == 0 || !StringsKt.contains$default((CharSequence) str, (CharSequence) "《", false, 2, (Object) null)) {
            return new SpannableString("invalid data");
        }
        try {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new GenericWindowView$setClickSpan$1(this), StringsKt.indexOf$default((CharSequence) str, "《", 0, false, 6, (Object) null), StringsKt.indexOf$default((CharSequence) str, "》", 0, false, 6, (Object) null) + 1, 34);
            if (z) {
                spannableString.setSpan(new GenericWindowView$setClickSpan$2(this), StringsKt.lastIndexOf$default((CharSequence) str, "《", 0, false, 6, (Object) null), StringsKt.lastIndexOf$default((CharSequence) str, "》", 0, false, 6, (Object) null) + 1, 34);
            }
            int[] iArr = {getResources().getColor(R.color.color_gradient_star), getResources().getColor(R.color.color_gradient_end)};
            spannableString.setSpan(new LinearGradientForegroundSpan(iArr), StringsKt.indexOf$default((CharSequence) str, "《", 0, false, 6, (Object) null), StringsKt.indexOf$default((CharSequence) str, "》", 0, false, 6, (Object) null) + 1, 18);
            if (z) {
                spannableString.setSpan(new LinearGradientForegroundSpan(iArr), StringsKt.lastIndexOf$default((CharSequence) str, "《", 0, false, 6, (Object) null), StringsKt.lastIndexOf$default((CharSequence) str, "》", 0, false, 6, (Object) null) + 1, 18);
            }
            return spannableString;
        } catch (Exception e2) {
            ULog.Delegate delegate2 = ULog.f6446a;
            String message = e2.getMessage();
            delegate2.c("setClickSpan", "e : " + message);
            return new SpannableString("invalid data");
        }
    }

    public final void K(IClickCallback iClickCallback, int i) {
        this.d.k.setOnClickListener(new u(iClickCallback, i));
        this.d.l.setOnClickListener(new h(this, i));
        this.d.j.setOnClickListener(new i(iClickCallback, i));
        this.d.n.setOnClickListener(new j(iClickCallback, i));
        this.d.U.setOnCheckedChangeListener(new k(this));
    }

    public final void S(TextView textView, boolean z) {
        Drawable drawable;
        if (z) {
            drawable = getResources().getDrawable(R.drawable.name_edit_icon_clean);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        } else {
            drawable = null;
        }
        textView.setCompoundDrawablesRelative((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        textView.setSelected(true);
    }

    public final void T(String str, int i) {
        String str2;
        ULog.f6446a.a("GenericWindowView", "setInputByLimit string=" + str + ", limit=" + i);
        this.e = str;
        Charset defaultCharset = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(defaultCharset, "defaultCharset(...)");
        byte[] bytes = str.getBytes(defaultCharset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        if (bytes.length > i) {
            this.d.w.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.error_edit_bg));
            TextView textView = this.d.x;
            Intrinsics.checkNotNullExpressionValue(textView, "editInputLen");
            textView.setVisibility(0);
            this.f = true;
            int length = str.length() - 1;
            while (true) {
                if (-1 >= length) {
                    str2 = str;
                    break;
                }
                CharSequence subSequence = str.subSequence(0, length);
                Intrinsics.checkNotNull(subSequence, "null cannot be cast to non-null type kotlin.String");
                str2 = (String) subSequence;
                Charset defaultCharset2 = Charset.defaultCharset();
                Intrinsics.checkNotNullExpressionValue(defaultCharset2, "defaultCharset(...)");
                byte[] bytes2 = str2.getBytes(defaultCharset2);
                Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                if (bytes2.length <= i) {
                    break;
                }
                length--;
            }
            ULog.Delegate delegate = ULog.f6446a;
            Charset defaultCharset3 = Charset.defaultCharset();
            Intrinsics.checkNotNullExpressionValue(defaultCharset3, "defaultCharset(...)");
            byte[] bytes3 = str2.getBytes(defaultCharset3);
            Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
            delegate.a("GenericWindowView", "setInputByLimit before=" + str + ", after=" + str2 + "，len=" + bytes3.length);
            this.e = str2;
            this.d.w.setText(str2);
            this.d.w.setSelection(str2.length());
        } else if (this.f) {
            this.f = false;
        } else {
            this.d.w.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.common_edit_bg));
            TextView textView2 = this.d.x;
            Intrinsics.checkNotNullExpressionValue(textView2, "editInputLen");
            textView2.setVisibility(8);
        }
    }

    public final void W(TextView textView, String str) {
        int lineCount = textView.getLineCount();
        if (lineCount > 1) {
            textView.setGravity(8388611);
            ULog.Delegate delegate = ULog.f6446a;
            int windowType = getWindowType();
            delegate.a("GenericWindowView", str + ", windowType: " + windowType + ", lineCount: " + lineCount + ", gravity: START");
            return;
        }
        textView.setGravity(17);
        ULog.Delegate delegate2 = ULog.f6446a;
        int windowType2 = getWindowType();
        delegate2.a("GenericWindowView", str + ", windowType: " + windowType2 + ", lineCount: " + lineCount + ", gravity: CENTER");
    }

    public final void X(Context context) {
        Intent intent = new Intent();
        try {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
            context.startActivity(intent);
        } catch (Exception unused) {
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", context.getPackageName(), (String) null));
            context.startActivity(intent);
        }
    }

    public void b(int i, Object obj) {
        Context context;
        int i2;
        Intrinsics.checkNotNullParameter(obj, "data");
        AppUpdateInfo appUpdateInfo = null;
        if (i == 132) {
            ConnectResult connectResult = (ConnectResult) obj;
            ULog.Delegate delegate = ULog.f6446a;
            delegate.a("updateView", "connectState is: " + connectResult);
            String z = z(connectResult.getMErrorCode());
            MzButton mzButton = this.d.k;
            Intrinsics.checkNotNullExpressionValue(mzButton, "deviceConfirm");
            mzButton.setVisibility(connectResult.getMResult() ^ true ? 4 : 0);
            MzButton mzButton2 = this.d.j;
            Intrinsics.checkNotNullExpressionValue(mzButton2, "deviceCancel");
            mzButton2.setVisibility(connectResult.getMResult() ^ true ? 0 : 8);
            MzButton mzButton3 = this.d.l;
            Intrinsics.checkNotNullExpressionValue(mzButton3, "deviceConnect");
            mzButton3.setVisibility(connectResult.getMResult() ^ true ? 0 : 8);
            LinearLayout linearLayout = this.d.A;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "glassProtocol");
            linearLayout.setVisibility(8);
            this.d.k.setText(getContext().getString(R.string.text_done));
            this.d.j.setText(getContext().getString(R.string.cancel));
            this.d.l.setText(getContext().getString(R.string.reconnect));
            TextView textView = this.d.o;
            if (connectResult.getMResult()) {
                z = getContext().getString(R.string.enjoy_your_ar_world);
            }
            textView.setText(z);
            TextView textView2 = this.d.s;
            if (connectResult.getMResult()) {
                context = getContext();
                i2 = R.string.connect_success;
            } else {
                context = getContext();
                i2 = R.string.connect_fail;
            }
            textView2.setText(context.getString(i2));
            if (connectResult.getMResult()) {
                String deviceInfo = InterconnectManager.getInstance().getStarryNetDeviceManager().getDeviceInfo(connectResult.getMDeviceID(), 5);
                Boolean bool = BuildConfig.f6575a;
                Intrinsics.checkNotNullExpressionValue(bool, "COUNTRY_INTL");
                if (bool.booleanValue()) {
                    deviceInfo = "1003";
                }
                CustomFrameAnimation.Companion companion = CustomFrameAnimation.d;
                companion.b().p(true);
                Object A = A(deviceInfo, TrackerEvent.PositioningOfflineOutdoor);
                if (A instanceof Integer) {
                    this.d.q.setVisibility(4);
                    this.d.r.setVisibility(8);
                    CustomFrameAnimation b = companion.b();
                    int intValue = ((Number) A).intValue();
                    ImageView imageView = this.d.q;
                    Intrinsics.checkNotNullExpressionValue(imageView, "deviceImg");
                    b.h(intValue, imageView, false, (CustomFrameAnimation.IAnimState) null);
                } else if (A instanceof PagParam) {
                    this.d.q.setVisibility(4);
                    this.d.r.setVisibility(0);
                    PAGImageView pAGImageView = this.d.r;
                    Intrinsics.checkNotNullExpressionValue(pAGImageView, "devicePag");
                    LibPag.a(pAGImageView, (PagParam) A);
                }
            }
        } else if (i == 186) {
            if (obj instanceof AppUpdateInfo) {
                appUpdateInfo = (AppUpdateInfo) obj;
            }
            if (appUpdateInfo != null) {
                GenericWindowBinding genericWindowBinding = this.d;
                ConstraintLayout constraintLayout = genericWindowBinding.D;
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "layDownloadInfo");
                constraintLayout.setVisibility(0);
                TextView textView3 = genericWindowBinding.o0;
                int i3 = R.string.latest_version_param;
                String latestVersion = appUpdateInfo.getLatestVersion();
                if (latestVersion == null) {
                    latestVersion = "";
                }
                textView3.setText(GlobalExtKt.i(i3, latestVersion));
                TextView textView4 = genericWindowBinding.p0;
                Long apkSize = appUpdateInfo.getApkSize();
                textView4.setText(FileSizeExtKt.a(apkSize != null ? apkSize.longValue() : 0));
                genericWindowBinding.P.setProgress((int) (appUpdateInfo.getDownloadProgress() * ((float) 100)));
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ULog.Delegate delegate = ULog.f6446a;
        Object mExtra = getMExtra();
        int windowType = getWindowType();
        delegate.a("GenericNoticeView", "mExtra is: " + mExtra + " notice is: " + windowType);
        if (getWindowType() != 141) {
            setBackground(ContextCompat.getDrawable(getContext(), R.drawable.bg_notiice_permisson));
        }
        int windowType2 = getWindowType();
        if (!(windowType2 == 123 || windowType2 == 150)) {
            if (windowType2 == 154) {
                ConstraintLayout constraintLayout = this.d.J;
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "noticeMain");
                constraintLayout.setVisibility(8);
                ConstraintLayout constraintLayout2 = this.d.m;
                Intrinsics.checkNotNullExpressionValue(constraintLayout2, "deviceConnectMain");
                constraintLayout2.setVisibility(8);
                ConstraintLayout constraintLayout3 = this.d.e;
                Intrinsics.checkNotNullExpressionValue(constraintLayout3, "commonLoading");
                constraintLayout3.setVisibility(8);
                this.d.F.cancelAnimation();
                LinearLayout linearLayout = this.d.X;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "removeDeviceFromSetting");
                linearLayout.setVisibility(0);
                ConstraintLayout constraintLayout4 = this.d.i0;
                Intrinsics.checkNotNullExpressionValue(constraintLayout4, "syncVolMain");
                constraintLayout4.setVisibility(8);
                this.d.g.setOnClickListener(new p(this));
                return;
            } else if (windowType2 != 161) {
                if (!(windowType2 == 203 || windowType2 == 188 || windowType2 == 189)) {
                    switch (windowType2) {
                        case TrackerEvent.PositioningOfflineOutdoor /*131*/:
                        case 132:
                        case 133:
                            break;
                        default:
                            switch (windowType2) {
                                case Opcodes.IF_ACMPEQ:
                                case Opcodes.IF_ACMPNE:
                                case Opcodes.GOTO:
                                    break;
                                default:
                                    setUI(getWindowType());
                                    E(getCallback(), getWindowType());
                                    return;
                            }
                    }
                }
                setDeviceConnectUI(getWindowType());
                K(getCallback(), getWindowType());
                return;
            } else {
                ConstraintLayout constraintLayout5 = this.d.J;
                Intrinsics.checkNotNullExpressionValue(constraintLayout5, "noticeMain");
                constraintLayout5.setVisibility(8);
                ConstraintLayout constraintLayout6 = this.d.m;
                Intrinsics.checkNotNullExpressionValue(constraintLayout6, "deviceConnectMain");
                constraintLayout6.setVisibility(8);
                ConstraintLayout constraintLayout7 = this.d.e;
                Intrinsics.checkNotNullExpressionValue(constraintLayout7, "commonLoading");
                constraintLayout7.setVisibility(8);
                this.d.F.cancelAnimation();
                LinearLayout linearLayout2 = this.d.X;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "removeDeviceFromSetting");
                linearLayout2.setVisibility(8);
                ConstraintLayout constraintLayout8 = this.d.i0;
                Intrinsics.checkNotNullExpressionValue(constraintLayout8, "syncVolMain");
                constraintLayout8.setVisibility(8);
                ConstraintLayout constraintLayout9 = this.d.Z;
                Intrinsics.checkNotNullExpressionValue(constraintLayout9, "superNotifyUi");
                constraintLayout9.setVisibility(0);
                if (getMExtra() instanceof PermissionNote) {
                    Object mExtra2 = getMExtra();
                    Intrinsics.checkNotNull(mExtra2, "null cannot be cast to non-null type com.upuphone.xr.sapp.entity.PermissionNote");
                    PermissionNote permissionNote = (PermissionNote) mExtra2;
                    this.d.l0.setText(permissionNote.getTitle());
                    this.d.k0.setText(permissionNote.getContent());
                    return;
                }
                return;
            }
        }
        setLoadingUI(getWindowType());
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getHandler().removeCallbacksAndMessages((Object) null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public final SpannableString w(String str) {
        int[] iArr = {getResources().getColor(R.color.color_gradient_star), getResources().getColor(R.color.color_gradient_end)};
        SpannableString spannableString = new SpannableString(str);
        Locale locale = getResources().getConfiguration().locale;
        boolean areEqual = Intrinsics.areEqual((Object) locale.getLanguage(), (Object) "ja");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GenericWindowView", "当前语言->" + locale + "，是否适配日本->" + areEqual);
        Pattern compile = Pattern.compile(areEqual ? "「[^」]+」|「」" : "《[^》]+》|《》");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
        Matcher matcher = compile.matcher(str);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.a("GenericWindowView", "命中->" + matcher + "，group->" + group);
            Intrinsics.checkNotNull(group);
            if (StringsKt.contains$default((CharSequence) group, (CharSequence) GlobalExtKt.h(R.string.superapp_privacy_policy), false, 2, (Object) null)) {
                spannableString.setSpan(new PolicyJapClickableSpan(this, group), start, end, 34);
                spannableString.setSpan(new LinearGradientForegroundSpan(iArr), start, end, 18);
            }
        }
        return spannableString;
    }

    public final SpannableString x(String str) {
        String string = getResources().getString(R.string.superapp_privacy_policy);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getResources().getString(R.string.service_protocol_anchor);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        int[] iArr = {getResources().getColor(R.color.color_gradient_star), getResources().getColor(R.color.color_gradient_end)};
        SpannableString spannableString = new SpannableString(str);
        Locale locale = getResources().getConfiguration().locale;
        boolean areEqual = Intrinsics.areEqual((Object) locale.getLanguage(), (Object) "ja");
        ULog.Delegate delegate = ULog.f6446a;
        delegate.a("GenericWindowView", "buildSpan() 当前语言->" + locale + "，是否适配日本->" + areEqual);
        Pattern compile = Pattern.compile(areEqual ? "「[^」]+」|「」" : "《[^》]+》|《》");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
        Matcher matcher = compile.matcher(str);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            ULog.Delegate delegate2 = ULog.f6446a;
            delegate2.a("GenericWindowView", "命中->" + matcher + "，group->" + group);
            Intrinsics.checkNotNull(group);
            if (StringsKt.contains$default((CharSequence) group, (CharSequence) string, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) group, (CharSequence) string2, false, 2, (Object) null)) {
                spannableString.setSpan(new PolicyClickableSpan(this, group), start, end, 34);
                spannableString.setSpan(new LinearGradientForegroundSpan(iArr), start, end, 18);
            }
        }
        return spannableString;
    }

    public final int y(int i) {
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

    public final String z(int i) {
        if (i == -300) {
            String string = getContext().getString(R.string.connect_timeout_please_retry);
            Intrinsics.checkNotNull(string);
            return string;
        } else if (i == -200) {
            String string2 = getContext().getString(R.string.connect_fail_please_retry);
            Intrinsics.checkNotNull(string2);
            return string2;
        } else if (i != -100) {
            String string3 = getContext().getString(R.string.connect_fail_please_retry);
            Intrinsics.checkNotNull(string3);
            return string3;
        } else {
            String string4 = getContext().getString(R.string.connect_fail_please_retry);
            Intrinsics.checkNotNull(string4);
            return string4;
        }
    }
}
