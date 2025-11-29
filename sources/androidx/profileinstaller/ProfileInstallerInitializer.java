package androidx.profileinstaller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.startup.Initializer;
import com.honey.account.b0.d;
import com.honey.account.b0.e;
import com.honey.account.b0.f;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ProfileInstallerInitializer implements Initializer<Result> {

    @RequiresApi
    public static class Choreographer16Impl {
        @DoNotInline
        public static void c(Runnable runnable) {
            Choreographer.getInstance().postFrameCallback(new a(runnable));
        }
    }

    @RequiresApi
    public static class Handler28Impl {
        @DoNotInline
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public static class Result {
    }

    public static void k(Context context) {
        new ThreadPoolExecutor(0, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new f(context));
    }

    public List dependencies() {
        return Collections.emptyList();
    }

    /* renamed from: e */
    public Result a(Context context) {
        f(context.getApplicationContext());
        return new Result();
    }

    public void f(Context context) {
        Choreographer16Impl.c(new d(this, context));
    }

    /* renamed from: g */
    public void h(Context context) {
        Handler28Impl.a(Looper.getMainLooper()).postDelayed(new e(context), (long) (new Random().nextInt(Math.max(1000, 1)) + 5000));
    }
}
