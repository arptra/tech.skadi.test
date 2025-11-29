package com.share.connect.security;

import android.content.Context;
import android.util.Log;
import com.easy.logger.EasyLog;
import com.honey.account.b3.a;
import com.honey.account.constant.AccountConstantKt;
import com.share.connect.channel.ConnectChannel;
import com.ucar.databus.proto.UCarProto;
import com.ucar.protocol.UCarAuthProtocol;
import com.ucar.protocol.UCarMessage;
import com.ucar.protocol.UCarWorkMode;
import com.ucar.protocol.channel.ChannelType;
import com.ucar.protocol.channel.SendFutureCallback;
import com.ucar.protocol.security.SecurityManager;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class UCarAuthService {

    /* renamed from: a  reason: collision with root package name */
    public boolean f9913a = false;
    public final ConnectChannel b;
    public final UCarAuthObserver c;
    public final SecurityManager d = new SecurityManager();
    public final ServerKeyNegotiator e;
    public int f;

    public interface UCarAuthObserver {
        void a(String str, int i);

        void b(String str, String str2, String str3, int i);

        void c();

        void d();

        int onSelectWorkMode(int i);
    }

    public UCarAuthService(Context context, UCarAuthObserver uCarAuthObserver, int i, int i2, String str, boolean z) {
        this.e = new ServerKeyNegotiator(context);
        this.c = uCarAuthObserver;
        AnonymousClass1 r9 = new ConnectChannel(ChannelType.AUTH, true, false) {
            public void L0() {
                super.L0();
                boolean unused = UCarAuthService.this.f9913a = true;
            }

            public void M0() {
                boolean unused = UCarAuthService.this.f9913a = false;
            }
        };
        this.b = r9;
        r9.S0(new a(this, i, i2, str, z));
    }

    public final /* synthetic */ void d(int i, int i2, String str, boolean z, UCarMessage uCarMessage) {
        String str2;
        if (UCarAuthProtocol.n(uCarMessage)) {
            UCarProto.AuthRequest q = UCarAuthProtocol.q(uCarMessage);
            String str3 = new String(q.getId().toByteArray(), StandardCharsets.UTF_8);
            if (q.getWorkModes() != 0) {
                this.f = this.c.onSelectWorkMode(UCarWorkMode.a(q.getWorkModes()).j(i));
            } else {
                this.f = this.c.onSelectWorkMode(UCarWorkMode.a(1).j(i));
            }
            if (!q.getProductName().isEmpty()) {
                UCarWorkMode a2 = UCarWorkMode.a(this.f);
                if (a2.b() || a2.c()) {
                    str2 = q.getProductName();
                    this.c.b(str3, q.getModel(), str2, q.getVersion());
                    final UCarProto.AuthResponse A = this.e.A(q, this.f, i2, str, z);
                    this.b.O0(UCarAuthProtocol.k(A, uCarMessage.k()), new SendFutureCallback() {
                        public void c(Exception exc) {
                            EasyLog.d("UCarAuthService", "Send auth response error.", exc);
                        }

                        /* renamed from: d */
                        public void a(Boolean bool) {
                            if (!bool.booleanValue()) {
                                return;
                            }
                            if (A.getResult() == 0) {
                                UCarAuthService.this.c.c();
                            } else if (A.getResult() == 2 || A.getResult() == 1 || A.getResult() == 3 || A.getResult() == 4) {
                                UCarAuthService.this.c.d();
                            } else {
                                Log.e("UCarAuthService", "wrong negotiation protocol version received");
                            }
                        }
                    });
                }
            }
            str2 = null;
            this.c.b(str3, q.getModel(), str2, q.getVersion());
            final UCarProto.AuthResponse A2 = this.e.A(q, this.f, i2, str, z);
            this.b.O0(UCarAuthProtocol.k(A2, uCarMessage.k()), new SendFutureCallback() {
                public void c(Exception exc) {
                    EasyLog.d("UCarAuthService", "Send auth response error.", exc);
                }

                /* renamed from: d */
                public void a(Boolean bool) {
                    if (!bool.booleanValue()) {
                        return;
                    }
                    if (A2.getResult() == 0) {
                        UCarAuthService.this.c.c();
                    } else if (A2.getResult() == 2 || A2.getResult() == 1 || A2.getResult() == 3 || A2.getResult() == 4) {
                        UCarAuthService.this.c.d();
                    } else {
                        Log.e("UCarAuthService", "wrong negotiation protocol version received");
                    }
                }
            });
        } else if (UCarAuthProtocol.m(uCarMessage)) {
            String str4 = new String(this.d.d(UCarAuthProtocol.p(uCarMessage).getCipher().toByteArray()), StandardCharsets.UTF_8);
            String[] split = str4.split(AccountConstantKt.CODE_SEPARTOR);
            if (split.length > 0) {
                this.c.a(split[0], this.f);
                return;
            }
            Log.e("UCarAuthService", "phone's authentication confirmation message is ill-formatted, msg=" + str4);
        }
    }

    public void e(String str) {
        this.e.x(str.getBytes(StandardCharsets.UTF_8));
    }

    public void f(String str) {
        try {
            EasyLog.a("UCarAuthService", "start auth service, binding=" + this.f9913a);
            if (!this.f9913a) {
                this.b.W0(0, str);
            }
        } catch (IOException e2) {
            Log.e("UCarAuthService", "Start auth channel error.", e2);
        }
    }

    public void g() {
        EasyLog.a("UCarAuthService", "stop auth service");
        this.b.c0();
        this.f9913a = false;
    }
}
