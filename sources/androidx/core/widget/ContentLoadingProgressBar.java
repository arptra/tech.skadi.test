package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.honey.account.t.a;
import com.honey.account.t.b;

public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: a  reason: collision with root package name */
    public long f949a;
    public boolean b;
    public boolean c;
    public boolean d;
    public final Runnable e;
    public final Runnable f;

    public ContentLoadingProgressBar(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public final /* synthetic */ void c() {
        this.b = false;
        this.f949a = -1;
        setVisibility(8);
    }

    public final /* synthetic */ void d() {
        this.c = false;
        if (!this.d) {
            this.f949a = System.currentTimeMillis();
            setVisibility(0);
        }
    }

    public final void e() {
        removeCallbacks(this.e);
        removeCallbacks(this.f);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    public ContentLoadingProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f949a = -1;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = new a(this);
        this.f = new b(this);
    }
}
