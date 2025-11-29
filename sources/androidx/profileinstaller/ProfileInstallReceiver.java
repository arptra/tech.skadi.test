package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import androidx.profileinstaller.ProfileInstaller;
import com.honey.account.b0.b;

public class ProfileInstallReceiver extends BroadcastReceiver {

    public class ResultDiagnostics implements ProfileInstaller.DiagnosticsCallback {
        public ResultDiagnostics() {
        }

        public void a(int i, Object obj) {
            ProfileInstaller.b.a(i, obj);
            ProfileInstallReceiver.this.setResultCode(i);
        }

        public void b(int i, Object obj) {
            ProfileInstaller.b.b(i, obj);
        }
    }

    public static void a(ProfileInstaller.DiagnosticsCallback diagnosticsCallback) {
        Process.sendSignal(Process.myPid(), 10);
        diagnosticsCallback.a(12, (Object) null);
    }

    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (intent != null) {
            String action = intent.getAction();
            if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
                ProfileInstaller.k(context, new b(), new ResultDiagnostics(), true);
            } else if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
                Bundle extras2 = intent.getExtras();
                if (extras2 != null) {
                    String string = extras2.getString("EXTRA_SKIP_FILE_OPERATION");
                    if ("WRITE_SKIP_FILE".equals(string)) {
                        ProfileInstaller.l(context, new b(), new ResultDiagnostics());
                    } else if ("DELETE_SKIP_FILE".equals(string)) {
                        ProfileInstaller.c(context, new b(), new ResultDiagnostics());
                    }
                }
            } else if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
                a(new ResultDiagnostics());
            } else if ("androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) && (extras = intent.getExtras()) != null) {
                String string2 = extras.getString("EXTRA_BENCHMARK_OPERATION");
                ResultDiagnostics resultDiagnostics = new ResultDiagnostics();
                if ("DROP_SHADER_CACHE".equals(string2)) {
                    BenchmarkOperation.b(context, resultDiagnostics);
                } else {
                    resultDiagnostics.a(16, (Object) null);
                }
            }
        }
    }
}
