package com.upuphone.star.launcher.ddauth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.android.dingtalk.openauth.AuthLoginParam;
import com.android.dingtalk.openauth.DDAuthApiFactory;
import com.honey.account.q6.a;
import com.upuphone.star.core.log.ULog;
import com.upuphone.starrynet.strategy.protocol.ProtocolVersions;
import com.upuphone.xr.sapp.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/upuphone/star/launcher/ddauth/DDAuthActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "a", "Companion", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
public final class DDAuthActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f6480a = new Companion((DefaultConstructorMarker) null);
    public static String b;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/upuphone/star/launcher/ddauth/DDAuthActivity$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "a", "(Landroid/content/Context;)V", "", "TAG", "Ljava/lang/String;", "app_intlRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            AuthLoginParam.AuthLoginParamBuilder newBuilder = AuthLoginParam.AuthLoginParamBuilder.newBuilder();
            newBuilder.appId("dingziqozuvzoibr6dv0");
            newBuilder.redirectUri("https://www.meizu.com");
            newBuilder.responseType("code");
            newBuilder.scope("openid%20corpid");
            newBuilder.state("calendar");
            newBuilder.prompt("consent");
            DDAuthApiFactory.createDDAuthApi(context, newBuilder.build()).authLogin();
        }

        public Companion() {
        }
    }

    public static final WindowInsetsCompat o0(View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(view, ProtocolVersions.PROTOCOL_KEY_CONNECTION_VERSION);
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "insets");
        Insets f = windowInsetsCompat.f(WindowInsetsCompat.Type.f());
        Intrinsics.checkNotNullExpressionValue(f, "getInsets(...)");
        view.setPadding(f.f712a, f.b, f.c, f.d);
        return windowInsetsCompat;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_ddauth);
        ViewCompat.M0(findViewById(R.id.main), new a());
        ULog.Delegate delegate = ULog.f6446a;
        delegate.g("DDAuthActivity", "onCreate");
        Intent intent = getIntent();
        if (intent != null) {
            b = intent.getStringExtra("authCode");
            String stringExtra = intent.getStringExtra("state");
            String stringExtra2 = intent.getStringExtra("error");
            String str = b;
            if (str == null || str.length() == 0) {
                delegate.g("DDAuthActivity", "state:" + stringExtra + " error:" + stringExtra2);
            } else {
                String str2 = b;
                delegate.g("DDAuthActivity", "authCode:" + str2);
            }
            finish();
        }
    }
}
