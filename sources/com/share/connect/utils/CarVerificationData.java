package com.share.connect.utils;

import com.easy.logger.EasyLog;
import java.io.IOException;
import java.io.Reader;

public class CarVerificationData {

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public Reader f9915a;

        public Builder a(Reader reader) {
            this.f9915a = reader;
            return this;
        }

        public String b() {
            if (this.f9915a != null) {
                StringBuilder sb = new StringBuilder();
                try {
                    char[] cArr = new char[1024];
                    while (true) {
                        int read = this.f9915a.read(cArr);
                        if (read <= 0) {
                            return sb.toString().trim();
                        }
                        sb.append(cArr, 0, read);
                    }
                } catch (IOException e) {
                    EasyLog.d("CarVerificationData", " read car verification data exception ", e);
                    return null;
                }
            } else {
                EasyLog.c("CarVerificationData", "CarVerificationData  no reader to build");
                throw new IllegalArgumentException("Reader is null");
            }
        }
    }
}
