package com.ucar.vehiclesdk.control;

import com.easy.logger.EasyLog;
import com.geetest.sdk.x;
import com.honey.account.view.web.WebJs;
import com.meizu.common.datetimepicker.date.MonthView;
import com.ucar.protocol.security.SecurityManager;
import com.ucar.vehiclesdk.UCarCommon;
import com.ucarsink.sink.natives.SinkNative;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;

public class UibcManager {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f5440a;
    public SecurityManager b;
    public String c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public UCarCommon.VisibleRegion i;

    public final int a(int i2) {
        float f2;
        int i3;
        float f3;
        float f4;
        float e2;
        float f5;
        int h2;
        UCarCommon.VisibleRegion visibleRegion = this.i;
        if (visibleRegion == null || !visibleRegion.d()) {
            int i4 = this.h;
            if (i4 == 0 || i4 == 2) {
                f2 = (((float) i2) * 1.0f) / ((float) this.f);
                i3 = this.d;
            } else {
                f2 = (((float) i2) * 1.0f) / ((float) this.f);
                i3 = this.e;
            }
            f3 = f2 * ((float) i3);
        } else {
            int i5 = this.h;
            if (i5 == 0 || i5 == 2) {
                UCarCommon.VisibleRegion visibleRegion2 = this.i;
                f4 = (((float) this.d) * 1.0f) / ((float) visibleRegion2.e);
                e2 = (float) (i5 == 0 ? visibleRegion2.e() : visibleRegion2.f());
                f5 = (((float) i2) * 1.0f) / ((float) this.f);
                h2 = this.i.h();
            } else {
                UCarCommon.VisibleRegion visibleRegion3 = this.i;
                f4 = (((float) this.e) * 1.0f) / ((float) visibleRegion3.f);
                e2 = (float) (i5 == 1 ? visibleRegion3.g() : visibleRegion3.a());
                f5 = (((float) i2) * 1.0f) / ((float) this.f);
                h2 = this.i.c();
            }
            f3 = ((f5 * ((float) h2)) + e2) * f4;
        }
        return (int) f3;
    }

    public final int b(int i2) {
        float f2;
        int i3;
        float f3;
        float f4;
        float g2;
        float f5;
        int c2;
        UCarCommon.VisibleRegion visibleRegion = this.i;
        if (visibleRegion == null || !visibleRegion.d()) {
            int i4 = this.h;
            if (i4 == 0 || i4 == 2) {
                f2 = (((float) i2) * 1.0f) / ((float) this.g);
                i3 = this.e;
            } else {
                f2 = (((float) i2) * 1.0f) / ((float) this.g);
                i3 = this.d;
            }
            f3 = f2 * ((float) i3);
        } else {
            int i5 = this.h;
            if (i5 == 0 || i5 == 2) {
                UCarCommon.VisibleRegion visibleRegion2 = this.i;
                f4 = (((float) this.e) * 1.0f) / ((float) visibleRegion2.f);
                g2 = (float) (i5 == 0 ? visibleRegion2.g() : visibleRegion2.a());
                f5 = (((float) i2) * 1.0f) / ((float) this.g);
                c2 = this.i.c();
            } else {
                UCarCommon.VisibleRegion visibleRegion3 = this.i;
                f4 = (((float) this.d) * 1.0f) / ((float) visibleRegion3.e);
                g2 = (float) (i5 == 1 ? visibleRegion3.f() : visibleRegion3.e());
                f5 = (((float) i2) * 1.0f) / ((float) this.g);
                c2 = this.i.h();
            }
            f3 = ((f5 * ((float) c2)) + g2) * f4;
        }
        return (int) f3;
    }

    public final boolean c() {
        return this.b != null;
    }

    public boolean d(int i2, int i3, int[] iArr, int[] iArr2, int[] iArr3) {
        if (iArr.length != i3 || iArr2.length != i3 || iArr3.length != i3) {
            EasyLog.c("UibcManager", "sendTouchEvent failed: count error!");
            return false;
        } else if (!this.f5440a) {
            EasyLog.c("UibcManager", "sendTouchEvent failed: encryption is not settled");
            return false;
        } else if (this.d <= 0 || this.e <= 0) {
            EasyLog.c("UibcManager", "sendTouchEvent failed: source size haven't been initialized!");
            return false;
        } else {
            EasyLog.a("UibcManager", "sendTouchEvent, action: " + i2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", 1);
                jSONObject.put(WebJs.ACTION, i2);
                jSONObject.put(MonthView.VIEW_PARAMS_WIDTH, this.f);
                jSONObject.put(MonthView.VIEW_PARAMS_HEIGHT, this.g);
                jSONObject.put("count", i3);
                for (int i4 = 0; i4 < i3; i4++) {
                    jSONObject.put("trackID" + i4, iArr[i4]);
                    int a2 = a(iArr2[i4]);
                    int b2 = b(iArr3[i4]);
                    jSONObject.put(x.f + i4, a2);
                    jSONObject.put("y" + i4, b2);
                    EasyLog.a("UibcManager", "origin point: (" + iArr2[i4] + ", " + iArr3[i4] + "), display size: (" + this.f + ", " + this.g + "), source size: (" + this.d + ", " + this.e + "), mapped point: (" + a2 + ", " + b2 + ")");
                }
                byte[] bytes = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
                if (c()) {
                    bytes = this.b.f(bytes);
                }
                return SinkNative.onUibcEvent(this.c, bytes);
            } catch (JSONException e2) {
                EasyLog.d("UibcManager", "sendTouchEvent JSONException", e2);
                return false;
            }
        }
    }

    public void e(int i2) {
        this.e = i2;
    }

    public void f(int i2) {
        this.d = i2;
    }

    public void g(int i2, UCarCommon.VisibleRegion visibleRegion) {
        EasyLog.a("UibcManager", "updateSurfaceParams. rotation: " + i2 + ", region: " + visibleRegion);
        this.h = i2;
        if (visibleRegion != null) {
            this.i = visibleRegion.b();
        } else {
            this.i = null;
        }
    }
}
