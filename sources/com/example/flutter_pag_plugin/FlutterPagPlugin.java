package com.example.flutter_pag_plugin;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.example.flutter_pag_plugin.FlutterPagPlayer;
import com.geetest.sdk.x;
import com.meizu.common.datetimepicker.date.MonthView;
import com.meizu.common.widget.MzContactsContract;
import com.upuphone.starrynet.payload.PayloadConstant;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.libpag.PAGFile;
import org.libpag.PAGLayer;
import org.libpag.PAGSurface;

public class FlutterPagPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public static List i = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public MethodChannel f2820a;
    public TextureRegistry b;
    public Context c;
    public PluginRegistry.Registrar d;
    public FlutterPlugin.FlutterAssets e;
    public Handler f = new Handler(Looper.getMainLooper());
    public HashMap g = new HashMap();
    public HashMap h = new HashMap();

    /* renamed from: com.example.flutter_pag_plugin.FlutterPagPlugin$1  reason: invalid class name */
    class AnonymousClass1 implements PluginRegistry.ViewDestroyListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FlutterPagPlugin f2821a;

        public boolean onViewDestroy(FlutterNativeView flutterNativeView) {
            this.f2821a.h();
            FlutterPagPlugin.i.remove(this);
            return false;
        }
    }

    public FlutterPagPlayer c(MethodCall methodCall) {
        return (FlutterPagPlayer) this.g.get(e(methodCall));
    }

    public List d(MethodCall methodCall) {
        FlutterPagPlayer c2 = c(methodCall);
        ArrayList arrayList = new ArrayList();
        PAGLayer[] layersUnderPoint = c2 != null ? c2.getLayersUnderPoint(((Double) methodCall.argument(x.f)).floatValue(), ((Double) methodCall.argument("y")).floatValue()) : null;
        if (layersUnderPoint != null) {
            for (PAGLayer layerName : layersUnderPoint) {
                arrayList.add(layerName.layerName());
            }
        }
        return arrayList;
    }

    public String e(MethodCall methodCall) {
        return "" + methodCall.argument("textureId");
    }

    public final void f(final MethodCall methodCall, final MethodChannel.Result result) {
        String str = (String) methodCall.argument("assetName");
        byte[] bArr = (byte[]) methodCall.argument("bytesData");
        String str2 = (String) methodCall.argument("url");
        String str3 = (String) methodCall.argument("package");
        if (bArr != null) {
            g(PAGFile.Load(bArr), methodCall, result);
        } else if (str != null) {
            String lookupKeyForAsset = this.d != null ? (str3 == null || str3.isEmpty()) ? this.d.lookupKeyForAsset(str) : this.d.lookupKeyForAsset(str, str3) : this.e != null ? (str3 == null || str3.isEmpty()) ? this.e.getAssetFilePathByName(str) : this.e.getAssetFilePathByName(str, str3) : "";
            if (lookupKeyForAsset == null) {
                result.error("-1100", "asset资源加载错误", (Object) null);
            } else {
                g(PAGFile.Load(this.c.getAssets(), lookupKeyForAsset), methodCall, result);
            }
        } else if (str2 != null) {
            DataLoadHelper.f2817a.h(str2, new Function1<byte[], Unit>() {
                /* renamed from: a */
                public Unit invoke(final byte[] bArr) {
                    FlutterPagPlugin.this.f.post(new Runnable() {
                        public void run() {
                            byte[] bArr = bArr;
                            if (bArr == null) {
                                result.error("-1100", "url资源加载错误", (Object) null);
                                return;
                            }
                            FlutterPagPlugin flutterPagPlugin = FlutterPagPlugin.this;
                            PAGFile Load = PAGFile.Load(bArr);
                            AnonymousClass2 r3 = AnonymousClass2.this;
                            flutterPagPlugin.g(Load, methodCall, result);
                        }
                    });
                    return null;
                }
            }, 0);
        } else {
            result.error("-1100", "未添加资源", (Object) null);
        }
    }

    public final void g(PAGFile pAGFile, MethodCall methodCall, MethodChannel.Result result) {
        if (pAGFile == null) {
            result.error("-1100", "load composition is null! ", (Object) null);
            return;
        }
        int intValue = ((Integer) methodCall.argument("repeatCount")).intValue();
        double doubleValue = ((Double) methodCall.argument("initProgress")).doubleValue();
        final boolean booleanValue = ((Boolean) methodCall.argument("autoPlay")).booleanValue();
        FlutterPagPlayer flutterPagPlayer = new FlutterPagPlayer();
        final TextureRegistry.SurfaceTextureEntry createSurfaceTexture = this.b.createSurfaceTexture();
        this.h.put(String.valueOf(createSurfaceTexture.id()), createSurfaceTexture);
        flutterPagPlayer.f(pAGFile, intValue, doubleValue, this.f2820a, createSurfaceTexture.id());
        SurfaceTexture surfaceTexture = createSurfaceTexture.surfaceTexture();
        surfaceTexture.setDefaultBufferSize(pAGFile.width(), pAGFile.height());
        final Surface surface = new Surface(surfaceTexture);
        final PAGSurface FromSurface = PAGSurface.FromSurface(surface);
        flutterPagPlayer.setSurface(FromSurface);
        flutterPagPlayer.k(new FlutterPagPlayer.ReleaseListener() {
            public void a() {
                createSurfaceTexture.release();
                surface.release();
                FromSurface.release();
            }
        });
        this.g.put(String.valueOf(createSurfaceTexture.id()), flutterPagPlayer);
        final HashMap hashMap = new HashMap();
        hashMap.put("textureId", Long.valueOf(createSurfaceTexture.id()));
        hashMap.put(MonthView.VIEW_PARAMS_WIDTH, Double.valueOf((double) pAGFile.width()));
        hashMap.put(MonthView.VIEW_PARAMS_HEIGHT, Double.valueOf((double) pAGFile.height()));
        final FlutterPagPlayer flutterPagPlayer2 = flutterPagPlayer;
        final MethodChannel.Result result2 = result;
        this.f.post(new Runnable() {
            public void run() {
                flutterPagPlayer2.flush();
                if (booleanValue) {
                    flutterPagPlayer2.l();
                }
                result2.success(hashMap);
            }
        });
    }

    public void h() {
        for (FlutterPagPlayer release : this.g.values()) {
            release.release();
        }
        for (TextureRegistry.SurfaceTextureEntry release2 : this.h.values()) {
            release2.release();
        }
        this.g.clear();
        this.h.clear();
        this.f2820a.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    public void i(MethodCall methodCall) {
        FlutterPagPlayer c2 = c(methodCall);
        if (c2 != null) {
            c2.i();
        }
    }

    public void j(MethodCall methodCall) {
        FlutterPagPlayer flutterPagPlayer = (FlutterPagPlayer) this.g.remove(e(methodCall));
        if (flutterPagPlayer != null) {
            flutterPagPlayer.m();
            flutterPagPlayer.release();
        }
        TextureRegistry.SurfaceTextureEntry surfaceTextureEntry = (TextureRegistry.SurfaceTextureEntry) this.h.remove(e(methodCall));
        if (surfaceTextureEntry != null) {
            surfaceTextureEntry.release();
        }
    }

    public void k(MethodCall methodCall) {
        double doubleValue = ((Double) methodCall.argument(PayloadConstant.PARAMS_KEY_INT_OTA_PROGRESS)).doubleValue();
        FlutterPagPlayer c2 = c(methodCall);
        if (c2 != null) {
            c2.j(doubleValue);
        }
    }

    public void l(MethodCall methodCall) {
        FlutterPagPlayer c2 = c(methodCall);
        if (c2 != null) {
            c2.l();
        }
    }

    public void m(MethodCall methodCall) {
        FlutterPagPlayer c2 = c(methodCall);
        if (c2 != null) {
            c2.m();
        }
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        if (!i.contains(this)) {
            i.add(this);
        }
        this.e = flutterPluginBinding.getFlutterAssets();
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "flutter_pag_plugin");
        this.f2820a = methodChannel;
        methodChannel.setMethodCallHandler(this);
        this.c = flutterPluginBinding.getApplicationContext();
        this.b = flutterPluginBinding.getTextureRegistry();
        DataLoadHelper.f2817a.g(this.c, 31457280);
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f2820a.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 3540994:
                if (str.equals("stop")) {
                    c2 = 0;
                    break;
                }
                break;
            case 106440182:
                if (str.equals("pause")) {
                    c2 = 1;
                    break;
                }
                break;
            case 109757538:
                if (str.equals(MzContactsContract.START_PARAM_KEY)) {
                    c2 = 2;
                    break;
                }
                break;
            case 345774064:
                if (str.equals("getLayersUnderPoint")) {
                    c2 = 3;
                    break;
                }
                break;
            case 988242095:
                if (str.equals("setProgress")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1090594823:
                if (str.equals("release")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1948318054:
                if (str.equals("initPag")) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                m(methodCall);
                result.success("");
                return;
            case 1:
                i(methodCall);
                result.success("");
                return;
            case 2:
                l(methodCall);
                result.success("");
                return;
            case 3:
                result.success(d(methodCall));
                return;
            case 4:
                k(methodCall);
                result.success("");
                return;
            case 5:
                j(methodCall);
                result.success("");
                return;
            case 6:
                f(methodCall, result);
                return;
            default:
                result.notImplemented();
                return;
        }
    }
}
