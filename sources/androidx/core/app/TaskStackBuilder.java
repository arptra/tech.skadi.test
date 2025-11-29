package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.upuphone.runasone.uupcast.CaptureType;
import java.util.ArrayList;
import java.util.Iterator;

public final class TaskStackBuilder implements Iterable<Intent> {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f683a = new ArrayList();
    public final Context b;

    public interface SupportParentable {
        Intent getSupportParentActivityIntent();
    }

    public TaskStackBuilder(Context context) {
        this.b = context;
    }

    public static TaskStackBuilder e(Context context) {
        return new TaskStackBuilder(context);
    }

    public TaskStackBuilder a(Intent intent) {
        this.f683a.add(intent);
        return this;
    }

    public TaskStackBuilder b(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.b.getPackageManager());
        }
        if (component != null) {
            d(component);
        }
        a(intent);
        return this;
    }

    public TaskStackBuilder c(Activity activity) {
        Intent supportParentActivityIntent = activity instanceof SupportParentable ? ((SupportParentable) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = NavUtils.a(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.b.getPackageManager());
            }
            d(component);
            a(supportParentActivityIntent);
        }
        return this;
    }

    public TaskStackBuilder d(ComponentName componentName) {
        int size = this.f683a.size();
        try {
            Intent b2 = NavUtils.b(this.b, componentName);
            while (b2 != null) {
                this.f683a.add(size, b2);
                b2 = NavUtils.b(this.b, b2.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public Intent f(int i) {
        return (Intent) this.f683a.get(i);
    }

    public int h() {
        return this.f683a.size();
    }

    public void i() {
        j((Bundle) null);
    }

    public Iterator iterator() {
        return this.f683a.iterator();
    }

    public void j(Bundle bundle) {
        if (!this.f683a.isEmpty()) {
            Intent[] intentArr = (Intent[]) this.f683a.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (!ContextCompat.startActivities(this.b, intentArr, bundle)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(CaptureType.CAPTURE_VIRTUAL_DISPLAY_WHEN_SCREEN_LOCKED);
                this.b.startActivity(intent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
