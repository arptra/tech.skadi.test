package com.ucar.vehiclesdk.datacenter;

import android.content.Context;
import android.text.TextUtils;
import com.easy.logger.EasyLog;
import com.google.protobuf.ByteString;
import com.share.connect.channel.ConnectChannel;
import com.share.connect.utils.CarVerifier;
import com.ucar.databus.proto.UCarProto;
import com.ucar.protocol.UCarCertProtocol;
import com.ucar.protocol.channel.SendFutureCallback;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CarCertManager {

    /* renamed from: a  reason: collision with root package name */
    public final Context f5442a;
    public final ConnectChannel b;

    /* renamed from: com.ucar.vehiclesdk.datacenter.CarCertManager$1  reason: invalid class name */
    class AnonymousClass1 extends ConnectChannel {
        public final /* synthetic */ String r;
        public final /* synthetic */ CarCertManager s;

        public void H0() {
            String f = new CarVerifier(this.s.f5442a, this.r).f();
            if (TextUtils.isEmpty(f)) {
                EasyLog.c("CarCertManager", "failed to get car cert data");
                return;
            }
            EasyLog.a("CarCertManager", "sending car certificate to phone");
            O0(UCarCertProtocol.j(UCarProto.CarCertificate.newBuilder().setContent(ByteString.copyFrom(f.getBytes(StandardCharsets.UTF_8))).build()), new SendFutureCallback() {
                public void c(Exception exc) {
                    EasyLog.d("CarCertManager", "sending car certificate error: " + exc.getMessage(), exc);
                }

                /* renamed from: d */
                public void a(Boolean bool) {
                    AnonymousClass1.this.s.b.c0();
                }
            });
        }
    }

    public void c(String str) {
        try {
            this.b.W0(0, str);
        } catch (IOException e) {
            EasyLog.d("CarCertManager", "Start car certificate error: ", e);
        }
    }

    public void d() {
        EasyLog.a("CarCertManager", "stopCertChannel");
        this.b.c0();
    }
}
