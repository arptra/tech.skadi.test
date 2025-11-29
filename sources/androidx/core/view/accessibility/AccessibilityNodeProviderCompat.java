package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityNodeProviderCompat {

    /* renamed from: a  reason: collision with root package name */
    public final Object f930a;

    public static class AccessibilityNodeProviderApi19 extends AccessibilityNodeProvider {

        /* renamed from: a  reason: collision with root package name */
        public final AccessibilityNodeProviderCompat f931a;

        public AccessibilityNodeProviderApi19(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            this.f931a = accessibilityNodeProviderCompat;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            AccessibilityNodeInfoCompat b = this.f931a.b(i);
            if (b == null) {
                return null;
            }
            return b.O0();
        }

        public List findAccessibilityNodeInfosByText(String str, int i) {
            List c = this.f931a.c(str, i);
            if (c == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = c.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(((AccessibilityNodeInfoCompat) c.get(i2)).O0());
            }
            return arrayList;
        }

        public AccessibilityNodeInfo findFocus(int i) {
            AccessibilityNodeInfoCompat d = this.f931a.d(i);
            if (d == null) {
                return null;
            }
            return d.O0();
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f931a.f(i, i2, bundle);
        }
    }

    @RequiresApi
    public static class AccessibilityNodeProviderApi26 extends AccessibilityNodeProviderApi19 {
        public AccessibilityNodeProviderApi26(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            super(accessibilityNodeProviderCompat);
        }

        public void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f931a.a(i, AccessibilityNodeInfoCompat.P0(accessibilityNodeInfo), str, bundle);
        }
    }

    public AccessibilityNodeProviderCompat() {
        this.f930a = new AccessibilityNodeProviderApi26(this);
    }

    public void a(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, String str, Bundle bundle) {
    }

    public AccessibilityNodeInfoCompat b(int i) {
        return null;
    }

    public List c(String str, int i) {
        return null;
    }

    public AccessibilityNodeInfoCompat d(int i) {
        return null;
    }

    public Object e() {
        return this.f930a;
    }

    public boolean f(int i, int i2, Bundle bundle) {
        return false;
    }

    public AccessibilityNodeProviderCompat(Object obj) {
        this.f930a = obj;
    }
}
