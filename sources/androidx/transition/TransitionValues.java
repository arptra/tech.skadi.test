package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class TransitionValues {

    /* renamed from: a  reason: collision with root package name */
    public final Map f1876a = new HashMap();
    public View b;
    public final ArrayList c = new ArrayList();

    public TransitionValues(View view) {
        this.b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        return this.b == transitionValues.b && this.f1876a.equals(transitionValues.f1876a);
    }

    public int hashCode() {
        return (this.b.hashCode() * 31) + this.f1876a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.b + StringUtils.LF) + "    values:";
        for (String str2 : this.f1876a.keySet()) {
            str = str + "    " + str2 + ": " + this.f1876a.get(str2) + StringUtils.LF;
        }
        return str;
    }
}
